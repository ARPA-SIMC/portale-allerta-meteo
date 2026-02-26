/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service.impl;

import com.liferay.portal.aop.AopService;

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

import org.osgi.service.component.annotations.Component;

/**
 * @author Pratola_L
 */
@Component(
	property = {
		"json.web.service.context.name=rubrica",
		"json.web.service.context.path=RubricaLog"
	},
	service = AopService.class
)
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