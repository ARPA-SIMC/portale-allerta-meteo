package it.eng.allerta.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(
		category = "allerta-meteo",
	    scope = ExtendedObjectClassDefinition.Scope.COMPANY
	)
@Meta.OCD(
		id = AllertaSMSConfiguration.Id,
		localization = "content/Language",
	    name = "allerta-sms-name"
		)
public interface AllertaSMSConfiguration {
	
	public static final String Id = "it.eng.allerta.configuration.AllertaSMSConfiguration";

	@Meta.AD(
			name = "sms-username",
			deflt = "AllertaMeteo2019",
			required = false
			)
	public String username();
	
	@Meta.AD(
			name = "sms-password",
			deflt = "Meteo-TIM-2019",
			required = false
			)
	public String password();
	
	@Meta.AD(
			name = "sms-token",
			deflt = "249060EE1B4E52A3A33DC55840A8848418047584",
			required = false
			)
	public String token();
	
	@Meta.AD(
			name = "sms-alias",
			deflt = "AllerteER",
			required = false
			)
	public String alias();
	
	@Meta.AD(
			name = "url-servizio",
			deflt = "https://smartconsole.telecomitalia.it/ssc2-api/rest/",
			required = false
			)
	public String urlServizio();

}
