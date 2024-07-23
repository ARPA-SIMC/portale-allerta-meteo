package it.eng.allerter.allerta;

import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringEscapeUtils;
import org.osgi.service.component.annotations.Component;

import it.eng.allerter.model.Allerta;
import it.eng.allerter.model.AllertaValanghe;
import it.eng.allerter.model.AllertaValangheStato;
import it.eng.allerter.service.AllertaLocalServiceUtil;
import it.eng.allerter.service.AllertaServiceUtil;
import it.eng.allerter.service.AllertaValangheLocalServiceUtil;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;

@Component(
	    immediate = true,
	    property = {
	        "osgi.http.whiteboard.context.path=/",
	        "osgi.http.whiteboard.servlet.pattern=/badge"
	    },
	    service = Servlet.class
	)
public class BadgeServlet  extends HttpServlet {
	
	static String areeNuove[] =
		{"A1","A2","B1","B2","C1","C2","D1","D2","D3","E1","E2","F1","F2","F3","G1","G2","H1","H2"};
	
	
	public static String BASE_URL1 = "http://localhost:8080";
	public static String BASE_URL = BASE_URL1+"/";
	/**
	 * 
	 */
	private static final long serialVersionUID = -339602787309949658L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = null;
		try {
			
			String cpu = PortalUtil.getComputerName();
			if (cpu!=null && cpu.contains("vm"))
			{
				BASE_URL1 = "https://allertameteo.regione.emilia-romagna.it";
				BASE_URL = BASE_URL1+"/";
			}
			
			String feed = req.getParameter("t");
			if (feed==null) {
				resp.setStatus(404);
				return;
			}
			
			String ts = req.getParameter("ts");
			Date tts = null;
			if (ts!=null) {
				tts = new SimpleDateFormat("dd/MM/yyyy").parse(ts);
			}

			String g = req.getParameter("g");
			int giorno = 0;
			if (g!=null && "1".equals(g)) giorno = 1;
			
			String comune = req.getParameter("comune");
			String zona = null;
			String zonaV = null;
			if (comune!=null) {
				comune=StringEscapeUtils.escapeSql(comune).toUpperCase();
				comune=comune.replace(";", "");
				comune=comune.replace(",", "");
				comune=comune.replace("\"", "");
				comune=comune.replace("(", "");
				comune=comune.replace(")", "");
				comune=comune.replace("%20", " ");
				if (comune.length()==5) comune = "0" + comune;
				Object[] result = (Object[]) BollettinoLocalServiceUtil.eseguiQueryGenerica("select nome,area from storico_aree where istat='"+
						comune+"' and tipo='M' and data_inizio<=current_date and data_fine>=current_date");
				
				if (result==null) {
					resp.setStatus(404);
					return;
				}
				
				comune = (String)result[0];
				zona = (String)result[1];
				
				if (comune==null || zona==null) {
					resp.setStatus(404);
					return;
				}
				
				
				
				zonaV = (String)BollettinoLocalServiceUtil.eseguiQueryGenerica("select area from storico_aree where nome='"+
						comune+"' and tipo='V' and data_inizio<=current_date and data_fine>=current_date");
			
			
				if (zonaV!=null) {
					zonaV = zonaV.replace("Appennino Emiliano Occidentale", "V1");
					zonaV = zonaV.replace("Appennino Emiliano Centrale", "V2");
					zonaV = zonaV.replace("Appennino Romagnolo", "V3");
				}
			}
			
			
		
			
			String testo = getTesto(feed);
			
			if (testo==null) {
				resp.setStatus(404);
				return;
			}
			
			while (testo.contains("%import(")) {
				int index = testo.indexOf("%import(");
				int index2 = testo.indexOf(")",index);
				String sub = testo.substring(index+8, index2);
				String imported = getTesto(sub);
				testo = testo.replace("%import("+sub+")%", imported);
			}
			
			String out ="";
			String overallColor = "white";
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
			
			ArrayList<Map<String, String>> oggi = AllertaServiceUtil.getStatoAllerta();
			ArrayList<Map<String, String>> domani = AllertaServiceUtil.getStatoAllertaDomani();
			
			HashMap<String, String> worst = new HashMap<String, String>();
			HashMap<String, String> events = new HashMap<String, String>();
			
			ArrayList<Map<String, String>> lista = (giorno==0?oggi:domani);
			
			for (Map<String,String> x : lista) {
				String area = x.get("area");
				String eventi = x.get("eventi");
				String[] ev2 = eventi.split(",");
				for (String evD : ev2) {
					String[] dett = evD.split(":");
					String evento = dett[0];
					String colore = dett[1];
					if (area.equals(zona) || area.equals(zonaV)) {
						testo = testo.replace("%area_"+evento+"%", colore);
						testo = testo.replace(("%area_"+evento+"_colore%"), getColor(colore));
						
					}
					int index = getIndex(colore);
					if (!worst.containsKey(area) || getIndex(worst.get(area))<index)
						worst.put(area, colore);
					
					if (!events.containsKey(evento) || getIndex(events.get(evento))<index)
						if ((zona==null || area.equals(zona) || area.equals(zonaV))) events.put(evento, colore);
					
					if (getIndex(overallColor)<index && (zona==null || area.equals(zona) || area.equals(zonaV))) overallColor=colore;
				}
			}
			
			testo = testo.replace("%colore_globale%", overallColor);
			testo = testo.replace("%nome_colore_globale%", getColor(overallColor));
			if (comune!=null) {
				testo = testo.replace("%comune%",comune.toUpperCase());
				testo = testo.replace("%comune_on%","on");
			} else testo = testo.replace("%comune_on%","off");
			if (zona!=null)  {
				testo = testo.replace("%zona%",zona);
				testo = testo.replace("%zona_on%","on");
			}
			else {
				testo = testo.replace("%zona%","");
				testo = testo.replace("%zona_on%","off");
			}
			
			if (zonaV!=null) {
				testo = testo.replace("%zona_valanghe%",zonaV);
				testo = testo.replace("%zona_valanghe_on%","on");
			}
			else {
				testo = testo.replace("%zona_valanghe%","");
				testo = testo.replace("%zona_valanghe_on%","off");
			}
			
			for (String x : worst.keySet()) {
				testo = testo.replace("%"+x+"%", worst.get(x));
				
			}
			
			for (String x : events.keySet()) {
				testo = testo.replace("%"+x+"%", events.get(x));
				testo = testo.replace("%"+x+"_colore%", getColor(events.get(x)));
			}
			
			if (!events.containsKey("valanghe")) {
				testo = testo.replace("%valanghe%", "white");
				testo = testo.replace("%valanghe_colore%", "BIANCO");
			}
			
			Allerta a = getAllerta(giorno,tts);
			if (a!=null) {
				testo = testo.replace("%titolo_allerta%", a.getTitolo());
				testo = testo.replace("%link_allerta%", BASE_URL1+a.getLink());
			}
			
			AllertaValanghe av = getAllertaValanghe(giorno);
			if (av!=null) {
				
				testo = testo.replace("%titolo_allerta_valanghe%", av.getTitolo());
				testo = testo.replace("%link_allerta_valanghe%", BASE_URL1+av.getLink());
				testo = testo.replace("%allerta_valanghe%", "on");
			} else {
				testo = testo.replace("%titolo_allerta_valanghe%", "");
				testo = testo.replace("%link_allerta_valanghe%", "");
				testo = testo.replace("%allerta_valanghe%", "off");
				
			}
			
			testo = testo.replace("%path%", BASE_URL+"o/it.eng.allerta.compila/img");
			testo = testo.replaceAll("%baseurl%", BASE_URL);
			
			String mappa = "";
			for (String x : areeNuove) {
				String col = worst.get(x);
				if (col==null) col = "white";
				mappa+=getColorInitial(col);
				
			}
			testo = testo.replace("%mappa%", BASE_URL+"o/allerta-img?param="+mappa);
			
			resp.setStatus(200);
			resp.setHeader("Access-Control-Allow-Origin", "*");
			resp.setHeader("Content-Security-Policy", "frame-ancestors *");
			resp.setContentType("text/html");
			
			ByteBuffer bb = Charset.forName("UTF-8").encode(testo);
			byte[] ba = new byte[bb.remaining()];
			
			resp.setContentLength(ba.length);
			
			bb.get(ba);
			
			resp.getOutputStream().write(ba);
			
		} catch (Exception e) {
			try {
				//LogInternoLocalServiceUtil.log("FeedServlet", "doGet", e, "");
				if (connection!=null && !connection.isClosed()) connection.close();
			} catch (Exception e2) {}
			e.printStackTrace();
		}
	}
	
	private int getIndex(String s) {
		String[] colors = {"white","green","yellow","orange","red"};
		for (int k=0; k<colors.length; k++) if (colors[k].equals(s)) return k;
		return -1;
	}
	
	private String getColor(String s) {
		String[] colors = {"white","green","yellow","orange","red"};
		String[] colori = {"BIANCO","VERDE","GIALLO","ARANCIONE","ROSSO"};
		
		for (int k=0; k<colors.length; k++) if (colors[k].equals(s)) return colori[k];
		return "";
	}
	
	private String getColorInitial(String s) {
		String[] colors = {"white","green","yellow","orange","red"};
		String[] colori = {"X","V","G","A","R"};
		
		for (int k=0; k<colors.length; k++) if (colors[k].equals(s)) return colori[k];
		return "";
	}
	
	public String getTesto (String id) {
		id=id.replace("'", "");
		id=id.replace(";", "");
		id=id.replace(",", "");
		id=id.replace("\"", "");
		id=id.replace("(", "");
		id=id.replace(")", "");
		String testo = (String) BollettinoLocalServiceUtil.eseguiQueryGenerica("select testo from api_badge where id='"+id+"'");
		return testo;
	}
	
	public Allerta getAllerta(int giorni,Date ts) {
		
		String timestamp = (giorni==0? "current_timestamp" : "current_timestamp + interval '"+giorni+" days'");
		if (ts!=null) {
			timestamp = "'" + new SimpleDateFormat("yyyy-MM-dd").format(ts) + " 03:00:00'";
		}
	
		String query = "select allertaid from allerter_allerta a where datainizio<"+timestamp+" "
						+ "	and datafine>"+timestamp+" and stato=0 "
						+ " and not exists (select allertaid from allerter_allerta a2 where "
						+ " a2.stato=0 and a2.dataemissione>a.dataemissione "
						+ " and a2.datainizio<="+timestamp
						+ " and a2.datafine>="+timestamp+") order by dataemissione desc limit 1";
						;
		
			Object o = BollettinoLocalServiceUtil.eseguiQueryGenerica(query);
			if (o==null) return null;
			return AllertaLocalServiceUtil.fetchAllerta(Long.parseLong(o.toString()));
		
	}
	
	public AllertaValanghe getAllertaValanghe(int giorni) {
		
		String timestamp = (giorni==0? "current_timestamp" : "current_timestamp + interval '"+giorni+" days'");
		
	
		String query = "select allertavalangheid from allerter_allertavalanghe a where datainizio<"+timestamp+" "
						+ "	and datafine>"+timestamp+" and stato=0 "
						+ " and not exists (select allertavalangheid from allerter_allertavalanghe a2 where "
						+ " a2.stato=0 and a2.dataemissione>a.dataemissione "
						+ " and a2.datainizio<="+timestamp
						+ " and a2.datafine>="+timestamp+") order by dataemissione desc limit 1";
						;
		
			Object o = BollettinoLocalServiceUtil.eseguiQueryGenerica(query);
			if (o==null) return null;
			return AllertaValangheLocalServiceUtil.fetchAllertaValanghe(Long.parseLong(o.toString()));
		
	}
	
	public List<Object> getMacroaree(String timestamp) {
		String query = "select abs(x.areaid) as areaid,x.eventi from ("+
				"select allertaid, areaid, string_agg('' || eventoid || ':' || statoid,',') as eventi "
				+ " from allerter_allertastato ass where allertaid = "
						+ "(select allertaid from allerter_allerta a where datainizio<"+timestamp+" "
						+ "	and datafine>"+timestamp+" and stato=0 "
						+ " and not exists (select allertaid from allerter_allerta a2 where "
						+ " a2.stato=0 and a2.dataemissione>a.dataemissione "
						+ " and a2.datainizio<="+timestamp
						+ " and a2.datafine>="+timestamp+") order by dataemissione desc limit 1) " 
						+ " group by allertaid, areaid  order by areaid) x "
						+ " join allerter_allerta aa on aa.allertaid=x.allertaid "
						+ " where aa.parentid=0 or (date("+timestamp+")=date(aa.datainizio) and x.areaid<0) "
						+ " or (date("+timestamp+")<>date(aa.datainizio) and x.areaid>0)";
						;
						
			return BollettinoLocalServiceUtil.eseguiQueryGenericaLista(query);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	

}
