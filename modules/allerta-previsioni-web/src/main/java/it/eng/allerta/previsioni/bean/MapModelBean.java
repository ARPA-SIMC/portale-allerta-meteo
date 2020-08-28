package it.eng.allerta.previsioni.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.osgi.service.component.annotations.Reference;

import com.google.gson.Gson;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import it.eng.allerter.service.AllertaLocalService;
import it.eng.allerter.service.AllertaServiceUtil;
import it.eng.bollettino.model.BollettinoParametro;
import it.eng.bollettino.service.BollettinoLocalService;
import it.eng.bollettino.service.BollettinoParametroLocalServiceUtil;
import it.eng.radarMeteo.service.ImgServiceUtil;


public class MapModelBean  {
	
	// serialVersionUID
	private static final long serialVersionUID = 7459438254337818761L;
	private Log _log = LogFactoryUtil.getLog(MapModelBean.class);

	private long companyId;
	private String siteName ; 
	private String page_title;
	private Boolean homePage;
	private String isChild="no";
	private String portalUrl;
	private String URLCurrent;
	private boolean operatore;
	private Map<Integer, String> RoleAllowed = new HashMap<Integer, String>();
	private boolean temperatureEstremeAlte;
	/*
	 *  chiavi di accesso alle variabili liferay 
	 */
	private static String lat_k  ="latitudine";
	private static String long_k ="longitudine";
	private static String area_k ="Area";
	private static String show="no";

	// Chiavi per operatori
	// Su questi ruoli viene attivato la variabile IS OPERATORE
	private static String KEY_OPERATORE_UNO = "Approvatore_Arpae";
	private static String KEY_OPERATORE_DUE = "Approvatore_Pc";
	private static String KEY_OPERATORE_TRE = "COMPILATORE_MONITORAGGIO";
	private static String KEY_OPERATORE_QUATTRO = "COMPILATORE_ALLERTA";
	private static String KEY_OPERATORE_CINQUE = "Administrator";

	/*
	 *  CHIAVI DELLA MAPPA 
	 */
	private String KEY_DATA_FINE_VALORE    = "datafine";
	private String KEY_DATA_INIZIO_VALORE  = "datainizio";
	private String KEY_SINTESI_VALORE      = "sintesi";
	private String KEY_TIPO_VALORE         = "tipo";
	private String KEY_LINK_VALORE         = "link";
	private String KEY_NUMERO_VALORE       = "numero";
	private String KEY_TITOLO_VALORE		= "titolo";

	// VALORI ALLERTA OGGI 
	private String allertaOggiDataFine;
	private String allertaOggiDataFineNoTime;
	private String allertaOggiDataInizio;
	private String allertaOggiDataInizioNoTime;
	private String allertaOggiSintesi;
	private String allertaOggiTipo;
	private String allertaOggiLink;
	private String allertaOggiNumero;
	private String allertaOggiTitolo;

	// VALORI ALLERTA DOMANI
	private String allertaDomaniDataFine;
	private String allertaDomaniDataFineNoTime;
	private String allertaDomaniDataInizio;
	private String allertaDomaniDataInizioNoTime;
	private String allertaDomaniSintesi;
	private String allertaDomaniTipo;
	private String allertaDomaniLink;
	private String allertaDomaniNumero;
	private String allertaDomaniTitolo;

	private boolean existDomani = true;
	private boolean existOggi = true;

	/*
	 * VARIABILI PASSATE DAL BEAN ALLA VIEW 
	 */
	private String lat_ ="";
	private String long_="";
	private String area ="";
	//private Boolean monitoraggioOn;
	private String infoAllerta;
	private String infoAllertaDomani;

	private final SimpleDateFormat timeformatter = new SimpleDateFormat("HH:mm");
	private final SimpleDateFormat dayformatter = new SimpleDateFormat("dd MMMM YYYY", Locale.ITALY);

	//data e ora per il livello fiume
	//	private String oraMonitoraggio;
	private String dataMonitoraggio;

	private Map<String,Object> mappaInfoAllerta;
	private Map<String,Object> mappaInfoAllertaDomani;
	private ThemeDisplay _themeDisplay;

	public MapModelBean( ThemeDisplay themeDisplay) throws PortalException, SystemException {
		
		_themeDisplay = themeDisplay;

		this.reset();
		
		this.setGeoInformation();
		
		this.setAllertaInformation();
		
		RoleAllowed.put(0, "Administrator");
		RoleAllowed.put(1, "Power User");
		RoleAllowed.put(2, "Approvatore_Arpae");
		RoleAllowed.put(3, "Approvatore_Pc");
	}
	
	public boolean isGestMonAttivo() {
		
		BollettinoParametro bollpar = null;
		try {
			bollpar = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("GESTIONE_MONITORAGGIO");
			
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			_log.error(e);
		}
		
		return Boolean.valueOf((bollpar.getValore()));
	}


	private void reset() throws PortalException, SystemException{

		siteName   = _themeDisplay.getLayout().getGroup().getName(_themeDisplay.getLocale());//liferayFacesContext.getThemeDisplay().getLayout().getGroup().getName();
		companyId  = _themeDisplay.getCompanyId(); //liferayFacesContext.getCompanyId();
		page_title = _themeDisplay.getLayout().getName(_themeDisplay.getLocale() ); //liferayFacesContext.getThemeDisplay().getLayout().getName(liferayFacesContext.getThemeDisplay().getLocale());
		portalUrl =  _themeDisplay.getPortalURL(); //liferayFacesContext.getPortalURL();
		URLCurrent = _themeDisplay.getURLCurrent(); //liferayFacesContext.getThemeDisplay().getURLCurrent();

		if(page_title.toLowerCase().contains("home")){

			this.homePage=true;
		}else 
		{
			this.homePage=false;
		}

		if(siteName.equalsIgnoreCase("Guest")){
			isChild="no";
		}else{
			isChild="si";
		}
	}

	private void setInfoAllertaOggi(){

		this.allertaOggiDataFine   ="";
		this.allertaOggiDataInizio ="";
		this.allertaOggiDataInizioNoTime="";
		this.allertaOggiSintesi    ="";
		this.allertaOggiTipo       ="";
		this.allertaOggiLink       ="";
		this.allertaOggiNumero     ="";
		this.allertaOggiTitolo     ="";

		this.mappaInfoAllerta      = AllertaServiceUtil.getInfoAllerta();

		if(this.mappaInfoAllerta!=null){		 
//				logger.info("RECUPERO I DATI DALLA HASHMAP ALLERTA ");
			this.infoAllerta="Info Allerta oggi ";

			Timestamp ts;
			if(this.mappaInfoAllerta.get(KEY_DATA_INIZIO_VALORE)!=null){
				ts = (Timestamp)this.mappaInfoAllerta.get(KEY_DATA_INIZIO_VALORE);
				this.allertaOggiDataInizio = timeformatter.format((java.util.Date) ts);
				this.allertaOggiDataInizioNoTime = dayformatter.format((java.util.Date) ts);
			}
			else{
				existOggi = false;
			}
			if(this.mappaInfoAllerta.get(KEY_DATA_FINE_VALORE)!=null){
				ts = (Timestamp)this.mappaInfoAllerta.get(KEY_DATA_FINE_VALORE);
				this.allertaOggiDataFine = timeformatter.format((java.util.Date) ts);
				this.allertaOggiDataFineNoTime = dayformatter.format((java.util.Date) ts);
			}
			this.allertaOggiSintesi    = (String) this.mappaInfoAllerta.get(KEY_SINTESI_VALORE);
			this.allertaOggiTipo       = (String) this.mappaInfoAllerta.get(KEY_TIPO_VALORE);
			this.allertaOggiLink       = (String) this.mappaInfoAllerta.get(KEY_LINK_VALORE);
			this.allertaOggiNumero     = (String) this.mappaInfoAllerta.get(KEY_NUMERO_VALORE);
			this.allertaOggiTitolo	=(String) this.mappaInfoAllerta.get(KEY_TITOLO_VALORE);
		}else{
			_log.info("HASHMAP ALLERTA NULLA ");
			this.infoAllerta="TROVATA MAPPA NULLA SU ALLERTA DI OGGI  ";
		}
	}

	private void setInfoAllertaDomani(){

		this.allertaDomaniDataFine   ="";
		this.allertaDomaniDataInizio ="";
		this.allertaDomaniDataInizioNoTime="";
		this.allertaDomaniSintesi    ="";
		this.allertaDomaniTipo       ="";
		this.allertaDomaniLink       ="";
		this.allertaDomaniNumero     ="";
		this.allertaDomaniTitolo     ="";

		this.mappaInfoAllertaDomani      = AllertaServiceUtil.getInfoAllertaDomani();
		//allertaLocalService

		if(this.mappaInfoAllertaDomani!=null){
			this.infoAllertaDomani =" info Allerta domani ";

			Timestamp ts;
			if(this.mappaInfoAllertaDomani.get(KEY_DATA_INIZIO_VALORE)!=null){
				ts = (Timestamp)this.mappaInfoAllertaDomani.get(KEY_DATA_INIZIO_VALORE);
				this.allertaDomaniDataInizio = timeformatter.format((java.util.Date) ts);
				this.allertaDomaniDataInizioNoTime = dayformatter.format((java.util.Date) ts);
			}
			else{
				existDomani = false;
			}

			if(this.mappaInfoAllertaDomani.get(KEY_DATA_FINE_VALORE)!=null)
			{
				ts = (Timestamp)this.mappaInfoAllertaDomani.get(KEY_DATA_FINE_VALORE);
				this.allertaDomaniDataFine = timeformatter.format((java.util.Date) ts);
				this.allertaDomaniDataFineNoTime = dayformatter.format((java.util.Date) ts);
			}

			this.allertaDomaniSintesi    = (String) this.mappaInfoAllertaDomani.get(KEY_SINTESI_VALORE);
			this.allertaDomaniTipo       = (String) this.mappaInfoAllertaDomani.get(KEY_TIPO_VALORE);
			this.allertaDomaniLink       = (String) this.mappaInfoAllertaDomani.get(KEY_LINK_VALORE);
			this.allertaDomaniNumero     = (String) this.mappaInfoAllertaDomani.get(KEY_NUMERO_VALORE);
			this.allertaDomaniTitolo	= (String) this.mappaInfoAllertaDomani.get(KEY_TITOLO_VALORE);
		}else{
			this.infoAllertaDomani =" TROVATA MAPPA NULLA SU ALLERTA DI DOMANI ";
		}
	}

	private void setAllertaInformation(){
//			logger.info("@@ INIT ALLERTA INFORMATION ");	
		this.setInfoAllertaOggi();
		this.setInfoAllertaDomani();
	}

	private void setGeoInformation(){

//			logger.info("@@ INIT GEO INFORMATION ");
		//LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();

		Group site = _themeDisplay.getSiteGroup();
		
		Map<String, Serializable> expandoAttribs =  null;
		if(site!=null)
		{
//				logger.info("@@ RECUPERATO SITO CORRENTE  "+site.getName());
			expandoAttribs=  site.getExpandoBridge().getAttributes();
			this.lat_     = (String) expandoAttribs.get(lat_k);
			this.long_    = (String) expandoAttribs.get(long_k);
			this.area     = (String) expandoAttribs.get(area_k); 	 
		}
	}

	public String graficoData() {
		
		String url = getURLCurrent();
		Pattern p;
		Matcher m;

		p = Pattern.compile("stazione=([^&]+)", Pattern.CASE_INSENSITIVE);		
		m = p.matcher(url);
		m.find();		
		String stazione = m.group(1);

		p = Pattern.compile("variabile=([^&]+)", Pattern.CASE_INSENSITIVE);		
		m = p.matcher(url);
		m.find();		
		String variabile = m.group(1);
//			logger.info(stazione + " " + variabile);
		return new Gson().toJson(ImgServiceUtil.getInfoSensore(stazione, variabile));
	}

	public final String getInfoAllerta() {
		return infoAllerta;
	}

	public final String getInfoAllertaDomani() {
		return infoAllertaDomani;
	}

	public final Map<String, Object> getMappaInfoAllerta() {
		return mappaInfoAllerta;
	}

	public final Map<String, Object> getMappaInfoAllertaDomani() {
		return mappaInfoAllertaDomani;
	}

	/*public final Boolean getMonitoraggioOn() {
		return  !BollettinoServiceUtil.getAllarmi().isEmpty(); 
	}*/

	public final long getCompanyId() {
		return companyId;
	}

	public final void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public final String getSiteName() {
		return siteName;
	}

	public final void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public final String getIsChild() {
		return isChild;
	}

	public final void setIsChild(String isChild) {
		this.isChild = isChild;
	}


	public final String getLat_() {
		return lat_;
	}


	public final void setLat_(String lat_) {
		this.lat_ = lat_;
	}


	public final String getLong_() {
		return long_;
	}


	public final void setLong_(String long_) {
		this.long_ = long_;
	}


	public final String getArea() {
		return area;
	}


	public final void setArea(String area) {
		this.area = area;
	}


	public final String getPage_title() {
		return page_title;
	}

	public final String getAllertaOggiDataFine() {
		return allertaOggiDataFine;
	}

	public final String getAllertaOggiDataInizio() {
		return allertaOggiDataInizio;
	}

	public final String getAllertaOggiSintesi() {
		return allertaOggiSintesi;
	}

	public final String getAllertaOggiTipo() {
		return allertaOggiTipo;
	}

	public final String getAllertaOggiLink() {
		return allertaOggiLink;
	}

	public final String getAllertaOggiNumero() {
		return allertaOggiNumero;
	}

	public String getAllertaOggiTitolo() {
		return allertaOggiTitolo;
	}

	public String getAllertaDomaniTitolo() {
		return allertaDomaniTitolo;
	}

	public final String getAllertaDomaniDataFine() {
		return allertaDomaniDataFine;
	}

	public final String getAllertaDomaniDataInizio() {
		return allertaDomaniDataInizio;
	}

	public final String getAllertaDomaniSintesi() {
		return allertaDomaniSintesi;
	}

	public final String getAllertaDomaniTipo() {
		return allertaDomaniTipo;
	}

	public final String getAllertaDomaniLink() {
		return allertaDomaniLink;
	}

	public final String getAllertaDomaniNumero() {
		return allertaDomaniNumero;
	}

	public final String getAllertaOggiDataInizoNoTime() {
		return allertaOggiDataInizioNoTime;
	}

	public final String getAllertaOggiDataFineNoTime() {
		return allertaOggiDataFineNoTime;
	}

	public final String getAllertaDomaniDataFineNoTime() {
		return allertaDomaniDataFineNoTime;
	}

	public final String getAllertaDomaniDataInizioNoTime() {
		return allertaDomaniDataInizioNoTime;
	}

	public final Boolean getHomePage() {
		return homePage;
	}


	public final void setHomePage(Boolean homePage) {
		this.homePage = homePage;
	}


	public String getPortalUrl() {
		return portalUrl;
	}


	public boolean isExistDomani() {
		return existDomani;
	}
	
	public boolean isExistOggi() {
		return existOggi;
	}


	//	public String getOraMonitoraggio() {
	//		oraMonitoraggio = timeformatter.format(new Date());
	//		return oraMonitoraggio;
	//	}
	//
	//
	public String getDataMonitoraggio() {
		dataMonitoraggio = dayformatter.format(new Date());
		return dataMonitoraggio;
	}

	public String getURLCurrent(){
		return URLCurrent;
	}

	public boolean isOperatore() {
		
		this.operatore = false;
		
		List<Role> roles = null;
		
		try {
			
			Long userId = _themeDisplay.getUserId();
			
			User user = UserServiceUtil.getUserById(userId);
			
			roles = user.getRoles();
			
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}

		if (roles != null) {
			
			Iterator<Role> it = roles.iterator();
			
			boolean find = false;
			String nameActualRole = "";
			
			Role actual = null;
			
			while (it.hasNext() && !find) {
				
				actual = it.next();
				nameActualRole = actual.getName();
				nameActualRole = nameActualRole.trim();
//					logger.info("----------->@@ DEBUG ROLE NAME " + nameActualRole);

				if (nameActualRole.equalsIgnoreCase(KEY_OPERATORE_UNO)
						|| nameActualRole.equalsIgnoreCase(KEY_OPERATORE_DUE)
						|| nameActualRole.equalsIgnoreCase(KEY_OPERATORE_TRE)
						|| nameActualRole.equalsIgnoreCase(KEY_OPERATORE_QUATTRO)	
						|| nameActualRole.equalsIgnoreCase(KEY_OPERATORE_CINQUE)) {
					find = true;
					this.operatore = true;
				}

			}

		}

		return operatore;
	}

	public boolean isTemperatureEstremeAlte() {
		return checkIfLowOrHigh();
	}

	public boolean checkIfLowOrHigh() {
		
		Date start;
		Date end;
		Date now;

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, 3);
		calendar.set(Calendar.DAY_OF_MONTH,1);
		calendar.set(Calendar.HOUR,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		start = calendar.getTime();

		calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, 9);
		calendar.set(Calendar.DAY_OF_MONTH,1);
		calendar.set(Calendar.HOUR,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		end = calendar.getTime();

		calendar = Calendar.getInstance();
		now = calendar.getTime();
		
		return now.after(start)	&& now.before(end);
	}

	
	@Reference
	private AllertaLocalService allertaLocalService;

}
