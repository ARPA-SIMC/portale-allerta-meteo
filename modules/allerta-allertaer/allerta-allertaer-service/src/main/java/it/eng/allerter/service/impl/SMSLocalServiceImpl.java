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

package it.eng.allerter.service.impl;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.EmailAddress;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.InternetHeaders;

import it.eng.allerta.configuration.AllertaBaseConfiguration;
import it.eng.allerta.utils.AllertaTracker;
import it.eng.allerte.model.RubricaContatto;
import it.eng.allerte.model.RubricaGruppo;
import it.eng.allerte.model.RubricaNominativo;
import it.eng.allerte.service.RubricaContattoLocalServiceUtil;
import it.eng.allerte.service.RubricaGruppoGruppiLocalServiceUtil;
import it.eng.allerte.service.RubricaGruppoLocalServiceUtil;
import it.eng.allerte.service.RubricaGruppoNominativiLocalServiceUtil;
import it.eng.allerte.service.RubricaNominativoLocalServiceUtil;
import it.eng.allerter.model.AllertaParametro;
import it.eng.allerter.model.Email;
import it.eng.allerter.model.SMS;
import it.eng.allerter.service.SMSLocalServiceUtil;
import it.eng.allerter.service.base.SMSLocalServiceBaseImpl;

/**
 * The implementation of the sms local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.allerter.service.SMSLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author GFAVINI
 * @see SMSLocalServiceBaseImpl
 */
public class SMSLocalServiceImpl extends SMSLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.allerter.service.SMSLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.allerter.service.smsLocalService</code>.
	 */
	
	public static final int CANALE_EMAIL = 1;
	public static final int CANALE_TELEFONO = 2;
	public static final int CANALE_CELLULARE = 3;
	
	public static InternetAddress[] replyTo;

	
	private Log logger = LogFactoryUtil.getLog(SMSLocalServiceImpl.class);

	
	public int getSmsInStato(Long stato){
		int size;
		try {
			DynamicQuery query = 
							DynamicQueryFactoryUtil
								.forClass(SMS.class, getClassLoader())
								.add(
									PropertyFactoryUtil.forName("stato").eq(stato)
								 );
			
			size = SMSLocalServiceUtil.dynamicQuery(query).size();
			
		} catch (SystemException e) {
			size=-1;
			logger.info("Errore nel calcolo degli sms in stato " + stato + e);
		}
		return size;
	}
	
	public List<Email> searchEmail( String tipo,
									String sottotipo,
									String destinatario,
									String dataInvioDa,
									String dataInvioA,
									int start,
									int end) {
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Email.class, "email", getClassLoader());
		
		if (Validator.isNotNull(tipo)) 
			dynamicQuery.add(PropertyFactoryUtil.forName("tipo").eq(tipo));
		
		if (Validator.isNotNull(sottotipo)) 
			dynamicQuery.add(PropertyFactoryUtil.forName("sottotipo").eq(sottotipo));
		
		if (Validator.isNotNull(destinatario)) 
			dynamicQuery.add(PropertyFactoryUtil.forName("nomeDestinatario").eq(destinatario));
		
		if ( Validator.isNotNull(dataInvioDa)) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			try {
				dynamicQuery.add(PropertyFactoryUtil.forName("dataInvio").ge(sdf.parse(dataInvioDa)));
			} catch (ParseException e) {
				logger.error(e);
			}
		}
		
		if ( Validator.isNotNull(dataInvioA)) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			try {
				dynamicQuery.add(PropertyFactoryUtil.forName("dataInvio").le(sdf.parse(dataInvioA)));
			} catch (ParseException e) {
				logger.error(e);
			}
		}
		
		return  SMSLocalServiceUtil.dynamicQuery(dynamicQuery, start, end);
	}
	
	public long searchEmailCount(String tipo,
								 String sottotipo,
								 String destinatario,
								 String dataInvioDa,
								 String dataInvioA) {
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Email.class, "email", getClassLoader());
		
		if (Validator.isNotNull(tipo)) 
			dynamicQuery.add(PropertyFactoryUtil.forName("tipo").eq(tipo));
		
		if (Validator.isNotNull(sottotipo)) 
			dynamicQuery.add(PropertyFactoryUtil.forName("sottotipo").eq(sottotipo));
		
		if (Validator.isNotNull(destinatario)) 
			dynamicQuery.add(PropertyFactoryUtil.forName("nomeDestinatario").eq(destinatario));
		
		if ( Validator.isNotNull(dataInvioDa)) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			try {
				dynamicQuery.add(PropertyFactoryUtil.forName("dataInvio").ge(sdf.parse(dataInvioDa)));
			} catch (ParseException e) {
				logger.error(e);
			}
		}
		
		if ( Validator.isNotNull(dataInvioA)) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			try {
				dynamicQuery.add(PropertyFactoryUtil.forName("dataInvio").le(sdf.parse(dataInvioA)));
			} catch (ParseException e) {
				logger.error(e);
			}
		}
		
		return  SMSLocalServiceUtil.dynamicQueryCount(dynamicQuery);
	}
	
	public List<SMS> searchSMS( 
								String tipo, 
								String sottoTipo, 
								long stato, 
								String numero, 
								String destinatario,
								String dataInvioDa,
								String dataInvioA,
								int start,
								int end) {

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SMS.class, "sms", getClassLoader());
		
		if (Validator.isNotNull(tipo)) 
			dynamicQuery.add(PropertyFactoryUtil.forName("tipo").eq(tipo));
		
		if (Validator.isNotNull(sottoTipo)) 
			dynamicQuery.add(PropertyFactoryUtil.forName("sottotipo").eq(sottoTipo));
		
		if ( Validator.isNotNull(stato) && stato != -1) 
			dynamicQuery.add(PropertyFactoryUtil.forName("stato").eq(stato));
		
		if (Validator.isNotNull(destinatario)) 
			dynamicQuery.add(PropertyFactoryUtil.forName("nomeDestinatario").eq(destinatario));
		
		if (Validator.isNotNull(numero)) 
			dynamicQuery.add(PropertyFactoryUtil.forName("numero").eq(numero));
		
		if ( Validator.isNotNull(dataInvioDa)) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			try {
				dynamicQuery.add(PropertyFactoryUtil.forName("dataInvio").ge(sdf.parse(dataInvioDa)));
			} catch (ParseException e) {
				logger.error(e);
			}
		}
		
		if ( Validator.isNotNull(dataInvioA)) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			try {
				dynamicQuery.add(PropertyFactoryUtil.forName("dataInvio").le(sdf.parse(dataInvioA)));
			} catch (ParseException e) {
				logger.error(e);
			}
		}
		/*
		if ( Validator.isNotNull(numero)) 
			dynamicQuery.add(PropertyFactoryUtil.forName("numero").eq(destinatario));
		
		if ( Validator.isNotNull(dataInvioDa))
			dynamicQuery.add(PropertyFactoryUtil.forName("dataInvio").ge(dataInvioDa));
		
		if ( Validator.isNotNull(dataInvioA))
			dynamicQuery.add(PropertyFactoryUtil.forName("dataInvio").le(dataInvioA));
		*/
		return  SMSLocalServiceUtil.dynamicQuery(dynamicQuery, start, end);
	}
	
	public long searchSMSCount( String tipo, 
								String sottoTipo, 
								long stato, 
								String numero, 
								String destinatario,
								String dataInvioDa,
								String dataInvioA) {

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SMS.class, "sms", getClassLoader());
		
		if (Validator.isNotNull(tipo)) 
			dynamicQuery.add(PropertyFactoryUtil.forName("tipo").eq(tipo));
		
		if (Validator.isNotNull(sottoTipo)) 
			dynamicQuery.add(PropertyFactoryUtil.forName("sottotipo").eq(sottoTipo));
		
		if ( Validator.isNotNull(stato) && stato != -1) 
			dynamicQuery.add(PropertyFactoryUtil.forName("stato").eq(stato));
		
		if (Validator.isNotNull(destinatario)) 
			dynamicQuery.add(PropertyFactoryUtil.forName("nomeDestinatario").eq(destinatario));
		
		if (Validator.isNotNull(numero)) 
			dynamicQuery.add(PropertyFactoryUtil.forName("numero").eq(numero));
		
		if ( Validator.isNotNull(dataInvioDa)) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			try {
				dynamicQuery.add(PropertyFactoryUtil.forName("dataInvio").ge(sdf.parse(dataInvioDa)));
			} catch (ParseException e) {
				logger.error(e);
			}
		}
		
		if ( Validator.isNotNull(dataInvioA)) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			try {
				dynamicQuery.add(PropertyFactoryUtil.forName("dataInvio").le(sdf.parse(dataInvioA)));
			} catch (ParseException e) {
				logger.error(e);
			}
		}
		/*
		if ( Validator.isNotNull(numero)) 
		dynamicQuery.add(PropertyFactoryUtil.forName("numero").eq(destinatario));
		
		if ( Validator.isNotNull(dataInvioDa))
		dynamicQuery.add(PropertyFactoryUtil.forName("dataInvio").ge(dataInvioDa));
		
		if ( Validator.isNotNull(dataInvioA))
		dynamicQuery.add(PropertyFactoryUtil.forName("dataInvio").le(dataInvioA));
		*/
		return  SMSLocalServiceUtil.dynamicQueryCount(dynamicQuery);
	
	}

	
	public boolean isNuovaRubricaAttiva() {
		return true;
	}

	
	public SMS creaSMS(String from, String to, String testo, String tipo, String sottotipo, long param, long utente)
			throws Exception {

		long id = counterLocalService.increment(SMS.class.getName());

		SMS s = this.createSMS(id);
		s.setDestinatario(utente);
		s.setNumero(to);
		s.setParam(param);
		s.setSottotipo(sottotipo);
		s.setStato(0);
		s.setTesto(testo);
		s.setTipo(tipo);
		s.setNumeroDa(from);
		s.setNomeDestinatario(null);
		s.setDataInvio(new Date());
		s.setTentativi(0);

		smsLocalService.updateSMS(s);

		return s;
	}

	public SMS creaSMS(String from, String to, String testo, String tipo, String sottotipo, long param, long utente,
			String nomeUtente) throws Exception {

		long id = counterLocalService.increment(SMS.class.getName());

		SMS s = this.createSMS(id);
		s.setDestinatario(utente);
		s.setNumero(to);
		s.setParam(param);
		s.setSottotipo(sottotipo);
		s.setStato(0);
		s.setTesto(testo);
		s.setTipo(tipo);
		s.setNumeroDa(from);
		s.setNomeDestinatario(nomeUtente != null ? nomeUtente.toLowerCase() : nomeUtente);
		s.setDataInvio(new Date());

		smsLocalService.updateSMS(s);

		return s;
	}

	public void creaEmail(String tipo, String sottotipo, long param, User u) throws Exception {

		if (u.getEmailAddress() != null) {
			long id = counterLocalService.increment(Email.class.getName());
			Email e = emailLocalService.createEmail(id);

			e.setDestinatario(u.getUserId());
			e.setIndirizzo(u.getEmailAddress().toLowerCase());
			e.setNomeDestinatario(u.getFullName().toLowerCase());
			e.setParam(param);
			e.setSottotipo(sottotipo);
			e.setStato(0);
			e.setTipo(tipo);
			e.setDataInvio(new Date());

			emailLocalService.updateEmail(e);
		}

		//logger.info("TROVATE " + u.getEmailAddresses().size() + " EMAIL AGGIUNTIVE PER " + u.getFullName());

		for (EmailAddress ea : u.getEmailAddresses()) {
			
			if (ea==null) continue;
			
			long id = counterLocalService.increment(Email.class.getName());
			Email e = emailLocalService.createEmail(id);

			e.setDestinatario(u.getUserId());
			e.setIndirizzo(ea.getAddress().toLowerCase());
			e.setNomeDestinatario(u.getFullName().toLowerCase());
			e.setParam(param);
			e.setSottotipo(sottotipo);
			e.setStato(0);
			e.setTipo(tipo);
			e.setDataInvio(new Date());

			emailLocalService.updateEmail(e);
		}

	}

	public int creaSMS(String from, String testo, String tipo, String sottotipo, long param, User u) throws Exception {

		int created = 0;

		for (Phone p : u.getPhones()) {

			creaSMS(from, p.getNumber(), testo, tipo, sottotipo, param, u.getUserId(), u.getFullName());
			created++;

		}

		// giï¿½ che ci siamo creiamo anche le mail!
		creaEmail(tipo, sottotipo, param, u);

		return created;
	}
	
	public int creaOnlySMS(String from, String testo, String tipo, String sottotipo, long param, User u) throws Exception {

		int created = 0;

		for (Phone p : u.getPhones()) {

			creaSMS(from, p.getNumber(), testo, tipo, sottotipo, param, u.getUserId(), u.getFullName());
			created++;

		}

		return created;
	}

	public int creaSMSUserGroup(String from, String testo, String tipo, String sottotipo, long param, long userGroupId)
			throws Exception {

		int created = 0;

		logger.info("creaSMSUserGroup " + userGroupId);

		for (User p : userLocalService.getUserGroupUsers(userGroupId)) {

			created += creaSMS(from, testo, tipo, sottotipo, param, p);

		}

		return created;
	}
	
	public int creaOnlySMSUserGroup(String from, String testo, String tipo, String sottotipo, long param, long userGroupId)
			throws Exception {

		int created = 0;

		logger.info("creaSMSUserGroup " + userGroupId);

		for (User p : userLocalService.getUserGroupUsers(userGroupId)) {

			created += creaOnlySMS(from, testo, tipo, sottotipo, param, p);

		}

		return created;
	}
	
	public int creaNotificaContattoRubrica(long canale[], RubricaGruppo rg, 
			RubricaNominativo rn, RubricaContatto rc, String from, String testo, String tipo, String sottotipo, long param) {
				
		int spedite = 0;
		
		if (!rc.getALLERTAMENTO()) return 0;
		
		boolean avanti = false;
		if (canale==null) avanti=true;
		else {
			for (long l : canale) if (l==rc.getFK_CANALE()) avanti=true;
		}
		
		if (!avanti) return 0;
			
		switch ((int)rc.getFK_CANALE()) {
			case CANALE_CELLULARE:
			case CANALE_TELEFONO:
				String to = rc.getCONTATTO();
				try {
				String nomeutente = rg.getNOME()+" - "+rn.getCOGNOME()+" "+rn.getNOME();
				creaSMS(from, to, testo, tipo, sottotipo, param, rg.getID_GRUPPO(),
						nomeutente);
				spedite++;
				} catch (Exception e) {
					logger.error(e);
					//logInternoLocalService.log("smsLocalService", "creaNotificaContattoRubrica", e, "");
					
				}
				break;
				
			case CANALE_EMAIL:
				
				try {
					long id = counterLocalService.increment(Email.class.getName());
					Email e = emailLocalService.createEmail(id);
	
					e.setDestinatario(rn.getID_NOMINATIVO());
					e.setIndirizzo(rc.getCONTATTO());
					e.setNomeDestinatario(rg.getNOME()+" - "+ rn.getNOME()+" "+rn.getCOGNOME());
					e.setParam(param);
					e.setSottotipo(sottotipo);
					e.setStato(0);
					e.setTipo(tipo);
					e.setDataInvio(new Date());
	
					emailLocalService.updateEmail(e);
					spedite++;
				} catch (Exception e) {
					logger.error(e);
					//logInternoLocalService.log("SMSLocalServiceUtil", "creaNotificaContattoRubrica", e, "");
					
				}
				break;
			}
		
		
		return spedite;
	}
	
	/**
	 * 
	 * @param canale - elenco dei canali sui quali creare la notifica, o NULL per indicare tutti i canali
	 * @param from - il numero o id di provenienza della notifica
	 * @param testo - il testo della notifica
	 * @param tipo - il tipo della notifica (primo elemento della gerarchia tipo/sottotipo/param)
	 * @param sottotipo il sottotipo della notifica (secondo elemento della gerarchia tipo/sottotipo/param)
	 * @param param - il parametro della notifica (terzo elemento della gerarchia tipo/sottotipo/param. questo è un numero che può funzionare da chiave esterna)
	 * @param groupOwner - l'id del proprietario della rubrica in cui cercare il gruppo
	 * @param nomeGruppo - il nome del gruppo da invocare
	 * @param ricorsivo - se true, l'invio è ricorsivo, cioè tutti i path non specificati nel parametro successivo ricevono la notifica
	 * @param sottogruppi - una mappa String che dice a quali sottogruppi (indicati con notazione "path/con/wildcard->TRUE" con wildcard e supporto per regex) mandare la notifica; si guarda
	 * il booleano del primo path che fa match; per quelli che non fanno match con nessun path indicato qui, si usa il parametro "ricorsivo"
	 * @return il numero di notifiche create. NOTA: questo metodo NON spedisce le notifiche, le crea solo.
	 * @throws Exception
	 */
	public int creaNotificaGruppoRubrica(long[] canale, String from, String testo, String tipo, String sottotipo, long param, long groupOwner, String nomeGruppo, boolean ricorsivo, List<String> sottogruppi)
			throws Exception {
		int created = 0;
		
		Object[] gruppi = RubricaGruppoLocalServiceUtil.getGruppiByOwnerAndName(groupOwner, nomeGruppo);
		ArrayList<String> nuoviSottogruppi = new ArrayList<String>();
		
		if (gruppi==null || gruppi.length==0) return 0;
		RubricaGruppo rg = RubricaGruppoLocalServiceUtil.fetchRubricaGruppo((Long)gruppi[0]);
		ArrayList al = RubricaGruppoGruppiLocalServiceUtil.getGruppiFigli(rg.getID_GRUPPO());
		for (Object o: al) {
			Object[] ret = (Object[])o;
			long l = Long.parseLong(ret[1].toString());
			RubricaGruppo rg2 = RubricaGruppoLocalServiceUtil.fetchRubricaGruppo(l);
			
			//confronta il gruppo con i path specificati
			Boolean includi = null;
			if (sottogruppi!=null)
				for (String regola: sottogruppi) {
					String[] div = regola.split("->");
					String path = div[0].trim();
					Boolean azione = new Boolean(div[1].trim().toLowerCase());
					
					//wildcard:
					// ? vale per un livello di annidamento
					// * vale per tutti i livelli di annidamento
					if (path.startsWith("*") || path.startsWith("?") || (path.startsWith(rg2.getNOME()) && !path.contains("/"))) {
						includi = azione;
						break;
					}
					if (path.startsWith("@")) {
						//Regex
						String regex = path.substring(1,path.indexOf('@', 1));
						if (rg2.getNOME().matches(regex)) {
							includi = azione;
							break;
						}
					}
				}
			
			//se non fai match, usa il valore di default
			if (includi==null) includi = ricorsivo;
			
			if (includi) {
				
				//filtra e togli il primo pezzo da tutti i path dei sottogruppi quando passi al livello inferiore. L'unica eccezione
				//è la wildcard *, che vale da questo livello in poi.
				nuoviSottogruppi.clear();
				if (sottogruppi!=null)
					for (String s : sottogruppi) {
						if (s.contains("/")) {
							//se non conteneva un carattere "/" vuol dire che si riferiva solo al primo livello e non dobbiamo portarcela dietro
							String s2 = s.substring(0, s.indexOf('/'));
							if (s2.equals("*") || s2.startsWith("@") ||  s2.equals(rg2.getNOME())) {
								//togli il primo pezzo e manda in ricorsione
								nuoviSottogruppi.add(s.substring(s.indexOf('/')+1));
							}
						} else if (s.startsWith("*")) nuoviSottogruppi.add(s);
					}
				
				
				created+=creaNotificaGruppoRubrica(canale,from,testo,tipo,sottotipo,param,rg2.getFK_SITO_PROPRIETARIO(),rg2.getNOME(),ricorsivo,nuoviSottogruppi);

			}
		}
		

			List<Object[]> nominativi = RubricaGruppoNominativiLocalServiceUtil.loadNominativiGruppo(rg.getID_GRUPPO(), rg.getFK_SITO_PROPRIETARIO());
			for (Object[] n : nominativi) {
				RubricaNominativo rn = RubricaNominativoLocalServiceUtil.fetchRubricaNominativo((Long)n[1]);
				List<Object[]> contatti = RubricaContattoLocalServiceUtil.loadByNominativo(rn.getID_NOMINATIVO());
				for (Object[] c : contatti) {
					RubricaContatto rc = RubricaContattoLocalServiceUtil.fetchRubricaContatto((Long)c[0]);
					created += creaNotificaContattoRubrica(canale,rg,rn,rc,from,testo,tipo,sottotipo,param);
				}
			}
		
		
		
		return created;
	}
	
	public int creaSMSGroup(String from, String testo, String tipo, String sottotipo, long param, long groupId)
			throws Exception {

		int created = 0;

		logger.info("creaSMSGroup " + groupId);

		for (User p : userLocalService.getGroupUsers(groupId)) {

			created += creaSMS(from, testo, tipo, sottotipo, param, p);

		}

		return created;
	}
	
	public int creaOnlySMSGroup(String from, String testo, String tipo, String sottotipo, long param, long groupId)
			throws Exception {

		int created = 0;

		logger.info("creaSMSGroup " + groupId);

		for (User p : userLocalService.getGroupUsers(groupId)) {

			created += creaOnlySMS(from, testo, tipo, sottotipo, param, p);

		}

		return created;
	}
	
	public void creaEmailGroup(String tipo, String sottotipo, long param, long groupId)
			throws Exception {

		logInternoLocalService.log("creaEmailGroup", ""+tipo+","+groupId, "", "");

		for (User p : userLocalService.getGroupUsers(groupId)) {

			creaEmail(tipo, sottotipo, param, p);

		}

		return;
	}
	
	public void creaEmailOrganization(String tipo, String sottotipo, long param, long id)
			throws Exception {

		logInternoLocalService.log("creaEmailOrganization", ""+tipo+","+id, "", "");

		for (User p : userLocalService.getOrganizationUsers(id)) {

			creaEmail(tipo, sottotipo, param, p);

		}

		return;
	}
	
	public void creaEmailGroupRole(String tipo, String sottotipo, long param, long groupId,
			long roleId) throws Exception {

		logInternoLocalService.log("creaEmailGroupRole", ""+tipo+","+groupId, "", "");
		
		for (UserGroupRole p : UserGroupRoleLocalServiceUtil.getUserGroupRolesByGroupAndRole(groupId, roleId)) {

			creaEmail(tipo, sottotipo, param, p.getUser());

		}

		return;
	}

	public int creaSMSGroupRole(String from, String testo, String tipo, String sottotipo, long param, long groupId,
			long roleId) throws Exception {

		int created = 0;

		logger.info("creaSMSGroupRole " + groupId + " " + roleId);

		for (UserGroupRole p : UserGroupRoleLocalServiceUtil.getUserGroupRolesByGroupAndRole(groupId, roleId)) {

			created += creaSMS(from, testo, tipo, sottotipo, param, p.getUser());

		}

		return created;
	}
	
	public int creaOnlySMSGroupRole(String from, String testo, String tipo, String sottotipo, long param, long groupId,
			long roleId) throws Exception {

		int created = 0;

		logger.info("creaSMSGroupRole " + groupId + " " + roleId);

		for (UserGroupRole p : UserGroupRoleLocalServiceUtil.getUserGroupRolesByGroupAndRole(groupId, roleId)) {

			created += creaOnlySMS(from, testo, tipo, sottotipo, param, p.getUser());

		}

		return created;
	}

	public int creaSMSOrganization(String from, String testo, String tipo, String sottotipo, long param,
			long organizationId, long roleId, List<String> gerarchiaOrg) throws Exception {

		int created = 0;
		Organization o = null;

		try {

			logger.info("creaSMSOrganization " + organizationId);

			for (Group g : GroupLocalServiceUtil.getOrganizationGroups(organizationId)) {

				if (roleId != 0)
					created += creaSMSGroup(from, testo, tipo, sottotipo, param, g.getGroupId());
				else
					created += creaSMSGroupRole(from, testo, tipo, sottotipo, param, g.getGroupId(), roleId);
			}

			for (User g : userLocalService.getOrganizationUsers(organizationId)) {

				created += creaSMS(from, testo, tipo, sottotipo, param, g);
			}

			o = OrganizationLocalServiceUtil.getOrganization(organizationId);

			for (Organization sub : OrganizationLocalServiceUtil.getSuborganizations(o.getCompanyId(),
					organizationId)) {
				String name = sub.getName();
				if (gerarchiaOrg != null && gerarchiaOrg.size() > 0) {
					// visita tutte le sotto-organizzazioni i cui nomi sono
					// nella lista
					for (String s : gerarchiaOrg) {
						if (name.equals(s))
							created += creaSMSOrganization(from, testo, tipo, sottotipo, param, sub.getOrganizationId(),
									roleId, gerarchiaOrg);

					}

				}
				// se gerarchia ï¿½ vuota visitale tutte
				if (gerarchiaOrg == null || gerarchiaOrg.size() == 0)
					created += creaSMSOrganization(from, testo, tipo, sottotipo, param, sub.getOrganizationId(), roleId,
							gerarchiaOrg);

			}

			logInternoLocalService.log("creaSMSOrganization", o.getName(), "created " + created, null);

			return created;

		} catch (Exception e) {
			logInternoLocalService.log("creaSMSOrganization", (o != null ? o.getName() : "" + organizationId), e,
					null);
			return 0;
		}

	}
	
	
	
	public int creaOnlySMSOrganization(String from, String testo, String tipo, String sottotipo, long param,
			long organizationId, long roleId, List<String> gerarchiaOrg) throws Exception {

		int created = 0;
		Organization o = null;

		try {

			logger.info("creaSMSOrganization " + organizationId);

			for (Group g : GroupLocalServiceUtil.getOrganizationGroups(organizationId)) {

				if (roleId != 0)
					created += creaOnlySMSGroup(from, testo, tipo, sottotipo, param, g.getGroupId());
				else
					created += creaOnlySMSGroupRole(from, testo, tipo, sottotipo, param, g.getGroupId(), roleId);
			}

			for (User g : userLocalService.getOrganizationUsers(organizationId)) {

				created += creaOnlySMS(from, testo, tipo, sottotipo, param, g);
			}

			o = OrganizationLocalServiceUtil.getOrganization(organizationId);

			for (Organization sub : OrganizationLocalServiceUtil.getSuborganizations(o.getCompanyId(),
					organizationId)) {
				String name = sub.getName();
				if (gerarchiaOrg != null && gerarchiaOrg.size() > 0) {
					// visita tutte le sotto-organizzazioni i cui nomi sono
					// nella lista
					for (String s : gerarchiaOrg) {
						if (name.equals(s))
							created += creaOnlySMSOrganization(from, testo, tipo, sottotipo, param, sub.getOrganizationId(),
									roleId, gerarchiaOrg);

					}

				}
				// se gerarchia ï¿½ vuota visitale tutte
				if (gerarchiaOrg == null || gerarchiaOrg.size() == 0)
					created += creaOnlySMSOrganization(from, testo, tipo, sottotipo, param, sub.getOrganizationId(), roleId,
							gerarchiaOrg);

			}

			logInternoLocalService.log("creaSMSOrganization", o.getName(), "created " + created, null);

			return created;

		} catch (Exception e) {
			logInternoLocalService.log("creaSMSOrganization", (o != null ? o.getName() : "" + organizationId), e,
					null);
			return 0;
		}

	}

	public int creaSMSOrganization(String from, String testo, String tipo, String sottotipo, long param,
			long organizationId) throws Exception {
		return creaSMSOrganization(from, testo, tipo, sottotipo, param, organizationId, 0, null);
	}
	
	
	public int creaOnlySMSOrganization(String from, String testo, String tipo, String sottotipo, long param,
			long organizationId) throws Exception {
		return creaOnlySMSOrganization(from, testo, tipo, sottotipo, param, organizationId, 0, null);
	}

	public int eliminaDuplicati(String tipo, String sottotipo, long param) {

		return smsFinder.eliminaDuplicati(tipo, sottotipo, param);

	}

	public int eliminaDuplicatiEmail(String tipo, String sottotipo, long param) {

		return smsFinder.eliminaDuplicatiEmail(tipo, sottotipo, param);

	}

	public void inviaSMS(Object[] s) {

	}

	public void inviaListaSMS(List<Object[]> s) {
		if (s == null || s.size() == 0)
			return;
		
		logger.info("Invio " + s.size() + " SMS...");

		// for (Object[] ss : s)
		// inviaSMS(ss);
	}

	public void inviaSMS(String tipo, String sottotipo, long param) {

		//QUESTO CONTROLLO E' PASSATO AL THREAD DI INVIO
		/*AllertaBaseConfiguration configuration = AllertaTracker.getAllertaBaseConfiguration();
		if (configuration.disableSms()) {
			
			logger.info("SMS NON INVIATO");
			return;
		}*/
		
		
		eliminaDuplicati(tipo, sottotipo, param);
		List l = smsFinder.ottieniPerSpedizione(tipo, sottotipo, param);
		if (l!=null && l.size()>0) logInternoLocalService.log("sms","Creazione SMS","Tipo "+tipo+", sottotipo "+sottotipo+": "+l.size()+" SMS creati","");

	}

	public void inviaEmail(List<String> indirizzi, String subject, String text, InternetAddress from) {

		inviaEmail(indirizzi,subject,text,from,(File)null,(String)null);

	}
	
	public void inviaEmail(List<String> indirizzi, String subject, String text, InternetAddress from, File attach, String fileName) {

		AllertaBaseConfiguration configuration = AllertaTracker.getAllertaBaseConfiguration();
		
		try {
			if (configuration.enableTestMode()) {
				indirizzi = new ArrayList<String>();
			}
			if (Validator.isNotNull(configuration.mailTest()))
				indirizzi.add(configuration.mailTest());
			
			if (indirizzi == null || indirizzi.size() == 0)
				return;

			logger.info("Invio " + indirizzi.size() + " email...");
			

			InternetAddress[] ind = new InternetAddress[indirizzi.size()];

			for (int k = 0; k < ind.length; k++)
				ind[k] = new InternetAddress(indirizzi.get(k));

			MailMessage mailMessage = new MailMessage();
			mailMessage.setBCC(ind);
			mailMessage.setFrom(from);
			
			if (replyTo==null) {
				InternetAddress r = new InternetAddress("AllertaMeteoER@regione.emilia-romagna.it");
				replyTo = new InternetAddress[] { r };
			}
			
			mailMessage.setReplyTo(replyTo);
			mailMessage.setSubject(subject);
			mailMessage.setBody(text);
			mailMessage.setHTMLFormat(true);
			if (attach!=null) mailMessage.addFileAttachment(attach, fileName);
			mailMessage.setHTMLFormat(true);
			
			InternetHeaders ih = mailMessage.getInternetHeaders();
			String notificheInvio = AllertaTracker.getAllertaEmailConfiguration().indirizzoNotificheInvio();
			if (notificheInvio!=null || !"".equals(notificheInvio))
				ih.setHeader("Return-Receipt-To", notificheInvio);
			
			String notificheLettura = AllertaTracker.getAllertaEmailConfiguration().indirizzoNotificheLettura();
			if (notificheLettura!=null && !notificheLettura.equals("")) {
				ih.setHeader("Disposition-Notification-To",notificheLettura);
			}
			
			MailServiceUtil.sendEmail(mailMessage);

		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("inviaEmail", "inviaEmail", e, "");
		}

	}
	
	public void inviaEmail(List<String> indirizzi, String subject, String text, InternetAddress from, List<File> attach, List<String> fileName) {

		AllertaBaseConfiguration configuration = AllertaTracker.getAllertaBaseConfiguration();
		
		try {
			
			if (configuration.enableTestMode()) {
				indirizzi = new ArrayList<String>();
			}
			if (Validator.isNotNull(configuration.mailTest()))
				indirizzi.add(configuration.mailTest());
			
			if (indirizzi == null || indirizzi.size() == 0)
				return;

			logger.info("Invio " + indirizzi.size() + " email...");

			InternetAddress[] ind = new InternetAddress[indirizzi.size()];

			for (int k = 0; k < ind.length; k++)
				ind[k] = new InternetAddress(indirizzi.get(k));

			MailMessage mailMessage = new MailMessage();
			mailMessage.setBCC(ind);
			mailMessage.setFrom(from);
			
			if (replyTo==null) {
				InternetAddress r = new InternetAddress("AllertaMeteoER@regione.emilia-romagna.it");
				replyTo = new InternetAddress[] { r };
			}
			mailMessage.setReplyTo(replyTo);
			mailMessage.setSubject(subject);
			mailMessage.setBody(text);
			mailMessage.setHTMLFormat(true);

			if (attach!=null) {
				for (int k=0; k<attach.size(); k++)
					mailMessage.addFileAttachment(attach.get(k), fileName.get(k));
			}
			mailMessage.setHTMLFormat(true);
			MailServiceUtil.sendEmail(mailMessage);
			
			//logInternoLocalService.log("inviaEmail", "successo", "", "");

		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("inviaEmail", "inviaEmail", e, "");
		}

	}

	public void inviaEmail(String tipo, String sottotipo, long param, String subject, String text, String from)
			throws Exception {
		eliminaDuplicatiEmail(tipo, sottotipo, param);
		List<String> l = smsFinder.ottieniEmailPerSpedizione(tipo, sottotipo, param, text, subject);
		if (l==null) return;
		inviaEmail(l, subject, text,
				creaMittenteEmail(from,tipo));
		if (l.size()>0) logInternoLocalService.log("email","Invio email","Tipo "+tipo+", sottotipo "+sottotipo+", "+l.size()+" email create","");

	}
	
	public void inviaEmail(String tipo, String sottotipo, long param, String subject, String text, String from, File attach, String fileName)
			throws Exception {
		eliminaDuplicatiEmail(tipo, sottotipo, param);
		List<String> l = smsFinder.ottieniEmailPerSpedizione(tipo, sottotipo, param, text, subject);
		if (l==null) return;
		inviaEmail(l, subject, text,
				creaMittenteEmail(from,tipo),attach,fileName);
		
		if (l.size()>0) logInternoLocalService.log("email","Invio email con allegato","Tipo "+tipo+", sottotipo "+sottotipo+", "+l.size()+" email create","");


	}
	
	
	public void inviaEmail(String tipo, String sottotipo, long param, String subject, String text, String from, List<File> attach, List<String> fileName)
			throws Exception {
		eliminaDuplicatiEmail(tipo, sottotipo, param);
		List<String> l = smsFinder.ottieniEmailPerSpedizione(tipo, sottotipo, param, text, subject);
		if (l==null) return;
		inviaEmail(l, subject, text,
				creaMittenteEmail(from,tipo),attach,fileName);
		
		if (l.size()>0) logInternoLocalService.log("email","Invio email con allegati","Tipo "+tipo+", sottotipo "+sottotipo+", "+l.size()+" email create","");


	}

	public void creaSocketMessaggio(String ip, int port, String login, String password, String mittente, String dest,
			String testo) {

		
	}

	
	private InternetAddress creaMittenteEmail(String indirizzo, String tipo) {
		
		try {
			
			if (tipo==null || indirizzo==null) return null;
			
			AllertaParametro ap = allertaParametroLocalService.fetchAllertaParametro("MITTENTE_EMAIL_"+tipo.toUpperCase());
			if (ap==null) return new InternetAddress(indirizzo);
			
			return new InternetAddress(indirizzo,ap.getValore());
			
		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("SMSLocalServiceImpl", "creaMittenteEmail", e, "");
			return null;
		}
		
	}

	public List<Object[]> ottieniPerSpedizione(String tipo, String sottotipo, long param, int currentStatus,
			int newStatus, int limit) {
		return smsFinder.ottieniPerSpedizione(tipo, sottotipo, param, currentStatus, newStatus, limit);
	}
	
	public int marcaMessaggiInTimeout() {
		return smsFinder.marcaMessaggiInTimeout(); 
	}

	public List<SMS> findByNumeroDataAck(String numero, Date dataAck) throws SystemException {
		return smsPersistence.findByNumeroDataAck(numero, dataAck);
	}
	
	public List<SMS> findByTimestamp(String numero) throws SystemException {
		return smsPersistence.findByTimestamp(numero);
	}

}