package it.eng.allerte.custom.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import it.eng.allerte.custom.jsonRubrica.Contact;
import it.eng.allerte.custom.jsonRubrica.ContactRequest;
import it.eng.allerte.custom.jsonRubrica.GroupAssociationRequest;
import it.eng.allerte.custom.jsonRubrica.GroupCreateRequest;
import it.eng.allerte.custom.jsonRubrica.NominativeCreateRequest;
import it.eng.allerte.custom.jsonRubrica.NominativeUpdateRequest;
import it.eng.allerte.exception.NoSuchRubricaGruppoException;
import it.eng.allerte.model.RubricaGruppo;
import it.eng.allerte.service.persistence.RubricaGruppoUtil;


public class RubricaJsonValidation {
	
	private Log _log = LogFactoryUtil.getLog(RubricaJsonValidation.class);

	
	//VALIDAZIONE DATI INPUT creazione nominativo
	public List<String> validateNominative(NominativeCreateRequest nominative) {
		
		List<String> errValid = new ArrayList<>();
		
		if(! Validator.isNotNull(nominative.getFirstName())) {
			errValid.add("nome non valorizzato");
			
		}
		
		if(! Validator.isNotNull(nominative.getLastName())) {
			errValid.add("cognome non valorizzato");
		}
				
		return errValid;
		
	}
	
	//Validazione dati update nominativo
	public List<String> validateNominative(NominativeUpdateRequest nominative) {
		
		List<String> errValid = new ArrayList<>();
		
		if(! Validator.isNotNull(nominative.getFirstName())) {
			errValid.add("nome non valorizzato");
			
		}
		
		if(! Validator.isNotNull(nominative.getLastName())) {
			errValid.add("cognome non valorizzato");
		}
				
		return errValid;
	}
	/**
	 * 
	 * @param contacts
	 * @return
	 */
	public List<String> validateContact(List<Contact> contacts) {

		List<String> errValid = new ArrayList<>();
		
		boolean hasError = false;
		
		if(null != contacts && !contacts.isEmpty()) {
			
			for(Contact contatto : contacts) {
				
				//Valida valore contatto
				if(! Validator.isNotNull(contatto.getValue())) {
					errValid.add("sono presenti contatti non valorizzati");
					hasError = true;
				} 
				else if (null!= contatto.getChannelId() && contatto.getChannelId().longValue() == 1) { //caso email verifica formato corretto
					
					Pattern p = Pattern.compile("[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}");
					Matcher m = p.matcher(contatto.getValue());
					
					if(! m.matches()) {
						errValid.add("sono presenti formati mail non validi");
						hasError = true;
					}
				}
				//Valida identificativo canale deve essere sempre presente
				if(null == (contatto.getChannelId())) {
					errValid.add("identificativo canale assente");
					hasError = true;
				}
				
				if(hasError) {
					break;
				}
			}
		}
		
		return errValid;
		
	}
	
	/**
	 * 
	 * @param contact
	 * @return
	 */
	public List<String> validaContactRequest(ContactRequest contact) {

		List<String> errValid = new ArrayList<>();
		
		if(!Validator.isNotNull(contact.getValue())) {
			errValid.add("contatto non valorizzato");
		}
		else if (null != contact.getChannelId() && contact.getChannelId().longValue() == 1) { //caso mail
			
			Pattern p = Pattern.compile("[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}");
			Matcher m = p.matcher(contact.getValue());
			
			if(! m.matches()) {
				errValid.add("formato mail non valido");
			}
		}
		if(null == contact.getChannelId()){
			errValid.add("identificativo canale assente");
		}
		if(null == contact.getNominativeId()) {
			errValid.add("identificativo nominativo assente");
		}
		
		return errValid;
		
	}
	
	/**
	 * 
	 * @param group
	 * @param ownerId 
	 * @return
	 */
	public List<String> validateGroupCreateRequest(GroupCreateRequest group, long ownerId) {
		
		List<String> errValid = new ArrayList<>();
		
		if(! Validator.isNotNull(group.getName())) {
			errValid.add("Nome non valorizzato");
		}
		
		//verifica se il gruppo che sto creando è già presente per lo stesso proprietario
		RubricaGruppo gruppo = null;
		try {
			gruppo = RubricaGruppoUtil.findByRubricaGruppoForOwnerAndName(ownerId, group.getName().trim(), false);
			if(null != gruppo) {
				//Gruppo già presente, segnala errore
				errValid.add("Il gruppo: " + group.getName() + " è già presente in rubrica");
			}
		} catch (NoSuchRubricaGruppoException e) {
			//Se non trovo nulla vuol dire che non esiste quindi lo posso creare
			_log.info("Gruppo non presente. Continua la creazione" );
		} catch (SystemException e) {
			_log.error("Errore in validazione gruppo", e);
		}
		
		
//		if(null == group.getOwnerId()) {
//			errValid.add("identificativo gruppo proprietario assente");
//		}
		
		return errValid;
	}

	public List<String> validateGroup(List<GroupAssociationRequest> groups) {
		
		List<String> errValid = new ArrayList<>();
		boolean hasError = false;
		
		if(null != groups && !groups.isEmpty()) {
			
			for(GroupAssociationRequest gruppo : groups) {
				
				//Identificativo gruppo nono deve essere null
				if(null == gruppo.getId()) {
					errValid.add("identificativo gruppo assente");
					hasError = true;
				}
				if(null == gruppo.getRoleId()) {
					errValid.add("identificativo ruolo assente");
					hasError = true;
				}
				
				if(hasError) {
					break;
				}
			}
		}
		return errValid;
	}
	
}
