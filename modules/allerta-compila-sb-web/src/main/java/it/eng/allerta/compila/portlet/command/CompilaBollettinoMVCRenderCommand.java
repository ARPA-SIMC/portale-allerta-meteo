package it.eng.allerta.compila.portlet.command;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import it.eng.allerta.utils.AllertaKeys;

@Component(
	immediate = true,
	property = {
			"javax.portlet.name=" + AllertaKeys.AllertaCompilaMonitoraggioPortlet,
			"mvc.command.name=/allertaer/bollettino/compila"
	},
	service = MVCRenderCommand.class
)
public class CompilaBollettinoMVCRenderCommand implements MVCRenderCommand {
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) 
			throws PortletException {
		
		
		return "/bollettino/compila.jsp";
	}

}
