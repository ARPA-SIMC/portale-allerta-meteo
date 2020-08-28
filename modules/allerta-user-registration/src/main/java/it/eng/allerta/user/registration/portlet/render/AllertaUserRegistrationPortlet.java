package it.eng.allerta.user.registration.portlet.render;

import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import it.eng.allerta.utils.AllertaKeys;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author CPPNDR74H
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=" + AllertaKeys.AllertaCategory,
		"com.liferay.portlet.use-default-template=true",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Login e Registrazione", 
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/login.jsp",
		"javax.portlet.name=" + AllertaKeys.AllertaUserRegistration,
		"javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"		
	},
	service = Portlet.class
)
public class AllertaUserRegistrationPortlet extends MVCPortlet {
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		
		try {
			CaptchaUtil.serveImage(resourceRequest, resourceResponse);

		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	private Log _log = LogFactoryUtil.getLog(AllertaUserRegistrationPortlet.class);
}