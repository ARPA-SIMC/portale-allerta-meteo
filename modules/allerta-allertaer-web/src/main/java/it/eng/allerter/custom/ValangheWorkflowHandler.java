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
import it.eng.allerter.model.AllertaValanghe;
import it.eng.allerter.model.AllertaValangheStato;
import it.eng.allerter.model.Email;
import it.eng.allerter.service.AllertaLocalService;
import it.eng.allerter.service.AllertaParametroLocalService;
import it.eng.allerter.service.AllertaStatoLocalService;
import it.eng.allerter.service.AllertaValangheLocalService;
import it.eng.allerter.service.AllertaValangheStatoLocalService;
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
public class ValangheWorkflowHandler extends BaseWorkflowHandler<AllertaValanghe> {

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
		
		logInternoLocalService.log(tipo?"allertaV":"bollettinoV",
				"Cambio di stato","Documento valanghe "+allerta+" passato in stato "+stringaStato,"");
	}

	public AllertaValanghe updateStatus(int status, Map<String, Serializable> workflowContext)
			throws PortalException, SystemException {
		// long userId =
		// GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));

		String text = null;
		String subject = null;
		String textPlusOne = null;
		String subjectPlusOne = null;

		System.out.println("VALANGHE WORKFLOW  " + status);

		//if (pubblicato == null || revisione == null || lavorazione == null)
			//caricaPubblicatoTag();
  
		long resourcePrimKey = GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
		//long userId = allertaLocalService.getIdApprovatore(resourcePrimKey);
		AllertaValanghe feedback = allertaLocalService.getAllertaValanghe(resourcePrimKey);
		 
		if (feedback.getStato()==WorkflowConstants.STATUS_APPROVED) return feedback;
		if (feedback.getStato()==1000 && status==1) return feedback;
		
		logCambioStato(feedback.getTipoAllerta(), feedback.getNumero(), status);
		//logInternoLocalService.log("AllertaWorkflow", "updateStatus " + status, "stato " + feedback.getStato(), "");

		String tipo = (feedback.getTipoAllerta() ? "workflowAllValanghe" : "workflowBolValanghe");
		String sottotipo = feedback.getNumero();
		long l = new Date().getTime();

		if (status == WorkflowConstants.STATUS_PENDING && feedback.getStato() == WorkflowConstants.STATUS_DENIED) {


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
			feedback = allertaLocalService.updateAllertaValanghe(feedback);

			mandaNotificaSoloEmail(getParam("EMAIL_RESPINGI_ALLERTA", ""), tipo, sottotipo, l + 1);
			if (feedback.getUtenteFirmaArpaId() != 0)
				mandaNotificaSoloEmail(feedback.getUtenteFirmaArpaId(), tipo, sottotipo, l + 1);
			if (feedback.getUtenteFirmaProtId() != 0)
				mandaNotificaSoloEmail(feedback.getUtenteFirmaProtId(), tipo, sottotipo, l + 1);

			text = null;
			subject = null;
			textPlusOne = "<html><head></head><body>Il documento valanghe " + feedback.getNumero()
					+ " e' stato respinto.</body></html>";
			subjectPlusOne = "Documento valanghe " + feedback.getNumero() + " respinto";

			// mandaMessaggioRifiuto(feedback);
			long id = assetEntryLocalService.getEntry(AllertaValanghe.class.getName(), feedback.getAllertaValangheId())
					.getEntryId();
			assetCategoryLocalService.clearAssetEntryAssetCategories(id);
			
			assetCategoryLocalService.addAssetEntryAssetCategory(id, lavorazione);
		}

		if (status == WorkflowConstants.STATUS_PENDING) {

			mandaNotifica(feedback.getUtenteFirmaArpaId(),
					"Il documento valanghe " + feedback.getNumero()
							+ " è in attesa di approvazione: https://allertameteo.regione.emilia-romagna.it",
					feedback, tipo, sottotipo, l);

			text = "<html><head></head><body>Il documento valanghe " + feedback.getNumero()
					+ " e' in attesa di approvazione su <a href=\"https://allertameteo.regione.emilia-romagna.it\">https://allertameteo.regione.emilia-romagna.it</a></body></html>";
			subject = "Il documento valanghe " + feedback.getNumero() + " è in attesa di approvazione";

			long id = assetEntryLocalService.getEntry(AllertaValanghe.class.getName(), feedback.getAllertaValangheId())
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
		feedback = allertaLocalService.updateAllertaValanghe(feedback);

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
					dsi.setCHIAVE_NUMERO((feedback.getTipoAllerta()?"0":"")
							+feedback.getNumero().split("/")[0]);
					dsi.setCHIAVE_ANNO(Long.parseLong(feedback.getNumero().split("/")[1]));
					dsi.setDATA_UNITA_DOCUMENTARIA(feedback.getDataEmissione());
					dsi.setIDENTIFICATIVO_DATO_SPECIFICO("" + feedback.getAllertaValangheId());
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
						datiSpecificiInvioLocalService.comunicaDatiSpecificiInvioValanghe(dsi, documentiCollegati,
								componentiInvio);

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
					titolo = titolo.replace("Allerta valanghe", "Allerta valanghe "+colore);
				sendToChannel(titolo + " - " + url + feedback.getLink());
			} catch (Exception e) {
				logger.error(e);
			}
			//if (pubblicato == null || revisione == null)
			//	caricaPubblicatoTag();

			long id = assetEntryLocalService.getEntry(AllertaValanghe.class.getName(), feedback.getAllertaValangheId())
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


			// if (revisione!=null)
			// assetCategoryLocalService.deleteAssetEntryAssetCategory(id, revisione);

			assetEntryLocalService.updateVisible(AllertaValanghe.class.getName(), resourcePrimKey, true);
			indexerRegistry.nullSafeGetIndexer(AllertaValanghe.class).reindex(feedback);

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
			assetEntryLocalService.updateVisible(AllertaValanghe.class.getName(), resourcePrimKey, true);
		}
		return feedback;
	}
	
	

	public static final String CLASS_NAME = AllertaValanghe.class.getName();

	

	public void mandaNotifica(long idUtente, String testo, AllertaValanghe a, String tipo, String sottotipo, long l) {
		try {
			User u = userLocalService.fetchUser(idUtente);
			if (u == null)
				return;
			smsLocalService.creaSMS("AllerteER", testo, tipo, sottotipo, l, u);

		} catch (Exception e) {
			logger.error(e);
		}
	}

	public void mandaNotificaSoloEmail(long idUtente, String tipo, String sottotipo, long l) {
		try {
			User u = userLocalService.fetchUser(idUtente);
			if (u == null)
				return;
			smsLocalService.creaEmail(tipo, sottotipo, l, u);
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public void mandaNotificaSoloEmail(String indirizzi, String tipo, String sottotipo, long l) {
		try {
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

		} catch (Exception e) {
			logger.error(e);
		}
	}

	public void spedisciNotifiche(String tipo, String sottotipo, long l, String emailSubject, String emailText,
			AllertaValanghe a) {

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

	public void sendSms(AllertaValanghe a) {

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

		String desc = "Emanata Allerta Valanghe %NUMERO%";
		String email = "Emanata Allerta Valanghe %NUMERO%";

		try {
			AllertaParametro bp = allertaParametroLocalService.fetchAllertaParametro("SMS_TESTO_ALLERTA_VALANGHE");
			if (bp != null)
				desc = bp.getValore();

		} catch (Exception e) {
		}

		try {
			AllertaParametro bp = allertaParametroLocalService.fetchAllertaParametro("EMAIL_TESTO_ALLERTA_VALANGHE");
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


		HashMap<String, String> zone = new HashMap<String, String>();
		HashMap<String, String> zoneX = new HashMap<String, String>();
		
		long peggiore = 0;

		try {

			DynamicQuery dyn = allertaStatoLocalService.dynamicQuery()
					.add(PropertyFactoryUtil.forName("allertaValangheId").eq(a.getAllertaValangheId()));
			List<AllertaValangheStato> s = allertaStatoLocalService.dynamicQuery(dyn);

			HashMap<Number, List<AllertaValangheStato>> rosso = new HashMap<Number, List<AllertaValangheStato>>();
			HashMap<Number, List<AllertaValangheStato>> arancione = new HashMap<Number, List<AllertaValangheStato>>();
			HashMap<Number, List<AllertaValangheStato>> giallo = new HashMap<Number, List<AllertaValangheStato>>();

			HashMap<Number, List<AllertaValangheStato>> rossoX = new HashMap<Number, List<AllertaValangheStato>>();
			HashMap<Number, List<AllertaValangheStato>> arancioneX = new HashMap<Number, List<AllertaValangheStato>>();
			HashMap<Number, List<AllertaValangheStato>> gialloX = new HashMap<Number, List<AllertaValangheStato>>();

			
				for (AllertaValangheStato ss : s) {
	
					if (ss.getStatoId() == 0 || ss.getStatoId() == 1000)
						continue;
	
					HashMap<Number, List<AllertaValangheStato>> lista = null;
					if (ss.getStatoId() == 1)
						lista = ss.getAreaId()<0?gialloX:giallo;
					if (ss.getStatoId() == 2)
						lista = ss.getAreaId()<0?arancioneX:arancione;
					if (ss.getStatoId() == 3)
						lista = ss.getAreaId()<0?rossoX:rosso;
					if (lista != null) {
						List<AllertaValangheStato> l = lista.get(ss.getEventoId());
						if (l == null) {
							l = new ArrayList<AllertaValangheStato>();
							l.add(ss);
							lista.put(ss.getEventoId(), l);
						} else
							l.add(ss);
					}
	
					if (ss.getStatoId() > peggiore)
						peggiore = ss.getStatoId();

	
					switch ((int) ss.getAreaId()) {
					case 10:
						zone.put("Valanghe App. E. Occidentale", "Valanghe App. E. Occidentale");
						break;
					case 20:
						zone.put("Valanghe App. E. Centrale", "Valanghe App. E. Centrale");
						break;
					case 30:
						zone.put("Valanghe App. Romagnolo", "Valanghe App. Romagnolo");
						break;
					case -10:
						zoneX.put("Valanghe App. E. Occidentale", "Valanghe App. E. Occidentale");
						break;
					case -20:
						zoneX.put("Valanghe App. E. Centrale", "Valanghe App. E. Centrale");
						break;
					case -30:
						zoneX.put("Valanghe App. Romagnolo", "Valanghe App. Romagnolo");
						break;
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

			List<HashMap<Number, List<AllertaValangheStato>>> ll = new ArrayList<HashMap<Number, List<AllertaValangheStato>>>();

			boolean oggiVerde = false;
			boolean domaniVerde = false;
			
			if (a.getParentId()>0) {
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
				
				HashMap<Number, List<AllertaValangheStato>> rr = ll.get(jj);
				if (rr != null && !rr.isEmpty()) {
					if ((jj%3) == 0)
						testoAllerta += "CODICE COLORE ROSSO ";
					if ((jj%3) == 1)
						testoAllerta += "CODICE COLORE ARANCIONE ";
					if ((jj%3) == 2)
						testoAllerta += "CODICE COLORE GIALLO ";
					for (Number n : rr.keySet()) {
						List<AllertaValangheStato> as = rr.get(n);
						testoAllerta += "su ";

						for (int k = 0; k < as.size(); k++) {
							int id = (int) as.get(k).getAreaId();
							if (id<0) id = -id;
							String abc = null;
							switch (id) {
							case 10:
								abc = "Appennino Emiliano occidentale";
								break;
							case 20:
								abc = "Appennino Emiliano centrale";
								break;
							case 30:
								abc = "Appennino Romagnolo";
								break;
							}

							testoAllerta += abc;
							if (k < as.size() - 1)
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

		List<String> gerarchia = new ArrayList<String>();

		if (zoneX!=null && !zoneX.isEmpty()) zone.putAll(zoneX);
		// aggiungi i destinatari per zone
		for (String z : zone.values()) {
			try {
				System.out.println("Aggiungo zona " + z);
				gerarchia.add(z);
			} catch (Exception e) {
				logger.error(e);
			}
		}

		try {


			smsLocalService.creaNotificaGruppoRubrica(null, fromSMS, desc, "valanghe", a.getNumero(),
					a.getAllertaValangheId(), 20181, "Valanghe SEMPRE", true, null);

			for (String g : gerarchia) {
				smsLocalService.creaNotificaGruppoRubrica(null, fromSMS, desc, "valanghe", a.getNumero(),
						a.getAllertaValangheId(), 20181, g, true, null);

			}

			smsLocalService.inviaSMS("valanghe", a.getNumero(), a.getAllertaValangheId());

			// String testoEmail = prepareMessageBodyMail(null, a);

			smsLocalService.eliminaDuplicatiEmail("valanghe", a.getNumero(), a.getAllertaValangheId());

			File ff = getReportAsFile(a);

			smsLocalService.inviaEmail("valanghe", a.getNumero(), a.getAllertaValangheId(),
					"ALLERTAER - Emessa Allerta Valanghe " + a.getNumero(), email, fromMail, ff, nomeFile);

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

	private void rigeneraPdf(AllertaValanghe a, long scope) {

		try {
			
			allertaUtils.invocaServizio("refreshValanghe",a.getAllertaValangheId());
			
		} catch (Exception e) {
			logger.error(e);
		}

	}


	private File getReportAsFile(AllertaValanghe a) {

		try {

			Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

			try {
				AllertaParametro ap = allertaParametroLocalService
						.fetchAllertaParametro("VALANGHE_PARENT_FOLDER_ID");
				if (ap != null)
					parentFolderId = Long.parseLong(ap.getValore());
			} catch (Exception e) {
			}

			Folder folder = dlAppService.getFolder(20181, parentFolderId, "allerta-valanghe-" + a.getAllertaValangheId());
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

	private long getReportId(AllertaValanghe a) {

		try {

			Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

			try {
				AllertaParametro ap = allertaParametroLocalService
						.fetchAllertaParametro("VALANGHE_PARENT_FOLDER_ID");
				if (ap != null)
					parentFolderId = Long.parseLong(ap.getValore());
			} catch (Exception e) {
			}

			Folder folder = dlAppService.getFolder(20181, parentFolderId, "allerta-valanghe-" + a.getAllertaValangheId());
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
	
	public String getColore(AllertaValanghe a) {
		long peggiore = 0;
		
		DynamicQuery dyn = allertaStatoLocalService.dynamicQuery()
				.add(PropertyFactoryUtil.forName("allertaValangheId").eq(a.getAllertaValangheId()));
		List<AllertaValangheStato> s = allertaStatoLocalService.dynamicQuery(dyn);
		
		for (AllertaValangheStato ss : s) {
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
	private AllertaValangheLocalService allertaLocalService;
	
	@Reference
	private AllertaParametroLocalService allertaParametroLocalService;
	
	@Reference
	private IndexerRegistry indexerRegistry;
	
	@Reference
	private SMSLocalService smsLocalService;
	
	@Reference
	private EmailLocalService emailLocalService;
	
	@Reference
	private AllertaValangheStatoLocalService allertaStatoLocalService;
	
	@Reference
	private DLAppService dlAppService;
	

}
