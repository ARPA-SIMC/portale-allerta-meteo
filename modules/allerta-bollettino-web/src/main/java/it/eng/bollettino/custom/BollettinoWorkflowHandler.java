package it.eng.bollettino.custom;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.mail.internet.InternetAddress;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;

import it.eng.allerta.configuration.AllertaBaseConfiguration;
import it.eng.allerta.utils.AllertaTracker;
import it.eng.allerta.utils.AllertaUtils;
import it.eng.allerta.utils.AllertaUtilsInterface;
import it.eng.allerter.model.AllertaParametro;
import it.eng.allerter.model.Email;
import it.eng.allerter.service.AllertaParametroLocalService;
import it.eng.allerter.service.EmailLocalService;
import it.eng.allerter.service.LogInternoLocalService;
import it.eng.allerter.service.SMSLocalService;
import it.eng.bollettino.model.Bollettino;
import it.eng.bollettino.model.BollettinoParametro;
import it.eng.bollettino.service.BollettinoLocalService;
import it.eng.bollettino.service.BollettinoParametroLocalService;
import it.eng.parer.model.ComponentiInvio;
import it.eng.parer.model.DatiSpecificiInvio;
import it.eng.parer.model.DocumentiCollegati;
import it.eng.parer.service.ComponentiInvioLocalService;
import it.eng.parer.service.DatiSpecificiInvioLocalService;

@Component(immediate = true, service = WorkflowHandler.class)
public class BollettinoWorkflowHandler extends BaseWorkflowHandler<Bollettino> {

	public AssetCategory pubblicato;
	public AssetCategory lavorazione;
	public AssetCategory presentato;
	public AssetCategory homepage;
	
	private Log logger = LogFactoryUtil.getLog(BollettinoWorkflowHandler.class);

	String nomeFile = "";

	public String getClassName() {
		return CLASS_NAME;
	}

	public String getType(Locale locale) {
		return "Bollettino";
	}
	
	private void logCambioStato(String b, int stato) {
		String stringaStato = "";
		switch (stato) {
		case WorkflowConstants.STATUS_DRAFT: stringaStato="Bozza"; break;
		case WorkflowConstants.STATUS_APPROVED: stringaStato="Approvato"; break;
		case WorkflowConstants.STATUS_PENDING: stringaStato="In Approvazione"; break;
		case WorkflowConstants.STATUS_DENIED: stringaStato="Respinto"; break;
		}
		
		logInternoLocalService.log("monitoraggio",
				"Cambio di stato","Documento "+b+" passato in stato "+stringaStato,"");
	}

	public Bollettino updateStatus(int status, Map<String, Serializable> workflowContext)
			throws PortalException, SystemException {

		System.out.println("BOLLETTINO WORKFLOW " + status);
		// BollettinoUtil.getPersistence().find

		String text = null;
		String subject = null;
		String textPlusOne = null;
		String subjectPlusOne = null;

		// long userId =
		// GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));

		long resourcePrimKey = GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
		//long userId = bollettinoLocalService.getApprovatore(resourcePrimKey);
		Bollettino feedback = bollettinoLocalService.getBollettino(resourcePrimKey);

		String tipo = "workflowMonitoraggio";
		String sottotipo = feedback.getNumero();
		long l = new Date().getTime();
		
		

		if (status == WorkflowConstants.STATUS_PENDING && feedback.getStato() == WorkflowConstants.STATUS_DENIED)
			return feedback;
		
		logCambioStato(sottotipo, status);

		if (status == WorkflowConstants.STATUS_DRAFT) {
			if (lavorazione == null)
				caricaPubblicatoTag();
			if (lavorazione != null)
				assetCategoryLocalService.addAssetEntryAssetCategory(assetEntryLocalService
						.getEntry(Bollettino.class.getName(), feedback.getBollettinoId()).getEntryId(), lavorazione);
			assetEntryLocalService.updateVisible(Bollettino.class.getName(), resourcePrimKey, true);
			IndexerRegistryUtil.nullSafeGetIndexer(Bollettino.class).reindex(feedback);
		}

		// if (feedback.getStato()==status) return feedback;

		if (status == WorkflowConstants.STATUS_DENIED) {

			mandaNotificaSoloEmail(getParam("EMAIL_RESPINGI_BOLLETTINO", ""), tipo, sottotipo, l + 1);
			if (feedback.getIdApprovatore() != 0)
				mandaNotificaSoloEmail(feedback.getIdApprovatore(), tipo, sottotipo, l + 1);

			text = null;
			subject = null;
			textPlusOne = "<html><head></head><body>Il monitoraggio " + feedback.getNumero()
					+ " e' stato respinto.</body></html>";
			subjectPlusOne = "Monitoraggio " + feedback.getNumero() + " respinto";

			feedback.setStato(WorkflowConstants.STATUS_DENIED);
			if (pubblicato == null || lavorazione == null || presentato == null)
				caricaPubblicatoTag();
			feedback.setStato(status);
			feedback = bollettinoLocalService.updateBollettino(feedback);

			// mandaMessaggioRifiuto(feedback);

			long id = assetEntryLocalService.getEntry(Bollettino.class.getName(), feedback.getBollettinoId())
					.getEntryId();
			assetCategoryLocalService.clearAssetEntryAssetCategories(id);
			if (lavorazione != null)
				assetCategoryLocalService.addAssetEntryAssetCategory(id, lavorazione);
		}

		// feedback.setStato(status);
		// feedback=bollettinoLocalService.updateBollettino(feedback);
		if (status == WorkflowConstants.STATUS_APPROVED) {

			mandaNotificaSoloEmail(feedback.getIdApprovatore(), tipo, sottotipo, l + 1);
			mandaNotificaSoloEmail(getParam("EMAIL_APPROVA_BOLLETTINO", ""), tipo, sottotipo, l + 1);

			textPlusOne = "<html><head></head><body>Il monitoraggio " + feedback.getNumero()
					+ " e' stato approvato.</body></html>";
			subjectPlusOne = "Monitoraggio " + feedback.getNumero() + " approvato";

			ServiceContext s = (ServiceContext) 
					workflowContext.get(WorkflowConstants.CONTEXT_SERVICE_CONTEXT);
			if (s != null) {
				System.out.println("CONTEXT OK");
				System.out.println(s.getThemeDisplay());
				System.out.println(s.getPortalURL());
				System.out.println(s.getGuestOrUserId());
			} else
				System.out.println("CONTEXT NOT OK");

			feedback.setStato(status);
			feedback.setDataApprovazione(new Date());
			feedback.setDataEmissione(new Date());
			//feedback.setIdApprovatore(userId);
			feedback = bollettinoLocalService.updateBollettino(feedback);

			rigeneraPdf(feedback, feedback.getGroupId());

			// PARER
			try {
				if (!AllertaTracker.getAllertaBaseConfiguration().disableParer()) {
					User arpa = userLocalService.getUser(feedback.getIdApprovatore());
					String[] num = feedback.getNumero().split("/");
					DatiSpecificiInvio dsi = datiSpecificiInvioLocalService.createDatiSpecificiInvio(0);
					dsi.setCHIAVE_NUMERO(num[0] + num[2].substring(0, 2));
					dsi.setCHIAVE_ANNO(Long.parseLong(num[1]));
					dsi.setDATA_UNITA_DOCUMENTARIA(feedback.getDataEmissione());
					dsi.setIDENTIFICATIVO_DATO_SPECIFICO("" + feedback.getBollettinoId());
					dsi.setDATA_GENERAZIONE(feedback.getCreateDate());
					dsi.setDENOMINAZIONE_APPLICATIVO("AllertaMeteoER");
					dsi.setCOMPILATORE_ARPAE(feedback.getUserName());
					dsi.setAPPROVATORE_ARPAE(arpa.getFullName());
					dsi.setDATA_INIZIO_VALIDITA(feedback.getDataInizio());
					dsi.setDATA_FINE_VALIDITA(feedback.getDataFine());
					dsi.setDATA_FIRMA_ARPAE(feedback.getDataApprovazione());
	
					ArrayList<DocumentiCollegati> documentiCollegati = new ArrayList<DocumentiCollegati>();
					ArrayList<ComponentiInvio> componentiInvio = new ArrayList<ComponentiInvio>();
	
					ComponentiInvio c = componentiInvioLocalService.getNuovoComponenteInvio();
					c.setHASH_VERSATO(feedback.getHash());
					c.setID_COMPONENTE_VERSATO(getReportId(feedback));
					c.setNOME_COMPONENTE(nomeFile);
					c.setURN_VERSATO("https://allertameteo.regione.emilia-romagna.it" + feedback.getLink());
					c.setFORMATO_FILE_VERSATO("PDF");
					componentiInvio.add(c);
					datiSpecificiInvioLocalService.comunicaDatiSpecificiInvioMonitoraggio(dsi, documentiCollegati,
							componentiInvio);
				}

			} catch (Exception e) {
				//logInternoLocalService.log("MonitoraggioWorkflow", "approva", e, "");
				logger.error(e);
			}

			String url = "https://allertameteo.regione.emilia-romagna.it";
			try {
				AllertaParametro ap = allertaParametroLocalService.getAllertaParametro("URL_PRIMES");
				if (ap != null)
					url = ap.getValore();
			} catch (Exception e) {
			}
			sendToChannel(
					"Emanato documento di monitoraggio " + feedback.getNumero() + ": " + url + feedback.getLink());

			if (pubblicato == null)
				caricaPubblicatoTag();

			try {
				if (lavorazione != null)
					assetCategoryLocalService.deleteAssetEntryAssetCategory(feedback.getBollettinoId(), lavorazione);
			} catch (Exception e) {
			}
			try {
				if (presentato != null)
					assetCategoryLocalService.deleteAssetEntryAssetCategory(feedback.getBollettinoId(), presentato);
			} catch (Exception e) {
			}

			if (pubblicato != null) {
				// assetCategoryLocalService.clearAssetEntryAssetCategories(assetEntryLocalService.getEntry(Bollettino.class.getName(),
				// feedback.getBollettinoId()).getEntryId());
				assetCategoryLocalService.addAssetEntryAssetCategory(assetEntryLocalService
						.getEntry(Bollettino.class.getName(), feedback.getBollettinoId()).getEntryId(), pubblicato);
			}

			if (homepage != null) {
				assetCategoryLocalService.addAssetEntryAssetCategory(assetEntryLocalService
						.getEntry(Bollettino.class.getName(), feedback.getBollettinoId()).getEntryId(), homepage);
			}

			assetEntryLocalService.updateVisible(Bollettino.class.getName(), resourcePrimKey, true);
			IndexerRegistryUtil.nullSafeGetIndexer(Bollettino.class).reindex(feedback);

			/*
			 * try { sendMail(Long.parseLong(workflowContext.get(WorkflowConstants.
			 * CONTEXT_COMPANY_ID).toString()),feedback); } catch (Exception mail) {
			 * System.out.println("MAIL EXCEPTION: "+mail.getMessage()); }
			 */

			String fromSMS = "33312345678";
			try {
				BollettinoParametro bp = bollettinoParametroLocalService
						.fetchBollettinoParametro("SMS_FROM_BOLLETTINO");
				if (bp != null)
					fromSMS = bp.getValore();

			} catch (Exception e) {
			}

			sendSMS(feedback, fromSMS); // manda anche le mail
		}

		if (status == WorkflowConstants.STATUS_PENDING) {

			mandaNotifica(feedback.getIdApprovatore(),
					"Il monitoraggio " + feedback.getNumero()
							+ " è in attesa di approvazione: https://allertameteo.regione.emilia-romagna.it",
					feedback, tipo, sottotipo, l);

			text = "<html><head></head><body>Il monitoraggio " + feedback.getNumero()
					+ " e' in attesa di approvazione su <a href=\"https://allertameteo.regione.emilia-romagna.it\">https://allertameteo.regione.emilia-romagna.it</a></body></html>";
			subject = "Il documento " + feedback.getNumero() + " è in attesa di approvazione";

			long id = assetEntryLocalService.getEntry(Bollettino.class.getName(), feedback.getBollettinoId())
					.getEntryId();

			if (presentato == null)
				caricaPubblicatoTag();
			if (presentato != null) {
				// assetCategoryLocalService.clearAssetEntryAssetCategories(assetEntryLocalService.getEntry(Bollettino.class.getName(),
				// feedback.getBollettinoId()).getEntryId());
				assetCategoryLocalService.addAssetEntryAssetCategory(id, presentato);
			}

			try {
				if (lavorazione != null)
					assetCategoryLocalService.deleteAssetEntryAssetCategory(id, lavorazione);
			} catch (Exception e) {

				logger.error(e);
			}

			assetEntryLocalService.updateVisible(Bollettino.class.getName(), resourcePrimKey, true);
			IndexerRegistryUtil.nullSafeGetIndexer(Bollettino.class).reindex(feedback);
		}

		if (text != null) {
			spedisciNotifiche(tipo, sottotipo, l, subject, text, feedback);
		}

		if (textPlusOne != null) {
			spedisciNotifiche(tipo, sottotipo, l + 1, subjectPlusOne, textPlusOne, feedback);
		}

		return feedback;
	}

	public static final String CLASS_NAME = Bollettino.class.getName();

	public void caricaPubblicatoTag() throws SystemException {

		List<AssetCategory> list = assetCategoryLocalService.getCategories();

		for (AssetCategory t : list) {
			if (t.getName().equals("monitoraggio-pubblicato")) {
				pubblicato = t;
				System.out.println("trovata categoria " + t.getCategoryId());
			}
			if (t.getName().equals("monitoraggio-presentato")) {
				presentato = t;
				System.out.println("trovata categoria " + t.getCategoryId());
			}
			if (t.getName().equals("monitoraggio-lavorazione")) {
				lavorazione = t;
				System.out.println("trovata categoria " + t.getCategoryId());
			}
			if (t.getName().equals("mostra-in-home")) {
				homepage = t;
				System.out.println("trovata categoria " + t.getCategoryId());
			}
		}

	}

	private void sendSMS(Bollettino a, String from) {
		try {

			boolean nuovaRubrica = smsLocalService.isNuovaRubricaAttiva();

			// UserGroup ug = UserGroupLocalServiceUtil.getUserGroup(20154,
			// "destinatari-monitoraggio");
			if (true) {

				String testo = "Emanato documento di monitoraggio %NUMERO%";

				try {
					BollettinoParametro bp = bollettinoParametroLocalService
							.fetchBollettinoParametro("SMS_TESTO_BOLLETTINO");
					if (bp != null)
						testo = bp.getValore();
				} catch (Exception e) {
				}

				testo = testo.replace("%NUMERO%", a.getNumero());

				List bacini = bollettinoLocalService.getFiumiBollettino(a.getBollettinoId());

				List<String> b2 = new ArrayList<String>();
				b2.add("§§§");
				for (Object ob : bacini)
					b2.add(ob.toString());

				// bollettinoLocalService.

				if (nuovaRubrica) {

					List<String> regole = new ArrayList<String>();

					// questi bacini sono inclusi
					for (String s : b2)
						regole.add("Monitoraggio "+s.toUpperCase()+"->true");
					// tutti gli altri no, usa una regular expression
					regole.add("@Monitoraggio .*@->false");

					smsLocalService.creaNotificaGruppoRubrica(null, from, testo, "monitoraggio", a.getNumero(),
							a.getBollettinoId(), 20181, "Rubrica Monitoraggio", true, regole);

				} else {
					Organization o = organizationLocalService.fetchOrganization(20154, "Rubrica Monitoraggio");
					if (o != null) {
						smsLocalService.creaSMSOrganization(from, testo, "monitoraggio", a.getNumero(),
								a.getBollettinoId(), o.getOrganizationId(), 0, b2);
					}
				}
				// smsLocalService.creaSMSUserGroup(from, "Emanato documento di monitoraggio
				// "+a.getNumero(), "monitoraggio", a.getNumero(), a.getBollettinoId(),
				// ug.getUserGroupId());
				smsLocalService.inviaSMS("monitoraggio", a.getNumero(), a.getBollettinoId());
			}
		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("BollettinoWorkflow", "inviaSMS", e, "");
		}

		String ff = "monitoraggio@allertameteoer.it";

		try {
			BollettinoParametro bp = bollettinoParametroLocalService
					.fetchBollettinoParametro("EMAIL_FROM_BOLLETTINO");
			if (bp != null)
				ff = bp.getValore();

			String body = "Emesso documento di monitoraggio %NUMERO%";

			try {
				BollettinoParametro bp2 = bollettinoParametroLocalService
						.fetchBollettinoParametro("EMAIL_TESTO_BOLLETTINO");
				if (bp != null)
					body = bp2.getValore();
			} catch (Exception e) {
			}

			body = body.replace("%NUMERO%", a.getNumero());

			File fil = getReportAsFile(a);

			smsLocalService.inviaEmail("monitoraggio", a.getNumero(), a.getBollettinoId(),
					"ALLERTAER - Emesso Documento di monitoraggio n. " + a.getNumero(), body, ff, fil, nomeFile);

		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("BollettinoWorkflow", "inviaEmail", e, "");
		}

	}

	private void mandaMessaggioRifiuto(Bollettino a) {
		try {

			BollettinoParametro bp = bollettinoParametroLocalService
					.fetchBollettinoParametro("EMAIL_RESPINGI_BOLLETTINO");
			if (bp == null)
				return;

			String email = bp.getValore();
			if (email == null)
				return;

			String subject = "Respingimento monitoraggio " + a.getNumero();
			MailMessage mailMessage = new MailMessage();
			String[] ss = subject.split(",");
			InternetAddress[] ia = new InternetAddress[ss.length];
			for (int k = 0; k < ss.length; k++)
				ia[k] = new InternetAddress(ss[k]);
			mailMessage.setTo(ia);
			mailMessage.setFrom(new InternetAddress("no-reply@allertemeteoer.it"));
			mailMessage.setSubject(subject);
			mailMessage.setBody("Il monitoraggio " + a.getNumero() + " e' stato respinto dall'approvatore.");
			mailMessage.setHTMLFormat(true);
			mailService.sendEmail(mailMessage);

		} catch (Exception e) {
			//logInternoLocalService.log("BollettinoWorkflow", "mandaMessaggioRifiuto", e, "");
			logger.error(e);
		}
	}

	private void rigeneraPdf(Bollettino a, long scope) {

		try {
			
			allertaUtils.invocaServizioRefreshMonitoraggio(a.getBollettinoId());
			
			/*BollettinoParametro ap = bollettinoParametroLocalService
					.fetchBollettinoParametro("BOLLETTINO_PDF_REFRESH_URL");

			String url = (ap != null ? ap.getValore()
					: "http://localhost:" + portal.getPortalServerPort(false) + "/o/api/allerta/buildAllertaPdf");

			url += ("?tipo=bollettino&scope=" + scope + "&id=" + a.getBollettinoId());

			System.out.println(url);

			new URL(url).openConnection().getInputStream();*/
			
		} catch (Exception e) {
			
			//logInternoLocalService.log("BollettinoWorkflow", "rigeneraPdf", e, "");
			logger.error(e);
		}

	}

	private File getReportAsFile(Bollettino a) {

		try {

			Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

			try {
				BollettinoParametro ap = bollettinoParametroLocalService
						.fetchBollettinoParametro("BOLLETTINO_PARENT_FOLDER_ID");
				if (ap != null)
					parentFolderId = Long.parseLong(ap.getValore());
			} catch (Exception e) {
			}

			Folder folder = dlAppService.getFolder(20181, parentFolderId, "bollettino-" + a.getBollettinoId());
			List<FileEntry> fileEntries = dlAppService.getFileEntries(20181, folder.getFolderId());

			for (FileEntry f : fileEntries) {
				if (f.getTitle().startsWith("monitoraggio")) {
					nomeFile = f.getTitle();
					File ff = FileUtil.createTempFile(f.getContentStream());
					return ff;
				}
			}

			return null;

		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("BollettinoWorkflow", "getReportAsFile", e, "");
			return null;
		}

	}

	private long getReportId(Bollettino a) {

		try {

			Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

			try {
				BollettinoParametro ap = bollettinoParametroLocalService
						.fetchBollettinoParametro("BOLLETTINO_PARENT_FOLDER_ID");
				if (ap != null)
					parentFolderId = Long.parseLong(ap.getValore());
			} catch (Exception e) {
			}

			Folder folder = dlAppService.getFolder(20181, parentFolderId, "bollettino-" + a.getBollettinoId());
			List<FileEntry> fileEntries = dlAppService.getFileEntries(20181, folder.getFolderId());

			for (FileEntry f : fileEntries) {
				if (f.getTitle().startsWith("monitoraggio")) {
					nomeFile = f.getTitle();
					return f.getFileEntryId();
				}
			}

			return 0;

		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("BollettinoWorkflow", "getReportAsFile", e, "");
			return 0;
		}

	}

	private String getParam(String a, String def) {
		try {
			BollettinoParametro ap = bollettinoParametroLocalService.fetchBollettinoParametro(a);
			if (ap == null)
				return def;
			return ap.getValore();
		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("BollettinoWorkflow", "getParam", e, null);
			return def;
		}
	}

	public void mandaNotifica(long idUtente, String testo, Bollettino a, String tipo, String sottotipo, long l) {
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

				long id = CounterLocalServiceUtil.increment(Email.class.getName());
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
			Bollettino a) {

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

	public void sendToChannel(String message) {
		
		AllertaBaseConfiguration configuration = AllertaTracker.getAllertaBaseConfiguration();
		if (configuration.disableTelegram()) {
			
			System.out.println("TELEGRAM DISABILITATO");
			return;
		}
		
		String urlTest = "<URL_TELEGRAM>";

		try {
			BollettinoParametro ap = bollettinoParametroLocalService
					.fetchBollettinoParametro("ALLERTA_TELEGRAM_URL");
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
			//logInternoLocalService.log("BollettinoWorkflow", "sendToChannel", message, "");

		} catch (IOException e) {
			logger.error(e);
			//logInternoLocalService.log("BollettinoWorkflow", "sendToChannel", e, "");
		} finally {
			if (conn != null)
				conn.disconnect();
		}
	}

	@Reference
	AllertaUtilsInterface allertaUtils;
	
	@Reference
	private AssetCategoryLocalService assetCategoryLocalService;

	@Reference
	private AssetEntryLocalService assetEntryLocalService;

	@Reference
	private UserLocalService userLocalService;
	
	@Reference
	private OrganizationLocalService organizationLocalService;
	
	@Reference
	private MailService mailService;
	
	@Reference
	private Portal portal;
	
	@Reference
	private DLAppService dlAppService;
	
	@Reference
	private BollettinoLocalService bollettinoLocalService;
	
	@Reference
	private DatiSpecificiInvioLocalService datiSpecificiInvioLocalService;
	
	@Reference
	private ComponentiInvioLocalService componentiInvioLocalService;
	
	@Reference
	private LogInternoLocalService logInternoLocalService;
	
	@Reference
	private AllertaParametroLocalService allertaParametroLocalService;
	
	@Reference
	private BollettinoParametroLocalService bollettinoParametroLocalService;
	
	@Reference
	private SMSLocalService smsLocalService;
	
	@Reference
	private EmailLocalService emailLocalService;
	
	
}
