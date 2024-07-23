package it.eng.allerter.allerta;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import it.eng.bollettino.service.BollettinoLocalServiceUtil;

@Component(
	    immediate = true,
	    property = {
	        "osgi.http.whiteboard.context.path=/",
	        "osgi.http.whiteboard.servlet.pattern=/badge.js"
	    },
	    service = Servlet.class
	)
public class BadgeJSServlet  extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2782609832922640930L;


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setStatus(200);
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setContentType("text/javascript");
		
		ByteBuffer bb = Charset.forName("UTF-8").encode(getTesto("js"));
		byte[] ba = new byte[bb.remaining()];
		
		resp.setContentLength(ba.length);
		
		bb.get(ba);
		
		resp.getOutputStream().write(ba);
		
	}
	
	
	public String getTesto (String id) {
		id=id.replace("'", "");
		id=id.replace(";", "");
		id=id.replace(",", "");
		id=id.replace("\"", "");
		id=id.replace("(", "");
		id=id.replace(")", "");
		String testo = (String) BollettinoLocalServiceUtil.eseguiQueryGenerica("select testo from api_badge where id='"+id+"'");
		
		testo = testo.replaceAll("%baseurl%", BadgeServlet.BASE_URL);
		return testo;
	}
}