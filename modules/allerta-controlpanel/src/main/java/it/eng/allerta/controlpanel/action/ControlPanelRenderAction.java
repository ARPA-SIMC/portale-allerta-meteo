package it.eng.allerta.controlpanel.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;

import it.eng.allerta.controlpanel.constants.AllertaControlPanelPortletKeys;


@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AllertaControlPanelPortletKeys.ALLERTACONTROLPANEL,
				"mvc.command.name=/controlpanel/render"
		},
		service = MVCRenderCommand.class
		)
public class ControlPanelRenderAction implements MVCRenderCommand {


	public String render(RenderRequest renderRequest, RenderResponse renderResponse) 
			throws PortletException {
		
		System.out.println("RenderCommand");
		renderRequest.getParameterMap().forEach(
				(key,value)->System.out.println(key+" -> "+value));
		return "/view.jsp";
	}
	
}

