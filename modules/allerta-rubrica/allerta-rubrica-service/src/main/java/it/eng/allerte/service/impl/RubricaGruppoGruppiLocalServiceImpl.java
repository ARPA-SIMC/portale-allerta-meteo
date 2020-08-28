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

import it.eng.allerte.exception.NoSuchRubricaGruppoException;
import it.eng.allerte.model.RubricaGruppo;
import it.eng.allerte.model.RubricaGruppoGruppi;
import it.eng.allerte.service.base.RubricaGruppoGruppiLocalServiceBaseImpl;
import it.eng.allerte.service.persistence.RubricaGruppoGruppiPK;

/**
 * The implementation of the rubrica gruppo gruppi local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.allerte.service.RubricaGruppoGruppiLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaGruppoGruppiLocalServiceBaseImpl
 */
public class RubricaGruppoGruppiLocalServiceImpl
	extends RubricaGruppoGruppiLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.allerte.service.RubricaGruppoGruppiLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.allerte.service.RubricaGruppoGruppiLocalServiceUtil</code>.
	 */
	
	private Log logger = LogFactoryUtil.getLog(RubricaGruppoGruppiLocalServiceImpl.class);
	
	//Integrazione con sistema di allertamento
		/**
		 * Il metodo restituisce la lista dei sottogruppi per l'id gruppo passato come parametro
		 * 
		 * @param idGroup
		 * @return
		 */
		public List<RubricaGruppo> getSubGroups(long idGroup) {
			
			List<RubricaGruppo> listSubGroups = new ArrayList<>();
			
			List<Object[]> listSubGroupsObj = rubricaGruppoGruppiFinder.getGruppiFigli(idGroup);
			
			if(null != listSubGroupsObj) {
				
				for (Object[] objectsSubGruop : listSubGroupsObj) {
				
					RubricaGruppoGruppiPK pk = new RubricaGruppoGruppiPK(
							(long) objectsSubGruop[0], (long)objectsSubGruop[1]);
					RubricaGruppoGruppi gruppoGruppi = fetchRubricaGruppoGruppi(pk); 
							//new RubricaGruppoGruppiImpl();
					//gruppoGruppi.setFK_GRUPPO_PADRE((long) objectsSubGruop[0]);
					//gruppoGruppi.setFK_GRUPPO_FIGLIO((long)objectsSubGruop[1]);
			
							
					//recupera le info del gruppo (passando gruppoGruppi.getFK_GRUPPO_FIGLIO)
					RubricaGruppo subGroup = null;
					try {
						subGroup = rubricaGruppoPersistence.findByPrimaryKey(gruppoGruppi.getFK_GRUPPO_FIGLIO());
						listSubGroups.add(subGroup);
					} catch (NoSuchRubricaGruppoException e) {
						logger.error("Errore gruppo figlio non presente", e);
					} catch (SystemException e) {
						logger.error("Errore nel caricamento delle info gruppo figlio", e);
					}
				}
			}			
			
			return listSubGroups;
					
		}

		public ArrayList<Object[]> getGruppiFigli(Long fkGruppoPadre) {
			return rubricaGruppoGruppiFinder.getGruppiFigli(fkGruppoPadre);
		}
		
		public ArrayList<Object[]> getGruppiPadriPerFiglio(Long fkGruppoPadre) {
			return rubricaGruppoGruppiFinder.getGruppiPadriPerFiglio(fkGruppoPadre);
		}
		
		public void deleteGruppoSottoGruppo(Long fkGruppo, Long fkSottoGruppo) {
			rubricaGruppoGruppiFinder.deleteGruppoSottoGruppo(fkGruppo, fkSottoGruppo);
		}

}