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

package it.eng.cache.service.impl;

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

/**
 * The implementation of the dati local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.cache.service.DatiLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author GFAVINI
 * @see DatiLocalServiceBaseImpl
 */
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