package it.eng.sms.portlet.portlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.InfrastructureUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
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
import org.apache.poi.ss.usermodel.*;

import it.eng.allerta.utils.AllertaKeys;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=" + AllertaKeys.AllertaCategory,
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/dettagliEvento.jsp",
			"javax.portlet.display-name=Dettaglio report Evento", 
			"javax.portlet.name=" + AllertaKeys.AllertaDettagliEventiPortlet,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class AllertaDettaglioEventoPortlet extends MVCPortlet {
	
	private static String[] columns={"s.nomedestinatario","s.numero","s.nomestato","s.datainvio","s.dataack","s.dataricevuta","s.testo","s.contatto_ricevuto","s.destinatario_ricevuto"};	
	private static String[] headers={"Destinatario","Numero","Stato","Generato","Spedito","Consegnato","Testo","Contatto ricevuto","Destinatario ricevuto"};
	private static Class[] classes={String.class,String.class,String.class,Timestamp.class,Timestamp.class,Timestamp.class,String.class,Boolean.class,Boolean.class};
	private static boolean[] autosize={true,true,true,true,true,true,false,true,true};
	private static int mergedColumn=0;
	private static boolean [] mergeAlso = {false,false,false,false,false,false,false,false,true};
	private static String table = "sms_dettaglio_vw s";
	
	@Override
	public void render( RenderRequest request, RenderResponse response) 
			throws IOException, PortletException {
		
		HttpServletRequest originalRequest = 
					PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
		
		String id = originalRequest.getParameter("id");
		String backTo = originalRequest.getParameter("backTo");
		
		if( Validator.isNotNull(id)) {
			request.setAttribute("id", id);
			request.setAttribute("backTo", backTo);
		}
		
		super.render(request, response);
	}
	
	@Override
	public void serveResource(
				ResourceRequest resourceRequest, ResourceResponse resourceResponse) 
						throws IOException, PortletException {
		
		String filtro = ParamUtil.getString(resourceRequest, "filtro");
		String failed = ParamUtil.getString(resourceRequest, "failed");
		String id = ParamUtil.getString(resourceRequest, "id");
		String tipoEvt = ParamUtil.getString(resourceRequest, "evt");
		
		Connection connection = null;
		
		Workbook w = new HSSFWorkbook();
		Sheet s = w.createSheet("Invio SMS");
		
		CellStyle headerStyle = s.getWorkbook().createCellStyle();
		Font font = s.getWorkbook().createFont();
	    font.setBold(true);
	    
	    BorderStyle bstyle =  BorderStyle.THIN;
		headerStyle.setBorderBottom(bstyle);
		headerStyle.setBorderTop(bstyle);
		headerStyle.setBorderLeft(bstyle);
		headerStyle.setBorderRight(bstyle);
		headerStyle.setFont(font);
		
		HorizontalAlignment halign = HorizontalAlignment.CENTER;
		VerticalAlignment valign = VerticalAlignment.CENTER;
		FillPatternType fillPatterType = FillPatternType.SOLID_FOREGROUND;
		
		headerStyle.setAlignment(halign);
		
		CellStyle yesStyle = s.getWorkbook().createCellStyle();
		yesStyle.setFillPattern(fillPatterType);
		yesStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
		yesStyle.setVerticalAlignment(valign);
		yesStyle.setAlignment(halign);
		
		CellStyle noStyle = s.getWorkbook().createCellStyle();
		noStyle.setFillPattern(fillPatterType);
		noStyle.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		noStyle.setVerticalAlignment(valign);
		noStyle.setAlignment(halign);
		
		CellStyle dateStyle = s.getWorkbook().createCellStyle();
		CreationHelper createHelper = s.getWorkbook().getCreationHelper();
		dateStyle.setDataFormat(
			    createHelper.createDataFormat().getFormat("dd/MM/yyyy HH:mm"));
		
		CellStyle centerStyle = s.getWorkbook().createCellStyle();
		centerStyle.setVerticalAlignment(valign);
		
		int row = 1;
		
		if (tipoEvt != null) {
			Row titolo = s.createRow( row++);
			Cell ti = titolo.createCell(1);
			ti.setCellValue("Invio SMS per evento " + tipoEvt);
		}
		
		Row r = s.createRow(row++);
		int col=1;
		
		for (String h : headers) {
			
			Cell c = r.createCell(col++);
			
			c.setCellValue(h);
			c.setCellStyle(headerStyle);
		}
		
		DataSource ds = InfrastructureUtil.getDataSource();
		try {
			connection = ds.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
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
		
		if (failed != null && failed.equals("true")) {
			query +=" and not destinatario_ricevuto ";
		}
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		Object mergeField = null;
		int startMergeRow = -1;
		Object previousMergeField = null;
		
		try {
			
			st = connection.prepareStatement(query);
			st.execute();
			
			rs = st.getResultSet();
			
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
						
					}else if (classes[k]==Boolean.class) {
						
						Boolean b = rs.getBoolean(k+1);
						if (k==mergedColumn) mergeField = b;
						if (b!=null) {
							nextcell.setCellStyle(b?yesStyle:noStyle);
							nextcell.setCellValue(b?"SI":"NO");
						}
						
					} else if (classes[k]==Timestamp.class) {
						Timestamp ts = rs.getTimestamp(k+1);
						if (k==mergedColumn) mergeField = ts;
						if (ts!=null) {
							nextcell.setCellStyle(dateStyle);
							nextcell.setCellValue(ts);
						}
						
					}
					
					if (k == mergedColumn) {
						
						nextcell.setCellStyle(centerStyle);
						
						if (previousMergeField==null) {
							
							previousMergeField = mergeField;
							startMergeRow = row-1;
							
						} else {
							
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
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		
		resourceResponse.setContentType("application/vnd.ms-excel");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		w.write(baos);
		byte[] b = baos.toByteArray();
		resourceResponse.setContentLength(b.length);
		resourceResponse.getPortletOutputStream().write(b);
	}

}
