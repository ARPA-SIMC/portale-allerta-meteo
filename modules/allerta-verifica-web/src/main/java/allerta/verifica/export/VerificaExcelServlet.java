package allerta.verifica.export;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.util.InfrastructureUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import org.osgi.service.component.annotations.Component;

import allerta.catasto.model.Segnalazione;
import allerta.catasto.service.SegnalazioneLocalServiceUtil;
import allerta.verifica.model.Verifica;
import allerta.verifica.model.VerificaDato;
import allerta.verifica.service.VerificaDatoLocalServiceUtil;
import allerta.verifica.service.VerificaLocalServiceUtil;
import allerta.verifica.web.bean.CostruttoreVerificaDato;
import allerta.verifica.web.bean.VerificaAllertaBean;
import allerta.verifica.web.bean.VerificaDisplayTerms;
import allerta.verifica.web.constants.CostantiVerificaAllerte;
import it.eng.allerter.model.Allerta;
import it.eng.allerter.service.AllertaLocalServiceUtil;
import it.eng.allerter.service.LogInternoLocalServiceUtil;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;

@Component(
	    immediate = true,
	    property = {
	        "osgi.http.whiteboard.context.path=/",
	        "osgi.http.whiteboard.servlet.pattern=/report/verifica/excel"
	    },
	    service = Servlet.class
	)
public class VerificaExcelServlet extends HttpServlet {
	
	public String[] FOGLI = {"AllertaBollettino","Precipitazioni","Criticità idraulica","Criticità idrogeologica",
			"Criticità temporali","Vento","Temperature estreme","Neve","Pioggia che gela","Stato del mare","Criticità costiera","Valutazione"};
	
	String dataInizio = null;
	String dataFine = null;
	Date d1 = null;
	Date d2 = null;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat ora = new SimpleDateFormat("HH:mm");
	
	List<Verifica> verifiche = null;
	List<VerificaDato> dati = null;
	List<VerificaDato> datiPrecipitazioni = null;
	List<Allerta> allerte = null;
	List<Segnalazione> segnalazioni = null;
	
	Allerta currentAllerta;
	Verifica currentVerifica;
	int currentFenomeno;
	String currentZona;
	String currentRiga1;
	String currentRiga2;
	String currentRiga3;
	
	static Map<String, String> labels = new HashMap<String, String>();
	static Map<String, String> defaultStyles = new HashMap<String, String>();
	static Map<String, String> intestazioneStyles = new HashMap<String, String>();
	
	Map<String,CellStyle> styles;
	
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
		labels.put("note_riga_fenomeno", "Note");
		
		
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
		defaultStyles.put(labels.get("note_riga_fenomeno"), "");
		
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
				resp.setHeader("Content-Disposition", "attachment;filename=verifica.xls");
				resp.setContentLength(output.length);
				resp.getOutputStream().write(output);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			LogInternoLocalServiceUtil.log("VerificaExcelServlet", "doGet", e, "");
		} finally {
			try {
			if (connection!=null) connection.close();	
			} catch (Exception e3) {}
			try {
				if (stream!=null) stream.close();	
				} catch (Exception e3) {}
		}
	}
	
	private String getWhere() {
		return "where 1=1 "+(dataInizio!=null?" and datafine>'"+dataInizio+"' ":"")+(dataFine!=null?" and datainizio<='"+dataFine+"' ":"");
	}
	
	private String getOrderBy() {
		return "order by createdate asc ";
	}
	
	private void getData() {
		DynamicQuery dq = VerificaLocalServiceUtil.dynamicQuery();
		try {
			if (d1!=null)
				dq = dq.add(PropertyFactoryUtil.forName("dataFine").gt(d1));
			if (d2!=null)
				dq = dq.add(PropertyFactoryUtil.forName("dataInizio").le(d2));
		} catch (Exception e) {
			e.printStackTrace();
		}
		dq = dq.addOrder(OrderFactoryUtil.asc("dataInizio"));
	
		verifiche = VerificaLocalServiceUtil.dynamicQuery(dq);
		
		dq = VerificaDatoLocalServiceUtil.dynamicQuery();
		try {
			if (d1!=null)
				dq = dq.add(PropertyFactoryUtil.forName("giorno").gt(d1));
			if (d2!=null)
				dq = dq.add(PropertyFactoryUtil.forName("giorno").le(d2));
			
			dq = dq.addOrder(OrderFactoryUtil.asc("giorno"));
			dq = dq.addOrder(OrderFactoryUtil.asc("zona"));
			dq = dq.addOrder(OrderFactoryUtil.asc("evento"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		dati = VerificaDatoLocalServiceUtil.dynamicQuery(dq);
		
		datiPrecipitazioni = new ArrayList<VerificaDato>();
		if (dati!=null) {
			for (VerificaDato vd : dati) {
				if (vd.getDocumento()==0) datiPrecipitazioni.add(vd);
			}
		}
		
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
		
		dq = SegnalazioneLocalServiceUtil.dynamicQuery();
		try {
						
			if (d1!=null)
				dq = dq.add(PropertyFactoryUtil.forName("dataEvento").ge(d1));
			if (d2!=null)
				dq = dq.add(PropertyFactoryUtil.forName("dataEvento").le(d2));
		} catch (Exception e) {
			e.printStackTrace();
		}
		dq = dq.addOrder(OrderFactoryUtil.asc("dataEvento"));
	
		segnalazioni = SegnalazioneLocalServiceUtil.dynamicQuery(dq);
	}
	
	private List<Object> getRighe(String foglio) {
		ArrayList<Object> out = new ArrayList<Object>();
		
		
		List<VerificaDato> dat = foglio.equals(FOGLI[1])? datiPrecipitazioni : dati;
		if (dat==null || dat.size()==0) return out;
		
		Date giorno = null;
		for (VerificaDato vd : dat) {
			if (giorno==null || (vd.getGiorno()!=null && vd.getGiorno().after(giorno))) {
				out.add(vd.getGiorno());
				giorno = vd.getGiorno();
			}
		}
		
		return out;
		
	}
	
	private int fenomenoForFoglio(String foglio) {
		if (foglio.equals(FOGLI[2])) return 1;
		if (foglio.equals(FOGLI[3])) return 2;
		if (foglio.equals(FOGLI[4])) return 3;
		if (foglio.equals(FOGLI[5])) return 4;
		if (foglio.equals(FOGLI[6])) return 5;
		if (foglio.equals(FOGLI[7])) return 6;
		if (foglio.equals(FOGLI[8])) return 7;
		if (foglio.equals(FOGLI[9])) return 8;
		if (foglio.equals(FOGLI[10])) return 9;
		
		return 0;
	}
	
	private List<Object> getRiga(String foglio, Object idRiga, List<Object[]> intestazione) {
		
		ArrayList<Object> out = new ArrayList<Object>();
		if (intestazione==null || intestazione.size()==0 || intestazione.get(0).length==0) return out;
		
		List<VerificaDato> d = VerificaAllertaBean.filtraDati(dati,
				(Date)idRiga,null,null,null,null);
		
		List<VerificaDato> d2 = VerificaAllertaBean.filtraDati(datiPrecipitazioni,
				(Date)idRiga,null,null,null,null);
		
		Verifica v = null;
		Allerta a = null;
		List<Segnalazione> segn = new ArrayList<Segnalazione>();
		Date giorno = (Date)idRiga;
		Date startOfGiorno = null;
		Date startOfTomorrow = null;
		
		
		Calendar c = Calendar.getInstance();
		c.setTime(giorno);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		startOfGiorno = c.getTime();
		c.add(Calendar.DAY_OF_YEAR, 1);
		startOfTomorrow = c.getTime();
		String stringOfGiorno = sdf.format(startOfGiorno);
		
		long fenomeno = fenomenoForFoglio(foglio);
		String[] colonne = null;
		if (fenomeno>0) {
			colonne=CostantiVerificaAllerte.EVENTI_COLONNE.get(""+fenomeno);
		}
		
		long id = 0;
		
		
			for (VerificaDato vd : d) {
				if (vd.getDocumento()!=0) {
					id = vd.getDocumento();
					for (Verifica vv : verifiche) {
						if (vv.getId()==id) {
							v = vv;
							break;
						}
					}
					for (Allerta aa : allerte) {
						if (aa.getAllertaId()==id) {
							a = aa;
							break;
						}
					}
					break;
				}
			}
		
			
		
		
		if (fenomeno>0 && a!=null) {
			for (Segnalazione s : segnalazioni) {
				if (/*s.getDocumentoAssociato()==id && */ s.getDataEvento()!=null && sdf.format(s.getDataEvento()).equals(stringOfGiorno))
					segn.add(s);
			}
		}
		
		//riempi le colonne
		for (int k=0; k<intestazione.get(0).length; k++) {
			String riga1 = intestazione.get(0)[k].toString();
			String riga2 = (intestazione.size()>1?intestazione.get(1)[k].toString():"");
			String riga3 = (intestazione.size()>2?intestazione.get(2)[k].toString():"");
			
			for (int ff=0; ff<CostantiVerificaAllerte.EVENTI.length; ff++)
				if (riga1.equals(CostantiVerificaAllerte.EVENTI[ff])) fenomeno = ff+1;
			
			
			String cella = "";
			String zona = riga1.startsWith("ZONA")?riga1.split(" ")[1]:null;
			if (zona==null && (riga2.endsWith("1") || riga2.endsWith("2") || riga2.endsWith("3")))
				zona = riga2;
			
			
			currentFenomeno=(int)fenomeno;
			currentZona=zona;
			currentVerifica=v;
			currentAllerta=a;
			currentRiga1=riga1;
			currentRiga2=riga2;
			currentRiga3=riga3;
			
			
			if (riga3.equals(labels.get("data_evento"))) {
				cella = sdf.format(giorno);
			}

			if (riga3.equals(labels.get("numero_documento"))) {
				cella = (a!=null?(a.getTipoAllerta()?"A ":"B ")+a.getNumero():"");
			}
			
			if (riga3.equals(labels.get("numero_documento_semplice"))) {
				cella = (a!=null?a.getNumero():"");
			}
			
			if (riga3.equals(labels.get("allerta_bollettino"))) {
				cella = (a!=null?(a.getTipoAllerta()?"A":"B"):"");
			}
			
			if (riga3.equals(labels.get("durata"))) {
				cella = (giorno.getTime()==startOfGiorno.getTime()?"1":"0,5");
			}
			
			if (riga3.equals(labels.get("codice_colore_max"))) {
				int max = 0;
				for (VerificaDato vd : d) {
					if ("colore_pre".equals(vd.getNomeDato())) {
						String ssss = CostruttoreVerificaDato.getDato(vd);
						int prev = 0;
						if ("GIALLO".equals(ssss)) prev = 1;
						if ("ARANCIONE".equals(ssss)) prev = 2;
						if ("ROSSO".equals(ssss)) prev = 3;
						if (prev>max) max = prev;
					}
				}
				if (max==0) cella = "V";
				else if (max==1) cella = "G";
				else if (max==2) cella = "A";
				else if (max==3) cella = "R";
				
			}
			
			if (riga3.equals(labels.get("codice_colore_fenomeno"))) {
				int fen = 0;
				for (int ee=0; ee<9; ee++) if (riga1.equals(CostantiVerificaAllerte.EVENTI[ee]))
					fen = ee+1;
				
				int max = 0;
				for (VerificaDato vd : d) {
					if ("colore_pre".equals(vd.getNomeDato()) && vd.getEvento()==fen) {
						String ssss = CostruttoreVerificaDato.getDato(vd);
						int prev = 0;
						if ("GIALLO".equals(ssss)) prev = 1;
						if ("ARANCIONE".equals(ssss)) prev = 2;
						if ("ROSSO".equals(ssss)) prev = 3;
						if (prev>max) max = prev;
					}
				}
				if (max==0) cella = "V";
				else if (max==1) cella = "G";
				else if (max==2) cella = "A";
				else if (max==3) cella = "R";
				
			}
			
			if (riga3.equals(labels.get("zone_fenomeno"))) {
				int fen = 0;
				for (int ee=0; ee<9; ee++) if (riga1.equals(CostantiVerificaAllerte.EVENTI[ee]))
					fen = ee+1;
				
				cella = "";
				for (VerificaDato vd : d) {
					if ("colore_pre".equals(vd.getNomeDato()) && vd.getEvento()==fen) {
						String ssss = CostruttoreVerificaDato.getDato(vd);
						
						if ("GIALLO".equals(ssss) ||
						"ARANCIONE".equals(ssss) ||
						"ROSSO".equals(ssss)) {
							if (!"".equals(cella)) cella+=",";
							cella += vd.getZona();
						}
					
					}
				}
				
			}

			if (riga3.equals(labels.get("note_allerta")) && v!=null) {
				cella = v.getNote();
			}
			
			if (riga3.equals(labels.get("fenomeni_descritti")) && v!=null) {
				cella = v.getFenomeniDescritti();
			}
			
			if (riga3.equals(labels.get("fenomeni_allerta")) && v!=null) {
				cella = v.getFenomeni();
			}
			
			if (riga3.equals(labels.get("data_emissione"))) {
				cella = (a!=null && a.getDataEmissione()!=null?(sdf.format(a.getDataEmissione())):"");
			}
			
			if (riga2.equals(labels.get("inizio_validita_codice_colore"))) {
				if (riga3.equals(labels.get("data"))) cella = sdf.format(giorno);
				if (riga3.equals(labels.get("ora"))) cella = ora.format(giorno);
			}
			
			if (riga2.equals(labels.get("fine_validita_codice_colore"))) {

				if (riga3.equals(labels.get("data"))) cella = sdf.format(startOfTomorrow);
				if (riga3.equals(labels.get("ora"))) cella = ora.format(startOfTomorrow);
			}
			
			if ((riga3.equals(labels.get("codice_previsto")) || riga3.equals(labels.get("prev_val"))) && zona!=null) {
				VerificaDato vd = VerificaAllertaBean.filtraDatiUnico(d, giorno, zona, fenomeno, "colore_pre", null);
				if (vd!=null) {
					cella = CostruttoreVerificaDato.getDato(vd);
					if (cella!=null && cella.length()>1) cella=cella.substring(0, 1);
				}
			}
			
			if (riga3.equals(labels.get("previsto_24h")) && zona!=null) {
				VerificaDato vd = VerificaAllertaBean.filtraDatiUnico(d, giorno, zona, null, "precipitazioni_previste", null);
				if (vd!=null) {
					cella = CostruttoreVerificaDato.getDato(vd);
				}
			}
			
			if (riga3.equals(labels.get("osservato_24h")) && zona!=null) {
				VerificaDato vd = VerificaAllertaBean.filtraDatiUnico(d, giorno, zona, null, "precipitazioni_osservate", null);
				if (vd!=null) {
					cella = CostruttoreVerificaDato.getDato(vd);
				}
			}
			
			if ((riga3.equals(labels.get("codice_osservato")) || riga3.equals(labels.get("oss_val"))) && zona!=null) {
				VerificaDato vd = VerificaAllertaBean.filtraDatiUnico(d, giorno, zona, fenomeno, "colore_post", null);
				if (vd!=null) {
					cella = CostruttoreVerificaDato.getDato(vd);
					if (cella!=null && cella.length()>1) cella=cella.substring(0, 1);
				}
			}
			
			if ((riga3.equals(labels.get("note_riga_fenomeno"))) && zona!=null) {
				VerificaDato vd = VerificaAllertaBean.filtraDatiUnico(d, giorno, zona, fenomeno, "note", null);
				if (vd!=null) {
					cella = CostruttoreVerificaDato.getDato(vd);
					if (cella!=null && cella.length()>1) cella=cella.substring(0, 1);
				}
			}
			
			if (riga3.equals(labels.get("segnalazioni_territorio")) && zona!=null && segn!=null && segn.size()>0) {
				cella="";
				for (Segnalazione s : segn) {
					if (zona.equals(s.getArea()) && (fenomeno==s.getCategoria() || s.getCategoria()==0))
						cella+="#"+s.getId()+": "+(s.getComune()!=null?s.getComune():"")+" ";
				}
			}
			
			
			if (riga2.equals(labels.get("post_allerta")) && colonne!=null) {
				for (String col : colonne) {
					String lab = CostantiVerificaAllerte.NOMI_COLONNE.get(col);
					if (lab.equals(riga3)) {
						VerificaDato vd = VerificaAllertaBean.filtraDatiUnico(d, giorno, zona, fenomeno, col, null);		
						if (vd!=null) {
							cella = CostruttoreVerificaDato.getDato(vd);
						}
					}
				}
			}
			
			if (riga3.equals(labels.get("note_valutazione")) && fenomeno>0) {
				VerificaDato vd = VerificaAllertaBean.filtraDatiUnico(d, giorno, null, fenomeno, "note_valutazione", null);
				if (vd!=null) {
					cella = CostruttoreVerificaDato.getDato(vd);
				}
			}
			
			if (riga3.equals(labels.get("valutazione_descrittiva")) && fenomeno>0) {
				VerificaDato vd = VerificaAllertaBean.filtraDatiUnico(d, giorno, null, fenomeno, "valutazione_descrittiva", null);
				if (vd!=null) {
					cella = CostruttoreVerificaDato.getDato(vd);
				}
			}
			
			if (riga3.equals(labels.get("corretto")) && fenomeno>0) {
				VerificaDato vd = VerificaAllertaBean.filtraDatiUnico(d, giorno, null, fenomeno, "correttezza", null);
				if (vd!=null) {
					cella = CostruttoreVerificaDato.getDato(vd);
				}
			}
			
			if (riga3.equals(labels.get("magnitudo")) && fenomeno>0) {
				VerificaDato vd = VerificaAllertaBean.filtraDatiUnico(d, giorno, null, fenomeno, "magnitudo", null);
				if (vd!=null) {
					cella = CostruttoreVerificaDato.getDato(vd);
				}
			}
			
			if (riga3.equals(labels.get("localizzazione")) && fenomeno>0) {
				VerificaDato vd = VerificaAllertaBean.filtraDatiUnico(d, giorno, null, fenomeno, "localizzazione", null);
				if (vd!=null) {
					cella = CostruttoreVerificaDato.getDato(vd);
				}
			}
			
			if (riga3.equals(labels.get("cause")) && fenomeno>0) {
				VerificaDato vd = VerificaAllertaBean.filtraDatiUnico(d, giorno, null, fenomeno, "cause", null);
				if (vd!=null) {
					cella = CostruttoreVerificaDato.getDato(vd);
				}
			}
			
			if (cella==null) cella = "";
			out.add(cella);
		}
		
		return out;
	}
	
	private List<Object[]> getIntestazioneSommario() {
		
		List<Object[]> out = new ArrayList<Object[]>();
		List<String> l = new ArrayList<String>();
		
		l.add(labels.get("data_evento"));
		l.add(labels.get("allerta_bollettino"));
		l.add(labels.get("durata"));
		l.add(labels.get("numero_documento_semplice"));
		l.add(labels.get("data_emissione"));
		l.add(labels.get("inizio_validita_codice_colore"));
		l.add(labels.get("inizio_validita_codice_colore"));
		l.add(labels.get("fine_validita_codice_colore"));
		l.add(labels.get("fine_validita_codice_colore"));
		l.add(labels.get("codice_colore_max"));
		
		for (String ev : CostantiVerificaAllerte.EVENTI) {
			l.add(ev);
			l.add(ev);
		}
		
		l.add(labels.get("note_allerta"));
		l.add(labels.get("fenomeni_descritti"));
		l.add(labels.get("fenomeni_allerta"));
		
		out.add(l.toArray());
		out.add(l.toArray());
		
		l.clear();
		
		l.add(labels.get("data_evento"));
		l.add(labels.get("allerta_bollettino"));
		l.add(labels.get("durata"));
		l.add(labels.get("numero_documento_semplice"));
		l.add(labels.get("data_emissione"));
		l.add(labels.get("data"));
		l.add(labels.get("ora"));
		l.add(labels.get("data"));
		l.add(labels.get("ora"));
		l.add(labels.get("codice_colore_max"));
		
		for (String ev : CostantiVerificaAllerte.EVENTI) {
			l.add(labels.get("zone_fenomeno"));
			l.add(labels.get("codice_colore_fenomeno"));
		}
		
		l.add(labels.get("note_allerta"));
		l.add(labels.get("fenomeni_descritti"));
		l.add(labels.get("fenomeni_allerta"));
		out.add(l.toArray());
		
		return out;
		
	}
	
	private List<Object[]> getIntestazioneValutazione() {
		
		List<Object[]> out = new ArrayList<Object[]>();
		List<String> l = new ArrayList<String>();
		
		l.add(labels.get("data_evento"));
		l.add(labels.get("numero_documento"));
		l.add(labels.get("inizio_validita_codice_colore"));
		l.add(labels.get("inizio_validita_codice_colore"));
		l.add(labels.get("fine_validita_codice_colore"));
		l.add(labels.get("fine_validita_codice_colore"));
		
		int k=1;
		for (String ev : CostantiVerificaAllerte.EVENTI) {
			int size = (k>=8?18:2);
			for (int j=0; j<size; j++) {
				//l.add(ev);
				//l.add(ev);
			}
			
			l.add(ev);
			l.add(ev);
			l.add(ev);
			l.add(ev);
			l.add(ev);
			l.add(ev);
			
			
			k++;
		}

		out.add(l.toArray());
		
		l.clear();
		
		l.add(labels.get("data_evento"));
		l.add(labels.get("numero_documento"));
		l.add(labels.get("inizio_validita_codice_colore"));
		l.add(labels.get("inizio_validita_codice_colore"));
		l.add(labels.get("fine_validita_codice_colore"));
		l.add(labels.get("fine_validita_codice_colore"));
		
		k=1;
		for (String ev : CostantiVerificaAllerte.EVENTI) {
			int size = (k>=8?2:18);
			for (int j=0; j<size; j++) {
				String z[] = k>=8?CostantiVerificaAllerte.SOTTOZONE_COSTA:CostantiVerificaAllerte.SOTTOZONE;
				//l.add(z[j]);
				//l.add(z[j]);
			}
			
			l.add(labels.get("note_valutazione"));
			l.add(labels.get("valutazione_descrittiva"));
			l.add(labels.get("valutazione_codice_sintetico"));
			l.add(labels.get("valutazione_codice_sintetico"));
			l.add(labels.get("valutazione_codice_sintetico"));
			l.add(labels.get("valutazione_codice_sintetico"));
			
			
			k++;
		}
		
		out.add(l.toArray());
		
		l.clear();
		
		l.add(labels.get("data_evento"));
		l.add(labels.get("numero_documento"));
		l.add(labels.get("data"));
		l.add(labels.get("ora"));
		l.add(labels.get("data"));
		l.add(labels.get("ora"));
		
		for (String ev : CostantiVerificaAllerte.EVENTI) {
			//l.add(labels.get("prev_val"));
			//l.add(labels.get("oss_val"));
			
			l.add(labels.get("note_valutazione"));
			l.add(labels.get("valutazione_descrittiva"));
			l.add(labels.get("corretto"));
			l.add(labels.get("magnitudo"));
			l.add(labels.get("localizzazione"));
			l.add(labels.get("cause"));
		}
		
		
		out.add(l.toArray());
		
		return out;
		
	}
	
private List<Object[]> getIntestazionePrecipitazioni() {
		
		List<Object[]> out = new ArrayList<Object[]>();
		List<String> l = new ArrayList<String>();
		
		l.add(labels.get("data_evento"));
		l.add(labels.get("allerta_bollettino"));
		l.add(labels.get("numero_documento_semplice"));
		l.add(labels.get("data_emissione"));
		l.add(labels.get("inizio_validita_codice_colore"));
		l.add(labels.get("inizio_validita_codice_colore"));
		l.add(labels.get("fine_validita_codice_colore"));
		l.add(labels.get("fine_validita_codice_colore"));
		
		
		for (String ev : CostantiVerificaAllerte.ZONE) {
			l.add("ZONA "+ev);
			l.add("ZONA "+ev);
		}
		
		out.add(l.toArray());
		out.add(l.toArray());
		
		l.clear();
		
		l.add(labels.get("data_evento"));
		l.add(labels.get("allerta_bollettino"));
		l.add(labels.get("numero_documento_semplice"));
		l.add(labels.get("data_emissione"));
		l.add(labels.get("data"));
		l.add(labels.get("ora"));
		l.add(labels.get("data"));
		l.add(labels.get("ora"));
		
		for (String ev : CostantiVerificaAllerte.ZONE) {
			l.add(labels.get("previsto_24h"));
			l.add(labels.get("osservato_24h"));
		}
		
		out.add(l.toArray());
		
		return out;
		
	}
	
	private List<Object[]> getIntestazioneFenomeno(int fenomeno) {
		
		List<Object[]> out = new ArrayList<Object[]>();
		List<String> l = new ArrayList<String>();
		String zone[] = (fenomeno>=8?CostantiVerificaAllerte.SOTTOZONE_COSTA:CostantiVerificaAllerte.SOTTOZONE);
		String custom[] = CostantiVerificaAllerte.EVENTI_COLONNE.get(""+fenomeno);
		int customs = custom.length;
		
		l.add(labels.get("data_evento"));
		l.add(labels.get("numero_documento"));
		l.add(labels.get("data_emissione"));
		l.add(labels.get("inizio_validita_codice_colore"));
		l.add(labels.get("inizio_validita_codice_colore"));
		l.add(labels.get("fine_validita_codice_colore"));
		l.add(labels.get("fine_validita_codice_colore"));
		
		for (String zona : zone) {
			String z = "ZONA "+zona;
			l.add(z);
			for (int k=0; k<customs; k++) l.add(z);
			l.add(z);
			l.add(z);
			l.add(z);
		}
		
		out.add(l.toArray());
		
		l.clear();
		
		l.add(labels.get("data_evento"));
		l.add(labels.get("numero_documento"));
		l.add(labels.get("data_emissione"));
		l.add(labels.get("inizio_validita_codice_colore"));
		l.add(labels.get("inizio_validita_codice_colore"));
		l.add(labels.get("fine_validita_codice_colore"));
		l.add(labels.get("fine_validita_codice_colore"));
		
		for (String zona : zone) {

			l.add(labels.get("post_briefing"));
			for (int k=0; k<customs; k++) l.add(labels.get("post_allerta"));
			l.add(labels.get("post_allerta"));
			l.add(labels.get("post_allerta"));
			l.add(labels.get("post_verifica"));
		}
		
		out.add(l.toArray());
		
		l.clear();
		
		l.add(labels.get("data_evento"));
		l.add(labels.get("numero_documento"));
		l.add(labels.get("data_emissione"));
		l.add(labels.get("data"));
		l.add(labels.get("ora"));
		l.add(labels.get("data"));
		l.add(labels.get("ora"));
		
		for (String zona : zone) {

			l.add(labels.get("codice_previsto"));
			for (int k=0; k<customs; k++) l.add(CostantiVerificaAllerte.NOMI_COLONNE.get(custom[k]));
			l.add(labels.get("segnalazioni_territorio"));
			l.add(labels.get("noteXXX"));
			l.add(labels.get("codice_osservato"));
		}
		
		out.add(l.toArray());
		
		return out;
		
	}
	
	private List<Object[]> getIntestazione(String foglio) {
		List<Object[]> out = new ArrayList<Object[]>();
		
		if (foglio.equals(FOGLI[0])) return getIntestazioneSommario();
		if (foglio.equals(FOGLI[1])) return getIntestazionePrecipitazioni();
		if (foglio.equals(FOGLI[11])) return getIntestazioneValutazione();
		if (fenomenoForFoglio(foglio)!=0)
			return getIntestazioneFenomeno(fenomenoForFoglio(foglio));
		
		
		return out;
		
		
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
		s.getRow(1).setHeight((short)-1);
		s.getRow(2).setHeight((short)-1);
		
		return celle;
	}

	
	private HSSFWorkbook creaExcel() {
		HSSFWorkbook wb = HSSFWorkbookFactory.createWorkbook();
		for (int k=0; k<FOGLI.length; k++) {
			 HSSFSheet sheet = wb.createSheet(FOGLI[k]);

			 List<Object[]> intestaz = makeIntestazione(FOGLI[k], wb, sheet);
			 int rownum = intestaz.size();
			 
			 List<Object> righe = getRighe(FOGLI[k]);
			 if (righe==null || righe.size()==0) continue;
			 
			 int widths[] = new int[intestaz.get(0).length];
			 for (int col=0; col<widths.length; col++) {
				 String[] split = intestaz.get(2)[col].toString().split("\n");
				 String x2 = split[split.length-1];
				 widths[col] = x2.length();
			 }
			 
			 for (Object riga : righe) {
				 List<Object> celle = getRiga(FOGLI[k], riga, intestaz);
				 Row r = sheet.createRow(rownum++);
				 r.setHeight((short)600);
				 int cellnum = 0;
				 for (Object c : celle) {
					 Cell cell = r.createCell(cellnum++);
					
					 if (c!=null) {
						 cell.setCellValue(c.toString());
						int len = c.toString().length();
						if (len>widths[cellnum-1]) widths[cellnum-1] = len;
					 }
					 cell.setCellStyle(buildStyle(wb, getCellStyle(FOGLI[k], 
							 currentVerifica, currentAllerta, (Date)riga, intestaz.get(0)[cellnum-1].toString(),
							 intestaz.get(1)[cellnum-1].toString(), intestaz.get(2)[cellnum-1].toString(), currentFenomeno, c)));
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
	
	private String getIntestazioneStyle(String foglio,String riga) {
		String style = "align-center align-middle bold grey wrap thin-right thin-bottom ";
		
		if (intestazioneStyles.containsKey(riga))
			style+=intestazioneStyles.get(riga);
		
		return style;
	}
	
	private String getCellStyle(String foglio, Verifica v, Allerta a, Date giorno, String riga1, String riga2, String riga3, int fenomeno, Object valore) {
		String style= "align-center align-middle wrap ";
		
		if (defaultStyles.containsKey(riga1))
			style+=defaultStyles.get(riga1);
		if (defaultStyles.containsKey(riga2))
			style+=defaultStyles.get(riga2);
		if (defaultStyles.containsKey(riga3))
			style+=defaultStyles.get(riga3);
		
		if (!foglio.equals(FOGLI[11]) && a!=null && a.getTipoAllerta()) style+=" bgcolor47";
		
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
