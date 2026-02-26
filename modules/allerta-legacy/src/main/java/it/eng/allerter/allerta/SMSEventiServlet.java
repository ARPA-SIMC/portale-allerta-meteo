package it.eng.allerter.allerta;

import com.liferay.portal.kernel.util.InfrastructureUtil;

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

import it.eng.allerta.utils.AllertaTracker;

@Component(
	    immediate = true,
	    property = {
	        "osgi.http.whiteboard.context.path=/",
	        "osgi.http.whiteboard.servlet.pattern=/report/eventi"
	    },
	    service = Servlet.class
	)
public class SMSEventiServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2527258349687396234L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String filtro = req.getParameter("FILTRO");
		
		Connection connection = null;
		InputStream stream = null;
		
		try {
			
	        DataSource ds = InfrastructureUtil.getDataSource();
			connection = ds.getConnection();
			HashMap<String,Object> params = new HashMap<String,Object>();

			String pathReports = "/report/";
			String templateName = "Eventi.jasper";
			//templateName = templateName;
			
			String dirSubReport = pathReports;
			
			params.put("SUBREPORT_DIR",dirSubReport);
			System.out.println("SUBREPORT_DIR -> "+dirSubReport);
			

			String datada = req.getParameter("DATADA");
			String dataa = req.getParameter("DATAA");
			if (datada!=null && datada.contains("/")) {
				String d[] = datada.split("/");
				datada = d[2] + "-" + d[1] + "-" + d[0];
			}
			if (dataa!=null && dataa.contains("/")) {
				String d[] = dataa.split("/");
				dataa = d[2] + "-" + d[1] + "-" + d[0];
			}
			
			params.put("DATADA", datada);
			params.put("DATAA", dataa);
			params.put("FILTRO", filtro);
			
			
			//JRProperties.setProperty("net.sf.jasperreports.awt.ignore.missing.font", Boolean.TRUE);
			
			JasperUtils ju = AllertaTracker.getService(JasperUtils.class);
			
			//stream = this.getClass().getResourceAsStream(templateName);
			byte[] b = ju.getReportAsExcel(templateName, params, connection);
			
			
			resp.setContentType("application/vnd.ms-excel; name=\"invii.xsl\"");
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
