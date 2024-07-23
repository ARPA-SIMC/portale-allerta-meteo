package it.eng.allerta.compila.portlet.command;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.NoSuchWorkflowInstanceLinkException;
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
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermissionUtil;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerter.model.Allerta;
import it.eng.allerter.service.AllertaLocalServiceUtil;
import it.eng.allerter.service.LogInternoLocalServiceUtil;
import it.eng.bollettino.model.Bollettino;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AllertaKeys.AllertaCompilaSbPortlet,
				"mvc.command.name=/allertaer/allerta/workflow"
		},
		service = MVCActionCommand.class
	)
public class WorkflowAllertaMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String cmd = "";
		try {
		long allertaId = ParamUtil.getLong(actionRequest, "allertaId");
		long taskId = ParamUtil.getLong(actionRequest, "taskId");
		cmd = ParamUtil.getString(actionRequest, "cmd");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		Allerta b = AllertaLocalServiceUtil.getAllerta(allertaId);
		
		try {
			LogInternoLocalServiceUtil.log("WorkflowAllertaMVCActionCommand",
					"doProcessAction", ""+allertaId+" "+taskId+" "+cmd, "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		boolean hasWfl = 
				WorkflowInstanceLinkLocalServiceUtil.hasWorkflowInstanceLink(
						b.getCompanyId(), 
						b.getGroupId(), 
						Allerta.class.getName(), 
						allertaId);
		
		if(hasWfl ) {
			
			WorkflowInstanceLink wil= null;
			
			try {
				wil = WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(
									b.getCompanyId(), 
									b.getGroupId(), 
									Allerta.class.getName(), 
									allertaId);
				
			} catch( NoSuchWorkflowInstanceLinkException nse) {
				
			}
			
			if( wil != null) { 
				
	            WorkflowTask task = WorkflowTaskManagerUtil.getWorkflowTask(themeDisplay.getCompanyId(), taskId);
	            
	            boolean taskPerm = WorkflowPermissionUtil.hasPermission(
					                		themeDisplay.getPermissionChecker(), 
					                		b.getGroupId(), 
					                		Allerta.class.getName(), 
					                		allertaId, 
					                		task.getName());
	            
	            if( taskPerm) {
	            	
	            	 WorkflowInstance workflowInstance = 
	            			 WorkflowInstanceManagerUtil.getWorkflowInstance(themeDisplay.getCompanyId(), wil.getWorkflowInstanceId());
	            	
	            	 Map<String, Serializable> workflowContext = workflowInstance.getWorkflowContext();
	            	 
	            	 try {
		            	 if (task.isCompleted()) {
		            		 //stiamo tentando di riassegnare un task vecchio, forse problema di cache
		            		 List<WorkflowTask> ls = WorkflowTaskManagerUtil.getWorkflowTasksByWorkflowInstance(themeDisplay.getCompanyId(), 0L, workflowInstance.getWorkflowInstanceId(), false, -1, -1, null);
		            		 if (ls!=null) {
		            			 for (WorkflowTask wt : ls) { 
		            				 if (!wt.isCompleted() && wt.getName().equals(task.getName())) {
		            					 
			            				 LogInternoLocalServiceUtil.log("workflow", "test", "taskId->"+taskId+"->"+wt.getWorkflowTaskId(), null);
			            				 task = wt;
			            				 taskId = wt.getWorkflowTaskId();
		            					 break;
		            				 }
		            			 }
		            		 }
		            	 }
	            	 } catch (Exception e) {
        				 LogInternoLocalServiceUtil.log("workflow", "test", e, null);
	            	 }
	            	 
	            	 
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
	    						"Rejected", 
	    						workflowContext);
	    			}
	            }
			}
		
		}
		
		long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), false, AllertaKeys.AllertaCompilaSbPortlet);
		 
		PortletURL redirect = PortletURLFactoryUtil.create(
				 					PortalUtil.getHttpServletRequest(actionRequest), AllertaKeys.AllertaCompilaSbPortlet,
				 					plid, PortletRequest.RENDER_PHASE
				 				);
			      
		 redirect.setPortletMode(PortletMode.VIEW);
		 redirect.setWindowState(WindowState.NORMAL);		 
		 //actionResponse.sendRedirect(redirect.toString());

		 actionResponse.sendRedirect("/esito-approvazione?cmd="+cmd+"&oggetto=allerta&status=ok");
		 
		} catch (Exception e) {
			LogInternoLocalServiceUtil.log("WorkflowAllertaMVCActionCommand", "doProcessAction", e, "");
			actionResponse.sendRedirect("/esito-approvazione?cmd="+cmd+"&oggetto=allerta&status=ko");

		}
	}

}
