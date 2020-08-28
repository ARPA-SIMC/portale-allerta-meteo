package it.eng.allerta.configuration;


import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(
		category = "allerta-meteo",
	    scope = ExtendedObjectClassDefinition.Scope.COMPANY
	)
@Meta.OCD(
		id = DocumentazioneConfiguration.Id,
		localization = "content/Language",
		name = "documentazione-name"
		)
public interface DocumentazioneConfiguration {

	public static final String Id = "it.eng.allerta.configuration.DocumentazioneConfiguration";
	
	@Meta.AD(
			name = "link-guida-mappa",
			deflt = "https://allertameteo.regione.emilia-romagna.it/documents/20181/1138904/Guida+mappa_allerta.pdf",
			required = false
			)
	public String linkGuidaMappa();
	
	@Meta.AD(
			name = "link-guida-monitoraggio",
			deflt = "https://allertameteo.regione.emilia-romagna.it/documents/20181/1138904/Guida+mappa_monitoraggio.pdf",
			required = false
			)
	public String linkGuidaMonitoraggio();
	
	@Meta.AD(
			name = "link-piene-fiumi",
			deflt = "https://allertameteo.regione.emilia-romagna.it/documents/20181/1138904/Tabella_Scenari_Criticit%C3%A0_Idraulica.pdf/88f9c6f4-357f-48c6-a935-3eb1bd9c214f",
			required = false
			)
	public String linkPieneFiumi();
	
	@Meta.AD(
			name = "link-frane",
			deflt = "https://allertameteo.regione.emilia-romagna.it/documents/20181/1138904/Tabella_Scenari_Criticit%C3%A0_Idrogeologica.pdf/666ee168-bfcb-4c4a-a0a6-979485807bf4",
			required = false
			)
	public String linkFrane();
	
	@Meta.AD(
			name = "link-temporali",
			deflt = "https://allertameteo.regione.emilia-romagna.it/documents/20181/1138904/Tabella_Scenari_Criticit%C3%A0_Temporali.pdf/fd96a895-df83-4908-b2d2-273fd2f8f729",
			required = false
			)
	public String linkTemporali();
	
	@Meta.AD(
			name = "link-vento",
			deflt = "https://allertameteo.regione.emilia-romagna.it/documents/20181/1138904/Tabella_Scenari_Vento.pdf",
			required = false
			)
	public String linkVento();
	
	@Meta.AD(
			name = "link-neve",
			deflt = "https://allertameteo.regione.emilia-romagna.it/documents/20181/1138904/Tabella_Scenari_Neve.pdf",
			required = false
			)
	public String linkNeve();
	
	@Meta.AD(
			name = "link-pioggia-gela",
			deflt = "https://allertameteo.regione.emilia-romagna.it/documents/20181/1138904/Tabella_Scenari_Pioggia_che_gela.pdf",
			required = false
			)
	public String linkPioggiaGela();
	
	@Meta.AD(
			name = "link-temperature",
			deflt = "https://allertameteo.regione.emilia-romagna.it/documents/20181/1138904/Tabella_Scenari_Temperature_Estreme.pdf",
			required = false
			)
	public String linkTemperature();
	
	
	@Meta.AD(
			name = "link-stato-mare",
			deflt = "https://allertameteo.regione.emilia-romagna.it/documents/20181/1138904/Tabella_Scenari_Stato_del_mare.pdf",
			required = false
			)
	public String linkStatoMare();
	
	@Meta.AD(
			name = "link-mareggiate",
			deflt = "https://allertameteo.regione.emilia-romagna.it/documents/20181/1138904/Tabella_Scenari_Criticit%C3%A0_Costiera.pdf/d4aa483b-8618-4c53-a58a-241d61727ab0",
			required = false
			)
	public String linkMareggiate();
	
	@Meta.AD(
			name = "link-valanghe",
			deflt = "https://allertameteo.regione.emilia-romagna.it/documents/20181/1138904/Tabella_Scenari_Valanghe.pdf",
			required = false
			)
	public String linkValanghe();
	
	@Meta.AD(
			name = "link-lettura-precipitazioni",
			deflt = "https://allertameteo.regione.emilia-romagna.it/documents/20181/1138904/Guida+mappa_precipitazioni.pdf",
			required = false
			)
	public String linkLetturaPrecipitazioni();
	
	@Meta.AD(
			name = "link-lettura-idro",
			deflt = "https://allertameteo.regione.emilia-romagna.it/documents/20181/1138904/Guida+mappa_liv_idrometrici.pdf",
			required = false
			)
	public String linkLetturaIdro();
	
	@Meta.AD(
			name = "link-lettura-temperature",
			deflt = "https://allertameteo.regione.emilia-romagna.it/documents/20181/1138904/Guida+mappa_temperature.pdf",
			required = false
			)
	public String linkLetturaTemperature();
	
	@Meta.AD(
			name = "link-lettura-vento",
			deflt = "https://allertameteo.regione.emilia-romagna.it/documents/20181/1138904/Guida+mappa_vento.pdf",
			required = false
			)
	public String linkLetturaVento();
	
	@Meta.AD(
			name = "link-lettura-umidita",
			deflt = "https://allertameteo.regione.emilia-romagna.it/documents/20181/1138904/Guida+mappa_umidita.pdf",
			required = false
			)
	public String linkLetturaUmidita();
	
	@Meta.AD(
			name = "link-lettura-pressione",
			deflt = "https://allertameteo.regione.emilia-romagna.it/documents/20181/1138904/Guida+mappa_pressione.pdf",
			required = false
			)
	public String linkLetturaPressione();
	
	@Meta.AD(
			name = "link-lettura-radar",
			deflt = "https://allertameteo.regione.emilia-romagna.it/documents/20181/1138904/Guida+mappa_radar.pdf",
			required = false
			)
	public String linkLetturaRadar();
	
}
