package it.eng.allerta.user.registration.portlet.action;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import it.eng.allerta.configuration.AllertaBaseConfiguration;
import it.eng.allerta.user.registration.service.AllertaUserRegistrationService;
import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerta.utils.AllertaTracker;
import it.eng.allerter.allerta.utils.WebAllerteConstants;

@Component(
		immediate = true, 
		property = { 
				"javax.portlet.name=" + AllertaKeys.AllertaUserRegistration,
				"mvc.command.name=/allerta/user-save" }, 
		service = MVCActionCommand.class
		)
public class SaveRegistrazioneMVCActionCommand extends BaseMVCActionCommand {

//	private boolean recaptchaCheck(long companyId, String response) {
//		
//		
//		try {
//			AllertaBaseConfiguration allertaBaseConfiguration = 
//					AllertaTracker.getAllertaBaseConfiguration(companyId);
//		
//			String secret = allertaBaseConfiguration.reCaptchaSecret();
//			
//			String data  = "secret="+secret;
//			data += "&response="+response;
//			
//			String checkUrl = "https://www.google.com/recaptcha/api/siteverify";
//			
//			URL url = new URL(checkUrl);
//			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//			urlConnection.setRequestMethod("POST");
//			urlConnection.setDoOutput(true);
//			DataOutputStream dos = new DataOutputStream(urlConnection.getOutputStream());
//			dos.write(data.getBytes());
//			dos.flush();
//			dos.close();
//			
//			InputStream is = urlConnection.getInputStream();
//			ByteArrayOutputStream baos = new ByteArrayOutputStream();
//			StreamUtil.transfer(is, baos);
//			
//			JSONObject json = JSONFactoryUtil.createJSONObject(baos.toString());
//			
//			return json.getBoolean("success");
//			
//		} catch (Exception e) {
//			logger.error(e);
//		}
//		
//		return false;
//	}
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long companyId = themeDisplay.getCompanyId();
			
			CaptchaUtil.check(actionRequest);
			
//			String recaptchaResponse = ParamUtil.getString(actionRequest, "g-response");
//			
//			if (Validator.isNotNull(recaptchaResponse)) {
//				
//				boolean check = recaptchaCheck(companyId, recaptchaResponse);
//				if (!check) {
//					throw new PortalException("BAD Recaptcha");
//				}
//				
//			}
			
			long creatorUserId = themeDisplay.getUserId();
			
			DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat("yyyy-MM-dd");
			
			String emailAddress = ParamUtil.getString(actionRequest, "email");
			String screenName = ParamUtil.getString(actionRequest, "username");
			String firstName = ParamUtil.getString(actionRequest, "nome");
			String lastName = ParamUtil.getString(actionRequest, "cognome");
			String telefono = ParamUtil.getString(actionRequest, "telefono");
			
			Date dataNascita = ParamUtil.getDate(actionRequest, "dataNascita", dateFormat);
			
			ServiceContext serviceContext  = ServiceContextFactory.getInstance(User.class.getName(), 
					actionRequest);
			serviceContext.setAttribute(
					WebAllerteConstants.WF_PARAM_MAIL_USER.toString(), emailAddress);
		
			allertaUserRegistrationService.registerUser(creatorUserId, companyId,
					themeDisplay.getScopeGroupId(), emailAddress, 
					firstName, lastName, screenName, dataNascita, telefono, serviceContext);
			
			
		} catch (Exception e) {
			logger.error(e);
			SessionErrors.add(actionRequest, e.getClass());
			actionResponse.getRenderParameters().setValue("jspPage", "/registrazione.jsp");
			throw e;
		}

	}
	
		
	@Reference
	private AllertaUserRegistrationService allertaUserRegistrationService;	

	private Log logger = LogFactoryUtil.getLog(SaveRegistrazioneMVCActionCommand.class);

}
