 package it.eng.allerter.allerta;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.security.auth.AuthTokenUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import it.eng.allerter.service.LogInternoLocalServiceUtil;
import it.eng.allerter.service.SMSLocalServiceUtil;
import it.eng.bollettino.cron.RisultatiAggiornamento;
import it.eng.bollettino.model.BollettinoParametro;
import it.eng.bollettino.model.StazioneVariabile;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;
import it.eng.bollettino.service.BollettinoParametroLocalServiceUtil;
import it.eng.bollettino.service.StazioneLocalServiceUtil;
import it.eng.bollettino.service.StazioneVariabileLocalServiceUtil;

public class SensoreBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean canModifica = false;
	private boolean canVede = false;
	private boolean canVedeTutto = false;
	
	public static String esitoRicarica = "";
	public static long userRicarica = -1;

	public class SensoreManager implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String idStazione;
		String idVariabile;
		String name;
		String basin;
		String subbasin;
		boolean attivo;
		boolean funzionante;
		String comuni;
		String idComuni;
		String url;
		String variabileVera;
		float sogliaSpike;
		double soglia1, soglia2, soglia3;
		public String getIdStazione() {
			return idStazione;
		}
		public void setIdStazione(String idStazione) {
			this.idStazione = idStazione;
		}
		public String getIdVariabile() {
			return idVariabile;
		}
		public void setIdVariabile(String idVariabile) {
			this.idVariabile = idVariabile;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getBasin() {
			return basin;
		}
		public void setBasin(String basin) {
			this.basin = basin;
		}
		public String getSubbasin() {
			return subbasin;
		}
		public void setSubbasin(String subbasin) {
			this.subbasin = subbasin;
		}
		public boolean isAttivo() {
			return attivo;
		}
		public void setAttivo(boolean attivo) {
			this.attivo = attivo;
		}
		public String getComuni() {
			return comuni;
		}
		public void setComuni(String comuni) {
			this.comuni = comuni;
		}
		public String getIdComuni() {
			return idComuni;
		}
		public void setIdComuni(String idComuni) {
			this.idComuni = idComuni;
		}
		
		
		
		public double getSoglia1() {
			return soglia1;
		}
		public void setSoglia1(double soglia1) {
			this.soglia1 = soglia1;
		}
		public double getSoglia2() {
			return soglia2;
		}
		public void setSoglia2(double soglia2) {
			this.soglia2 = soglia2;
		}
		public double getSoglia3() {
			return soglia3;
		}
		public void setSoglia3(double soglia3) {
			this.soglia3 = soglia3;
		}
		public float getSogliaSpike() {
			return sogliaSpike;
		}
		public void setSogliaSpike(float sogliaSpike) {
			this.sogliaSpike = sogliaSpike;
		}
		public boolean isFunzionante() {
			return funzionante;
		}
		public void setFunzionante(boolean funzionante) {
			this.funzionante = funzionante;
		}
		public String getTipo() {
			if (idVariabile==null) return "N/A";
			if (idVariabile.equals("254,0,0/1,-,-,-/B13215")) return "Idrometro";
			return "Pluviometro";
		}
		public boolean isIdro() {
			return (idVariabile!=null && idVariabile.equals("254,0,0/1,-,-,-/B13215"));
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getVariabileVera() {
			return variabileVera;
		}
		public void setVariabileVera(String variabileVera) {
			this.variabileVera = variabileVera;
		}
		
		public String getStyle() {
			if (attivo) {
				return "background-color:#77ff77; text-align:center";
			}
			else return "background-color:#ff7777; text-align:center";
		}
		public String getStyle2() {
			if (funzionante && attivo) {
				return "background-color:#77ff77; text-align:center";
			}
			else return "background-color:#ff7777; text-align:center";
		}
		public String getStyle3() {
			if (funzionante) {
				return "background-color:#77ff77; text-align:center";
			}
			else return "background-color:#ff7777; text-align:center";
		}
		
		public String getTestoAttiva() {
			if (funzionante) return "Disattiva notifica"; else return "Attiva notifica";
		}
		
	}
	
	//List<RegolaAllarme> regole;
	List<SensoreManager> regole;
	List<SensoreManager> filtrate;
	List<SensoreManager> idro;
	List<SensoreManager> pluvio;
	String filtro;
	
	String urlSensore;
	String token;
	
	List<String> comuniInteresse;
	boolean soloTuoiComuni = true;
	
	public SensoreBean(HttpServletRequest req2) {
		new SensoreBean(req2,true);
		
	}
	
	public SensoreBean(HttpServletRequest req2, boolean soloTuoi) {
		soloTuoiComuni = soloTuoi;
		init(req2);
		
	}
	
	public void caricaRegole() {
		
		regole = new ArrayList<SensoreManager>();
		List ll = BollettinoLocalServiceUtil.eseguiQueryGenericaLista("select * from sensori_comuni_vw");
		LogInternoLocalServiceUtil.log("SensoreBean", "caricaRegole", ""+ll.size(), "");
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dataFine = sdf.format(cal.getTime());
		cal.add(Calendar.DAY_OF_MONTH, -2);
		String dataInizio = sdf.format(cal.getTime());
		
		for (Object o : ll) {
			Object[] o2 = (Object[])o;
			SensoreManager rm = new SensoreManager();
			if (o2[0]!=null) rm.setIdStazione(o2[0].toString());
			if (o2[1]!=null) rm.setName(o2[1].toString());
			if (o2[2]!=null) rm.setIdVariabile(o2[2].toString());
			if (o2[3]!=null) rm.setBasin(o2[3].toString());
			if (o2[4]!=null) rm.setSubbasin(o2[4].toString());
			if (o2[5]!=null) rm.setAttivo((Boolean)o2[5]);
			if (o2[6]!=null) rm.setComuni(o2[6].toString());
			if (o2[7]!=null) rm.setIdComuni(o2[7].toString());
			if (o2[8]!=null) rm.setVariabileVera(o2[8].toString());
			if (o2[9]!=null) rm.setFunzionante((Boolean)o2[9]);
			if (o2[10]!=null) rm.setSogliaSpike((Float)o2[10]);
			if (o2.length>=14) {
				if (o2[11]!=null) rm.setSoglia1((Double)o2[11]);
				if (o2[12]!=null) rm.setSoglia2((Double)o2[12]);
				if (o2[13]!=null) rm.setSoglia3((Double)o2[13]);
			}
			
			String url = "&r=" + rm.getIdStazione() + "/" + (rm.getVariabileVera()!=null?rm.getVariabileVera():rm.getIdVariabile())
							   + "/" + dataInizio + "/" + dataFine + "&stazione=" + 
							rm.getIdStazione() + "&variabile=" + (rm.getVariabileVera()!=null?rm.getVariabileVera():rm.getIdVariabile());
			/*
			if (urlSensore != null) {
				String url = urlSensore;
				if (token!=null) url = url.replace("%TOKEN%", token);
				url = url.replace("%STAZIONE%", rm.getIdStazione());
				url = url.replace("%VARIABILE%", (rm.getVariabileVera()!=null?rm.getVariabileVera():rm.getIdVariabile()));
				url = url.replace("%DATAINIZIO%", dataInizio);
				url = url.replace("%DATAFINE%", dataFine);
				rm.setUrl(url);
			}*/
			
			rm.setUrl(url);
			
			regole.add(rm);
		}
		
		filtra();
	}
	
	public void filtra() {
		if (filtrate == null) filtrate = new ArrayList<SensoreManager>();
		else filtrate.clear();
		if (idro == null) idro = new ArrayList<SensoreManager>();
		else idro.clear();
		if (pluvio == null) pluvio = new ArrayList<SensoreManager>();
		else pluvio.clear();
		
		if (filtro==null) filtro = "";
		String f2 =  filtro.trim();
		f2 = f2.toUpperCase();
		
		for (SensoreManager rm : regole) {
			
			boolean includi = false;
			if (f2.equals("")) includi = true;
			else if (rm.name!=null && rm.name.toUpperCase().contains(f2)) includi = true;
			else if (rm.basin!=null && rm.basin.toUpperCase().contains(f2)) includi = true;
			else if (rm.subbasin!=null && rm.subbasin.toUpperCase().contains(f2)) includi = true;
			else if (rm.comuni!=null && rm.comuni.toUpperCase().contains(f2)) includi = true;
			
			if (includi && soloTuoiComuni && comuniInteresse!=null) {
				//mostra solo i sensori dei tuoi comuni
				boolean trovato = false;
				for (String com : comuniInteresse) {
					String com2 = com.toUpperCase()+"(";
					String com3 = ", "+com2;
					if (rm.comuni.contains(com3)) trovato = true;
					else if (rm.comuni.startsWith(com2)) trovato = true;
				}
				if (!trovato) includi = false;
			}
			
			if (includi) {
				filtrate.add(rm);
				if (rm.isIdro()) idro.add(rm); else pluvio.add(rm);
			}
		}
		
	}
	

	public void init(HttpServletRequest req2) {
		
		try {
			
			ThemeDisplay themeDisplay = (ThemeDisplay)req2.getAttribute(WebKeys.THEME_DISPLAY);
			long userid = themeDisplay.getUserId();
			BollettinoParametro can = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("URL_SENSORE");
			if (can!=null) {
				urlSensore = can.getValore();
			}
			
			
			token = AuthTokenUtil.getToken(req2);
			
			List<UserGroupRole> r = UserGroupRoleLocalServiceUtil.getUserGroupRoles(userid);
			List<Role> rr = RoleLocalServiceUtil.getUserRoles(userid);
			
			can = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("RUOLI_VEDI_SENSORI_COMUNE");
			if (can!=null) {
				
				String ruoli[] = can.getValore().split(",");
				for (String ruo : ruoli) {
					for (UserGroupRole rol : r) {
						if (ruo.equals(""+rol.getRoleId())) {
							if (comuniInteresse==null) comuniInteresse = new ArrayList<String>();
							Group g = GroupLocalServiceUtil.fetchGroup(rol.getGroupId());
							String group = g.getName();
							boolean trovato = comuniInteresse.contains(group);
							if (!trovato) comuniInteresse.add(group);
						}
					}
				}
				
			}
			
			
			can = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("RUOLI_ATTIVA_SENSORI");
			if (can!=null) {
				
				String ruoli[] = can.getValore().split(",");
				for (String ruo : ruoli) {
					for (Role rol : rr) {
						if (ruo.equals(""+rol.getRoleId())) {
							canModifica = true;
							canVede = true;
						}
					}
				}
			}
			
			can = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("RUOLI_VEDE_SOGLIE");
			if (can!=null) {
				
				String ruoli[] = can.getValore().split(",");
				for (String ruo : ruoli) {
					for (Role rol : rr) {
						if (ruo.equals(""+rol.getRoleId())) canVede = true;
					}
				}
			}
			
			can = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("RUOLI_VEDE_SOGLIE_TUTTO");
			if (can!=null) {
				
				String ruoli[] = can.getValore().split(",");
				for (String ruo : ruoli) {
					for (Role rol : rr) {
						if (ruo.equals(""+rol.getRoleId())) {
							canVede = true;
							canVedeTutto = true;
						}
					}
				}
			}
			
			caricaRegole();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			LogInternoLocalServiceUtil.log("sensoreBean", "init", e, "");
			
		}
		
		
	}
	
	
	
	

	public List<SensoreManager> getRegole() {
		return regole;
	}

	public void setRegole(List<SensoreManager> regole) {
		this.regole = regole;
	}


	public List<SensoreManager> getFiltrate() {
		return filtrate;
	}

	public void setFiltrate(List<SensoreManager> filtrate) {
		this.filtrate = filtrate;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<String> getComuniInteresse() {
		return comuniInteresse;
	}

	public void setComuniInteresse(List<String> comuniInteresse) {
		this.comuniInteresse = comuniInteresse;
	}

	public boolean isSoloTuoiComuni() {
		return soloTuoiComuni;
	}

	public void setSoloTuoiComuni(boolean soloTuoiComuni) {
		this.soloTuoiComuni = soloTuoiComuni;
		
		
	}

	public boolean isCanModifica() {
		return canModifica;
	}

	public void setCanModifica(boolean canModifica) {
		this.canModifica = canModifica;
	}

	public String attiva(PortletRequest req) {
		String s = ParamUtil.getString(req,"idStazione");
			
		String v = ParamUtil.getString(req,"idVariabile");  
				
		String att = ParamUtil.getString(req,"attivo");
				
		if (att.equals("true")) {
			
			BollettinoLocalServiceUtil.eseguiQueryGenerica("insert into bollettino_disattivazionesensore(idstazione,idvariabile) values('"+s+"','"+v+"')");
		} else {
			BollettinoLocalServiceUtil.eseguiQueryGenerica("delete from bollettino_disattivazionesensore where idstazione='"+s+"' and idvariabile='"+v+"'");
			
		}
		
		String style= "";
		String testo="";
		String label="";
		boolean stato = false;
				
		for (SensoreManager sm : regole) {
			
			if (sm.idStazione.equals(s) && sm.idVariabile.equals(v))  {
				sm.funzionante = !sm.funzionante;
				style = sm.getStyle3();
				testo = sm.getTestoAttiva();
				if( sm.funzionante) {
					label = "SI";
					stato = true;
				}else
					label = "NO";
			}
		}
		
		JSONObject json = JSONFactoryUtil.createJSONObject();
        json.put("style", style);
        json.put("testo", testo);
        json.put("label", label);
        json.put("stato", stato);
		
        return json.toString(); 
	}
	
	public void salvaSoglia(PortletRequest req) {
		
		String s = ParamUtil.getString(req,"idStazione");  
		String v = ParamUtil.getString(req,"idVariabile");  
		String f = ParamUtil.getString(req,"soglia");  
		String t = ParamUtil.getString(req,"type");  
		
		//float f=0.0f;
		
		/*
		for (SensoreManager sm : regole) {
			if (sm.idStazione.equals(s) && sm.idVariabile.equals(v)) f = sm.sogliaSpike;
		}*/
		
		
		BollettinoLocalServiceUtil.eseguiQueryGenerica("update bollettino_idrometro set sogliaspike = "+f+" where stazioneid='"+s+"'");
		
	}

	public List<SensoreManager> getIdro() {
		return idro;
	}

	public void setIdro(List<SensoreManager> idro) {
		this.idro = idro;
	}

	public List<SensoreManager> getPluvio() {
		return pluvio;
	}

	public void setPluvio(List<SensoreManager> pluvio) {
		this.pluvio = pluvio;
	}

	public boolean isCanVede() {
		return canVede;
	}

	public void setCanVede(boolean canVede) {
		this.canVede = canVede;
	}

	public boolean isCanVedeTutto() {
		return canVedeTutto;
	}

	public void setCanVedeTutto(boolean canVedeTutto) {
		this.canVedeTutto = canVedeTutto;
	}
	
	public String aggiornaSensori(User u) {
		String out ="";
		
		RisultatiAggiornamento ra = StazioneLocalServiceUtil.aggiornaStazioni();
		RisultatiAggiornamento ra2 = StazioneVariabileLocalServiceUtil.aggiornaSensori();
		
		out = "Risultati aggiornamento stazioni: "+ra.toString()+"<br/><br/>"+
				"Risultati aggiornamento variabili: "+ra2.toString()+"<br/><br/>";
				
				
		esitoRicarica=out;
		userRicarica = u.getUserId();
		
		String risultati = "";
		if (ra.aggiunti>0 || ra.modificati>0 || ra.rimossi>0 || ra.errore!=null) {
			if (ra.errore!=null) LogInternoLocalServiceUtil.log("dati osservati", "Aggiornamento stazioni", "Errore: "+ra.errore, "");
			else {
				risultati += "MODIFICHE ALLE STAZIONI - "+ra.toString()+" ";
				String ris = "Aggiunti "+ra.aggiunti+", modificati "+ra.modificati+", rimossi "+ra.rimossi;
				LogInternoLocalServiceUtil.log("dati osservati", "Aggiornamento stazioni", ris, "");
			}
		}
		if (ra2.aggiunti>0 || ra2.modificati>0 || ra2.rimossi>0 || ra2.errore!=null) {
			if (ra2.errore!=null) LogInternoLocalServiceUtil.log("dati osservati", "Aggiornamento sensori", "Errore: "+ra.errore, "");
			else {
				risultati += "MODIFICHE A SOGLIE O VARIABILI DEI SENSORI - "+ra2.toString()+" ";
				String ris = "Aggiunti "+ra2.aggiunti+", modificati "+ra2.modificati+", rimossi "+ra2.rimossi;
				LogInternoLocalServiceUtil.log("dati osservati", "Aggiornamento sensori", ris, "");
			}
		}
		
		try {
			if (risultati!=null && !risultati.equals("")) {
				BollettinoParametro gruppo = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("GRUPPO_ACCENSIONE_MAPPA");
				if (gruppo!=null) {
					try {
						
						
						
						long ts = new Date().getTime();
						long canaleMail[] = new long[1];
						canaleMail[0] = 1;
						SMSLocalServiceUtil.creaNotificaGruppoRubrica(canaleMail, "AllerteER", "Notifica variazioni stazioni Portale Allerte", "automatismo", "aggStazioni", ts, 20181, gruppo.getValore(), true, null);
						SMSLocalServiceUtil.eliminaDuplicatiEmail("automatismo", "aggStazioni", ts);
						SMSLocalServiceUtil.inviaEmail("automatismo", "aggStazioni", ts,
								"Notifica variazioni stazioni Portale Allerte", "Si comunicano le seguenti variazioni alle stazioni sul Portale Allerte Emilia-Romagna. "+risultati, "no-reply@regione.emilia-romagna.it");
									} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return out;
	}
	
	
	
}
