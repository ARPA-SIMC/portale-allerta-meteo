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
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.Validator;

import it.eng.allerte.model.RubricaContatto;
import it.eng.allerte.service.base.RubricaContattoLocalServiceBaseImpl;

/**
 * The implementation of the rubrica contatto local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.allerte.service.RubricaContattoLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaContattoLocalServiceBaseImpl
 */
public class RubricaContattoLocalServiceImpl
	extends RubricaContattoLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.allerte.service.RubricaContattoLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.allerte.service.RubricaContattoLocalServiceUtil</code>.
	 */
	
	private  Log logger = LogFactoryUtil.getLog(RubricaContattoLocalServiceImpl.class);
	
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
			
				List<Object[]> listaContattiObj = rubricaContattoFinder.loadByNominativo(idNominative);
				
				if(null != listaContattiObj) {
					
					for(Object [] contattoObj : listaContattiObj) {
						
						RubricaContatto rubricaContatto = fetchRubricaContatto((long) contattoObj[0]);
						//new RubricaContattoImpl();
						//rubricaContatto.setID_CONTATTO((long) contattoObj[0]);
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
				logger.error("Errore nel caricamnento dei contatti", e);
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
				
				User userPortale = userLocalService.fetchUser(idUserPortal);
				Contact contact = userPortale.getContact();
				
				
				//In contact liferay ci sono i contatti per colonna, prendiamo solo mail e cell
				if(Validator.isNotNull(contact.getEmailAddress())) {
					RubricaContatto contattoEmail = fetchRubricaContatto(contact.getContactId());
							//new RubricaContattoImpl();
					//contattoEmail.setID_CONTATTO(contact.getContactId());
					contattoEmail.setALLERTAMENTO(true); // lo setto sempre a true in questo caso
					contattoEmail.setFK_CANALE(new Long(1)); //1 sarà la mail
					contattoEmail.setCONTATTO(contact.getEmailAddress());
					contattoEmail.setFK_NOMINATIVO(idUserPortal);
					listaContatti.add(contattoEmail);
				} else if (Validator.isNotNull(contact.getSmsSn())) {
					
					RubricaContatto contattoSms = fetchRubricaContatto(contact.getContactId());
							//new RubricaContattoImpl();
					//contattoSms.setID_CONTATTO(contact.getContactId());
					contattoSms.setALLERTAMENTO(true); // lo setto sempre a true in questo caso
					contattoSms.setFK_CANALE(new Long(3)); //3 sarà il cell
					contattoSms.setCONTATTO(contact.getSmsSn());
					contattoSms.setFK_NOMINATIVO(idUserPortal);
					listaContatti.add(contattoSms);
				}
			} catch (PortalException | SystemException e) {
				logger.error("Errore nel caricamento contatti per utente portale" , e);
			}			
			
			return listaContatti;
					
		}
		
		public ArrayList<Object[]> loadByNominativo(Long idNominativo) {
			return rubricaContattoFinder.loadByNominativo(idNominativo);
		}
}