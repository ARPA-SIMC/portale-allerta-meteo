package it.eng.allerta.previsioni.bean;

import java.io.Serializable;
import java.io.StringReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.osgi.service.component.annotations.Reference;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.eng.previsioni.meteo.exception.NoSuchImgException;
import it.eng.previsioni.meteo.model.Bollettino;
import it.eng.previsioni.meteo.model.Storico;
import it.eng.previsioni.meteo.service.BollettinoLocalService;
import it.eng.previsioni.meteo.service.BollettinoLocalServiceUtil;
import it.eng.previsioni.meteo.service.ImgLocalService;
import it.eng.previsioni.meteo.service.ImgLocalServiceUtil;
import it.eng.previsioni.meteo.service.StoricoLocalService;
import it.eng.previsioni.meteo.service.StoricoLocalServiceUtil;

public class Previsioni implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static Map<String,String> dayTransform;
	static{
		dayTransform = new HashMap<>();
		dayTransform.put("oggi", "domani");
		dayTransform.put("domani", "dopodomani");
		dayTransform.put("dopodomani", "quartogiorno");
	}
	
	private static Log _log = LogFactoryUtil.getLog(Previsioni.class); 
	private List<String> meteoProv = new ArrayList<String>();

	private ArrayList<TableRow> storici = new ArrayList<TableRow>();
	private XPath xPath;
	private Document doc;
	
	public Previsioni(){
		
		Bollettino bollettino = BollettinoLocalServiceUtil.findByTipo("completo");
		
		String xmlString = bollettino.getXml_content();
		
		try {
			
			doc = loadXMLFromString(xmlString);
			xPath =  XPathFactory.newInstance().newXPath();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(e);
		}
	}
	
	public String getImg(String part, String day, String provincia){
		
		String img = null;

		try {
			
			String timestamp = (String) xPath.compile("bollettinoCompleto/"+day+"/bollettino/@timestamp").evaluate(doc, XPathConstants.STRING);
			
			Date date = getZeroTimeDate(new Date(Long.valueOf(timestamp)*1000L));
			
			if(date.compareTo(getZeroTimeDate(new Date()))!=0){
				day = dayTransform.get(day);
			}
			
			img = ImgLocalServiceUtil.getByPartDayProvincia(part,day,provincia).getData();
			
		} catch (NoSuchImgException e) {
			// TODO Auto-generated catch block
			_log.error(e);
		} catch (XPathExpressionException|SystemException e) {
			// TODO Auto-generated catch block
			_log.error(e);
		}
		
		return img;
	}
	
	public List<String> readXmlBollettino(String day){
		
		List<String> prev = new ArrayList<>();
		try{
				//Bollettino bollettino = BollettinoLocalServiceUtil.findByTipo("completo");
				//String xmlString = bollettino.getXml_content();
				//Document doc = Scheduler.loadXMLFromString(xmlString);
				//XPath xPath =  XPathFactory.newInstance().newXPath();
				
				String cielo = (String) xPath.compile("bollettinoCompleto/"+day+"/bollettino/regionale/testo/cielo").evaluate(doc, XPathConstants.STRING);
				String temperatura = (String) xPath.compile("bollettinoCompleto/"+day+"/bollettino/regionale/testo/temperatura").evaluate(doc, XPathConstants.STRING);
				String vento =  (String) xPath.compile("bollettinoCompleto/"+day+"/bollettino/regionale/testo/vento").evaluate(doc, XPathConstants.STRING);
				String mare =  (String) xPath.compile("bollettinoCompleto/"+day+"/bollettino/regionale/testo/mare").evaluate(doc, XPathConstants.STRING);
				
				prev.add(cielo);
				prev.add(temperatura);
				prev.add(vento);
				prev.add(mare);
				
		}catch(Exception e){
			_log.error(e);
		}
		return prev;
	}
	
	public List<String> getMeteoProv(String provincia) {
		
		meteoProv = new ArrayList<String>();
		storici = new ArrayList<TableRow>();
		
		try {
			
//			Bollettino bollettino = BollettinoLocalServiceUtil.findByTipo("completo");
//			XPath xPath =  XPathFactory.newInstance().newXPath();
			
			Calendar cal = Calendar.getInstance();
			
			for(String day: GestioneBean.types){
				
				//doc = Scheduler.loadXMLFromString(bollettino.getXml_content());
				meteoProv.add((String) xPath.compile("bollettinoCompleto/"+day+"/bollettino/provinciale/"+provincia+"/testo_previsione").evaluate(doc, XPathConstants.STRING));
				Node dataTableNode =(Node) xPath.compile("bollettinoCompleto/"+day+"/bollettino/dati").evaluate(doc, XPathConstants.NODE);
				
				storici.add(createTableStorici(StoricoLocalServiceUtil.getStoricoBySigla(provincia),dataTableNode, day, cal.get(Calendar.DAY_OF_YEAR)));
				
				cal.add(Calendar.DAY_OF_YEAR,1);
			}
			
		}catch(Exception e){
			
			_log.error(e);
		}
		
		return meteoProv;
	}
	
	private TableRow createTableStorici(List<Storico> storicoList, Node bollettinoDataNode, String day, Integer dayYear) {
		
		TableRow tableRow = new TableRow();
		Document doc;
		
		XPath xPath =  XPathFactory.newInstance().newXPath();
		
		StringBuilder htmlHeader= new StringBuilder();
		StringBuilder tMin = new StringBuilder();
		StringBuilder tMax = new StringBuilder();
		StringBuilder prec = new StringBuilder();
		StringBuilder vento = new StringBuilder();
		
		try{
			
			for(Storico current:storicoList){
				
				htmlHeader.append("<th>"+current.getTipo()+"</th>");
				
				doc = loadXMLFromString(current.getXml());
				
				Integer id = current.getIdZona();
				
				DecimalFormat df = new DecimalFormat("###.#");
				
				float maxStorico = Float.parseFloat((String)xPath.compile("(//Tmax_Daily_Mean)["+dayYear+"]").evaluate(doc, XPathConstants.STRING));
				float minStorico = Float.parseFloat((String) xPath.compile("(//Tmin_Daily_Mean)["+dayYear+"]").evaluate(doc, XPathConstants.STRING));
				
				tMin.append("<td>"+(String)xPath.compile("temperatura_minima/t"+id+"/@dato").evaluate(bollettinoDataNode, XPathConstants.STRING)+"<span>("+df.format(minStorico)+")</span></td>");
				tMax.append("<td>"+(String)xPath.compile("temperatura_massima/T"+id+"/@dato").evaluate(bollettinoDataNode, XPathConstants.STRING)+"<span>("+df.format(maxStorico)+")</span></td>");
				prec.append("<td>"+new String((String)xPath.compile("precipitazioni/P"+id+"/@dato").evaluate(bollettinoDataNode, XPathConstants.STRING))+"</td>");
				vento.append("<td>"+(String) xPath.compile("vento_massimo/V"+id+"/@dato").evaluate(bollettinoDataNode, XPathConstants.STRING)+"</td>");
			}
			
			tableRow.setHeader(htmlHeader.toString());
			tableRow.settMin(tMin.append("<td>°C</td>").toString());
			tableRow.settMax(tMax.append("<td>°C</td>").toString());
			tableRow.setPrecipitazioni(prec.append("<td><small>mm</small></td").toString());
			tableRow.setVento(vento.append("<td><small>km/h</small></td>").toString());
			
			System.out.println(day+" "+dayYear);
			
		}catch(Exception e){
			_log.error(e);
		}
		
		return tableRow;
	}
	
	public ArrayList<TableRow> getStorici(){
		
		return storici;
	}
	
	public void setStorici(ArrayList<TableRow> list){
		
		this.storici =list;
	}
	
	private static Date getZeroTimeDate(Date date) {
		
		Calendar calendar = Calendar.getInstance();
		
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		date = calendar.getTime();
		
		return date;
	}
	
	private static Document loadXMLFromString(String xml) throws Exception {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(xml));
		
		return builder.parse(is);
	}
	

}
