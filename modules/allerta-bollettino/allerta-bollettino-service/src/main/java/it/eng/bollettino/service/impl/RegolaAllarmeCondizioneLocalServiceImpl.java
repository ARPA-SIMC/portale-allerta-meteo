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

import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;

import it.eng.bollettino.model.RegolaAllarmeCondizione;
import it.eng.bollettino.service.RegolaAllarmeCondizioneLocalServiceUtil;
import it.eng.bollettino.service.base.RegolaAllarmeCondizioneLocalServiceBaseImpl;

/**
 * The implementation of the regola allarme condizione local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.bollettino.service.RegolaAllarmeCondizioneLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author GFAVINI
 * @see RegolaAllarmeCondizioneLocalServiceBaseImpl
 */
public class RegolaAllarmeCondizioneLocalServiceImpl
	extends RegolaAllarmeCondizioneLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.bollettino.service.RegolaAllarmeCondizioneLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.bollettino.service.RegolaAllarmeCondizioneLocalServiceUtil</code>.
	 */
	
	public List<RegolaAllarmeCondizione> getAllarmeCondizione(long idRegola) {
		
		DynamicQuery dyn = 
					DynamicQueryFactoryUtil
						.forClass(RegolaAllarmeCondizione.class, getClassLoader())
						.add(PropertyFactoryUtil.forName("idRegola").eq(idRegola))
						.addOrder(OrderFactoryUtil.asc("id"));
		return RegolaAllarmeCondizioneLocalServiceUtil.dynamicQuery(dyn);
	}

}