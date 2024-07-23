package it.eng.allerter.allerta;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
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
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowStatusManagerUtil;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerta.utils.AllertaTracker;
import it.eng.allerter.model.AllertaParametro;
import it.eng.allerter.model.AllertaValanghe;
import it.eng.allerter.model.AllertaValangheStato;
import it.eng.allerter.service.AllertaParametroLocalServiceUtil;
import it.eng.allerter.service.AllertaValangheLocalServiceUtil;
import it.eng.allerter.service.AllertaValangheStatoLocalServiceUtil;
import it.eng.allerter.service.SMSLocalServiceUtil;

public class AllertaValangheBean implements Serializable {

	private static final long serialVersionUID = 3538119404903799906L;
	
	public static int MAX_CARATTERI_TITOLO = 117;
	
	int matriceColori[][] = new int[16][16];
	String aree[] = {"Appennino Emiliano Occidentale", "Appennino Emiliano Centrale", "Appennino Romagnolo"};
	String eventi[] = {"Criticit&agrave; valanghe"};
	String eventiInformali[] = {"valanghe"};

	long allertaValangheId;
	
	String descrizioneFenomeni = "";
	String note = "";
	String riferimenti = "";
	
	Date dataInizio = new Date();
	Date dataFine = new Date();
	
	String numero = "";
	String titolo = "";	
	String sintesi = "";
	
	private List<User> listaApprovatoriArpae;
	private String approvatoreArpae = null;
	private List<User> listaApprovatoriPc;
	private String approvatorePc = null;	

	AllertaValanghe allertaValangheCorrente;
	List<RigaValangheManager> griglia;
	List<RigaValangheManager> grigliaOggi;
	
	HttpServletRequest httpRequest;	
	
	boolean dueGiorni = false;
	
	public AllertaValangheBean(long allertaValangheId, PortletRequest portletRequest) {		
		this.allertaValangheId = allertaValangheId;		
		this.httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(portletRequest));
		
		initBean();	
	}

	public AllertaValangheBean(HttpServletRequest request) {	
		this.httpRequest = request;
		
		initBean();	
	}
	
	public AllertaValangheBean(long allertaValangheId, HttpServletRequest request) {		
		this.allertaValangheId = allertaValangheId;		
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

			if (this.allertaValangheId <= 0) {
				this.allertaValangheId = ParamUtil.getLong(httpRequest, "allertaValangheId");
			}			
			this.allertaValangheCorrente = AllertaValangheLocalServiceUtil.fetchAllertaValanghe(this.allertaValangheId);
			
			initGriglia();				
			caricaAllertaValanghe();			

			if (Validator.isNull(riferimenti)) {
				try {
					AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("TESTO_RIFERIMENTI_VALANGHE");
					
					if (ap != null) {
						riferimenti = ap.getValore();
					}
				} catch (Exception e) {
				}			
			}
			if (Validator.isNull(descrizioneFenomeni)) {
				try {
					AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("TESTO_FENOMENI_VALANGHE");
					
					if (ap != null) {
						descrizioneFenomeni = ap.getValore();
					}
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
		griglia = new ArrayList<RigaValangheManager>(aree.length);
		grigliaOggi = new ArrayList<RigaValangheManager>(aree.length);
		
		int riga = 1;

		for (String area : aree) {			
			List<GrigliaValangheManager> r = new ArrayList<GrigliaValangheManager>(eventi.length);
			RigaValangheManager rm = new RigaValangheManager();
			
			griglia.add(rm);			
			rm.celle = r;
			rm.nomeRiga = area;
			rm.divisa = false;			
			
			int colonna = 1;
			
			for (String evento : eventi) {
				GrigliaValangheManager gm = new GrigliaValangheManager();
				gm.valori = new ArrayList<CellaValangheManager>(eventi.length);
				gm.riga = riga;
				gm.colonna = colonna++;
				gm.area = area;
				gm.idEvento = gm.colonna;
				gm.nomeEvento = evento;				
				
				CellaValangheManager cm = new CellaValangheManager();				
				cm.riga = gm.riga;
				cm.colonna = gm.colonna;
				cm.sottoriga = 1; // nel nostro caso è solo 1 (la lascio per eventuali usi futuri)
				
				int valore = 1000;
				
				if (this.httpRequest != null) {
					String inputName = "input"+cm.riga+"-"+cm.colonna+"-"+cm.sottoriga;
					valore = ParamUtil.getInteger(httpRequest, inputName, 1000);
				}
						
				cm.valore = valore; //1000;
				// if (gm.colonna<8) cm.valore = 0;
				gm.valori.add(cm);

				// nel nostro caso non sarà mai true ma lo lascio in caso di modifiche
				if (rm.divisa && gm.colonna >= 4) {
					CellaValangheManager cm2 = new CellaValangheManager();
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
		
		riga = 1;
		
		for (String area : aree) {			
			List<GrigliaValangheManager> r = new ArrayList<GrigliaValangheManager>(eventi.length);
			RigaValangheManager rm = new RigaValangheManager();
			
			grigliaOggi.add(rm);			
			rm.celle = r;
			rm.nomeRiga = area;
			rm.divisa = false;			
			
			int colonna = 1;
			
			if (this.httpRequest != null) {
				dueGiorni = ParamUtil.getBoolean(httpRequest, "duegriglie", false);
			}
			
			for (String evento : eventi) {
				GrigliaValangheManager gm = new GrigliaValangheManager();
				gm.valori = new ArrayList<CellaValangheManager>(eventi.length);
				gm.riga = riga;
				gm.colonna = colonna++;
				gm.area = area;
				gm.idEvento = gm.colonna;
				gm.nomeEvento = evento;				
				
				CellaValangheManager cm = new CellaValangheManager();				
				cm.riga = gm.riga;
				cm.colonna = gm.colonna;
				cm.sottoriga = 1; // nel nostro caso è solo 1 (la lascio per eventuali usi futuri)
				
				int valore = 1000;
				
				if (this.httpRequest != null) {
					String inputName = "inputOggi"+cm.riga+"-"+cm.colonna+"-"+cm.sottoriga;
					valore = ParamUtil.getInteger(httpRequest, inputName, 1000);
				}
						
				cm.valore = valore; //1000;
				// if (gm.colonna<8) cm.valore = 0;
				gm.valori.add(cm);

				// nel nostro caso non sarà mai true ma lo lascio in caso di modifiche
				if (rm.divisa && gm.colonna >= 4) {
					CellaValangheManager cm2 = new CellaValangheManager();
					cm2.riga = gm.riga;
					cm2.colonna = gm.colonna;
					cm2.sottoriga = 2;					
					valore = 1000;
					
					if (this.httpRequest != null) {
						String inputName = "inputOggi"+cm2.riga+"-"+cm2.colonna+"-"+cm2.sottoriga;
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

	public void setThreadUserPermission() throws Exception {		
		// fingiamo di essere il creatore dell'allerta
		PrincipalThreadLocal.setName(allertaValangheCorrente.getUserId());
		PermissionChecker pc = PermissionCheckerFactoryUtil.create(UserLocalServiceUtil.fetchUser(allertaValangheCorrente.getUserId()));
		PermissionThreadLocal.setPermissionChecker(pc);
	}

	public boolean isAllertaValanghe() {
		for (RigaValangheManager rm : griglia) {
			for (GrigliaValangheManager gm : rm.celle) {
				for (CellaValangheManager cm : gm.valori) {
					if (cm.valore != 0 && cm.valore != 1000)
						return true;
				}
			}
		}
		
		if (isDueGiorni()) {
			for (RigaValangheManager rm : grigliaOggi) {
				for (GrigliaValangheManager gm : rm.celle) {
					for (CellaValangheManager cm : gm.valori) {
						if (cm.valore != 0 && cm.valore != 1000)
							return true;
					}
				}
			}
		}

		return false;
	}

	public String[] getListaEventiInformali() {
		int gravita[] = new int[eventi.length];

		for (RigaValangheManager rm : griglia) {
			for (GrigliaValangheManager gm : rm.celle) {
				for (CellaValangheManager cm : gm.valori) {
					int v = cm.valore;
					int c = cm.colonna;
					
					if (v != 1000 && v > gravita[c - 1])
						gravita[c - 1] = v;
				}
			}
		}

		if (isDueGiorni()) {
			for (RigaValangheManager rm : grigliaOggi) {
				for (GrigliaValangheManager gm : rm.celle) {
					for (CellaValangheManager cm : gm.valori) {
						int v = cm.valore;
						int c = cm.colonna;
						
						if (v != 1000 && v > gravita[c - 1])
							gravita[c - 1] = v;
					}
				}
			}
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

	public void setTitoloDefault(int eventi[])  {
		titolo = getTitoloDefault(eventi);
	}
	
	
	public String getTitoloDefault(int eventi[]) {
		SimpleDateFormat data = new SimpleDateFormat("dd-MM-yyyy");
		String dt = data.format(dataInizio);

		if (eventi[0]>0) {
			String out = "Allerta valanghe " + /* numero */ getNumeroDefault(eventi) + " valida dalle HH:mm del DD/MM/YYYY ";
			String[] ev = getListaEventiInformali();
			int lungh = 0;
			
			for (int k = 0; k < ev.length; k++)
				lungh += ev[k].length();
			
			lungh += (ev.length - 1) * 2;
			lungh += out.length();

			int quanti = ev.length;

			if (lungh > MAX_CARATTERI_TITOLO && quanti > 3)
				quanti = 3;

			return out;

		} else {
			return "Bollettino valanghe " + getNumeroDefault(eventi) + " valido dalle HH:mm del DD/MM/YYYY ";
		}
	}

	public void setNumeroDefault(int eventi[]) {		
		numero = getNumeroDefault(eventi);
	}
	
	public String getNumeroDefault(int eventi[]) {
		Calendar c = Calendar.getInstance();
		c.setTime(dataInizio);
		int anno = c.get(Calendar.YEAR);
		
		return AllertaValangheLocalServiceUtil.nextIdAllertaValanghe(eventi[0]>0, anno);
	}

	public void validate() throws Exception {
		if (Validator.isNull(numero)) {
			try {
				int eventi[] = new int[1];
				for (RigaValangheManager rm : griglia)
					for (GrigliaValangheManager gm : rm.celle)
						for (CellaValangheManager cm : gm.valori) {
							int v = cm.valore;
							int c = cm.colonna;
							if (v != 1000 && v > eventi[c - 1])
								eventi[c - 1] = v;
	
						}
				if (isDueGiorni()) {
					for (RigaValangheManager rm : grigliaOggi)
						for (GrigliaValangheManager gm : rm.celle)
							for (CellaValangheManager cm : gm.valori) {
								int v = cm.valore;
								int c = cm.colonna;
								if (v != 1000 && v > eventi[c - 1])
									eventi[c - 1] = v;
		
							}
				}
				numero = getNumeroDefault(eventi);	
			} catch (Exception e) {
				numero = "";
			}
		}		
		if (Validator.isNull(titolo)) {
			try {
				int eventi[] = new int[1];
				for (RigaValangheManager rm : griglia)
					for (GrigliaValangheManager gm : rm.celle)
						for (CellaValangheManager cm : gm.valori) {
							int v = cm.valore;
							int c = cm.colonna;
							if (v != 1000 && v > eventi[c - 1])
								eventi[c - 1] = v;
	
						}
				if (isDueGiorni()) {
					for (RigaValangheManager rm : grigliaOggi)
						for (GrigliaValangheManager gm : rm.celle)
							for (CellaValangheManager cm : gm.valori) {
								int v = cm.valore;
								int c = cm.colonna;
								if (v != 1000 && v > eventi[c - 1])
									eventi[c - 1] = v;
		
							}
				}
				titolo = getTitoloDefault(eventi);	
				titolo = titolo.replace("HH:mm", new SimpleDateFormat("HH:mm").format(dataInizio));
				titolo = titolo.replace("DD/MM/YYYY", new SimpleDateFormat("dd-MM-yyyy").format(dataInizio));
			} catch (Exception e) {
				titolo = "";
				
			}
		}
		if (Validator.isNull(approvatoreArpae)) {
			approvatoreArpae = ""+getListaApprovatoriArpae().get(0).getUserId();
			//throw new Exception("Inserire l'approvatore Arpae");			
		}		
		if (Validator.isNull(approvatorePc)) {
			approvatorePc = ""+getListaApprovatoriPc().get(0).getUserId();
			//throw new Exception("Inserire l'approvatore Protezione Civile");			
		}		
//		if (Validator.isNull(descrizioneMeteo)) {
//			throw new Exception("Inserire la descrizione dei fenomeni");			
//		}		
	}
	
	public void salvaAllertaValanghe() throws Exception {		
		initRequest();		
		validate();

		boolean nuovo = false;

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) httpRequest.getAttribute(WebKeys.THEME_DISPLAY);	
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(AllertaValanghe.class.getName(), httpRequest);				

			if (allertaValangheId > 0) {
				allertaValangheCorrente = AllertaValangheLocalServiceUtil.getAllertaValanghe(allertaValangheId);				
				if (allertaValangheCorrente!=null && allertaValangheCorrente.getStato()==0) return;
				if (allertaValangheCorrente!=null && allertaValangheCorrente.getStato()==1) return;
				if (allertaValangheCorrente!=null && allertaValangheCorrente.getStato()==1000) return;
			}
			
			if (allertaValangheCorrente == null) {
				nuovo = true;

				long inc = CounterLocalServiceUtil.increment(AllertaValanghe.class.getName());
				allertaValangheCorrente = AllertaValangheLocalServiceUtil.createAllertaValanghe(inc);
				
				allertaValangheCorrente.setCreateDate(new Date());
				allertaValangheCorrente.setUserId(themeDisplay.getRealUserId());
				allertaValangheCorrente.setGroupId(themeDisplay.getScopeGroupId());
				allertaValangheCorrente.setUserName(themeDisplay.getRealUser().getFullName());
				allertaValangheCorrente.setCompanyId(themeDisplay.getCompanyId());
				allertaValangheCorrente.setStato(WorkflowConstants.STATUS_DRAFT);
				allertaValangheCorrente.setCreatorName(themeDisplay.getRealUser().getFullName());

				createFolder(themeDisplay, "allerta-valanghe-" + inc, "File per documento valanghe " + inc);
			} 
			
			allertaValangheCorrente.setModifiedDate(new Date());

			allertaValangheCorrente.setDataInizio(this.dataInizio);
			allertaValangheCorrente.setDataFine(this.dataFine);

			allertaValangheCorrente.setUserId(themeDisplay.getRealUserId());
			allertaValangheCorrente.setGroupId(themeDisplay.getScopeGroupId());
			allertaValangheCorrente.setUserName(themeDisplay.getRealUser().getFullName());
			allertaValangheCorrente.setCompanyId(themeDisplay.getCompanyId());

			allertaValangheCorrente.setDescrizioneFenomeni(descrizioneFenomeni);
			allertaValangheCorrente.setNote(note);
			allertaValangheCorrente.setRiferimenti(riferimenti);
			allertaValangheCorrente.setSintesi(sintesi);

			allertaValangheCorrente.setUtenteFirmaArpaId(Long.parseLong(approvatoreArpae));
			allertaValangheCorrente.setUtenteFirmaProtId(Long.parseLong(approvatorePc));

			allertaValangheCorrente.setNumero(numero);
			allertaValangheCorrente.setTipoAllerta(isAllertaValanghe());

			
			allertaValangheCorrente.setTitolo(titolo);
			
			allertaValangheCorrente.setParentId(isDueGiorni()?1:0);

			AllertaValangheLocalServiceUtil.updateAllertaValanghe(allertaValangheCorrente);

			for (AllertaValangheStato as : allertaValangheCorrente.getAllertaValangheStato()) {
				AllertaValangheStatoLocalServiceUtil.deleteAllertaValangheStato(as);
			}
			
			for (RigaValangheManager rm : griglia) {
				for (GrigliaValangheManager gm : rm.celle) {
					for (CellaValangheManager cm : gm.valori) {
						//if (cm.stato == null) {
						long inc = CounterLocalServiceUtil.increment(AllertaValangheStato.class.getName());
						
						cm.stato = AllertaValangheStatoLocalServiceUtil.createAllertaValangheStato(inc);
						cm.stato.setEventoId(cm.colonna);
						cm.stato.setAreaId(cm.riga * 10 + (cm.colonna > 3 ? cm.sottoriga : 0));
						cm.stato.setCreateDate(new Date());
						cm.stato.setAllertaValangheId(allertaValangheCorrente.getAllertaValangheId());						
						//}
						cm.stato.setStatoId(cm.valore);
						
						AllertaValangheStatoLocalServiceUtil.updateAllertaValangheStato(cm.stato);
					}
				}
			}
			
			if (isDueGiorni()) {
				for (RigaValangheManager rm : grigliaOggi) {
					for (GrigliaValangheManager gm : rm.celle) {
						for (CellaValangheManager cm : gm.valori) {
							//if (cm.stato == null) {
							long inc = CounterLocalServiceUtil.increment(AllertaValangheStato.class.getName());
							
							cm.stato = AllertaValangheStatoLocalServiceUtil.createAllertaValangheStato(inc);
							cm.stato.setEventoId(cm.colonna);
							cm.stato.setAreaId(-(cm.riga * 10 + (cm.colonna > 3 ? cm.sottoriga : 0)));
							cm.stato.setCreateDate(new Date());
							cm.stato.setAllertaValangheId(allertaValangheCorrente.getAllertaValangheId());						
							//}
							cm.stato.setStatoId(cm.valore);
							
							AllertaValangheStatoLocalServiceUtil.updateAllertaValangheStato(cm.stato);
						}
					}
				}
			}

			AssetEntryLocalServiceUtil.updateEntry(
				themeDisplay.getUserId(), allertaValangheCorrente.getGroupId(),
				AllertaValanghe.class.getName(), allertaValangheCorrente.getAllertaValangheId(), 
				serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames()
			);

			if (allertaValangheCorrente.getStato() == WorkflowConstants.STATUS_DRAFT) {				
				AssetEntry ae = AssetEntryLocalServiceUtil.getEntry(AllertaValanghe.class.getName(), allertaValangheCorrente.getAllertaValangheId());
				
				try {
					ae.setTitle(allertaValangheCorrente.getTitolo());
					ae.setDescription(allertaValangheCorrente.getDescrizioneFenomeni());
					
					if (ae.getCreateDate()==null) ae.setCreateDate(new Date());
						ae.setModifiedDate(new Date());
						
					ae.setSummary(allertaValangheCorrente.getTitolo());					
					AssetEntryLocalServiceUtil.updateAssetEntry(ae);
				} catch (Exception ee) {
					_log.error(ee);
				}
				
				long id = ae.getEntryId();
				List<AssetCategory> c = AssetCategoryLocalServiceUtil.getCategories();
				
				for (AssetCategory ac : c) {
					if (ac.getName().equals("allerta-valanghe-lavorazione")) {
						AssetCategoryLocalServiceUtil.addAssetEntryAssetCategory(id, ac);
						break;
					}
				}
			}

			if (!nuovo) {
				// cancella i file esistenti
				AllertaValangheLocalServiceUtil.fileDeleteByApp("bollettino_valanghe", "allerta-valanghe-" + allertaValangheCorrente.getAllertaValangheId(), serviceContext);
				AllertaValangheLocalServiceUtil.fileDeleteByApp("allerta_valanghe", "allerta-valanghe-" + allertaValangheCorrente.getAllertaValangheId(), serviceContext);
				// fileDeleteByApp("bollettino.pdf", "bollettino-"+bollettino.getBollettinoId(),
				// themeDisplay, req2);
			}

			creaReport();
						
			allertaValangheId = allertaValangheCorrente.getAllertaValangheId();
		} catch(Exception e) {
			allertaValangheCorrente =null;
			
			throw e;
		}
	}
	
	public Folder createFolder(ThemeDisplay themeDisplay, String name, String description) {
		long repositoryId = themeDisplay.getScopeGroupId();// repository id is same as groupId
		long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID; // or 0

		try {
			AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("VALANGHE_PARENT_FOLDER_ID");
			
			if (ap != null) {
				parentFolderId = Long.parseLong(ap.getValore());
			}
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

	/**
	 * TODO : da rivedere
	 */
	public void creaReport() {
		int statiMacroaree[] = new int[3];
		int statiMacroareeOggi[] = new int[3];
		
		for (int k = 0; k < 3; k++) {
			statiMacroaree[k] = -1;
			statiMacroareeOggi[k] = -1;
		}
		
		int riga = 0;
		
		for (RigaValangheManager rm : griglia) {
			for (int k = 0; k < 1; k++) {
				GrigliaValangheManager gm = rm.celle.get(k);
				int stato = gm.valori.get(0).valore;

				if (stato != 1000 && stato > statiMacroaree[riga])
					statiMacroaree[riga] = stato;
			}
			
			riga++;
		}
		
		riga=0;
		if (isDueGiorni()) {
			for (RigaValangheManager rm : grigliaOggi) {
				for (int k = 0; k < 1; k++) {
					GrigliaValangheManager gm = rm.celle.get(k);
					int stato = gm.valori.get(0).valore;

					if (stato != 1000 && stato > statiMacroareeOggi[riga])
						statiMacroareeOggi[riga] = stato;
				}
				
				riga++;
			}
		}

		try {
			BufferedImage macroaree = ImageUtility.makeMappaValanghe(statiMacroaree, 660, 380);
			BufferedImage macroareeOggi = null;
			
			File f = FileUtil.createTempFile("png");
			File f2 = null;
			
			ImageUtility.saveImage(macroaree, f, "PNG");
			
			if (isDueGiorni()) {
				macroareeOggi = ImageUtility.makeMappaValanghe(statiMacroareeOggi, 660, 380);
				f2 = FileUtil.createTempFile("png");
				ImageUtility.saveImage(macroareeOggi, f2, "PNG");
			}

			HashMap<String, String> map = new HashMap<String, String>();

			for (int k = 0; k < 1; k++) {
				for (int j = 0; j < aree.length; j++) {
					String r = aree[j];
					if (j==0) r = "A";
					if (j==1) r = "B";
					if (j==2) r = "C";
					String c = "" + (k + 1);
					String paramName = r + "_" + c;
					String val = getStringaStato(griglia.get(j).celle.get(k).valori.get(0).valore);
					map.put(paramName, val);
					map.put(paramName+"oggi", 
							isDueGiorni()?getStringaStato(grigliaOggi.get(j).celle.get(k).valori.get(0).valore):"");
				}
			}
			
			map.put("title",allertaValangheCorrente.getTitolo());
			JasperUtils ju = AllertaTracker.getService(JasperUtils.class); 
			byte[] report = ju.generateReportAllertaValanghe(
				f.getAbsolutePath(),f2!=null?f2.getAbsolutePath():"", allertaValangheCorrente.getAllertaValangheId(), map
			);
			_log.debug("REPORT: " + (report != null ? report.length : 0));

			if (report != null && report.length > 0) {
				File f3 = FileUtil.createTempFile(report);

				String numero = "";
				if (allertaValangheCorrente.getNumero() != null) {
					numero = allertaValangheCorrente.getNumero().replace("/", "_");
				}
				
				String nomeFile = allertaValangheCorrente.isTipoAllerta() ? "allerta_valanghe" + numero + ".pdf"	: "bollettino_valanghe" + numero + ".pdf";
				String tipoFile = allertaValangheCorrente.isTipoAllerta() ? "Allerta Valanghe" : "Bollettino Valanghe";
				ServiceContext serviceContext;
				
				if (httpRequest!=null) {
					serviceContext = ServiceContextFactory.getInstance(AllertaValanghe.class.getName(), httpRequest);
				} else {
					serviceContext = new ServiceContext();
					serviceContext.setUserId(allertaValangheCorrente.getUserId());
					serviceContext.setCompanyId(allertaValangheCorrente.getCompanyId());
					serviceContext.setScopeGroupId(allertaValangheCorrente.getGroupId());
				}
				
				AllertaValangheLocalServiceUtil.fileUploadByApp(
					f3, "allerta-valanghe-" + allertaValangheCorrente.getAllertaValangheId(), nomeFile, tipoFile,
					"application/pdf", serviceContext
				);					
				
				String pdfLink = allertaValangheCorrente.getFileLinkRelative(
					"allerta-valanghe-" + allertaValangheCorrente.getAllertaValangheId(),
					nomeFile
				);

				allertaValangheCorrente.setLink(pdfLink);
				allertaValangheCorrente.setHash(this.getHash(report));
				AllertaValangheLocalServiceUtil.updateAllertaValanghe(allertaValangheCorrente);

				_log.debug("LINK PDF: " + pdfLink);
					
				FileUtil.delete(f3);
			}

			FileUtil.delete(f);
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

		
		if (allertaValangheId > 0) {
			allertaValangheCorrente = AllertaValangheLocalServiceUtil.getAllertaValanghe(allertaValangheId);				
			if (allertaValangheCorrente!=null && allertaValangheCorrente.getStato()==0) return;
			if (allertaValangheCorrente!=null && allertaValangheCorrente.getStato()==1) return;
			if (allertaValangheCorrente!=null && allertaValangheCorrente.getStato()==1000) return;
		}		
		if (allertaValangheCorrente == null)
			return;

		boolean reinvio = allertaValangheCorrente.getStato() == WorkflowConstants.STATUS_DENIED;

		allertaValangheCorrente.setStato(WorkflowConstants.STATUS_PENDING);
		allertaValangheCorrente.setDataFirmaArpa(null);
		allertaValangheCorrente.setDataFirmaProt(null);
		salvaAllertaValanghe();
		
		if (reinvio) {
			allertaValangheCorrente.setStato(WorkflowConstants.STATUS_DRAFT);
			AllertaValangheLocalServiceUtil.updateAllertaValanghe(allertaValangheCorrente);
		}

		ThemeDisplay themeDisplay = (ThemeDisplay) httpRequest.getAttribute(WebKeys.THEME_DISPLAY);

		preparaUtenteApprovatore();
		preparaUtenteApprovatore2();

		//WorkflowDefinitionLink workflowDefinitionLink = null;

		if (reinvio) {

			try {

				WorkflowInstanceLink link = WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(
					allertaValangheCorrente.getCompanyId(), allertaValangheCorrente.getGroupId(), AllertaValanghe.class.getName(),
					allertaValangheCorrente.getAllertaValangheId()
				);

				WorkflowInstance wi = WorkflowInstanceManagerUtil.getWorkflowInstance(
					allertaValangheCorrente.getCompanyId(),	link.getWorkflowInstanceId()
				);

				Map<String, Serializable> wfContext = wi.getWorkflowContext();

				WorkflowInstanceManagerUtil.signalWorkflowInstance(
					allertaValangheCorrente.getCompanyId(),	themeDisplay.getRealUserId(), wi.getWorkflowInstanceId(), "resubmit", wfContext
				);

				Map<String, Serializable> workflowContext = new HashMap<String, Serializable>();
				workflowContext.put(WorkflowConstants.CONTEXT_ENTRY_CLASS_NAME, AllertaValanghe.class.getName());
				workflowContext.put(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK, allertaValangheCorrente.getAllertaValangheId());
				workflowContext.put(WorkflowConstants.CONTEXT_USER_ID, themeDisplay.getUserId());
				workflowContext.put(WorkflowConstants.CONTEXT_GROUP_ID, themeDisplay.getCompanyGroupId());
				workflowContext.put(WorkflowConstants.CONTEXT_COMPANY_ID, themeDisplay.getCompanyId());
				WorkflowStatusManagerUtil.updateStatus(WorkflowConstants.STATUS_PENDING, workflowContext);

				// String tipo =
				// (allertaCorrente.getTipoAllerta()?"workflowAllerta":"workflowBollettino");
				// String sottotipo=allertaCorrente.getNumero();
				// long l = new Date().getTime();

				// mandaNotifica(allertaCorrente.getUtenteFirmaArpaId(),"Il documento
				// "+allertaCorrente.getNumero()+" � in attesa di approvazione:
				// https://allertameteo.regione.emilia-romagna.it"
				// ,allertaCorrente,tipo,sottotipo,l);

				// String text = "<html><head></head><body>Il documento
				// "+allertaCorrente.getNumero()+" e' in attesa di approvazione su <a
				// href=\"https://allertameteo.regione.emilia-romagna.it\">https://allertameteo.regione.emilia-romagna.it</a></body></html>";
				// String subject = "Il documento "+allertaCorrente.getNumero()+" � in attesa di
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

				WorkflowHandlerRegistryUtil.startWorkflowInstance(
					allertaValangheCorrente.getCompanyId(),
					allertaValangheCorrente.getGroupId(), themeDisplay.getUserId(), AllertaValanghe.class.getName(),
					allertaValangheCorrente.getPrimaryKey(), allertaValangheCorrente, sc
				);

			} catch (Exception ex) {
				_log.error(ex);
				//LogInternoLocalServiceUtil.log("allertaBean", "inviaApprovazione", ex, "");

				if (ex instanceof NoSuchWorkflowDefinitionLinkException) {
					SessionMessages.add(httpRequest, "workflow-not-enabled");
				}
				
			}

		}

	}

	public void eliminaAllertaValanghe() {
		if (allertaValangheCorrente != null) {
			try {
				long id = AssetEntryLocalServiceUtil.getEntry(
							AllertaValanghe.class.getName(), allertaValangheCorrente.getAllertaValangheId()
						  ).getEntryId();
				
				AssetEntryLocalServiceUtil.deleteAssetEntry(id);
				AllertaValangheLocalServiceUtil.deleteAllertaValanghe(allertaValangheCorrente);
				
				allertaValangheCorrente = null;
				//init();
			} catch (Exception e) {
				_log.error(e);
				//LogInternoLocalServiceUtil.log("allertaBean", "eliminaAllerta", e, "");			
			}
		}
	}

	public void creaAllertaValanghe(ActionRequest req) {
		_log.debug("creaAllerta");

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) req.getAttribute(WebKeys.THEME_DISPLAY);
			
			AllertaValanghe a = AllertaValangheLocalServiceUtil.createAllertaValanghe(0);
			// IndexerRegistryUtil.nullSafeGetIndexer(AllertaValanghe.class).reindex(a);		
			
			a.setStato(WorkflowConstants.STATUS_DRAFT);
			a.setUserId(themeDisplay.getUserId());
			a.setCompanyId(themeDisplay.getCompanyId());
			a.setGroupId(themeDisplay.getScopeGroupId());

			a.setDescrizioneFenomeni(descrizioneFenomeni);
			a.setNote(note);
			a.setRiferimenti(riferimenti);
			a.setSintesi(sintesi);
			
			AllertaValangheLocalServiceUtil.updateAllertaValanghe(a);

			SessionMessages.add(req, "allerta-valanghe-submit-success");
		} catch (Exception e) {
			_log.error(e);
			//LogInternoLocalServiceUtil.log("allertaValangheBean", "creaAllertaValanghe", e, "");
		}
	}

	public String getDescrizioneFenomeni() {
		return descrizioneFenomeni;
	}

	public void setDescrizioneMeteo(String descrizioneFenomeni) {
		this.descrizioneFenomeni = descrizioneFenomeni;
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

	public AllertaValanghe getAllertaValangheCorrente() {
		return allertaValangheCorrente;
	}

	public void setAllertaCorrente(AllertaValanghe allertaValangheCorrente) {
		this.allertaValangheCorrente = allertaValangheCorrente;
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

	public List<RigaValangheManager> getGriglia() {
		return griglia;
	}

	public void setGriglia(List<RigaValangheManager> griglia) {
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
		return allertaValangheCorrente != null 
			   && (allertaValangheCorrente.getStato() == WorkflowConstants.STATUS_DRAFT
			   || allertaValangheCorrente.getStato() == WorkflowConstants.STATUS_DENIED);
	}

	public boolean getMostraSalva() {
		return allertaValangheCorrente == null 
			   || (allertaValangheCorrente.getStato() == WorkflowConstants.STATUS_DRAFT
			   || allertaValangheCorrente.getStato() == WorkflowConstants.STATUS_DENIED);
	}
	
	public boolean testCanApprove() {		
		return true;		
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getUrl() {
		if (allertaValangheCorrente != null) {
			return allertaValangheCorrente.getUrl();
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

	public List<User> getListaApprovatoriArpae() {
		if (listaApprovatoriArpae == null) {
			try {
				String id = "Approvatore_Arpae";
				AllertaParametro bp = AllertaParametroLocalServiceUtil.fetchAllertaParametro("RUOLO_POTENZIALI_APPROVATORI_ARPAE");
				
				if (bp != null) {
					id = bp.getValore();
				}
				Role r = RoleLocalServiceUtil.getRole(getAllertaValangheCompanyId(), id);
				List<User> utenti = UserLocalServiceUtil.getRoleUsers(r.getRoleId());
				listaApprovatoriArpae = new ArrayList<User>();

				for (User u : utenti) {
					listaApprovatoriArpae.add(u);
					
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

				AllertaParametro bp = AllertaParametroLocalServiceUtil.fetchAllertaParametro("RUOLO_POTENZIALI_APPROVATORI_PC");
				if (bp != null)
					id = bp.getValore();

				Role r = RoleLocalServiceUtil.getRole(getAllertaValangheCompanyId(), id);
				List<User> utenti = UserLocalServiceUtil.getRoleUsers(r.getRoleId());
				listaApprovatoriPc = new ArrayList<User>();

				for (User u : utenti) {
					listaApprovatoriPc.add(u);
					
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

	public void mandaNotifica(long idUtente, String testo, AllertaValanghe a, String tipo, String sottotipo, long l) {
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

	public String getHash(byte[] b) {
		if (b == null || b.length == 0) {			
			return "";
		}
		
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
			_log.debug("Hex format : " + sb.toString());

			// convert the byte to hex format method 2
			hexString = new StringBuffer();
			
			for (int i = 0; i < mdbytes.length; i++) {
				hexString.append(Integer.toHexString(0xFF & mdbytes[i]));
			}
			_log.debug("Hex format : " + hexString.toString());
		} catch (Exception e) {
			e.printStackTrace();
			
			return "";
		}
		
		return hexString.toString();
	}	
	
	public long getAllertaValangheId() {
		return allertaValangheId;
	}

	public void setAllertaValangheId(long allertaValangheId) throws Exception {
		this.allertaValangheId = allertaValangheId;
	}
	
	// private
	
	private void initRequest() throws Exception {
		if (httpRequest != null) {
			allertaValangheId = ParamUtil.getLong(httpRequest, "allertaValangheId");
			
			dataInizio = ParamUtil.getDate(httpRequest, "dataInizio", AllertaKeys.WebDateTimeFormat);
			dataFine = ParamUtil.getDate(httpRequest, "dataFine", AllertaKeys.WebDateTimeFormat);	
			
			descrizioneFenomeni = ParamUtil.getString(httpRequest, "descrizioneFenomeni");
			note = ParamUtil.getString(httpRequest, "note");
			riferimenti = ParamUtil.getString(httpRequest, "riferimenti");
			
			numero = ParamUtil.getString(httpRequest, "numero");
			titolo = ParamUtil.getString(httpRequest, "titolo");
			
			approvatoreArpae = ParamUtil.getString(httpRequest, "approvatoreArpae");
			approvatorePc = ParamUtil.getString(httpRequest, "approvatorePc");	

			griglia=null;
			grigliaOggi=null;
			
			initGriglia();	
		}
	}
	
	private long getAllertaValangheCompanyId() throws PortalException {		
		if (allertaValangheCorrente != null) {
			return allertaValangheCorrente.getCompanyId();
		}
		
		if (this.httpRequest != null) {
			ThemeDisplay themeDisplay = (ThemeDisplay) httpRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			return themeDisplay.getCompanyId();
		}
		
		throw new PortalException("No Company Id");
	}
	
	private void caricaAllertaValanghe() throws Exception {
		if (allertaValangheCorrente != null) {			
			this.numero = allertaValangheCorrente.getNumero();
			this.titolo = allertaValangheCorrente.getTitolo();
			this.approvatoreArpae = String.valueOf(allertaValangheCorrente.getUtenteFirmaArpaId());
			this.approvatorePc = String.valueOf(allertaValangheCorrente.getUtenteFirmaProtId());
			this.allertaValangheId = allertaValangheCorrente.getAllertaValangheId();
			
			this.dataFine = allertaValangheCorrente.getDataFine();
			this.dataInizio = allertaValangheCorrente.getDataInizio();
			this.descrizioneFenomeni = allertaValangheCorrente.getDescrizioneFenomeni();
			this.note = allertaValangheCorrente.getNote();
			this.riferimenti = allertaValangheCorrente.getRiferimenti();
			this.sintesi = allertaValangheCorrente.getSintesi();
			this.dueGiorni = allertaValangheCorrente.getParentId()>0;
			
			
			List<AllertaValangheStato> bb = allertaValangheCorrente.getAllertaValangheStato();

			for (AllertaValangheStato bbb : bb) {
				for (RigaValangheManager rm : griglia) {
					for (GrigliaValangheManager gm : rm.celle) {
						for (CellaValangheManager cm : gm.valori) {
							if (cm.colonna == bbb.getEventoId() && bbb.getAreaId() == (10 * cm.riga + (cm.colonna > 3 ? cm.sottoriga : 0))) {
								cm.stato = bbb;
								cm.valore = (int) bbb.getStatoId();
							}
						}
					}
				}
				
				if (dueGiorni)
					for (RigaValangheManager rm : grigliaOggi) {
						for (GrigliaValangheManager gm : rm.celle) {
							for (CellaValangheManager cm : gm.valori) {
								if (cm.colonna == bbb.getEventoId() && bbb.getAreaId() == -(10 * cm.riga + (cm.colonna > 3 ? cm.sottoriga : 0))) {
									cm.stato = bbb;
									cm.valore = (int) bbb.getStatoId();
									
								}
							}
						}
					}
			}
		}
	}
	
	public String getSintesi() {
		return sintesi;
	}

	public void setSintesi(String sintesi) {
		this.sintesi = sintesi;
	}

	public void salvaSintesi() {

		try {

			if (allertaValangheCorrente == null)
				return;
			
			if (httpRequest!=null)
				sintesi = ParamUtil.getString(httpRequest, "sintesi");
			
			allertaValangheCorrente.setSintesi(sintesi);

			AllertaValangheLocalServiceUtil.updateAllertaValanghe(allertaValangheCorrente);

		} catch (Exception e) {
			_log.error(e);
			//LogInternoLocalServiceUtil.log("allertaBean", "salvaSintesi", e, "");

		}
	}
	
	public String creaDaWebService() {
		return creaDaWebService(false);
	}
	
	public String creaDaWebServiceDueGiorni() {
		return creaDaWebService(true);
	}
	
	public String creaDaWebService(boolean dueG) {
		
		JSONArray d = getWebServiceMetemont(1);
		JSONArray d2 = null;
		boolean noneve = false;
		
		if (dueG) d2 = getWebServiceMetemont(0);
		if (d==null || (dueG && d2==null)) return "erroreAccesso";
		
		int pericoli[] = {-1,-1,-1};
		int pericoliOggi[] = {-1,-1,-1};
		HashMap<String, Integer> mappaColori = new HashMap<String, Integer>();
		
		mappaColori.put("00", -1);
		mappaColori.put("01", 0);
		mappaColori.put("02", 0);
		mappaColori.put("03", 1);
		mappaColori.put("04", 2);
		mappaColori.put("05", 3);
		mappaColori.put("06", 3);
		
		for (int k=0; k<d.length(); k++) {
			JSONObject o = d.getJSONObject(k);
			int index = -1;
			if (o.getString("descSottoSett").equals("Appennino Emiliano Occidentale")) index = 0;
			if (o.getString("descSottoSett").equals("Appennino Emiliano Centrale")) index = 1;
			if (o.getString("descSottoSett").equals("Appennino Romagnolo")) index = 2;
			
			if (index>=0) {
				try {
					String s = o.getString("dataRif").substring(0, 10);
					long dataRif = new SimpleDateFormat("yyyy-MM-dd").parse(s).getTime();
					long now = new Date().getTime();
					//if (now-dataRif>24*3600*1000)
						//return "nonAggiornato";
					
					String pericolo1 = o.getString("colorePericolo1");
					String pericolo2 = o.getString("colorePericolo2");
					String pericolo = (!"".equals(pericolo2) && pericolo1.compareTo(pericolo2)<0?pericolo2:pericolo1);
					Integer val = mappaColori.get(pericolo);
					if (val==null) val = 0;
					pericoli[index] = val;
					
					if (val<0) noneve = true;
				} catch (Exception e) {
					_log.error(e);
					return "erroreAccesso";
				}
			}
		}
		
		if (dueG) {
			for (int k=0; k<d2.length(); k++) {
				JSONObject o = d2.getJSONObject(k);
				int index = -1;
				if (o.getString("descSottoSett").equals("Appennino Emiliano Occidentale")) index = 0;
				if (o.getString("descSottoSett").equals("Appennino Emiliano Centrale")) index = 1;
				if (o.getString("descSottoSett").equals("Appennino Romagnolo")) index = 2;
				
				if (index>=0) {
					try {
						/*String s = o.getString("dataRif").substring(0, 10);
						long dataRif = new SimpleDateFormat("yyyy-MM-dd").parse(s).getTime();
						long now = new Date().getTime();
						if (now-dataRif>24*3600*1000)
							return "nonAggiornato";*/
						
						String pericolo1 = o.getString("colorePericolo1");
						String pericolo2 = o.getString("colorePericolo2");
						String pericolo = (!"".equals(pericolo2) && pericolo1.compareTo(pericolo2)<0?pericolo2:pericolo1);
						Integer val = mappaColori.get(pericolo);
						if (val==null) val = 0;
						pericoliOggi[index] = val;
						
						if (val<0) noneve = true;
						
					} catch (Exception e) {
						_log.error(e);
						return "erroreAccesso";
					}
				}
			}
		}
		
		//if (pericoli[0]<0 ||pericoli[1]<0 || pericoli[2]<0)
		//	return "incompleto";
		
		
		ThemeDisplay themeDisplay = (ThemeDisplay) httpRequest.getAttribute(WebKeys.THEME_DISPLAY);	

		
		try {
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(AllertaValanghe.class.getName(), httpRequest);				

			long inc = CounterLocalServiceUtil.increment(AllertaValanghe.class.getName());
			allertaValangheCorrente = AllertaValangheLocalServiceUtil.createAllertaValanghe(inc);
			
			allertaValangheCorrente.setCreateDate(new Date());
			allertaValangheCorrente.setUserId(themeDisplay.getRealUserId());
			allertaValangheCorrente.setGroupId(themeDisplay.getScopeGroupId());
			allertaValangheCorrente.setUserName(themeDisplay.getRealUser().getFullName());
			allertaValangheCorrente.setCompanyId(themeDisplay.getCompanyId());
			allertaValangheCorrente.setStato(WorkflowConstants.STATUS_DRAFT);
			allertaValangheCorrente.setCreatorName(themeDisplay.getRealUser().getFullName());
			
			allertaValangheCorrente.setModifiedDate(new Date());
			
			allertaValangheCorrente.setParentId(dueG?1:0);
			dueGiorni = dueG;
			
			setThreadUserPermission();

			Calendar c = Calendar.getInstance();
			c.set(Calendar.HOUR_OF_DAY, 0);
			c.set(Calendar.MINUTE,0);
			c.set(Calendar.SECOND,0);
			c.set(Calendar.MILLISECOND,0);
			c.add(Calendar.DAY_OF_YEAR, 1);
			dataInizio = c.getTime();
			c.add(Calendar.DAY_OF_YEAR, 1);
			dataFine = c.getTime();
			if (dueG) dataInizio = new Date(dataInizio.getTime()-12*3600*1000);
			allertaValangheCorrente.setDataInizio(this.dataInizio);
			allertaValangheCorrente.setDataFine(this.dataFine);
			
			if (Validator.isNull(riferimenti)) {
				try {
					AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("TESTO_RIFERIMENTI_VALANGHE");
					
					if (ap != null) {
						riferimenti = ap.getValore();
					}
				} catch (Exception e) {
				}			
			}
			if (Validator.isNull(descrizioneFenomeni)) {
				try {
					AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("TESTO_FENOMENI_VALANGHE");
					
					if (ap != null) {
						descrizioneFenomeni = ap.getValore();
					}
				} catch (Exception e) {
				}			
			}

			allertaValangheCorrente.setDescrizioneFenomeni(descrizioneFenomeni);
			allertaValangheCorrente.setNote("");
			if (noneve) {
				AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("VALANGHE_NOSNOW");
				if (ap!=null) allertaValangheCorrente.setNote(ap.getValore());
					/*allertaValangheCorrente.setNote("Il codice colore grigio indica la condizione di \"NO NEVE\" che individua una situazione nella quale la presenza del manto nevoso si " + 
						"caratterizza, a scala sinottica (aree >= 100km2), in forma estremamente discontinua, con una distribuzione fortemente localizzata " + 
						"(canaloni e conche) e spessori ridotti che possono variare in funzione della quota e dell'esposizione. Questa condizione non coinvolge " + 
						"quindi lo sviluppo di interi versanti per cui la possibilità di fenomeni valanghivi non è valutabile alla scala definita.");*/
			}
			allertaValangheCorrente.setRiferimenti(riferimenti);
			allertaValangheCorrente.setSintesi(null);

			allertaValangheCorrente.setUtenteFirmaArpaId(20198);
			allertaValangheCorrente.setUtenteFirmaProtId(20198);
			
			int ev[] = new int[1];
			ev[0] = pericoli[0];
			if (pericoli[1]>ev[0]) ev[0] = pericoli[1];
			if (pericoli[2]>ev[0]) ev[0] = pericoli[2];
			if (ev[0]<0) ev[0] = 0;
			
			if (dueG) {
				if (pericoliOggi[0]>ev[0]) ev[0] = pericoliOggi[0];
				if (pericoliOggi[1]>ev[0]) ev[0] = pericoliOggi[1];
				if (pericoliOggi[2]>ev[0]) ev[0] = pericoliOggi[2];
				if (ev[0]<0) ev[0] = 0;
			}
			
			String s = getTitoloDefault(ev);
			s = s.replace("HH:mm", dueG?"12:00":"00:00");
			s = s.replace("DD/MM/YYYY", new SimpleDateFormat("dd/MM/yyyy").format(dataInizio));
			allertaValangheCorrente.setTitolo(s);
			allertaValangheCorrente.setTipoAllerta(ev[0]>0);
			allertaValangheCorrente.setNumero(getNumeroDefault(ev));
			
			AllertaValangheLocalServiceUtil.updateAllertaValanghe(allertaValangheCorrente);
			
			AssetEntryLocalServiceUtil.updateEntry(
					themeDisplay.getUserId(), allertaValangheCorrente.getGroupId(),
					AllertaValanghe.class.getName(), allertaValangheCorrente.getAllertaValangheId(), 
					serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames()
				);

				if (allertaValangheCorrente.getStato() == WorkflowConstants.STATUS_DRAFT) {				
					AssetEntry ae = AssetEntryLocalServiceUtil.getEntry(AllertaValanghe.class.getName(), allertaValangheCorrente.getAllertaValangheId());
					
					try {
						ae.setTitle(allertaValangheCorrente.getTitolo());
						ae.setDescription(allertaValangheCorrente.getDescrizioneFenomeni());
						
						if (ae.getCreateDate()==null) ae.setCreateDate(new Date());
							ae.setModifiedDate(new Date());
							
						ae.setSummary(allertaValangheCorrente.getTitolo());					
						AssetEntryLocalServiceUtil.updateAssetEntry(ae);
					} catch (Exception ee) {
						_log.error(ee);
					}
					
					long id = ae.getEntryId();
					List<AssetCategory> cx = AssetCategoryLocalServiceUtil.getCategories();
					
					for (AssetCategory ac : cx) {
						if (ac.getName().equals("allerta-valanghe-lavorazione")) {
							AssetCategoryLocalServiceUtil.addAssetEntryAssetCategory(id, ac);
							break;
						}
					}
				}
			
			griglia = new ArrayList<RigaValangheManager>();
			for (int k=0; k<3; k++) {
				
				RigaValangheManager rv = new RigaValangheManager();
				griglia.add(rv);
				rv.divisa = false;
				rv.nomeRiga = aree[k];
				rv.celle = new ArrayList<GrigliaValangheManager>();
				GrigliaValangheManager gv = new GrigliaValangheManager();
				rv.celle.add(gv);
				gv.area = aree[k];
				gv.colonna=1;
				gv.idEvento=1;
				gv.nomeEvento=eventi[0];
				gv.valori = new ArrayList<CellaValangheManager>();
				CellaValangheManager cv = new CellaValangheManager();
				gv.valori.add(cv);
				cv.colonna = 1;
				cv.riga = k+1;
				cv.sottoriga = 1;
				
				if (pericoli[k]<0 || pericoli[k]>3) pericoli[k] = 1000;
				
				cv.valore = pericoli[k];
				
				
				long id = CounterLocalServiceUtil.increment(AllertaValangheStato.class.getName());
				
				AllertaValangheStato cm = AllertaValangheStatoLocalServiceUtil.createAllertaValangheStato(id);
				cm.setEventoId(1);
				cm.setAreaId(10*(k+1));
				cm.setCreateDate(new Date());
				cm.setAllertaValangheId(allertaValangheCorrente.getAllertaValangheId());						
				//}
				cm.setStatoId(pericoli[k]);
				
				AllertaValangheStatoLocalServiceUtil.updateAllertaValangheStato(cm);
			}
			
			if (dueG) {
				grigliaOggi = new ArrayList<RigaValangheManager>();
				for (int k=0; k<3; k++) {
					
					RigaValangheManager rv = new RigaValangheManager();
					grigliaOggi.add(rv);
					rv.divisa = false;
					rv.nomeRiga = aree[k];
					rv.celle = new ArrayList<GrigliaValangheManager>();
					GrigliaValangheManager gv = new GrigliaValangheManager();
					rv.celle.add(gv);
					gv.area = aree[k];
					gv.colonna=1;
					gv.idEvento=1;
					gv.nomeEvento=eventi[0];
					gv.valori = new ArrayList<CellaValangheManager>();
					CellaValangheManager cv = new CellaValangheManager();
					gv.valori.add(cv);
					cv.colonna = 1;
					cv.riga = k+1;
					cv.sottoriga = 1;
					
					if (pericoliOggi[k]<0 || pericoliOggi[k]>3) pericoliOggi[k] = 1000;
					
					cv.valore = pericoliOggi[k];
					
					
					long id = CounterLocalServiceUtil.increment(AllertaValangheStato.class.getName());
					
					AllertaValangheStato cm = AllertaValangheStatoLocalServiceUtil.createAllertaValangheStato(id);
					cm.setEventoId(1);
					cm.setAreaId(-10*(k+1));
					cm.setCreateDate(new Date());
					cm.setAllertaValangheId(allertaValangheCorrente.getAllertaValangheId());						
					//}
					cm.setStatoId(pericoli[k]);
					
					AllertaValangheStatoLocalServiceUtil.updateAllertaValangheStato(cm);
				}
			}
			
			createFolder(themeDisplay, "allerta-valanghe-" + inc, "File per documento valanghe " + inc);
			creaReport();
			
		} catch (Exception e ) {
			_log.error(e);
			return "erroreSalvataggio";
		}
		return "";
	}
	
	public InputStream getInputStreaWithTimeout(String value){
		HttpURLConnection huc = null;
		try {
			URL url = new URL(value);
			huc = (HttpURLConnection) url.openConnection();
			HttpURLConnection.setFollowRedirects(false);
			huc.setConnectTimeout(15 * 1000);
			huc.setReadTimeout(30 * 1000);
			huc.setRequestMethod("GET");
			huc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.1.2) Gecko/20090729 Firefox/3.5.2 (.NET CLR 3.5.30729)");
			huc.connect();
			return huc.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			_log.error("IoException.. metodo per gestire l'inputstream con timeout \n"+e);
		}
		return null;

	}
	
	private byte[] fromStreamtoByteArray(InputStream inputStream) throws IOException {
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		StreamUtil.transfer(inputStream, baos);
		
		return baos.toByteArray();
	}
	
	private JSONArray getWebServiceMetemont(int giorno){
		String url = "https://servizimeteomont.csifa.carabinieri.it/api/meteomontweb/previsioni/getprevisionivalangheCL/data?data=";
		Date d = new Date();
		url += new SimpleDateFormat("yyyy-MM-dd").format(d)+"T"+new SimpleDateFormat("HH:mm:ss").format(d);
		
		InputStream input = null;
		
		try {
			
			input = getInputStreaWithTimeout(url);
			String json = new String(fromStreamtoByteArray(input),"utf-8");
			JSONArray j = JSONFactoryUtil.createJSONObject(json).getJSONObject("giorno"+giorno).getJSONArray("previsioneValanga");
			
			if (input!=null) input.close();
			return j;
		} catch (Exception e) {
			_log.error(e);
		}
		return null;
	}
	
	
	

	public List<RigaValangheManager> getGrigliaOggi() {
		return grigliaOggi;
	}

	public void setGrigliaOggi(List<RigaValangheManager> grigliaOggi) {
		this.grigliaOggi = grigliaOggi;
	}

	public boolean isDueGiorni() {
		return dueGiorni;
	}

	public void setDueGiorni(boolean dueGiorni) {
		this.dueGiorni = dueGiorni;
	}




	private Log _log = LogFactoryUtil.getLog(AllertaValangheBean.class);
}
