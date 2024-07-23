package allerta.verifica.export;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.util.InfrastructureUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.osgi.service.component.annotations.Component;

import allerta.catasto.model.Effetti;
import allerta.catasto.model.EffettiSub;
import allerta.catasto.model.Segnalazione;
import allerta.catasto.model.Sottocategoria;
import allerta.catasto.service.EffettiLocalServiceUtil;
import allerta.catasto.service.EffettiSubLocalServiceUtil;
import allerta.catasto.service.SegnalazioneLocalServiceUtil;
import allerta.catasto.service.SottocategoriaLocalServiceUtil;
import it.eng.allerter.model.Allerta;
import it.eng.allerter.service.AllertaLocalServiceUtil;
import it.eng.allerter.service.LogInternoLocalServiceUtil;

@Component(
	    immediate = true,
	    property = {
	        "osgi.http.whiteboard.context.path=/",
	        "osgi.http.whiteboard.servlet.pattern=/report/catasto/excel"
	    },
	    service = Servlet.class
	)
public class CatastoExport extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1786798458655466406L;
	
	String dataInizio = null;
	String dataFine = null;
	Date d1 = null;
	Date d2 = null;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat ora = new SimpleDateFormat("HH:mm");
	
	Map<String,CellStyle> styles;
	List<Segnalazione> segnalazioni;
	List<Allerta> allerte;
	
	public String[] FOGLI = {"Catasto segnalazioni"};
	public String[] CATEGORIE = {"N.D.","Crit. idraulica","Crit. idrogeologica","Crit. temporali"
			,"Vento","Temperature estreme","Neve","Pioggia che gela","Stato del mare",
			"Crit. costiera"};
	
	public String[] CATEGORIE2 = {"N.D.","Crit. idraulica","Crit. idrogeologica","Crit. temporali"
			,"Vento","Temperature estreme","Neve","Pioggia che gela","Stato del mare",
			"Crit. costiera", "Valanghe"};
	public String[] FONTI = {"N.D.","Stampa","Web","Social media","VVF","DB segnalazione danno"
		};
	
	List<Sottocategoria> sottocategorie;
	List<Effetti> effetti;
	List<EffettiSub> effettiSub;
	
	static Map<String, String> labels = new HashMap<String, String>();
	static Map<String, String> defaultStyles = new HashMap<String, String>();
	static Map<String, String> intestazioneStyles = new HashMap<String, String>();

	
	static {
		labels.put("data_evento", "Data evento");
		labels.put("numero_documento", "Numero documento");
		labels.put("numero_documento_semplice", "Numero doc.");
		labels.put("data_emissione", "Data emissione");
		labels.put("inizio_validita_codice_colore", "Inizio validità \ncodice colore");
		labels.put("fine_validita_codice_colore", "Fine validità \ncodice colore");
		labels.put("data", "Data");
		labels.put("ora", "Ora");
		labels.put("post_briefing", "POST-BRIEFING");
		labels.put("post_allerta", "POST-ALLERTA");
		labels.put("post_verifica", "POST-VERIFICA");
		labels.put("codice_previsto", "Codice previsto");
		labels.put("codice_osservato", "Codice osservato");
		labels.put("segnalazioni_territorio", "Oggetti catasto");
		
		labels.put("allerta_bollettino", "Allerta/\nBollettino");
		labels.put("durata", "Durata");
		labels.put("codice_colore_max", "Codice colore max");
		labels.put("note_allerta","Note verifica");
		labels.put("fenomeni_descritti","Fenomeni descritti");
		labels.put("fenomeni_allerta","Fenomeni allerta");
		labels.put("zone_fenomeno","ZONE");
		labels.put("codice_colore_fenomeno","CODICE\nCOLORE");
		
		labels.put("previsto_24h","Previsto 24h");
		labels.put("osservato_24h","Osservato 24h");
		
		labels.put("note_valutazione","SEGNALAZIONI DAL TERRITORIO");
		labels.put("valutazione_descrittiva","VALUTAZIONE DESCRITTIVA");
		labels.put("valutazione_codice_sintetico","VALUTAZIONE CODICE SINTETICO");
		labels.put("prev_val","P");
		labels.put("oss_val","O");

		labels.put("corretto","Corretto");
		labels.put("magnitudo","Magnitudo");
		labels.put("localizzazione","Localizzazione");
		labels.put("cause","Cause");
		
		
		
		
		defaultStyles.put(labels.get("data_evento"), " fontcolor56 bold");
		defaultStyles.put(labels.get("numero_documento"), " fontcolor56 bold");
		defaultStyles.put(labels.get("numero_documento_semplice"), " fontcolor56 bold");
		defaultStyles.put(labels.get("data_emissione"), " fontcolor56 bold thin-right ");
		defaultStyles.put(labels.get("inizio_validita_codice_colore"), "");
		defaultStyles.put(labels.get("fine_validita_codice_colore"), "");
		defaultStyles.put(labels.get("data"), "");
		defaultStyles.put(labels.get("ora"), "");
		defaultStyles.put(labels.get("post_briefing"), "");
		defaultStyles.put(labels.get("post_allerta"), "");
		defaultStyles.put(labels.get("post_verifica"), "");
		defaultStyles.put(labels.get("codice_previsto"), " thin-left bold ");
		defaultStyles.put(labels.get("codice_osservato"), " thin-right bold ");
		defaultStyles.put(labels.get("segnalazioni_territorio"), "");
		
		defaultStyles.put(labels.get("allerta_bollettino"), " bold");
		defaultStyles.put(labels.get("durata"), "");
		defaultStyles.put(labels.get("codice_colore_max"), " bold thin-right ");
		defaultStyles.put(labels.get("note_allerta"),"");
		defaultStyles.put(labels.get("fenomeni_descritti"),"");
		defaultStyles.put(labels.get("fenomeni_allerta"),"");
		defaultStyles.put(labels.get("zone_fenomeno")," thin-left ");
		defaultStyles.put(labels.get("codice_colore_fenomeno")," thin-right bold ");
		
		defaultStyles.put(labels.get("previsto_24h")," thin-left ");
		defaultStyles.put(labels.get("osservato_24h")," thin-right ");
		
		defaultStyles.put(labels.get("note_valutazione")," thin-left ");
		defaultStyles.put(labels.get("valutazione_descrittiva"),"");
		defaultStyles.put(labels.get("valutazione_codice_sintetico"),"");
		defaultStyles.put(labels.get("prev_val"),"");
		defaultStyles.put(labels.get("oss_val"),"");

		defaultStyles.put(labels.get("corretto")," bold ");
		defaultStyles.put(labels.get("magnitudo")," bold ");
		defaultStyles.put(labels.get("localizzazione")," bold ");
		defaultStyles.put(labels.get("cause")," thin-right bold ");
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String datada = req.getParameter("datada");
		String dataa = req.getParameter("dataa");
		
		styles = new HashMap<String, CellStyle>();
		
		sottocategorie = SottocategoriaLocalServiceUtil.getSottocategorias(-1, -1);
		effetti = EffettiLocalServiceUtil.getEffettis(-1, -1);
		effettiSub = EffettiSubLocalServiceUtil.getEffettiSubs(-1, -1);
		
		try {
			if (datada!=null && !datada.equals("")) {
				System.out.println("Datada="+datada.toString());
				d1 = sdf.parse(datada);
				dataInizio = new SimpleDateFormat("yyyy-MM-dd").format(d1);
			}
			if (dataa!=null && !dataa.equals("")) {
				System.out.println("Dataa="+dataa.toString());
				d2 = sdf.parse(dataa);
				dataFine = new SimpleDateFormat("yyyy-MM-dd").format(d2);
			}
			

			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		byte[] b = null;

		Connection connection = null;
		InputStream stream = null;
		
		//PortletRequest r = (PortletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		//String pathReports = r.getPortletSession().getPortletContext().getRealPath("report") + "/";
		//String pathReports = AllertaBean.pathReports;
		
		try {
			
			getData();
			
	        DataSource ds = InfrastructureUtil.getDataSource();
			connection = ds.getConnection();
			
			HSSFWorkbook report = creaExcel();
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			if (report!=null) {
				report.write(baos);
				byte[] output = baos.toByteArray(); 
				resp.setContentType("application/vnd.ms-excel");
				resp.setHeader("Content-Disposition", "attachment;filename=catasto.xls");
				resp.setContentLength(output.length);
				resp.getOutputStream().write(output);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			LogInternoLocalServiceUtil.log("CatastoExportServlet", "doGet", e, "");

		}
		 finally {
				try {
				if (connection!=null) connection.close();	
				} catch (Exception e3) {}
				try {
					if (stream!=null) stream.close();	
					} catch (Exception e3) {}
			}

	}
	
	private void getData() {
		DynamicQuery dq = SegnalazioneLocalServiceUtil.dynamicQuery();
		try {
			if (d1!=null)
				dq = dq.add(PropertyFactoryUtil.forName("dataEvento").gt(d1));
			if (d2!=null)
				dq = dq.add(PropertyFactoryUtil.forName("dataEvento").le(d2));
		} catch (Exception e) {
			e.printStackTrace();
		}
		dq = dq.addOrder(OrderFactoryUtil.asc("dataEvento"));
	
		segnalazioni = SegnalazioneLocalServiceUtil.dynamicQuery(dq);

		dq = AllertaLocalServiceUtil.dynamicQuery();
		try {
			
			dq = dq.add(PropertyFactoryUtil.forName("stato").eq(0));
			
			if (d1!=null)
				dq = dq.add(PropertyFactoryUtil.forName("dataFine").gt(d1));
			if (d2!=null)
				dq = dq.add(PropertyFactoryUtil.forName("dataInizio").le(d2));
		} catch (Exception e) {
			e.printStackTrace();
		}
		dq = dq.addOrder(OrderFactoryUtil.asc("dataInizio"));
	
		allerte = AllertaLocalServiceUtil.dynamicQuery(dq);
		
		
	}
	
	private HSSFWorkbook creaExcel() {
		HSSFWorkbook wb = HSSFWorkbookFactory.createWorkbook();
		for (int k=0; k<FOGLI.length; k++) {
			 HSSFSheet sheet = wb.createSheet(FOGLI[k]);

			 List<Object[]> intestaz = makeIntestazione(FOGLI[k], wb, sheet);
			 int rownum = intestaz.size();
			 
			 List<Segnalazione> righe = /*getRighe(FOGLI[k])*/ segnalazioni;
			 if (righe==null || righe.size()==0) continue;
			 
			
			 int widths[] = new int[intestaz.get(0).length];
			 for (int col=0; col<widths.length; col++) {
				 String[] split = intestaz.get(0)[col].toString().split("\n");
				 String x2 = split[split.length-1];
				 widths[col] = x2.length();
			 }
			 
			 
			 for (Segnalazione riga : righe) {
				 //List<Object> celle = getRiga(FOGLI[k], riga, intestaz);
				 Row r = sheet.createRow(rownum++);
				 r.setHeight((short)600);
				 int cellnum = 0;
				 List<Object> celle = new ArrayList<Object>();
				 Object row[] = {"ID","Data evento","Tipo evento","Sottotipo","Provincia","Comune",
							"Indirizzo","Civico","Area","Macrocat. Effetti","Effetti","Fonte","Descrizione",
							"Ente segnalante","Riferimento","Note"};
				 celle.add(riga.getId());
				 celle.add(riga.getDataEvento());
				 celle.add(CATEGORIE2[(int)riga.getCategoria()]);
				 String txt = "";
				 for (Sottocategoria s : sottocategorie)
					 if (s.getId()==riga.getSottocategoria())
						 txt = s.getDescrizione();
				 
				 celle.add(txt);
				 celle.add(riga.getProvincia());
				 celle.add(riga.getComune());
				 celle.add(riga.getIndirizzo());
				 celle.add(riga.getCivico());
				 celle.add(riga.getArea());
				 
				 txt="";
				 for (Effetti s : effetti)
					 if (s.getId()==riga.getEffetti())
						 txt = s.getDescrizione();
				 celle.add(txt);
				 txt="";
				 
				 for (EffettiSub s : effettiSub)
					 if (s.getId()==riga.getEffettiSub())
						 txt=s.getDescrizione();
				 
				 celle.add(txt);
				 
				 celle.add(FONTI[(int)riga.getFonte()]);
				 celle.add(riga.getDescrizione());
				 celle.add(riga.getEnteSegnalante());
				 celle.add(riga.getRiferimento());
				 celle.add(riga.getNote());
				 
				 for (Object c : celle) {
					 Cell cell = r.createCell(cellnum++);
					
					 if (c!=null) {
						 cell.setCellValue(c!=null?c.toString():"");
						int len = c.toString().length();
						if (len>widths[cellnum-1]) widths[cellnum-1] = len;
					 }
					 cell.setCellStyle(buildStyle(wb, getCellStyle(FOGLI[k], 
							 "","","")));
				 }
			 }
			 
			 for (int col=0; col<widths.length; col++) {
				 int xx = widths[col]+2;
				 if (xx>64) xx = 64;
				 if (xx<3) xx = 3;
				 sheet.setColumnWidth(col, xx*256);
				 //System.out.println("setting column width "+col+" "+xx);
			 }
			 
		}
		
		return wb;
	}
	
	private List<Object[]> getIntestazione(String foglio) {
		List<Object[]> out = new ArrayList<Object[]>();
		Object row[] = {"ID","Data evento","Tipo evento","Sottotipo","Provincia","Comune",
				"Indirizzo","Civico","Area","Macrocat. Effetti","Effetti","Fonte","Descrizione",
				"Ente segnalante","Riferimento","Note"};
		
		out.add(row);
		
		return out;
		
		
	}
	
	private String getIntestazioneStyle(String foglio,String riga) {
		String style = "align-center align-middle bold grey wrap thin-right thin-bottom ";
		
		if (intestazioneStyles.containsKey(riga))
			style+=intestazioneStyles.get(riga);
		
		return style;
	}
	
	
	private List<Object[]> makeIntestazione(String foglio, HSSFWorkbook wb, HSSFSheet s) {
		
		
		List<Object[]> celle = getIntestazione(foglio);
		
		for (int k=0; k<celle.size(); k++) {
			Object[] o = celle.get(k);
			Row r = s.createRow(k);
			for (int j=0; j<o.length; j++) {
				Cell cell = r.createCell(j);
				 if (o[j]!=null) cell.setCellValue(o[j].toString());
				 cell.setCellStyle(buildStyle(wb, getIntestazioneStyle(foglio, o[j].toString())));
			}
		}
		
		for (int k=0; k<celle.size(); k++) {
			Object[] o = celle.get(k);
			for (int j=0; j<o.length; j++) {
				if (k>0 && celle.get(k-1)[j].equals(o[j])) continue;
				if (j>0 && o[j].equals(o[j-1])) continue;
				Object val = o[j];
				int finek = k;
				int finej = j;
				while (finek<celle.size()-1 && celle.get(finek+1)[j].equals(val)) finek++;
				while (finej<o.length-1 && o[finej+1].equals(val)) finej++;
				if (finek>k || finej>j) s.addMergedRegion(new CellRangeAddress(k, finek, j, finej));
			}
		}
		
		s.getRow(0).setHeight((short)-1);
	    //s.getRow(1).setHeight((short)-1);
		//s.getRow(2).setHeight((short)-1);
		
		return celle;
	}
	
	private String getCellStyle(String foglio, String riga1, String riga2, String riga3) {
		String style= "align-center align-middle wrap ";
		
		if (defaultStyles.containsKey(riga1))
			style+=defaultStyles.get(riga1);
		if (defaultStyles.containsKey(riga2))
			style+=defaultStyles.get(riga2);
		if (defaultStyles.containsKey(riga3))
			style+=defaultStyles.get(riga3);
		
		
		return style;
	}
	
	   private CellStyle buildStyle(HSSFWorkbook wb, String st) {
		   
		   if (styles.containsKey(st)) return styles.get(st);

	        CellStyle header1 = wb.createCellStyle();
	        if (st == null) st = "";
	        HSSFFont f = wb.createFont();
	        f.setFontName("Calibri");
	        
	        if (st.contains("align-center")) header1.setAlignment(HorizontalAlignment.CENTER);
	        if (st.contains("align-left")) header1.setAlignment(HorizontalAlignment.LEFT);
	        if (st.contains("align-right")) header1.setAlignment(HorizontalAlignment.RIGHT);
	        if (st.contains("align-middle")) header1.setVerticalAlignment(VerticalAlignment.CENTER);
	        if (st.contains("align-top")) header1.setVerticalAlignment(VerticalAlignment.TOP);
	        if (st.contains("align-bottom")) header1.setVerticalAlignment(VerticalAlignment.BOTTOM);
	        if (st.contains("wrap")) header1.setWrapText(true);
	        if (st.contains("border-right") || st.contains("border-medium")) header1.setBorderRight(BorderStyle.MEDIUM);
	        if (st.contains("border-left") || st.contains("border-medium")) header1.setBorderLeft(BorderStyle.MEDIUM);
	        if (st.contains("border-top") || st.contains("border-medium")) header1.setBorderTop(BorderStyle.MEDIUM);
	        if (st.contains("border-bottom") || st.contains("border-medium")) header1.setBorderBottom(BorderStyle.MEDIUM);
	        if (st.contains("thin-right") || st.contains("border-thin")) header1.setBorderRight(BorderStyle.THIN);
	        if (st.contains("thin-left") || st.contains("border-thin")) header1.setBorderLeft(BorderStyle.THIN);
	        if (st.contains("thin-top") || st.contains("border-thin")) header1.setBorderTop(BorderStyle.THIN);
	        if (st.contains("thin-bottom") || st.contains("border-thin")) header1.setBorderBottom(BorderStyle.THIN);

	        for (int k = 63; k >= 0; k--) {
	            if (st.contains("bgcolor" + (k<10?"0":"")+ k)) {
	                header1.setFillPattern(FillPatternType.SOLID_FOREGROUND);

	                header1.setFillForegroundColor((short) k);
	               
	            }
	            if (st.contains("fontcolor" + (k<10?"0":"") + k)) {
	                f.setColor((short)k);
	              
	            }
	        }
	        
	      

	        if (st.contains("grey")) {
	            header1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	            header1.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	        }


	        if (st.contains("bold")) f.setBold(true);
	        if (st.contains("italic")) f.setItalic(true);
	        if (st.contains("big")) f.setFontHeight((short) 300);
	        if (st.contains("huge")) f.setFontHeight((short) 500);
	       

	        header1.setFont(f);

	        if (st.contains("number")) {
	            DataFormat format = wb.createDataFormat();
	            header1.setDataFormat(format.getFormat("#,##0.00"));
	        } else if (st.contains("currency")) {
	            DataFormat format = wb.createDataFormat();
	            header1.setDataFormat(format.getFormat("€ #,##0.00"));
	        }
	        
	        System.out.println("inserisco stile "+st);
	        styles.put(st, header1);
	        return header1;
	    }

}
