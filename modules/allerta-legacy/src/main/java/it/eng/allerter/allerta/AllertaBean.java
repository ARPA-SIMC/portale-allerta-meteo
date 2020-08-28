package it.eng.allerter.allerta;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.exception.NoSuchWorkflowDefinitionLinkException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.WorkflowInstanceLink;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowStatusManagerUtil;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerta.utils.AllertaTracker;
import it.eng.allerter.model.Allerta;
import it.eng.allerter.model.AllertaParametro;
import it.eng.allerter.model.AllertaStato;
import it.eng.allerter.service.AllertaLocalService;
import it.eng.allerter.service.AllertaLocalServiceUtil;
import it.eng.allerter.service.AllertaParametroLocalServiceUtil;
import it.eng.allerter.service.AllertaStatoLocalServiceUtil;
//import it.eng.allerter.service.//LogInternoLocalServiceUtil;
import it.eng.allerter.service.SMSLocalServiceUtil;

public class AllertaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3538119404903799906L;

	String sintesi = "";
	String descrizioneMeteo = "";
	String note = "";
	String riferimenti = "";
	String tendenza = "1";
	Date dataInizio = new Date();
	Date dataFine = new Date();
	String numero = "";
	String titolo = "";

	long allertaId;
	
	private List<User> listaApprovatoriArpae;
	private String approvatoreArpae = null;
	private List<User> listaApprovatoriPc;
	private String approvatorePc = null;

	public static int MAX_CARATTERI_TITOLO = 117;

	Allerta allertaCorrente;
	int matriceColori[][] = new int[16][16];
	String aree[] = { "A", "B", "C", "D", "E", "F", "G", "H" };
	String eventi[] = { "Criticità idraulica", "Criticità idrogeologica", "Criticità per temporali", "Vento",
			"Temperature estreme", "Neve", "Pioggia che gela", "Stato del mare", "Criticità costiera" };
	String eventiInformali[] = { "piene dei fiumi", "frane e piene dei corsi minori", "temporali", "vento",
			"temperature estreme", "neve", "pioggia che gela", "stato del mare", "mareggiate" };

	List<RigaManager> griglia;
	HttpServletRequest httpRequest;
	
	
	
	private void initRequest() throws Exception {

		if (httpRequest != null) {
			
			sintesi = ParamUtil.getString(httpRequest, "sintesi");
			descrizioneMeteo = ParamUtil.getString(httpRequest, "descrizioneMeteo");
			note = ParamUtil.getString(httpRequest, "note");
			riferimenti = ParamUtil.getString(httpRequest, "riferimenti");
			tendenza = ParamUtil.getString(httpRequest, "tendenza");
			numero = ParamUtil.getString(httpRequest, "numero");
			titolo = ParamUtil.getString(httpRequest, "titolo");
			approvatoreArpae = ParamUtil.getString(httpRequest, "approvatoreArpae");
			approvatorePc = ParamUtil.getString(httpRequest, "approvatorePc");
			dataInizio  = ParamUtil.getDate(httpRequest, "dataInizio", AllertaKeys.WebDateTimeFormat);
			dataFine  = ParamUtil.getDate(httpRequest, "dataFine", AllertaKeys.WebDateTimeFormat);
			allertaId = ParamUtil.getLong(httpRequest, "allertaId");

			griglia=null;
			initGriglia();
	
		}
	}
	
	public AllertaBean(long allertaId, PortletRequest portletRequest) {
		
		this.allertaId = allertaId;
		
		this.httpRequest = PortalUtil.getOriginalServletRequest( 
				PortalUtil.getHttpServletRequest(portletRequest));
		
		initBean();
	
	}

	public AllertaBean(HttpServletRequest request) {
	
		this.httpRequest = request;
		
		initBean();
	
	}
	
	public AllertaBean(long allertaId, HttpServletRequest request) {
		
		this.allertaId = allertaId;
		
		this.httpRequest = request;
		
		initBean();
	
	}
	
	private void initBean() {

		try {
			
			Calendar c = Calendar.getInstance();
			c.set(Calendar.HOUR_OF_DAY, 0);
			c.set(Calendar.MINUTE,0);
			c.set(Calendar.SECOND,0);
			c.set(Calendar.MILLISECOND,0);
			c.add(Calendar.DAY_OF_YEAR, 1);
			dataInizio = c.getTime();
			c.add(Calendar.DAY_OF_YEAR, 1);
			dataFine = c.getTime();

			if (this.allertaId <= 0) {
				this.allertaId = ParamUtil.getLong(httpRequest, "allertaId");
			}
			
			this.allertaCorrente = AllertaLocalServiceUtil.fetchAllerta(this.allertaId);
			
			initGriglia();
				
			caricaAllerta();
			

			if (Validator.isNull(riferimenti)) {
				try {
					AllertaParametro ap = AllertaParametroLocalServiceUtil
						.fetchAllertaParametro("TESTO_RIFERIMENTI");
					if (ap != null)
						riferimenti = ap.getValore();
				} catch (Exception e) {
				}
			
			}
		

		} catch (Exception e) {
			
			_log.error(e);
		}
		
	}
	
	
	private void initGriglia() {
		
		if (griglia != null) {
			return;
		}
		
		griglia = new ArrayList<RigaManager>();
		int riga = 1;
		int colonna = 1;

		for (String area : aree) {
			RigaManager rm = new RigaManager();
			List<GrigliaManager> r = new ArrayList<GrigliaManager>();
			rm.celle = r;
			rm.nomeRiga = area;
			rm.divisa = (!area.equals("F"));
			griglia.add(rm);
			colonna = 1;
			for (String evento : eventi) {

				GrigliaManager gm = new GrigliaManager();
				gm.riga = riga;
				gm.colonna = colonna++;

				gm.area = area;
				gm.nomeEvento = evento;
				gm.idEvento = gm.colonna;

				gm.valori = new ArrayList<CellaManager>();
				CellaManager cm = new CellaManager();
				cm.riga = gm.riga;
				cm.colonna = gm.colonna;
				cm.sottoriga = 1;
				
				int valore = 1000;
				if (this.httpRequest != null) {
					String inputName = "input"+cm.riga+"-"+cm.colonna+"-"+cm.sottoriga;
					valore = ParamUtil.getInteger(httpRequest, inputName, 1000);
				}
						
				cm.valore = valore; //1000;
				// if (gm.colonna<8) cm.valore = 0;
				gm.valori.add(cm);

				if (rm.divisa && gm.colonna >= 4) {
					CellaManager cm2 = new CellaManager();
					cm2.riga = gm.riga;
					cm2.colonna = gm.colonna;
					cm2.sottoriga = 2;
					
					valore = 1000;
					if (this.httpRequest != null) {
						String inputName = "input"+cm2.riga+"-"+cm2.colonna+"-"+cm2.sottoriga;
						valore = ParamUtil.getInteger(httpRequest, inputName, 1000);
					}
					
					cm2.valore = valore; //1000;
					// if (gm.colonna<8 || gm.riga==2 || gm.riga==4) cm2.valore = 0;
					gm.valori.add(cm2);
				}

				r.add(gm);

			}

			riga++;
		}
		
		
	}


	private void caricaAllerta() throws Exception {

		
		if (allertaCorrente != null) {
			
			this.numero = allertaCorrente.getNumero();
			this.titolo = allertaCorrente.getTitolo();
			this.approvatoreArpae = String.valueOf(allertaCorrente.getUtenteFirmaArpaId());
			this.approvatorePc = String.valueOf(allertaCorrente.getUtenteFirmaProtId());
			this.allertaId = allertaCorrente.getAllertaId();
			
			this.dataFine = allertaCorrente.getDataFine();
			this.dataInizio = allertaCorrente.getDataInizio();
			this.sintesi = allertaCorrente.getSintesi();
			this.descrizioneMeteo = allertaCorrente.getDescrizioneMeteo();
			this.note = allertaCorrente.getNote();
			this.riferimenti = allertaCorrente.getRiferimenti();
			this.tendenza = "" + allertaCorrente.getTendenza();

			List<AllertaStato> bb = allertaCorrente.getAllertaStato();

			for (AllertaStato bbb : bb) {

				for (RigaManager rm : griglia) {
					for (GrigliaManager gm : rm.celle) {
						for (CellaManager cm : gm.valori) {
							if (cm.colonna == bbb.getEventoId()
									&& bbb.getAreaId() == (10 * cm.riga + (cm.colonna > 3 ? cm.sottoriga : 0))) {
								cm.stato = bbb;
								cm.valore = (int) bbb.getStatoId();
							}
						}
					}
				}

			}

		}
		
		

	}

	public void setThreadUserPermission() throws Exception {
		
		// fingiamo di essere il creatore dell'allerta
		PrincipalThreadLocal.setName(allertaCorrente.getUserId());
		PermissionChecker pc = PermissionCheckerFactoryUtil
				.create(UserLocalServiceUtil.fetchUser(allertaCorrente.getUserId()));
		PermissionThreadLocal.setPermissionChecker(pc);

	}


	public boolean isAllerta() {

		for (RigaManager rm : griglia) {

			for (GrigliaManager gm : rm.celle) {

				for (CellaManager cm : gm.valori) {

					if (cm.valore != 0 && cm.valore != 1000)
						return true;
				}
			}

		}

		return false;
	}

	public boolean isAllertaIdro() {

		for (RigaManager rm : griglia) {

			for (GrigliaManager gm : rm.celle) {

				for (CellaManager cm : gm.valori) {

					if (gm.colonna < 4 && cm.valore != 0 && cm.valore != 1000)
						return true;
				}
			}

		}

		return false;
	}

	public String[] getListaEventiInformali() {

		int gravita[] = new int[eventi.length];

		for (RigaManager rm : griglia)
			for (GrigliaManager gm : rm.celle)
				for (CellaManager cm : gm.valori) {
					int v = cm.valore;
					int c = cm.colonna;
					if (v != 1000 && v > gravita[c - 1])
						gravita[c - 1] = v;
				}

		int ev = 0;

		for (int k = 0; k < gravita.length; k++)
			if (gravita[k] > 0)
				ev++;

		String fuori[] = new String[ev];

		int index = 0;

		for (int k = 0; k < gravita.length; k++)
			if (gravita[k] == 3)
				fuori[index++] = eventiInformali[k];

		for (int k = 0; k < gravita.length; k++)
			if (gravita[k] == 2)
				fuori[index++] = eventiInformali[k];

		for (int k = 0; k < gravita.length; k++)
			if (gravita[k] == 1)
				fuori[index++] = eventiInformali[k];

		return fuori;

	}

	public void setTitoloDefault()  {
		titolo = getTitoloDefault();
	}
	
	
	public String getTitoloDefault() {

		SimpleDateFormat data = new SimpleDateFormat("dd-MM-yyyy");
		String dt = data.format(dataInizio);

		if (isAllerta()) {

			String out = "Allerta " + /* numero */ getNumeroDefault() + " valida dal " + dt + ": ";

			String[] ev = getListaEventiInformali();
			int lungh = 0;
			for (int k = 0; k < ev.length; k++)
				lungh += ev[k].length();
			lungh += (ev.length - 1) * 2;
			lungh += out.length();

			int quanti = ev.length;

			if (lungh > MAX_CARATTERI_TITOLO && quanti > 3)
				quanti = 3;

			for (int k = 0; k < quanti; k++) {
				out += ev[k];
				if (k < quanti - 1)
					out += ", ";
			}

			if (quanti < ev.length)
				out += " e altri fenomeni.";

			return out;

		} else {
			return "Bollettino di vigilanza " + getNumeroDefault() + " valido dal " + dt + ": nessuna allerta.";
		}

	}

	public void setNumeroDefault() {
		
		numero = getNumeroDefault();
	}
	
	public String getNumeroDefault() {

		Calendar c = Calendar.getInstance();
		c.setTime(dataInizio);
		int anno = c.get(Calendar.YEAR);
		return AllertaLocalServiceUtil.nextIdAllerta(isAllerta(), anno);

	}

	public void salvaSintesi() {

		try {

			if (allertaCorrente == null)
				return;
			
			if (httpRequest!=null)
				sintesi = ParamUtil.getString(httpRequest, "sintesi");
			
			allertaCorrente.setSintesi(sintesi);

			AllertaLocalServiceUtil.updateAllerta(allertaCorrente);

		} catch (Exception e) {
			_log.error(e);
			//LogInternoLocalServiceUtil.log("allertaBean", "salvaSintesi", e, "");

		}
	}

	public void validate() throws Exception {
		if (Validator.isNull(numero)) {
			numero = getNumeroDefault();			
		}
		
		if (Validator.isNull(titolo)) {
			titolo = getTitoloDefault();			
		}
		

		if (Validator.isNull(approvatoreArpae)) {
			approvatoreArpae = ""+getListaApprovatoriArpae().get(0).getUserId();
			//throw new Exception("Inserire l'approvatore Arpae");			
		}
		
		if (Validator.isNull(approvatorePc)) {
			approvatorePc = ""+getListaApprovatoriPc().get(0).getUserId();
			//throw new Exception("Inserire l'approvatore Protezione Civile");			
		}
		

		if (Validator.isNull(sintesi)) {
			sintesi = "";	
		}
		
//		if (Validator.isNull(descrizioneMeteo)) {
//			throw new Exception("Inserire la descrizione dei fenomeni");			
//		}
		
		
	}
	
	public void salvaAllerta() throws Exception {
		
		initRequest();
		
		validate();

		boolean nuovo = false;

		try {
		
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Allerta.class.getName(), httpRequest);
			
			ThemeDisplay themeDisplay = (ThemeDisplay) httpRequest.getAttribute(WebKeys.THEME_DISPLAY);
			

			if (allertaId > 0) {
				allertaCorrente = AllertaLocalServiceUtil.getAllerta(allertaId);				
			}
			
			if (allertaCorrente == null) {

				nuovo = true;

				long inc = CounterLocalServiceUtil.increment(Allerta.class.getName());
				allertaCorrente = AllertaLocalServiceUtil.createAllerta(inc);
				allertaCorrente.setCreateDate(new Date());
				allertaCorrente.setUserId(themeDisplay.getRealUserId());
				allertaCorrente.setGroupId(themeDisplay.getScopeGroupId());
				allertaCorrente.setUserName(themeDisplay.getRealUser().getFullName());
				allertaCorrente.setCompanyId(themeDisplay.getCompanyId());
				allertaCorrente.setStato(WorkflowConstants.STATUS_DRAFT);
				allertaCorrente.setCreatorName(themeDisplay.getRealUser().getFullName());

				createFolder(themeDisplay, "allerta-" + inc, "File per allerta " + inc);

			} 
			
			allertaCorrente.setModifiedDate(new Date());

			allertaCorrente.setDataInizio(this.dataInizio);
			allertaCorrente.setDataFine(this.dataFine);

			allertaCorrente.setUserId(themeDisplay.getRealUserId());
			allertaCorrente.setGroupId(themeDisplay.getScopeGroupId());
			allertaCorrente.setUserName(themeDisplay.getRealUser().getFullName());
			allertaCorrente.setCompanyId(themeDisplay.getCompanyId());

			allertaCorrente.setSintesi(sintesi);
			allertaCorrente.setDescrizioneMeteo(descrizioneMeteo);
			allertaCorrente.setNote(note);
			allertaCorrente.setRiferimenti(riferimenti);

			allertaCorrente.setUtenteFirmaArpaId(Long.parseLong(approvatoreArpae));
			allertaCorrente.setUtenteFirmaProtId(Long.parseLong(approvatorePc));

			if (numero == null || numero.equals(""))
				numero = getNumeroDefault();
			allertaCorrente.setNumero(numero);
			allertaCorrente.setTendenza(Integer.parseInt(tendenza));
			allertaCorrente.setTipoAllerta(isAllerta());
			allertaCorrente.setProgressivo(isAllertaIdro() ? 1 : 0); // usiamo progressivo per questo... brutto ma non
																		// c'è tempo

			if (titolo == null || titolo.equals(""))
				titolo = getTitoloDefault();
			allertaCorrente.setTitolo(titolo);

			AllertaLocalServiceUtil.updateAllerta(allertaCorrente);

			for (AllertaStato as : allertaCorrente.getAllertaStato()) {
				AllertaStatoLocalServiceUtil.deleteAllertaStato(as);
			}
			
			for (RigaManager rm : griglia) {
				for (GrigliaManager gm : rm.celle) {
					for (CellaManager cm : gm.valori) {

						//if (cm.stato == null) {

							long inc = CounterLocalServiceUtil.increment(AllertaStato.class.getName());
							cm.stato = AllertaStatoLocalServiceUtil.createAllertaStato(inc);
							cm.stato.setEventoId(cm.colonna);
							cm.stato.setAreaId(cm.riga * 10 + (cm.colonna > 3 ? cm.sottoriga : 0));
							cm.stato.setCreateDate(new Date());
							cm.stato.setAllertaId(allertaCorrente.getAllertaId());

						//}

						cm.stato.setStatoId(cm.valore);
						AllertaStatoLocalServiceUtil.updateAllertaStato(cm.stato);

					}
				}
			}

			AssetEntryLocalServiceUtil.updateEntry(themeDisplay.getUserId(), allertaCorrente.getGroupId(),
					Allerta.class.getName(), allertaCorrente.getAllertaId(), serviceContext.getAssetCategoryIds(),
					serviceContext.getAssetTagNames());

			if (allertaCorrente.getStato() == WorkflowConstants.STATUS_DRAFT) {
				
				AssetEntry ae = AssetEntryLocalServiceUtil.getEntry(Allerta.class.getName(), allertaCorrente.getAllertaId());
				try {
					ae.setTitle(allertaCorrente.getTitolo());
					ae.setDescription(allertaCorrente.getDescrizioneMeteo());
					if (ae.getCreateDate()==null) ae.setCreateDate(new Date());
					ae.setModifiedDate(new Date());
					ae.setSummary(allertaCorrente.getTitolo());
					AssetEntryLocalServiceUtil.updateAssetEntry(ae);
				} catch (Exception ee) {
					_log.error(ee);
				}
				
				long id = ae
						.getEntryId();
				List<AssetCategory> c = AssetCategoryLocalServiceUtil.getCategories();
				for (AssetCategory ac : c) {
					if (ac.getName().equals("allerta-lavorazione")) {
						AssetCategoryLocalServiceUtil.addAssetEntryAssetCategory(id, ac);
						break;
					}
				}
			}

			if (!nuovo) {
				// cancella i file esistenti
				AllertaLocalServiceUtil.fileDeleteByApp("bollettino", "allerta-" + allertaCorrente.getAllertaId(), serviceContext);
				AllertaLocalServiceUtil.fileDeleteByApp("allerta", "allerta-" + allertaCorrente.getAllertaId(), serviceContext);
				// fileDeleteByApp("bollettino.pdf", "bollettino-"+bollettino.getBollettinoId(),
				// themeDisplay, req2);
			}

			creaReport();
						
			allertaId = allertaCorrente.getAllertaId();

		} catch(Exception e) {
			allertaCorrente =null;
			throw e;
		}

	}
	
	
	public Folder createFolder(ThemeDisplay themeDisplay, String name,
			String description) {
		long repositoryId = themeDisplay.getScopeGroupId();// repository id is same as groupId
		long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID; // or 0

		try {
			AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("ALLERTA_PARENT_FOLDER_ID");
			if (ap != null)
				parentFolderId = Long.parseLong(ap.getValore());
		} catch (Exception e) {
		}

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), httpRequest);
			Folder folder = DLAppServiceUtil.addFolder(repositoryId, parentFolderId, name, description, serviceContext);

			Role guestRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.GUEST);
			ResourcePermissionLocalServiceUtil.setResourcePermissions(themeDisplay.getCompanyId(),
					DLFolder.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
					String.valueOf(folder.getFolderId()), guestRole.getRoleId(), new String[] { "VIEW" });

			AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("ALLERTA_RUOLI_MODIFICA_LINK");
			if (ap != null && ap.getValore() != null && !ap.getValore().equals("")) {
				String[] ruoli = ap.getValore().split(",");
				for (String s : ruoli) {
					long l = Long.parseLong(s);
					ResourcePermissionLocalServiceUtil.setResourcePermissions(serviceContext.getCompanyId(),
							DLFolder.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
							String.valueOf(folder.getFolderId()), l,
							new String[] { "VIEW", "UPDATE", "DELETE", ActionKeys.ADD_DOCUMENT });
				}
			}

			return folder;
		} catch (Exception e1) {
			_log.error(e1);
			//LogInternoLocalServiceUtil.log("allertaBean", "createFolder", e1, "");
			return null;
		}
	}


	public void creaReport() {

		int statiMacroaree[] = new int[8];
		for (int k = 0; k < 8; k++)
			statiMacroaree[k] = -1;
		int riga = 0;
		for (RigaManager rm : griglia) {
			for (int k = 0; k < 3; k++) {
				GrigliaManager gm = rm.celle.get(k);
				int stato = gm.valori.get(0).valore;

				if (stato != 1000 && stato > statiMacroaree[riga])
					statiMacroaree[riga] = stato;

			}
			riga++;
		}

		int statiSottoMacroaree[] = new int[16];
		for (int k = 0; k < 16; k++)
			statiSottoMacroaree[k] = -1;
		riga = 0;
		for (RigaManager rm : griglia) {
			for (int k = 3; k < 9; k++) {
				GrigliaManager gm = rm.celle.get(k);
				int stato = gm.valori.get(0).valore;

				if (stato != 1000 && stato > statiSottoMacroaree[riga * 2])
					statiSottoMacroaree[riga * 2] = stato;

				if (gm.valori.size() > 1 && gm.valori.get(1).valore != 1000
						&& gm.valori.get(1).valore > statiSottoMacroaree[riga * 2 + 1])
					statiSottoMacroaree[riga * 2 + 1] = gm.valori.get(1).valore;

			}
			riga++;
		}

		try {

			BufferedImage macroaree = ImageUtility.makeMappaMacroaree(statiMacroaree, 660, 380);
			File f = FileUtil.createTempFile("png");
			ImageUtility.saveImage(macroaree, f, "PNG");

			macroaree = ImageUtility.makeMappaMacroaree2(statiSottoMacroaree, 660, 380);
			File f2 = FileUtil.createTempFile("png");
			ImageUtility.saveImage(macroaree, f2, "PNG");

			HashMap<String, String> map = new HashMap<String, String>();

			for (int k = 0; k < 3; k++) {
				for (int j = 0; j < aree.length; j++) {
					String r = aree[j];
					String c = "" + (k + 1);
					String paramName = r + "_" + c;
					String val = getStringaStato(griglia.get(j).celle.get(k).valori.get(0).valore);
					map.put(paramName, val);
				}
			}

			for (int k = 3; k < 9; k++) {
				for (int j = 0; j < aree.length; j++) {
					String r = aree[j];
					String c = "" + (k + 1);
					String paramName = r + "1_" + c;
					String val = getStringaStato(griglia.get(j).celle.get(k).valori.get(0).valore);
					map.put(paramName, val);

					if (griglia.get(j).celle.get(k).valori.size() > 1) {
						paramName = r + "2_" + c;
						val = getStringaStato(griglia.get(j).celle.get(k).valori.get(1).valore);
						map.put(paramName, val);
					}
				}
			}
			
			map.put("title",allertaCorrente.getTitolo());
			JasperUtils ju = AllertaTracker.getService(JasperUtils.class); 
			byte[] report = ju.generateReportAllerta(f.getAbsolutePath(), f2.getAbsolutePath(),
					allertaCorrente.getAllertaId(), map);
			System.out.println("REPORT: " + (report != null ? report.length : 0));

			if (report != null && report.length > 0) {
				File f3 = FileUtil.createTempFile(report);

				// FileUtils.writeByteArrayToFile(f2, data);
				String numero = "";
				if (allertaCorrente.getNumero() != null)
					numero = allertaCorrente.getNumero().replace("/", "_");
				String nomeFile = allertaCorrente.isTipoAllerta() ? "allerta" + numero + ".pdf"
						: "bollettino" + numero + ".pdf";
				String tipoFile = allertaCorrente.isTipoAllerta() ? "Allerta" : "Bollettino di vigilanza";

				//if (themeDisplay != null) {
				
					ServiceContext serviceContext;
					if (httpRequest!=null) 
						serviceContext = ServiceContextFactory.getInstance(Allerta.class.getName(), httpRequest);
					else {
						serviceContext = new ServiceContext();
						serviceContext.setUserId(allertaCorrente.getUserId());
						serviceContext.setCompanyId(allertaCorrente.getCompanyId());
						serviceContext.setScopeGroupId(allertaCorrente.getGroupId());
					}
					AllertaLocalServiceUtil.fileUploadByApp(f3, "allerta-" + allertaCorrente.getAllertaId(), nomeFile, tipoFile,
							"application/pdf", serviceContext);
					
					/*Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
					try {
						AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro(AllertaKeys.AllertaParentFolderParamKey);
						if (ap != null)
							parentFolderId = Long.parseLong(ap.getValore());
					} catch (Exception e) {
					}

					try {
						Folder folder = DLAppServiceUtil.getFolder(allertaCorrente.getGroupId(), parentFolderId, nomeFile);
					} catch(Exception e) {
						ThemeDisplay themeDisplay = (ThemeDisplay) httpRequest.getAttribute(WebKeys.THEME_DISPLAY);
						createFolder(themeDisplay, "allerta-" + allertaCorrente.getAllertaId(), "File per allerta " +  allertaCorrente.getAllertaId());
						
						System.out.println("Creata Folder : allerta-" + allertaCorrente.getAllertaId() );
					}*/
					
					String pdfLink = allertaCorrente.getFileLinkRelative("allerta-" + allertaCorrente.getAllertaId(),
							nomeFile);

					allertaCorrente.setLink(pdfLink);
					allertaCorrente.setHash(this.getHash(report));
					AllertaLocalServiceUtil.updateAllerta(allertaCorrente);

					System.out.println("LINK PDF: " + pdfLink);
					
				FileUtil.delete(f3);
			}

			FileUtil.delete(f);
			FileUtil.delete(f2);

		} catch (Exception e) {
			_log.error(e);
			//LogInternoLocalServiceUtil.log("allertaBean", "creaReport", e, "");
			
		}

	}

	public String getStringaStato(int stato) {
		if (stato == 0)
			return "VERDE";
		if (stato == 1)
			return "GIALLO";
		if (stato == 2)
			return "ARANCIONE";
		if (stato == 3)
			return "ROSSO";
		return null;
	}

	public void inviaApprovazione() throws Exception {

		if (allertaId > 0) {
			allertaCorrente = AllertaLocalServiceUtil.getAllerta(allertaId);				
		}
		
		if (allertaCorrente == null)
			return;

		boolean reinvio = allertaCorrente.getStato() == WorkflowConstants.STATUS_DENIED;

		allertaCorrente.setStato(WorkflowConstants.STATUS_PENDING);
		allertaCorrente.setDataFirmaArpa(null);
		allertaCorrente.setDataFirmaProt(null);
		salvaAllerta();
		
		if (reinvio) {
			allertaCorrente.setStato(WorkflowConstants.STATUS_DRAFT);
			AllertaLocalServiceUtil.updateAllerta(allertaCorrente);
		}

		ThemeDisplay themeDisplay = (ThemeDisplay) httpRequest.getAttribute(WebKeys.THEME_DISPLAY);

		preparaUtenteApprovatore();
		preparaUtenteApprovatore2();

		//WorkflowDefinitionLink workflowDefinitionLink = null;

		if (reinvio) {

			try {

				WorkflowInstanceLink link = WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(
						allertaCorrente.getCompanyId(), allertaCorrente.getGroupId(), Allerta.class.getName(),
						allertaCorrente.getAllertaId());

				WorkflowInstance wi = WorkflowInstanceManagerUtil.getWorkflowInstance(allertaCorrente.getCompanyId(),
						link.getWorkflowInstanceId());

				Map<String, Serializable> wfContext = wi.getWorkflowContext();

				WorkflowInstanceManagerUtil.signalWorkflowInstance(allertaCorrente.getCompanyId(),
						themeDisplay.getRealUserId(), wi.getWorkflowInstanceId(), "resubmit", wfContext);

				Map<String, Serializable> workflowContext = new HashMap<String, Serializable>();
				workflowContext.put(WorkflowConstants.CONTEXT_ENTRY_CLASS_NAME, Allerta.class.getName());
				workflowContext.put(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK, allertaCorrente.getAllertaId());
				workflowContext.put(WorkflowConstants.CONTEXT_USER_ID, themeDisplay.getUserId());
				workflowContext.put(WorkflowConstants.CONTEXT_GROUP_ID, themeDisplay.getCompanyGroupId());
				workflowContext.put(WorkflowConstants.CONTEXT_COMPANY_ID, themeDisplay.getCompanyId());
				WorkflowStatusManagerUtil.updateStatus(WorkflowConstants.STATUS_PENDING, workflowContext);

				// String tipo =
				// (allertaCorrente.getTipoAllerta()?"workflowAllerta":"workflowBollettino");
				// String sottotipo=allertaCorrente.getNumero();
				// long l = new Date().getTime();

				// mandaNotifica(allertaCorrente.getUtenteFirmaArpaId(),"Il documento
				// "+allertaCorrente.getNumero()+" è in attesa di approvazione:
				// https://allertameteo.regione.emilia-romagna.it"
				// ,allertaCorrente,tipo,sottotipo,l);

				// String text = "<html><head></head><body>Il documento
				// "+allertaCorrente.getNumero()+" e' in attesa di approvazione su <a
				// href=\"https://allertameteo.regione.emilia-romagna.it\">https://allertameteo.regione.emilia-romagna.it</a></body></html>";
				// String subject = "Il documento "+allertaCorrente.getNumero()+" è in attesa di
				// approvazione";

				// spedisciNotifiche(tipo, sottotipo, l, subject, text, allertaCorrente);

			} catch (Exception ex) {
				_log.error(ex);
				//LogInternoLocalServiceUtil.log("allertaBean", "inviaApprovazione", ex, "");
				

			}

		} else {

			try {
//				workflowDefinitionLink = WorkflowDefinitionLinkLocalServiceUtil
//						.getDefaultWorkflowDefinitionLink(themeDisplay.getCompanyId(), Allerta.class.getName(), 0, 0);

				ServiceContext sc = new ServiceContext();
				sc.setScopeGroupId(themeDisplay.getLayout().getGroupId());
				// start workflow instance to feedback.

				WorkflowHandlerRegistryUtil.startWorkflowInstance(allertaCorrente.getCompanyId(),
						allertaCorrente.getGroupId(), themeDisplay.getUserId(), Allerta.class.getName(),
						allertaCorrente.getPrimaryKey(), allertaCorrente, sc);

			} catch (Exception ex) {
				_log.error(ex);
				//LogInternoLocalServiceUtil.log("allertaBean", "inviaApprovazione", ex, "");

				if (ex instanceof NoSuchWorkflowDefinitionLinkException) {
					SessionMessages.add(httpRequest, "workflow-not-enabled");
				}
				
			}

		}

	}

	public void eliminaAllerta() {
		if (allertaCorrente != null) {
			try {
				long id = AssetEntryLocalServiceUtil.getEntry(Allerta.class.getName(), allertaCorrente.getAllertaId())
						.getEntryId();
				AssetEntryLocalServiceUtil.deleteAssetEntry(id);
				AllertaLocalServiceUtil.deleteAllerta(allertaCorrente);
				allertaCorrente = null;
				//init();
			} catch (Exception e) {
				_log.error(e);
				//LogInternoLocalServiceUtil.log("allertaBean", "eliminaAllerta", e, "");
			
			}
		}
	}

	public void creaAllerta(ActionRequest req) {

		System.out.println("creaAllerta");

		try {

			AllertaLocalService als = AllertaLocalServiceUtil.getService();

			Allerta a = AllertaLocalServiceUtil.createAllerta(0);
			// IndexerRegistryUtil.nullSafeGetIndexer(Allerta.class).reindex(a);

			ThemeDisplay themeDisplay = (ThemeDisplay) req.getAttribute(WebKeys.THEME_DISPLAY);

			a.setDescrizioneMeteo(descrizioneMeteo);
			a.setNote(note);
			a.setRiferimenti(riferimenti);
			a.setStato(WorkflowConstants.STATUS_DRAFT);
			a.setUserId(themeDisplay.getUserId());
			a.setCompanyId(themeDisplay.getCompanyId());
			a.setGroupId(themeDisplay.getScopeGroupId());

			AllertaLocalServiceUtil.updateAllerta(a);

			SessionMessages.add(req, "allerta-submit-success");

		} catch (Exception e) {
			_log.error(e);
			//LogInternoLocalServiceUtil.log("allertaBean", "creaAllerta", e, "");

		}

	}

	public String getDescrizioneMeteo() {
		return descrizioneMeteo;
	}

	public void setDescrizioneMeteo(String descrizioneMeteo) {
		this.descrizioneMeteo = descrizioneMeteo;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getRiferimenti() {
		return riferimenti;
	}

	public void setRiferimenti(String riferimenti) {
		this.riferimenti = riferimenti;
	}

	public String getTendenza() {
		return tendenza;
	}

	public void setTendenza(String tendenza) {
		this.tendenza = tendenza;
	}

	public Allerta getAllertaCorrente() {
		return allertaCorrente;
	}

	public void setAllertaCorrente(Allerta allertaCorrente) {
		this.allertaCorrente = allertaCorrente;
	}

	public int[][] getMatriceColori() {
		return matriceColori;
	}

	public void setMatriceColori(int[][] matriceColori) {
		this.matriceColori = matriceColori;
	}

	public String[] getAree() {
		return aree;
	}

	public void setAree(String[] aree) {
		this.aree = aree;
	}

	public String[] getEventi() {
		return eventi;
	}

	public void setEventi(String[] eventi) {
		this.eventi = eventi;
	}

	public List<RigaManager> getGriglia() {
		return griglia;
	}

	public void setGriglia(List<RigaManager> griglia) {
		this.griglia = griglia;
	}

	public String getDataInizioString() {

		return AllertaKeys.WebDateTimeFormat.format(dataInizio);
		
	}
	
	public String getDataFineString() {
		
		return AllertaKeys.WebDateTimeFormat.format(dataFine);
		
	}
	
	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public boolean getMostraInviaApprovazione() {
		return allertaCorrente != null && (allertaCorrente.getStato() == WorkflowConstants.STATUS_DRAFT
				|| allertaCorrente.getStato() == WorkflowConstants.STATUS_DENIED);
	}

	public boolean getMostraSalva() {
		return allertaCorrente == null || (allertaCorrente.getStato() == WorkflowConstants.STATUS_DRAFT
				|| allertaCorrente.getStato() == WorkflowConstants.STATUS_DENIED);
	}
	
	public boolean testCanApprove() {
		
		return true;
		
	}

	
	

	public String getSintesi() {
		return sintesi;
	}

	public void setSintesi(String sintesi) {
		this.sintesi = sintesi;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public String getUrl() {
		if (allertaCorrente != null) {
			return allertaCorrente.getUrl();
		}
		
		return null;
	}
	
	public void preparaUtenteApprovatore() {

		try {

			String id = "Approvatore_Arpae";

			AllertaParametro bp = AllertaParametroLocalServiceUtil
					.fetchAllertaParametro("RUOLO_VERI_APPROVATORI_ARPAE");
			if (bp != null)
				id = bp.getValore();

			String id2 = "Approvatore_Arpae";

			AllertaParametro bp2 = AllertaParametroLocalServiceUtil
					.fetchAllertaParametro("RUOLO_POTENZIALI_APPROVATORI_ARPAE");
			if (bp2 != null)
				id2 = bp2.getValore();

			if (id.equals(id2))
				return;

			ThemeDisplay themeDisplay = (ThemeDisplay) httpRequest.getAttribute(WebKeys.THEME_DISPLAY);

			Role r = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), id);

			List<User> utenti = UserLocalServiceUtil.getRoleUsers(r.getRoleId());

			// svuotiamo questo ruolo e mettiamo solo l'utente selezionato

			for (User u : utenti) {
				RoleLocalServiceUtil.deleteUserRole(u.getUserId(), r.getRoleId());
			}

			RoleLocalServiceUtil.addUserRole(Long.parseLong(approvatoreArpae), r.getRoleId());

		} catch (Exception e) {
			_log.error(e);
			//LogInternoLocalServiceUtil.log("allertaBean", "preparaUtenteApprovatore", e, "");
		}
	}

	public void preparaUtenteApprovatore2() {

		try {

			String id = "Approvatore_Pc";

			AllertaParametro bp = AllertaParametroLocalServiceUtil.fetchAllertaParametro("RUOLO_VERI_APPROVATORI_PC");
			if (bp != null)
				id = bp.getValore();

			String id2 = "Approvatore_Pc";

			AllertaParametro bp2 = AllertaParametroLocalServiceUtil
					.fetchAllertaParametro("RUOLO_POTENZIALI_APPROVATORI_PC");
			if (bp2 != null)
				id2 = bp2.getValore();

			if (id.equals(id2))
				return;

			ThemeDisplay themeDisplay = (ThemeDisplay) httpRequest.getAttribute(WebKeys.THEME_DISPLAY);

			Role r = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), id);

			List<User> utenti = UserLocalServiceUtil.getRoleUsers(r.getRoleId());

			// svuotiamo questo ruolo e mettiamo solo l'utente selezionato

			for (User u : utenti) {
				RoleLocalServiceUtil.deleteUserRole(u.getUserId(), r.getRoleId());
			}

			RoleLocalServiceUtil.addUserRole(Long.parseLong(approvatorePc), r.getRoleId());

		} catch (Exception e) {
			_log.error(e);
			//LogInternoLocalServiceUtil.log("allertaBean", "preparaUtenteApprovatore2", e, "");
			
		}
	}
	
	private long getAllertaCompanyId() throws PortalException {
		
		if (allertaCorrente != null) {
			return allertaCorrente.getCompanyId();
		}
		
		if (this.httpRequest != null) {
			ThemeDisplay themeDisplay = (ThemeDisplay) httpRequest.getAttribute(WebKeys.THEME_DISPLAY);
			return themeDisplay.getCompanyId();
		}
		
		throw new PortalException("No Company Id");
	}

	public List<User> getListaApprovatoriArpae() {

		if (listaApprovatoriArpae == null) {

			try {

				String id = "Approvatore_Arpae";

				AllertaParametro bp = AllertaParametroLocalServiceUtil
						.fetchAllertaParametro("RUOLO_POTENZIALI_APPROVATORI_ARPAE");
				if (bp != null)
					id = bp.getValore();

				Role r = RoleLocalServiceUtil.getRole(getAllertaCompanyId(), id);

				List<User> utenti = UserLocalServiceUtil.getRoleUsers(r.getRoleId());

				listaApprovatoriArpae = new ArrayList<User>();

				for (User u : utenti) {
					listaApprovatoriArpae
							.add(u);
					if (approvatoreArpae == null)
						approvatoreArpae = "" + u.getUserId();
				}

			} catch (Exception e) {
				_log.error(e);
				//LogInternoLocalServiceUtil.log("allertaBean", "getListaApprovatoriArpae", e, "");
				
			}

		}

		return listaApprovatoriArpae;
	}

	public void setListaApprovatoriArpae(List<User> listaApprovatoriArpae) {
		this.listaApprovatoriArpae = listaApprovatoriArpae;
	}

	public String getApprovatoreArpae() {
		return approvatoreArpae;
	}

	public void setApprovatoreArpae(String approvatoreArpae) {
		this.approvatoreArpae = approvatoreArpae;
	}

	public List<User> getListaApprovatoriPc() {

		if (listaApprovatoriPc == null) {

			try {

				String id = "Approvatore_Pc";

				AllertaParametro bp = AllertaParametroLocalServiceUtil
						.fetchAllertaParametro("RUOLO_POTENZIALI_APPROVATORI_PC");
				if (bp != null)
					id = bp.getValore();

				Role r = RoleLocalServiceUtil.getRole(getAllertaCompanyId(), id);

				List<User> utenti = UserLocalServiceUtil.getRoleUsers(r.getRoleId());

				listaApprovatoriPc = new ArrayList<User>();

				for (User u : utenti) {
					listaApprovatoriPc
							.add(u);
					if (approvatorePc == null)
						approvatorePc = "" + u.getUserId();
				}

			} catch (Exception e) {
				_log.error(e);
				//LogInternoLocalServiceUtil.log("allertaBean", "getListaApprovatoriPC", e, "");
				
			}
		}

		return listaApprovatoriPc;
	}

	public void setListaApprovatoriPc(List<User> listaApprovatoriPc) {
		this.listaApprovatoriPc = listaApprovatoriPc;
	}

	public String getApprovatorePc() {
		return approvatorePc;
	}

	public void setApprovatorePc(String approvatorePc) {
		this.approvatorePc = approvatorePc;
	}


	public void mandaNotifica(long idUtente, String testo, Allerta a, String tipo, String sottotipo, long l) {
		try {
			User u = UserLocalServiceUtil.fetchUser(idUtente);
			if (u == null)
				return;
			SMSLocalServiceUtil.creaSMS("AllerteER", testo, tipo, sottotipo, l, u);
			// SMSLocalServiceUtil.inviaSMS("workflow", "allerta", l);
			// SMSLocalServiceUtil.inviaEmail("workflow", "allerta", l, subject, testo,
			// "no-reply@allertameteoer.it");
		} catch (Exception e) {
			_log.error(e);
			//LogInternoLocalServiceUtil.log("AllertaWorkflow", "mandaNotifica", e, "");
		}
	}

	
	

//HTTP POST request
	private boolean recaptcha(String url, String captchaSecret, String rispostaUtente) throws Exception {

		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-type", "application/x-www-form-urlencoded");

		String urlParameters = "secret=" + captchaSecret + "&response=" + rispostaUtente;

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		// System.out.println("\nSending 'POST' request to URL : " + url);
		// System.out.println("Post parameters : " + urlParameters);
		// System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// se per qualche ragione fallisce non possiamo impedire la registrazione... per
		// questo se null va bene
		return (response == null || response.toString().toLowerCase().contains("true"));

	}

//	public void submit() {
//
//		String testoRecaptcha = ParamUtil.getString(httpRequest, "recaptcha_response_field");
//		if (testoRecaptcha != null) {
//			try {
//				boolean b = recaptcha("https://www.google.com/recaptcha/api/siteverify",
//						"6Ldi5B0UAAAAAF_0PD92jjXj9kASlOGJSQZqlXDE", testoRecaptcha);
//				if (!b) {
//					SessionMessages.add(httpRequest, "fical-code-exception");
//					return;
//				}
//			} catch (Exception e) {
//			}
//		}
//
//	}

	public String getHash(byte[] b) {
		if (b == null || b.length == 0)
			return "";
		StringBuffer hexString = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(b, 0, b.length);

			byte[] mdbytes = md.digest();

			// convert the byte to hex format method 1
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < mdbytes.length; i++) {
				sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
			}

			System.out.println("Hex format : " + sb.toString());

			// convert the byte to hex format method 2
			hexString = new StringBuffer();
			for (int i = 0; i < mdbytes.length; i++) {
				hexString.append(Integer.toHexString(0xFF & mdbytes[i]));
			}

			System.out.println("Hex format : " + hexString.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		return hexString.toString();

	}

	
	
	public long getAllertaId() {
		return allertaId;
	}

	public void setAllertaId(long allertaId) throws Exception {
		this.allertaId = allertaId;
	}

	
//	public void approve() throws WorkflowException {
//		
//		ThemeDisplay themeDisplay = (ThemeDisplay) httpRequest.getAttribute(WebKeys.THEME_DISPLAY);
//		
//		Map<String, Serializable> workflowContext = new HashMap<String, Serializable>();
//		workflowContext.put(WorkflowConstants.CONTEXT_ENTRY_CLASS_NAME, Allerta.class.getName());
//		workflowContext.put(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK, allertaCorrente.getAllertaId());
//		workflowContext.put(WorkflowConstants.CONTEXT_USER_ID, themeDisplay.getUserId());
//		workflowContext.put(WorkflowConstants.CONTEXT_GROUP_ID, themeDisplay.getCompanyGroupId());
//		workflowContext.put(WorkflowConstants.CONTEXT_COMPANY_ID, themeDisplay.getCompanyId());
//		WorkflowStatusManagerUtil.updateStatus(WorkflowConstants.STATUS_APPROVED, workflowContext);
//	}


	private Log _log = LogFactoryUtil.getLog(AllertaBean.class);
}
