package it.eng.allerta.messaggio.sindaco.portlet;


import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import it.eng.allerta.messaggio.sindaco.bean.MessaggioBean;
import it.eng.allerta.messaggio.sindaco.config.MessaggioSindacoConfiguration;
import it.eng.allerta.utils.AllertaKeys;

import java.io.IOException;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

/**
 * @author VLPMRC80B
 */
@Component(
		 configurationPid = "it.eng.allerta.messaggio.sindaco.config.MessaggioSindacoConfiguration",
		 configurationPolicy = ConfigurationPolicy.OPTIONAL,	        
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=" + AllertaKeys.AllertaCategory,
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.footer-portlet-javascript=/js/check.js",
		"javax.portlet.display-name=Allerta Messaggio del Sindaco",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AllertaKeys.AllertaMessaggioSindacoPortlet,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.init-param.add-process-action-success-action=false"
	},
	service = Portlet.class
)
public class AllertaMessaggioSindacoPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
	
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		try {
			
			boolean isNew = ParamUtil.getBoolean(renderRequest, "new");
			
			MessaggioBean messaggioBean = (MessaggioBean) renderRequest.getPortletSession()
					.getAttribute(AllertaKeys.SessionMessaggioBean);
			
			if (messaggioBean == null || isNew) {
				messaggioBean = new MessaggioBean(themeDisplay.getUser());
			}
			
			renderRequest.setAttribute("messaggioBean", messaggioBean);
			//se siamo arrivati in fondo, elimina i dati dell'invio dalla sessione
			renderRequest.getPortletSession().setAttribute(AllertaKeys.SessionMessaggioBean, messaggioBean.getStep()==4?null:messaggioBean);
			
			renderRequest.setAttribute(
					MessaggioSindacoConfiguration.class.getName(), _configuration);

		} catch (Exception e) {
			_log.error(e);
		}
		
		
		super.render(renderRequest, renderResponse);
	}


    @Activate
    @Modified
    protected void activate(Map<String, Object> properties) {
        _configuration = ConfigurableUtil.createConfigurable(
        		MessaggioSindacoConfiguration.class, properties);
    }

    private volatile MessaggioSindacoConfiguration _configuration;
	
	
	private Log _log = LogFactoryUtil.getLog(AllertaMessaggioSindacoPortlet.class);
}