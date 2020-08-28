package it.eng.allerta.previsioni.portlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import it.eng.allerta.previsioni.bean.GestioneBean;
import it.eng.allerta.previsioni.bean.Previsioni;
import it.eng.allerta.utils.AllertaKeys;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=" +  AllertaKeys.AllertaCategory,
		"com.liferay.portlet.use-default-template=true",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Allerta Previsioni Terriotrio", 
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/territorio.jsp",
		"javax.portlet.name=" + AllertaKeys.AllertaPrevisioniTerritorioPortlet,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AllertaPrevisioniTerritorio extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		
		GestioneBean gb = new GestioneBean();
		Previsioni previsioni = new Previsioni();
		
		String prov = ParamUtil.getString(renderRequest, "prov", "ND");
		
		renderRequest.setAttribute("GestioneBean", gb);
		renderRequest.setAttribute("PrevisioniBean", previsioni);
		renderRequest.setAttribute("Provincia", prov);
		
		super.render(renderRequest, renderResponse);

	}

}
