package it.eng.allerta.gestione.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerter.allerta.SensoreBean;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=" + AllertaKeys.AllertaCategory,
			"com.liferay.portlet.instanceable=false",
			"com.liferay.portlet.header-portlet-css=/css/dataTables.bootstrap4.css",
			"com.liferay.portlet.header-portlet-javascript=/js/jquery.dataTables.min.js",
			"javax.portlet.init-param.add-process-action-success-action=false",
			"javax.portlet.init-param.add-process-action-error-action=false",
			"javax.portlet.display-name=Configurazione Sensori", 
			"javax.portlet.init-param.template-path=/configurazione/",
			"javax.portlet.init-param.view-template=/configurazione/sensori.jsp",
			"javax.portlet.name=" + AllertaKeys.AllertaConfigurazioneSensoriPortlet,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class ConfigurazioneSensoriPortlet extends MVCPortlet {
	
	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
		
		String s = renderRequest.getParameter("solotuoicomuni");
		
		boolean soloTuoi = true;
		if (s!=null) soloTuoi = Boolean.parseBoolean(s);
		
		SensoreBean sensori = new SensoreBean( 
								PortalUtil.getOriginalServletRequest( 
										PortalUtil.getHttpServletRequest(renderRequest)
								), soloTuoi
							);

				
		renderRequest.setAttribute("sensori", sensori);
		
		super.render(renderRequest, renderResponse);
	}
	
	public void serveResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {
		
		String op = ParamUtil.getString(resourceRequest, "op");
//		String idVariabile = ParamUtil.getString(resourceRequest, "idVariabile");
//		String idStazione = ParamUtil.getString(resourceRequest, "idStazione");
		SensoreBean sensori = new SensoreBean( 
				PortalUtil.getOriginalServletRequest( 
						PortalUtil.getHttpServletRequest(resourceRequest)
				)
			);
		
		if( op.equals("salva-soglia")) {
			
			sensori.salvaSoglia(resourceRequest);
			
		} else if( op.equals("salva-stato")) {
			
			String json = sensori.attiva(resourceRequest);
			
			PrintWriter writer = resourceResponse.getWriter();
			writer.write(json);
			writer.flush();
			writer.close();

		}
		
	}

}
