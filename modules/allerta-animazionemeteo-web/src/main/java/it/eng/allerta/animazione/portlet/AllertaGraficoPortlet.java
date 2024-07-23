package it.eng.allerta.animazione.portlet;

import java.io.IOException;

import javax.portlet.MimeResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.parsers.DocumentBuilderFactory;

import org.osgi.service.component.annotations.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
		
		/*try {
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

			Element element = doc.createElement( "meta");

			element.setAttribute( "name", "viewport" );
			element.setAttribute( "content", "minimum-scale=0.25" );
			renderResponse.addProperty(MimeResponse.MARKUP_HEAD_ELEMENT, element);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		super.render(renderRequest, renderResponse);
	}

}
