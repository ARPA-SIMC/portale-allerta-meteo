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

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import it.eng.allerte.custom.interfaces.IRubricaRestConstants;
import it.eng.allerte.custom.jsonRubrica.Log;
import it.eng.allerte.service.RubricaLogLocalServiceUtil;
import it.eng.allerte.service.RubricaUtenteSitoLocalServiceUtil;
import it.eng.allerte.service.base.RubricaLogServiceBaseImpl;
import it.eng.allerte.service.persistence.RubricaLogUtil;
import it.eng.rubrica.service.util.GestioneRubricaCustomService;

/**
 * The implementation of the rubrica log remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.allerte.service.RubricaLogService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaLogServiceBaseImpl
 */
public class RubricaLogServiceImpl extends RubricaLogServiceBaseImpl implements IRubricaRestConstants {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>it.eng.allerte.service.RubricaLogServiceUtil</code> to access the rubrica log remote service.
	 */
	public Map<String,Object> getLogs(String name, int limit, int offset){
		
		Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
		Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		mappa =	loadLogs(userId, idSite, name, limit, offset);
		
	
		return mappa;
	}

	
	/**
	 * 
	 * @param userId
	 * @param groupId
	 * @param name
	 * @param limit
	 * @param offset
	 * @return
	 */
	private Map<String, Object> loadLogs(long userId, long groupId, String name, int limit, int offset) {
			
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		List<Log> listaLog = null;
		
		try {
		   GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, groupId);
		   listaLog = gestRubrica.loadLogs(name, new Long(limit), new Long(offset));
			 
		   if(null == listaLog) {
			   mappa.put(CODE, 404);
			   mappa.put(ERROR, "nessun risultato");
		   } else {
				   mappa.put(CODE, 200);
				   mappa.put(DATA, listaLog);
				   mappa.put(LIMIT, limit);
				   mappa.put(OFFSET, offset);
				   //Se ho impostato il nome devo contatre tutti quelli per il nome altrimenti conta tutto
				   if(StringUtils.isNotBlank(name)) {
					   mappa.put(TOTAL, RubricaLogLocalServiceUtil.getLogByNameTable(name, groupId, new Long (-1), new Long(-1)).size());
				   } else {
					   mappa.put(TOTAL, RubricaLogUtil.findByRubricaLogBySitoProprietario(groupId, -1, -1).size() ) ;
				   }
		   }
			   
		} catch (SystemException | PortalException | JsonProcessingException | ParseException e) {
		   mappa.put(CODE, 400);
		   mappa.put(ERROR, GENERIC_ERROR);
		}
		
		return mappa;
	}
}