/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.allerter.model.SMS;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SMS. This utility wraps
 * <code>it.eng.allerter.service.impl.SMSLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author GFAVINI
 * @see SMSLocalService
 * @generated
 */
public class SMSLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.allerter.service.impl.SMSLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the sms to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SMSLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sms the sms
	 * @return the sms that was added
	 */
	public static SMS addSMS(SMS sms) {
		return getService().addSMS(sms);
	}

	public static void creaEmail(
			String tipo, String sottotipo, long param,
			com.liferay.portal.kernel.model.User u)
		throws Exception {

		getService().creaEmail(tipo, sottotipo, param, u);
	}

	public static void creaEmailGroup(
			String tipo, String sottotipo, long param, long groupId)
		throws Exception {

		getService().creaEmailGroup(tipo, sottotipo, param, groupId);
	}

	public static void creaEmailGroupRole(
			String tipo, String sottotipo, long param, long groupId,
			long roleId)
		throws Exception {

		getService().creaEmailGroupRole(
			tipo, sottotipo, param, groupId, roleId);
	}

	public static void creaEmailOrganization(
			String tipo, String sottotipo, long param, long id)
		throws Exception {

		getService().creaEmailOrganization(tipo, sottotipo, param, id);
	}

	public static int creaNotificaContattoRubrica(
		long[] canale, it.eng.allerte.model.RubricaGruppo rg,
		it.eng.allerte.model.RubricaNominativo rn,
		it.eng.allerte.model.RubricaContatto rc, String from, String testo,
		String tipo, String sottotipo, long param) {

		return getService().creaNotificaContattoRubrica(
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
	 gerarchia tipo/sottotipo/param. questo è un numero che può
	 funzionare da chiave esterna)
	 * @param groupOwner  - l'id del proprietario della rubrica in cui cercare il
	 gruppo
	 * @param nomeGruppo  - il nome del gruppo da invocare
	 * @param ricorsivo   - se true, l'invio è ricorsivo, cioè tutti i path non
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
	public static int creaNotificaGruppoRubrica(
			long[] canale, String from, String testo, String tipo,
			String sottotipo, long param, long groupOwner, String nomeGruppo,
			boolean ricorsivo, List<String> sottogruppi)
		throws Exception {

		return getService().creaNotificaGruppoRubrica(
			canale, from, testo, tipo, sottotipo, param, groupOwner, nomeGruppo,
			ricorsivo, sottogruppi);
	}

	public static int creaOnlySMS(
			String from, String testo, String tipo, String sottotipo,
			long param, com.liferay.portal.kernel.model.User u)
		throws Exception {

		return getService().creaOnlySMS(from, testo, tipo, sottotipo, param, u);
	}

	public static int creaOnlySMSGroup(
			String from, String testo, String tipo, String sottotipo,
			long param, long groupId)
		throws Exception {

		return getService().creaOnlySMSGroup(
			from, testo, tipo, sottotipo, param, groupId);
	}

	public static int creaOnlySMSGroupRole(
			String from, String testo, String tipo, String sottotipo,
			long param, long groupId, long roleId)
		throws Exception {

		return getService().creaOnlySMSGroupRole(
			from, testo, tipo, sottotipo, param, groupId, roleId);
	}

	public static int creaOnlySMSOrganization(
			String from, String testo, String tipo, String sottotipo,
			long param, long organizationId)
		throws Exception {

		return getService().creaOnlySMSOrganization(
			from, testo, tipo, sottotipo, param, organizationId);
	}

	public static int creaOnlySMSOrganization(
			String from, String testo, String tipo, String sottotipo,
			long param, long organizationId, long roleId,
			List<String> gerarchiaOrg)
		throws Exception {

		return getService().creaOnlySMSOrganization(
			from, testo, tipo, sottotipo, param, organizationId, roleId,
			gerarchiaOrg);
	}

	public static int creaOnlySMSUserGroup(
			String from, String testo, String tipo, String sottotipo,
			long param, long userGroupId)
		throws Exception {

		return getService().creaOnlySMSUserGroup(
			from, testo, tipo, sottotipo, param, userGroupId);
	}

	public static int creaSMS(
			String from, String testo, String tipo, String sottotipo,
			long param, com.liferay.portal.kernel.model.User u)
		throws Exception {

		return getService().creaSMS(from, testo, tipo, sottotipo, param, u);
	}

	public static SMS creaSMS(
			String from, String to, String testo, String tipo, String sottotipo,
			long param, long utente)
		throws Exception {

		return getService().creaSMS(
			from, to, testo, tipo, sottotipo, param, utente);
	}

	public static SMS creaSMS(
			String from, String to, String testo, String tipo, String sottotipo,
			long param, long utente, String nomeUtente)
		throws Exception {

		return getService().creaSMS(
			from, to, testo, tipo, sottotipo, param, utente, nomeUtente);
	}

	public static int creaSMSGroup(
			String from, String testo, String tipo, String sottotipo,
			long param, long groupId)
		throws Exception {

		return getService().creaSMSGroup(
			from, testo, tipo, sottotipo, param, groupId);
	}

	public static int creaSMSGroupRole(
			String from, String testo, String tipo, String sottotipo,
			long param, long groupId, long roleId)
		throws Exception {

		return getService().creaSMSGroupRole(
			from, testo, tipo, sottotipo, param, groupId, roleId);
	}

	public static int creaSMSOrganization(
			String from, String testo, String tipo, String sottotipo,
			long param, long organizationId)
		throws Exception {

		return getService().creaSMSOrganization(
			from, testo, tipo, sottotipo, param, organizationId);
	}

	public static int creaSMSOrganization(
			String from, String testo, String tipo, String sottotipo,
			long param, long organizationId, long roleId,
			List<String> gerarchiaOrg)
		throws Exception {

		return getService().creaSMSOrganization(
			from, testo, tipo, sottotipo, param, organizationId, roleId,
			gerarchiaOrg);
	}

	public static int creaSMSUserGroup(
			String from, String testo, String tipo, String sottotipo,
			long param, long userGroupId)
		throws Exception {

		return getService().creaSMSUserGroup(
			from, testo, tipo, sottotipo, param, userGroupId);
	}

	public static void creaSocketMessaggio(
		String ip, int port, String login, String password, String mittente,
		String dest, String testo) {

		getService().creaSocketMessaggio(
			ip, port, login, password, mittente, dest, testo);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new sms with the primary key. Does not add the sms to the database.
	 *
	 * @param id the primary key for the new sms
	 * @return the new sms
	 */
	public static SMS createSMS(long id) {
		return getService().createSMS(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the sms with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SMSLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the sms
	 * @return the sms that was removed
	 * @throws PortalException if a sms with the primary key could not be found
	 */
	public static SMS deleteSMS(long id) throws PortalException {
		return getService().deleteSMS(id);
	}

	/**
	 * Deletes the sms from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SMSLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sms the sms
	 * @return the sms that was removed
	 */
	public static SMS deleteSMS(SMS sms) {
		return getService().deleteSMS(sms);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.SMSModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.SMSModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static int eliminaDuplicati(
		String tipo, String sottotipo, long param) {

		return getService().eliminaDuplicati(tipo, sottotipo, param);
	}

	public static int eliminaDuplicatiEmail(
		String tipo, String sottotipo, long param) {

		return getService().eliminaDuplicatiEmail(tipo, sottotipo, param);
	}

	public static SMS fetchSMS(long id) {
		return getService().fetchSMS(id);
	}

	public static List<SMS> findByNumeroDataAck(
			String numero, java.util.Date dataAck)
		throws SystemException {

		return getService().findByNumeroDataAck(numero, dataAck);
	}

	public static List<SMS> findByTimestamp(String numero)
		throws SystemException {

		return getService().findByTimestamp(numero);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the sms with the primary key.
	 *
	 * @param id the primary key of the sms
	 * @return the sms
	 * @throws PortalException if a sms with the primary key could not be found
	 */
	public static SMS getSMS(long id) throws PortalException {
		return getService().getSMS(id);
	}

	public static int getSmsInStato(Long stato) {
		return getService().getSmsInStato(stato);
	}

	/**
	 * Returns a range of all the smses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.SMSModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smses
	 * @param end the upper bound of the range of smses (not inclusive)
	 * @return the range of smses
	 */
	public static List<SMS> getSMSs(int start, int end) {
		return getService().getSMSs(start, end);
	}

	/**
	 * Returns the number of smses.
	 *
	 * @return the number of smses
	 */
	public static int getSMSsCount() {
		return getService().getSMSsCount();
	}

	public static void inviaEmail(
		List<String> indirizzi, String subject, String text,
		javax.mail.internet.InternetAddress from) {

		getService().inviaEmail(indirizzi, subject, text, from);
	}

	public static void inviaEmail(
		List<String> indirizzi, String subject, String text,
		javax.mail.internet.InternetAddress from, java.io.File attach,
		String fileName) {

		getService().inviaEmail(
			indirizzi, subject, text, from, attach, fileName);
	}

	public static void inviaEmail(
		List<String> indirizzi, String subject, String text,
		javax.mail.internet.InternetAddress from, List<java.io.File> attach,
		List<String> fileName) {

		getService().inviaEmail(
			indirizzi, subject, text, from, attach, fileName);
	}

	public static void inviaEmail(
			String tipo, String sottotipo, long param, String subject,
			String text, String from)
		throws Exception {

		getService().inviaEmail(tipo, sottotipo, param, subject, text, from);
	}

	public static void inviaEmail(
			String tipo, String sottotipo, long param, String subject,
			String text, String from, java.io.File attach, String fileName)
		throws Exception {

		getService().inviaEmail(
			tipo, sottotipo, param, subject, text, from, attach, fileName);
	}

	public static void inviaEmail(
			String tipo, String sottotipo, long param, String subject,
			String text, String from, List<java.io.File> attach,
			List<String> fileName)
		throws Exception {

		getService().inviaEmail(
			tipo, sottotipo, param, subject, text, from, attach, fileName);
	}

	public static void inviaListaSMS(List<Object[]> s) {
		getService().inviaListaSMS(s);
	}

	public static void inviaSMS(Object[] s) {
		getService().inviaSMS(s);
	}

	public static void inviaSMS(String tipo, String sottotipo, long param) {
		getService().inviaSMS(tipo, sottotipo, param);
	}

	public static boolean isNuovaRubricaAttiva() {
		return getService().isNuovaRubricaAttiva();
	}

	public static int marcaMessaggiInTimeout() {
		return getService().marcaMessaggiInTimeout();
	}

	public static List<Object[]> ottieniPerSpedizione(
		String tipo, String sottotipo, long param, int currentStatus,
		int newStatus, int limit) {

		return getService().ottieniPerSpedizione(
			tipo, sottotipo, param, currentStatus, newStatus, limit);
	}

	public static List<it.eng.allerter.model.Email> searchEmail(
		String tipo, String sottotipo, String destinatario, String dataInvioDa,
		String dataInvioA, int start, int end) {

		return getService().searchEmail(
			tipo, sottotipo, destinatario, dataInvioDa, dataInvioA, start, end);
	}

	public static List<it.eng.allerter.model.Email> searchEmail(
		String tipo, String sottotipo, String destinatario, String email,
		String dataInvioDa, String dataInvioA, int start, int end) {

		return getService().searchEmail(
			tipo, sottotipo, destinatario, email, dataInvioDa, dataInvioA,
			start, end);
	}

	public static long searchEmailCount(
		String tipo, String sottotipo, String destinatario, String dataInvioDa,
		String dataInvioA) {

		return getService().searchEmailCount(
			tipo, sottotipo, destinatario, dataInvioDa, dataInvioA);
	}

	public static long searchEmailCount(
		String tipo, String sottotipo, String destinatario, String email,
		String dataInvioDa, String dataInvioA) {

		return getService().searchEmailCount(
			tipo, sottotipo, destinatario, email, dataInvioDa, dataInvioA);
	}

	public static List<SMS> searchSMS(
		String tipo, String sottoTipo, long stato, String numero,
		String destinatario, String dataInvioDa, String dataInvioA, int start,
		int end) {

		return getService().searchSMS(
			tipo, sottoTipo, stato, numero, destinatario, dataInvioDa,
			dataInvioA, start, end);
	}

	public static long searchSMSCount(
		String tipo, String sottoTipo, long stato, String numero,
		String destinatario, String dataInvioDa, String dataInvioA) {

		return getService().searchSMSCount(
			tipo, sottoTipo, stato, numero, destinatario, dataInvioDa,
			dataInvioA);
	}

	/**
	 * Updates the sms in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SMSLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sms the sms
	 * @return the sms that was updated
	 */
	public static SMS updateSMS(SMS sms) {
		return getService().updateSMS(sms);
	}

	public static SMSLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<SMSLocalService> _serviceSnapshot =
		new Snapshot<>(SMSLocalServiceUtil.class, SMSLocalService.class);

}