package it.eng.animazione.cron;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import com.liferay.portal.kernel.exception.PortalException;
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

import it.eng.allerta.configuration.schedulers.AllertaBaseSchedulersConfiguration;
import it.eng.allerta.utils.AllertaTracker;
import it.eng.animazione.image.exception.NoSuchPioggiaCumulativaException;
import it.eng.animazione.image.model.PioggiaCumulativa;
import it.eng.animazione.image.service.ParametroLocalService;
import it.eng.animazione.image.service.PioggiaCumulativaLocalService;
//import it.eng.animazione.image.service.ParametroLocalServiceUtil;
//import it.eng.animazione.image.service.PioggiaCumulativaLocalServiceUtil;


@Component(
		immediate = false,
		service = MessageListener.class
		)
public class CumulativeScheduler extends BaseMessageListener{
	
	private Log _log = LogFactoryUtil.getLog(CumulativeScheduler.class);

	public final static String jsonURL = "https://simc.arpae.it/webapp/allerte/list.json.php";
	public final static String imgURL = "https://simc.arpae.it/webapp/allerte/get.image.php?";

	@Reference(cardinality=ReferenceCardinality.MANDATORY)
	PioggiaCumulativaLocalService pioggiaCumulativaLocalService;
	@Reference(cardinality=ReferenceCardinality.MANDATORY)
	ParametroLocalService parametroLocalService;
	
	@Override
	protected void doReceive(Message message) throws Exception {
		
		_log.info("CumulativeScheduler - START");
		
		getCumulativeImages();
		
		_log.info("CumulativeScheduler - END");
	}

	private byte[] fromStreamtoByteArray(InputStream inputStream) throws IOException {
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		StreamUtil.transfer(inputStream, baos);
		
		return baos.toByteArray();
	}
	
	private void getCumulativeImages(){
		
		int countImg = 0;
		
		String authString = null;
		
		try {
			
			authString = parametroLocalService.getParametro("param1").getValue() + ":" + parametroLocalService.getParametro("param2").getValue();
			
		} catch (PortalException | SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		String authStringEnc = new String(Base64.encode(authString.getBytes()));

		InputStream input = null;
		
		try{
			
			input= getInputStreaWithTimeout(jsonURL,authStringEnc);
			String jsonString = new String(fromStreamtoByteArray(input));
			
			input.close();
			JSONObject myObject = JSONFactoryUtil.createJSONObject(jsonString);
			JSONArray myArray = myObject.getJSONArray("48h");
			
			for (int i = 0; i < myArray.length(); i++) {
				
				countImg++;
				
				String image = myArray.getString(i);
				
				Calendar  calendar = parseTimestamps(image,"_048");
				
				input= getInputStreaWithTimeout(imgURL+"cu=48h&im="+image,authStringEnc);
				
				PioggiaCumulativa img = getPioggiaCumulativa(i+1);
				img.setNome(image);
				img.setInzioCumulazione(calendar.getTime());
				calendar.add(Calendar.HOUR_OF_DAY, 48);
				img.setFineCumulazione(calendar.getTime());
				img.setCumulazione("48h");
				img.setImgData(Base64.encode(fromStreamtoByteArray(input)));
				
				pioggiaCumulativaLocalService.updatePioggiaCumulativa(img);
			}

			myArray = myObject.getJSONArray("6h");	
			 	
			for (int i = 0; i < myArray.length(); i++) {
				
				countImg++;
				
				String image = myArray.getString(i);
				
				Calendar  calendar = parseTimestamps(image,"_006");
				input= getInputStreaWithTimeout(imgURL+"cu=6h&im="+image,authStringEnc);

				PioggiaCumulativa img = getPioggiaCumulativa(i+myArray.length()+1);
				img.setNome(image);
				img.setInzioCumulazione(calendar.getTime());
				calendar.add(Calendar.HOUR_OF_DAY, 6);
				img.setFineCumulazione(calendar.getTime());
				img.setCumulazione("6h");
				img.setImgData(Base64.encode(fromStreamtoByteArray(input)));
				
				pioggiaCumulativaLocalService.updatePioggiaCumulativa(img);
			}		
			
			
			myArray = myObject.getJSONArray("24h");
			
			if (myArray!=null)
				for (int i = 0; i < myArray.length(); i++) {
					
					countImg++;
					
					String image = myArray.getString(i);
					
					Calendar  calendar = parseTimestamps(image,"_024");
					
					input= getInputStreaWithTimeout(imgURL+"cu=24h&im="+image,authStringEnc);
					
					PioggiaCumulativa img = getPioggiaCumulativa(countImg);
					img.setNome(image);
					img.setInzioCumulazione(calendar.getTime());
					calendar.add(Calendar.HOUR_OF_DAY, 24);
					img.setFineCumulazione(calendar.getTime());
					img.setCumulazione("24h");
					img.setImgData(Base64.encode(fromStreamtoByteArray(input)));
					
					pioggiaCumulativaLocalService.updatePioggiaCumulativa(img);
				}
		}catch(Exception e){
			
			e.printStackTrace();
		}finally{
			
			try {
				
				input.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				_log.error(e);
			}
		}
	}


	private Calendar parseTimestamps(String timeString, String param){
		
		timeString = new String(timeString.substring(timeString.lastIndexOf("NULL_")+5, timeString.indexOf(param)));
		
		Integer anno =  Integer.parseInt(timeString.substring(0, 4));
		Integer mese = Integer.parseInt(timeString.substring(4, 6));
		Integer data = Integer.parseInt(timeString.substring(6, 8));
		Integer ora = Integer.parseInt(timeString.substring(8, 10));
		
		Calendar  cal = Calendar.getInstance();
		cal.set(anno, mese-1, data, ora, 0);
		
		return cal;
	}

	private PioggiaCumulativa  getPioggiaCumulativa(int id){
		
		PioggiaCumulativa img = null;
		
		try {
			
			img =pioggiaCumulativaLocalService.findByID(id);
			
		} catch (NoSuchPioggiaCumulativaException e) {
			
			img = pioggiaCumulativaLocalService.createPioggiaCumulativa(id);
			_log.info("PioggiaCumulativa was created");
			
		} catch (SystemException e) {
			
			_log.error("Error while creating PioggiaCumulativa");
		}
		
		return img;
	}
	
	public InputStream getInputStreaWithTimeout(String value, String authStringEnc){
		
		HttpURLConnection huc = null;
		
		try {
			
			URL url = new URL(value);
			huc = (HttpURLConnection) url.openConnection();
			HttpURLConnection.setFollowRedirects(false);
			
			huc.setConnectTimeout(15 * 1000);
			huc.setReadTimeout(30 * 1000);
			huc.setRequestMethod("GET");
			huc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.1.2) Gecko/20090729 Firefox/3.5.2 (.NET CLR 3.5.30729)");
			huc.setRequestProperty("Authorization", "Basic " + authStringEnc);
			huc.connect();
			
			return huc.getInputStream();
			
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			_log.error("IoException.. metodo per gestire l'inputstream con timeout \n"+e);
		}
		
		return null;
	}

	
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		
		Class<?> clazz = getClass();

		String className = clazz.getName();
		
		AllertaBaseSchedulersConfiguration configuration = AllertaTracker.getAllertaSchedulersConfiguration();
		
		_log.info("CumulativeScheduler scheduling at " + configuration.schedulerCumulativeMinutes());

		if (configuration.schedulerCumulativeMinutes()<1) return;
		
		Trigger trigger = _triggerFactory.createTrigger(className, className, null, null, configuration.schedulerCumulativeMinutes(), TimeUnit.MINUTE);

		SchedulerEntry schedulerEntry = new SchedulerEntryImpl(className, trigger);

		baseScheduler.register(this, schedulerEntry, DestinationNames.SCHEDULER_DISPATCH);
		
	}

	@Deactivate
	protected void deactivate() {
		baseScheduler.unregister(this);
	}
	

	@Reference
	private TriggerFactory _triggerFactory;

	@Reference
	private SchedulerEngineHelper baseScheduler;
	
	
	
}
