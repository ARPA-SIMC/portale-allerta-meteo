package it.eng.comune.portlet.action;

import java.io.Serializable;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.NoSuchWorkflowInstanceLinkException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.WorkflowInstanceLink;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermissionUtil;

import it.eng.allerta.utils.AllertaKeys;

@Component(
	immediate = true,
	property = {
			"javax.portlet.name=" + AllertaKeys.AllertaStrumentiComunePortlet,
			"mvc.command.name=/allertaer/comune/workflow"
	},
	service = MVCActionCommand.class
)
public class AllertaDocumentiWorkflowAction extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
	
		long fileEntryId = ParamUtil.getLong(actionRequest, "entryId");
		long taskId = ParamUtil.getLong(actionRequest, "taskId");
		String cmd = ParamUtil.getString(actionRequest, "cmd");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		DLFileEntry entry = DLFileEntryLocalServiceUtil.getDLFileEntry(fileEntryId);
		
        WorkflowTask task = WorkflowTaskManagerUtil.getWorkflowTask(themeDisplay.getCompanyId(), taskId);
        
        WorkflowTask nextTask = 
			 	WorkflowTaskManagerUtil.assignWorkflowTaskToUser(
			 			entry.getCompanyId(), 
			 			themeDisplay.getUserId(), 
			 			task.getWorkflowTaskId(), 
			 			themeDisplay.getUserId(), 
			 			"auto assign", task.getDueDate(), 
			 			null);
        
        if( cmd.equals("approve")) {
    		
			WorkflowTaskManagerUtil.completeWorkflowTask(
					entry.getCompanyId(), 
					themeDisplay.getUserId(), 
					nextTask.getWorkflowTaskId(), 
					"approve", 
					"Approved", 
					null);
			
		} else if( cmd.equals("reject")) {
			
			WorkflowTaskManagerUtil.completeWorkflowTask(
					entry.getCompanyId(), 
					themeDisplay.getUserId(), 
					nextTask.getWorkflowTaskId(), 
					"reject", 
					"Rjected", 
					null);
		}
        
        String siteUrl = themeDisplay.getPortalURL() + themeDisplay.getPathFriendlyURLPublic() + themeDisplay.getScopeGroup().getFriendlyURL();
		
		actionResponse.sendRedirect(siteUrl);
	}

}
