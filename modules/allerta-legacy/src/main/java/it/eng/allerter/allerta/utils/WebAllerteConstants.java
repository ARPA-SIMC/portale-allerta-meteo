package it.eng.allerter.allerta.utils;

public enum WebAllerteConstants {
	// VAriabile utilizzata nella parte di inizializzazione 
	SITE_NAME("weballerte (Staging)"),
	WEB_ALLERTE_SITE_ID("20181"),
	// Variabili utilizzate nella registrazione 
    LIFERAY_ITALIA_CODE("8"),
//    LIFERAY_CLASS_CONTACT_CLASS_NAME("com.liferay.portal.kernel.model.Contact"),
//    LIFERAY_CLASS_PHONE_CLASS_NAME("com.liferay.portal.kernel.model.Contact.phone"),
//    LIFERAY_CLASS_ADDRESS_CLASS_NAME("com.liferay.portal.kernel.model.Contact.address"),  
    CITTADINO_JOB_TITLE ("cittadino"),
    SINDACO_JOB_TITLE ("sindaco"),
    TECNICO_JOB_TITLE ("tecnico"),
    DELEGATO_SINDACO_JOB_TITLE ("delegato"),
    ADDRESS_TYPE_PERSONALE ("personal"),
    ADDRESS_TYPE_BILLING   ("other"),
    CITTADINO_ROLE("CITTADINO"),
    CITTADINO_GROUP("CITTADINO"),
    // variabili utilizzate nelle notifiche della registrazuibe 
    MAIL_REGISTRATION_SUBJECT("Richiesta di approvazione utente"),
    MAIL_SENDER("newsubmit@weballerter.it"),
    // variabili utilizzae per instradare la registrazione
    REGISTRATION_TYPE			 		("registration-type"),
	REGISTRATION_TYPE_CITTADINO  		("registration-cittadino-send"),
	REGISTRATION_TYPE_SINDACO 	 		("registration-sindaco-send"),
	REGISTRATION_TYPE_TECNICO 	 		("registration-tecnico-send"),
	REGISTRATION_TYPE_DELEGATO_SINDACO 	("registration-delegato-send"),
	// NOMI DEI RUOLI REGOLARI ( OVVERO DI PORTALE)
	ROLE_REGULAR_SINDACO("SINDACO"),
	ROLE_REGULAR_CITTADINO("CITTADINO"),
	ROLE_REGULAR_TECNICO("TECNICO"),
	ROLE_REGULAR_DELEGATO_SINDACO_PARZIALE("DELEGATO POTERI PARZIALI SITE"),
	ROLE_REGULAR_DELEGATO_SINDACO_TOTALE("DELEGATO SINDACO"),
	
	// NOMI DEI RUOLI SI SITO 
	ROLE_SPECIFIC_SITE_SINDACO("SINDACO SITE"),
	ROLE_SPECIFIC_SITE_DELEGATO_SINDACO_PARZIALE("DELEGATO POTERI PARZIALI"),
	ROLE_SPECIFIC_SITE_DELEGATO_SINDACO_TOTALE("DELEGATO SINDACO SITE"),
	ROLE_SPECIFIC_SITE_TECNICO("TECNICO SITE"),
	
	
	// CODICE ANAGRAFE PROVICE EMILIA 
	code_bologna("BO"),
	code_ferrara("FE"),
	code_forli_cesena("FC"),
	code_modena("MO"),
	code_parma("PR"),
	code_piacenza("PC"),
	code_ravenna("RA"),
	code_reggio_emilia("RE"),
	code_rimini("RN"),
	// Variabili passate al wf 
	WF_PARAM_APPROVER("weballerteApprover"),
	WF_PARAM_MAIL_USER("weballerteUserMail");
    
	
    private final String text;
   
    private WebAllerteConstants(final String text) {
        this.text = text;
    }
  
    @Override
    public String toString() {
        return text;
    }
    
    
}