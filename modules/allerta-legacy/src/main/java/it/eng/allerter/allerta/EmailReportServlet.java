package it.eng.allerter.allerta;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.InfrastructureUtil;

import it.eng.allerter.service.LogInternoLocalServiceUtil;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
//import net.sf.jasperreports.engine.util.JRProperties;

public class EmailReportServlet extends HttpServlet {
	
	private Log logger = LogFactoryUtil.getLog(EmailReportServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String tipo = req.getParameter("tipo");
		String sottotipo = req.getParameter("sottotipo");
		String param = req.getParameter("param");
		String destinatario = req.getParameter("destinatario");
		String datada = req.getParameter("datada");
		String dataa = req.getParameter("dataa");
		
		Connection connection = null;
		
		
		//PortletRequest r = (PortletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		//String pathReports = r.getPortletSession().getPortletContext().getRealPath("report") + "/";
		//String pathReports = AllertaBean.pathReports;
		String pathReports = req.getServletContext().getRealPath("report") + "/";
		
		try {
			
	        DataSource ds = InfrastructureUtil.getDataSource();
			connection = ds.getConnection();
			HashMap<String,Object> params = new HashMap<String,Object>();

			
			String templateName = "Email.jasper";
			
			//../riepilogoCosti/riepilogoCosti.jasper
			String template = pathReports + templateName;
			String dirSubReport = pathReports;
			
			params.put("SUBREPORT_DIR",dirSubReport);
			System.out.println("SUBREPORT_DIR -> "+dirSubReport);
			
			params.put("TIPO", tipo);
			params.put("SOTTOTIPO", sottotipo);
			
			Long pp = null;
			if (param!=null) 
				pp = Long.parseLong(param);
			
			params.put("PARAM", pp);
			
			params.put("DESTINATARIO", destinatario);
			
			/*Date d1 = null;
			Date d2 = null;
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH:mm");
			
			if (datada!=null) {
				d1 = sdf.parse(datada);
			}
			
			if (dataa!=null) {
				d2 = sdf.parse(dataa);
			}*/
			
			params.put("DATADA", datada);
			params.put("DATAA", dataa);
			

			
			//JRProperties.setProperty("net.sf.jasperreports.awt.ignore.missing.font", Boolean.TRUE);
			//JRProperties.setProperty("net.sf.jasperreports.print.keep.full.text", Boolean.TRUE);
			JasperPrint jasperprint = JasperFillManager.fillReport(template, params,connection);
			
			ByteArrayOutputStream o = new ByteArrayOutputStream();
			
			JRXlsExporter xls = new JRXlsExporter();
			xls.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperprint);
			xls.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, o);
			xls.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
			xls.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
			xls.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
			
			xls.exportReport();
			
			resp.setContentType("application/vnd.ms-excel");
			byte[] b = o.toByteArray();
			resp.setContentLength(b.length);
			resp.getOutputStream().write(b);
			
			
					
			} catch (Exception e) {	
				logger.error(e);
				//LogInternoLocalServiceUtil.log("report email", "get", e, "");
						
			} finally {
				try {
				if (connection!=null) connection.close();	
				} catch (Exception e3) {}
			}
	        
		
		
	}

}
