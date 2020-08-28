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
import it.eng.allerter.allerta.BollettinoBean;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AllertaKeys.BollettinoCompilaSbWebPortlet,
				"mvc.command.name=/allertaer/bollettino/rigenera"
		},
		service = MVCActionCommand.class
		)
public class RigeneraBollettinoNumeroMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		

		try {
			
			String cmd = ParamUtil.getString(actionRequest, "cmd");
			if (cmd.equals("numero")) {
				rigeneraNumero(actionRequest, actionResponse);
			} else if (cmd.equals("ora")) {
				rigeneraOra(actionRequest, actionResponse);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	protected void rigeneraOra(ActionRequest actionRequest, ActionResponse actionResponse) 
			throws Exception {
		
			
			HttpServletRequest request = PortalUtil.getOriginalServletRequest( 
					PortalUtil.getHttpServletRequest(actionRequest));
			
			BollettinoBean bollettinoBean = new BollettinoBean(request);
			
			bollettinoBean.rigeneraOra();
			
			actionRequest.setAttribute(AllertaKeys.RequestBollettinoBean, bollettinoBean);
		
	}
	

	
	protected void rigeneraNumero(ActionRequest actionRequest, ActionResponse actionResponse) 
			throws Exception {
		
			
			HttpServletRequest request = PortalUtil.getOriginalServletRequest( 
					PortalUtil.getHttpServletRequest(actionRequest));
			
			BollettinoBean bollettinoBean = new BollettinoBean(request);
			
			bollettinoBean.rigeneraNumero();
			
			actionRequest.setAttribute(AllertaKeys.RequestBollettinoBean, bollettinoBean);
		
	}
	
}
