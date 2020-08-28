package it.eng.allerta.compila.portlet;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.NoSuchWorkflowInstanceLinkException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.model.WorkflowInstanceLink;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowLog;
import com.liferay.portal.kernel.workflow.WorkflowLogManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManager;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.kernel.workflow.comparator.WorkflowComparatorFactoryUtil;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermissionUtil;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerter.allerta.BollettinoBean;
import it.eng.bollettino.model.Bollettino;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author VLPMRC80B
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=" + AllertaKeys.AllertaCategory,
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-css=/css/mappa.css",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.header-portlet-javascript=/js/interact.js",
		"com.liferay.portlet.footer-portlet-javascript=/js/main.js",
		"com.liferay.portlet.footer-portlet-javascript=/js/init.js",
		"javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.init-param.add-process-action-error-action=false",
		"javax.portlet.display-name=Compila Bollettino Monitoraggio", 
		"javax.portlet.init-param.template-path=/bollettino/",
		"javax.portlet.init-param.view-template=/bollettino/lista_monitoraggi.jsp",
		"javax.portlet.name=" + AllertaKeys.AllertaCompilaMonitoraggioPortlet,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class BollettinoCompilaSbWebPortlet extends MVCPortlet {
	
	
	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
		
		//BollettinoBean bollettinoBean = (BollettinoBean) renderRequest.getPortletSession().getAttribute(AllertaKeys.RequestBollettinoBean);
		
		try {
			
			List<Bollettino> bollettiniEntry = BollettinoLocalServiceUtil.getListaBollettiniMonitoraggio();
			
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			HashMap<String, String> taskIds = new HashMap<String, String>();
			
			for (Bollettino b : bollettiniEntry) {
				
				_log.warn("Considero monitoraggio "+b.getBollettinoId());
				
				boolean hasWfl = 
						WorkflowInstanceLinkLocalServiceUtil.hasWorkflowInstanceLink(
								themeDisplay.getCompanyId(), 
								b.getGroupId(), 
								Bollettino.class.getName(), 
								b.getBollettinoId());
				
				if( hasWfl) {
					
					_log.warn("Workflow link presente");
				
					WorkflowInstanceLink wil= null;
					
					
					try {
						wil = WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(
											themeDisplay.getCompanyId(), 
											b.getGroupId(), 
											Bollettino.class.getName(), 
											b.getBollettinoId());
						
					} catch( NoSuchWorkflowInstanceLinkException nse) {
						_log.error(nse);
					}
		           
					if( wil != null) { 
						
						_log.warn("Workflow link ottenuto");
						
			            List<Integer> logTypes_assign = new ArrayList<Integer>();
			            
			            logTypes_assign.add(WorkflowLog.TASK_ASSIGN);
			            
			            List<WorkflowLog> workflowLogs_assign = 
			            		WorkflowLogManagerUtil.getWorkflowLogsByWorkflowInstance(
			            					themeDisplay.getCompanyId(), 
			            					wil.getWorkflowInstanceId(), 
			            					logTypes_assign, 
			            					QueryUtil.ALL_POS, 
			            					QueryUtil.ALL_POS, 
			            					WorkflowComparatorFactoryUtil.getLogCreateDateComparator(true));
			            
			            if(workflowLogs_assign.size() > 0){
			            	
			            	_log.warn("Workflow assign log ottenuto");
			            	
			                long taskId = workflowLogs_assign.get(workflowLogs_assign.size()-1).getWorkflowTaskId();
			                
			                
			                WorkflowTask task = WorkflowTaskManagerUtil.getWorkflowTask(themeDisplay.getCompanyId(), taskId);
			                _log.warn("taskId = "+taskId+", name="+task.getName()+", workflowTaskId="+task.getWorkflowTaskId());
			                
			                boolean taskPerm = WorkflowPermissionUtil.hasPermission(
							                		themeDisplay.getPermissionChecker(), 
							                		b.getGroupId(), 
							                		Bollettino.class.getName(), 
							                		b.getBollettinoId(), 
							                		task.getName());
			                
			                //WorkflowTask nextTask = WorkflowTaskManagerUtil.assignWorkflowTaskToUser(companyId, userId, task.getWorkflowTaskId(), userId, "auto assign", task.getDueDate(), workflowContext);
			                _log.warn("task Permission: "+taskPerm);
			                if( taskPerm && !task.getName().equals("update"))
			                	taskIds.put(String.valueOf(b.getBollettinoId()), String.valueOf(taskId));
			                else 
			                	taskIds.put(String.valueOf(b.getBollettinoId()),  "-1");
			            }
					} else
						taskIds.put(String.valueOf(b.getBollettinoId()),  "-1");
				} else 
					taskIds.put(String.valueOf(b.getBollettinoId()),  "-1");
			}
			
			renderRequest.setAttribute("bollettiniEntry", bollettiniEntry);
			renderRequest.setAttribute("bollettiniTasks", taskIds);
			
			User u = PortalUtil.getUser(renderRequest);
			boolean canApprove=false;
			boolean canModify=false;
			if (u!=null) {
				for (Role r : RoleLocalServiceUtil.getUserRoles(u.getUserId())) {
					long rl = r.getRoleId();
					if (rl==20161) { //admin
						canApprove = true;
						canModify = true;
					}
					if (rl==227354) { //approvatore_arpae_vero
						canApprove = true;
					}
					if (rl==246577) { //compilatore monitoraggio
						canModify = true;
					}
				}
			}
			_log.info("canApprove: "+canApprove);
			_log.info("canModify: "+canModify);
			renderRequest.setAttribute("canApprove", canApprove?1:0);
			renderRequest.setAttribute("canModify", canModify?1:0);
			
		} catch (Exception e) {
			
			_log.error(e);
			
			
		}
				
		super.render(renderRequest, renderResponse);
	}
	
	public void serveResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {
		
		String op = ParamUtil.getString(resourceRequest, "op");
		
		if( op.equals("genera-numero")) {
			
			boolean ultimo = ParamUtil.getBoolean(resourceRequest, "ultimo");
			
			Calendar c = Calendar.getInstance();
			int anno = c.get(Calendar.YEAR);
			String numero = BollettinoLocalServiceUtil.nextIdMonitoraggio(anno);
			if (ultimo)
				numero += "U";
			
			resourceResponse.setContentType("text/html");
			PrintWriter out = resourceResponse.getWriter();
			out.print(numero);
			out.flush();
			
		} else if( op.equals("genera-ora")) {
			
			//HttpServletRequest req= PortalUtil.getHttpServletRequest(resourceRequest);
			
			BollettinoBean bollettinoBean = (BollettinoBean) resourceRequest.getPortletSession().getAttribute(AllertaKeys.RequestBollettinoBean);
					//req.getAttribute(AllertaKeys.RequestBollettinoBean);
			
			resourceResponse.setContentType("text/html");
			PrintWriter out = resourceResponse.getWriter();
			bollettinoBean.rigeneraOra();
			out.print(bollettinoBean.getBacinoParam().getOre());
			out.flush();
			
		}
		
	}
	
	
	private Log _log = LogFactoryUtil.getLog(BollettinoCompilaSbWebPortlet.class);
	
}