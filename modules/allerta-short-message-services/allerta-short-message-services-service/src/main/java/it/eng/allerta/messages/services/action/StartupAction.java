package it.eng.allerta.messages.services.action;


import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.SimpleAction;
//import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
//import com.liferay.portal.kernel.util.PortalUtil;

import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;

//import it.eng.allerta.messages.services.HostUtility;
//import it.eng.allerta.messages.services.SmsUtility;
//import it.eng.allerta.messages.services.SmsWatchdogManagerWebServices;
//import it.eng.allerta.messages.services.scheduler.SmsSchedulerContextException;
//import it.eng.allerta.messages.services.scheduler.SmsSchedulerContextUtility;

@Component(
	immediate = true,
	property = {"key=application.startup.events"},
	service = LifecycleAction.class
)
public class StartupAction extends SimpleAction {
	
	private static Log logger = LogFactoryUtil.getLog(StartupAction.class);
	
	private static boolean serverStartedFirstTime = true;
	
	// Liferay lifecycle service
    //@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED)
    //private ModuleServiceLifecycle _portalInitialized; 

	@Override
	public void run(String[] companyIds) throws ActionException {
		logger.info("begin Startup Action");
		
		// Info company
		Long currentCompanyId = CompanyThreadLocal.getCompanyId();
		logger.info("Startup Action - current company id = " + currentCompanyId);
		
		for (String companyId:companyIds) {
			logger.info("Startup Action - company id = " + companyId);
		}
		
		logger.info("end Startup Action");
		
		/*
		// Info Host
		String infoHost = null;
		String hostIp = "unknown";
		String port = "";
		String nodeId = "unknown";
		
		try {
			nodeId = HostUtility.getCurrentClusterId();
			hostIp = HostUtility.getCurrentHostIp();
			port = HostUtility.getCurrentHostPort();
			
			infoHost = System.lineSeparator() +
					   "Startup Portlet" + System.lineSeparator() +
					   "Computer name = " + PortalUtil.getComputerName() + System.lineSeparator() +
					   "Node id = " + nodeId + System.lineSeparator() +
					   "Node IP:Port = " + hostIp + ":" + port + System.lineSeparator();
		} catch (SystemException e) {
			logger.error("Startup Portlet - non è stato possibile recuperare info sul host", e);
		}
		if (infoHost != null) {
			logger.info(infoHost);
		}
		
		try {
			// se lo scheduler risulta morto all'avvio della portlet (ne posso avere più di una attiva nei vari nodi) allora
			// prova a diventare lo scheduler
			if (SmsSchedulerContextUtility.ifDeadTryToBecomeScheduler(hostIp, port)) {
				// dato che ragionevolmente è morto, eseguo il reset dello stato dello Scheduler SMS a DEAD
				// e tento di diventare lo scheduler di invio/verifica SMS : usa la tecnica del lock esclusivo mettendo prima lo stato a SmsSchedulerState.DEAD.
				// Se ci riesce, lo scheduler sarà in esecuzione e il suo stato avrà il valore STARTED
				logger.info("il seguente host " + hostIp + ":" + port + " ha avviato l'istanza dello scheduler di invio/verifica SMS");
			// se non è in stato DEAD il nodo diventa un watchdog
			} else {
				if (!SmsSchedulerContextUtility.isSchedulerInThisHost()) {
					startWatchdogIfNecessary(hostIp, port);
				}
			}
		} catch (SmsSchedulerContextException ex) {
			String errMsg = "Errore grave, fase di avvio scheduler andata in errore, verificare che lo scheduler sia attivo : " + ex.getMessage();
			logger.error(errMsg, ex.getCause());
			
			SmsUtility.sendMailWithPlainText(errMsg);
		}
		*/
	}
	
	public static synchronized boolean isServerStartedFirstTime() {
		return serverStartedFirstTime;
	}
	
	public static synchronized void setServerNotStartedFirstTime() {
		serverStartedFirstTime = false;
	}
	
	/*	
	private void startWatchdogIfNecessary(String hostIp, String port) throws SmsSchedulerContextException {
		logger.info("il seguente host tenterà di avviare l'istanza del watchdog di controllo dello scheduler di invio/verifica SMS");
		
		boolean result = SmsWatchdogManagerWebServices.getInstance().tryStartWatchdog();					
						
		if (!result) {
			String errMsg = "Attenzione!!! Watchdog non avviato per il seguente host : " + hostIp + ":" + port + " perchè già attivo";
			logger.error(errMsg);
			
			SmsUtility.sendMailWithPlainText(errMsg);
		} else {
			logger.info("Watchdog avviato per il seguente host : " + hostIp);
		}		
	}
	*/
}

