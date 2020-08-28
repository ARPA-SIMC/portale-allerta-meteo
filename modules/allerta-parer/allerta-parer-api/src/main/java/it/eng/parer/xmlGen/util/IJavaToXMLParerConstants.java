package it.eng.parer.xmlGen.util;

public interface IJavaToXMLParerConstants {
	//PARAMETER REQUEST NAME
	public static final String PAR_VERSIONE = "VERSIONE";
	public static final String PAR_PASSWORD = "PASSWORD";
	public static final String PAR_LOGINNAME = "LOGINNAME";
	public static final String PAR_XMLSIP = "XMLSIP";
	
	
	//DATA FORMATTER
	public static final String FORMATTER_AAAA_MM_DD = "yyyy-MM-dd";
	public static final String FORMATTER_GG_MM_AAAA_HH_MM = "dd-MM-yyyy-HH-mm";

	//INTESTAZIONE CONSTANTS
	public static final String VERSIONE = "1.4";

	//DATI SPECIFICI CONSTANTS
	public static final String VERSIONE_DATI_SPECIFICI = "1.0";	

	public static final String ENTE_REGIONE_EMILIA_ROMAGNA = "regione_emilia-romagna";
	public static final String ENTE_ARPA_ER= "regione_emilia-romagna";//"ARPA_ER";
	public static final String STRUTTURA_ALLERTA_PROTEZIONE_CIVILE = "protezione civile";
	public static final String STRUTTURA_ARPA = "protezione civile"; //arpa

	//INVIO RESPONSABILE TERRITORIALE
	public static final String INVIO_RESP_TERRITORIO_SI= "SI";
	public static final String INVIO_RESP_TERRITORIO_NO= "NO";

	//TIPO REGISTRO
	public static final String TIPO_REGISTRO_BOLLETTINO = "BOLLETTINI";
	public static final String TIPO_REGISTRO_ALLERTA = "ALLERTE";
	public static final String TIPO_REGISTRO_ALLERTA_SMS = "ALLERTA SMS";
	public static final String TIPO_REGISTRO_ALLERTA_MAIL = "ALLERTA MAIL";
	public static final String TIPO_REGISTRO_MONITORAGGIO= "MONITORAGGI";
	public static final String TIPO_REGISTRO_MONITORAGGIO_SMS= "MONITORAGGIO SMS";
	public static final String TIPO_REGISTRO_MONITORAGGIO_MAIL= "MONITORAGGIO MAIL";
	public static final String TIPO_REGISTRO_SUPERAMENTO_MAIL= "SUPERAMENTI MAIL";
	public static final String TIPO_REGISTRO_SUPERAMENTO_SMS= "SUPERAMENTI SMS";

	//TIPOLOGIOA UNITA DOCUMENTARIA
	public static final String TIPOLOGIA_UNITA_DOCUMENTARIA_BOLLETTINO = "BOLLETTINO";
	public static final String TIPOLOGIA_UNITA_DOCUMENTARIA_ALLERTA = "ALLERTA";
	public static final String TIPOLOGIA_UNITA_DOCUMENTARIA_ALLERTA_SMS = "AVVISI SMS";
	public static final String TIPOLOGIA_UNITA_DOCUMENTARIA_ALLERTA_MAIL = "AVVISI MAIL";
	public static final String TIPOLOGIA_UNITA_DOCUMENTARIA_MONITORAGGI = "MONITORAGGIO";
	public static final String TIPOLOGIA_UNITA_DOCUMENTARIA_MONITORAGGI_SMS = "AVVISI SMS";
	public static final String TIPOLOGIA_UNITA_DOCUMENTARIA_MONITORAGGI_MAIL = "AVVISI MAIL";
	public static final String TIPOLOGIA_UNITA_DOCUMENTARIA_SUPERAMENTI_MAIL = "SUPERAMENTO MAIL";
	public static final String TIPOLOGIA_UNITA_DOCUMENTARIA_SUPERAMENTI_SMS = "SUPERAMENTO SMS";

	//DOCUMENTO PRINCIPALE CONSTANTS
	public static final String TIPO_DOCUMENTO_BOLLETTINO = "BOLLETTINO";
	public static final String TIPO_DOCUMENTO_ALLERTA = "ALLERTA";
	public static final String TIPO_DOCUMENTO_ALLERTA_SMS = "AVVISI SMS";
	public static final String TIPO_DOCUMENTO_ALLERTA_MAIL = "AVVISI MAIL";
	public static final String TIPO_DOCUMENTO_MONITORAGGIO = "MONITORAGGIO";
	public static final String TIPO_DOCUMENTO_MONITORAGGIO_MAIL = "AVVISI MAIL";
	public static final String TIPO_DOCUMENTO_MONITORAGGIO_SMS = "AVVISI SMS";
	public static final String TIPO_DOCUMENTO_SUPERAMENTO_MAIL = "SUPERAMENTO MAIL";
	public static final String TIPO_DOCUMENTO_SUPERAMENTO_SMS = "SUPERAMENTO SMS";

	//STRUTTURA CONSTANTS
	public static final String TIPO_STRUTTURA = "DocumentoGenerico";

	//COMPONENTE CONSTANTS
	public static final String ID_COMPONENTE = "ID1";
	public static final int ORDINE_PRESENTAZIONE = 1;
	public static final String TIPO_COMPENENTE = "Contenuto";
	public static final String TIPO_SUPPORTO_COMPONENTE= "FILE";

	//DESCRIZIONE COLLEGAMENTO
	public static final String DESCR_COLLEGAMENTO_ALLERTA_MAIL = "Allerta trasmessa con invio MAIL";
	public static final String DESCR_COLLEGAMENTO_ALLERTA_SMS = "Allerta trasmessa con invio SMS";
	public static final String DESCR_COLLEGAMENTO_MONITORAGGIO_SMS = "Monitoraggio trasmesso con invio SMS";
	public static final String DESCR_COLLEGAMENTO_MONITORAGGIO_MAIL = "Monitoraggio trasmesso con invio MAIL";
	public static final String DESCR_COLLEGAMENTO_SUPERAMENTO = "Avvisi riferiti al medesimo superamento trasmessi con diverso mezzo (invio mail o sms)";

	//TIPO FILE
	public static final String TIPO_FILE_PDF = "PDF";
	public static final String TIPO_FILE_CSV = "CSV";
	//CHARSET
	public static final String CHARSET = "UTF-8";

	//ESITO INVIO
	public static final String ESITO_INVIO_KO = "KO";
	public static final String ESITO_INVIO_OK = "OK";
	public static final String ESITO_INVIO_IN_INVIO = "IN";
	public static final String ESITO_INVIO_RE_INVIO = "RI";

	//TIPO COMUNICAZIONE
	public static final String TIPO_COMUNICAZIONE_ALLERTA = "Allerta";
	public static final String TIPO_COMUNICAZIONE_MONITORAGGIO = "Monitoraggio";
	public static final String TIPO_COMUNICAZIONE_SUPERAMENTO = "Superamento";
}
