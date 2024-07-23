package it.eng.allerta.animazione.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import it.eng.radarMeteo.model.Img;
import it.eng.radarMeteo.service.ImgLocalServiceUtil;
import it.eng.radarMeteo.service.ImgServiceUtil;

public class RadarBean implements Serializable {

	private static final long serialVersionUID = 4419015455823352187L;
	
	private static Log _log = LogFactoryUtil.getLog(RadarBean.class);
	
	private String info;
	private long infoIDUt;
	private String bounds;
	private String urlImg;
	private String portalUrl;
	private List<Img> allImagesList;
	private ThemeDisplay _themeDisplay;

	//	private String currentVar = null;
	private HashMap<Long,String> imgMap = new HashMap<Long,String>();

	private static final Map<String,String> variables;
	static {
		variables = new HashMap<String,String>();
		variables.put("temperature", "/254,0,0/103,2000,-,-/B12101");
		variables.put("umidita", "/254,0,0/103,2000,-,-/B13003");
		variables.put("pressione", "/254,0,0/1,-,-,-/B10004");
		variables.put("vento", "/254,0,0/103,10000,-,-/B11002");
		variables.put("livello-idrometrico", "/254,0,0/1,-,-,-/B13215");
		variables.put("precipitazioni", "/1,0,3600/1,-,-,-/B13011");
		
		variables.put("livellomare", "/254,0,0/101,-,-,-/B22037");
		variables.put("altezzaonda", "/0,0,1800/1,-,-,-/M00002");
		variables.put("direzioneonda", "/200,0,1800/1,-,-,-/M00001");
	}
	
	public RadarBean(ThemeDisplay themeDisplay) {
		this._themeDisplay = themeDisplay;
	}
	
	public String getLastImages(){
		
		try {
			
			return ImgServiceUtil.getlastimages().getData();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String graficoData(){
		
		String url = _themeDisplay.getURLCurrent();
		
		Pattern p;
		Matcher m;

		p = Pattern.compile("stazione=([^&]+)", Pattern.CASE_INSENSITIVE);		
		m = p.matcher(url);
		m.find();		
		String stazione = m.group(1);

		p = Pattern.compile("variabile=([^&]+)", Pattern.CASE_INSENSITIVE);		
		m = p.matcher(url);
		m.find();		
		
		String variabile = m.group(1);
		
		_log.info("stazione e variabile grafico"+stazione + " " + variabile);
		
		return new Gson().toJson(ImgServiceUtil.getInfoSensore(stazione, variabile));
	}
	
	public String getAllImagesJSON(){
		
		allImagesList = null;
		
		try {
			
			allImagesList = ImgLocalServiceUtil.getImgs(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			
			for(Img current:allImagesList){
//				Timestamp imgTimestamp = new Timestamp(current.getId()*1000);
//				Calendar cal = Calendar.getInstance();
//				cal.setTimeInMillis(imgTimestamp.getTime());
//				boolean dst = TimeZone.getTimeZone("Europe/Rome").inDaylightTime(new Date());
//				if(dst)
//					cal.add(Calendar.HOUR,2);
//				else
//					cal.add(Calendar.HOUR,1);
//				long later = cal.getTime().getTime()/1000;
//				current.setId(later);
				imgMap.put(current.getId(),current.getData());
			}
			bounds = allImagesList.get(0).getCoord();
		} catch (SystemException e) {
			_log.error(e);
		}
		
		Gson jObj = new GsonBuilder().create();
		
		return jObj.toJson(imgMap);
	}
	
	public String getAllImagesJSON5() {
		
		allImagesList = null;
		
		try {
			allImagesList = ImgLocalServiceUtil.getImgs(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			
			_log.info("First id " +allImagesList.get(0).getId());
			_log.info("Last id " +allImagesList.get(allImagesList.size()-1).getId());
			
			for(Img current:allImagesList) {
				
				Timestamp imgTimestamp = new Timestamp(current.getId()*1000);
				Calendar cal = Calendar.getInstance();
				cal.setTimeInMillis(imgTimestamp.getTime());
				
				boolean dst = TimeZone.getTimeZone("Europe/Rome").inDaylightTime(new Date());
				
				if(dst)
					cal.add(Calendar.HOUR,2);
				else
					cal.add(Calendar.HOUR,1);
				long later = cal.getTime().getTime()/1000;
				
				current.setId(later);
				
				imgMap.put(current.getId(),current.getData());
			}
			
			bounds = allImagesList.get(0).getCoord();
			
		} catch (SystemException e) {
			_log.error(e);
		}
		
		Gson jObj = new GsonBuilder().create();
		return jObj.toJson(imgMap);
	}
	
	public String getImgRadar(int id){
		return allImagesList.get(id).getData();
	}

	public HashMap<Long, String> getImgMap() {
		return imgMap;
	}

	public void setImgMap(HashMap<Long, String> imgMap) {
		this.imgMap = imgMap;
	}
	public String getPortalUrl() {
		return portalUrl;
	}

	public void setPortalUrl(String portalUrl) {
		this.portalUrl = portalUrl;
	}

	public String getBounds() {
		return bounds;
	}

	public String getUrlImg() {
		return urlImg;
	}

	public long getInfoIDUt() {
		return infoIDUt;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
