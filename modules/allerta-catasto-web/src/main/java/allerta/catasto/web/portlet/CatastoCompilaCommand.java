package allerta.catasto.web.portlet;


import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import allerta.catasto.web.constants.AllertaCatastoWebPortletKeys;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AllertaCatastoWebPortletKeys.ALLERTACATASTOWEB,
				"mvc.command.name=/allertaer/catasto/compila"
		},
		service = MVCRenderCommand.class
		)
public class CatastoCompilaCommand implements MVCRenderCommand{


	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) 
			throws PortletException {
		
		
		return "/dettaglio.jsp";
	}
	
}

