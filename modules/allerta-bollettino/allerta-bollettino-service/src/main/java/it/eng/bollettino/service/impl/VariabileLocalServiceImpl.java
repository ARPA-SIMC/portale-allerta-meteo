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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;
import java.util.Map;

import org.apache.felix.utils.log.Logger;

import allerta.bollettino.service.util.DownloaderDati;
import it.eng.bollettino.cron.RisultatiAggiornamento;
import it.eng.bollettino.model.Variabile;
import it.eng.bollettino.service.VariabileLocalServiceUtil;
import it.eng.bollettino.service.base.VariabileLocalServiceBaseImpl;

/**
 * The implementation of the variabile local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.bollettino.service.VariabileLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author GFAVINI
 * @see VariabileLocalServiceBaseImpl
 */
public class VariabileLocalServiceImpl extends VariabileLocalServiceBaseImpl {

	private Log logger = LogFactoryUtil.getLog(VariabileLocalServiceImpl.class);
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.bollettino.service.VariabileLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.bollettino.service.VariabileLocalServiceUtil</code>.
	 */
	public RisultatiAggiornamento aggiornaVariabili() {
		
		RisultatiAggiornamento out = new RisultatiAggiornamento();
		
		String dati = DownloaderDati.downloadVariabili();
		if (dati==null) {
			out.errore = "Impossibile scaricare web service variabili";
			return out;
		}
		
		List<Map<String, Object>> v = DownloaderDati.convertiJson(dati);
		if (v==null) {
			out.errore = "Dati variabili in formato non comprensibile";
			return out;
		}
		
		for (Map<String,Object> o : v) {
			try {
				String id = (String)o.get("id");
				if (id==null) continue;
				
				Variabile s = null;
				s = fetchVariabile(id);
				if (s==null) {
					s = createVariabile(id);
					out.aggiunti++;
				}
				
				if (o.get("level_t1") != null)
					s.setLevel_t1((int) Double.parseDouble(o.get("level_t1").toString()));
				if (o.get("level_t2") != null)
					s.setLevel_t2((int) Double.parseDouble(o.get("level_t2").toString()));
				if (o.get("level_v1") != null)
					s.setLevel_v1((int) Double.parseDouble(o.get("level_v1").toString()));
				if (o.get("level_v2") != null)
					s.setLevel_v2((int) Double.parseDouble(o.get("level_v2").toString()));
				if (o.get("trange_p1") != null)
					s.setTrange_p1((int) Double.parseDouble(o.get("trange_p1").toString()));
				if (o.get("trange_p2") != null)
					s.setTrange_p2((int) Double.parseDouble(o.get("trange_p2").toString()));
				if (o.get("trange_pind") != null)
					s.setTrange_pind((int) Double.parseDouble(o.get("trange_pind").toString()));

				if (o.get("unit") != null)
					s.setUnit(o.get("unit").toString());
				if (o.get("bcode") != null)
					s.setBcode(o.get("bcode").toString());
				if (o.get("description_it") != null)
					s.setDescription_it(o.get("description_it").toString());

				updateVariabile(s);
				
			} catch (Exception e) {
				logger.error(e);
			}
		}
		
		return out;
		
	}
}