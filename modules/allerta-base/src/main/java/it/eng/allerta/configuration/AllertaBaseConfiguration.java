package it.eng.allerta.configuration;


import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(
		category = "allerta-meteo",
	    scope = ExtendedObjectClassDefinition.Scope.COMPANY
	)
@Meta.OCD(
		id = AllertaBaseConfiguration.Id,
		localization = "content/Language"		
		)
public interface AllertaBaseConfiguration {

	public static final String Id = "it.eng.allerta.configuration.AllertaBaseConfiguration";
	
	@Meta.AD(
			name = "enable-test-mode",
			deflt = "false",
			required = false
			)
	public boolean enableTestMode();
	
	@Meta.AD(
			name = "disable-telegram",
			deflt = "true",
			required = false
			)
	public boolean disableTelegram();
	
	@Meta.AD(
			name = "disable-sms",
			deflt = "true",
			required = false
			)
	public boolean disableSms();
	
	@Meta.AD(
			name = "mail-test",
			deflt = "",
			required = false
			)
	public String mailTest();
	
	@Meta.AD(
			name = "disable-parer",
			deflt = "true",
			required = false
			)
	public boolean disableParer();
	
	
	@Meta.AD(
			name = "recaptcha-key",
			deflt = "",
			required = false
			)
	public String reCaptchaKey();
	
	
	@Meta.AD(
			name = "recaptcha-secret",
			deflt = "",
			required = false
			)
	public String reCaptchaSecret();
	
	
	@Meta.AD(
			name = "email-notification-user-enable",
			deflt = "",
			required = false
			)
	public String emailNotificationUserEnable();
	
	@Meta.AD(
			name = "disable-rtdata",
			deflt = "false",
			required = false
			)
	public boolean disableRtData();
}
