/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service.impl;

import com.liferay.portal.aop.AopService;

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


import org.osgi.service.component.annotations.Component;

/**
 * @author Pratola_L
 */
@Component(
	property = {
		"json.web.service.context.name=rubrica",
		"json.web.service.context.path=RubricaCategoria"
	},
	service = AopService.class
)
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