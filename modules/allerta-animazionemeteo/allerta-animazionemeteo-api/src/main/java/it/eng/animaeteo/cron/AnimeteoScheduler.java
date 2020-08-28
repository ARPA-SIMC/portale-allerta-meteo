package it.eng.animaeteo.cron;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

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
	private static final String arpaUrl = "https://www.arpae.it/sim/pagine/mappe_numeriche/immagine.php?im=";
	
	@Reference(cardinality=ReferenceCardinality.MANDATORY)
	AnimeteoImgLocalService animeteoImgLocalService;
	@Reference(cardinality=ReferenceCardinality.MANDATORY)
	AnimeteoSmallImgLocalService animeteoSmallImgLocalService;
	
	private static final List<String> variables;
	static {
		variables = new ArrayList<String>();
		variables.add("preci");
		variables.add("nuv");
		variables.add("wind");
	}
	
	@Override
	protected void doReceive(Message message) throws Exception {
		
	
		_log.info("Animeteo Scheduler START");
			
		getImagesHome();
		
		getImages();
		
		getBigImages();
		
		_log.info("Animeteo Scheduler END");
	}


	private byte[] fromStreamtoByteArray(InputStream inputStream) throws IOException {
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		StreamUtil.transfer(inputStream, baos);
		
		return baos.toByteArray();
	}

	private void getImagesHome() {
		
		_log.info("Animeteo Scheduler ImagesHome - START");
		
		Calendar cal = Calendar.getInstance(Locale.ITALY);
		InputStream stream = null;
		AnimeteoImg	animeteoImg = null;
		
		try {
			//			animeteoImg = animeteoImgLocalService.createAnimeteoImg(80);
			animeteoImg = animeteoImgLocalService.getAnimeteoImg(80);
			stream = getInputStreaWithTimeout("https://www.arpae.it/sim/pagine/mappe_numeriche/preci.png");
			animeteoImg.setName("preci.png");
			animeteoImg.setType("preciHome");
			animeteoImg.setInserted(cal.getTime());
			animeteoImg.setData(Base64.encode(fromStreamtoByteArray(stream)));
			animeteoImgLocalService.updateAnimeteoImg(animeteoImg);
	
			animeteoImg = animeteoImgLocalService.getAnimeteoImg(81);
			//			animeteoImg = animeteoImgLocalService.createAnimeteoImg(81);
			stream = getInputStreaWithTimeout("https://www.arpae.it/sim/pagine/mappe_numeriche/nuv.png");
			animeteoImg.setName("nuv.png");
			animeteoImg.setType("nuvHome");
			animeteoImg.setInserted(cal.getTime());
			animeteoImg.setData(Base64.encode(fromStreamtoByteArray(stream)));
			animeteoImgLocalService.updateAnimeteoImg(animeteoImg);

			animeteoImg = animeteoImgLocalService.getAnimeteoImg(82);
			//			animeteoImg = animeteoImgLocalService.createAnimeteoImg(82);
//			url = new URL("https://www.arpae.it/sim/pagine/mappe_numeriche/wind.png");
//			stream = url.openStream();
			stream = getInputStreaWithTimeout("https://www.arpae.it/sim/pagine/mappe_numeriche/wind.png");
			animeteoImg.setName("wind.png");
			animeteoImg.setType("windHome");
			animeteoImg.setInserted(cal.getTime());
			animeteoImg.setData(Base64.encode(fromStreamtoByteArray(stream)));
			animeteoImgLocalService.updateAnimeteoImg(animeteoImg);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error(e);
		}
		finally {
			try {
				stream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				_log.error(e);
			}
		}
		
		_log.info("Animeteo Scheduler ImagesHome - END");
	}

	public ArrayList<String> createBigImageList(String param) {
		
		ArrayList<String> list = new ArrayList<String>();
		for(int i=1; i<25; i++){
			list.add(new String(arpaUrl+param+"_"+String.format("%02d",i)+".png"));
		}
		return list;	
	}

	
	private void getBigImages() throws IOException {
		
		_log.info("Animeteo Scheduler BigImages - START");
		
		Calendar cal = Calendar.getInstance(Locale.ITALY);
		InputStream stream = null;
		AnimeteoImg animeteoImg = null;
		
		for(int i = 0; i < 3; i++){
			
			ArrayList<String> urlList = createBigImageList(variables.get(i));
			
			for(int j=1; j < 25; j++){
				
				try {
					
					animeteoImg = animeteoImgLocalService.getAnimeteoImg(i*24+j);
					//					animeteoImg = animeteoImgLocalService.createAnimeteoImg(i*24+j);
					URL url = new URL(urlList.get(j-1));
					stream = url.openStream();
					animeteoImg.setName(variables.get(i)+"_"+String.format("%02d", j)+".png");
					animeteoImg.setType(variables.get(i));
					animeteoImg.setInserted(cal.getTime());
					animeteoImg.setData(Base64.encode(fromStreamtoByteArray(stream)));
					animeteoImgLocalService.updateAnimeteoImg(animeteoImg);

				}catch (Exception e) {
					e.printStackTrace();
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
			list.add(new String(arpaUrl+param+"_"+String.format("%02d",i)+"s.png"));
		}
		return list;	
	}
	
	private void getImages() throws IOException{
		
		_log.info("Animeteo Scheduler Images - START");
		
		Calendar cal = Calendar.getInstance(Locale.ITALY);
		InputStream stream = null;
		AnimeteoSmallImg animeteoImg = null;
		
		for(int i = 0; i<3;i++){
			
			ArrayList<String> urlList = createImageList(variables.get(i));
			
			for(int j=1;j<25;j++){
				
				try {
					
					animeteoImg = animeteoSmallImgLocalService.getAnimeteoSmallImg(i*24+j);
					//					animeteoImg = AnimeteoSmallImgLocalServiceUtil.createAnimeteoSmallImg(i*24+j);
					URL url = new URL(urlList.get(j-1));

					stream =url.openStream();

					animeteoImg.setName(variables.get(i)+"_"+String.format("%02d", j)+"s.png");
					animeteoImg.setType(variables.get(i));
					animeteoImg.setInserted(cal.getTime());
					animeteoImg.setData(Base64.encode(fromStreamtoByteArray(stream)));
					animeteoSmallImgLocalService.updateAnimeteoSmallImg(animeteoImg);
					
				}catch (Exception e) {
					_log.error(e);
				}finally{
					if(stream!=null){
						stream.close();
					}
				}
			}
		}
		
		_log.info("Animeteo Scheduler Images - END");
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
		
		_log.info("AnimeteoScheduler scheduling at " + configuration.schedulerAnimeteoMinutes());

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