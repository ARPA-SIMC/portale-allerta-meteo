package it.eng.allerter.allerta;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.liferay.portal.kernel.util.InfrastructureUtil;

import it.eng.allerter.service.LogInternoLocalServiceUtil;

public class SMSReportServlet2 extends HttpServlet {
	
	private static String[] columns={"s.nomedestinatario","s.numero","s.nomestato","s.datainvio","s.dataack","s.dataricevuta","s.testo","s.contatto_ricevuto","s.destinatario_ricevuto"};	
	private static String[] headers={"Destinatario","Numero","Stato","Generato","Spedito","Consegnato","Testo","Contatto ricevuto","Destinatario ricevuto"};
	private static Class[] classes={String.class,String.class,String.class,Timestamp.class,Timestamp.class,Timestamp.class,String.class,Boolean.class,Boolean.class};
	private static boolean[] autosize={true,true,true,true,true,true,false,true,true};
	private static int mergedColumn=0;
	private static boolean [] mergeAlso = {false,false,false,false,false,false,false,false,true};
	private static String table = "sms_dettaglio_vw s";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Connection connection = null;
		try {
			String id = req.getParameter("id");
			String nome = req.getParameter("nome");
			String filtro = req.getParameter("filtro");
			String falliti = req.getParameter("falliti");
			
			if (id==null) {
				resp.setStatus(404);
				return;
			}
			
			
			Workbook w = new HSSFWorkbook();
			Sheet s = w.createSheet("Invio SMS");
			/*
			CellStyle headerStyle = s.getWorkbook().createCellStyle();
			Font font = s.getWorkbook().createFont();
		    font.setBoldweight((short)400); //true);
			headerStyle.setBorderBottom((short)1);
			headerStyle.setBorderTop((short)1);
			headerStyle.setBorderLeft((short)1);
			headerStyle.setBorderRight((short)1);
			headerStyle.setFont(font);
			headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
			
			CellStyle yesStyle = s.getWorkbook().createCellStyle();
			yesStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			yesStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
			yesStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			yesStyle.setAlignment(CellStyle.ALIGN_CENTER);
			
			CellStyle noStyle = s.getWorkbook().createCellStyle();
			noStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			noStyle.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
			noStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			noStyle.setAlignment(CellStyle.ALIGN_CENTER);
			
			CellStyle dateStyle = s.getWorkbook().createCellStyle();
			CreationHelper createHelper = s.getWorkbook().getCreationHelper();
			dateStyle.setDataFormat(
				    createHelper.createDataFormat().getFormat("dd/MM/yyyy HH:mm"));
			
			CellStyle centerStyle = s.getWorkbook().createCellStyle();
			centerStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			*/
			
			int row = 1;
			
			if (nome!=null) {
				Row titolo = s.createRow(row++);
				Cell ti = titolo.createCell(1);
				ti.setCellValue("Invio SMS per evento "+nome);
			}
			
			Row r = s.createRow(row++);
			int col=1;
			for (String h : headers) {
				Cell c = r.createCell(col++);
				c.setCellValue(h);
				//c.setCellStyle(headerStyle);
			}
			
	        DataSource ds = InfrastructureUtil.getDataSource();
			connection = ds.getConnection();
			
			String cols = "";
			for (int k=0; k<columns.length; k++) {
				cols+=columns[k];
				if (k<columns.length-1)cols+=",";
			}
			String query = "select "+cols+" from "+table+" where id='"+id+"'";
			if (filtro!=null && !filtro.equals("")) {
				String t = "'%"+filtro.toUpperCase()+"%'";
				query+=" and(upper(nomedestinatario) like "+t+" or upper(numero) like "+t+" or upper(nomestato) like "+t+")";
			}
			if (falliti!=null && falliti.equals("true")) {
				query +=" and not destinatario_ricevuto ";
			}
			PreparedStatement st = connection.prepareStatement(query);
			st.execute();
			ResultSet rs = st.getResultSet();
			
			Object mergeField = null;
			int startMergeRow = -1;
			Object previousMergeField = null;
			
			while(rs.next()) {
				Row nextrow = s.createRow(row++);
				col = 1;
				for (int k=0; k<columns.length; k++) {
					Cell nextcell = nextrow.createCell(col++);
					if (classes[k]==String.class) {
						String str = rs.getString(k+1);
						if (k==mergedColumn) mergeField = str;
						if (str!=null)
							nextcell.setCellValue(str);
					}
					if (classes[k]==Boolean.class) {
						Boolean b = rs.getBoolean(k+1);
						if (k==mergedColumn) mergeField = b;
						if (b!=null) {
							//nextcell.setCellStyle(b?yesStyle:noStyle);
							nextcell.setCellValue(b?"SI":"NO");
						}
						
					}
					if (classes[k]==Timestamp.class) {
						Timestamp ts = rs.getTimestamp(k+1);
						if (k==mergedColumn) mergeField = ts;
						if (ts!=null) {
							//nextcell.setCellStyle(dateStyle);
							nextcell.setCellValue(ts);
						}
						
					}
					
					if (k==mergedColumn) {
						
						//nextcell.setCellStyle(centerStyle);
						
						if (previousMergeField==null) {
							previousMergeField = mergeField;
							startMergeRow = row-1;
						}
						else {
							if (!previousMergeField.equals(mergeField)) {
								if (startMergeRow<row-2) {
									s.addMergedRegion(new CellRangeAddress(startMergeRow,row-2,k+1,k+1));
									for (int j=0; j<mergeAlso.length; j++) {
										if (mergeAlso[j]) {
											s.addMergedRegion(new CellRangeAddress(startMergeRow,row-2,j+1,j+1));
										}
									}
								}
								previousMergeField = mergeField;
								startMergeRow = row-1;
							}
						}
					}
				}
			}
			
			rs.close();
			st.close();
			
			if (previousMergeField!=null) {
				if (startMergeRow<row-2) {
					s.addMergedRegion(new CellRangeAddress(startMergeRow,row-1,mergedColumn+1,mergedColumn+1));
					for (int j=0; j<mergeAlso.length; j++) {
						if (mergeAlso[j]) {
							s.addMergedRegion(new CellRangeAddress(startMergeRow,row-1,j+1,j+1));
						}
					}
				}
			}
			
			for (int k=0; k<columns.length; k++)
					if (autosize[k]) s.autoSizeColumn(k+1);
			
			resp.setContentType("application/vnd.ms-excel");
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			w.write(baos);
			byte[] b = baos.toByteArray();
			resp.setContentLength(b.length);
			resp.getOutputStream().write(b);
			
			
					
			} catch (Exception e) {	
				//LogInternoLocalServiceUtil.log("report SMS2", "get", e, "");
				e.printStackTrace();
						
			} finally {
				try {
				if (connection!=null) connection.close();	
				} catch (Exception e3) {}
			}
	        
		
		
	}

}
