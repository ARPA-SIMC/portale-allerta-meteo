package it.eng.animaeteo.cron;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

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

import it.eng.allerta.configuration.schedulers.AllertaBaseSchedulersConfiguration;
import it.eng.allerta.utils.AllertaTracker;
import it.eng.animaeteo.model.AnimeteoImg;
import it.eng.animaeteo.model.AnimeteoSmallImg;
import it.eng.animaeteo.service.AnimeteoImgLocalService;
//import it.eng.animaeteo.service.AnimeteoImgLocalServiceUtil;
//import it.eng.animaeteo.service.AnimeteoSmallImgLocalServiceUtil;
import it.eng.animaeteo.service.AnimeteoSmallImgLocalService;


@Component(
  immediate = false, 			  
  service = MessageListener.class
)
public class AnimeteoScheduler extends BaseMessageListener {
	
	private Log _log = LogFactoryUtil.getLog(AnimeteoScheduler.class);

	private static final String baseUrl = "https://apps.arpae.it/REST/";
	private static final String baseUrl2 = "https://apps.arpae.it/REST";
	@Reference(cardinality=ReferenceCardinality.MANDATORY)
	AnimeteoImgLocalService animeteoImgLocalService;
	@Reference(cardinality=ReferenceCardinality.MANDATORY)
	AnimeteoSmallImgLocalService animeteoSmallImgLocalService;
	
	JSONObject datiPreci;
	JSONObject datiNuv;
	JSONObject datiWind;
	
	private static final List<String> variables;
	static {
		variables = new ArrayList<String>();
		variables.add("preci");
		variables.add("nuv");
		variables.add("wind");
	}
	
	private static final List<String> url;
	static {
		url = new ArrayList<String>();
		url.add("meteo_mappe_previsione_nord_italia_precipitazione");
		url.add("meteo_mappe_previsione_nord_italia_copertura_nuvolosa");
		url.add("meteo_mappe_previsione_nord_italia_vento");
	}
	
	@Override
	protected void doReceive(Message message) throws Exception {
		
	
		_log.info("Animeteo Scheduler START");
		
		try {
			datiPreci = JSONFactoryUtil.createJSONObject(new String( fromStreamtoByteArray(getInputStreaWithTimeout(baseUrl+url.get(0)))));
		} catch (Exception e) {
			_log.error(e);
		}
		
		try {
			datiNuv = JSONFactoryUtil.createJSONObject(new String( fromStreamtoByteArray(getInputStreaWithTimeout(baseUrl+url.get(1)))));
		} catch (Exception e) {
			_log.error(e);
		}
		
		try {
			datiWind = JSONFactoryUtil.createJSONObject(new String( fromStreamtoByteArray(getInputStreaWithTimeout(baseUrl+url.get(2)))));
		} catch (Exception e) {
			_log.error(e);
		}
		
		//getImagesHome();
		
		//getImages();
		
		getBigImages();
		
		_log.info("Animeteo Scheduler END");
	}


	private byte[] fromStreamtoByteArray(InputStream inputStream) throws IOException {
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		StreamUtil.transfer(inputStream, baos);
		
		return baos.toByteArray();
	}

	

	public ArrayList<String> createBigImageList(JSONObject param) {
		
		JSONArray mappe = param.getJSONArray("_items").getJSONObject(0).getJSONArray("mappe");
		
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0; i<24; i++){
			list.add(mappe.getJSONObject(i).getJSONObject("mappa").getJSONObject("file").getString("file"));
		}
		return list;	
	}

public InputStream getInputStreaWithTimeout(String value){
		
		HttpURLConnection huc = null;
		
		try {
			URL url = new URL(value);
			huc = (HttpURLConnection) url.openConnection();
			HttpURLConnection.setFollowRedirects(false);
			huc.setConnectTimeout(15 * 1000);
			huc.setReadTimeout(15 * 1000);
			huc.setRequestMethod("GET");
			huc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.1.2) Gecko/20090729 Firefox/3.5.2 (.NET CLR 3.5.30729)");
			huc.connect();
			
			return huc.getInputStream();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			_log.error("IoException.. metodo per gestire l'inputstream con timeout \n"+e);
		}
		
		return null;
	}
	
	private void getBigImages() throws IOException {
		
		_log.info("Animeteo Scheduler BigImages - START");
		
		Calendar cal = Calendar.getInstance(Locale.ITALY);
		InputStream stream = null;
		AnimeteoImg animeteoImg = null;
		AnimeteoSmallImg smallImg = null;
		
		List<JSONObject> l = new ArrayList<JSONObject>();
		l.add(datiPreci);
		l.add(datiNuv);
		l.add(datiWind);
		
		for(int i = 0; i < 3; i++){
			
			ArrayList<String> urlList = createBigImageList(l.get(i));
			
			for(int j=1; j < 25; j++){
				
				try {
					
					animeteoImg = animeteoImgLocalService.getAnimeteoImg(i*24+j);
					//					animeteoImg = animeteoImgLocalService.createAnimeteoImg(i*24+j);
					//URL url = new URL(baseUrl2+urlList.get(j-1));
					//stream = url.openStream();
					stream = getInputStreaWithTimeout(baseUrl2+urlList.get(j-1));
					animeteoImg.setName(variables.get(i)+"_"+String.format("%02d", j)+".png");
					animeteoImg.setType(variables.get(i));
					String s = l.get(i).getJSONArray("_items").getJSONObject(0).getJSONArray("mappe").getJSONObject(j-1).getString("data_validita");
					Instant in = Instant.parse(s);
					animeteoImg.setInserted(new Date(in.toEpochMilli()));
					animeteoImg.setData(Base64.encode(fromStreamtoByteArray(stream)));
					animeteoImgLocalService.updateAnimeteoImg(animeteoImg);
					
					/*smallImg = animeteoSmallImgLocalService.getAnimeteoSmallImg(i*24+j);
					smallImg.setName(variables.get(i)+"_"+String.format("%02d", j)+"s.png");
					smallImg.setType(variables.get(i));
					smallImg.setInserted(cal.getTime());
					smallImg.setData(Base64.encode(fromStreamtoByteArray(stream)));
					animeteoSmallImgLocalService.updateAnimeteoSmallImg(smallImg);
					*/
					
					
					stream.close();

				}catch (Exception e) {
					e.printStackTrace();
					return;
				}
				finally{
					if(stream!=null){
						stream.close();
					}
				}
			}
		}
		
		_log.info("Animeteo Scheduler BigImages - END");

	}
	
	public ArrayList<String> createImageList(String param){
		ArrayList<String> list = new ArrayList<String>();
		for(int i=1; i<25; i++){
			//list.add(new String(arpaUrl+param+"_"+String.format("%02d",i)+"s.png"));
		}
		return list;	
	}
	
	
	

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		
		Class<?> clazz = getClass();

		String className = clazz.getName();
		
		AllertaBaseSchedulersConfiguration configuration = AllertaTracker.getAllertaSchedulersConfiguration();
		
		_log.info("AnimeteoScheduler scheduling at " + configuration.schedulerAnimeteoMinutes());

		if (configuration.schedulerAnimeteoMinutes()<1) return;
		
		Trigger trigger = _triggerFactory.createTrigger(className, className, null, null, configuration.schedulerAnimeteoMinutes(), TimeUnit.MINUTE);

		SchedulerEntry schedulerEntry = new SchedulerEntryImpl(className, trigger);

		baseScheduler.register(this, schedulerEntry, DestinationNames.SCHEDULER_DISPATCH);
		
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