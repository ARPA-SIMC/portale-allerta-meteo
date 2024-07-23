package it.eng.previsioni;


import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerEntry;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.TimeUnit;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.StreamUtil;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import it.eng.allerta.configuration.schedulers.AllertaBaseSchedulersConfiguration;
import it.eng.allerta.utils.AllertaTracker;
import it.eng.previsioni.meteo.exception.NoSuchImgException;
import it.eng.previsioni.meteo.model.Bollettino;
import it.eng.previsioni.meteo.model.Img;
//import it.eng.previsioni.meteo.service.BollettinoLocalServiceUtil;
//import it.eng.previsioni.meteo.service.ImgLocalServiceUtil;
import it.eng.previsioni.meteo.service.BollettinoLocalService;
import it.eng.previsioni.meteo.service.ImgLocalService;

@Component(
		  immediate = false, 			  
		  service = MessageListener.class
		)
public class BollettinoScheduler extends BaseMessageListener {

	private Log logger = LogFactoryUtil.getLog(BollettinoScheduler.class);

	/*private static final String bollettinoURL  = "https://www.arpae.it/smr/external/bollettino/bollettino_previ_provinciali.php?t=xml";
	private static final String bollettinoJSON  = "https://www.arpae.it/smr/external/bollettino/?t=json";
	private static final String imageURL  = "https://www.arpae.it/sim/datiiningresso/Bollettino/";
	private static final String nowcastURL ="https://www.arpae.it/sim/";
	private static final String tendenzaURL ="https://www.arpae.it/sim/datiiningresso/bollettino/tendenza.xml";
	*/
	//private static final String nowcastURL ="https://www.arpae.it/sim/";
	private static final String nowcastURL = "https://apps.arpae.it/REST/meteo_radar_nowcasting?sort=-data_validita&max_results=1";
	
	private static final String globalUrl = "https://apps.arpae.it/REST/meteo_bollettini/?sort=-_id&max_results=1";
	//private final String tendenza3g = "https://www.arpae.it/smr/datiiningresso/bollettino/tendenza3g.txt";

	@Reference(cardinality=ReferenceCardinality.MANDATORY)
	BollettinoLocalService bollettinoLocalService;
	@Reference(cardinality=ReferenceCardinality.MANDATORY)
	ImgLocalService imgLocalService;

	static final List<String> giorni;
	static {
		giorni = new ArrayList<String>();
		giorni.add("oggi");
		giorni.add("domani");
		giorni.add("dopodomani");
		giorni.add("quartogiorno");
	}
	private static final List<String> province;
	static {
		province = new ArrayList<String>();
		province.add("PC");
		province.add("PR");
		province.add("RE");
		province.add("MO");
		province.add("BO");
		province.add("FE");
		province.add("FC");
		province.add("RN");
		province.add("RA");
	}
	private static final List<String> parti ;
	static {
		parti = new ArrayList<String>();
		parti.add("mattina");
		parti.add("pomeriggio");
		parti.add("sera_notte");
	}

	private static final List<String> names;
	static {
		names = new ArrayList<String>();
		names.add("timestamp");
		names.add("emissione");
		names.add("validita");
	}

	public static final Map<String, String> nowcastMap;
	static {
		nowcastMap = new HashMap<String,String>();
		//nowcastMap.put("immagineRadar","datiiningresso/Immagini/Radar/nowcast.png");
		nowcastMap.put("Lretevie","nowcast_layer_rete_vie.png");
		nowcastMap.put("Lamministrativi","nowcast_layer_amministrativi.png");
		nowcastMap.put("Lidro","nowcast_layer_idro.png");
	}

	private static final List<String> tendenzaImgList;
	static {
		tendenzaImgList = new ArrayList<String>();
		/*tendenzaImgList.add("tend_meteo_1");
		tendenzaImgList.add("tend_meteo_2");
		tendenzaImgList.add("tend_meteo_3");
		tendenzaImgList.add("tend_meteo_4");
		tendenzaImgList.add("tend_temp_1");
		tendenzaImgList.add("tend_temp_2");
		tendenzaImgList.add("tend_temp_3");
		tendenzaImgList.add("tend_temp_4");*/
		tendenzaImgList.add("meteo");
		tendenzaImgList.add("temp");
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		// TODO Auto-generated method stub
		logger.warn("Inizio scheduler");
		JSONObject d = getXml();
		logger.warn("Passo images");
		getImages(d);
		logger.warn("Passo nowcasting");
		getNowcastingImg();
		logger.warn("Passo tendenza");
		getTendenzaImg(d);
		logger.warn("Fine scheduler");

	}
	
	private byte[] fromStreamtoByteArray(InputStream inputStream) throws IOException {
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		StreamUtil.transfer(inputStream, baos);
		
		return baos.toByteArray();
	}

	private JSONObject getXml(){
		Bollettino bollettino = null;
		InputStream input = null;
		try {
			/*input = getInputStreaWithTimeout(bollettinoURL);
			String content = new String(fromStreamtoByteArray(input), "utf-8"); */
			//input = getInputStreaWithTimeout(bollettinoJSON);
			input = getInputStreaWithTimeout(globalUrl);
			String json = new String(fromStreamtoByteArray(input),"utf-8");
			bollettino = getBollettino("completo");
			bollettino.setTimestamp(Calendar.getInstance().getTimeInMillis());
			bollettino.setXml_content("");
			
			JSONArray ja = JSONFactoryUtil.createJSONObject(json).getJSONArray("_items");
			bollettino.setJson(ja.getJSONObject(0).toJSONString());
			bollettino.setValidita(ja.getJSONObject(0).getJSONObject("oggi").getJSONObject("bollettino").getString("validita"));
			bollettino.setEmissione(ja.getJSONObject(0).getJSONObject("oggi").getJSONObject("bollettino").getString("emissione"));
			bollettinoLocalService.updateBollettino(bollettino);
			return ja.getJSONObject(0);
		}
		catch (NullPointerException e) {
			logger.error(e);
		}
		catch (Exception e) {
			logger.error("Pevisioni_Meteo [ERROR]: Can't save XML: "+e);
		}
		return null;
		//x la tendenza a 3 giorni

		/*
		URL url;
		InputStream input = null;
		try {
			url = new URL(tendenza3g);
			input = url.openStream();
			//			String content = IOUtils.toString(input, "utf-8");
			Bollettino tendenzaTesto3g = getBollettino("tendenza3g");
			Date date = new Date();
			tendenzaTesto3g.setTimestamp(date.getTime());
			tendenzaTesto3g.setXml_content(URLDecoder.decode(IOUtils.toString(input, "utf-8"), "utf-8"));
			BollettinoLocalServiceUtil.updateBollettino(tendenzaTesto3g);

		} catch (IOException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/

	}

	public static Document loadXMLFromString(String xml) throws Exception
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(xml));
		return builder.parse(is);
	}

	private void getImages(JSONObject d){
		InputStream stream = null;
		Calendar cal = Calendar.getInstance(Locale.ITALY);
		try{
			for(String giorno:giorni){
				for(String parte:parti){
					//stream = getInputStreaWithTimeout(imageURL+giorno+"_"+parte+".png");
					Img img = getImg(parte, giorno, "ND");

					img.setDay(giorno);
					img.setDaypart(parte);
					img.setProvincia("ND");
					img.setInserted(cal.getTime());
					//img.setData(Base64.encode(fromStreamtoByteArray(stream)));
					img.setData(d.getJSONObject(giorno).getJSONObject("bollettino").getJSONObject("regionale").getJSONObject("immagini").getString(parte));
					imgLocalService.updateImg(img);

					for(String provincia:province){
						//stream = getInputStreaWithTimeout(imageURL+provincia+"_"+giorno+"_"+parte+".png");
						img = getImg(parte, giorno, provincia);
						img.setDay(giorno);
						img.setDaypart(parte);
						img.setProvincia(provincia);
						img.setInserted(cal.getTime());
						//img.setData(Base64.encode(fromStreamtoByteArray(stream)));
						img.setData(d.getJSONObject(giorno).getJSONObject("bollettino").getJSONObject("provinciale").getJSONObject(provincia).getJSONObject("immagini").getString(parte));
						imgLocalService.updateImg(img);
					}
				}
			}
			//logger.info("Images was saved successfully");
		}catch(Exception e){
			logger.error(e);
		}finally{
			if(stream!=null){
				try {
					stream.close();
				} catch (IOException e) {
					logger.error("Pevisioni_Meteo [ERROR]: Cannot close URL connection stream. Could cause memory leaks. Cause: "+e);
				}
			}
		}
	}

	private Img getImg(String parte, String giorno, String provincia) throws SystemException {
		Img img = null;
		try {
			img = imgLocalService.getByPartDayProvincia(parte, giorno, provincia);
		}catch (NoSuchImgException e) {
			img = imgLocalService.createImg(counterLocalService.increment());
			logger.error("Created image");
		}
		return img;
	}

	private Bollettino getBollettino(String type){
		Bollettino bollettino = null;
		bollettino = bollettinoLocalService.findByTipo(type);
		if (bollettino ==null){
			try {
				bollettino = bollettinoLocalService.createBollettino(counterLocalService.increment());
				bollettino.setTipo(type);
			} catch (SystemException e) {
				logger.error("Errore creazione nuova entry in previsione meteo "+e);
			}
		}
		return bollettino;
	}

	private void getNowcastingImg(){
		InputStream stream = null;
		try{
			Img img = getImg("immagineRadar","Nowcasting","ND");
			stream = getInputStreaWithTimeout(nowcastURL);
			String json = new String(fromStreamtoByteArray(stream),"utf-8");
			String imageData = JSONFactoryUtil.createJSONObject(json).getJSONArray("_items").getJSONObject(0).getJSONObject("mappa").getString("image_data");
			img.setProvincia("ND");
			img.setDay("Nowcasting");
			img.setDaypart("immagineRadar");
			img.setData(imageData);
			Date d = new Date(Instant.parse(JSONFactoryUtil.createJSONObject(json).getJSONArray("_items").getJSONObject(0).getString("data_validita")).getEpochSecond()*1000);
			img.setInserted(d);
			imgLocalService.updateImg(img);
			stream.close();
			
			/*for (Map.Entry<String, String> entry : nowcastMap.entrySet()){

				img = getImg(entry.getKey(),"Nowcasting","ND");
				//				url = new URL(nowcastURL+entry.getValue());
				//				stream = url.openStream();
				stream = new FileInputStream(getClass().getClassLoader().getResource("/images/"+entry.getValue()).getPath());
				//stream = getInputStreaWithTimeout(nowcastURL+entry.getValue());
				img.setProvincia("ND");
				img.setDay("Nowcasting");
				img.setDaypart(entry.getKey());
				img.setData(Base64.encode(fromStreamtoByteArray(stream)));
				imgLocalService.updateImg(img);
				stream.close();
			}*/
		}
		catch (Exception e) {
			logger.error("Pevisioni_Meteo [ERROR]: Can't save Nowcasting images: "+e.getCause());
		}
		finally {
			try {
				stream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error(e);
			}
		}
	}

	private void getTendenzaImg(JSONObject o){
		Bollettino bollettino = getBollettino("tendenza");
		//InputStream input = null;
		//InputStream stream = null;
		try {
			/*input = getInputStreaWithTimeout(tendenzaURL);
			String content = new String(fromStreamtoByteArray(input), "utf-8"); 
			input.close();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(content));
			Document doc = builder.parse(is);
			XPath xPath =  XPathFactory.newInstance().newXPath();*/
			/*bollettino.setTimestamp(Long.parseLong((String) xPath.compile("bollettino//@timestamp").evaluate(doc, XPathConstants.STRING)));
			bollettino.setEmissione((String) xPath.compile("bollettino//@emissione").evaluate(doc, XPathConstants.STRING));
			bollettino.setValidita((String) xPath.compile("bollettino//@validita").evaluate(doc, XPathConstants.STRING));
			*/
			bollettino.setTimestamp(o.getJSONObject("tendenza").getJSONObject("bollettino").getLong("timestamp"));
			bollettino.setEmissione(o.getJSONObject("tendenza").getJSONObject("bollettino").getString("emissione"));
			bollettino.setValidita(o.getJSONObject("tendenza").getJSONObject("bollettino").getString("validita"));
			
			bollettino.setJson(o.getJSONObject("tendenza").toJSONString());
			bollettino.setXml_content("");
			bollettinoLocalService.updateBollettino(bollettino);

			for (int k=1; k<=4; k++){
				
				for (String ss : tendenzaImgList) {

					String entry = "tend_"+ss+"_"+k;
					Img img = getImg(entry,"Tendenza","ND");
	
					//stream = getInputStreaWithTimeout(imageURL+entry+".png");
					img.setProvincia("ND");
					img.setDay("Tendenza");
					img.setDaypart(entry);
					img.setData(o.getJSONObject("tendenza").getJSONObject("bollettino").getJSONObject("giorno"+k).getJSONObject("immagini").getString(ss));
					imgLocalService.updateImg(img);
				}
			}
		} 		
		catch (Exception e) {
			logger.error("Pevisioni_Meteo [ERROR]: Can't save Tendenza images: "+e);
		}
		finally {

		}
	}

	public InputStream getInputStreaWithTimeout(String value){
		HttpURLConnection huc = null;
		try {
			URL url = new URL(value);
			huc = (HttpURLConnection) url.openConnection();
			HttpURLConnection.setFollowRedirects(false);
			huc.setConnectTimeout(15 * 1000);
			huc.setReadTimeout(30 * 1000);
			huc.setRequestMethod("GET");
			huc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.1.2) Gecko/20090729 Firefox/3.5.2 (.NET CLR 3.5.30729)");
			huc.connect();
			return huc.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("IoException.. metodo per gestire l'inputstream con timeout \n"+e);
		}
		return null;

	}
	
	@Reference
	private CounterLocalService counterLocalService;

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		
		System.out.println("Activate BollettinoScheduler");
		logger.debug("Activate BollettinoScheduler");
		
		Class<?> clazz = getClass();

		String className = clazz.getName();
		
		AllertaBaseSchedulersConfiguration configuration = AllertaTracker.getAllertaSchedulersConfiguration();
		
		System.out.println("scheduling at " + configuration.schedulerBollettinoMinutes());

		if (configuration.schedulerBollettinoMinutes()<1) return;
		
		Trigger trigger = 
				_triggerFactory.createTrigger(className, className, null, null, configuration.schedulerBollettinoMinutes(), TimeUnit.MINUTE);

		SchedulerEntry schedulerEntry = new SchedulerEntryImpl(
			className, trigger);

		baseScheduler.register(
			this, schedulerEntry, DestinationNames.SCHEDULER_DISPATCH);
		
	}

	@Deactivate
	protected void deactivate() {
		baseScheduler.unregister(this);
	}
	
	@Reference
	private SchedulerEngineHelper baseScheduler;
	
	@Reference
	private TriggerFactory _triggerFactory;
}