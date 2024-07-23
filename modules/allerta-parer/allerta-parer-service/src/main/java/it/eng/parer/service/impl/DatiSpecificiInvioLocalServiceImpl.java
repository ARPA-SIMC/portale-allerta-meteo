/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.eng.parer.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.Validator;

import it.eng.parer.model.ComponentiInvio;
import it.eng.parer.model.DatiSpecificiInvio;
import it.eng.parer.model.DocumentiCollegati;
import it.eng.parer.service.DatiSpecificiInvioServiceUtil;
import it.eng.parer.service.base.DatiSpecificiInvioLocalServiceBaseImpl;
import it.eng.parer.xmlGen.serviziVersamento.wsEsitoUnico.ECEsitoGeneraleType;
import it.eng.parer.xmlGen.serviziVersamento.wsEsitoUnico.EsitoVersamentoType;
import it.eng.parer.xmlGen.util.InvioDatiParer;
import it.eng.parer.xmlGen.util.JavaToXMLParer;
import it.eng.parer.xmlGen.util.TipoDatoDaInviare;

/**
 * The implementation of the dati specifici invio local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.parer.service.DatiSpecificiInvioLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Pratola_L
 * @see DatiSpecificiInvioLocalServiceBaseImpl
 */
public class DatiSpecificiInvioLocalServiceImpl
	extends DatiSpecificiInvioLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.parer.service.DatiSpecificiInvioLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.parer.service.DatiSpecificiInvioLocalServiceUtil</code>.
	 */
	
	private Log logger = LogFactoryUtil.getLog(DatiSpecificiInvioLocalServiceImpl.class);
	public static final String ESITO_INVIO_IN_INVIO = "IN";
	public static final String ESITO_INVIO_RE_INVIO = "RI";
	//LiferayFacesContext liferayFacesContext;

	/*ParerService () {
		try {
			liferayFacesContext = LiferayFacesContext.getInstance();
			userId = liferayFacesContext.getUser().getUserId();
			companyId = liferayFacesContext.getCompanyId();
			groupId = liferayFacesContext.getScopeGroupId(); 
			locale = liferayFacesContext.getLocale();
		} catch (Exception e) {}
	}*/
	/**
	 * 
	 * @param datiSpecificiBean
	 * @return
	 */
	public String comunicaDatiSpecificiInvioAllerta(DatiSpecificiInvio datiSpecifici, 
			List<DocumentiCollegati> documentiCollegati, List<ComponentiInvio> componentiInvio) {
		
		//Esito di default
		String esitoInvio = ESITO_INVIO_IN_INVIO;
		
		try {
			//costruisci xml per l'invio
			String xmlAllerta = generaFileXml(datiSpecifici, documentiCollegati,  componentiInvio, TipoDatoDaInviare.ALLERTA.getTipoDatoDaInviare());

			//inserisco con esito invio = "in invio" 
			//Serve per lo scheduler
			datiSpecifici.setESITO_INVIO(esitoInvio);
			
			//Inserimento in DatiSpecificiInvio e Documenti Collegati
			insertDatiSpecificiInvio(datiSpecifici, documentiCollegati, componentiInvio, TipoDatoDaInviare.ALLERTA.getTipoDatoDaInviare());
			
			//Carico i file (componenti) da inviare
			List<File> listaFileComponenti = caricaFileComponenti(componentiInvio);
			
			esitoInvio = invioDatiParer(datiSpecifici, esitoInvio, xmlAllerta, listaFileComponenti);

		} catch (SystemException | DatatypeConfigurationException | PortalException | IOException e) {
			logger.error(e);
		}
		return esitoInvio;
	}
	
	public String comunicaDatiSpecificiInvioValanghe(DatiSpecificiInvio datiSpecifici, 
			List<DocumentiCollegati> documentiCollegati, List<ComponentiInvio> componentiInvio) {
		
		//Esito di default
		String esitoInvio = ESITO_INVIO_IN_INVIO;
		
		try {
			//costruisci xml per l'invio
			String xmlAllerta = generaFileXml(datiSpecifici, documentiCollegati,  componentiInvio, TipoDatoDaInviare.VALANGHE.getTipoDatoDaInviare());

			//inserisco con esito invio = "in invio" 
			//Serve per lo scheduler
			datiSpecifici.setESITO_INVIO(esitoInvio);
			
			//Inserimento in DatiSpecificiInvio e Documenti Collegati
			insertDatiSpecificiInvio(datiSpecifici, documentiCollegati, componentiInvio, TipoDatoDaInviare.VALANGHE.getTipoDatoDaInviare());
			
			//Carico i file (componenti) da inviare
			List<File> listaFileComponenti = caricaFileComponenti(componentiInvio);
			
			esitoInvio = invioDatiParer(datiSpecifici, esitoInvio, xmlAllerta, listaFileComponenti);

		} catch (SystemException | DatatypeConfigurationException | PortalException | IOException e) {
			logger.error(e);
		}
		return esitoInvio;
	}

	/**
	 * 
	 * @param datiSpecificiBean
	 * @return
	 */
	public String comunicaDatiSpecificiInvioAllertaSms(DatiSpecificiInvio datiSpecifici, List<DocumentiCollegati> documentiCollegati, List<ComponentiInvio> componentiInvio ){

		//Esito di default
		String esitoInvio = ESITO_INVIO_IN_INVIO;

		try {
			
			//costruisci xml per l'invio
			String xmlAllerta = generaFileXml(datiSpecifici, documentiCollegati,  componentiInvio, TipoDatoDaInviare.ALLERTA_SMS.getTipoDatoDaInviare());

			//inserisco con esito invio = "in invio"
			//Serve per lo scheduler
			datiSpecifici.setESITO_INVIO(esitoInvio);
			
			//Inserimento in DatiSpecificiInvio e Documenti Collegati
			insertDatiSpecificiInvio(datiSpecifici, documentiCollegati, componentiInvio, TipoDatoDaInviare.ALLERTA_SMS.getTipoDatoDaInviare());
			
			//Carico i file (componenti) da inviare
			List<File> listaFileComponenti = caricaFileComponenti(componentiInvio);
			
			esitoInvio = invioDatiParer(datiSpecifici, esitoInvio, xmlAllerta, listaFileComponenti);

		} catch (SystemException | DatatypeConfigurationException | PortalException | IOException e) {
			logger.error(e);
		}
		return esitoInvio;
	}
	
	public String comunicaDatiSpecificiInvioValangheSms(DatiSpecificiInvio datiSpecifici, List<DocumentiCollegati> documentiCollegati, List<ComponentiInvio> componentiInvio ){

		//Esito di default
		String esitoInvio = ESITO_INVIO_IN_INVIO;

		try {
			
			//costruisci xml per l'invio
			String xmlAllerta = generaFileXml(datiSpecifici, documentiCollegati,  componentiInvio, TipoDatoDaInviare.VALANGHE_SMS.getTipoDatoDaInviare());

			//inserisco con esito invio = "in invio"
			//Serve per lo scheduler
			datiSpecifici.setESITO_INVIO(esitoInvio);
			
			//Inserimento in DatiSpecificiInvio e Documenti Collegati
			insertDatiSpecificiInvio(datiSpecifici, documentiCollegati, componentiInvio, TipoDatoDaInviare.VALANGHE_SMS.getTipoDatoDaInviare());
			
			//Carico i file (componenti) da inviare
			List<File> listaFileComponenti = caricaFileComponenti(componentiInvio);
			
			esitoInvio = invioDatiParer(datiSpecifici, esitoInvio, xmlAllerta, listaFileComponenti);

		} catch (SystemException | DatatypeConfigurationException | PortalException | IOException e) {
			logger.error(e);
		}
		return esitoInvio;
	}

	/**
	 * 
	 * @param datiSpecificiBean
	 * @return
	 */
	public String comunicaDatiSpecificiInvioAllertaMail(DatiSpecificiInvio datiSpecifici, List<DocumentiCollegati> documentiCollegati, List<ComponentiInvio> componentiInvio){

		//Esito di default
		String esitoInvio = ESITO_INVIO_IN_INVIO;

		try {
			//costruisci xml per l'invio
			String xmlAllerta = generaFileXml(datiSpecifici, documentiCollegati, componentiInvio, TipoDatoDaInviare.ALLERTA_MAIL.getTipoDatoDaInviare());

			//inserisco con esito invio = "in invio" 
			//Serve per lo scheduler
			datiSpecifici.setESITO_INVIO(esitoInvio);
			
			//Inserimento in DatiSpecificiInvio e Documenti Collegati
			insertDatiSpecificiInvio(datiSpecifici, documentiCollegati, componentiInvio, TipoDatoDaInviare.ALLERTA_MAIL.getTipoDatoDaInviare());
			
			//Carico i file (componenti) da inviare
			List<File> listaDocumenti = caricaFileComponenti(componentiInvio);

			esitoInvio = invioDatiParer(datiSpecifici, esitoInvio, xmlAllerta, listaDocumenti);

		} catch (SystemException | DatatypeConfigurationException | PortalException | IOException e) {
			logger.error(e);
		}
		return esitoInvio;
	}
	
	public String comunicaDatiSpecificiInvioValangheMail(DatiSpecificiInvio datiSpecifici, List<DocumentiCollegati> documentiCollegati, List<ComponentiInvio> componentiInvio){

		//Esito di default
		String esitoInvio = ESITO_INVIO_IN_INVIO;

		try {
			//costruisci xml per l'invio
			String xmlAllerta = generaFileXml(datiSpecifici, documentiCollegati, componentiInvio, TipoDatoDaInviare.VALANGHE_MAIL.getTipoDatoDaInviare());

			//inserisco con esito invio = "in invio" 
			//Serve per lo scheduler
			datiSpecifici.setESITO_INVIO(esitoInvio);
			
			//Inserimento in DatiSpecificiInvio e Documenti Collegati
			insertDatiSpecificiInvio(datiSpecifici, documentiCollegati, componentiInvio, TipoDatoDaInviare.VALANGHE_MAIL.getTipoDatoDaInviare());
			
			//Carico i file (componenti) da inviare
			List<File> listaDocumenti = caricaFileComponenti(componentiInvio);

			esitoInvio = invioDatiParer(datiSpecifici, esitoInvio, xmlAllerta, listaDocumenti);

		} catch (SystemException | DatatypeConfigurationException | PortalException | IOException e) {
			logger.error(e);
		}
		return esitoInvio;
	}
				
	/**
	 * 
	 * @param datiSpecificiBean
	 * @return
	 */
	public String comunicaDatiSpecificiInvioAllertaBollettino(DatiSpecificiInvio datiSpecifici, List<DocumentiCollegati> documentiCollegati, List<ComponentiInvio> componentiInvio){

		//Esito di default
		String esitoInvio = ESITO_INVIO_IN_INVIO;

		try {
			//costruisci xml per l'invio
			String xmlAllerta = generaFileXml(datiSpecifici, documentiCollegati, componentiInvio, TipoDatoDaInviare.ALLERTA_BOLLETTINO.getTipoDatoDaInviare());

			//inserisco con esito invio = "in invio" 
			//Serve per lo scheduler
			datiSpecifici.setESITO_INVIO(esitoInvio);
			
			//Inserimento in DatiSpecificiInvio e Documenti Collegati
			insertDatiSpecificiInvio(datiSpecifici, documentiCollegati, componentiInvio, TipoDatoDaInviare.ALLERTA_BOLLETTINO.getTipoDatoDaInviare());
			
			//Carico i file (componenti) da inviare
			List<File> listaFileComponenti = caricaFileComponenti(componentiInvio);
			
			esitoInvio = invioDatiParer(datiSpecifici, esitoInvio, xmlAllerta, listaFileComponenti);

		} catch (SystemException | DatatypeConfigurationException | PortalException | IOException e) {
			logger.error(e);
		}
		return esitoInvio;
	}

	/**
	 * 
	 * @param datiSpecificiBean
	 * @return
	 */
	public String comunicaDatiSpecificiInvioMonitoraggio(DatiSpecificiInvio datiSpecifici, List<DocumentiCollegati> documentiCollegati, List<ComponentiInvio> componentiInvio){

		//Esito di default
		String esitoInvio = ESITO_INVIO_IN_INVIO;

		try {
			//costruisci xml per l'invio
			String xmlAllerta = generaFileXml(datiSpecifici, documentiCollegati, componentiInvio, TipoDatoDaInviare.MONITORAGGIO.getTipoDatoDaInviare());

			//inserisco con esito invio = "in invio"
			//Serve per lo scheduler
			datiSpecifici.setESITO_INVIO(esitoInvio);
			
			//Inserimento in DatiSpecificiInvio e Documenti Collegati
			insertDatiSpecificiInvio(datiSpecifici, documentiCollegati, componentiInvio,  TipoDatoDaInviare.MONITORAGGIO.getTipoDatoDaInviare());
			
			//Carico i file (componenti) da inviare
			List<File> listaFileComponenti = caricaFileComponenti(componentiInvio);
			
			esitoInvio = invioDatiParer(datiSpecifici, esitoInvio, xmlAllerta, listaFileComponenti);

		} catch (SystemException | DatatypeConfigurationException | PortalException | IOException e) {
			logger.error(e);
		}
		return esitoInvio;
	}

	/**
	 * 
	 * @param datiSpecificiBean
	 * @return
	 */
	public String comunicaDatiSpecificiInvioMonitoraggioSms(DatiSpecificiInvio datiSpecifici, List<DocumentiCollegati> documentiCollegati, List<ComponentiInvio> componentiInvio){

		//Esito di default
		String esitoInvio = ESITO_INVIO_IN_INVIO;

		try {

			//costruisci xml per l'invio
			String xmlAllerta = generaFileXml(datiSpecifici, documentiCollegati, componentiInvio, TipoDatoDaInviare.MONITORAGGIO_SMS.getTipoDatoDaInviare());

			//inserisco con esito invio = "in invio" 
			//Serve per lo scheduler
			datiSpecifici.setESITO_INVIO(esitoInvio);
			
			//Inserimento in DatiSpecificiInvio e Documenti Collegati
			insertDatiSpecificiInvio(datiSpecifici, documentiCollegati, componentiInvio, TipoDatoDaInviare.MONITORAGGIO_SMS.getTipoDatoDaInviare());
			
			//Carico i file (componenti) da inviare
			List<File> listaFileComponenti = caricaFileComponenti(componentiInvio);
			
			esitoInvio = invioDatiParer(datiSpecifici, esitoInvio, xmlAllerta, listaFileComponenti);

		} catch (SystemException | DatatypeConfigurationException | PortalException | IOException e) {
			logger.error(e);
		}
		return esitoInvio;
	}

	/**
	 * 
	 * @param datiSpecificiBean
	 * @return
	 */
	public String comunicaDatiSpecificiInvioMonitoraggioMail(DatiSpecificiInvio datiSpecifici, List<DocumentiCollegati> documentiCollegati, List<ComponentiInvio> componentiInvio){

		//Esito di default
		String esitoInvio = ESITO_INVIO_IN_INVIO;
	
		try {
			//costruisci xml per l'invio
			String xmlAllerta = generaFileXml(datiSpecifici, documentiCollegati, componentiInvio, TipoDatoDaInviare.MONITORAGGIO_MAIL.getTipoDatoDaInviare());

			//inserisco con esito invio = "in invio" 
			//Serve per lo scheduler
			datiSpecifici.setESITO_INVIO(esitoInvio);
			
			//Inserimento in DatiSpecificiInvio e Documenti Collegati
			insertDatiSpecificiInvio(datiSpecifici, documentiCollegati, componentiInvio, TipoDatoDaInviare.MONITORAGGIO_MAIL.getTipoDatoDaInviare());
			
			//Carico i file (componenti) da inviare
			List<File> listaFileComponenti = caricaFileComponenti(componentiInvio);
			
			esitoInvio = invioDatiParer(datiSpecifici, esitoInvio, xmlAllerta, listaFileComponenti);

		} catch (SystemException | DatatypeConfigurationException | PortalException | IOException e) {
			logger.error(e);
		}
		return esitoInvio;
	}

	/**
	 * 
	 * @param datiSpecificiBean
	 * @return
	 */
	public String comunicaDatiSpecificiInvioSuperamentoSms(DatiSpecificiInvio datiSpecifici, List<DocumentiCollegati> documentiCollegati, List<ComponentiInvio> componentiInvio){

		//Esito di default
		String esitoInvio = ESITO_INVIO_IN_INVIO;

		try {
			//costruisci xml per l'invio
			String xmlAllerta = generaFileXml(datiSpecifici, documentiCollegati,  componentiInvio, TipoDatoDaInviare.SUPERAMENTO_SMS.getTipoDatoDaInviare());

			//inserisco con esito invio = "in invio" 
			//Serve per lo scheduler
			datiSpecifici.setESITO_INVIO(esitoInvio);
			
			//Inserimento in DatiSpecificiInvio e Documenti Collegati
			insertDatiSpecificiInvio(datiSpecifici, documentiCollegati, componentiInvio,  TipoDatoDaInviare.SUPERAMENTO_SMS.getTipoDatoDaInviare());
			
			//Carico i file (componenti) da inviare
			List<File> listaFileComponenti = caricaFileComponenti(componentiInvio);
			
			esitoInvio = invioDatiParer(datiSpecifici, esitoInvio, xmlAllerta, listaFileComponenti);

		} catch (SystemException | DatatypeConfigurationException | PortalException | IOException e) {
			logger.error(e);
		}
		return esitoInvio;
	}

	/**
	 * 
	 * @param datiSpecificiBean
	 * @return
	 */
	public String comunicaDatiSpecificiInvioSuperamentoMail(DatiSpecificiInvio datiSpecifici, List<DocumentiCollegati> documentiCollegati, List<ComponentiInvio> componentiInvio){

		//Esito di default
		String esitoInvio = ESITO_INVIO_IN_INVIO;
	
		try {
			//costruisci xml per l'invio
			String xmlAllerta = generaFileXml(datiSpecifici, documentiCollegati, componentiInvio, TipoDatoDaInviare.SUPERAMENTO_MAIL.getTipoDatoDaInviare());

			//inserisco con esito invio = "in invio"
			//Serve per lo scheduler
			datiSpecifici.setESITO_INVIO(esitoInvio);
			
			//Inserimento in DatiSpecificiInvio e Documenti Collegati
			insertDatiSpecificiInvio(datiSpecifici, documentiCollegati, componentiInvio, TipoDatoDaInviare.SUPERAMENTO_MAIL.getTipoDatoDaInviare());
			
			//Carico i file (componenti) da inviare
			List<File> listaFileComponenti = caricaFileComponenti(componentiInvio);
			
			esitoInvio = invioDatiParer(datiSpecifici, esitoInvio, xmlAllerta, listaFileComponenti);

		} catch (SystemException | DatatypeConfigurationException | PortalException | IOException e) {
			logger.error(e);
		}
		return esitoInvio;
	}
	
	
	/**
	 * 
	 * @param componentiInvio
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	private List<File> caricaFileComponenti(List<ComponentiInvio> componentiInvio) throws PortalException, SystemException {
		
		List<File> listaFileComponenti = new ArrayList<>();
		
		for(ComponentiInvio comp : componentiInvio) {
		
			DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(comp.getID_COMPONENTE_VERSATO());
			//File file = DLFileEntryLocalServiceUtil.getFile(userId, comp.getID_COMPONENTE_VERSATO(), dlFileEntry.getVersion(), false);
			try {
			File file = FileUtil.createTempFile(dlFileEntry.getContentStream());
			listaFileComponenti.add(file);
			} catch (Exception e) {
				File file = FileUtil.createTempFile();
				listaFileComponenti.add(file);
				e.printStackTrace();
			}
	
		}
		
		return listaFileComponenti;
	}


	/**
	 * 
	 * @param datiSpecifici
	 * @param esitoInvio
	 * @param xmlAllerta
	 * @return
	 * @throws SystemException
	 */
	private String invioDatiParer(DatiSpecificiInvio datiSpecifici, String esitoInvio, String xmlAllerta, List<File> listaDocomunti) throws SystemException {
	
		EsitoVersamentoType esitoVers = new EsitoVersamentoType();
		//imposto esito di default a KO
		esitoInvio = "KO";
		//Richiamo metodo per la comunicazione dei dati al PARER
		try {
			String response = InvioDatiParer.invioDatiParer(xmlAllerta, listaDocomunti, datiSpecifici.getVERSATORE_USER_ID());
			esitoVers = verificaEsito(response);
			//setto l'esito generale dell'invio
			esitoInvio = esitoVers.getEsitoGenerale().getCodiceEsito().value().equals("NEGATIVO")? "KO" : "OK";		
		}
		catch(Exception e) {
			logger.error(e);
		}
		finally {
			//Setto l'esito dell'invio e aggiorno
			if(null != esitoVers && null != esitoVers.getEsitoGenerale() && null!=esitoVers.getEsitoGenerale().getCodiceEsito()) {
				datiSpecifici.setCODICE_ESITO(esitoVers.getEsitoGenerale().getCodiceEsito().value());
			}
			if(null != esitoVers && null != esitoVers.getEsitoGenerale() && null!=esitoVers.getEsitoGenerale().getMessaggioErrore()) {
				datiSpecifici.setMESG_ERRORE(esitoVers.getEsitoGenerale().getMessaggioErrore());
			}
			if(null != esitoVers && null != esitoVers.getEsitoGenerale() && null!=esitoVers.getEsitoGenerale().getCodiceErrore()) {
				datiSpecifici.setCODICE_ERRORE(esitoVers.getEsitoGenerale().getCodiceErrore());
			}
			datiSpecifici.setESITO_INVIO(esitoInvio);
			datiSpecifici.setData_risposta(new Date());
			try {
				aggiornaDatiSpecificiInvio(datiSpecifici);
			}
			catch(Exception e) {
				logger.error(e);
			}
		}
		return esitoInvio;
	}


	private EsitoVersamentoType verificaEsito(String response) throws SAXException, IOException, 
		ParserConfigurationException, JAXBException {
		
		EsitoVersamentoType esitoVersamento = new EsitoVersamentoType();
		
//		String resp = "";
//		for(String respon : response){
//			resp =resp.concat(respon);
//		}
		
		if(Validator.isNotNull(response)) {
		
			JAXBContext jaxbContext = JAXBContext.newInstance(EsitoVersamentoType.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

			StringReader reader = new StringReader(response);
			esitoVersamento = (EsitoVersamentoType) unmarshaller.unmarshal(reader);
			
			reader.close();
				
		} else {
			//Non abbiamo avuto risposta per problemi di comunicazione con il server
			//Setto esito negativo
			ECEsitoGeneraleType esitoGen = new ECEsitoGeneraleType();
			esitoGen.setCodiceEsito(it.eng.parer.xmlGen.serviziVersamento.wsEsitoUnico.ECEsitoExtType.NEGATIVO);
			esitoVersamento.setEsitoGenerale(esitoGen);
		}
		
		
		return esitoVersamento;
	}
	/**
	 * 
	 * @param datiSpecifici
	 * @throws SystemException
	 */
	@Transactional(isolation = Isolation.PORTAL, propagation = Propagation.REQUIRED)
	private void aggiornaDatiSpecificiInvio(DatiSpecificiInvio datiSpecifici) throws SystemException {
		datiSpecificiInvioLocalService.updateDatiSpecificiInvio(datiSpecifici);
	}	

	/**
	 * 
	 * @param datiSpecifici
	 * @param documentiCollegati 
	 * @param componentiInvio 
	 * @param codiceTipoInvio 
	 * @throws Exception
	 */
	@Transactional(isolation = Isolation.PORTAL, propagation = Propagation.REQUIRED)
	private Long insertDatiSpecificiInvio(DatiSpecificiInvio datiSpecifici, List<DocumentiCollegati> documentiCollegati, List<ComponentiInvio> componentiInvio, String codiceTipoInvio) throws SystemException {

		//Se ho già valorizzato l'id (caso di reinvii con batch) non ne stacco uno nuovo ma aggiorno su quello esistente
		if(datiSpecifici.getID_INVIO() > 0) {
			//Aggiorno il vecchio con il codice esito "REINVIATO"
			datiSpecifici.setESITO_INVIO(ESITO_INVIO_RE_INVIO);
			aggiornaDatiSpecificiInvio(datiSpecifici);
		}
		
		//Stacco un nuovo id per "la copia" del nuovo oggetto che sto reinviando
		long id = counterLocalService.increment(DatiSpecificiInvio.class.getName());
		datiSpecifici.setID_INVIO(id);
					
		datiSpecifici.setUserId(20198);
		datiSpecifici.setCompanyId(20154);
		datiSpecifici.setGroupId(0);
		datiSpecifici.setData_invio(new Date());
		datiSpecifici.setCODICE_TIPO_INVIO(codiceTipoInvio);
		
		//inserisco in DatiSpecificiInvio
		datiSpecificiInvioLocalService.updateDatiSpecificiInvio(datiSpecifici);
		//setto l'id invio e inserisco in documenti collegati
		if(null != documentiCollegati) {
			for(DocumentiCollegati docCollegati : documentiCollegati) {
				if(null != docCollegati && Validator.isNotNull(docCollegati.getDOC_COLLEGATO_NUMERO())) {
					docCollegati.setID_INVIO(datiSpecifici.getID_INVIO());
					documentiCollegatiLocalService.updateDocumentiCollegati(docCollegati);
				}
			}
		}
		//setto l'id invio e inserisco in componenti invio
		for(ComponentiInvio compInvio : componentiInvio) {
			if(null != compInvio) {
				compInvio.setID_INVIO(datiSpecifici.getID_INVIO());
				componentiInvioLocalService.updateComponentiInvio(compInvio);
			}
		}
		
		return datiSpecifici.getID_INVIO();
	}

	/**
	 * 
	 * @param datiSpecifici
	 * @param documentiCollegati
	 * @param tipoDatoDaInviare
	 * @return
	 * @throws DatatypeConfigurationException
	 * @throws IOException 
	 */
	private String generaFileXml(DatiSpecificiInvio datiSpecifici, List<DocumentiCollegati> documentiCollegati, List<ComponentiInvio> listaComponenti ,String tipoDatoDaInviare) throws DatatypeConfigurationException, IOException {
		return JavaToXMLParer.generaXmlFileAsString(datiSpecifici, documentiCollegati, listaComponenti, tipoDatoDaInviare);
	}

	/**
	 * Ritorna una lista di dati specifici filtrata in base all'esito passato come paramentro
	 * 
	 * @param esitoInvio
	 * @return
	 */
	public List<DatiSpecificiInvio> listaDatiSpecificiByEsitoInvio(String esitoInvio) throws Exception {

		List<DatiSpecificiInvio> findByesitoInvio = new ArrayList<>();
		findByesitoInvio = DatiSpecificiInvioServiceUtil.listaDatiSpecificiByEsitoInvio(esitoInvio);
		//recupero la lista degli invii non processati
		return findByesitoInvio;

	}


}