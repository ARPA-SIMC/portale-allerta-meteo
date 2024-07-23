package it.eng.allerter.allerta;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.InfrastructureUtil;

import it.eng.allerta.utils.AllertaTracker;
import it.eng.allerter.service.LogInternoLocalServiceUtil;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
//import net.sf.jasperreports.engine.util.JRProperties;

@Component(
	    immediate = true,
	    property = {
	        "osgi.http.whiteboard.context.path=/",
	        "osgi.http.whiteboard.servlet.pattern=/report/sc/*"
	    },
	    service = Servlet.class
	)
public class SensoriComuniReport extends HttpServlet {
	
	private Log logger = LogFactoryUtil.getLog(EmailPDFServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		Connection connection = null;
		InputStream stream = null;
		
		try {
			
	        DataSource ds = InfrastructureUtil.getDataSource();
			connection = ds.getConnection();
			HashMap<String,Object> params = new HashMap<String,Object>();

			String pathReports = "/report/";
			String templateName = req.getRequestURI().endsWith("sensori")?
					"SensoriComuni.jasper":"ComuniSensori.jasper";
			
			String filename  = req.getRequestURI().endsWith("sensori")?"sensori.xls":"comuni.xls";
			
			//../riepilogoCosti/riepilogoCosti.jasper
			String dirSubReport = pathReports;
			
			params.put("SUBREPORT_DIR",dirSubReport);
			System.out.println("SUBREPORT_DIR -> "+dirSubReport);
			
			//JRProperties.setProperty("net.sf.jasperreports.awt.ignore.missing.font", Boolean.TRUE);
			
			JasperUtils ju = AllertaTracker.getService(JasperUtils.class);
			
			byte[] b = ju.getReportAsExcel(templateName, params, connection);
			
			resp.setContentType("application/vnd.ms-excel; name=\""+filename+"\"");
			resp.setContentLength(b.length);
			resp.getOutputStream().write(b);
			
			
					
			} catch (Exception e) {	
				e.printStackTrace();
				//LogInternoLocalServiceUtil.log("report SMS_PDF", "get", e, "");
				
						
			} finally {
				try {
				if (connection!=null) connection.close();	
				} catch (Exception e3) {}
				try {
					if (stream!=null) stream.close();	
					} catch (Exception e3) {}
			}
	        
		
		
	}
}
