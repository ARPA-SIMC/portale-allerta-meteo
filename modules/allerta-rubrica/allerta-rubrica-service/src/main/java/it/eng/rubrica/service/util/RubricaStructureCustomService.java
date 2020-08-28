package it.eng.rubrica.service.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.persistence.UserUtil;

import it.eng.allerte.custom.jsonRubrica.Contact;
import it.eng.allerte.custom.jsonRubrica.GroupDetail;
import it.eng.allerte.custom.jsonRubrica.GroupElement;
import it.eng.allerte.custom.jsonRubrica.Nominative;
import it.eng.allerte.custom.jsonRubrica.Owner;
import it.eng.allerte.custom.jsonRubrica.UserInfo;
import it.eng.allerte.exception.NoSuchRubricaGruppoException;
import it.eng.allerte.model.RubricaContatto;
import it.eng.allerte.model.RubricaGruppo;
import it.eng.allerte.model.RubricaGruppoGruppi;
import it.eng.allerte.model.RubricaGruppoNominativi;
import it.eng.allerte.model.RubricaNominativo;
import it.eng.allerte.model.RubricaRuoloRubrica;
import it.eng.allerte.model.RubricaSito;
import it.eng.allerte.model.impl.RubricaGruppoGruppiImpl;
import it.eng.allerte.model.impl.RubricaGruppoImpl;
import it.eng.allerte.model.impl.RubricaGruppoNominativiImpl;
import it.eng.allerte.service.RubricaGruppoGruppiLocalServiceUtil;
import it.eng.allerte.service.RubricaGruppoLocalServiceUtil;
import it.eng.allerte.service.RubricaGruppoNominativiLocalServiceUtil;
import it.eng.allerte.service.RubricaNominativoLocalServiceUtil;
import it.eng.allerte.service.RubricaRuoloRubricaLocalServiceUtil;
import it.eng.allerte.service.RubricaSitoLocalServiceUtil;
import it.eng.allerte.service.persistence.RubricaContattoUtil;
import it.eng.allerte.service.persistence.RubricaGruppoGruppiUtil;
import it.eng.allerte.service.persistence.RubricaGruppoUtil;

public class RubricaStructureCustomService {

	//private static Logger logger = LoggerFactory.getLogger(RubricaStructureCustomService.class);
	
	
	/**
	 * 
	 * @param nodes
	 * @return
	 */
	public static GroupElement createGroupElementTree(List<GroupElement> nodes) {

        Map<Long, GroupElement> mapTmp = new HashMap<>();
        
        //Inserisci i nodi nella mappa
        for (GroupElement current : nodes) {
            mapTmp.put(current.getId(), current);
        }

        //Cicla sui nodi e crea relazione padre/figlio
        for (GroupElement current : nodes) {
            Long parentId = current.getParentId();

            if (parentId != null) {
            	GroupElement parent = mapTmp.get(parentId);
                if (parent != null) {
                    current.setParent(parent);
                    parent.addSubGroup(current);
                    mapTmp.put(parentId, parent);
                    mapTmp.put(current.getId(), current);
                }
            }

        }
  
        //Estrai nodo radice (che contiene la gerarchia completa)
        GroupElement root = null;
        for (GroupElement node : mapTmp.values()) {
            if(node.getParent() == null) {
                root = node;
                break;
            }
        }

       return root;
    }

	
	/**
	 * 
	 * @param nodes
	 * @return
	 */
	public static GroupDetail createGroupDetailTree(List<GroupDetail> nodes) {
		
		Map<Long, GroupDetail> mapTmp = new HashMap<>();
	        
	        //Inserisci i nodi nella mappa
	        for (GroupDetail current : nodes) {
	            mapTmp.put(current.getId(), current);
	        }

	        //Cicla sui nodi e crea relazione padre/figlio
	        for (GroupDetail current : nodes) {
	            Long parentId = current.getParentId();

	            if (parentId != null) {
	            	GroupDetail parent = mapTmp.get(parentId);
	                if (parent != null) {
	                    current.setParent(parent);
	                    parent.addSubGroup(current);
	                    mapTmp.put(parentId, parent);
	                    mapTmp.put(current.getId(), current);
	                }
	            }

	        }
	  
	        //Estrai nodo radice (che contiene la gerarchia completa)
	        GroupDetail root = null;
	        for (GroupDetail node : mapTmp.values()) {
	            if(node.getParent() == null) {
	                root = node;
	                break;
	            }
	        }

	       return root;
	}
	
	/**
	 * 
	 * Metodo ricorsivo per la creazione dell'albero del tipo GroupDetail
	 * 
	 * @param listaGruopDetail
	 * @param idGruppoPadre
	 * @param idSite
	 * @throws SystemException
	 * @throws PortalException
	 */
	public static void loadSubGroupDetail(List<GroupDetail> listaGroupDetail, Long idGruppoPadre, Long idSite) throws SystemException, PortalException {
		
		List<Object[]> listaSubGroups = RubricaGruppoGruppiLocalServiceUtil.getGruppiFigli(idGruppoPadre);
		
		if(null != listaSubGroups) {
			
			for (Object[] objectsSubGruop : listaSubGroups) {
			
				RubricaGruppoGruppi gruppoGruppi = new RubricaGruppoGruppiImpl();
				gruppoGruppi.setFK_GRUPPO_PADRE((long) objectsSubGruop[0]);
				gruppoGruppi.setFK_GRUPPO_FIGLIO((long)objectsSubGruop[1]);
				
				//recupera le info del gruppo (passando gruppoGruppi.getFK_GRUPPO_FIGLIO)
				RubricaGruppo subGroupDetail =  RubricaGruppoLocalServiceUtil.fetchRubricaGruppo(gruppoGruppi.getFK_GRUPPO_FIGLIO());
	
				//verifica se è lo stesso proprietario (dovrebbe essere sempre vero a questo punto ma meglio controllare)
				if(subGroupDetail.getFK_SITO_PROPRIETARIO() == idSite.longValue()) {
				
					GroupDetail subGruopDetailJson = new GroupDetail();
								
					subGruopDetailJson.setId(subGroupDetail.getID_GRUPPO());
					subGruopDetailJson.setName(subGroupDetail.getNOME());
					subGruopDetailJson.setParentId(gruppoGruppi.getFK_GRUPPO_PADRE());
					
					//recupera il numero di nominativi e sottogruppi associati
					subGruopDetailJson.setNominativeCount(countNominativiPerGruppo(subGroupDetail.getID_GRUPPO(), idSite));
					subGruopDetailJson.setSubgroupsCount(countSottoGruppi(subGroupDetail.getID_GRUPPO()));
					
					//carica i dati del proprietario
					Owner ownerJson = loadOwnerForGroup(subGroupDetail.getFK_SITO_PROPRIETARIO());
					
					subGruopDetailJson.setOwner(ownerJson);
					
					//carica i dati dell'user che ha fatto modifiche sul gruppo
					if (subGroupDetail.getFK_UTENTE_MODIFICA() > 0) {
						UserInfo lastUserEditJson = loadEditUserInfoForGroup(subGroupDetail.getFK_UTENTE_MODIFICA());
						subGruopDetailJson.setLastEditUser(lastUserEditJson);
					} else {
						UserInfo lastUserEditJson = loadEditUserInfoForGroup(subGroupDetail.getFK_UTENTE_CREAZIONE());
						subGruopDetailJson.setLastEditUser(lastUserEditJson);
					}
					//subGruopDetailJson.setLastEditUser(lastUserEditJson);
					
					//Setta la data dell'utlima modifica
					subGruopDetailJson.setLastEdit(null != subGroupDetail.getDATA_MODIFICA() ? subGroupDetail.getDATA_MODIFICA().getTime() : subGroupDetail.getDATA_CREAZIONE().getTime() );
					
					//recupea i nominativi associati al gruppo		
					List<Nominative> listNominativesJson = loadNominativesForGroup(idSite, subGroupDetail); 
					if (listNominativesJson!=null) {
						for (Nominative n : listNominativesJson) {
							if (n!=null && n.getGroups()!=null) {
								for (it.eng.allerte.custom.jsonRubrica.Group gg : n.getGroups()) {
									if (gg!=null && gg.getId()==subGroupDetail.getID_GRUPPO()) {
										n.setRole(gg.getRole());
										n.setSpecificaRuolo(gg.getSpecificaRuolo());
									}
								}
							}
						}
					}
					//Setto la lista sull'oggetto finale
					subGruopDetailJson.setNominatives(listNominativesJson);
					
					
					//Aggiungi il nodo alla lista listaGruopElement
					listaGroupDetail.add(subGruopDetailJson);
				}	
			
				//Cerca i sottogruppi dei figli ricorsivamente
				loadSubGroupDetail(listaGroupDetail, gruppoGruppi.getFK_GRUPPO_FIGLIO(), idSite);
			} 
		}
	}

	/**
	 * Questo metodo carica la lista dei nominativi associati a un gruppo
	 * 
	 * 
	 * @param idSite
	 * @param subGroupDetail
	 * @return
	 * @throws SystemException
	 */
	public static List<Nominative> loadNominativesForGroup(Long idSite, RubricaGruppo subGroupDetail) throws SystemException {
		
		List<Nominative> listNominativesJson = new ArrayList<>();
		
		List<Object[]> listaGruppoNominativi = RubricaGruppoNominativiLocalServiceUtil.loadNominativiGruppo(subGroupDetail.getID_GRUPPO(), idSite);
		
		for (Object[] objectsGruop : listaGruppoNominativi) {
			
			//Creo un oggetto RubricaGruppoNominativi
			RubricaGruppoNominativi gruppoNominativo = new RubricaGruppoNominativiImpl();
			gruppoNominativo.setFK_GRUPPO((long) objectsGruop[0]);
			gruppoNominativo.setFK_NOMINATIVO((long) objectsGruop[1]);
			gruppoNominativo.setFK_RUOLO((long) objectsGruop[2]);
			
			//carico il nominativo
			Nominative nominativeJson = loadDetailNominativeForGroup(gruppoNominativo);
			
			listNominativesJson.add(nominativeJson);
			
		}
		return listNominativesJson;
	}

	/**
	 * Questo metodo ritorna le informazione sul nominativo associato a un gruppo
	 * 
	 * 
	 * @param gruppoNominativo
	 * @return
	 * @throws SystemException
	 */
	public static Nominative loadDetailNominativeForGroup(RubricaGruppoNominativi gruppoNominativo) throws SystemException {
		
		RubricaNominativo nominativo = RubricaNominativoLocalServiceUtil.fetchRubricaNominativo(gruppoNominativo.getFK_NOMINATIVO());

		Nominative nominativeJson = new Nominative();
		
		if(null !=nominativo) {
			nominativeJson = popolateNominative(gruppoNominativo, nominativo);		
		}
		
		return nominativeJson;
	}

	/**
	 * Metodo che popola un oggetto di tipo Nominative
	 * 
	 * @param gruppoNominativo
	 * @param nominativo
	 * @return
	 * @throws SystemException
	 */
	public static Nominative popolateNominative(RubricaGruppoNominativi gruppoNominativo, RubricaNominativo nominativo) throws SystemException {
		
		Nominative nominativeJson = new Nominative();
		
		nominativeJson.setId(nominativo.getID_NOMINATIVO());
		nominativeJson.setAddress(nominativo.getINDIRIZZO());
		nominativeJson.setFirstName(nominativo.getNOME());
		nominativeJson.setLastName(nominativo.getCOGNOME());
		nominativeJson.setLastEdit(null!=nominativo.getDATA_MODIFICA() ? nominativo.getDATA_MODIFICA().getTime() : null);
		if(nominativo.getFK_UTENTE_MODIFICA() != 0) {
			nominativeJson.setModifyUser(RubricaStructureCustomService.loadCreateEditUserInfoForNominative(nominativo.getFK_UTENTE_MODIFICA()));
		}
		if(nominativo.getFK_UTENTE_CREAZIONE() != 0) {
			nominativeJson.setCreateUser(RubricaStructureCustomService.loadCreateEditUserInfoForNominative(nominativo.getFK_UTENTE_CREAZIONE()));
		}					
		
		//Se gli passo il gruppo estraggo anche le info sul ruolo
		if(null != gruppoNominativo) {
			//estraggo le info sul ruolo
			RubricaRuoloRubrica role = RubricaRuoloRubricaLocalServiceUtil.fetchRubricaRuoloRubrica(gruppoNominativo.getFK_RUOLO());
			
			if(null != role ) {
				nominativeJson.setRole(role.getDESCRIZIONE());
			}
		}
				
		//Carico i contatti associati al nominativo
		List<Contact> listaConattiJson = loadContactsForNominative(nominativo);
			
		nominativeJson.setContacts(listaConattiJson);
		
		return nominativeJson;
	}

	/**
	 * Questo metodo carica i contatti associati a un nominativo
	 * 
	 * 
	 * @param nominativo
	 * @return
	 * @throws SystemException
	 */
	public static List<Contact> loadContactsForNominative(RubricaNominativo nominativo) throws SystemException {
		
		List<RubricaContatto> contatti = RubricaContattoUtil.findByContattoNominativo(nominativo.getID_NOMINATIVO());

		List<Contact> listaConattiJson = new ArrayList<>();
		if(null!= contatti && !contatti.isEmpty()) {
			for(RubricaContatto contatto : contatti) {
				
				//Considero solo i contatti validi
				if(null == contatto.getDATA_FINE_VALIDITA()) {
					
					Contact contattoJson = new Contact();
					contattoJson.setId(contatto.getID_CONTATTO());
					//recupero le info sul tipo
					//RubricaCanale canale = RubricaCanaleLocalServiceUtil.getRubricaCanale(contatto.getFK_CANALE());
					contattoJson.setChannelId(contatto.getFK_CANALE());
					contattoJson.setWarning(contatto.getALLERTAMENTO());
					contattoJson.setValue(contatto.getCONTATTO());	
					contattoJson.setExpiredDate(null != contatto.getDATA_FINE_VALIDITA() ? contatto.getDATA_FINE_VALIDITA().getTime() : null);
					
					listaConattiJson.add(contattoJson);
				}
			}
		}
		
		return listaConattiJson;
			
	}

		
	
	/**
	 * Questo metodo carica le informazione relativo all'utente che ha modificato un gruppo
	 * 
	 * @param subGroupDetail
	 * @return
	 * @throws SystemException
	 */
	public static UserInfo loadEditUserInfoForGroup(long idEditUser) throws SystemException {
		
		UserInfo lastUserEditJson = new UserInfo();
		
		User user = null;
	//	if(subGroupDetail.getFK_UTENTE_MODIFICA() != 0) {
			user = UserLocalServiceUtil.fetchUser(idEditUser);
			lastUserEditJson.setId(user.getUserId());
			lastUserEditJson.setLastName(user.getLastName());
			lastUserEditJson.setFirstName(user.getFirstName());
	//	}
		return lastUserEditJson;
	}
	
	/**
	 * Questo metoro restituisce il nome dell'user che ha creato/modificato un nominativo
	 * 
	 * @param subGroupDetail
	 * @return
	 * @throws SystemException
	 */
	public static String loadCreateEditUserInfoForNominative(long userId) throws SystemException {
		
		String createEditUser = null;
		
		User user = null;
		try {
			user = UserUtil.findByPrimaryKey(userId);
		} catch (NoSuchUserException e) {
			//logger.error("Errore in fase di caricamento info per Edit User", e);
		}
		createEditUser = user.getFirstName().concat(" ").concat(user.getLastName());

		return createEditUser;
	}

	/**
	 * Questo metodo restituisce le informazioni sul sito proprietario di un gruppo
	 * 
	 * 
	 * @param subGroupDetail
	 * @return
	 * @throws SystemException
	 */
	public static Owner loadOwnerForGroup(Long idSitoProprietario) throws SystemException {
		
		Owner ownerJson = new Owner();
		RubricaSito sito = RubricaSitoLocalServiceUtil.fetchRubricaSito(idSitoProprietario);
		//Group sitoProprietario = GroupLocalServiceUtil.fetchGroup(idSitoProprietario);
		
		if(null!=sito) {
			ownerJson.setName(sito.getNOME());
			ownerJson.setId(idSitoProprietario);
		}
		return ownerJson;
	}
	
	
	/**
	 * Metodo ricorsivo per la creazione dell'albero del tipo GroupElement
	 * 
	 * @param listaGruopElement
	 * @param idGruppoPadre
	 * @param idSite
	 * @throws SystemException
	 */
	public static void loadSubGruopElement(List<GroupElement> listaGruopElement, Long idGruppoPadre, Long idSite, List<RubricaGruppoGruppi> listaSubGroups,Map<String,Object> cache) throws SystemException {
		
		//List<Object[]> listaSubGroups = RubricaGruppoGruppiFinderUtil.getGruppiFigli(idGruppoPadre);
		//List<Object[]> listaSubGroups = null;
		if(null != listaSubGroups) {
			
			for (RubricaGruppoGruppi objectsSubGruop : listaSubGroups) {
				
				if (objectsSubGruop.getFK_GRUPPO_PADRE()!=idGruppoPadre) continue;
			
				RubricaGruppoGruppi gruppoGruppi = objectsSubGruop; /*new RubricaGruppoGruppiImpl();
				gruppoGruppi.setFK_GRUPPO_PADRE((long) objectsSubGruop[0]);
				gruppoGruppi.setFK_GRUPPO_FIGLIO((long)objectsSubGruop[1]);*/
				
				//recupera le info del gruppo (passando gruppoGruppi.getFK_GRUPPO_FIGLIO)
				RubricaGruppo subGroup = (RubricaGruppo)cache.get("gruppo_"+gruppoGruppi.getFK_GRUPPO_FIGLIO());
				if (subGroup==null) {
					subGroup = new RubricaGruppoImpl();
					try {
						subGroup = RubricaGruppoUtil.findByPrimaryKey(gruppoGruppi.getFK_GRUPPO_FIGLIO());
						cache.put("gruppo_"+gruppoGruppi.getFK_GRUPPO_FIGLIO(), subGroup);
					} catch (NoSuchRubricaGruppoException e) {
						//logger.error("Errore in fase di caricamento sottogruppi. Gruppo figlio non presente", e);
					}
				}
				
	
				//verifico che è lo stesso proprietario (dovrebbe essere vero a questo punto, ma meglio controllare)
				if(subGroup.getFK_SITO_PROPRIETARIO() == idSite.longValue() && !subGroup.getDISABLED()) {
					
					GroupElement subGruopJson = new GroupElement();
								
					subGruopJson.setId(subGroup.getID_GRUPPO());
					subGruopJson.setName(subGroup.getNOME());
					subGruopJson.setParentId(gruppoGruppi.getFK_GRUPPO_PADRE());
					
					//recupera il numero di nominativi e sottogruppi associati
					if (cache.containsKey("nominativi_"+subGroup.getID_GRUPPO())) {
						subGruopJson.setNominativeCount((Long)cache.get("nominativi_"+subGroup.getID_GRUPPO()));
						subGruopJson.setSubgroupsCount((Long)cache.get("sottogruppi_"+subGroup.getID_GRUPPO()));
					} else {
						Long nomin = RubricaStructureCustomService.countNominativiPerGruppo(subGroup.getID_GRUPPO(), idSite);
						cache.put("nominativi_"+subGroup.getID_GRUPPO(), nomin);
						subGruopJson.setNominativeCount(nomin);
						Long subg = RubricaStructureCustomService.countSottoGruppi(subGroup.getID_GRUPPO());
						cache.put("sottogruppi_"+subGroup.getID_GRUPPO(), subg);
						subGruopJson.setSubgroupsCount(subg);
					}
					//subGruopJson.setNominativeCount(countNominativiPerGruppo(subGroup.getID_GRUPPO(), idSite));
					//subGruopJson.setSubgroupsCount(countSottoGruppi(subGroup.getID_GRUPPO()));
					
					//Aggiungi il nodo alla lista listaGruopElement
					listaGruopElement.add(subGruopJson);
		
				}
				
				//Cerca i sottogruppi dei figli ricorsivamente
				loadSubGruopElement(listaGruopElement, gruppoGruppi.getFK_GRUPPO_FIGLIO(), idSite,listaSubGroups,cache);
			}
			
			

		} 
		
		if (listaGruopElement!=null && listaGruopElement.size()>1) {
			listaGruopElement.sort(
					new Comparator<GroupElement>() {
						public int compare(GroupElement arg0, GroupElement arg1) {
							return arg0.getName().compareTo(arg1.getName());
						};
					}
					);
		}
	}
	
	
	/**
	 * 
	 * @param idGruppo
	 * @param idSite
	 * @return
	 */
	public static Long countNominativiPerGruppo(Long idGruppo, Long idSite) {
		
		List<Object[]> listaNominativiGruppo = RubricaGruppoNominativiLocalServiceUtil.loadNominativiGruppo(idGruppo, idSite);			
		return null != listaNominativiGruppo ? listaNominativiGruppo.size() : new Long(0);
		
		
	}
	
	/**
	 * 
	 * @param idGruppo
	 * @return
	 */
	public static Long countSottoGruppi(Long idGruppo) {
		
		List<Object[]> listaSottoGruppi = RubricaGruppoGruppiLocalServiceUtil.getGruppiFigli(idGruppo);	
		return null != listaSottoGruppi ? listaSottoGruppi.size() : new Long(0);
		
		
	}
	
}

