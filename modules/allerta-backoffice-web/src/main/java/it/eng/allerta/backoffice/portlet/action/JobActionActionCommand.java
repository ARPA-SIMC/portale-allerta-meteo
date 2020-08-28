package it.eng.allerta.backoffice.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import it.eng.allerta.backoffice.constants.AllertaBackofficeKeys;
import it.eng.allerta.backoffice.scheduler.utils.QuartzSchedulerUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import org.osgi.service.component.annotations.Component;


@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + AllertaBackofficeKeys.ScheduledJobManagerPortlet,
	        "mvc.command.name=jobAction"
	    },
	    service = MVCActionCommand.class
	)
public class JobActionActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		
		String jobAction = ParamUtil.getString(actionRequest, QuartzSchedulerUtil.PARAMETER_JOB_ACTION);
        
        if (!jobAction.isEmpty()) {
        	
            if (jobAction.equals(QuartzSchedulerUtil.ACTION_REFRESH)) {
                // None action here for now. just going to render phase
            } else if (jobAction.equals(QuartzSchedulerUtil.ACTION_SHUTDOWN)) {
                try {
                    QuartzSchedulerUtil.scheduleJobServiceAction(jobAction);
                } catch (SchedulerException e) {
                    _log.error(e);
                    SessionErrors.add(actionRequest, SESSION_MESSAGE_ERROR);
                }
            } else {
                try {
                    QuartzSchedulerUtil.scheduleJobAction(actionRequest, jobAction);
                } catch (Exception e) {
                    _log.error(e);
                    SessionErrors.add(actionRequest, SESSION_MESSAGE_ERROR);
                }
            }
        }
        
        return true;
	}
	
	private static final Log _log = LogFactoryUtil.getLog(JobActionActionCommand.class);
	private static final String SESSION_MESSAGE_ERROR = "request-failed";

}
