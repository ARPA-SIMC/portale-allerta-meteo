package it.eng.radarMeteo.service.util;

import com.liferay.portal.kernel.json.JSONContext;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONSerializer;
import com.liferay.portal.kernel.json.JSONTransformer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import it.eng.radarMeteo.service.Comuni_bacini_wsServiceUtil;
import it.eng.radarMeteo.service.Comuni_wsServiceUtil;

@Component(
	    immediate = true,
	    	property = 
		        "osgi.http.whiteboard.servlet.pattern=/get-bollettino-monitoraggio",
		    service = Servlet.class
	)
public class GetMonitoraggioServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Map<String,Object> m = Comuni_bacini_wsServiceUtil.getBollettinoMonitoraggio();
		JSONSerializer serializer = JSONFactoryUtil.createJSONSerializer();
		serializer.transform(new JSONTransformer() {
			
			@Override
			public void transform(JSONContext jsonContext, Object object) {
				jsonContext.writeQuoted(object!=null?new SimpleDateFormat("MMM d, yyyy hh:mm:ss a").format(object):"");
				
			}
		}, Date.class);
		serializer.transform(new JSONTransformer() {
			
			@Override
			public void transform(JSONContext jsonContext, Object object) {
				jsonContext.writeQuoted(object!=null?new SimpleDateFormat("MMM d, yyyy hh:mm:ss a").format(object):"");
				
			}
		}, Timestamp.class);
		String start = serializer.serializeDeep(m);
		
		resp.setStatus(200);
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setContentType("application/json");
		
		ByteBuffer bb = Charset.forName("UTF-8").encode(start);
		byte[] ba = new byte[bb.remaining()];
		
		resp.setContentLength(ba.length);
		
		bb.get(ba);
		
		resp.getOutputStream().write(ba);
		
	}

}
