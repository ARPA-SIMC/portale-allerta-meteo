package it.eng.radarMeteo.cron;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
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
import it.eng.radarMeteo.exception.NoSuchImgException;
import it.eng.radarMeteo.model.Img;
import it.eng.radarMeteo.model.Json;
import it.eng.radarMeteo.service.ImgLocalService;
//import it.eng.radarMeteo.service.ImgLocalServiceUtil;
import it.eng.radarMeteo.service.JsonLocalService;
//import it.eng.radarMeteo.service.JsonLocalServiceUtil;

@Component(
  immediate = true, 			  
  service = MessageListener.class
)
public class RTImageScheduler extends BaseMessageListener {

	private Log _log = LogFactoryUtil.getLog(RTImageScheduler.class);

	public static final String JSONURL = "https://simc.arpae.it/webapp/radar.json/";
	public static final String IMAGEURL = "https://simc.arpae.it/webapp/getradarimage.php?f=";
	public static final int IMG_UDPATE_TIME = 5;

	public static final String JSONURL5 = "https://www.arpae.it/sim/external/bollettino/radar_wp7.php?callback=";
	public static final String IMAGEURL5 = "https://www.arpae.it/sim/external/bollettino/mappa_radar_wp7.php?f=";

	@Override
	protected void doReceive(Message message) throws Exception {
		
		_log.info("RTImageScheduler - START");
		
		getAllImages();
		
		_log.info("RTImageScheduler - END");
	}


	//----This method downloads all images that specified in JSON---//
	public void getAllImages(){
		//		Long id = null;
		String defaultBounds = "7,42,15,47";
		defaultBounds = "8.5,43.4,13.2058,46.001";
		try {
			String jsonString = getJsonFromUrl();

			String index;
			//			logger.info(jsonString);
			if(!jsonString.equals("")){
				JSONArray jsonarray = JSONFactoryUtil.createJSONArray(jsonString);
				for (int i = 0; i < jsonarray.length(); i++) {
					JSONObject jsonobject = jsonarray.getJSONObject(i);
					index = jsonobject.getString("i");
					InputStream stream =  getInputStreaWithTimeout(IMAGEURL5+index);
					Img img = getImg(jsonobject.getLong("ts"));
					img.setTimestamp(Long.parseLong(index.substring(5,index.length()-4)));
					img.setCoord(defaultBounds);
					
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					StreamUtil.transfer(stream, baos);
					
					img.setData(new String(Base64.encode(baos.toByteArray())));
					imgLocalService.updateImg(img);
				}
			}else{
				_log	.debug("RT_portlet [ERROR]: JSON5 is null.");
			}

			//this serve for delete the imagine non need
			List<Img> deleteList = imgLocalService.getImgs(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			//			logger.info("dimensione lista da eliminare: "+(deleteList.size()-250));
			for (int xy=250; xy < deleteList.size(); xy++){
				imgLocalService.deleteImg(deleteList.get(xy));
			}


		} catch (JSONException e) {
			_log.error("RT_portlet [ERROR]: JSON ERROR ");
			_log.error(e);

		} catch (IOException e) {
			_log.error("RT_portlet [ERROR]: Something wrong while downloading image: ");
			_log.error(e);

		} catch (SystemException e) {
			_log.error("RT_portlet [ERROR] SystemException: Can't save/update Img in db:");
			_log.error(e);
		}
		catch (Exception e) {
			_log.error("RT_portlet [ERROR] exception : Something went wrong: ");
			_log.error(e);
		}
	}

	public String getJsonFromUrl(){
		
		String jsonString = null;
		//InputStream in = null;
		Json json = null;
		
		try{
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			StreamUtil.transfer(getInputStreaWithTimeout(JSONURL5), baos);
			
			jsonString = new String(baos.toByteArray());
			json=getJson().get(1);
			//Json jsonFromUrl = jsonFromUrl(JSONURL5, jsonString, 1);
			if(json == null){
				
				baos = new ByteArrayOutputStream();
				StreamUtil.transfer( getInputStreaWithTimeout(JSONURL), baos);
					
				jsonString = new String(baos.toByteArray());; //(IOUtils.toString(new InputStreamReader()));//jsonFromUrl(JSONURL, jsonString, 0);
				json =  getJson().get(0);
				json.setType("JSON");
				json.setInserted(Calendar.getInstance().getTimeInMillis());
				json.setData(jsonString);
				
			} else{
				
				json =  getJson().get(1);
				json.setType("JSON5");
				json.setInserted(Calendar.getInstance().getTimeInMillis());
				if(jsonString.length()>0){
					jsonString =jsonString.substring(1, jsonString.length()-1);
					json.setData(jsonString);
				}
			}
		}
		catch(IOException e){
			
			_log.error("Errore nel metodo json from url "+e);
		}

		try {
			
			jsonLocalService.updateJson(json);
		} catch (SystemException e) {
			
			_log.error("Errore aggiornamento database mappe radar",e);
		}
		return jsonString;
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
			_log.error("IoException.. metodo per gestire l'inputstream con timeout \n"+e);
		}
		
		return null;
	}

	//-------This method saves only the last recent image that was added to JSON
	public void getLastImage() {
		
		Long id = null;
		Long comparable =   new Long(0);
		InputStream stream = null;
		
		try {
			
			String jsonString = getJsonFromUrl();
			
			if(!jsonString.equals("")){
				
				JSONObject jObj = JSONFactoryUtil.createJSONObject(jsonString);	
				JSONObject coords = (JSONObject) jObj.getJSONObject("obs").getJSONObject("meta").getJSONObject("coords");
				JSONObject jImgs = jObj.getJSONObject("obs").getJSONObject("images");
				
				String bounds  =  coords.getString("lon_min")+","+coords.getString("lat_min")+","+coords.getString("lon_max")+","+coords.getString("lat_max");
				
				Integer iteratorCounter = 0;
				
				for(Iterator<String> iterator = jImgs.keys(); iterator.hasNext();) {
				
					String iterKey = iterator.next();
					iteratorCounter++;
					Long currentKey = Long.parseLong(iterKey); 
					if(comparable.compareTo(currentKey)<0){
						comparable = currentKey;
						id = jImgs.getJSONObject(iterKey).getLong("index");
					}
				}
				
				stream = getInputStreaWithTimeout(IMAGEURL+id);
				Img img = getLastImg(comparable, iteratorCounter);
				img.setTimestamp(id);
				img.setCoord(bounds);
				
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				StreamUtil.transfer(stream, baos);
				
				img.setData(new String(baos.toByteArray()));
				imgLocalService.updateImg(img);

			} else {
				_log.debug("RT_portlet [ERROR]: JSON is null.");
			}

		} catch (JSONException e) {
			
			_log.error("RT_portlet [ERROR]: JSON ERROR "+e);

		} catch (IOException e) {
			
			_log.error("RT_portlet [ERROR]: Something gone wrong while downloading image: "+e);

		} catch (SystemException e) {
			
			_log.error("RT_portlet [ERROR]: Can't save/update Img in db:"+e);
			
		} catch (Exception e) {
			
			_log.error("RT_portlet [ERROR]: Something went wrong: "+e);
		}
		finally {
			
			try {
				stream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				_log.error(e);
			}
		}
	}

	private Img getImg(Long id){
		
		Img img = null;
		
		try {
			
			img = imgLocalService.getImg(id);
			
		} catch (NoSuchImgException e) {
			
			img = imgLocalService.createImg(id);
		} catch (SystemException e) {
			
			_log.error("RT_portlet: Error while creating Image");
		} catch (PortalException e) {
			
			// TODO Auto-generated catch block
			_log.error("PortalException " +e);
		}
		
		return img;
	}

	private Img getLastImg(Long id, Integer iteratorCounter) {
		
		Img img = null;
		
		try {
		
			List<Img> imgList = imgLocalService.getImgs(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			
			if(imgList.size()!=0 || imgList.size() == iteratorCounter ) {
				
				img = imgList.get(0);
				
			} else{
				
				img = imgLocalService.createImg(id);
				_log.info("RT_portlet Image was created");
			}
			
		} catch (Exception e) {
			//Do nothing
			_log.error("Metodo getlastImages di datiIntempoReale "+ e);
		}
		return img;
	}

	private List<Json> getJson(){
		
		List<Json> json= new ArrayList<Json>();
		
		try {
			List<Json> jsonList = jsonLocalService.getJsons(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if(jsonList.size()>=2){
				json = jsonList;
			}
			else{
				json.add(jsonLocalService.createJson(CounterLocalServiceUtil.increment()));
				json.add(jsonLocalService.createJson(CounterLocalServiceUtil.increment()));
			}

		} catch (Exception e) {
			_log.error("Errore nel recupero dei json dal db RT_PORTLET ");
			_log.error(e);
		}
		return json;
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		
		System.out.println("ACTIVATE RTImagesScheduler");
		
		_log.debug("ACTIVATE RTImagesScheduler");
		
		Class<?> clazz = getClass();

		String className = clazz.getName();
		
		AllertaBaseSchedulersConfiguration configuration = AllertaTracker.getAllertaSchedulersConfiguration();
		
		_log.info("RTImagesScheduler scheduling at " + configuration.schedulerRTImagesMinutes());

		Trigger trigger = _triggerFactory.createTrigger(className, className, null, null, configuration.schedulerRTImagesMinutes(), TimeUnit.MINUTE);

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
	private JsonLocalService jsonLocalService;
	
	@Reference
	private ImgLocalService imgLocalService;
	
	@Reference
	private TriggerFactory _triggerFactory;

	
}

