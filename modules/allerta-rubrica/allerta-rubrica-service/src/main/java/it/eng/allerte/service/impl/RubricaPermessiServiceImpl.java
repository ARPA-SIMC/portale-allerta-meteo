/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.eng.allerte.custom.interfaces.IRubricaRestConstants;
import it.eng.allerte.custom.jsonRubrica.Permission;
import it.eng.allerte.service.RubricaUtenteSitoLocalServiceUtil;
import it.eng.allerte.service.base.RubricaPermessiServiceBaseImpl;
import it.eng.rubrica.service.util.GestioneRubricaCustomService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Pratola_L
 */
@Component(
	property = {
		"json.web.service.context.name=rubrica",
		"json.web.service.context.path=RubricaPermessi"
	},
	service = AopService.class
)
public class RubricaPermessiServiceImpl extends RubricaPermessiServiceBaseImpl implements IRubricaRestConstants {
	

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>it.eng.allerte.service.RubricaPermessiServiceUtil</code> to access the rubrica permessi remote service.
	 */
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String,Object> getPermission(){

		Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
		Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
		
				
		Map<String,Object> mappa = new HashMap<String, Object>();
			
		mappa = loadPermessi(userId, idSite);

		return mappa;
	}

	
	private Map<String, Object> loadPermessi(Long userId, Long idSite) {
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		List<Permission> listPermission;
		
		try {
		   GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, idSite);
		   listPermission = gestRubrica.loadPermission();
		  
		   if(null == listPermission || listPermission.isEmpty() ) {
			   mappa.put(CODE, 404);
			   mappa.put(ERROR, "permessi non presenti");
		   } else {
			   mappa.put(CODE, 200);
			   mappa.put(DATA, listPermission);
		   }
   
		} catch (SystemException e) {
		   //Se ho un errore setto il codice e il messaggio
		   mappa.put(CODE, 400);
		   mappa.put(ERROR, GENERIC_ERROR);
		}
		
		return mappa;
	}
}