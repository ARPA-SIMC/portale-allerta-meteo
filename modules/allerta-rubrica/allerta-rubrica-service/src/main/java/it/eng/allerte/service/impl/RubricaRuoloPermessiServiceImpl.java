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
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.eng.allerte.custom.interfaces.IRubricaRestConstants;
import it.eng.allerte.custom.jsonRubrica.LiferayRolePermission;
import it.eng.allerte.custom.jsonRubrica.UserInfoLogin;
import it.eng.allerte.service.RubricaUtenteSitoLocalServiceUtil;
import it.eng.allerte.service.base.RubricaRuoloPermessiServiceBaseImpl;
import it.eng.rubrica.service.util.GestioneRubricaCustomService;

/**
 * The implementation of the rubrica ruolo permessi remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.allerte.service.RubricaRuoloPermessiService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaRuoloPermessiServiceBaseImpl
 */
public class RubricaRuoloPermessiServiceImpl
	extends RubricaRuoloPermessiServiceBaseImpl implements IRubricaRestConstants {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>it.eng.allerte.service.RubricaRuoloPermessiServiceUtil</code> to access the rubrica ruolo permessi remote service.
	 */

	//GET - POST - PUT liferayRoles
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String,Object> getRolePermission(){
		
		Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
		Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
		
				
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		mappa = loadLiferayRolesPermission(userId, idSite);
		
		return mappa;
	}
	
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String,Object> insertRolePermission(String data){
		
		Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
		Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
		
				
		Map<String,Object> mappa = new HashMap<String, Object>();
			
		mappa = insertRolePermission(userId, idSite, data);
		
		return mappa;
	}
	
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String,Object> updateRolePermission(String data){
		
		Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
		Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
		
				
		Map<String,Object> mappa = new HashMap<String, Object>();
			
		mappa = updateRolePermission(userId, idSite, data);
		
		return mappa;
	}

	//GET - POST - PUT liferayRoles
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String,Object> getUserInfo(){
			
		Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
		Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
		
					
		Map<String,Object> mappa = new HashMap<String, Object>();
		mappa = loadUserInfo(userId, idSite);
		
		return mappa;
	}
	

	/**
	 * 
	 * @param userId
	 * @param scopeGroupId
	 * @param data
	 * @return
	 */
	private Map<String, Object> updateRolePermission(long userId, long groupId, String data) {
		
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		try {
			
			GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, groupId);
		    mappa = gestRubrica.inserisciRuoloPermessi(data);
			mappa.put(CODE, 200);
			mappa.put(SUCCESS, "aggiornamento avvenuto con successo");
			
		} catch (IOException | SystemException e) {
			mappa.put(CODE, 400);
			mappa.put(ERROR, GENERIC_ERROR);
		}
		return mappa;
		
		
		
	}

	/**
	 * 
	 * @param userId
	 * @param groupId
	 * @param data
	 * @return
	 */
	private Map<String, Object> insertRolePermission(long userId, long groupId, String data) {
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		try {
			
			GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, groupId);
		    mappa = gestRubrica.inserisciRuoloPermessi(data);
			
		} catch (IOException | SystemException e) {
			mappa.put(CODE, 400);
			mappa.put(ERROR, GENERIC_ERROR);
		}
		return mappa;
	}

	/**
	 * 
	 * @param userId
	 * @param groupId
	 * @return
	 */
	private Map<String, Object> loadLiferayRolesPermission(long userId, long groupId) {
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		List<LiferayRolePermission> listLiferayRole;
		
		try {
		   GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, groupId);
		   listLiferayRole = gestRubrica.loadLiferayRolesPermission();
		  
		   if(null == listLiferayRole || listLiferayRole.isEmpty() ) {
			   mappa.put(CODE, 404);
			   mappa.put(ERROR, "nessun permesso configurato");
		   } else {
			   mappa.put(CODE, 200);
			   mappa.put(DATA, listLiferayRole);
		   }
   
		} catch (SystemException e) {
		   //Se ho un errore setto il codice e il messaggio
		   mappa.put(CODE, 400);
		   mappa.put(ERROR, GENERIC_ERROR);
		}
		
		return mappa;
	}
	
	
	/**
	 * 
	 * @param userId
	 * @param idSite
	 * @return
	 */
	private Map<String, Object> loadUserInfo(Long userId, Long idSite) {
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		UserInfoLogin userInfoLogin;
		
		try {
		   GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, idSite);
		   userInfoLogin = gestRubrica.loadUserInfoLogin();
		    
		   mappa.put(CODE, 200);
		   mappa.put(DATA, userInfoLogin);
	
		} catch (SystemException | PortalException e) {
		   //Se ho un errore setto il codice e il messaggio
		   mappa.put(CODE, 400);
		   mappa.put(ERROR, GENERIC_ERROR);
		}
		
		return mappa;
	}
}