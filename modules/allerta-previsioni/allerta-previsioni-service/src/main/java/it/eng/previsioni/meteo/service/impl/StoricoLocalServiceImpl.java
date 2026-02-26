/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.previsioni.meteo.service.impl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import it.eng.previsioni.meteo.model.Storico;
import it.eng.previsioni.meteo.service.base.StoricoLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=it.eng.previsioni.meteo.model.Storico",
	service = AopService.class
)
public class StoricoLocalServiceImpl extends StoricoLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.previsioni.meteo.service.StoricoLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.previsioni.meteo.service.StoricoLocalServiceUtil</code>.
	 */
	
	public List<Storico> getStoricoBySigla(String sigla){
		try {
			List<Storico> storicoList = storicoPersistence.findBySigla(sigla);
			return storicoList;
		} catch (SystemException e) {
			return null;
		}
		
	}

}