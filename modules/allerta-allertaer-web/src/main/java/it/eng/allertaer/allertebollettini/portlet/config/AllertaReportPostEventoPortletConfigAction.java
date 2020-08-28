package it.eng.allertaer.allertebollettini.portlet.config;

import java.util.Map;

import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;

import aQute.bnd.annotation.metatype.Configurable;
import it.eng.allerta.utils.AllertaKeys;

@Component(
		configurationPid = "it.eng.allertaer.allertebollettini.portlet.configuration.ReportPostEvento", 
		configurationPolicy = ConfigurationPolicy.OPTIONAL, 
		immediate = true, 
		property = {
				"javax.portlet.name=" + AllertaKeys.AllertaReportPostEventoPortlet
		}, 
service = ConfigurationAction.class)
public class AllertaReportPostEventoPortletConfigAction extends DefaultConfigurationAction {
	
	@Override
    public String getJspPath(HttpServletRequest request) {
        return "/reports_config.jsp";
    }
	
	@Override
    public void include(PortletConfig portletConfig, 
    					HttpServletRequest httpServletRequest, 
    					HttpServletResponse httpServletResponse) throws Exception {

        httpServletRequest.setAttribute(ReportPostEventoConfiguration.class.getName(), _myConfiguration);

        super.include(portletConfig, httpServletRequest, httpServletResponse);
    }	
	
	@Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
        _myConfiguration= Configurable.createConfigurable(ReportPostEventoConfiguration.class, properties);
    }
	
	private volatile ReportPostEventoConfiguration _myConfiguration;

}
