package it.eng.allerta.web.rest.application.verifier;

import java.util.Properties;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.AccessControlContext;
import com.liferay.portal.kernel.security.auth.AuthException;
import com.liferay.portal.kernel.security.auth.verifier.AuthVerifier;
import com.liferay.portal.kernel.security.auth.verifier.AuthVerifierResult;
import com.liferay.portal.kernel.security.auth.verifier.AuthVerifierResult.State;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Portal;

@Component(
		immediate = true,
		property= {
				"auth.verifier.AllertaAuthVerifier.urls.includes=*",
				"auth.verifier.AllertaAuthVerifier.urls.excludes=*rubrica*"
		},
		service = AuthVerifier.class
		)
public class AllertaAuthVerifier implements AuthVerifier{

	@Override
	public String getAuthType() {
		// TODO Auto-generated method stub
		return "FORM";
	}

	@Override
	public AuthVerifierResult verify(AccessControlContext accessControlContext, Properties properties)
			throws AuthException {

		AuthVerifierResult result = new AuthVerifierResult();
		long companyId = portal.getDefaultCompanyId();
		
		try {

			User defaultUser = userLocalService.getDefaultUser(companyId);

			result.setState(State.SUCCESS);
			result.setUserId(defaultUser.getUserId());

			accessControlContext.setAuthVerifierResult(result);

		} catch (Exception e) {
		}

		return result;
	}

	@Reference
	private Portal portal;

	@Reference
	private UserLocalService userLocalService;
}
