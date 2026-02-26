/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.cache.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.json.JSONDeserializer;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONSerializer;

import java.util.Date;
import java.util.List;

import it.eng.cache.model.Dati;
import it.eng.cache.service.DatiLocalServiceUtil;
import it.eng.cache.service.base.DatiLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author GFAVINI
 */
@Component(
	property = "model.class.name=it.eng.cache.model.Dati",
	service = AopService.class
)
public class DatiLocalServiceImpl extends DatiLocalServiceBaseImpl {
	

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.cache.service.DatiLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.cache.service.DatiLocalServiceUtil</code>.
	 */
	
	public void putDato(String chiave, Object valore) {
		Dati d = DatiLocalServiceUtil.fetchDati(chiave); 
		if (d==null) d = DatiLocalServiceUtil.createDati(chiave); 
		d.setCreateDate(new Date());
		if (valore==null) d.setDato(null);
		else {
			JSONSerializer serializer = JSONFactoryUtil.createJSONSerializer();
			String jsonData = serializer.serialize(valore);
			d.setDato(jsonData);
		}
		DatiLocalServiceUtil.updateDati(d);
	}
	
	public Object getDato(String chiave) {
		Dati d = DatiLocalServiceUtil.fetchDati(chiave);
		if (d==null || d.getDato()==null) return null;
		JSONDeserializer ds = JSONFactoryUtil.createJSONDeserializer();
		return ds.deserialize(d.getDato());
	}
	
	public List<Dati> getDatiByPrefix(String prefix) {
		DynamicQuery dyn = datiLocalService.dynamicQuery().
			add(PropertyFactoryUtil.forName("idDati").like(prefix));
		return datiLocalService.dynamicQuery(dyn);
	}
	
	public void removeDatiByPrefix(String prefix) {
		List<Dati> ld = getDatiByPrefix(prefix);
		for (Dati d : ld) DatiLocalServiceUtil.deleteDati(d);
	}
}