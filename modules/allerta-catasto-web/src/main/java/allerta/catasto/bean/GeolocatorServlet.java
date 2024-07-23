package allerta.catasto.bean;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    property = {
	        "osgi.http.whiteboard.context.path=/",
	        "osgi.http.whiteboard.servlet.pattern=/geolocator"
	    },
	    service = Servlet.class
	)
public class GeolocatorServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		GeoLocator gl = new GeoLocator();
		
		String comune = req.getParameter("comune");
		String provincia = req.getParameter("provincia");
		String indirizzo = req.getParameter("indirizzo");
		String civico = req.getParameter("civico");
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("comune", comune);
		hm.put("provincia", provincia);
		hm.put("indirizzo", indirizzo);
		hm.put("civico", civico);
		
		try {
			HashMap<String, Object> out = gl.locate(hm);
			
			resp.setStatus(200);
			resp.setHeader("Access-Control-Allow-Origin", "*");
			resp.setContentType("application/json");
			
			String testo = "";
			for (String k : out.keySet()) {
				Object o = out.get(k);
				if (o==null) continue;
				if (!"".contentEquals(testo)) testo+=", ";
				testo+="\""+k+"\""+":";
				
				boolean str = (o instanceof String);
				if (str) testo+="\"";
				testo+=o.toString();
				if (str) testo+="\"";
			}
			testo = "{"+testo+"}";
			
			ByteBuffer bb = Charset.forName("UTF-8").encode(testo);
			byte[] ba = new byte[bb.remaining()];
			
			resp.setContentLength(ba.length);
			
			bb.get(ba);
			
			resp.getOutputStream().write(ba);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(404);
			return;
		}
	}
}
