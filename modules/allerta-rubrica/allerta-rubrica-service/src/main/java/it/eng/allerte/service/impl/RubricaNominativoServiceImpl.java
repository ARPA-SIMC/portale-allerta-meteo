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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import it.eng.allerte.custom.interfaces.IRubricaRestConstants;
import it.eng.allerte.custom.jsonRubrica.Nominative;
import it.eng.allerte.service.RubricaNominativoLocalServiceUtil;
import it.eng.allerte.service.RubricaUtenteSitoLocalServiceUtil;
import it.eng.allerte.service.base.RubricaNominativoServiceBaseImpl;
import it.eng.rubrica.service.util.GestioneRubricaCustomService;

/**
 * The implementation of the rubrica nominativo remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.allerte.service.RubricaNominativoService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaNominativoServiceBaseImpl
 */
public class RubricaNominativoServiceImpl
	extends RubricaNominativoServiceBaseImpl implements IRubricaRestConstants {
	

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>it.eng.allerte.service.RubricaNominativoServiceUtil</code> to access the rubrica nominativo remote service.
	 */
	public java.util.Map<java.lang.String, java.lang.Object> getNominatives(
			java.lang.Long id) {
		
		Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
		Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
		
		return loadNominativeById(userId, idSite, id);

	}

		public java.util.Map<java.lang.String, java.lang.Object> getNominatives(
			java.lang.String name, int limit, int offset) {
			
			Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
			Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
			
			return loadNominativeByName(userId, idSite, name, limit, offset);
			
		}

		public Map<String, Object> deleteNominatives(Long id) {
			Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
			Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
			
			return deleteNominativeById(userId, idSite,id);
		}
		
		private Map<String, Object> deleteNominativeById(long userId, long groupId, Long id) {
			
			Map<String,Object> mappa = new HashMap<String, Object>();
			
			GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, groupId);
			try {
				mappa = gestRubrica.eliminaNominativoAll(id);
			} catch (SystemException | PortalException | ParseException e) {
				mappa.put(CODE, 400);
				mappa.put(ERROR, GENERIC_ERROR);
			}
		
			return mappa;
		
		}
		
		public Map<String, Object> updateNominatives(Long id, String data) {
			Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
			Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
			
			return updateNonminativeById(userId,idSite,id,data);
		}
		
		private Map<String, Object> updateNonminativeById(long userId, long groupId, Long id, String data) {
			
			Map<String,Object> mappa = new HashMap<String, Object>();
					
			GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, groupId);
		
			try {
				mappa = gestRubrica.aggiornaNominativo(id, data);
		
			} catch (JSONException | SystemException | ParseException | IOException e) {
				mappa.put(CODE, 400);
				mappa.put(ERROR,  GENERIC_ERROR);
			}
			
			return mappa;
		}
		
		public java.util.Map<java.lang.String, java.lang.Object> insertNominatives(String data) {
			Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
			Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
			
			return creaNominativo(userId, idSite, data);
		}

		public java.util.Map<java.lang.String, java.lang.Object> importNominatives() {
			//TODO
			return null;
		}

		public java.util.Map<java.lang.String, java.lang.Object> nominativesMulti(String data) {
			//TODO
			Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
			Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
			
			return deleteNominativeMulti(userId, idSite, data);
		}

		
		@JSONWebService
		@AccessControlled(guestAccessEnabled = true)
		public java.util.Map<java.lang.String, java.lang.Object> addNominativesGroupsMulti(
			java.lang.Long id, String data) {

			Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
			Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
			
				
			Map<String,Object> mappa = new HashMap<String, Object>();			
			mappa = createNominativeGroupMulti(userId, idSite, id, data);

			return mappa;
		}
		
		@JSONWebService
		@AccessControlled(guestAccessEnabled = true)
		public java.util.Map<java.lang.String, java.lang.Object> deleteNominativesGroupsMulti(
				java.lang.Long id, String data) {

				Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
				Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
			
					
				Map<String,Object> mappa = new HashMap<String, Object>();			
				mappa = deleteNominativeGroupsMulti(userId, idSite, id, data);

				return mappa;
			}
		
		private Map<String, Object> deleteNominativeMulti(Long userId, Long idSite, String data) {

			Map<String,Object> mappa = new HashMap<String, Object>();
			
			try {
				
				GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, idSite);
			    List<Long> listaDelError = gestRubrica.cancellaNominativoMulti(data);
				if(listaDelError.isEmpty())   { 
				    mappa.put(CODE, 200);
				    mappa.put(SUCCESS, "cancellazione avvenuta con successo");
				}
				else {
				    mappa.put(CODE, 404);
				    mappa.put(ERROR, listaDelError);
				}
								
			} catch (SystemException | IOException e) {
			    mappa.put(CODE, 400);
				mappa.put(ERROR, GENERIC_ERROR);
			}
			
			return mappa;
		}
		

		private Map<String, Object> createNominativeGroupMulti(Long userId, Long idSite, Long id, String data) {
			Map<String,Object> mappa = new HashMap<String, Object>();
					
			try {
						
				GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, idSite);
			    List<Long> listaAssociationError = gestRubrica.associaNominativoGruppiMulti(new Long(id), data);
				if(listaAssociationError.isEmpty())   { 
				    mappa.put(CODE, 201);
				    mappa.put(SUCCESS, "associazione avvenuta con successo");
				}
				else {
				    mappa.put(CODE, 404);
				    mappa.put(ERROR, listaAssociationError);
				}
									
			} catch (SystemException | IOException e) {
				//logger.error("Errore in fase di associazione multipla gruppo nominativo", e);
			    mappa.put(CODE, 400);
				mappa.put(ERROR, GENERIC_ERROR);
			}
					
			return mappa;
		}


		private Map<String, Object> deleteNominativeGroupsMulti(Long userId, Long idSite, Long id, String data) {
			
			Map<String,Object> mappa = new HashMap<String, Object>();
			
			try {
				
				GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, idSite);
			    List<Long> listaDeleteAssociationError = gestRubrica.cancellaNominativoGruppiMulti(new Long(id), data);
				if(listaDeleteAssociationError.isEmpty())   { 
				    mappa.put(CODE, 201);
				    mappa.put(SUCCESS, "cancellazione avvenuta con successo");
				}
				else {
				    mappa.put(CODE, 404);
				    mappa.put(ERROR, listaDeleteAssociationError);
				}
								
			} catch (SystemException | IOException e) {
				//logger.error("Errore in fase di cancellazione multipla gruppo nominativo", e);
			    mappa.put(CODE, 400);
				mappa.put(ERROR, GENERIC_ERROR);
			}
			
			return mappa;
		}

		public java.util.Map<java.lang.String, java.lang.Object> nominativesMulti(
			java.lang.Long id) {
			//TODO
			return null;
		}
		
		
		private Map<String, Object> loadNominativeById(long userId, Long idSite, Long id ) {
			
			Map<String,Object> mappa = new HashMap<String, Object>();
			
			Nominative nominative;
			
			try {
			   GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, idSite);
			   nominative = gestRubrica.loadNominativoById(idSite, id);
			  
			   if(null == nominative ) {
				   mappa.put(CODE, 404);
				   mappa.put(ERROR, "nominativo non presente");
			   } else {
				   mappa.put(CODE, 200);
				   mappa.put(DATA, nominative);
			   }
					   
			} catch (SystemException | PortalException | ParseException | IOException e) {
			   mappa.put(CODE, 400);
			   mappa.put(ERROR, GENERIC_ERROR);
			}
			
			return mappa;
		}
		
		private Map<String, Object> loadNominativeByName(long userId, long idSite, String name, int limit, int offset) {
			
			Map<String,Object> mappa = new HashMap<String, Object>();
			
			List<Nominative> listaNominative;

			try {
			   GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, idSite);
			   listaNominative = gestRubrica.loadNominativoByName(idSite, name, new Long(limit), new Long(offset));
			 
			   if(null == listaNominative /*|| listaNominative.isEmpty() */) {
				   mappa.put(CODE, 404);
				   mappa.put(ERROR, "nessun risultato");
			   } else {
				   mappa.put(CODE, 200);
				   mappa.put(DATA, listaNominative);
				   mappa.put(LIMIT, limit);
				   mappa.put(OFFSET, offset);
				   mappa.put(TOTAL, RubricaNominativoLocalServiceUtil.getNominativiByName(name, new Long(-1), new Long(-1)).size());
			   }

			} catch (SystemException | PortalException | JsonProcessingException | ParseException e) {
			   mappa.put(CODE, 400);
			   mappa.put(ERROR, GENERIC_ERROR);
			}
			
			return mappa;
		}
		
		
		private Map<String, Object> creaNominativo(long userId, long groupId, String data) {
			
			Map<String,Object> mappa = new HashMap<String, Object>();
			
			try {
				
				GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, groupId);
			    mappa = gestRubrica.creaNominativo(data);
				
			} catch (IOException | SystemException e) {
				//logger.error("Errore in fase di creazione nominativo", e);
				mappa.put(CODE, 400);
				mappa.put(ERROR, GENERIC_ERROR);
			}
			return mappa;
		}
}