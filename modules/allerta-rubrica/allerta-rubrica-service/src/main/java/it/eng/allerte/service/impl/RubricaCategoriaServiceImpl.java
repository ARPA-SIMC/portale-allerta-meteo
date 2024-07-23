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

package it.eng.allerte.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.eng.allerte.model.RubricaCategoria;
import it.eng.allerte.service.RubricaCategoriaLocalServiceUtil;
import it.eng.allerte.service.base.RubricaCategoriaServiceBaseImpl;

import it.eng.allerte.custom.interfaces.IRubricaRestConstants;

/**
 * The implementation of the rubrica categoria remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.allerte.service.RubricaCategoriaService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaCategoriaServiceBaseImpl
 */
public class RubricaCategoriaServiceImpl
	extends RubricaCategoriaServiceBaseImpl implements IRubricaRestConstants {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>it.eng.allerte.service.RubricaCategoriaServiceUtil</code> to access the rubrica categoria remote service.
	 */
	
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String,Object> getCategorie() {
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		try {
			List<RubricaCategoria> rc = RubricaCategoriaLocalServiceUtil.getRubricaCategorias(-1, -1);
		
			mappa.put(CODE, 200);
			mappa.put(DATA, rc);
		} catch (Exception e) {
			//logger.error("Errore in fase di caricamento gruppi", e);
			mappa.put(CODE, 400);
			mappa.put(ERROR, GENERIC_ERROR);
		}
		
		return mappa;
	}
}