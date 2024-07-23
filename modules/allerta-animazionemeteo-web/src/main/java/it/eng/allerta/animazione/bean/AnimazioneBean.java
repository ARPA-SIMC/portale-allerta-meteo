package it.eng.allerta.animazione.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.google.gson.Gson;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.eng.animaeteo.model.AnimeteoImg;
import it.eng.animaeteo.model.AnimeteoSmallImg;
import it.eng.animaeteo.service.AnimeteoImgLocalServiceUtil;
import it.eng.animaeteo.service.AnimeteoSmallImgLocalServiceUtil;

public class AnimazioneBean implements Serializable {

	private static final long serialVersionUID = 3899877445302620722L;
	
	private static Log _log = LogFactoryUtil.getLog(AnimazioneBean.class);
		
	Calendar calendar = null;
	private List<String> days = new ArrayList<String>();
	
	public List<String> days() {
		
		for(int i=0; i<3; i++){
			
			calendar = Calendar.getInstance();
			calendar.add(Calendar.DATE, i);
			days.add(new SimpleDateFormat("EEEE d MMMM y").format(calendar.getTime()));
		}
		
		return days;
	}	
	
	public static ArrayList<String> createImageList(String param) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		return list;	
	}
	
	public static ArrayList<String> createBigImageList(String param) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		return list;	
	}
	
	public String retriveImg(String type) {
		
		List<AnimeteoSmallImg> list = null;
		
		try {
			
			list = AnimeteoSmallImgLocalServiceUtil.findByType(type);
			
		} catch (SystemException e) {
			
			e.printStackTrace();
		}
		
		return new Gson().toJson(list);
	}
	
	public List<AnimeteoSmallImg> retriveImgView(String type) {
		
		List<AnimeteoSmallImg> list = null;
		
		try {
			
			list = AnimeteoSmallImgLocalServiceUtil.findByType(type);
			
		} catch (SystemException e) {
			
			_log.error(e);
		}
		
		return list;
	}

	public String retriveBigImg(String type) {
		
		if(type==null){
			
			type="preci";
		}
		
		List<AnimeteoImg> list = null;
		
		try {
			
			list = AnimeteoImgLocalServiceUtil.findByType(type);
			
		} catch (SystemException e) {
			_log.error(e);
		}
		
		return new Gson().toJson(list);
	}
	
	public AnimeteoImg retriveBigImg(String type, int id) {
		
		if(type==null){
			
			type="preci";
		}
		
		List<AnimeteoImg> list = null;
		
		try {
			
			list = AnimeteoImgLocalServiceUtil.findByType(type);
			
		} catch (SystemException e) {
			_log.error(e);
		}
		
		return list.get(id);
	}
	
	public String retrieveImgHome(String type) {
		
		String img = null;
		
		try{
			
			img = AnimeteoImgLocalServiceUtil.findByType(type).get(0).getData();
			
		}catch(SystemException e){
			
			_log.error(e);
		}
		
		return img;
	}

}
