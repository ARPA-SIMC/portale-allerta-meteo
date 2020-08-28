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
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import it.eng.allerte.custom.interfaces.IRubricaRestConstants;
import it.eng.allerte.model.RubricaContatto;
import it.eng.allerte.model.impl.RubricaContattoImpl;
import it.eng.allerte.service.RubricaContattoLocalServiceUtil;
import it.eng.allerte.service.RubricaUtenteSitoLocalServiceUtil;
import it.eng.allerte.service.base.RubricaContattoServiceBaseImpl;
import it.eng.rubrica.service.util.GestioneRubricaCustomService;

/**
 * The implementation of the rubrica contatto remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.allerte.service.RubricaContattoService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaContattoServiceBaseImpl
 */
public class RubricaContattoServiceImpl extends RubricaContattoServiceBaseImpl implements IRubricaRestConstants {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>it.eng.allerte.service.RubricaContattoServiceUtil</code> to access the rubrica contatto remote service.
	 */
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String,Object> addContacts(String data){
		
		Map<String,Object> mappa = new HashMap<String, Object>();
			
		Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
		Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);

		mappa = associaContattoNominativo(userId, idSite, data);

		
		return mappa;
	}

	
	//GET - PUT - DELETE nominatives (ID)
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String,Object> updateContacts(Long id, String data){
			
		Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
		Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		mappa = updateContact(userId, idSite, id, data); 
		
		return mappa;
	}
	
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String,Object> deleteContacts(Long id, String data){
		
		Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
		Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		mappa = deleteContactById(userId, idSite, id); 
		
		return mappa;
	}
	
	//GET - PUT - DELETE nominativesMulti (ID)
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String,Object> deleteContactsMulti(String data){
				
		Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
		Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
		
		Map<String,Object> mappa = new HashMap<String, Object>();

		
		mappa = deleteContactMulti(userId, idSite, data);
 
			
		return mappa;
	}

	
	
	private Map<String, Object> deleteContactMulti(Long userId, Long idSite, String data) {
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		try {
			
			GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, idSite);
		    List<Long> listaDeleteAssociationError = gestRubrica.eliminaContattiMulti(data);
			if(listaDeleteAssociationError.isEmpty())   { 
			    mappa.put(CODE, 200);
			    mappa.put(SUCCESS, "cancellazione avvenuta con successo");
			}
			else {
			    mappa.put(CODE, 404);
			    mappa.put(ERROR, listaDeleteAssociationError);
			}
							
		} catch (IOException | SystemException e) {
			//logger.error("Errore in fase di cancellazione multipla contatti", e);
		    mappa.put(CODE, 400);
			mappa.put(ERROR, GENERIC_ERROR);
		}
		
		return mappa;
	}


	/**
	 * 
	 * @param userId
	 * @param groupId
	 * @param id
	 * @param data
	 * @return
	 */
	private Map<String, Object> updateContact(long userId, long groupId, Long id, String data) {
		
		Map<String,Object> mappa = new HashMap<String, Object>();
				
		try {
		
			GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, groupId);
			mappa = gestRubrica.aggiornaContatto(id, data);

		} catch (NumberFormatException | SystemException | IOException e) {
			//logger.error("Errore in aggiornamento contatto", e);
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
	private Map<String, Object> associaContattoNominativo(long userId, long groupId, String data) {
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		try {
				
			GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, groupId);
		    mappa = gestRubrica.associaContattoNominativo(data);
						
		} catch (IOException | SystemException e) {
			//logger.error("Errore in fase di associzione contatto nominativo", e);
		    mappa.put(CODE, 400);
			mappa.put(ERROR, REQUEST_ERROR);
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
	private Map<String, Object> deleteContactById(long userId, long groupId, Long id) {
		
		Map<String,Object> mappa = new HashMap<String, Object>();

		try {
		
			GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, groupId);
			mappa = gestRubrica.eliminaContatto(id);
		
		} catch (SystemException | PortalException e) {
			//logger.error("Errore in fase di cancellazione contatto", e);
			mappa.put(CODE, 400);
			mappa.put(ERROR, REQUEST_ERROR);
		}
	
		return mappa;
			
	}
	
	//Integrazione con sistema di allertamento
	/**
	 * 
	 * ritorna una lista di contatti per l'id nominativo passato come parametro
	 * 
	 * @param idNominative
	 * @return
	 */
	public List<RubricaContatto> getContactByNominative(long idNominative) {
	
		List<RubricaContatto> listaContatti  =  new ArrayList<>();
		
		try {
		
			List<Object[]> listaContattiObj = RubricaContattoLocalServiceUtil.loadByNominativo(idNominative);
			
			if(null != listaContattiObj) {
				
				for(Object [] contattoObj : listaContattiObj) {
					
					RubricaContatto rubricaContatto = new RubricaContattoImpl();
					rubricaContatto.setID_CONTATTO((long) contattoObj[0]);
					rubricaContatto.setFK_NOMINATIVO((long) contattoObj[1]);
					rubricaContatto.setFK_CANALE((long)contattoObj[2]);
					rubricaContatto.setCONTATTO((String) contattoObj[3]);
					rubricaContatto.setALLERTAMENTO((boolean) contattoObj[4]);
					rubricaContatto.setFK_UTENTE_CREAZIONE((long) contattoObj[5]);
					rubricaContatto.setDATA_CREAZIONE((Date) contattoObj[6]);
					rubricaContatto.setFK_UTENTE_MODIFICA((long) contattoObj[7]);
					rubricaContatto.setDATA_MODIFICA((Date) contattoObj[8]);
					rubricaContatto.setDATA_FINE_VALIDITA((Date) contattoObj[9]);				
					
					listaContatti.add(rubricaContatto);
				}
			}
		} catch(Exception e) {
			//logger.error("Errore nel caricamnento dei contatti", e);
		}
		
		return listaContatti;
				
	}
		
	/**
	 * 
	 * Il metodo ritorna i conatti per un user iscritto al portale
	 * 
	 * @param idUserPortal
	 * @return
	 */
	public List<RubricaContatto> getContactByNominativePortal(long idUserPortal) {
		
		List<RubricaContatto> listaContatti  =  new ArrayList<>();
		
		try {				
			
			User userPortale = UserLocalServiceUtil.fetchUser(idUserPortal);
			Contact contact = userPortale.getContact();
			
			
			//In contact liferay ci sono i contatti per colonna, prendiamo solo mail e cell
			if(StringUtils.isNotBlank(contact.getEmailAddress())) {
				RubricaContatto contattoEmail = new RubricaContattoImpl();
				contattoEmail.setID_CONTATTO(contact.getContactId());
				contattoEmail.setALLERTAMENTO(true); // lo setto sempre a true in questo caso
				contattoEmail.setFK_CANALE(new Long(1)); //1 sarà la mail
				contattoEmail.setCONTATTO(contact.getEmailAddress());
				contattoEmail.setFK_NOMINATIVO(idUserPortal);
				listaContatti.add(contattoEmail);
			} else if (StringUtils.isNotBlank(contact.getSmsSn())) {
				
				RubricaContatto contattoSms = new RubricaContattoImpl();
				contattoSms.setID_CONTATTO(contact.getContactId());
				contattoSms.setALLERTAMENTO(true); // lo setto sempre a true in questo caso
				contattoSms.setFK_CANALE(new Long(3)); //3 sarà il cell
				contattoSms.setCONTATTO(contact.getSmsSn());
				contattoSms.setFK_NOMINATIVO(idUserPortal);
				listaContatti.add(contattoSms);
			}
		} catch (PortalException | SystemException e) {
			//logger.error("Errore nel caricamento contatti per utente portale" , e);
		}			
		
		return listaContatti;
				
	}
	
	
}