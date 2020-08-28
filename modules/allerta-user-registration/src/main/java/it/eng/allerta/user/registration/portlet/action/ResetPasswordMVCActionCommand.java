package it.eng.allerta.user.registration.portlet.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.UserActiveException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import it.eng.allerta.utils.AllertaKeys;

@Component(
		immediate = true, 
		property = { 
				"javax.portlet.name=" + AllertaKeys.AllertaUserRegistration,
				"mvc.command.name=/allerta/reset-password" 
		}, 
		service = MVCActionCommand.class
		)
public class ResetPasswordMVCActionCommand extends BaseMVCActionCommand {
	
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		try {

			CaptchaUtil.check(actionRequest);
			
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			Company company = themeDisplay.getCompany();

			if (!company.isSendPassword() && !company.isSendPasswordResetLink()) {
					throw new PrincipalException.MustBeEnabled(
						company.getCompanyId(),
						PropsKeys.COMPANY_SECURITY_SEND_PASSWORD,
						PropsKeys.COMPANY_SECURITY_SEND_PASSWORD_RESET_LINK);
			}

			sendPassword(actionRequest, actionResponse);
			
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			SessionErrors.add(actionRequest, e.getClass());
			actionResponse.getRenderParameters().setValue("jspPage", "/forgot-password.jsp");
			throw e;
		}

	}
	
	protected User getUser(ActionRequest actionRequest) throws Exception {
		
		PortletSession portletSession = actionRequest.getPortletSession();

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String sessionEmailAddress = (String)portletSession.getAttribute(
			WebKeys.FORGOT_PASSWORD_REMINDER_USER_EMAIL_ADDRESS);

		User user = null;

		if (Validator.isNotNull(sessionEmailAddress)) {
			user = _userLocalService.getUserByEmailAddress(
				themeDisplay.getCompanyId(), sessionEmailAddress);
		}
		else {
			long userId = ParamUtil.getLong(actionRequest, "userId");
			String screenName = ParamUtil.getString(
				actionRequest, "screenName");
			String emailAddress = ParamUtil.getString(
				actionRequest, "emailAddress");

			if (Validator.isNotNull(emailAddress)) {
				user = _userLocalService.getUserByEmailAddress(
					themeDisplay.getCompanyId(), emailAddress);
			}
			else if (Validator.isNotNull(screenName)) {
				user = _userLocalService.getUserByScreenName(
					themeDisplay.getCompanyId(), screenName);
			}
			else if (userId > 0) {
				user = _userLocalService.getUserById(userId);
			}
			else {
				throw new NoSuchUserException("User does not exist");
			}
		}

		if (!user.isActive()) {
			throw new UserActiveException("Inactive user " + user.getUuid());
		}

		_userLocalService.checkLockout(user);

		return user;
	}

	
	protected void sendPassword(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		Company company = themeDisplay.getCompany();

		User user = getUser(actionRequest);

		String emailToAddress = user.getEmailAddress();

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				User.class.getName(), actionRequest);

			UserLocalServiceUtil.sendPassword(
				company.getCompanyId(), emailToAddress, null, null, null,
				null, serviceContext);

		HttpServletRequest httpServletRequest = _portal.getHttpServletRequest(
			actionRequest);

		SessionMessages.add(httpServletRequest, "forgotPasswordSent");

		sendRedirect(actionRequest, actionResponse, null);
	}
	
	
	@Reference
	private UserLocalService _userLocalService;

	@Reference
	private Portal _portal;

	private Log logger = LogFactoryUtil.getLog(ResetPasswordMVCActionCommand.class);

}
