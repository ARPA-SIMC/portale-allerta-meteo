package it.eng.allerta.rest.application.service;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONSerializer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.eng.allerter.service.AllertaService;

@Component(
	    immediate = true,
	    property = {
	        "osgi.http.whiteboard.context.path=/",
	        "osgi.http.whiteboard.servlet.pattern=/primes/get-primes-domani"
	    },
	    service = Servlet.class
	)
public class PrimesDomaniServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		JSONSerializer serializer = JSONFactoryUtil.createJSONSerializer();
		String jsonData = serializer.serializeDeep(allertaService.getStatoAllertaPrimesDomani());
		
		resp.setStatus(200);
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setContentType("application/json");
		
		ByteBuffer bb = Charset.forName("UTF-8").encode(jsonData);
		byte[] ba = new byte[bb.remaining()];
		
		resp.setContentLength(ba.length);
		
		bb.get(ba);
		
		resp.getOutputStream().write(ba);
		
	}
	
	@Reference
	private AllertaService allertaService;

}
