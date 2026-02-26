package it.eng.allerta.messages.services.scheduler;

import com.google.gson.Gson;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ServiceScope;

import it.eng.allerta.messages.services.bean.InfoWS;
import it.eng.allerta.messages.services.bean.IsSmsSendBean;
import it.eng.allerta.messages.services.bean.IsSchedulerInStateShutdownBean;
import it.eng.allerta.messages.services.bean.IsSchedulerInStateStartedBean;
import it.eng.allerta.messages.services.bean.IsSchedulerReceiveShutdownBean;
import it.eng.allerta.messages.services.bean.IsSchedulerReceiveTerminatedBean;
import it.eng.allerta.messages.services.bean.IsSchedulerSendShutdownBean;
import it.eng.allerta.messages.services.bean.IsSchedulerSendTerminatedBean;
import it.eng.allerta.messages.services.bean.IsSchedulerShutdownBean;
import it.eng.allerta.messages.services.bean.IsSchedulerStartedBean;
import it.eng.allerta.messages.services.bean.IsSchedulerTerminatedBean;
import it.eng.allerta.messages.services.bean.IsServerVerifyEnableBean;
import it.eng.allerta.messages.services.bean.LogBean;
import it.eng.allerta.messages.services.bean.SmsInviatiBean;
import it.eng.allerta.messages.services.model.SmsSchedulerContext;
import it.eng.allerta.messages.services.model.impl.SmsSchedulerContextImpl;
import it.eng.allerta.messages.services.model.impl.SmsSchedulerContextImpl.SmsSchedulerState;
import it.eng.allerta.messages.services.service.SmsSchedulerContextLocalService;
import it.eng.allerta.messages.services.servletWS.ServletUtility;
import it.eng.allerta.messages.services.SmsManagerWebServices;

@Component(
	immediate = true,
	scope = ServiceScope.SINGLETON,
	service = SmsSchedulerContextUtility.class
)
public class SmsSchedulerContextUtility {
	
	private static final Log logger = LogFactoryUtil.getLog(SmsSchedulerContextUtility.class);
	
	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	SmsSchedulerContextLocalService smsSchedulerContextLocalService;
	
	public synchronized void resetSmsSchedulerState(SmsSchedulerState smsSchedulerStateNewVal) throws SmsSchedulerContextException {
		try {			
			smsSchedulerContextLocalService.resetSmsSchedulerState(smsSchedulerStateNewVal.name());
		} catch (SystemException e) {
			String errMsg = "reset del parametro " + SmsSchedulerContextImpl.VAR_ID_SMS_SCHEDULER_STATE + " fallito";
			
			throw new SmsSchedulerContextException(errMsg, e);			
		}
	}	
	
	/**
	 * Il metodo prova a far diventare l'host corrente lo scheduler di invio/verifica SMS :
	 * all'interno, nella fase di lock della riga che ne determina lo stato, verifica nuovamente se è veramente in stato DEAD,
	 * perchè in realtà potrebbe essere stato avviato da un altro host.
	 * 
	 * @return
	 * @throws SmsSchedulerContextException
	 */
	public synchronized boolean ifDeadTryToBecomeScheduler(String hostIp, String port/*, boolean fromStartupAction*/) throws SmsSchedulerContextException {
		try {			
			return smsSchedulerContextLocalService.ifDeadTryToBecomeScheduler(hostIp, port);
		} catch (Exception ex) {
			String errMsg = "tryToBecomeScheduler sul seguente nodo identificato da ip:port [" + hostIp + ":" + port + "] fallito";

			throw new SmsSchedulerContextException(errMsg, ex);
		}		
	}
	
	public synchronized void doPortalInitInExclusiveMode(String hostIp, String port) throws SmsSchedulerContextException {
		try {			
			smsSchedulerContextLocalService.doPortalInitInExclusiveMode(hostIp, port);
		} catch (Exception ex) {
			updatePortalContext(SmsSchedulerContextImpl.PortletContextState.INIT_EXCEPTION);
			String errMsg = "doPortalInitInExclusiveMode fallito";

			throw new SmsSchedulerContextException(errMsg, ex);
		}		
	}
	
	public synchronized void doPortalDestroyInExclusiveMode() throws SmsSchedulerContextException {
		try {			
			smsSchedulerContextLocalService.doPortalDestroyInExclusiveMode();
		} catch (Exception ex) {
			updatePortalContext(SmsSchedulerContextImpl.PortletContextState.DESTROY_EXCEPTION);
			String errMsg = "doPortalDestroyInExclusiveMode fallito";

			throw new SmsSchedulerContextException(errMsg, ex);
		}		
	}

	public boolean tryStartScheduler() throws SmsSchedulerContextException, SystemException {
		boolean isStarted;
		
		if (smsSchedulerContextLocalService.isSchedulerInThisHost()) {
			SmsSchedulerState sss = SmsManagerWebServices.getInstance().tryStartScheduler();
			isStarted = sss.equals(SmsSchedulerState.STARTED);
		} else {
			isStarted = tryStartSchedulerOther();
		}
		
		return isStarted;
	}
	
	public boolean tryShutdownScheduler() throws SmsSchedulerContextException, SystemException {
		boolean isShutdown;
		
		if (smsSchedulerContextLocalService.isSchedulerInThisHost()) {
			SmsSchedulerState sss = SmsManagerWebServices.getInstance().tryShutdownScheduler();
			isShutdown = sss.equals(SmsSchedulerState.SHUTDOWN) || sss.equals(SmsSchedulerState.FORCE_SHUTDOWN);
		} else {
			isShutdown = tryShutdownSchedulerOther();
		}		
		
		return isShutdown;
	}
	
	public void toggleSendOrSimulateSMS() throws SmsSchedulerContextException, SystemException {
		if (smsSchedulerContextLocalService.isSchedulerInThisHost()) {
			SmsManagerWebServices.getInstance().toggleSendOrSimulateSMS();
		} else {
			toggleSendOrSimulateSMSOther();
		}
	}
	
	public void toggleVerifyIfServerIsEnable() throws SmsSchedulerContextException, SystemException {
		if (smsSchedulerContextLocalService.isSchedulerInThisHost()) {
			SmsManagerWebServices.getInstance().toggleVerifyIfServerIsEnable();
		} else {
			toggleVerifyIfServerIsEnableOther();
		}
	}
	
	/**
	 * Ottiene parte del log
	 * 
	 * @return
	 * @throws SmsSchedulerContextException
	 * @throws SystemException
	 */
	public String getLog() throws SmsSchedulerContextException, SystemException {
		if (smsSchedulerContextLocalService.isSchedulerInThisHost()) {
			return SmsManagerWebServices.getInstance().getLog();
		} else {
			return getLogOther();
		}
	}
	
	// <metodi locali senza la controparte remota (<metodo>Other)>
	
	/**
	 * Ritorna il numero degli SMS in un determinato stato.
	 * 
	 * @param stato
	 * @return
	 */
	public int getSmsInStato(Long stato) throws SmsSchedulerContextException {		
		return SmsManagerWebServices.getInstance().getSmsInStato(stato);		
	}
	

	// <chiamate alla servlet per poter eseguire gli stessi metodi sul nodo che contiene lo scheduler>
	
	// +-- <remote actions>
	
	public static boolean tryStartSchedulerOther() throws SystemException {
		//HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
		//ServiceContext s = ServiceContextThreadLocal.getServiceContext();
		//HttpServletRequest request = s.getRequest();
		//callServlet(request.getScheme(),request.getServerName(), request.getServerPort(), "tryStartScheduler");
		String callServlet = ServletUtility.callMethodFromServlet("tryStartScheduler");
		Gson gson = new Gson();
		IsSchedulerStartedBean fromJson = gson.fromJson(callServlet, IsSchedulerStartedBean.class);
		
		return fromJson.getIsSchedulerStarted();
	}
	
	public static boolean tryShutdownSchedulerOther() throws SystemException {
		//HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
		//ServiceContext s = ServiceContextThreadLocal.getServiceContext();
		//HttpServletRequest request = s.getRequest();
		//callServlet(request.getScheme(),request.getServerName(), request.getServerPort(), "tryShutdownScheduler");
		String callServlet = ServletUtility.callMethodFromServlet("tryShutdownScheduler");
		Gson gson = new Gson();
		IsSchedulerShutdownBean fromJson = gson.fromJson(callServlet, IsSchedulerShutdownBean.class);
		
		return fromJson.getIsSchedulerShutdown();
	}
	
	public static void toggleSendOrSimulateSMSOther() throws SystemException {
		// HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
		//ServiceContext s = ServiceContextThreadLocal.getServiceContext();
		//HttpServletRequest request = s.getRequest();
		//callServlet(request.getScheme(),request.getServerName(), request.getServerPort(), "changeEnable");
		ServletUtility.callMethodFromServlet("toggleSendOrSimulateSMS");
	}
	
	public static void toggleVerifyIfServerIsEnableOther() throws SystemException {
		ServletUtility.callMethodFromServlet("toggleVerifyIfServerIsEnable");
	}
	
	// +-- <remote properties>
	
	public static long getSmsInviatiOther() throws SystemException {
		String callServlet = ServletUtility.callMethodFromServlet("getSmsInviati");
		Gson gson = new Gson();
		SmsInviatiBean fromJson = gson.fromJson(callServlet, SmsInviatiBean.class);
		
		return fromJson.getSmsInviati();
	}
	
	public static String nameJVMOther() throws SystemException {
		String callServlet = ServletUtility.callMethodFromServlet("nameJVM");
		Gson gson = new Gson();
		InfoWS fromJson = gson.fromJson(callServlet,InfoWS.class);
		
		return fromJson.getNameJVM();
	}
	
	public static boolean isSendSMSOther() throws SystemException {
		//HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
		//ServiceContext s = ServiceContextThreadLocal.getServiceContext();
		//HttpServletRequest request = s.getRequest();
		//String callServlet = callServlet(request.getScheme(),request.getServerName(), request.getServerPort(), "isSmsSend");
		String callServlet = ServletUtility.callMethodFromServlet("isSmsSend");
		Gson gson = new Gson();
		IsSmsSendBean fromJson = gson.fromJson(callServlet, IsSmsSendBean.class);
		
		return fromJson.isSmsSend();
	}
	
	public static boolean isServerVerifyEnableOther() throws SystemException {
		//HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
		//ServiceContext s = ServiceContextThreadLocal.getServiceContext();
		//HttpServletRequest request = s.getRequest();
		//String callServlet = callServlet(request.getScheme(),request.getServerName(), request.getServerPort(), "isEnable");
		String callServlet = ServletUtility.callMethodFromServlet("isServerVerifyEnable");
		Gson gson = new Gson();
		IsServerVerifyEnableBean fromJson = gson.fromJson(callServlet, IsServerVerifyEnableBean.class);
		
		return fromJson.isServerVerifyEnable();
	}
	
	public static boolean isSchedulerInStateStartedOther() throws SystemException {
		String callServlet = ServletUtility.callMethodFromServlet("isSchedulerInStateStarted");
		Gson gson = new Gson();
		IsSchedulerInStateStartedBean fromJson = gson.fromJson(callServlet, IsSchedulerInStateStartedBean.class);
		
		return fromJson.getIsSchedulerInStateStarted();
	}
	
	public static boolean isSchedulerInStateShutdownOther() throws SystemException {
		String callServlet = ServletUtility.callMethodFromServlet("isSchedulerInStateShutdown");
		Gson gson = new Gson();
		IsSchedulerInStateShutdownBean fromJson = gson.fromJson(callServlet, IsSchedulerInStateShutdownBean.class);
		
		return fromJson.getIsSchedulerInStateShutdown();
	}
	
	public static boolean isSchedulerTerminatedOther() throws SystemException {
		String callServlet = ServletUtility.callMethodFromServlet("isSchedulerTerminated");
		Gson gson = new Gson();
		IsSchedulerTerminatedBean fromJson = gson.fromJson(callServlet, IsSchedulerTerminatedBean.class);
		
		return fromJson.getIsSchedulerTerminated();
	}
	
	public static boolean isSchedulerShutdownOther() throws SystemException {
		String callServlet = ServletUtility.callMethodFromServlet("isSchedulerShutdown");
		Gson gson = new Gson();
		IsSchedulerShutdownBean fromJson = gson.fromJson(callServlet, IsSchedulerShutdownBean.class);
		
		return fromJson.getIsSchedulerShutdown();
	}
	
	public static boolean isSchedulerSendTerminatedOther() throws SystemException {
		String callServlet = ServletUtility.callMethodFromServlet("isSchedulerSendTerminated");
		Gson gson = new Gson();
		IsSchedulerSendTerminatedBean fromJson = gson.fromJson(callServlet, IsSchedulerSendTerminatedBean.class);
		
		return fromJson.getIsSchedulerSendTerminated();
	}
	
	public static boolean isSchedulerReceiveTerminatedOther() throws SystemException {
		String callServlet = ServletUtility.callMethodFromServlet("isSchedulerReceiveTerminated");
		Gson gson = new Gson();
		IsSchedulerReceiveTerminatedBean fromJson = gson.fromJson(callServlet, IsSchedulerReceiveTerminatedBean.class);
		
		return fromJson.getIsSchedulerReceiveTerminated();
	}
	
	public static boolean isSchedulerSendShutdownOther() throws SystemException {
		String callServlet = ServletUtility.callMethodFromServlet("isSchedulerSendShutdown");
		Gson gson = new Gson();
		IsSchedulerSendShutdownBean fromJson = gson.fromJson(callServlet, IsSchedulerSendShutdownBean.class);
		
		return fromJson.getIsSchedulerSendShutdown();
	}
	
	public static boolean isSchedulerReceiveShutdownOther() throws SystemException {
		String callServlet = ServletUtility.callMethodFromServlet("isSchedulerReceiveShutdown");
		Gson gson = new Gson();
		IsSchedulerReceiveShutdownBean fromJson = gson.fromJson(callServlet, IsSchedulerReceiveShutdownBean.class);
		
		return fromJson.getIsSchedulerReceiveShutdown();
	}

	public static String getLogOther() throws SystemException {
		//HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
		//ServiceContext s = ServiceContextThreadLocal.getServiceContext();
		//HttpServletRequest request = s.getRequest();
		//String callServlet = callServlet(request.getScheme(),request.getServerName(), request.getServerPort(), "getLog");
		String callServlet = ServletUtility.callMethodFromServlet("getLog");
		Gson gson = new Gson();
		LogBean fromJson = gson.fromJson(callServlet,LogBean.class);
		
		return fromJson.getText();
	}
	
	public static InfoWS getInfo() throws SystemException {
		//HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
		//ServiceContext s = ServiceContextThreadLocal.getServiceContext();
		//HttpServletRequest request = s.getRequest();
		//String callServlet = callServlet(request.getScheme(),request.getServerName(), request.getServerPort(), "getInfo");
		String callServlet = ServletUtility.callMethodFromServlet("getInfo");
		Gson gson = new Gson();
		InfoWS fromJson = gson.fromJson(callServlet, InfoWS.class);
		
		return fromJson;
	}
	
	// metodi private
	
	private void updatePortalContext(SmsSchedulerContextImpl.PortletContextState portletContextState) {
		SmsSchedulerContext smsSchedulerContext;
		
		try {
			smsSchedulerContext = smsSchedulerContextLocalService.fetchSmsSchedulerContext(SmsSchedulerContextImpl.VAR_ID_PORTAL_CONTEXT_STATE);
			smsSchedulerContext.setValue(portletContextState.name());
			smsSchedulerContextLocalService.updateSmsSchedulerContext(smsSchedulerContext);
		} catch (SystemException e) {
			logger.error("Errore grave, Non è stato possibile aggiornare lo stato del portal context init/detroy");
		}		
	}
}
