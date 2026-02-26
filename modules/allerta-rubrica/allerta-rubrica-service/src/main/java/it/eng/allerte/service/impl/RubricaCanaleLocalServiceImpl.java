/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service.impl;

import com.liferay.portal.aop.AopService;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.eng.allerte.exception.NoSuchRubricaCanaleException;
import it.eng.allerte.model.RubricaCanale;
import it.eng.allerte.service.base.RubricaCanaleLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Pratola_L
 */
@Component(
	property = "model.class.name=it.eng.allerte.model.RubricaCanale",
	service = AopService.class
)
public class RubricaCanaleLocalServiceImpl
	extends RubricaCanaleLocalServiceBaseImpl {
	
	

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.allerte.service.RubricaCanaleLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.allerte.service.RubricaCanaleLocalServiceUtil</code>.
	 */
	
	private Log logger = LogFactoryUtil.getLog(RubricaCanaleLocalServiceImpl.class);
	
	//Integrazione con sistema allertamento
		/**
		 * Il metodo ritorna la lista dei tipi di canali della rubrica (cell, mail, telefono)
		 * 
		 */
		public List<RubricaCanale> getRubricaCanali() {
		
			List<RubricaCanale> listaRubricaCanale = new ArrayList<>();
			
			try {
				listaRubricaCanale = rubricaCanalePersistence.findAll();
			} catch (SystemException e) {
				logger.error("Errore nel caricamento della lista canali", e);
			}
					
			return listaRubricaCanale;
					
		}
		
		/**
		 * Il metodo ritorna la descrizione del canale
		 * 
		 * @param idCanale
		 * @return
		 */
		public String getDescrRubricaCanale(long idCanale) {
			
			String descrCanale = null;	
			
			try {
				descrCanale = rubricaCanalePersistence.findByPrimaryKey(idCanale).getNOME();
			} catch (NoSuchRubricaCanaleException e) {
				logger.error("Canale non presente", e);
			} catch (SystemException e) {
				logger.error("Errore nel caricamento della descrizione canale", e);
			}				
			return descrCanale;
					
		}
}