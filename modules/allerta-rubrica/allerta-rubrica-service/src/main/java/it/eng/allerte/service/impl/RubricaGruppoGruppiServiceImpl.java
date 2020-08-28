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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.eng.allerte.custom.interfaces.IRubricaRestConstants;
import it.eng.allerte.exception.NoSuchRubricaGruppoException;
import it.eng.allerte.model.RubricaGruppo;
import it.eng.allerte.model.RubricaGruppoGruppi;
import it.eng.allerte.model.impl.RubricaGruppoGruppiImpl;
import it.eng.allerte.model.impl.RubricaGruppoImpl;
import it.eng.allerte.service.RubricaGruppoGruppiLocalServiceUtil;
import it.eng.allerte.service.RubricaUtenteSitoLocalServiceUtil;
import it.eng.allerte.service.base.RubricaGruppoGruppiServiceBaseImpl;
import it.eng.allerte.service.persistence.RubricaGruppoGruppiUtil;
import it.eng.allerte.service.persistence.RubricaGruppoUtil;
import it.eng.rubrica.service.util.GestioneRubricaCustomService;

/**
 * The implementation of the rubrica gruppo gruppi remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.allerte.service.RubricaGruppoGruppiService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaGruppoGruppiServiceBaseImpl
 */
public class RubricaGruppoGruppiServiceImpl
	extends RubricaGruppoGruppiServiceBaseImpl implements IRubricaRestConstants {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>it.eng.allerte.service.RubricaGruppoGruppiServiceUtil</code> to access the rubrica gruppo gruppi remote service.
	 */
	//POST - DELETE - PUT - GET  gruppo-nominativo
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
		public Map<String,Object> updateGroupSubgroups(int id, String data){
				
			Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
			Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
					
			Map<String,Object> mappa = new HashMap<String, Object>();
				
			
			mappa = updateGruppoSottoGruppo(userId, idSite, id, data);
			 
		
			return mappa;
		}
		
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
		public Map<String,Object> deleteGroupSubgroups(int id, String data){
			
			Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
			Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
					
			Map<String,Object> mappa = new HashMap<String, Object>();
				
			
			mappa = deleteGruppoSottoGruppo(userId, idSite, id, data); 
		
			return mappa;
		}
		
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
		public Map<String,Object> addGroupSubgroups(int id, String data){
			
			Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
			Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
					
			Map<String,Object> mappa = new HashMap<String, Object>();
				
			mappa = associaGruppoSottoGruppo(userId, idSite, id, data);
			
		
			return mappa;
		}


		//POST - DELETE - PUT - GET  gruppo-nominativo
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
		public Map<String,Object> deleteGroupMultiSubgroups(int id, String data){
					
			Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
			Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
				
			Map<String,Object> mappa = new HashMap<String, Object>();

			mappa = deleteGruppoSottoGruppoMulti(userId, idSite, id, data); 
			
			return mappa;
		}
		
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
		public Map<String,Object> addGroupMultiSubgroups(int id,String data){
			
			Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
			Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
				
			Map<String,Object> mappa = new HashMap<String, Object>();
					
			mappa = associaGruppoSottoGruppoMulti(userId, idSite, id, data);	 
			
			return mappa;
		}
		
		//POST - DELETE - PUT - GET  gruppo-nominativo
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
		public Map<String,Object> deleteGroupMultiSupergroups(int id, String data){
						
				Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
				Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
					
				Map<String,Object> mappa = new HashMap<String, Object>();

				mappa = deleteGruppoSuperGruppoMulti(userId, idSite, id, data);	 
				
				return mappa;
			}
		
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
		public Map<String,Object> addGroupMultiSupergroups(int id,String data){
			
			Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
			Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
				
			Map<String,Object> mappa = new HashMap<String, Object>();
			
			mappa = associaGruppoSuperGruppoMulti(userId, idSite, id, data);
 
			return mappa;
		}
		
		
		
		private Map<String, Object> deleteGruppoSottoGruppoMulti(Long userId, Long idSite, int id, String data) {
			
			Map<String,Object> mappa = new HashMap<String, Object>();
			
			try {
				
				GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, idSite);
			    List<Long> listaAssociationDeleteError = gestRubrica.cancellaGruppoSottoGruppoMulti(idSite, new Long(id), data);
				if(listaAssociationDeleteError.isEmpty())   { 
				    mappa.put(CODE, 200);
				    mappa.put(SUCCESS, "cancellazione avvenuta con successo");
				}
				else {
				    mappa.put(CODE, 404);
				    mappa.put(ERROR, listaAssociationDeleteError);
				}
								
			} catch (SystemException | IOException e) {
				//logger.error("Errore in fase di associazione gruppo sottoGruppo", e);
			    mappa.put(CODE, 400);
				mappa.put(ERROR, GENERIC_ERROR);
			}
			
			return mappa;
		}
		
		private Map<String, Object> deleteGruppoSuperGruppoMulti(Long userId, Long idSite, int id, String data) {
			
			Map<String,Object> mappa = new HashMap<String, Object>();
			
			try {
				
				GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, idSite);
			    List<Long> listaAssociationDeleteError = gestRubrica.cancellaGruppoSuperGruppoMulti(idSite, new Long(id), data);
				if(listaAssociationDeleteError.isEmpty())   { 
				    mappa.put(CODE, 200);
				    mappa.put(SUCCESS, "cancellazione avvenuta con successo");
				}
				else {
				    mappa.put(CODE, 404);
				    mappa.put(ERROR, listaAssociationDeleteError);
				}
								
			} catch (SystemException | IOException e) {
				//logger.error("Errore in fase di associazione gruppo sottoGruppo", e);
			    mappa.put(CODE, 400);
				mappa.put(ERROR, GENERIC_ERROR);
			}
			
			return mappa;
		}


		private Map<String, Object> associaGruppoSottoGruppoMulti(Long userId, Long idSite, int id, String data) {
			
			Map<String,Object> mappa = new HashMap<String, Object>();
			
			try {
				
				GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, idSite);
			    List<Long> listaAssociationError = gestRubrica.associaGruppoSottoGruppoMulti(idSite, new Long(id), data);
				if(listaAssociationError.isEmpty())   { 
				    mappa.put(CODE, 200);
				    mappa.put(SUCCESS, "associazione avvenuta con successo");
				}
				else {
				    mappa.put(CODE, 404);
				    mappa.put(ERROR, listaAssociationError);
				}
								
			} catch (SystemException | IOException e) {
				//logger.error("Errore in fase di associazione gruppo sottoGruppo", e);
			    mappa.put(CODE, 400);
				mappa.put(ERROR, GENERIC_ERROR);
			}
			
			return mappa;
		}
		
		private Map<String, Object> associaGruppoSuperGruppoMulti(Long userId, Long idSite, int id, String data) {
			
			Map<String,Object> mappa = new HashMap<String, Object>();
			
			try {
				
				GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, idSite);
			    List<Long> listaAssociationError = gestRubrica.associaGruppoSuperGruppoMulti(idSite, new Long(id), data);
				if(listaAssociationError.isEmpty())   { 
				    mappa.put(CODE, 200);
				    mappa.put(SUCCESS, "associazione avvenuta con successo");
				}
				else {
				    mappa.put(CODE, 404);
				    mappa.put(ERROR, listaAssociationError);
				}
								
			} catch (SystemException | IOException e) {
				//logger.error("Errore in fase di associazione gruppo sottoGruppo", e);
			    mappa.put(CODE, 400);
				mappa.put(ERROR, GENERIC_ERROR);
			}
			
			return mappa;
		}


		/**
		 * 
		 * @param idSite 
		 * @param userId 
		 * @param id
		 * @param data
		 * @return
		 */
		private Map<String, Object> associaGruppoSottoGruppo(long userId, long idSite, int id, String data) {
			
			Map<String,Object> mappa = new HashMap<String, Object>();
			
			try {
				
				GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, idSite);
			    boolean isValidAssociation = gestRubrica.associaGruppoSottoGruppo(idSite, new Long(id), data);
				if(isValidAssociation)   { 
				    mappa.put(CODE, 200);
				    mappa.put(SUCCESS, "associazione avvenuta con successo");
				}
				else {
				    mappa.put(CODE, 404);
				    mappa.put(ERROR, "associazione non consentita");
				}
								
			} catch (SystemException | IOException e) {
				//logger.error("Errore in fase di associazione gruppo sottoGruppo", e);
			    mappa.put(CODE, 400);
				mappa.put(ERROR, GENERIC_ERROR);
			}
			
			return mappa;
			

		}

		/**
		 * 
		 * @param groupId 
		 * @param userId 
		 * @param id
		 * @param data
		 * @return
		 */
		private Map<String, Object> deleteGruppoSottoGruppo(long userId, long groupId, int id, String data) {
			
			Map<String,Object> mappa = new HashMap<String, Object>();
			
			GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, groupId);
			
			try {
				mappa = gestRubrica.eliminaGruppoSottoGruppo(new Long(id), data);
			} catch (SystemException | IOException e) {
				//logger.error("Errore in fase di cancellazione relazione gruppo sottoGruppo", e);
				mappa.put(CODE, 400);
				mappa.put(ERROR, GENERIC_ERROR);
			}
			
			return mappa;
		}
		
		/**
		 * 
		 * @param userId
		 * @param scopeGroupId
		 * @param id
		 * @param string
		 * @return
		 */
		private Map<String, Object> updateGruppoSottoGruppo(long userId, long groupId, int id,	String data) {

			Map<String,Object> mappa = new HashMap<String, Object>();
			
			GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, groupId);
		
			try {
				
				mappa = gestRubrica.aggiornaGruppoSottoGruppo(id, data);
		
			} catch (IOException | SystemException | PortalException e) {
				//logger.error("Errore in fase di aggiornamento relazione gruppo sottoGruppo", e);
				mappa.put(CODE, 400);
				mappa.put(ERROR, GENERIC_ERROR);
			}
			
			return mappa;
		}
				
		//Integrazione con sistema di allertamento
		/**
		 * Il metodo restituisce la lista dei sottogruppi per l'id gruppo passato come parametro
		 * 
		 * @param idGroup
		 * @return
		 */
		public List<RubricaGruppo> getSubGroups(long idGroup) {
			
			List<RubricaGruppo> listSubGroups = new ArrayList<>();
			
			List<Object[]> listSubGroupsObj = RubricaGruppoGruppiLocalServiceUtil.getGruppiFigli(idGroup);
			
			if(null != listSubGroupsObj) {
				
				for (Object[] objectsSubGruop : listSubGroupsObj) {
				
					RubricaGruppoGruppi gruppoGruppi = new RubricaGruppoGruppiImpl();
					gruppoGruppi.setFK_GRUPPO_PADRE((long) objectsSubGruop[0]);
					gruppoGruppi.setFK_GRUPPO_FIGLIO((long)objectsSubGruop[1]);
			
							
					//recupera le info del gruppo (passando gruppoGruppi.getFK_GRUPPO_FIGLIO)
					RubricaGruppo subGroup = new RubricaGruppoImpl();
					try {
						subGroup = RubricaGruppoUtil.findByPrimaryKey(gruppoGruppi.getFK_GRUPPO_FIGLIO());
						listSubGroups.add(subGroup);
					} catch (NoSuchRubricaGruppoException e) {
						//logger.error("Errore gruppo figlio non presente", e);
					} catch (SystemException e) {
						//logger.error("Errore nel caricamento delle info gruppo figlio", e);
					}
				}
			}			
			
			return listSubGroups;
					
		}
}