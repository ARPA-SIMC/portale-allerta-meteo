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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.eng.allerte.model.RubricaGruppo;
import it.eng.allerte.service.base.RubricaGruppoLocalServiceBaseImpl;

/**
 * The implementation of the rubrica gruppo local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.allerte.service.RubricaGruppoLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaGruppoLocalServiceBaseImpl
 */
public class RubricaGruppoLocalServiceImpl
	extends RubricaGruppoLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.allerte.service.RubricaGruppoLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.allerte.service.RubricaGruppoLocalServiceUtil</code>.
	 */
	
	private Log logger = LogFactoryUtil.getLog(RubricaGruppoLocalServiceImpl.class);
	
	
	//Integrazione con sistema allertamento
		/**
		 * 
		 * Il metodo restituisce le info sul gruppo a partire dal nome e per il sito proprietario
		 * 
		 */
		public RubricaGruppo getGroupForOwnerByName(Long ownerId, String groupName){
			
			RubricaGruppo gruppoResult = null;
			
			try {
			
				Object[] gruppo = rubricaGruppoFinder.getGruppiByOwnerAndName(ownerId, groupName);
				
				if( null != gruppo) {
					
					gruppoResult = fetchRubricaGruppo((long)gruppo[0]);
//							new RubricaGruppoImpl();
	//				gruppoResult.setID_GRUPPO((long)gruppo[0]);
					gruppoResult.setNOME((String) gruppo[1]);
					gruppoResult.setFK_SITO_PROPRIETARIO((long) gruppo[2]);
					gruppoResult.setNOTE((String) gruppo[3]);
					gruppoResult.setFK_UTENTE_CREAZIONE((long) gruppo[4]);
					gruppoResult.setDATA_CREAZIONE((Date) gruppo[5]);
					gruppoResult.setFK_UTENTE_MODIFICA((long) gruppo[6]);
					gruppoResult.setDATA_MODIFICA((Date) gruppo[7]);
					gruppoResult.setDISABLED((boolean)gruppo[8]);
						
				} 
			} 
			catch(Exception e) {
				logger.error("Errore caricamento gruppo", e);
			}
						
			return gruppoResult;
				
		}

		
		public Object[] getGruppiByOwnerAndName(Long idOwner, String groupName) {
			return rubricaGruppoFinder.getGruppiByOwnerAndName(idOwner, groupName);
		}
		
		public ArrayList<Object[]> getGruppiByName(Long site, String groupName, Long limit, Long offset) {
			return rubricaGruppoFinder.getGruppiByName(site, groupName, limit, offset);
		}
		
		public List<Object[]> getGroup(Long id) {
			return rubricaGruppoFinder.getGroup(id);
		}
		
		public void aggiornaTuttoGruppo(Long gruppo) {
			rubricaGruppoFinder.aggiornaTuttoGruppo(gruppo);
		}
		
}