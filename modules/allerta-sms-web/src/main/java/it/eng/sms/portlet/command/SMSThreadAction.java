package it.eng.sms.portlet.command;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

//import it.eng.allerta.messages.services.model.impl.SmsSchedulerContextImpl.SmsSchedulerState;
import it.eng.allerta.messages.services.scheduler.SmsSchedulerContextUtility;
import it.eng.allerta.utils.AllertaKeys;
import it.eng.sms.bean.SMSManager;


// NON USATA
/*
@Component(
	immediate = true,
	property= {
			"javax.portlet.name=" + AllertaKeys.AllertaServiceConsolePortlet,
			"mvc.command.name=/allerta/sms/thread"
	},
	service = MVCActionCommand.class 
)
*/
public class SMSThreadAction /*extends BaseMVCActionCommand*/ {
	
	/* DELETE CLASS
	@Override
	protected void doProcessAction(
				ActionRequest actionRequest, ActionResponse actionResponse) 
						throws Exception {
		
		
		String cmd = ParamUtil.getString(actionRequest, "cmd");
		
		switch( cmd) {
		
			/case "startStopThread" :
				SMSManager.startOrStopThread();
				break;
				
			case "startStopSocket" :
				SMSManager.startOrStopSocket();
				break;
				
			case "startStopOtherThread" :
				SMSManager.startOrStopThreadOther(
							PortalUtil.getHttpServletRequest(actionRequest));
				break;
				
			case "startOrStopOtherSocket" :
				SMSManager.startOrStopSocketOther(
							PortalUtil.getHttpServletRequest(actionRequest));
				break;/
		
		case "tryStartScheduler":
			SmsSchedulerContextUtility.tryStartScheduler();
			break;
			
		case "tryShutdownScheduler":
			SmsSchedulerContextUtility.tryShutdownScheduler();
			break;
			
		case "changeEnable":
			SmsSchedulerContextUtility.toggleSendOrSimulateSMS();
			break;
			
		case "verifyServerEnable":
			SmsSchedulerContextUtility.toggleVerifyIfServerIsEnable();
			break;
		
		}
		
		
	}
	
	public String tryStartScheduler() throws Exception {
		boolean isStarted;
		
		if (SmsSchedulerContextUtility.isSchedulerInThisHost()) {
			isStarted = SmsSchedulerContextUtility.tryStartScheduler();
		} else {
			isStarted = SmsSchedulerContextUtility.tryStartSchedulerOther();
		}		
		
		return "";
	}
	
	public String tryShutdownScheduler() throws Exception {
		boolean isShutdown;
		
		if (SmsSchedulerContextUtility.isSchedulerInThisHost()) {
			isShutdown = SmsSchedulerContextUtility.tryShutdownScheduler();
		} else {
			isShutdown = SmsSchedulerContextUtility.tryShutdownSchedulerOther();
		}		
		
		return "";
	}
	
	public String changeEnable() throws Exception {
		if (SmsSchedulerContextUtility.isSchedulerInThisHost()) {
			SmsSchedulerContextUtility.toggleSendOrSimulateSMS();
		} else {
			SmsSchedulerContextUtility.toggleSendOrSimulateSMS();
		}
		
		return "";
	}
	
	public String changeServerVerifyEnable() throws Exception {
		if (SmsSchedulerContextUtility.isSchedulerInThisHost()) {
			SmsSchedulerContextUtility.toggleVerifyIfServerIsEnable();
		} else {
			SmsSchedulerContextUtility.toggleVerifyIfServerIsEnableOther();
		}
		
		return "";
	}
*/

}
