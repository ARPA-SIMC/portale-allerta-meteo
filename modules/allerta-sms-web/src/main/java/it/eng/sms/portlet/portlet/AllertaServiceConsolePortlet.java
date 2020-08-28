package it.eng.sms.portlet.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import it.eng.allerta.messages.services.HostUtility;
import it.eng.allerta.messages.services.SmsUtility;
import it.eng.allerta.messages.services.SmsWatchdogManagerWebServices;
import it.eng.allerta.messages.services.action.StartupAction;
import it.eng.allerta.messages.services.scheduler.SmsSchedulerContextException;
import it.eng.allerta.messages.services.scheduler.SmsSchedulerContextUtility;
import it.eng.allerta.messages.services.service.SmsSchedulerContextLocalService;
import it.eng.allerta.utils.AllertaKeys;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=" + AllertaKeys.AllertaCategory,
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/wsconsole.jsp",
		"com.liferay.portlet.footer-portlet-javascript=/js/sms-service.js",
		"javax.portlet.display-name=Console per la gestione degli Scheduler di invio/verifica SMS", 
		"javax.portlet.name=" + AllertaKeys.AllertaServiceConsolePortlet,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AllertaServiceConsolePortlet extends MVCPortlet {
	
	private static Log logger = LogFactoryUtil.getLog(AllertaServiceConsolePortlet.class);
	
	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	private SmsSchedulerContextUtility smsSchedulerContextUtility;
	
	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	private SmsSchedulerContextLocalService smsSchedulerContextLocalService;
	
	// metodi public
	
	@Override
	public void init() throws PortletException {
		logger.info("Init Portlet AllertaServiceConsolePortlet - Avvio ...");
		
		super.init();
		
		logger.info("Init Portlet AllertaServiceConsolePortlet - Terminato con successo");
	}
	
	@Override
	public void destroy() {
		logger.info("Destroy Portlet AllertaServiceConsolePortlet - Avvio ...");
		
		/*
		try {			
			smsSchedulerContextUtility.doPortalDestroyInExclusiveMode();
			logger.info("Destroy Portlet AllertaServiceConsolePortlet - Terminato con successo");
		} catch (Throwable e) {			
			logger.error("Destroy Portlet AllertaServiceConsolePortlet - Terminato con fallimento",  e);
		} finally {
			super.destroy();
		}
		*/
		super.destroy();
		
		logger.info("Destroy Portlet AllertaServiceConsolePortlet - Terminato con successo");
	}
	
	public void tryStartScheduler() throws Exception {
		boolean isStarted;
		
		if (smsSchedulerContextLocalService.isSchedulerInThisHost()) {
			isStarted = smsSchedulerContextUtility.tryStartScheduler();
		} else {
			isStarted = SmsSchedulerContextUtility.tryStartSchedulerOther();
		}		
		if (!isStarted) {
			throw new SmsSchedulerContextException("Non è stato possibile eseguire lo start dello scheduler");
		}
	}
	
	public void tryShutdownScheduler() throws Exception {
		boolean isShutdown;
		
		if (smsSchedulerContextLocalService.isSchedulerInThisHost()) {
			isShutdown = smsSchedulerContextUtility.tryShutdownScheduler();
		} else {
			isShutdown = SmsSchedulerContextUtility.tryShutdownSchedulerOther();
		}		
		if (!isShutdown) {
			throw new SmsSchedulerContextException("Non è stato possibile eseguire lo shutdown dello scheduler");
		}
	}
	
	public void toggleSendOrSimulateSMS() throws Exception {
		if (smsSchedulerContextLocalService.isSchedulerInThisHost()) {
			smsSchedulerContextUtility.toggleSendOrSimulateSMS();
		} else {
			SmsSchedulerContextUtility.toggleSendOrSimulateSMSOther();
		}
	}
	
	public void toggleVerifyIfServerIsEnable() throws Exception {
		if (smsSchedulerContextLocalService.isSchedulerInThisHost()) {
			smsSchedulerContextUtility.toggleVerifyIfServerIsEnable();
		} else {
			SmsSchedulerContextUtility.toggleVerifyIfServerIsEnableOther();
		}
	}
	
	// metodi protected
	
	@ProcessAction(name="doProcessAction")
	public void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortalException {
		String cmd = ParamUtil.getString(actionRequest, "cmd");
		
		try {
			switch (cmd) {		
				case "tryStartScheduler":
					logger.info("richiesta esecuzione action tryStartScheduler");
					
					tryStartScheduler();
					break;
					
				case "tryShutdownScheduler":
					logger.info("richiesta esecuzione action tryShutdownScheduler");
					
					tryShutdownScheduler();
					break;
					
				case "toggleSendOrSimulateSMS":
					logger.info("richiesta esecuzione action toggleSendOrSimulateSMS");
					
					toggleSendOrSimulateSMS();
					break;
					
				case "toggleVerifyIfServerIsEnable":
					logger.info("richiesta esecuzione action toggleVerifyIfServerIsEnable");
					
					toggleVerifyIfServerIsEnable();
					break;		
			}
			
			SessionMessages.add(actionRequest, "success");
		} catch(Throwable t) {
			String errMsg = "non è stato possibile eseguire il comando " + cmd;
			logger.error(errMsg);
			
			SessionErrors.add(actionRequest, "error");			
		} finally {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);			
			Long plid = PortalUtil.getPlidFromPortletId( themeDisplay.getScopeGroupId(), AllertaKeys.AllertaServiceConsolePortlet);
			PortletURL compilaURL = PortletURLFactoryUtil.create(actionRequest,	AllertaKeys.AllertaServiceConsolePortlet, plid, PortletRequest.RENDER_PHASE);
			
			actionResponse.sendRedirect( compilaURL.toString());
		}
	}
}
