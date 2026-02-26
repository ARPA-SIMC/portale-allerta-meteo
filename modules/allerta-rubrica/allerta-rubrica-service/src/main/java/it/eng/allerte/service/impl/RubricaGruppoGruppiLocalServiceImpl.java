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

import it.eng.allerte.exception.NoSuchRubricaGruppoException;
import it.eng.allerte.model.RubricaGruppo;
import it.eng.allerte.model.RubricaGruppoGruppi;
import it.eng.allerte.service.base.RubricaGruppoGruppiLocalServiceBaseImpl;
import it.eng.allerte.service.persistence.RubricaGruppoGruppiPK;

import org.osgi.service.component.annotations.Component;

/**
 * @author Pratola_L
 */
@Component(
	property = "model.class.name=it.eng.allerte.model.RubricaGruppoGruppi",
	service = AopService.class
)
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