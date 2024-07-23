package it.eng.allerta.compila.portlet;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.NoSuchWorkflowInstanceLinkException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.WorkflowInstanceLink;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowLog;
import com.liferay.portal.kernel.workflow.WorkflowLogManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.kernel.workflow.comparator.WorkflowComparatorFactoryUtil;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermissionUtil;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerter.allerta.AllertaBean;
import it.eng.allerter.allerta.AllertaValangheBean;
import it.eng.allerter.model.Allerta;
import it.eng.allerter.model.AllertaValanghe;
import it.eng.allerter.service.AllertaLocalServiceUtil;
import it.eng.allerter.service.AllertaValangheLocalServiceUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author VLPMRC80B
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=" + AllertaKeys.AllertaValangheCategory,
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-css=/css/mappa.css",
		"com.liferay.portlet.footer-portlet-javascript=/js/main.js",
		"com.liferay.portlet.footer-portlet-javascript=/js/init.js",
		"com.liferay.portlet.footer-portlet-javascript=/js/allerta.js",
		"javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.init-param.add-process-action-error-action=false",
		"javax.portlet.display-name=Compila Allerta Valanghe", 
		"javax.portlet.init-param.template-path=/allerta_valanghe/",
		"javax.portlet.init-param.view-template=/allerta_valanghe/view.jsp",
		"javax.portlet.name=" + AllertaKeys.AllertaValangheCompilaSbPortlet,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ValangheCompilaSbWebPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {		
		try {			
			List<AllertaValanghe> allerteEntry = AllertaValangheLocalServiceUtil.getListaAllerteValanghe();			
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);			
			HashMap<String, String> taskIds = new HashMap<String, String>();
			
			for (AllertaValanghe a : allerteEntry) {				
				boolean hasWfl = 
						WorkflowInstanceLinkLocalServiceUtil.hasWorkflowInstanceLink(
								themeDisplay.getCompanyId(), 
								a.getGroupId(), 
								AllertaValanghe.class.getName(), 
								a.getAllertaValangheId());
				
				if( hasWfl) {				
					WorkflowInstanceLink wil= null;
					
					try {
						wil = WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(
											themeDisplay.getCompanyId(), 
											a.getGroupId(), 
											AllertaValanghe.class.getName(), 
											a.getAllertaValangheId());
						
					} catch( NoSuchWorkflowInstanceLinkException nse) {						
					}
		           
					if( wil != null) { 
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
			            
			            if (workflowLogs_assign.size() > 0) {			            	
			                long taskId = workflowLogs_assign.get(workflowLogs_assign.size()-1).getWorkflowTaskId();			                
			                WorkflowTask task = WorkflowTaskManagerUtil.getWorkflowTask(themeDisplay.getCompanyId(), taskId);
			                
			                Boolean taskPerm = WorkflowPermissionUtil.hasPermission(
							                		themeDisplay.getPermissionChecker(), 
							                		a.getGroupId(), 
							                		AllertaValanghe.class.getName(), 
							                		a.getAllertaValangheId(), 
							                		task.getName());
			                
			                //WorkflowTask nextTask = WorkflowTaskManagerUtil.assignWorkflowTaskToUser(companyId, userId, task.getWorkflowTaskId(), userId, "auto assign", task.getDueDate(), workflowContext);
			                _log.debug("task : "+task.getName());
			                _log.debug("task Permission: "+taskPerm);
			                _log.debug("task : "+task.getWorkflowTaskId());
			                if( taskPerm!=null && taskPerm && !task.getName().equals("update"))
			                	taskIds.put(String.valueOf(a.getAllertaValangheId()), String.valueOf(taskId));
			                else 
			                	taskIds.put(String.valueOf(a.getAllertaValangheId()),  "-1");
			            }
					} else
						taskIds.put(String.valueOf(a.getAllertaValangheId()),  "-1");
				} else 
					taskIds.put(String.valueOf(a.getAllertaValangheId()),  "-1");
			}
			
			renderRequest.setAttribute("allerteValangheEntry", allerteEntry);
			renderRequest.setAttribute("allerteValangheTasks", taskIds);
			
		} catch (Exception e) {
			_log.error(e);
		}
				
		super.render(renderRequest, renderResponse);
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest( 
				PortalUtil.getHttpServletRequest(resourceRequest));
		
		long allertaId = ParamUtil.getLong(httpRequest, "allertaValangheId");
		
		String op = ParamUtil.getString(httpRequest, "generaField");

		AllertaValangheBean allertaBean = new AllertaValangheBean(allertaId, httpRequest);

		String allerta = httpRequest.getParameter("allerta");
		int i[] = new int[1];
		i[0] = Integer.parseInt(allerta);
		
		PrintWriter writer = resourceResponse.getWriter();
		if( op.equals("titolo"))
			writer.println(allertaBean.getTitoloDefault(i));
		else 
			writer.println(allertaBean.getNumeroDefault(i));
		
	}
	
	private Log _log = LogFactoryUtil.getLog(ValangheCompilaSbWebPortlet.class);
	
}