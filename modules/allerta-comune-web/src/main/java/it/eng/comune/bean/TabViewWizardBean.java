package it.eng.comune.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;

import it.eng.allerter.model.Allerta;
import it.eng.allerter.service.AllertaLocalServiceUtil;

public class TabViewWizardBean implements Serializable {
	
	private static final long serialVersionUID  = 101469870238569865L;
	private Log _log = LogFactoryUtil.getLog(TabViewWizardBean.class);
	private Integer selectedTabIndex = 0;
	
	private transient MessageModelBean messageModelBean;
	private transient SelectBooleanChannelModelBean selectBooleanChannelModelBean;
	private transient SelectBooleanInfoModelBean selectBooleanInfoModelBean;
	private transient SelectOrganizationModelBean selectOrganizationModelBean;
	
	private Boolean sindaco;
	private Boolean advancedAdmin=false;
	private Map<Long, String> comuneDelSindaco = new HashMap<>();
	private List<String> selectTownHall = new ArrayList<>();

	private String administrator_k = "Administrator";
	
	// Dati legati all allerta
	/*
	 *  Qualora la funzionalita venga richiamata dalla portlet del login 
	 *  allora se la portlet si trova in una pagina di allerta allora verra' recuperata anche l'allerta
	 */
	private String idAllerta;
	private String titoloAllerta;

	// UNA VOLTA PRELEVATI I DATI DELL ALLERTA DA URL DEVO SALVARLI IN SESSIONE PERCHE' IL WIZARD NON RIPASSA I DATI NELLA URL 
	private String idAllertaSaved;
	private String titoloAllertaSaved;
	private String PATH_ALLERTA= "/web/guest/singola-allerta/-/asset_publisher/FZPQSb6AzKtJ/Allerta-Bollettino/id/";


	private void reset() {
		
		_log.info("RESET BEAN WIZARD MESSAGGIO DEL SINDACO");
		this.idAllerta=null;
		this.titoloAllerta=null;
		this.idAllertaSaved=null;
		this.titoloAllertaSaved=null;
		sindaco=false;
	}
	
	/*
	 *  profiliamo utente in modo da capire quali sono i dati da utilizzare 
	 */
	private void profileUser(User user) throws Exception{

		_log.info("PROFILAZIONE UTENTE ");
		
		String sindaco_k    = "SINDACO";
		String delegato_k	= "DELEGATO SINDACO";
		String guest_k      = "guest";
		sindaco = false;
		
		long site_sindaco_role_id=29574;		
		long site_delegatototale_role_id = 75902;

		//variabili di utility
		Group sitoAttuale;
		Role actual = null;
		String name;

		List<Role> roles = new ArrayList<Role>();
		roles.addAll(user.getRoles());
		Iterator<Role> it = roles.iterator();

		while(it.hasNext()) {
			
			actual = it.next();
			name = actual.getName();
			_log.info("riga 140 Tabviewizard: "+name );
			
			if(name.equalsIgnoreCase(sindaco_k) || name.equalsIgnoreCase(delegato_k) && !sindaco){
			
				sindaco=true;
				List<Group> sitiSindaco = user.getMySiteGroups();
				Iterator<Group> itSite = sitiSindaco.iterator();
				String sname="";
				
				while(itSite.hasNext()){
				
					sitoAttuale = (Group)itSite.next();
					sname = sitoAttuale.getName();
					_log.info("riga 150 Tabviewizard: "+sitoAttuale.getName() +" -- "+ name );
					
					if(!sname.equalsIgnoreCase(guest_k)){
						// controllo se per il sito attuale l utente è il sindaco o delegato
						if(UserGroupRoleLocalServiceUtil.hasUserGroupRole(user.getUserId(), sitoAttuale.getGroupId(), site_sindaco_role_id) ||
						   UserGroupRoleLocalServiceUtil.hasUserGroupRole(user.getUserId(), sitoAttuale.getGroupId(),site_delegatototale_role_id))
						{
							comuneDelSindaco.put(sitoAttuale.getGroupId(), sname);
						}
					}
				}
			}
		}
		
		if(comuneDelSindaco.size()>0 && sindaco){
			selectTownHall.add(String.valueOf(comuneDelSindaco.entrySet().iterator().next().getKey()));
		}
		
		if(roles.contains(administrator_k)){
		
			advancedAdmin=true;
			_log.info("TROVATO UTENTE SUPER ADMIN ");
		}
		//		if(!sindaco){
		//			List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(new long[]{238646L,232913L});
		//			selectTownHall.add(String.valueOf(organizations.iterator().next().getPrimaryKey()));
		//		}
	}
	
	public  String getTitoloAllerta() {
		
		String titolo=null;
		idAllerta = this.getIdAllerta();
		
		_log.info("DEBUG ALLERTA ASSOCIATA "+idAllerta);
		
		if(idAllerta!=null ){
			_log.info("Cerco di Recuperare allerta con id   "+idAllerta);
			try {
				Long alertId =  Long.parseLong(idAllerta);
				boolean    assetFind = false;
				AssetEntry entry     = null;
				Allerta allerta         = null;
				try {
					entry = AssetEntryLocalServiceUtil.getAssetEntry(alertId);
					if(entry!=null){
						assetFind=true;
						_log.info(">>Trovata Entry ");
					}
				} catch (Exception e1) {
					_log.info(">>Trovata NON  Entry ");
					_log.error(e1);
				}
				if(assetFind){
					try {
						allerta = AllertaLocalServiceUtil.getAllerta(entry.getClassPK());
						_log.info("Allerta recuperata "+allerta.getTitolo()+" "+allerta.getTipoAllerta());
						titolo = allerta.getTitolo();
						this.titoloAllertaSaved = titolo;
					} catch (Exception e) {
						_log.info("Allerta non recuperata ");
					}
				}
			} catch (Exception e) {
				_log.info("Impossibile recuperare allerta con   "+idAllerta);
			}
		}
		return titolo;
	}
	
	public  String getIdAllerta() {

		_log.info("PROVO A RECUPERARE ID ALLERTA");
		String idAllerta =null;
		
		String url = ""; //liferayFacesContext.getThemeDisplay().getURLCurrent();
		String key= "?alert_is=";
		try {
			
			int position =url.indexOf(key);
			
			if(position>0){
			
				_log.info("Chiave trovata");
				idAllerta = url.substring(position+(key.length()));
				// Salvo id allerta solo se non è stata gia salvata
				// Altrimenti perdo l'id casua passaggi del wizard 
				
				if(idAllertaSaved==null ){
					_log.info("Setto lal Chiave trovata"+idAllerta);
					idAllertaSaved = idAllerta;
				}else{
					_log.info("Non setto la chiave all'allerta perchè già presente questa "+idAllertaSaved);
				}
			}else {
				_log.info("Chiave non trovata");
			}
		} catch (Exception e) {

		}
		
		this.idAllerta = idAllerta;

		return idAllerta;
	}
}
