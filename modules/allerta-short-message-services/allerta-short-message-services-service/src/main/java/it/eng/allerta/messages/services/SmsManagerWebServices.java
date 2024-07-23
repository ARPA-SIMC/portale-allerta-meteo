package it.eng.allerta.messages.services;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import it.eng.allerta.messages.services.scheduler.SmsSchedulerContextConstants;

import it.eng.allerta.messages.services.model.SmsSchedulerContext;
import it.eng.allerta.messages.services.model.impl.SmsSchedulerContextImpl;
import it.eng.allerta.messages.services.model.impl.SmsSchedulerContextImpl.SmsSchedulerState;
import it.eng.allerta.messages.services.scheduler.SmsSchedulerContextException;
import it.eng.allerta.messages.services.service.ParametroLocalServiceUtil;
import it.eng.allerta.messages.services.service.SmsSchedulerContextLocalService;
import it.eng.allerter.service.SMSLocalService;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

public class SmsManagerWebServices {
	
	private static Log logger = LogFactoryUtil.getLog(SmsManagerWebServices.class);

	private static final String BASE_MSG_SCHEDULER = "Scheduler periodici ";
	
	private static SmsManagerWebServices INSTANCE;
	
	private static ServiceTracker<SmsSchedulerContextLocalService, SmsSchedulerContextLocalService> _serviceTracker1;
	private static ServiceTracker<SMSLocalService, SMSLocalService> _serviceTracker2;
	private SmsSchedulerContextLocalService smsSchedulerContextLocalService;	
	private SMSLocalService smsLocalService;
	private static Bundle bundle;

	static {
		bundle = FrameworkUtil.getBundle(SmsSchedulerContextLocalService.class);
	
		ServiceTracker<SmsSchedulerContextLocalService, SmsSchedulerContextLocalService> serviceTracker1 =
				new ServiceTracker<SmsSchedulerContextLocalService, SmsSchedulerContextLocalService>(bundle.getBundleContext(), SmsSchedulerContextLocalService.class, null);
		serviceTracker1.open();	
		_serviceTracker1 = serviceTracker1;
		
		ServiceTracker<SMSLocalService, SMSLocalService> serviceTracker2 =
				new ServiceTracker<SMSLocalService, SMSLocalService>(bundle.getBundleContext(), SMSLocalService.class, null);
		serviceTracker2.open();	
		_serviceTracker2 = serviceTracker2;
	}
	
	private ScheduledExecutorService schedulerSend;
	private ScheduledExecutorService schedulerReceive;
	private ScheduledExecutorService schedulerHeartbeat;
	private ScheduledExecutorService schedulerServerVerify;
	
	private ScheduledFuture<?> scheduledFutureSend;
	private ScheduledFuture<?> scheduledFutureReceive;
	private ScheduledFuture<?> scheduledFutureHeartbeat;
	private ScheduledFuture<?> scheduledFutureServerVerify;
	
	private SmsWebServiceSend smsWebServiceSend;
	private SmsWebServiceReceive smsWebServiceReceive;
	private SmsWebServiceHeartbeat smsWebServiceHeartbeat;
	private SmsWebServiceServerVerify smsWebServiceServerVerify;

	private SmsManagerWebServices() throws SmsSchedulerContextException {
		try {
			smsWebServiceSend = new SmsWebServiceSend();
			smsWebServiceReceive = new SmsWebServiceReceive();
			smsWebServiceHeartbeat = new SmsWebServiceHeartbeat();
			smsWebServiceServerVerify = new SmsWebServiceServerVerify();
			smsSchedulerContextLocalService = _serviceTracker1.getService();
			smsLocalService = _serviceTracker2.getService();
		} catch (SystemException e) {
			String errMsg = "Errore grave, non è stato possibile creare gli oggetti che fanno da scheduler (SmsManagerWebServices) e che gestiscono i pool di thread di invio/verifica ricezione sms, Heartbeat e ServerVerify";
			
			throw new SmsSchedulerContextException(errMsg, e);
		}
	}
	
	// metodi public
	
	public static SmsManagerWebServices getInstance() throws SmsSchedulerContextException {
		if (INSTANCE == null) {
			synchronized(SmsManagerWebServices.class) {
				if (INSTANCE == null) {
					INSTANCE = new SmsManagerWebServices();
				}
			}
		}
		
		return INSTANCE;
	}
	
	public ScheduledExecutorService getSchedulerSend() {		
		return schedulerSend;
	}
	
	public ScheduledExecutorService getSchedulerReceive() {
		return schedulerReceive;
	}
	
	public ScheduledExecutorService getSchedulerHeartbeat() {
		return schedulerHeartbeat;
	}
	
	public ScheduledExecutorService getSchedulerServerVerify() {
		return schedulerServerVerify;
	}
	
	/**
	 * Avvia lo scheduler.
	 * 
	 * @return lo stato dello scheduler nel suo complesso
	 */
	public synchronized SmsSchedulerState tryStartScheduler() {
		String infoNodo;
		
		try {
			infoNodo = HostUtility.getCurrentHostIpAndPort() + ", jvm name = " + SmsUtility.nameJVM();
			//if (infoNodo==null || infoNodo.contains("10.10.64.128")) return getSmsSchedulerState();
		
		} catch (SystemException e1) {
			infoNodo = "unknown, jvm name = " + SmsUtility.nameJVM();
		}
		
		// se è già stato tentato un avvio, non lo deve rifare
		if (isSmsSchedulerStateOneOf(SmsSchedulerState.TRY_START, SmsSchedulerState.STARTED)) {
			logger.warn(BASE_MSG_SCHEDULER + " - l'avvio è già in corso tramite metodo tryStartScheduler sul nodo " + infoNodo);
			
			return getSmsSchedulerState();
		// se il service è in stato shutdown allora posso riattivarlo
		} else if (isSmsSchedulerStateOneOf(SmsSchedulerState.SHUTDOWN, SmsSchedulerState.FORCE_SHUTDOWN, SmsSchedulerState.DEAD, SmsSchedulerState.UNDEFINED)) {
			// cambio lo stato
			if (!updateSmsSchedulerState(SmsSchedulerState.TRY_START)) {
				// se ci sono problemi ritorno lo stato NOT_STARTED
				logger.error(BASE_MSG_SCHEDULER + " - tentativo di avvio fallito tramite metodo tryStartScheduler sul nodo " + infoNodo);
				
				return getSmsSchedulerState();
			}			
			logger.info(BASE_MSG_SCHEDULER + " - tento l'avvio tramite metodo tryStartScheduler sul nodo " + infoNodo);				
			
			boolean tryStartSchedulerSend = false;
			boolean tryStartSchedulerReceive = false;
			boolean tryStartSchedulerHeartbeat = false;
			boolean tryStartSchedulerServerVerify = false;
			
			String statoSendMsg = "non definito";
			String statoReceiveMsg = "non definito";
			String statoHeartbeatMsg = "non definito";
			String statoServerVerifyMsg = "non definito";
			
			// create Send
			if (schedulerSend == null) {
				schedulerSend = Executors.newScheduledThreadPool(1);
				tryStartSchedulerSend = true;
			} else {				
				if (schedulerSend.isShutdown() || schedulerSend.isTerminated()) { // non è attivo quindi va ricreato
					tryStartSchedulerSend = true; 
					schedulerSend = Executors.newScheduledThreadPool(1);
				}
			}
			// create Receive
			if (schedulerReceive == null) {			
				schedulerReceive = Executors.newScheduledThreadPool(1);
				tryStartSchedulerReceive = true;			
			} else {
				if (schedulerReceive.isShutdown() || schedulerReceive.isTerminated()) { // non è attivo quindi va ricreato
					tryStartSchedulerReceive = true;
					schedulerReceive = Executors.newScheduledThreadPool(1);
				}
			}
			// create Heartbeat
			if (schedulerHeartbeat == null) {			
				schedulerHeartbeat = Executors.newScheduledThreadPool(1);
				tryStartSchedulerHeartbeat = true;			
			} else {
				if (schedulerHeartbeat.isShutdown() || schedulerHeartbeat.isTerminated()) { // non è attivo quindi va ricreato
					tryStartSchedulerHeartbeat = true;
					schedulerHeartbeat = Executors.newScheduledThreadPool(1);
				}
			}
			// create ServerVerify
			if (schedulerServerVerify == null) {			
				schedulerServerVerify = Executors.newScheduledThreadPool(1);
				tryStartSchedulerServerVerify = true;			
			} else {
				if (schedulerServerVerify.isShutdown() || schedulerServerVerify.isTerminated()) { // non è attivo quindi va ricreato
					tryStartSchedulerServerVerify = true;
					schedulerServerVerify = Executors.newScheduledThreadPool(1);
				}
			}
			
			int initialDelay = 0;
			
			// +-- Scheduler
			SmsSchedulerContext SSC_SCHEDULER_DELAY_TIMEUNIT;
			SmsSchedulerContext SSC_SCHEDULER_DELAY_VALUE;
			TimeUnit sscSchedulerDelayTimeunit;
			long sscSchedulerDelay;
			// +-- Heartbeat
			SmsSchedulerContext SSC_HEARTBEAT_PERIOD_TIMEUNIT;
			SmsSchedulerContext SSC_HEARTBEAT_PERIOD_VALUE;
			TimeUnit sscHeartbeatPeriodTimeunit;
			long sscHeartbeatPeriodValue;
			// +-- ServerVerify
			SmsSchedulerContext SSC_SERVER_VERIFY_PERIOD_TIMEUNIT;
			SmsSchedulerContext SSC_SERVER_VERIFY_PERIOD_VALUE;
			TimeUnit sscServerVerifyPeriodTimeunit;
			long sscServerVerifyPeriodValue;
			
			// +-- leggo le costanti stringa da DB
			try {
				// Scheduler
				SSC_SCHEDULER_DELAY_TIMEUNIT = smsSchedulerContextLocalService.fetchSmsSchedulerContext(SmsSchedulerContextImpl.VAR_ID_SCHEDULER_DELAY_TIMEUNIT);
				SSC_SCHEDULER_DELAY_VALUE = smsSchedulerContextLocalService.fetchSmsSchedulerContext(SmsSchedulerContextImpl.VAR_ID_SCHEDULER_DELAY_VALUE);
				sscSchedulerDelayTimeunit = TimeUnit.valueOf(SSC_SCHEDULER_DELAY_TIMEUNIT.getValue());
				sscSchedulerDelay = Long.valueOf(SSC_SCHEDULER_DELAY_VALUE.getValue()); // conversione da stringa a long
				// Heartbeat
				SSC_HEARTBEAT_PERIOD_TIMEUNIT = smsSchedulerContextLocalService.fetchSmsSchedulerContext(SmsSchedulerContextImpl.VAR_ID_HEARTBEAT_PERIOD_TIMEUNIT);
				SSC_HEARTBEAT_PERIOD_VALUE = smsSchedulerContextLocalService.fetchSmsSchedulerContext(SmsSchedulerContextImpl.VAR_ID_HEARTBEAT_PERIOD);
				sscHeartbeatPeriodTimeunit = TimeUnit.valueOf(SSC_HEARTBEAT_PERIOD_TIMEUNIT.getValue());
				sscHeartbeatPeriodValue = Long.valueOf(SSC_HEARTBEAT_PERIOD_VALUE.getValue()); // conversione da stringa a long
				// ServerVerify
				SSC_SERVER_VERIFY_PERIOD_TIMEUNIT = smsSchedulerContextLocalService.fetchSmsSchedulerContext(SmsSchedulerContextImpl.VAR_SERVER_VERIFY_PERIOD_TIMEUNIT);
				SSC_SERVER_VERIFY_PERIOD_VALUE = smsSchedulerContextLocalService.fetchSmsSchedulerContext(SmsSchedulerContextImpl.VAR_SERVER_VERIFY_PERIOD_VALUE);
				sscServerVerifyPeriodTimeunit = TimeUnit.valueOf(SSC_SERVER_VERIFY_PERIOD_TIMEUNIT.getValue());
				sscServerVerifyPeriodValue =  Long.valueOf(SSC_SERVER_VERIFY_PERIOD_VALUE.getValue()); // conversione da stringa a long
			} catch (SystemException|NumberFormatException e) {
				logger.warn("Al tentativo di start dello scheduler non è stato possibile leggere/convertire i valori dei parametri degli scheduler da DB, verranno settati i valori di default");
				
				// <default value>
				// +-- Scheduler
				sscSchedulerDelayTimeunit = SmsSchedulerContextConstants.SCHEDULER_DELAY_TIMEUNIT;
				sscSchedulerDelay = SmsSchedulerContextConstants.SCHEDULER_DELAY_VALUE;
				// +-- Heartbeat
				sscHeartbeatPeriodTimeunit = SmsSchedulerContextConstants.HEARTBEAT_PERIOD_TIMEUNIT;
				sscHeartbeatPeriodValue = SmsSchedulerContextConstants.HEARTBEAT_PERIOD_VALUE;
				// +-- ServerVerify
				sscServerVerifyPeriodTimeunit = SmsSchedulerContextConstants.SERVER_VERIFY_PERIOD_TIMEUNIT;
				sscServerVerifyPeriodValue = SmsSchedulerContextConstants.SERVER_VERIFY_PERIOD_VALUE;
			}
				
			if (!tryStartSchedulerSend) {
				logger.info(BASE_MSG_SCHEDULER + " - non necessario l'avvio perchè lo scheduler di invio sms non è ancora terminato sul nodo "+ infoNodo);
				statoSendMsg = "non ancora terminato";
			} else {
			// avvia lo scheduler Send				
				SmsWebServiceSend.initParamFromDB();
				scheduledFutureSend = schedulerSend.scheduleWithFixedDelay(smsWebServiceSend, initialDelay, sscSchedulerDelay, sscSchedulerDelayTimeunit);
				statoSendMsg = "avviato";
				logger.info(BASE_MSG_SCHEDULER + " - avvio scheduler di invio sms avvenuto con successo sul nodo " + infoNodo);
			}
			
			if (!tryStartSchedulerReceive) {
				logger.info(BASE_MSG_SCHEDULER + " - non necessario l'avvio perchè lo scheduler di verifica invio sms non è ancora terminato sul nodo " + infoNodo);
				statoReceiveMsg = "non ancora terminato";
			} else {
			// avvia lo scheduler Receive
				scheduledFutureReceive = schedulerReceive.scheduleWithFixedDelay(smsWebServiceReceive, initialDelay, sscSchedulerDelay, sscSchedulerDelayTimeunit);
				statoReceiveMsg = "avviato";
				logger.info(BASE_MSG_SCHEDULER + " - avvio scheduler di verifica invio sms avvenuto con successo sul nodo " + infoNodo);
			}
			
			if (!tryStartSchedulerHeartbeat) {
				logger.info(BASE_MSG_SCHEDULER + " - non necessario l'avvio perchè lo scheduler di Heartbeat non è ancora terminato sul nodo " + infoNodo);
				statoHeartbeatMsg = "non ancora terminato";
			} else {
			// avvia lo scheduler Heartbeat
				scheduledFutureHeartbeat = schedulerHeartbeat.scheduleWithFixedDelay(smsWebServiceHeartbeat, initialDelay, sscHeartbeatPeriodValue, sscHeartbeatPeriodTimeunit);
				statoHeartbeatMsg = "avviato";
				logger.info(BASE_MSG_SCHEDULER + " - avvio scheduler Heartbeat avvenuto con successo sul nodo " + infoNodo);
			}			
			
			if (!tryStartSchedulerServerVerify) {
				logger.info(BASE_MSG_SCHEDULER + " - non necessario l'avvio perchè lo scheduler di ServerVerify non è ancora terminato sul nodo " + infoNodo);
				statoServerVerifyMsg = "non ancora terminato";
			} else {
			// avvia lo scheduler ServerVerify
				smsWebServiceServerVerify.initParamFromDB();
				scheduledFutureServerVerify = schedulerServerVerify.scheduleWithFixedDelay(smsWebServiceServerVerify, initialDelay, sscServerVerifyPeriodValue, sscServerVerifyPeriodTimeunit);
				statoServerVerifyMsg = "avviato";
				logger.info(BASE_MSG_SCHEDULER + " - avvio scheduler ServerVerify avvenuto con successo sul nodo " + infoNodo);
			}
			
			String infoMsg = BASE_MSG_SCHEDULER + 
					" - risultato del metodo tryStartScheduler sul nodo " + infoNodo + " : " + System.lineSeparator() + 
					"Stato Scheduler Send = " + statoSendMsg + 
					", Stato Scheduler Receive = " + statoReceiveMsg + 
					", Stato Scheduler Heartbeat = " + statoHeartbeatMsg +
					", Stato Scheduler ServerVerify = " + statoServerVerifyMsg +
					", Stato Scheduler Globale = ";
			
			if (tryStartSchedulerSend || tryStartSchedulerReceive || tryStartSchedulerHeartbeat || tryStartSchedulerServerVerify) {
				if (!updateSmsSchedulerState(SmsSchedulerState.STARTED)) {
					infoMsg = BASE_MSG_SCHEDULER + " - avvio fallito dello scheduler tramite metodo tryStartScheduler sul nodo " + infoNodo + " : non è stato possibile aggiornare lo stato dello scheduler a DB";
					
					if (scheduledFutureSend != null) {
						scheduledFutureSend.cancel(true);
					}
					if (scheduledFutureReceive != null) {
						scheduledFutureReceive.cancel(true);
					}
					if (scheduledFutureHeartbeat != null) {
						scheduledFutureHeartbeat.cancel(true);
					}
					if (scheduledFutureServerVerify != null) {
						scheduledFutureServerVerify.cancel(true);
					}
					logger.error(infoMsg);
					smsSchedulerContextLocalService.sendMailWithPlainText(infoMsg);
					
					return getSmsSchedulerState();
				}				
				infoMsg = infoMsg + SmsSchedulerState.STARTED.toString() + System.lineSeparator();
				logger.info(infoMsg);
				
				smsSchedulerContextLocalService.sendMailWithPlainText(infoMsg);
				
				return SmsSchedulerState.STARTED;
			} else {
				infoMsg = infoMsg + SmsSchedulerState.NOT_STARTED.toString() + System.lineSeparator() +
						  BASE_MSG_SCHEDULER + " - avvio fallito tramite metodo tryStartScheduler sul nodo " + infoNodo + " : non è stato possibile far partire nessuno degli scheduler";
				logger.error(infoMsg);
				
				try {
					if (!updateSmsSchedulerState(SmsSchedulerState.NOT_STARTED)) {					
						return getSmsSchedulerState();
					}
				} finally {
					smsSchedulerContextLocalService.sendMailWithPlainText(infoMsg);
				}
				
				return SmsSchedulerState.NOT_STARTED;
			}
		} else if (isSmsSchedulerStateOneOf(SmsSchedulerState.TRY_SHUTDOWN)) {
			logger.warn(BASE_MSG_SCHEDULER + " - è in corso uno shutdown tramite metodo tryShutdownScheduler sul nodo " + infoNodo);
			
			return getSmsSchedulerState();
		} else {
			logger.error(BASE_MSG_SCHEDULER + " - caso non previsto tramite metodo tryStartScheduler sul nodo " + infoNodo);
			
			return getSmsSchedulerState();
		}
	}
	
	/**
	 * Tenta lo shutdown dello scheduler.
	 * 
	 * @return lo stato dello scheduler nel suo complesso
	 */
	public synchronized SmsSchedulerState tryShutdownScheduler() {
		String infoNodo;
		
		try {
			infoNodo = HostUtility.getCurrentHostIpAndPort() + ", jvm name = " + SmsUtility.nameJVM();
		} catch (SystemException e1) {
			infoNodo = "unknown, jvm name = " + SmsUtility.nameJVM();
		}
		
		// se è già stato tentato uno shutdown, non lo deve rifare
		if (isSmsSchedulerStateOneOf(SmsSchedulerState.TRY_SHUTDOWN, SmsSchedulerState.SHUTDOWN, SmsSchedulerState.FORCE_SHUTDOWN)) {
			logger.warn(BASE_MSG_SCHEDULER + " - lo shutdown è già in corso oppure è già stato eseguito tramite metodo tryShutdownScheduler sul nodo " + infoNodo);
			
			return getSmsSchedulerState();
		// se il service è in stato started allora posso spegnerlo
		} else if (isSmsSchedulerStateOneOf(SmsSchedulerState.STARTED, SmsSchedulerState.TRY_START, SmsSchedulerState.UNDEFINED)) {		
			if (!updateSmsSchedulerState(SmsSchedulerState.TRY_SHUTDOWN)) {
				logger.error(BASE_MSG_SCHEDULER + " - tentativo di shutdownNow fallito tramite metodo tryShutdownScheduler sul nodo " + infoNodo + " : non è stato possibile aggiornare lo stato dello scheduler a DB");
				
				return getSmsSchedulerState();
			}
			
			logger.info(BASE_MSG_SCHEDULER + " - tento lo shutdownNow tramite metodo tryShutdownScheduler sul nodo " + infoNodo);
			
			String logMsg = null;
			boolean isSendShutdown = false;
			boolean isReceiveShutdown = false;
			boolean isHeartbeatShutdown = false;
			boolean isServerVerifyShutdown = false;
			
			// controlla se è attivo il send
			if (schedulerSend != null && 
				!(isSendShutdown = schedulerSend.isTerminated()) && !(isSendShutdown = schedulerSend.isShutdown())) 
			{
				if (smsWebServiceSend != null) {
					smsWebServiceSend.cancelAllTask(true);
				}
				schedulerSend.shutdownNow();
				scheduledFutureSend.cancel(true);
				isSendShutdown = schedulerSend.isShutdown();
				logMsg = " shutdown dello scheduler Send di invio sms, ";
			} else {
				isSendShutdown = true;
				logMsg = " non è attivo lo scheduler Send di invio sms, lo shutdown non serve, ";
			}
			
			// controlla se è attivo il receive
			if (schedulerReceive != null && 
				!(isReceiveShutdown = schedulerReceive.isTerminated()) && !(isReceiveShutdown = schedulerReceive.isShutdown())) 
			{
				if (smsWebServiceReceive != null) {
					smsWebServiceReceive.cancelAllTask(true);
				}
				schedulerReceive.shutdownNow();
				scheduledFutureReceive.cancel(true);
				isReceiveShutdown = schedulerReceive.isShutdown();
				logMsg = logMsg + " shutdown dello scheduler Receive di verifica invio sms, ";
			} else {
				isReceiveShutdown = true;
				logMsg = logMsg + " non è attivo lo scheduler Receive di verifica invio sms, ";
			}
			
			// controlla se è attivo heartbeat
			if (schedulerHeartbeat != null && 
				!(isHeartbeatShutdown = schedulerHeartbeat.isTerminated()) && !(isHeartbeatShutdown = schedulerHeartbeat.isShutdown())) 
			{
				schedulerHeartbeat.shutdownNow();
				scheduledFutureHeartbeat.cancel(true);
				isHeartbeatShutdown = schedulerHeartbeat.isShutdown();
				logMsg = logMsg + " shutdown dello scheduler Heartbeat, ";
			} else {
				isHeartbeatShutdown = true;
				logMsg = logMsg + " non è attivo lo scheduler Heartbeat, ";
			}
			
			// controlla se è attivo serverVerify
			if (schedulerServerVerify != null && 
				!(isServerVerifyShutdown = schedulerServerVerify.isTerminated()) && !(isServerVerifyShutdown = schedulerServerVerify.isShutdown())) 
			{
				schedulerServerVerify.shutdownNow();
				scheduledFutureServerVerify.cancel(true);
				isServerVerifyShutdown = schedulerServerVerify.isShutdown();
				logMsg = logMsg + " shutdown dello scheduler ServerVerify, ";
			} else {
				isServerVerifyShutdown = true;
				logMsg = logMsg + " non è attivo lo scheduler ServerVerify, ";
			}
			
			String infoMsg = BASE_MSG_SCHEDULER + " - risultato del metodo tryShutdownScheduler sul nodo " + infoNodo + " : " + System.lineSeparator() + logMsg;
			//logger.info(infoMsg);
			
			if (isSendShutdown || isReceiveShutdown || isHeartbeatShutdown || isServerVerifyShutdown) {
				logger.info("Attendo la chiusura degli scheduler ...");
				
				try {
					if (schedulerSend != null) {
						schedulerSend.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
						logger.info("schedulerSend chiuso");
					}
					if (schedulerReceive != null) {
						schedulerReceive.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
						logger.info("schedulerReceive chiuso");
					}
					if (schedulerHeartbeat != null) {
						schedulerHeartbeat.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
						logger.info("schedulerHeartbeat chiuso");
					}
					if (schedulerServerVerify != null) {
						schedulerServerVerify.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
						logger.info("schedulerServerVerify chiuso");
					}
				} catch (InterruptedException e) {
					// log e istruzioni non necessarie, se si esce dalla awaitTermination con interruzione si esce dal metodo normalmente,; non mi interessa gestire
					// l'interruzione che può avvenire solo se c'è uno shutdown della webapp e a quel punto attendere gli scheduler non è importante
				}
				logger.info("Scheduler chiusi");
				
				// se non si aggiorna lo stato
				if (!updateSmsSchedulerState(SmsSchedulerState.SHUTDOWN)) {
					infoMsg = infoMsg + System.lineSeparator() + BASE_MSG_SCHEDULER + " - shutdown fallito tramite metodo tryShutdownScheduler sul nodo " + infoNodo + " : non è stato possibile aggiornare lo stato dello scheduler a DB";
					
					// forzo la cancellazione a mano degli scheduler
					if (scheduledFutureSend != null) {
						scheduledFutureSend.cancel(true);
					}
					if (scheduledFutureReceive != null) {
						scheduledFutureReceive.cancel(true);
					}
					if (scheduledFutureHeartbeat != null) {
						scheduledFutureReceive.cancel(true);
					}
					if (scheduledFutureServerVerify != null) {
						scheduledFutureServerVerify.cancel(true);
					}
					logger.error(infoMsg);
					smsSchedulerContextLocalService.sendMailWithPlainText(infoMsg);
					
					return getSmsSchedulerState();					
				}
				infoMsg = infoMsg + System.lineSeparator() + 
						"Stato scheduler Globale = " + SmsSchedulerState.SHUTDOWN.toString() + System.lineSeparator() +
						BASE_MSG_SCHEDULER + " - shutdown concluso con successo tramite metodo tryShutdownScheduler sul nodo " + infoNodo;
				logger.info(infoMsg);
				
				smsSchedulerContextLocalService.sendMailWithPlainText(infoMsg);
				
				return SmsSchedulerState.SHUTDOWN;
			} else {
				infoMsg = infoMsg + System.lineSeparator() + 
						"Stato scheduler Globale = " + SmsSchedulerState.NOT_SHUTDOWN.toString() + System.lineSeparator() +
						BASE_MSG_SCHEDULER + " - shutdown fallito tramite metodo tryShutdownScheduler sul nodo " + infoNodo;
				logger.error(infoMsg);
				
				try {
					if (!updateSmsSchedulerState(SmsSchedulerState.NOT_SHUTDOWN)) {					
						return getSmsSchedulerState();
					}
				} finally {
					smsSchedulerContextLocalService.sendMailWithPlainText(infoMsg);
				}				
				
				return SmsSchedulerState.NOT_SHUTDOWN;
			}
		} else if (isSmsSchedulerStateOneOf(SmsSchedulerState.TRY_START)) {
			logger.warn(BASE_MSG_SCHEDULER + " - è in corso un avvio tramite metodo tryStartScheduler sul nodo " + infoNodo);
			
			return getSmsSchedulerState();
		} else {
			logger.error(BASE_MSG_SCHEDULER + " - caso non previsto tramite metodo tryShutdownScheduler sul nodo " + infoNodo);
			
			return getSmsSchedulerState();
		}
	}
	
	// metodi per la verifica degli stati dello scheduler
	
	public boolean isSchedulerInStateStarted() {
		return isSmsSchedulerStateOneOf(SmsSchedulerState.STARTED);
	}
	
	public boolean isSchedulerInStateShutdown() {
		return isSmsSchedulerStateOneOf(SmsSchedulerState.SHUTDOWN);
	}
	
	/**
	 * Verifica se lo scheduler è terminato : il send,il receive,heartbeat e il serverVerify devono essere terminati.
	 * 
	 * @return true o false
	 */
	public boolean isSchedulerTerminated() {
		boolean isTerminatedSend = (schedulerSend != null) ? schedulerSend.isTerminated() : true;
		boolean isTerminatedReceive = (schedulerReceive != null) ? schedulerReceive.isTerminated() : true;
		boolean isTerminatedHeartbeat = (schedulerHeartbeat != null) ? schedulerHeartbeat.isTerminated() : true;
		boolean isTerminatedServerVerify = (schedulerServerVerify != null) ? schedulerServerVerify.isTerminated() : true;
		
		return isTerminatedSend && isTerminatedReceive && isTerminatedHeartbeat && isTerminatedServerVerify;
	}
	
	/**
	 * Verifica se lo scheduler è in shutdown : il send,il receive,heartbeat e il serverVerify devono essere in shutdown.
	 * Shutdown è lo stato prima di terminated.
	 * 
	 * @return
	 */
	public boolean isSchedulerShutdown() {
		boolean isShutdownSend = (schedulerSend != null) ? schedulerSend.isShutdown() : true;
		boolean isShutdownReceive = (schedulerReceive != null) ? schedulerReceive.isShutdown() : true;
		boolean isShutdownHeartbeat = (schedulerHeartbeat != null) ? schedulerHeartbeat.isShutdown() : true;
		boolean isShutdownServerVerify = (schedulerServerVerify != null) ? schedulerServerVerify.isShutdown() : true;
		
		return isShutdownSend && isShutdownReceive && isShutdownHeartbeat && isShutdownServerVerify;
	}
	
	// metodi di verifca degli stati terminated/shutdown dei singoli sub scheduler
	
	public boolean isSchedulerSendTerminated() {		
		return (schedulerSend != null) ? schedulerSend.isTerminated() : true;
	}
	
	public boolean isSchedulerReceiveTerminated() {		
		return (schedulerReceive != null) ? schedulerReceive.isTerminated() : true;
	}
	
	public boolean isSchedulerHeartbeatTerminated() {		
		return (schedulerHeartbeat != null) ? schedulerHeartbeat.isTerminated() : true;
	}
	
	public boolean isSchedulerServerVerifyTerminated() {		
		return (schedulerServerVerify != null) ? schedulerServerVerify.isTerminated() : true;
	}
	
	public boolean isSchedulerSendShutdown() {		
		return (schedulerSend != null) ? schedulerSend.isShutdown() : true;
	}
	
	public boolean isSchedulerReceiveShutdown() {		
		return (schedulerReceive != null) ? schedulerReceive.isShutdown() : true;
	}
	
	public boolean isSchedulerHeartbeatShutdown() {		
		return (schedulerHeartbeat != null) ? schedulerHeartbeat.isShutdown() : true;
	}
	
	public boolean isSchedulerServerVerifyShutdown() {		
		return (schedulerServerVerify != null) ? schedulerServerVerify.isShutdown() : true;
	}
	
	/**
	 * Numero di sms inviati dall'avvio dello scheduler.
	 * 
	 * @return
	 */
	public int getSmsInviati() {
		if (smsWebServiceSend == null) {
			return 0;
		}
		
		return SmsWebServiceSend.getSmsInviati();
	}

	/**
	 * Ritorna true se l'invio degli SMS è attivo, false se è simulato.
	 * 
	 * @return
	 */
	public boolean isSendSMS() {
		if (smsWebServiceSend == null) {
			return false;
		}
		
		return SmsWebServiceSend.isSendSMS();
	}
	
	/**
	 * Fa il toggle da SMS inviati a SMS simulati.
	 * 
	 * @return il valore dato da isSendSMS().
	 */
	public synchronized boolean toggleSendOrSimulateSMS() {
		if (smsWebServiceSend != null) {
			SmsWebServiceSend.setSendSMS(!SmsWebServiceSend.isSendSMS());
			
			logger.info("ChangeEnable settato a " + SmsWebServiceSend.isSendSMS());
		}
		
		return (smsWebServiceSend != null) ? SmsWebServiceSend.isSendSMS() : false;
	}	
	
	/**
	 * Ritorna true se è attiva la verifica del server di invio sms.
	 * 
	 * @return se è attiva ritorna true altrimenti false
	 */
	public boolean isServerVerifyEnable() {
		if (smsWebServiceServerVerify == null) {
			return false;
		}
		
		return smsWebServiceServerVerify.isServerVerifyEnable();
	}
	
	/**
	 * Fa il toggle della verifica o meno che il server di invio sms sia attivo.
	 * 
	 * @return il valore dato dal metodo isServerVerifyEnable()
	 */
	public synchronized boolean toggleVerifyIfServerIsEnable() {
		if (smsWebServiceServerVerify != null) {
			smsWebServiceServerVerify.setServerVerifyEnable(!smsWebServiceServerVerify.isServerVerifyEnable());
			
			logger.info("changeServerVerifyEnable settato a " + smsWebServiceServerVerify.isServerVerifyEnable());
		}
		
		return (smsWebServiceServerVerify != null) ? smsWebServiceServerVerify.isServerVerifyEnable() : false;
	}
	
	/**
	 * Ritorna il numero degli SMS in un determinato stato.
	 * 
	 * @param stato
	 * @return
	 */
	public int getSmsInStato(Long stato){
		int size;
		
		try {
			return smsLocalService.getSmsInStato(stato);
			//ClassLoader cl =(ClassLoader) PortletBeanLocatorUtil.locate("allerta-sb-portlet", "portletClassLoader");
			//DynamicQuery query = DynamicQueryFactoryUtil.forClass(SMS.class, cl).add(PropertyFactoryUtil.forName("stato").eq(stato));
			//size = smsLocalService.dynamicQuery(query).size();
		} catch (SystemException e) {
			size = -1;
			logger.error("Errore nel calcolo degli sms in stato " + stato, e);
		}
		
		return size;
	}
	
	/**
	 * log di testo in HTML
	 * 
	 * @return
	 */
	public String getLog() {
		String getenv = System.getenv("PWD");
		if (getenv==null) return "";
		File file = new File(getenv+"/logs/SmsService/logging.log");
		String tail = SmsUtility.tail(file, 30).replaceAll("\\R", "<br/>");
		
		return tail;
	}

	/**
	 * ritorna l'IP del localhost
	 * 
	 * @return
	 * @throws UnknownHostException
	 */
	public String getIp() throws UnknownHostException {
		return InetAddress.getLocalHost().getHostAddress();
	}

	/**
	 * Ritorna il nome della JVM del localhost.
	 * 
	 * @return
	 */
	public String nameJVM() {
		return SmsUtility.nameJVM();
	}
	
	/**
	 * Metodo vecchio di Giorgianni che non ho più usato.
	 */
	public void resetSMSFaseTwo(){
		ParametroLocalServiceUtil.resetSMSFaseTwo();
	}
	
	/**
	 * Metodo vecchio di Giorgianni che non ho più usato.
	 */
	public void resetSMSFaseThree(){
		ParametroLocalServiceUtil.resetSMSFaseThree();
	}
	
	/**
	 * Ritorna true se lo scheduler è in uno degli stati passati.
	 * 
	 * @param smsSchedulerStateValues
	 * @return
	 */
	public boolean isSmsSchedulerStateOneOf(SmsSchedulerState... smsSchedulerStateValues) {		
		try {
			SmsSchedulerContext ap = smsSchedulerContextLocalService.fetchSmsSchedulerContext(SmsSchedulerContextImpl.VAR_ID_SMS_SCHEDULER_STATE);
			
			for (SmsSchedulerState smsSchedulerStateValue:smsSchedulerStateValues) {
				if (smsSchedulerStateValue.name().equalsIgnoreCase(ap.getValue())) {
					return true;
				}
			}
			
			return false;
		} catch (Throwable e) {
			String logMsg = String.format("errore grave a DB : fetchSmsSchedulerContext -> varId = %s",  SmsSchedulerContextImpl.VAR_ID_SMS_SCHEDULER_STATE);
			logger.error(logMsg, e);
			
			smsSchedulerContextLocalService.sendMailWithPlainText(logMsg);
			
			throw e;
		}
	}
	
	// metodi default
	
	/**
	 * Aggiorna lo stato dello scheduler a DB.
	 * 
	 * @param smsSchedulerStateValue
	 * @return true se è andato tutto bene altrimenti false con un invio email per sicurezza.
	 */
	public boolean updateSmsSchedulerState(SmsSchedulerState smsSchedulerStateValue) {		
		try {			
			SmsSchedulerContext smsSchedulerContext = smsSchedulerContextLocalService.fetchSmsSchedulerContext(SmsSchedulerContextImpl.VAR_ID_SMS_SCHEDULER_STATE);
			smsSchedulerContext.setValue(smsSchedulerStateValue.toString());
			smsSchedulerContextLocalService.updateSmsSchedulerContext(smsSchedulerContext);
			
			return true;
		} catch (Throwable e) {
			String logMsg = String.format("errore grave a DB : updateSmsSchedulerContext -> varId = %s, valore = %s", SmsSchedulerContextImpl.VAR_ID_SMS_SCHEDULER_STATE, smsSchedulerStateValue.toString());
			logger.error(logMsg);
			
			smsSchedulerContextLocalService.sendMailWithPlainText(logMsg);
			
			return false;
		}
	}
	
	/**
	 * Aggiorna lo stato dello scheduler a DB con una nuova transazione.
	 * 
	 * @param smsSchedulerStateValue
	 * @return
	 */
	public boolean updateSmsSchedulerStateNewTransaction(SmsSchedulerState smsSchedulerStateValue) {		
		try {			
			SmsSchedulerContext smsSchedulerContext = smsSchedulerContextLocalService.fetchSmsSchedulerContext(SmsSchedulerContextImpl.VAR_ID_SMS_SCHEDULER_STATE);
			smsSchedulerContext.setValue(smsSchedulerStateValue.toString());
			smsSchedulerContextLocalService.updateSmsSchedulerContextNewTransaction(smsSchedulerContext);
			
			return true;
		} catch (Throwable e) {
			String logMsg = String.format("errore grave a DB : updateSmsSchedulerContext -> varId = %s, valore = %s", SmsSchedulerContextImpl.VAR_ID_SMS_SCHEDULER_STATE, smsSchedulerStateValue.toString());
			logger.error(logMsg);
			
			smsSchedulerContextLocalService.sendMailWithPlainText(logMsg);
			
			return false;
		}
	}
	
	/**
	 * Ritorna lo stato dello scheduler.
	 * 
	 * @return
	 */
	SmsSchedulerState getSmsSchedulerState() {
		try {
			SmsSchedulerContext ssc = smsSchedulerContextLocalService.fetchSmsSchedulerContext(SmsSchedulerContextImpl.VAR_ID_SMS_SCHEDULER_STATE);
			
			return SmsSchedulerState.valueOf(ssc.getValue());
		} catch (Throwable e) {
			String logMsg = String.format("errore grave a DB : fetchSmsSchedulerContext -> varId = %s",  SmsSchedulerContextImpl.VAR_ID_SMS_SCHEDULER_STATE);
			logger.error(logMsg);
			
			smsSchedulerContextLocalService.sendMailWithPlainText(logMsg);
			
			return SmsSchedulerState.UNDEFINED;
		}
	}
	
	// metodi per forzare lo shutdown dei sub scheduler
	
	boolean forceShutdownSchedulerSend() {
		if (scheduledFutureSend == null) {
			return false;
		}
		if (schedulerSend != null) {			
			schedulerSend.shutdownNow(); // fa lo shutdown dell'istanza corrente del thread in esecuzione ma non dello scheduler
		}
		
		return scheduledFutureSend.cancel(true); // termina il thread dello scheduler 
	}
	
	boolean forceShutdownSchedulerReceive() {
		if (scheduledFutureReceive == null) {
			return false;
		}
		if (schedulerReceive != null) {			
			schedulerReceive.shutdownNow(); // fa lo shutdown dell'istanza corrente del thread in esecuzione ma non dello scheduler
		}
		
		return scheduledFutureReceive.cancel(true); // termina il thread dello scheduler
	}
	
	boolean forceShutdownSchedulerHeartbeat() {
		if (scheduledFutureHeartbeat == null) {
			return false;
		}
		if (schedulerHeartbeat != null) {
			schedulerHeartbeat.shutdownNow(); // fa lo shutdown dell'istanza corrente del thread in esecuzione ma non dello scheduler
		}
		
		return scheduledFutureHeartbeat.cancel(true); // termina il thread dello scheduler
	}
	
	boolean forceShutdownSchedulerServerVerify() {
		if (scheduledFutureServerVerify == null) {
			return false;
		}
		if (schedulerServerVerify != null) {
			schedulerServerVerify.shutdownNow(); // fa lo shutdown dell'istanza corrente del thread in esecuzione ma non dello scheduler
		}
		
		return scheduledFutureServerVerify.cancel(true); // termina il thread dello scheduler
	}
}
