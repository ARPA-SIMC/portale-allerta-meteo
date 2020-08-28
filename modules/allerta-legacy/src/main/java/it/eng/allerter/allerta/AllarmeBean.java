 package it.eng.allerter.allerta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import it.eng.bollettino.model.BollettinoParametro;
import it.eng.bollettino.model.Idrometro;
import it.eng.bollettino.model.Pluviometro;
import it.eng.bollettino.model.RegolaAllarme;
import it.eng.bollettino.model.RegolaAllarmeComune;
import it.eng.bollettino.model.RegolaAllarmeCondizione;
import it.eng.bollettino.model.Stazione;
import it.eng.bollettino.model.StazioneVariabile;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;
import it.eng.bollettino.service.BollettinoParametroLocalServiceUtil;
import it.eng.bollettino.service.IdrometroLocalServiceUtil;
import it.eng.bollettino.service.PluviometroLocalServiceUtil;
import it.eng.bollettino.service.RegolaAllarmeComuneLocalServiceUtil;
import it.eng.bollettino.service.RegolaAllarmeCondizioneLocalServiceUtil;
import it.eng.bollettino.service.RegolaAllarmeLocalServiceUtil;
import it.eng.bollettino.service.StazioneLocalServiceUtil;

public class AllarmeBean implements Serializable {
	
	private Log logger = LogFactoryUtil.getLog(AllarmeBean.class);
	
	public class RegolaManager implements Serializable {
		long idRegola;
		String nome;
		String descrizione;
		boolean attivo;
		int colore;
		String variabile;
		String sensorePrimario;
		String altriSensori;
		String comuni;
		public long getIdRegola() {
			return idRegola;
		}
		public void setIdRegola(long idRegola) {
			this.idRegola = idRegola;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getDescrizione() {
			return descrizione;
		}
		public void setDescrizione(String descrizione) {
			this.descrizione = descrizione;
		}
		public boolean isAttivo() {
			return attivo;
		}
		public void setAttivo(boolean attivo) {
			this.attivo = attivo;
		}
		public int getColore() {
			return colore;
		}
		public void setColore(int colore) {
			this.colore = colore;
		}
		public String getVariabile() {
			return variabile;
		}
		public void setVariabile(String variabile) {
			this.variabile = variabile;
		}
		public String getSensorePrimario() {
			return sensorePrimario;
		}
		public void setSensorePrimario(String sensorePrimario) {
			this.sensorePrimario = sensorePrimario;
		}
		public String getAltriSensori() {
			return altriSensori;
		}
		public void setAltriSensori(String altriSensori) {
			this.altriSensori = altriSensori;
		}
		public String getComuni() {
			return comuni;
		}
		public void setComuni(String comuni) {
			this.comuni = comuni;
		}
		
		public String getTipo() {
			if (variabile==null) return "N/A";
			if (variabile.equals("254,0,0/1,-,-,-/B13215")) return "IDRO";
			return "PLUVIO";
		}
		
		public String getStyle() {
			if (attivo) {
				return "background-color:#77ff77; text-align:center";
			}
			else return "background-color:#ff7777; text-align:center";
		}
		
		public String getTestoAttiva() {
			if (attivo) return "Disattiva";
			else return "Attiva";
		}
		

		
	}
	
	public class CondizioneManager implements Serializable {
		
		RegolaAllarmeCondizione condizione;
		String lettera;
		StazioneVariabile stazioneVariabile;
		String variabile;
		List<SelectItem> listaStazioni;
		String stazione;
		String soglia;
		int index;
		
		Idrometro idrometro;
		Pluviometro pluviometro;
		
		
		
		public Idrometro getIdrometro() {
			return idrometro;
		}
		public void setIdrometro(Idrometro idrometro) {
			this.idrometro = idrometro;
		}
		public Pluviometro getPluviometro() {
			return pluviometro;
		}
		public void setPluviometro(Pluviometro pluviometro) {
			this.pluviometro = pluviometro;
		}
		public RegolaAllarmeCondizione getCondizione() {
			return condizione;
		}
		public void setCondizione(RegolaAllarmeCondizione condizione) {
			this.condizione = condizione;
		}
		public String getLettera() {
			return lettera;
		}
		public void setLettera(String lettera) {
			this.lettera = lettera;
		}
		public StazioneVariabile getStazioneVariabile() {
			return stazioneVariabile;
		}
		public void setStazioneVariabile(StazioneVariabile stazioneVariabile) {
			this.stazioneVariabile = stazioneVariabile;
		}
		public String getVariabile() {
			return variabile;
		}
		public void setVariabile(String variabile) {
			this.variabile = variabile;
		}
		public List<SelectItem> getListaStazioni() {
			return listaStazioni;
		}
		public void setListaStazioni(List<SelectItem> listaStazioni) {
			this.listaStazioni = listaStazioni;
		}
		public String getStazione() {
			return stazione;
		}
		public void setStazione(String stazione) {
			this.stazione = stazione;
		}
		public String getSoglia() {
			return soglia;
		}
		public void setSoglia(String soglia) {
			this.soglia = soglia;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		
		public boolean isVarIdrometro() {
			return (variabile!=null && variabile.contains("B13215"));
		}
		
		public boolean isVarPluviometro() {
			return (variabile!=null && variabile.contains("B13011"));
		}
		
		public boolean isElimina() {
			return condizioni!=null && !this.equals(condizioni.get(0));
		}
		
		public boolean getElimina() {
			return isElimina();
		}
		
	}
	
	public class ComuneManager implements Serializable {
		
		RegolaAllarmeComune comune;
		Group com;
		boolean attivo;
		
		public RegolaAllarmeComune getComune() {
			return comune;
		}
		public void setComune(RegolaAllarmeComune comune) {
			this.comune = comune;
		}
		public Group getCom() {
			return com;
		}
		public void setCom(Group com) {
			this.com = com;
		}
		public boolean isAttivo() {
			return attivo;
		}
		public void setAttivo(boolean attivo) {
			this.attivo = attivo;
		}
		
		public boolean isVisibile() {
			return (filtroComuni==null || filtroComuni.equals("") || com.getName().toUpperCase().contains(filtroComuni.toUpperCase()));
		}
		
		
	}
	
	public static boolean ALLARMI_ATTIVI = true;
	
	String stringaComuni = "";
	
	
	//List<RegolaAllarme> regole;
	List<RegolaManager> regole;
	List<RegolaManager> filtrate;
	String filtro;
	List<Group> comuni;
	
	boolean dettaglio = false;
	
	RegolaAllarme regolaCorrente;
	String nome;
	String descrizione;
	String espressione;
	boolean attiva;
	String colore;
	List<CondizioneManager> condizioni;
	List<ComuneManager> posti;
	
	List<SelectItem> variabili;
	HashMap<String, List<SelectItem>> stazioniVariabili;
	String filtroComuni;
	
	String nomeRubrica;
	String fiume;
	String partiFiume;
	
	boolean canModifica;
	boolean canDisattiva;
	
	public AllarmeBean(long userId) {
		init(userId);
	}
	
	public void caricaRegole() {
		regole = new ArrayList<RegolaManager>();
		List ll = BollettinoLocalServiceUtil.eseguiQueryGenericaLista("select * from regole_allarme_vw");
		
		for (Object o : ll) {
			Object[] o2 = (Object[])o;
			RegolaManager rm = new RegolaManager();
			if (o2[0]!=null) rm.setIdRegola(new Long(o2[0].toString()));
			if (o2[1]!=null) rm.setNome(o2[1].toString());
			if (o2[2]!=null) rm.setDescrizione(o2[2].toString());
			if (o2[3]!=null) rm.setVariabile(o2[3].toString());
			if (o2[4]!=null) rm.setColore(new Integer(o2[4].toString()));
			if (o2[5]!=null) rm.setAttivo((Boolean)o2[5]);
			if (o2[6]!=null) rm.setSensorePrimario(o2[6].toString());
			if (o2[7]!=null) rm.setAltriSensori(o2[7].toString());
			if (o2[8]!=null) rm.setComuni(o2[8].toString());
			
			regole.add(rm);
		}
		
		filtra();
	}
	
	public void filtra() {
		if (filtrate == null) filtrate = new ArrayList<AllarmeBean.RegolaManager>();
		else filtrate.clear();
		
		if (filtro==null) filtro = "";
		String f2 =  filtro.trim();
		f2 = f2.toUpperCase();
		
		for (RegolaManager rm : regole) {
			
			boolean includi = false;
			if (f2.equals("")) includi = true;
			else if (rm.nome!=null && rm.nome.toUpperCase().contains(f2)) includi = true;
			else if (rm.descrizione!=null && rm.descrizione.toUpperCase().contains(f2)) includi = true;
			else if (rm.sensorePrimario!=null && rm.sensorePrimario.toUpperCase().contains(f2)) includi = true;
			else if (rm.altriSensori!=null && rm.altriSensori.toUpperCase().contains(f2)) includi = true;
			else if (rm.comuni!=null && rm.comuni.toUpperCase().contains(f2)) includi = true;
			
			if (includi) filtrate.add(rm);
		}
		
	}
	
	public void filtra(PortletRequest req) {
		filtra(req);
	}
	

	public void init(long userid) {
		
		try {
			
			caricaRegole();
			
			//regole = RegolaAllarmeLocalServiceUtil.getRegolaAllarmes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			regolaCorrente = null;
			
			List<Group> l = GroupLocalServiceUtil.getGroups(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			comuni = new ArrayList<Group>();
			
			canModifica = false;
			canDisattiva = false;
			
			//ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);
			//long userid = themeDisplay.getUserId();
			List<Role> r = RoleLocalServiceUtil.getUserRoles(userid);
			BollettinoParametro can = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("RUOLI_MODIFICA_REGOLE");
			if (can!=null) {
				
				String ruoli[] = can.getValore().split(",");
				for (String ruo : ruoli) {
					for (Role rol : r) {
						if (ruo.equals(""+rol.getRoleId())) canModifica = true;
					}
				}
			}
			
			can = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("RUOLI_ATTIVA_REGOLE");
			if (can!=null) {
				
				String ruoli[] = can.getValore().split(",");
				for (String ruo : ruoli) {
					for (Role rol : r) {
						if (ruo.equals(""+rol.getRoleId())) canDisattiva = true;
					}
				}
			}
			
			BollettinoParametro bp = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("TIPO_GRUPPO_COMUNE");
			BollettinoParametro bp2 = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("REGEXP_PATH_COMUNE");

			int tipo = -1;
			if (bp!=null) {
				try {
					tipo = Integer.parseInt(bp.getValore());
				} catch (Exception e) {}
			}
			
			
			
			
			for (Group g : l) {
				if (bp!=null && g.getType()!=tipo) continue; //sub site
				if (bp2!=null && g.getTreePath()!=null && !g.getTreePath().matches(bp2.getValore())) continue;
				
				comuni.add(g);
			}
			
			posti = new ArrayList<ComuneManager>();
			for (Group c : comuni) {
				ComuneManager cm = new ComuneManager();
				cm.com = c;
				cm.attivo = false;
				posti.add(cm);
				
			}
			
			variabili = new ArrayList<SelectItem>();
			//variabili.add(new SelectItem("1,0,1800/1,-,-,-/B13011","Precipitazione in 30 minuti"));
			variabili.add(new SelectItem("1,0,3600/1,-,-,-/B13011","Pluviometri"));
			//variabili.add(new SelectItem("1,0,86400/1,-,-,-/B13011","Precipitazione giornaliera"));
			variabili.add(new SelectItem("254,0,0/1,-,-,-/B13215","Idrometri"));
			
			stazioniVariabili = new HashMap<String, List<SelectItem>>();
			
			
			for (SelectItem si : variabili) {
				
				//???String s = si.getValue().toString();
				String s = si.getKey().toString();
				
				List<SelectItem> ss = new ArrayList<SelectItem>();
				/*				
				 * Per il classloading, spostato nella LocalServiceImpl, dove doveva stare
				 * DynamicQuery dyn = DynamicQueryFactoryUtil.forClass(Stazione.class)
						.add(PropertyFactoryUtil.forName("id").in(
								DynamicQueryFactoryUtil.forClass(StazioneVariabile.class)
								.add(PropertyFactoryUtil.forName("idVariabile").eq(s))
								.setProjection(ProjectionFactoryUtil.property("idStazione"))))
						.addOrder(OrderFactoryUtil.asc("name"));
				List<Stazione> sv = StazioneLocalServiceUtil.dynamicQuery(dyn);
				*/
				
				List<Stazione> sv = StazioneLocalServiceUtil.getStazioni(s);
				
				for (Stazione st : sv) {
					ss.add(new SelectItem(st.getId(),st.getName()+" ("+st.getId()+")"));
				}
				
				stazioniVariabili.put(si.getValue().toString(), ss);
			}
			
			
		} catch (Exception e) {
			logger.error(e);
			//LogInternoLocalServiceUtil.log("allarmeBean", "init", e, "");
		}
		
		
	}
	
	public String attivaRegola(long r) {
		
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		try {
			RegolaAllarme ra = RegolaAllarmeLocalServiceUtil.getRegolaAllarme(r);
			if (ra==null) return null;
			
			ra.setAttivo(!ra.getAttivo());
			RegolaAllarmeLocalServiceUtil.updateRegolaAllarme(ra);
			
			if( ra.getAttivo()) {
				json.put("style",  "background-color:#77ff77; text-align:center");
		        json.put("testo", "Disattiva regola");
		        json.put("label", "SI");
			} else {
				json.put("style",  "background-color:#ff7777; text-align:center");
		        json.put("testo", "Attiva regola");
		        json.put("label", "NO");
				
			}
			
			caricaRegole();
			
		} catch (Exception e) {
			//LogInternoLocalServiceUtil.log("allarmeBean", "attivaRegola", e, "");
		}
		
        return json.toString(); 
		
	}
	
	public void caricaRegola(long r) {
		
		try {
		
			regolaCorrente = RegolaAllarmeLocalServiceUtil.getRegolaAllarme(r);
			dettaglio = true;

			nome = regolaCorrente.getNome();
			descrizione = regolaCorrente.getDescrizione();
			espressione = regolaCorrente.getEspressione();
			attiva = regolaCorrente.getAttivo();
			colore = ""+regolaCorrente.getColore();
			
			condizioni = new ArrayList<AllarmeBean.CondizioneManager>();
			
			/*				
			 * Per il classloading, spostato nella LocalServiceImpl, dove doveva stare			
			DynamicQuery dyn = DynamicQueryFactoryUtil.forClass(RegolaAllarmeCondizione.class)
					.add(PropertyFactoryUtil.forName("idRegola").eq(r))
					.addOrder(OrderFactoryUtil.asc("id"));
			List<RegolaAllarmeCondizione> sv = RegolaAllarmeCondizioneLocalServiceUtil.dynamicQuery(dyn);
			*/
			
			List<RegolaAllarmeCondizione> sv = RegolaAllarmeCondizioneLocalServiceUtil.getAllarmeCondizione(r);		
			int inde = 0;
			
			for (RegolaAllarmeCondizione rac : sv) {
				
				CondizioneManager c = new CondizioneManager();
				c.condizione = rac;
				c.variabile = rac.getIdVariabile();
				c.stazione = rac.getIdStazione();
				c.lettera = rac.getLettera();
				c.soglia = ""+rac.getSoglia();
				c.index = inde;
				inde++;
				
				c.listaStazioni = stazioniVariabili.get(c.variabile);
				
					try {
						if (c.isVarIdrometro()) {
							c.setPluviometro(null);
							Idrometro i = IdrometroLocalServiceUtil.fetchIdrometro(c.stazione);
							if (i==null) {
								i = IdrometroLocalServiceUtil.createIdrometro(c.stazione);
								IdrometroLocalServiceUtil.updateIdrometro(i);
							}
							c.setIdrometro(i);
							if (condizioni.size()==0) { //sensore primario
								nomeRubrica = i.getNomeRubrica();
								fiume = i.getNomeBacino();
								partiFiume = i.getNomeSottobacino();
								stringaComuni = getComuniRubrica(i.getNomeRubrica());
							}
						}
						if (c.isVarPluviometro()) {
							c.setIdrometro(null);
							Pluviometro i = PluviometroLocalServiceUtil.fetchPluviometro(c.stazione);
							if (i==null) {
								i = PluviometroLocalServiceUtil.createPluviometro(c.stazione);
								PluviometroLocalServiceUtil.updatePluviometro(i);
							}
							c.setPluviometro(i);
							if (condizioni.size()==0) { //sensore primario
								nomeRubrica = i.getNomeRubrica();
								fiume = "";
								partiFiume= "";
								stringaComuni = getComuniRubrica(i.getNomeRubrica());
							}
						}
					} catch (Exception ex) {
						logger.error(ex);
						//LogInternoLocalServiceUtil.log("allarmeBean", "caricaRegola", ex, "");
					}
				
				
				condizioni.add(c);
				
				
			}
			
			for (ComuneManager cm : posti) {
				cm.attivo = false;
				cm.comune = null;
			}
			
			/*				
			 * Per il classloading, spostato nella LocalServiceImpl, dove doveva stare
			dyn = DynamicQueryFactoryUtil.forClass(RegolaAllarmeComune.class)
					.add(PropertyFactoryUtil.forName("idRegola").eq(r));
			List<RegolaAllarmeComune> cc = RegolaAllarmeComuneLocalServiceUtil.dynamicQuery(dyn);
			*/
			
			List<RegolaAllarmeComune> cc = RegolaAllarmeComuneLocalServiceUtil.getAllarmeCondizione(r);
			
			for (RegolaAllarmeComune c : cc) {
				
				for (ComuneManager cm : posti) {
					if (c.getIdComune()==cm.com.getClassPK()) {
						cm.attivo = true;
						cm.comune = c;
					}
				}
				
			}
			
			
			
			
		} catch (Exception e) {
			//LogInternoLocalServiceUtil.log("allarmeBean", "init", e, "");
			logger.error(e);
		}
		
	}
	
	public String attiva(PortletRequest req) {
		
		String ra =  ParamUtil.getString(req, "regola");
		System.out.println("ATTIVA "+ra);
		if (ra==null) return "";
		return attivaRegola(Long.parseLong(ra));
	}
	
	public void carica(PortletRequest req) {
		String ra =  ParamUtil.getString(req, "regola");
		System.out.println("CARICA "+ra);
		if (ra==null) return;
		caricaRegola(Long.parseLong(ra));
	}
	
	public void elimina(PortletRequest req) {
		try {
			String ra =  ParamUtil.getString(req, "regola");
			System.out.println("CARICA "+ra);
			if (ra==null) return;
			RegolaAllarmeLocalServiceUtil.deleteRegolaAllarme(Long.parseLong(ra));
			//regole = RegolaAllarmeLocalServiceUtil.getRegolaAllarmes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			caricaRegole();
		} catch (Exception ex) {
			logger.error(ex);
			//LogInternoLocalServiceUtil.log("allarmeBean", "elimina", ex, "");
		}
	}
	
	public void eliminaCondizione(PortletRequest req) {
		try {
			String ra =  ParamUtil.getString(req, "condizione");
			System.out.println("ELIMINA CONDIZIONE "+ra);
			if (ra==null) return;
			
			CondizioneManager cm = null;
			if( condizioni == null || (condizioni != null && condizioni.size() == 0)) {
				
				long idRegola = ParamUtil.getLong(req, "idRegola");
				caricaRegola(idRegola);
			}
			
			cm = condizioni.get(Integer.parseInt(ra));
			
			if (cm.condizione!=null)
				RegolaAllarmeCondizioneLocalServiceUtil.deleteRegolaAllarmeCondizione(cm.condizione);
			
			condizioni.remove(cm);
			
			for (int k=0; k<condizioni.size(); k++) condizioni.get(k).index = k;
			
		} catch (Exception ex) {
			logger.error(ex);
			//LogInternoLocalServiceUtil.log("allarmeBean", "eliminaCondizione", ex, "");
		}
	}
	
	
	public void nuovaRegola() {
		
		dettaglio = true;
		regolaCorrente = null;
		nome = "";
		descrizione = "";
		espressione = "X";
		colore = "1";
		attiva = true;
		condizioni = new ArrayList<AllarmeBean.CondizioneManager>();
		
		for (ComuneManager cm : posti) {
			cm.attivo = false;
			cm.comune = null;
		}
		
		aggiungiCondizione();
		 
	}
	
	public void modificaRegola(PortletRequest request) {
		
		dettaglio = true;
		regolaCorrente = null;
		long idRegola = ParamUtil.getLong(request, "idRegola");
		
		caricaRegola(idRegola);
		
		nome = ParamUtil.getString(request, "nome", "");
		descrizione = ParamUtil.getString(request, "descrizione", "");
		espressione = ParamUtil.getString(request, "espressione", "");
		colore = ParamUtil.getString(request, "colore", "");
		fiume = ParamUtil.getString(request, "fiume", "");
		nomeRubrica = ParamUtil.getString(request, "rubrica", "");
		partiFiume = ParamUtil.getString(request, "parti", "");
		attiva = ParamUtil.getBoolean(request, "attiva");
		
		for( CondizioneManager cm : condizioni) {
			
			RegolaAllarmeCondizioneLocalServiceUtil.deleteRegolaAllarmeCondizione(cm.condizione);
		}
		
		condizioni = new ArrayList<AllarmeBean.CondizioneManager>();
		
		String rules =  ParamUtil.getString(request, "rules", "");
		
		String[] rule = rules.split(",");
		
		for (String r : rule) {
			aggiungiCondizione( request, r);
		}
	}
	
	public void nuovaRegola(PortletRequest request) {
		
		dettaglio = true;
		regolaCorrente = null;
		nome = ParamUtil.getString(request, "nome", "");
		descrizione = ParamUtil.getString(request, "descrizione", "");
		espressione = ParamUtil.getString(request, "espressione", "");
		colore = ParamUtil.getString(request, "colore", "");
		attiva = ParamUtil.getBoolean(request, "attiva", true);
		fiume = ParamUtil.getString(request, "fiume", "");
		nomeRubrica = ParamUtil.getString(request, "rubrica", "");
		partiFiume = ParamUtil.getString(request, "parti", "");
		condizioni = new ArrayList<AllarmeBean.CondizioneManager>();
		
		String rules =  ParamUtil.getString(request, "rules", "");
		
		String[] rule = rules.split(",");
		
		for (String r : rule) {
			aggiungiCondizione( request, r);
		}
	}
	
	public void aggiungiCondizione(PortletRequest request, String index) {
		
		CondizioneManager cm = new CondizioneManager();
		
		cm.variabile = ParamUtil.getString(request, "sensore_" + index, "");
		cm.listaStazioni = stazioniVariabili.get(cm.variabile);
		cm.index = condizioni.size();
		cm.soglia = ParamUtil.getString(request, "soglia_" + index, "");
		cm.lettera= ParamUtil.getString(request, "lettera_" + index, "");
		cm.stazione = ParamUtil.getString(request, "staz_" + index, "");
		
		try {
			if (cm.isVarIdrometro()) {
				cm.setPluviometro(null);
				Idrometro i = IdrometroLocalServiceUtil.fetchIdrometro(cm.stazione);
				if (i==null) {
					i = IdrometroLocalServiceUtil.createIdrometro(cm.stazione);
					IdrometroLocalServiceUtil.updateIdrometro(i);
				}
				cm.setIdrometro(i);
				//stringaComuni = getComuniRubrica(i.getNomeRubrica());
			}
			if (cm.isVarPluviometro()) {
				cm.setIdrometro(null);
				Pluviometro i = PluviometroLocalServiceUtil.fetchPluviometro(cm.stazione);
				if (i==null) {
					i = PluviometroLocalServiceUtil.createPluviometro(cm.stazione);
					PluviometroLocalServiceUtil.updatePluviometro(i);
				}
				cm.setPluviometro(i);
				//stringaComuni = getComuniRubrica(i.getNomeRubrica());
			}
		}
		catch (Exception ex) {
			logger.error(ex);
			//LogInternoLocalServiceUtil.log("allarmeBean", "aggiungiCondizione", ex, "");
		}
		
		condizioni.add(cm);
	}
	
	
	public void salva() {
		
		boolean ricarica = false;
		
		try {
			if (regolaCorrente == null) {
				
				long inc = CounterLocalServiceUtil.increment(RegolaAllarme.class.getName());
				regolaCorrente = RegolaAllarmeLocalServiceUtil.createRegolaAllarme(inc);
				ricarica = true;
				
			}
			
			regolaCorrente.setNome(nome);
			regolaCorrente.setAttivo(attiva);
			regolaCorrente.setColore(Integer.parseInt(colore));
			regolaCorrente.setDescrizione(descrizione);
			regolaCorrente.setEspressione(espressione);
			
			RegolaAllarmeLocalServiceUtil.updateRegolaAllarme(regolaCorrente);
			//if (ricarica) regole = RegolaAllarmeLocalServiceUtil.getRegolaAllarmes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if (ricarica) caricaRegole();
			
			for (CondizioneManager cm : condizioni) {
				
				if (cm.condizione == null) {
					long inc = CounterLocalServiceUtil.increment(RegolaAllarmeCondizione.class.getName());
					cm.condizione = RegolaAllarmeCondizioneLocalServiceUtil.createRegolaAllarmeCondizione(inc);
				}
				
				cm.condizione.setIdRegola(regolaCorrente.getId());
				cm.condizione.setIdStazione(cm.stazione);
				cm.condizione.setIdVariabile(cm.variabile);
				cm.condizione.setSoglia(Integer.parseInt(cm.soglia));
				cm.condizione.setLettera(cm.lettera);
				
				RegolaAllarmeCondizioneLocalServiceUtil.updateRegolaAllarmeCondizione(cm.condizione);
				if (cm == condizioni.get(0)) {
					if (cm.getIdrometro()!=null) {
						cm.getIdrometro().setNomeRubrica(nomeRubrica);
						cm.getIdrometro().setNomeBacino(fiume);
						cm.getIdrometro().setNomeSottobacino(partiFiume);
						IdrometroLocalServiceUtil.updateIdrometro(cm.getIdrometro());
						stringaComuni = getComuniRubrica(cm.getIdrometro().getNomeRubrica());
					}
					if (cm.getPluviometro()!=null) {
						cm.getPluviometro().setNomeRubrica(nomeRubrica);
						PluviometroLocalServiceUtil.updatePluviometro(cm.getPluviometro());
						stringaComuni = getComuniRubrica(cm.getPluviometro().getNomeRubrica());
					}
				}
			
			}
			
			for (ComuneManager cm : posti) {
				
				if (cm.attivo && cm.comune==null) {
					long inc = CounterLocalServiceUtil.increment(RegolaAllarmeComune.class.getName());
					cm.comune = RegolaAllarmeComuneLocalServiceUtil.createRegolaAllarmeComune(inc);
					
					cm.comune.setIdComune(cm.com.getClassPK());
					cm.comune.setIdRegola(regolaCorrente.getId());
					RegolaAllarmeComuneLocalServiceUtil.updateRegolaAllarmeComune(cm.comune);
				}
				
				if (!cm.attivo && cm.comune!=null) {
					RegolaAllarmeComuneLocalServiceUtil.deleteRegolaAllarmeComune(cm.comune);
				}
				
				
			}
			
			caricaRegole();
				
		} catch (Exception ex)
		{
			logger.error(ex);
			//LogInternoLocalServiceUtil.log("allarmeBean", "salva", ex, "");
		}
		
	}
	
	public void tornaLista(){
		dettaglio = false;
	}
	
	public void aggiungiCondizione() {
		
		CondizioneManager cm = new CondizioneManager();
		
		cm.variabile = variabili.get(0).getValue().toString();
		cm.listaStazioni = stazioniVariabili.get(cm.variabile);
		cm.index = condizioni.size();
		cm.soglia = "1";
		cm.lettera="X";
		if (cm.listaStazioni!=null) cm.stazione = cm.listaStazioni.get(0).getValue().toString();
		
		try {
		if (cm.isVarIdrometro()) {
			cm.setPluviometro(null);
			Idrometro i = IdrometroLocalServiceUtil.fetchIdrometro(cm.stazione);
			if (i==null) {
				i = IdrometroLocalServiceUtil.createIdrometro(cm.stazione);
				IdrometroLocalServiceUtil.updateIdrometro(i);
			}
			cm.setIdrometro(i);
			//stringaComuni = getComuniRubrica(i.getNomeRubrica());
		}
		if (cm.isVarPluviometro()) {
			cm.setIdrometro(null);
			Pluviometro i = PluviometroLocalServiceUtil.fetchPluviometro(cm.stazione);
			if (i==null) {
				i = PluviometroLocalServiceUtil.createPluviometro(cm.stazione);
				PluviometroLocalServiceUtil.updatePluviometro(i);
			}
			cm.setPluviometro(i);
			//stringaComuni = getComuniRubrica(i.getNomeRubrica());
		}
		}
		catch (Exception ex) {
			//LogInternoLocalServiceUtil.log("allarmeBean", "aggiungiCondizione", ex, "");
		}
		
		condizioni.add(cm);
		
	}
	
	/*
	 * DA RIFARE
	 */
	/*
	public void variabileChange() {
		System.out.println("LISTENER");
		CondizioneManager cm = (CondizioneManager) e.getComponent().getAttributes().get("condizione");
		if (cm==null) return;
		System.out.println(cm.lettera);
		cm.listaStazioni = stazioniVariabili.get(cm.variabile);
		if (cm.listaStazioni!=null) cm.stazione = cm.listaStazioni.get(0).getValue().toString();
	}
	
	
	public void stazioneChange(ValueChangeEvent e) {
		try {
		System.out.println("STAZIONE");
		CondizioneManager cm = (CondizioneManager) e.getComponent().getAttributes().get("condizione");
		if (cm==null) return;
		cm.stazione = (String)e.getNewValue();
		
		if (cm.isVarIdrometro()) {
			cm.setPluviometro(null);
			Idrometro i = IdrometroLocalServiceUtil.fetchIdrometro(cm.stazione);
			
			if (i==null) {
				i = IdrometroLocalServiceUtil.createIdrometro(cm.stazione);
				IdrometroLocalServiceUtil.updateIdrometro(i);
			}
			cm.setIdrometro(i);
			if (cm.equals(condizioni.get(0))) {
				nomeRubrica = i.getNomeRubrica();
				fiume = i.getNomeBacino();
				partiFiume = i.getNomeSottobacino();
				stringaComuni = getComuniRubrica(i.getNomeRubrica());
			}
		}
		if (cm.isVarPluviometro()) {
			cm.setIdrometro(null);
			Pluviometro i = PluviometroLocalServiceUtil.fetchPluviometro(cm.stazione);
			if (i==null) {
				i = PluviometroLocalServiceUtil.createPluviometro(cm.stazione);
				PluviometroLocalServiceUtil.updatePluviometro(i);
			}
			cm.setPluviometro(i);
			if (cm.equals(condizioni.get(0))) {
				nomeRubrica = i.getNomeRubrica();
				fiume = "";
				partiFiume = "";
				stringaComuni = getComuniRubrica(i.getNomeRubrica());
			}
		}
		System.out.println(cm.lettera);
		//cm.listaStazioni = stazioniVariabili.get(cm.variabile);
		//if (cm.listaStazioni!=null) cm.stazione = cm.listaStazioni.get(0).getValue().toString();
		
		} catch (Exception ex) {
			//LogInternoLocalServiceUtil.log("allarmeBean", "stazioneChange", ex, "");
		}
	}
	
	public void variabileChange2(ValueChangeEvent e) {
		System.out.println("LISTENER");
		CondizioneManager cm = (CondizioneManager) e.getComponent().getAttributes().get("condizione");
		cm.variabile = e.getNewValue().toString();
		if (cm==null) return;
		System.out.println(cm.lettera);
		cm.listaStazioni = stazioniVariabili.get(cm.variabile);
		if (cm.listaStazioni!=null) cm.stazione = cm.listaStazioni.get(0).getValue().toString();
		
		try {
			if (cm.isVarIdrometro()) {
				cm.setPluviometro(null);
				Idrometro i = IdrometroLocalServiceUtil.fetchIdrometro(cm.stazione);
				if (i==null) {
					i = IdrometroLocalServiceUtil.createIdrometro(cm.stazione);
					IdrometroLocalServiceUtil.updateIdrometro(i);
				}
				cm.setIdrometro(i);
				if (cm.equals(condizioni.get(0))) {
					nomeRubrica = i.getNomeRubrica();
					fiume = i.getNomeBacino();
					partiFiume = i.getNomeSottobacino();
					stringaComuni = getComuniRubrica(i.getNomeRubrica());
				}
			}
			if (cm.isVarPluviometro()) {
				cm.setIdrometro(null);
				Pluviometro i = PluviometroLocalServiceUtil.fetchPluviometro(cm.stazione);
				if (i==null) {
					i = PluviometroLocalServiceUtil.createPluviometro(cm.stazione);
					PluviometroLocalServiceUtil.updatePluviometro(i);
				}
				cm.setPluviometro(i);
				if (cm.equals(condizioni.get(0))) {
					nomeRubrica = i.getNomeRubrica();
					fiume = "";
					partiFiume = "";
					stringaComuni = getComuniRubrica(i.getNomeRubrica());
				}
			}
		} catch (Exception ex) {
			//LogInternoLocalServiceUtil.log("allarmeBean", "variabileChange2", ex, "");
		}
	}

*/

	public List<RegolaManager> getRegole() {
		return regole;
	}

	public void setRegole(List<RegolaManager> regole) {
		this.regole = regole;
	}

	public List<Group> getComuni() {
		return comuni;
	}

	public void setComuni(List<Group> comuni) {
		this.comuni = comuni;
	}

	public boolean isDettaglio() {
		return dettaglio;
	}

	public void setDettaglio(boolean dettaglio) {
		this.dettaglio = dettaglio;
	}


	public RegolaAllarme getRegolaCorrente() {
		return regolaCorrente;
	}

	public void setRegolaCorrente(RegolaAllarme regolaCorrente) {
		this.regolaCorrente = regolaCorrente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getEspressione() {
		return espressione;
	}

	public void setEspressione(String espressione) {
		this.espressione = espressione;
	}

	public boolean isAttiva() {
		return attiva;
	}

	public void setAttiva(boolean attiva) {
		this.attiva = attiva;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public List<CondizioneManager> getCondizioni() {
		return condizioni;
	}

	public void setCondizioni(List<CondizioneManager> condizioni) {
		this.condizioni = condizioni;
	}

	public List<ComuneManager> getPosti() {
		return posti;
	}

	public void setPosti(List<ComuneManager> posti) {
		this.posti = posti;
	}

	public List<SelectItem> getVariabili() {
		return variabili;
	}

	public void setVariabili(List<SelectItem> variabili) {
		this.variabili = variabili;
	}

	public HashMap<String, List<SelectItem>> getStazioniVariabili() {
		return stazioniVariabili;
	}

	public void setStazioniVariabili(HashMap<String, List<SelectItem>> stazioniVariabili) {
		this.stazioniVariabili = stazioniVariabili;
	}


	public String getFiltroComuni() {
		return filtroComuni;
	}


	public void setFiltroComuni(String filtroComuni) {
		this.filtroComuni = filtroComuni;
	}
	
	
	
	public String getStringaComuni() {
		return stringaComuni;
	}


	public void setStringaComuni(String stringaComuni) {
		this.stringaComuni = stringaComuni;
	}


	public String getComuniRubrica(String org) {
		
		try {
			
			if (org==null || org.equals("")) return "NOME RUBRICA NON SPECIFICATO";
			
			Organization o = OrganizationLocalServiceUtil.fetchOrganization(20154, org);
			
			if (o==null) return "\""+org+"\" NON ESISTE IN RUBRICA";
			
			List<User> u = UserLocalServiceUtil.getOrganizationUsers(o.getOrganizationId());
			String comuni = null;
			
			
			if (u!=null) {
				for (User uu : u) {
					List<UserGroupRole> l = UserGroupRoleLocalServiceUtil.getUserGroupRoles(uu.getUserId());
					if (l!=null) {
						for (UserGroupRole ugr : l) {
							if (ugr.getRoleId()==451351) {
								//COMUNE
								Group g = GroupLocalServiceUtil.fetchGroup(ugr.getGroupId());
								if (g!=null) {
									if (comuni==null) comuni = g.getName();
									else comuni+=", "+g.getName();
								}
							}
						}
					}
				}
			}
			
			if (comuni==null) return "\""+org+"\" esiste ma non ha sindaci associati";
			else return "\""+org+"\" esiste e ha i seguenti sindaci associati: " + comuni;
			
		} catch (Exception e) {
			
			//LogInternoLocalServiceUtil.log("allarmeBean", "getComuniRubrica", e, "");
			return "";
		}
		
	}


	public String getNomeRubrica() {
		return nomeRubrica;
	}


	public void setNomeRubrica(String nomeRubrica) {
		this.nomeRubrica = nomeRubrica;
	}


	public String getFiume() {
		return fiume;
	}


	public void setFiume(String fiume) {
		this.fiume = fiume;
	}


	public String getPartiFiume() {
		return partiFiume;
	}


	public void setPartiFiume(String partiFiume) {
		this.partiFiume = partiFiume;
	}

	public boolean isIdro() {
		return (condizioni.get(0).isVarIdrometro());
	}

	public List<RegolaManager> getFiltrate() {
		return filtrate;
	}

	public void setFiltrate(List<RegolaManager> filtrate) {
		this.filtrate = filtrate;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public boolean isCanModifica() {
		return canModifica;
	}

	public void setCanModifica(boolean canModifica) {
		this.canModifica = canModifica;
	}

	public boolean isCanDisattiva() {
		return canDisattiva;
	}

	public void setCanDisattiva(boolean canDisattiva) {
		this.canDisattiva = canDisattiva;
	}
	
	
	
	
}
