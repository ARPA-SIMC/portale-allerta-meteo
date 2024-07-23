package it.eng.parer.xmlGen.util;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.StringEscapeUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.eng.parer.model.ComponentiInvio;
import it.eng.parer.model.DatiSpecificiInvio;
import it.eng.parer.model.DocumentiCollegati;
import it.eng.parer.xmlGen.allerta.DatiSpecificiTypeAllerta;
import it.eng.parer.xmlGen.allerta.bollettino.DatiSpecificiTypeBollettino;
import it.eng.parer.xmlGen.allerta.mail.DatiSpecificiTypeMail;
import it.eng.parer.xmlGen.allerta.mail.ObjectFactory;
import it.eng.parer.xmlGen.allerta.sms.DatiSpecificiTypeSms;
import it.eng.parer.xmlGen.monitoraggio.DatiSpecificiTypeMonitoraggio;
import it.eng.parer.xmlGen.monitoraggio.mail.DatiSpecificiTypeMonitoraggioMail;
import it.eng.parer.xmlGen.monitoraggio.sms.DatiSpecificiTypeMonitoraggioSms;
import it.eng.parer.xmlGen.serviziVersamento.wsRequestUnico.ChiaveType;
import it.eng.parer.xmlGen.serviziVersamento.wsRequestUnico.ComponenteType;
import it.eng.parer.xmlGen.serviziVersamento.wsRequestUnico.ConfigType;
import it.eng.parer.xmlGen.serviziVersamento.wsRequestUnico.DocumentoCollegatoType;
import it.eng.parer.xmlGen.serviziVersamento.wsRequestUnico.DocumentoCollegatoType.DocumentoCollegato;
import it.eng.parer.xmlGen.serviziVersamento.wsRequestUnico.DocumentoType;
import it.eng.parer.xmlGen.serviziVersamento.wsRequestUnico.IntestazioneType;
import it.eng.parer.xmlGen.serviziVersamento.wsRequestUnico.ProfiloUnitaDocumentariaType;
import it.eng.parer.xmlGen.serviziVersamento.wsRequestUnico.StrutturaType;
import it.eng.parer.xmlGen.serviziVersamento.wsRequestUnico.StrutturaType.Componenti;
import it.eng.parer.xmlGen.serviziVersamento.wsRequestUnico.TipoConservazioneType;
import it.eng.parer.xmlGen.serviziVersamento.wsRequestUnico.TipoSupportoType;
import it.eng.parer.xmlGen.serviziVersamento.wsRequestUnico.UnitaDocumentaria;
import it.eng.parer.xmlGen.serviziVersamento.wsRequestUnico.VersatoreType;
import it.eng.parer.xmlGen.superamento.mail.DatiSpecificiTypeSuperamentoMail;
import it.eng.parer.xmlGen.superamento.sms.DatiSpecificiTypeSuperamentoSms;
import it.eng.parer.xmlGen.valanghe.DatiSpecificiTypeValanghe;
import it.eng.parer.xmlGen.valanghe.mail.DatiSpecificiTypeValangheMail;
import it.eng.parer.xmlGen.valanghe.sms.DatiSpecificiTypeValangheSms;



public class JavaToXMLParer implements IJavaToXMLParerConstants {
	
	private static Log logger = LogFactoryUtil.getLog(JavaToXMLParer.class);

//	/**
//	 * Il metodo ritorna un FILE xml
//	 * 
//	 * @param datiSpecifici
//	 * @param listaDocumentiCollegati
//	 * @param tipoDatoDaInviare
//	 * @return
//	 * @throws DatatypeConfigurationException
//	 */
//	public static File generaXmlFile (DatiSpecificiInvio datiSpecifici, List<DocumentiCollegati> listaDocumentiCollegati,  List<ComponentiInvio> listaComponenti, String tipoDatoDaInviare ) throws DatatypeConfigurationException  {
//		
//		//In base al tipoDatoDaInviare prepopolo alcuni dati "statici" nell'oggetto datiSpecifici
//		initDatiSpecifi(datiSpecifici, tipoDatoDaInviare, listaDocumentiCollegati, listaComponenti);
//		
//		UnitaDocumentaria unDoc = buildUnitaDocumentaria(datiSpecifici, listaDocumentiCollegati, listaComponenti, tipoDatoDaInviare);
//		
//		File file = new File("file.xml"); //FIXME
//		
//		try {
//		
//			JAXBContext jaxbContext = JAXBContext.newInstance(UnitaDocumentaria.class);
//			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//
//			// output pretty printed
//			jaxbMarshaller.marshal(unDoc, file);
//			//jaxbMarshaller.marshal(unDoc, System.out);
//		
//		} catch (JAXBException e) {
//			e.printStackTrace();
//	    }
//		return file;
//	}
	
	/**
	 * Il metodo ritorna un FILE xml sotto forma di String
	 * 
	 * @param datiSpecifici
	 * @param listaDocumentiCollegati
	 * @param listaComponenti 
	 * @param tipoDatoDaInviare
	 * @return
	 * @throws DatatypeConfigurationException
	 * @throws IOException 
	 */
	public static String generaXmlFileAsString (DatiSpecificiInvio datiSpecifici, List<DocumentiCollegati> listaDocumentiCollegati, List<ComponentiInvio> listaComponenti, String tipoDatoDaInviare ) throws DatatypeConfigurationException, IOException  {
		
		//In base al tipoDatoDaInviare prepopolo alcuni dati "statici" nell'oggetto datiSpecifici
		initDatiSpecifi(datiSpecifici, tipoDatoDaInviare, listaDocumentiCollegati, listaComponenti);
				
		UnitaDocumentaria unDoc = buildUnitaDocumentaria(datiSpecifici, listaDocumentiCollegati, listaComponenti, tipoDatoDaInviare);
		StringWriter sw = new StringWriter();
		String fileAsString = null;
		
		
		try {
			JAXBContext jaxbContext = null;
			Marshaller jaxbMarshaller = null;
			
//			if(TipoDatoDaInviare.ALLERTA.getTipoDatoDaInviare().equals(tipoDatoDaInviare)){
//				jaxbContext = JAXBContext.newInstance(UnitaDocumentaria.class);
//			}else if(TipoDatoDaInviare.ALLERTA_BOLLETTINO.getTipoDatoDaInviare().equals(tipoDatoDaInviare)) {
//				jaxbContext = JAXBContext.newInstance(UnitaDocumentaria.class);
//			}else if(TipoDatoDaInviare.ALLERTA_MAIL.getTipoDatoDaInviare().equals(tipoDatoDaInviare)) {
//				jaxbContext = JAXBContext.newInstance(UnitaDocumentaria.class);
//			}else if (TipoDatoDaInviare.ALLERTA_SMS.getTipoDatoDaInviare().equals(tipoDatoDaInviare)) {
//				jaxbContext = JAXBContext.newInstance(UnitaDocumentaria.class);
//			}else if (TipoDatoDaInviare.MONITORAGGIO.getTipoDatoDaInviare().equals(tipoDatoDaInviare)) {
//				jaxbContext = JAXBContext.newInstance(UnitaDocumentaria.class);
//			}else if (TipoDatoDaInviare.MONITORAGGIO_MAIL.getTipoDatoDaInviare().equals(tipoDatoDaInviare)) {
//				jaxbContext = JAXBContext.newInstance(UnitaDocumentaria.class);
//			}else if (TipoDatoDaInviare.MONITORAGGIO_SMS.getTipoDatoDaInviare().equals(tipoDatoDaInviare)) {
//				jaxbContext = JAXBContext.newInstance(UnitaDocumentaria.class);
//			}else if (TipoDatoDaInviare.SUPERAMENTO_MAIL.getTipoDatoDaInviare().equals(tipoDatoDaInviare)) {
//				jaxbContext = JAXBContext.newInstance(UnitaDocumentaria.class);
//			}else if (TipoDatoDaInviare.SUPERAMENTO_SMS.getTipoDatoDaInviare().equals(tipoDatoDaInviare)) {
//				jaxbContext = JAXBContext.newInstance(UnitaDocumentaria.class);
//			}
			
			JAXBContextFactory factory = JAXBContextFactory.getInstance();
			jaxbContext = factory.getJaxBContext(UnitaDocumentaria.class);
			
			jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.marshal(unDoc, sw);
							
			fileAsString = sw.toString();
				
		} catch (JAXBException e) {
			logger.error(e);
			e.printStackTrace();
	    }
		finally {
			sw.close();
		}
		
		return fileAsString;
	}

	/**
	 * 
	 * @param datiSpecifici
	 * @param tipoDatiSpecifici
	 * @param listaDocumentiCollegati
	 * @param listaComponenti 
	 */
	private static void initDatiSpecifi(DatiSpecificiInvio datiSpecifici, String tipoDatiSpecifici, List<DocumentiCollegati> listaDocumentiCollegati, List<ComponentiInvio> listaComponenti) {
		
		datiSpecifici.setAMBIENTE(ConstansUtil.AMBIENTE);
		datiSpecifici.setVERSIONE_DATI_SPECIFICI(Double.parseDouble(VERSIONE_DATI_SPECIFICI));
		
		if(TipoDatoDaInviare.ALLERTA.getTipoDatoDaInviare().equals(tipoDatiSpecifici)){
			
			datiSpecifici.setVERSATORE_ENTE(ENTE_REGIONE_EMILIA_ROMAGNA);
			datiSpecifici.setVERSATORE_STRUTTURA(STRUTTURA_ALLERTA_PROTEZIONE_CIVILE);
			datiSpecifici.setVERSATORE_USER_ID(ConstansUtil.VERSATORE_ALLERTA_USER_ID_PROT_CIVILE);
			
			datiSpecifici.setCHIAVE_TIPO_REGISTRO(TIPO_REGISTRO_ALLERTA);
			
			datiSpecifici.setTIPOLOGIA_UNITA_DOCUMENTARIA(TIPOLOGIA_UNITA_DOCUMENTARIA_ALLERTA);
			
			datiSpecifici.setOGGETTO_UNITA_DOCUMENTARIA(StringEscapeUtils.escapeXml("Allerta numero "+ datiSpecifici.getCHIAVE_NUMERO() + " emanata il " + dateUtilToString(datiSpecifici.getDATA_UNITA_DOCUMENTARIA())));
			
			datiSpecifici.setINVIO_RESPONSABILE_TERRITORIO(INVIO_RESP_TERRITORIO_SI);
			
			datiSpecifici.setTIPO_DOCUMENTO(TIPO_DOCUMENTO_ALLERTA);
			
			datiSpecifici.setTIPO_STRUTTURA(TIPO_STRUTTURA);
			
			initConfigComponente(listaComponenti);
			
		}else if(TipoDatoDaInviare.ALLERTA_BOLLETTINO.getTipoDatoDaInviare().equals(tipoDatiSpecifici)) {
			
			datiSpecifici.setVERSATORE_ENTE(ENTE_REGIONE_EMILIA_ROMAGNA);
			datiSpecifici.setVERSATORE_STRUTTURA(STRUTTURA_ALLERTA_PROTEZIONE_CIVILE);
			datiSpecifici.setVERSATORE_USER_ID(ConstansUtil.VERSATORE_ALLERTA_USER_ID_PROT_CIVILE);
			
			datiSpecifici.setCHIAVE_TIPO_REGISTRO(TIPO_REGISTRO_BOLLETTINO);
			
			datiSpecifici.setTIPOLOGIA_UNITA_DOCUMENTARIA(TIPOLOGIA_UNITA_DOCUMENTARIA_BOLLETTINO);
			
			datiSpecifici.setOGGETTO_UNITA_DOCUMENTARIA(StringEscapeUtils.escapeXml("Bollettino numero "+ datiSpecifici.getCHIAVE_NUMERO() + " emanato il " + dateUtilToString(datiSpecifici.getDATA_UNITA_DOCUMENTARIA() ) ) );
			
			datiSpecifici.setINVIO_RESPONSABILE_TERRITORIO(INVIO_RESP_TERRITORIO_NO);
			
			datiSpecifici.setTIPO_DOCUMENTO(TIPO_DOCUMENTO_BOLLETTINO);
			
			datiSpecifici.setTIPO_STRUTTURA(TIPO_STRUTTURA);
						
			initConfigComponente(listaComponenti);
	
		
		}else if(TipoDatoDaInviare.ALLERTA_MAIL.getTipoDatoDaInviare().equals(tipoDatiSpecifici)) {
			
			datiSpecifici.setVERSATORE_ENTE(ENTE_REGIONE_EMILIA_ROMAGNA);
			datiSpecifici.setVERSATORE_STRUTTURA(STRUTTURA_ALLERTA_PROTEZIONE_CIVILE);
			datiSpecifici.setVERSATORE_USER_ID(ConstansUtil.VERSATORE_ALLERTA_USER_ID_PROT_CIVILE);
			
			datiSpecifici.setCHIAVE_TIPO_REGISTRO(TIPO_REGISTRO_ALLERTA_MAIL);
			
			datiSpecifici.setTIPOLOGIA_UNITA_DOCUMENTARIA(TIPOLOGIA_UNITA_DOCUMENTARIA_ALLERTA_MAIL);
			
			String numeroAllertoUD [] = datiSpecifici.getIDENTIFICATIVO_DATO_SPECIFICO().split("/");
			
			datiSpecifici.setOGGETTO_UNITA_DOCUMENTARIA(StringEscapeUtils.escapeXml("Report di invio degli avvisi trasmessi via mail, relativi ad allerta numero " + numeroAllertoUD[0] +
														 " emanata il "+  dateUtilToString(datiSpecifici.getDATA_UNITA_DOCUMENTARIA()) +", generato il " +  dateUtilToString(datiSpecifici.getDATA_GENERAZIONE())));
			
			
			//Setto le costanti su doc collegati
			for(DocumentiCollegati docCollegato : listaDocumentiCollegati) {
				
				docCollegato.setDOC_COLLEGATO_TIPO_REGISTRO(TIPO_REGISTRO_ALLERTA);
				docCollegato.setDESCRIZIONE_COLLEGAMENTO(DESCR_COLLEGAMENTO_ALLERTA_MAIL);
				
			}
								
			datiSpecifici.setTIPO_DOCUMENTO(TIPO_DOCUMENTO_ALLERTA_MAIL);
			
			datiSpecifici.setTIPO_STRUTTURA(TIPO_STRUTTURA);
			
			initConfigComponente(listaComponenti);
			
		}else if (TipoDatoDaInviare.ALLERTA_SMS.getTipoDatoDaInviare().equals(tipoDatiSpecifici)) {
			
			datiSpecifici.setVERSATORE_ENTE(ENTE_REGIONE_EMILIA_ROMAGNA);
			datiSpecifici.setVERSATORE_STRUTTURA(STRUTTURA_ALLERTA_PROTEZIONE_CIVILE);
			datiSpecifici.setVERSATORE_USER_ID(ConstansUtil.VERSATORE_ALLERTA_USER_ID_PROT_CIVILE);
			
			datiSpecifici.setCHIAVE_TIPO_REGISTRO(TIPO_REGISTRO_ALLERTA_SMS);
			
			datiSpecifici.setTIPOLOGIA_UNITA_DOCUMENTARIA(TIPOLOGIA_UNITA_DOCUMENTARIA_ALLERTA_SMS);
			
			String numeroAllertoUD [] = datiSpecifici.getIDENTIFICATIVO_DATO_SPECIFICO().split("/");
			
			datiSpecifici.setOGGETTO_UNITA_DOCUMENTARIA(StringEscapeUtils.escapeXml("Report di invio degli avvisi trasmessi via sms, relativi ad allerta numero " + numeroAllertoUD[0] +
														 " emanata il "+  dateUtilToString(datiSpecifici.getDATA_UNITA_DOCUMENTARIA()) +", generato il " +  dateUtilToString(datiSpecifici.getDATA_GENERAZIONE())) );
			
			
			//Setto le costanti su doc collegati
			for(DocumentiCollegati docCollegato : listaDocumentiCollegati) {
				
				docCollegato.setDOC_COLLEGATO_TIPO_REGISTRO(TIPO_REGISTRO_ALLERTA);
				docCollegato.setDESCRIZIONE_COLLEGAMENTO(DESCR_COLLEGAMENTO_ALLERTA_SMS);
				
			}
					
			datiSpecifici.setTIPO_DOCUMENTO(TIPO_DOCUMENTO_ALLERTA_SMS);
			
			datiSpecifici.setTIPO_STRUTTURA(TIPO_STRUTTURA);
			
			initConfigComponente(listaComponenti);

		
		}else if (TipoDatoDaInviare.MONITORAGGIO.getTipoDatoDaInviare().equals(tipoDatiSpecifici)) {
			
			datiSpecifici.setVERSATORE_ENTE(ENTE_ARPA_ER);
			datiSpecifici.setVERSATORE_STRUTTURA(STRUTTURA_ARPA);
			datiSpecifici.setVERSATORE_USER_ID(ConstansUtil.VERSATORE_ALLERTA_USER_ID_ARPA);
			
			datiSpecifici.setCHIAVE_TIPO_REGISTRO(TIPO_REGISTRO_MONITORAGGIO);
			
			datiSpecifici.setTIPOLOGIA_UNITA_DOCUMENTARIA(TIPOLOGIA_UNITA_DOCUMENTARIA_MONITORAGGI);
			
			datiSpecifici.setOGGETTO_UNITA_DOCUMENTARIA(StringEscapeUtils.escapeXml("Monitoraggio meteo idrologico e idraulico "+ datiSpecifici.getCHIAVE_NUMERO() + " emanato il " +  dateUtilToString(datiSpecifici.getDATA_UNITA_DOCUMENTARIA())));
			
			datiSpecifici.setINVIO_RESPONSABILE_TERRITORIO(INVIO_RESP_TERRITORIO_SI);	
			
			datiSpecifici.setTIPO_DOCUMENTO(TIPO_DOCUMENTO_MONITORAGGIO);
			
			datiSpecifici.setTIPO_STRUTTURA(TIPO_STRUTTURA);
			
			initConfigComponente(listaComponenti);

		}else if (TipoDatoDaInviare.MONITORAGGIO_MAIL.getTipoDatoDaInviare().equals(tipoDatiSpecifici)) {
			
			datiSpecifici.setVERSATORE_ENTE(ENTE_ARPA_ER);
			datiSpecifici.setVERSATORE_STRUTTURA(STRUTTURA_ARPA);
			datiSpecifici.setVERSATORE_USER_ID(ConstansUtil.VERSATORE_ALLERTA_USER_ID_ARPA);
			
			datiSpecifici.setCHIAVE_TIPO_REGISTRO(TIPO_REGISTRO_MONITORAGGIO_MAIL);
			
			datiSpecifici.setTIPOLOGIA_UNITA_DOCUMENTARIA(TIPOLOGIA_UNITA_DOCUMENTARIA_MONITORAGGI_MAIL);
			
			String numeroAllertoUD [] = datiSpecifici.getIDENTIFICATIVO_DATO_SPECIFICO().split("/");
			
			datiSpecifici.setOGGETTO_UNITA_DOCUMENTARIA(StringEscapeUtils.escapeXml("Report di invio degli avvisi trasmessi via mail, relativi al monitoraggio " +  numeroAllertoUD[0] +
														 " emanato il "+  dateUtilToString(datiSpecifici.getDATA_UNITA_DOCUMENTARIA()) +", generato il " +  dateUtilToString(datiSpecifici.getDATA_GENERAZIONE())) );
			
			
			//Setto le costanti su doc collegati
			for(DocumentiCollegati docCollegato : listaDocumentiCollegati) {
				
				docCollegato.setDOC_COLLEGATO_TIPO_REGISTRO(TIPO_REGISTRO_MONITORAGGIO);
				docCollegato.setDESCRIZIONE_COLLEGAMENTO(DESCR_COLLEGAMENTO_MONITORAGGIO_MAIL);
				
			}
					
			datiSpecifici.setTIPO_DOCUMENTO(TIPO_DOCUMENTO_MONITORAGGIO_MAIL);
			
			datiSpecifici.setTIPO_STRUTTURA(TIPO_STRUTTURA);
			
			initConfigComponente(listaComponenti);
			
		}else if (TipoDatoDaInviare.MONITORAGGIO_SMS.getTipoDatoDaInviare().equals(tipoDatiSpecifici)) {
			
			datiSpecifici.setVERSATORE_ENTE(ENTE_ARPA_ER);
			datiSpecifici.setVERSATORE_STRUTTURA(STRUTTURA_ARPA);
			datiSpecifici.setVERSATORE_USER_ID(ConstansUtil.VERSATORE_ALLERTA_USER_ID_ARPA);
			
			datiSpecifici.setCHIAVE_TIPO_REGISTRO(TIPO_REGISTRO_MONITORAGGIO_SMS);
			
			datiSpecifici.setTIPOLOGIA_UNITA_DOCUMENTARIA(TIPOLOGIA_UNITA_DOCUMENTARIA_MONITORAGGI_SMS);
			
			String numeroAllertoUD [] = datiSpecifici.getIDENTIFICATIVO_DATO_SPECIFICO().split("/");
			
			datiSpecifici.setOGGETTO_UNITA_DOCUMENTARIA(StringEscapeUtils.escapeXml("Report di invio degli avvisi trasmessi via sms, relativi al monitoraggio " +  numeroAllertoUD[0] +
														 " emanato il "+  dateUtilToString(datiSpecifici.getDATA_UNITA_DOCUMENTARIA()) +", generato il " +  dateUtilToString(datiSpecifici.getDATA_GENERAZIONE())));
			
			
			//Setto le costanti su doc collegati
			for(DocumentiCollegati docCollegato : listaDocumentiCollegati) {
				
				docCollegato.setDOC_COLLEGATO_TIPO_REGISTRO(TIPO_REGISTRO_MONITORAGGIO);
				docCollegato.setDESCRIZIONE_COLLEGAMENTO(DESCR_COLLEGAMENTO_MONITORAGGIO_SMS);
				
			}
					
			datiSpecifici.setTIPO_DOCUMENTO(TIPO_DOCUMENTO_MONITORAGGIO_SMS);
			
			datiSpecifici.setTIPO_STRUTTURA(TIPO_STRUTTURA);
			
			initConfigComponente(listaComponenti);
	
		}else if (TipoDatoDaInviare.SUPERAMENTO_MAIL.getTipoDatoDaInviare().equals(tipoDatiSpecifici)) {
			
			datiSpecifici.setVERSATORE_ENTE(ENTE_REGIONE_EMILIA_ROMAGNA);
			datiSpecifici.setVERSATORE_STRUTTURA(STRUTTURA_ALLERTA_PROTEZIONE_CIVILE);
			datiSpecifici.setVERSATORE_USER_ID(ConstansUtil.VERSATORE_ALLERTA_USER_ID_PROT_CIVILE);
			
			datiSpecifici.setCHIAVE_TIPO_REGISTRO(TIPO_REGISTRO_SUPERAMENTO_MAIL);
			
			datiSpecifici.setTIPOLOGIA_UNITA_DOCUMENTARIA(TIPOLOGIA_UNITA_DOCUMENTARIA_SUPERAMENTI_MAIL);
			
			datiSpecifici.setOGGETTO_UNITA_DOCUMENTARIA(StringEscapeUtils.escapeXml("Report di invio degli avvisi trasmessi via mail, relativi al superamento di soglia "+ datiSpecifici.getCHIAVE_NUMERO() +
														 "avvenuto il " +  dateUtilToString(datiSpecifici.getDATA_UNITA_DOCUMENTARIA()) +", generato il " +  dateUtilToString(datiSpecifici.getDATA_GENERAZIONE())));
			
			
			//Setto le costanti su doc collegati
			for(DocumentiCollegati docCollegato : listaDocumentiCollegati) {
				
				docCollegato.setDOC_COLLEGATO_TIPO_REGISTRO(TIPO_REGISTRO_SUPERAMENTO_MAIL);
				docCollegato.setDESCRIZIONE_COLLEGAMENTO(DESCR_COLLEGAMENTO_SUPERAMENTO);
				
			}
								
			datiSpecifici.setTIPO_DOCUMENTO(TIPO_DOCUMENTO_SUPERAMENTO_MAIL);
			
			datiSpecifici.setTIPO_STRUTTURA(TIPO_STRUTTURA);
			
			initConfigComponente(listaComponenti);
			
		}else if (TipoDatoDaInviare.SUPERAMENTO_SMS.getTipoDatoDaInviare().equals(tipoDatiSpecifici)) {
			
			datiSpecifici.setVERSATORE_ENTE(ENTE_REGIONE_EMILIA_ROMAGNA);
			datiSpecifici.setVERSATORE_STRUTTURA(STRUTTURA_ALLERTA_PROTEZIONE_CIVILE);
			datiSpecifici.setVERSATORE_USER_ID(ConstansUtil.VERSATORE_ALLERTA_USER_ID_PROT_CIVILE);
			
			datiSpecifici.setCHIAVE_TIPO_REGISTRO(TIPO_REGISTRO_SUPERAMENTO_SMS);
			
			datiSpecifici.setTIPOLOGIA_UNITA_DOCUMENTARIA(TIPOLOGIA_UNITA_DOCUMENTARIA_SUPERAMENTI_SMS);
			
			datiSpecifici.setOGGETTO_UNITA_DOCUMENTARIA(StringEscapeUtils.escapeXml("Report di invio degli avvisi trasmessi via sms, relativi al superamento di soglia "+ datiSpecifici.getCHIAVE_NUMERO() +
														 "avvenuto il " +  dateUtilToString(datiSpecifici.getDATA_UNITA_DOCUMENTARIA()) +", generato il " +  dateUtilToString(datiSpecifici.getDATA_GENERAZIONE())) );
			
			
			//Setto le costanti su doc collegati
			for(DocumentiCollegati docCollegato : listaDocumentiCollegati) {
				
				docCollegato.setDOC_COLLEGATO_TIPO_REGISTRO(TIPO_REGISTRO_SUPERAMENTO_MAIL);
				docCollegato.setDESCRIZIONE_COLLEGAMENTO(DESCR_COLLEGAMENTO_SUPERAMENTO);
				
			}
								
			datiSpecifici.setTIPO_DOCUMENTO(TIPO_DOCUMENTO_SUPERAMENTO_SMS);
			
			datiSpecifici.setTIPO_STRUTTURA(TIPO_STRUTTURA);
			
			initConfigComponente(listaComponenti);
		} else if(TipoDatoDaInviare.VALANGHE.getTipoDatoDaInviare().equals(tipoDatiSpecifici)){
			
			datiSpecifici.setVERSATORE_ENTE(ENTE_REGIONE_EMILIA_ROMAGNA);
			datiSpecifici.setVERSATORE_STRUTTURA(STRUTTURA_ALLERTA_PROTEZIONE_CIVILE);
			datiSpecifici.setVERSATORE_USER_ID(ConstansUtil.VERSATORE_ALLERTA_USER_ID_PROT_CIVILE);
			
			datiSpecifici.setCHIAVE_TIPO_REGISTRO(TIPO_REGISTRO_VALANGHE);
			
			datiSpecifici.setTIPOLOGIA_UNITA_DOCUMENTARIA(TIPOLOGIA_UNITA_DOCUMENTARIA_VALANGHE);
			
			boolean all =  datiSpecifici.getCHIAVE_NUMERO().length()>3;
			String num = all?datiSpecifici.getCHIAVE_NUMERO().substring(1):datiSpecifici.getCHIAVE_NUMERO();
			String ogg = all?"Allerta valanghe "+num+" emanata il ":"Bollettino valanghe "+num+" emanato il ";
			ogg += dateUtilToString(datiSpecifici.getDATA_UNITA_DOCUMENTARIA());
			datiSpecifici.setOGGETTO_UNITA_DOCUMENTARIA(StringEscapeUtils.escapeXml(ogg));
			
			datiSpecifici.setINVIO_RESPONSABILE_TERRITORIO(INVIO_RESP_TERRITORIO_SI);
			
			datiSpecifici.setTIPO_DOCUMENTO(TIPO_DOCUMENTO_VALANGHE);
			
			datiSpecifici.setTIPO_STRUTTURA(TIPO_STRUTTURA);
			
			initConfigComponente(listaComponenti);
			
		}else if(TipoDatoDaInviare.VALANGHE_MAIL.getTipoDatoDaInviare().equals(tipoDatiSpecifici)) {
			
			datiSpecifici.setVERSATORE_ENTE(ENTE_REGIONE_EMILIA_ROMAGNA);
			datiSpecifici.setVERSATORE_STRUTTURA(STRUTTURA_ALLERTA_PROTEZIONE_CIVILE);
			datiSpecifici.setVERSATORE_USER_ID(ConstansUtil.VERSATORE_ALLERTA_USER_ID_PROT_CIVILE);
			
			datiSpecifici.setCHIAVE_TIPO_REGISTRO(TIPO_REGISTRO_VALANGHE_MAIL);
			
			datiSpecifici.setTIPOLOGIA_UNITA_DOCUMENTARIA(TIPOLOGIA_UNITA_DOCUMENTARIA_VALANGHE_MAIL);
			
			boolean all =  datiSpecifici.getIDENTIFICATIVO_DATO_SPECIFICO().length()>3;
			String num = all?datiSpecifici.getIDENTIFICATIVO_DATO_SPECIFICO().substring(1):datiSpecifici.getIDENTIFICATIVO_DATO_SPECIFICO();
			
			String numeroAllertoUD [] = num.split("/");
			
			datiSpecifici.setOGGETTO_UNITA_DOCUMENTARIA(StringEscapeUtils.escapeXml("Report di invio degli avvisi trasmessi via mail, relativi "+(all?"ad allerta valanghe":"a bollettino valanghe")+" " + numeroAllertoUD[0] +
														 " del "+  dateUtilToString(datiSpecifici.getDATA_UNITA_DOCUMENTARIA()) +", generato il " +  dateUtilToString(datiSpecifici.getDATA_GENERAZIONE())));
			
			
			//Setto le costanti su doc collegati
			for(DocumentiCollegati docCollegato : listaDocumentiCollegati) {
				
				docCollegato.setDOC_COLLEGATO_TIPO_REGISTRO(TIPO_REGISTRO_VALANGHE);
				docCollegato.setDESCRIZIONE_COLLEGAMENTO(DESCR_COLLEGAMENTO_VALANGHE_MAIL);
				
			}
								
			datiSpecifici.setTIPO_DOCUMENTO(TIPO_DOCUMENTO_VALANGHE_MAIL);
			
			datiSpecifici.setTIPO_STRUTTURA(TIPO_STRUTTURA);
			
			initConfigComponente(listaComponenti);
			
		}else if (TipoDatoDaInviare.VALANGHE_SMS.getTipoDatoDaInviare().equals(tipoDatiSpecifici)) {
			
			datiSpecifici.setVERSATORE_ENTE(ENTE_REGIONE_EMILIA_ROMAGNA);
			datiSpecifici.setVERSATORE_STRUTTURA(STRUTTURA_ALLERTA_PROTEZIONE_CIVILE);
			datiSpecifici.setVERSATORE_USER_ID(ConstansUtil.VERSATORE_ALLERTA_USER_ID_PROT_CIVILE);
			
			datiSpecifici.setCHIAVE_TIPO_REGISTRO(TIPO_REGISTRO_VALANGHE_SMS);
			
			datiSpecifici.setTIPOLOGIA_UNITA_DOCUMENTARIA(TIPOLOGIA_UNITA_DOCUMENTARIA_VALANGHE_SMS);
			
			boolean all =  datiSpecifici.getIDENTIFICATIVO_DATO_SPECIFICO().length()>3;
			String num = all?datiSpecifici.getIDENTIFICATIVO_DATO_SPECIFICO().substring(1):datiSpecifici.getIDENTIFICATIVO_DATO_SPECIFICO();
			
			String numeroAllertoUD [] = num.split("/");
			
			datiSpecifici.setOGGETTO_UNITA_DOCUMENTARIA(StringEscapeUtils.escapeXml("Report di invio degli avvisi trasmessi via sms, relativi "+(all?"ad allerta valanghe":"a bollettino valanghe")+" " + numeroAllertoUD[0] +
					 " del "+  dateUtilToString(datiSpecifici.getDATA_UNITA_DOCUMENTARIA()) +", generato il " +  dateUtilToString(datiSpecifici.getDATA_GENERAZIONE())));

			
			//Setto le costanti su doc collegati
			for(DocumentiCollegati docCollegato : listaDocumentiCollegati) {
				
				docCollegato.setDOC_COLLEGATO_TIPO_REGISTRO(TIPO_REGISTRO_VALANGHE);
				docCollegato.setDESCRIZIONE_COLLEGAMENTO(DESCR_COLLEGAMENTO_VALANGHE_SMS);
				
			}
					
			datiSpecifici.setTIPO_DOCUMENTO(TIPO_DOCUMENTO_VALANGHE_SMS);
			
			datiSpecifici.setTIPO_STRUTTURA(TIPO_STRUTTURA);
			
			initConfigComponente(listaComponenti);

		
		}
		
	}

	/**
	 * 
	 * @param listaComponenti
	 */
	private static void initConfigComponente(List<ComponentiInvio> listaComponenti) {
		
		long index = 0;
		long ordinePresentazione = 0;
		for(ComponentiInvio compInvio: listaComponenti){
			compInvio.setID_COMPONENTE(++index);
			compInvio.setORDINE_PRESENTAZIONE(++ordinePresentazione);
			compInvio.setTIPO_COMPONENTE(TIPO_COMPENENTE);
			compInvio.setTIPO_SUPPORTO_COMPONENTE(TIPO_SUPPORTO_COMPONENTE);
		}
		
	}

	/**
	 * Crea la radice del documento
	 * Crea e popolo l'oggetto UnitaDocumentaria
	 * @param listaDocCollegati 
	 * @param listaComponenti 
	 * @param <T>
	 * 
	 * @return
	 * @throws DatatypeConfigurationException
	 */
	private static UnitaDocumentaria buildUnitaDocumentaria(DatiSpecificiInvio datiSpec, List<DocumentiCollegati> listaDocCollegati, List<ComponentiInvio> listaComponenti, String tipoDatiSpecifici) throws DatatypeConfigurationException {
		//Radice
	    UnitaDocumentaria unDoc = new UnitaDocumentaria();
		  
		//Elementi
		//1° ELEMENTO - Intestazione
		IntestazioneType intestazione = buildIntestazione(datiSpec, tipoDatiSpecifici);
		  
		//2° ELEMENTO - CONFIGURAZIONE
		ConfigType configurazione = buildConfigurazione(datiSpec, tipoDatiSpecifici);
		  
		//3° ELEMENTO - PROFILO UNITA DOCUMENTARIA
		ProfiloUnitaDocumentariaType profiloUnitaDocumentaria = buildProfiloUnitaDocumentaria(datiSpec, tipoDatiSpecifici);
		  
		//4° ELEMENTO - DATI SPECIFICI
		if(TipoDatoDaInviare.ALLERTA.getTipoDatoDaInviare().equals(tipoDatiSpecifici)){
			JAXBElement<DatiSpecificiTypeAllerta> datiSpecAllerta = buildDatiSpecificiAllerta(datiSpec);
			unDoc.setDatiSpecifici(datiSpecAllerta);					
		}else if(TipoDatoDaInviare.ALLERTA_BOLLETTINO.getTipoDatoDaInviare().equals(tipoDatiSpecifici)) {
			JAXBElement<DatiSpecificiTypeBollettino> datiSpecBollettino = buildDatiSpecificiBollettino(datiSpec);
			unDoc.setDatiSpecifici(datiSpecBollettino);
		}else if(TipoDatoDaInviare.ALLERTA_MAIL.getTipoDatoDaInviare().equals(tipoDatiSpecifici)) {
			JAXBElement<DatiSpecificiTypeMail> datiSpecMail = buildDatiSpecificiAllertaMail(datiSpec);
			unDoc.setDatiSpecifici(datiSpecMail);
		}else if (TipoDatoDaInviare.ALLERTA_SMS.getTipoDatoDaInviare().equals(tipoDatiSpecifici)) {
			JAXBElement<DatiSpecificiTypeSms> datiSpecAllertaSms = buildDatiSpecificiAllertaSms(datiSpec);
			unDoc.setDatiSpecifici(datiSpecAllertaSms);
		}else if (TipoDatoDaInviare.MONITORAGGIO.getTipoDatoDaInviare().equals(tipoDatiSpecifici)) {
			JAXBElement<DatiSpecificiTypeMonitoraggio> datiSpecMonitoraggio = buildDatiSpecificiMonitoraggio(datiSpec);
			unDoc.setDatiSpecifici(datiSpecMonitoraggio);
		}else if (TipoDatoDaInviare.MONITORAGGIO_MAIL.getTipoDatoDaInviare().equals(tipoDatiSpecifici)) {
			JAXBElement<DatiSpecificiTypeMonitoraggioMail> datiSpecMonMail = buildDatiSpecificiMonitoraggioMail(datiSpec);
			unDoc.setDatiSpecifici(datiSpecMonMail);			
		}else if (TipoDatoDaInviare.MONITORAGGIO_SMS.getTipoDatoDaInviare().equals(tipoDatiSpecifici)) {
			JAXBElement<DatiSpecificiTypeMonitoraggioSms> datiSpecMonMail = buildDatiSpecificiMonitoraggioSms(datiSpec);
			unDoc.setDatiSpecifici(datiSpecMonMail);	
		}else if (TipoDatoDaInviare.SUPERAMENTO_MAIL.getTipoDatoDaInviare().equals(tipoDatiSpecifici)) {
			JAXBElement<DatiSpecificiTypeSuperamentoMail> datiSpecSuperamentoMail = buildDatiSpecificiSuperamentoMail(datiSpec);
			unDoc.setDatiSpecifici(datiSpecSuperamentoMail);				
		}else if (TipoDatoDaInviare.SUPERAMENTO_SMS.getTipoDatoDaInviare().equals(tipoDatiSpecifici)) {
			JAXBElement<DatiSpecificiTypeSuperamentoSms> datiSpecSuperamentoSms = buildDatiSpecificiSuperamentoSms(datiSpec);
			unDoc.setDatiSpecifici(datiSpecSuperamentoSms);	
		}else if (TipoDatoDaInviare.VALANGHE.getTipoDatoDaInviare().equals(tipoDatiSpecifici)) {
			JAXBElement<DatiSpecificiTypeValanghe> datiSpecSuperamentoSms = buildDatiSpecificiValanghe(datiSpec);
			unDoc.setDatiSpecifici(datiSpecSuperamentoSms);	
		}else if (TipoDatoDaInviare.VALANGHE_SMS.getTipoDatoDaInviare().equals(tipoDatiSpecifici)) {
			JAXBElement<DatiSpecificiTypeValangheSms> datiSpecSuperamentoSms = buildDatiSpecificiValangheSms(datiSpec);
			unDoc.setDatiSpecifici(datiSpecSuperamentoSms);	
		}else if (TipoDatoDaInviare.VALANGHE_MAIL.getTipoDatoDaInviare().equals(tipoDatiSpecifici)) {
			JAXBElement<DatiSpecificiTypeValangheMail> datiSpecSuperamentoSms = buildDatiSpecificiValangheMail(datiSpec);
			unDoc.setDatiSpecifici(datiSpecSuperamentoSms);	
		}
	  
		//5° ELEMENTO - DOCUMENTI COLLEGATI
		DocumentoCollegatoType documentiCollegati = buildDocumentoCollegato(listaDocCollegati, tipoDatiSpecifici);
		  
		//6° ELEMENTO - DOCUMENTO PRINCIPALE
		DocumentoType documentoPrincipale = buildDocumentoPrincipale(datiSpec, listaComponenti, tipoDatiSpecifici);
		  	  
		//Setting sul nodo radice dei restanti elementi
		unDoc.setIntestazione(intestazione);
		unDoc.setConfigurazione(configurazione);
		unDoc.setProfiloUnitaDocumentaria(profiloUnitaDocumentaria);
		unDoc.setDocumentiCollegati(documentiCollegati);
		unDoc.setDocumentoPrincipale(documentoPrincipale);
		
		return unDoc;
	}

	/**
	 * Crea e popola l'oggetto Intestazione
	 * @param datiSpecificiInvio 
	 * @param tipoDatiSpecifici 
	 * @return
	 */
	private static IntestazioneType buildIntestazione(DatiSpecificiInvio datiSpecificiInvio, String tipoDatiSpecifici) {
	
		IntestazioneType intestazione = new IntestazioneType();
		
		intestazione.setVersione(StringEscapeUtils.escapeXml(VERSIONE)); //FIXME dovrebbe essere fissa
		datiSpecificiInvio.setVERSIONE(Double.parseDouble(VERSIONE));
		//Intestazione -> Versatore
		VersatoreType versatore = buildVersatore(datiSpecificiInvio);
		  
		intestazione.setVersatore(versatore);
		  
		//Intestazine -> Chiave
		ChiaveType chiave = buildChiave(datiSpecificiInvio);
		  
		intestazione.setChiave(chiave);
		  
		//Intestazione -> Tipologia Unita Documentaria
		intestazione.setTipologiaUnitaDocumentaria(StringEscapeUtils.escapeXml(datiSpecificiInvio.getTIPOLOGIA_UNITA_DOCUMENTARIA()));
		
		return intestazione;
	}

	/**
	 * Crea e popola l'oggetto Chiave
	 * @param datiSpecificiInvio 
	 * @return
	 */
	private static ChiaveType buildChiave(DatiSpecificiInvio datiSpecificiInvio) {
		
		ChiaveType chiave = new ChiaveType();
		chiave.setAnno((int) datiSpecificiInvio.getCHIAVE_ANNO());
		chiave.setNumero(StringEscapeUtils.escapeXml(datiSpecificiInvio.getCHIAVE_NUMERO()));
		chiave.setTipoRegistro(StringEscapeUtils.escapeXml(datiSpecificiInvio.getCHIAVE_TIPO_REGISTRO()));
		
		return chiave;
	}

	/**
	 * Crea e popola l'oggetto Versatore
	 * @param datiSpecificiInvio 
	 * @return
	 */
	private static VersatoreType buildVersatore(DatiSpecificiInvio datiSpecificiInvio) {
		
		VersatoreType versatore = new VersatoreType();
	    versatore.setAmbiente(StringEscapeUtils.escapeXml(datiSpecificiInvio.getAMBIENTE()));
	    versatore.setEnte(StringEscapeUtils.escapeXml(datiSpecificiInvio.getVERSATORE_ENTE()));
		versatore.setStruttura(StringEscapeUtils.escapeXml(datiSpecificiInvio.getVERSATORE_STRUTTURA()));
		versatore.setUserID(StringEscapeUtils.escapeXml(datiSpecificiInvio.getVERSATORE_USER_ID()));
		
		return versatore;
	}
	
	/**
	 * Crea e popola l'oggetto Configurazione
	 * @param datiSpecificiInvio 
	 * @param tipoDatiSpecifici 
	 * @return
	 */
	private static ConfigType buildConfigurazione(DatiSpecificiInvio datiSpecificiInvio, String tipoDatiSpecifici) {
		
		ConfigType configurazione = new ConfigType();
		
		if(TipoDatoDaInviare.ALLERTA.getTipoDatoDaInviare().equals(tipoDatiSpecifici)){
			configurazione = settaParamConfigurazione(false, true, false);
			configurazione.setTipoConservazione(TipoConservazioneType.fromValue(TipoConservazioneType.VERSAMENTO_ANTICIPATO.value()));				
		}else if(TipoDatoDaInviare.ALLERTA_BOLLETTINO.getTipoDatoDaInviare().equals(tipoDatiSpecifici)) {
			configurazione = settaParamConfigurazione(false, true, false);
			configurazione.setTipoConservazione(TipoConservazioneType.fromValue(TipoConservazioneType.VERSAMENTO_ANTICIPATO.value()));
		}else if(TipoDatoDaInviare.ALLERTA_MAIL.getTipoDatoDaInviare().equals(tipoDatiSpecifici)) {
			configurazione = settaParamConfigurazione(false, true, false);
			configurazione.setTipoConservazione(TipoConservazioneType.fromValue(TipoConservazioneType.VERSAMENTO_ANTICIPATO.value()));
		}else if (TipoDatoDaInviare.ALLERTA_SMS.getTipoDatoDaInviare().equals(tipoDatiSpecifici)) {
			configurazione = settaParamConfigurazione(false, true, false);
			configurazione.setTipoConservazione(TipoConservazioneType.fromValue(TipoConservazioneType.VERSAMENTO_ANTICIPATO.value()));
		}else if (TipoDatoDaInviare.MONITORAGGIO.getTipoDatoDaInviare().equals(tipoDatiSpecifici)) {
			configurazione = settaParamConfigurazione(false, true, false);
			configurazione.setTipoConservazione(TipoConservazioneType.fromValue(TipoConservazioneType.VERSAMENTO_ANTICIPATO.value()));
		}else if (TipoDatoDaInviare.MONITORAGGIO_MAIL.getTipoDatoDaInviare().equals(tipoDatiSpecifici)) {
			configurazione = settaParamConfigurazione(false, true, false);
			configurazione.setTipoConservazione(TipoConservazioneType.fromValue(TipoConservazioneType.VERSAMENTO_ANTICIPATO.value()));			
		}else if (TipoDatoDaInviare.MONITORAGGIO_SMS.getTipoDatoDaInviare().equals(tipoDatiSpecifici)) {
			configurazione = settaParamConfigurazione(false, true, false);
			configurazione.setTipoConservazione(TipoConservazioneType.fromValue(TipoConservazioneType.VERSAMENTO_ANTICIPATO.value()));	
		}else if (TipoDatoDaInviare.SUPERAMENTO_MAIL.getTipoDatoDaInviare().equals(tipoDatiSpecifici)) {
			configurazione = settaParamConfigurazione(false, true, true);
			configurazione.setTipoConservazione(TipoConservazioneType.fromValue(TipoConservazioneType.VERSAMENTO_ANTICIPATO.value()));				
		}else if (TipoDatoDaInviare.SUPERAMENTO_SMS.getTipoDatoDaInviare().equals(tipoDatiSpecifici)) {
			configurazione = settaParamConfigurazione(false, true, true);
			configurazione.setTipoConservazione(TipoConservazioneType.fromValue(TipoConservazioneType.VERSAMENTO_ANTICIPATO.value()));
		} else if(TipoDatoDaInviare.VALANGHE.getTipoDatoDaInviare().equals(tipoDatiSpecifici)){
			configurazione = settaParamConfigurazione(false, true, false);
			configurazione.setTipoConservazione(TipoConservazioneType.fromValue(TipoConservazioneType.VERSAMENTO_ANTICIPATO.value()));				
		}else if(TipoDatoDaInviare.VALANGHE_MAIL.getTipoDatoDaInviare().equals(tipoDatiSpecifici)) {
			configurazione = settaParamConfigurazione(false, true, false);
			configurazione.setTipoConservazione(TipoConservazioneType.fromValue(TipoConservazioneType.VERSAMENTO_ANTICIPATO.value()));
		}else if (TipoDatoDaInviare.VALANGHE_SMS.getTipoDatoDaInviare().equals(tipoDatiSpecifici)) {
			configurazione = settaParamConfigurazione(false, true, false);
			configurazione.setTipoConservazione(TipoConservazioneType.fromValue(TipoConservazioneType.VERSAMENTO_ANTICIPATO.value()));
		}
		datiSpecificiInvio.setTIPO_CONSERVAZIONE(configurazione.getTipoConservazione().name());
		datiSpecificiInvio.setFORZA_ACCETTAZIONE(configurazione.isForzaAccettazione()?"S":"N");
		datiSpecificiInvio.setFORZA_COLLEGAMENTO(configurazione.isForzaCollegamento()?"S":"N");
		datiSpecificiInvio.setFORZA_CONSERVAZIONE(configurazione.isForzaConservazione()?"S":"N");
		
		return configurazione;
	}

	/**
	 * 
	 * @param forzaAccettazione
	 * @param forzaCollegamento
	 * @param forzaConservazione
	 * @return
	 */
	private static ConfigType settaParamConfigurazione(boolean forzaAccettazione, boolean forzaConservazione, boolean forzaCollegamento) {
		
		ConfigType configurazione = new ConfigType();
		
		configurazione.setForzaAccettazione(forzaAccettazione);
		configurazione.setForzaCollegamento(forzaCollegamento);
		configurazione.setForzaConservazione(forzaConservazione);

		return configurazione;
	}
	
	/**
	 * Crea e popola l'oggetto profilo unita documentaria
	 * @param datiSpecificiInvio 
	 * @param tipoDatiSpecifici 
	 * @return
	 * @throws DatatypeConfigurationException
	 */
	private static ProfiloUnitaDocumentariaType buildProfiloUnitaDocumentaria(DatiSpecificiInvio datiSpecificiInvio, String tipoDatiSpecifici) throws DatatypeConfigurationException {
		
		ProfiloUnitaDocumentariaType profiloUnitaDocumentaria = new ProfiloUnitaDocumentariaType();
		
		//Verificare se crea problemi questa conveserionse (non dovrebbe)
		DateFormat format = new SimpleDateFormat(FORMATTER_AAAA_MM_DD);
		XMLGregorianCalendar xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(format.format(datiSpecificiInvio.getDATA_UNITA_DOCUMENTARIA()));
		
		profiloUnitaDocumentaria.setData(xgcal);
		profiloUnitaDocumentaria.setOggetto(StringEscapeUtils.escapeXml(datiSpecificiInvio.getOGGETTO_UNITA_DOCUMENTARIA()));
		
		return profiloUnitaDocumentaria;
	}
	
	/**
	 * Crea e popolo l'oggetto DocumentiCollegati
	 * @param tipoDatiSpecifici 
	 * @param list 
	 * @return
	 */
	private static DocumentoCollegatoType buildDocumentoCollegato(List<DocumentiCollegati> listDocCollegati, String tipoDatiSpecifici) {
		
		if(null != listDocCollegati && listDocCollegati.size()> 0) {

			DocumentoCollegatoType documentiCollegati = new DocumentoCollegatoType();
		

			for(DocumentiCollegati docCollegato : listDocCollegati) {
	
				DocumentoCollegato documentoCollegato = new DocumentoCollegato();
				
				ChiaveType chiaveDocumentoCollegato = new ChiaveType();
				
				chiaveDocumentoCollegato.setAnno(docCollegato.getDOC_COLLEGATO_ANNO());
				chiaveDocumentoCollegato.setNumero(StringEscapeUtils.escapeXml(docCollegato.getDOC_COLLEGATO_NUMERO()));
				chiaveDocumentoCollegato.setTipoRegistro(StringEscapeUtils.escapeXml(docCollegato.getDOC_COLLEGATO_TIPO_REGISTRO()));
				
				documentoCollegato.setChiaveCollegamento(chiaveDocumentoCollegato);
				documentoCollegato.setDescrizioneCollegamento(StringEscapeUtils.escapeXml(docCollegato.getDESCRIZIONE_COLLEGAMENTO()));
				documentiCollegati.getDocumentoCollegato().add(documentoCollegato);
			}
			
			return documentiCollegati;
		}
		return null;
	}

	/**
	 * Crea e popolo l'oggetto DocumentoPrincipale
	 * @param datiSpecificiInvio 
	 * @param listaComponenti 
	 * @param tipoDatiSpecifici 
	 * @return
	 */
	private static DocumentoType buildDocumentoPrincipale(DatiSpecificiInvio datiSpecificiInvio, List<ComponentiInvio> listaComponenti, String tipoDatiSpecifici) {
		
		DocumentoType documentoPrincipale = new DocumentoType();
		documentoPrincipale.setIDDocumento(StringEscapeUtils.escapeXml(String.valueOf(datiSpecificiInvio.getID_DOCUMENTO_PRINCIPALE())));
		documentoPrincipale.setTipoDocumento(StringEscapeUtils.escapeXml(datiSpecificiInvio.getTIPO_DOCUMENTO()));
		StrutturaType strutturaOriginale = new StrutturaType();
		strutturaOriginale.setTipoStruttura(StringEscapeUtils.escapeXml(TIPO_STRUTTURA)); 
		
		//Creo le componenti
		Componenti componenti = new Componenti();
		
		for(ComponentiInvio compInvio : listaComponenti) {
		
			ComponenteType componente = new ComponenteType();
			componente.setID(StringEscapeUtils.escapeXml(String.valueOf(compInvio.getID_COMPONENTE())));
			componente.setOrdinePresentazione((int)compInvio.getORDINE_PRESENTAZIONE());
			componente.setTipoComponente(StringEscapeUtils.escapeXml(compInvio.getTIPO_COMPONENTE()));
			componente.setTipoSupportoComponente(TipoSupportoType.fromValue(TipoSupportoType.FILE.value()));
			componente.setNomeComponente(StringEscapeUtils.escapeXml(compInvio.getNOME_COMPONENTE()));
			componente.setFormatoFileVersato(StringEscapeUtils.escapeXml(compInvio.getFORMATO_FILE_VERSATO())); //arriva già valorizzato
			componente.setHashVersato(StringEscapeUtils.escapeXml(compInvio.getHASH_VERSATO()));
			componente.setUrnVersato(StringEscapeUtils.escapeXml(compInvio.getURN_VERSATO()));
			componente.setIDComponenteVersato(StringEscapeUtils.escapeXml(String.valueOf(compInvio.getID_COMPONENTE_VERSATO())));
			
			//aggiungo la componente alla lista
			componenti.getComponente().add(componente);
		}
		
		strutturaOriginale.setComponenti(componenti);
		
		//e la struttura al doc principale
		documentoPrincipale.setStrutturaOriginale(strutturaOriginale);
		
		return documentoPrincipale;
	}
	
	
	/**
	 * 
	 * @param tipoDatiSpecifici
	 * @return
	 */
//	private static String tipoFileVersato(String tipoDatiSpecifici){
//		
////		if( TipoDatoDaInviare.ALLERTA.getTipoDatoDaInviare().equals(tipoDatiSpecifici) ||
////			TipoDatoDaInviare.ALLERTA_BOLLETTINO.getTipoDatoDaInviare().equals(tipoDatiSpecifici) ||
////			TipoDatoDaInviare.MONITORAGGIO.getTipoDatoDaInviare().equals(tipoDatiSpecifici)	 ) {
//			
//			return TIPO_FILE_PDF;
//		//}
//		//return TIPO_FILE_CSV;
//	}

	
	/**
	 * Crea e popolo l'oggetto DatiSpecifici
	 * @param datiSpecificiInvio 
	 * @return
	 * @throws DatatypeConfigurationException
	 */
	private static JAXBElement<DatiSpecificiTypeMail> buildDatiSpecificiAllertaMail(DatiSpecificiInvio datiSpecificiInvio) throws DatatypeConfigurationException {
		
		ObjectFactory obj = new ObjectFactory();
	    DatiSpecificiTypeMail datiSpecificiMail =  obj.createDatiSpecificiType();
	    datiSpecificiMail.setVersioneDatiSpecifici(StringEscapeUtils.escapeXml(String.valueOf(datiSpecificiInvio.getVERSIONE_DATI_SPECIFICI())));
			  
		datiSpecificiMail.setDataGenerazione(StringEscapeUtils.escapeXml(formattaData(datiSpecificiInvio.getDATA_GENERAZIONE())));

		datiSpecificiMail.setNumeroComunicazione((StringEscapeUtils.escapeXml(datiSpecificiInvio.getIDENTIFICATIVO_DATO_SPECIFICO())));
		datiSpecificiMail.setTipoComunicazione(StringEscapeUtils.escapeXml(TIPO_COMUNICAZIONE_ALLERTA));		
		datiSpecificiMail.setOggettoMail(StringEscapeUtils.escapeXml(datiSpecificiInvio.getOGGETTO_MAIL()));
		datiSpecificiMail.setTestoMail(StringEscapeUtils.escapeXml(datiSpecificiInvio.getTESTO_MAIL()));
		datiSpecificiMail.setDenominazioneApplicativo(StringEscapeUtils.escapeXml(datiSpecificiInvio.getDENOMINAZIONE_APPLICATIVO()));
		  
		JAXBElement<DatiSpecificiTypeMail> datiSpec = obj.createDatiSpecifici(datiSpecificiMail);
		
		return datiSpec;
	}
	
	private static JAXBElement<DatiSpecificiTypeValangheMail> buildDatiSpecificiValangheMail(DatiSpecificiInvio datiSpecificiInvio) throws DatatypeConfigurationException {
		
		it.eng.parer.xmlGen.valanghe.mail.ObjectFactory obj = new it.eng.parer.xmlGen.valanghe.mail.ObjectFactory();
	    DatiSpecificiTypeValangheMail datiSpecificiMail =  obj.createDatiSpecificiType();
	    datiSpecificiMail.setVersioneDatiSpecifici(StringEscapeUtils.escapeXml(String.valueOf(datiSpecificiInvio.getVERSIONE_DATI_SPECIFICI())));
			  
		datiSpecificiMail.setDataGenerazione(StringEscapeUtils.escapeXml(formattaData(datiSpecificiInvio.getDATA_GENERAZIONE())));

		datiSpecificiMail.setNumeroComunicazione((StringEscapeUtils.escapeXml(datiSpecificiInvio.getIDENTIFICATIVO_DATO_SPECIFICO())));
		datiSpecificiMail.setTipoComunicazione(StringEscapeUtils.escapeXml(TIPO_COMUNICAZIONE_VALANGHE));		
		datiSpecificiMail.setOggettoMail(StringEscapeUtils.escapeXml(datiSpecificiInvio.getOGGETTO_MAIL()));
		datiSpecificiMail.setTestoMail(StringEscapeUtils.escapeXml(datiSpecificiInvio.getTESTO_MAIL()));
		datiSpecificiMail.setDenominazioneApplicativo(StringEscapeUtils.escapeXml(datiSpecificiInvio.getDENOMINAZIONE_APPLICATIVO()));
		  
		JAXBElement<DatiSpecificiTypeValangheMail> datiSpec = obj.createDatiSpecifici(datiSpecificiMail);
		
		return datiSpec;
	}
	
	
	private static JAXBElement<DatiSpecificiTypeSuperamentoSms> buildDatiSpecificiSuperamentoSms(DatiSpecificiInvio datiSpec) throws DatatypeConfigurationException {
		it.eng.parer.xmlGen.superamento.sms.ObjectFactory obj = new it.eng.parer.xmlGen.superamento.sms.ObjectFactory();
		DatiSpecificiTypeSuperamentoSms datiSpecificiSuperamentoSms =  obj.createDatiSpecificiType();
		datiSpecificiSuperamentoSms.setVersioneDatiSpecifici(StringEscapeUtils.escapeXml(String.valueOf(datiSpec.getVERSIONE_DATI_SPECIFICI())));

		
		datiSpecificiSuperamentoSms.setDataGenerazione(StringEscapeUtils.escapeXml(formattaData(datiSpec.getDATA_GENERAZIONE())));

		datiSpecificiSuperamentoSms.setNumeroSuperamento(StringEscapeUtils.escapeXml(datiSpec.getIDENTIFICATIVO_DATO_SPECIFICO()));
		datiSpecificiSuperamentoSms.setDenominazioneSensoreRilevamento(StringEscapeUtils.escapeXml(datiSpec.getDENOMINAZIONE_SENSORE_RILEVAMENTO()));
		datiSpecificiSuperamentoSms.setRegolaAllarmeDescrizione(StringEscapeUtils.escapeXml(datiSpec.getREGOLA_ALLARME_DESCRIZIONE()));
		datiSpecificiSuperamentoSms.setRegolaAllarmeid(StringEscapeUtils.escapeXml(datiSpec.getREGOLA_ALLARME_ID()));
		datiSpecificiSuperamentoSms.setRegolaAllarmeNome(StringEscapeUtils.escapeXml(datiSpec.getREGOLA_ALLARME_NOME()));
		datiSpecificiSuperamentoSms.setNumeroNotificheDiRicezione(new BigInteger(String.valueOf(datiSpec.getNUM_NOTIFICHE_RICEZIONE())));
		datiSpecificiSuperamentoSms.setNumeroSMSGenerati(new BigInteger( String.valueOf(datiSpec.getNUM_SMS_GENERATI())));
		datiSpecificiSuperamentoSms.setNumeroSMSInviati(new BigInteger (String.valueOf( datiSpec.getNUM_SMS_INVIATI())));
		datiSpecificiSuperamentoSms.setDenominazioneApplicativo(StringEscapeUtils.escapeXml(datiSpec.getDENOMINAZIONE_APPLICATIVO()));
		  
		JAXBElement<DatiSpecificiTypeSuperamentoSms> datiSpecSupSms = obj.createDatiSpecifici(datiSpecificiSuperamentoSms);
		
		return datiSpecSupSms;
	}


	private static JAXBElement<DatiSpecificiTypeSuperamentoMail> buildDatiSpecificiSuperamentoMail(DatiSpecificiInvio datiSpec) throws DatatypeConfigurationException {
		it.eng.parer.xmlGen.superamento.mail.ObjectFactory obj = new it.eng.parer.xmlGen.superamento.mail.ObjectFactory();
		DatiSpecificiTypeSuperamentoMail datiSpecificiSuperamentoMail =  obj.createDatiSpecificiType();
		datiSpecificiSuperamentoMail.setVersioneDatiSpecifici(StringEscapeUtils.escapeXml(String.valueOf(datiSpec.getVERSIONE_DATI_SPECIFICI())));

		datiSpecificiSuperamentoMail.setDataGenerazione(StringEscapeUtils.escapeXml(formattaData(datiSpec.getDATA_GENERAZIONE())));

		datiSpecificiSuperamentoMail.setNumeroSuperamento(StringEscapeUtils.escapeXml(datiSpec.getIDENTIFICATIVO_DATO_SPECIFICO()));
		datiSpecificiSuperamentoMail.setDenominazioneSensoreRilevamento(StringEscapeUtils.escapeXml(datiSpec.getDENOMINAZIONE_SENSORE_RILEVAMENTO()));
		datiSpecificiSuperamentoMail.setRegolaAllarmeDescrizione(StringEscapeUtils.escapeXml(datiSpec.getREGOLA_ALLARME_DESCRIZIONE()));
		datiSpecificiSuperamentoMail.setRegolaAllarmeid(StringEscapeUtils.escapeXml(datiSpec.getREGOLA_ALLARME_ID()));
		datiSpecificiSuperamentoMail.setRegolaAllarmeNome(StringEscapeUtils.escapeXml(datiSpec.getREGOLA_ALLARME_NOME()));
		datiSpecificiSuperamentoMail.setOggettoMail(StringEscapeUtils.escapeXml(datiSpec.getOGGETTO_MAIL()));
		datiSpecificiSuperamentoMail.setTestoMail(StringEscapeUtils.escapeXml(datiSpec.getTESTO_MAIL()));
		datiSpecificiSuperamentoMail.setDenominazioneApplicativo(StringEscapeUtils.escapeXml(datiSpec.getDENOMINAZIONE_APPLICATIVO()));
		  
		JAXBElement<DatiSpecificiTypeSuperamentoMail> datiSpecSupMail = obj.createDatiSpecifici(datiSpecificiSuperamentoMail);
		
		return datiSpecSupMail;
	}


	private static JAXBElement<DatiSpecificiTypeMonitoraggioSms> buildDatiSpecificiMonitoraggioSms(DatiSpecificiInvio datiSpec) throws DatatypeConfigurationException {
		it.eng.parer.xmlGen.monitoraggio.sms.ObjectFactory obj = new it.eng.parer.xmlGen.monitoraggio.sms.ObjectFactory();
		DatiSpecificiTypeMonitoraggioSms datiSpecificiSuperamentoMonitorSms =  obj.createDatiSpecificiType();
		datiSpecificiSuperamentoMonitorSms.setVersioneDatiSpecifici(StringEscapeUtils.escapeXml(String.valueOf(datiSpec.getVERSIONE_DATI_SPECIFICI())));

		datiSpecificiSuperamentoMonitorSms.setDataGenerazione(StringEscapeUtils.escapeXml(formattaData(datiSpec.getDATA_GENERAZIONE())));
		
		datiSpecificiSuperamentoMonitorSms.setNumeroComunicazione(StringEscapeUtils.escapeXml(datiSpec.getIDENTIFICATIVO_DATO_SPECIFICO()));
		datiSpecificiSuperamentoMonitorSms.setTipoComunicazione(StringEscapeUtils.escapeXml(TIPO_COMUNICAZIONE_MONITORAGGIO));
		datiSpecificiSuperamentoMonitorSms.setNumeroNotificheDiRicezione(new BigInteger(String.valueOf(datiSpec.getNUM_NOTIFICHE_RICEZIONE())));
		datiSpecificiSuperamentoMonitorSms.setNumeroSMSGenerati(new BigInteger( String.valueOf(datiSpec.getNUM_SMS_GENERATI())));
		datiSpecificiSuperamentoMonitorSms.setNumeroSMSInviati(new BigInteger (String.valueOf( datiSpec.getNUM_SMS_INVIATI())));
		datiSpecificiSuperamentoMonitorSms.setDenominazioneApplicativo(StringEscapeUtils.escapeXml(datiSpec.getDENOMINAZIONE_APPLICATIVO()));
		  
		JAXBElement<DatiSpecificiTypeMonitoraggioSms> datiSpecMonitorSms = obj.createDatiSpecifici(datiSpecificiSuperamentoMonitorSms);
		
		return datiSpecMonitorSms;
	}


	private static JAXBElement<DatiSpecificiTypeMonitoraggioMail> buildDatiSpecificiMonitoraggioMail(DatiSpecificiInvio datiSpec) throws DatatypeConfigurationException {
		it.eng.parer.xmlGen.monitoraggio.mail.ObjectFactory obj = new it.eng.parer.xmlGen.monitoraggio.mail.ObjectFactory();
		DatiSpecificiTypeMonitoraggioMail datiSpecificiMonitorMail =  obj.createDatiSpecificiType();
		datiSpecificiMonitorMail.setVersioneDatiSpecifici(StringEscapeUtils.escapeXml(String.valueOf(datiSpec.getVERSIONE_DATI_SPECIFICI())));
	
		datiSpecificiMonitorMail.setDataGenerazione(StringEscapeUtils.escapeXml(formattaData(datiSpec.getDATA_GENERAZIONE())));

		datiSpecificiMonitorMail.setNumeroComunicazione(StringEscapeUtils.escapeXml(datiSpec.getIDENTIFICATIVO_DATO_SPECIFICO()));
		datiSpecificiMonitorMail.setTipoComunicazione(StringEscapeUtils.escapeXml(TIPO_COMUNICAZIONE_MONITORAGGIO));
		datiSpecificiMonitorMail.setOggettoMail(StringEscapeUtils.escapeXml(datiSpec.getOGGETTO_MAIL()));
		datiSpecificiMonitorMail.setTestoMail(StringEscapeUtils.escapeXml(datiSpec.getTESTO_MAIL()));
		datiSpecificiMonitorMail.setDenominazioneApplicativo(StringEscapeUtils.escapeXml(datiSpec.getDENOMINAZIONE_APPLICATIVO()));
		  
		JAXBElement<DatiSpecificiTypeMonitoraggioMail> datiSpecMonitorMail = obj.createDatiSpecifici(datiSpecificiMonitorMail);
		
		return datiSpecMonitorMail;
	}


	private static JAXBElement<DatiSpecificiTypeMonitoraggio> buildDatiSpecificiMonitoraggio(DatiSpecificiInvio datiSpec) throws DatatypeConfigurationException {
		it.eng.parer.xmlGen.monitoraggio.ObjectFactory obj = new it.eng.parer.xmlGen.monitoraggio.ObjectFactory();
		DatiSpecificiTypeMonitoraggio datiSpecificiMonitoraggio =  obj.createDatiSpecificiType();
		datiSpecificiMonitoraggio.setVersioneDatiSpecifici(StringEscapeUtils.escapeXml(String.valueOf(datiSpec.getVERSIONE_DATI_SPECIFICI())));
		datiSpecificiMonitoraggio.setApprovatoreARPAE(StringEscapeUtils.escapeXml(datiSpec.getAPPROVATORE_ARPAE()));
		datiSpecificiMonitoraggio.setCompilatore(StringEscapeUtils.escapeXml(datiSpec.getCOMPILATORE_ARPAE()));

			
		datiSpecificiMonitoraggio.setDataCreazione(StringEscapeUtils.escapeXml(formattaData(datiSpec.getDATA_GENERAZIONE())));
		datiSpecificiMonitoraggio.setDataFineValidita(StringEscapeUtils.escapeXml(formattaData(datiSpec.getDATA_FINE_VALIDITA())));
		datiSpecificiMonitoraggio.setDataInizioValidita(StringEscapeUtils.escapeXml(formattaData(datiSpec.getDATA_INIZIO_VALIDITA())));
		datiSpecificiMonitoraggio.setDataFirmaARPAE(StringEscapeUtils.escapeXml(formattaData(datiSpec.getDATA_FIRMA_ARPAE())));
		
		datiSpecificiMonitoraggio.setInvioResponsabiliTerritorio(StringEscapeUtils.escapeXml(datiSpec.getINVIO_RESPONSABILE_TERRITORIO()));
		datiSpecificiMonitoraggio.setMonitoraggioID(StringEscapeUtils.escapeXml(datiSpec.getIDENTIFICATIVO_DATO_SPECIFICO()));
		  
		JAXBElement<DatiSpecificiTypeMonitoraggio> datiSpecMonitor = obj.createDatiSpecifici(datiSpecificiMonitoraggio);
		
		return datiSpecMonitor;
	}


	private static JAXBElement<DatiSpecificiTypeSms> buildDatiSpecificiAllertaSms(DatiSpecificiInvio datiSpec) throws DatatypeConfigurationException {
		it.eng.parer.xmlGen.allerta.sms.ObjectFactory obj = new it.eng.parer.xmlGen.allerta.sms.ObjectFactory();
		DatiSpecificiTypeSms datiSpecificiAllertaSms =  obj.createDatiSpecificiType();
		datiSpecificiAllertaSms.setVersioneDatiSpecifici(StringEscapeUtils.escapeXml(String.valueOf(datiSpec.getVERSIONE_DATI_SPECIFICI())));

		datiSpecificiAllertaSms.setDataGenerazione(StringEscapeUtils.escapeXml(formattaData(datiSpec.getDATA_GENERAZIONE())));
		
		datiSpecificiAllertaSms.setNumeroComunicazione(StringEscapeUtils.escapeXml(datiSpec.getIDENTIFICATIVO_DATO_SPECIFICO()));
		datiSpecificiAllertaSms.setTipoComunicazione(StringEscapeUtils.escapeXml(TIPO_COMUNICAZIONE_ALLERTA));
		datiSpecificiAllertaSms.setNumeroNotificheDiRicezione(new BigInteger(String.valueOf(datiSpec.getNUM_NOTIFICHE_RICEZIONE())));
		datiSpecificiAllertaSms.setNumeroSMSGenerati(new BigInteger( String.valueOf(datiSpec.getNUM_SMS_GENERATI())));
		datiSpecificiAllertaSms.setNumeroSMSInviati(new BigInteger (String.valueOf( datiSpec.getNUM_SMS_INVIATI())));
		datiSpecificiAllertaSms.setDenominazioneApplicativo(StringEscapeUtils.escapeXml(datiSpec.getDENOMINAZIONE_APPLICATIVO()));
		  
		JAXBElement<DatiSpecificiTypeSms> datiSpecAllertaSms = obj.createDatiSpecifici(datiSpecificiAllertaSms);
		
		return datiSpecAllertaSms;
	}
	
	private static JAXBElement<DatiSpecificiTypeValangheSms> buildDatiSpecificiValangheSms(DatiSpecificiInvio datiSpec) throws DatatypeConfigurationException {
		it.eng.parer.xmlGen.valanghe.sms.ObjectFactory obj = new it.eng.parer.xmlGen.valanghe.sms.ObjectFactory();
		DatiSpecificiTypeValangheSms datiSpecificiAllertaSms =  obj.createDatiSpecificiType();
		datiSpecificiAllertaSms.setVersioneDatiSpecifici(StringEscapeUtils.escapeXml(String.valueOf(datiSpec.getVERSIONE_DATI_SPECIFICI())));

		datiSpecificiAllertaSms.setDataGenerazione(StringEscapeUtils.escapeXml(formattaData(datiSpec.getDATA_GENERAZIONE())));
		
		datiSpecificiAllertaSms.setNumeroComunicazione(StringEscapeUtils.escapeXml(datiSpec.getIDENTIFICATIVO_DATO_SPECIFICO()));
		datiSpecificiAllertaSms.setTipoComunicazione(StringEscapeUtils.escapeXml(TIPO_COMUNICAZIONE_VALANGHE));
		datiSpecificiAllertaSms.setNumeroNotificheDiRicezione(new BigInteger(String.valueOf(datiSpec.getNUM_NOTIFICHE_RICEZIONE())));
		datiSpecificiAllertaSms.setNumeroSMSGenerati(new BigInteger( String.valueOf(datiSpec.getNUM_SMS_GENERATI())));
		datiSpecificiAllertaSms.setNumeroSMSInviati(new BigInteger (String.valueOf( datiSpec.getNUM_SMS_INVIATI())));
		datiSpecificiAllertaSms.setDenominazioneApplicativo(StringEscapeUtils.escapeXml(datiSpec.getDENOMINAZIONE_APPLICATIVO()));
		  
		JAXBElement<DatiSpecificiTypeValangheSms> datiSpecAllertaSms = obj.createDatiSpecifici(datiSpecificiAllertaSms);
		
		return datiSpecAllertaSms;
	}

	private static JAXBElement<DatiSpecificiTypeAllerta> buildDatiSpecificiAllerta(DatiSpecificiInvio datiSpec) throws DatatypeConfigurationException {
		it.eng.parer.xmlGen.allerta.ObjectFactory obj = new it.eng.parer.xmlGen.allerta.ObjectFactory();
		DatiSpecificiTypeAllerta datiSpecificiAllerta =  obj.createDatiSpecificiType();
		datiSpecificiAllerta.setVersioneDatiSpecifici(StringEscapeUtils.escapeXml(String.valueOf(datiSpec.getVERSIONE_DATI_SPECIFICI())));

		datiSpecificiAllerta.setDataCreazione(StringEscapeUtils.escapeXml(formattaData(datiSpec.getDATA_GENERAZIONE())));
		datiSpecificiAllerta.setAllertaID(StringEscapeUtils.escapeXml(datiSpec.getIDENTIFICATIVO_DATO_SPECIFICO()));
		datiSpecificiAllerta.setApprovatoreARPAE(StringEscapeUtils.escapeXml(datiSpec.getAPPROVATORE_ARPAE()));
		datiSpecificiAllerta.setApprovatoreProtezioneCivile(StringEscapeUtils.escapeXml(datiSpec.getAPPROVATORE_PROTEZIONE_CIVILE()));
		datiSpecificiAllerta.setCompilatoreARPAE(StringEscapeUtils.escapeXml(datiSpec.getCOMPILATORE_ARPAE()));
		datiSpecificiAllerta.setCompilatoreProtezioneCivile(StringEscapeUtils.escapeXml(datiSpec.getCOMPILATORE_PROTEZIONE_CIVILE()));

		datiSpecificiAllerta.setDataInizioValidita(StringEscapeUtils.escapeXml(formattaData(datiSpec.getDATA_INIZIO_VALIDITA())));
		datiSpecificiAllerta.setDataFineValidita(StringEscapeUtils.escapeXml(formattaData(datiSpec.getDATA_FINE_VALIDITA())));
		datiSpecificiAllerta.setDataFirmaARPAE(StringEscapeUtils.escapeXml(formattaData(datiSpec.getDATA_FIRMA_ARPAE())));
		datiSpecificiAllerta.setDataFirmaProtezioneCivile(StringEscapeUtils.escapeXml(formattaData(datiSpec.getDATA_FIRMA_PROTEZIONE_CIVILE())));
		
		datiSpecificiAllerta.setInvioResponsabiliTerritorio(StringEscapeUtils.escapeXml(datiSpec.getINVIO_RESPONSABILE_TERRITORIO()));		
		  
		JAXBElement<DatiSpecificiTypeAllerta> datiSpecAllerta = obj.createDatiSpecifici(datiSpecificiAllerta);
		
		return datiSpecAllerta;
	}
	
	private static JAXBElement<DatiSpecificiTypeValanghe> buildDatiSpecificiValanghe(DatiSpecificiInvio datiSpec) throws DatatypeConfigurationException {
		it.eng.parer.xmlGen.valanghe.ObjectFactory obj = new it.eng.parer.xmlGen.valanghe.ObjectFactory();
		DatiSpecificiTypeValanghe datiSpecificiAllerta =  obj.createDatiSpecificiType();
		datiSpecificiAllerta.setVersioneDatiSpecifici(StringEscapeUtils.escapeXml(String.valueOf(datiSpec.getVERSIONE_DATI_SPECIFICI())));

		datiSpecificiAllerta.setDataCreazione(StringEscapeUtils.escapeXml(formattaData(datiSpec.getDATA_GENERAZIONE())));
		datiSpecificiAllerta.setBollettinoValangheID(StringEscapeUtils.escapeXml(datiSpec.getIDENTIFICATIVO_DATO_SPECIFICO()));
		datiSpecificiAllerta.setApprovatoreProtezioneCivile(StringEscapeUtils.escapeXml(datiSpec.getAPPROVATORE_PROTEZIONE_CIVILE()));
		datiSpecificiAllerta.setCompilatoreARPAE(StringEscapeUtils.escapeXml(datiSpec.getCOMPILATORE_ARPAE()));

		datiSpecificiAllerta.setDataInizioValidita(StringEscapeUtils.escapeXml(formattaData(datiSpec.getDATA_INIZIO_VALIDITA())));
		datiSpecificiAllerta.setDataFineValidita(StringEscapeUtils.escapeXml(formattaData(datiSpec.getDATA_FINE_VALIDITA())));
		datiSpecificiAllerta.setDataFirmaProtezioneCivile(StringEscapeUtils.escapeXml(formattaData(datiSpec.getDATA_FIRMA_PROTEZIONE_CIVILE())));
		
		datiSpecificiAllerta.setInvioResponsabiliTerritorio(StringEscapeUtils.escapeXml(datiSpec.getINVIO_RESPONSABILE_TERRITORIO()));		
		  
		JAXBElement<DatiSpecificiTypeValanghe> datiSpecAllerta = obj.createDatiSpecifici(datiSpecificiAllerta);
		
		return datiSpecAllerta;
	}

	private static JAXBElement<DatiSpecificiTypeBollettino> buildDatiSpecificiBollettino(DatiSpecificiInvio datiSpec) throws DatatypeConfigurationException {
		it.eng.parer.xmlGen.allerta.bollettino.ObjectFactory obj = new it.eng.parer.xmlGen.allerta.bollettino.ObjectFactory();
		DatiSpecificiTypeBollettino datiSpecificiAllertaBollettino =  obj.createDatiSpecificiType();
		datiSpecificiAllertaBollettino.setVersioneDatiSpecifici(StringEscapeUtils.escapeXml(String.valueOf(datiSpec.getVERSIONE_DATI_SPECIFICI())));

		datiSpecificiAllertaBollettino.setDataCreazione(StringEscapeUtils.escapeXml(formattaData(datiSpec.getDATA_GENERAZIONE())));
		
		datiSpecificiAllertaBollettino.setAllertaID(StringEscapeUtils.escapeXml(datiSpec.getIDENTIFICATIVO_DATO_SPECIFICO()));
		datiSpecificiAllertaBollettino.setApprovatoreARPAE(StringEscapeUtils.escapeXml(datiSpec.getAPPROVATORE_ARPAE()));
		datiSpecificiAllertaBollettino.setApprovatoreProtezioneCivile(StringEscapeUtils.escapeXml(datiSpec.getAPPROVATORE_PROTEZIONE_CIVILE()));
		datiSpecificiAllertaBollettino.setCompilatoreARPAE(StringEscapeUtils.escapeXml(datiSpec.getCOMPILATORE_ARPAE()));
		datiSpecificiAllertaBollettino.setCompilatoreProtezioneCivile(StringEscapeUtils.escapeXml(datiSpec.getCOMPILATORE_PROTEZIONE_CIVILE()));

		datiSpecificiAllertaBollettino.setDataInizioValidita(StringEscapeUtils.escapeXml(formattaData(datiSpec.getDATA_INIZIO_VALIDITA())));
		datiSpecificiAllertaBollettino.setDataFineValidita(StringEscapeUtils.escapeXml(formattaData(datiSpec.getDATA_FINE_VALIDITA())));
		datiSpecificiAllertaBollettino.setDataFirmaARPAE(StringEscapeUtils.escapeXml(formattaData(datiSpec.getDATA_FIRMA_ARPAE())));
		datiSpecificiAllertaBollettino.setDataFirmaProtezioneCivile(StringEscapeUtils.escapeXml(formattaData(datiSpec.getDATA_FIRMA_PROTEZIONE_CIVILE())));
		
		datiSpecificiAllertaBollettino.setInvioResponsabiliTerritorio(StringEscapeUtils.escapeXml(datiSpec.getINVIO_RESPONSABILE_TERRITORIO()));		
		  
		JAXBElement<DatiSpecificiTypeBollettino> datiSpecAllertaBollettino = obj.createDatiSpecifici(datiSpecificiAllertaBollettino);
		
		return datiSpecAllertaBollettino;
	}
	

	/**
	 * Formatta la data nel formata richiesto per l'invio
	 * 
	 * @param date
	 * @return
	 */
	@SuppressWarnings("unused")
	private static String formattaData(Date date) {
		
		Calendar calendar = GregorianCalendar.getInstance(); 
	  	calendar.setTime(date);   
	  	  
	  	int anno =  calendar.get(Calendar.YEAR);
	  	int mese = calendar.get(Calendar.MONTH)+1;
	  	int giorno = calendar.get(Calendar.DAY_OF_MONTH);
	  	int ora = calendar.get(Calendar.HOUR_OF_DAY);
	  	int min = calendar.get(Calendar.MINUTE);
	  	int mm =  calendar.get(Calendar.MILLISECOND);

	  	
	  	//Creo le stringhe per la concatenazione (calendar ritorna un intero senza "doppia" cifra)
	  	String meseStr = formatTime(mese);
	  	String giornoStr = formatTime(giorno);
	  	String oraStr = formatTime(ora);
	  	String minStr = formatTime(min);
	  	String mmStri = formatTime(mm);
	  	
	  	String dataFormat = String.valueOf(anno)+"-"+meseStr+"-"+giornoStr+"T"+oraStr+":"+minStr+":00";
		
		return dataFormat;
	}
	
	/**
	 * 
	 * @param time
	 * @return
	 */
	private static String formatTime(int time){
		return time < 10 ? "0".concat(String.valueOf(time)):String.valueOf(time);
	}
	
	
	private static String dateUtilToString(Date data) {
		
		Format formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String dataStr = formatter.format(data);
		return dataStr;
		
	}
	
	
//	/**
//	 * Il metodo ritorna un FILE xml di TEST sotto forma di String 
//	 * 
//	 * @param datiSpecifici
//	 * @param listaDocumentiCollegati
//	 * @param tipoDatoDaInviare
//	 * @return
//	 * @throws DatatypeConfigurationException
//	 */
//	public static String generaXmlFileAsStringTest (DatiSpecificiInvio datiSpecifici, List<DocumentiCollegati> listaDocumentiCollegati, List<ComponentiInvio> listaComponenti, String tipoDatoDaInviare ) throws DatatypeConfigurationException  {
//
//		String fileAsString = generaXmlFileAsString(datiSpecifici, listaDocumentiCollegati, listaComponenti, tipoDatoDaInviare );
//	
//		return fileAsString;
//
//	}
//	
//	/**
//	 * Il metodo ritorna un FILE xml di TEST
//	 * 
//	 * @param datiSpecifici
//	 * @param listaDocumentiCollegati
//	 * @param tipoDatoDaInviare
//	 * @return
//	 * @throws DatatypeConfigurationException
//	 */
//	public static File generaXmlFileTest (DatiSpecificiInvio datiSpecifici, List<DocumentiCollegati> listaDocumentiCollegati, List<ComponentiInvio> listaComponenti, String tipoDatoDaInviare ) throws DatatypeConfigurationException  {
//	
//		File file = generaXmlFile(datiSpecifici, listaDocumentiCollegati, listaComponenti, tipoDatoDaInviare);
//	
//		return file;
//	}

}
