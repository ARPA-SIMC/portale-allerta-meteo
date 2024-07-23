package it.eng.allerter.allerta;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.util.InfrastructureUtil;

import it.eng.allerter.model.Feed;
import it.eng.allerter.service.FeedLocalServiceUtil;
import it.eng.allerter.service.LogInternoLocalServiceUtil;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;

@Component(
	    immediate = true,
	    property = {
	        "osgi.http.whiteboard.context.path=/",
	        "osgi.http.whiteboard.servlet.pattern=/compila-allerta-portlet/feed"
	    },
	    service = Servlet.class
	)
public class FeedServlet  extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = null;
		try {
			
			String feed = req.getParameter("feed");
			if (feed==null) {
				resp.setStatus(404);
				return;
			}
			
			Feed f = FeedLocalServiceUtil.fetchFeed(feed);
			if (f==null) {
				resp.setStatus(404);
				return;
			}
			
			String out ="";
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
			
			List<Object[]> l = BollettinoLocalServiceUtil.eseguiQueryGenericaLista(f.getQuery());
			if (l==null) return;
			
			String lastDate = null;
			Date las = null;
			for (Object[] o : l) {
				String title = (String) o[0];
				String link = (String) o[1];
				String id = (String) o[2];
				Date updated = (Date) o[3];
				if (updated==null) updated = new Date();
				String dat = sdf.format(updated)+"T"+sdf2.format(updated)+"Z";
				if (las==null || updated.after(las)) {
					lastDate = dat;
					las = updated;
				}
				String summary = (String) o[4];
				String entryString = "<entry><title>"+title+"</title><link href=\""+link+"\"/><id>"+link+"</id><updated>"+dat+"</updated><summary>"+summary+"</summary></entry>";
				out+=entryString;
			}
			
			String start = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
			start+="<feed xmlns=\"http://www.w3.org/2005/Atom\">";
			start+="<title>"+f.getTitolo()+"</title>";
			start+="<link href=\""+f.getLink()+"\" />";
			start+="<updated>"+lastDate+"</updated>";
			if (f.getAutore()!=null)
				start+="<author><name>"+f.getAutore()+"</name></author>";
			start+="<id>allerteER:feed:"+f.getFeedId()+"</id>";
			start += out;
			start+="</feed>";
			
			resp.setStatus(200);
			resp.setHeader("Access-Control-Allow-Origin", "*");
			resp.setContentType("application/atom+xml");
			
			ByteBuffer bb = Charset.forName("UTF-8").encode(start);
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
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	

}
