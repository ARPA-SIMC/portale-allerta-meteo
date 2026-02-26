package allerta.search.portlet;

import allerta.search.constants.AllertaSearchPortletKeys;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

/**
 * @author GFavini
 */
@Component(
	configurationPid="allerta.search.portlet.SearchPortletConfig",
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AllertaSearch",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.init-param.config-template=/config.jsp",
		"com.liferay.portlet.footer-portlet-javascript=/js/init.js",
		"javax.portlet.name=" + AllertaSearchPortletKeys.ALLERTASEARCH,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.configuration-action-class=com.liferay.portal.kernel.portlet.DefaultConfigurationAction"
	},
	service = Portlet.class
)
public class AllertaSearchPortlet extends MVCPortlet {
	
	private volatile SearchPortletConfig configuration;
	
	@Override
    public void doView(RenderRequest renderRequest,
            RenderResponse renderResponse) throws IOException, PortletException {

            renderRequest.setAttribute(
            		SearchPortletConfig.class.getName(),
                    configuration);
            
            String url = PortalUtil.getHttpServletRequest(renderRequest).getRequestURI();
            String searchable = "";
            if (url==null) url = "";
            searchable = "allerta";
            if (url.contains("valang")) searchable = "valanghe";
            if (url.contains("monitoraggi")) searchable = "monitoraggio";
            if (url.contains("briefing")) searchable = "allerta-briefing";
            if (url.contains("post-evento")) searchable = "report-post-evento";
            if (url.contains("verifiche-allerte")) searchable = "verifica-settimanale";

            
            
            renderRequest.setAttribute("searchable", searchable);

            super.doView(renderRequest, renderResponse);
    }
	
	@Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
           
		configuration = ConfigurableUtil.createConfigurable(
				SearchPortletConfig.class, properties);
    }
	
	public String getOggetto() {
		if (configuration==null) return "";
		return configuration.oggetto();
	}
}