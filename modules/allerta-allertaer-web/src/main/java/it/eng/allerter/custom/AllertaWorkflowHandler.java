package it.eng.allerter.custom;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.search.IndexerRegistry;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;

import it.eng.allerta.configuration.AllertaBaseConfiguration;
import it.eng.allerta.utils.AllertaTracker;
import it.eng.allerta.utils.AllertaUtilsInterface;
import it.eng.allerter.model.Allerta;
import it.eng.allerter.model.AllertaParametro;
import it.eng.allerter.model.AllertaStato;
import it.eng.allerter.model.Email;
import it.eng.allerter.service.AllertaLocalService;
import it.eng.allerter.service.AllertaParametroLocalService;
import it.eng.allerter.service.AllertaStatoLocalService;
import it.eng.allerter.service.EmailLocalService;
import it.eng.allerter.service.LogInternoLocalService;
import it.eng.allerter.service.SMSLocalService;
import it.eng.bollettino.model.BollettinoParametro;
import it.eng.bollettino.service.BollettinoParametroLocalService;
import it.eng.parer.model.ComponentiInvio;
import it.eng.parer.model.DatiSpecificiInvio;
import it.eng.parer.model.DocumentiCollegati;
import it.eng.parer.service.ComponentiInvioLocalService;
import it.eng.parer.service.DatiSpecificiInvioLocalService;

/**
 * Portlet implementation class FeedbackAction
 */
@Component(
		immediate = true, 
		service = WorkflowHandler.class
		)
public class AllertaWorkflowHandler extends BaseWorkflowHandler<Allerta> {

	public static final long pubblicato = 153999L;
	public static final long lavorazione = 154001L;
	public static final long revisione = 154000L;

	public static final long homepage = 155477L;

	public static final long allerta = 168560L;
	public static final long bollettino = 168562L;
	
	private Log logger = LogFactoryUtil.getLog(AllertaWorkflowHandler.class);

	String nomeFile = "";

	public String getClassName() {
		return CLASS_NAME;
	}

	public String getType(Locale locale) {
		return "Allerta/Bollettino di vigilanza";
	}
	
	private void logCambioStato(boolean tipo, String allerta, int stato) {
		String stringaStato = "";
		switch (stato) {
		case WorkflowConstants.STATUS_DRAFT: stringaStato="Bozza"; break;
		case WorkflowConstants.STATUS_APPROVED: stringaStato="Approvato"; break;
		case WorkflowConstants.STATUS_PENDING: stringaStato="Approvazione ARPAE"; break;
		case WorkflowConstants.STATUS_DENIED: stringaStato="Respinto"; break;
		case 1000: stringaStato="Approvazione PC"; break;
		}
		
		logInternoLocalService.log(tipo?"allerta":"bollettino",
				"Cambio di stato","Documento "+allerta+" passato in stato "+stringaStato,"");
	}

	public Allerta updateStatus(int status, Map<String, Serializable> workflowContext)
			throws PortalException, SystemException {
		// long userId =
		// GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));

		String text = null;
		String subject = null;
		String textPlusOne = null;
		String subjectPlusOne = null;

		System.out.println("ALLERTA WORKFLOW  " + status);

		//if (pubblicato == null || revisione == null || lavorazione == null)
			//caricaPubblicatoTag();
  
		long resourcePrimKey = GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
		//long userId = allertaLocalService.getIdApprovatore(resourcePrimKey);
		Allerta feedback = allertaLocalService.getAllerta(resourcePrimKey);
		 
		if (feedback.getStato()==WorkflowConstants.STATUS_APPROVED) return feedback;
		if (feedback.getStato()==1000 && status==1) return feedback;
		
		logCambioStato(feedback.getTipoAllerta(), feedback.getNumero(), status);
		//logInternoLocalService.log("AllertaWorkflow", "updateStatus " + status, "stato " + feedback.getStato(), "");

		String tipo = (feedback.getTipoAllerta() ? "workflowAllerta" : "workflowBollettino");
		String sottotipo = feedback.getNumero();
		long l = new Date().getTime();

		if (status == WorkflowConstants.STATUS_PENDING && feedback.getStato() == WorkflowConstants.STATUS_DENIED) {

			/*
			 * mandaNotifica(feedback.getUtenteFirmaArpaId(),"Il documento "+feedback.
			 * getNumero()
			 * +" è in attesa di approvazione: https://allertameteo.regione.emilia-romagna.it"
			 * ,feedback,tipo,sottotipo,l);
			 * 
			 * text = "<html><head></head><body>Il documento "+feedback.getNumero()
			 * +" e' in attesa di approvazione su <a href=\"https://allertameteo.regione.emilia-romagna.it\">https://allertameteo.regione.emilia-romagna.it</a></body></html>"
			 * ; subject =
			 * "Il documento "+feedback.getNumero()+" è in attesa di approvazione";
			 * 
			 * spedisciNotifiche(tipo, sottotipo, l, subject, text, feedback);
			 */

			return feedback;
		}

		feedback.setStato(status);

		boolean rigenera = false;

		//if (userId != 0) { 
			if (status == 1000) {
				//feedback.setUtenteFirmaArpaId(userId);
				feedback.setDataFirmaArpa(new Date());
				//rigenera = true; 

				if (status != WorkflowConstants.STATUS_DENIED) {
					mandaNotificaSoloEmail(feedback.getUtenteFirmaArpaId(), tipo, sottotipo, l + 1);
					mandaNotifica(feedback.getUtenteFirmaProtId(),
							"Il documento " + feedback.getNumero()
									+ " è in attesa di approvazione su https://allertameteo.regione.emilia-romagna.it",
							feedback, tipo, sottotipo, l);

					text = "<html><head></head><body>Il documento " + feedback.getNumero()
							+ " e' in attesa di approvazione su <a href=\"https://allertameteo.regione.emilia-romagna.it\">https://allertameteo.regione.emilia-romagna.it</a></body></html>";
					subject = "Il documento " + feedback.getNumero() + " è in attesa di approvazione";

					textPlusOne = "<html><head></head><body>Hai approvato il documento " + feedback.getNumero()
							+ ".</body></html>";
					subjectPlusOne = "Documento " + feedback.getNumero() + " approvato";
				}
			}
			if (status == 0) {
				//feedback.setUtenteFirmaProtId(userId);
				feedback.setDataFirmaProt(new Date());
				rigenera = true;

				if (status != WorkflowConstants.STATUS_DENIED) {
					mandaNotificaSoloEmail(feedback.getUtenteFirmaProtId(), tipo, sottotipo, l + 1);
					mandaNotificaSoloEmail(getParam("EMAIL_APPROVA_ALLERTA", ""), tipo, sottotipo, l + 1);

					textPlusOne = "<html><head></head><body>Il documento " + feedback.getNumero()
							+ " e' stato approvato.</body></html>";
					subjectPlusOne = "Documento " + feedback.getNumero() + " approvato";
				}

			}

		//}
		if (status == WorkflowConstants.STATUS_APPROVED) {
			feedback.setDataEmissione(new Date());
			rigenera = true;
		}

		if (status == WorkflowConstants.STATUS_DENIED) {
			feedback.setStato(WorkflowConstants.STATUS_DENIED);
			//if (pubblicato == null || lavorazione == null || revisione == null)
				//caricaPubblicatoTag();
			feedback.setDataFirmaArpa(null);
			feedback.setDataFirmaProt(null);
			feedback = allertaLocalService.updateAllerta(feedback);

			mandaNotificaSoloEmail(getParam("EMAIL_RESPINGI_ALLERTA", ""), tipo, sottotipo, l + 1);
			if (feedback.getUtenteFirmaArpaId() != 0)
				mandaNotificaSoloEmail(feedback.getUtenteFirmaArpaId(), tipo, sottotipo, l + 1);
			if (feedback.getUtenteFirmaProtId() != 0)
				mandaNotificaSoloEmail(feedback.getUtenteFirmaProtId(), tipo, sottotipo, l + 1);

			text = null;
			subject = null;
			textPlusOne = "<html><head></head><body>Il documento " + feedback.getNumero()
					+ " e' stato respinto.</body></html>";
			subjectPlusOne = "Documento " + feedback.getNumero() + " respinto";

			// mandaMessaggioRifiuto(feedback);
			long id = assetEntryLocalService.getEntry(Allerta.class.getName(), feedback.getAllertaId())
					.getEntryId();
			assetCategoryLocalService.clearAssetEntryAssetCategories(id);
			
			assetCategoryLocalService.addAssetEntryAssetCategory(id, lavorazione);
		}

		if (status == WorkflowConstants.STATUS_PENDING) {

			mandaNotifica(feedback.getUtenteFirmaArpaId(),
					"Il documento " + feedback.getNumero()
							+ " è in attesa di approvazione: https://allertameteo.regione.emilia-romagna.it",
					feedback, tipo, sottotipo, l);

			text = "<html><head></head><body>Il documento " + feedback.getNumero()
					+ " e' in attesa di approvazione su <a href=\"https://allertameteo.regione.emilia-romagna.it\">https://allertameteo.regione.emilia-romagna.it</a></body></html>";
			subject = "Il documento " + feedback.getNumero() + " è in attesa di approvazione";

			long id = assetEntryLocalService.getEntry(Allerta.class.getName(), feedback.getAllertaId())
					.getEntryId();

			
			assetCategoryLocalService.addAssetEntryAssetCategory(id, revisione);

			if (feedback.isTipoAllerta())
				assetCategoryLocalService.addAssetEntryAssetCategory(id, allerta);
			if (!feedback.isTipoAllerta())
				assetCategoryLocalService.addAssetEntryAssetCategory(id, bollettino);

			try {
				assetCategoryLocalService.deleteAssetEntryAssetCategory(id, lavorazione);
			} catch (Exception e) {

				logger.error(e);
			}
		}

		if (status == WorkflowConstants.STATUS_DRAFT)
			feedback.setStato(WorkflowConstants.STATUS_PENDING);
		feedback = allertaLocalService.updateAllerta(feedback);

		if (rigenera)
			rigeneraPdf(feedback, feedback.getGroupId());

		if (text != null) {
			spedisciNotifiche(tipo, sottotipo, l, subject, text, feedback);
		}

		if (textPlusOne != null) {
			spedisciNotifiche(tipo, sottotipo, l + 1, subjectPlusOne, textPlusOne, feedback);
		}

		if (status == WorkflowConstants.STATUS_APPROVED) {

			// PARER
			try {
				if (!AllertaTracker.getAllertaBaseConfiguration().disableParer()) {
					User arpa = userLocalService.getUser(feedback.getUtenteFirmaArpaId());
					User pc = userLocalService.getUser(feedback.getUtenteFirmaProtId());
	
					DatiSpecificiInvio dsi = datiSpecificiInvioLocalService.createDatiSpecificiInvio(0);
					dsi.setCHIAVE_NUMERO(feedback.getNumero().split("/")[0]);
					dsi.setCHIAVE_ANNO(Long.parseLong(feedback.getNumero().split("/")[1]));
					dsi.setDATA_UNITA_DOCUMENTARIA(feedback.getDataEmissione());
					dsi.setIDENTIFICATIVO_DATO_SPECIFICO("" + feedback.getAllertaId());
					dsi.setDATA_GENERAZIONE(feedback.getCreateDate());
					dsi.setDENOMINAZIONE_APPLICATIVO("AllertaMeteoER");
					dsi.setCOMPILATORE_ARPAE(feedback.getCreatorName());
					dsi.setCOMPILATORE_PROTEZIONE_CIVILE(feedback.getUserName());
					dsi.setAPPROVATORE_ARPAE(arpa.getFullName());
					dsi.setAPPROVATORE_PROTEZIONE_CIVILE(pc.getFullName());
					dsi.setDATA_INIZIO_VALIDITA(feedback.getDataInizio());
					dsi.setDATA_FINE_VALIDITA(feedback.getDataFine());
					dsi.setDATA_FIRMA_ARPAE(feedback.getDataFirmaArpa());
					dsi.setDATA_FIRMA_PROTEZIONE_CIVILE(feedback.getDataFirmaProt());
	
					ArrayList<DocumentiCollegati> documentiCollegati = new ArrayList<DocumentiCollegati>();
					ArrayList<ComponentiInvio> componentiInvio = new ArrayList<ComponentiInvio>();
	
					ComponentiInvio c = componentiInvioLocalService.getNuovoComponenteInvio();
					c.setHASH_VERSATO(feedback.getHash());
					c.setID_COMPONENTE_VERSATO(getReportId(feedback));
					c.setNOME_COMPONENTE(nomeFile);
					c.setURN_VERSATO("https://allertameteo.regione.emilia-romagna.it" + feedback.getLink());
					c.setFORMATO_FILE_VERSATO("PDF");
					componentiInvio.add(c);
					if (feedback.getTipoAllerta())
						datiSpecificiInvioLocalService.comunicaDatiSpecificiInvioAllerta(dsi, documentiCollegati,
								componentiInvio);
					else
						datiSpecificiInvioLocalService.comunicaDatiSpecificiInvioAllertaBollettino(dsi,
								documentiCollegati, componentiInvio);
				}

			} catch (Exception e) {
				logger.error(e);
				//logInternoLocalService.log("AllertaWorkflow", "approva", e, "");
				System.out.println("PARER EXCEPTION: " + e.getMessage());
			}

			String url = "https://allertameteo.regione.emilia-romagna.it";
			try {
				AllertaParametro ap = allertaParametroLocalService.getAllertaParametro("URL_PRIMES");
				if (ap != null)
					url = ap.getValore();
			} catch (Exception e) {
			}
			
			try {
				String titolo = feedback.getTitolo();
				String colore = getColore(feedback);
				if (!"".equals(colore))
					titolo = titolo.replace("Allerta", "Allerta "+colore);
				sendToChannel(titolo + " - " + url + feedback.getLink());
			} catch (Exception e) {
				logger.error(e);
			}
			//if (pubblicato == null || revisione == null)
			//	caricaPubblicatoTag();

			long id = assetEntryLocalService.getEntry(Allerta.class.getName(), feedback.getAllertaId())
					.getEntryId();

			try {
				assetCategoryLocalService.deleteAssetEntryAssetCategory(id, lavorazione);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
					assetCategoryLocalService.deleteAssetEntryAssetCategory(id, revisione);
			} catch (Exception e) {
				e.printStackTrace();
			}
			assetCategoryLocalService.addAssetEntryAssetCategory(id, pubblicato);
			assetCategoryLocalService.addAssetEntryAssetCategory(id, homepage);

			if (isIdrogeologica(feedback)) {
				// attiva il controllo del monitoraggio
				BollettinoParametro bp = bollettinoParametroLocalService
						.fetchBollettinoParametro("CONTROLLO_MONITORAGGIO");
				if (bp != null) {
					bp.setValore("true");
					bollettinoParametroLocalService.updateBollettinoParametro(bp);
				}

			}

			// if (revisione!=null)
			// assetCategoryLocalService.deleteAssetEntryAssetCategory(id, revisione);

			assetEntryLocalService.updateVisible(Allerta.class.getName(), resourcePrimKey, true);
			indexerRegistry.nullSafeGetIndexer(Allerta.class).reindex(feedback);

			try {
				// manda notifiche e genera report di invio solo per le allerte, non i
				// bollettini
				if (feedback.getTipoAllerta()) {
					sendSms(feedback);
					// scheduleReports(feedback);
				}
			} catch (Exception mail) {
				System.out.println("MAIL EXCEPTION: " + mail.getMessage());
			}

		} else {
			assetEntryLocalService.updateVisible(Allerta.class.getName(), resourcePrimKey, true);
		}
		return feedback;
	}
	
	

	public static final String CLASS_NAME = Allerta.class.getName();

	/*public void caricaPubblicatoTag() throws SystemException {

		List<AssetCategory> list = assetCategoryLocalService.getCategories();

		for (AssetCategory t : list) {
			// System.out.println("CATEGORIA "+t.getName());

			if (t.getName().equals("allerta-pubblicata")) {
				pubblicato = t;
				System.out.println("trovata categoria " + t.getCategoryId());
			}
			if (t.getName().equals("allerta-revisione")) {
				revisione = t;
				System.out.println("trovata categoria " + t.getCategoryId());
			}
			if (t.getName().equals("allerta-lavorazione")) {
				lavorazione = t;
				System.out.println("trovata categoria " + t.getCategoryId());
			}
			if (t.getName().equals("mostra-in-home")) {
				homepage = t;
				System.out.println("trovata categoria " + t.getCategoryId());
			}
			if (t.getName().equals("allerta")) {
				allerta = t;
				System.out.println("trovata categoria " + t.getCategoryId());
			}
			if (t.getName().equals("bollettino")) {
				bollettino = t;
				System.out.println("trovata categoria " + t.getCategoryId());
			}
		}

		// System.out.println("categoria non trovata");

	}*/

	public void mandaNotifica(long idUtente, String testo, Allerta a, String tipo, String sottotipo, long l) {
		try {
			User u = userLocalService.fetchUser(idUtente);
			if (u == null)
				return;
			smsLocalService.creaSMS("AllerteER", testo, tipo, sottotipo, l, u);
			// smsLocalService.inviaSMS("workflow", "allerta", l);
			// smsLocalService.inviaEmail("workflow", "allerta", l, subject, testo,
			// "no-reply@allertameteoer.it");
		} catch (Exception e) {
			logger.error(e);
			//logger.error(e);
			//logInternoLocalService.log("AllertaWorkflow", "mandaNotifica", e, "");
		}
	}

	public void mandaNotificaSoloEmail(long idUtente, String tipo, String sottotipo, long l) {
		try {
			User u = userLocalService.fetchUser(idUtente);
			if (u == null)
				return;
			// long l = new Date().getTime();
			smsLocalService.creaEmail(tipo, sottotipo, l, u);
			// smsLocalService.inviaEmail("workflow", "allertaEmail", l, subject, testo,
			// "no-reply@allertameteoer.it");
		} catch (Exception e) {
			logger.error(e);
			//logger.error(e);
			//logInternoLocalService.log("AllertaWorkflow", "mandaNotificaSoloEmail", e, "");
		}
	}

	public void mandaNotificaSoloEmail(String indirizzi, String tipo, String sottotipo, long l) {
		try {
			// User u = userLocalService.fetchUser(idUtente);
			// if (u==null) return;
			String[] ss = indirizzi.split(",");
			for (String s : ss) {

				if (s == null)
					continue;

				long id = counterLocalService.increment(Email.class.getName());
				Email e = emailLocalService.createEmail(id);

				e.setDestinatario(0);
				e.setIndirizzo(s.toLowerCase());
				e.setNomeDestinatario("");
				e.setParam(l);
				e.setSottotipo(sottotipo);
				e.setStato(0);
				e.setTipo(tipo);
				e.setDataInvio(new Date());

				emailLocalService.updateEmail(e);
			}
			// long l = new Date().getTime();

			// smsLocalService.inviaEmail("workflow", "allertaEmail", l, subject, testo,
			// "no-reply@allertameteoer.it");
		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("AllertaWorkflow", "mandaNotificaSoloEmail", e, "");
		}
	}

	public void spedisciNotifiche(String tipo, String sottotipo, long l, String emailSubject, String emailText,
			Allerta a) {

		try {
			File f = getReportAsFile(a);

			smsLocalService.inviaSMS(tipo, sottotipo, l);
			smsLocalService.inviaEmail(tipo, sottotipo, l, emailSubject, emailText, "no-reply@allertameteoer.it", f,
					nomeFile);
		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("AllertaWorkflow", "spedisciNotifiche", e, "");
		}
	}

	public void sendSms(Allerta a) {

		SimpleDateFormat data = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat ora = new SimpleDateFormat("HH:mm");

		String fromSMS = "33312345678";
		try {
			AllertaParametro bp = allertaParametroLocalService.fetchAllertaParametro("SMS_FROM_ALLERTA");
			if (bp != null)
				fromSMS = bp.getValore();

		} catch (Exception e) {
		}

		String fromMail = "allerta@allertameteoer.it";
		try {
			AllertaParametro bp = allertaParametroLocalService.fetchAllertaParametro("EMAIL_FROM_ALLERTA");
			if (bp != null)
				fromMail = bp.getValore();

		} catch (Exception e) {
		}

		String desc = "Emanata Allerta %NUMERO%";
		String email = "Emanata Allerta %NUMERO%";

		try {
			AllertaParametro bp = allertaParametroLocalService.fetchAllertaParametro("SMS_TESTO_ALLERTA");
			if (bp != null)
				desc = bp.getValore();

		} catch (Exception e) {
		}

		try {
			AllertaParametro bp = allertaParametroLocalService.fetchAllertaParametro("EMAIL_TESTO_ALLERTA");
			if (bp != null)
				email = bp.getValore();

		} catch (Exception e) {
		}

		desc = desc.replace("%NUMERO%", a.getNumero());

		desc = desc.replace("%DATAINIZIO%", data.format(a.getDataInizio()));
		desc = desc.replace("%ORAINIZIO%", ora.format(a.getDataInizio()));

		desc = desc.replace("%DATAFINE%", data.format(a.getDataFine()));
		desc = desc.replace("%ORAFINE%", ora.format(a.getDataFine()));

		email = email.replace("%NUMERO%", a.getNumero());

		email = email.replace("%DATAINIZIO%", data.format(a.getDataInizio()));
		email = email.replace("%ORAINIZIO%", ora.format(a.getDataInizio()));

		email = email.replace("%DATAFINE%", data.format(a.getDataFine()));
		email = email.replace("%ORAFINE%", ora.format(a.getDataFine()));

		/*
		 * try { UserGroup ug = UserGroupLocalServiceUtil.fetchUserGroup(20154,
		 * "allerta-sempre"); if (ug!=null)
		 * smsLocalService.creaSMSUserGroup(fromSMS, desc, "allerta", a.getNumero(),
		 * a.getAllertaId(), ug.getUserGroupId());
		 * 
		 * } catch (Exception e) { logger.error(e); }
		 */

		// trova tutte le zone
		HashMap<String, String> zone = new HashMap<String, String>();
		HashMap<String, String> zoneX = new HashMap<String, String>();
		long peggiore = 0;
		boolean nuovoTipo = false;

		try {

			DynamicQuery dyn = allertaStatoLocalService.dynamicQuery()
					.add(PropertyFactoryUtil.forName("allertaId").eq(a.getAllertaId()));
			List<AllertaStato> s = allertaStatoLocalService.dynamicQuery(dyn);

			HashMap<Number, List<AllertaStato>> rosso = new HashMap<Number, List<AllertaStato>>();
			HashMap<Number, List<AllertaStato>> arancione = new HashMap<Number, List<AllertaStato>>();
			HashMap<Number, List<AllertaStato>> giallo = new HashMap<Number, List<AllertaStato>>();

			HashMap<Number, List<AllertaStato>> rossoX = new HashMap<Number, List<AllertaStato>>();
			HashMap<Number, List<AllertaStato>> arancioneX = new HashMap<Number, List<AllertaStato>>();
			HashMap<Number, List<AllertaStato>> gialloX = new HashMap<Number, List<AllertaStato>>();

			
			
			for (AllertaStato ss : s) {
				if (ss.getAreaId()==43 || ss.getAreaId()==63) nuovoTipo=true;
			}
			
			if (nuovoTipo) {
				for (AllertaStato ss : s) {
					if (ss.getStatoId() == 0 || ss.getStatoId() == 1000)
						continue;
					HashMap<Number, List<AllertaStato>> lista = null;
					if (ss.getStatoId() == 1)
						lista = ss.getAreaId()<0?gialloX:giallo; 
					if (ss.getStatoId() == 2)
						lista = ss.getAreaId()<0?arancioneX:arancione; 
					if (ss.getStatoId() == 3)
						lista = ss.getAreaId()<0?rossoX:rosso; 
					if (lista != null) {
						List<AllertaStato> l = lista.get(ss.getEventoId());
						if (l == null) {
							l = new ArrayList<AllertaStato>();
							l.add(ss);
							lista.put(ss.getEventoId(), l);
						} else
							l.add(ss);
					}
					
					if (ss.getStatoId() > peggiore)
						peggiore = ss.getStatoId();
					
					
					HashMap<String, String> mappaZone = zone;
					if (ss.getAreaId()<0) mappaZone = zoneX;
					long l = ss.getAreaId();
					if (l<0) l = -l;
					char lettera = (char)('A' + (l/10)-1); //22 -> B2
					char numero = (char)('0' + (l%10));
					String zon = ""+lettera+""+numero;
					mappaZone.put(""+lettera, ""+lettera); //A
					mappaZone.put(zon, zon);  //A1
					
				}
			} else {
				for (AllertaStato ss : s) {
	
					if (ss.getStatoId() == 0 || ss.getStatoId() == 1000)
						continue;
	
					HashMap<Number, List<AllertaStato>> lista = null;
					if (ss.getStatoId() == 1)
						lista = giallo;
					if (ss.getStatoId() == 2)
						lista = arancione;
					if (ss.getStatoId() == 3)
						lista = rosso;
					if (lista != null) {
						List<AllertaStato> l = lista.get(ss.getEventoId());
						if (l == null) {
							l = new ArrayList<AllertaStato>();
							l.add(ss);
							lista.put(ss.getEventoId(), l);
						} else
							l.add(ss);
					}
	
					if (ss.getStatoId() > peggiore)
						peggiore = ss.getStatoId();
	
					switch ((int) ss.getAreaId()) {
					case 10:
						zone.put("A", "A");
						zone.put("A1", "A1");
						zone.put("A2", "A2");
						break;
					case 11:
						zone.put("A", "A");
						zone.put("A1", "A1");
						break;
					case 12:
						zone.put("A", "A");
						zone.put("A2", "A2");
						break;
					case 20:
						zone.put("B", "B");
						zone.put("B1", "B1");
						zone.put("B2", "B2");
						break;
					case 21:
						zone.put("B", "B");
						zone.put("B1", "B1");
						break;
					case 22:
						zone.put("B", "B");
						zone.put("B2", "B2");
						break;
					case 30:
						zone.put("C", "C");
						zone.put("C1", "C1");
						zone.put("C2", "C2");
						break;
					case 31:
						zone.put("C", "C");
						zone.put("C1", "C1");
						break;
					case 32:
						zone.put("C", "C");
						zone.put("C2", "C2");
						break;
					case 40:
						zone.put("D", "D");
						zone.put("D1", "D1");
						zone.put("D2", "D2");
						break;
					case 41:
						zone.put("D", "D");
						zone.put("D1", "D1");
						break;
					case 42:
						zone.put("D", "D");
						zone.put("D2", "D2");
						break;
					case 50:
						zone.put("E", "E");
						zone.put("E1", "E1");
						zone.put("E2", "E2");
						break;
					case 51:
						zone.put("E", "E");
						zone.put("E1", "E1");
						break;
					case 52:
						zone.put("E", "E");
						zone.put("E2", "E2");
						break;
					case 60:
						zone.put("F", "F");
						break;
					case 61:
						zone.put("F", "F");
						zone.put("F1", "F1");
						break;
					case 62:
						zone.put("F", "F");
						zone.put("F2", "F2");
						break;
					case 70:
						zone.put("G", "G");
						zone.put("G1", "G1");
						zone.put("G2", "G2");
						break;
					case 71:
						zone.put("G", "G");
						zone.put("G1", "G1");
						break;
					case 72:
						zone.put("G", "G");
						zone.put("G2", "G2");
						break;
					case 80:
						zone.put("H", "H");
						zone.put("H1", "H1");
						zone.put("H2", "H2");
						break;
					case 81:
						zone.put("H", "H");
						zone.put("H1", "H1");
						break;
					case 82:
						zone.put("H", "H");
						zone.put("H2", "H2");
						break;
	
					}
				}
			}
			String colore = "";
			if (peggiore == 1)
				colore = "GIALLA";
			if (peggiore == 2)
				colore = "ARANCIONE";
			if (peggiore == 3)
				colore = "ROSSA";
			desc = desc.replace("%COLORE%", colore);
			email = email.replace("%COLORE%", colore);

			String testoAllerta = "";
			String eventi[] = { "per criticita' idraulica", "per criticita' idrogeologica",
					"per criticita' per temporali", "per vento", "per temperature estreme", "per neve",
					"per pioggia che gela", "per stato del mare", "per criticita' costiera" };

			List<HashMap<Number, List<AllertaStato>>> ll = new ArrayList<HashMap<Number, List<AllertaStato>>>();
			
			boolean oggiVerde = false;
			boolean domaniVerde = false;
			
			if (nuovoTipo && a.getParentId()>0) {
				ll.add(rossoX);
				ll.add(arancioneX);
				ll.add(gialloX);
				
				oggiVerde = rossoX.isEmpty() && arancioneX.isEmpty() && gialloX.isEmpty();
				domaniVerde = rosso.isEmpty() && arancione.isEmpty() && giallo.isEmpty();
				
			}
			
			ll.add(rosso);
			ll.add(arancione);
			ll.add(giallo);
			
			
			
			

			for (int jj = 0; jj < ll.size(); jj++) {
				
				if (a.getParentId()>0 && (jj%3)==0) {
					//intestazione della giornata di riferimento
					Date d = a.getDataInizio();
					if (jj==3) {
						Calendar c = Calendar.getInstance(Locale.ITALY);
						c.setTime(d);
						c.set(Calendar.HOUR_OF_DAY, 0);
						c.set(Calendar.MINUTE, 0);
						c.set(Calendar.SECOND, 0);
						c.set(Calendar.MILLISECOND, 0);
						c.add(Calendar.DAY_OF_YEAR, 1);
						d = c.getTime();
					}
					String ox = new SimpleDateFormat("HH:mm").format(d);
					String gx = new SimpleDateFormat("dd-MM-yyyy").format(d);
					String ux = new SimpleDateFormat("u").format(d);
					String giorno = " ";
					if ("1".equals(ux)) giorno = " lunedì ";
					if ("2".equals(ux)) giorno = " martedì ";
					if ("3".equals(ux)) giorno = " mercoledì ";
					if ("4".equals(ux)) giorno = " giovedì ";
					if ("5".equals(ux)) giorno = " venerdì ";
					if ("6".equals(ux)) giorno = " sabato ";
					if ("7".equals(ux)) giorno = " domenica ";
					testoAllerta += "<br/><b>Dalle "+ox+" di"+giorno+gx+"</b><br/>";
					if ((jj==0 && oggiVerde) || (jj==3 && domaniVerde))
						testoAllerta+="CODICE COLORE VERDE: in tutte le zone di allerta.<br/>";
				}
				
				HashMap<Number, List<AllertaStato>> rr = ll.get(jj);
				if (rr != null && !rr.isEmpty()) {
					if ((jj%3) == 0)
						testoAllerta += "CODICE COLORE ROSSO: ";
					if ((jj%3) == 1)
						testoAllerta += "CODICE COLORE ARANCIONE: ";
					if ((jj%3) == 2)
						testoAllerta += "CODICE COLORE GIALLO: ";
					for (Number n : rr.keySet()) {
						testoAllerta += eventi[n.intValue() - 1];
						List<AllertaStato> as = rr.get(n);
						if ((n.intValue() < 4 || nuovoTipo) && as.size() == 1)
							testoAllerta += ", nella zona ";
						if ((n.intValue() < 4 || nuovoTipo) && as.size() != 1)
							testoAllerta += ", nelle zone ";
						if (n.intValue() >= 4 && !nuovoTipo && as.size() == 1)
							testoAllerta += ", nella sottozona ";
						if (n.intValue() >= 4 && !nuovoTipo && as.size() != 1)
							testoAllerta += ", nelle sottozone ";

						List<String> elencoZone = new ArrayList<String>();
						for (int k = 0; k < as.size(); k++) {
							int id = (int) as.get(k).getAreaId();
							if (id<0) id = -id;
							String abc = null;
							switch (id) {
							case 10:
								abc = "A";
								break;
							case 11:
								abc = "A1";
								break;
							case 12:
								abc = "A2";
								break;
							case 20:
								abc = "B";
								break;
							case 21:
								abc = "B1";
								break;
							case 22:
								abc = "B2";
								break;
							case 30:
								abc = "C";
								break;
							case 31:
								abc = "C1";
								break;
							case 32:
								abc = "C2";
								break;
							case 40:
								abc = "D";
								break;
							case 41:
								abc = "D1";
								break;
							case 42:
								abc = "D2";
								break;
							case 43:
								abc = "D3";
								break;
							case 50:
								abc = "E";
								break;
							case 51:
								abc = "E1";
								break;
							case 52:
								abc = "E2";
								break;
							case 60:
								abc = "F";
								break;
							case 61:
								abc = "F1";
								break;
							case 62:
								abc = "F2";
								break;
							case 63:
								abc = "F3";
								break;
							case 70:
								abc = "G";
								break;
							case 71:
								abc = "G1";
								break;
							case 72:
								abc = "G2";
								break;
							case 80:
								abc = "H";
								break;
							case 81:
								abc = "H1";
								break;
							case 82:
								abc = "H2";
								break;

							}

							/*testoAllerta += abc;
							if (k < as.size() - 1)
								testoAllerta += ",";*/
							elencoZone.add(abc);
						}
						
						elencoZone.sort(null);
						for (int k=0; k<elencoZone.size(); k++) {
							testoAllerta+=elencoZone.get(k);
							if (k < elencoZone.size() - 1)
								testoAllerta += ",";
						}
						testoAllerta += "; ";
					}
					testoAllerta += "<br/>";
			
				}
			}

			email = email.replace("%EVENTI%", testoAllerta);

		} catch (Exception e) {
			//logInternoLocalService.log("allerta.sendSms", a.getNumero(), e, null);
			logger.error(e);
		}

		//List<String> gerarchia = new ArrayList<String>();

		// aggiungi i destinatari per zone
		/*for (String z : zone.values()) {
			try {
				System.out.println("Aggiungo zona " + z);
				gerarchia.add("Allerta Zona " + z);
			} catch (Exception e) {
				logger.error(e);
			}
		}
		
		if (nuovoTipo) {
			for (String z : zoneX.values()) {
				try {
					System.out.println("Aggiungo zona " + z);
					gerarchia.add("Allerta Zona " + z);
				} catch (Exception e) {
					logger.error(e);
				}
			}
		}*/
		
		if (zoneX!=null && !zoneX.isEmpty()) zone.putAll(zoneX);

		try {


			List<String> regole = new ArrayList<String>();

			String[] macroaree = { "A", "B", "C", "D", "E", "F", "G", "H" };
			String[] sottoaree = { "1", "2", "3" };

			for (String s : macroaree) {
				if (!zone.containsKey(s))
						regole.add("Allerta Zona " + s + "->false");
				else
					for (String s2 : sottoaree) {
						if (!zone.containsKey(s + s2))
							regole.add("Allerta Zona " + s + "/Allerta Zona " + s + s2 + "->false");
					}
			}
			regole.add("*->true");

			smsLocalService.creaNotificaGruppoRubrica(null, fromSMS, desc, "allerta", a.getNumero(),
					a.getAllertaId(), 20181, "Rubrica Allerta", true, regole);

			

			smsLocalService.inviaSMS("allerta", a.getNumero(), a.getAllertaId());

			// String testoEmail = prepareMessageBodyMail(null, a);

			smsLocalService.eliminaDuplicatiEmail("allerta", a.getNumero(), a.getAllertaId());

			File ff = getReportAsFile(a);

			smsLocalService.inviaEmail("allerta", a.getNumero(), a.getAllertaId(),
					"ALLERTAER - Emessa Allerta " + a.getNumero(), email, fromMail, ff, nomeFile);

			//logInternoLocalService.log("allerta.sendSms", a.getNumero(), "finish", null);

		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("allerta.sendSms", a.getNumero(), e, null);
		}
	}

	private String getParam(String a, String def) {
		try {
			AllertaParametro ap = allertaParametroLocalService.fetchAllertaParametro(a);
			if (ap == null)
				return def;
			return ap.getValore();
		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("AllertaWorkflow", "getParam", e, null);
			return def;
		}
	}

	private void rigeneraPdf(Allerta a, long scope) {

		try {
			
			allertaUtils.invocaServizioRefreshAllerta(a.getAllertaId());
			
		} catch (Exception e) {
			logger.error(e);
		}

	}

	public boolean isIdrogeologica(Allerta a) {

		return a.getProgressivo() > 0;

		/*
		 * System.out.println("isIdro");
		 * 
		 * try { List<AllertaStato> stati =
		 * AllertaStatoUtil.findByAllertaId(a.getAllertaId()); for (AllertaStato s :
		 * stati) { if (s.getEventoId()<4 && s.getStatoId()>=1 && s.getStatoId()<=3)
		 * return true; } } catch (Exception e) { logger.error(e); return false; }
		 * System.out.println("No idro"); return false;
		 */

	}

	private File getReportAsFile(Allerta a) {

		try {

			Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

			try {
				AllertaParametro ap = allertaParametroLocalService
						.fetchAllertaParametro("ALLERTA_PARENT_FOLDER_ID");
				if (ap != null)
					parentFolderId = Long.parseLong(ap.getValore());
			} catch (Exception e) {
			}

			Folder folder = dlAppService.getFolder(20181, parentFolderId, "allerta-" + a.getAllertaId());
			List<FileEntry> fileEntries = dlAppService.getFileEntries(20181, folder.getFolderId());

			for (FileEntry f : fileEntries) {
				if (f.getTitle().startsWith("allerta") || f.getTitle().startsWith("bollettino")) {
					nomeFile = f.getTitle();
					File ff = FileUtil.createTempFile(f.getContentStream());
					return ff;
				}
			}

			return null;

		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("AllertaWorkflow", "getReportAsFile", e, "");
			return null;
		}

	}

	private long getReportId(Allerta a) {

		try {

			Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

			try {
				AllertaParametro ap = allertaParametroLocalService
						.fetchAllertaParametro("ALLERTA_PARENT_FOLDER_ID");
				if (ap != null)
					parentFolderId = Long.parseLong(ap.getValore());
			} catch (Exception e) {
			}

			Folder folder = dlAppService.getFolder(20181, parentFolderId, "allerta-" + a.getAllertaId());
			List<FileEntry> fileEntries = dlAppService.getFileEntries(20181, folder.getFolderId());

			for (FileEntry f : fileEntries) {
				if (f.getTitle().startsWith("allerta") || f.getTitle().startsWith("bollettino")) {
					nomeFile = f.getTitle();
					return f.getFileEntryId();
				}
			}

			return 0;

		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("AllertaWorkflow", "getReportId", e, "");
			return 0;
		}

	}

	public void sendToChannel(String message) {
		
		AllertaBaseConfiguration configuration = AllertaTracker.getAllertaBaseConfiguration();
		if (configuration.disableTelegram()) {
			
			System.out.println("TELEGRAM DISABILITATO");
			return;
		}
		
		String urlTest = "https://api.telegram.org/bot524869072:AAEvFLpoFBHJUMNLhWn1aOvAPdZYPvkHBhM/sendMessage?chat_id=@AllertaMeteoEMR&text=";

		try {
			AllertaParametro ap = allertaParametroLocalService.fetchAllertaParametro("ALLERTA_TELEGRAM_URL");
			if (ap != null)
				urlTest = ap.getValore();
		} catch (Exception e) {
		}

		urlTest += message;
		URL url;
		HttpURLConnection conn = null;
		try {
			url = new URL(urlTest);
			conn = (HttpURLConnection) url.openConnection();
			conn.getInputStream();
			//logInternoLocalService.log("AllertaWorkflow", "sendToChannel", message, "");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			//logInternoLocalService.log("AllertaWorkflow", "sendToChannel", e, "");
		} finally {
			if (conn != null)
				conn.disconnect();
		}
	}
	
	public String getColore(Allerta a) {
		long peggiore = 0;
		
		DynamicQuery dyn = allertaStatoLocalService.dynamicQuery()
				.add(PropertyFactoryUtil.forName("allertaId").eq(a.getAllertaId()));
		List<AllertaStato> s = allertaStatoLocalService.dynamicQuery(dyn);
		
		for (AllertaStato ss : s) {
			long  st = ss.getStatoId();
			if (st!=1000 && st>peggiore) peggiore = st;
		}
		
		if (peggiore==1) return "GIALLA";
		if (peggiore==2) return "ARANCIONE";
		if (peggiore==3) return "ROSSA";
		return "";
	}
	
	@Reference
	AllertaUtilsInterface allertaUtils;

	@Reference
	private AssetEntryLocalService assetEntryLocalService;
	
	@Reference
	private AssetCategoryLocalService assetCategoryLocalService;
	
	@Reference
	private UserLocalService userLocalService;
	
	@Reference
	private CounterLocalService counterLocalService;
	
	@Reference
	private DatiSpecificiInvioLocalService datiSpecificiInvioLocalService;
	
	@Reference
	private ComponentiInvioLocalService componentiInvioLocalService;
	
	@Reference
	private BollettinoParametroLocalService bollettinoParametroLocalService;
	
	@Reference
	private OrganizationLocalService organizationLocalService;
	
	@Reference
	private Portal portal;
	
	@Reference
	private LogInternoLocalService logInternoLocalService;
	
	@Reference
	private AllertaLocalService allertaLocalService;
	
	@Reference
	private AllertaParametroLocalService allertaParametroLocalService;
	
	@Reference
	private IndexerRegistry indexerRegistry;
	
	@Reference
	private SMSLocalService smsLocalService;
	
	@Reference
	private EmailLocalService emailLocalService;
	
	@Reference
	private AllertaStatoLocalService allertaStatoLocalService;
	
	@Reference
	private DLAppService dlAppService;
	

}
