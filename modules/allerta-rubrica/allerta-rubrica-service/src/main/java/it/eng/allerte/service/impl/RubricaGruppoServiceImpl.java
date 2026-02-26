/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service.impl;

import com.liferay.portal.aop.AopService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.eng.allerte.custom.interfaces.IRubricaRestConstants;
import it.eng.allerte.custom.jsonRubrica.GroupDetail;
import it.eng.allerte.custom.jsonRubrica.GroupElement;
import it.eng.allerte.custom.jsonRubrica.RubricaUserGroup;
import it.eng.allerte.custom.util.RubricaUtil;
import it.eng.allerte.model.RubricaGruppo;
import it.eng.allerte.model.impl.RubricaGruppoImpl;
import it.eng.allerte.service.RubricaGruppoLocalServiceUtil;
import it.eng.allerte.service.RubricaUtenteSitoLocalServiceUtil;
import it.eng.allerte.service.base.RubricaGruppoServiceBaseImpl;
import it.eng.rubrica.service.util.GestioneRubricaCustomService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Pratola_L
 */
@Component(
	property = {
		"json.web.service.context.name=rubrica",
		"json.web.service.context.path=RubricaGruppo"
	},
	service = AopService.class
)
public class RubricaGruppoServiceImpl extends RubricaGruppoServiceBaseImpl implements IRubricaRestConstants {
	

	
	//GET groups (ID)
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String,Object> getGroups(Long id){

		Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
		Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
		
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		mappa = loadGroupById(userId, idSite, id);
		return mappa;
	}
	
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String,Object> updateGroups(Long id, String data){

		Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
		Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
		
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		mappa = updateGroupById(userId, idSite, id, data);
		return mappa;
	}
	
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String,Object> deleteGroups(Long id){

		Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
		Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
		
		
		Map<String,Object> mappa = new HashMap<String, Object>();

		mappa = deleteGroupById(userId,  idSite, id);

		return mappa;
	}
	
	
	//GET groups (name, limit, offset)
	@JSONWebService
	@AccessControlled(guestAccessEnabled = false)
	public Map<String,Object> getGroups(String name, Long categoria, int limit, int offset){
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		try {
			long aaa = this.getGuestOrUserId();
			User bbb = this.getGuestOrUser();
			System.out.println("xxx");
		} catch (Exception e) {}
		Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
		Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
		
			
		mappa = loadGroupByName(userId, idSite,  name, categoria, limit, offset);

		return mappa;

	}

	//POST - crea gruppo - GET restituisci i gruppi a cui è associato l'user
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String,Object> getGroups(){
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
		Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
		

		mappa = loadUserGroups(userId);		
		return mappa;
	}
	
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String,Object> addGroup(String data){
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
		Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
		

		mappa = creaGruppo(userId, idSite, data);		
		return mappa;
	}

	
	//POST - crea gruppo - GET restituisci i gruppi a cui è associato l'user
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String,Object> deleteGroupsMulti(String data){
			
		Map<String,Object> mappa = new HashMap<String, Object>();

		Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
		Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
		

		mappa = deleteGroupMulti(userId,  idSite, data);
					
		return mappa;
	}
	
	
	private Map<String, Object> deleteGroupMulti(Long userId, Long idSite, String data) {

		Map<String,Object> mappa = new HashMap<String, Object>();
		
		try {
			
			GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, idSite);
		    List<Long> listaDelError = gestRubrica.cancellaGruppiMulti(data);
			if(listaDelError.isEmpty())   { 
			    mappa.put(CODE, 201);
			    mappa.put(SUCCESS, "cancellazione avvenuta con successo");
			}
			else {
			    mappa.put(CODE, 404);
			    mappa.put(ERROR, listaDelError);
			}
							
		} catch (SystemException | IOException e) {
			//logger.error("Errore in fase di cancellazione multipla dei gruppi", e);
		    mappa.put(CODE, 400);
			mappa.put(ERROR, GENERIC_ERROR);
		}
		
		return mappa;
		
	}


	/**
	 * 
	 * @param userId
	 * @return
	 */
	private Map<String, Object> loadUserGroups(long userId) {
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		List<RubricaUserGroup> listUserGroup = new ArrayList<>();
		
		try {
		   
		   GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, 0);
		   listUserGroup = gestRubrica.loadUserGroups(userId);
		   
		   if(null == listUserGroup || listUserGroup.isEmpty() ) {
			   mappa.put(CODE, 404);
			   mappa.put(ERROR, "non sono stati trovati gruppi per l'user");
		   } else {
			   mappa.put(CODE,200);
			   mappa.put(DATA, listUserGroup);
		   }
 
		} catch (SystemException | PortalException e) {
			   //logger.error("Errore in fase di caricamento gruppi per user", e);
			   mappa.put(CODE, 400);
			   mappa.put(ERROR, GENERIC_ERROR);
		}
		return mappa;
		
		
		
	}


	/**
	 * 
	 * @param groupId 
	 * @param userId 
	 * @param data
	 * @return
	 */
	private Map<String, Object> creaGruppo(long userId, long groupId, String data) {
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		try {
			
			GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, groupId);
			mappa = gestRubrica.creaGruppo(data);
							
		} catch (IOException | SystemException e) {
		    mappa.put(CODE, 400);
			mappa.put(ERROR,  GENERIC_ERROR);
		}
		return mappa;
	}
	
	/**
	 * 
	 * @param id
	 * @param userId 
	 * @param id2 
	 * @return
	 */
	private Map<String, Object> loadGroupById(long userId, Long groupId, Long id) {
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		GroupDetail groupDeatail;
		
		try {
		   
		   GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, groupId);
		   groupDeatail = gestRubrica.loadGroupById(groupId, id);
		   
		   if(null == groupDeatail ) {
			   mappa.put(CODE, 404);
			   mappa.put(ERROR, "gruppo non trovato");
		   } else {
			   mappa.put(CODE,200);
			   mappa.put(DATA, groupDeatail);
		   }
 
		} catch (SystemException | PortalException |  ParseException | IOException e) {
			   //logger.error("Errore in fase di caricamento gruppo", e);
			   mappa.put(CODE, 400);
			   mappa.put(ERROR, GENERIC_ERROR);
		}
		return mappa;
	}	
	
	/**
	 * 
	 * @param groupId 
	 * @param userId 
	 * @param name
	 * @param limit
	 * @param offset
	 * @return
	 */
	private Map<String, Object> loadGroupByName( long userId, long site, String name, Long categoria, int limit, int offset) {
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		List<GroupElement> listaGroupElement;
		
		try {
			GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, site);
		    listaGroupElement = gestRubrica.loadGroupsByName(site, name, categoria, new Long(limit), new Long(offset));
			 
			if(null == listaGroupElement) {
				mappa.put(CODE, 404);
				mappa.put(ERROR, "gruppo non trovato");
			} else {
				mappa.put(CODE, 200);
				mappa.put(DATA, listaGroupElement);
				mappa.put(LIMIT, limit);
				mappa.put(OFFSET, offset);
				//se ho un gruppo "UTENTI PORTALE" per il sito proprietario devo sommarlo nel TOTAL count dei gruppi
				if(hasGroupUtentiPortale(listaGroupElement)) {
					mappa.put(TOTAL,  RubricaGruppoLocalServiceUtil.getGruppiByName(site, name, new Long(-1), new Long(-1)).size()+1);
				} else {
					mappa.put(TOTAL,  RubricaGruppoLocalServiceUtil.getGruppiByName(site, name, new Long(-1), new Long(-1)).size());
				}
			}
		} catch (SystemException | PortalException | JsonProcessingException | ParseException e) {
			//logger.error("Errore in fase di caricamento gruppi", e);
			mappa.put(CODE, 400);
			mappa.put(ERROR, GENERIC_ERROR);
		}
		
		return mappa;
	}

	/**
	 * 
	 * @param listaGroupElement
	 * @return
	 */
	private boolean hasGroupUtentiPortale(List<GroupElement> listaGroupElement) {
		for(GroupElement group : listaGroupElement) {
			if(group.getName().equalsIgnoreCase(DESCRIZIONE_GRUPPO_UTENTI_PORTALE)) {
				return true;
			}
		}		
		return false;
	}


	/**
	 * 
	 * @param id
	 * @param groupId 
	 * @param userId 
	 * @param data
	 * @return
	 */
	private Map<String, Object> updateGroupById(long userId, long groupId, Long id, String data) {
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, groupId);
	
		try {
			
			mappa = gestRubrica.aggiornaGruppo(id, data);
	
		} catch (SystemException | IOException e) {
			//logger.error("Errore in fase di aggiornamento gruppo", e);
			mappa.put(CODE, 400);
			mappa.put(ERROR, GENERIC_ERROR);
		}
		
		return mappa;
	}
	
	/**
	 * 
	 * @param id
	 * @param groupId 
	 * @param userId 
	 * @return
	 */
	private Map<String, Object> deleteGroupById(long userId, long groupId, Long id) {
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, groupId);
		
		try {
			mappa = gestRubrica.eliminaGruppoAll(id);
		} catch (SystemException | PortalException e) {
			//logger.error("Errore in fase di cancellazione gruppo", e);
			mappa.put(CODE, 400);
			mappa.put(ERROR, GENERIC_ERROR);
		}
	
		return mappa;
	}
	
	
	//Integrazione con sistema allertamento
	/**
	 * 
	 * Il metodo restituisce le info sul gruppo a partire dal nome e per il sito proprietario
	 * 
	 */
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public RubricaGruppo getGroupForOwnerByName(Long ownerId, String groupName){
		
		RubricaGruppo gruppoResult = null;
		
		try {
		
			Object[] gruppo = RubricaGruppoLocalServiceUtil.getGruppiByOwnerAndName(ownerId, groupName);
			
			if( null != gruppo) {
				
				gruppoResult = new RubricaGruppoImpl();
				gruppoResult.setID_GRUPPO((long)gruppo[0]);
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
			//logger.error("Errore caricamento gruppo", e);
		}
					
		return gruppoResult;
			
	}
	
}