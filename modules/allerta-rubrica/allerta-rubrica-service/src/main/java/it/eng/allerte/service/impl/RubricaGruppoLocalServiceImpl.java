/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service.impl;

import com.liferay.portal.aop.AopService;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.eng.allerte.model.RubricaGruppo;
import it.eng.allerte.service.base.RubricaGruppoLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Pratola_L
 */
@Component(
	property = "model.class.name=it.eng.allerte.model.RubricaGruppo",
	service = AopService.class
)
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
		
		public ArrayList<Object[]> getGruppiByNameCategoria(Long site, String groupName, Long categoria, Long limit, Long offset) {
			return rubricaGruppoFinder.getGruppiByNameCategory(site, groupName, categoria, limit, offset);
		}
		
		public List<Object[]> getGroup(Long id) {
			return rubricaGruppoFinder.getGroup(id);
		}
		
		public void aggiornaTuttoGruppo(Long gruppo) {
			rubricaGruppoFinder.aggiornaTuttoGruppo(gruppo);
		}
		
		public ArrayList<Object[]> getGerarchia(Long site) {
			return rubricaGruppoFinder.getGerarchia(site);
		}
}