package allerta.search.objects;

import com.liferay.portal.kernel.json.JSONFactoryUtil;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import allerta.search.objects.searchables.SearchFactory;

@Component(
	    immediate = true,
	    property = {
	        "osgi.http.whiteboard.context.path=/",
	        "osgi.http.whiteboard.servlet.pattern=/feed/*"
	    },
	    service = Servlet.class
	)
public class SearchableFeedServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String request = req.getRequestURI();
		String parts[] = request.split("/");
		String tipoFeed = parts[parts.length-1];
		
		Searchable archivio = SearchFactory.getSearchable(tipoFeed);
		if (archivio==null) {
			resp.setStatus(404);
			return;
		}

		String command = req.getParameter("filter");

		
		Map<String, String> params = new HashMap<String, String>();
		for (String s : req.getParameterMap().keySet()) {
			params.put(s,req.getParameterMap().get(s)[0]);
		}
		
		params.put("limit", "20");
		params.put("feed", "true");
		
		List<FeedResult> out = null;
		

		out = archivio.feed(params);
		
		String entries = "";
		for (FeedResult fr : out) {
			entries+="<entry>"+
				"<title>"+fr.title+"</title>"+
				"<link href=\""+fr.link+"\" />" +
				"<id>"+fr.id+"</id>"+
				"<updated>"+fr.updated+"</updated>"+
				"<summary>"+fr.summary+"</summary>"+
				"</entry>"; 
		}

		
		String risultato = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
				+ "<feed xmlns=\"http://www.w3.org/2005/Atom\">"
				+ "<title>"+archivio.getFeedTitle()+"</title>"
				+ "<link href=\"https://allertameteo.regione.emilia-romagna.it/"+archivio.getFeedLink()+"\" />"
				+ "<updated>"+(out.size()>0 && out.get(0)!=null && out.get(0).getUpdated()!=null?out.get(0).getUpdated():"")+"</updated>"
				+ "<author><name>"+archivio.getFeedAuthor()+"</name></author>"
				+ "<id>allerteER:feed:"+archivio.getFeedId()+"</id>"+entries+"</feed>";
 		
		resp.setStatus(200);
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setContentType("application/atom+xml");
		
		ByteBuffer bb = Charset.forName("UTF-8").encode(risultato);
		byte[] ba = new byte[bb.remaining()];
		
		resp.setContentLength(ba.length);
		
		bb.get(ba);
		
		resp.getOutputStream().write(ba);
	}

}
