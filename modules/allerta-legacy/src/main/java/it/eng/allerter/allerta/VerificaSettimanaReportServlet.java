package it.eng.allerter.allerta;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import com.liferay.portal.kernel.util.PortalUtil;

import it.eng.allerta.utils.AllertaTracker;
//import net.sf.jasperreports.engine.util.JRProperties;

@Component(
	    immediate = true,
	    property = {
	        "osgi.http.whiteboard.context.path=/",
	        "osgi.http.whiteboard.servlet.pattern=/report/verifica-settimana"
	    },
	    service = Servlet.class
	)
public class VerificaSettimanaReportServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8590455975669030398L;
	private Log logger = LogFactoryUtil.getLog(VerificaSettimanaReportServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String datada = req.getParameter("datada");
		String dataa = req.getParameter("dataa");
		
		
		Connection connection = null;
		InputStream stream = null;
		
		//PortletRequest r = (PortletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		//String pathReports = r.getPortletSession().getPortletContext().getRealPath("report") + "/";
		//String pathReports = AllertaBean.pathReports;
		
		try {
			
	        DataSource ds = InfrastructureUtil.getDataSource();
			connection = ds.getConnection();
			HashMap<String,Object> params = new HashMap<String,Object>();

			String pathReports = "/report/";
			String templateName = "VerificaFull.jasper";
			templateName = pathReports + templateName;
			
			//../riepilogoCosti/riepilogoCosti.jasper
			String dirSubReport = pathReports;
			
			params.put("SUBREPORT_DIR",dirSubReport);
			System.out.println("SUBREPORT_DIR -> "+dirSubReport);
			
			try {
				String x = PortalUtil.getComputerName();
				System.out.println("COMPUTER NAME -> "+x);
				if (x!=null && x.contains("vm"))
					params.put("URL_SERVIZI","http://vm668lnx.ente.regione.emr.it:8080");
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			
			Long pp = null;
			
			params.put("PARAM", pp);
			
			/*Date d1 = null;
			Date d2 = null;
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH:mm");
			
			if (datada!=null) {
				d1 = sdf.parse(datada);
			}
			
			if (dataa!=null) {
				d2 = sdf.parse(dataa);
			}*/
			
			Date d1 = new SimpleDateFormat("dd/MM/yyyy").parse(datada);
			Date d2;
			if (dataa!=null && !"".equals(dataa)) d2 = new SimpleDateFormat("dd/MM/yyyy").parse(dataa);
			else {
				Calendar c = Calendar.getInstance();
				c.setTime(d1);
				c.add(Calendar.DAY_OF_YEAR, 7);
				d2 = c.getTime();
			}
			
			params.put("DATA_REPORT", d1);
			params.put("DATA_REPORT_FINE", d2);
			
			
			//JRProperties.setProperty("net.sf.jasperreports.awt.ignore.missing.font", Boolean.TRUE);
			
			JasperUtils ju = AllertaTracker.getService(JasperUtils.class);
			
			stream = this.getClass().getResourceAsStream(templateName);
			byte[] b = ju.getReportAsPDF(stream, params, connection);
			
			
			resp.setContentType("application/pdf");
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
