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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import allerta.bollettino.service.util.DownloaderDati;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.eng.bollettino.cron.RisultatiAggiornamento;
import it.eng.bollettino.model.Stazione;
import it.eng.bollettino.model.StazioneVariabile;
import it.eng.bollettino.service.StazioneLocalServiceUtil;
import it.eng.bollettino.service.base.StazioneLocalServiceBaseImpl;

/**
 * The implementation of the stazione local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.bollettino.service.StazioneLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author GFAVINI
 * @see StazioneLocalServiceBaseImpl
 */
public class StazioneLocalServiceImpl extends StazioneLocalServiceBaseImpl {
	
	private Log logger = LogFactoryUtil.getLog(StazioneLocalServiceImpl.class);

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.bollettino.service.StazioneLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.bollettino.service.StazioneLocalServiceUtil</code>.
	 */
	

	public Stazione getStazione(String id) {
		
		return StazioneLocalServiceUtil.fetchStazione(id);
		
	}
	
	public List<Stazione> getStazioni(String variabile) {
		
		DynamicQuery dyn = 
					DynamicQueryFactoryUtil
						.forClass(Stazione.class, getClassLoader())
						.add(
								PropertyFactoryUtil
									.forName("id").in(
											DynamicQueryFactoryUtil
												.forClass(StazioneVariabile.class, getClassLoader())
												.add(PropertyFactoryUtil.forName("idVariabile").eq(variabile))
												.setProjection(ProjectionFactoryUtil.property("idStazione")))
						 )
						.addOrder(OrderFactoryUtil.asc("name"));
		
		return StazioneLocalServiceUtil.dynamicQuery(dyn);
		
	}
	
	public RisultatiAggiornamento aggiornaStazioni() {
		
		RisultatiAggiornamento out = new RisultatiAggiornamento();
		
		String dati = DownloaderDati.downloadStazioni();
		if (dati==null) {
			out.errore = "Impossibile scaricare web service stazioni";
			return out;
		}
		
		List<Map<String, Object>> v = DownloaderDati.convertiJson(dati);
		if (v==null) {
			out.errore = "Dati stazioni in formato non comprensibile";
			return out;
		}
		
		List<Stazione> staz = null;
		List<Stazione> staz2 = new ArrayList<Stazione>();
		try {
			staz = StazioneLocalServiceUtil.getStaziones(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			staz2.addAll(staz);
		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("caricaDbTask", "aggiornaStazioni", e, "");
		}
		
		for (Map<String,Object> o : v) {
			try {
				String id = (String)o.get("id");
				if (id==null) continue;
				
				Stazione s = null;
				
				try {
					s = StazioneLocalServiceUtil.fetchStazione(id);
					if (s==null) {
						s = StazioneLocalServiceUtil.createStazione(id);
						s.setAttivo(true);
						logger.info("Creazione stazione "+id);
						out.aggiunti++;
					}
					
					for (Stazione ss : staz2) {
						if (ss.getId().equals(s.getId())) {
							staz2.remove(ss);
							break;
						}
					}
					
				} catch (Exception e) {
					logger.error(e);
				}
				
				if (!s.getAttivo()) {
					s.setAttivo(true);
					logger.info("Riattivazione stazione "+id);
					out.modificati++;
				}
				
				if (o.get("height") != null)
					s.setHeight(Float.parseFloat(o.get("height").toString()));
				if (o.get("lat") != null)
					s.setLat((long) Double.parseDouble(o.get("lat").toString()));
				if (o.get("lon") != null)
					s.setLon((long) Double.parseDouble(o.get("lon").toString()));
				if (o.get("ident") != null)
					s.setIdent(o.get("ident").toString());
				if (o.get("network") != null)
					s.setNetwork(o.get("network").toString());
				if (o.get("name") != null)
					s.setName(o.get("name").toString());

				if (o.get("country") != null) {
					Map<String, Object> m = (Map<String, Object>) o.get("country");
					if (m.get("name") != null)
						s.setNameCountry(m.get("name").toString());
					if (m.get("code") != null)
						s.setIdCountry(m.get("code").toString());
				}

				if (o.get("province") != null) {
					Map<String, Object> m = (Map<String, Object>) o.get("province");
					if (m.get("name") != null)
						s.setNameProvince(m.get("name").toString());
					if (m.get("code") != null)
						s.setIdProvince(m.get("code").toString());
				}

				if (o.get("basin") != null) {
					Map<String, Object> m = (Map<String, Object>) o.get("basin");
					if (m.get("name") != null)
						s.setNameBasin(m.get("name").toString());
					if (m.get("code") != null)
						s.setIdBasin(m.get("code").toString());
				}

				if (o.get("region") != null) {
					Map<String, Object> m = (Map<String, Object>) o.get("region");
					if (m.get("name") != null)
						s.setNameRegion(m.get("name").toString());
					if (m.get("code") != null)
						s.setIdRegion(m.get("code").toString());
				}

				if (o.get("subbasin") != null) {
					Map<String, Object> m = (Map<String, Object>) o.get("subbasin");
					if (m.get("name") != null)
						s.setNameSubbasin(m.get("name").toString());
					if (m.get("code") != null)
						s.setIdSubbasin(m.get("code").toString());
				}

				if (o.get("municipality") != null) {
					Map<String, Object> m = (Map<String, Object>) o.get("municipality");
					if (m.get("name") != null)
						s.setNameMunicipality(m.get("name").toString());
					if (m.get("code") != null)
						s.setIdMunicipality(m.get("code").toString());
				}

				if (o.get("macroarea") != null) {
					Map<String, Object> m = (Map<String, Object>) o.get("macroarea");
					if (m.get("name") != null)
						s.setNameMacroarea(m.get("name").toString());
					if (m.get("code") != null)
						s.setIdMacroarea(m.get("code").toString());
				}

				StazioneLocalServiceUtil.updateStazione(s);
				
			} catch (Exception e) {
				logger.error(e);
			}
			
		}
		
		for (Stazione rimasto : staz2) {
			try {
				if (rimasto.getAttivo()) {
					logger.info("Disattivo stazione "+rimasto.getId());
					out.rimossi++;
				}
				rimasto.setAttivo(false);
				StazioneLocalServiceUtil.updateStazione(rimasto);
			} catch (Exception e) {
				logger.error(e);
			}
		}
		
		return out;
	}
}