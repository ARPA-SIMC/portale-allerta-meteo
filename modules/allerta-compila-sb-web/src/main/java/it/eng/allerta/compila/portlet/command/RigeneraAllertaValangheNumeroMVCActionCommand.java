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
import it.eng.allerter.allerta.AllertaValangheBean;

@Component(
	immediate = true,
	property = {
			"javax.portlet.name=" + AllertaKeys.AllertaValangheCompilaSbPortlet,
			"mvc.command.name=/allertaer/allerta_valanghe/rigenera"
	},
	service = MVCActionCommand.class
)
public class RigeneraAllertaValangheNumeroMVCActionCommand extends BaseMVCActionCommand{

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
		HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
		
		AllertaValangheBean allertaValangheBean = new AllertaValangheBean(request);
		
		String allerta = request.getParameter("allerta");
		int eventi[] = new int[1];
		
		if (allerta!=null) {
			String x[] = allerta.split(",");
			for (int k=0; k<x.length; k++) eventi[k] = Integer.parseInt(x[k]);
		} 
		
		allertaValangheBean.setTitoloDefault(eventi);
		
		actionRequest.setAttribute(AllertaKeys.RequestAllertaValangheBean, allertaValangheBean);	
		actionResponse.getRenderParameters().setValue("titolo", allertaValangheBean.getTitolo());		
	}

	private void rigeneraNumero(ActionRequest actionRequest, ActionResponse actionResponse) {	
		HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
		
		AllertaValangheBean allertaValangheBean = new AllertaValangheBean(request);		
		
		int eventi[] = new int[1];
		String allerta = request.getParameter("allerta");
		
		
		if (allerta!=null) {
			String x[] = allerta.split(",");
			for (int k=0; k<x.length; k++) eventi[k] = Integer.parseInt(x[k]);
		} 		
		allertaValangheBean.setNumeroDefault(eventi);	
		
		actionRequest.setAttribute(AllertaKeys.RequestAllertaValangheBean, allertaValangheBean);		
		actionResponse.getRenderParameters().setValue("numero", allertaValangheBean.getNumero());		
	}	
	
	
	
}
