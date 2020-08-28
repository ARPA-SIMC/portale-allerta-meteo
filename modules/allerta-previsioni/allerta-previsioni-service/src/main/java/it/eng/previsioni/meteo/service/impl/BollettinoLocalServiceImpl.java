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

package it.eng.previsioni.meteo.service.impl;

import com.liferay.portal.kernel.exception.SystemException;

import it.eng.previsioni.meteo.exception.NoSuchBollettinoException;
import it.eng.previsioni.meteo.model.Bollettino;
import it.eng.previsioni.meteo.service.base.BollettinoLocalServiceBaseImpl;

/**
 * The implementation of the bollettino local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.previsioni.meteo.service.BollettinoLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BollettinoLocalServiceBaseImpl
 */
public class BollettinoLocalServiceImpl extends BollettinoLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.previsioni.meteo.service.BollettinoLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.previsioni.meteo.service.BollettinoLocalServiceUtil</code>.
	 */
	
	@Override
	public Bollettino findByTipo(String currentType){
		try {
			Bollettino result = bollettinoPersistence.findBytipo(currentType);
			return result;
		} catch (NoSuchBollettinoException | SystemException e) {
			return null;
		}
	}

	@Override
	public Bollettino findByID(long id){
		// TODO Auto-generated method stub
		try {
			return bollettinoPersistence.fetchByPrimaryKey(id);
		} catch (SystemException e) {
			return null;
		}
	}
}