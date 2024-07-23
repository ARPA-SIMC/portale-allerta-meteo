package it.eng.allerta.compila.portlet.command;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerter.allerta.AllertaBean;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AllertaKeys.AllertaCompilaSbPortlet,
				"mvc.command.name=/allertaer/allerta/rigenera"
		},
		service = MVCActionCommand.class
		)
public class RigeneraAllertaNumeroMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		
		try {
			
			String cmd = ParamUtil.getString(actionRequest, "cmd");
			if (cmd.equals("numero")) {
				rigeneraNumero(actionRequest, actionResponse);
			} else if (cmd.equals("titolo")) {
				rigeneraTitolo(actionRequest, actionResponse);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	private void rigeneraTitolo(ActionRequest actionRequest, ActionResponse actionResponse) {
		
		HttpServletRequest request = PortalUtil.getOriginalServletRequest( 
				PortalUtil.getHttpServletRequest(actionRequest));
		
		AllertaBean allertaBean = new AllertaBean(request);
		
		String allerta = request.getParameter("allerta");
		int eventi[] = new int[9];
		
		if (allerta!=null) {
			String x[] = allerta.split(",");
			for (int k=0; k<x.length; k++) eventi[k] = Integer.parseInt(x[k]);
		} 
		
		allertaBean.setTitoloDefault(eventi);
		
		actionRequest.setAttribute(AllertaKeys.RequestAllertaBean, allertaBean);
		
		actionResponse.getRenderParameters().setValue("titolo", allertaBean.getTitolo());
		
		
	}

	private void rigeneraNumero(ActionRequest actionRequest, ActionResponse actionResponse) {
	
		HttpServletRequest request = PortalUtil.getOriginalServletRequest( 
				PortalUtil.getHttpServletRequest(actionRequest));
		
		AllertaBean allertaBean = new AllertaBean(request);
		
		String allerta = request.getParameter("allerta");
		int eventi[] = new int[9];
		
		if (allerta!=null) {
			String x[] = allerta.split(",");
			for (int k=0; k<x.length; k++) eventi[k] = Integer.parseInt(x[k]);
		} 		
		allertaBean.setNumeroDefault(eventi);		
		
		actionRequest.setAttribute(AllertaKeys.RequestAllertaBean, allertaBean);
		
		actionResponse.getRenderParameters().setValue("numero", allertaBean.getNumero());
		
	}

	
}
