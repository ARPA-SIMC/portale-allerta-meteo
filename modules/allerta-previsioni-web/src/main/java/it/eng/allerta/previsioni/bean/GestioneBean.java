package it.eng.allerta.previsioni.bean;

import java.io.Serializable;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

//import javax.xml.xpath.XPath;
//import javax.xml.xpath.XPathConstants;
//import javax.xml.xpath.XPathFactory;

import org.osgi.service.component.annotations.Reference;
import org.xml.sax.InputSource;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.eng.previsioni.meteo.model.Bollettino;
import it.eng.previsioni.meteo.model.Img;
import it.eng.previsioni.meteo.service.BollettinoLocalService;
import it.eng.previsioni.meteo.service.BollettinoLocalServiceUtil;
import it.eng.previsioni.meteo.service.ImgLocalService;
import it.eng.previsioni.meteo.service.ImgLocalServiceUtil;

public class GestioneBean implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	private static Log _log = LogFactoryUtil.getLog(GestioneBean.class); 
	
	static final List<String> types;
	static {
		types = new ArrayList<String>();
		types.add("oggi");
		types.add("domani");
		types.add("dopodomani");
	}
	
	static final HashMap<String,String> typesIeri;
	static {
		typesIeri = new HashMap<String,String>();
		typesIeri.put("oggi","domani");
		typesIeri.put("domani","dopodomani");
		typesIeri.put("dopodomani","quartogiorno");
	}
	private static HashMap<String, Giorno> previsioni = new HashMap<String, Giorno>();
	private HashMap<String,String> previsioniRegione =  new HashMap<String, String>();
	private	HashMap<String,String> previsioniProvincia = new HashMap<String, String>();
	private HashMap<String,String> nowcastMap = new HashMap<String, String>();


	public GestioneBean() {
		
		readXmlBollettino();
	}
	
	public static void readXmlBollettino(){
		
		try{
			
			int i = 0;
			
			Bollettino bollettino = BollettinoLocalServiceUtil.findByTipo("completo");
			
			String xmlString = bollettino.getJson();
			JSONObject doc = loadXMLFromString(xmlString);
			

			
			for(String currentType:types){
				
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DAY_OF_YEAR, i);
				
				Giorno giorno = new Giorno();
				giorno.setNome(new SimpleDateFormat("EEEE", Locale.ITALY).format(cal.getTime()));
				
				
				
				//XPath xPath =  XPathFactory.newInstance().newXPath();
				
			
				
				JSONObject jo = doc.getJSONObject(currentType).getJSONObject("bollettino").getJSONObject("regionale").getJSONObject("testo");
				String cielo = jo.getString("cielo");
				String temperatura = jo.getString("temperatura");
				String vento =  jo.getString("vento");
				String mare =  jo.getString("mare");
				
				giorno.setCielo(cielo);
				giorno.setTemperatura(temperatura);
				giorno.setVento(vento);
				giorno.setMare(mare);

				previsioni.put(currentType,giorno);
				i++;
			}
		}catch(Exception e){
			
			_log.error(e);
		}
	}
	
	public void getDescriptionProvincia(String provincia, String giorno){
		
		try {
			
			String xmlString = BollettinoLocalServiceUtil.findByTipo("completo").getJson();
			
			JSONObject doc = loadXMLFromString(xmlString);
			//XPath xPath =  XPathFactory.newInstance().newXPath();	

			/*String cielo = (String) xPath.compile("bollettinoCompleto/"+giorno+"/bollettino/provinciale/"+provincia).evaluate(doc, XPathConstants.STRING);
			String temperaturaMin = (String) xPath.compile("bollettinoCompleto/"+giorno+"/bollettino/dati/temperatura_minima").evaluate(doc, XPathConstants.STRING);
			String temperaturaMax = (String) xPath.compile("bollettinoCompleto/"+giorno+"/bollettino/dati/temperatura_massima").evaluate(doc, XPathConstants.STRING);
			String vento = (String) xPath.compile("bollettinoCompleto/"+giorno+"/bollettino/dati/vento_massimo").evaluate(doc, XPathConstants.STRING);
			String precipitazioni = (String) xPath.compile("bollettinoCompleto/"+giorno+"/bollettino/dati/precipitazioni").evaluate(doc, XPathConstants.STRING);
			 */
			JSONObject cielo = doc.getJSONObject(giorno).getJSONObject("bollettino").getJSONObject("provinciale").getJSONObject(provincia);
			JSONObject temperaturaMin = doc.getJSONObject(giorno).getJSONObject("bollettino").getJSONObject("dati").getJSONObject("temperatura_minima");
			JSONObject temperaturaMax = doc.getJSONObject(giorno).getJSONObject("bollettino").getJSONObject("dati").getJSONObject("temperatura_massima");
			JSONObject vento = doc.getJSONObject(giorno).getJSONObject("bollettino").getJSONObject("dati").getJSONObject("vento_massimo");
			JSONObject precipitazioni = doc.getJSONObject(giorno).getJSONObject("bollettino").getJSONObject("dati").getJSONObject("precipitazioni");
			
			
			previsioniProvincia.put("cielo",cielo.toJSONString());
			previsioniProvincia.put("temperaturaMin",temperaturaMin.toJSONString());
			previsioniProvincia.put("temperaturaMax",temperaturaMax.toJSONString());
			previsioniProvincia.put("vento",vento.toJSONString());
			previsioniProvincia.put("precipitazioni",precipitazioni.toJSONString());


		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	public void getPrevisioniRegione(String giorno){
		
		try {
			
			List<Img> temp_list = ImgLocalServiceUtil.getByDayProvincia(giorno,"ND");
			
			for(Img current:temp_list){
				previsioniRegione.put(current.getDaypart(), current.getData());
			}

		} catch (SystemException e) {
			// TODO Auto-generated catch block
			_log.error(e);
		}
	}
	
	public void getPrevisioniProvincia(String prov, String giorno){
		
		try {
			
			List<Img> temp_list = ImgLocalServiceUtil.getByDayProvincia(giorno, prov);
			
			for(Img current:temp_list){
				previsioniProvincia.put(current.getDaypart(),current.getData());
			}
			
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			_log.error(e);
		}
	}
	
	private static JSONObject loadXMLFromString(String xml) throws Exception {
		
		/*JSONObjectBuilderFactory factory = JSONObjectBuilderFactory.newInstance();
		JSONObjectBuilder builder = factory.newJSONObjectBuilder();
		InputSource is = new InputSource(new StringReader(xml));
		return builder.parse(is);*/
		return JSONFactoryUtil.createJSONObject(xml);
	}
	
	public HashMap<String, String> getTendenza(){
		
		HashMap<String, String> tendenzaMap = new HashMap<String, String>();
		
		int i = 3;
		
		try {
			
			String xmlString = BollettinoLocalServiceUtil.findByTipo("tendenza").getJson();
			
			JSONObject doc = loadXMLFromString(xmlString);
			//XPath xPath =  XPathFactory.newInstance().newXPath();	
			//String previsioneTendenza = (String) xPath.compile("bollettino/testo").evaluate(doc, XPathConstants.STRING);
			String previsioneTendenza = doc.getJSONObject("bollettino").getString("testo");
			
			tendenzaMap.put("previsione", previsioneTendenza);
			
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_YEAR, i);
			tendenzaMap.put("1", (new SimpleDateFormat("EEEE dd MMM", Locale.ITALY).format(cal.getTime())));
			cal.add(Calendar.DAY_OF_YEAR, 1);
			tendenzaMap.put("2", (new SimpleDateFormat("EEEE dd MMM", Locale.ITALY).format(cal.getTime())));
			cal.add(Calendar.DAY_OF_YEAR, 1);
			tendenzaMap.put("3", (new SimpleDateFormat("EEEE dd MMM", Locale.ITALY).format(cal.getTime())));
			cal.add(Calendar.DAY_OF_YEAR, 1);
			tendenzaMap.put("4", (new SimpleDateFormat("EEEE dd MMM", Locale.ITALY).format(cal.getTime())));

			List<Img> list = ImgLocalServiceUtil.getByDayProvincia("Tendenza","ND");
			for(Img img:list){
				tendenzaMap.put(img.getDaypart(), img.getData());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block;
			_log.error(e);
		}
		
		return tendenzaMap;
	}
	
	public String getEmissione(){
		String value = "Emissione di ";
		value += new SimpleDateFormat("EEEE d MMMM y",Locale.ITALY).format(Calendar.getInstance().getTime());
		
		return value;
	}


	//-----------Getters-Setters------------------
	public HashMap<String, Giorno> getPrevisioni() {
		return previsioni;
	}

	public HashMap<String,String> getPrevisioniRegione() {
		return previsioniRegione;
	}

	public HashMap<String,String> getPrevisioniProvincia() {
		return previsioniProvincia;
	}

	public HashMap<String,String> getNowcastMap() {
		return nowcastMap;
	}
	
	
}
