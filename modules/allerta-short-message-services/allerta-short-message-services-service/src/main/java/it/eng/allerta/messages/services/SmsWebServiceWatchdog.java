package it.eng.allerta.messages.services;

import com.liferay.portal.kernel.dao.orm.ORMException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import it.eng.allerta.messages.services.action.ShutdownAction;
import it.eng.allerta.messages.services.model.impl.SmsSchedulerContextImpl.SmsSchedulerState;
import it.eng.allerta.messages.services.scheduler.SmsSchedulerContextException;
import it.eng.allerta.messages.services.service.SmsSchedulerContextLocalService;

public class SmsWebServiceWatchdog implements Runnable {

	// <var di classe>
	private static Log logger = LogFactoryUtil.getLog(SmsWebServiceWatchdog.class);
	
	private static ServiceTracker<SmsSchedulerContextLocalService, SmsSchedulerContextLocalService> _serviceTrackerSmsSchedulerContext;
	private static SmsSchedulerContextLocalService smsSchedulerContextLocalService;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SmsSchedulerContextLocalService.class);
	
		ServiceTracker<SmsSchedulerContextLocalService, SmsSchedulerContextLocalService> serviceTracker =
				new ServiceTracker<SmsSchedulerContextLocalService, SmsSchedulerContextLocalService>(bundle.getBundleContext(), SmsSchedulerContextLocalService.class, null);
		serviceTracker.open();	
		_serviceTrackerSmsSchedulerContext = serviceTracker;
		smsSchedulerContextLocalService = _serviceTrackerSmsSchedulerContext.getService();
	}
	
	private final String hostIp;
	private final String port;
	
	public SmsWebServiceWatchdog() throws SystemException {
		try {
			hostIp = HostUtility.getCurrentHostIp(); 
			port = HostUtility.getCurrentHostPort();
		} catch (SystemException e) {
			logger.error("SmsWebServiceWatchdog : non è stato possibile ricavere le informazioni sul cluster (IP e Port)", e);
			
			throw e;
		}
	}

	// metodo run che verrà eseguito dal thread di scheduling
	@Override
	public void run() {
		boolean tryDeactivate = false;
		
		try {
			tryDeactivate = SmsManagerWebServices.getInstance().isSmsSchedulerStateOneOf(SmsSchedulerState.FORCE_SHUTDOWN);
			
			// se è avvenuto uno shutdown forzato
			if (tryDeactivate) {
				// forzo lo shutdown anche dei watchdog
				SmsWatchdogManagerWebServices.getInstance().forceShutdownWatchdog();
				logger.info("Stop forzato dello scheduler del Watchdog tramite lo stato FORCE_SHUTDOWN settato a DB");
			}
			
			// non sono stato interrotto (shutdownNow dall'esterno)
			if (!Thread.currentThread().isInterrupted() && !tryDeactivate) {			
				try {
					// se lo scheduler risulta morto (in qualsiasi nodo sia : il controllo si basa sul heartbeat a DB) allora ...
					if (smsSchedulerContextLocalService.isSmsSchedulerDead()) {
						// e il watchdog non è sospeso
						if (!smsSchedulerContextLocalService.isSmsWatchdogSuspend()) {							
							// e lo scheduler non è stato spento con uno shutdown manuale/forzato 
							if (!SmsManagerWebServices.getInstance().isSmsSchedulerStateOneOf(
									SmsSchedulerState.SHUTDOWN, SmsSchedulerState.FORCE_SHUTDOWN
								))								
							{
								// se è in fase di start/shutdown e se è morto ...
								if (SmsManagerWebServices.getInstance().isSmsSchedulerStateOneOf(
										SmsSchedulerState.TRY_SHUTDOWN, SmsSchedulerState.TRY_START, 
										SmsSchedulerState.NOT_STARTED, SmsSchedulerState.NOT_SHUTDOWN
									) && smsSchedulerContextLocalService.ifDeadTryToBecomeScheduler(hostIp, port)) 
								{						
									// ... l'host corrente prova a diventare lo scheduler di invio/verifica SMS
									SmsSchedulerState sss = SmsManagerWebServices.getInstance().tryStartScheduler(); // se va a buon fine lo stato sarà SmsSchedulerState.STARTED
									String logMsg;
									
									if (sss == SmsSchedulerState.STARTED) {
										// non deve più essere watchdog perchè diventa scheduler
										SmsWatchdogManagerWebServices.getInstance().forceShutdownWatchdog();
										logMsg = "Il seguente host " + hostIp+":"+port + " tramite watchdog ha avviato l'istanza dello scheduler di invio/verifica SMS";
										logger.info(logMsg);
									} else {
										logMsg = "Attenzione!!! Il seguente host " + hostIp+":"+port + " tramite watchdog non ha avviato l'istanza dello scheduler di invio/verifica SMS, lo stato è : " + sss.name();
										logger.error(logMsg);									
									}
									
									smsSchedulerContextLocalService.sendMailWithPlainText(logMsg);									
								}
							}
						} else {
							logger.warn("I watchdog al momento sono sospesi, verificare il parametro SMS_WATCHDOG_SUSPEND nella tabella SMSSERVICE_SMSSCHEDULERCONTEXT che sia a FALSE");
						}
					}
				} catch (SmsSchedulerContextException ex) {
					String errMsg = "Errore grave, fase di avvio scheduler del Watchdog andata in errore, verificare se lo scheduler di invio/verifica SMS è attivo : " + ex.getMessage();
					logger.error(errMsg, ex.getCause());
					
					smsSchedulerContextLocalService.sendMailWithPlainText(errMsg);
				}		
			}
		} catch (Throwable t) {
			String errMsg = "Errore grave, schedulerWatchdog andato in eccezione : noin sarà in grado di attivare un eventuale nuovo Scheduler nel caso il principale riscontrasse problemi";			
			logger.error(errMsg, t);			
			
			/*
			if (ShutdownAction.isServerShutdown()) { // perchè il server è in shutdown
				Thread.currentThread().interrupt(); // quindi mi auto interrompo
			}
			*/			
			smsSchedulerContextLocalService.sendMailWithPlainText(errMsg);
		}
	}
}
