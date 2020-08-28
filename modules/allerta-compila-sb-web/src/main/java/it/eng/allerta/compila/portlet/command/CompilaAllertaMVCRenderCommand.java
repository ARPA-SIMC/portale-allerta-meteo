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

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AllertaKeys.AllertaCompilaSbPortlet,
				"mvc.command.name=/allertaer/allerta/compila"
		},
		service = MVCRenderCommand.class
		)
public class CompilaAllertaMVCRenderCommand implements MVCRenderCommand{


	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) 
			throws PortletException {
		
		
		return "/allerta/compila.jsp";
	}
	
}
