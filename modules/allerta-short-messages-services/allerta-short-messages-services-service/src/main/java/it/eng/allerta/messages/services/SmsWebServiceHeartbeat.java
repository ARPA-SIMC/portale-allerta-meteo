package it.eng.allerta.messages.services;

import com.liferay.portal.kernel.dao.orm.ORMException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import it.eng.allerta.messages.services.action.ShutdownAction;
import it.eng.allerta.messages.services.model.impl.SmsSchedulerContextImpl.SmsSchedulerState;
import it.eng.allerta.messages.services.service.SmsSchedulerContextLocalService;

public class SmsWebServiceHeartbeat implements Runnable {
	
	// <var di classe>
	private static Log logger = LogFactoryUtil.getLog(SmsWebServiceHeartbeat.class);
	
	private static ServiceTracker<SmsSchedulerContextLocalService, SmsSchedulerContextLocalService> _serviceTrackerSmsSchedulerContext;
	private static SmsSchedulerContextLocalService smsSchedulerContextLocalService;
	private static Bundle bundle;

	static {
		bundle = FrameworkUtil.getBundle(SmsSchedulerContextLocalService.class);
	
		ServiceTracker<SmsSchedulerContextLocalService, SmsSchedulerContextLocalService> serviceTracker =
				new ServiceTracker<SmsSchedulerContextLocalService, SmsSchedulerContextLocalService>(bundle.getBundleContext(), SmsSchedulerContextLocalService.class, null);
		serviceTracker.open();	
		_serviceTrackerSmsSchedulerContext = serviceTracker;
		smsSchedulerContextLocalService = _serviceTrackerSmsSchedulerContext.getService();
	}
	
	// metodo run che verrà eseguito dal thread di scheduling
	@Override
	public void run() {
		boolean tryDeactivate = false;		
		
		try {
			// non sono stato interrotto (shutdownNow dall'esterno)
			if (!Thread.currentThread().isInterrupted() /* && !tryDeactivate*/) {
				// aggiorno il battito del cuore con timestamp
				smsSchedulerContextLocalService.updateHeartbeatInstantNow();
			}
			
			tryDeactivate = SmsManagerWebServices.getInstance().isSmsSchedulerStateOneOf(SmsSchedulerState.FORCE_SHUTDOWN);
			
			// se è avvenuto uno shutdown forzato
			if (tryDeactivate) {
				// controllo se gli scheduler Send e Receive sono terminati
				while (!(SmsManagerWebServices.getInstance().isSchedulerSendTerminated() && SmsManagerWebServices.getInstance().isSchedulerReceiveTerminated())) {
					Thread.sleep(500);
				}
				// se sono qui vuol dire che i 2 scheduler sono terminati, forzo lo shutdown del Heartbeat (deve essere l'ultimo a terminare)				
				SmsManagerWebServices.getInstance().forceShutdownSchedulerHeartbeat();
				logger.info("Stop forzato dello schedulerHeartbeat tramite lo stato FORCE_SHUTDOWN settato a DB");				
			}
		} catch (Throwable t) {
			String errMsg = "SchedulerHeartbeat andato in eccezione, lo Scheduler verrà visto dai watchdog in stato DEAD e attiveranno un altro scheduler";			
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
