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


import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.eng.allerte.custom.interfaces.IRubricaRestConstants;
import it.eng.allerte.custom.jsonRubrica.Channel;
import it.eng.allerte.service.RubricaUtenteSitoLocalServiceUtil;
import it.eng.allerte.service.base.RubricaCanaleServiceBaseImpl;
import it.eng.rubrica.service.util.GestioneRubricaCustomService;

/**
 * The implementation of the rubrica canale remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.allerte.service.RubricaCanaleService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaCanaleServiceBaseImpl
 */
public class RubricaCanaleServiceImpl extends RubricaCanaleServiceBaseImpl implements IRubricaRestConstants {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>it.eng.allerte.service.RubricaCanaleServiceUtil</code> to access the rubrica canale remote service.
	 */
	
	/*
	 * NON IMPORTO I SORGENTI DAL VECCHIO PROGETTO, OCCORRE RIVALUTARE LA FUNZIONALITA'
	 */
	
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String,Object> getChannels(){
		
		Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
		Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
			
		Map<String,Object> mappa = new HashMap<String, Object>();
		

		mappa = loadChannels(userId, idSite);


		return mappa;
	}
	
	private Map<String, Object> loadChannels(long userId, long groupId) {
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		List<Channel> listChannel;
		
		try {
		   GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, groupId);
		   listChannel = gestRubrica.loadChannels();
		  
		   if(null == listChannel || listChannel.isEmpty() ) {
			   mappa.put(CODE, 404);
			   mappa.put(ERROR, "canali non presenti");
		   } else {
			   mappa.put(CODE, 200);
			   mappa.put(DATA, listChannel);
		   }
   
		} catch (SystemException e) {
		    //logger.error("Errore in fase di caricamento canali", e);
			//Se ho un errore setto il codice e il messaggio
		    mappa.put(CODE, 400);
			mappa.put(ERROR, GENERIC_ERROR);
		}
		
		return mappa;
	}
	
}