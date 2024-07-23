package it.eng.allerta.animazione.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import it.eng.allerta.utils.AllertaKeys;


@Component(
		immediate = true,
		property = {
				"com.liferay.portlet.display-category=" +  AllertaKeys.AllertaCategory,
				"com.liferay.portlet.use-default-template=true",
				"com.liferay.portlet.instanceable=false",
				"com.liferay.portlet.footer-portlet-javascript=/js/am.init.map-with-data.js?v=0.3",
				"javax.portlet.expiration-cache=0",
				"javax.portlet.display-name=Animazione Cumulativa 24h", 
				"javax.portlet.init-param.template-path=/",
				"javax.portlet.init-param.view-template=/animcumulata24.jsp",
				"javax.portlet.name=" + "AllertaAnimazioneCumulata24Portlet",
				"javax.portlet.resource-bundle=content.Language",
				"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class AllertaAnimazioneCumulata24Portlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		
		super.render(renderRequest, renderResponse);
	}
}
