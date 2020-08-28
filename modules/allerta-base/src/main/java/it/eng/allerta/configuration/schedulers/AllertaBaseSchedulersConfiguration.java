package it.eng.allerta.configuration.schedulers;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(
		category = "allerta-meteo",
		scope = ExtendedObjectClassDefinition.Scope.COMPANY
)

@Meta.OCD(
		id = AllertaBaseSchedulersConfiguration.Id,
		localization = "content/Language",
		name = "allerta-schedulers-service-configuration-name"
	)
public interface AllertaBaseSchedulersConfiguration {
	
	public static final String Id = "it.eng.allerta.configuration.schedulers.AllertaBaseSchedulersConfiguration";
	
	@Meta.AD(
			name = "scheduler-bollettino-minutes",
			deflt = "5",
			required = false
			)
	public int schedulerBollettinoMinutes();
	
	@Meta.AD(
			name = "scheduler-rtimages-minutes",
			deflt = "5",
			required = false
			)
	public int schedulerRTImagesMinutes();

	@Meta.AD(
			name = "scheduler-caricaDBTask-minutes",
			deflt = "5",
			required = false
			)
	public int schedulerCaricaDBTaskMinutes();
	
	@Meta.AD(
			name = "scheduler-reportGenertor-minutes",
			deflt = "5",
			required = false
			)
	public int schedulerReportGeneratorMinutes();
	
	@Meta.AD(
			name = "scheduler-cumulative-minutes",
			deflt = "5",
			required = false
			)
	public int schedulerCumulativeMinutes();
	
	@Meta.AD(
			name = "scheduler-animeteo-minutes",
			deflt = "5",
			required = false
			)
	public int schedulerAnimeteoMinutes();
	
	@Meta.AD(
			name = "scheduler-parer-minutes",
			deflt = "15",
			required = false
			)
	public int schedulerParerMinutes();
	
	@Meta.AD(
			name = "scheduler-ondaAlt-minutes",
			deflt = "60",
			required = false
			)
	public int schedulerOndaAltMinutes();
}
