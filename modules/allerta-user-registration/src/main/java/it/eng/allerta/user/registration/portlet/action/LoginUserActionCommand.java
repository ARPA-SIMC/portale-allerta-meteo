package it.eng.allerta.user.registration.portlet.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.session.AuthenticatedSessionManager;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.struts.LastPath;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;

import it.eng.allerta.utils.AllertaKeys;

@Component(
		immediate = true,
		property = { 
				"javax.portlet.name=" + AllertaKeys.AllertaUserRegistration,
				"javax.portlet.name=" + AllertaKeys.AllertaLogin,
				"mvc.command.name=/allerta/user-login" 
		}, 
		service = MVCActionCommand.class
)

public class LoginUserActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		String path = PropsUtil.get(PropsKeys.DEFAULT_LANDING_PAGE_PATH);
		
		String redirectTo = ParamUtil.getString(actionRequest, "redirectTo");
		
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		
		HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
					
		boolean authenticated = false;
		
		try {
			
			System.out.println("LOGINNNNN!!!!!!!!!!!!!");
		
			//ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			String username = ParamUtil.getString(actionRequest, "userName");
			String password = ParamUtil.getString(actionRequest, "password");
			Boolean ricordami = ParamUtil.getBoolean(actionRequest, "ricordami");
				
			HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);
			
			String authType = CompanyConstants.AUTH_TYPE_SN;
			
			authenticatedSessionManager.login(request, response, username, password, ricordami, authType);
			
			authenticated = true;
			
		} catch(Exception e) {

			SessionErrors.add(actionRequest, e.getClass());
		
		}
		
		if( authenticated) {
		
			if (Validator.isNotNull(redirectTo)) {
				
				LastPath lastPath = ((LastPath)  request.getSession().getAttribute(redirectTo));
				actionResponse.sendRedirect(lastPath.getContextPath() + lastPath.getPath());
				
			} if( Validator.isNotNull(redirect)) 
				actionResponse.sendRedirect(redirect);
			
			else if (Validator.isNotNull(path)) {
				actionResponse.sendRedirect(path);
			} else actionResponse.sendRedirect("/");
		}

	}
	
	@Reference
	private AuthenticatedSessionManager authenticatedSessionManager;

}
