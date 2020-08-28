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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;

import it.eng.allerta.utils.AllertaLegacy;
import it.eng.allerte.exception.NoSuchRubricaNominativoException;
import it.eng.allerte.model.RubricaGruppoNominativi;
import it.eng.allerte.model.RubricaNominativo;
import it.eng.allerte.service.base.RubricaGruppoNominativiLocalServiceBaseImpl;

/**
 * The implementation of the rubrica gruppo nominativi local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.allerte.service.RubricaGruppoNominativiLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaGruppoNominativiLocalServiceBaseImpl
 */
public class RubricaGruppoNominativiLocalServiceImpl
	extends RubricaGruppoNominativiLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.allerte.service.RubricaGruppoNominativiLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.allerte.service.RubricaGruppoNominativiLocalServiceUtil</code>.
	 */
	
	private Log logger = LogFactoryUtil.getLog(RubricaGruppoNominativiLocalServiceImpl.class);
	
	//Integrazione con sistema di allertamento
		/**
		 * restituisci i nominvativi associati a un gruppo
		 * 
		 * 
		 * @param ownerId
		 * @param groupId
		 * @return
		 */
		public Set<RubricaNominativo> getNominativeForGroup(Long ownerId, Long groupId){
			
			//uso in set per evitare duplicati che potrebberi esserci se l'user ha due ruoli diversi sullo stesso gruppo
			Set<RubricaNominativo> listaRubricaNominativiResult = new HashSet<>();
			try {
			
				List<Object[]> listaGruppoNominativi = 
						rubricaGruppoNominativiFinder.loadNominativiGruppo(groupId, ownerId);
						
				if(null != listaGruppoNominativi) {
				
					for (Object[] objectsGruop : listaGruppoNominativi) {
				
						try {
							RubricaNominativo rubricaNominativo = 
									rubricaNominativoPersistence.findByPrimaryKey((long) objectsGruop[1]);
							listaRubricaNominativiResult.add(rubricaNominativo);
						} catch (NoSuchRubricaNominativoException | SystemException e) {
							logger.error("Nominativo non presente", e);
						}
						
					}
				}
			} catch(Exception e){
				logger.error("Errore caricamento nominativi per gruppo" , e);
			}
				
			return listaRubricaNominativiResult;
			
		}
		
		/**
		 * Il metodo ritorna le info di un nominativo iscrittto al portale per il sito proprietario
		 * 
		 * @param ownerId
		 * @return
		 */
		public List<RubricaNominativo> getNominativeForGroupPortal(Long ownerId){
			
			List<RubricaNominativo> listaRubricaNominativiResult = new ArrayList<>();
			
			try {
				//Carico gli utenti per il gruppo proprietario con ruolo CITTADINO
				Role role = null;
				try {
					role = RoleLocalServiceUtil.getRole(20154, 
							AllertaLegacy.DESCRIZIONE_ROLE_CITTADINO);
				} catch (PortalException e) {
					logger.error(e);
				}
				if(role==null){
					logger.error("Ruolo non trovato");
					return null;
				}
				//List<UserGroupRole> userGroupRolesByGroupAndRole = UserGroupRoleUtil.findByG_R(idSite, role.getRoleId());
				//List<UserGroupRole> userGroupRolesByGroupAndRole = UserGroupRoleLocalServiceUtil.getUserGroupRolesByGroupAndRole(idSite, role.getRoleId());
				List<User> listaUser = userLocalService.getGroupUsers(ownerId);
				List<User> listaUserFinal = new ArrayList<>();
				//Filtro per i cittadini
				for(User user : listaUser){
					for(Long roleId : user.getRoleIds()) {
						if(roleId.longValue() == role.getRoleId()) {
							//E' un cittadino lo aggiungo
							listaUserFinal.add(user);
						}
					}
				}
				for (User userGroup : listaUserFinal) {
					
					
					RubricaNominativo nominativo = 
							rubricaNominativoPersistence.fetchByPrimaryKey(userGroup.getUserId()) ;
							//new RubricaNominativoImpl();									
					//nominativo.setID_NOMINATIVO(userGroup.getUserId());
					nominativo.setCOGNOME(userGroup.getLastName());
					nominativo.setNOME(userGroup.getFirstName());
					nominativo.setFK_SITO_PROPRIETARIO(ownerId);
					if(null != userGroup.getAddresses() && ! userGroup.getAddresses().isEmpty()) {
						nominativo.setINDIRIZZO(null != userGroup.getAddresses().get(0).getStreet1() ? userGroup.getAddresses().get(0).getStreet1() : null);
					}
						
					listaRubricaNominativiResult.add(nominativo);
				}
			
			
			} catch (SystemException e) {
				logger.error("Errore caricamento utenti portale", e);
			} 
								
			return listaRubricaNominativiResult;
			
		}
		
		public List<Object[]> loadNominativiGruppo(Long idGruppo, Long idSite) {
			return rubricaGruppoNominativiFinder.loadNominativiGruppo(idGruppo, idSite);
		}
		
		public void deleteNominativoDaGruppo(Long fkGruppo, Long fkNominativo) {
			rubricaGruppoNominativiFinder.deleteNominativoDaGruppo(fkGruppo, fkNominativo);
		}
		
		public List<Object[]> loadByidRuolo(Long idRuolo) {
			return rubricaGruppoNominativiFinder.loadByidRuolo(idRuolo);
		}
		
		public List<RubricaGruppoNominativi> findByRubricaGruppoRuoloByNominativo(Long idNominativo) {
			return rubricaGruppoNominativiPersistence.findByRubricaGruppoRuoloByNominativo(idNominativo);
		}
		
		
}