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

import com.liferay.portal.kernel.util.InfrastructureUtil;

import it.eng.allerter.service.LogInternoLocalServiceUtil;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
//import net.sf.jasperreports.engine.util.JRProperties;

public class SMSPDFReport extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String tipo = req.getParameter("tipo");
		String sottotipo = req.getParameter("sottotipo");
		String param = req.getParameter("param");
		String numero = req.getParameter("numero");
		String destinatario = req.getParameter("destinatario");
		String datada = req.getParameter("datada");
		String dataa = req.getParameter("dataa");
		String stato = req.getParameter("stato");
		
		Connection connection = null;
		
		
		//PortletRequest r = (PortletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		//String pathReports = r.getPortletSession().getPortletContext().getRealPath("report") + "/";
		//String pathReports = AllertaBean.pathReports;
		String pathReports = req.getServletContext().getRealPath("report") + "/";
		
		try {
			
	        DataSource ds = InfrastructureUtil.getDataSource();
			connection = ds.getConnection();
			HashMap<String,Object> params = new HashMap<String,Object>();

			
			String templateName = "SMS_PDF.jasper";
			
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
			
			params.put("NUMERO", numero);
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
			
			Long stat = null;
			if (stato!=null) 
				stat = Long.parseLong(stato);
			
			params.put("STATO", stat);
			
			//JRProperties.setProperty("net.sf.jasperreports.awt.ignore.missing.font", Boolean.TRUE);
			
			JasperPrint jasperprint = JasperFillManager.fillReport(template, params,connection);
			
			
			ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream() ;
	        //OutputStream outputfile= new FileOutputStream(new File("c:/output/JasperReport.xls"));		 
			 
	         // coding For PDF:
			JRPdfExporter exporterPDF = new JRPdfExporter();
			exporterPDF.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperprint);
			exporterPDF.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, byteArrayOutput);
			
			//exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
			exporterPDF.exportReport();	    
			
			
			resp.setContentType("application/pdf");
			byte[] b = byteArrayOutput.toByteArray();
			resp.setContentLength(b.length);
			resp.getOutputStream().write(b);
			
			
					
			} catch (Exception e) {	
				e.printStackTrace();
				//LogInternoLocalServiceUtil.log("report SMS_PDF", "get", e, "");
				
						
			} finally {
				try {
				if (connection!=null) connection.close();	
				} catch (Exception e3) {}
			}
	        
		
		
	}

}
