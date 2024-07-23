package allerta.search.objects;

import com.liferay.portal.kernel.json.JSONFactoryUtil;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
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
	        "osgi.http.whiteboard.servlet.pattern=/object-search"
	    },
	    service = Servlet.class
	)
public class SearchServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String obj = req.getParameter("object");
		String command = req.getParameter("command");
		
		if (obj==null || command==null) return;
		
		Searchable archivio = SearchFactory.getSearchable(obj);
		if (archivio==null) return;
		
		Map<String, String> params = new HashMap<String, String>();
		for (String s : req.getParameterMap().keySet()) {
			if (!s.equals("object") && !s.equals("command")) params.put(s,req.getParameterMap().get(s)[0]);
		}
		
		Object out = null;
		
		for (String key : params.keySet()) {
			
			String value = params.get(key);
			value = value.replaceAll("'", "''");
			value = value.replaceAll("\"", "");
			value = value.replaceAll("\\(", "");
			value = value.replaceAll("\\)", "");
			value = value.replaceAll("&", "");
			value = value.replaceAll("\\\\", "");
			value = value.replaceAll(",", " ");
			value = value.replaceAll(";", " ");
			value = value.trim();
			if (!"".equals(value)) params.put(key, value);
			else params.remove(key);
		}
		
		if (command.equals("countYears")) {
			out = archivio.countByYear(params);
		} else if (command.equals("countMonths")) {
			out = archivio.countByMonth(params);
		} else if (command.equals("search")) {
			out = archivio.search(params);
		}
		
		String risultato = JSONFactoryUtil.looseSerializeDeep(out);
		if (risultato==null) risultato = "{}";
 		
		resp.setStatus(200);
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setContentType("application/json");
		
		ByteBuffer bb = Charset.forName("UTF-8").encode(risultato);
		byte[] ba = new byte[bb.remaining()];
		
		resp.setContentLength(ba.length);
		
		bb.get(ba);
		
		resp.getOutputStream().write(ba);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

}
