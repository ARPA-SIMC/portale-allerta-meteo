/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.previsioni.meteo.service.impl;

import com.liferay.portal.aop.AopService;


import com.liferay.portal.kernel.exception.SystemException;

import it.eng.previsioni.meteo.exception.NoSuchBollettinoException;
import it.eng.previsioni.meteo.model.Bollettino;
import it.eng.previsioni.meteo.service.base.BollettinoLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=it.eng.previsioni.meteo.model.Bollettino",
	service = AopService.class
)
public class BollettinoLocalServiceImpl extends BollettinoLocalServiceBaseImpl {


	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.previsioni.meteo.service.BollettinoLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.previsioni.meteo.service.BollettinoLocalServiceUtil</code>.
	 */
	
	public Bollettino findByTipo(String currentType){
		try {
			Bollettino result = bollettinoPersistence.findBytipo(currentType);
			return result;
		} catch (NoSuchBollettinoException | SystemException e) {
			return null;
		}
	}

	public Bollettino findByID(long id){
		// TODO Auto-generated method stub
		try {
			return bollettinoPersistence.fetchByPrimaryKey(id);
		} catch (SystemException e) {
			return null;
		}
	}
}