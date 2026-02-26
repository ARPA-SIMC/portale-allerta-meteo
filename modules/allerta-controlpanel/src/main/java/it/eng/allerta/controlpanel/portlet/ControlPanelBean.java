package it.eng.allerta.controlpanel.portlet;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import it.eng.allerta.controlpanel.action.InviaSMSAction;
import it.eng.allerta.controlpanel.servlet.LogSearchServlet;
import it.eng.allerter.model.SMS;
import it.eng.allerter.service.LogInternoLocalServiceUtil;
import it.eng.allerter.service.SMSLocalServiceUtil;
import it.eng.bollettino.model.BollettinoParametro;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;
import it.eng.bollettino.service.BollettinoParametroLocalServiceUtil;

public class ControlPanelBean {
	
	static List<String>	smsHeaderNames	= new ArrayList<String>();
	static List<String>	invioHeaderNames	= new ArrayList<String>();
	
	static {
		smsHeaderNames.add("Numero tel.");
		smsHeaderNames.add("Testo");
		smsHeaderNames.add("ID/Timestamp");
		smsHeaderNames.add("Codice risposta");
		smsHeaderNames.add("Data invio");
		
		invioHeaderNames.add("Tipo");
		invioHeaderNames.add("Sottotipo");
		invioHeaderNames.add("Param");
		invioHeaderNames.add("Inviati");
		invioHeaderNames.add("Ricevuti");
		invioHeaderNames.add("% Ricezione");
		invioHeaderNames.add("Esempi");
	}
	
	
	public class SMSSContainer extends SearchContainer<SMS> {
		
		public static final String	EMPTY_RESULTS_MESSAGE	= "Nessun SMS trovato";
		public static final int DEFAULT_DELTA = 10;
		
		public SMSSContainer(PortletRequest portletRequest, PortletURL iteratorURL) {
			super(portletRequest,new DisplayTerms(portletRequest),new DisplayTerms(portletRequest),DEFAULT_CUR_PARAM, 
					DEFAULT_DELTA, 
					iteratorURL,
					smsHeaderNames, 
					EMPTY_RESULTS_MESSAGE);

			iteratorURL.setParameter("id", "SMS");
		}
		
		public SMSSContainer(PortletRequest portletRequest, PortletURL iteratorURL, String id) {
			super(portletRequest,new DisplayTerms(portletRequest),new DisplayTerms(portletRequest),id, 
					DEFAULT_DELTA, 
					iteratorURL,
					smsHeaderNames, 
					EMPTY_RESULTS_MESSAGE);
			
			iteratorURL.setParameter("id", "SMS");
			iteratorURL.setParameter("container", id);
		}
	}
	
	public class InvioSContainer extends SearchContainer<InvioBean> { 
		
		public static final String	EMPTY_RESULTS_MESSAGE	= "Nessun invio trovato.";
		public static final int DEFAULT_DELTA = 15;

		public InvioSContainer(PortletRequest portletRequest, PortletURL iteratorURL, String id) {
			super(portletRequest,new DisplayTerms(portletRequest),new DisplayTerms(portletRequest),id, 
					DEFAULT_DELTA, 
					iteratorURL,
					invioHeaderNames, 
					EMPTY_RESULTS_MESSAGE);
			
			iteratorURL.setParameter("id", "SMS");
		}
	}
	
	HttpServletRequest httpRequest = null;
	String activePanel;
	String computer;
	String nodo;
	String home;
	User utente;
	
	String logOutput;
	String logCmd;
	String logNodo;
	String logParam1;
	String logParam2;
	String logParam3;
	String logParam4;
	
	long generati;
	long inviati;
	long ricevuti;
	long errori;
	long errori2;
	String messaggio1 = "";
	String messaggio2 = "";
	String messaggio3 = "";
	String messaggio4 = "";
	
	long inviiNonRicevuti;
	int tassoMinimo;
	
	String ricevuta1 = "";
	
	String smsAttempt;
	String smsCode;
	String smsReason;
	String smsContent;
	String smsResponse;
	String smsMessage;
	String smsTimestamp;
	String smsError;
	
	String ricevutaAttempt;
	String ricevutaCode;
	String ricevutaReason;
	String ricevutaContent;
	String ricevutaResponse;
	String ricevutaMessage;
	String ricevutaTimestamp;
	String ricevutaError;
	String ricevutaData;
	String ricevutaEsito;
	
	Map<Integer,Integer> datiArrivati = new HashMap<Integer, Integer>();
	List<Object[]> risultatiQuery;
	String dbQuery="";
	
	String superamentiQuery1 = "select sr.* from (select * from (select idregola, count(case when lettera='X' then 1 else null end) as primario, " + 
			"(case when lower(espressione) like '%and%' then true else false end) as multi, " + 
			"count(*) as condizioni from vw_stato_regole where superata group by idregola,espressione) x " + 
			"where primario>0 and (not multi or condizioni>1)) z join vw_stato_regole sr on z.idregola=sr.idregola " + 
			"where lettera='X' order by nome";
	
	String datiQuery1 = "select sum(valori) from (select cast((regexp_matches(risultato,'Comunicati (.*) dati'))[1] as integer) " + 
			"as valori from allerter_loginterno where timestamp>now()-cast('DURATA' as interval) " + 
			"and cosa='dati osservati' and risultato like 'Comunicati %') x";
	
	String smsQuery1 = "select (select count(*) from allerter_sms where datainvio>now()-cast('1 day' as interval) " + 
			"		and datainvio<=now()-cast('5 minute' as interval) " + 
			"		and stato in (0,1,2)) as generati, " + 
			"(select count(*) from allerter_sms where datainvio>now()-cast('1 day' as interval) and dataack>now()-cast('5 minute' as interval) " + 
			" and stato in (3,4)) as smistati, " + 
			" (select count(*) from allerter_sms where datainvio>now()-cast('1 day' as interval) and dataricevuta>now()-cast('5 minute' as interval) " + 
			" and stato in (4,5)) as ricevuti, " + 
			" (select count(*) from allerter_sms where datainvio>now()-cast('1 day' as interval) " + 
			"		and codiceerrore is not null and codiceerrore<>'200') as errori, " + 
			" (select count(*) from allerter_sms where datainvio>now()-cast('1 day' as interval) " + 
			"		and stato=3 and descrizioneerrore is not null " + 
			" and descrizioneerrore not like 'Esito : forse%' and " + 
			" descrizioneerrore not like 'Presa in carico della campagna andata a buon fine%') as errori2";

	
	static String smsSubQuery1 = "select x.*, 1.0*ricevuti/inviati as tasso from (select tipo,sottotipo,param,testo,count(case when stato>2 then 1 else null end) " + 
			"as inviati, count(case when stato=4 then 1 else null end) as ricevuti from allerter_sms " + 
			"where datainvio>now()-cast('1 day' as interval) and " + 
			"datainvio<now()-cast('15 minute' as interval) and stato > 2 group by tipo,sottotipo,param,testo having count(*)>=50) x " + 
			"where 1.0*ricevuti/inviati<0.7";
	String smsQuery2 = "select count(*) as invii, coalesce(min(tasso),0) as mintasso from ("+smsSubQuery1+") x";
	
	static String smsSubQuery2 = "select y.*, coalesce(string_agg('Destinatario '||z.numero||', timestamp '||z.timestamp,'<br/>'),'') as esempi from " + 
			"("+smsSubQuery1+") y left join lateral (select * from allerter_sms s " + 
			"where s.tipo=y.tipo and s.sottotipo=y.sottotipo and s.param=y.param and s.stato=3 and timestamp is not null limit 5) " + 
			"z on true group by y.tipo,y.sottotipo,y.param,y.testo,y.inviati,y.ricevuti,y.tasso";
	
	public ControlPanelBean() {
	}
	
	public ControlPanelBean(HttpServletRequest request) {
		httpRequest = request;
		System.out.println(httpRequest.getParameterMap().toString());
		activePanel = ParamUtil.getString(httpRequest, "id");
		init();
	}
	
	protected void init() {
		try {
			
			if (activePanel==null || "".equals(activePanel)) activePanel="Generale";
			
			utente = PortalUtil.getUser(httpRequest);
			computer = PortalUtil.getComputerName();
			nodo = "nodo non riconosciuto";
			if (computer.contains("vm667lnx")) nodo = "nodo1";
			if (computer.contains("vm668lnx")) nodo = "nodo2";
			if (computer.contains("vm957lnx")) nodo = "nodo1";
			if (computer.contains("vm959lnx")) nodo = "nodo2";
			home = PortalUtil.getPortal().getPortalProperties().getProperty("liferay.home");
			
			if ("Log".equals(activePanel)) {
				
				logCmd="ls";
				logNodo=(nodo.equals("nodo non riconosciuto")?"nodoX":nodo);
				logParam1 = "";
				logParam2 = "";
				logParam3 = "";
				logParam4 = "";
				
				if (!ParamUtil.getString(httpRequest, "comandoLog").equals(""))
					logCmd = ParamUtil.getString(httpRequest, "comandoLog");
				if (!ParamUtil.getString(httpRequest, "nodoLog").equals(""))
					logNodo = ParamUtil.getString(httpRequest, "nodoLog");
				if (!ParamUtil.getString(httpRequest, "logParam1").equals(""))
					logParam1 = ParamUtil.getString(httpRequest, "logParam1");
				if (!ParamUtil.getString(httpRequest, "logParam2").equals(""))
					logParam2 = ParamUtil.getString(httpRequest, "logParam2");
				if (!ParamUtil.getString(httpRequest, "logParam3").equals(""))
					logParam3 = ParamUtil.getString(httpRequest, "logParam3");
				
				if (logNodo.equals("nodoX") || logNodo.equals(nodo)) {
					logOutput = LogSearchServlet.doCommand(logCmd, logParam1, logParam2, logParam3);
				} else {
					String nodoReal = "";
					if (logNodo.equals("nodo1")) nodoReal = "vm667lnx";
					if (logNodo.equals("nodo2")) nodoReal = "vm668lnx";
					logOutput = LogSearchServlet.doCommandOnNode(nodoReal,logCmd, logParam1, logParam2, logParam3);
				}
			}
			
			if ("Query".equals(activePanel)) {
				risultatiQuery = null;
				String query = ParamUtil.getString(httpRequest, "dbQuery");
				query = query.trim();
				dbQuery=query;
				boolean select = false;
				if (query.toLowerCase().startsWith("select")) select = true;
				System.out.println(query);
				if (select) {
					risultatiQuery = BollettinoLocalServiceUtil.eseguiQueryGenericaLista(query);
					System.out.println(risultatiQuery.size());
				}
				else BollettinoLocalServiceUtil.eseguiQueryGenerica(query);

			}
			
			if ("SMS".equals(activePanel)) {
				
				String numero = ParamUtil.getString(httpRequest, "testInvioNumero");
				String testo = ParamUtil.getString(httpRequest, "testInvioTesto");
				String timestamp = ParamUtil.getString(httpRequest, "testRicevutaTimestamp");
				
				if (numero!=null && !numero.equals("") && testo!=null && !testo.equals("")) {
					
					if (!numero.startsWith("+"))
						numero = "+39"+numero;
					
					Map<String,String> map = InviaSMSAction.inviaSMS(numero, testo);
					smsCode = map.get("inviosms_code");
					smsReason = map.get("inviosms_reason");
					smsContent = map.get("inviosms_content");
					smsResponse = map.get("inviosms_response");
					smsMessage = map.get("inviosms_message");
					smsError = map.get("inviosms_error");
					smsTimestamp = map.get("inviosms_timestamp");
					smsAttempt = map.get("inviosms_attempt");
				}
				
				if (timestamp!=null && !timestamp.equals("")) {
					
					Map<String,String> map = InviaSMSAction.ricevutaSMS(timestamp);
					ricevutaCode = map.get("inviosms_code");
					ricevutaReason = map.get("inviosms_reason");
					ricevutaContent = map.get("inviosms_content");
					ricevutaResponse = map.get("inviosms_response");
					ricevutaMessage = map.get("inviosms_message");
					ricevutaError = map.get("inviosms_error");
					smsTimestamp = map.get("inviosms_timestamp");
					ricevutaAttempt = map.get("inviosms_attempt");
					ricevutaData = map.get("inviosms_dataricezione");
					ricevutaEsito = map.get("inviosms_esitoricezione");
				}
				
				System.out.println("Eseguo query SMS");
				List<Object[]> o = BollettinoLocalServiceUtil.eseguiQueryGenericaLista(smsQuery1);
				System.out.println("Query 1");
				if (o!=null && o.size()>0) {
					Object[] smsdati = o.get(0);
					System.out.println("smsdati: "+smsdati);
					if (smsdati!=null) {
						System.out.println("generati: "+Long.parseLong(smsdati[0].toString()));
						generati = Long.parseLong(smsdati[0].toString());
						inviati = Long.parseLong(smsdati[1].toString());
						ricevuti = Long.parseLong(smsdati[2].toString());
						errori = Long.parseLong(smsdati[3].toString());
						errori2 = Long.parseLong(smsdati[4].toString());
					}
				} else {
					System.out.println("Query 1 null o vuota");
				}
				
				List<Object[]> o2 = BollettinoLocalServiceUtil.eseguiQueryGenericaLista(smsQuery2);
				if (o2!=null && o2.size()>0) {
					Object[] smsdati = o2.get(0);
					if (smsdati!=null) {
						inviiNonRicevuti = Long.parseLong(smsdati[0].toString());
						tassoMinimo = (int) (Double.parseDouble(smsdati[1].toString())*100.0);
					}
				}
				
				messaggio1 = "<p class=\"CLASS\">Ci sono <b>GENERATI</b> SMS in attesa di essere inviati da almeno 5 minuti. "+
				"Negli ultimi 5 minuti sono stati inviati <b>INVIATI</b> SMS. Lo stato invio &egrave; ESITO.</p>";
				
				String esito ="<b>NORMALE</b>";
				String classe = "verde";
				if (generati>0 && inviati==0) {
					esito ="<b>BLOCCO TOTALE</b>. Il problema potrebbe essere dovuto a un timeout del server, un errore di connessione oppure a un errore del servizio. In generale, non riuscendo a contattare Telecom, non sono disponibili ID per questi messaggi. Consulta gli elenchi dei messaggi in errore qui in basso per info aggiuntive.";
					classe="rosso";
				} else if (generati>0 && inviati<50) {
					esito ="<b>RALLENTAMENTO SIGNIFICATIVO</b>";
					classe="arancio";
				} else if (generati>0 && inviati<200) {
					esito ="<b>RALLENTAMENTO MODERATO</b>";
					classe="giallo";
				}
				
				messaggio1 = messaggio1.replaceAll("GENERATI", ""+generati);
				messaggio1 = messaggio1.replaceAll("INVIATI", ""+inviati);
				messaggio1 = messaggio1.replaceAll("ESITO", ""+esito);
				messaggio1 = messaggio1.replaceAll("CLASS", classe);
				
				messaggio2 = "<p>Negli ultimi 5 minuti, sono arrivate <b>RICEVUTI</b> ricevute di consegna SMS.</p>";
				messaggio2 = messaggio2.replaceAll("RICEVUTI", ""+ricevuti);
				
				messaggio3 = "<p>Nelle ultime 24 ore sono presenti <b>ERRORI</b> SMS con un errore esplicito del server (errore connessione o codice risposta diverso da 200). COMMENTO</p>";
				messaggio3 = messaggio3.replaceAll("ERRORI", ""+errori);
				String commento1 = "";
				if (errori>0 && generati>0 && inviati==0) commento1="Gli errori in questi messaggi sono probabilmente la causa del blocco in invio.";
				messaggio3 = messaggio3.replaceAll("COMMENTO", commento1);
				
				messaggio4 = "<p>Nelle ultime 24 ore sono presenti <b>ERRORI2</b> SMS presi in carico dal server ma di cui non &egrave stata tentata la consegna. ALTRO</p>";
				messaggio4 = messaggio4.replaceAll("ERRORI2", ""+errori2);
				String altro = "";
				if (errori2>0) {
					altro="La presenza di pochi messaggi in questa lista indica probabilmente un problema con questi numeri di telefono "+
				"(potrebbero non essere abilitati a ricevere SMS). La presenza di molti messaggi indica invece un probabile guasto del fornitore (i messaggi appaiono inviati ma non lo sono).";
				}
				messaggio4 = messaggio4.replaceAll("ALTRO", ""+altro);

				ricevuta1 = "<p>Ci sono <b>INVII</b> gruppi di almeno 50 SMS delle ultime 24 ore e inviati da almeno 15 minuti con percentuale di consegna inferiore al 70%. Lo stato delle ricevute di invio &egrave; ESITO</p>";
				ricevuta1 = ricevuta1.replaceAll("INVII", ""+inviiNonRicevuti);
				String esito2 = "<b>NORMALE</b>.";
				classe="verde";
				if (inviiNonRicevuti>0) {
					String tasso = " (tasso minimo di ricezione pari a "+tassoMinimo+"%). Di seguito la lista degli invii anomali, con max 10 esempi di messaggi e timestamp condivisibili con help desk Telecom.";
					if (tassoMinimo==0) {
						esito2 = "<b>ANOMALIA</b>";
						classe = "rosso";
					}
					else if (tassoMinimo<50) {
						esito2 = "<b>PROBABILE ANOMALIA</b>";
						classe = "arancio";
					}
					else {
						esito2 = "<b>POTENZIALE ANOMALIA</b>";
						classe = "giallo";
					}
					esito2 += tasso;
				}
				ricevuta1 = ricevuta1.replaceAll("ESITO", esito2);
				ricevuta1 = ricevuta1.replaceAll("CLASS", classe);
			}

			
		} catch (Exception e) {
			LogInternoLocalServiceUtil.log("ControlPanelBean", "init", e, "");
		}
	}
	
	public String getColoreRicevute() {
		if (inviiNonRicevuti==0) return "verde";
		if (tassoMinimo==0) return "rosso";
		if (tassoMinimo<50) return "arancio";
		return "giallo";
	}
	
	
	public static List<SMS> getErrori(int start, int end) {
		DynamicQuery dq = SMSLocalServiceUtil.dynamicQuery();
		dq = dq.add(PropertyFactoryUtil.forName("dataInvio").gt(new Date(new Date().getTime()-24*3600*1000)));
		dq = dq.add(PropertyFactoryUtil.forName("codiceErrore").isNotNull());
		dq = dq.add(PropertyFactoryUtil.forName("codiceErrore").ne("200"));
		dq = dq.addOrder(OrderFactoryUtil.desc("dataInvio"));
		dq.setLimit(start, end);
		return SMSLocalServiceUtil.dynamicQuery(dq);

	}
	
	public static List<SMS> getErrori2(int start, int end) {
		DynamicQuery dq = SMSLocalServiceUtil.dynamicQuery();
		Criterion cr = PropertyFactoryUtil.forName("dataInvio").gt(new Date(new Date().getTime()-24*3600*1000));
		Criterion cc = RestrictionsFactoryUtil.and(cr, PropertyFactoryUtil.forName("stato").eq(new Long(3)));
		cc = RestrictionsFactoryUtil.and(cc, PropertyFactoryUtil.forName("descrizioneErrore").isNotNull());
		cc = RestrictionsFactoryUtil.and(cc, RestrictionsFactoryUtil.not(PropertyFactoryUtil.forName("descrizioneErrore").like("Esito : forse%")));
		cc = RestrictionsFactoryUtil.and(cc, RestrictionsFactoryUtil.not(PropertyFactoryUtil.forName("descrizioneErrore").like("Presa in carico della campagna andata a buon fine%")));
		dq = dq.add(cc);
		dq = dq.addOrder(OrderFactoryUtil.desc("dataInvio"));
		dq.setLimit(start, end);
		return SMSLocalServiceUtil.dynamicQuery(dq);

	}
	
	public static List<InvioBean> getInviiNonRicevuti(int start, int end) {
		
		int results = end-start;
		List<Object[]> o = BollettinoLocalServiceUtil.eseguiQueryGenericaLista(smsSubQuery2+" limit "+results+" offset "+start);
		
		List<InvioBean> out = new ArrayList<InvioBean>();
		for (Object[] oo : o) {
			InvioBean ib = new InvioBean();
			
			if (oo[0]!=null) ib.setTipo(oo[0].toString());
			if (oo[1]!=null) ib.setSottotipo(oo[1].toString());
			if (oo[2]!=null) ib.setParam(Long.parseLong(oo[2].toString()));
			if (oo[3]!=null) ib.setTesto(oo[3].toString());
			if (oo[4]!=null) ib.setInviati(Integer.parseInt(oo[4].toString()));
			if (oo[5]!=null) ib.setRicevuti(Integer.parseInt(oo[5].toString()));
			if (oo[6]!=null) ib.setTasso(((int)(10000.0*Double.parseDouble(oo[6].toString())))/100.0);
			if (oo[7]!=null) ib.setEsempi(oo[7].toString());
			out.add(ib);
		}
		
		return out;

	}
	
	public int getDatiTempoRealeInMinuti(int minuti) {
		
		if (datiArrivati.containsKey(minuti))
			return datiArrivati.get(minuti);
		
		String x = datiQuery1;
		x = x.replaceAll("DURATA", ""+minuti+" minutes");
		Object oo = BollettinoLocalServiceUtil.eseguiQueryGenerica(x);
		Integer dati = (oo!=null? Integer.parseInt(oo.toString()):new Integer(0));
		datiArrivati.put(minuti, dati);
		return dati;
	}
	
	public SearchContainer<SMS> getSMSSearchContainer(PortletRequest portletRequest, PortletURL iteratorURL, String id) {
		return new SMSSContainer(portletRequest, iteratorURL, id);
	}
	
	public SearchContainer<InvioBean> getInvioSearchContainer(PortletRequest portletRequest, PortletURL iteratorURL, String id) {
		return new InvioSContainer(portletRequest, iteratorURL, id);
	}

	public String getComputer() {
		return computer;
	}

	public void setComputer(String computer) {
		this.computer = computer;
	}

	public User getUtente() {
		return utente;
	}

	public void setUtente(User utente) {
		this.utente = utente;
	}

	public String getNodo() {
		return nodo;
	}

	public void setNodo(String nodo) {
		this.nodo = nodo;
	}

	public String getActivePanel() {
		return activePanel;
	}

	public void setActivePanel(String activePanel) {
		this.activePanel = activePanel;
	}

	public long getGenerati() {
		return generati;
	}

	public void setGenerati(long generati) {
		this.generati = generati;
	}

	public long getInviati() {
		return inviati;
	}

	public void setInviati(long inviati) {
		this.inviati = inviati;
	}

	public long getRicevuti() {
		return ricevuti;
	}

	public void setRicevuti(long ricevuti) {
		this.ricevuti = ricevuti;
	}

	public int getErrori() {
		return (int)errori;
	}

	public void setErrori(int errori) {
		this.errori = errori;
	}

	public int getErrori2() {
		return (int)errori2;
	}

	public void setErrori2(int errori2) {
		this.errori2 = errori2;
	}

	public String getMessaggio1() {
		return messaggio1;
	}

	public void setMessaggio1(String messaggio1) {
		this.messaggio1 = messaggio1;
	}

	public String getMessaggio2() {
		return messaggio2;
	}

	public void setMessaggio2(String messaggio2) {
		this.messaggio2 = messaggio2;
	}

	public String getMessaggio3() {
		return messaggio3;
	}

	public void setMessaggio3(String messaggio3) {
		this.messaggio3 = messaggio3;
	}

	public String getMessaggio4() {
		return messaggio4;
	}

	public void setMessaggio4(String messaggio4) {
		this.messaggio4 = messaggio4;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getLogOutput() {
		return logOutput;
	}

	public void setLogOutput(String logOutput) {
		this.logOutput = logOutput;
	}

	public String getRicevuta1() {
		return ricevuta1;
	}

	public void setRicevuta1(String ricevuta1) {
		this.ricevuta1 = ricevuta1;
	}

	public int getInviiNonRicevuti() {
		return (int)inviiNonRicevuti;
	}

	public void setInviiNonRicevuti(int inviiNonRicevuti) {
		this.inviiNonRicevuti = inviiNonRicevuti;
	}

	public String getLogCmd() {
		return logCmd;
	}

	public void setLogCmd(String logCmd) {
		this.logCmd = logCmd;
	}

	public String getLogParam1() {
		return logParam1;
	}

	public void setLogParam1(String logParam1) {
		this.logParam1 = logParam1;
	}

	public String getLogParam2() {
		return logParam2;
	}

	public void setLogParam2(String logParam2) {
		this.logParam2 = logParam2;
	}

	public String getLogParam3() {
		return logParam3;
	}

	public void setLogParam3(String logParam3) {
		this.logParam3 = logParam3;
	}

	public String getLogParam4() {
		return logParam4;
	}

	public void setLogParam4(String logParam4) {
		this.logParam4 = logParam4;
	}

	public String getLogNodo() {
		return logNodo;
	}

	public void setLogNodo(String logNodo) {
		this.logNodo = logNodo;
	}

	public String getSmsCode() {
		return smsCode;
	}

	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}

	public String getSmsReason() {
		return smsReason;
	}

	public void setSmsReason(String smsReason) {
		this.smsReason = smsReason;
	}

	public String getSmsContent() {
		return smsContent;
	}

	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}

	public String getSmsResponse() {
		return smsResponse;
	}

	public void setSmsResponse(String smsResponse) {
		this.smsResponse = smsResponse;
	}

	public String getSmsMessage() {
		return smsMessage;
	}

	public void setSmsMessage(String smsMessage) {
		this.smsMessage = smsMessage;
	}

	public String getSmsTimestamp() {
		return smsTimestamp;
	}

	public void setSmsTimestamp(String smsTimestamp) {
		this.smsTimestamp = smsTimestamp;
	}

	public String getSmsError() {
		return smsError;
	}

	public void setSmsError(String smsError) {
		this.smsError = smsError;
	}

	public String getSmsAttempt() {
		return smsAttempt;
	}

	public void setSmsAttempt(String smsAttempt) {
		this.smsAttempt = smsAttempt;
	}

	public String getRicevutaAttempt() {
		return ricevutaAttempt;
	}

	public void setRicevutaAttempt(String ricevutaAttempt) {
		this.ricevutaAttempt = ricevutaAttempt;
	}

	public String getRicevutaCode() {
		return ricevutaCode;
	}

	public void setRicevutaCode(String ricevutaCode) {
		this.ricevutaCode = ricevutaCode;
	}

	public String getRicevutaReason() {
		return ricevutaReason;
	}

	public void setRicevutaReason(String ricevutaReason) {
		this.ricevutaReason = ricevutaReason;
	}

	public String getRicevutaContent() {
		return ricevutaContent;
	}

	public void setRicevutaContent(String ricevutaContent) {
		this.ricevutaContent = ricevutaContent;
	}

	public String getRicevutaResponse() {
		return ricevutaResponse;
	}

	public void setRicevutaResponse(String ricevutaResponse) {
		this.ricevutaResponse = ricevutaResponse;
	}

	public String getRicevutaMessage() {
		return ricevutaMessage;
	}

	public void setRicevutaMessage(String ricevutaMessage) {
		this.ricevutaMessage = ricevutaMessage;
	}

	public String getRicevutaTimestamp() {
		return ricevutaTimestamp;
	}

	public void setRicevutaTimestamp(String ricevutaTimestamp) {
		this.ricevutaTimestamp = ricevutaTimestamp;
	}

	public String getRicevutaError() {
		return ricevutaError;
	}

	public void setRicevutaError(String ricevutaError) {
		this.ricevutaError = ricevutaError;
	}

	public String getRicevutaData() {
		return ricevutaData;
	}

	public void setRicevutaData(String ricevutaData) {
		this.ricevutaData = ricevutaData;
	}

	public String getRicevutaEsito() {
		return ricevutaEsito;
	}

	public void setRicevutaEsito(String ricevutaEsito) {
		this.ricevutaEsito = ricevutaEsito;
	}

	public List<Object[]> getRisultatiQuery() {
		return risultatiQuery;
	}

	public void setRisultatiQuery(List<Object[]> risultatiQuery) {
		this.risultatiQuery = risultatiQuery;
	}

	public String getDbQuery() {
		return dbQuery;
	}

	public void setDbQuery(String dbQuery) {
		this.dbQuery = dbQuery;
	}

	

}
