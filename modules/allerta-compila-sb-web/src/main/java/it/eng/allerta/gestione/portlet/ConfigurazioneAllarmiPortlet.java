package it.eng.allerta.gestione.portlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerter.allerta.AllarmeBean;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=" + AllertaKeys.AllertaCategory,
			"com.liferay.portlet.instanceable=false",
			"com.liferay.portlet.header-portlet-css=/css/dataTables.bootstrap4.css",
			"com.liferay.portlet.header-portlet-javascript=/js/jquery.dataTables.min.js",
			"javax.portlet.init-param.add-process-action-success-action=false",
			"javax.portlet.init-param.add-process-action-error-action=false",
			"javax.portlet.display-name=Configurazione Allarmi", 
			"javax.portlet.init-param.template-path=/configurazione/",
			"javax.portlet.init-param.view-template=/configurazione/allarmi.jsp",
			"javax.portlet.name=" + AllertaKeys.AllertaConfigurazioneAllarmiPortlet,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class ConfigurazioneAllarmiPortlet extends MVCPortlet {
	
	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		AllarmeBean allarme = new AllarmeBean( themeDisplay.getUserId());
		
		renderRequest.setAttribute("allarmi", allarme);
		
		super.render(renderRequest, renderResponse);
		
	}
	
	public void serveResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {
		
		String op = ParamUtil.getString(resourceRequest, "op");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		AllarmeBean allarme = new AllarmeBean( themeDisplay.getUserId());
		
		if( op.equals("salva-stato")) {
			
			String json = allarme.attiva(resourceRequest);
			
			PrintWriter writer = resourceResponse.getWriter();
			writer.write(json);
			writer.flush();
			writer.close();
			
		} else if( op.equals("elimina-condizione")) {
			
			allarme.eliminaCondizione(resourceRequest);
			
			PrintWriter writer = resourceResponse.getWriter();
			writer.write("ok");
			writer.flush();
			writer.close();
		}
	}

}
