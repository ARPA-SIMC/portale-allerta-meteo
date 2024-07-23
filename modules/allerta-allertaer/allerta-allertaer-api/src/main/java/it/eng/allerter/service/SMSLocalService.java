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

package it.eng.allerter.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.allerte.model.RubricaContatto;
import it.eng.allerte.model.RubricaGruppo;
import it.eng.allerte.model.RubricaNominativo;
import it.eng.allerter.model.Email;
import it.eng.allerter.model.SMS;

import java.io.File;
import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.mail.internet.InternetAddress;

/**
 * Provides the local service interface for SMS. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author GFAVINI
 * @see SMSLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface SMSLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SMSLocalServiceUtil} to access the sms local service. Add custom service methods to <code>it.eng.allerter.service.impl.SMSLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the sms to the database. Also notifies the appropriate model listeners.
	 *
	 * @param sms the sms
	 * @return the sms that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SMS addSMS(SMS sms);

	public void creaEmail(String tipo, String sottotipo, long param, User u)
		throws Exception;

	public void creaEmailGroup(
			String tipo, String sottotipo, long param, long groupId)
		throws Exception;

	public void creaEmailGroupRole(
			String tipo, String sottotipo, long param, long groupId,
			long roleId)
		throws Exception;

	public void creaEmailOrganization(
			String tipo, String sottotipo, long param, long id)
		throws Exception;

	public int creaNotificaContattoRubrica(
		long[] canale, RubricaGruppo rg, RubricaNominativo rn,
		RubricaContatto rc, String from, String testo, String tipo,
		String sottotipo, long param);

	/**
	 * @param canale      - elenco dei canali sui quali creare la notifica, o NULL
	 per indicare tutti i canali
	 * @param from        - il numero o id di provenienza della notifica
	 * @param testo       - il testo della notifica
	 * @param tipo        - il tipo della notifica (primo elemento della gerarchia
	 tipo/sottotipo/param)
	 * @param sottotipo   il sottotipo della notifica (secondo elemento della
	 gerarchia tipo/sottotipo/param)
	 * @param param       - il parametro della notifica (terzo elemento della
	 gerarchia tipo/sottotipo/param. questo � un numero che pu�
	 funzionare da chiave esterna)
	 * @param groupOwner  - l'id del proprietario della rubrica in cui cercare il
	 gruppo
	 * @param nomeGruppo  - il nome del gruppo da invocare
	 * @param ricorsivo   - se true, l'invio � ricorsivo, cio� tutti i path non
	 specificati nel parametro successivo ricevono la notifica
	 * @param sottogruppi - una mappa String che dice a quali sottogruppi (indicati
	 con notazione "path/con/wildcard->TRUE" con wildcard e
	 supporto per regex) mandare la notifica; si guarda il
	 booleano del primo path che fa match; per quelli che non
	 fanno match con nessun path indicato qui, si usa il
	 parametro "ricorsivo"
	 * @return il numero di notifiche create. NOTA: questo metodo NON spedisce le
	 notifiche, le crea solo.
	 * @throws Exception
	 */
	public int creaNotificaGruppoRubrica(
			long[] canale, String from, String testo, String tipo,
			String sottotipo, long param, long groupOwner, String nomeGruppo,
			boolean ricorsivo, List<String> sottogruppi)
		throws Exception;

	public int creaOnlySMS(
			String from, String testo, String tipo, String sottotipo,
			long param, User u)
		throws Exception;

	public int creaOnlySMSGroup(
			String from, String testo, String tipo, String sottotipo,
			long param, long groupId)
		throws Exception;

	public int creaOnlySMSGroupRole(
			String from, String testo, String tipo, String sottotipo,
			long param, long groupId, long roleId)
		throws Exception;

	public int creaOnlySMSOrganization(
			String from, String testo, String tipo, String sottotipo,
			long param, long organizationId)
		throws Exception;

	public int creaOnlySMSOrganization(
			String from, String testo, String tipo, String sottotipo,
			long param, long organizationId, long roleId,
			List<String> gerarchiaOrg)
		throws Exception;

	public int creaOnlySMSUserGroup(
			String from, String testo, String tipo, String sottotipo,
			long param, long userGroupId)
		throws Exception;

	public int creaSMS(
			String from, String testo, String tipo, String sottotipo,
			long param, User u)
		throws Exception;

	public SMS creaSMS(
			String from, String to, String testo, String tipo, String sottotipo,
			long param, long utente)
		throws Exception;

	public SMS creaSMS(
			String from, String to, String testo, String tipo, String sottotipo,
			long param, long utente, String nomeUtente)
		throws Exception;

	public int creaSMSGroup(
			String from, String testo, String tipo, String sottotipo,
			long param, long groupId)
		throws Exception;

	public int creaSMSGroupRole(
			String from, String testo, String tipo, String sottotipo,
			long param, long groupId, long roleId)
		throws Exception;

	public int creaSMSOrganization(
			String from, String testo, String tipo, String sottotipo,
			long param, long organizationId)
		throws Exception;

	public int creaSMSOrganization(
			String from, String testo, String tipo, String sottotipo,
			long param, long organizationId, long roleId,
			List<String> gerarchiaOrg)
		throws Exception;

	public int creaSMSUserGroup(
			String from, String testo, String tipo, String sottotipo,
			long param, long userGroupId)
		throws Exception;

	public void creaSocketMessaggio(
		String ip, int port, String login, String password, String mittente,
		String dest, String testo);

	/**
	 * Creates a new sms with the primary key. Does not add the sms to the database.
	 *
	 * @param id the primary key for the new sms
	 * @return the new sms
	 */
	@Transactional(enabled = false)
	public SMS createSMS(long id);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the sms with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the sms
	 * @return the sms that was removed
	 * @throws PortalException if a sms with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public SMS deleteSMS(long id) throws PortalException;

	/**
	 * Deletes the sms from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sms the sms
	 * @return the sms that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public SMS deleteSMS(SMS sms);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	public int eliminaDuplicati(String tipo, String sottotipo, long param);

	public int eliminaDuplicatiEmail(String tipo, String sottotipo, long param);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SMS fetchSMS(long id);

	public List<SMS> findByNumeroDataAck(String numero, Date dataAck)
		throws SystemException;

	public List<SMS> findByTimestamp(String numero) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Returns the sms with the primary key.
	 *
	 * @param id the primary key of the sms
	 * @return the sms
	 * @throws PortalException if a sms with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SMS getSMS(long id) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSmsInStato(Long stato);

	/**
	 * Returns a range of all the smses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.SMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @return the range of smses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SMS> getSMSs(int start, int end);

	/**
	 * Returns the number of smses.
	 *
	 * @return the number of smses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSMSsCount();

	public void inviaEmail(
		List<String> indirizzi, String subject, String text,
		InternetAddress from);

	public void inviaEmail(
		List<String> indirizzi, String subject, String text,
		InternetAddress from, File attach, String fileName);

	public void inviaEmail(
		List<String> indirizzi, String subject, String text,
		InternetAddress from, List<File> attach, List<String> fileName);

	public void inviaEmail(
			String tipo, String sottotipo, long param, String subject,
			String text, String from)
		throws Exception;

	public void inviaEmail(
			String tipo, String sottotipo, long param, String subject,
			String text, String from, File attach, String fileName)
		throws Exception;

	public void inviaEmail(
			String tipo, String sottotipo, long param, String subject,
			String text, String from, List<File> attach, List<String> fileName)
		throws Exception;

	public void inviaListaSMS(List<Object[]> s);

	public void inviaSMS(Object[] s);

	public void inviaSMS(String tipo, String sottotipo, long param);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isNuovaRubricaAttiva();

	public int marcaMessaggiInTimeout();

	public List<Object[]> ottieniPerSpedizione(
		String tipo, String sottotipo, long param, int currentStatus,
		int newStatus, int limit);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Email> searchEmail(
		String tipo, String sottotipo, String destinatario, String dataInvioDa,
		String dataInvioA, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Email> searchEmail(
		String tipo, String sottotipo, String destinatario, String email,
		String dataInvioDa, String dataInvioA, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long searchEmailCount(
		String tipo, String sottotipo, String destinatario, String dataInvioDa,
		String dataInvioA);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long searchEmailCount(
		String tipo, String sottotipo, String destinatario, String email,
		String dataInvioDa, String dataInvioA);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SMS> searchSMS(
		String tipo, String sottoTipo, long stato, String numero,
		String destinatario, String dataInvioDa, String dataInvioA, int start,
		int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long searchSMSCount(
		String tipo, String sottoTipo, long stato, String numero,
		String destinatario, String dataInvioDa, String dataInvioA);

	/**
	 * Updates the sms in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param sms the sms
	 * @return the sms that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SMS updateSMS(SMS sms);

}