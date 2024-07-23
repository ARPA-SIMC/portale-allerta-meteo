package it.eng.allerta.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import com.liferay.portal.kernel.util.DateFormatFactoryUtil;

public class AllertaKeys {  
	
	public static final String AllertaCategory = "Allerta-Meteo";
	public static final String AllertaValangheCategory = "Allerta-Valanghe";

	
	public static final String AllertaUserRegistration = "AllertaUserRegistration";
	public static final String AllertaLogin = "AllertaLogin";
	public static final String AllertaHeaderPortlet = "AllertaHeaderPortlet";	
	public static final String AllertaBreadcrumbsPortlet = "AllertaBreadcrumbsPortlet";	
	public static final String AllertaHomePortlet = "AllertaHomePortlet";
	public static final String AllertaPrevisioniPortlet = "AllertaPrevisioniPortlet";
	public static final String AllertaCompilaMonitoraggioPortlet = "AllertaCompilaMonitoraggioPortlet";
	public static final String AllertaPreferenzeMonitoraggioPortlet = "AllertaPreferenzeMonitoraggioPortlet";
	public static final String AllertaGestioneMonitoraggioPortlet = "AllertaGestioneMonitoraggioPortlet";
	public static final String AllertaConfigurazioneSensoriPortlet = "AllertaConfigurazioneSensoriPortlet";
	public static final String AllertaConfigurazioneAllarmiPortlet = "AllertaConfigurazioneAllarmiPortlet";
	public static final String AllertaPrevisioniTerritorioPortlet = "AllertaPrevisioniTerritorioPortlet";
	public static final String AllertaPrevisioniTendenzaPortlet = "AllertaPrevisioniTendenzaPortlet";
	public static final String AllertaPrevisioniMedioTerminePortlet = "AllertaPrevisioniMedioTerminePortlet";
	public static final String AllertaAnimazioneMeteoPortlet = "AllertaAnimazioneMeteoPortlet";
	public static final String AllertaAnimazioneMarePioggaPortlet = "AllertaAnimazioneMarePioggaPortlet";
	public static final String AllertaAnimazioneOceanoPortlet = "AllertaAnimazioneOceanoPortlet";
	public static final String AllertaAnimazioneRadarPortlet = "AllertaAnimazioneRadarPortlet";
	public static final String AllertaAnimazionePressionePortlet = "AllertaAnimazionePressionePortlet";
	public static final String AllertaAnimazioneUmiditaPortlet = "AllertaAnimazioneUmiditaPortlet";
	public static final String AllertaAnimazioneVentoPortlet = "AllertaAnimazioneVentoPortlet";
	public static final String AllertaGraficoPortlet = "AllertaGraficoPortlet";
	public static final String AllertaAnimazioneIdrometricoPortlet = "AllertaAnimazioneIdrometricoPortlet";
	public static final String AllertaAnimazionePrecipitazioniPortlet = "AllertaAnimazionePrecipitazioniPortlet";
	public static final String AllertaAnimazioneTemperaturaPortlet = "AllertaAnimazioneTemperaturaPortlet";
	public static final String AllertaAnimazioneCumulata48Portlet = "AllertaAnimazioneCumulata48Portlet";
	public static final String AllertaNowcastingPortlet = "AllertaNowcastingPortlet";
	public static final String AllertaContentRender = "AllertaContentRender";
	public static final String AllertaAnimazioneCumulata6Portlet = "AllertaAnimazioneCumulata6Portlet";
	public static final String AllertaCompilaSbPortlet = "AllertaCompilaSbPortlet";
	public static final String AllertaValangheCompilaSbPortlet = "AllertaValangheCompilaSbPortlet";
	public static final String AllertaStrumentiPortlet = "AllertaStrumentiPortlet";
	public static final String BollettinoCompilaSbWebPortlet = "BollettinoCompilaSbWebPortlet";
	public static final String AllertaLeftMenuPortlet = "AllertaLeftMenuPortlet";
	public static final String AllertaLuoghiPreferitiPortlet = "AllertaLuoghiPreferitiPortlet";
	public static final String AllertaAllerteBollettiniPortlet = "AllertaAllerteBollettiniPortlet";
	public static final String AllertaAllerteMonitoraggioPortlet = "AllertaAllerteMonitoraggioPortlet";
	public static final String AllertaReportPostEventoPortlet = "AllertaReportPostEventoPortlet";
	public static final String AllertaSocialPortlet = "AllertaSocialPortlet";
	public static final String AllertaMessaggioSindacoPortlet = "AllertaMessaggioSindacoPortlet";
	public static final String AllertaComunePortlet = "AllertaComunePortlet";
	public static final String AllertaDocumentiComunePortlet = "AllertaDocumentiComunePortlet";
	public static final String AllertaCartografiaComunePortlet = "AllertaCartografiaComunePortlet";
	public static final String AllertaStrumentiSindacoPortlet = "AllertaStrumentiSindacoPortlet";
	public static final String AllertaComunePrevisioneEDatiPortlet = "AllertaComunePrevisioneEDatiPortlet";
	public static final String AllertaStrumentiComunePortlet = "AllertaStrumentiComunePortlet";
	public static final String AllertaComuneHeadPortlet = "AllertaComuneHeadPortlet";
	public static final String AllertaGraficoSMSPortlet = "AllertaGraficoSMSPortlet";
	public static final String AllertaServiceSmsWebPortlet = "AllertaServiceSmsWebPortlet";
	public static final String AllertaServiceConsolePortlet = "AllertaServiceConsolePortlet";
	public static final String AllertaElencoSmsPortlet = "AllertaElencoSmsPortlet";
	public static final String AllertaElencoEventiPortlet = "AllertaElencoEventiPortlet";
	public static final String AllertaDettagliEventiPortlet = "AllertaDettagliEventiPortlet";
	
	public static final String AllertaCruscottoPortlet = "AllertaCruscottoPortlet";
	
	public static final String RequestAllertaBean = "RequestAllertaBean";
	public static final String RequestAllertaValangheBean = "RequestAllertaValangheBean";
	public static final String RequestBollettinoBean = "RequestBollettinoBean";
	
	public static final String SessionMessaggioBean = "SessionMessaggioBean";
	
		
	public static final DateFormat TimeFormat = new SimpleDateFormat("HH:mm",Locale.ITALY);
	public static final DateFormat WebDateFormat = DateFormatFactoryUtil.getSimpleDateFormat("dd/MM/yyyy");
	public static final DateFormat WebDateTimeFormat = DateFormatFactoryUtil.getSimpleDateFormat("dd/MM/yyyy HH:mm");
	
	
	public static final String AllertaParentFolderParamKey = "ALLERTA_PARENT_FOLDER_ID";
	public static final String BollettinoParentFolderParamKey = "BOLLETTINO_PARENT_FOLDER_ID";
	
	public static final String AllertaValangheParentFolderParamKey = "ALLERTAVALANGHE_PARENT_FOLDER_ID";
	public static final String BollettinoValangheParentFolderParamKey = "BOLLETTINOVALANGHE_PARENT_FOLDER_ID";

	
}
