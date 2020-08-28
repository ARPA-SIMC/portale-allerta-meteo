package it.eng.allerta.gestione.portlet.command;

import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerter.allerta.AllarmeBean;

@Component(
	    immediate = true,
	    property = {
	       "javax.portlet.name=" +AllertaKeys.AllertaConfigurazioneAllarmiPortlet,
	       "mvc.command.name=/allertaer/regola/modifica"
	    },
	    service = MVCRenderCommand.class
	)
public class ModificaRegolaAllarmeRender implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		AllarmeBean allarme = new AllarmeBean( themeDisplay.getUserId());
		allarme.carica(renderRequest);
		
		renderRequest.setAttribute("allarme", allarme);
		
		return "/configurazione/modifica_regola.jsp";
	}

}
