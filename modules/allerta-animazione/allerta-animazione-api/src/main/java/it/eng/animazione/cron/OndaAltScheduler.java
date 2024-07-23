package it.eng.animazione.cron;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
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
import com.liferay.portal.kernel.messaging.MessageListenerException;
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
import it.eng.animazione.image.model.altezzaOnda;
import it.eng.animazione.image.model.altezzaOndaAdriac;
import it.eng.animazione.image.model.altezzaOndaSwanita;
import it.eng.animazione.image.model.elevazione;
import it.eng.animazione.image.service.altezzaOndaAdriacLocalService;
import it.eng.animazione.image.service.altezzaOndaLocalService;
import it.eng.animazione.image.service.altezzaOndaSwanitaLocalService;
import it.eng.animazione.image.service.elevazioneLocalService;
//import it.eng.animazione.image.service.altezzaOndaLocalServiceUtil;

@Component(
	immediate = false,
	service = MessageListener.class
	)
public class OndaAltScheduler extends BaseMessageListener {
	
	private Log _log = LogFactoryUtil.getLog(OndaAltScheduler.class);

	public final static String swanURL = "https://apps.arpae.it/REST/meteo_mappe_previsione_altezza_onda_swanemr?sort=-_id&max_results=1";
	public final static String swanitaURL = "https://apps.arpae.it/REST/meteo_mappe_previsione_altezza_onda_swanita?sort=-_id&max_results=1";
	public final static String adriacURL = "https://apps.arpae.it/REST/meteo_mappe_mare_previsione_livello_mare_adriac?sort=-_id&max_results=1";

	//public final static String jsonURL = "https://www.arpae.it/sim/external/bollettino/mappe_mare.php";
	//public final static String imgURLadriaroms = "https://www.arpae.it/sim/datiiningresso/Immagini/adriaroms/";
	//public final static String imgURLswanemr = "https://www.arpae.it/sim/datiiningresso/Immagini/SWANEMR/";
	
	public final static String downloadUrl = "https://apps.arpae.it/REST";

	@Reference(cardinality=ReferenceCardinality.MANDATORY)
	altezzaOndaLocalService altezzaService;
	
	@Reference(cardinality=ReferenceCardinality.MANDATORY)
	altezzaOndaAdriacLocalService altezzaAdriacService;
	
	@Reference(cardinality=ReferenceCardinality.MANDATORY)
	altezzaOndaSwanitaLocalService altezzaSwanitaService;
	
	@Reference(cardinality=ReferenceCardinality.MANDATORY)
	elevazioneLocalService elevazioneService;
	
	@Override
	protected void doReceive(Message message) throws Exception {
		
		_log.info("OndaAlt Scheduler - START");

		getAltezzaOndaImages();
		getAltezzaOndaSwanitaImages();
		getAltezzaOndaAdriacImages();
		
		_log.info("OndaAlt Scheduler - END");

	}
	
	private byte[] fromStreamtoByteArray(InputStream inputStream) throws IOException {
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		StreamUtil.transfer(inputStream, baos);
		
		return baos.toByteArray();
	}

	private void getAltezzaOndaImages() {

		InputStream input = null;
		try{
			input= getInputStreaWithTimeout(swanURL);
			String jsonString = new String(fromStreamtoByteArray(input));
			input.close();
			JSONObject myObject = JSONFactoryUtil.createJSONObject(jsonString);
			JSONArray SWANEMR = myObject.getJSONArray("_items").getJSONObject(0).getJSONArray("mappe");
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			for(int i=1;i<=SWANEMR.length();i++){
				//JSONObject element = SWANEMR.getJSONObject(String.format("%02d", i));
				JSONObject element = SWANEMR.getJSONObject(i-1);
				JSONObject im = element.getJSONObject("mappa");
				altezzaOnda field = altezzaService.fetchaltezzaOnda(i);
				if(field == null){
					field = altezzaService.createaltezzaOnda(i);
				}
				field.setIm(im.getJSONObject("file").getString("file"));
				String text = element.getString("data_validita");
				if (text!=null) {
					Instant ins = Instant.parse(text);
					field.setTs_UTC(ins.getEpochSecond()); 
					field.setText_LOC(sdf.format(new Date(ins.toEpochMilli())));
				} else {
					field.setText_LOC("");
					field.setTs_UTC(0);
				}
				
				input = getInputStreaWithTimeout(downloadUrl+field.getIm());
				field.setImgData(Base64.encode(fromStreamtoByteArray(input)));
				input.close();
				altezzaService.updatealtezzaOnda(field);
			}

		}
		catch(Exception e){
			_log.error(e);
		}
		finally{
			try {
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				_log.error(e);
			}
		}

	}
	
	private void getAltezzaOndaSwanitaImages() {

		InputStream input = null;
		try{
			input= getInputStreaWithTimeout(swanitaURL);
			String jsonString = new String(fromStreamtoByteArray(input));
			input.close();
			JSONObject myObject = JSONFactoryUtil.createJSONObject(jsonString);
			JSONArray SWANEMR = myObject.getJSONArray("_items").getJSONObject(0).getJSONArray("mappe");
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			for(int i=1;i<=SWANEMR.length();i++){
				//JSONObject element = SWANEMR.getJSONObject(String.format("%02d", i));
				JSONObject element = SWANEMR.getJSONObject(i-1);
				JSONObject im = element.getJSONObject("mappa");
				altezzaOndaSwanita field = altezzaSwanitaService.fetchaltezzaOndaSwanita(i);
				if(field == null){
					field = altezzaSwanitaService.createaltezzaOndaSwanita(i);
				}
				field.setIm(im.getJSONObject("file").getString("file"));
				String text = element.getString("data_validita");
				if (text!=null) {
					Instant ins = Instant.parse(text);
					field.setTs_UTC(ins.getEpochSecond()); 
					field.setText_LOC(sdf.format(new Date(ins.toEpochMilli())));
				} else {
					field.setText_LOC("");
					field.setTs_UTC(0);
				}
				
				input = getInputStreaWithTimeout(downloadUrl+field.getIm());
				field.setImgData(Base64.encode(fromStreamtoByteArray(input)));
				input.close();
				altezzaSwanitaService.updatealtezzaOndaSwanita(field);
			}

		}
		catch(Exception e){
			_log.error(e);
		}
		finally{
			try {
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				_log.error(e);
			}
		}

	}
	
	private void getAltezzaOndaAdriacImages() {

		InputStream input = null;
		try{
			input= getInputStreaWithTimeout(adriacURL);
			String jsonString = new String(fromStreamtoByteArray(input));
			input.close();
			JSONObject myObject = JSONFactoryUtil.createJSONObject(jsonString);
			JSONArray SWANEMR = myObject.getJSONArray("_items").getJSONObject(0).getJSONArray("mappe");
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			for(int i=1;i<=SWANEMR.length();i++){
				//JSONObject element = SWANEMR.getJSONObject(String.format("%02d", i));
				JSONObject element = SWANEMR.getJSONObject(i-1);
				JSONObject im = element.getJSONObject("mappa");
				altezzaOndaAdriac field = altezzaAdriacService.fetchaltezzaOndaAdriac(i);
				if(field == null){
					field = altezzaAdriacService.createaltezzaOndaAdriac(i);
				}
				field.setIm(im.getJSONObject("file").getString("file"));
				String text = element.getString("data_validita");
				if (text!=null) {
					Instant ins = Instant.parse(text);
					field.setTs_UTC(ins.getEpochSecond()); 
					field.setText_LOC(sdf.format(new Date(ins.toEpochMilli())));
				} else {
					field.setText_LOC("");
					field.setTs_UTC(0);
				}
				
				input = getInputStreaWithTimeout(downloadUrl+field.getIm());
				field.setImgData(Base64.encode(fromStreamtoByteArray(input)));
				input.close();
				altezzaAdriacService.updatealtezzaOndaAdriac(field);
			}

		}
		catch(Exception e){
			_log.error(e);
		}
		finally{
			try {
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				_log.error(e);
			}
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
		
		_log.info("OndaAltScheduler scheduling at " + configuration.schedulerOndaAltMinutes());

		if (configuration.schedulerOndaAltMinutes()<1) return;
		
		Trigger trigger = _triggerFactory.createTrigger(className, className, null, null, configuration.schedulerOndaAltMinutes(), TimeUnit.MINUTE);

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
	private TriggerFactory _triggerFactory;

	@Reference
	private SchedulerEngineHelper baseScheduler;

	
	
}
