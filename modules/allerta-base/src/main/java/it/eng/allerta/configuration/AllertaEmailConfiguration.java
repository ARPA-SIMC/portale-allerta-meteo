package it.eng.allerta.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(
		category = "allerta-meteo",
	    scope = ExtendedObjectClassDefinition.Scope.COMPANY
	)
@Meta.OCD(
		id = AllertaEmailConfiguration.Id,
		localization = "content/Language",
	    name = "allerta-email-name"
		)
public interface AllertaEmailConfiguration {
	
	public static final String Id = "it.eng.allerta.configuration.AllertaEmailConfiguration";

	@Meta.AD(
			name = "indirizzo-notifiche-invio",
			deflt = "",
			required = false
			)
	public String indirizzoNotificheInvio();
	
	@Meta.AD(
			name = "indirizzo-notifiche-lettura",
			deflt = "",
			required = false
			)
	public String indirizzoNotificheLettura();
}
