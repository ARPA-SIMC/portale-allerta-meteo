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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.transaction.Transactional;

import it.eng.radarMeteo.bean.StatoAllertaBean;
import it.eng.radarMeteo.model.Comuni_ws;
import it.eng.radarMeteo.service.base.Comuni_wsServiceBaseImpl;

/**
 * The implementation of the comuni_ws remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.radarMeteo.service.Comuni_wsService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Francesco
 * @see Comuni_wsServiceBaseImpl
 */
public class Comuni_wsServiceImpl extends Comuni_wsServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>it.eng.radarMeteo.service.Comuni_wsServiceUtil</code> to access the comuni_ws remote service.
	 */
	
	private Log _log = LogFactoryUtil.getLog(Comuni_wsServiceImpl.class);

	@Transactional
	public ArrayList<HashMap<String, String>> getMeteomont(){
		ArrayList<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		List<Object[]> meteomont = comuni_wsFinder.getMeteomont();
		for(Object[] value: meteomont){
			HashMap<String, String> mappa = new HashMap<String, String>();
			mappa.put("titolo",(String)value[0]);
			mappa.put("url", (String)value[1]);
			result.add(mappa);
		}
		return result;
	}

	@Transactional
	public Map<String,Object> getStatoAllerta(){
		Map<String,Object> result = new HashMap<String, Object>();
		Calendar calendar = Calendar.getInstance();
		java.sql.Timestamp javaSqlDate = new java.sql.Timestamp(calendar.getTimeInMillis());
		List<Object[]> getStatoAllerta = comuni_wsFinder.getStatoAllerta(javaSqlDate);
		_log.info("db array: "+getStatoAllerta.size()+"  "+javaSqlDate);
		Object[] next = getStatoAllerta.iterator().next();
		result.put("dataEmissione", next[1]);
		result.put("dataFine", next[2]);
		result.put("titolo",next[12]);
		result.put("descrizionemeteo",next[13]);
		result.put("link",next[14]);
		for(Object[] value:getStatoAllerta){
			StatoAllertaBean statoAllertaBean = new StatoAllertaBean( 
					(String) value[3],(String) value[4], 
					(String)value[5], (String)value[6], (String)value[7], 
					(String)value[8], (String)value[9], 
					(String)value[10],(String) value[11]);
			List<Comuni_ws> findByZonaallerta = null;
			try{
				if(((String)value[0]).equalsIgnoreCase("F1"))				
					findByZonaallerta = comuni_wsPersistence.findByZonaallerta("F");
				else
					if(((String)value[0]).length()==1)
						findByZonaallerta = comuni_wsPersistence.findByZonaallerta((String)value[0]);
					else
						findByZonaallerta = comuni_wsPersistence.findBySottozona((String)value[0]);
			}
			catch(SystemException e){
				_log.error(e);
			}
			for(Comuni_ws ws:findByZonaallerta){
				statoAllertaBean.getComuni().add(ws.getComune());
				if(!statoAllertaBean.getProvince().contains(ws.getProvincia())){
					statoAllertaBean.getProvince().add(ws.getProvincia());
				}

			}
			result.put((String) value[0], statoAllertaBean);
		}
		_log.info("db array post: "+result.size());
		return result;
	}

	@Transactional
	public Map<String,Object> getStatoAllerta(java.sql.Timestamp timestamp){
		Map<String,Object> result = new HashMap<String, Object>();
		java.sql.Timestamp javaSqlDate = timestamp;
		List<Object[]> getStatoAllerta = comuni_wsFinder.getStatoAllerta(javaSqlDate);
		Object[] next = getStatoAllerta.iterator().next();
		result.put("dataEmissione", next[1]);
		result.put("dataFine", next[2]);
		result.put("titolo",next[12]);
		result.put("descrizionemeteo",next[13]);
		result.put("link",next[14]);
		for(Object[] value:getStatoAllerta){
			StatoAllertaBean statoAllertaBean = new StatoAllertaBean( 
					(String) value[3],(String) value[4], 
					(String)value[5], (String)value[6], (String)value[7], 
					(String)value[8], (String)value[9], 
					(String)value[10],(String) value[11]);
			List<Comuni_ws> findByZonaallerta = null;
			try{
				if(((String)value[0]).equalsIgnoreCase("F1"))				
					findByZonaallerta = comuni_wsPersistence.findByZonaallerta("F");
				else
					if(((String)value[0]).length()==1)
						findByZonaallerta = comuni_wsPersistence.findByZonaallerta((String)value[0]);
					else
						findByZonaallerta = comuni_wsPersistence.findBySottozona((String)value[0]);
			}
			catch(SystemException e){
				_log.error(e);
			}
			for(Comuni_ws ws:findByZonaallerta){
				statoAllertaBean.getComuni().add(ws.getComune());
				if(!statoAllertaBean.getProvince().contains(ws.getProvincia())){
					statoAllertaBean.getProvince().add(ws.getProvincia());
				}

			}
			result.put((String) value[0], statoAllertaBean);
		}
		return result;
	}

}