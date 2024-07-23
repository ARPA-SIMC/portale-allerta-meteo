package it.eng.allerter.allerta;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.NoSuchWorkflowDefinitionLinkException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.WorkflowInstanceLink;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
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
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerta.utils.AllertaTracker;
import it.eng.allerter.model.Allerta;
import it.eng.allerter.service.LogInternoLocalServiceUtil;
//import it.eng.allerter.service.//LogInternoLocalServiceUtil;
import it.eng.bollettino.model.Bacino;
import it.eng.bollettino.model.Bollettino;
import it.eng.bollettino.model.BollettinoBacino;
import it.eng.bollettino.model.BollettinoParametro;
import it.eng.bollettino.model.BollettinoSensore;
import it.eng.bollettino.model.Stazione;
import it.eng.bollettino.model.StazioneVariabile;
import it.eng.bollettino.model.ValoreSensore;
import it.eng.bollettino.service.BacinoLocalServiceUtil;
import it.eng.bollettino.service.BollettinoBacinoLocalServiceUtil;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;
import it.eng.bollettino.service.BollettinoParametroLocalServiceUtil;
import it.eng.bollettino.service.BollettinoSensoreLocalServiceUtil;
import it.eng.bollettino.service.StazioneLocalServiceUtil;
import it.eng.bollettino.service.StazioneVariabileLocalServiceUtil;
import it.eng.bollettino.service.ValoreSensoreLocalServiceUtil;

/*
 * RIVEDERE I PATH ASSOLUTI
 */

public class BollettinoBean implements Serializable {
	
	String queryUltimoPubblicato= "select bollettinoid, numero from bollettino_bollettino where stato=0 order by dataemissione desc limit 1";
	String queryCopiaColmiOsservati =
			"update bollettino_bollettinosensore bs set osservato=(select osservato from bollettino_bollettinosensore bs2 " + 
			"where bs2.idstazione=bs.idstazione and bs2.idbollettino=IDB limit 1), " + 
			"colmoprevisto=(select colmoprevisto from bollettino_bollettinosensore bs2 " + 
			"where bs2.idstazione=bs.idstazione and bs2.idbollettino=IDB limit 1), " + 
			"oraprevista=(select oraprevista from bollettino_bollettinosensore bs2 " + 
			"where bs2.idstazione=bs.idstazione and bs2.idbollettino=IDB limit 1), " + 
			"giornoprevisto=(select giornoprevisto from bollettino_bollettinosensore bs2 " + 
			"where bs2.idstazione=bs.idstazione and bs2.idbollettino=IDB limit 1), " + 
			"tendenza=(select tendenza from bollettino_bollettinosensore bs2 " + 
			"where bs2.idstazione=bs.idstazione and bs2.idbollettino=IDB limit 1) " + 
			"			   where bs.idbollettino=IDN and exists(select * from bollettino_bollettinosensore bs2 " + 
			"where bs2.idstazione=bs.idstazione and bs2.idbollettino=IDB limit 1)";
	String queryCopiaNote = "update bollettino_bollettinobacino bb set note = (select note from bollettino_bollettinobacino bb2 where bb2.idbacino=bb.idbacino and bb2.idbollettino=IDB limit 1) where bb.idbollettino=IDN and exists(select * from bollettino_bollettinobacino bb2 where bb2.idbacino=bb.idbacino and bb2.idbollettino=IDB limit 1)";
	/**
	 * 
	 */
	private static final long serialVersionUID = -6066789871362224379L;
	
	boolean dryRun = false; //se true, non crea veramente gli oggetti in db.
	public boolean creaRep = true;
	public boolean ignoraSensori = false;

	private Bollettino bollettino;
	private String stringaMeteo = "";
	private List<BacinoManager> bacini;
	private BacinoManager bacinoParam;
	private String noteMeteo;
	private String numero;
	Date dataInizio = null;
	Date dataFine = null;
	private boolean ultimo = false;
	private long bollettinoId = 0;


	private List<SelectItem> listaApprovatoriArpae;
	private String approvatoreArpae = null;

	// immagini
	BufferedImage sfondo;
	List<BufferedImage> icone;
	//public static String pathReports = "";
	String pathImmagine = "";
	String path = "";
	boolean oraLegale;
	
	private long taskId = -1;
	private String taskName = "";

	HttpServletRequest request;
	
	String sfondoImageName = "trascinata6h.png";
	String sfondoImageName2 = "trascinata48h.png";
	
	public BollettinoBean(long bollettinoId, HttpServletRequest request) {
		
		this.bollettinoId = bollettinoId;
		this.request = request;
		
		if (bollettinoId>0 && BollettinoLocalServiceUtil.fetchBollettino(bollettinoId)==null) {
			dryRun = false;
		}
		
		initBean();
	}

	public BollettinoBean(HttpServletRequest request) {
		
		try {
			this.request = request;
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			ServiceContext sc = ServiceContextFactory.getInstance(Bollettino.class.getName(), request);
			createBollettino2(themeDisplay, sc);
			LogInternoLocalServiceUtil.log("monitoraggio", "creaMonitoraggio", ""+bollettino.getBollettinoId(), "");
		} catch (Exception e) {
			LogInternoLocalServiceUtil.log("monitoraggio", "creaMonitoraggio", e, "");
		}
		//initBean();
	}
	
	public void setRequest( HttpServletRequest request) {
		this.request = request;
	}
	
	public void initBean() {
		
		//ignoraSensori = "true".equals(ParamUtil.getString(request, "ignoreSensors"));
		carica();
		
		init();
		
		//riempiBollettino();
		
		if( this.bollettinoId > 0)
			initFromBean();
		else
			initFromRequest();
			
		oraLegale = TimeZone.getDefault().inDaylightTime(new Date());
	}
	

	public String getDataImagePath() {
		
		String path = PropsUtil.get("liferay.home");
		
		path = path.concat("/data");
		
		path = path.concat("/images");
		File file = new File(path);
		
		if (!file.exists()) {
			file.mkdir();
		}
		
		path = path.concat("/");
		
		
		return path;
		
	}
	
	public void initGriglia() {
		
		String baciniInput =  ParamUtil.getString(this.request, "bacini_selected", null);
		
		//if( Validator.isNotNull(baciniInput)) {
			
			//String[] baciniIds = baciniInput.split("_");
			
			if( bollettino == null) {
				
				ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

				ServiceContext sc = null;
				try {
					sc = ServiceContextFactory.getInstance(Bollettino.class.getName(), request);
				} catch (PortalException e) {
				
				}
				
				createBollettino(themeDisplay, sc);
				
				//riempiBollettino();
				
				for (BacinoManager bb : this.bacini) {

					bb.selezionato = false;
					for (StazioneManager sm : bb.stazioni) {
						if (sm.selezionata)
							bb.selezionato = true;
					}

					// genera automaticamente l'ora di osservazione
					if (bb.selezionato && bb.getOre() == null) {
						bacinoParam = bb;
						rigeneraOra();
					}

					bb.bacino.setIdBollettino(bollettino.getBollettinoId());
					bb.bacino.setNote(bb.getNote());
					bb.setNote(bb.getNote());
					bb.bacino.setOreOsservazione(bb.getOre());
					bb.bacino.setIdBollettino(bollettino.getBollettinoId());
					if (!dryRun) BollettinoBacinoLocalServiceUtil.updateBollettinoBacino(bb.bacino);

					for (StazioneManager sm : bb.stazioni) {

						sm.sensore.setIdBollettino(bollettino.getBollettinoId());
						sm.sensore.setIdBollettinoBacino(bb.bacino.getPrimaryKey());
						sm.sensore.setNomeStazione(sm.stazione.getName());
						sm.sensore.setSoglia1(sm.stazioneVariabile.getSoglia1());
						sm.sensore.setSoglia2(sm.stazioneVariabile.getSoglia2());
						sm.sensore.setSoglia3(sm.stazioneVariabile.getSoglia3());
						
						sm.sensore.setColmoPrevisto(sm.getLivelloPrevisto());
						sm.sensore.setOraPrevista(sm.oraPrevista);
						sm.sensore.setGiornoPrevisto(sm.giornoPrevisto);
						sm.sensore.setOsservazione(sm.ultimoLivello != null ? sm.ultimoLivello : 0.0);
						sm.sensore.setOreOsservazione(sm.oraUltimoLivello);
						
						int tendenza = -100;
						if (sm.isSelezionata()) {
							String ten = sm.getTendenza();
							if (ten.equals("+"))
								tendenza = 1;
							else if (ten.equals("-"))
								tendenza = -1;
							else if (ten.equals("="))
								tendenza = 0;
							else
								tendenza = 2;
						}

						sm.sensore.setTendenza(tendenza);
						

						if (!dryRun) BollettinoSensoreLocalServiceUtil.updateBollettinoSensore(sm.sensore);
						return;
					}
				}

			}
			
			if (bollettino == null || ignoraSensori)
				return;

			List<BollettinoBacino> bb = bollettino.getBacini();
			
			if(bacini == null)
				bacini = new ArrayList<BacinoManager>();
			else
				bacini.clear();

			for (BollettinoBacino bbb : bb) {

				BacinoManager bm = new BacinoManager();
				bacini.add(bm);
				bm.bacino = bbb;
				bm.bac = BacinoLocalServiceUtil.fetchBacino(bbb.getIdBacino());
				bm.note = bbb.getNote();
				bm.ore = bbb.getOreOsservazione();
				//String xyz = ParamUtil.getString(this.request, "note", null);
				String xyz = ParamUtil.getString(this.request, "note_" + bbb.getIdBacino(), null);
				if (xyz!=null) {
					bm.note = xyz;
					bm.getBacino().setNote(xyz);
				}

				DynamicQuery dyn2 = BollettinoSensoreLocalServiceUtil.dynamicQuery()
						.add(PropertyFactoryUtil.forName("idBollettinoBacino").eq(bbb.getId()))
						.addOrder(OrderFactoryUtil.asc("progressivo"));
				List<BollettinoSensore> ss = BollettinoSensoreLocalServiceUtil.dynamicQuery(dyn2);

				bm.stazioni = new ArrayList<StazioneManager>();

				for (BollettinoSensore sss : ss) {

					StazioneManager sm = new StazioneManager();
					sm.sensore = sss;
					sm.parent = bm;
					bm.stazioni.add(sm);

					DynamicQuery dyn3 = StazioneLocalServiceUtil.dynamicQuery()
							.add(PropertyFactoryUtil.forName("name").eq(sss.getNomeStazione()))
							.add(PropertyFactoryUtil.forName("progressivo").ne(0));
					List<Stazione> ssss = BollettinoSensoreLocalServiceUtil.dynamicQuery(dyn3);

					if (ssss.size() > 0) {
						sm.stazione = ssss.get(0);

						DynamicQuery dyn = StazioneVariabileLocalServiceUtil.dynamicQuery()
								.add(PropertyFactoryUtil.forName("idStazione").eq(sm.stazione.getId()))
								.add(PropertyFactoryUtil.forName("idVariabile").eq("254,0,0/1,-,-,-/B13215"));
						List<StazioneVariabile> ssvv = StazioneVariabileLocalServiceUtil.dynamicQuery(dyn);

						if (ssvv.size() > 0)
							sm.stazioneVariabile = ssvv.get(0);
					}

					sm.livelloPrevisto = "";
					sm.oraPrevista = "";
					sm.giornoPrevisto = "";
					sm.setTendenza("=");
					sss.setTendenza(-100);
					
					if( Validator.isNotNull(baciniInput) && baciniInput.indexOf( "_" + bbb.getIdBacino()) >= 0 ) {
						
						String stazioneInput =  ParamUtil.getString(this.request, "stazionesel_" + sm.stazione.getId(), null);
						
						if( stazioneInput != null) {
							
							String note = ParamUtil.getString(this.request, "note_" + bbb.getIdBacino(), null);
							
							sm.selezionata = true;
							sm.livelloPrevisto = sss.getColmoPrevisto();
							sm.oraPrevista = sss.getOraPrevista();
							sm.giornoPrevisto = sss.getGiornoPrevisto();
							
							String tendenza = ParamUtil.getString(this.request, "tendenza_" + sm.stazione.getId(), null);
							
							if (tendenza.equals("+"))
								sss.setTendenza(1);
							else if (tendenza.equals("-"))
								sss.setTendenza(-1);
							else if (tendenza.equals("="))
								sss.setTendenza(0);
							else if (tendenza.equals("?"))
								sss.setTendenza(2);
							
							/*if (note!=null) {
								bm.getBacino().setNote(note);
								bm.note = note;
							}*/
							 
							sss.setColmoPrevisto(ParamUtil.getString(this.request, "livelloprevisto_" + sm.stazione.getId(), null));
							sss.setOraPrevista(ParamUtil.getString(this.request, "oraprevista_" + sm.stazione.getId(), null));
							sss.setGiornoPrevisto(ParamUtil.getString(this.request, "giornoprevisto_" + sm.stazione.getId(), null));
							
							sss.setOsservazione(ParamUtil.getDouble(this.request, "ultimoLivello_" + sm.stazione.getId(), 0.0));
							sss.setOreOsservazione(ParamUtil.getString(this.request, "oraLivelloOsservato_" + sm.stazione.getId(), null));
							sss.setOsservato(ParamUtil.getBoolean(this.request, "osserv_" + sm.stazione.getId()));
							
						} else {
							sm.selezionata = false;

						}
						
					} else 
						sm.selezionata = false;
						

				}
			}
		//}
	}
	
	public void carica()  {

		
		try {
			BollettinoParametro rep = BollettinoParametroLocalServiceUtil
					.fetchBollettinoParametro("BOLLETTINO_REPORT_PATH");
			if (rep == null)
				rep = BollettinoParametroLocalServiceUtil.createBollettinoParametro("BOLLETTINO_REPORT_PATH");
			//rep.setValore(pathReports);
			BollettinoParametroLocalServiceUtil.updateBollettinoParametro(rep);
		} catch (Exception ex) {
			_log.error(ex);
		}

		if (sfondo == null) {

			path = getDataImagePath() ;

			try {
				BollettinoParametro bp = BollettinoParametroLocalServiceUtil
						.fetchBollettinoParametro("BOLLETTINO_IMG_PATH");
				if (bp == null)
					bp = BollettinoParametroLocalServiceUtil.createBollettinoParametro("BOLLETTINO_IMG_PATH");
				bp.setValore(path);
				BollettinoParametroLocalServiceUtil.updateBollettinoParametro(bp);
			} catch (Exception ex) {
				//LogInternoLocalServiceUtil.log("BollettinoBean", "getCarica", ex, "");
			}

			try {

//				BollettinoParametro pathImg = BollettinoParametroLocalServiceUtil
//						.fetchBollettinoParametro("PATH_IMG_BOLLETTINO");
				BollettinoParametro datiImg = BollettinoParametroLocalServiceUtil
						.fetchBollettinoParametro("IMG_BOLLETTINO");

				if (datiImg != null) {

					pathImmagine = path + sfondoImageName; 
					byte[] bb = hexStringToByteArray(datiImg.getValore());
					File file = FileUtil.createTempFile(bb);
					File veroFile = new File(file.getParentFile(), sfondoImageName);
					if (veroFile.exists()) {
						veroFile.delete();

					}
					file.renameTo(veroFile);

					Files.copy(Paths.get(veroFile.getAbsolutePath()), Paths.get(pathImmagine),
							StandardCopyOption.REPLACE_EXISTING);
					file.delete();
				}
				

			} catch (Exception e) {
				//LogInternoLocalServiceUtil.log("BollettinoBean", "getCarica", e, "");
				_log.error(e);
			}

			
			sfondo = ImageUtility.getImage(this.getClass().getResourceAsStream("/images/macroaree.png"));
			icone = new ArrayList<BufferedImage>();
			icone.add(ImageUtility.getImage(this.getClass().getResourceAsStream("/images/pioggiaassente.png")));
			icone.add(ImageUtility.getImage(this.getClass().getResourceAsStream("/images/pioggiadebole.png")));
			icone.add(ImageUtility.getImage(this.getClass().getResourceAsStream("/images/pioggiamoderata.png")));
			icone.add(ImageUtility.getImage(this.getClass().getResourceAsStream("/images/pioggiaelevata.png")));
			icone.add(ImageUtility.getImage(this.getClass().getResourceAsStream("/images/pioggianeve.png")));
			icone.add(ImageUtility.getImage(this.getClass().getResourceAsStream("/images/neve.png")));
		}

		
		if (bollettinoId > 0) {
			
			bollettino = BollettinoLocalServiceUtil.fetchBollettino(bollettinoId);
			if (bollettino == null)
				return;

			this.dataInizio = bollettino.getDataInizio();
			this.dataFine = bollettino.getDataFine();
			this.numero = bollettino.getNumero();
			this.noteMeteo = bollettino.getNoteMeteo();
			this.stringaMeteo = bollettino.getStringaMeteo();
			this.ultimo = bollettino.getUltimo();

//			DynamicQuery dyn = BollettinoBacinoLocalServiceUtil.dynamicQuery()
//					.add(PropertyFactoryUtil.forName("idBollettino").eq(bollettinoId))
//					.addOrder(OrderFactoryUtil.asc("progressivo"));
			List<BollettinoBacino> bb = bollettino.getBacini();

			if(bacini == null)
				bacini = new ArrayList<BacinoManager>();
			else
				bacini.clear();

			for (BollettinoBacino bbb : bb) {

				BacinoManager bm = new BacinoManager();
				bacini.add(bm);
				bm.bacino = bbb;
				bm.bac = BacinoLocalServiceUtil.fetchBacino(bbb.getIdBacino());
				bm.note = bbb.getNote();
				bm.ore = bbb.getOreOsservazione();

				DynamicQuery dyn2 = BollettinoSensoreLocalServiceUtil.dynamicQuery()
						.add(PropertyFactoryUtil.forName("idBollettinoBacino").eq(bbb.getId()))
						.addOrder(OrderFactoryUtil.asc("progressivo"));
				List<BollettinoSensore> ss = BollettinoSensoreLocalServiceUtil.dynamicQuery(dyn2);

				bm.stazioni = new ArrayList<StazioneManager>();
				
				for (BollettinoSensore sss : ss) {

					StazioneManager sm = new StazioneManager();
					sm.sensore = sss;
					sm.parent = bm;
					
					if (sss.getTendenza() != -100) {
						sm.selezionata = true;
						bm.selezionato = true;
					}

					DynamicQuery dyn3 = StazioneLocalServiceUtil.dynamicQuery()
							.add(PropertyFactoryUtil.forName("name").eq(sss.getNomeStazione()))
							.add(PropertyFactoryUtil.forName("progressivo").ne(0));
					List<Stazione> ssss = BollettinoSensoreLocalServiceUtil.dynamicQuery(dyn3);

					if (ssss.size() > 0) {
						sm.stazione = ssss.get(0);

						DynamicQuery dyn = StazioneVariabileLocalServiceUtil.dynamicQuery()
								.add(PropertyFactoryUtil.forName("idStazione").eq(sm.stazione.getId()))
								.add(PropertyFactoryUtil.forName("idVariabile").eq("254,0,0/1,-,-,-/B13215"));
						List<StazioneVariabile> ssvv = StazioneVariabileLocalServiceUtil.dynamicQuery(dyn);

						if (ssvv.size() > 0)
							sm.stazioneVariabile = ssvv.get(0);
					}

					sm.livelloPrevisto = sss.getColmoPrevisto();
					sm.oraPrevista = sss.getOraPrevista();
					sm.giornoPrevisto = sss.getGiornoPrevisto();
					sm.setOsservato(sss.getOsservato());
					sm.ultimoLivello = sss.getOsservazione();
					sm.oraUltimoLivello = sss.getOreOsservazione();

					if (sss.getTendenza()==1) sm.tendenza="+";
					if (sss.getTendenza()==0) sm.tendenza="=";
					if (sss.getTendenza()==-1) sm.tendenza="-";
					//sm.tendenza = String.valueOf( sss.getTendenza());
					
					// ricarica gli ultimi due valori osservati (il penultimo serve per la tendenza)
					DynamicQuery dyn = ValoreSensoreLocalServiceUtil.dynamicQuery()
							.add(PropertyFactoryUtil.forName("idStazione").eq(sm.stazione.getId()))
							.add(PropertyFactoryUtil.forName("idVariabile").eq("254,0,0/1,-,-,-/B13215"))
							.addOrder(OrderFactoryUtil.desc("datetime"));
					List<ValoreSensore> sv = ValoreSensoreLocalServiceUtil.dynamicQuery(dyn, 0, 2);
					if (sss.getTendenza()==-100) {
					if (sv.size() > 0)
						sm.ultimoLivello = sv.get(0).getValue();
					if (sv.size() > 1)
						sm.penultimoLivello = sv.get(1).getValue();
					sm.setTendenza(sm.calcolaTendenza());
					}
					
					bm.stazioni.add(sm);
				}

			}

			//ricaricaLivelliOsservati();

		} else 
			riempiBollettino();

	}

	public void setThreadUserPermission() throws Exception {
		
		// fingiamo di essere il creatore dell'allerta
		PrincipalThreadLocal.setName(bollettino.getUserId());
		PermissionChecker pc = PermissionCheckerFactoryUtil
				.create(UserLocalServiceUtil.fetchUser(bollettino.getUserId()));
		PermissionThreadLocal.setPermissionChecker(pc);

	}

/*
	public String myCarica(long l, long scope) throws Exception {

		bollettino = BollettinoLocalServiceUtil.fetchBollettino(l);
		if (bollettino == null)
			return null;

		// BollettinoParametro bp =
		// BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("BOLLETTINO_REPORT_PATH");
		// if (bp==null) return null;
		// pathReports = bp.getValore();

		BollettinoParametro bp = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("BOLLETTINO_IMG_PATH");
		if (bp == null)
			return null;
		path = bp.getValore();

		sfondo = ImageUtility.getImage(this.getClass().getResourceAsStream("/images/macroaree.png"));
		icone = new ArrayList<BufferedImage>();
		icone.add(ImageUtility.getImage(this.getClass().getResourceAsStream("/images/pioggiaassente.png")));
		icone.add(ImageUtility.getImage(this.getClass().getResourceAsStream("/images/pioggiadebole.png")));
		icone.add(ImageUtility.getImage(this.getClass().getResourceAsStream("/images/pioggiamoderata.png")));
		icone.add(ImageUtility.getImage(this.getClass().getResourceAsStream("/images/pioggiaelevata.png")));
		icone.add(ImageUtility.getImage(this.getClass().getResourceAsStream("/images/pioggianeve.png")));
		icone.add(ImageUtility.getImage(this.getClass().getResourceAsStream("/images/neve.png")));
		

		// fingiamo di essere il creatore
		PrincipalThreadLocal.setName(bollettino.getUserId());
		PermissionChecker pc = PermissionCheckerFactoryUtil
				.create(UserLocalServiceUtil.fetchUser(bollettino.getUserId()));
		PermissionThreadLocal.setPermissionChecker(pc);

		FileEntry fe = bollettino.getFile("bollettino-" + bollettino.getBollettinoId(), sfondoImageName);

		File trasc = FileUtil.createTempFile(fe.getContentStream());

		ServiceContext sc = new ServiceContext();
		sc.setUserId(bollettino.getUserId());
		sc.setScopeGroupId(scope);
		sc.setCompanyId(bollettino.getCompanyId());

		BufferedImage meteo = ImageUtility.componiImmagine(sfondo, icone, bollettino.getStringaMeteo());
		File f = FileUtil.createTempFile("png");
		ImageUtility.saveImage(meteo, f, "PNG");

		JasperUtils ju = AllertaTracker.getService(JasperUtils.class); 
				//new JasperUtils();
		byte[] report = ju.generateReportBollettino(f.getAbsolutePath(),
				trasc.exists() ? trasc.getAbsolutePath() : null, bollettino.getBollettinoId());
		System.out.println("REPORT: " + (report != null ? report.length : 0));
		// bollettino.setHash(getHash(report));
		// BollettinoLocalServiceUtil.updateBollettino(bollettino);
		BollettinoLocalServiceUtil.eseguiQueryGenerica("update bollettino_bollettino set hash='" + this.getHash(report)
				+ "' where bollettinoid=" + bollettino.getBollettinoId());

		if (report != null && report.length > 0) {
			File f2 = FileUtil.createTempFile(report);

			// FileUtils.writeByteArrayToFile(f2, data);
			BollettinoLocalServiceUtil.fileDeleteByApp(scope, "monitoraggio", "bollettino-" + bollettino.getBollettinoId());
			String idm = "";
			if (bollettino.getNumero() != null)
				idm = bollettino.getNumero().replace("/", "_");
			BollettinoLocalServiceUtil.fileUploadByApp(f2, "bollettino-" + bollettino.getBollettinoId(), "monitoraggio" + idm + ".pdf",
					"Bollettino di monitoraggio", "application/pdf", sc);

			FileUtil.delete(f2);
		}

		FileUtil.delete(f);
		FileUtil.delete(trasc);

		return null;

	}

	*/
	public void ricaricaLivelliOsservati(long id) {
		
		DynamicQuery d = BollettinoSensoreLocalServiceUtil.dynamicQuery()
				.add(PropertyFactoryUtil.forName("idBollettino").eq(id));
		List<BollettinoSensore> bss = BollettinoSensoreLocalServiceUtil.dynamicQuery(d, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		if (bss==null) return;
		
		StazioneManager sm = new StazioneManager();
		for (BollettinoSensore bs : bss) {
			StazioneVariabile s = StazioneVariabileLocalServiceUtil.fetchStazioneVariabile(bs.getIdStazione());
			if (s==null) continue;
			
			DynamicQuery dyn = ValoreSensoreLocalServiceUtil.dynamicQuery()
					.add(PropertyFactoryUtil.forName("idStazione").eq(s.getIdStazione()))
					.add(PropertyFactoryUtil.forName("idVariabile").eq("254,0,0/1,-,-,-/B13215"))
					.addOrder(OrderFactoryUtil.desc("datetime"));
			List<ValoreSensore> sv = ValoreSensoreLocalServiceUtil.dynamicQuery(dyn, 0, 2);

			if (sv.size() > 0) {
				sm.ultimoLivello = sv.get(0).getValue();
				sm.oraUltimoLivello = sm.getOraLivelloOsservato(sv.get(0));
				bs.setOsservazione(sv.get(0).getValue());
				bs.setOreOsservazione(sm.getOraLivelloOsservato(sv.get(0)));
			}
				
			if (sv.size() > 1) {
				sm.penultimoLivello = sv.get(1).getValue();
				int tendenza = -100;
				if (sm.ultimoLivello>sm.penultimoLivello) tendenza = 1;
				else { if (sm.ultimoLivello<sm.penultimoLivello) tendenza = -1; 
				else tendenza = 0; }
				
				if (bs.getTendenza()!=-100) bs.setTendenza(tendenza);
				_log.error("ultimo: "+sm.ultimoLivello+", penultimo="+sm.penultimoLivello+", tend="+tendenza);
			}
			BollettinoSensoreLocalServiceUtil.updateBollettinoSensore(bs);
			
		}

		creaReport(false);

	}

	/*
	 * DA RIVEDERE
	 */
	public void rigeneraNumero() {

		try {
			Calendar c = Calendar.getInstance();
			int anno = c.get(Calendar.YEAR);
			numero = BollettinoLocalServiceUtil.nextIdMonitoraggio(anno);
			if (ultimo)
				numero += "U";
		} catch (Exception ex) {

			_log.error(ex);
		}
	}

	public void rigeneraOra() {

		/*System.out.println("rigeneraOra");

		if (bacinoParam == null)
			return;

		System.out.println(bacinoParam.bac.getNome());

		Date d = null;

		for (StazioneManager s : bacinoParam.stazioni) {

			if (!s.selezionata || s.getUltimoLivello() == null || s.oraUltimoLivello == null)
				continue;

			if (d == null || s.oraUltimoLivello.after(d))
				d = s.oraUltimoLivello;

		}

		if (d == null)
			return;

		bacinoParam.setOre(AllertaKeys.TimeFormat.format(processDate(d)));*/
	}

	public void inviaApprovazione() {
		
		dryRun = false;

		if (bollettino == null)
			return;
		
		if (bollettino.getStato()==0) return;
		if (bollettino.getStato()==1) return;

		boolean reinvio = bollettino.getStato() == WorkflowConstants.STATUS_DENIED;

		bollettino.setStato(WorkflowConstants.STATUS_PENDING);
		salvaBollettino(true);

		preparaUtenteApprovatore();

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		if (reinvio) {

			try {

				WorkflowInstanceLink link = WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(
						bollettino.getCompanyId(), bollettino.getGroupId(), Bollettino.class.getName(),
						bollettino.getBollettinoId());

				WorkflowInstance wi = WorkflowInstanceManagerUtil.getWorkflowInstance(bollettino.getCompanyId(),
						link.getWorkflowInstanceId());

				Map<String, Serializable> wfContext = wi.getWorkflowContext();

				WorkflowInstanceManagerUtil.signalWorkflowInstance(bollettino.getCompanyId(),
						themeDisplay.getRealUserId(), wi.getWorkflowInstanceId(), "resubmit", wfContext);

				Map<String, Serializable> workflowContext = new HashMap<String, Serializable>();
				workflowContext.put(WorkflowConstants.CONTEXT_ENTRY_CLASS_NAME, Bollettino.class.getName());
				workflowContext.put(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK, bollettino.getBollettinoId());
				workflowContext.put(WorkflowConstants.CONTEXT_USER_ID, themeDisplay.getUserId());
				workflowContext.put(WorkflowConstants.CONTEXT_GROUP_ID, themeDisplay.getCompanyGroupId());
				workflowContext.put(WorkflowConstants.CONTEXT_COMPANY_ID, themeDisplay.getCompanyId());
				com.liferay.portal.kernel.workflow.WorkflowStatusManagerUtil.updateStatus(1, workflowContext);

			} catch (Exception ex) {
				ex.printStackTrace();
				//LogInternoLocalServiceUtil.log("BollettinoBean", "inviaApprovazione", ex, "");
			}

		} else {
			try {
//				WorkflowDefinitionLink workflowDefinitionLink = 
//						WorkflowDefinitionLinkLocalServiceUtil.getDefaultWorkflowDefinitionLink(
//						themeDisplay.getCompanyId(), Bollettino.class.getName(), 0, 0);

				ServiceContext sc = ServiceContextFactory.getInstance(
						Bollettino.class.getName(), request);

				// start workflow instance to feedback.
				WorkflowHandlerRegistryUtil.startWorkflowInstance(bollettino.getCompanyId(), bollettino.getGroupId(),
						themeDisplay.getUserId(), Bollettino.class.getName(), 
						bollettino.getPrimaryKey(), bollettino, sc);

			} catch (Exception ex) {

				_log.error(ex);
				//LogInternoLocalServiceUtil.log("BollettinoBean", "inviaApprovazione", ex, "");

				if (ex instanceof NoSuchWorkflowDefinitionLinkException) {
					SessionMessages.add(request, "workflow-not-enabled");
				}
			}
		}

	}

	public String getStato() {

		if (bollettino == null)
			return "Non ancora salvato";
		if (bollettino.getStato() == WorkflowConstants.STATUS_DRAFT)
			return "In lavorazione";
		if (bollettino.getStato() == WorkflowConstants.STATUS_PENDING)
			return "In attesa di approvazione";
		if (bollettino.getStato() == WorkflowConstants.STATUS_APPROVED)
			return "Approvato";
		if (bollettino.getStato() == WorkflowConstants.STATUS_DENIED)
			return "Respinto";

		return "Stato sconosciuto";

	}


	public boolean isMostraInviaApprovazione() {

		if (bollettino == null)
			return false;

		if (bollettino.getStato() != WorkflowConstants.STATUS_DRAFT
				&& bollettino.getStato() != WorkflowConstants.STATUS_DENIED)
			return false;

		return true;

	}

	public boolean isMostraSalva() {

		if (bollettino == null)
			return true;

		if (bollettino.getStato() != WorkflowConstants.STATUS_DRAFT
				&& bollettino.getStato() != WorkflowConstants.STATUS_DENIED)
			return false;

		return true;

	}

	private void riempiBollettino() {

		try {

			List<Bacino> bac = BacinoLocalServiceUtil.getBacinos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			int k = 0;

			bacini = new ArrayList<BacinoManager>();
			for (Bacino b : bac) {

				k++;

				BacinoManager bm = new BacinoManager();
				
				bacini.add(bm);

				bm.bac = b;
				bm.stazioni = new ArrayList<StazioneManager>();

				DynamicQuery dyn = StazioneLocalServiceUtil.dynamicQuery()
						.add(PropertyFactoryUtil.forName("nameBasin").eq(b.getNome()))
						.add(PropertyFactoryUtil.forName("progressivo").gt(0))
						.add(PropertyFactoryUtil.forName("attivo").eq(true))
						.add(PropertyFactoryUtil.forName("incluso").eq(true))
						.addOrder(OrderFactoryUtil.asc("progressivo"));
				List<Stazione> sv = StazioneLocalServiceUtil.dynamicQuery(dyn);

				for (Stazione s : sv) {
					

					dyn = StazioneVariabileLocalServiceUtil.dynamicQuery()
							.add(PropertyFactoryUtil.forName("idStazione").eq(s.getId()))
							.add(PropertyFactoryUtil.forName("idVariabile").eq("254,0,0/1,-,-,-/B13215"));
					List<StazioneVariabile> ssvv = StazioneVariabileLocalServiceUtil.dynamicQuery(dyn);

					if (ssvv.size()==0) continue;
					StazioneManager sm = new StazioneManager();
					bm.stazioni.add(sm);
					sm.parent = bm;
					sm.setStazione(s);
					
					sm.setStazioneVariabile(ssvv.get(0));
				}

			}

			//ricaricaLivelliOsservati();

		} catch (Exception e) {
			_log.error(e);
		}

	}

	private void init() {

		try {

			int count = BacinoLocalServiceUtil.getBacinosCount();

			if (count == 0) {
				
				BacinoLocalServiceUtil.creaBacinoDefault("0114", "TIDONE", 1,
						new String[] { "-/944062,4496427/simnpr", "-/952977,4505668/simnpr" });
				BacinoLocalServiceUtil.creaBacinoDefault("0117", "TREBBIA", 2,
						new String[] { "-/938369,4475510/simnpr", "-/958211,4490039/simnpr" });
				BacinoLocalServiceUtil.creaBacinoDefault("0064", "NURE", 3,
						new String[] { "-/964382,4487378/simnpr", "-/977124,4500949/simnpr" });
				BacinoLocalServiceUtil.creaBacinoDefault("0110", "TARO", 4, new String[] { "-/1009579,4469547/simnpr",
						"-/1022464,4482263/simnpr", "-/1025430,4491689/simnpr" });
				BacinoLocalServiceUtil.creaBacinoDefault("0069", "PARMA", 5,
						new String[] { "-/1032468,4480548/simnpr", "-/1037523,4493058/simnpr" });
				BacinoLocalServiceUtil.creaBacinoDefault("0036", "ENZA", 6, new String[] { "-/1035510,4453261/simnpr",
						"-/1044642,4472830/simnpr", "-/1045405,4484397/simnpr" });
				BacinoLocalServiceUtil.creaBacinoDefault("0031", "CROSTOLO", 7, new String[] { "-/1059917,4465546/simnpr",
						"-/1058119,4477880/simnpr", "-/1063976,4485363/simnpr" });
				BacinoLocalServiceUtil.creaBacinoDefault("0101", "SECCHIA", 8,
						new String[] { "-/1077079,4454859/simnpr", "-/1079554,4465039/simnpr",
								"-/1081495,4465855/simnpr", "-/1089934,4466967/simnpr", "-/1098734,4474755/simnpr",
								"-/1096490,4485676/simnpr", "-/1098334,4491082/simnpr" });
				BacinoLocalServiceUtil.creaBacinoDefault("0068", "PANARO", 9,
						new String[] { "-/1103000,4453398/simnpr", "-/1100948,4460693/simnpr",
								"-/1099703,4462283/simnpr", "-/1099531,4466995/simnpr", "-/1104508,4472716/simnpr",
								"-/1113509,4478670/simnpr", "-/1128766,4482459/simnbo" });
				BacinoLocalServiceUtil.creaBacinoDefault("0094", "SAMOGGIA", 10,
						new String[] { "-/1113301,4454736/simnbo", "-/1123027,4458426/simnbo" });
				BacinoLocalServiceUtil.creaBacinoDefault("0086", "RENO", 11,
						new String[] { "-/1111313,4428780/simnbo", "-/1128243,4447318/simnbo",
								"-/1131382,4460927/simnbo", "-/1127237,4466547/simnbo", "-/1129579,4472121/simnbo",
								"-/1134978,4476419/simnbo", "-/1136893,4477849/simnbo", "-/1154538,4472410/simnbo",
								"-/1162513,4467307/simnbo", "-/1184727,4459196/simnbo", "-/1187520,4457745/simnbo" });
				BacinoLocalServiceUtil.creaBacinoDefault("0044", "IDICE", 12, new String[] { "-/1136519,4445378/simnbo",
						"-/1147017,4450748/simnbo", "-/1159537,4457810/simnbo", "-/1170609,4457480/simnbo" });
				BacinoLocalServiceUtil.creaBacinoDefault("0107", "SILLARO", 13, new String[] { "-/1158841,4438103/simnbo",
						"-/1173595,4445876/simnbo", "-/1176422,4452811/simnbo" });
				BacinoLocalServiceUtil.creaBacinoDefault("0095", "SANTERNO", 14, new String[] { "-/1171292,4434535/simnbo",
						"-/1181481,4439378/simnbo", "-/1186575,4443880/simnbo", "-/1188402,4451584/simnbo" });
				BacinoLocalServiceUtil.creaBacinoDefault("0103", "SENIO", 15, new String[] { "-/1182482,4431006/simnbo",
						"-/1194246,4438305/simnbo", "-/1196830,4446538/simnbo", "-/1204777,4450393/simnbo" });
				BacinoLocalServiceUtil.creaBacinoDefault("0047", "LAMONE", 16,
						new String[] { "-/1182146,4424466/spdsra", "-/1189148,4428688/spdsra",
								"-/1194276,4430650/spdsra", "-/1196682,4433147/spdsra", "-/1208286,4446959/spdsra" });
				BacinoLocalServiceUtil.creaBacinoDefault("0060", "MONTONE", 17,
						new String[] { "-/1202757,4422698/spdsra", "-/1199295,4426279/spdsra",
								"-/1203134,4433002/spdsra", "-/1216847,4438896/spdsra", "-/1227311,4439398/spdsra" });
				BacinoLocalServiceUtil.creaBacinoDefault("0090", "RONCO", 18, new String[] { "-/1206155,4412146/spdsra",
						"-/1208668,4420306/spdsra", "-/1211085,4429769/spdsra", "-/1217268,4436791/spdsra" });
				BacinoLocalServiceUtil.creaBacinoDefault("0098", "SAVIO", 19,
						new String[] { "-/1219984,4409098/spdsra", "-/1223505,4413971/spdsra",
								"-/1223401,4423218/spdsra", "-/1226090,4425901/spdsra", "-/1229549,4430563/spdsra" });
				BacinoLocalServiceUtil.creaBacinoDefault("0057", "MARECCHIA", 20, new String[] { "-/1240581,4398105/simnbo",
						"-/1254549,4405651/simnbo", "-/1254197,4406141/simnbo" });

			}
			
			
		} catch (Exception e) {
			_log.error(e);
		}

	}

	public void initFromRequest() {
		
		if (this.request != null) {
			
			this.dataInizio  = ParamUtil.getDate(request, "dataInizio", AllertaKeys.WebDateTimeFormat);
			this.dataFine  = ParamUtil.getDate(request, "dataFine", AllertaKeys.WebDateTimeFormat);
			this.numero = ParamUtil.getString(request, "numero");
			this.noteMeteo = ParamUtil.getString(request, "noteMeteo");
			this.stringaMeteo = ParamUtil.getString(request, "testoMeteo");
			this.bollettinoId = ParamUtil.getLong(request, "bollettinoId");
			this.approvatoreArpae = ParamUtil.getString(request, "elencoApprovatori");
			
			initGriglia();
		}
		
		
	}

	public void initFromBean() {
		
		this.dataInizio  = this.bollettino.getDataInizio();
		this.dataFine  = this.bollettino.getDataFine();
		this.numero = this.bollettino.getNumero();
		this.noteMeteo = this.bollettino.getNoteMeteo();
		this.stringaMeteo = this.bollettino.getStringaMeteo();
		this.approvatoreArpae =  String.valueOf( this.bollettino.getIdApprovatore());
		this.ultimo = this.bollettino.getUltimo();
		
	
	}

	public void salvaBollettino( boolean readFromRequest) {
		
		dryRun = false; 
		if( readFromRequest)
			initFromRequest();
		
		salvaBollettino();
		
	}
	
	public void createBollettino( ThemeDisplay themeDisplay, ServiceContext sc ) {
		
		long inc = CounterLocalServiceUtil.increment(Bollettino.class.getName());
		
		bollettino = BollettinoLocalServiceUtil.createBollettino(inc);
		this.bollettinoId = inc;
		
		bollettino.setCreateDate(new Date());
		bollettino.setUserId(themeDisplay.getRealUserId());
		bollettino.setGroupId(themeDisplay.getScopeGroupId());
		bollettino.setUserName(themeDisplay.getRealUser().getFullName());
		bollettino.setCompanyId(themeDisplay.getCompanyId());
		bollettino.setStato(WorkflowConstants.STATUS_DRAFT);
		
		rigeneraNumero();
		
		bollettino.setNumero(numero);
		
		if (!dryRun) BollettinoLocalServiceUtil.updateBollettino(bollettino);

		if (!dryRun) createFolder("bollettino-" + inc, "File per bollettino " + inc, sc);
		
		if( this.bacini.size() == 0)
			this.riempiBollettino();
		
		

		for (BacinoManager bb : this.bacini) {

			inc = CounterLocalServiceUtil.increment(BollettinoBacino.class.getName());
			//this.bollettinoId = inc;
			bb.bacino = BollettinoBacinoLocalServiceUtil.createBollettinoBacino(inc);
			bb.bacino.setIdBacino(bb.bac.getId());
			bb.bacino.setIdBollettino(bollettino.getBollettinoId());
			bb.bacino.setNomeBacino(bb.bac.getNome());
			bb.bacino.setProgressivo(bb.bac.getProgressivo());
			
			if (!dryRun) BollettinoBacinoLocalServiceUtil.updateBollettinoBacino(bb.bacino);

			for (StazioneManager sm : bb.stazioni) {
				
				if (sm.stazioneVariabile==null) continue;

				inc = CounterLocalServiceUtil.increment(BollettinoSensore.class.getName());
				sm.sensore = BollettinoSensoreLocalServiceUtil.createBollettinoSensore(inc);
				sm.sensore.setIdBollettino(bollettino.getBollettinoId());
				sm.sensore.setIdBollettinoBacino(bb.bacino.getId());
				sm.sensore.setIdStazione(sm.stazioneVariabile.getId());
				sm.sensore.setColmoPrevisto(sm.getLivelloPrevisto());
				sm.sensore.setNomeStazione(sm.stazione.getName());
				sm.sensore.setProgressivo(sm.stazione.getProgressivo());
				sm.sensore.setSoglia1(sm.stazioneVariabile.getSoglia1());
				sm.sensore.setSoglia2(sm.stazioneVariabile.getSoglia2());
				sm.sensore.setSoglia3(sm.stazioneVariabile.getSoglia3());
				sm.sensore.setOraPrevista(null);
				sm.sensore.setGiornoPrevisto(null);
				sm.sensore.setTendenza(-100);
				sm.selezionata = false;
				
				// ricarica gli ultimi due valori osservati (il penultimo serve per la tendenza)
				DynamicQuery dyn = ValoreSensoreLocalServiceUtil.dynamicQuery()
						.add(PropertyFactoryUtil.forName("idStazione").eq(sm.stazione.getId()))
						.add(PropertyFactoryUtil.forName("idVariabile").eq("254,0,0/1,-,-,-/B13215"))
						.addOrder(OrderFactoryUtil.desc("datetime"));
				List<ValoreSensore> sv = ValoreSensoreLocalServiceUtil.dynamicQuery(dyn, 0, 2);

				if (sv.size() > 0) {
					sm.ultimoLivello = sv.get(0).getValue();
					sm.sensore.setOsservazione(sm.ultimoLivello);
					sm.oraUltimoLivello = sm.getOraLivelloOsservato(sv.get(0));
					sm.sensore.setOreOsservazione(sm.oraUltimoLivello);
				}
				if (sv.size() > 1)
					sm.penultimoLivello = sv.get(1).getValue();
				sm.setTendenza(sm.calcolaTendenza());
				String ten = sm.getTendenza();
				int tendenza = -100;
				if (ten.equals("+"))
					tendenza = 1;
				else if (ten.equals("-"))
					tendenza = -1;
				else if (ten.equals("="))
					tendenza = 0;
				else
					tendenza = 2;
				sm.sensore.setTendenza(tendenza);
				
				if (!dryRun) BollettinoSensoreLocalServiceUtil.updateBollettinoSensore(sm.sensore);

			}

		}
		
		if (!dryRun) copiaColmiOsservati();

	}
	
	public void createBollettino2( ThemeDisplay themeDisplay, ServiceContext sc ) {
		
		long inc = CounterLocalServiceUtil.increment(Bollettino.class.getName());
		
		bollettino = BollettinoLocalServiceUtil.createBollettino(inc);
		this.bollettinoId = inc;
		
		bollettino.setCreateDate(new Date());
		bollettino.setUserId(themeDisplay.getRealUserId());
		bollettino.setGroupId(themeDisplay.getScopeGroupId());
		bollettino.setUserName(themeDisplay.getRealUser().getFullName());
		bollettino.setCompanyId(themeDisplay.getCompanyId());
		bollettino.setStato(WorkflowConstants.STATUS_DRAFT);
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.HOUR, 1);
		bollettino.setDataInizio(cal.getTime());
		cal.add(Calendar.HOUR, 6);
		bollettino.setDataFine(cal.getTime());
		
		rigeneraNumero();
		
		bollettino.setNumero(numero);
		bollettino.setIdApprovatore(20198);
		
		BollettinoLocalServiceUtil.updateBollettino(bollettino);

		createFolder("bollettino-" + inc, "File per bollettino " + inc, sc);
		
		this.bacini = new ArrayList<BacinoManager>();
		this.riempiBollettino();
		
		

		for (BacinoManager bb : this.bacini) {

			inc = CounterLocalServiceUtil.increment(BollettinoBacino.class.getName());
			//this.bollettinoId = inc;
			bb.bacino = BollettinoBacinoLocalServiceUtil.createBollettinoBacino(inc);
			bb.bacino.setIdBacino(bb.bac.getId());
			bb.bacino.setIdBollettino(bollettino.getBollettinoId());
			bb.bacino.setNomeBacino(bb.bac.getNome());
			bb.bacino.setProgressivo(bb.bac.getProgressivo());
			
			BollettinoBacinoLocalServiceUtil.updateBollettinoBacino(bb.bacino);

			for (StazioneManager sm : bb.stazioni) {
				
				if (sm.stazioneVariabile==null) continue;

				inc = CounterLocalServiceUtil.increment(BollettinoSensore.class.getName());
				sm.sensore = BollettinoSensoreLocalServiceUtil.createBollettinoSensore(inc);
				sm.sensore.setIdBollettino(bollettino.getBollettinoId());
				sm.sensore.setIdBollettinoBacino(bb.bacino.getId());
				sm.sensore.setIdStazione(sm.stazioneVariabile.getId());
				sm.sensore.setColmoPrevisto(sm.getLivelloPrevisto());
				sm.sensore.setNomeStazione(sm.stazione.getName());
				sm.sensore.setProgressivo(sm.stazione.getProgressivo());
				sm.sensore.setSoglia1(sm.stazioneVariabile.getSoglia1());
				sm.sensore.setSoglia2(sm.stazioneVariabile.getSoglia2());
				sm.sensore.setSoglia3(sm.stazioneVariabile.getSoglia3());
				sm.sensore.setOraPrevista(null);
				sm.sensore.setGiornoPrevisto(null);
				sm.sensore.setTendenza(-100);
				sm.selezionata = false;
				
				// ricarica gli ultimi due valori osservati (il penultimo serve per la tendenza)
				DynamicQuery dyn = ValoreSensoreLocalServiceUtil.dynamicQuery()
						.add(PropertyFactoryUtil.forName("idStazione").eq(sm.stazione.getId()))
						.add(PropertyFactoryUtil.forName("idVariabile").eq("254,0,0/1,-,-,-/B13215"))
						.addOrder(OrderFactoryUtil.desc("datetime"));
				List<ValoreSensore> sv = ValoreSensoreLocalServiceUtil.dynamicQuery(dyn, 0, 2);

				if (sv.size() > 0) {
					sm.ultimoLivello = sv.get(0).getValue();
					sm.sensore.setOsservazione(sm.ultimoLivello);
					sm.oraUltimoLivello = sm.getOraLivelloOsservato(sv.get(0));
					sm.sensore.setOreOsservazione(sm.oraUltimoLivello);
				}
				if (sv.size() > 1)
					sm.penultimoLivello = sv.get(1).getValue();
				sm.setTendenza(sm.calcolaTendenza());
				/*String ten = sm.getTendenza();
				int tendenza = -100;
				if (ten.equals("+"))
					tendenza = 1;
				else if (ten.equals("-"))
					tendenza = -1;
				else if (ten.equals("="))
					tendenza = 0;
				else
					tendenza = 0;*/
				sm.sensore.setTendenza(-100);
				
				BollettinoSensoreLocalServiceUtil.updateBollettinoSensore(sm.sensore);

			}

		}
		
		List<Object> l = BollettinoLocalServiceUtil.eseguiQueryGenericaLista(queryUltimoPubblicato);
		if (l!=null && l.size()>0) {
			Object[] o = (Object[])l.get(0);
			if (o==null || o[0]==null || o[1]==null) return;
			String nome = o[1].toString().toUpperCase().trim();
			if (nome.endsWith("U") || nome.endsWith("ULTIMO")) {
				return;
			}
			String q = queryCopiaColmiOsservati.replaceAll("IDB", o[0].toString());
			q = q.replaceAll("IDN", ""+bollettino.getBollettinoId());
			BollettinoLocalServiceUtil.eseguiQueryGenerica(q);
			
			q = queryCopiaNote.replaceAll("IDB", o[0].toString());
			q = q.replaceAll("IDN", ""+bollettino.getBollettinoId());
			BollettinoLocalServiceUtil.eseguiQueryGenerica(q);
		}

	}
	
	public void salvaBollettino() {

		if (bollettino != null && (bollettino.getStato() == WorkflowConstants.STATUS_APPROVED) ) {
			//			|| bollettino.getStato() == WorkflowConstants.STATUS_DENIED)
			return;
		}

		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			boolean nuovo = false;
			
			ServiceContext sc = ServiceContextFactory.getInstance(Bollettino.class.getName(), request);
			
		
			if (bollettino == null) {
				nuovo = true;
				createBollettino(themeDisplay, sc);	
			} 
			
			bollettino.setNoteMeteo(this.noteMeteo);
			bollettino.setNumero(this.numero);
			bollettino.setDataInizio(dataInizio);
			bollettino.setDataFine(dataFine);
			bollettino.setStringaMeteo(stringaMeteo);
			bollettino.setUltimo(ultimo);
			bollettino.setIdApprovatore(Long.parseLong(approvatoreArpae));

			bollettino.setUserId(themeDisplay.getRealUserId());
			bollettino.setGroupId(themeDisplay.getScopeGroupId());
			bollettino.setUserName(themeDisplay.getRealUser().getFullName());
			bollettino.setCompanyId(themeDisplay.getCompanyId());
			bollettino.setModifiedDate(new Date());

			if (!dryRun) BollettinoLocalServiceUtil.updateBollettino(bollettino);

			// if (nuovo) {

			if (bollettino != null && !dryRun) {
				
				this.bollettinoId = bollettino.getBollettinoId();
				
				// add feedback asset in asset entry table
				AssetEntryLocalServiceUtil.updateEntry(themeDisplay.getUserId(), bollettino.getGroupId(),
						Bollettino.class.getName(), bollettino.getBollettinoId(), sc.getAssetCategoryIds(),
						sc.getAssetTagNames());

				if (bollettino.getStato() == WorkflowConstants.STATUS_DRAFT) {
					
					AssetEntry ae = AssetEntryLocalServiceUtil
							.getEntry(Bollettino.class.getName(), bollettino.getBollettinoId());
					try {
						ae.setTitle("Documento di monitoraggio "+bollettino.getNumero());
						ae.setDescription(bollettino.getNoteMeteo());
						if (ae.getCreateDate()==null) ae.setCreateDate(new Date());
						ae.setModifiedDate(new Date());
						ae.setSummary("Documento di monitoraggio "+bollettino.getNumero());
						AssetEntryLocalServiceUtil.updateAssetEntry(ae);
					} catch (Exception ee) {
						_log.error(ee);
					}
					
					long id = ae.getEntryId();
					List<AssetCategory> c = AssetCategoryLocalServiceUtil.getCategories();
					for (AssetCategory ac : c) {
						if (ac.getName().equals("monitoraggio-lavorazione")) {
							AssetCategoryLocalServiceUtil.addAssetEntryAssetCategory(id, ac);
							break;
						}
					}
				}

			}

			// }

			// if (bollettino.getBollettinoId()==0)
			// bollettino =
			// BollettinoLocalServiceUtil.fetchBollettinoByUuidAndCompanyId(bollettino.getUuid(),
			// bollettino.getCompanyId());
			
			for (BacinoManager bb : this.bacini) {

				bb.selezionato = false;
				for (StazioneManager sm : bb.stazioni) {
					if (sm.selezionata)
						bb.selezionato = true;
				}

				// genera automaticamente l'ora di osservazione
				if (bb.selezionato && bb.getOre() == null) {
					bacinoParam = bb;
					rigeneraOra();
				}

				bb.bacino.setIdBollettino(bollettino.getBollettinoId());
				//leggo dalla Request
				bb.bacino.setNote(bb.getNote());
				bb.bacino.setOreOsservazione(bb.getOre());
				bb.bacino.setIdBollettino(bollettino.getBollettinoId());
				if (!dryRun) BollettinoBacinoLocalServiceUtil.updateBollettinoBacino(bb.bacino);

				for (StazioneManager sm : bb.stazioni) {

					sm.sensore.setIdBollettino(bollettino.getBollettinoId());
					sm.sensore.setIdBollettinoBacino(bb.bacino.getPrimaryKey());
					sm.sensore.setNomeStazione(sm.stazione.getName());
					if (sm.stazioneVariabile!=null) {
					sm.sensore.setSoglia1(sm.stazioneVariabile.getSoglia1());
					sm.sensore.setSoglia2(sm.stazioneVariabile.getSoglia2());
					sm.sensore.setSoglia3(sm.stazioneVariabile.getSoglia3());
					} else 
					{
						try {
							
							DynamicQuery dyn = StazioneVariabileLocalServiceUtil.dynamicQuery()
									.add(PropertyFactoryUtil.forName("idStazione").eq(sm.stazione.getId()))
									.add(PropertyFactoryUtil.forName("idVariabile").eq("254,0,0/1,-,-,-/B13215"));
							List<StazioneVariabile> ssvv = StazioneVariabileLocalServiceUtil.dynamicQuery(dyn);

							if (ssvv.size() > 0)
								sm.stazioneVariabile = ssvv.get(0);
							
							if (sm.stazioneVariabile!=null) {
								sm.sensore.setSoglia1(sm.stazioneVariabile.getSoglia1());
								sm.sensore.setSoglia2(sm.stazioneVariabile.getSoglia2());
								sm.sensore.setSoglia3(sm.stazioneVariabile.getSoglia3());
							}
							
						} catch (Exception ee) {
							LogInternoLocalServiceUtil.log("salvaBollettino", "", ee, "");
						}
					}
					
					if( !sm.selezionata) {
						
						sm.sensore.setOraPrevista("");
						sm.sensore.setGiornoPrevisto("");
						sm.sensore.setColmoPrevisto("");
						sm.sensore.setOsservato(false);
						sm.sensore.setTendenza(-100);
					}
					
					/*
					li leggo dalla Request - sempre
					sm.sensore.setColmoPrevisto(sm.getLivelloPrevisto());
					sm.sensore.setOraPrevista(sm.oraPrevista);
					sm.sensore.setGiornoPrevisto(sm.giornoPrevisto);
					sm.sensore.setOsservazione(sm.ultimoLivello != null ? sm.ultimoLivello.getValue() : 0.0);
					sm.sensore.setOreOsservazione(sm.ultimoLivello != null
							? AllertaKeys.TimeFormat.format(processDate(sm.ultimoLivello.getDatetime()))
							: null);

					int tendenza = -100;
					if (sm.isSelezionata()) {
						String ten = sm.getTendenza();
						if (ten.equals("+"))
							tendenza = 1;
						else if (ten.equals("-"))
							tendenza = -1;
						else if (ten.equals("="))
							tendenza = 0;
						else
							tendenza = 2;
					}

					sm.sensore.setTendenza(tendenza);
					*/

					if (!dryRun) BollettinoSensoreLocalServiceUtil.updateBollettinoSensore(sm.sensore);

				}
			}

			
			creaReport(nuovo);

		} catch (Exception ex) {
			_log.error(ex);
			//LogInternoLocalServiceUtil.log("BollettinoBean", "salvaBollettino", ex, "");
		}
	}
	
	public void creaReport(boolean nuovo) {
		
		if (dryRun || !creaRep) return;
		
		try {
			ServiceContext serviceContext;
			if (request!=null) 
				serviceContext = ServiceContextFactory.getInstance(Bollettino.class.getName(), request);
			else {
				serviceContext = new ServiceContext();
				serviceContext.setUserId(bollettino.getUserId());
				serviceContext.setCompanyId(bollettino.getCompanyId());
				serviceContext.setScopeGroupId(bollettino.getGroupId());
			}
			//ServiceContext serviceContext = ServiceContextFactory.getInstance(Bollettino.class.getName(),
			//		request);
			
			File trascinata = new File(pathImmagine);

			// metti l'immagine del meteo nella directory, per darla a Jasper
			if (!nuovo) {
				// cancella i file esistenti
				// fileDeleteByApp("meteo.png", "bollettino-"+bollettino.getBollettinoId(),
				// themeDisplay, req2);
				BollettinoLocalServiceUtil.fileDeleteByApp(serviceContext.getScopeGroupId(),
						"monitoraggio", "bollettino-" + bollettino.getBollettinoId());
			}

			if (trascinata.exists()) {
				if (!nuovo)
					BollettinoLocalServiceUtil.fileDeleteByApp(serviceContext.getScopeGroupId(), 
							sfondoImageName, "bollettino-" + bollettino.getBollettinoId());
				
				BollettinoLocalServiceUtil.fileUploadByApp(
						trascinata, "bollettino-" + bollettino.getBollettinoId(), sfondoImageName,
						"Trascinata piogge ultime 6 ore", "image/png", serviceContext);
				

			}
			

			BufferedImage meteo = ImageUtility.componiImmagine(sfondo, icone, bollettino.getStringaMeteo());
			File f = FileUtil.createTempFile("png");
			ImageUtility.saveImage(meteo, f, "PNG");
			// fileUploadByApp(f, "bollettino-"+bollettino.getBollettinoId(), "meteo.png",
			// "Meteo", "image/png", themeDisplay, req2);

			// String meteoLink = getFileLink(themeDisplay,
			// "bollettino-"+bollettino.getBollettinoId(), "meteo.png");

			// System.out.println("LINK PNG METEO: "+meteoLink);

			JasperUtils ju = AllertaTracker.getService(JasperUtils.class); 
			//new JasperUtils();
			byte[] report = 
						ju.generateReportBollettino(f.getAbsolutePath(),
													trascinata.exists() ? trascinata.getAbsolutePath() : null, 
													bollettino.getBollettinoId()
						);

			bollettino.setHash(getHash(report));
			BollettinoLocalServiceUtil.updateBollettino(bollettino);
	
			System.out.println("REPORT: " + (report != null ? report.length : 0));
			if (report != null && report.length > 0) {
				File f2 = FileUtil.createTempFile(report);

				// FileUtils.writeByteArrayToFile(f2, data);
				String idm = "";
				if (bollettino.getNumero() != null)
					idm = bollettino.getNumero().replace("/", "_");
				BollettinoLocalServiceUtil.fileUploadByApp(f2, "bollettino-" + bollettino.getBollettinoId(), "monitoraggio" + idm + ".pdf",
						"Documento di monitoraggio", "application/pdf", serviceContext);

				String pdfLink = bollettino.getFileLinkRelative("bollettino-" + bollettino.getBollettinoId(),
						"monitoraggio");

				System.out.println("LINK PDF: " + pdfLink);

				bollettino.setLink(pdfLink);
				BollettinoLocalServiceUtil.updateBollettino(bollettino);

				FileUtil.delete(f2);
			}

			FileUtil.delete(f);
	
		} catch (Exception e) {
			_log.error(e);
			//LogInternoLocalServiceUtil.log("BollettinoBean", "creaReport", e, "");
		}
	}

	public Bollettino getBollettino() {
		return bollettino;
	}

	public void setBollettino(Bollettino bollettino) {
		this.bollettino = bollettino;
	}

	public List<BacinoManager> getBacini() {
		return bacini;
	}

	public void setBacini(List<BacinoManager> bacini) {
		this.bacini = bacini;
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
	
	public String getDataInizioString() {

		if (dataInizio==null) return "";
		return AllertaKeys.WebDateTimeFormat.format(dataInizio);
		
	}
	
	public String getDataFineString() {
		
		if (dataFine==null) return "";
		return AllertaKeys.WebDateTimeFormat.format(dataFine);
		
	}
	

	public String getStringaMeteo() {
		return stringaMeteo;
	}

	public void setStringaMeteo(String stringaMeteo) {
		this.stringaMeteo = stringaMeteo;
	}

	public String getNoteMeteo() {
		return noteMeteo;
	}

	public void setNoteMeteo(String noteMeteo) {
		this.noteMeteo = noteMeteo;
	}

	public String getNumero() {
		if (Validator.isNull(numero)) {
			rigeneraNumero();
		}
		
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Folder createFolder(String name, String description, ServiceContext serviceContext) {
		
		long repositoryId = serviceContext.getScopeGroupId();// repository id is same as groupId
		long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID; // or 0

		try {
			BollettinoParametro ap = BollettinoParametroLocalServiceUtil
					.fetchBollettinoParametro("BOLLETTINO_PARENT_FOLDER_ID");
			if (ap != null)
				parentFolderId = Long.parseLong(ap.getValore());
		} catch (Exception e) {
		}

		try {
			ServiceContext dlServiceContext = ServiceContextFactory.getInstance(
					DLFolder.class.getName(), request);
			Folder folder = DLAppServiceUtil.addFolder(repositoryId, parentFolderId, name, 
					description, dlServiceContext);

			Role guestRole = RoleLocalServiceUtil.getRole(serviceContext.getCompanyId(), 
					RoleConstants.GUEST);
			ResourcePermissionLocalServiceUtil.setResourcePermissions(serviceContext.getCompanyId(),
					DLFolder.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(folder.getFolderId()),
					guestRole.getRoleId(), new String[] { "VIEW" });

			BollettinoParametro ap = BollettinoParametroLocalServiceUtil
					.fetchBollettinoParametro("BOLLETTINO_RUOLI_MODIFICA_LINK");
			if (ap != null && ap.getValore() != null && !ap.getValore().equals("")) {
				String[] ruoli = ap.getValore().split(",");
				for (String s : ruoli) {
					long l = Long.parseLong(s);
					ResourcePermissionLocalServiceUtil.setResourcePermissions(
							serviceContext.getCompanyId(),
							DLFolder.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
							String.valueOf(folder.getFolderId()), l,
							new String[] { "VIEW", "UPDATE", "DELETE", "ADD_DOCUMENT" });
				}
			}

			return folder;
		} catch (PortalException e1) {
			e1.printStackTrace();
			return null;
		} catch (SystemException e1) {
			e1.printStackTrace();
			return null;
		}
	}

//	public void createDLFolder(RenderRequest renderRequest, ThemeDisplay themeDisplay, String folderName,
//			String description) {
//		long userId = themeDisplay.getUserId();
//		long groupId = themeDisplay.getScopeGroupId();
//		long repositoryId = themeDisplay.getScopeGroupId();// repository id is same as groupId
//		boolean mountPoint = false; // mountPoint which is a boolean specifying whether the folder is a facade for
//									// mounting a third-party repository
//		long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID; // or 0
//
//		try {
//			BollettinoParametro ap = BollettinoParametroLocalServiceUtil
//					.fetchBollettinoParametro("BOLLETTINO_PARENT_FOLDER_ID");
//			if (ap != null)
//				parentFolderId = Long.parseLong(ap.getValore());
//		} catch (Exception e) {
//		}
//
//		boolean hidden = false; // true if you want to hidden the folder
//		try {
//			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), renderRequest);
//			DLFolderLocalServiceUtil.addFolder(userId, groupId, repositoryId, mountPoint, parentFolderId, folderName,
//					description, hidden, serviceContext);
//		} catch (PortalException e1) {
//			e1.printStackTrace();
//		} catch (SystemException e1) {
//			e1.printStackTrace();
//		}
//	}

//	public void fileUploadByApp(File file, String folderName, String title, String description, String mimeType,
//			ThemeDisplay themeDisplay) {
//		
//		System.out.println("Exist=>" + file.exists());
//		long repositoryId = themeDisplay.getScopeGroupId();
//		// String mimeType = MimeTypesUtil.getContentType(file);
//		// String title = file.getName();
//		// String description = "This file is added via programatically";
//		String changeLog = "hi";
//		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
//
//		try {
//			BollettinoParametro ap = BollettinoParametroLocalServiceUtil
//					.fetchBollettinoParametro("BOLLETTINO_PARENT_FOLDER_ID");
//			if (ap != null)
//				parentFolderId = Long.parseLong(ap.getValore());
//		} catch (Exception e) {
//		}
//
//		try {
//			Folder folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolderId, folderName);
//			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
//					request);
//			InputStream is = new FileInputStream(file);
//			FileEntry f = DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), file.getName(), mimeType,
//					title, description, changeLog, is, file.length(), serviceContext);
//
//			Role guestRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.GUEST);
//			ResourcePermissionLocalServiceUtil.setResourcePermissions(themeDisplay.getCompanyId(),
//					DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(f.getFileEntryId()),
//					guestRole.getRoleId(), new String[] { "VIEW" });
//
//			BollettinoParametro ap = BollettinoParametroLocalServiceUtil
//					.fetchBollettinoParametro("BOLLETTINO_RUOLI_MODIFICA_LINK");
//			if (ap != null && ap.getValore() != null && !ap.getValore().equals("")) {
//				String[] ruoli = ap.getValore().split(",");
//				for (String s : ruoli) {
//					long l = Long.parseLong(s);
//					ResourcePermissionLocalServiceUtil.setResourcePermissions(themeDisplay.getCompanyId(),
//							DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
//							String.valueOf(f.getFileEntryId()), l, new String[] { "VIEW", "UPDATE", "DELETE" });
//				}
//			}
//
//		} catch (Exception e) {
//			//LogInternoLocalServiceUtil.log("BollettinoBean", "fileUploadByApp", e, "");
//		}
//	}

	

	

//Get All Files which are even in draft
//	public String getAllDLFileLink(ThemeDisplay themeDisplay, String folderName, String fileName) {
//
//		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
//
//		try {
//			BollettinoParametro ap = BollettinoParametroLocalServiceUtil
//					.fetchBollettinoParametro("BOLLETTINO_PARENT_FOLDER_ID");
//			if (ap != null)
//				parentFolderId = Long.parseLong(ap.getValore());
//		} catch (Exception e) {
//		}
//
//		try {
//			Folder folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolderId, folderName);
//			List<DLFileEntry> dlFileEntries = DLFileEntryLocalServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(),
//					folder.getFolderId());
//			for (DLFileEntry file : dlFileEntries) {
//				String url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
//						+ themeDisplay.getScopeGroupId() + "/" + file.getFolderId() + "/" + file.getTitle();
//				//System.out.println("DL Link=>" + url);
//				if (file.getTitle().equals(fileName))
//					return url;
//			}
//			return null;
//		} catch (Exception e) {
//			_log.error(e);
//			return null;
//		}
//
//	}

	public String getUrl() {

		if (bollettino != null) {

			return bollettino.getFileLink("bollettino-" + bollettino.getBollettinoId(), 
					"monitoraggio");
		}
		
		return null;
	}


	
	
	public boolean isUltimo() {
		return ultimo;
	}

	public void setUltimo(boolean ultimo) {
		this.ultimo = ultimo;
	}

	public void preparaUtenteApprovatore() {

		try {

			String id = "Approvatore_Arpae";

			BollettinoParametro bp = BollettinoParametroLocalServiceUtil
					.fetchBollettinoParametro("RUOLO_VERI_APPROVATORI");
			if (bp != null)
				id = bp.getValore();

			String id2 = "Approvatore_Arpae";

			BollettinoParametro bp2 = BollettinoParametroLocalServiceUtil
					.fetchBollettinoParametro("RUOLO_POTENZIALI_APPROVATORI");
			if (bp2 != null)
				id2 = bp2.getValore();

			if (id.equals(id2))
				return;

			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			Role r = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), id);

			List<User> utenti = UserLocalServiceUtil.getRoleUsers(r.getRoleId());

			// svuotiamo questo ruolo e mettiamo solo l'utente selezionato

			for (User u : utenti) {
				RoleLocalServiceUtil.deleteUserRole(u.getUserId(), r.getRoleId());
			}

			RoleLocalServiceUtil.addUserRole(Long.parseLong(approvatoreArpae), r.getRoleId());

		} catch (Exception e) {
			_log.error(e);
			//LogInternoLocalServiceUtil.log("BollettinoBean", "preparaUtenteApprovatore", e, "");
		}
	}

	public List<SelectItem> getListaApprovatoriArpae(ThemeDisplay themeDisplay) {

		if (listaApprovatoriArpae == null) {

			try {

				String id = "Approvatore_Arpae";

				BollettinoParametro bp = BollettinoParametroLocalServiceUtil
						.fetchBollettinoParametro("RUOLO_POTENZIALI_APPROVATORI");
				if (bp != null)
					id = bp.getValore();

				Role r = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), id);

				List<User> utenti = UserLocalServiceUtil.getRoleUsers(r.getRoleId());

				listaApprovatoriArpae = new ArrayList<SelectItem>();

				for (User u : utenti) {
					listaApprovatoriArpae
							.add(new SelectItem("" + u.getUserId(), u.getLastName() + " " + u.getFirstName()));
					if (approvatoreArpae == null)
						approvatoreArpae = "" + u.getUserId();
				}

			} catch (Exception e) {
				_log.error(e);
				//LogInternoLocalServiceUtil.log("BollettinoBean", "getListaApprovatoriArpae", e, "");
			}

		}

		return listaApprovatoriArpae;
	}

	public void setListaApprovatoriArpae(List<SelectItem> listaApprovatoriArpae) {
		this.listaApprovatoriArpae = listaApprovatoriArpae;
	}

	public String getApprovatoreArpae() {
		return approvatoreArpae;
	}

	public void setApprovatoreArpae(String approvatoreArpae) {
		this.approvatoreArpae = approvatoreArpae;
	}

	public BacinoManager getBacinoParam() {
		return bacinoParam;
	}

	public void setBacinoParam(BacinoManager bacinoParam) {
		this.bacinoParam = bacinoParam;
	}

	public static byte[] hexStringToByteArray(String s) {
		int len = s.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
		}
		return data;
	}

	public Date processDate(Date d) {
		if (d == null)
			return null;
		long l = d.getTime();
		if (oraLegale)
			l += 7200000;
		else
			l += 3600000;
		return new Date(l);
	}

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
			_log.error(e);
			return "";
		}
		return hexString.toString();

	}
	
	

	public long getBollettinoId() {
		return bollettinoId;
	}

	public void setBollettinoId(long bollettinoId) {
		this.bollettinoId = bollettinoId;
	}


	public String getDataImage() {
		
		String content = "";
		
		try {
			
			content = "data:image/png;base64,";
			
			FileInputStream fis = new FileInputStream(pathImmagine);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			StreamUtil.transfer(fis, baos);
			
			content += Base64.encode(baos.toByteArray());
					
		} catch (Exception e) {
			_log.error(e);
		}
		
		return content;
	}
	
	public void copiaColmiOsservati() {
		List<Object> l = BollettinoLocalServiceUtil.eseguiQueryGenericaLista(queryUltimoPubblicato);
		if (l!=null && l.size()>0) {
			Object[] o = (Object[])l.get(0);
			if (o==null || o[0]==null || o[1]==null) return;
			String nome = o[1].toString().toUpperCase().trim();
			if (nome.endsWith("U") || nome.endsWith("ULTIMO")) {
				return;
			}
			String q = queryCopiaColmiOsservati.replaceAll("IDB", o[0].toString());
			q = q.replaceAll("IDN", ""+bollettino.getBollettinoId());
			BollettinoLocalServiceUtil.eseguiQueryGenerica(q);
			
			q = queryCopiaNote.replaceAll("IDB", o[0].toString());
			q = q.replaceAll("IDN", ""+bollettino.getBollettinoId());
			BollettinoLocalServiceUtil.eseguiQueryGenerica(q);
			
			for (BacinoManager bm : bacini) {
				DynamicQuery dyn2 = BollettinoBacinoLocalServiceUtil.dynamicQuery()
						.add(PropertyFactoryUtil.forName("idBacino").eq(bm.bac.getId()))
						.add(PropertyFactoryUtil.forName("idBollettino").eq(bollettino.getBollettinoId()));
				List<BollettinoBacino> bba = BollettinoBacinoLocalServiceUtil.dynamicQuery(dyn2);
				if (bba!=null && bba.size()>0) {
					bm.setBacino(bba.get(0));
					bm.note = bba.get(0).getNote();
				}
				
				for (StazioneManager st : bm.stazioni) {
					long bs = st.sensore.getId();
					DynamicQuery dyn = BollettinoSensoreLocalServiceUtil.dynamicQuery()
							.add(PropertyFactoryUtil.forName("idStazione").eq(st.sensore.getIdStazione()))
							.add(PropertyFactoryUtil.forName("idBollettino").eq(bollettino.getBollettinoId()));
					List<BollettinoSensore> ssvv = BollettinoSensoreLocalServiceUtil.dynamicQuery(dyn);
					if (ssvv.size()>0)
					{
						st.sensore = ssvv.get(0);
						if (true || st.sensore.isOsservato()) {
							st.giornoPrevisto = st.sensore.getGiornoPrevisto();
							st.oraPrevista = st.sensore.getOraPrevista();
							st.livelloPrevisto = st.sensore.getColmoPrevisto();
							int tendenza = st.sensore.getTendenza();
							if (tendenza==1) st.setTendenza("+");
							else if (tendenza==0) st.setTendenza("=");
							else st.setTendenza("-");
							st.selezionata = true;
							bm.selezionato = true;
							st.osservato = true;
						}

						
					}
			
				}
			}
		}
	}

	private Log _log = LogFactoryUtil.getLog(BollettinoBean.class);
}
