package allerta.search.portlet;

import allerta.search.constants.AllertaSearchPortletKeys;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

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
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CommandPortlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/command.jsp",
		"javax.portlet.name=" + AllertaSearchPortletKeys.COMMAND,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CommandLinePortlet extends MVCPortlet {
	
	private volatile SearchPortletConfig configuration;
	
	@Override
    public void doView(RenderRequest renderRequest,
            RenderResponse renderResponse) throws IOException, PortletException {

            super.doView(renderRequest, renderResponse);
    }
	
	@Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {

    }

}