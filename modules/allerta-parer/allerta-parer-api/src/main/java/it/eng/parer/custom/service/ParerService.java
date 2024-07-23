package it.eng.parer.custom.service;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang.StringUtils;
import org.xml.sax.SAXException;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import it.eng.parer.bean.DatiSpecificiBean;
import it.eng.parer.model.ComponentiInvio;
import it.eng.parer.model.DatiSpecificiInvio;
import it.eng.parer.model.DocumentiCollegati;
import it.eng.parer.service.ComponentiInvioLocalServiceUtil;
import it.eng.parer.service.ComponentiInvioServiceUtil;
import it.eng.parer.service.DatiSpecificiInvioLocalServiceUtil;
import it.eng.parer.service.DatiSpecificiInvioServiceUtil;
import it.eng.parer.service.DocumentiCollegatiLocalServiceUtil;
import it.eng.parer.service.DocumentiCollegatiServiceUtil;
import it.eng.parer.xmlGen.serviziVersamento.wsEsitoUnico.ECEsitoGeneraleType;
import it.eng.parer.xmlGen.serviziVersamento.wsEsitoUnico.EsitoVersamentoType;
import it.eng.parer.xmlGen.util.IJavaToXMLParerConstants;
import it.eng.parer.xmlGen.util.InvioDatiParer;
import it.eng.parer.xmlGen.util.JavaToXMLParer;
import it.eng.parer.xmlGen.util.TipoDatoDaInviare;

/**
 * 
 * Classe di servizio per invio dati al parer Contiene i metodi da invocare in
 * Allerte per procedere con l'invio al PARER.
 * 
 * 
 * @author Pratola_L
 *
 */
public class ParerService implements IJavaToXMLParerConstants {
	
	private Log logger = LogFactoryUtil.getLog(ParerService.class);

	long userId;
	long companyId;
	long groupId;
	Locale locale;

	public ParerService(long companyId, long groupId, long userId) {
		try {
			
			this.userId = userId;
			this.companyId = companyId;
			this.groupId = groupId;
			locale = Locale.ITALY;
			
		} catch (Exception e) {
		}
	}

	/**
	 * 
	 * @param datiSpecificiBean
	 * @return
	 * @throws IOException
	 */
	public String comunicaDatiSpecificiInvioAllerta(DatiSpecificiBean datiSpecificiBean) throws IOException {

		// Esito di default
		String esitoInvio = ESITO_INVIO_IN_INVIO;

		// Estraggo le info dal bean
		DatiSpecificiInvio datiSpecifici = datiSpecificiBean.getDatiSpecifici();
		List<DocumentiCollegati> documentiCollegati = datiSpecificiBean.getDocumentiCollegati();
		List<ComponentiInvio> componentiInvio = datiSpecificiBean.getComponenti();

		try {
			// costruisci xml per l'invio
			String xmlAllerta = generaFileXml(datiSpecifici, documentiCollegati, componentiInvio,
					TipoDatoDaInviare.ALLERTA.getTipoDatoDaInviare());

			// inserisco con esito invio = "in invio"
			// Serve per lo scheduler
			datiSpecifici.setESITO_INVIO(esitoInvio);

			// Inserimento in DatiSpecificiInvio e Documenti Collegati
			insertDatiSpecificiInvio(datiSpecifici, documentiCollegati, componentiInvio,
					TipoDatoDaInviare.ALLERTA.getTipoDatoDaInviare());

			// Carico i file (componenti) da inviare
			List<File> listaFileComponenti = caricaFileComponenti(componentiInvio);

			esitoInvio = invioDatiParer(datiSpecifici, esitoInvio, xmlAllerta, listaFileComponenti);

		} catch (SystemException | DatatypeConfigurationException | PortalException e) {
			logger.error(e);
		}
		return esitoInvio;
	}
	
	public String comunicaDatiSpecificiInvioValanghe(DatiSpecificiBean datiSpecificiBean) throws IOException {

		// Esito di default
		String esitoInvio = ESITO_INVIO_IN_INVIO;

		// Estraggo le info dal bean
		DatiSpecificiInvio datiSpecifici = datiSpecificiBean.getDatiSpecifici();
		List<DocumentiCollegati> documentiCollegati = datiSpecificiBean.getDocumentiCollegati();
		List<ComponentiInvio> componentiInvio = datiSpecificiBean.getComponenti();

		try {
			// costruisci xml per l'invio
			String xmlAllerta = generaFileXml(datiSpecifici, documentiCollegati, componentiInvio,
					TipoDatoDaInviare.VALANGHE.getTipoDatoDaInviare());

			// inserisco con esito invio = "in invio"
			// Serve per lo scheduler
			datiSpecifici.setESITO_INVIO(esitoInvio);

			// Inserimento in DatiSpecificiInvio e Documenti Collegati
			insertDatiSpecificiInvio(datiSpecifici, documentiCollegati, componentiInvio,
					TipoDatoDaInviare.VALANGHE.getTipoDatoDaInviare());

			// Carico i file (componenti) da inviare
			List<File> listaFileComponenti = caricaFileComponenti(componentiInvio);

			esitoInvio = invioDatiParer(datiSpecifici, esitoInvio, xmlAllerta, listaFileComponenti);

		} catch (SystemException | DatatypeConfigurationException | PortalException e) {
			logger.error(e);
		}
		return esitoInvio;
	}

	/**
	 * 
	 * @param datiSpecificiBean
	 * @return
	 * @throws IOException
	 */
	public String comunicaDatiSpecificiInvioAllertaSms(DatiSpecificiBean datiSpecificiBean) throws IOException {

		// Esito di default
		String esitoInvio = ESITO_INVIO_IN_INVIO;

		// Estraggo le info dal bean
		DatiSpecificiInvio datiSpecifici = datiSpecificiBean.getDatiSpecifici();
		List<DocumentiCollegati> documentiCollegati = datiSpecificiBean.getDocumentiCollegati();
		List<ComponentiInvio> componentiInvio = datiSpecificiBean.getComponenti();

		try {

			// costruisci xml per l'invio
			String xmlAllerta = generaFileXml(datiSpecifici, documentiCollegati, componentiInvio,
					TipoDatoDaInviare.ALLERTA_SMS.getTipoDatoDaInviare());

			// inserisco con esito invio = "in invio"
			// Serve per lo scheduler
			datiSpecifici.setESITO_INVIO(esitoInvio);

			// Inserimento in DatiSpecificiInvio e Documenti Collegati
			insertDatiSpecificiInvio(datiSpecifici, documentiCollegati, componentiInvio,
					TipoDatoDaInviare.ALLERTA_SMS.getTipoDatoDaInviare());

			// Carico i file (componenti) da inviare
			List<File> listaFileComponenti = caricaFileComponenti(componentiInvio);

			esitoInvio = invioDatiParer(datiSpecifici, esitoInvio, xmlAllerta, listaFileComponenti);

		} catch (SystemException | DatatypeConfigurationException | PortalException e) {
			logger.error(e);
		}
		return esitoInvio;
	}
	
	public String comunicaDatiSpecificiInvioValangheSms(DatiSpecificiBean datiSpecificiBean) throws IOException {

		// Esito di default
		String esitoInvio = ESITO_INVIO_IN_INVIO;

		// Estraggo le info dal bean
		DatiSpecificiInvio datiSpecifici = datiSpecificiBean.getDatiSpecifici();
		List<DocumentiCollegati> documentiCollegati = datiSpecificiBean.getDocumentiCollegati();
		List<ComponentiInvio> componentiInvio = datiSpecificiBean.getComponenti();

		try {

			// costruisci xml per l'invio
			String xmlAllerta = generaFileXml(datiSpecifici, documentiCollegati, componentiInvio,
					TipoDatoDaInviare.VALANGHE_SMS.getTipoDatoDaInviare());

			// inserisco con esito invio = "in invio"
			// Serve per lo scheduler
			datiSpecifici.setESITO_INVIO(esitoInvio);

			// Inserimento in DatiSpecificiInvio e Documenti Collegati
			insertDatiSpecificiInvio(datiSpecifici, documentiCollegati, componentiInvio,
					TipoDatoDaInviare.VALANGHE_SMS.getTipoDatoDaInviare());

			// Carico i file (componenti) da inviare
			List<File> listaFileComponenti = caricaFileComponenti(componentiInvio);

			esitoInvio = invioDatiParer(datiSpecifici, esitoInvio, xmlAllerta, listaFileComponenti);

		} catch (SystemException | DatatypeConfigurationException | PortalException e) {
			logger.error(e);
		}
		return esitoInvio;
	}

	/**
	 * 
	 * @param datiSpecificiBean
	 * @return
	 * @throws IOException
	 */
	public String comunicaDatiSpecificiInvioAllertaMail(DatiSpecificiBean datiSpecificiBean) throws IOException {

		// Esito di default
		String esitoInvio = ESITO_INVIO_IN_INVIO;

		// Estraggo le info dal bean
		DatiSpecificiInvio datiSpecifici = datiSpecificiBean.getDatiSpecifici();
		List<DocumentiCollegati> documentiCollegati = datiSpecificiBean.getDocumentiCollegati();
		List<ComponentiInvio> componentiInvio = datiSpecificiBean.getComponenti();

		try {
			// costruisci xml per l'invio
			String xmlAllerta = generaFileXml(datiSpecifici, documentiCollegati, componentiInvio,
					TipoDatoDaInviare.ALLERTA_MAIL.getTipoDatoDaInviare());

			// inserisco con esito invio = "in invio"
			// Serve per lo scheduler
			datiSpecifici.setESITO_INVIO(esitoInvio);

			// Inserimento in DatiSpecificiInvio e Documenti Collegati
			insertDatiSpecificiInvio(datiSpecifici, documentiCollegati, componentiInvio,
					TipoDatoDaInviare.ALLERTA_MAIL.getTipoDatoDaInviare());

			// Carico i file (componenti) da inviare
			List<File> listaDocumenti = caricaFileComponenti(componentiInvio);

			esitoInvio = invioDatiParer(datiSpecifici, esitoInvio, xmlAllerta, listaDocumenti);

		} catch (SystemException | DatatypeConfigurationException | PortalException e) {
			logger.error(e);
		}
		return esitoInvio;
	}
	
	public String comunicaDatiSpecificiInvioValangheMail(DatiSpecificiBean datiSpecificiBean) throws IOException {

		// Esito di default
		String esitoInvio = ESITO_INVIO_IN_INVIO;

		// Estraggo le info dal bean
		DatiSpecificiInvio datiSpecifici = datiSpecificiBean.getDatiSpecifici();
		List<DocumentiCollegati> documentiCollegati = datiSpecificiBean.getDocumentiCollegati();
		List<ComponentiInvio> componentiInvio = datiSpecificiBean.getComponenti();

		try {
			// costruisci xml per l'invio
			String xmlAllerta = generaFileXml(datiSpecifici, documentiCollegati, componentiInvio,
					TipoDatoDaInviare.VALANGHE_MAIL.getTipoDatoDaInviare());

			// inserisco con esito invio = "in invio"
			// Serve per lo scheduler
			datiSpecifici.setESITO_INVIO(esitoInvio);

			// Inserimento in DatiSpecificiInvio e Documenti Collegati
			insertDatiSpecificiInvio(datiSpecifici, documentiCollegati, componentiInvio,
					TipoDatoDaInviare.VALANGHE_MAIL.getTipoDatoDaInviare());

			// Carico i file (componenti) da inviare
			List<File> listaDocumenti = caricaFileComponenti(componentiInvio);

			esitoInvio = invioDatiParer(datiSpecifici, esitoInvio, xmlAllerta, listaDocumenti);

		} catch (SystemException | DatatypeConfigurationException | PortalException e) {
			logger.error(e);
		}
		return esitoInvio;
	}

	/**
	 * 
	 * @param datiSpecificiBean
	 * @return
	 * @throws IOException
	 */
	public String comunicaDatiSpecificiInvioAllertaBollettino(DatiSpecificiBean datiSpecificiBean) throws IOException {

		// Esito di default
		String esitoInvio = ESITO_INVIO_IN_INVIO;

		// Estraggo le info dal bean
		DatiSpecificiInvio datiSpecifici = datiSpecificiBean.getDatiSpecifici();
		List<DocumentiCollegati> documentiCollegati = datiSpecificiBean.getDocumentiCollegati();
		List<ComponentiInvio> componentiInvio = datiSpecificiBean.getComponenti();

		try {
			// costruisci xml per l'invio
			String xmlAllerta = generaFileXml(datiSpecifici, documentiCollegati, componentiInvio,
					TipoDatoDaInviare.ALLERTA_BOLLETTINO.getTipoDatoDaInviare());

			// inserisco con esito invio = "in invio"
			// Serve per lo scheduler
			datiSpecifici.setESITO_INVIO(esitoInvio);

			// Inserimento in DatiSpecificiInvio e Documenti Collegati
			insertDatiSpecificiInvio(datiSpecifici, documentiCollegati, componentiInvio,
					TipoDatoDaInviare.ALLERTA_BOLLETTINO.getTipoDatoDaInviare());

			// Carico i file (componenti) da inviare
			List<File> listaFileComponenti = caricaFileComponenti(componentiInvio);

			esitoInvio = invioDatiParer(datiSpecifici, esitoInvio, xmlAllerta, listaFileComponenti);

		} catch (SystemException | DatatypeConfigurationException | PortalException e) {
			logger.error(e);
		}
		return esitoInvio;
	}

	/**
	 * 
	 * @param datiSpecificiBean
	 * @return
	 * @throws IOException
	 */
	public String comunicaDatiSpecificiInvioMonitoraggio(DatiSpecificiBean datiSpecificiBean) throws IOException {

		// Esito di default
		String esitoInvio = ESITO_INVIO_IN_INVIO;

		// Estraggo le info dal bean
		DatiSpecificiInvio datiSpecifici = datiSpecificiBean.getDatiSpecifici();
		List<DocumentiCollegati> documentiCollegati = datiSpecificiBean.getDocumentiCollegati();
		List<ComponentiInvio> componentiInvio = datiSpecificiBean.getComponenti();

		try {
			// costruisci xml per l'invio
			String xmlAllerta = generaFileXml(datiSpecifici, documentiCollegati, componentiInvio,
					TipoDatoDaInviare.MONITORAGGIO.getTipoDatoDaInviare());

			// inserisco con esito invio = "in invio"
			// Serve per lo scheduler
			datiSpecifici.setESITO_INVIO(esitoInvio);

			// Inserimento in DatiSpecificiInvio e Documenti Collegati
			insertDatiSpecificiInvio(datiSpecifici, documentiCollegati, componentiInvio,
					TipoDatoDaInviare.MONITORAGGIO.getTipoDatoDaInviare());

			// Carico i file (componenti) da inviare
			List<File> listaFileComponenti = caricaFileComponenti(componentiInvio);

			esitoInvio = invioDatiParer(datiSpecifici, esitoInvio, xmlAllerta, listaFileComponenti);

		} catch (SystemException | DatatypeConfigurationException | PortalException e) {
			logger.error(e);
		}
		return esitoInvio;
	}

	/**
	 * 
	 * @param datiSpecificiBean
	 * @return
	 * @throws IOException
	 */
	public String comunicaDatiSpecificiInvioMonitoraggioSms(DatiSpecificiBean datiSpecificiBean) throws IOException {

		// Esito di default
		String esitoInvio = ESITO_INVIO_IN_INVIO;

		// Estraggo le info dal bean
		DatiSpecificiInvio datiSpecifici = datiSpecificiBean.getDatiSpecifici();
		List<DocumentiCollegati> documentiCollegati = datiSpecificiBean.getDocumentiCollegati();
		List<ComponentiInvio> componentiInvio = datiSpecificiBean.getComponenti();

		try {

			// costruisci xml per l'invio
			String xmlAllerta = generaFileXml(datiSpecifici, documentiCollegati, componentiInvio,
					TipoDatoDaInviare.MONITORAGGIO_SMS.getTipoDatoDaInviare());

			// inserisco con esito invio = "in invio"
			// Serve per lo scheduler
			datiSpecifici.setESITO_INVIO(esitoInvio);

			// Inserimento in DatiSpecificiInvio e Documenti Collegati
			insertDatiSpecificiInvio(datiSpecifici, documentiCollegati, componentiInvio,
					TipoDatoDaInviare.MONITORAGGIO_SMS.getTipoDatoDaInviare());

			// Carico i file (componenti) da inviare
			List<File> listaFileComponenti = caricaFileComponenti(componentiInvio);

			esitoInvio = invioDatiParer(datiSpecifici, esitoInvio, xmlAllerta, listaFileComponenti);

		} catch (SystemException | DatatypeConfigurationException | PortalException e) {
			logger.error(e);
		}
		return esitoInvio;
	}

	/**
	 * 
	 * @param datiSpecificiBean
	 * @return
	 * @throws IOException
	 */
	public String comunicaDatiSpecificiInvioMonitoraggioMail(DatiSpecificiBean datiSpecificiBean) throws IOException {

		// Esito di default
		String esitoInvio = ESITO_INVIO_IN_INVIO;

		// Estraggo le info dal bean
		DatiSpecificiInvio datiSpecifici = datiSpecificiBean.getDatiSpecifici();
		List<DocumentiCollegati> documentiCollegati = datiSpecificiBean.getDocumentiCollegati();
		List<ComponentiInvio> componentiInvio = datiSpecificiBean.getComponenti();

		try {
			// costruisci xml per l'invio
			String xmlAllerta = generaFileXml(datiSpecifici, documentiCollegati, componentiInvio,
					TipoDatoDaInviare.MONITORAGGIO_MAIL.getTipoDatoDaInviare());

			// inserisco con esito invio = "in invio"
			// Serve per lo scheduler
			datiSpecifici.setESITO_INVIO(esitoInvio);

			// Inserimento in DatiSpecificiInvio e Documenti Collegati
			insertDatiSpecificiInvio(datiSpecifici, documentiCollegati, componentiInvio,
					TipoDatoDaInviare.MONITORAGGIO_MAIL.getTipoDatoDaInviare());

			// Carico i file (componenti) da inviare
			List<File> listaFileComponenti = caricaFileComponenti(componentiInvio);

			esitoInvio = invioDatiParer(datiSpecifici, esitoInvio, xmlAllerta, listaFileComponenti);

		} catch (SystemException | DatatypeConfigurationException | PortalException e) {
			logger.error(e);
		}
		return esitoInvio;
	}

	/**
	 * 
	 * @param datiSpecificiBean
	 * @return
	 * @throws IOException
	 */
	public String comunicaDatiSpecificiInvioSuperamentoSms(DatiSpecificiBean datiSpecificiBean) throws IOException {

		// Esito di default
		String esitoInvio = ESITO_INVIO_IN_INVIO;

		// Estraggo le info dal bean
		DatiSpecificiInvio datiSpecifici = datiSpecificiBean.getDatiSpecifici();
		List<DocumentiCollegati> documentiCollegati = datiSpecificiBean.getDocumentiCollegati();
		List<ComponentiInvio> componentiInvio = datiSpecificiBean.getComponenti();

		try {
			// costruisci xml per l'invio
			String xmlAllerta = generaFileXml(datiSpecifici, documentiCollegati, componentiInvio,
					TipoDatoDaInviare.SUPERAMENTO_SMS.getTipoDatoDaInviare());

			// inserisco con esito invio = "in invio"
			// Serve per lo scheduler
			datiSpecifici.setESITO_INVIO(esitoInvio);

			// Inserimento in DatiSpecificiInvio e Documenti Collegati
			insertDatiSpecificiInvio(datiSpecifici, documentiCollegati, componentiInvio,
					TipoDatoDaInviare.SUPERAMENTO_SMS.getTipoDatoDaInviare());

			// Carico i file (componenti) da inviare
			List<File> listaFileComponenti = caricaFileComponenti(componentiInvio);

			esitoInvio = invioDatiParer(datiSpecifici, esitoInvio, xmlAllerta, listaFileComponenti);

		} catch (SystemException | DatatypeConfigurationException | PortalException e) {
			logger.error(e);
		}
		return esitoInvio;
	}

	/**
	 * 
	 * @param datiSpecificiBean
	 * @return
	 * @throws IOException
	 */
	public String comunicaDatiSpecificiInvioSuperamentoMail(DatiSpecificiBean datiSpecificiBean) throws IOException {

		// Esito di default
		String esitoInvio = ESITO_INVIO_IN_INVIO;

		// Estraggo le info dal bean
		DatiSpecificiInvio datiSpecifici = datiSpecificiBean.getDatiSpecifici();
		List<DocumentiCollegati> documentiCollegati = datiSpecificiBean.getDocumentiCollegati();
		List<ComponentiInvio> componentiInvio = datiSpecificiBean.getComponenti();

		try {
			// costruisci xml per l'invio
			String xmlAllerta = generaFileXml(datiSpecifici, documentiCollegati, componentiInvio,
					TipoDatoDaInviare.SUPERAMENTO_MAIL.getTipoDatoDaInviare());

			// inserisco con esito invio = "in invio"
			// Serve per lo scheduler
			datiSpecifici.setESITO_INVIO(esitoInvio);

			// Inserimento in DatiSpecificiInvio e Documenti Collegati
			insertDatiSpecificiInvio(datiSpecifici, documentiCollegati, componentiInvio,
					TipoDatoDaInviare.SUPERAMENTO_MAIL.getTipoDatoDaInviare());

			// Carico i file (componenti) da inviare
			List<File> listaFileComponenti = caricaFileComponenti(componentiInvio);

			esitoInvio = invioDatiParer(datiSpecifici, esitoInvio, xmlAllerta, listaFileComponenti);

		} catch (SystemException | DatatypeConfigurationException | PortalException e) {
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
	private List<File> caricaFileComponenti(List<ComponentiInvio> componentiInvio)
			throws PortalException, SystemException {

		List<File> listaFileComponenti = new ArrayList<>();

		for (ComponentiInvio comp : componentiInvio) {

			DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(comp.getID_COMPONENTE_VERSATO());
			File file = DLFileEntryLocalServiceUtil.getFile(dlFileEntry.getFileEntryId(),
					//userId, comp.getID_COMPONENTE_VERSATO(),
					dlFileEntry.getVersion(), false);
			listaFileComponenti.add(file);

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
	private String invioDatiParer(DatiSpecificiInvio datiSpecifici, String esitoInvio, String xmlAllerta,
			List<File> listaDocomunti) throws SystemException {

		EsitoVersamentoType esitoVers = new EsitoVersamentoType();
		// imposto esito di default a KO
		esitoInvio = "KO";
		// Richiamo metodo per la comunicazione dei dati al PARER
		try {
			String response = InvioDatiParer.invioDatiParer(xmlAllerta, listaDocomunti,
					datiSpecifici.getVERSATORE_USER_ID());
			esitoVers = verificaEsito(response);
			// setto l'esito generale dell'invio
			esitoInvio = esitoVers.getEsitoGenerale().getCodiceEsito().value().equals("NEGATIVO") ? "KO" : "OK";
		} catch (Exception e) {
			logger.error(e);
		} finally {
			// Setto l'esito dell'invio e aggiorno
			if (null != esitoVers && null != esitoVers.getEsitoGenerale()
					&& null != esitoVers.getEsitoGenerale().getCodiceEsito()) {
				datiSpecifici.setCODICE_ESITO(esitoVers.getEsitoGenerale().getCodiceEsito().value());
			}
			if (null != esitoVers && null != esitoVers.getEsitoGenerale()
					&& null != esitoVers.getEsitoGenerale().getMessaggioErrore()) {
				datiSpecifici.setMESG_ERRORE(esitoVers.getEsitoGenerale().getMessaggioErrore());
			}
			if (null != esitoVers && null != esitoVers.getEsitoGenerale()
					&& null != esitoVers.getEsitoGenerale().getCodiceErrore()) {
				datiSpecifici.setCODICE_ERRORE(esitoVers.getEsitoGenerale().getCodiceErrore());
			}
			datiSpecifici.setESITO_INVIO(esitoInvio);
			datiSpecifici.setData_risposta(new Date());
			try {
				aggiornaDatiSpecificiInvio(datiSpecifici);
			} catch (Exception e) {
				logger.error(e);
			}
		}
		return esitoInvio;
	}

	private EsitoVersamentoType verificaEsito(String response)
			throws SAXException, IOException, ParserConfigurationException, JAXBException {

		EsitoVersamentoType esitoVersamento = new EsitoVersamentoType();

//			String resp = "";
//			for(String respon : response){
//				resp =resp.concat(respon);
//			}

		if (StringUtils.isNotBlank(response)) {

			JAXBContext jaxbContext = JAXBContext.newInstance(EsitoVersamentoType.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

			StringReader reader = new StringReader(response);
			esitoVersamento = (EsitoVersamentoType) unmarshaller.unmarshal(reader);

			reader.close();

		} else {
			// Non abbiamo avuto risposta per problemi di comunicazione con il server
			// Setto esito negativo
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
		DatiSpecificiInvioLocalServiceUtil.updateDatiSpecificiInvio(datiSpecifici);
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
	private Long insertDatiSpecificiInvio(DatiSpecificiInvio datiSpecifici, 
			List<DocumentiCollegati> documentiCollegati,
			List<ComponentiInvio> componentiInvio, String codiceTipoInvio) throws SystemException {

		// Se ho già valorizzato l'id (caso di reinvii con batch) non ne stacco uno
		// nuovo ma aggiorno su quello esistente
		if (datiSpecifici.getID_INVIO() > 0) {
			// Aggiorno il vecchio con il codice esito "REINVIATO"
			datiSpecifici.setESITO_INVIO(ESITO_INVIO_RE_INVIO);
			aggiornaDatiSpecificiInvio(datiSpecifici);
		}

		// Stacco un nuovo id per "la copia" del nuovo oggetto che sto reinviando
		long id = CounterLocalServiceUtil.increment(DatiSpecificiInvio.class.getName());
		datiSpecifici.setID_INVIO(id);

		datiSpecifici.setUserId(userId);
		datiSpecifici.setCompanyId(companyId);
		datiSpecifici.setGroupId(groupId);
		datiSpecifici.setData_invio(new Date());
		datiSpecifici.setCODICE_TIPO_INVIO(codiceTipoInvio);

		// inserisco in DatiSpecificiInvio
		DatiSpecificiInvioLocalServiceUtil.updateDatiSpecificiInvio(datiSpecifici);
		// setto l'id invio e inserisco in documenti collegati
		if (null != documentiCollegati) {
			for (DocumentiCollegati docCollegati : documentiCollegati) {
				if (null != docCollegati && StringUtils.isNotBlank(docCollegati.getDOC_COLLEGATO_NUMERO())) {
					docCollegati.setID_INVIO(datiSpecifici.getID_INVIO());
					DocumentiCollegatiLocalServiceUtil.updateDocumentiCollegati(docCollegati);
				}
			}
		}
		// setto l'id invio e inserisco in componenti invio
		for (ComponentiInvio compInvio : componentiInvio) {
			if (null != compInvio) {
				compInvio.setID_INVIO(datiSpecifici.getID_INVIO());
				ComponentiInvioLocalServiceUtil.updateComponentiInvio(compInvio);
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
	private String generaFileXml(DatiSpecificiInvio datiSpecifici, List<DocumentiCollegati> documentiCollegati,
			List<ComponentiInvio> listaComponenti, String tipoDatoDaInviare)
			throws DatatypeConfigurationException, IOException {
		return JavaToXMLParer.generaXmlFileAsString(datiSpecifici, documentiCollegati, listaComponenti,
				tipoDatoDaInviare);
	}

	/**
	 * Ritorna una lista di dati specifici filtrata in base all'esito passato come
	 * paramentro
	 * 
	 * @param esitoInvio
	 * @return
	 */
	public List<DatiSpecificiInvio> listaDatiSpecificiByEsitoInvio(String esitoInvio) throws Exception {

		List<DatiSpecificiInvio> findByesitoInvio = new ArrayList<>();
		findByesitoInvio = DatiSpecificiInvioServiceUtil.listaDatiSpecificiByEsitoInvio(esitoInvio);
		// recupero la lista degli invii non processati
		return findByesitoInvio;

	}

	/**
	 * Ritorna la lista di documenti collegati per un dato idInvio.
	 * 
	 * Da usare per recuperare i documenti collegati ai dati specifici
	 * 
	 * @param idInvio
	 * @return
	 */
	public List<DocumentiCollegati> listaDocumentiCollegatiByIdInvio(Long idInvio) throws Exception {

		List<DocumentiCollegati> findByIdInvio = new ArrayList<DocumentiCollegati>();
		findByIdInvio = DocumentiCollegatiServiceUtil.listaDocumentiCollegatiByEsitoInvio(idInvio);

		return findByIdInvio;

	}

	/**
	 * Ritorna la lista di componenti per un dato idInvio.
	 * 
	 * Da usare per recuperare i componenti collegati ai dati specifici
	 * 
	 * @param idInvio
	 * @return
	 */
	public List<ComponentiInvio> listaComponentiByIdInvio(Long idInvio) throws Exception {

		List<ComponentiInvio> findByIdInvio = new ArrayList<ComponentiInvio>();
		findByIdInvio = ComponentiInvioServiceUtil.listaComponentiByIdInvio(idInvio);
		return findByIdInvio;

	}
}
