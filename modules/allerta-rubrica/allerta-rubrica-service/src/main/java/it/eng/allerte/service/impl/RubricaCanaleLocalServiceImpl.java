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
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.eng.allerte.exception.NoSuchRubricaCanaleException;
import it.eng.allerte.model.RubricaCanale;
import it.eng.allerte.service.base.RubricaCanaleLocalServiceBaseImpl;

/**
 * The implementation of the rubrica canale local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.allerte.service.RubricaCanaleLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaCanaleLocalServiceBaseImpl
 */
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