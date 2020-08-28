package it.eng.allerta.gestione.portlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.bollettino.model.BollettinoParametro;
import it.eng.bollettino.service.BollettinoParametroLocalServiceUtil;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=" + AllertaKeys.AllertaCategory,
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.init-param.add-process-action-success-action=false",
			"javax.portlet.init-param.add-process-action-error-action=false",
			"javax.portlet.display-name=Gestione Monitoraggio", 
			"javax.portlet.init-param.template-path=/bollettino/",
			"javax.portlet.init-param.view-template=/bollettino/gestione_monitoraggio.jsp",
			"javax.portlet.name=" + AllertaKeys.AllertaGestioneMonitoraggioPortlet,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class GestioneMonitoraggioPortlet extends MVCPortlet {
	
	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
		
		BollettinoParametro bollpar = null;
		try {
			bollpar = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("GESTIONE_MONITORAGGIO");
			
		} catch (SystemException e) {
			_log.error(e);
		}
		
		renderRequest.setAttribute("monitoraggioStatus", bollpar.getValore());
		
		super.render(renderRequest, renderResponse);
	}
	
	private Log _log = LogFactoryUtil.getLog(GestioneMonitoraggioPortlet.class);

}
