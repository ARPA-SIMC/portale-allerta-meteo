package it.eng.allerter.allerta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import it.eng.allerter.service.AllertaServiceUtil;

public class LoginBean {
	
	private ThemeDisplay _themeDisplay;
	
	private Log _log = LogFactoryUtil.getLog(LoginBean.class);
	// CHIAVI PER LA FORMATTAZIONE 
	private static String sitePath= "/web";
	private static String lat_k   = "latitudine";
	private static String long_k  = "longitudine";
	private static String area_k  = "Area";
	private static String show    = "no";
	private String mostra_solo_link_monitoraggio="no";
	
	// FG
	private String livelloAllertamento;
	
	private UserBean comuneSindaco;
	private transient DocumentModelBean documentModelBean;
	
	public LoginBean( ThemeDisplay themeDisplay) throws PortalException, SystemException {
		
		_themeDisplay = themeDisplay;
		
		comuneSindaco = new UserBean();
		documentModelBean = new DocumentModelBean(themeDisplay);
		
	}
	
	public final DocumentModelBean getDocumentloginModelBean() {
		return documentModelBean;
	}
	
	public UserBean getComuneSindaco() throws PortalException, SystemException {
		
		User u = _themeDisplay.getUser();
		
		if( u != null) {
			
			_log.info("# Controllo se sindaco devo prendermi il suo comune ");	
			String siteName;
			// VARIABILI IDENTIFICAZIONE RUOLO
			boolean isAdvancedAdmin=false;

			// GESTIONE DEI RUOLI 
			List<Role> roles = new ArrayList<Role>();
			roles.addAll(u.getRoles());

			_log.info("# Numero di ruoli associati all utente "+ u.getFirstName() + " " + u.getScreenName()+" "+roles.size());	

			Iterator<Role> it = roles.iterator();
			Role actual = null;
			String name;
			// ULTERIORI DATI LEGATI ALL UTENTE
			String urlSite="";
			// CHIAVI DEI RUOLI 
			String sindaco_k = "SINDACO";
			// COSTANTI DEI SITI
			String guest_k="guest";

			long site_sindaco_role_id=29574;

			while(it.hasNext() && (!isAdvancedAdmin)) {

				actual = it.next();
				name = actual.getName();
				_log.info("# Ruolo Attuale"+name);
				
				if(name.equalsIgnoreCase(sindaco_k)  ) {

					_log.info("#### Trovato un sindaco");	

					isAdvancedAdmin=true;	

					List<Group> sitiSindaco = u.getMySiteGroups();

					Iterator<Group> itSite = sitiSindaco.iterator();
					boolean findSiteSindaco=false;
					Map<String, Serializable> expandoAttribs =  null;
					Group sitoAttuale;
					String sname="";

					_log.info("#@@@@ NUmero di siti associati al sindaco"+sitiSindaco.size());

					while(itSite.hasNext() && (!findSiteSindaco)) {
						
						sitoAttuale = (Group)itSite.next();
						sname = sitoAttuale.getName();
	
						if(!sname.equalsIgnoreCase(guest_k)) {
							_log.info("# trovato questo sito "+sname);	

							// controllo se per il sito attuale l utente è il sindaco
							boolean isSidacoInThisSite= 
										UserGroupRoleLocalServiceUtil.hasUserGroupRole(u.getUserId(), sitoAttuale.getGroupId(), site_sindaco_role_id);
							
							if(isSidacoInThisSite){
							
								siteName = sitoAttuale.getName();
								urlSite="";
								expandoAttribs=   sitoAttuale.getExpandoBridge().getAttributes();
							
								String area     = (String) expandoAttribs.get(area_k);
								String geoName  = siteName.replaceAll("\\s","").toUpperCase();
								//String url_parameter ="/home#geoLoc="+lat_+"|"+long_+"&geoName="+geoName+"&geoArea="+area;
								urlSite = sitePath.concat(sitoAttuale.getFriendlyURL());	
							
								
								//urlSite = urlSite.concat(url_parameter);
								findSiteSindaco = true;
								_log.info("##  HO TROVATO IL SINDACO DI  "+urlSite);	
								// update dati della maschera 

								this.comuneSindaco.setName(siteName);
								this.comuneSindaco.setUrl(urlSite);  
								this.comuneSindaco.setArea(area);
								//this.documentloginModelBean.reset(siteName);
								this.getEventiInCorso(area);

							}
						}
					}
				}
			}
		}
		
		return comuneSindaco;
	}
	
	//FG start
	public List<String[]> getEventiInCorso(String area){
		Map<String,String> conversione = new HashMap<String, String>();
		conversione.put("idro", "idraulica");
		conversione.put("idrogeo", "idrogeologica");
		conversione.put("idraulica", "Piene dei fiumi");
		conversione.put("temporali", "temporali");
		conversione.put("mareggiate", "mareggiate");
		conversione.put("stato-mare", "stato-mare");
		conversione.put("ghiaccio-pioggia-gela", "ghiaccio-pioggia-gela");
		conversione.put("neve", "neve");
		conversione.put("temperature-estreme", "Temperature estreme calde");
		conversione.put("vento", "vento");

		List<Map<String,String>> eventiComune = AllertaServiceUtil.getStatoAllerta();
		List<String[]> eventiInCorso = new ArrayList<String[]>();
		
		for(Map<String,String> even: eventiComune){
			try {
				if (even.get("area").equalsIgnoreCase(area) || even.get("area").equalsIgnoreCase(area.substring(0,1))){
					String[] listaEventi = even.get("eventi").split(",");
					for(String ev: listaEventi){
						String[] listaEventiColore = ev.split(":");
						if(!(listaEventiColore[1].equalsIgnoreCase("white") || listaEventiColore[1].equalsIgnoreCase("green")))
						{
							//eventiInCorso.add(listaEventiColore[0]);
							listaEventiColore[0] = conversione.get(listaEventiColore[0]);
							eventiInCorso.add(listaEventiColore);
						}
					}
				}	
			} catch (Exception e) {
				_log.info("catturata eccezione"+e.getMessage());
			}
			
		}
		return eventiInCorso;
	}

	public String getLivelloAllertamento(String area) {
		
		if(area != null) {
			
			Map<String, Integer> coloreLivello = new HashMap<String, Integer>();
			coloreLivello.put( "white",0);
			coloreLivello.put("green",1);
			coloreLivello.put("yellow",2);
			coloreLivello.put( "orange",3);
			coloreLivello.put("red",4);
			List<Map<String,String>> eventiComune = AllertaServiceUtil.getStatoAllerta();

			Map<String,String> conversioneColore = new HashMap<String, String>();
			conversioneColore.put("white", "bianco");
			conversioneColore.put("green", "verde");
			conversioneColore.put("yellow", "giallo");
			conversioneColore.put("orange", "arancione");
			conversioneColore.put("red", "rosso");

			int livello = 0;
			livelloAllertamento = "verde";
			try {
				area     = getComuneSindaco().getArea();
			} catch (PortalException | SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(Map<String,String> even: eventiComune){
				if (even.get("area").equalsIgnoreCase(area) || even.get("area").equalsIgnoreCase(area.substring(0,1))){
					String[] listaEventi = even.get("eventi").split(",");
					for(String ev: listaEventi){
						String[] listaEventiColore = ev.split(":");
						if(coloreLivello.get(listaEventiColore[1])>livello){
							livello = coloreLivello.get(listaEventiColore[1]);
							livelloAllertamento = conversioneColore.get(listaEventiColore[1]);
						}
					}
				}
			}
			return livelloAllertamento;
		}
		else
			return "verde";
	}
	//FG end

}


