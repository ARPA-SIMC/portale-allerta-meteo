package it.eng.radarMeteo.service.util;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import it.eng.radarMeteo.service.Comuni_wsServiceUtil;

@Component(
	    property = 
	        "osgi.http.whiteboard.servlet.pattern=/xmlcap",
	    service = Servlet.class
	)
public class GetXmlCapService extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String data = req.getParameter("data");
		Date d = new Date();
		if (data!=null) {
			try {
			d = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(data);
			} catch (Exception e) {}
		}
		
		Timestamp t = new Timestamp(d.getTime());
		String start = "";
		
		List<Object[]> m = Comuni_wsServiceUtil.getStatoAllertaCap(t);
		if (m==null || m.size()==0) start = "";
		else {
			
		
			
			start = "<alert xmlns=\"urn:oasis:names:tc:emergency:cap:1.2\">";
			
			Object[] primaRiga = m.get(0);
			Object dataEmissione = primaRiga[1];
			Object dataFine = primaRiga[2];
			Object dataInizio = primaRiga[4];
			Object numero = primaRiga[14];
			Object tipoAllerta = primaRiga[15];
			Object desc = primaRiga[17];
			
			start += getTag("identifier", numero);
			start += getTag("sender", "AllertaMeteoER@regione.emilia-romagna.it");
			start += getTag("sent", dataEmissione);
			start += getTag("status", "Actual");
			start += getTag("msgType", "0".equals(tipoAllerta.toString())?"Update":"Alert");
			start += getTag("source", "Operator");
			start += getTag("scope", "Public");
			start += getTag("note", desc);
			
			for (int k=0; k<m.size(); k++) {
				Object[] rigaDomani = m.get(k);
				Object[] rigaOggi = null;
				
				int id = Integer.parseInt(m.get(k)[0].toString());
				if (id<0) continue;
				rigaDomani = m.get(k);
				for (int j=0; j<m.size(); j++) {
					int id2 = Integer.parseInt(m.get(j)[0].toString());
					if (id2==-id) {
						rigaOggi = m.get(j);
						break;
					}
				}
				String area = "Emil-" + (char)('A'+id/10-1) + (id%10!=0?(char)('0'+(id%10)):"");
				start += getInfo(area, rigaDomani, rigaOggi);
			}
			
			start += "</alert>";
		}
		
		
		resp.setStatus(200);
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setContentType("application/xml");
		
		ByteBuffer bb = Charset.forName("UTF-8").encode(start);
		byte[] ba = new byte[bb.remaining()];
		
		resp.setContentLength(ba.length);
		
		bb.get(ba);
		
		resp.getOutputStream().write(ba);
		
	}
	
	String getTag(String tagName, Object content) {
		if (content==null || content.equals("")) return "<"+tagName+"/>";
		
		String contentTranslated = "";
		if (content instanceof String) contentTranslated = (String)content;
		else if (content instanceof Date) {
			ZonedDateTime i = Instant.ofEpochMilli(((Date) content).getTime()).atZone(Calendar.getInstance().getTimeZone().toZoneId());
			contentTranslated = i.toString();
		} else contentTranslated = content.toString();
		
		return "<"+tagName+">"+contentTranslated+"</"+tagName+">";
	}
	
	String getTags(String tagName, String... tags) {
		String out = "<"+tagName+">";
		for (String tag: tags) {
			out+=tag;
		}
		out+="</"+tagName+">";
		return out;
	}
	
	String getInfo(String area,Object[] riga, Object[] rigaOggi) {
		String content = "";
		String colori[] = {"VERDE","GIALLO","ARANCIONE","ROSSO"};
		String severity[] = {"Unknown","Moderate","Severe","Extreme"};
		
		int[] eventi = rigaOggi!=null? new int[18] : new int[9];
		for (int k=0; k<9; k++) eventi[k] = Integer.parseInt(riga[5+k].toString());
		if (rigaOggi!=null)
			for (int k=0; k<9; k++) eventi[k+9] = Integer.parseInt(rigaOggi[5+k].toString());
		
		int massimo = -1;
		for (int k=0; k<eventi.length; k++) if (eventi[k]!=1000 && eventi[k]>massimo) massimo = eventi[k];
		
		content += getTag("language", "it-IT");
		content += getTag("category",massimo>0?"Geo":"Met");
		content += getTag("event",colori[massimo]);
		content += getTag("responseType",massimo>0?"Prepare":"None");
		content += getTag("urgency",massimo>0?"Expected":"Unknown");
		content += getTag("severity",severity[massimo]);
		content += getTag("certainty","Likely");
		content += getTag("onset",riga[4]);
		content += getTag("expires",riga[2]);
		
		for (int k=0; k<eventi.length; k++)
			content += getParametroColore((k%9)+1, rigaOggi!=null, k<9, ""+eventi[k]);
		
		content+=getTag("area",getTag("areaDesc",area));
		
		return getTag("info",content);
	}
	
	String getParametroColore(int evento, boolean suDueGiorni, boolean domani, String colore) {
		
		if (colore==null || "white".equals(colore)) return "";
		
		String[] eventi = {"IDRAULICO","IDROGEOLOGICO","TEMPORALI","VENTO","TEMPERATURE_ESTREME","NEVE","GHIACCIO_PIOGGIA_CHE_GELA","STATO_MARE","MAREGGIATE"};
		String eventoBase = eventi[evento-1];
		if (suDueGiorni)
			if (domani) eventoBase+="_2436"; else eventoBase+="_1224";
		
		String color = "";
		if ("0".contentEquals(colore)) color = "VERDE";
		if ("1".contentEquals(colore)) color = "GIALLO";
		if ("2".contentEquals(colore)) color = "ARANCIONE";
		if ("3".contentEquals(colore)) color = "ROSSO";
		
		return getTags("parameter",getTag("valueName",eventoBase),getTag("value",color));
	}

}

