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

package it.eng.bollettino.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import allerta.bollettino.service.util.DownloaderDati;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.eng.bollettino.cron.RisultatiAggiornamento;
import it.eng.bollettino.model.RegolaAllarmeCondizione;
import it.eng.bollettino.model.StazioneVariabile;
import it.eng.bollettino.service.StazioneVariabileLocalServiceUtil;
import it.eng.bollettino.service.base.StazioneVariabileLocalServiceBaseImpl;

/**
 * The implementation of the stazione variabile local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.bollettino.service.StazioneVariabileLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author GFAVINI
 * @see StazioneVariabileLocalServiceBaseImpl
 */
public class StazioneVariabileLocalServiceImpl
	extends StazioneVariabileLocalServiceBaseImpl {

	private Log logger = LogFactoryUtil.getLog(StazioneVariabileLocalServiceImpl.class);
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.bollettino.service.StazioneVariabileLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.bollettino.service.StazioneVariabileLocalServiceUtil</code>.
	 */
	
	public List<StazioneVariabile> getStazioneVariabile( String idStazione, String idVariabile) {
		
		DynamicQuery dyn = 
				DynamicQueryFactoryUtil
					.forClass(StazioneVariabile.class, getClassLoader())
					.add(PropertyFactoryUtil.forName("idStazione").eq(idStazione))
					.add(PropertyFactoryUtil.forName("idVariabile").eq(idVariabile));
		
		return StazioneVariabileLocalServiceUtil.dynamicQuery(dyn);
	}
	
	public RisultatiAggiornamento aggiornaSensori() {
		
		RisultatiAggiornamento out = new RisultatiAggiornamento();
		
		String dati = DownloaderDati.downloadSensori();
		if (dati==null) {
			out.errore = "Impossibile scaricare web service sensori";
			return out;
		}
		
		Map<String,List<Object>> v = DownloaderDati.convertiJsonGenerico(dati);
		if (v==null) {
			out.errore = "Dati sensori in formato non comprensibile";
			return out;
		}
		
		List<StazioneVariabile> all = getStazioneVariabiles(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		Map<String,StazioneVariabile> map = new HashMap<String, StazioneVariabile>();
		for (StazioneVariabile sv : all) {
			String key = sv.getIdStazione()+sv.getIdVariabile();
			map.put(key, sv);
		}
		
		for (String var : v.keySet()) {
			for (Object o : v.get(var)) {
				try {
					Map<String,Object> sensore = (Map)o;
					String stazione = (String)sensore.get("station");
					Map<String,Object> datiSensore = (Map)sensore.get("sensor");
					double soglia1 = 0.0;
					double soglia2 = 0.0;
					double soglia3 = 0.0;
					
					if (datiSensore!=null) {
						Object hydroInfo = datiSensore.get("hydroinfo");
						if (hydroInfo!=null) {
							Object thresholds = ((Map<String,Object>)hydroInfo).get("thresholds");
							if (thresholds!=null) {
								List<Object> t = (List)thresholds;
								if (t!=null) {
									soglia1 = (t.get(0)!=null?Double.parseDouble(t.get(0).toString()):0.0);
									soglia2 = (t.get(1)!=null?Double.parseDouble(t.get(1).toString()):0.0);
									soglia3 = (t.get(2)!=null?Double.parseDouble(t.get(2).toString()):0.0);
								}
							}
						}
					}
					
					if (stazione==null) continue;
					
					StazioneVariabile l = map.get(stazione+var);
					boolean changed = false;
					if (l==null) {
						changed = true;
						out.aggiunti++;
						l = createStazioneVariabile(0);
						l.setIdStazione(stazione);
						l.setIdVariabile(var);
					} else {
						
						if (l.getSoglia1()!=soglia1) changed = true;
						if (l.getSoglia2()!=soglia2) changed = true;
						if (l.getSoglia3()!=soglia3) changed = true;
						if (changed) out.modificati++;
					}
					l.setSoglia1(soglia1);
					l.setSoglia2(soglia2);
					l.setSoglia3(soglia3);
					if (changed) updateStazioneVariabile(l);
					
					
				} catch (Exception e) {
					logger.error(e);
				}
			}
			
		}
		
		return out;
		
	}
}