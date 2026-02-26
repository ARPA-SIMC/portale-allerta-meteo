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
import it.eng.allerte.custom.jsonRubrica.Channel;
import it.eng.allerte.service.RubricaUtenteSitoLocalServiceUtil;
import it.eng.allerte.service.base.RubricaCanaleServiceBaseImpl;
import it.eng.rubrica.service.util.GestioneRubricaCustomService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Pratola_L
 */
@Component(
	property = {
		"json.web.service.context.name=rubrica",
		"json.web.service.context.path=RubricaCanale"
	},
	service = AopService.class
)
public class RubricaCanaleServiceImpl extends RubricaCanaleServiceBaseImpl  implements IRubricaRestConstants  {


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