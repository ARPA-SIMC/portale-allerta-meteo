package it.eng.rubrica.portlet;

import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.zip.ZipFileUtil;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.osgi.service.component.annotations.Component;

import it.eng.allerte.model.RubricaGruppo;
import it.eng.allerte.service.RubricaGruppoLocalServiceUtil;

@Component(
	    immediate = true,
	    property = {
	        "osgi.http.whiteboard.context.path=/",
	        "osgi.http.whiteboard.servlet.pattern=/rubrica/gruppo/*"
	    },
	    service = Servlet.class
	)
public class DownloadGruppoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String ss = req.getParameter("gruppo");
		if (ss==null) {
			return;
		}
		
		boolean separati = false;
		if (req.getParameter("separati")!=null && !"".equals(req.getParameter("separati")))
			separati = true;
		
		long l = Long.parseLong(ss);
		RubricaGruppo rg = RubricaGruppoLocalServiceUtil.fetchRubricaGruppo(l);
		if (rg==null) return;
		//resp.getOutputStream().print("GRUPPO: "+l);
		XSSFWorkbook workbook;
		
		String nomeGruppo = rg.getNOME();
		if (nomeGruppo==null) nomeGruppo = "";
		nomeGruppo = nomeGruppo.replaceAll(" ", "_");
		nomeGruppo = nomeGruppo.replaceAll("\\.", "");
		nomeGruppo = nomeGruppo.replaceAll(";", "");
		nomeGruppo = nomeGruppo.replaceAll(":", "");
		nomeGruppo = nomeGruppo.replaceAll(",", "");
		nomeGruppo = nomeGruppo.toLowerCase();
		
		List<Object[]> rubrica = RubricaGruppoLocalServiceUtil.getGroup(l);
		
		if (!separati) {
			workbook = getWorkbook(rubrica, nomeGruppo, true);
			resp.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			String filename = nomeGruppo+"_"+new SimpleDateFormat("yyyyMMdd_HHmm").format(new Date())+".xlsx";
		    resp.addHeader("Content-Disposition", "attachment; filename=\""+filename+"\"");
		    try {
				workbook.write(resp.getOutputStream());
				workbook.close();
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		    return;
		}
		
		//file separati
		Map<String,File> files = new HashMap<String, File>();
		File folder = FileUtil.createTempFolder();
		
		for (int k=0; k<rubrica.size(); k++) {
			String grp = rubrica.get(k)[0].toString();
			if (files.containsKey(grp)) continue;
			
			XSSFWorkbook wb = getWorkbook(rubrica, grp, false);
			if (wb==null) continue;
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			wb.write(baos);
			byte[] content = baos.toByteArray();
			
			String grp2 = grp.replaceAll(" ", "_");
			grp2 = grp2.replaceAll("\\.", "");
			grp2 = grp2.replaceAll(";", "");
			grp2 = grp2.replaceAll(":", "");
			grp2 = grp2.replaceAll(",", "");
			grp2 = grp2.toLowerCase();
			String fnm = grp2+"_"+new SimpleDateFormat("yyyyMMdd_HHmm").format(new Date())+".xlsx";

			File ff = new File(folder,fnm);
			ff.createNewFile();
			FileUtil.write(ff, content);
			files.put(grp, ff);
			
		}
		String zipname = nomeGruppo+"_"+new SimpleDateFormat("yyyyMMdd_HHmm").format(new Date())+".zip";

		File zip = new File(folder,zipname);
		zip.createNewFile();
		
		FileOutputStream fos = new FileOutputStream(zip);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ZipOutputStream zos = new ZipOutputStream(bos);
		
		try {
		    for (String entry : files.keySet()) {
		        // not available on BufferedOutputStream
		    	File ff2 = files.get(entry);
		        zos.putNextEntry(new ZipEntry(ff2.getName()));
		        zos.write(FileUtil.getBytes(ff2));
		        // not available on BufferedOutputStream
		        zos.closeEntry();
		    }
		}
		finally {
		    zos.close();
		}
		
		resp.setContentType("application/zip");
	    resp.addHeader("Content-Disposition", "attachment; filename=\""+zip.getName()+"\"");
	    resp.getOutputStream().write(FileUtil.getBytes(zip));
	    
	    FileUtil.deltree(folder);
		
		//long l = Long.parseLong(req.getParameter("gruppo"));
		

	}
	
	private XSSFWorkbook getWorkbook(List<Object[]> rubrica, String nomeGruppo, boolean tutti) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		workbook.createSheet();
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		//long l = Long.parseLong(req.getParameter("gruppo"));
		
		//String nomeGruppo = rg.getNOME();
		if (nomeGruppo==null) nomeGruppo = "";
		/*nomeGruppo = nomeGruppo.replaceAll(" ", "_");
		nomeGruppo = nomeGruppo.replaceAll("\\.", "");
		nomeGruppo = nomeGruppo.replaceAll(";", "");
		nomeGruppo = nomeGruppo.replaceAll(":", "");
		nomeGruppo = nomeGruppo.replaceAll(",", "");
		nomeGruppo = nomeGruppo.toLowerCase();
		*/
		//resp.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		//String filename = nomeGruppo+"_"+new SimpleDateFormat("yyyyMMdd_HHmm").format(new Date())+".xlsx";
	    //resp.addHeader("Content-Disposition", "attachment; filename=\""+filename+"\"");
		
	    XSSFRow header = sheet.createRow(0);
	    header.createCell(0).setCellValue("Gruppo");
	    header.createCell(1).setCellValue("Cognome");
	    header.createCell(2).setCellValue("Nome");
	    header.createCell(3).setCellValue("Ruolo");
	    header.createCell(4).setCellValue("Specifica ruolo");
	    header.createCell(5).setCellValue("Indirizzo");
	    header.createCell(6).setCellValue("Tipo contatto");
	    header.createCell(7).setCellValue("Contatto");
	    header.createCell(8).setCellValue("Data aggiornamento gruppo");
	    header.createCell(9).setCellValue("Data aggiornamento contatto");
	    int base = 10000;
	    sheet.setColumnWidth(0, (int)(base*1.2));
	    sheet.setColumnWidth(1, (int)(base*0.5));
	    sheet.setColumnWidth(2, (int)(base*0.5));
	    sheet.setColumnWidth(3, (int)(base*0.4));
	    sheet.setColumnWidth(4, (int)(base*0.5));
	    sheet.setColumnWidth(5, (int)(base*0.5));
	    sheet.setColumnWidth(6, (int)(base*0.3));
	    sheet.setColumnWidth(7, (int)(base*0.7));
	    sheet.setColumnWidth(8, (int)(base*0.7));
	    sheet.setColumnWidth(9, (int)(base*0.7));
	    XSSFFont font = workbook.createFont();
	    XSSFCellStyle style = workbook.createCellStyle();
	    font.setBold(true);
	    style.setFont(font);
	    for (int k=0; k<10; k++) header.getCell(k).setCellStyle(style);
		
		//List<Object[]> rubrica = RubricaGruppoLocalServiceUtil.getGroup(l);
				//RubricaGruppoLocalServiceUtil.getAllRubrica();
	    int index = 0;
		for (int k=0; k<rubrica.size(); k++) {
			
			if (!tutti && !rubrica.get(k)[0].toString().equals(nomeGruppo)) continue;
			
			XSSFRow row = sheet.createRow(++index);
			Object[] riga = rubrica.get(k);
			for (int j=0; j<riga.length; j++) {
				String strValue = "";
				if (riga[j] instanceof String) strValue = (String) riga[j];
				else if (riga[j] instanceof Date) {
					strValue = sdf.format((Date)riga[j]);
				} else strValue = (riga[j]!=null?riga[j].toString():"");
				row.createCell(j).setCellValue(strValue);
			}
		}
		
		return workbook;
	}

}
