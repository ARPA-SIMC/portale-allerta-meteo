/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service.impl;

import com.liferay.portal.aop.AopService;

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
import org.osgi.service.component.annotations.Component;

/**
 * @author GFAVINI
 */
@Component(
	property = "model.class.name=it.eng.bollettino.model.Variabile",
	service = AopService.class
)
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