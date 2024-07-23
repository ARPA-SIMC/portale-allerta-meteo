package it.eng.allerta.compila.portlet.command;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerter.allerta.AllertaBean;
import it.eng.allerter.allerta.BollettinoBean;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AllertaKeys.AllertaCompilaMonitoraggioPortlet,
				"mvc.command.name=/allertaer/monitoraggio/compila"
		},
		service = MVCRenderCommand.class
		)
public class CompilaMonitoraggioMVCRenderCommand implements MVCRenderCommand{


	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) 
			throws PortletException {
		
		long bollettinoId = ParamUtil.getLong(renderRequest, "bollettinoId");
		BollettinoBean bollettinoBean = null;
		
		if( bollettinoId > 0)
			bollettinoBean = new BollettinoBean(bollettinoId, PortalUtil.getHttpServletRequest(renderRequest));
		else {
			bollettinoBean = new BollettinoBean(PortalUtil.getHttpServletRequest(renderRequest));
			bollettinoId = bollettinoBean.getBollettino().getBollettinoId();
			bollettinoBean = new BollettinoBean(bollettinoId, PortalUtil.getHttpServletRequest(renderRequest));
			
		}
		renderRequest.getPortletSession().setAttribute(AllertaKeys.RequestBollettinoBean, bollettinoBean);
		
		return "/bollettino/compila.jsp";
	}
	
	
}
