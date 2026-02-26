/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.radarMeteo.service.impl;

import com.liferay.portal.aop.AopService;

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

import org.osgi.service.component.annotations.Component;

/**
 * @author Francesco
 */
@Component(
	property = {
		"json.web.service.context.name=rt_portlet",
		"json.web.service.context.path=Comuni_ws"
	},
	service = AopService.class
)
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
		result.put("dataInizio", next[2]);
		result.put("dataFine", next[3]);
		result.put("titolo",next[13]);
		result.put("descrizionemeteo",next[14]);
		result.put("link",next[15]);
		if (next.length>=16 && next[16]!=null && !"".equals(next[16])) result.put("tendenza", next[16]);
		for(Object[] value:getStatoAllerta){
			StatoAllertaBean statoAllertaBean = new StatoAllertaBean( 
					(String) value[4],(String) value[5], 
					(String)value[6], (String)value[7], (String)value[8], 
					(String)value[9], (String)value[10], 
					(String)value[11],(String) value[12]);
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
		if (getStatoAllerta==null || getStatoAllerta.size()==0) return result;
		Object[] next = getStatoAllerta.iterator().next();
		result.put("dataEmissione", next[1]);
		result.put("dataInizio", next[2]);
		result.put("dataFine", next[3]);
		
		result.put("titolo",next[13]);
		result.put("descrizionemeteo",next[14]);
		result.put("link",next[15]);
		if (next.length>=16 && next[16]!=null && !"".equals(next[16])) result.put("tendenza", next[16]);

		
		boolean nuovo = false;
		for(Object[] value:getStatoAllerta){
			String areaid = (String)value[0];
			int id = Integer.parseInt(areaid);
			if (id<0 || id%10==3) nuovo=true;
		}
		
		for(Object[] value:getStatoAllerta){
			StatoAllertaBean statoAllertaBean = new StatoAllertaBean( 
					(String) value[4],(String) value[5], 
					(String)value[6], (String)value[7], (String)value[8], 
					(String)value[9], (String)value[10], 
					(String)value[11],(String) value[12]);
			List<Comuni_ws> findByZonaallerta = null;
			
			String areaid = (String)value[0];
			int id = Integer.parseInt(areaid);
			char lettera = (char)('A'+(id/10)-1);
			char numero = (char)('0'+(id%10));
			value[0] = ""+lettera+(numero=='0'?"":numero);
			
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
	
	@Transactional
	public List<Object[]> getStatoAllertaCap(java.sql.Timestamp timestamp){
		Map<String,Object> result = new HashMap<String, Object>();
		java.sql.Timestamp javaSqlDate = timestamp;
		List<Object[]> getStatoAllerta = comuni_wsFinder.getStatoAllertaForCap(javaSqlDate);
		return getStatoAllerta;
		
	}
}