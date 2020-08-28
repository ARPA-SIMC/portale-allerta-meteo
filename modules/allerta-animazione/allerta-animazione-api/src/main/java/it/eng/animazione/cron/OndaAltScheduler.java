package it.eng.animazione.cron;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

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
import it.eng.animazione.image.service.altezzaOndaLocalService;
//import it.eng.animazione.image.service.altezzaOndaLocalServiceUtil;

@Component(
	immediate = false,
	service = MessageListener.class
	)
public class OndaAltScheduler extends BaseMessageListener {
	
	private Log _log = LogFactoryUtil.getLog(OndaAltScheduler.class);

	public final static String jsonURL = "https://www.arpae.it/sim/external/bollettino/mappe_mare.php";
	public final static String imgURLadriaroms = "https://www.arpae.it/sim/datiiningresso/Immagini/adriaroms/";
	public final static String imgURLswanemr = "https://www.arpae.it/sim/datiiningresso/Immagini/SWANEMR/";

	@Reference(cardinality=ReferenceCardinality.MANDATORY)
	altezzaOndaLocalService altezzaService;
	
	@Override
	protected void doReceive(Message message) throws Exception {
		
		_log.info("OndaAlt Scheduler - START");

		getAltezzaOndaImages();
		
		_log.info("OndaAlt Scheduler - END");

	}
	
	private byte[] fromStreamtoByteArray(InputStream inputStream) throws IOException {
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		StreamUtil.transfer(inputStream, baos);
		
		return baos.toByteArray();
	}

	private void getAltezzaOndaImages() {
		
		// TODO Auto-generated method stub
		InputStream input = null;
		try{
			input= getInputStreaWithTimeout(jsonURL);
			String jsonString = new String(fromStreamtoByteArray(input));
			input.close();
			JSONObject myObject = JSONFactoryUtil.createJSONObject(jsonString);
			JSONObject SWANEMR = myObject.getJSONObject("SWANEMR");
			for(int i=1;i<=72;i++){
				JSONObject element = SWANEMR.getJSONObject(String.format("%02d", i));
				JSONObject im = element.getJSONObject("im");
				altezzaOnda field = altezzaService.fetchaltezzaOnda(i);
				if(field == null){
					field = altezzaService.createaltezzaOnda(i);
				}
				field.setIm(im.getString("im"));
				field.setText_LOC(im.getString("text_LOC"));
				field.setTs_UTC(im.getLong("ts_UTC"));
				input = getInputStreaWithTimeout(imgURLswanemr+field.getIm());
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
