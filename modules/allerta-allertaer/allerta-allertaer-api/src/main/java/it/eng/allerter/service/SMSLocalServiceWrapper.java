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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SMSLocalService}.
 *
 * @author GFAVINI
 * @see SMSLocalService
 * @generated
 */
@ProviderType
public class SMSLocalServiceWrapper
	implements SMSLocalService, ServiceWrapper<SMSLocalService> {

	public SMSLocalServiceWrapper(SMSLocalService smsLocalService) {
		_smsLocalService = smsLocalService;
	}

	/**
	 * Adds the sms to the database. Also notifies the appropriate model listeners.
	 *
	 * @param sms the sms
	 * @return the sms that was added
	 */
	@Override
	public it.eng.allerter.model.SMS addSMS(it.eng.allerter.model.SMS sms) {
		return _smsLocalService.addSMS(sms);
	}

	@Override
	public void creaEmail(
			String tipo, String sottotipo, long param,
			com.liferay.portal.kernel.model.User u)
		throws Exception {

		_smsLocalService.creaEmail(tipo, sottotipo, param, u);
	}

	@Override
	public void creaEmailGroup(
			String tipo, String sottotipo, long param, long groupId)
		throws Exception {

		_smsLocalService.creaEmailGroup(tipo, sottotipo, param, groupId);
	}

	@Override
	public void creaEmailGroupRole(
			String tipo, String sottotipo, long param, long groupId,
			long roleId)
		throws Exception {

		_smsLocalService.creaEmailGroupRole(
			tipo, sottotipo, param, groupId, roleId);
	}

	@Override
	public void creaEmailOrganization(
			String tipo, String sottotipo, long param, long id)
		throws Exception {

		_smsLocalService.creaEmailOrganization(tipo, sottotipo, param, id);
	}

	@Override
	public int creaNotificaContattoRubrica(
		long[] canale, it.eng.allerte.model.RubricaGruppo rg,
		it.eng.allerte.model.RubricaNominativo rn,
		it.eng.allerte.model.RubricaContatto rc, String from, String testo,
		String tipo, String sottotipo, long param) {

		return _smsLocalService.creaNotificaContattoRubrica(
			canale, rg, rn, rc, from, testo, tipo, sottotipo, param);
	}

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
	@Override
	public int creaNotificaGruppoRubrica(
			long[] canale, String from, String testo, String tipo,
			String sottotipo, long param, long groupOwner, String nomeGruppo,
			boolean ricorsivo, java.util.List<String> sottogruppi)
		throws Exception {

		return _smsLocalService.creaNotificaGruppoRubrica(
			canale, from, testo, tipo, sottotipo, param, groupOwner, nomeGruppo,
			ricorsivo, sottogruppi);
	}

	@Override
	public int creaOnlySMS(
			String from, String testo, String tipo, String sottotipo,
			long param, com.liferay.portal.kernel.model.User u)
		throws Exception {

		return _smsLocalService.creaOnlySMS(
			from, testo, tipo, sottotipo, param, u);
	}

	@Override
	public int creaOnlySMSGroup(
			String from, String testo, String tipo, String sottotipo,
			long param, long groupId)
		throws Exception {

		return _smsLocalService.creaOnlySMSGroup(
			from, testo, tipo, sottotipo, param, groupId);
	}

	@Override
	public int creaOnlySMSGroupRole(
			String from, String testo, String tipo, String sottotipo,
			long param, long groupId, long roleId)
		throws Exception {

		return _smsLocalService.creaOnlySMSGroupRole(
			from, testo, tipo, sottotipo, param, groupId, roleId);
	}

	@Override
	public int creaOnlySMSOrganization(
			String from, String testo, String tipo, String sottotipo,
			long param, long organizationId)
		throws Exception {

		return _smsLocalService.creaOnlySMSOrganization(
			from, testo, tipo, sottotipo, param, organizationId);
	}

	@Override
	public int creaOnlySMSOrganization(
			String from, String testo, String tipo, String sottotipo,
			long param, long organizationId, long roleId,
			java.util.List<String> gerarchiaOrg)
		throws Exception {

		return _smsLocalService.creaOnlySMSOrganization(
			from, testo, tipo, sottotipo, param, organizationId, roleId,
			gerarchiaOrg);
	}

	@Override
	public int creaOnlySMSUserGroup(
			String from, String testo, String tipo, String sottotipo,
			long param, long userGroupId)
		throws Exception {

		return _smsLocalService.creaOnlySMSUserGroup(
			from, testo, tipo, sottotipo, param, userGroupId);
	}

	@Override
	public int creaSMS(
			String from, String testo, String tipo, String sottotipo,
			long param, com.liferay.portal.kernel.model.User u)
		throws Exception {

		return _smsLocalService.creaSMS(from, testo, tipo, sottotipo, param, u);
	}

	@Override
	public it.eng.allerter.model.SMS creaSMS(
			String from, String to, String testo, String tipo, String sottotipo,
			long param, long utente)
		throws Exception {

		return _smsLocalService.creaSMS(
			from, to, testo, tipo, sottotipo, param, utente);
	}

	@Override
	public it.eng.allerter.model.SMS creaSMS(
			String from, String to, String testo, String tipo, String sottotipo,
			long param, long utente, String nomeUtente)
		throws Exception {

		return _smsLocalService.creaSMS(
			from, to, testo, tipo, sottotipo, param, utente, nomeUtente);
	}

	@Override
	public int creaSMSGroup(
			String from, String testo, String tipo, String sottotipo,
			long param, long groupId)
		throws Exception {

		return _smsLocalService.creaSMSGroup(
			from, testo, tipo, sottotipo, param, groupId);
	}

	@Override
	public int creaSMSGroupRole(
			String from, String testo, String tipo, String sottotipo,
			long param, long groupId, long roleId)
		throws Exception {

		return _smsLocalService.creaSMSGroupRole(
			from, testo, tipo, sottotipo, param, groupId, roleId);
	}

	@Override
	public int creaSMSOrganization(
			String from, String testo, String tipo, String sottotipo,
			long param, long organizationId)
		throws Exception {

		return _smsLocalService.creaSMSOrganization(
			from, testo, tipo, sottotipo, param, organizationId);
	}

	@Override
	public int creaSMSOrganization(
			String from, String testo, String tipo, String sottotipo,
			long param, long organizationId, long roleId,
			java.util.List<String> gerarchiaOrg)
		throws Exception {

		return _smsLocalService.creaSMSOrganization(
			from, testo, tipo, sottotipo, param, organizationId, roleId,
			gerarchiaOrg);
	}

	@Override
	public int creaSMSUserGroup(
			String from, String testo, String tipo, String sottotipo,
			long param, long userGroupId)
		throws Exception {

		return _smsLocalService.creaSMSUserGroup(
			from, testo, tipo, sottotipo, param, userGroupId);
	}

	@Override
	public void creaSocketMessaggio(
		String ip, int port, String login, String password, String mittente,
		String dest, String testo) {

		_smsLocalService.creaSocketMessaggio(
			ip, port, login, password, mittente, dest, testo);
	}

	/**
	 * Creates a new sms with the primary key. Does not add the sms to the database.
	 *
	 * @param id the primary key for the new sms
	 * @return the new sms
	 */
	@Override
	public it.eng.allerter.model.SMS createSMS(long id) {
		return _smsLocalService.createSMS(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smsLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the sms with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the sms
	 * @return the sms that was removed
	 * @throws PortalException if a sms with the primary key could not be found
	 */
	@Override
	public it.eng.allerter.model.SMS deleteSMS(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smsLocalService.deleteSMS(id);
	}

	/**
	 * Deletes the sms from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sms the sms
	 * @return the sms that was removed
	 */
	@Override
	public it.eng.allerter.model.SMS deleteSMS(it.eng.allerter.model.SMS sms) {
		return _smsLocalService.deleteSMS(sms);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _smsLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _smsLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _smsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _smsLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _smsLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _smsLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public int eliminaDuplicati(String tipo, String sottotipo, long param) {
		return _smsLocalService.eliminaDuplicati(tipo, sottotipo, param);
	}

	@Override
	public int eliminaDuplicatiEmail(
		String tipo, String sottotipo, long param) {

		return _smsLocalService.eliminaDuplicatiEmail(tipo, sottotipo, param);
	}

	@Override
	public it.eng.allerter.model.SMS fetchSMS(long id) {
		return _smsLocalService.fetchSMS(id);
	}

	@Override
	public java.util.List<it.eng.allerter.model.SMS> findByNumeroDataAck(
			String numero, java.util.Date dataAck)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _smsLocalService.findByNumeroDataAck(numero, dataAck);
	}

	@Override
	public java.util.List<it.eng.allerter.model.SMS> findByTimestamp(
			String numero)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _smsLocalService.findByTimestamp(numero);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _smsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _smsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _smsLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the sms with the primary key.
	 *
	 * @param id the primary key of the sms
	 * @return the sms
	 * @throws PortalException if a sms with the primary key could not be found
	 */
	@Override
	public it.eng.allerter.model.SMS getSMS(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smsLocalService.getSMS(id);
	}

	@Override
	public int getSmsInStato(Long stato) {
		return _smsLocalService.getSmsInStato(stato);
	}

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
	@Override
	public java.util.List<it.eng.allerter.model.SMS> getSMSs(
		int start, int end) {

		return _smsLocalService.getSMSs(start, end);
	}

	/**
	 * Returns the number of smses.
	 *
	 * @return the number of smses
	 */
	@Override
	public int getSMSsCount() {
		return _smsLocalService.getSMSsCount();
	}

	@Override
	public void inviaEmail(
		java.util.List<String> indirizzi, String subject, String text,
		javax.mail.internet.InternetAddress from) {

		_smsLocalService.inviaEmail(indirizzi, subject, text, from);
	}

	@Override
	public void inviaEmail(
		java.util.List<String> indirizzi, String subject, String text,
		javax.mail.internet.InternetAddress from, java.io.File attach,
		String fileName) {

		_smsLocalService.inviaEmail(
			indirizzi, subject, text, from, attach, fileName);
	}

	@Override
	public void inviaEmail(
		java.util.List<String> indirizzi, String subject, String text,
		javax.mail.internet.InternetAddress from,
		java.util.List<java.io.File> attach, java.util.List<String> fileName) {

		_smsLocalService.inviaEmail(
			indirizzi, subject, text, from, attach, fileName);
	}

	@Override
	public void inviaEmail(
			String tipo, String sottotipo, long param, String subject,
			String text, String from)
		throws Exception {

		_smsLocalService.inviaEmail(
			tipo, sottotipo, param, subject, text, from);
	}

	@Override
	public void inviaEmail(
			String tipo, String sottotipo, long param, String subject,
			String text, String from, java.io.File attach, String fileName)
		throws Exception {

		_smsLocalService.inviaEmail(
			tipo, sottotipo, param, subject, text, from, attach, fileName);
	}

	@Override
	public void inviaEmail(
			String tipo, String sottotipo, long param, String subject,
			String text, String from, java.util.List<java.io.File> attach,
			java.util.List<String> fileName)
		throws Exception {

		_smsLocalService.inviaEmail(
			tipo, sottotipo, param, subject, text, from, attach, fileName);
	}

	@Override
	public void inviaListaSMS(java.util.List<Object[]> s) {
		_smsLocalService.inviaListaSMS(s);
	}

	@Override
	public void inviaSMS(Object[] s) {
		_smsLocalService.inviaSMS(s);
	}

	@Override
	public void inviaSMS(String tipo, String sottotipo, long param) {
		_smsLocalService.inviaSMS(tipo, sottotipo, param);
	}

	@Override
	public boolean isNuovaRubricaAttiva() {
		return _smsLocalService.isNuovaRubricaAttiva();
	}

	@Override
	public int marcaMessaggiInTimeout() {
		return _smsLocalService.marcaMessaggiInTimeout();
	}

	@Override
	public java.util.List<Object[]> ottieniPerSpedizione(
		String tipo, String sottotipo, long param, int currentStatus,
		int newStatus, int limit) {

		return _smsLocalService.ottieniPerSpedizione(
			tipo, sottotipo, param, currentStatus, newStatus, limit);
	}

	@Override
	public java.util.List<it.eng.allerter.model.Email> searchEmail(
		String tipo, String sottotipo, String destinatario, String dataInvioDa,
		String dataInvioA, int start, int end) {

		return _smsLocalService.searchEmail(
			tipo, sottotipo, destinatario, dataInvioDa, dataInvioA, start, end);
	}

	@Override
	public java.util.List<it.eng.allerter.model.Email> searchEmail(
		String tipo, String sottotipo, String destinatario, String email,
		String dataInvioDa, String dataInvioA, int start, int end) {

		return _smsLocalService.searchEmail(
			tipo, sottotipo, destinatario, email, dataInvioDa, dataInvioA,
			start, end);
	}

	@Override
	public long searchEmailCount(
		String tipo, String sottotipo, String destinatario, String dataInvioDa,
		String dataInvioA) {

		return _smsLocalService.searchEmailCount(
			tipo, sottotipo, destinatario, dataInvioDa, dataInvioA);
	}

	@Override
	public long searchEmailCount(
		String tipo, String sottotipo, String destinatario, String email,
		String dataInvioDa, String dataInvioA) {

		return _smsLocalService.searchEmailCount(
			tipo, sottotipo, destinatario, email, dataInvioDa, dataInvioA);
	}

	@Override
	public java.util.List<it.eng.allerter.model.SMS> searchSMS(
		String tipo, String sottoTipo, long stato, String numero,
		String destinatario, String dataInvioDa, String dataInvioA, int start,
		int end) {

		return _smsLocalService.searchSMS(
			tipo, sottoTipo, stato, numero, destinatario, dataInvioDa,
			dataInvioA, start, end);
	}

	@Override
	public long searchSMSCount(
		String tipo, String sottoTipo, long stato, String numero,
		String destinatario, String dataInvioDa, String dataInvioA) {

		return _smsLocalService.searchSMSCount(
			tipo, sottoTipo, stato, numero, destinatario, dataInvioDa,
			dataInvioA);
	}

	/**
	 * Updates the sms in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param sms the sms
	 * @return the sms that was updated
	 */
	@Override
	public it.eng.allerter.model.SMS updateSMS(it.eng.allerter.model.SMS sms) {
		return _smsLocalService.updateSMS(sms);
	}

	@Override
	public SMSLocalService getWrappedService() {
		return _smsLocalService;
	}

	@Override
	public void setWrappedService(SMSLocalService smsLocalService) {
		_smsLocalService = smsLocalService;
	}

	private SMSLocalService _smsLocalService;

}