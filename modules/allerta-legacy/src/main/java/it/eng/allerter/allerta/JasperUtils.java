package it.eng.allerter.allerta;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.swing.ImageIcon;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.InfrastructureUtil;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import com.liferay.portal.kernel.util.ResourceBundleLoaderUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import it.eng.allerter.service.LogInternoLocalServiceUtil;
import it.eng.bollettino.model.Bollettino;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPropertiesUtil;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReportsContext;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
//import net.sf.jasperreports.engine.util.JRProperties;

@Component(immediate = true, service = JasperUtils.class)
public class JasperUtils {

	public byte[] generateReportBollettino(String meteo, String pioggia, long idBollettino)
			throws NamingException, JRException, SQLException {
		Connection connection = null;
		HashMap<String, Object> params = new HashMap<String, Object>();
		byte[] pdfasbytes;

		try {
			
			Bollettino b = BollettinoLocalServiceUtil.fetchBollettino(idBollettino);

			DataSource ds = InfrastructureUtil.getDataSource();
			connection = ds.getConnection();

			// String pathReports = path;
			String pathReports = "/report/";
			String templateName = "Bollettino.jasper";

			// ../riepilogoCosti/riepilogoCosti.jasper
			String template = pathReports + templateName;
			String dirSubReport = pathReports;
			
			pathReports = getClass().getClassLoader().getResource(pathReports).getPath();
			
			params.put("SUBREPORT_DIR", dirSubReport);
			
			params.put("ID_RICHIESTA", new BigDecimal(idBollettino));
			System.out.println("ID_RICHIESTA -> " + idBollettino);
			params.put("METEO", meteo);
			System.out.println("METEO -> " + meteo);
			params.put("ICONE", pathReports);
			System.out.println("ICONE -> " + pathReports);
			if (pioggia != null) {
				params.put("PIOGGIA", pioggia);
				System.out.println("PIOGGIA -> " + pioggia);
			} else
				params.put("PIOGGIA", meteo); 

			InputStream stream = this.getClass().getResourceAsStream(template);
			if (b!=null) params.put("title", "Documento di monitoraggio "+b.getNumero());

			pdfasbytes = getReportAsPDF(stream, params, connection);

		} catch (Exception e) {
			System.out.println( e.getMessage());
			_log.error(e); 
			//LogInternoLocalServiceUtil.log("JasperUtils", "generateReportBollettino", e, "");
			return null;

		} finally {
			if (connection != null)
				connection.close();
		}

		return pdfasbytes;
	}

	public byte[] generateReportAllerta(String mappa1, String mappa2, long idAllerta, Map<String, String> p)
			throws NamingException, JRException, SQLException {
		Connection connection = null;
		HashMap<String, Object> params = new HashMap<String, Object>();
		byte[] pdfasbytes;

		try {

			DataSource ds = InfrastructureUtil.getDataSource();
			connection = ds.getConnection();

			String pathReports = "/report/";
			String templateName = "Allerta.jasper";

			// ../riepilogoCosti/riepilogoCosti.jasper
			String template = pathReports + templateName;
			String dirSubReport = pathReports;

			params.put("SUBREPORT_DIR", dirSubReport);
			System.out.println("SUBREPORT_DIR -> " + dirSubReport);

			params.put("ID_RICHIESTA", new BigDecimal(idAllerta));
			System.out.println("ID_RICHIESTA -> " + idAllerta);
			params.put("MAPPA1", mappa1);
			System.out.println("MAPPA1 -> " + mappa1);
			params.put("MAPPA2", mappa2);
			System.out.println("MAPPA2 -> " + mappa2);

			params.putAll(p);

			InputStream stream = this.getClass().getResourceAsStream(template);

			pdfasbytes = getReportAsPDF(stream, params, connection);

		} catch (Exception e) {
			//LogInternoLocalServiceUtil.log("JasperUtils", "generateReportAllerta", e, "");
			_log.error(e);
			return null;
		} finally {
			if (connection != null)
				connection.close();
		}

		return pdfasbytes;
	}

	public byte[] getReport(String template, HashMap<String, Object> params, Connection connection)
			throws JRException {
		JasperPrint jasperprint = JasperFillManager.fillReport(template, params, connection);

		ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream();

		JasperExportManager.exportReportToPdfStream(jasperprint, byteArrayOutput);

		return byteArrayOutput.toByteArray();
	}

	public byte[] getReportAsExcel(
			String templateName, HashMap<String, Object> params, Connection connection) {
		//JRProperties.setProperty("net.sf.jasperreports.awt.ignore.missing.font", Boolean.TRUE);

		String pathReports = "/report/";
		String template = pathReports + templateName;
		
		pathReports = getClass().getClassLoader().getResource(pathReports).getPath();
		
		InputStream stream = this.getClass().getResourceAsStream(template);
		
		ByteArrayOutputStream byteArrayOutput = null;
		
		JasperReportsContext jasperReportsContext = DefaultJasperReportsContext.getInstance();
		jasperReportsContext.setProperty("net.sf.jasperreports.awt.ignore.missing.font", "true");
		jasperReportsContext.setProperty("java.awt.headless", "true");
		//jasperReportsContext.setProperty("net.sf.jasperreports.print.keep.full.text", Boolean.TRUE);
		System.setProperty("java.awt.headless", "true");
		
		try {
		
			JasperPrint jasperprint = JasperFillManager.fillReport(stream, params, connection);
	
			byteArrayOutput = new ByteArrayOutputStream();
			// OutputStream outputfile= new FileOutputStream(new
			// File("c:/output/JasperReport.xls"));
	
			// coding For Excel:
			JRXlsExporter exporterXLS = new JRXlsExporter();
			exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperprint);
			exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, byteArrayOutput);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
			// exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
			// Boolean.TRUE);
			exporterXLS.exportReport();
			
		} catch (Exception e) {
			e.printStackTrace(); 
			_log.error(e);
			return null;
		}

		return byteArrayOutput.toByteArray();
	}

	private byte[] getReportAsPDF(InputStream stream, HashMap<String, Object> params, Connection connection)
			throws JRException {
		
		JasperReportsContext jasperReportsContext = DefaultJasperReportsContext.getInstance();
		jasperReportsContext.setProperty("net.sf.jasperreports.awt.ignore.missing.font", "true");

		//JRPropertiesUtil.setProperty("net.sf.jasperreports.awt.ignore.missing.font", Boolean.TRUE);
	
		JasperPrint jasperprint = JasperFillManager.fillReport(stream, params, connection);

		ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream();
		// OutputStream outputfile= new FileOutputStream(new
		// File("c:/output/JasperReport.xls"));

		// coding For PDF:
		SimplePdfExporterConfiguration c = new SimplePdfExporterConfiguration();
		if (params.containsKey("title")) c.setMetadataTitle((String)params.get("title"));
		c.setTagged(true);
		c.setTagLanguage("it-it");
		
		JRPdfExporter exporterPDF = new JRPdfExporter();
		//exporterPDF.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperprint);
		//exporterPDF.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, byteArrayOutput);
		SimpleExporterInput sei = new SimpleExporterInput(jasperprint);
		SimpleOutputStreamExporterOutput out = new SimpleOutputStreamExporterOutput(byteArrayOutput);
		exporterPDF.setExporterInput(sei);
		exporterPDF.setExporterOutput(out);
		exporterPDF.setConfiguration(c);

		// exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
		// Boolean.TRUE);
		exporterPDF.exportReport();

		return byteArrayOutput.toByteArray();
	}

	private Log _log = LogFactoryUtil.getLog(JasperUtils.class);

}
