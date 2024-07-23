package it.eng.rubrica.service.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.persistence.RoleUtil;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import it.eng.allerte.custom.interfaces.IRubricaLogConstants;
import it.eng.allerte.custom.interfaces.IRubricaRestConstants;
import it.eng.allerte.custom.jsonRubrica.Channel;
import it.eng.allerte.custom.jsonRubrica.Contact;
import it.eng.allerte.custom.jsonRubrica.ContactRequest;
import it.eng.allerte.custom.jsonRubrica.GroupAssociationRequest;
import it.eng.allerte.custom.jsonRubrica.GroupCreateRequest;
import it.eng.allerte.custom.jsonRubrica.GroupDetail;
import it.eng.allerte.custom.jsonRubrica.GroupElement;
import it.eng.allerte.custom.jsonRubrica.GroupNominative;
import it.eng.allerte.custom.jsonRubrica.GroupSubGroupAssociationRequest;
import it.eng.allerte.custom.jsonRubrica.GroupSubGroupUpdateRequest;
import it.eng.allerte.custom.jsonRubrica.LiferayRolePermission;
import it.eng.allerte.custom.jsonRubrica.Log;
import it.eng.allerte.custom.jsonRubrica.Nominative;
import it.eng.allerte.custom.jsonRubrica.NominativeCSV;
import it.eng.allerte.custom.jsonRubrica.NominativeCreateRequest;
import it.eng.allerte.custom.jsonRubrica.NominativeGroupRole;
import it.eng.allerte.custom.jsonRubrica.NominativeUpdateRequest;
import it.eng.allerte.custom.jsonRubrica.Owner;
import it.eng.allerte.custom.jsonRubrica.Permission;
import it.eng.allerte.custom.jsonRubrica.Role;
import it.eng.allerte.custom.jsonRubrica.RubricaUserGroup;
import it.eng.allerte.custom.jsonRubrica.UserInfo;
import it.eng.allerte.custom.jsonRubrica.UserInfoLogin;
import it.eng.allerte.custom.util.RubricaJsonValidation;
import it.eng.allerte.exception.NoSuchRubricaContattoException;
import it.eng.allerte.exception.NoSuchRubricaGruppoException;
import it.eng.allerte.exception.NoSuchRubricaGruppoGruppiException;
import it.eng.allerte.exception.NoSuchRubricaGruppoNominativiException;
import it.eng.allerte.exception.NoSuchRubricaNominativoException;
import it.eng.allerte.model.RubricaCanale;
import it.eng.allerte.model.RubricaCategoria;
import it.eng.allerte.model.RubricaContatto;
import it.eng.allerte.model.RubricaGruppo;
import it.eng.allerte.model.RubricaGruppoGruppi;
import it.eng.allerte.model.RubricaGruppoNominativi;
import it.eng.allerte.model.RubricaLog;
//import LiferayPortletHelperUtil
import it.eng.allerte.model.RubricaNominativo;
import it.eng.allerte.model.RubricaPermessi;
import it.eng.allerte.model.RubricaRuolo;
import it.eng.allerte.model.RubricaRuoloPermessi;
import it.eng.allerte.model.RubricaRuoloRubrica;
import it.eng.allerte.model.RubricaUtenteSito;
import it.eng.allerte.model.impl.RubricaContattoImpl;
import it.eng.allerte.model.impl.RubricaGruppoGruppiImpl;
import it.eng.allerte.model.impl.RubricaGruppoImpl;
import it.eng.allerte.model.impl.RubricaGruppoNominativiImpl;
import it.eng.allerte.model.impl.RubricaLogImpl;
import it.eng.allerte.model.impl.RubricaNominativoImpl;
import it.eng.allerte.model.impl.RubricaRuoloPermessiImpl;
import it.eng.allerte.service.RubricaCategoriaLocalServiceUtil;
import it.eng.allerte.service.RubricaContattoLocalServiceUtil;
import it.eng.allerte.service.RubricaGruppoGruppiLocalServiceUtil;
import it.eng.allerte.service.RubricaGruppoLocalServiceUtil;
import it.eng.allerte.service.RubricaGruppoNominativiLocalServiceUtil;
import it.eng.allerte.service.RubricaLogLocalServiceUtil;
import it.eng.allerte.service.RubricaNominativoLocalServiceUtil;
import it.eng.allerte.service.RubricaRuoloLocalServiceUtil;
import it.eng.allerte.service.RubricaRuoloPermessiLocalServiceUtil;
import it.eng.allerte.service.RubricaRuoloRubricaLocalServiceUtil;
import it.eng.allerte.service.RubricaSitoLocalServiceUtil;
import it.eng.allerte.service.RubricaUtenteSitoLocalServiceUtil;
import it.eng.allerte.service.persistence.RubricaCanaleUtil;
import it.eng.allerte.service.persistence.RubricaContattoUtil;
import it.eng.allerte.service.persistence.RubricaGruppoGruppiPK;
import it.eng.allerte.service.persistence.RubricaGruppoGruppiUtil;
import it.eng.allerte.service.persistence.RubricaGruppoNominativiPK;
import it.eng.allerte.service.persistence.RubricaGruppoNominativiUtil;
import it.eng.allerte.service.persistence.RubricaGruppoUtil;
import it.eng.allerte.service.persistence.RubricaNominativoUtil;
import it.eng.allerte.service.persistence.RubricaPermessiUtil;
import it.eng.allerte.service.persistence.RubricaRuoloPermessiUtil;
import it.eng.allerte.service.persistence.RubricaRuoloUtil;

public class GestioneRubricaCustomService implements IRubricaLogConstants, IRubricaRestConstants {
	
	public static final long AMMINISTRATORE_RUBRICA = 233866;
	public static final long AMMINISTRATORE_PORTALE = 168321L;
	public static final long ADMIN = 20161;
	public static final long SINDACO = 29574;
	public static final long DELEGATO_TOTALE = 75902;
	
	//private static Logger logger = LoggerFactory.getLogger(GestioneRubricaCustomService.class);
	
	//LiferayFacesContext liferayFacesContext;
	long userId;
	long companyId;
	long groupId;
	Locale locale;
	
	public static Long getIdSitoUtente(Long userId) {
		if (userId==null) return null;
		
		RubricaUtenteSito rus = RubricaUtenteSitoLocalServiceUtil.fetchRubricaUtenteSito(userId);
		if (rus!=null) return rus.getID_SITO();
		
		if (RoleLocalServiceUtil.hasUserRole(userId, AMMINISTRATORE_RUBRICA)) return 20181L;
		if (RoleLocalServiceUtil.hasUserRole(userId, AMMINISTRATORE_PORTALE)) return 20181L;
		if (RoleLocalServiceUtil.hasUserRole(userId, ADMIN)) return 20181L;
		
		List<Group> groups = GroupLocalServiceUtil.getUserGroups(userId);
		for (Group g : groups) {
			if (UserGroupRoleLocalServiceUtil.hasUserGroupRole(userId, g.getGroupId(), SINDACO)
					|| UserGroupRoleLocalServiceUtil.hasUserGroupRole(userId, g.getGroupId(), DELEGATO_TOTALE))
				return g.getGroupId();
		}
		
		
		return null;
	}
	
	public static void updateIdSitoUtente(Long userId, Long sito) {
		
		Map<Long,String> m = getSitiUtente(userId);
		if (!m.containsKey(sito)) return; //non hai il permesso
		
		RubricaUtenteSito rus = RubricaUtenteSitoLocalServiceUtil.fetchRubricaUtenteSito(userId);
		if (rus==null) {
			rus = RubricaUtenteSitoLocalServiceUtil.createRubricaUtenteSito(userId);
			rus.setID_SITO(sito);
			rus.setID_UTENTE(userId);
			//rus = RubricaUtenteSitoLocalServiceUtil.addRubricaUtenteSito(rus);
			RubricaUtenteSitoLocalServiceUtil.updateRubricaUtenteSito(rus);
		} else {
			rus.setID_SITO(sito);
			RubricaUtenteSitoLocalServiceUtil.updateRubricaUtenteSito(rus);
		}

	}
	
	public static Map<Long,String> getSitiUtente(Long userId) {
		Map<Long,String> m = new HashMap<Long, String>();
		
		if (RoleLocalServiceUtil.hasUserRole(userId, AMMINISTRATORE_RUBRICA)) m.put(20181L,"Rubrica Portale");
		if (RoleLocalServiceUtil.hasUserRole(userId, AMMINISTRATORE_PORTALE)) m.put(20181L,"Rubrica Portale");
		if (RoleLocalServiceUtil.hasUserRole(userId, ADMIN)) m.put(20181L,"Rubrica Portale");
		
		List<Group> groups = GroupLocalServiceUtil.getUserGroups(userId);
		for (Group g : groups) {
			if (UserGroupRoleLocalServiceUtil.hasUserGroupRole(userId, g.getGroupId(), SINDACO)
					|| UserGroupRoleLocalServiceUtil.hasUserGroupRole(userId, g.getGroupId(), DELEGATO_TOTALE))
				
				m.put(g.getGroupId(),"Rubrica "+g.getName());
		}
		
		return m;
	}
	
	//Costruttore
	public GestioneRubricaCustomService(long userId, long groupId){
		try {
		
			//liferayFacesContext = LiferayFacesContext.getInstance();
			this.userId = userId;
			//this.companyId = companyId;
			this.groupId = groupId;
			//locale = liferayFacesContext.getLocale();

		} catch (Exception e) {}
	}
	
	//------------ INIZIO RUBRICA NOMINATIVO -----------//
	
	/**
	 * 
	 * @param data
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SystemException
	 */
	public Map<String, Object> creaNominativo(String data) throws JsonParseException, JsonMappingException, IOException, SystemException {
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		List<String> errValidNominative = new ArrayList<>();
		List<String> errValidContact = new ArrayList<>();
		List<String> errValidGroup = new ArrayList<>();
		
		//Deserializzo il json
		ObjectMapper mapper = new ObjectMapper();
		NominativeCreateRequest nominative = mapper.readValue(data, NominativeCreateRequest.class);
			
		if(null != nominative) {
			
			//Valida dati da inserire
			RubricaJsonValidation validator =  new RubricaJsonValidation();
			errValidNominative = validator.validateNominative(nominative);
			errValidContact = validator.validateContact(nominative.getContacts());
			errValidGroup = validator.validateGroup(nominative.getGroups());
			
			if(errValidNominative.isEmpty() && errValidContact.isEmpty()) {
				
				Long idNominativo = inserisciNominativo(nominative);
				
				//se ho dei contatti e dei gruppi li inserisco
				if(null != nominative.getContacts() && ! nominative.getContacts().isEmpty()) {
					associaContattiNominativo(nominative.getContacts(), idNominativo);
				}
				if(null != nominative.getGroups() && ! nominative.getGroups().isEmpty()) {
					associaGruppiNominativo(nominative.getGroups(), idNominativo);
				}
				
			    mappa.put(CODE, 201);
			    mappa.put(SUCCESS, "inserimento avvenuto con successo");
			
			} else {
				
				//creo la lista con tutti gli errori
				List<String> errValidFinal = new ArrayList<>();
				errValidFinal.addAll(errValidNominative);
				errValidFinal.addAll(errValidContact);
				errValidFinal.addAll(errValidGroup);
				
				mappa.put(CODE,  400);
				mappa.put(ERROR, errValidFinal);
			}
		} 
		else {
			mappa.put(CODE,  400);
			mappa.put(ERROR, GENERIC_ERROR);
		}
		
		return mappa;
	}
	
	/**
	 * 
	 * @param nominative
	 * @return
	 * @throws SystemException
	 * @throws JsonProcessingException 
	 */
	private Long inserisciNominativo(NominativeCreateRequest nominative) throws SystemException, JsonProcessingException {
		//logger.info("inserisciNominativo1");
		RubricaNominativo rubricaNominativo = new RubricaNominativoImpl();
		rubricaNominativo.setID_NOMINATIVO(CounterLocalServiceUtil.increment(RubricaNominativo.class.getName()));
		rubricaNominativo.setCOGNOME(nominative.getLastName().trim());
		rubricaNominativo.setNOME(nominative.getFirstName().trim());
		rubricaNominativo.setINDIRIZZO(nominative.getAddress().trim());
		rubricaNominativo.setFK_SITO_PROPRIETARIO(groupId); 
		rubricaNominativo.setFK_UTENTE_PORTALE(0); // //Al momento abbiamo detto non serve questa info, lo setto sempre a 0
		
		//Setto le date di creazione e modifica in inserimento saranno le stesse
		rubricaNominativo.setDATA_MODIFICA(new Date());
		rubricaNominativo.setDATA_CREAZIONE(new Date());
		
		//e setto l'utente che sta creando il contatto
		//setto anche quello di modifica uguale a quello di creazione in questa fase
		rubricaNominativo.setFK_UTENTE_CREAZIONE(userId);
		rubricaNominativo.setFK_UTENTE_MODIFICA(userId);
		rubricaNominativo.setMODIFICA_MINORE(false);

		RubricaNominativoLocalServiceUtil.updateRubricaNominativo(rubricaNominativo);
		
		//Logga operazione in RUBRICA_LOG
		aggiornaRubricaLog(TABELLA_RUBRICA_NOMINATIVO, String.valueOf(rubricaNominativo.getID_NOMINATIVO()),TIPO_OPERAZIONE_INSERT, rubricaNominativo.toString(), userId );
		//logger.info("inserisciNominativo2");
		if (nominative.getGroup()!=null) {
			//logger.info("inserisciNominativo3");
			RubricaGruppoNominativi rgn = new RubricaGruppoNominativiImpl();
			rgn.setFK_NOMINATIVO(rubricaNominativo.getID_NOMINATIVO());
			rgn.setFK_GRUPPO(nominative.getGroup());
			rgn.setFK_RUOLO(nominative.getRole());
			rgn.setSPECIFICA_RUOLO(nominative.getSpecificaRuolo());
			RubricaGruppoNominativiLocalServiceUtil.updateRubricaGruppoNominativi(rgn);
		}
		
		//logger.info("inserisciNominativo4");
		if (nominative.getEmail()!=null && !"".equals(nominative.getEmail())) {
			//logger.info("inserisciNominativo5");
			String[] s = nominative.getEmail().split(",");
			for (String cont : s) {
				RubricaContatto rc = new RubricaContattoImpl();
				rc.setID_CONTATTO(CounterLocalServiceUtil.increment(RubricaContatto.class.getName()));
				rc.setFK_CANALE(1);
				rc.setFK_NOMINATIVO(rubricaNominativo.getID_NOMINATIVO());
				rc.setCONTATTO(cont.trim());
				rc.setALLERTAMENTO(true);
				rc.setDATA_MODIFICA(new Date());
				rc.setDATA_CREAZIONE(new Date());
				
				//e setto l'utente che sta creando il contatto
				//setto anche quello di modifica uguale a quello di creazione in questa fase
				rc.setFK_UTENTE_CREAZIONE(userId);
				rc.setFK_UTENTE_MODIFICA(userId);
				RubricaContattoLocalServiceUtil.updateRubricaContatto(rc);
			}
			
		}
		
		if (nominative.getTelefono()!=null && !"".equals(nominative.getTelefono())) {
			String[] s = nominative.getTelefono().split(",");
			for (String cont : s) {
				RubricaContatto rc = new RubricaContattoImpl();
				rc.setID_CONTATTO(CounterLocalServiceUtil.increment(RubricaContatto.class.getName()));
				rc.setFK_CANALE(2);
				rc.setFK_NOMINATIVO(rubricaNominativo.getID_NOMINATIVO());
				rc.setCONTATTO(cont.trim());
				rc.setALLERTAMENTO(true);
				rc.setDATA_MODIFICA(new Date());
				rc.setDATA_CREAZIONE(new Date());
				
				//e setto l'utente che sta creando il contatto
				//setto anche quello di modifica uguale a quello di creazione in questa fase
				rc.setFK_UTENTE_CREAZIONE(userId);
				rc.setFK_UTENTE_MODIFICA(userId);
				RubricaContattoLocalServiceUtil.updateRubricaContatto(rc);
			}
			
		}
		
		
		return rubricaNominativo.getID_NOMINATIVO();
		
	}
	
	/**
	 * 
	 * @param gruppi
	 * @param idNominativo
	 * @throws SystemException
	 */
	private void associaGruppiNominativo(List<GroupAssociationRequest> gruppi, Long idNominativo) throws SystemException {
	
		//Se ho dei gruppi li inserisco altrimenti non faccio nulla
	 	for(GroupAssociationRequest gruppoJson : gruppi) {
					
			RubricaGruppoNominativi gruppoNominativo = new RubricaGruppoNominativiImpl();
					
			gruppoNominativo.setFK_NOMINATIVO(idNominativo);
			gruppoNominativo.setFK_RUOLO(gruppoJson.getRoleId());  
			gruppoNominativo.setFK_GRUPPO(gruppoJson.getId());
					
			RubricaGruppoNominativiLocalServiceUtil.updateRubricaGruppoNominativi(gruppoNominativo);
				
			//Logga operazione in RUBRICA_LOG
			aggiornaRubricaLog(TABELLA_RUBRICA_GRUPPO_NOMINATIVI, 
								String.valueOf(gruppoNominativo.getFK_GRUPPO()).concat("-").concat(String.valueOf(gruppoNominativo.getFK_NOMINATIVO())).concat("-").concat(String.valueOf(gruppoNominativo.getFK_RUOLO())),
								TIPO_OPERAZIONE_INSERT,  gruppoNominativo.toString(), userId );
			
		}
		
	}
	
	/**
	 * 
	 * @param idGruppo
	 * @param data
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public List<Long> associaGruppoNominativoMulti(Long idGruppo, String data) throws JsonParseException, JsonMappingException, IOException, SystemException {

		List<Long> listaAssociationError = new ArrayList<>();
		
		//Deserializzo il json
		ObjectMapper mapper = new ObjectMapper();
		GroupNominative[] gruppoNominativoList = mapper.readValue(data, GroupNominative[].class);
	
		for(GroupNominative gruppoNominativo : gruppoNominativoList) {
			
			try {
				RubricaGruppoNominativi rubricaGruppoNominativi = new RubricaGruppoNominativiImpl();
							
				rubricaGruppoNominativi.setFK_GRUPPO(idGruppo);
				rubricaGruppoNominativi.setFK_NOMINATIVO(gruppoNominativo.getNominativeId());
				rubricaGruppoNominativi.setFK_RUOLO(gruppoNominativo.getRole());
				rubricaGruppoNominativi.setSPECIFICA_RUOLO(gruppoNominativo.getSpecificaRuolo());
							
				RubricaGruppoNominativiLocalServiceUtil.updateRubricaGruppoNominativi(rubricaGruppoNominativi);
									
				//Logga operazione in RUBRICA_LOG
				aggiornaRubricaLog(TABELLA_RUBRICA_GRUPPO_NOMINATIVI, 
						String.valueOf(rubricaGruppoNominativi.getFK_GRUPPO()).concat("-").concat(String.valueOf(rubricaGruppoNominativi.getFK_NOMINATIVO())).concat("-").concat(String.valueOf(rubricaGruppoNominativi.getFK_RUOLO())),
						TIPO_OPERAZIONE_INSERT, rubricaGruppoNominativi.toString(), userId );
			
				
				try {
					RubricaNominativo rn = RubricaNominativoLocalServiceUtil.fetchRubricaNominativo(gruppoNominativo.getNominativeId());
					if (rn!=null) {
						rn.setFK_UTENTE_MODIFICA(userId);
						rn.setDATA_MODIFICA(new Date());
						RubricaNominativoLocalServiceUtil.updateRubricaNominativo(rn);
					}
					RubricaGruppo rg = RubricaGruppoLocalServiceUtil.fetchRubricaGruppo(idGruppo);
					if (rg!=null) {
						rg.setFK_UTENTE_MODIFICA(userId);
						rg.setDATA_MODIFICA(new Date());
						RubricaGruppoLocalServiceUtil.updateRubricaGruppo(rg);
					}
				} catch (Exception ee) {
					ee.printStackTrace();
				}
			
			}
			catch (Exception e ){
				listaAssociationError.add(gruppoNominativo.getNominativeId());
			}			
			
		}				
		return listaAssociationError;
	}
	
	
	/**
	 * 
	 * @param idGruppo
	 * @param data
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public List<Long> cancellaGruppoNominativoMulti(Long idGruppo, String data) throws JsonParseException, JsonMappingException, IOException, SystemException {
		
		List<Long> listaDeleteAssociationError = new ArrayList<>();
		
		//Deserializzo il json
		ObjectMapper mapper = new ObjectMapper();
		GroupNominative[] gruppoNominativoList = mapper.readValue(data, GroupNominative[].class);
		
		for(GroupNominative gruppoNominativo : gruppoNominativoList) {
			
			try {
				//carico i dati che sto per cancellare
				RubricaGruppoNominativi rubricaGruppoNominativo=null;
				try {
					rubricaGruppoNominativo = RubricaGruppoNominativiUtil.findByPrimaryKey(new RubricaGruppoNominativiPK(idGruppo, gruppoNominativo.getNominativeId()));
				} catch (NoSuchRubricaGruppoNominativiException e) {
					//logger.error("Errore in cancellazione. Relazione gruppo nominativi non presente", e);
				}
				
				if(null != rubricaGruppoNominativo) {
					RubricaGruppoNominativiLocalServiceUtil.deleteNominativoDaGruppo(idGruppo, gruppoNominativo.getNominativeId());
							
					aggiornaRubricaLog(TABELLA_RUBRICA_GRUPPO_NOMINATIVI, 
								String.valueOf(idGruppo).concat("-").concat(String.valueOf(gruppoNominativo.getNominativeId())).concat("-").concat(String.valueOf(rubricaGruppoNominativo.getFK_RUOLO())), 
								TIPO_OPERAZIONE_DELETE,	rubricaGruppoNominativo.toString(), userId );
						
				
					try {
						RubricaNominativo rn = RubricaNominativoLocalServiceUtil.fetchRubricaNominativo(gruppoNominativo.getNominativeId());
						if (rn!=null) {
							rn.setFK_UTENTE_MODIFICA(userId);
							rn.setDATA_MODIFICA(new Date());
							RubricaNominativoLocalServiceUtil.updateRubricaNominativo(rn);
						}
						RubricaGruppo rg = RubricaGruppoLocalServiceUtil.fetchRubricaGruppo(idGruppo);
						if (rg!=null) {
							rg.setFK_UTENTE_MODIFICA(userId);
							rg.setDATA_MODIFICA(new Date());
							RubricaGruppoLocalServiceUtil.updateRubricaGruppo(rg);
						}
					} catch (Exception ee) {
						ee.printStackTrace();
					}
				
				} else {
					listaDeleteAssociationError.add(gruppoNominativo.getNominativeId());
				}
				
			} catch(Exception e) {
				listaDeleteAssociationError.add(gruppoNominativo.getNominativeId());
			}
		}	
		
		return listaDeleteAssociationError;
	}
	
	/**
	 * 
	 * @param contatti
	 * @param idNominativo
	 * @throws SystemException
	 */
	private void associaContattiNominativo(List<Contact> contatti, Long idNominativo) throws SystemException {
		
		for(Contact contatto : contatti) {
		
			RubricaContatto rubricaContatto = new RubricaContattoImpl();
				
			//setto l'id
			rubricaContatto.setID_CONTATTO(CounterLocalServiceUtil.increment(RubricaContatto.class.getName()));
				
			//Setto la FK del nominativo
			rubricaContatto.setFK_NOMINATIVO(idNominativo);
				
			rubricaContatto.setALLERTAMENTO(contatto.isWarning());
			rubricaContatto.setFK_CANALE(contatto.getChannelId());
			rubricaContatto.setCONTATTO(contatto.getValue().trim());			
			rubricaContatto.setDATA_FINE_VALIDITA(null != contatto.getExpiredDate() ? new Date(contatto.getExpiredDate()*1000) : null);	
			
			//in inserimento data creazione e modifica saranno le stesse
			rubricaContatto.setDATA_MODIFICA(new Date());
			rubricaContatto.setDATA_CREAZIONE(new Date());
				
			//setto l'id dell'utente che sta creando il contatto e quello di modifica in modo uguale
			rubricaContatto.setFK_UTENTE_CREAZIONE(userId);
			rubricaContatto.setFK_UTENTE_MODIFICA(userId);
			rubricaContatto.setMODIFICA_MINORE(false);
				
			RubricaContattoLocalServiceUtil.updateRubricaContatto(rubricaContatto);
						
			//Logga operazione in RUBRICA_LOG
			aggiornaRubricaLog(TABELLA_RUBRICA_CONTATTO, String.valueOf(rubricaContatto.getID_CONTATTO()),TIPO_OPERAZIONE_INSERT, rubricaContatto.toString(), userId );
			
		}	
	}

	/**
	 * Aggiorna nominativo
	 * Ritorna la mappa con l'esito dell'operazione
	 * 
	 * @param nominativo
	 * @throws SystemException 
	 * @throws ParseException 
	 * @throws JSONException 
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public Map<String, Object> aggiornaNominativo(Long id, String data) throws SystemException, JSONException, ParseException, JsonParseException, JsonMappingException, IOException{
	
		Map<String,Object> mappa = new HashMap<String, Object>();
		List<String> errValidNominative = new ArrayList<>();
		
		//Deserializzo il json
		ObjectMapper mapper = new ObjectMapper();
		NominativeUpdateRequest nominative = mapper.readValue(data, NominativeUpdateRequest.class);
	
		if(null != nominative) {
			
			RubricaJsonValidation validator = new RubricaJsonValidation();
			errValidNominative = validator.validateNominative(nominative);
			
			if(null != errValidNominative && errValidNominative.isEmpty()) {
			
				RubricaNominativo nominativeUpdate = new RubricaNominativoImpl();
				
				try {
					nominativeUpdate = RubricaNominativoUtil.findByPrimaryKey(id);
				} catch (NoSuchRubricaNominativoException e) {
					//logger.error("Errore in fase di aggiornamento, nominativo non presente", e);
					mappa.put(CODE, 400);
					mappa.put(ERROR, "nominativo non presente impossibile aggiornare");
					return mappa;
				}
				
				if(null != nominativeUpdate) {
					
					//Logga operazione in RUBRICA_LOG con il valore precedente
					aggiornaRubricaLog(TABELLA_RUBRICA_NOMINATIVO, String.valueOf(nominativeUpdate.getID_NOMINATIVO()),TIPO_OPERAZIONE_UPDATE, nominativeUpdate.toString(), userId );
					
					//imposto la data di modifica all'attuale
					if (!nominative.isModificaMinore()) {
						nominativeUpdate.setDATA_MODIFICA(new Date());
					
					//Imposto l'utente che sta modificando
						nominativeUpdate.setFK_UTENTE_MODIFICA(userId);
					}
					
					//Imposto i valori passati nel json
					nominativeUpdate.setCOGNOME(nominative.getLastName().trim());
					nominativeUpdate.setNOME(nominative.getFirstName().trim());
					nominativeUpdate.setINDIRIZZO(nominative.getAddress().trim());
					nominativeUpdate.setMODIFICA_MINORE(nominative.isModificaMinore());
					
					RubricaNominativoLocalServiceUtil.updateRubricaNominativo(nominativeUpdate);
					
					mappa.put(CODE, 204 );
					mappa.put(SUCCESS, "aggiornamento avvenuto con successo");
				
				} else {
					mappa.put(CODE, 400);
					mappa.put(ERROR, "nominativo non presente impossibile aggiornare");
				} 
			} else {
				mappa.put(CODE, 400);
				mappa.put(ERROR, errValidNominative);
			}
		} else {
			mappa.put(CODE, 400);
			mappa.put(ERROR, GENERIC_ERROR);
		}
		
		return mappa;
	}
	
	/**
	 * 
	 * @param idNominativo
	 * @return 
	 * @throws SystemException
	 * @throws ParseException
	 * @throws PortalException
	 */
	public Map<String, Object> eliminaNominativo(Long idNominativo) throws SystemException, ParseException, PortalException {
	
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		//Carico il dato che sto per cancellare
		RubricaNominativo nominativoDel = RubricaNominativoUtil.fetchByPrimaryKey(idNominativo);
		
		if(null != nominativoDel && !nominativoDel.isDISABLED()) { //cancello solo quelli attivi
			
			//Aggiorno la tabella di log con il vecchio valore
			aggiornaRubricaLog(TABELLA_RUBRICA_NOMINATIVO, String.valueOf(idNominativo), TIPO_OPERAZIONE_DELETE, nominativoDel.toString(), userId );

			//Setto enabled su false per cancellarlo logicamente
			nominativoDel.setDISABLED(true);
			//Setto user e data ultimo modifica
			nominativoDel.setFK_UTENTE_MODIFICA(userId);
			nominativoDel.setDATA_MODIFICA(new Date());
			
			//effetto la cancellazione logica con update
			RubricaNominativoLocalServiceUtil.updateRubricaNominativo(nominativoDel);
			
			mappa.put(CODE, 204 );
			mappa.put(SUCCESS, "cancellazione avvenuta con successo");
			
		} else {
			
			mappa.put(CODE, 404 );
			mappa.put(ERROR, "nominativo non presente, impossibile cancellare");
		}
		
		return mappa;
	}
	
	public List<Long> eliminaContattiByNominativo(Long idNominativo, String data) throws JsonParseException, JsonMappingException, IOException, SystemException {
		
		List<Long> listaDelContattiError = new ArrayList<>();
		
		//Deserializzo il json
		ObjectMapper mapper = new ObjectMapper();
		Contact[] contattiList = mapper.readValue(data, Contact[].class);
		
		for(Contact contattoDel : contattiList){
				
			try {
				//carico il contatto 
				RubricaContatto contatto = RubricaContattoUtil.fetchByPrimaryKey(contattoDel.getId());
	
				if(null != contatto && null == contatto.getDATA_FINE_VALIDITA() && contatto.getFK_NOMINATIVO() == idNominativo){ //cancello solo quelli null,  ancora attivi per il nominativo 
				
					//Aggiorna Log con i dati del contatto che sto per cancellare
					aggiornaRubricaLog(TABELLA_RUBRICA_CONTATTO, String.valueOf(contatto.getID_CONTATTO()), TIPO_OPERAZIONE_DELETE, contatto.toString(), userId );
					
					//Setto la data fine validità corrente per cancellarlo logicamente
					contatto.setDATA_FINE_VALIDITA(new Date());
					
					contatto.setDATA_MODIFICA(new Date());
					contatto.setFK_UTENTE_MODIFICA(userId);
					
					RubricaContattoLocalServiceUtil.updateRubricaContatto(contatto);		
					
					
				}
			} catch (Exception e) {
				listaDelContattiError.add(contattoDel.getId());
			}
		}
		
		return listaDelContattiError;
	}
	
	/**
	 * 
	 * @param idNominativo
	 * @param data
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SystemException
	 */
	public List<Long> associaNominativoGruppiMulti(Long idNominativo, String data) throws JsonParseException, JsonMappingException, IOException, SystemException {
		
		List<Long> listaAssociationError = new ArrayList<>();
		
		//Deserializzo il json
		ObjectMapper mapper = new ObjectMapper();
		GroupAssociationRequest[] gruppoAssociationList = mapper.readValue(data, GroupAssociationRequest[].class);
	
		for(GroupAssociationRequest gruppoAssociation : gruppoAssociationList) {
			
			try {
				
				RubricaGruppoNominativi gruppoNominativo = new RubricaGruppoNominativiImpl();
				
				gruppoNominativo.setFK_NOMINATIVO(idNominativo);
				gruppoNominativo.setFK_RUOLO(gruppoAssociation.getRoleId());  
				gruppoNominativo.setFK_GRUPPO(gruppoAssociation.getId());
				gruppoNominativo.setSPECIFICA_RUOLO(gruppoAssociation.getSpecificaRuolo());
						
				RubricaGruppoNominativiLocalServiceUtil.updateRubricaGruppoNominativi(gruppoNominativo);
					
				//Logga operazione in RUBRICA_LOG
				aggiornaRubricaLog(TABELLA_RUBRICA_GRUPPO_NOMINATIVI, 
									String.valueOf(gruppoNominativo.getFK_GRUPPO()).concat("-").concat(String.valueOf(gruppoNominativo.getFK_NOMINATIVO())).concat("-").concat(String.valueOf(gruppoNominativo.getFK_RUOLO())),
									TIPO_OPERAZIONE_INSERT,  gruppoNominativo.toString(), userId );
				
			}
			catch (Exception e ){
				listaAssociationError.add(gruppoAssociation.getId());
			}			
			
		}				
		return listaAssociationError;
	}

	/**
	 * 
	 * @param idNominativo
	 * @param data
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SystemException
	 */
	public List<Long> cancellaNominativoGruppiMulti(Long idNominativo, String data) throws JsonParseException, JsonMappingException, IOException, SystemException {
		
		List<Long> listaDeleteError = new ArrayList<>();
		
		//Deserializzo il json
		ObjectMapper mapper = new ObjectMapper();
		GroupAssociationRequest[] gruppoNominativoDeleteList = mapper.readValue(data, GroupAssociationRequest[].class);
	
		for(GroupAssociationRequest gruppoNominativoDelete : gruppoNominativoDeleteList) {
			try {	
				//carico i dati che sto per cancellare
				RubricaGruppoNominativi rubricaGruppoNominativo = null;
				try {
					rubricaGruppoNominativo = RubricaGruppoNominativiUtil.findByPrimaryKey(new RubricaGruppoNominativiPK(gruppoNominativoDelete.getId(), idNominativo));
				} catch (NoSuchRubricaGruppoNominativiException e) {
					//logger.error("Errore in cancellazione. Relazione gruppo nominativi non presente", e);
				}
				
				//Aggiorna Log
				if(null!=rubricaGruppoNominativo) {

					RubricaGruppoNominativiLocalServiceUtil.deleteNominativoDaGruppo(gruppoNominativoDelete.getId(), idNominativo);
						
					aggiornaRubricaLog(TABELLA_RUBRICA_GRUPPO_NOMINATIVI, 
								String.valueOf(gruppoNominativoDelete.getId()).concat("-").concat(String.valueOf(idNominativo)).concat("-").concat(String.valueOf(rubricaGruppoNominativo.getFK_RUOLO())), 
								TIPO_OPERAZIONE_DELETE,	rubricaGruppoNominativo.toString(), userId );
					
				}
			}				
			catch(Exception e) {
				listaDeleteError.add(gruppoNominativoDelete.getId());
			}
		}
		return listaDeleteError;
	}
	
	/**
	 * 
	 * @param idNominativo
	 * @param  
	 * @return
	 * @throws SystemException
	 * @throws ParseException
	 * @throws PortalException
	 * @throws IOException
	 */
	public Nominative loadNominativoById(Long idSite, Long idNominativo) throws SystemException, ParseException, PortalException, IOException {
	
		//carico il nominativo 
		//il nominativo viene caricato solo se appartiene allo stesso proprietario
		//logger.info("loadNominativoById:"+idSite+","+idNominativo);
		RubricaNominativo nominativo = RubricaNominativoLocalServiceUtil.fetchRubricaNominativo(idNominativo);
				
		if(null != nominativo && 
		  ! nominativo.isDISABLED() && 
		  nominativo.getFK_SITO_PROPRIETARIO() == idSite.longValue()) { //carico solo quelli attivi per il sito proprietario
			
			//creo e popolo l'oggetto nominativo chiamando il metodo popolateNominativo che al suo interno carica anche i contatti associati al nominativo
			Nominative nominativeJson = new Nominative();
			nominativeJson = RubricaStructureCustomService.popolateNominative(null, nominativo);
			if (nominativo.getFK_SITO_PROPRIETARIO()!=0) {
				nominativeJson.setOwner(RubricaSitoLocalServiceUtil.fetchRubricaSito(nominativo.getFK_SITO_PROPRIETARIO()).getNOME());
			}
			//Estrai i gruppi associati al nominativo
			List<RubricaGruppoNominativi> listaGruppoNominativo = RubricaGruppoNominativiUtil.findByRubricaGruppoRuoloByNominativo(nominativo.getID_NOMINATIVO());
			List<it.eng.allerte.custom.jsonRubrica.Group> listaGruppi = new ArrayList<>();
			//logger.info("gruppi:"+listaGruppoNominativo.size());
			if(null != listaGruppoNominativo) {
				//Creo l'oggetto con nome gruppo e lo aggiungo alla lista
				for(RubricaGruppoNominativi gruppoNominativo : listaGruppoNominativo) {
								
					//Considero solo i gruppi del proprietario
					RubricaGruppo rubGruppo = RubricaGruppoUtil.findByPrimaryKey(gruppoNominativo.getFK_GRUPPO());
					//logger.info("Gruppo "+rubGruppo.getNOME());
					if(null != rubGruppo && rubGruppo.getFK_SITO_PROPRIETARIO() == idSite.longValue()) {
						//logger.info("Entro");
						it.eng.allerte.custom.jsonRubrica.Group gruppo = new it.eng.allerte.custom.jsonRubrica.Group();
						gruppo.setId(gruppoNominativo.getFK_GRUPPO());
						gruppo.setName(rubGruppo.getNOME());
						
						//estraggo le info sul ruolo
						RubricaRuolo role = RubricaRuoloLocalServiceUtil.fetchRubricaRuolo(gruppoNominativo.getFK_RUOLO());
						//logger.info("Ruolo "+gruppoNominativo.getFK_RUOLO());
						if(null != role ) {
							//logger.info("Ruolo trovato: "+role.getDESCRIZIONE());
							gruppo.setRole(role.getDESCRIZIONE());
							gruppo.setSpecificaRuolo(gruppoNominativo.getSPECIFICA_RUOLO());
						}
							
						listaGruppi.add(gruppo);
					}
				}
			}
			
			nominativeJson.setGroups(listaGruppi);
					
			return nominativeJson;
			
		}
		else {
			return null;
		}
	
	}
	
	/**
	 * 
	 * @param idSite
	 * @param name
	 * @param limit
	 * @param offset
	 * @return
	 * @throws SystemException
	 * @throws ParseException
	 * @throws PortalException
	 * @throws JsonProcessingException
	 */
	public List<Nominative> loadNominativoByName(long idSite, String name, Long limit, Long offset) throws SystemException, ParseException, PortalException, JsonProcessingException {
	
		//carico il nominativo
		List<Object[]> listaNominativiObj = RubricaNominativoLocalServiceUtil.getNominativiByName(name, limit, offset) ;
	
		List<Nominative> listaNominativiJson = new ArrayList<>();
		
		if(listaNominativiObj.size() > 0) {
								
			List<RubricaNominativo> listaNominativi = new ArrayList<>();
			
			listaNominativi = toRubricaNominativo(listaNominativiObj);
			
			//Creo gli oggetti JSON
			for(RubricaNominativo nominativo : listaNominativi) {
			
				//Carico solo quelli attivi e per il proprietario
				if(! nominativo.isDISABLED() && nominativo.getFK_SITO_PROPRIETARIO() == idSite) {
				
					//creo e popolo l'oggetto nominativo chiamando il metodo popolateNominativo che al suo interno carica anche i contatti associati al nominativo
					Nominative nominativeJson = new Nominative();
					nominativeJson = RubricaStructureCustomService.popolateNominative(null, nominativo);

					//Estra i gruppi associati al nominativo
					List<RubricaGruppoNominativi> listaGruppoNominativo = RubricaGruppoNominativiUtil.findByRubricaGruppoRuoloByNominativo(nominativo.getID_NOMINATIVO());
					List<it.eng.allerte.custom.jsonRubrica.Group> listaGruppi = new ArrayList<>();
					
					if(null != listaGruppoNominativo) {
						//Carica e setta il dettaglio per ogni gruppo
						for(RubricaGruppoNominativi gruppoNominativo : listaGruppoNominativo) {
							
							//considero solo i gruppi del proprietario
							RubricaGruppo rubGruppo = RubricaGruppoUtil.findByPrimaryKey(gruppoNominativo.getFK_GRUPPO());
							
							if(rubGruppo.getFK_SITO_PROPRIETARIO() == idSite) {
								it.eng.allerte.custom.jsonRubrica.Group gruppo = new it.eng.allerte.custom.jsonRubrica.Group();
								gruppo.setId(gruppoNominativo.getFK_GRUPPO());
								
								gruppo.setName(rubGruppo.getNOME());
								
								//estraggo le info sul ruolo
								RubricaRuoloRubrica role = RubricaRuoloRubricaLocalServiceUtil.fetchRubricaRuoloRubrica(gruppoNominativo.getFK_RUOLO());
								
								if(null != role ) {
									gruppo.setRole(role.getDESCRIZIONE());
								}															
								listaGruppi.add(gruppo);
							}
						}
					}
					
					nominativeJson.setGroups(listaGruppi);
					listaNominativiJson.add(nominativeJson);
				}
			}
		}
		
		return listaNominativiJson;
	}

	
	/**
	 * 
	 * @param listaNominativiObj
	 * @return
	 */
	private List<RubricaNominativo> toRubricaNominativo(List<Object[]> listaNominativiObj) {
		
		List<RubricaNominativo> listaNominativi = new ArrayList<>();
				
		//Trasformo la lista
		for (Object[] objectNominativo : listaNominativiObj) {
			
			//Creo un nuovo oggetto
			RubricaNominativo nominativo = new RubricaNominativoImpl();
			nominativo.setID_NOMINATIVO((long) objectNominativo[0]);
			nominativo.setCOGNOME((String) objectNominativo[1]);
			nominativo.setNOME((String) objectNominativo[2]);
			nominativo.setINDIRIZZO((String) objectNominativo[3]);
			nominativo.setFK_SITO_PROPRIETARIO((long) objectNominativo[4]);
			nominativo.setFK_UTENTE_PORTALE((long) objectNominativo[5]);
			nominativo.setFK_UTENTE_CREAZIONE((long) objectNominativo[6]);
			nominativo.setDATA_CREAZIONE((Date) objectNominativo[7]);
			nominativo.setFK_UTENTE_MODIFICA((long) objectNominativo[8]);
			nominativo.setDATA_MODIFICA((Date) objectNominativo[9]);
			nominativo.setDISABLED((boolean)objectNominativo[10]) ;
			
			listaNominativi.add(nominativo);
		
		}
		
		return listaNominativi;
	}
	
	
	
	
	//------------ FINE RUBRICA NOMINATIVO -----------//
	
	
	//------------ INIZIO RUBRICA CONTATTO -----------//
//	/**
//	 * Metodo che inserisce un contatto in rubrica
//	 * L'inserimento avviene in RUBRICA_NOMINATIVO, RUBRICA_CONTATTO, RUBRICA_GRUPPO_NOMINATIVO
//	 * Ogni operazione svolta in questa fase viene loggata nella tabella RUBRICA_LOG
//	 * 
//	 * @param contatto
//	 * @throws JSONException
//	 * @throws SystemException
//	 * @throws ParseException
//	 */
//	@Transactional(isolation = Isolation.PORTAL, propagation=Propagation.REQUIRED)
//	public void inserimentoContattoInRubrica(String contatto) throws JSONException, SystemException, ParseException {
//		
//		Long idNominativo = inserimentoRubricaNominativo(contatto);
//		
//		//Se ho inserito un nominativo valido inserisco alche contatto e gruppo
//		if(null != idNominativo) {
//		
//			inserimentoRubricaContattoByNominativo(contatto, idNominativo);
//			
//			inserimentoGruppoNominativo(contatto, idNominativo);
//		
//		} else {
//			//FIXME eventualmente lancia eccezione 
//		}
//		
//	}
	
//	@Transactional(isolation = Isolation.PORTAL, propagation=Propagation.REQUIRED)
//	public void inserimentoContattoInRubricaNew(String contatto) throws JSONException, SystemException, ParseException, JsonParseException, JsonMappingException, IOException {
//		
//		ObjectMapper mapper = new ObjectMapper();
//		
//		NominativeInputJson nominative = mapper.readValue(contatto,NominativeInputJson.class);
//		
//		//preparo l'oggetto nominativo da inserire
//		if(null != nominative) {
//			
//			Long idNominativo = inserimentoRubricaNominativoNew(nominative);
//			
//			//inserisco eventuali contatti e gruppi associati
//			if(null!=nominative.getContacts() && nominative.getContacts().size() > 0 )  {
//				inserimentoRubricaContattoByNominativoNew(nominative.getContacts(), idNominativo);
//			}
//			if(null!=nominative.getGroups() && nominative.getGroups().size() > 0) {
//				inserimentoGruppoNominativoNew(nominative.getGroups(), idNominativo);
//			}
//					
//		} else {
//			//ritorna messaggio 
//		}
//	}
	
//	/**
//	 * 
//	 * Metodo che aggiorna un contatto in rubrica
//	 * L'aggiornamento avviene sulle tabelle RUBRICA_NOMINATIVO, RUBRICA_CONTATTO, RUBRICA_GRUPPO_NOMINATIVO
//	 * Ogni operazione svolta in questa fase viene loggata nella tabella RUBRICA_LOG
//	 * 
//	 * @param contatto
//	 * @throws JSONException
//	 * @throws SystemException
//	 * @throws ParseException
//	 */
//	@Transactional(isolation = Isolation.PORTAL, propagation=Propagation.REQUIRED)
//	public void aggiornaContattoInRubrica(String contatto) throws JSONException, SystemException, ParseException {
//		
//		Long idNominativo = aggiornaNominativo(contatto);
//		
//		//Se mi viene passato un contatto continuo con l'inserimento degli altri dati
//		if(null != idNominativo) {
//			
//			aggiornaRubricaContatto(contatto, idNominativo);
//			
//			aggiornaRubricaGruppoNomintativi(contatto, idNominativo);
//		
//		} else {
//			//FIXME eventualmente lancia eccezione
//		}
//		
//	}
	
	/**
	 * 
	 * @param data
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SystemException
	 */
	public Map<String, Object> associaContattoNominativo(String data) throws JsonParseException, JsonMappingException, IOException, SystemException {
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		List<String> errValid = new ArrayList<>();
				
		//Deserializzo il json
		ObjectMapper mapper = new ObjectMapper();
		ContactRequest contact = mapper.readValue(data, ContactRequest.class);
		
		if(null!=contact) {
		
			//Valida dati
			RubricaJsonValidation validator = new RubricaJsonValidation();
			errValid = validator.validaContactRequest(contact);
			
			if(null != errValid && errValid.isEmpty()) {
			
				RubricaContatto rubricaContatto = new RubricaContattoImpl();
				
				//setto l'id
				rubricaContatto.setID_CONTATTO(CounterLocalServiceUtil.increment(RubricaContatto.class.getName()));
				
				//Setto la FK del nominativo
				rubricaContatto.setFK_NOMINATIVO(contact.getNominativeId());
				
				rubricaContatto.setALLERTAMENTO(contact.isWarning());
				rubricaContatto.setFK_CANALE(contact.getChannelId());
				rubricaContatto.setCONTATTO(contact.getValue().trim());
				rubricaContatto.setDATA_FINE_VALIDITA(null != contact.getExpiredDate() ? new Date (contact.getExpiredDate()*1000) : null);
				
				//in inserimento data ins e modifica saranno le stesse
				rubricaContatto.setDATA_MODIFICA(new Date());
				rubricaContatto.setDATA_CREAZIONE(new Date());
				
				//setto l'id dell'utente che sta creando il contatto e quello di modifica in modo uguale
				rubricaContatto.setFK_UTENTE_CREAZIONE(userId);
				rubricaContatto.setFK_UTENTE_MODIFICA(userId);
				rubricaContatto.setMODIFICA_MINORE(false);
				
				RubricaContattoLocalServiceUtil.updateRubricaContatto(rubricaContatto);
						
				//Logga operazione in RUBRICA_LOG
				aggiornaRubricaLog(TABELLA_RUBRICA_CONTATTO, String.valueOf(rubricaContatto.getID_CONTATTO()),TIPO_OPERAZIONE_INSERT, rubricaContatto.toString(), userId );
			
			    mappa.put(CODE, 201);
			    mappa.put(SUCCESS, "contatto associato con successo");
				
			} else {
				mappa.put(CODE, 400);
				mappa.put(ERROR, errValid);
			}
		} else {
			mappa.put(CODE, 400);
			mappa.put(ERROR, "errore nella richiesta");
		}
			
		return mappa;
	}
	


	/**
	 * 
	 * @param id
	 * @throws SystemException
	 * @throws PortalException
	 */
	public Map<String, Object> eliminaContatto(Long id) throws SystemException, PortalException {
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		//carico il contatto 
		RubricaContatto contatto = RubricaContattoUtil.fetchByPrimaryKey(id);

		if(null != contatto && null == contatto.getDATA_FINE_VALIDITA()){ //cancello solo quelli null,  ancora attivi
		
			//Aggiorna Log con i dati del contatto che sto per cancellare
			aggiornaRubricaLog(TABELLA_RUBRICA_CONTATTO, String.valueOf(id), TIPO_OPERAZIONE_DELETE, contatto.toString(), userId );
			
			//Setto la data fine validità corrente per cancellarlo logicamente
			contatto.setDATA_FINE_VALIDITA(new Date());
			
			contatto.setDATA_MODIFICA(new Date());
			contatto.setFK_UTENTE_MODIFICA(userId);
			
			RubricaContattoLocalServiceUtil.updateRubricaContatto(contatto);
					
			mappa.put(CODE, 204 );
			mappa.put(SUCCESS, "cancellazione avvenuta con successo");
			
		} else {
			
			mappa.put(CODE, 404 );
			mappa.put(ERROR, "contatto non presente, impossibile cancellare");
		}
				
		return mappa;
	}
	
	
	/**
	 * 
	 * @param data
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public List<Long> eliminaContattiMulti(String data) throws JsonParseException, JsonMappingException, IOException, SystemException {
		
		List<Long> listaDelContattiError = new ArrayList<>();
		
		//Deserializzo il json
		ObjectMapper mapper = new ObjectMapper();
		Contact[] contattiList = mapper.readValue(data, Contact[].class);
		
		for(Contact contattoDel : contattiList){
				
			try {
				//carico il contatto 
				RubricaContatto contatto = RubricaContattoUtil.fetchByPrimaryKey(contattoDel.getId());
	
				if(null != contatto && null == contatto.getDATA_FINE_VALIDITA()){ //cancello solo quelli null,  ancora attivi
				
					//Aggiorna Log con i dati del contatto che sto per cancellare
					aggiornaRubricaLog(TABELLA_RUBRICA_CONTATTO, String.valueOf(contatto.getID_CONTATTO()), TIPO_OPERAZIONE_DELETE, contatto.toString(), userId );
					
					//Setto la data fine validità corrente per cancellarlo logicamente
					contatto.setDATA_FINE_VALIDITA(new Date());
					
					contatto.setDATA_MODIFICA(new Date());
					contatto.setFK_UTENTE_MODIFICA(userId);
					
					RubricaContattoLocalServiceUtil.updateRubricaContatto(contatto);		
					
					
				}
			} catch (Exception e) {
				listaDelContattiError.add(contattoDel.getId());
			}
		}
		
		return listaDelContattiError;
	}
	
	
	/**
	 * 
	 * @param id
	 * @param data
	 * @return
	 * @throws SystemException
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public Map<String, Object> aggiornaContatto(long id, String data) throws SystemException, JsonParseException, JsonMappingException, IOException {
	
		Map<String,Object> mappa = new HashMap<String, Object>();
		List<String> errValid = new ArrayList<>();
		
		//Deserializzo il json
		ObjectMapper mapper = new ObjectMapper();
		ContactRequest contactRequest = mapper.readValue(data, ContactRequest.class);
	
		if(null != contactRequest) {
			
			RubricaJsonValidation validator = new RubricaJsonValidation();
			errValid = validator.validaContactRequest(contactRequest);
			
			if(null != errValid && errValid.isEmpty()) {
			
				RubricaContatto contactUpdate = new RubricaContattoImpl();
				
				try {
					contactUpdate = RubricaContattoUtil.findByPrimaryKey(id);
				} catch (NoSuchRubricaContattoException e) {
					//logger.error("Errore in aggiornamento. Contatto non presente", e);
					mappa.put(CODE, 400);
					mappa.put(ERROR, "contatto non presente impossibile aggiornare");
					return mappa;
				}
				
				if(null != contactUpdate) {
					
					//Logga operazione in RUBRICA_LOG con il valore precedente
					aggiornaRubricaLog(TABELLA_RUBRICA_CONTATTO, String.valueOf(id),
									TIPO_OPERAZIONE_UPDATE, contactUpdate.toString(), userId );
					
					//imposto la data di modifica all'attuale
					if (!contactRequest.isModificaMinore()) {
						contactUpdate.setDATA_MODIFICA(new Date());
						contactUpdate.setFK_UTENTE_MODIFICA(userId);
					}
					
					//Imposto l'utente che sta modificando
					
					
					//Imposto i valori passati nel json
					contactUpdate.setCONTATTO(contactRequest.getValue().trim());
					contactUpdate.setDATA_FINE_VALIDITA(null != contactRequest.getExpiredDate() ? new Date(contactRequest.getExpiredDate()*1000) : null);
					contactUpdate.setALLERTAMENTO(contactRequest.isWarning());
					contactUpdate.setFK_CANALE(contactRequest.getChannelId());
					contactUpdate.setFK_NOMINATIVO(contactRequest.getNominativeId());
					contactUpdate.setMODIFICA_MINORE(contactRequest.isModificaMinore());
					
					RubricaContattoLocalServiceUtil.updateRubricaContatto(contactUpdate);
					
					mappa.put(CODE, 204 );
					mappa.put(SUCCESS, "aggiornamento avvenuto con successo");
				
				} else {
					mappa.put(CODE, 400);
					mappa.put(ERROR, "contatto non presente impossibile aggiornare");
					return mappa;
				} 
			} else {
				mappa.put(CODE, 400);
				mappa.put(ERROR, errValid);
			}
		} else {
			mappa.put(CODE, 400);
			mappa.put(ERROR, GENERIC_ERROR);
		}
		
		return mappa;
		
	}

	
	/**
	 * 
	 * @param idNominativo
	 * @return 
	 * @throws SystemException
	 * @throws ParseException
	 * @throws PortalException
	 */
	public Map<String, Object> eliminaNominativoAll(Long idNominativo) throws SystemException, ParseException, PortalException {
	
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		mappa = eliminaNominativo(idNominativo);
		
		//eliminaContattoByIdNominativo(idNominativo);
		
		//eliminaGruppoByIdNominativo(idNominativo);
		
		return mappa;
	}
		
	/**
	 * 
	 * @param data
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SystemException
	 */
	public List<Long> cancellaNominativoMulti(String data) throws JsonParseException, JsonMappingException, IOException, SystemException {
		
		List<Long> listaDelNominativiError = new ArrayList<>();
		
		//Deserializzo il json
		ObjectMapper mapper = new ObjectMapper();
		Role[] nominativiList = mapper.readValue(data, Role[].class);
		
		for(Role nominativo : nominativiList){
				
			try {
				//Carico il dato che sto per cancellare
				RubricaNominativo nominativoDel = RubricaNominativoUtil.fetchByPrimaryKey(nominativo.getId());
				
				if(null != nominativoDel && !nominativoDel.isDISABLED()) { //cancello solo quelli attivi
					
					//Aggiorno la tabella di log con il vecchio valore
					aggiornaRubricaLog(TABELLA_RUBRICA_NOMINATIVO, String.valueOf(nominativo.getId()), TIPO_OPERAZIONE_DELETE, nominativoDel.toString(), userId );
	
					//Setto enabled su false per cancellarlo logicamente
					nominativoDel.setDISABLED(true);
					//Setto user e data ultimo modifica
					nominativoDel.setFK_UTENTE_MODIFICA(userId);
					nominativoDel.setDATA_MODIFICA(new Date());
					
					//effetto la cancellazione logica con update
					RubricaNominativoLocalServiceUtil.updateRubricaNominativo(nominativoDel);
											
				} 
			}
			catch (Exception e ) {
				listaDelNominativiError.add(nominativo.getId());
			}
		}
		
		
		return listaDelNominativiError;
	}
	

	//------------ FINE RUBRICA CONTATTO -----------//
	
	

	//------------ INIZIO RUBRICA GRUPPO -----------//
	
	/**
	 * 
	 * @param data
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SystemException
	 */
	public Map<String, Object> creaGruppo(String data) throws JsonParseException, JsonMappingException, IOException, SystemException {
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		List<String> errValid = new ArrayList<>();
		
		//Deserializzo il json
		ObjectMapper mapper = new ObjectMapper();
		GroupCreateRequest group = mapper.readValue(data, GroupCreateRequest.class);
		
		RubricaGruppo rubricaGruppo = new RubricaGruppoImpl();
		
		//Se ho qualcosa da inserire procedo
		if(null != group ) {
			
			RubricaJsonValidation validator = new RubricaJsonValidation();
			errValid = validator.validateGroupCreateRequest(group, groupId);
			
			if(null != errValid && errValid.isEmpty()) {
			
				//setto l'id
				rubricaGruppo.setID_GRUPPO(CounterLocalServiceUtil.increment(RubricaGruppo.class.getName()));
				
				//Setto l'id dell'utente creatore
				rubricaGruppo.setFK_UTENTE_CREAZIONE(userId);
				rubricaGruppo.setFK_UTENTE_MODIFICA(userId);
				
				rubricaGruppo.setFK_SITO_PROPRIETARIO(groupId);
				rubricaGruppo.setNOME(group.getName().trim());
				rubricaGruppo.setFK_CATEGORIA(group.getCategoria());
				
				//In inserimento sovrascrivo data modifica a null
				rubricaGruppo.setDATA_CREAZIONE(new Date());
				rubricaGruppo.setDATA_MODIFICA(new Date());
			
				RubricaGruppoLocalServiceUtil.updateRubricaGruppo(rubricaGruppo);
				
				//Aggiorna Log
				aggiornaRubricaLog(TABELLA_RUBRICA_GRUPPO, String.valueOf(rubricaGruppo.getID_GRUPPO()),TIPO_OPERAZIONE_INSERT, rubricaGruppo.toString(), userId );
				   
			    mappa.put(CODE, 201);
			    mappa.put(SUCCESS, "inserimento avvenuto con successo");
			
			} else {
				mappa.put(CODE, 400);
				mappa.put(ERROR, errValid);
			}
		
		} else {
			mappa.put(CODE, 400);
			mappa.put(ERROR, GENERIC_ERROR);
		}
		
		return mappa;
		
	}

	
	/**
	 * 
	 * @param id
	 * @param data
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SystemException
	 * @throws NoSuchRubricaGruppoException 
	 */
	public Map<String, Object> aggiornaGruppo(Long id, String data) throws JsonParseException, JsonMappingException, IOException, SystemException {
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		List<String> errValid = new ArrayList<>();
		
		//Deserializzo il json
		ObjectMapper mapper = new ObjectMapper();
		GroupCreateRequest group = mapper.readValue(data, GroupCreateRequest.class);
		
		if(null != group) {

			RubricaGruppo rubricaGruppo = new RubricaGruppoImpl();
			
			try {
				rubricaGruppo = RubricaGruppoUtil.findByPrimaryKey(id);
			} catch (NoSuchRubricaGruppoException e) {
				//logger.error("Errore in fase di aggiornamento gruppo. Gruppo non trovato", e);
				mappa.put(CODE, 404 );
				mappa.put(ERROR, "impossibile aggiornare, gruppo non trovato");
				return mappa;
			}			
			if(null != rubricaGruppo) {
			
				RubricaJsonValidation validator = new RubricaJsonValidation();
				//errValid = validator.validateGroupCreateRequest(group, groupId);
				
				if(null != errValid && errValid.isEmpty()) {
				
					//Aggiorna Log con valore precedente
					aggiornaRubricaLog(TABELLA_RUBRICA_GRUPPO, String.valueOf(rubricaGruppo.getID_GRUPPO()), TIPO_OPERAZIONE_UPDATE, rubricaGruppo.toString(), userId );
					
					//Setto l'id dell'utente che sta modificando
					rubricaGruppo.setFK_UTENTE_MODIFICA(userId);
					
					//setto la data modifica all'attuale
					rubricaGruppo.setDATA_MODIFICA(new Date());
					
					//setto le modifiche secondo il json ricevuto
					rubricaGruppo.setNOME(group.getName().trim());
					//rubricaGruppo.setFK_SITO_PROPRIETARIO(groupId);
					
					rubricaGruppo.setFK_CATEGORIA(group.getCategoria());
								
					RubricaGruppoLocalServiceUtil.updateRubricaGruppo(rubricaGruppo);
												
					mappa.put(CODE, 204 );
					mappa.put(SUCCESS, "aggiornamento avvenuto con successo");
				}
				
				else {
					mappa.put(CODE, 400);
					mappa.put(ERROR, errValid);
				}
				
			} else {
				mappa.put(CODE, 404 );
				mappa.put(ERROR, "impossibile aggiornare, gruppo non trovato");
			}
		} else {
			mappa.put(CODE, 400);
			mappa.put(ERROR, GENERIC_ERROR);
		}
		return mappa;
	}
	
	/**
	 * 
	 * @param idGruppo
	 * @throws PortalException 
	 * @throws SystemException 
	 */
	public Map<String, Object> eliminaGruppoAll(Long idGruppo) throws SystemException, PortalException {
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		//Cancello un gruppo 
		mappa = eliminaGruppo(idGruppo);
		
//		eliminaGruppoGruppiByIdGruppo(idGruppo);
//		
//		eliminaGruppoNominativoByIdGruppo(idGruppo);
			
		return mappa;
	}
	

	/**
	 * 
	 * @param idGruppo
	 * @param data
	 * @return 
	 * @throws SystemException
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 * @throws NoSuchRubricaGruppoGruppiException 
	 */
	public Map<String, Object> eliminaGruppoSottoGruppo(Long idGruppo, String data) throws SystemException, JsonParseException, JsonMappingException, IOException {
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		//Deserializzo il json
		ObjectMapper mapper = new ObjectMapper();
		GroupSubGroupAssociationRequest subGruop = mapper.readValue(data, GroupSubGroupAssociationRequest.class);
			
		//cancello solo se è presente l'associazione, carico il dato sempre aggioranto ripulendo la cache
		RubricaGruppoGruppi gruppoGruppiLog = null;
		try {
			gruppoGruppiLog = RubricaGruppoGruppiUtil.findByPrimaryKey(new RubricaGruppoGruppiPK(idGruppo,subGruop.getSubgroupId()));
		}
		catch(NoSuchRubricaGruppoGruppiException e ) {
			//logger.error("Errore in cancellazione. Relazione gruppo, sottoGruppo non presente", e);
			mappa.put(CODE, 404 );
			mappa.put(ERROR, "associazione non presente, impossibile cancellare");
			return mappa;
		}
		if(null != gruppoGruppiLog) {
		
			RubricaGruppoGruppiLocalServiceUtil.deleteGruppoSottoGruppo(idGruppo, subGruop.getSubgroupId());
		
			//Aggiorna Log
			aggiornaRubricaLog(TABELLA_RUBRICA_GRUPPO_GRUPPI, String.valueOf(idGruppo).concat("-").concat(String.valueOf(subGruop.getSubgroupId())), 
							   TIPO_OPERAZIONE_DELETE, gruppoGruppiLog.toString(), userId );
			
			mappa.put(CODE, 204 );
			mappa.put(SUCCESS, "cancellazione avvenuta con successo");
		
		} else {
			
			mappa.put(CODE, 404 );
			mappa.put(ERROR, "associazione non presente, impossibile cancellare");
			
		}
				
		return mappa; 
	}
	
	/**
	 * 
	 * @param idSite
	 * @param idGruppo
	 * @param data
	 * @return
	 * @throws SystemException
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public boolean associaGruppoSottoGruppo(long idSite, long idGruppo, String data) throws SystemException, JsonParseException, JsonMappingException, IOException {
		
		//Deserializzo il json
		ObjectMapper mapper = new ObjectMapper();
		GroupSubGroupAssociationRequest subGruops = mapper.readValue(data, GroupSubGroupAssociationRequest.class);
		
		return creaAssociazioneGruppoSottoGruppo(idGruppo, subGruops);
	
	}

	private boolean creaAssociazioneGruppoSottoGruppo(long idGruppo, GroupSubGroupAssociationRequest subGruops)	throws SystemException {
		
		RubricaGruppoGruppi gruppoSottoGruppo = new RubricaGruppoGruppiImpl();
		gruppoSottoGruppo.setFK_GRUPPO_PADRE(idGruppo);
		gruppoSottoGruppo.setFK_GRUPPO_FIGLIO(subGruops.getSubgroupId());
		
		//Verifica se sto associando gruppi di proprietari differenti il che non è ammissibile
		RubricaGruppo gruppoPadre = RubricaGruppoLocalServiceUtil.fetchRubricaGruppo(idGruppo);
		RubricaGruppo gruppoFiglio = RubricaGruppoLocalServiceUtil.fetchRubricaGruppo(subGruops.getSubgroupId().longValue());
		
		if(null == gruppoPadre || null == gruppoFiglio) {
			return false;
		}
		if(gruppoPadre.getFK_SITO_PROPRIETARIO() != gruppoFiglio.getFK_SITO_PROPRIETARIO()) {
			return false;
		}
		//verifica che non sto associando un gruppo a se stesso
		else if(idGruppo == subGruops.getSubgroupId().longValue()) {
			return false;
		}
		//Devo verificare che il nodo figlio non sia un antenato del nodo padre
		else if(! verificaDiscendenti(idGruppo, subGruops.getSubgroupId())){
			
			//TODO verificare che il nodo figlio non sia gia' associato a sottogruppi del padre
			if(!verificaDiscendentiPadre(idGruppo, subGruops.getSubgroupId())) {

			
				RubricaGruppoGruppiLocalServiceUtil.updateRubricaGruppoGruppi(gruppoSottoGruppo);
				
				//Logga operazione
				//Aggiorna Log
				aggiornaRubricaLog(TABELLA_RUBRICA_GRUPPO_GRUPPI, String.valueOf(idGruppo).concat("-").concat(String.valueOf(subGruops.getSubgroupId())), 
									TIPO_OPERAZIONE_INSERT, gruppoSottoGruppo.toString(), userId );
				
				return true;
			}
		}
		return false;
	}
	
private boolean creaAssociazioneGruppoSuperGruppo(long idGruppo, GroupSubGroupAssociationRequest subGruops)	throws SystemException {
		
		RubricaGruppoGruppi gruppoSottoGruppo = new RubricaGruppoGruppiImpl();
		gruppoSottoGruppo.setFK_GRUPPO_FIGLIO(idGruppo);
		gruppoSottoGruppo.setFK_GRUPPO_PADRE(subGruops.getSubgroupId());
		
		//Verifica se sto associando gruppi di proprietari differenti il che non è ammissibile
		RubricaGruppo gruppoPadre = RubricaGruppoLocalServiceUtil.fetchRubricaGruppo(idGruppo);
		RubricaGruppo gruppoFiglio = RubricaGruppoLocalServiceUtil.fetchRubricaGruppo(subGruops.getSubgroupId().longValue());
		
		if(null == gruppoPadre || null == gruppoFiglio) {
			return false;
		}
		if(gruppoPadre.getFK_SITO_PROPRIETARIO() != gruppoFiglio.getFK_SITO_PROPRIETARIO()) {
			return false;
		}
		//verifica che non sto associando un gruppo a se stesso
		else if(idGruppo == subGruops.getSubgroupId().longValue()) {
			return false;
		}
		//Devo verificare che il nodo figlio non sia un antenato del nodo padre
		else if(! verificaDiscendenti(subGruops.getSubgroupId(), idGruppo)){
			
			//TODO verificare che il nodo figlio non sia gia' associato a sottogruppi del padre
			if(!verificaDiscendentiPadre(subGruops.getSubgroupId(), idGruppo)) {

			
				RubricaGruppoGruppiLocalServiceUtil.updateRubricaGruppoGruppi(gruppoSottoGruppo);
				
				//Logga operazione
				//Aggiorna Log
				aggiornaRubricaLog(TABELLA_RUBRICA_GRUPPO_GRUPPI, String.valueOf(subGruops.getSubgroupId()).concat("-").concat(String.valueOf(idGruppo)), 
									TIPO_OPERAZIONE_INSERT, gruppoSottoGruppo.toString(), userId );
				
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * 
	 * @param idSite
	 * @param idGruppo
	 * @param data
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SystemException
	 */
	public List<Long> associaGruppoSottoGruppoMulti(Long idSite, Long idGruppo, String data) throws JsonParseException, JsonMappingException, IOException, SystemException {
		
		List<Long> listaAssociationError = new ArrayList<>();
				
		//Deserializzo il json
		ObjectMapper mapper = new ObjectMapper();
		GroupSubGroupAssociationRequest[] listSubGroups = mapper.readValue(data, GroupSubGroupAssociationRequest[].class);
		
		for(GroupSubGroupAssociationRequest subGroup : listSubGroups) {
			
			if(! creaAssociazioneGruppoSottoGruppo(idGruppo, subGroup)) {
				listaAssociationError.add(subGroup.getSubgroupId());
			}
		}		

		return listaAssociationError;
	}
	
	/**
	 * 
	 * @param idSite
	 * @param idGruppo
	 * @param data
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SystemException
	 */
	public List<Long> associaGruppoSuperGruppoMulti(Long idSite, Long idGruppo, String data) throws JsonParseException, JsonMappingException, IOException, SystemException {
		
		List<Long> listaAssociationError = new ArrayList<>();
				
		//Deserializzo il json
		ObjectMapper mapper = new ObjectMapper();
		GroupSubGroupAssociationRequest[] listSubGroups = mapper.readValue(data, GroupSubGroupAssociationRequest[].class);
		
		for(GroupSubGroupAssociationRequest subGroup : listSubGroups) {
			
			if(! creaAssociazioneGruppoSuperGruppo(idGruppo,subGroup)) {
				listaAssociationError.add(subGroup.getSubgroupId());
			}
		}		

		return listaAssociationError;
	}

	
	/**
	 * 
	 * @param idSite
	 * @param idGruppo
	 * @param data
	 * @return
	 * @throws SystemException
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public List<Long> cancellaGruppoSottoGruppoMulti(Long idSite, Long idGruppo, String data) throws SystemException, JsonParseException, JsonMappingException, IOException {
		
		List<Long> listaDeleteAssociationError = new ArrayList<>();
		//Deserializzo il json
		ObjectMapper mapper = new ObjectMapper();
		GroupSubGroupAssociationRequest[] listSubGroups = mapper.readValue(data, GroupSubGroupAssociationRequest[].class);
		
		for(GroupSubGroupAssociationRequest subGroup : listSubGroups) {
		
			//cancello solo se è presente l'associazione, carico il dato sempre aggioranto ripulendo la cache
			RubricaGruppoGruppi gruppoGruppiLog = null;
			try {
				gruppoGruppiLog = RubricaGruppoGruppiUtil.findByPrimaryKey(new RubricaGruppoGruppiPK(idGruppo, subGroup.getSubgroupId()));
			}
			catch(NoSuchRubricaGruppoGruppiException e ) {
				//logger.error("Errore in cancellazione. Relazione gruppo, sottoGruppo non presente", e);
			}
			if(null != gruppoGruppiLog) {
			
				RubricaGruppoGruppiLocalServiceUtil.deleteGruppoSottoGruppo(idGruppo, subGroup.getSubgroupId());
			
				//Aggiorna Log
				aggiornaRubricaLog(TABELLA_RUBRICA_GRUPPO_GRUPPI, String.valueOf(idGruppo).concat("-").concat(String.valueOf(subGroup.getSubgroupId())), 
								   TIPO_OPERAZIONE_DELETE, gruppoGruppiLog.toString(), userId );
			
			} else {
				
				listaDeleteAssociationError.add(subGroup.getSubgroupId());
				
			}
		}
		
		return listaDeleteAssociationError;
	}
	
	/**
	 * 
	 * @param idSite
	 * @param idGruppo
	 * @param data
	 * @return
	 * @throws SystemException
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public List<Long> cancellaGruppoSuperGruppoMulti(Long idSite, Long idGruppo, String data) throws SystemException, JsonParseException, JsonMappingException, IOException {
		
		List<Long> listaDeleteAssociationError = new ArrayList<>();
		//Deserializzo il json
		ObjectMapper mapper = new ObjectMapper();
		GroupSubGroupAssociationRequest[] listSubGroups = mapper.readValue(data, GroupSubGroupAssociationRequest[].class);
		
		for(GroupSubGroupAssociationRequest subGroup : listSubGroups) {
		
			//cancello solo se è presente l'associazione, carico il dato sempre aggioranto ripulendo la cache
			RubricaGruppoGruppi gruppoGruppiLog = null;
			try {
				gruppoGruppiLog = RubricaGruppoGruppiUtil.findByPrimaryKey(new RubricaGruppoGruppiPK(subGroup.getSubgroupId(),idGruppo));
			}
			catch(NoSuchRubricaGruppoGruppiException e ) {
				//logger.error("Errore in cancellazione. Relazione gruppo, sottoGruppo non presente", e);
			}
			if(null != gruppoGruppiLog) {
			
				RubricaGruppoGruppiLocalServiceUtil.deleteGruppoSottoGruppo(subGroup.getSubgroupId(),idGruppo);
			
				//Aggiorna Log
				aggiornaRubricaLog(TABELLA_RUBRICA_GRUPPO_GRUPPI, String.valueOf(String.valueOf(subGroup.getSubgroupId()).concat("-").concat(String.valueOf(idGruppo))), 
								   TIPO_OPERAZIONE_DELETE, gruppoGruppiLog.toString(), userId );
			
			} else {
				
				listaDeleteAssociationError.add(subGroup.getSubgroupId());
				
			}
		}
		
		return listaDeleteAssociationError;
	}
	
	/**
	 * 
	 * @param id
	 * @param data
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public Map<String, Object> aggiornaGruppoSottoGruppo(long id, String data) throws JsonParseException, JsonMappingException, IOException, SystemException, PortalException {
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		//Deserializzo il json
		ObjectMapper mapper = new ObjectMapper();
		GroupSubGroupUpdateRequest subGroupsUpdate = mapper.readValue(data, GroupSubGroupUpdateRequest.class);
		
		//Verifica dove il gruppo è figlio e elimina le associazioni (per lo stesso sito proprietario)
		List<RubricaGruppoGruppi> rubricaGruppoGruppi = new ArrayList<>();
		rubricaGruppoGruppi = RubricaGruppoGruppiUtil.findByRubricaGruppoGruppoByFiglio(id);
		
		if(null != rubricaGruppoGruppi) {
			
			for(RubricaGruppoGruppi gruppoGruppi : rubricaGruppoGruppi){
				
				RubricaGruppo gruppoPadreOld = RubricaGruppoUtil.findByPrimaryKey(gruppoGruppi.getFK_GRUPPO_PADRE());
				
				//verifica se è un gruppo per lo stesso proprietario 
				//cancella tutte le relazioni per lo stesso proprietario
				if(null != gruppoPadreOld && gruppoPadreOld.getFK_SITO_PROPRIETARIO() == groupId) {
					
					RubricaGruppoGruppiLocalServiceUtil.deleteRubricaGruppoGruppi(new RubricaGruppoGruppiPK(gruppoPadreOld.getID_GRUPPO(), id));
						
					//Logga operazione in RUBRICA_LOG
					RubricaGruppoGruppi gruppoGruppiDel = new RubricaGruppoGruppiImpl();
					gruppoGruppiDel.setFK_GRUPPO_PADRE(gruppoPadreOld.getID_GRUPPO());
					gruppoGruppiDel.setFK_GRUPPO_FIGLIO(id);
					
					aggiornaRubricaLog(TABELLA_RUBRICA_GRUPPO_GRUPPI, 
							String.valueOf(gruppoPadreOld.getID_GRUPPO())+"-"+String.valueOf(id),
							TIPO_OPERAZIONE_DELETE, gruppoGruppiDel.toString(), userId );
					
				}
			}
		}
			
		//Verifica se sarà un nodo radice oppure da associare a un altro padre
		if(null != subGroupsUpdate) {
				
			if(null != subGroupsUpdate.getParentId()) {
				
				//Se deve essere agganciato a un nuovo padre verifica che sia un'associzione valida e crea l'associazione in tabella
				RubricaGruppoGruppi gruppoSottoGruppo = new RubricaGruppoGruppiImpl();
				gruppoSottoGruppo.setFK_GRUPPO_PADRE(subGroupsUpdate.getParentId());
				gruppoSottoGruppo.setFK_GRUPPO_FIGLIO(id);
					
				//Verifica se sto associando gruppi di proprietari differenti il che non è ammissibile
				RubricaGruppo gruppoPadre = RubricaGruppoLocalServiceUtil.fetchRubricaGruppo(gruppoSottoGruppo.getFK_GRUPPO_PADRE());
				RubricaGruppo gruppoFiglio = RubricaGruppoLocalServiceUtil.fetchRubricaGruppo(gruppoSottoGruppo.getFK_GRUPPO_FIGLIO());
					
				if(gruppoPadre.getFK_SITO_PROPRIETARIO() != gruppoFiglio.getFK_SITO_PROPRIETARIO()) {
					mappa.put(CODE, 400);
					mappa.put(ERROR, "associazione non consentita");
					return mappa;
				}
				//verifica che non sto associando un gruppo a se stesso
				else if(id == subGroupsUpdate.getParentId().longValue()) {
					mappa.put(CODE, 400);
					mappa.put(ERROR, "associazione non consentita");
					return mappa;
				}
				//Devo verificare che il nodo figlio non sia un antenato del nodo padre 
				else if(! verificaDiscendenti(subGroupsUpdate.getParentId(), id)){
					
					//TODO verificare che il nodo figlio non sia gia' associato a sottogruppi del padre
					if(!verificaDiscendentiPadre(subGroupsUpdate.getParentId(), id)) {
					
					RubricaGruppoGruppiLocalServiceUtil.updateRubricaGruppoGruppi(gruppoSottoGruppo);
						
						//Logga operazione
						//Aggiorna Log
						aggiornaRubricaLog(TABELLA_RUBRICA_GRUPPO_GRUPPI, String.valueOf(subGroupsUpdate.getParentId()).concat("-").concat(String.valueOf(id)), 
											TIPO_OPERAZIONE_INSERT, gruppoSottoGruppo.toString(), userId );
						
						mappa.put(CODE, 204);
						mappa.put(SUCCESS, "associazione aggiornata con successo");
					} else {
						mappa.put(CODE, 400);
						mappa.put(ERROR, "associazione non consentita");
						return mappa;
					}
					
				} else {
					mappa.put(CODE, 400);
					mappa.put(ERROR, "associazione non consentita");
					return mappa;
				}
								
			} else {
				//Non devo associare nulla le altre relazioni (i sottogruppi del gruppo che sto aggiornando)rimangono inalterate
				mappa.put(CODE, 204);
				mappa.put(SUCCESS, "associazione aggiornata con successo");
			}
							
		} else {
			mappa.put(CODE, 400);
			mappa.put(ERROR, "dati mancanti");
		}
				
		return mappa;		
	}

	
	
	private boolean verificaDiscendentiPadre(Long parentId, long id) {
		
		boolean result = false;
		
		//cerco i figli del figlio se tra i figli ci sta il padre a cui
		//lo si vuole associare allora esci
		List<Object[]> listaDiscendente = RubricaGruppoGruppiLocalServiceUtil.getGruppiPadriPerFiglio(id);
	
		for(Object[] objects : listaDiscendente){
					
			RubricaGruppoGruppi gruppoGruppi = new RubricaGruppoGruppiImpl();
			gruppoGruppi.setFK_GRUPPO_PADRE((long) objects[0]);
			gruppoGruppi.setFK_GRUPPO_FIGLIO((long)objects[2]);
				
			if(parentId.longValue() == gruppoGruppi.getFK_GRUPPO_PADRE()) {
				result = true;
				break;
			} else {
				result =  verificaDiscendentiPadre(parentId, gruppoGruppi.getFK_GRUPPO_PADRE());
				if(result){
					return true;
				}
			}			
		}
		
		return result;
	}


	/**
	 * 
	 * @param padre
	 * @param figlio
	 * @return
	 */
	private boolean verificaDiscendenti(Long padre, Long figlio) {
		
		boolean result = false;
		
		//cerco i figli del figlio se tra i figli ci sta il padre a cui
		//lo si vuole associare allora esci
		List<Object[]> listaDiscendente = RubricaGruppoGruppiLocalServiceUtil.getGruppiFigli(figlio);
	
		for(Object[] objects : listaDiscendente){
					
			RubricaGruppoGruppi gruppoGruppi = new RubricaGruppoGruppiImpl();
			gruppoGruppi.setFK_GRUPPO_PADRE((long) objects[0]);
			gruppoGruppi.setFK_GRUPPO_FIGLIO((long)objects[1]);
				
			if(padre.longValue() == gruppoGruppi.getFK_GRUPPO_FIGLIO()) {
				result = true;
				break;
			} else {
				result =  verificaDiscendenti(padre, gruppoGruppi.getFK_GRUPPO_FIGLIO());
				if(result){
					return true;
				}
			}			
		}
		
		return result;
	}
	/**
	 * Questo metodo aggiorna il ruolo per un nominativo di un gruppo
	 * 
	 * @param data
	 * @return 
	 * @throws SystemException
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public Map<String, Object> aggiornaRuoloPerGruppoNominativo(String data) throws SystemException, JsonParseException, JsonMappingException, IOException {
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		//Deserializzo il json
		ObjectMapper mapper = new ObjectMapper();
		NominativeGroupRole nominativeGroupRole = mapper.readValue(data, NominativeGroupRole.class);
				
		if(null != nominativeGroupRole) {
					
			RubricaGruppoNominativi nominativeUpdate = new RubricaGruppoNominativiImpl();
	
			//carica i dati da aggiornare per gruppo e nominativo
			try {
				nominativeUpdate = RubricaGruppoNominativiUtil.findByPrimaryKey(new RubricaGruppoNominativiPK(nominativeGroupRole.getGroupId(), nominativeGroupRole.getNominativeId()));
			} catch (NoSuchRubricaGruppoNominativiException e) {
				//logger.error("Errore in aggiornamento. Relazione gruppo nominativo non presente", e);
				mappa.put(CODE, 404 );
				mappa.put(ERROR, "dati non presenti, impossibile aggiornare");			
				return mappa;
			}
			
			//Logga operazione in RUBRICA_LOG
			aggiornaRubricaLog(TABELLA_RUBRICA_GRUPPO_NOMINATIVI, 
					String.valueOf(nominativeUpdate.getFK_GRUPPO()).concat("-").concat(String.valueOf(nominativeUpdate.getFK_NOMINATIVO())).concat("-").concat(String.valueOf(nominativeUpdate.getFK_RUOLO())),
					TIPO_OPERAZIONE_UPDATE, nominativeUpdate.toString(), userId );
			
			//setto il nuovo ruolo
			nominativeUpdate.setFK_RUOLO(nominativeGroupRole.getRole());
	
			//e aggiorno			
			RubricaGruppoNominativiLocalServiceUtil.updateRubricaGruppoNominativi(nominativeUpdate);
			
			mappa.put(CODE, 204 );
			mappa.put(SUCCESS, "aggiornamento avvenuto con successo");
					
		}
		
		return mappa;
	}
	
	
	/**
	 * 
	 * @param idGruppo
	 * @return 
	 * @throws SystemException
	 * @throws PortalException
	 */
	private Map<String, Object> eliminaGruppo(Long idGruppo) throws SystemException, PortalException {
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		//carico il dato che sto per cancellare
		RubricaGruppo gruppoDel = RubricaGruppoUtil.fetchByPrimaryKey(idGruppo);
		
		if(null != gruppoDel && ! gruppoDel.isDISABLED()) { //cancello solo quelli attivi
				
			//Aggiorna Log con valore del gruppo che sto per cancellare
			aggiornaRubricaLog(TABELLA_RUBRICA_GRUPPO, String.valueOf(idGruppo), TIPO_OPERAZIONE_DELETE, gruppoDel.toString(), userId );
			
			//Setto disabed a false
			gruppoDel.setDISABLED(true);
			//setto data modifica e utente
			gruppoDel.setFK_UTENTE_MODIFICA(userId);
			gruppoDel.setDATA_MODIFICA(new Date());
			
			RubricaGruppoLocalServiceUtil.updateRubricaGruppo(gruppoDel);
			
			mappa.put(CODE, 204 );
			mappa.put(SUCCESS, "cancellazione avvenuta con successo");
					
		} else {
			
			mappa.put(CODE, 404 );
			mappa.put(ERROR, "gruppo non presente, impossibile cancellare");
		}
		
		return mappa;
	}
	
	/**
	 * 
	 * @param data
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SystemException
	 */
	public List<Long> cancellaGruppiMulti(String data) throws JsonParseException, JsonMappingException, IOException, SystemException {
		
		List<Long> listDelGruppoError = new ArrayList<>();
		
		//Deserializzo il json
		ObjectMapper mapper = new ObjectMapper();
		GroupAssociationRequest[] gruppoList = mapper.readValue(data, GroupAssociationRequest[].class);
				
		for(GroupAssociationRequest gruppo :gruppoList ) {
		
			try{
				
				//carico il dato che sto per cancellare
				RubricaGruppo gruppoDel = RubricaGruppoUtil.fetchByPrimaryKey(gruppo.getId());
				
				if(null != gruppoDel && ! gruppoDel.isDISABLED()) { //cancello solo quelli attivi
						
					//Aggiorna Log con valore del gruppo che sto per cancellare
					aggiornaRubricaLog(TABELLA_RUBRICA_GRUPPO, String.valueOf(gruppo.getId()), TIPO_OPERAZIONE_DELETE, gruppoDel.toString(), userId );
					
					//Setto disabed a false
					gruppoDel.setDISABLED(true);
					//setto data modifica e utente
					gruppoDel.setFK_UTENTE_MODIFICA(userId);
					gruppoDel.setDATA_MODIFICA(new Date());
					
					RubricaGruppoLocalServiceUtil.updateRubricaGruppo(gruppoDel);
				} 
		
			} catch (Exception e) {
				listDelGruppoError.add(gruppo.getId());
			}
			
		}	
		
		return listDelGruppoError;
		
	}


	
	//CARICAMENTO GRUPPI
	/**
	 * 
	 * @param groupName
	 * @param limit
	 * @param offset
	 * @return
	 * @throws SystemException
	 * @throws ParseException
	 * @throws PortalException
	 * @throws JsonProcessingException
	 */
	public List<GroupElement> loadGroupsByName(Long idSite, String groupName, Long category, Long limit, Long offset) throws SystemException, ParseException, PortalException, JsonProcessingException {
		
		List<Object[]> listaGruppi = new ArrayList<>();
		
		//cache
		//List<RubricaGruppoGruppi> gg = RubricaGruppoGruppiLocalServiceUtil.getRubricaGruppoGruppis(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<RubricaGruppoGruppi> gg = null;

		Map<String,Object> cache = new HashMap<>();
		
		//Lista finale che conterrà tutta la struttura Json
		List<GroupElement> listaGruopElementFinal = new ArrayList<>();
		if (limit==null || limit<=0) limit=10000L;

		if (category==null || category<=0 || category>10000) listaGruppi = RubricaGruppoLocalServiceUtil.getGruppiByName(idSite, groupName, limit, offset);
		else listaGruppi = RubricaGruppoLocalServiceUtil.getGruppiByNameCategoria(idSite, groupName, category, limit, offset);
		
		List<Object[]> gerarchia = RubricaGruppoLocalServiceUtil.getGerarchia(idSite);
		for (Object[] o : gerarchia) {
			long idgruppo = (long) o[0];
			String sottogruppi = (String)o[3];
			String nominativi = (String)o[4];
			cache.put("listasottogruppi_"+idgruppo, sottogruppi);
			cache.put("listanominativi_"+idgruppo, nominativi);
			long numsottogruppi = 0;
			if (sottogruppi!=null) {
				numsottogruppi = sottogruppi.split(",").length;
			}
			long numnominativi = 0;
			if (nominativi!=null)
				numnominativi = nominativi.split(",").length;
			
			cache.put("sottogruppi_"+idgruppo, numsottogruppi);
			cache.put("nominativi_"+idgruppo, numnominativi);
			
		}
		
		for (Object[] objectsGruop : listaGruppi) {
			
			//Considero solo quelli attivi
			if(!(boolean)objectsGruop[8]) {
				RubricaGruppo gruppo = new RubricaGruppoImpl();
				gruppo.setID_GRUPPO((long) objectsGruop[0]);
				gruppo.setNOME((String) objectsGruop[1]);
				gruppo.setFK_SITO_PROPRIETARIO((long) objectsGruop[2]);
				gruppo.setNOTE((String) objectsGruop[3]);
				gruppo.setFK_UTENTE_CREAZIONE((long) objectsGruop[4]);
				gruppo.setDATA_CREAZIONE((Date) objectsGruop[5]);
				gruppo.setFK_UTENTE_MODIFICA((long) objectsGruop[6]);
				gruppo.setDATA_MODIFICA((Date) objectsGruop[7]);
				gruppo.setDISABLED((boolean)objectsGruop[8]);
				
				cache.put("gruppo_"+gruppo.getID_GRUPPO(), gruppo);
				
			}
		}
		
		
		for (Object[] objectsGruop : listaGruppi) {
			
			//Considero solo quelli attivi
			if(!(boolean)objectsGruop[8]) {

				RubricaGruppo gruppo = (RubricaGruppo)cache.get("gruppo_"+(long) objectsGruop[0]);
				
				
				//Ricorsivamente devo creare su ogni gruppo la lista di sottogruppi a partire dalle relazioni
				//nella tabella rubrica_gruppo_gruppi
				//Ogni iterazione rappresenta il mio "nodo" radice
				//Quindi...
				List<GroupElement> listaGruopElement = new ArrayList<>();
				
				GroupElement rootGroup = new GroupElement();
				
				rootGroup.setId(gruppo.getID_GRUPPO());
				rootGroup.setName(gruppo.getNOME());
				rootGroup.setParentId(null);
				
				//recupera il numero di nominativi e sottogruppi associati
				Long nomin = (Long) cache.get("nominativi_"+gruppo.getID_GRUPPO());
				if (nomin==null) {
					nomin = RubricaStructureCustomService.countNominativiPerGruppo(gruppo.getID_GRUPPO(), idSite);
					cache.put("nominativi_"+gruppo.getID_GRUPPO(), nomin);
				}
				rootGroup.setNominativeCount(nomin);
				
				Long subg = (Long) cache.get("sottogruppi_"+gruppo.getID_GRUPPO());
				if (subg==null) {
					subg = RubricaStructureCustomService.countSottoGruppi(gruppo.getID_GRUPPO());
					cache.put("sottogruppi_"+gruppo.getID_GRUPPO(), subg);
				}
				rootGroup.setSubgroupsCount(subg);
				
				listaGruopElement.add(rootGroup);
							
				//chiamata al metodo ricorsivo
				RubricaStructureCustomService.loadSubGruopElement(listaGruopElement, rootGroup.getId(), idSite, gg, cache );
				
				//Costruisci albero a partire dalla lista 
				//Estrai il nodo radice (che contiene tutta la gerarchia) ed aggiungilo alla lista finale listaGruopElementFinal
				GroupElement rootGroupJson = RubricaStructureCustomService.createGroupElementTree(listaGruopElement);
				
				//Lo aggiungo alla lista solo se è un gruppo root, ovvero se non è figlio di un gruppo per lo stesso proprietario
				//if(isGroupRoot(rootGroupJson, idSite)) {
					//Aggiungo alla lista finale
					listaGruopElementFinal.add(rootGroupJson);
				//}						
			}
		}
		
		//devo aggiuntere ai gruppi radice anche il gruppo degli utenti del portale (viene creato "al volo" non viene fisicizzato in db)
		//GroupElement gruppoUtentiPortale = creaGroupElementUtentiPortale(idSite) ;
		//if(null != gruppoUtentiPortale)	listaGruopElementFinal.add(gruppoUtentiPortale);
			
		return listaGruopElementFinal;
	}
	
	
	/**
	 * 
	 * @param idSite
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	private GroupElement creaGroupElementUtentiPortale(Long idSite) throws SystemException, PortalException {
	
		List<User> listaUserFinal = getUserForGroupRole();
		
		if(null != listaUserFinal && ! listaUserFinal.isEmpty()) {
			GroupElement rootGroup = new GroupElement();
			
			rootGroup.setId(ID_GRUPPO_UTENTI_PORTALE); //ID FITTIZIO, se lo setto a 0 lo tratta come null causando eccezione lato react
			rootGroup.setName(DESCRIZIONE_GRUPPO_UTENTI_PORTALE);
			rootGroup.setParentId(null);
			
			rootGroup.setNominativeCount(new Long(listaUserFinal.size()));
			rootGroup.setSubgroups(new ArrayList<GroupElement>());
			rootGroup.setSubgroupsCount(new Long(0));
			
			return rootGroup; 
		}		
		return null;		
	}

	/**
	 * 
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public List<User> getUserForGroupRole() throws PortalException, SystemException {
		
		com.liferay.portal.kernel.model.Role role = null;
		role = RoleLocalServiceUtil.getRole(20154, DESCRIZIONE_ROLE_CITTADINO);
		if(role==null){
			//logger.error("Ruolo non trovato");
			return null;
		}
		List<User> listaUser = UserLocalServiceUtil.getGroupUsers(groupId);
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
		return listaUserFinal;
	}

	/**
	 * 
	 * @param rootGroupJson
	 * @param idSite 
	 * @return
	 * @throws SystemException 
	 */
	private boolean isGroupRoot(GroupElement rootGroupJson, Long idSite) throws SystemException {

		List<RubricaGruppoGruppi> listaPadri = RubricaGruppoGruppiUtil.findByRubricaGruppoGruppoByFiglio(rootGroupJson.getId());
		
		for(RubricaGruppoGruppi gruppoPadre : listaPadri) {
			
			RubricaGruppo gruppoPadreInfo = RubricaGruppoLocalServiceUtil.fetchRubricaGruppo(gruppoPadre.getFK_GRUPPO_PADRE());
			
			if(null!= gruppoPadreInfo && gruppoPadreInfo.getFK_SITO_PROPRIETARIO() == idSite.longValue()) {
				return false;
			}
		}		
		return true;			
	}

	/**
	 * 
	 * @param idGruop
	 * @param idProprietario 
	 * @return
	 * @throws SystemException
	 * @throws ParseException
	 * @throws PortalException
	 * @throws IOException
	 */
	public GroupDetail loadGroupById(Long idSite, Long idGroup)  throws SystemException, ParseException, PortalException, IOException {
		//logger.info("getGroupBId "+idGroup);
		//Dettaglio gruppo utenti portale
		if(idGroup.longValue() == ID_GRUPPO_UTENTI_PORTALE) { //l'id del gruppo degli utenti del portale è fisso
			GroupDetail groupDetailUtentiPortale = creaGroupDetailUtentiPortale(idSite, idGroup); //prova new Long(232914), new Long(-1)
			return groupDetailUtentiPortale;
		}
				
		//carico il gruppo per l'id passato come parametro 
		//Viene caricato solo se appartiene al proprietario
		RubricaGruppo group = RubricaGruppoLocalServiceUtil.fetchRubricaGruppo(idGroup);
				
		if(null !=group && !group.isDISABLED() && group.getFK_SITO_PROPRIETARIO() == idSite) { //Considero solo quelli attivi
			
			GroupDetail groupJson= new GroupDetail();
			 
			groupJson.setId(group.getID_GRUPPO());
			groupJson.setName(group.getNOME());
			groupJson.setCategoria(group.getFK_CATEGORIA());
			if (group.getFK_CATEGORIA()>0) {
				try {
					RubricaCategoria rc = RubricaCategoriaLocalServiceUtil.fetchRubricaCategoria(group.getFK_CATEGORIA());
					groupJson.setCategoriaName(rc.getDESCRIZIONE());
				} catch (Exception e) {
					
				}
			}
			 
			//Carica i dati del proprietario
			Owner ownerJson = RubricaStructureCustomService.loadOwnerForGroup(group.getFK_SITO_PROPRIETARIO());
			
			groupJson.setOwner(ownerJson);
						
			//carica i dati dell'user che ha modificato il gruppo
			UserInfo lastUserEditJson = null;
			if(group.getFK_UTENTE_MODIFICA()>0) {
				lastUserEditJson = RubricaStructureCustomService.loadEditUserInfoForGroup(group.getFK_UTENTE_MODIFICA());
			} else {
				lastUserEditJson = RubricaStructureCustomService.loadEditUserInfoForGroup(group.getFK_UTENTE_CREAZIONE());
			}
								
			groupJson.setLastEditUser(lastUserEditJson);
			 
			groupJson.setLastEdit((null != group.getDATA_MODIFICA() ? group.getDATA_MODIFICA().getTime() : group.getDATA_CREAZIONE().getTime() ));
	
			//recupera il numero di nominativi e sottogruppi associati
			groupJson.setNominativeCount(RubricaStructureCustomService.countNominativiPerGruppo(group.getID_GRUPPO(), idSite));
			groupJson.setSubgroupsCount(RubricaStructureCustomService.countSottoGruppi(group.getID_GRUPPO()));
			
			List<Object[]> padri = RubricaGruppoGruppiLocalServiceUtil.getGruppiPadriPerFiglio(group.getID_GRUPPO());
			groupJson.setSupergroupsCount(new Long(padri.size()));
			for (Object[] p : padri) {
				GroupDetail gd = new GroupDetail();
				gd.setId((Long)p[0]);
				gd.setName((String)p[1]);
				groupJson.getSupergroups().add(gd);
			}
			
			//recupea i nominativi associati al gruppo		
			List<Nominative> listNominativesJson = loadNominativesForGroup(idSite, group); 
			//logger.info("listNominativesJson = "+listNominativesJson);
			if (listNominativesJson!=null) {
				for (Nominative n : listNominativesJson) {
					if (n!=null && n.getGroups()!=null) {
						for (it.eng.allerte.custom.jsonRubrica.Group gg : n.getGroups()) {
							if (gg!=null && gg.getId()==idGroup) {
								n.setRole(gg.getRole());
								n.setSpecificaRuolo(gg.getSpecificaRuolo());
							}
						}
					}
				}
			}
			 
			//Setto la lista sull'oggetto finale
			groupJson.setNominatives(listNominativesJson);
			
			//Ricorsivamente devo creare su ogni gruppo la lista di sottogruppi a partire dalle relazioni
			//nella tabella rubrica_gruppo_gruppi
			//Ogni iterazione rappresenta il mio "nodo" radice
			//Quindi...
			List<GroupDetail> listaGroupDetail = new ArrayList<>();

			groupJson.setParentId(null);
			
			listaGroupDetail.add(groupJson);
						
			//chiamata al metodo ricorsivo
			RubricaStructureCustomService.loadSubGroupDetail(listaGroupDetail, groupJson.getId(), idSite);
			
			//Costruisci albero a partire dalla lista 
			//Estrai il nodo radice (che contiene tutta la gerarchia) ed aggiungilo alla lista finale listaGruopElementFinal
			GroupDetail rootGroupJson = RubricaStructureCustomService.createGroupDetailTree(listaGroupDetail);
			
			if (rootGroupJson.getSubgroups()!=null && rootGroupJson.getSubgroups().size()>1) {
				rootGroupJson.getSubgroups().sort(new Comparator<GroupDetail>() {
				@Override
				public int compare(GroupDetail o1, GroupDetail o2) {
					return o1.getName().compareTo(o2.getName());
				}
				});
			}
			
			if (rootGroupJson.getSupergroups()!=null && rootGroupJson.getSupergroups().size()>1) {
				rootGroupJson.getSupergroups().sort(new Comparator<GroupDetail>() {
				@Override
				public int compare(GroupDetail o1, GroupDetail o2) {
					return o1.getName().compareTo(o2.getName());
				}
				});
			}
			
			if (rootGroupJson.getNominatives()!=null && rootGroupJson.getNominatives().size()>1) {
				rootGroupJson.getNominatives().sort(new Comparator<Nominative>() {
				@Override
				public int compare(Nominative o1, Nominative o2) {
					if (o1.getLastName()==null) o1.setLastName("");
					if (o2.getLastName()==null) o2.setLastName("");
					if (o1.getFirstName()==null) o1.setFirstName("");
					if (o2.getFirstName()==null) o2.setFirstName("");
					
					int comp = o1.getLastName().compareTo(o2.getLastName());
					if (comp!=0) return comp;
					return o1.getFirstName().compareTo(o2.getFirstName());
				}
				});
			}
			
			return rootGroupJson;
		}
		else {
			return null;
		}
	}

	
	/**
	 * 
	 * @param idSite
	 * @param idGroup
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	private GroupDetail creaGroupDetailUtentiPortale(Long idSite, Long idGroup) throws SystemException, PortalException {
	
		GroupDetail groupJson= new GroupDetail();
		 
		//setto un id fittizzio per il gruppo degli utenti del portale (uso -1 , se metto 0 va in errore la risposta probabilmente lo tratta come null)
		groupJson.setId(ID_GRUPPO_UTENTI_PORTALE);
		groupJson.setName(DESCRIZIONE_GRUPPO_UTENTI_PORTALE);
		 
		//Carica i dati del proprietario
		Owner ownerJson = RubricaStructureCustomService.loadOwnerForGroup(idSite); //prova 232914
		
		groupJson.setOwner(ownerJson);
					
		//carica i dati dell'user che ha modificato il gruppo, setto dei dati "fittizzi"
		UserInfo lastUserEditJson = new UserInfo();
		lastUserEditJson.setId(new Long(-1));
		lastUserEditJson.setFirstName("");
		lastUserEditJson.setLastName("");
							
		groupJson.setLastEditUser(lastUserEditJson);
		 
		groupJson.setLastEdit(new Date().getTime());

		List<User> listaUserFinal = getUserForGroupRole();
		List<Nominative> listNominativesJson = new ArrayList<>();
		
		if(null != listaUserFinal && !listaUserFinal.isEmpty()) {
			
			groupJson.setNominativeCount((new Long(listaUserFinal.size())));
			groupJson.setSubgroupsCount(new Long(0));
			
			//recupea i nominativi associati al gruppo		
			listNominativesJson = loadNominativesForGroupUtentiPortale(listaUserFinal); 
			 
		} else {
			groupJson.setNominativeCount(new Long(0));
			groupJson.setSubgroupsCount(new Long(0));
		}
		
		//Setto la lista sull'oggetto finale
		groupJson.setNominatives(listNominativesJson);

		return groupJson;

	}

	
	/**
	 * 
	 * @param listaUserFinal
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	private List<Nominative> loadNominativesForGroupUtentiPortale(List<User> listaUserFinal) throws SystemException, PortalException {
				
		List<Nominative> listNominativesJson = new ArrayList<>();
		
		//estrae le info per nominativo e contatto di ogni user del portale
		for (User userGroup : listaUserFinal) {
			
			List<Contact> listaContatti = new ArrayList<>();
			
			Nominative nominativeJson = new Nominative();
			
			User userPortale = UserLocalServiceUtil.fetchUser(userGroup.getUserId());
			com.liferay.portal.kernel.model.Contact contact = userPortale.getContact();
		
			//Creo la lista dei gruppi a cui è iscritto l'user
//		    List<UserGroup> listaUserGroup = UserGroupLocalServiceUtil.getUserUserGroups(userGroup.getUserId());
		    //Per ogni gruppo carico le info
		    List<it.eng.allerte.custom.jsonRubrica.Group> listaGruppi = new ArrayList<>();
//		    for(UserGroup uGroup : listaUserGroup) {
//		    	com.liferay.portal.model.Group gruppo = GroupServiceUtil.getGroup(uGroup.getGroupId());
//		    	if (null != gruppo ) {
//		    		Group group = new Group();
//		    		group.setId(gruppo.getGroupId());
//		    		group.setName(gruppo.getName());
//		    		group.setRole(""); //vedere se bisogna popolarlo
//		    		listaGruppi.add(group);
//		    	}
//		    }
		    it.eng.allerte.custom.jsonRubrica.Group group = new it.eng.allerte.custom.jsonRubrica.Group();
    		group.setId(new Long(-1));
    		group.setName(DESCRIZIONE_GRUPPO_UTENTI_PORTALE);
    		group.setRole(DESCRIZIONE_ROLE_CITTADINO); //vedere se bisogna popolarlo
    		listaGruppi.add(group);
						
			nominativeJson.setAddress("");
			nominativeJson.setCreateUser(userPortale.getFirstName().concat(" ").concat( userPortale.getLastName()));
			nominativeJson.setFirstName(userPortale.getFirstName());
			nominativeJson.setLastName(userPortale.getLastName());
			nominativeJson.setId(userPortale.getUserId());
			nominativeJson.setLastEdit(userPortale.getModifiedDate().getTime());
			nominativeJson.setModifyUser(userPortale.getFirstName().concat(" ").concat( userPortale.getLastName()));
			nominativeJson.setRole(DESCRIZIONE_ROLE_CITTADINO); //Il ruolo è sempre cittadino
			nominativeJson.setGroups(listaGruppi);
			//In contact liferay ci sono i contatti per colonna, prendiamo solo mail e cell
			if(StringUtils.isNotBlank(contact.getEmailAddress())) {
				Contact contattoEmail = new Contact();
				contattoEmail.setChannelId(new Long(1));
				contattoEmail.setId(contact.getContactId());
				contattoEmail.setValue(contact.getEmailAddress());
				listaContatti.add(contattoEmail);
			} else if (StringUtils.isNotBlank(contact.getSmsSn())) {
				Contact contattoSms = new Contact();
				contattoSms.setChannelId(new Long(3));
				contattoSms.setId(contact.getContactId());
				contattoSms.setValue(contact.getSmsSn());
				listaContatti.add(contattoSms);
			}
			
			nominativeJson.setContacts(listaContatti);			

			listNominativesJson.add(nominativeJson);
			
		}
		return listNominativesJson;
	}

	/**
	 * 
	 * @param idSite
	 * @param group
	 * @return
	 * @throws SystemException
	 * @throws ParseException
	 * @throws PortalException
	 * @throws IOException
	 */
	private List<Nominative> loadNominativesForGroup(Long idSite, RubricaGruppo group) throws SystemException, ParseException, PortalException, IOException {
		
		List<Nominative> listNominativesJson = new ArrayList<>();
		
		List<Object[]> listaGruppoNominativi = RubricaGruppoNominativiLocalServiceUtil.loadNominativiGruppo(group.getID_GRUPPO(), idSite);
		
		for (Object[] objectsGruop : listaGruppoNominativi) {
			
			//Creo un oggetto RubricaGruppoNominativi
			RubricaGruppoNominativi gruppoNominativo = new RubricaGruppoNominativiImpl();
			gruppoNominativo.setFK_GRUPPO((long) objectsGruop[0]);
			gruppoNominativo.setFK_NOMINATIVO((long) objectsGruop[1]);
			gruppoNominativo.setFK_RUOLO((long) objectsGruop[2]);
			
			Nominative nominativeJson = loadNominativoById(idSite, gruppoNominativo.getFK_NOMINATIVO());
			
			if(null != nominativeJson) {
				//estraggo le info sul ruolo
				RubricaRuoloRubrica role = RubricaRuoloRubricaLocalServiceUtil.fetchRubricaRuoloRubrica(gruppoNominativo.getFK_RUOLO());
				
				if(null != role ) {
					nominativeJson.setRole(role.getDESCRIZIONE());
					nominativeJson.setSpecificaRuolo((String)objectsGruop[3]);
				}
									
				listNominativesJson.add(nominativeJson);
			}
			
		}
		return listNominativesJson;
	}
	

	/**
	 * 
	 * @param userId
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	public List<RubricaUserGroup> loadUserGroups(long userId) throws SystemException, PortalException {
		
		List<RubricaUserGroup> listaUserGroupResult = new ArrayList<>();
		
		List<UserGroup> listUserGroup = UserGroupLocalServiceUtil.getUserUserGroups(userId);
		
		for(UserGroup uGroup : listUserGroup) {
			
			RubricaUserGroup rubricaUserGroup = new RubricaUserGroup();
			rubricaUserGroup.setGroupId(uGroup.getGroupId());
			rubricaUserGroup.setName(uGroup.getName());
			
			listaUserGroupResult.add(rubricaUserGroup);	
			
		}
		
		return listaUserGroupResult;
		
	}
	
	

	//------------ FINE RUBRICA GRUPPO -----------//
	

	//------------INIZIO RUBRICA GRUPPO-> NOMINATIVI -----------//
	
	/**
	 * 
	 * @param idGruppo
	 * @param data
	 * @return 
	 * @throws SystemException
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public Map<String, Object> associaGruppoNominativo(Long idGruppo, String data) throws SystemException, JsonParseException, JsonMappingException, IOException {
	
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		//Deserializzo il json
		ObjectMapper mapper = new ObjectMapper();
		GroupNominative gruppoNominativo = mapper.readValue(data, GroupNominative.class);
		
		if(null != gruppoNominativo) {
		
			RubricaGruppoNominativi rubricaGruppoNominativi = new RubricaGruppoNominativiImpl();
					
			rubricaGruppoNominativi.setFK_GRUPPO(idGruppo);
			rubricaGruppoNominativi.setFK_NOMINATIVO(gruppoNominativo.getNominativeId());
			rubricaGruppoNominativi.setFK_RUOLO(gruppoNominativo.getRole());
			rubricaGruppoNominativi.setSPECIFICA_RUOLO(gruppoNominativo.getSpecificaRuolo());
					
			RubricaGruppoNominativiLocalServiceUtil.updateRubricaGruppoNominativi(rubricaGruppoNominativi);
							
			//Logga operazione in RUBRICA_LOG
			aggiornaRubricaLog(TABELLA_RUBRICA_GRUPPO_NOMINATIVI, 
					String.valueOf(rubricaGruppoNominativi.getFK_GRUPPO()).concat("-").concat(String.valueOf(rubricaGruppoNominativi.getFK_NOMINATIVO())).concat("-").concat(String.valueOf(rubricaGruppoNominativi.getFK_RUOLO())),
					TIPO_OPERAZIONE_INSERT, rubricaGruppoNominativi.toString(), userId );
			
			try {
				RubricaNominativo rn = RubricaNominativoLocalServiceUtil.fetchRubricaNominativo(gruppoNominativo.getNominativeId());
				if (rn!=null) {
					rn.setFK_UTENTE_MODIFICA(userId);
					rn.setDATA_MODIFICA(new Date());
					RubricaNominativoLocalServiceUtil.updateRubricaNominativo(rn);
				}
			} catch (Exception ee) {
				ee.printStackTrace();
			}
			
		    mappa.put(CODE, 201);
		    mappa.put(SUCCESS, "inserimento avventuo con successo");
		
		} else {
		     mappa.put(CODE, 400);
		     mappa.put(ERROR, "dati mancanti o errati nella richiesta");	
		}
		return mappa;
		
	}

	
	/**
	 * 
	 * @param idRuolo
	 * @throws SystemException
	 * @throws ParseException
	 * @throws PortalException
	 */
	@Transactional(isolation = Isolation.PORTAL, propagation=Propagation.REQUIRED)
	public void eliminaRubricaRuolo(Long idRuolo) throws SystemException, ParseException, PortalException {
	
		//devo eliminare a cascata anche le relazioni per il ruolo che sto cancellando da RubricaGruppoNominativi 
		eliminaRubricaRuoloById(idRuolo);
		
		eliminaRubricaGruppoNominativiByIdRuolo(idRuolo);
			
	}
	
	/**
	 * 
	 * @param idRuolo
	 * @throws SystemException
	 */
	public void eliminaRubricaGruppoNominativiByIdRuolo(Long idRuolo) throws SystemException {
		
		//Carico la lista che sto per cancellare (per tabella di Log)
		List<Object[]> listaGruppoNominativiPerRuolo = RubricaGruppoNominativiLocalServiceUtil.loadByidRuolo(idRuolo);
				
		for (Object[] objects : listaGruppoNominativiPerRuolo) {
			
			//Creo un nuovo oggetto
			RubricaGruppoNominativi gruppoNominativiDel = new RubricaGruppoNominativiImpl();
			gruppoNominativiDel.setFK_GRUPPO((long) objects[0]);
			gruppoNominativiDel.setFK_NOMINATIVO((long) objects[1]);
			gruppoNominativiDel.setFK_RUOLO(idRuolo);
			
			//Cancello il gruppo nominativo...
			RubricaGruppoNominativiLocalServiceUtil.deleteRubricaGruppoNominativi(gruppoNominativiDel);
			
			//Logga operazione in RUBRICA_LOG
			aggiornaRubricaLog(TABELLA_RUBRICA_GRUPPO_NOMINATIVI, 
					String.valueOf(gruppoNominativiDel.getFK_GRUPPO()+"-"+gruppoNominativiDel.getFK_NOMINATIVO()+"-"+gruppoNominativiDel.getFK_RUOLO()),
					TIPO_OPERAZIONE_UPDATE, gruppoNominativiDel.toString(), userId );

		}
	}
	
	/**
	 * 
	 * @param idGruppo
	 * @param data
	 * @return 
	 * @throws SystemException
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public Map<String, Object> eliminaGruppoNominativiByIdNominativo(Long idGruppo, String data) throws SystemException, JsonParseException, JsonMappingException, IOException {
	
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		//Deserializzo il json
		ObjectMapper mapper = new ObjectMapper();
		GroupNominative groupNominative = mapper.readValue(data, GroupNominative.class);
		
		if(null != groupNominative) {
			
			//carico i dati che sto per cancellare
			RubricaGruppoNominativi rubricaGruppoNominativo;
			try {
				rubricaGruppoNominativo = RubricaGruppoNominativiUtil.findByPrimaryKey(new RubricaGruppoNominativiPK(idGruppo, groupNominative.getNominativeId()));
			} catch (NoSuchRubricaGruppoNominativiException e) {
				//logger.error("Errore in cancellazione. Relazione gruppo nominativi non presente", e);
				mappa.put(CODE, 404 );
				mappa.put(ERROR, "associazione non presente, impossibile cancellare");
				return mappa;
			}
			
			//Aggiorna Log
			if(null!=rubricaGruppoNominativo) {
				
				

				RubricaGruppoNominativiLocalServiceUtil.deleteNominativoDaGruppo(idGruppo, groupNominative.getNominativeId());
				
				RubricaGruppo rg = RubricaGruppoLocalServiceUtil.fetchRubricaGruppo(idGruppo);
				if (rg!=null) {
					rg.setDATA_MODIFICA(new Date());
					rg.setFK_UTENTE_MODIFICA(userId);
					RubricaGruppoLocalServiceUtil.updateRubricaGruppo(rg);
				}
				
				aggiornaRubricaLog(TABELLA_RUBRICA_GRUPPO_NOMINATIVI, 
							String.valueOf(idGruppo).concat("-").concat(String.valueOf(groupNominative.getNominativeId())).concat("-").concat(String.valueOf(rubricaGruppoNominativo.getFK_RUOLO())), 
							TIPO_OPERAZIONE_DELETE,	rubricaGruppoNominativo.toString(), userId );
				
				mappa.put(CODE, 204 );
				mappa.put(SUCCESS, "cancellazione avvenuta con successo");

			}
			
			else {
				mappa.put(CODE, 204 );
				mappa.put(ERROR, "associazione non presente, impossibile cancellare");
			}

		} else {
			mappa.put(CODE, 400 );
			mappa.put(ERROR, "dati mancanti, cancellazione non effettuata");
		}
		
		return mappa;
	}
	
	/**
	 * 
	 * @param idRuolo
	 * @throws SystemException
	 * @throws ParseException
	 * @throws PortalException
	 */
	@Transactional(isolation = Isolation.PORTAL, propagation=Propagation.REQUIRED)
	public void eliminaRubricaRuoloById(Long idRuolo) throws SystemException, ParseException, PortalException {
	
		//mi carico prima le info per la tabella di log
		RubricaRuolo ruoloDel = RubricaRuoloLocalServiceUtil.fetchRubricaRuolo(idRuolo);
		
		//devo eliminare a cascata anche le relazioni per il ruolo che sto cancellando da RubricaGruppoNominativi 
		RubricaRuoloLocalServiceUtil.deleteRubricaRuolo(idRuolo);
						
		//Aggiorna Log
		aggiornaRubricaLog(TABELLA_RUBRICA_RUOLO, String.valueOf(idRuolo), TIPO_OPERAZIONE_DELETE, ruoloDel.toString(), userId );
			
	}
	
	//------------FINE RUBRICA RUOLO -----------//
	
	
	//------------INIZIO RUBRICA CANALE ---------//
	
	
	/**
	 * 
	 * Metodo che carica tutti i canali
	 * 	
	 * @return
	 * @throws SystemException
	 */
	public List<Channel> loadChannels() throws SystemException {
		
		List<Channel> listChannel = new ArrayList<>();
		List<RubricaCanale> listaRubricaCanale = new ArrayList<>();
		listaRubricaCanale= RubricaCanaleUtil.findAll();
		
		for(RubricaCanale canale : listaRubricaCanale) {
			
			Channel channel = new Channel();
			channel.setId(canale.getID_CANALE());
			channel.setName(canale.getNOME());
			channel.setRegEx(canale.getREGEX());
			
			listChannel.add(channel);
			
		}
		return listChannel;
	}
	
	
	//-----------FINE RUBRICA CANALE ----------//
	
	
	
	//------------INIZIO RUBRICA RUOLO ---------//
	
	/**
	 * 
	 * Metodo che carica tutti i ruoli
	 * 	
	 * @return
	 * @throws SystemException
	 */
	public List<Role> loadRoles() throws SystemException {
		
		List<Role> listRole = new ArrayList<>();
		List<RubricaRuolo> listaRubricaRuolo = new ArrayList<>();

		listaRubricaRuolo= RubricaRuoloUtil.findAll();
		
		for(RubricaRuolo ruolo : listaRubricaRuolo) {
			
			Role role = new Role();
			role.setId(ruolo.getID_RUOLO());
			role.setName(ruolo.getDESCRIZIONE());
			
			listRole.add(role);
			
		}
		return listRole;
	}
	
	
	/**
	 * 
	 * @return
	 * @throws SystemException
	 */
	public List<Role> loadAddressBookRoles() throws SystemException {
		List<Role> listRole = new ArrayList<>();
		List<RubricaRuolo> listaRubricaRuolo = new ArrayList<>();

		listaRubricaRuolo= RubricaRuoloUtil.findAll();
		
		for(RubricaRuolo ruolo : listaRubricaRuolo) {
			
			Role role = new Role();
			role.setId(ruolo.getID_RUOLO());
			role.setName(ruolo.getDESCRIZIONE());
			
			listRole.add(role);
			
		}
		Collections.sort(listRole, new Comparator<Role>() {

			@Override
			public int compare(Role o1, Role o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		return listRole;
	}
	
	
	
	//------------FINE RUBRICA RUOLO ---------//
	
	
	
	
	//-------------- INIZIO RUBRICA PERMESSI -----------//
	
	public List<Permission> loadPermission() throws SystemException {
		
		List<Permission> listPermessi = new ArrayList<>();
		List<RubricaPermessi> listaRubricaPermessi = new ArrayList<>();

		listaRubricaPermessi= RubricaPermessiUtil.findAll();
		
		for(RubricaPermessi perm : listaRubricaPermessi) {
			
			Permission permission = new Permission();
			permission.setId(perm.getID_PERMESSO());
			permission.setName(perm.getNOME_PERMESSO());
			
			listPermessi.add(permission);
			
		}
		
		return listPermessi;
	}
	
	
	/**
	 * 
	 * @return
	 * @throws SystemException 
	 */
	public List<LiferayRolePermission> loadLiferayRolesPermission() throws SystemException {
		
		List<com.liferay.portal.kernel.model.Role> listaLiferayRoles = new ArrayList<>();
		
		RoleUtil.clearCache();
		listaLiferayRoles = RoleUtil.findAll();
		List<LiferayRolePermission> listRolePermissionFinal = new ArrayList<>();
		
		for(com.liferay.portal.kernel.model.Role role : listaLiferayRoles) {
			
			//Verifico se per il ruolo ho dei permessi ineseriti 
			//RubricaRuoloUtil.clearCache();
			//RubricaRuolo ruolo = RubricaRuoloUtil.fetchByRubricaRuoloByRuoloLiferay(role.getRoleId());
			//if(null == ruolo) {
				////logger.error("ruolo non presente in rubrica per role liferay id: " + role.getRoleId() );
			//} else {
				
				LiferayRolePermission permission = new LiferayRolePermission();
				permission.setRoleId(role.getRoleId());
			 	permission.setRoleName(role.getName());
				
				//verifica permessi
			 	RubricaRuoloPermessiUtil.clearCache();
				List<RubricaRuoloPermessi> listaRubricaPermessi = RubricaRuoloPermessiUtil.findByRubricaPermessiByRuolo(role.getRoleId());
				if(null != listaRubricaPermessi && ! listaRubricaPermessi.isEmpty()) {
				
					for(RubricaRuoloPermessi ruoloPermessi : listaRubricaPermessi) {
				 	
					 	if(ruoloPermessi.getFK_ID_PERMESSO().equals("P")) {
					 		permission.setPermission(true);
					 	}
					 	if(ruoloPermessi.getFK_ID_PERMESSO().equals("W")) {
					 		permission.setWrite(true);
					 	}
					 	if(ruoloPermessi.getFK_ID_PERMESSO().equals("R")) {
					 		permission.setRead(true);
					 	}
					 				 	
					}
						
					
				//} 
				
				listRolePermissionFinal.add(permission);
				
			}
									
		}
		
		return listRolePermissionFinal;
	}

	/**
	 * 
	 * @param data
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SystemException
	 */
	public Map<String, Object> inserisciRuoloPermessi(String data) throws JsonParseException, JsonMappingException, IOException, SystemException {
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		
		//Deserializzo il json
		ObjectMapper mapper = new ObjectMapper();
		LiferayRolePermission[] liferayRole = mapper.readValue(data, LiferayRolePermission[].class);
		
		if(null != liferayRole) {

			for(LiferayRolePermission perm : liferayRole) {
			
				RubricaRuoloPermessi permessi = new RubricaRuoloPermessiImpl();
					
				permessi.setFK_ID_RUOLO(perm.getRoleId());
				
				//Inserisco se true, se false cancello perchè la NON presenza del permesso in tabella significa che NON ho un determinato tipo di permesso
				
				if(perm.isPermission()) {
					permessi.setFK_ID_PERMESSO("P");
					//RubricaPermessiGruppo
					RubricaRuoloPermessiLocalServiceUtil.updateRubricaRuoloPermessi(permessi);
						
					//Logga operazione in RUBRICA_LOG
					aggiornaRubricaLog(TABELLA_RUBRICA_RUOLO_PERMESSI, String.valueOf(permessi.getFK_ID_RUOLO()).concat("-").concat(permessi.getFK_ID_PERMESSO()), 
									TIPO_OPERAZIONE_INSERT, permessi.toString(), userId );
						
				} else {
					permessi.setFK_ID_PERMESSO("P");
					//RubricaPermessiGruppo
					RubricaRuoloPermessiLocalServiceUtil.deleteRubricaRuoloPermessi(permessi);
						
					//Logga operazione in RUBRICA_LOG
					aggiornaRubricaLog(TABELLA_RUBRICA_RUOLO_PERMESSI, String.valueOf(permessi.getFK_ID_RUOLO()).concat("-").concat(permessi.getFK_ID_PERMESSO()), 
									TIPO_OPERAZIONE_DELETE, permessi.toString(), userId );
				}
				if(perm.isRead()) {
					permessi.setFK_ID_PERMESSO("R");
					//RubricaPermessiGruppo
					RubricaRuoloPermessiLocalServiceUtil.updateRubricaRuoloPermessi(permessi);
						
					//Logga operazione in RUBRICA_LOG
					aggiornaRubricaLog(TABELLA_RUBRICA_RUOLO_PERMESSI, String.valueOf(permessi.getFK_ID_RUOLO()).concat("-").concat(permessi.getFK_ID_PERMESSO()), 
									TIPO_OPERAZIONE_INSERT, permessi.toString(), userId );
				} else {
					permessi.setFK_ID_PERMESSO("R");
					//RubricaPermessiGruppo
					RubricaRuoloPermessiLocalServiceUtil.deleteRubricaRuoloPermessi(permessi);
						
					//Logga operazione in RUBRICA_LOG
					aggiornaRubricaLog(TABELLA_RUBRICA_RUOLO_PERMESSI, String.valueOf(permessi.getFK_ID_RUOLO()).concat("-").concat(permessi.getFK_ID_PERMESSO()), 
									TIPO_OPERAZIONE_DELETE, permessi.toString(), userId );
				}
				if(perm.isWrite()){
					permessi.setFK_ID_PERMESSO("W");
					//RubricaPermessiGruppo
					RubricaRuoloPermessiLocalServiceUtil.updateRubricaRuoloPermessi(permessi);
						
					//Logga operazione in RUBRICA_LOG
					aggiornaRubricaLog(TABELLA_RUBRICA_RUOLO_PERMESSI, String.valueOf(permessi.getFK_ID_RUOLO()).concat("-").concat(permessi.getFK_ID_PERMESSO()), 
									TIPO_OPERAZIONE_INSERT, permessi.toString(), userId );
				} else {
					permessi.setFK_ID_PERMESSO("W");
					//RubricaPermessiGruppo
					RubricaRuoloPermessiLocalServiceUtil.deleteRubricaRuoloPermessi(permessi);
						
					//Logga operazione in RUBRICA_LOG
					aggiornaRubricaLog(TABELLA_RUBRICA_RUOLO_PERMESSI, String.valueOf(permessi.getFK_ID_RUOLO()).concat("-").concat(permessi.getFK_ID_PERMESSO()), 
									TIPO_OPERAZIONE_DELETE, permessi.toString(), userId );
				}
				
//
//					
//				//RubricaPermessiGruppo
//				RubricaRuoloPermessiLocalServiceUtil.updateRubricaRuoloPermessi(permessi);
//					
//				//Logga operazione in RUBRICA_LOG
//				aggiornaRubricaLog(TABELLA_RUBRICA_RUOLO_PERMESSI, String.valueOf(permessi.getFK_ID_RUOLO()).concat("-").concat(permessi.getFK_ID_PERMESSO()), 
//								TIPO_OPERAZIONE_INSERT, permessi.toString(), userId );
					
				mappa.put(CODE, 200);
				mappa.put(SUCCESS, "inserimento avvenuto con successo");
			}
				
		} else {
			mappa.put(CODE, 400);
			mappa.put(ERROR, "impossibile inserire, dati mancanti");
		}
			
		return mappa;
	}

	
	/**
	 * 
	 * @param data
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SystemException
	 */
//	public Map<String, Object> aggiornaRuoloPermessi(long idRuolo, String data) throws JsonParseException, JsonMappingException, IOException, SystemException {
//		
//		Map<String,Object> mappa = new HashMap<String, Object>();
//		
//		//Deserializzo il json
//		ObjectMapper mapper = new ObjectMapper();
//		LiferayRolePermissionUpdateRequest liferayRole = mapper.readValue(data, LiferayRolePermissionUpdateRequest.class);
//		
//		if(null != liferayRole) {
//							
//			List<RubricaRuoloPermessi> 	permessiUpdate = RubricaRuoloPermessiUtil.findByRubricaPermessiByRuolo(idRuolo);
//			
//			if(null == permessiUpdate || permessiUpdate.isEmpty()) {
//				//logger.error("Errore in fase di aggiornamento permessi. Ruolo non trovato");
//				mappa.put(CODE, 400);
//				mappa.put(ERROR, "impossibile aggiornare, permessi non presenti per il ruolo " + idRuolo);
//				return mappa;
//	
//			}
//			
//			for(String perm : liferayRole.getPermissionId()) {
//				
//				RubricaRuoloPermessi permessi = new RubricaRuoloPermessiImpl();
//					
//				permessi.setFK_ID_RUOLO(idRuolo);
//				permessi.setFK_ID_PERMESSO(perm);
//					
//				//RubricaPermessiGruppo
//				RubricaRuoloPermessiLocalServiceUtil.updateRubricaRuoloPermessi(permessi);
//					
//				//Logga operazione in RUBRICA_LOG
//				aggiornaRubricaLog(TABELLA_RUBRICA_RUOLO_PERMESSI, String.valueOf(permessi.getFK_ID_RUOLO()).concat("-").concat(permessi.getFK_ID_PERMESSO()), 
//								TIPO_OPERAZIONE_INSERT, permessi.toString(), userId );
//					
//				mappa.put(CODE, 200);
//				mappa.put(SUCCESS, "aggiornamento avvenuto con successo");
//			}
//			
//			
//		} else {
//			
//			mappa.put(CODE, 400);
//			mappa.put(ERROR, "dati mancanti, impossibile aggiornare");
//			
//		}
//		
//		return mappa;
//		
//		
//	}

	
	/**
	 * 
	 * @param idPermesso
	 * @return
	 * @throws SystemException 
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public Map<String, Object> cancellaRuoloPermessi(long idRuolo, String data) throws SystemException, JsonParseException, JsonMappingException, IOException {
		
		Map<String,Object> mappa = new HashMap<String, Object>();
		
//		//Deserializzo il json
//		ObjectMapper mapper = new ObjectMapper();
//		LiferayRolePermission liferayRole = mapper.readValue(data, LiferayRolePermission.class);
//		
//		if(null != liferayRole) {
//		
//			for(String perm : liferayRole.getPermissionId()) {
//				
//				RubricaRuoloPermessi permessi = new RubricaRuoloPermessiImpl();
//					
//				permessi.setFK_ID_RUOLO(idRuolo);
//				permessi.setFK_ID_PERMESSO(perm);
//					
//					
//				//RubricaPermessiGruppo
//				RubricaRuoloPermessiLocalServiceUtil.deleteRubricaRuoloPermessi(permessi);
//					
//				//Logga operazione in RUBRICA_LOG
//				aggiornaRubricaLog(TABELLA_RUBRICA_RUOLO_PERMESSI, String.valueOf(idRuolo).concat("-").concat(permessi.getFK_ID_PERMESSO()), 
//								TIPO_OPERAZIONE_DELETE, permessi.toString(), userId );
//	
//			}
//			
//	
//			mappa.put(CODE, 204 );
//			mappa.put(SUCCESS, "cancellazione avvenuta con successo");
//		
//		} else {
//			mappa.put(CODE, 400);
//			mappa.put(ERROR, "dati mancanti, impossibile cancellare");
//			
//		}
				
		return mappa; 
				
	}
	
	//-------------- FINE RUBRICA PERMESSI ------------//
	
	//------------INIZIO RUBRICA LOG -----------//
	
	/**
	 * Aggiorna Log
	 * 
	 * @param rubricaContatto
	 * @throws SystemException
	 */
	private void aggiornaRubricaLog(String nomeTabella, String idOggetto, String tipoOperazione, String value, long creatorUserId) throws SystemException {
		
		//Creo oggetto di Log		
		RubricaLog rubricaLog = creaRubricaLog(nomeTabella, idOggetto, tipoOperazione, value,  creatorUserId, new Date());
		//e lo inserisco
		inserimentoRubricaLog(rubricaLog);
	}
	
	/**
	 * 
	 * @param nomeTabella
	 * @param idOggetto
	 * @param tipoOperazione
	 * @param nuovaDescrizione
	 * @param userId
	 * @param dataModifica
	 * @return
	 */
	public RubricaLog creaRubricaLog (String nomeTabella, String idOggetto, String tipoOperazione,
									  String nuovaDescrizione, Long userId, Date dataModifica){

		RubricaLog rubricaLog = new RubricaLogImpl();
		
		rubricaLog.setDATA_MODIFICA(dataModifica);
		rubricaLog.setFK_SITO_PROPRIETARIO(groupId);
		rubricaLog.setFK_UTENTE_MODIFICA(userId);
		rubricaLog.setID_OGGETTO(idOggetto);
		rubricaLog.setNUOVA_DESCRIZIONE(nuovaDescrizione);
		rubricaLog.setTABELLA(nomeTabella);
		rubricaLog.setTIPO_OPERAZIONE(tipoOperazione);
		
		
		return rubricaLog;
	}
	
	/**
	 * Inserimento in Rubrica Log
	 * 
	 * @param rubricaLog
	 * @throws SystemException 
	 */
	@Transactional(isolation = Isolation.PORTAL, propagation=Propagation.REQUIRED)
	public void inserimentoRubricaLog(RubricaLog rubricaLog) throws SystemException{
		//setto l'id
		rubricaLog.setID_LOG(CounterLocalServiceUtil.increment(RubricaLog.class.getName()));
			
		RubricaLogLocalServiceUtil.updateRubricaLog(rubricaLog);

	}
	
	/**
	 * Aggiorna in Rubrica Log
	 * 
	 * @param rubricaLog
	 * @throws SystemException 
	 */
	@Transactional(isolation = Isolation.PORTAL, propagation=Propagation.REQUIRED)
	public void aggiornaRubricaLog(RubricaLog rubricaLog) throws SystemException{
		RubricaLogLocalServiceUtil.updateRubricaLog(rubricaLog);
	}
	
	/**
	 * Aggiorna in Rubrica Log
	 * 
	 * @param rubricaLog
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	@Transactional(isolation = Isolation.PORTAL, propagation=Propagation.REQUIRED)
	public void cancellaRubricaLogById(Long id) throws PortalException, SystemException{
		RubricaLogLocalServiceUtil.deleteRubricaLog(id);
	}

	/**
	 * 
	 * @param name
	 * @param limit
	 * @param offset
	 * @return
	 * @throws SystemException
	 * @throws ParseException
	 * @throws PortalException
	 * @throws JsonProcessingException
	 */
	public List<Log> loadLogs(String name, Long limit, Long offset) throws SystemException, ParseException, PortalException, JsonProcessingException {

		//carico i log per la tabella in name
		if (name==null) name = "";
		List<Object[]> listaLogObj = RubricaLogLocalServiceUtil.getLogByNameTable(name, groupId, limit, offset);
		
		List<Log> listaLogResult = new ArrayList<>();
		List<RubricaLog> listaLog = new ArrayList<>();
		
		//Se name non è valorizzato carico tutto
		//if(StringUtils.isNotBlank(name)) {
		
			if(null != listaLogObj && listaLogObj.size() > 0) {
											
				//Trasformo la lista
				for (Object[] objectLog : listaLogObj) {
				
					//Creo un nuovo oggetto
					RubricaLog log = new RubricaLogImpl();
					log.setID_LOG((long)objectLog[0]);
					log.setFK_SITO_PROPRIETARIO((long)objectLog[1]);
					log.setTABELLA((String) objectLog[2]);
					log.setTIPO_OPERAZIONE((String) objectLog[3]);
					log.setID_OGGETTO((String) objectLog[4]);
					log.setNUOVA_DESCRIZIONE((String) objectLog[5]);
					log.setFK_UTENTE_MODIFICA((Long) objectLog[6] );
					log.setDATA_MODIFICA((Date) objectLog[7]);
							
					listaLog.add(log);
					
				}
			}
		
		/*} else {
			int end = RubricaUtil.calcolaEnd(offset.intValue(), limit.intValue());
			int start = RubricaUtil.calcolaStart(offset.intValue(), limit.intValue());
			listaLog = RubricaLogUtil.findByRubricaLogBySitoProprietario(groupId, start, end, new OrderByComparator() {
				
				@Override
				public int compare(Object arg0, Object arg1) {
					// TODO Auto-generated method stub
					return 0;
				}
			});
		}*/
		
		for(RubricaLog rubricaLog : listaLog) {
			
			Log logResult = new Log();
			logResult.setDescription(rubricaLog.getNUOVA_DESCRIZIONE());
			logResult.setObjectId(rubricaLog.getID_OGGETTO());
			logResult.setOperation(rubricaLog.getTIPO_OPERAZIONE());
			logResult.setTable(rubricaLog.getTABELLA());
			if(null != rubricaLog.getDATA_MODIFICA()) {
				logResult.setEditDate(rubricaLog.getDATA_MODIFICA().getTime());
			}
			UserInfo lastUserEditInfo = new UserInfo();
			User user = UserLocalServiceUtil.fetchUser(rubricaLog.getFK_UTENTE_MODIFICA());
			if(null != user) {
				lastUserEditInfo.setId(user.getUserId());
				lastUserEditInfo.setLastName(user.getLastName());
				lastUserEditInfo.setFirstName(user.getFirstName());
				logResult.setEditUser(lastUserEditInfo);
			}
						
			listaLogResult.add(logResult);
									
		}
		
		return listaLogResult;
	}

	//---------------------FINE RUBRICA LOG ----------------------------------//
	
	//-------------------- INIZIO IMPORTAZIONE NOMINATIVI/CONTATTI CSV--------//
	/**
	 * 
	 * @param file
	 * @param groupId
	 * @return
	 * @throws SystemException
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public Map<String, Object> importNominatives(File file, long groupId) throws IOException {
		
		//logger.info("--Avvio processo importazione nominativi contatti da file csv--");
		
		/*Map<String,Object> mappaResult = new HashMap<String, Object>();
		Map<String, List<NominativeCSV>> mappa = new HashMap<String, List<NominativeCSV>>();
				
		FileInputStream fis = null;
		InputStreamReader isr = null;
		CSVReader reader = null;
		
		try {
			int totaleRigheInErrore = 0;
			int index = 0;
			List<Integer> numeroRigaInErrore = new ArrayList<>();
			List<String> msgReturn = new ArrayList<>();
			List<String> listaNominativiContattiGiaPresenti = new ArrayList<>();
		
			try {
		    	fis = new FileInputStream(file);
		    	isr = new InputStreamReader(fis,StandardCharsets.UTF_8);
		        reader = new CSVReader(isr, ';') {};
		    } 
		    catch(IOException e) {
		      	//logger.error("Errore in lettura del file csv");
	      	
		    	mappaResult.put(CODE, 400);
		    	mappaResult.put(ERROR, "errore lettura file csv: " + file.getName());
				return mappaResult;
		    } 
				
			//salto la prima riga di intestazione
			String[] record  = reader.readNext();
		
			while ((record = reader.readNext()) != null) {
						
				try {
					    
					index++;
						
					NominativeCSV nom = new NominativeCSV();
					nom.setNome(record[0].trim());
					nom.setCognome(record[1].trim());
					nom.setIndirizzo(record[2].trim());
					nom.setTipoContatto(record[3].trim());
					nom.setContatto(record[4].trim());
					nom.setAllertamento("true".equalsIgnoreCase(record[5].trim())? true:false);
					if(null!=record[6] && StringUtils.isNotBlank(record[6])){
						nom.setDisambiguatore(new Long(record[6].trim()));
					}
											
					String chiave = costruisciChiave(nom);	
					//creo la mappa con chiave nome-cognome-disambiguatore -> List<NominativeCSV>
					if(null == mappa.get(chiave)){
						//lo creo
						List<NominativeCSV> listaNominativi = new ArrayList<>();
						listaNominativi.add(nom);
						mappa.put(chiave, listaNominativi);
					} else {
						//lo aggiungo
						mappa.get(chiave).add(nom);
					}
							
				} catch(Exception e) {
					//in caso di errore nei dati non blocco ma elaboro la riga successiva
					//tengo traccia della riga in errore
					//logger.error("Errore elaborazione file csv. Riga numero: " + index, e);
					numeroRigaInErrore.add(index);
					totaleRigheInErrore++;
				}
			}
			
			//Scorro la mappa
			Set list  = mappa.keySet();
			Iterator iter = list.iterator();
		            			
			while(iter.hasNext()) {
		                 
				String key = (String) iter.next();
				List<NominativeCSV> value = mappa.get(key);
		            
				//cerco il primo indirizzo valorizzato, se esite, da copiare sugli altri oggetti per lo stesso nominativo
				String indirizzo = null;
				for(NominativeCSV nominative : value) {
					if(StringUtils.isNotBlank(nominative.getIndirizzo())) {
						indirizzo=nominative.getIndirizzo();
						break;
					}
				}
				
				for(NominativeCSV nominative : value) {
		                
					//verifica se ho gia inserito il nomintativo per il gruppo proprietario
					//Per stesso nominativo si intende l'uguaglianza su nome cognome e contatto
					String cognome = nominative.getCognome();
				
					if(null != nominative.getDisambiguatore()) {
						cognome = cognome.concat(" ").concat(String.valueOf(nominative.getDisambiguatore()));
						//sovrascrivo il cognome anche nell'oggetto csv
						nominative.setCognome(cognome);
					}
					List<RubricaNominativo> listaNominativi = RubricaNominativoUtil.findByNominativoPerGruppoByNomeCognome(cognome, nominative.getNome(), groupId);
						
					//setto l'indirizzo
					nominative.setIndirizzo(indirizzo);
					
					//se non ho inserito nulla oppure se ancora non ho elaborato l'elemento lo creo da zero
					if(null == listaNominativi || listaNominativi.isEmpty() ) {
						
						creaNominativoContattoFromCsv(nominative);
						
					} else {
						//verifica contatto
						for(RubricaNominativo nominativo : listaNominativi) {
							
							//Se il nominativo è lo stesso verifico il contatto
							if(verificaUguaglianzaNominativo(nominative, nominativo)) {
								
								//Stesso nominativo, verifica se anche i contatti sono uguali
								//Se non sono uguali aggiungo il contatto al nominativo altrimenti contatto e nominativo già presenti
								if(hasContact(nominative) && ! verificaContattiPerNominativo(nominative, nominativo.getID_NOMINATIVO())) {
									//Crea contatto mancante per il nominativo
									creaContattoByImportCsv(nominative, nominativo.getID_NOMINATIVO());
								}  else {
									//logger.info("Nominativo e contatto già presente: " + nominative.getNome().concat(" ").concat(nominative.getCognome().concat(" Contatto: ").concat(nominative.getContatto())));
									listaNominativiContattiGiaPresenti.add(nominative.getNome().concat(" ").concat(nominative.getCognome().concat(" Contatto: ").concat(nominative.getContatto())));
								
								}
							} 
						}
					}
				}
			}
			
			//logger.info("--Importazione Nominativi Contatti Terminata--");
			//logger.info("Sono state elaborate correttamente: " + (index-totaleRigheInErrore) + " elementi " );
			//logger.info("Elementi con errori: " + totaleRigheInErrore);
			//logger.info("Numero riga in errore: ");
			for(Integer numRiga : numeroRigaInErrore ) {
				//logger.info(String.valueOf(numRiga));
			}
			//logger.info("---------------------------");
			
			msgReturn.add("Sono state elaborate correttamente: " + (index-totaleRigheInErrore) + " elementi ");
			msgReturn.add("Righe totali in errore: " + totaleRigheInErrore);
			msgReturn.add("Numero di riga in errore :"  + numeroRigaInErrore.toString());
			msgReturn.add("Nominativi/contatti già presenti in rubrica: " + listaNominativiContattiGiaPresenti.toString());
			
			
			mappaResult.put(CODE, 200);
			mappaResult.put(SUCCESS, msgReturn);
		}
		catch (Exception e) {
			mappaResult.put(CODE, 400);
			mappaResult.put(ERROR, "Errore elaborazione file csv: " + file.getName());	
		}

		finally {	
			fis.close();
			isr.close();
			reader.close();
		}
	
		return mappaResult;*/
		return null;
	}

	
	/**
	 * 
	 * @param indirizzo
	 * @param nominative
	 * @throws SystemException
	 */
	private void creaNominativoContattoFromCsv(NominativeCSV nominative) throws SystemException {
	
		Long idNominativo = creaNominativoByImportCsv(nominative);
		//verifica se ho i dati del contatto da agganciare al nominativo, altrimenti creo solo il nominativo
		if(hasContact(nominative)) {
			creaContattoByImportCsv(nominative, idNominativo);
		}
	}
	
	/**
	 * Il metodo verifica se è stato inserito il contatto nel file csv di import
	 * @param nominative 
	 *  
	 * @return
	 */
	private boolean hasContact(NominativeCSV nominative) {
		return null!=nominative.getContatto();
	}

	/**
	 * 
	 * @param nominative
	 * @param idNominativo
	 * @throws SystemException
	 */
	private void creaContattoByImportCsv(NominativeCSV nominative, long idNominativo) throws SystemException {
		
		RubricaContatto rubricaContatto = new RubricaContattoImpl();
		
		//setto l'id
		rubricaContatto.setID_CONTATTO(CounterLocalServiceUtil.increment(RubricaContatto.class.getName()));
		
		//Setto la FK del nominativo
		rubricaContatto.setFK_NOMINATIVO(idNominativo);
		
		rubricaContatto.setALLERTAMENTO(nominative.isAllertamento());
		if(nominative.getTipoContatto().endsWith("mail") || nominative.getTipoContatto().endsWith("MAIL") ) {
			rubricaContatto.setFK_CANALE(new Long (1));
		} else if (nominative.getTipoContatto().startsWith("cell") || nominative.getTipoContatto().startsWith("CELL")) {
			rubricaContatto.setFK_CANALE(new Long (3));
		} else if (nominative.getTipoContatto().startsWith("tel") || nominative.getTipoContatto().startsWith("TEL")) {
			rubricaContatto.setFK_CANALE(new Long (2));
		} else {
			//default mail ?
			rubricaContatto.setFK_CANALE(new Long (1));
		}
		
		rubricaContatto.setCONTATTO(nominative.getContatto());
		rubricaContatto.setDATA_FINE_VALIDITA(null);
		
		//in inserimento data ins e modifica saranno le stesse
		rubricaContatto.setDATA_MODIFICA(new Date());
		rubricaContatto.setDATA_CREAZIONE(new Date());
		
		//setto l'id dell'utente che sta creando il contatto e quello di modifica in modo uguale
		rubricaContatto.setFK_UTENTE_CREAZIONE(userId);
		rubricaContatto.setFK_UTENTE_MODIFICA(userId);
		
		RubricaContattoLocalServiceUtil.updateRubricaContatto(rubricaContatto);
				
		//Logga operazione in RUBRICA_LOG
		aggiornaRubricaLog(TABELLA_RUBRICA_CONTATTO, String.valueOf(rubricaContatto.getID_CONTATTO()),TIPO_OPERAZIONE_INSERT, rubricaContatto.toString(), userId );
	
	}

	/**
	 * 
	 * @param nominative
	 * @throws SystemException 
	 */
	private Long creaNominativoByImportCsv(NominativeCSV nominative) throws SystemException {
		
		RubricaNominativo nominativo = new RubricaNominativoImpl();
		nominativo.setID_NOMINATIVO(CounterLocalServiceUtil.increment(RubricaNominativo.class.getName()));
		nominativo.setCOGNOME(nominative.getCognome());
		nominativo.setNOME(nominative.getNome());
		nominativo.setINDIRIZZO(nominative.getIndirizzo());
		nominativo.setFK_SITO_PROPRIETARIO(groupId);  
		nominativo.setFK_UTENTE_PORTALE(0); // //Al momento abbiamo detto non serve questa info, lo setto sempre a 0
		
		//Setto le date di creazione e modifica in inserimento saranno le stesse
		nominativo.setDATA_MODIFICA(new Date());
		nominativo.setDATA_CREAZIONE(new Date());
		
		//e setto l'utente che sta creando il contatto
		//setto anche quello di modifica uguale a quello di creazione in questa fase
		nominativo.setFK_UTENTE_CREAZIONE(userId);
		nominativo.setFK_UTENTE_MODIFICA(userId);

		RubricaNominativoLocalServiceUtil.updateRubricaNominativo(nominativo);
		
		//Logga operazione in RUBRICA_LOG
		aggiornaRubricaLog(TABELLA_RUBRICA_NOMINATIVO, String.valueOf(nominativo.getID_NOMINATIVO()),TIPO_OPERAZIONE_INSERT, nominativo.toString(), userId );
		
		return nominativo.getID_NOMINATIVO();
	}

	/**
	 * 
	 * @param nominative
	 * @param idNominativo
	 * @return
	 * @throws SystemException
	 */
	private boolean verificaContattiPerNominativo(NominativeCSV nominative, long idNominativo) throws SystemException {

		List<RubricaContatto> listaContatti = RubricaContattoUtil.findByContattoNominativo(idNominativo);
		if(null != listaContatti) {
			for(RubricaContatto contatto : listaContatti) {
				if(contatto.getCONTATTO().equalsIgnoreCase(nominative.getContatto())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @param nominative
	 * @param nominativo
	 * @return
	 * @throws SystemException
	 */
	private boolean verificaUguaglianzaNominativo(NominativeCSV nominative, RubricaNominativo nominativo) throws SystemException {

		if(nominative.getCognome().equalsIgnoreCase(nominativo.getCOGNOME()) &&
		   nominative.getNome().equalsIgnoreCase(nominativo.getNOME()) 
				) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param nom
	 * @return
	 */
	private static String costruisciChiave(NominativeCSV nom) {
		return nom.getNome().concat("-").concat(nom.getCognome().concat("-").concat(null!=nom.getDisambiguatore()? String.valueOf(nom.getDisambiguatore()) : String.valueOf(0)));
	}

	/**
	 * 
	 * @return
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public UserInfoLogin loadUserInfoLogin() throws SystemException, PortalException {

		UserInfoLogin userInfoLogin = new UserInfoLogin();

		User userInfo = UserLocalServiceUtil.fetchUser(userId);

		//Group groupInfo = GroupLocalServiceUtil.getGroup(groupId);

		userInfoLogin.setLastName(userInfo.getLastName());
		userInfoLogin.setFirstName(userInfo.getFirstName());
		userInfoLogin.setUserId(userId);
		userInfoLogin.setCurrentSiteId(groupId);
		userInfoLogin.setCurrentSiteName("");
	
		boolean permission = false;
		boolean read = false;
		boolean write = false;		

		List<com.liferay.portal.kernel.model.Role> roles = userInfo.getRoles();
		List<Group> mySiteGroups = userInfo.getMySiteGroups();
		
		List<com.liferay.portal.kernel.model.Role> listaRuoliPerSito = new ArrayList<>();
		
		for(com.liferay.portal.kernel.model.Role role:roles){

			for(Iterator<Group> ite=mySiteGroups.iterator();ite.hasNext();){
				Group next = ite.next();

				if(next.getGroupId() == groupId) {
					listaRuoliPerSito.add(role);
				}
			}

		}
			
		//Per ogni ruolo verifica i permessi (se per un ruolo NON sono abilitato su un permesso (es: scrittura) ma per un altro lo sono, allora "vince" il permesso in scrittura)
		for(com.liferay.portal.kernel.model.Role role : listaRuoliPerSito) {
			
			//Estraggo l'oggetto che mappa il ruolo liferay nella rubrica
			//RubricaRuolo rubricaRuolo = RubricaRuoloUtil.findByRubricaRuoloByRuoloLiferay(role.getRoleId());
			List<RubricaRuoloPermessi> listaPermessiRuolo = RubricaRuoloPermessiUtil.findByRubricaPermessiByRuolo(role.getRoleId());
			
			for(RubricaRuoloPermessi ruoloPermessi: listaPermessiRuolo) {
				//Valuto il permesso per la gestione dei permessi solo se ancora false
				if(null != ruoloPermessi && null != ruoloPermessi.getFK_ID_PERMESSO()) {
				
					if(ruoloPermessi.getFK_ID_PERMESSO().equals("P") && !permission) {
						permission = true;
					}
					//Valuto il permesso per scrittura
					if(ruoloPermessi.getFK_ID_PERMESSO().equals("W") && !write) {
						write = true;
					}
					//Valuto il permesso per la gestione dei permessi solo se ancora false
					if(ruoloPermessi.getFK_ID_PERMESSO().equals("R") && !read) {
						read = true;
					}
				}
			}
			
		}
		
		userInfoLogin.setPermission(permission);
		userInfoLogin.setRead(read);
		userInfoLogin.setWrite(write);

		return userInfoLogin;

	}

}