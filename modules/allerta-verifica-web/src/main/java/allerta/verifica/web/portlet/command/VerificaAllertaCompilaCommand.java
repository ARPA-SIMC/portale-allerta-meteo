package allerta.verifica.web.portlet.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import allerta.verifica.web.constants.AllertaVerificaWebPortletKeys;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AllertaVerificaWebPortletKeys.ALLERTAVERIFICAWEB,
				"mvc.command.name=/allertaer/verifica/compila"
		},
		service = MVCRenderCommand.class
		)
public class VerificaAllertaCompilaCommand implements MVCRenderCommand{


	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) 
			throws PortletException {
		
		
		return "/dettaglio.jsp";
	}
	
}

