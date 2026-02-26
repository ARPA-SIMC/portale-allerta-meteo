/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.service.impl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import it.eng.allerta.messages.services.model.Parametro;
import it.eng.allerta.messages.services.service.base.ParametroLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

/**
 * @author Giorgianni_F
 */
@Component(
	property = "model.class.name=it.eng.allerta.messages.services.model.Parametro",
	service = AopService.class
)
public class ParametroLocalServiceImpl extends ParametroLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.allerta.messages.services.service.ParametroLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.allerta.messages.services.service.ParametroLocalServiceUtil</code>.
	 */
	
	public List<Parametro> findBynodo(String nodo) throws SystemException {
		return parametroPersistence.findBynodo(nodo);
	}
	
	public void resetSMSFaseTwo(){
		parametroFinder.resetSMSFaseTwo();
	}
	
	public void resetSMSFaseThree(){
		parametroFinder.resetSMSFaseThree();
	}
	
	public List<Long> fetchSmsStatoTre(){
		List<Long> fetchSmsStatoTre = parametroFinder.fetchSmsStatoTre();
		return fetchSmsStatoTre;
	}

}