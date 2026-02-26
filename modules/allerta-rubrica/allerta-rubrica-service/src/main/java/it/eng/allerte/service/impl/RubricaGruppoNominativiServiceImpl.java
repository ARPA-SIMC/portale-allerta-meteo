/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.eng.allerte.service.RubricaGruppoNominativiLocalServiceUtil;
import it.eng.allerte.service.base.RubricaGruppoNominativiServiceBaseImpl;
import it.eng.allerte.service.persistence.RubricaNominativoUtil;
import it.eng.rubrica.service.util.GestioneRubricaCustomService;

import org.osgi.service.component.annotations.Component;

import it.eng.allerte.custom.interfaces.IRubricaRestConstants;
import it.eng.allerte.custom.util.RubricaUtil;
import it.eng.allerte.exception.NoSuchRubricaNominativoException;
import it.eng.allerte.model.RubricaNominativo;
import it.eng.allerte.model.impl.RubricaNominativoImpl;

/**
 * @author Pratola_L
 */
@Component(
	property = {
		"json.web.service.context.name=rubrica",
		"json.web.service.context.path=RubricaGruppoNominativi"
	},
	service = AopService.class
)
public class RubricaGruppoNominativiServiceImpl
	extends RubricaGruppoNominativiServiceBaseImpl implements IRubricaRestConstants {
	
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String,Object> addGroupNominatives(int id, String data){
		
		Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
		Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
		
			
		Map<String,Object> mappa = new HashMap<String, Object>();
		

		mappa = associaGruppoNominativo(userId, idSite, id, data);

	
		return mappa;
	}
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String,Object> deleteGroupNominatives(int id, String data){
		
		Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
		Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
		
			
		Map<String,Object> mappa = new HashMap<String, Object>();

		mappa = deleteGruppoNominativo(userId, idSite, id, data);
 
	
		return mappa;
	}
		
	
	//POST - DELETE - PUT - GET  gruppo-nominativo
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String,Object> addGroupNominativesMulti(int id, String data){
		
		Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
		Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
		
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		

		mappa = associaGruppoNominativoMulti(userId, idSite, id, data);
 
	
		return mappa;
	}
	
	@JSONWebService
	@AccessControlled(guestAccessEnabled = true)
	public Map<String,Object> deleteGroupNominativesMulti(int id, String data){
		
		Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
		Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
		
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		mappa = deleteGruppoNominativoMulti(userId, idSite, id, data);

	
		return mappa;
	}
	
	
	private Map<String, Object> deleteGruppoNominativoMulti(Long userId, Long idSite, int id, String data) {
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		try {
			
			GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, idSite);
		    List<Long> listaDeleteAssociationError = gestRubrica.cancellaGruppoNominativoMulti(new Long(id), data);
			if(listaDeleteAssociationError.isEmpty())   { 
			    mappa.put(CODE, 201);
			    mappa.put(SUCCESS, "cancellazione avvenuta con successo");
			}
			else {
			    mappa.put(CODE, 404);
			    mappa.put(ERROR, listaDeleteAssociationError);
			}
							
		} catch (SystemException | IOException e) {
		    mappa.put(CODE, 400);
			mappa.put(ERROR, GENERIC_ERROR);
		}
		
		return mappa;
	}


	private Map<String, Object> associaGruppoNominativoMulti(Long userId, Long idSite, int id, String data) {
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		try {
			
			GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, idSite);
		    List<Long> listaAssociationError = gestRubrica.associaGruppoNominativoMulti(new Long(id), data);
			if(listaAssociationError.isEmpty())   { 
			    mappa.put(CODE, 201);
			    mappa.put(SUCCESS, "associazione avvenuta con successo");
			}
			else {
			    mappa.put(CODE, 400);
			    mappa.put(ERROR, listaAssociationError);
			}
							
		} catch (SystemException | IOException e) {
		    mappa.put(CODE, 400);
			mappa.put(ERROR, GENERIC_ERROR);
		}
		
		return mappa;
	}


	//PUT nominativo gruppo ruolo
	public Map<String,Object> nominativeGroupRole(String data){
		
		Long userId = 0L; try { userId = this.getUserId(); } catch (Exception e) {}
		Long idSite = GestioneRubricaCustomService.getIdSitoUtente(userId);
		
		
		Map<String,Object> mappa = new HashMap<String, Object>();

		mappa = updateRoleForGruopNominative(userId, idSite, data);
		
		return mappa;
		
	}

	/**
	 * 
	 * @param groupId 
	 * @param userId 
	 * @param data
	 * @return
	 */
	private Map<String, Object> updateRoleForGruopNominative(long userId, long groupId, String data) {
	
		Map<String,Object> mappa = new HashMap<String, Object>();
			
		try {
		
			GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, groupId);
			mappa = gestRubrica.aggiornaRuoloPerGruppoNominativo(data);

		} catch (NumberFormatException | SystemException | IOException e) {
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
	private Map<String, Object> deleteGruppoNominativo(long userId, long groupId, int id, String data) {
	
		Map<String,Object> mappa = new HashMap<String, Object>();
			
		try {
			
			GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, groupId);
			mappa = gestRubrica.eliminaGruppoNominativiByIdNominativo(new Long(id), data);

		} catch (NumberFormatException | SystemException | IOException e) {
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
	private Map<String, Object> associaGruppoNominativo(long userId, long groupId, int id, String data) {
		
		Map<String,Object> mappa = new HashMap<String, Object>();
	
		try {
			
			GestioneRubricaCustomService gestRubrica = new GestioneRubricaCustomService(userId, groupId);
		    mappa = gestRubrica.associaGruppoNominativo(new Long(id), data);
	   							
		} catch (IOException | SystemException e) {
		    mappa.put(CODE, 400);
			mappa.put(ERROR, GENERIC_ERROR);
		}
		
		return mappa;
		
	}

	
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
		Set<RubricaNominativo> listaRubricaNominativiResult = new HashSet();
		try {
		
			List<Object[]> listaGruppoNominativi = RubricaGruppoNominativiLocalServiceUtil.loadNominativiGruppo(groupId, ownerId);
					
			if(null != listaGruppoNominativi) {
			
				for (Object[] objectsGruop : listaGruppoNominativi) {
			
					try {
						RubricaNominativo rubricaNominativo = RubricaNominativoUtil.findByPrimaryKey((long) objectsGruop[1]);
						listaRubricaNominativiResult.add(rubricaNominativo);
					} catch (NoSuchRubricaNominativoException | SystemException e) {
					}
					
				}
			}
		} catch(Exception e){
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
				role = RoleLocalServiceUtil.getRole(20154, DESCRIZIONE_ROLE_CITTADINO);
			} catch (PortalException e) {
			}
			if(role==null){
				return null;
			}
			
			List<User> listaUser = UserLocalServiceUtil.getGroupUsers(ownerId);
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
				
				RubricaNominativo nominativo = new RubricaNominativoImpl();
								
				nominativo.setID_NOMINATIVO(userGroup.getUserId());
				nominativo.setCOGNOME(userGroup.getLastName());
				nominativo.setNOME(userGroup.getFirstName());
				nominativo.setFK_SITO_PROPRIETARIO(ownerId);
				if(null != userGroup.getAddresses() && ! userGroup.getAddresses().isEmpty()) {
					nominativo.setINDIRIZZO(null != userGroup.getAddresses().get(0).getStreet1() ? userGroup.getAddresses().get(0).getStreet1() : null);
				}
					
				listaRubricaNominativiResult.add(nominativo);
			}
		
		
		} catch (SystemException e) {
		} 
							
		return listaRubricaNominativiResult;
		
	}
}