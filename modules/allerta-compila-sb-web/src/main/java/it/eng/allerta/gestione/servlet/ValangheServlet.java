package it.eng.allerta.gestione.servlet;

import com.liferay.portal.kernel.json.JSONContext;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONSerializer;
import com.liferay.portal.kernel.json.JSONTransformer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	        "osgi.http.whiteboard.servlet.pattern=/api/stato-valanghe"
	    },
	    service = Servlet.class
	)
public class ValangheServlet extends HttpServlet {
	
	
	String coloreString(int n) {
		if (n==0) return "green";
		if (n==1) return "yellow";
		if (n==2) return "orange";
		if (n==3) return "red";
		return "";
	}
	
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
		JSONSerializer serializer = JSONFactoryUtil.createJSONSerializer();
		serializer.transform(new JSONTransformer() {
			
			@Override
			public void transform(JSONContext jsonContext, Object object) {
				jsonContext.writeQuoted(object!=null?new SimpleDateFormat("MMM d, yyyy hh:mm:ss a").format(object):"");
				
			}
		}, Date.class);
			
		String dates = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(d);
		String q = "select av.titolo, av.descrizionefenomeni, av.datainizio, av.datafine, a1.statoid as s1, " + 

				"a2.statoid as s2, a3.statoid as s3 from allerter_allertavalanghe av "+
				"left join allerter_allertavalanghestato a1 on av.allertavalangheid=a1.allertavalangheid and a1.areaid=10 " + 
				"left join allerter_allertavalanghestato a2 on av.allertavalangheid=a2.allertavalangheid and a2.areaid=20 " + 
				"left join allerter_allertavalanghestato a3 on av.allertavalangheid=a3.allertavalangheid and a3.areaid=30 " + 
				
				
				"where av.datainizio<'"+dates+"' and av.datafine>='"+dates+
				"' and av.stato=0 order by av.dataemissione desc limit 1";
		List<Object[]> l = BollettinoLocalServiceUtil.eseguiQueryGenericaLista(q);
		
		String outcome = "{}";
		
		if (l!=null && l.size()>0) {
			Object[] o = l.get(0);
			Map<String,Object> m = new HashMap<String, Object>();
			m.put("titolo",o[0]);
			m.put("descrizione",o[1]);
			m.put("datainizio",o[2]);
			m.put("datafine",o[3]);
			m.put("appennino_occidentale",coloreString(Integer.parseInt(o[4].toString())));
			m.put("appennino_centrale",coloreString(Integer.parseInt(o[5].toString())));
			m.put("appennino_romagnolo",coloreString(Integer.parseInt(o[6].toString())));
			outcome = serializer.serialize(m);
		}

		
		
		resp.setStatus(200);
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setContentType("application/json");
		
		ByteBuffer bb = Charset.forName("UTF-8").encode(outcome);
		byte[] ba = new byte[bb.remaining()];
		
		resp.setContentLength(ba.length);
		
		bb.get(ba);
		
		resp.getOutputStream().write(ba);
		
	}

}
