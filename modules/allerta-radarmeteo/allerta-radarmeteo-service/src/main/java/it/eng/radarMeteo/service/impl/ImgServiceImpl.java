/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.eng.radarMeteo.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.access.control.AccessControlled;

import it.eng.radarMeteo.model.Img;
import it.eng.radarMeteo.service.base.ImgServiceBaseImpl;

/**
 * The implementation of the img remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.radarMeteo.service.ImgService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Francesco
 * @see ImgServiceBaseImpl
 */
public class ImgServiceImpl extends ImgServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>it.eng.radarMeteo.service.ImgServiceUtil</code> to access the img remote service.
	 */
	
	private Log _log = LogFactoryUtil.getLog(ImgServiceImpl.class);

	@Override
	@AccessControlled(guestAccessEnabled=true)
	public ArrayList<Map<String,Object>> getsensorvaluesnotime(String variabile, long time){
		int n = 0;
		int number = 0;
		List<Object[]> list = null;
		
		time = time - 60*60*1000;
		
		do{
			if(variabile.equals("1,0,3600/1,-,-,-/B13011"))
				list = jsonFinder.findValuesByElenco(variabile, time);
			else
				list = jsonFinder.findValuesByVarDate(variabile, time);

			for (Object[] objects : list)
				if((Double)objects[1] != null)
					n++;
			number++;
			//			System.out.println("test no time: "+list.size()+"  "+n+"  "+number);
		}
		while(n<(list.size()*0.8) && number<3);
		ArrayList<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		Map<String,Object> mappa;

		mappa= new HashMap<String, Object>();
		mappa.put("time",time);
		result.add(mappa);

		for (Object[] objects : list) {
			mappa= new HashMap<String, Object>();
			mappa.put("idstazione",(String)objects[0]);
			if(variabile.equals("1,0,3600/1,-,-,-/B13011"))
				mappa.put("value",(Double)objects[7]);
			else
				mappa.put("value",(Double)objects[1]);
			mappa.put("lat",(Long)objects[2]);
			mappa.put("lon",(Long)objects[3]);
			mappa.put("nomestaz",(String)objects[4]);
			mappa.put("ordinamento", (Integer)objects[5]);
			if(variabile.equals("1,0,3600/1,-,-,-/B13011"))
				mappa.put("idvariabile",(String)objects[6]);
			else{
				mappa.put("soglia1", (Double)objects[6]);
				mappa.put("soglia2", (Double)objects[7]);
				mappa.put("soglia3", (Double)objects[8]);
			}
			result.add(mappa);
		}
		return result;
	}

	@Override
	@AccessControlled(guestAccessEnabled=true)
	public ArrayList<Map<String, Object>> getSensorValues(String variabile, Long time){
		
		if (TimeZone.getDefault().getRawOffset()>0) {
			time += TimeZone.getDefault().getRawOffset();
			//if (TimeZone.getDefault().inDaylightTime(new Date())) time += 3600000;
		}
		
		//		System.out.println("ciao time"+new Timestamp(time)+"  "+new Date(time));
		//		long start = System.currentTimeMillis();
		List<Object[]> list = null;
		if(variabile.equals("1,0,3600/1,-,-,-/B13011"))
			list = jsonFinder.findValuesByElenco(variabile, time);
		else
			list = jsonFinder.findValuesByVarDate(variabile, time);
		//		System.out.println("tempo1: "+(System.currentTimeMillis()-start));
		ArrayList<Map<String,Object>> result = new ArrayList<Map<String,Object>>();

		for (Object[] objects : list) {
			Map<String,Object> mappa= new HashMap<String, Object>();
			mappa.put("idstazione",(String)objects[0]);
			if(variabile.equals("1,0,3600/1,-,-,-/B13011"))
				mappa.put("value",(Double)objects[7]);
			else
				mappa.put("value",(Double)objects[1]);
			mappa.put("lat",(Long)objects[2]);
			mappa.put("lon",(Long)objects[3]);
			mappa.put("nomestaz",(String)objects[4]);
			mappa.put("ordinamento", (Integer)objects[5]);
			if(variabile.equals("1,0,3600/1,-,-,-/B13011"))
				mappa.put("idvariabile",(String)objects[6]);
			else{
				mappa.put("soglia1", (Double)objects[6]);
				mappa.put("soglia2", (Double)objects[7]);
				mappa.put("soglia3", (Double)objects[8]);
			}

			result.add(mappa);
		}

		return result;
	}
	@Override
	@AccessControlled(guestAccessEnabled=true)
	public ArrayList<Map<String, Object>> getTimeSeries(String stazione, String variabile){
		long step = 0;
		ArrayList<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		List<Object[]> list = jsonFinder.findLastTheeDays(stazione,variabile);
		_log.info("elementi dal db: "+list.size() );
		TimeZone tz = TimeZone.getTimeZone("Europe/Rome");
		boolean inDs = tz.inDaylightTime(new Date());
		if (variabile.contains("B13011")){
			if (variabile.contains("3600"))
				step=3600000;
			else
				step=1800000;
		}
		if(variabile.contains("B13215")){
			step=3600000;
			for(int i=0; i<list.size()-1; i++){
				Timestamp ts = (Timestamp)list.get(i)[1];
				Timestamp ts_next = (Timestamp)list.get(i+1)[1];
				if(Math.abs(ts_next.getTime()-ts.getTime())<step)
					step=Math.abs(ts_next.getTime()-ts.getTime());
			}
			//old value prima dei 15 minuti
			//step=1800000;
		}
		Map<String,Object> mappa;
		for (Object[] value: list) {
			mappa = new HashMap<String, Object>();
			//aggiungo dst
			Timestamp ts = (Timestamp)value[1];
			if (inDs)
				ts.setTime(ts.getTime() + (120 * 60 * 1000));
			else
				ts.setTime(ts.getTime() + (60 * 60 * 1000));
			if(step!=0 && result.size()>0){
//				_log.info("Sono nel test per verificare se il dato successivo esista");
				long tsb = ts.getTime();
//				_log.info("long tsb = ts.getTime() "+tsb);
				Timestamp times = (Timestamp)result.get((result.size()-1)).get("t");
				boolean aaa = times.getTime()+step!=ts.getTime();
//				_log.info("Timestamp times = (Timestamp)result.get((result.size()-1)).get(t) "+times+ " test "+ aaa);
//				_log.info("times.getTime() "+times.getTime()+" times.getTime()+step "+(times.getTime()+step) );
//				_log.info("times.getTime()+step!=ts.getTime())");
				if(aaa){
					tsb +=step;

					mappa.put("v", null);
					mappa.put("t", (tsb));
					result.add(mappa);
					mappa = new HashMap<String, Object>();
				}				
			}
			mappa.put("v", (Double)value[0]);
			mappa.put("t", (ts));
			result.add(mappa);
		}
		return result;
	}

	@Override
	@AccessControlled(guestAccessEnabled=true)
	public ArrayList<Map<String, Object>> lastdata(String stazione, String variabile){

		ArrayList<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		List<Object[]> list = jsonFinder.findLastTheeDays(stazione,variabile);
		TimeZone tz = TimeZone.getTimeZone("Europe/Rome");
		boolean inDs = tz.inDaylightTime(new Date());
		for (Object[] objects : list) {
			Map<String,Object> mappa= new HashMap<String, Object>();
			//aggiungo dst
			Timestamp ts = (Timestamp)objects[1];
			if (inDs)
				ts.setTime(ts.getTime() + (120 * 60 * 1000));
			else
				ts.setTime(ts.getTime() + (60 * 60 * 1000));

			mappa.put("v", (Double)objects[0]);
			mappa.put("t", (ts));
			result.add(mappa);
		}
		return result;
	}

	@Override
	@AccessControlled(guestAccessEnabled=true)
	public Map<String, Object> getInfoSensore(String stazione, String variabile){

		Map<String,Object> mappa = new HashMap<String, Object>();
		List<Object[]> list = jsonFinder.getInfoSensore(stazione, variabile);
		for (Object[] objects : list) {
			mappa.put("name", (String)objects[0]);
			mappa.put("description", (String)objects[1]);
			mappa.put("height", (Double)objects[2]);
			mappa.put("namebasin", (String)objects[3]);
			mappa.put("namesubbasin", (String)objects[4]);
			mappa.put("soglia1", (Double)objects[5]);
			mappa.put("soglia2", (Double)objects[6]);
			mappa.put("soglia3", (Double)objects[7]);
			mappa.put("unit", (String)objects[8]);
		}
		return mappa;
	}

	@Override
	@AccessControlled(guestAccessEnabled=true)
	public ArrayList<Map<String, Object>> getStations(){
		ArrayList<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		ArrayList<Object[]> list = (ArrayList<Object[]>) jsonFinder.getAllStations();
		for (Object[] objects : list) {
			Map<String,Object> mappa = new HashMap<String, Object>();
			mappa.put("id_", (String)objects[0]);
			mappa.put("name", (String)objects[1]);
			mappa.put("municipality", (String)objects[2]);
			mappa.put("height", (Double)objects[3]);
			mappa.put("lat", (Long)objects[4]);
			mappa.put("lon", (Long)objects[5]);
			mappa.put("attivo", (Boolean)objects[6]);
			result.add(mappa);
		}
		return result;
	}

	@Override
	@AccessControlled(guestAccessEnabled=true)
	public Img getlastimages(){
		try {
			return imgFinder.findLastRadar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}