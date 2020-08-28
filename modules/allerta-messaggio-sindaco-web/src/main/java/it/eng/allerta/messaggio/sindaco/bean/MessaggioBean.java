package it.eng.allerta.messaggio.sindaco.bean;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.mail.internet.AddressException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;

import it.eng.allerta.messaggio.sindaco.config.MessaggioSindacoConfiguration;
import it.eng.allerta.utils.AllertaTracker;
import it.eng.allerte.model.RubricaGruppo;
import it.eng.allerte.service.RubricaCanaleLocalServiceUtil;
import it.eng.allerte.service.RubricaGruppoLocalServiceUtil;
import it.eng.allerter.allerta.FileBean;
import it.eng.allerter.allerta.utils.ChannelSendUtils;
import it.eng.allerter.allerta.utils.FacebookAccount;
import it.eng.allerter.allerta.utils.MailUtils;
import it.eng.allerter.allerta.utils.MessaggioMailUtils;
import it.eng.allerter.allerta.utils.MessaggioService;
import it.eng.allerter.service.SMSLocalServiceUtil;
import it.eng.bollettino.model.BollettinoParametro;
import it.eng.bollettino.service.BollettinoParametroLocalServiceUtil;

public class MessaggioBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7825120311625204973L;
	
	private static final String keyOn = "si";
	
	private int step = 1;
	private String obj_mail;
	private String mex_pc;
	private String subject;
	private Boolean show_pc;
	
	private long companyId;

	// DATI SMISTAMENTO INFORMAZIONI , vengono utilizzati per direzionare i messaggi
	// nei canali social
	private Set<FacebookAccount> credenziali = new HashSet<FacebookAccount>();

	// DATI DEL SINDACO
	private Boolean sindaco;
	private Boolean advancedAdmin = false;
	private Map<Long, String> comuneDelSindaco = new HashMap<>();
	private List<String> selectTownHall = new ArrayList<>();

	// Dati legati all allerta
	/*
	 * Qualora la funzionalita venga richiamata dalla portlet del login allora se la
	 * portlet si trova in una pagina di allerta allora verra' recuperata anche
	 * l'allerta
	 */
	private String idAllerta;
	private String titoloAllerta;

	// UNA VOLTA PRELEVATI I DATI DELL ALLERTA DA URL DEVO SALVARLI IN SESSIONE
	// PERCHE' IL WIZARD NON RIPASSA I DATI NELLA URL
	private String idAllertaSaved;
	private String titoloAllertaSaved;
	private String PATH_ALLERTA = "/web/guest/singola-allerta/-/asset_publisher/FZPQSb6AzKtJ/Allerta-Bollettino/id/";

	
	private String telefono = "no";
	private String sms= "no";
	private String social= "no";
	private String mail= "no";
	private String portale= "no";
	
	
	List<FileBean> uploadedFiles = new ArrayList<>();
	
	private List<String> selectedOrganization = new ArrayList<>();
		
	private List<String> selectBooleanInfo = new ArrayList<>();

	private User user;
	

	
	public MessaggioBean(User user) throws SystemException, PortalException {

		profileUser(user);
		
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public String getObj_mail() {
		return obj_mail;
	}

	public void setObj_mail(String obj_mail) {
		this.obj_mail = obj_mail;
	}

	public String getMex_pc() {
		return mex_pc;
	}

	public void setMex_pc(String mex_pc) {
		this.mex_pc = mex_pc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Boolean getShow_pc() {
		return show_pc;
	}

	public void setShow_pc(Boolean show_pc) {
		this.show_pc = show_pc;
	}

	private void reset() {
		logger.info("RESET BEAN WIZARD MESSAGGIO DEL SINDACO");
		this.idAllerta = null;
		this.titoloAllerta = null;
		this.idAllertaSaved = null;
		this.titoloAllertaSaved = null;
		sindaco = false;
	}
	
	public boolean isAdmin(List<Role> roles) {
		for (Role r : roles) {
			long id = r.getRoleId();
			if (id==20161) return true; //Administrator
			if (id==168321) return true; //Amministratore portale
			if (id==233866) return true; //Amministratore rubrica
		}
		return false;
	}

	/*
	 * profiliamo utente in modo da capire quali sono i dati da utilizzare
	 */
	private void profileUser(User user) throws SystemException, PortalException {

		logger.info("PROFILAZIONE UTENTE ");
		credenziali.clear();
		this.user = user;
		
		companyId= user.getCompanyId();
		
		String sindaco_k = "SINDACO";
		String delegato_k = "DELEGATO SINDACO";
		String guest_k = "guest";
		sindaco = false;
		long site_sindaco_role_id = 29574;
		long site_delegatototale_role_id = 75902;

		// variabili di utility
		Group sitoAttuale;
		Role actual = null;
		String name;

		List<Role> roles = new ArrayList<Role>();
		roles.addAll(user.getRoles());
		Iterator<Role> it = roles.iterator();

		while (it.hasNext()) {
			actual = it.next();
			name = actual.getName();
			
			if (name.equalsIgnoreCase(sindaco_k) || name.equalsIgnoreCase(delegato_k) && !sindaco) {
				sindaco = true;
				List<Group> sitiSindaco = user.getMySiteGroups();
				Iterator<Group> itSite = sitiSindaco.iterator();
				String sname = "";
				while (itSite.hasNext()) {
					sitoAttuale = (Group) itSite.next();
					sname = sitoAttuale.getName();
					
					if (!sname.equalsIgnoreCase(guest_k)) {
						// controllo se per il sito attuale l utente è il sindaco o delegato
						if (UserGroupRoleLocalServiceUtil.hasUserGroupRole(user.getUserId(), sitoAttuale.getGroupId(),
								site_sindaco_role_id)
								|| UserGroupRoleLocalServiceUtil.hasUserGroupRole(user.getUserId(),
										sitoAttuale.getGroupId(), site_delegatototale_role_id)) {
							comuneDelSindaco.put(sitoAttuale.getGroupId(), sname);
						}
					}
				}
			}
		}
		if (comuneDelSindaco.size() > 0 && sindaco) {
			selectTownHall.add(String.valueOf(comuneDelSindaco.entrySet().iterator().next().getKey()));
		}
		if (isAdmin(roles)) {
			advancedAdmin = true;
			logger.info("TROVATO UTENTE SUPER ADMIN ");
		}
	}

	public void getAccount(User user) {
		long principal_group_id = 20181;
		Group group = null;
		try {

			logger.info("I DATI RICEVUTI DAL SITO SONO");
			if (sindaco) {

				for (int i = 0; i < selectTownHall.size(); i++) {
					logger.info("xxx " + selectTownHall);

					logger.info("UTENTE E' SINDACO PER QUESTO COMUNE p " + selectTownHall.get(i));
					try {
						long id = Long.valueOf(selectTownHall.get(i));
						group = GroupLocalServiceUtil.getGroup(id);
						logger.info("group " + group);
					} catch (PortalException | SystemException e) {
						// TODO Auto-generated catch block
						logger.error(e);
					}
					credenziali
							.add(new FacebookAccount((String) group.getExpandoBridge().getAttribute("facebook-page-id"),
									(String) group.getExpandoBridge().getAttribute("facebook-page-pwd"),
									(String) group.getExpandoBridge().getAttribute("facebook-token")));
					logger.info("faceId" + (String) group.getExpandoBridge().getAttribute("facebook-page-id"));
					logger.info("facePass" + (String) group.getExpandoBridge().getAttribute("facebook-page-pwd"));
					logger.info("token" + (String) group.getExpandoBridge().getAttribute("facebook-token"));
				}
			}
		} catch (RuntimeException xx) {
			logger.error(xx);
		}

		if (!sindaco || advancedAdmin) {
			try {
				group = GroupLocalServiceUtil.getGroup(principal_group_id);
				if (group != null) {
					logger.info("TROVATO sitoPadre" + group.getName() + "" + group.getDescription());

					credenziali
							.add(new FacebookAccount((String) group.getExpandoBridge().getAttribute("facebook-page-id"),
									(String) group.getExpandoBridge().getAttribute("facebook-page-pwd"),
									(String) group.getExpandoBridge().getAttribute("facebook-token")));
					logger.info("faceId" + (String) group.getExpandoBridge().getAttribute("facebook-page-id"));
					logger.info("facePass" + (String) group.getExpandoBridge().getAttribute("facebook-page-pwd"));
					logger.info("token" + (String) group.getExpandoBridge().getAttribute("facebook-token"));
				} else {
					logger.info("@@@@ NON TROVATO PORTALE DI WEBALLERTE");
				}
			} catch (PortalException | SystemException e) {
				// // TODO Auto-generated catch block
				logger.error(e);
			}
		}
	}

	/*
	 * DISPATHC MESSAGE
	 */
	public void dispatchMessage(ThemeDisplay themeDisplay) throws AddressException, SystemException, 
		IOException, Exception {
		
		ChannelSendUtils channelSendUtils = AllertaTracker.getService(ChannelSendUtils.class);
		
		if (this.telefono.equalsIgnoreCase(keyOn)) {
			channelSendUtils.sendCall(user);
		}
		
		long[] smsChannel = new long[2];
		smsChannel[0] = 2;
		smsChannel[1] = 3;
		BollettinoParametro bp = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("SMS_FROM_ALLARME");
		String fromSMS = "AllertaER";
		if (bp!=null) fromSMS = bp.getValore();

		if (this.sms.equalsIgnoreCase(keyOn)) {
			
			if (selectTownHall!=null && selectTownHall.size()>0) {
				for (String v : selectTownHall) {
					Group group = null;
					try {
						group = GroupLocalServiceUtil.getGroup(Integer.valueOf(v));
						channelSendUtils.sendSms(group, getSubject(), "comunicazioneSindaco",
								new Date().getTime());
					} catch (NumberFormatException | PortalException e) {
						logger.error(e);
					}
				}
			} 
			if (getSelectedOrganization()!=null && getSelectedOrganization().size()>0) {
				Long time = new Date().getTime();
				for (String o : getSelectedOrganization()) {
					RubricaGruppo rg = RubricaGruppoLocalServiceUtil.fetchRubricaGruppo(Long.parseLong(o));
					if (rg!=null) SMSLocalServiceUtil.creaNotificaGruppoRubrica(smsChannel, fromSMS, getSubject(), "comunicazione", ""+time, 0, 20181, rg.getNOME(), true, null);
					
				}
					//channelSendUtils.sendSmsPrepare(Long.parseLong(o), getSubject(), "comunicazione",
						//	time);
				channelSendUtils.sendSms("comunicazione", time);
			}
		}
		
//		if (this.getSocial().equalsIgnoreCase(keyOn)) {
//			for (FacebookAccount value : credenziali) {
//				channelSendUtils.shareOnFacebook(user, value, this.getObj_mail(),
//						this.getMex_pc(), themeDisplay.getPortalURL());
//			}
//		}

		if (this.getPortale().equalsIgnoreCase(keyOn)) {
			channelSendUtils.sendAlert(user);
		}

		if (this.getMail().equalsIgnoreCase(keyOn)) {
			this.prepareMail(user, themeDisplay);
		}
	}

	/*
	 * INVIO DELLA EMAIL
	 */

	private void prepareMail(User user, ThemeDisplay themeDisplay)
			throws AddressException, SystemException, IOException {

		ChannelSendUtils channelSendUtils = AllertaTracker.getService(ChannelSendUtils.class);
		
		MessaggioSindacoConfiguration sindacoConfiguration = 
				AllertaTracker.getConfiguration(themeDisplay.getCompanyId(), 
						MessaggioSindacoConfiguration.class);
		
		logger.info("SONO NEL SUBMIT DEL MESSAGGIO");
		
		BollettinoParametro bp = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("SMS_FROM_ALLARME");
		String fromSMS = "AllertaER";
		if (bp!=null) fromSMS = bp.getValore();
	
		String oggetto = getObj_mail();
		String messaggio_pc = getMex_pc();

		// DATI PRESI DA INTERFACCIA PER I DIVERSI FENOMENI
		String piene = hasBooleanInfo("piene") ? keyOn : "";
		String frane = hasBooleanInfo("frane") ? keyOn : "";
		String temporali = hasBooleanInfo("temporali") ? keyOn : "";
		String vento = hasBooleanInfo("vento") ? keyOn : "";
		String mareggiate = hasBooleanInfo("mareggiate") ? keyOn : "";;
		String neve = hasBooleanInfo("neve") ? keyOn : "";
		String ghiaccio = hasBooleanInfo("ghiaccio") ? keyOn : "";
		String ondateDiCalore = hasBooleanInfo("ondateDiCalore") ? keyOn : "";
		String incendi = hasBooleanInfo("incendi") ? keyOn : "";
		String terremoto = hasBooleanInfo("terremoto") ? keyOn : "";

		String paginaPieneFiumi = "";
		String paginaFrane = "";
		String paginaTemporali = "";
		String paginaVento = "";
		String paginaMareggiate = "";
		String paginaNeve = "";
		String paginaGhiaccio = "";
		String paginaOndateCalore = "";
		String paginaIncendio = "";
		String paginaTerremoto = "";
		String paginaAllerta = "";

		if (piene.equalsIgnoreCase(keyOn)) {
			logger.info("Voglio aggiungere pagine fiumi ");

			if (Validator.isNotNull(sindacoConfiguration.paginaPieneFiumi())) {
				paginaPieneFiumi = sindacoConfiguration.paginaPieneFiumi();
			}
		}

		if (frane.equalsIgnoreCase(keyOn)) {
			logger.info("Voglio aggiungere pagine delle frane ");

			if (Validator.isNotNull(sindacoConfiguration.paginaFrane())) {
				paginaFrane = sindacoConfiguration.paginaFrane(); 
			}
		}
		
		if (temporali.equalsIgnoreCase(keyOn)) {
			logger.info("Voglio aggiungere  paginaTemporali ");
			
			if (Validator.isNotNull(sindacoConfiguration.paginaTemporali())) {
				paginaTemporali = sindacoConfiguration.paginaTemporali(); 
			}
			
		}

		if (incendi.equalsIgnoreCase(keyOn)) {
			logger.info("Voglio aggiungere  paginaIncendi ");
			if (Validator.isNotNull(sindacoConfiguration.paginaIncendio())) {
				paginaIncendio = sindacoConfiguration.paginaIncendio(); 
			}
			
		}

		if (vento.equalsIgnoreCase(keyOn)) {
			logger.info("Voglio aggiungere  paginaVento");
			if (Validator.isNotNull(sindacoConfiguration.paginaVento())) {
				paginaVento = sindacoConfiguration.paginaVento(); 
			}
			
		}

		if (mareggiate.equalsIgnoreCase(keyOn)) {
			logger.info("Voglio aggiungere  paginaMareggiate");
			if (Validator.isNotNull(sindacoConfiguration.paginaMareggiate())) {
				paginaMareggiate = sindacoConfiguration.paginaMareggiate(); 
			}
			
		}

		if (neve.equalsIgnoreCase(keyOn)) {
			logger.info("Voglio aggiungere  paginaNeve");
			if (Validator.isNotNull(sindacoConfiguration.paginaNeve())) {
				paginaNeve = sindacoConfiguration.paginaNeve(); 
			}
			
			
		}

		if (ghiaccio.equalsIgnoreCase(keyOn)) {
			logger.info("Voglio aggiungere  paginaGhiaccio");
			
			if (Validator.isNotNull(sindacoConfiguration.paginaGhiaccio())) {
				paginaGhiaccio = sindacoConfiguration.paginaGhiaccio(); 
			}
			
		}
		if (ondateDiCalore.equalsIgnoreCase(keyOn)) {
			logger.info("Voglio aggiungere  paginaOndateCalore");
			if (Validator.isNotNull(sindacoConfiguration.paginaOndateCalore())) {
				paginaOndateCalore = sindacoConfiguration.paginaOndateCalore(); 
			}
			
			
		}

		if (terremoto.equalsIgnoreCase(keyOn)) {
			logger.info("Voglio aggiungere  paginaTerremoto");
			if (Validator.isNotNull(sindacoConfiguration.paginaTerremoto())) {
				paginaTerremoto = sindacoConfiguration.paginaTerremoto(); 
			}
			
		}
		logger.info("@@@@@ idAllertaSaved " + idAllertaSaved);

		String portalUrl = themeDisplay.getPortalURL();
		
		if (idAllertaSaved != null && idAllertaSaved.trim().length() > 3) {
			paginaAllerta = portalUrl.concat(this.PATH_ALLERTA).concat(idAllertaSaved);

			logger.info("@@@@@ paginaAllerta " + paginaAllerta);

		} else {
			paginaAllerta = null;
			logger.info("@@@@@ paginaAllerta : non settata ");
		}

		channelSendUtils.printMessageOnConsole(sindaco, messaggio_pc, paginaPieneFiumi, paginaFrane, paginaTemporali,
				paginaVento, paginaNeve, paginaMareggiate, paginaGhiaccio, paginaOndateCalore, paginaIncendio,
				paginaTerremoto, paginaAllerta);
		
		String sottotipo = new Date().getTime() + "";
		
		MessaggioMailUtils messaggioMailUtils = AllertaTracker.getService(MessaggioMailUtils.class);
		
		long[] emailChannel = new long[1];
		emailChannel[0] = 1;
		
		if (selectTownHall!=null && selectTownHall.size()>0) {
			for (String v : selectTownHall) {
				Group group = null;
				try {
					group = GroupLocalServiceUtil.getGroup(Integer.valueOf(v));
				} catch (NumberFormatException | PortalException e) {
					e.printStackTrace();
				}
								
				String body = messaggioMailUtils.prepareMessageBodyMail(sindaco, user, group, messaggio_pc,
						paginaPieneFiumi, paginaFrane, paginaTemporali, paginaVento, paginaNeve, paginaMareggiate,
						paginaGhiaccio, paginaOndateCalore, paginaIncendio, paginaTerremoto, paginaAllerta, 
						themeDisplay.getPortalURL());
				try {
					
					SMSLocalServiceUtil.creaEmailGroup("comunicazioneSindaco", sottotipo, 0, group.getGroupId());
				} catch (Exception e) {
					e.printStackTrace();
				}
				channelSendUtils.sendMail("comunicazioneSindaco", sottotipo, sindaco,
						"Comunicazione da parte del comune di " + group.getName(), body,
						getUploadedFiles());
			}
		}
		if (getSelectedOrganization()!=null && getSelectedOrganization().size()>0) {
		for (String o : getSelectedOrganization()) {
				try {
					RubricaGruppo rg = RubricaGruppoLocalServiceUtil.fetchRubricaGruppo(Long.parseLong(o));
					if (rg!=null) SMSLocalServiceUtil.creaNotificaGruppoRubrica(emailChannel, fromSMS, "", "comunicazione", sottotipo, 0, 20181, rg.getNOME(), true, null);
					//SMSLocalServiceUtil.creaEmailOrganization("comunicazione", sottotipo, 0, Long.parseLong(o));
				} catch (Exception e) {
					logger.error(e);
				}
			}
			channelSendUtils.sendMail("comunicazione", sottotipo, sindaco, oggetto, messaggio_pc,
					getUploadedFiles());
		}
	}



//	public void passoDue(ActionEvent actionEvent) throws PortalException, SystemException {
//
//		logger.info("Gestione Del Secondo  Passo ");
//		FacesContext facesContext = FacesContext.getCurrentInstance();
//		FacesMessage facesMessage = new FacesMessage("The default value of selectedIndex=");
//		facesContext.addMessage(null, facesMessage);
//	}

	// GESTIONE DEL FILE IN UPLOAD

//	public void deleteUploadedFile(ActionEvent actionEvent) {
//
//		UICommand uiCommand = (UICommand) actionEvent.getComponent();
//		String fileId = (String) uiCommand.getValue();
//
//		try {
//			List<UploadedFile> uploadedFiles = bridgeInputFileModelBean.getUploadedFiles();
//
//			UploadedFile uploadedFileToDelete = null;
//
//			for (UploadedFile uploadedFile : uploadedFiles) {
//
//				if (uploadedFile.getId().equals(fileId)) {
//					uploadedFileToDelete = uploadedFile;
//
//					break;
//				}
//			}
//
//			if (uploadedFileToDelete != null) {
//				uploadedFileToDelete.delete();
//				uploadedFiles.remove(uploadedFileToDelete);
//				logger.info("Deleted file=[{0}]", uploadedFileToDelete.getName());
//			}
//		} catch (Exception e) {
//			logger.error(e);
//		}
//	}

//	public void handleFileUpload(FileUploadEvent fileUploadEvent) {
//
//		logger.info("CHIAMATO IL HANDLE FILE UPLOAD");
//
//		List<UploadedFile> uploadedFiles = bridgeInputFileModelBean.getUploadedFiles();
//		UploadedFile uploadedFile = fileUploadEvent.getUploadedFile();
//
//		if (uploadedFile.getStatus() == UploadedFile.Status.FILE_SAVED) {
//
//			FacesContext facesContext = FacesContext.getCurrentInstance();
//			FacesMessage facesMessage = new FacesMessage("Received fileUploadEvent for file named '"
//					+ uploadedFile.getName() + "' in the " + fileUploadEvent.getPhaseId().toString() + " phase.");
//			facesContext.addMessage(null, facesMessage);
//			uploadedFiles.add(uploadedFile);
//			logger.info("Received fileName=[{0}] absolutePath=[{1}]", uploadedFile.getName(),
//					uploadedFile.getAbsolutePath());
//		} else {
//			logger.error("Failed to receive uploaded file due to error status=[{0}] message=[{1}]",
//					uploadedFile.getStatus(), uploadedFile.getMessage());
//		}
//	}

//	public String getIdAllerta() {
//
//		logger.info("PROVO A RECUPERARE ID ALLERTA");
//		String idAllerta = null;
//		LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
//		String url = liferayFacesContext.getThemeDisplay().getURLCurrent();
//		String key = "?alert_is=";
//		try {
//			int position = url.indexOf(key);
//			if (position > 0) {
//				logger.info("Chiave trovata");
//				idAllerta = url.substring(position + (key.length()));
//				// Salvo id allerta solo se non è stata gia salvata
//				// Altrimenti perdo l'id casua passaggi del wizard
//				if (idAllertaSaved == null) {
//					logger.info("Setto lal Chiave trovata" + idAllerta);
//					idAllertaSaved = idAllerta;
//				} else {
//					logger.info("Non setto la chiave all'allerta perchè già presente questa " + idAllertaSaved);
//				}
//			} else {
//				logger.info("Chiave non trovata");
//			}
//		} catch (Exception e) {
//
//		}
//		this.idAllerta = idAllerta;
//
//		return idAllerta;
//	}

//	public String getTitoloAllerta() {
//		String titolo = null;
//		idAllerta = this.getIdAllerta();
//		logger.info("DEBUG ALLERTA ASSOCIATA " + idAllerta);
//		if (idAllerta != null) {
//			logger.info("Cerco di Recuperare allerta con id   " + idAllerta);
//			try {
//				Long alertId = Long.parseLong(idAllerta);
//				boolean assetFind = false;
//				AssetEntry entry = null;
//				Allerta allerta = null;
//				try {
//					entry = AssetEntryLocalServiceUtil.getAssetEntry(alertId);
//					if (entry != null) {
//						assetFind = true;
//						logger.info(">>Trovata Entry ");
//					}
//				} catch (PortalException | SystemException e1) {
//					logger.info(">>Trovata NON  Entry ");
//					logger.error(e1);
//				}
//				if (assetFind) {
//					try {
//						allerta = AllertaLocalServiceUtil.getAllerta(entry.getClassPK());
//						logger.info("Allerta recuperata " + allerta.getTitolo() + " " + allerta.getTipoAllerta());
//						titolo = allerta.getTitolo();
//						this.titoloAllertaSaved = titolo;
//					} catch (PortalException | SystemException e) {
//						logger.info("Allerta non recuperata ");
//					}
//				}
//			} catch (Exception e) {
//				logger.info("Impossibile recuperare allerta con   " + idAllerta);
//			}
//		}
//		return titolo;
//	}


	public final void setTitoloAllerta(String titoloAllerta) {
		this.titoloAllerta = titoloAllerta;
	}

	public final String getIdAllertaSaved() {
		return idAllertaSaved;
	}

	public final void setIdAllertaSaved(String idAllertaSaved) {
		this.idAllertaSaved = idAllertaSaved;
	}

	public final String getTitoloAllertaSaved() {
		return titoloAllertaSaved;
	}

	public final void setTitoloAllertaSaved(String titoloAllertaSaved) {
		this.titoloAllertaSaved = titoloAllertaSaved;
	}

	public Map<Long, String> getComuneDelSindaco() {
		return comuneDelSindaco;
	}

	public void setComuneDelSindaco(Map<Long, String> comuneDelSindaco) {
		this.comuneDelSindaco = comuneDelSindaco;
	}

	public List<String> getSelectTownHall() {
		return selectTownHall;
	}

	public void setSelectTownHall(List<String> selectTownHall) {
		logger.info("Comuni selezionati: " + selectTownHall.toString());
		this.selectTownHall = selectTownHall;
	}

	public String getGroupName(long key) {
		return comuneDelSindaco.get(key);
	}

	public boolean getSindaco() {
		return sindaco;
	}

	public void setSindaco(boolean sindaco) {
		this.sindaco = sindaco;
	}
	
	public List<String> getSelectedOrganization() {
		return selectedOrganization;
	}

	public void setSelectedOrganization(List<String> selectedOrganization) {
		this.selectedOrganization = selectedOrganization;
	}
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getSms() {
		return sms;
	}

	public void setSms(String sms) {
		this.sms = sms;
	}

	public String getSocial() {
		return social;
	}

	public void setSocial(String social) {
		this.social = social;
	}

	public String getPortale() {
		return portale;
	}

	public void setPortale(String portale) {
		this.portale = portale;
	}

	public void setSindaco(Boolean sindaco) {
		this.sindaco = sindaco;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String organizationToStringView() throws PortalException{
		MessaggioService msgService = AllertaTracker.getService(MessaggioService.class);
		MessaggioSindacoConfiguration sindacoConfiguration = 
				AllertaTracker.getConfiguration(companyId, MessaggioSindacoConfiguration.class);
		
		StringBuilder a = new StringBuilder();
		Map<Long, String> organizationIds = msgService.getOrganizations(sindacoConfiguration.organization());
		
		for(String s : selectedOrganization)
		{
			if(a.length() > 0)
				a.append(" - ");
			
			a.append(organizationIds.get(Long.parseLong(s)));
		}

		return a.toString();
	}
	
	public boolean hasOrganization(String key) {
		for (String org :selectedOrganization) {
			if (org.equals(key)) {
				return true;
			}
		}
		
		return false;
	}

	
	public List<FileBean> getUploadedFiles() {
		return uploadedFiles;
	}

	public void setUploadedFiles(List<FileBean> uploadedFiles) {
		this.uploadedFiles = uploadedFiles;
	}
	
	public void addUploadedFiles(FileBean uploadedFile) {
		this.uploadedFiles.add(uploadedFile);
	}
	

	public void deleteUploadedFiles(String hash) {

		Iterator<FileBean> iterator = uploadedFiles.iterator();
		
		while(iterator.hasNext()) {
			FileBean file = iterator.next();
			if (file.getHash().equals(hash)) {
				iterator.remove();
				break;
			}
		}
	}


	public List<String> getSelectBooleanInfo() {
		return selectBooleanInfo;
	}

	public void setSelectBooleanInfo(List<String> selectBooleanInfo) {
		this.selectBooleanInfo = selectBooleanInfo;
	}

	public void addSelectBooleanInfo(String value) {
		this.selectBooleanInfo.add(value);
	}

	public boolean hasBooleanInfo(String key) {
		for (String value :selectBooleanInfo) {
			if (value.equals(key)) {
				return true;
			}
		}
		
		return false;
	}
	
	public String booleanInfoToStringView() {
		StringBuilder a = new StringBuilder();
		for (String value :selectBooleanInfo) {
			if(a.length() > 0)
				a.append(",");
			
			a.append(value);
		}
		
		return a.toString();
	}

	private Log logger = LogFactoryUtil.getLog(MessaggioBean.class);



	public void unsetChannels() {
		setTelefono("");
		setSms("");
		setMail("");
		setSocial("");
		setPortale("");
		
	}


}
