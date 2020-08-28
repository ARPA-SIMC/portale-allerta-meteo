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

package it.eng.radarMeteo.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.eng.radarMeteo.model.Comuni_bacini_ws;
import it.eng.radarMeteo.service.base.Comuni_bacini_wsLocalServiceBaseImpl;

/**
 * The implementation of the comuni_bacini_ws local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.radarMeteo.service.Comuni_bacini_wsLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Francesco
 * @see Comuni_bacini_wsLocalServiceBaseImpl
 */
public class Comuni_bacini_wsLocalServiceImpl
	extends Comuni_bacini_wsLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.radarMeteo.service.Comuni_bacini_wsLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.radarMeteo.service.Comuni_bacini_wsLocalServiceUtil</code>.
	 */
	
	private final Log _log = LogFactoryUtil.getLog(Comuni_bacini_wsLocalServiceImpl.class);
	
	public List<Comuni_bacini_ws> findByBacino(String bacino){
		try {
			return comuni_bacini_wsPersistence.findByBacino(bacino);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			_log.error(e);
		}
		return null;
	}
}