package it.eng.allerta.gestione.portlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerter.allerta.ListaStazioniAttiveBean;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=" + AllertaKeys.AllertaCategory,
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.init-param.add-process-action-success-action=false",
			"javax.portlet.init-param.add-process-action-error-action=false",
			"javax.portlet.display-name=Preferenze Monitoraggio", 
			"javax.portlet.init-param.template-path=/bollettino/",
			"javax.portlet.init-param.view-template=/bollettino/lista_stazioni.jsp",
			"javax.portlet.name=" + AllertaKeys.AllertaPreferenzeMonitoraggioPortlet,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class PreferenzeMonitoraggioPortlet extends MVCPortlet {
	
	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
		
		ListaStazioniAttiveBean stazioni = new ListaStazioniAttiveBean();
		
		renderRequest.setAttribute("stazioni", stazioni);
		
		super.render(renderRequest, renderResponse);
	}

}
