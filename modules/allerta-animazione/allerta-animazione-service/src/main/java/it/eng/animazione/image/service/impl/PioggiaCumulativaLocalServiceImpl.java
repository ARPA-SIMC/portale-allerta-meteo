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

package it.eng.animazione.image.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import it.eng.animazione.image.exception.NoSuchPioggiaCumulativaException;
import it.eng.animazione.image.model.PioggiaCumulativa;
import it.eng.animazione.image.service.base.PioggiaCumulativaLocalServiceBaseImpl;

/**
 * The implementation of the pioggia cumulativa local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.animazione.image.service.PioggiaCumulativaLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author UTENTE
 * @see PioggiaCumulativaLocalServiceBaseImpl
 */
public class PioggiaCumulativaLocalServiceImpl
	extends PioggiaCumulativaLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.animazione.image.service.PioggiaCumulativaLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.animazione.image.service.PioggiaCumulativaLocalServiceUtil</code>.
	 */
	
	public PioggiaCumulativa findByID(long id) 
			throws NoSuchPioggiaCumulativaException, SystemException {
		PioggiaCumulativa result = pioggiaCumulativaPersistence.findByPrimaryKey(id);
		return result;
	}
	
	public List<PioggiaCumulativa> findByCumulazione(String cumulazione)
			throws NoSuchPioggiaCumulativaException, SystemException {
		 List<PioggiaCumulativa> result = pioggiaCumulativaPersistence.findByCumulazione(cumulazione);
		return result;
	}
}