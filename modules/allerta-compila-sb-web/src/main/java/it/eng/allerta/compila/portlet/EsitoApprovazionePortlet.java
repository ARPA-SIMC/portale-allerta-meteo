package it.eng.allerta.compila.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import it.eng.allerta.utils.AllertaKeys;

/**
 * @author VLPMRC80B
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=" + AllertaKeys.AllertaCategory,
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.init-param.add-process-action-error-action=false",
		"javax.portlet.display-name=Esito approvazione", 
		"javax.portlet.init-param.template-path=/configurazione/",
		"javax.portlet.init-param.view-template=/configurazione/esito_approvazione.jsp",
		"javax.portlet.name=EsitoApprovazionePortlet",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class EsitoApprovazionePortlet extends MVCPortlet {
	
	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
		
		super.render(renderRequest, renderResponse);
	}

	
	private Log _log = LogFactoryUtil.getLog(AllertaCompilaSbWebPortlet.class);
	
}
