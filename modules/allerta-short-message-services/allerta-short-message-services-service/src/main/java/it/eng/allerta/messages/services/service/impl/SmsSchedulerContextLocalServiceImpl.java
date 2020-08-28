/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.eng.allerta.messages.services.service.impl;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.mail.internet.InternetAddress;

import org.osgi.framework.Bundle;
import org.osgi.framework.Filter;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.util.tracker.ServiceTracker;

import it.eng.allerta.messages.services.HostUtility;
import it.eng.allerta.messages.services.SmsManagerWebServices;
import it.eng.allerta.messages.services.SmsWatchdogManagerWebServices;
import it.eng.allerta.messages.services.model.SmsSchedulerContext;
import it.eng.allerta.messages.services.model.impl.SmsSchedulerContextImpl;
import it.eng.allerta.messages.services.model.impl.SmsSchedulerContextImpl.PortletContextState;
import it.eng.allerta.messages.services.model.impl.SmsSchedulerContextImpl.SmsSchedulerState;
import it.eng.allerta.messages.services.scheduler.SmsSchedulerContextConstants;
import it.eng.allerta.messages.services.scheduler.SmsSchedulerContextException;
import it.eng.allerta.messages.services.service.SmsSchedulerContextLocalServiceUtil;
import it.eng.allerta.messages.services.service.base.SmsSchedulerContextLocalServiceBaseImpl;
import it.eng.allerter.service.SMSLocalService;

/**
 * The implementation of the sms scheduler context local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.allerta.messages.services.service.SmsSchedulerContextLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Giorgianni_F
 * @see SmsSchedulerContextLocalServiceBaseImpl
 */
public class SmsSchedulerContextLocalServiceImpl extends SmsSchedulerContextLocalServiceBaseImpl {
	
	private static Log logger = LogFactoryUtil.getLog(SmsSchedulerContextLocalServiceImpl.class);
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.allerta.messages.services.service.SmsSchedulerContextLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.allerta.messages.services.service.SmsSchedulerContextLocalServiceUtil</code>.
	 */
	private final static String querySmsSchdulerContextInExclusiveMode_ifDeadTryToBecomeScheduler = 
			" select SmsSchedulerContext.* from public.smsservice_smsschedulercontext SmsSchedulerContext " + 
					" where SmsSchedulerContext.varid = ? and SmsSchedulerContext.value <> ? " +
					" for update ";
	
	private final static String querySmsSchdulerContextInExclusiveMode_doPortalInExclusiveMode = 
			" select SmsSchedulerContext.* from public.smsservice_smsschedulercontext SmsSchedulerContext " + 
					" where (SmsSchedulerContext.varid = ? and SmsSchedulerContext.value <> ?) or SmsSchedulerContext.value like '%EXCEPTION%' " +
					" for update ";
	
	private ServiceTracker<SMSLocalService, SMSLocalService> _serviceTracker1;
	private Bundle bundle1;
	
	
	public SMSLocalService getSMSLocalService() throws InterruptedException {
		if (_serviceTracker1 == null) {
			bundle1 = FrameworkUtil.getBundle(SMSLocalService.class);
			_serviceTracker1 = new ServiceTracker<SMSLocalService, SMSLocalService>(bundle1.getBundleContext(), SMSLocalService.class, null);
			_serviceTracker1.open();
		}
		
		return _serviceTracker1.waitForService(0);
	}
	
	/**
	 * Se lo scheduler è morto prova a creare una nuova istanza dello scheduler in modalità esclusiva
	 */
	public boolean ifDeadTryToBecomeScheduler(String hostIp, String port) throws SystemException {
		logger.debug("begin ifDeadTryToBecomeScheduler");
		
		try {
			if (isSmsSchedulerDead()) {				
				return tryToBecomeScheduler(hostIp, port);
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new SystemException("Errore grave nel metodo ifDeadTryToBecomeScheduler", e);
		} finally {	
			logger.debug("end ifDeadTryToBecomeScheduler");
		}
	}
	
	public synchronized boolean isSmsSchedulerDead() throws SystemException {
		// parametri di default
		TimeUnit sscHeartbeatPeriodTimeunit = SmsSchedulerContextConstants.HEARTBEAT_PERIOD_TIMEUNIT;
		long sscHeartbeatPeriodValue = SmsSchedulerContextConstants.HEARTBEAT_PERIOD_VALUE;
		long sscHeartbeatOccurrences = SmsSchedulerContextConstants.HEARTBEAT_OCCURRENCES;		
		SmsSchedulerContext SSC_HEARTBEAT_PERIOD_TIMEUNIT;
		SmsSchedulerContext SSC_HEARTBEAT_PERIOD_VALUE;
		SmsSchedulerContext SSC_HEARTBEAT_OCCURRENCES;
		
		try {
			// lettura parametri da DB
			try {
				// +-- leggo le costanti stringa da DB
				SSC_HEARTBEAT_PERIOD_TIMEUNIT = fetchSmsSchedulerContext(SmsSchedulerContextImpl.VAR_ID_HEARTBEAT_PERIOD_TIMEUNIT);
				SSC_HEARTBEAT_PERIOD_VALUE = fetchSmsSchedulerContext(SmsSchedulerContextImpl.VAR_ID_HEARTBEAT_PERIOD);
				SSC_HEARTBEAT_OCCURRENCES = fetchSmsSchedulerContext(SmsSchedulerContextImpl.VAR_ID_HEARTBEAT_OCCURRENCES);
				// +-- conversione da stringa a long
				sscHeartbeatPeriodTimeunit = TimeUnit.valueOf(SSC_HEARTBEAT_PERIOD_TIMEUNIT.getValue());
				sscHeartbeatPeriodValue = Long.valueOf(SSC_HEARTBEAT_PERIOD_VALUE.getValue());
				sscHeartbeatOccurrences = Long.valueOf(SSC_HEARTBEAT_OCCURRENCES.getValue());
			} catch (SystemException|NumberFormatException e) {
				logger.warn("Non è stato possibile leggere/convertire i valori HEARTBEAT_PERIOD_TIMEUNIT/HEARTBEAT_PERIOD/HEARTBEAT_OCCURRENCES da DB, verranno settati i valori di default");
			}
			// verifica se lo scheduler di invio/verifica SMS è ancora attivo : se ci sono un numero di battiti pari a sscHeartbeatOccurrences
			// per un tempo di campionatura pari a sscHeartbeatPeriodValue*sscHeartbeatOccurrences allora è ancora attivo
			return isSmsSchedulerDead(sscHeartbeatPeriodTimeunit, sscHeartbeatPeriodValue, sscHeartbeatOccurrences);
		} catch (Throwable t) {
			String msgErr = "il metodo isSmsSchedulerDead non è stato in grado di determinare se lo scheduler di invio/verifica SMS è ancora attivo, verificare lo stato dello scheduler tramite console grafica";
			
			throw new SystemException(msgErr, t);
		}		
	}
	
	public synchronized boolean isSmsSchedulerDead(TimeUnit heartbeatPeriodTimeUnit, long heartbeatPeriod , long heartbeatOccurrences) throws SystemException, InterruptedException {
		int countHeartbeatOccurrence = 0;
		int countNoHeartbeatOccurrence = 0;
		long heartbeatPeriod_ms = TimeUnit.MILLISECONDS.convert(heartbeatPeriod, heartbeatPeriodTimeUnit);
		boolean doControl = false;
	
		do {
			// calcola delta battito dall'ultima rilevazione
			SmsSchedulerContext sscHeartbeatInstant = fetchSmsSchedulerContext(SmsSchedulerContextImpl.VAR_ID_HEARTBEAT_INSTANT);
			long lastHeartbeatInstant = Long.valueOf(sscHeartbeatInstant.getValue()); // in msec
			long currentTime = System.currentTimeMillis();
			long delta_ms = currentTime - lastHeartbeatInstant;	
			
			// se il delta è maggiore del periodo del battito
			if (delta_ms >= heartbeatPeriod_ms) {			
				++countNoHeartbeatOccurrence; // conto il numero dei non battiti
				countHeartbeatOccurrence = 0; // azzero il numero dei battiti
			} else { // delta minore
				++countHeartbeatOccurrence; // conto il numero dei battiti
				countNoHeartbeatOccurrence = 0; // azzero il numero dei non battiti
			}
			// verifica se deve eseguire un'altra volta il ciclo di verifica conteggi occorrenze
			doControl = countNoHeartbeatOccurrence != heartbeatOccurrences && countHeartbeatOccurrence != heartbeatOccurrences;
			// rimane in pausa per un periodo pari al battito
			if (doControl) {
				Thread.sleep(TimeUnit.MILLISECONDS.convert(heartbeatPeriod, heartbeatPeriodTimeUnit));
			}
		} while (doControl);
		
		if (countNoHeartbeatOccurrence == heartbeatOccurrences) {
			return true;
		}
		if (countHeartbeatOccurrence == heartbeatOccurrences) {
			return false;
		}
		
		throw new IllegalStateException("Non è stato possibile determinare se lo scheduler di invio/verifica SMS è in stato DEAD");
	}
	
	public boolean isSchedulerInThisHost() throws SystemException {
		String hostIp = "";			
		
		try {
			hostIp = HostUtility.getCurrentHostIpAndPort();
			String schedulerIp = getHostIPAndPortOfCurrentScheduler(); // contiene anche la porta
			
			if (hostIp.equals(schedulerIp)) {
				return true;
			}
		} catch (Exception ex) {
			String errMsg = "isSchedulerInThisHost sul seguente nodo identificato da ip:port [" + hostIp + "] fallito";
			
			throw new SystemException(errMsg, ex);
		}
		
		return false;
	}
	
	/**
	 * Ritorna hostip,port della macchina che contiene lo scheduler attualmente attivo.
	 * 
	 * @return
	 */
	public String getHostIPAndPortOfCurrentScheduler() {
		SmsSchedulerContext ssc;
		
		try {
			ssc = fetchSmsSchedulerContext(SmsSchedulerContextImpl.VAR_ID_CURRENT_SCHEDULER_HOST_IP_AND_PORT);
			
			return ssc.getValue();
		} catch (SystemException e) {
			logger.error("getHostIPAndPortOfCurrentScheduler fallito", e);
		
			return null;
		}	
	}
	
	/**
	 * Usata nella fase di init della portlet, quindi al suo deploy (può avvenire all'avvio del server oppure al redeploy della portlet).
	 * Se esiste uno scheduler attivo lo spegne e riavvia il tutto in modalità esclusiva, oppure diventa un watchdog.
	 * Se lo scheduler non è attivo avvia lo scheduler sul nodo corrente in modalità esclusiva.
	 */
	public void doPortalInitInExclusiveMode(String hostIp, String port) throws SystemException {
		try {
			logger.info("begin doPortalInitInExclusiveMode");
			
			boolean exclusiveMode = setSmsSchdulerContextInExclusiveMode(
				querySmsSchdulerContextInExclusiveMode_doPortalInExclusiveMode,
				SmsSchedulerContextImpl.VAR_ID_PORTAL_CONTEXT_STATE, 
				PortletContextState.INIT_EXECUTED.name()
			);
			if (exclusiveMode) {
				try {
					// se in fase di deploy della portlet, esiste ancora uno scheduler attivo su qualsiasi nodo
					if (!isSmsSchedulerDead()) {
						// tento lo shutdown
						logger.info("doPortalInitInExclusiveMode - c'è ancora uno scheduler attivo, tento lo shutdown forzato");
						// spengo tutto perchè sono in fase di avvio di una portlet con nuovo codice
						// e quindi è probabile che il codice dello scheduler sia cambiato
						SmsManagerWebServices.getInstance().updateSmsSchedulerStateNewTransaction(SmsSchedulerState.FORCE_SHUTDOWN);
						
						// Attendo il suo shutdown forzato
						logger.info("doPortalInitInExclusiveMode - attendo lo shutdown forzato");
						while (!isSmsSchedulerDead()) {
							logger.info("PortalInit - shutdown forzato non ancora terminato, rimango in attesa ...");			
						}
						// cambio lo stato in SHUTDOWN
						SmsManagerWebServices.getInstance().updateSmsSchedulerStateNewTransaction(SmsSchedulerState.SHUTDOWN);
						logger.info("doPortalInitInExclusiveMode - attesa terminata, shutdown forzato terminato");
						
						// tento il riavvio esclusivo dello scheduler (a questo punto sappiamo che è morto)
						tryToBecomeScheduler(hostIp, port);
					// se non abbiamo scheduler attivi
					} else {
						// se lo scheduler risulta morto all'avvio della portlet allora prova a diventare lo scheduler
						if (ifDeadTryToBecomeScheduler(hostIp, port)) {
							// dato che ragionevolmente è morto, eseguo il reset dello stato dello Scheduler SMS portandolo a DEAD;
							// tenta di diventare lo scheduler di invio/verifica SMS : usa la tecnica del lock esclusivo (mettendo prima lo stato a DEAD).
							// Se ci riesce, lo scheduler andrà in esecuzione con lo stato pari a STARTED					
							logger.info("il seguente host " + hostIp + ":" + port + " ha avviato l'istanza dello scheduler di invio/verifica SMS");				
						// se non è in stato DEAD il nodo diventa un watchdog
						} else {
							if (!isSchedulerInThisHost()) {
								startWatchdogIfNecessary(hostIp, port);
							}
						}
					}
				} catch (Throwable e) {				
					String errMsg = "doPortalInitInExclusiveMode - Errore grave, è fallito il tentativo di force shutdown dello scheduler nella fase di avvio del Server";
					logger.error(errMsg, e);
					
					sendMailWithPlainText(errMsg);
					
					throw new SystemException(errMsg, e);
				}
			}
		} catch (Exception e) {			
			String errMsg = "doPortalInitInExclusiveMode - Errore imprevisto nel metodo doPortalInitInExclusiveMode";
			logger.error(errMsg, e);
			
			//updatePortalContext(SmsSchedulerContextImpl.PortletContextState.INIT_EXCEPTION);
			
			throw new SystemException(errMsg,e);
		} finally {		
			logger.info("end doPortalInitInExclusiveMode");
		}
	}
	
	/**
	 * Spegne l'eventuale scheduler attivo se presente in questo host oppure il relativo watchdog.
	 */
	public void doPortalDestroyInExclusiveMode() throws SystemException {	
		try {
			logger.info("begin doPortalDestroyInExclusiveMode");
			// se lo scheduler è nello stesso host cerco di spegnerlo (se ne esiste uno attivo)
			if (isSchedulerInThisHost()) {			
				boolean exclusiveMode = setSmsSchdulerContextInExclusiveMode(
					querySmsSchdulerContextInExclusiveMode_doPortalInExclusiveMode,
					SmsSchedulerContextImpl.VAR_ID_PORTAL_CONTEXT_STATE, 
					PortletContextState.DESTROY_EXECUTED.name()
				);
				if (exclusiveMode) {
					try {
						boolean isShutdown;				
						
						SmsSchedulerState sss = SmsManagerWebServices.getInstance().tryShutdownScheduler();
						isShutdown = sss.equals(SmsSchedulerState.SHUTDOWN) || sss.equals(SmsSchedulerState.FORCE_SHUTDOWN);
						
						if (!isShutdown) {
							logger.error("doPortalDestroyInExclusiveMode - Non è stato possibile eseguire lo shutdown dello scheduler durante la fase di shutdown della portlet");
						}						
					} catch (Throwable e) {				
						String errMsg = "doPortalDestroyInExclusiveMode - Errore imprevisto durante la fase di shutdown della portlet";
						logger.error(errMsg, e);
						
						throw new SystemException(errMsg, e);
					}
				}
			// altrimenti vuol dire che l'host corrente ha una istanza di Watchdog che verrà spenta
			} else {
				SmsWatchdogManagerWebServices.getInstance().tryShutdownWatchdog();
			}
		} catch (SmsSchedulerContextException e) {
			String errMsg = "doPortalDestroyInExclusiveMode - Errore imprevisto";
			logger.error(errMsg, e);
			
			//updatePortalContext(SmsSchedulerContextImpl.PortletContextState.DESTROY_EXCEPTION);

			throw new SystemException(errMsg,e);
		} finally {
			logger.info("end doPortalDestroyInExclusiveMode");
		}	
	}
	
	// metodi di utilità
	
	/**
	 * Ripristino di eventuali stati non consistenti degli SMS a causa dello shutdwon del server;
	 * devono essere inviati nuovamente : se rimasti nello stato 2 e 6 non sono mai stati inviati
	 */
	public void ripristinaStatiInconsistentiSMS() {
		try {
			getSMSLocalService().ottieniPerSpedizione(null, null, 0, 2, 1, -1);
			getSMSLocalService().ottieniPerSpedizione(null, null, 0, 6, 3, -1);
			logger.info("ripristino di eventuali stati inconsistenti (2 in 1 e 6 in 3) degli sms andato a buon fine");
		} catch (Throwable e) {
			String errMsg = "doPortalInitInExclusiveMode - Errore grave, è fallito il tentativo di ripristinare gli stati inconsistenti dello scheduler (2 e 6) nella fase di avvio del Server";
			logger.error(errMsg, e);
			
			sendMailWithPlainText(errMsg);
			
			throw new SystemException(errMsg, e);
		}
	}
	
	public void resetSmsSchedulerState(String smsSchedulerStateNewVal) throws SystemException {
		try {
			SmsSchedulerContext sscSmsSchedulerState = this.fetchSmsSchedulerContext(SmsSchedulerContextImpl.VAR_ID_SMS_SCHEDULER_STATE);
			sscSmsSchedulerState.setValue(smsSchedulerStateNewVal);
			
			SmsSchedulerContextLocalServiceUtil.updateSmsSchedulerContext(sscSmsSchedulerState);
		} catch (Exception e) {
			String errMsg = "reset del parametro " + SmsSchedulerContextImpl.VAR_ID_SMS_SCHEDULER_STATE + " fallito";
			
			throw new SystemException(errMsg, e);
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED, rollbackFor =  {PortalException.class, SystemException.class})
	public SmsSchedulerContext updateSmsSchedulerContextNewTransaction(SmsSchedulerContext smsSchedulerContext) throws SystemException {
		return smsSchedulerContextPersistence.update(smsSchedulerContext);
	}
	
	public boolean setSmsSchdulerContextInExclusiveMode(String querySQL, String varId, String value) throws SystemException {
		Session session = null;
		SmsSchedulerContext ssc;
		
		try {
			//session = this.getSmsSchedulerContextPersistence().openSession();
			session = this.getSmsSchedulerContextPersistence().getCurrentSession();
			
			SQLQuery query = session.createSQLQuery(querySQL);
			query.setCacheable(false);
			query.addEntity("SmsSchedulerContext", SmsSchedulerContextImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(query);  
	        qPos.add(varId);
	        qPos.add(value);
	        
	        @SuppressWarnings("unchecked")
			List<SmsSchedulerContext> list = (List<SmsSchedulerContext>) query.list();
	        
	        if (list == null || list.isEmpty()) {
	        	return false;
	        }
	        
	        // doppio check : verifico se è nuovamente in stato DEAD, se non lo è non lo posso dichiarare in stato DEAD
	        // ma lo devo lasciare nello stato in cui si trova
	        //boolean isSmsSchedulerDead = SmsSchedulerContextUtility.isSmsSchedulerDead();
	        
	        //if (isSmsSchedulerDead) {
		        ssc = list.get(0);	        
				ssc.setValue(value);
				session.saveOrUpdate(ssc);
				//session.flush();
				
				return true;
	        //} else {
	        //	return false;
	        //}			
		} catch (Exception e) {
			throw new SystemException("Errore grave, chiamata al metodo setSmsSchdulerContextInExclusiveMode fallita", e);
		} finally {
			//this.getSmsSchedulerContextPersistence().closeSession(session);
		}
	}
	
	// metodi private
	
	private boolean tryToBecomeScheduler(String hostIp, String port) {		
		// mette in stato DEAD lo scheduler in modalità esclusiva (crea un lock sulla riga)
		boolean becomeIt = setSmsSchdulerContextInExclusiveMode(
			querySmsSchdulerContextInExclusiveMode_ifDeadTryToBecomeScheduler,
			SmsSchedulerContextImpl.VAR_ID_SMS_SCHEDULER_STATE, 
			SmsSchedulerState.DEAD.name()
		);
		
		if (becomeIt) {
			// tento l'avvio
			try {
				// ma prima ripristina eventuali stati inconsistenti degli SMS
				ripristinaStatiInconsistentiSMS();
				// avvia lo scheduler
				becomeIt = tryStartScheduler(hostIp, port);
			} catch (SmsSchedulerContextException e) {
				throw new SystemException("Errore grave, il metodo tryStartScheduler è andato in errore nella fase tryToBecomeScheduler", e);
			}
			// se lo è diventato : lo stato ora è STARTED
			if (becomeIt) {
				// reset della VAR_ID utilizzata al riavvio della portlet o bundle (caso diverso dall'avvio del server)
				setSmsSchdulerContextInExclusiveMode(
					querySmsSchdulerContextInExclusiveMode_doPortalInExclusiveMode,
					SmsSchedulerContextImpl.VAR_ID_PORTAL_CONTEXT_STATE, 
					PortletContextState.INIT_EXECUTED.name()
				);
				// salvo l'ip del host che farà girare lo scheduler
				SmsSchedulerContext ssc = this.fetchSmsSchedulerContext(SmsSchedulerContextImpl.VAR_ID_CURRENT_SCHEDULER_HOST_IP_AND_PORT);
				ssc.setValue(hostIp+":"+port);
				this.updateSmsSchedulerContext(ssc);
			}
		}
		
		return becomeIt;
	}
	
	private boolean tryStartScheduler(String hostIp, String port) throws SmsSchedulerContextException {
		boolean started = false;
		
		// attiva lo scheduler
		SmsSchedulerState sss = SmsManagerWebServices.getInstance().tryStartScheduler(); // se va a buon fine lo stato sarà SmsSchedulerState.STARTED
		
		if (sss == SmsSchedulerState.STARTED) {
			started = true;
		} else {
			String errMsg = "il seguente host:ip " + hostIp + ":" + port + " non ha avviato l'istanza dello scheduler di invio/verifica SMS, lo stato è : " + sss.name();
			
			sendMailWithPlainText(errMsg);
			started = false;
		}
		
		return started;
	}
	
	private void startWatchdogIfNecessary(String hostIp, String port) throws SmsSchedulerContextException {
		logger.info("il seguente host [" + hostIp + ":" + port + "] tenterà di avviare l'istanza del watchdog di controllo dello scheduler di invio/verifica SMS");
		
		boolean result = SmsWatchdogManagerWebServices.getInstance().tryStartWatchdog();					
						
		if (!result) {
			String errMsg = "Attenzione!!! Watchdog non avviato per il seguente host : [" + hostIp + ":" + port + "] perchè già attivo";
			logger.error(errMsg);
			
			sendMailWithPlainText(errMsg);
		} else {
			logger.info("Watchdog avviato per il seguente host : [" + hostIp + ":" + port + "]");
		}		
	}
	
	public void sendMailWithPlainText(String body) {
		try {
			String[] emailList = getEmailList(); 
			
			InternetAddress fromAddress = new InternetAddress("allertameteoSMS@regione.emilia-romagna.it");
			InternetAddress toAddress = new InternetAddress(emailList[0]);
			InternetAddress[] ccAddress = null;
			
			if (emailList.length > 1) {
				ccAddress = new InternetAddress[emailList.length-1];
				
				for (int i = 1; i < emailList.length; i++) {
					ccAddress[i-1] = new InternetAddress(emailList[i]);
				}
			}
			
			MailMessage mailMessage = new MailMessage();
			mailMessage.setTo(toAddress);
			
			if (ccAddress != null && ccAddress.length >=1) {
				mailMessage.setCC(ccAddress);
			}
			
			mailMessage.setFrom(fromAddress);
			mailMessage.setSubject("Allerte SMS Notification");
			mailMessage.setBody(body);
			
			MailServiceUtil.sendEmail(mailMessage);
			
			logger.debug("Sent mail -> " + body);
		} catch (Throwable t) {
			logger.error("Attenzione!!! Non è stato possibile inviare l'email", t);
		}
	}

	@Override
	public String[] getEmailList() throws SystemException {
		try {
			SmsSchedulerContext sscEmailList = smsSchedulerContextLocalService.fetchSmsSchedulerContext(SmsSchedulerContextImpl.VAR_ID_EMAIL_LIST);
						
			String emailList = sscEmailList.getValue();
			return emailList.split(";");
		} catch (SystemException e) {
			String errMsg = "lettura del parametro " + SmsSchedulerContextImpl.VAR_ID_EMAIL_LIST + " fallito";
			
			throw new SystemException(errMsg, e);			
		}
	}
	
	public synchronized void updateHeartbeatInstant(long timestamp) throws SystemException {
		try {
			SmsSchedulerContext sscSmsSchedulerState = smsSchedulerContextLocalService.fetchSmsSchedulerContext(SmsSchedulerContextImpl.VAR_ID_HEARTBEAT_INSTANT);
			sscSmsSchedulerState.setValue(String.valueOf(timestamp));
			
			smsSchedulerContextLocalService.updateSmsSchedulerContext(sscSmsSchedulerState);
		} catch (SystemException e) {
			String errMsg = "reset del parametro " + SmsSchedulerContextImpl.VAR_ID_SMS_SCHEDULER_STATE + " fallito";
			
			throw new SystemException(errMsg, e);			
		}
	}
	
	public synchronized long updateHeartbeatInstantNow() throws SystemException {
		long now = System.currentTimeMillis();		
		updateHeartbeatInstant(now);
		
		return now;
	}
	
	public synchronized boolean isSmsWatchdogSuspend() throws SystemException {
		try {
			return Boolean.valueOf(smsSchedulerContextLocalService.fetchSmsSchedulerContext(SmsSchedulerContextImpl.VAR_ID_SMS_WATCHDOG_SUSPEND).getValue());
		} catch (SystemException e) {
			String errMsg = "Non è stato possibile leggere/convertire il valore SMS_WATCHDOG_SUSPEND da DB, verrà settato il valore di default FALSE";
			
			throw new SystemException(errMsg, e);			
		}
	}
	
	/*
	private boolean tryShutdownSchedulerOther() throws SystemException {		
		String callServlet = ServletUtility.callMethodFromServlet("tryShutdownScheduler");
		Gson gson = new Gson();
		IsSchedulerShutdownBean fromJson = gson.fromJson(callServlet, IsSchedulerShutdownBean.class);
		
		return fromJson.getIsSchedulerShutdown();
	}
	*/
	
	/*
	private void updatePortalContext(SmsSchedulerContextImpl.PortletContextState portletContextState) {
		SmsSchedulerContext smsSchedulerContext;
		
		try {
			smsSchedulerContext = fetchSmsSchedulerContext(SmsSchedulerContextImpl.VAR_ID_PORTAL_CONTEXT_STATE);
			smsSchedulerContext.setValue(portletContextState.name());
			updateSmsSchedulerContext(smsSchedulerContext);
		} catch (SystemException e) {
			logger.error("Errore grave, Non è stato possibile aggiornare lo stato del portal context init/detroy");
		}		
	}
	*/
}