package it.eng.allerta.animazione.portlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import it.eng.allerta.animazione.bean.RadarBean;
import it.eng.allerta.utils.AllertaKeys;

@Component(
		immediate = true,
		property = {
				"com.liferay.portlet.display-category=" +  AllertaKeys.AllertaCategory,
				"com.liferay.portlet.use-default-template=true",
				"com.liferay.portlet.instanceable=false",
				"javax.portlet.display-name=Grafico Sensori", 
				"javax.portlet.init-param.template-path=/",
				"javax.portlet.init-param.view-template=/grafico.jsp",
				"javax.portlet.name=" + AllertaKeys.AllertaGraficoPortlet,
				"javax.portlet.resource-bundle=content.Language",
				"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class AllertaGraficoPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		RadarBean graficoBean = new RadarBean(themeDisplay);
		
		renderRequest.setAttribute("GraficoBean", graficoBean);
		
		super.render(renderRequest, renderResponse);
	}

}
