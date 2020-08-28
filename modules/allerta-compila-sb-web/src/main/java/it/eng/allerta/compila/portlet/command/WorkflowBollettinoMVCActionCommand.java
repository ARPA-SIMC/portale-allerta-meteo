package it.eng.allerta.compila.portlet.command;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.NoSuchWorkflowInstanceLinkException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.WorkflowInstanceLink;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowLog;
import com.liferay.portal.kernel.workflow.WorkflowLogManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.kernel.workflow.comparator.WorkflowComparatorFactoryUtil;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermissionUtil;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.bollettino.model.Bollettino;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AllertaKeys.AllertaCompilaMonitoraggioPortlet,
				"mvc.command.name=/allertaer/monitoraggio/workflow"
		},
		service = MVCActionCommand.class
	)
public class WorkflowBollettinoMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		long bollettinoId = ParamUtil.getLong(actionRequest, "bollettinoId");
		long taskId = ParamUtil.getLong(actionRequest, "taskId");
		String cmd = ParamUtil.getString(actionRequest, "cmd");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		Bollettino b = BollettinoLocalServiceUtil.getBollettino(bollettinoId);
		
		boolean hasWfl = 
				WorkflowInstanceLinkLocalServiceUtil.hasWorkflowInstanceLink(
						b.getCompanyId(), 
						b.getGroupId(), 
						Bollettino.class.getName(), 
						bollettinoId);
		
		if(hasWfl ) {
			
			WorkflowInstanceLink wil= null;
			
			try {
				wil = WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(
									b.getCompanyId(), 
									b.getGroupId(), 
									Bollettino.class.getName(), 
									bollettinoId);
				
			} catch( NoSuchWorkflowInstanceLinkException nse) {
				
			}
			
			if( wil != null) { 
				
	            WorkflowTask task = WorkflowTaskManagerUtil.getWorkflowTask(themeDisplay.getCompanyId(), taskId);
	            
	            boolean taskPerm = WorkflowPermissionUtil.hasPermission(
					                		themeDisplay.getPermissionChecker(), 
					                		b.getGroupId(), 
					                		Bollettino.class.getName(), 
					                		bollettinoId, 
					                		task.getName());
	            
	            if( taskPerm) {
	            	
	            	 WorkflowInstance workflowInstance = 
	            			 WorkflowInstanceManagerUtil.getWorkflowInstance(themeDisplay.getCompanyId(), wil.getWorkflowInstanceId());
	            	
	            	 Map<String, Serializable> workflowContext = workflowInstance.getWorkflowContext();

	            	 WorkflowTask nextTask = 
	            			 	WorkflowTaskManagerUtil.assignWorkflowTaskToUser(
	            			 			b.getCompanyId(), 
	            			 			themeDisplay.getUserId(), 
	            			 			task.getWorkflowTaskId(), 
	            			 			themeDisplay.getUserId(), 
	            			 			"auto assign", task.getDueDate(), 
	            			 			workflowContext);
	            	
	            	if( cmd.equals("approve")) {
	            		
	    				WorkflowTaskManagerUtil.completeWorkflowTask(
	    						b.getCompanyId(), 
	    						themeDisplay.getUserId(), 
	    						nextTask.getWorkflowTaskId(), 
	    						"approve", 
	    						"Approved", 
	    						workflowContext);
	    				
	    			} else if( cmd.equals("reject")) {
	    				
	    				WorkflowTaskManagerUtil.completeWorkflowTask(
	    						b.getCompanyId(), 
	    						themeDisplay.getUserId(), 
	    						nextTask.getWorkflowTaskId(), 
	    						"reject", 
	    						"Rjected", 
	    						workflowContext);
	    			}
	            }
			}
		
		}
		
		long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), false, AllertaKeys.AllertaCompilaMonitoraggioPortlet);
		 
		PortletURL redirect = PortletURLFactoryUtil.create(
				 					PortalUtil.getHttpServletRequest(actionRequest), AllertaKeys.AllertaCompilaMonitoraggioPortlet,
				 					plid, PortletRequest.RENDER_PHASE
				 				);
			      
		 redirect.setPortletMode(PortletMode.VIEW);
		 redirect.setWindowState(WindowState.NORMAL);		 
		 //actionResponse.sendRedirect(redirect.toString());

		 actionResponse.sendRedirect("/");
	}

	
	private Log log = LogFactoryUtil.getLog(WorkflowBollettinoMVCActionCommand.class);
}
