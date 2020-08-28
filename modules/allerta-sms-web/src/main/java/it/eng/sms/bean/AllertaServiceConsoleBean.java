package it.eng.sms.bean;

import com.liferay.portal.kernel.exception.SystemException;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import it.eng.allerta.messages.services.HostUtility;
import it.eng.allerta.messages.services.SmsManagerWebServices;
import it.eng.allerta.messages.services.scheduler.SmsSchedulerContextException;
import it.eng.allerta.messages.services.scheduler.SmsSchedulerContextUtility;
import it.eng.allerta.messages.services.service.SmsSchedulerContextLocalService;

public class AllertaServiceConsoleBean {

	private static ServiceTracker<SmsSchedulerContextLocalService, SmsSchedulerContextLocalService> _serviceTrackerSmsSchedulerContext;
	private static SmsSchedulerContextLocalService smsSchedulerContextLocalService;
	
	private static ServiceTracker<SmsSchedulerContextUtility, SmsSchedulerContextUtility> _serviceTrackerSmsSchedulerContextUtility;
	private static SmsSchedulerContextUtility smsSchedulerContextUtility;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SmsSchedulerContextLocalService.class);
	
		ServiceTracker<SmsSchedulerContextLocalService, SmsSchedulerContextLocalService> serviceTracker1 =
				new ServiceTracker<SmsSchedulerContextLocalService, SmsSchedulerContextLocalService>(bundle.getBundleContext(), SmsSchedulerContextLocalService.class, null);
		serviceTracker1.open();	
		_serviceTrackerSmsSchedulerContext = serviceTracker1;
		smsSchedulerContextLocalService = _serviceTrackerSmsSchedulerContext.getService();
		
		ServiceTracker<SmsSchedulerContextUtility, SmsSchedulerContextUtility> serviceTracker2 =
				new ServiceTracker<SmsSchedulerContextUtility, SmsSchedulerContextUtility>(bundle.getBundleContext(), SmsSchedulerContextUtility.class, null);
		serviceTracker2.open();	
		_serviceTrackerSmsSchedulerContextUtility = serviceTracker2;
		smsSchedulerContextUtility = _serviceTrackerSmsSchedulerContextUtility.getService();
	}
	/**
	 * Nome della JVM del nodo corrente del cluster.
	 * 
	 * @return
	 * @throws SmsSchedulerContextException
	 * @throws SystemException
	 */
	public static String nameJVM() throws SmsSchedulerContextException, SystemException {
		if (smsSchedulerContextLocalService.isSchedulerInThisHost()) {
			return SmsManagerWebServices.getInstance().nameJVM();
		} else {
			return SmsSchedulerContextUtility.nameJVMOther();
		}
	}
	
	/**
	 * Numero degli SMS inviati dal momento in cui è stato avviato il server.
	 * 
	 * @return
	 * @throws SmsSchedulerContextException
	 * @throws SystemException
	 */
	public static long getSmsInviati() throws SmsSchedulerContextException, SystemException {
		if (smsSchedulerContextLocalService.isSchedulerInThisHost()) {
			return SmsManagerWebServices.getInstance().getSmsInviati();
		} else {
			return SmsSchedulerContextUtility.getSmsInviatiOther();
		}
	}
	
	/**
	 * Numero degli SMS nello stato indicato dal parametro stato.
	 * 
	 * @param stato
	 * @return
	 */
	public static String getSmsInStato(long stato) {
		try {
			return String.valueOf(smsSchedulerContextUtility.getSmsInStato(stato));
		} catch (SmsSchedulerContextException e) {
			return "unknown";
		}
	}
	
	/**
	 * Ritorna hostip,port della macchina che contiene lo scheduler attualmente attivo.
	 * 
	 * @return
	 */
	public static String getCurrentSchedulerHostIPAndPort() {
		return smsSchedulerContextLocalService.getHostIPAndPortOfCurrentScheduler();
	}
	
	/**
	 * Ritorna hostip e porta della macchina che ha risposto alla request.
	 * 
	 * @return
	 */
	public static String getCurrentHostIpAndPort() {
		try {
			return HostUtility.getCurrentHostIpAndPort();
		} catch (SystemException ex) {
			return "unknow";
		}
	}
	
	/**
	 * Log parziale dell'applicativo
	 * 
	 * @return
	 */
	public static String getLog() {
		try {
			return smsSchedulerContextUtility.getLog();
		} catch (SystemException | SmsSchedulerContextException e) {
			return "error to get log";
		}
	}
	
	/**
	 * Ritorna true se l'invio degli SMS è abilitato altrimenti false che vuol dire essere in simulazione.
	 * 
	 * @return
	 * @throws SmsSchedulerContextException
	 * @throws SystemException
	 */
	public static boolean isSendSMS() throws SmsSchedulerContextException, SystemException {
		if (smsSchedulerContextLocalService.isSchedulerInThisHost()) {
			return SmsManagerWebServices.getInstance().isSendSMS();
		} else {
			return SmsSchedulerContextUtility.isSendSMSOther();
		}
	}
	
	/**
	 * Ritorna true se lo scheduler di verifica attività del server di invio sms è attivo altrimenti false.
	 * 
	 * @return
	 * @throws SmsSchedulerContextException
	 * @throws SystemException
	 */
	public static boolean isServerVerifyEnable() throws SmsSchedulerContextException, SystemException {
		if (smsSchedulerContextLocalService.isSchedulerInThisHost()) {
			return SmsManagerWebServices.getInstance().isServerVerifyEnable();
		} else {
			return SmsSchedulerContextUtility.isServerVerifyEnableOther();
		}
	}	
	
	// metodi per la verifica degli stati dello scheduler master
	
	public static boolean isSchedulerInStateStarted() throws SmsSchedulerContextException, SystemException {
		if (smsSchedulerContextLocalService.isSchedulerInThisHost()) {
			return SmsManagerWebServices.getInstance().isSchedulerInStateStarted();
		} else {
			return SmsSchedulerContextUtility.isSchedulerInStateStartedOther();
		}
	}
	
	public static boolean isSchedulerInStateShutdown() throws SmsSchedulerContextException, SystemException {
		if (smsSchedulerContextLocalService.isSchedulerInThisHost()) {
			return SmsManagerWebServices.getInstance().isSchedulerInStateShutdown();
		} else {
			return SmsSchedulerContextUtility.isSchedulerInStateShutdownOther();
		}
	}
	
	public static boolean isSchedulerTerminated() throws SmsSchedulerContextException, SystemException {
		if (smsSchedulerContextLocalService.isSchedulerInThisHost()) {
			return SmsManagerWebServices.getInstance().isSchedulerTerminated();
		} else {
			return SmsSchedulerContextUtility.isSchedulerTerminatedOther();
		}
	}

	public static boolean isNotSchedulerTerminated() throws SmsSchedulerContextException, SystemException {
		if (smsSchedulerContextLocalService.isSchedulerInThisHost()) {
			return !SmsManagerWebServices.getInstance().isSchedulerTerminated();
		} else {
			return !SmsSchedulerContextUtility.isSchedulerTerminatedOther();
		}
	}
	
	public static boolean isSchedulerShutdown() throws SmsSchedulerContextException, SystemException {
		if (smsSchedulerContextLocalService.isSchedulerInThisHost()) {
			return SmsManagerWebServices.getInstance().isSchedulerShutdown();
		} else {
			return SmsSchedulerContextUtility.isSchedulerShutdownOther();
		}
	}
	
	public static boolean isNotSchedulerShutdown() throws SmsSchedulerContextException, SystemException {
		if (smsSchedulerContextLocalService.isSchedulerInThisHost()) {
			return !SmsManagerWebServices.getInstance().isSchedulerShutdown();
		} else {
			return !SmsSchedulerContextUtility.isSchedulerShutdownOther();
		}
	}
	
	// metodi di verifica degli stati degli scheduler Send e Receive 
	
	public static boolean isSchedulerSendTerminated() throws SmsSchedulerContextException, SystemException {
		if (smsSchedulerContextLocalService.isSchedulerInThisHost()) {
			return SmsManagerWebServices.getInstance().isSchedulerSendTerminated();
		} else {
			return SmsSchedulerContextUtility.isSchedulerSendTerminatedOther();
		}
	}
	
	public static boolean isSchedulerReceiveTerminated() throws SmsSchedulerContextException, SystemException {
		if (smsSchedulerContextLocalService.isSchedulerInThisHost()) {
			return SmsManagerWebServices.getInstance().isSchedulerReceiveTerminated();
		} else {
			return SmsSchedulerContextUtility.isSchedulerReceiveTerminatedOther();
		}
	}
	
	public static boolean isSchedulerSendShutdown() throws SmsSchedulerContextException, SystemException {
		if (smsSchedulerContextLocalService.isSchedulerInThisHost()) {
			return SmsManagerWebServices.getInstance().isSchedulerSendShutdown();
		} else {
			return SmsSchedulerContextUtility.isSchedulerSendShutdownOther();
		}
	}
	
	public static boolean isSchedulerReceiveShutdown() throws SmsSchedulerContextException, SystemException {
		if (smsSchedulerContextLocalService.isSchedulerInThisHost()) {
			return SmsManagerWebServices.getInstance().isSchedulerReceiveShutdown();
		} else {
			return SmsSchedulerContextUtility.isSchedulerReceiveShutdownOther();
		}
	}	
}
