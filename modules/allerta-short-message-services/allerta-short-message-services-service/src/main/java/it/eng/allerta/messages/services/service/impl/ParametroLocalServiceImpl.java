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

package it.eng.allerta.messages.services.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import it.eng.allerta.messages.services.model.Parametro;
import it.eng.allerta.messages.services.service.base.ParametroLocalServiceBaseImpl;

/**
 * The implementation of the parametro local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.allerta.messages.services.service.ParametroLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Giorgianni_F
 * @see ParametroLocalServiceBaseImpl
 */
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