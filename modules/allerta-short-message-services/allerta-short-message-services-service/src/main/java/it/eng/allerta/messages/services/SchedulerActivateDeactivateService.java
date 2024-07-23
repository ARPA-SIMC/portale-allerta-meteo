package it.eng.allerta.messages.services;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import it.eng.allerta.messages.services.action.StartupAction;
import it.eng.allerta.messages.services.scheduler.SmsSchedulerContextException;
import it.eng.allerta.messages.services.scheduler.SmsSchedulerContextUtility;
import it.eng.allerta.messages.services.service.SmsSchedulerContextLocalService;
import it.eng.allerta.utils.AllertaTracker;
import it.eng.allerter.service.SMSLocalService;

@Component(
	immediate = true,
	service = SchedulerActivateDeactivateService.class
)
public class SchedulerActivateDeactivateService {
	
	private static Log logger = LogFactoryUtil.getLog(SchedulerActivateDeactivateService.class);
	
	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	private SmsSchedulerContextUtility smsSchedulerContextUtility;
	
	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	private SmsSchedulerContextLocalService smsSchedulerContextLocalService;
	
	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	private SMSLocalService smsLocalService;
	
	//@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED)
	//private ModuleServiceLifecycle moduleServiceLifecycle;

	@Activate
	public void start(BundleContext context) throws Exception {
		logger.info("start SchedulerActivateDeactivateService begin");
		logger.info("lo stato del bundle " + context.getBundle().getSymbolicName() + " è " + toState(context.getBundle().getState()));
		
		try {
		if (AllertaTracker.getAllertaBaseConfiguration().disableSms()) return;
		} catch (Exception e) {
			logger.error(e);
		}
		
		doStart(context);
		
		logger.info("start SchedulerActivateDeactivateService end");
	}

	@Deactivate
	public void stop(BundleContext context) throws Exception {
		logger.info("start SchedulerActivateDeactivateService begin");
		logger.info("lo stato del bundle " + context.getBundle().getSymbolicName() + " è " + toState(context.getBundle().getState()));
		
		doStop(context);
		
		logger.info("stop SchedulerActivateDeactivateService end");
	}
	
	// metodi protected
	
	protected void doStart(BundleContext context) {
		if (smsLocalService != null) {
			logger.debug("smsLocalService is not null");
		} else {
			logger.debug("smsLocalService is null");
		}
		
		// Recupero info realtive al Host corrente
		String infoHost = null;
		String hostIp = "unknown";
		String port = "";
		String nodeId = "unknown";
		
		try {
			nodeId = HostUtility.getCurrentClusterId();
			hostIp = HostUtility.getCurrentHostIp();
			port = HostUtility.getCurrentHostPort();
			
			infoHost = System.lineSeparator() +
					   "Startup Service" + System.lineSeparator() +
					   "Computer name = " + PortalUtil.getComputerName() + System.lineSeparator() +
					   "Node id = " + nodeId + System.lineSeparator() +
					   "Node IP:Port = " + hostIp + ":" + port + System.lineSeparator();
			
			logger.info(infoHost);
			
			if (PortalUtil.getComputerName().contains("vm668lnx")) {
				logger.info("Non sono io il nodo prescelto per gli sms");
				return;
			}
		} catch (SystemException e) {
			String errMsg = "Startup Service - Activate terminato con fallimento : non è stato possibile recuperare info sul host";
			logger.error(errMsg, e);
			
			throw new SystemException(errMsg, e);
		}

		// è la prima volta che viene avviato il server
		if (StartupAction.isServerStartedFirstTime()) {
			StartupAction.setServerNotStartedFirstTime(); // da ora in poi non sarà più il primo riavvio	
			
			try {
				// se lo scheduler risulta morto all'avvio del server allora prova a diventare lo scheduler
				if (smsSchedulerContextUtility.ifDeadTryToBecomeScheduler(hostIp, port)) {
					// dato che ragionevolmente è morto, eseguo il reset dello stato dello Scheduler SMS portandolo a DEAD;
					// tenta di diventare lo scheduler di invio/verifica SMS : usa la tecnica del lock esclusivo (mettendo prima lo stato a DEAD).
					// Se ci riesce, lo scheduler andrà in esecuzione con lo stato pari a STARTED					
					logger.info("il seguente host " + hostIp + ":" + port + " ha avviato l'istanza dello scheduler di invio/verifica SMS");				
				// se non è in stato DEAD il nodo diventa un watchdog
				} else {
					if (!smsSchedulerContextLocalService.isSchedulerInThisHost()) {
						startWatchdogIfNecessary(hostIp, port);
						logger.info("Startup Service - lo scheduler è attivo ma non mi trovo nel host dello scheduler; avvio il watchdog");
					} else {
						logger.warn("Startup Service - lo scheduler è già attivo, se avete cambiato codice è necessario stoppare lo scheduler e riavviarlo");
					}
				}
				
				logger.info("Startup Service - Activate terminato con successo");
			} catch (Throwable ex) {
				String errMsg = "Startup Service - Activate terminato con fallimento : fase di avvio scheduler andata in errore, verificare che lo scheduler sia attivo : " + ex.getMessage();
				logger.error(errMsg, ex.getCause());
				
				smsSchedulerContextLocalService.sendMailWithPlainText(errMsg);
			}
		// se non è il primo riavvio del server allora è il deploy del solo bundle/portlet
		} else {		
			try {
				smsSchedulerContextUtility.doPortalInitInExclusiveMode(hostIp, port);
				
				logger.info("Startup Service - Activate terminato con successo");
			} catch (SmsSchedulerContextException ex) {
				logger.error("Startup Service - Activate terminato con fallimento : fase di riavvio scheduler andata in errore, verificare che lo scheduler sia attivo", ex);
			}
		}
	}
	
	protected void doStop(BundleContext context) {
		try {			
			smsSchedulerContextUtility.doPortalDestroyInExclusiveMode();
			logger.info("Startup Service - Deactive terminato con successo");					
		} catch (Throwable e) {			
			logger.error("Startup Service - Deactive terminato con fallimento",  e);
		}
	}
	
	// metodi private
	
	private void startWatchdogIfNecessary(String hostIp, String port) throws SmsSchedulerContextException {
		logger.info("il seguente host tenterà di avviare l'istanza del watchdog di controllo dello scheduler di invio/verifica SMS");
		
		boolean result = SmsWatchdogManagerWebServices.getInstance().tryStartWatchdog();					
						
		if (!result) {
			String errMsg = "Attenzione!!! Watchdog non avviato per il seguente host : " + hostIp + ":" + port + " perchè già attivo";
			logger.error(errMsg);
			
			smsSchedulerContextLocalService.sendMailWithPlainText(errMsg);
		} else {
			logger.info("Watchdog avviato per il seguente host : " + hostIp);
		}		
	}
	
	private static String toState(int state) {
        switch (state) {
	        case Bundle.UNINSTALLED:
	            return "UNINSTALLED";
	        case Bundle.INSTALLED:
	            return "INSTALLED";
	        case Bundle.RESOLVED:
	            return "RESOLVED";
	        case Bundle.STARTING:
	            return "STARTING";
	        case Bundle.STOPPING:
	            return "STOPPING";
	        case Bundle.ACTIVE:
	            return "ACTIVE";
        }
        
        return null;
    }	
}
