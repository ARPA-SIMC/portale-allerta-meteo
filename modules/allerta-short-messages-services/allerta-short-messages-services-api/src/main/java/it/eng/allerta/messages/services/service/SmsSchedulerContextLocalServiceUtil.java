/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.allerta.messages.services.model.SmsSchedulerContext;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SmsSchedulerContext. This utility wraps
 * <code>it.eng.allerta.messages.services.service.impl.SmsSchedulerContextLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Giorgianni_F
 * @see SmsSchedulerContextLocalService
 * @generated
 */
public class SmsSchedulerContextLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.allerta.messages.services.service.impl.SmsSchedulerContextLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the sms scheduler context to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmsSchedulerContextLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smsSchedulerContext the sms scheduler context
	 * @return the sms scheduler context that was added
	 */
	public static SmsSchedulerContext addSmsSchedulerContext(
		SmsSchedulerContext smsSchedulerContext) {

		return getService().addSmsSchedulerContext(smsSchedulerContext);
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
	 * Creates a new sms scheduler context with the primary key. Does not add the sms scheduler context to the database.
	 *
	 * @param varId the primary key for the new sms scheduler context
	 * @return the new sms scheduler context
	 */
	public static SmsSchedulerContext createSmsSchedulerContext(String varId) {
		return getService().createSmsSchedulerContext(varId);
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
	 * Deletes the sms scheduler context from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmsSchedulerContextLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smsSchedulerContext the sms scheduler context
	 * @return the sms scheduler context that was removed
	 */
	public static SmsSchedulerContext deleteSmsSchedulerContext(
		SmsSchedulerContext smsSchedulerContext) {

		return getService().deleteSmsSchedulerContext(smsSchedulerContext);
	}

	/**
	 * Deletes the sms scheduler context with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmsSchedulerContextLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param varId the primary key of the sms scheduler context
	 * @return the sms scheduler context that was removed
	 * @throws PortalException if a sms scheduler context with the primary key could not be found
	 */
	public static SmsSchedulerContext deleteSmsSchedulerContext(String varId)
		throws PortalException {

		return getService().deleteSmsSchedulerContext(varId);
	}

	/**
	 * Spegne l'eventuale scheduler attivo se presente in questo host oppure il relativo watchdog.
	 */
	public static void doPortalDestroyInExclusiveMode() throws SystemException {
		getService().doPortalDestroyInExclusiveMode();
	}

	/**
	 * Usata nella fase di init della portlet, quindi al suo deploy (può avvenire all'avvio del server oppure al redeploy della portlet).
	 * Se esiste uno scheduler attivo lo spegne e riavvia il tutto in modalità esclusiva, oppure diventa un watchdog.
	 * Se lo scheduler non è attivo avvia lo scheduler sul nodo corrente in modalità esclusiva.
	 */
	public static void doPortalInitInExclusiveMode(String hostIp, String port)
		throws SystemException {

		getService().doPortalInitInExclusiveMode(hostIp, port);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerta.messages.services.model.impl.SmsSchedulerContextModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerta.messages.services.model.impl.SmsSchedulerContextModelImpl</code>.
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

	public static SmsSchedulerContext fetchSmsSchedulerContext(String varId) {
		return getService().fetchSmsSchedulerContext(varId);
	}

	public static String[] getEmailList() throws SystemException {
		return getService().getEmailList();
	}

	/**
	 * Ritorna hostip,port della macchina che contiene lo scheduler attualmente attivo.
	 *
	 * @return
	 */
	public static String getHostIPAndPortOfCurrentScheduler() {
		return getService().getHostIPAndPortOfCurrentScheduler();
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

	public static it.eng.allerter.service.SMSLocalService getSMSLocalService()
		throws InterruptedException {

		return getService().getSMSLocalService();
	}

	/**
	 * Returns the sms scheduler context with the primary key.
	 *
	 * @param varId the primary key of the sms scheduler context
	 * @return the sms scheduler context
	 * @throws PortalException if a sms scheduler context with the primary key could not be found
	 */
	public static SmsSchedulerContext getSmsSchedulerContext(String varId)
		throws PortalException {

		return getService().getSmsSchedulerContext(varId);
	}

	/**
	 * Returns a range of all the sms scheduler contexts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerta.messages.services.model.impl.SmsSchedulerContextModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sms scheduler contexts
	 * @param end the upper bound of the range of sms scheduler contexts (not inclusive)
	 * @return the range of sms scheduler contexts
	 */
	public static List<SmsSchedulerContext> getSmsSchedulerContexts(
		int start, int end) {

		return getService().getSmsSchedulerContexts(start, end);
	}

	/**
	 * Returns the number of sms scheduler contexts.
	 *
	 * @return the number of sms scheduler contexts
	 */
	public static int getSmsSchedulerContextsCount() {
		return getService().getSmsSchedulerContextsCount();
	}

	/**
	 * Se lo scheduler è morto prova a creare una nuova istanza dello scheduler in modalità esclusiva
	 */
	public static boolean ifDeadTryToBecomeScheduler(String hostIp, String port)
		throws SystemException {

		return getService().ifDeadTryToBecomeScheduler(hostIp, port);
	}

	public static boolean isSchedulerInThisHost() throws SystemException {
		return getService().isSchedulerInThisHost();
	}

	public static boolean isSmsSchedulerDead() throws SystemException {
		return getService().isSmsSchedulerDead();
	}

	public static boolean isSmsSchedulerDead(
			java.util.concurrent.TimeUnit heartbeatPeriodTimeUnit,
			long heartbeatPeriod, long heartbeatOccurrences)
		throws InterruptedException, SystemException {

		return getService().isSmsSchedulerDead(
			heartbeatPeriodTimeUnit, heartbeatPeriod, heartbeatOccurrences);
	}

	public static boolean isSmsWatchdogSuspend() throws SystemException {
		return getService().isSmsWatchdogSuspend();
	}

	public static void resetSmsSchedulerState(String smsSchedulerStateNewVal)
		throws SystemException {

		getService().resetSmsSchedulerState(smsSchedulerStateNewVal);
	}

	/**
	 * Ripristino di eventuali stati non consistenti degli SMS a causa dello shutdwon del server;
	 * devono essere inviati nuovamente : se rimasti nello stato 2 e 6 non sono mai stati inviati
	 */
	public static void ripristinaStatiInconsistentiSMS() {
		getService().ripristinaStatiInconsistentiSMS();
	}

	public static void sendMailWithPlainText(String body) {
		getService().sendMailWithPlainText(body);
	}

	public static boolean setSmsSchdulerContextInExclusiveMode(
			String querySQL, String varId, String value)
		throws SystemException {

		return getService().setSmsSchdulerContextInExclusiveMode(
			querySQL, varId, value);
	}

	public static void updateHeartbeatInstant(long timestamp)
		throws SystemException {

		getService().updateHeartbeatInstant(timestamp);
	}

	public static long updateHeartbeatInstantNow() throws SystemException {
		return getService().updateHeartbeatInstantNow();
	}

	/**
	 * Updates the sms scheduler context in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmsSchedulerContextLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smsSchedulerContext the sms scheduler context
	 * @return the sms scheduler context that was updated
	 */
	public static SmsSchedulerContext updateSmsSchedulerContext(
		SmsSchedulerContext smsSchedulerContext) {

		return getService().updateSmsSchedulerContext(smsSchedulerContext);
	}

	public static SmsSchedulerContext updateSmsSchedulerContextNewTransaction(
			SmsSchedulerContext smsSchedulerContext)
		throws SystemException {

		return getService().updateSmsSchedulerContextNewTransaction(
			smsSchedulerContext);
	}

	public static SmsSchedulerContextLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<SmsSchedulerContextLocalService>
		_serviceSnapshot = new Snapshot<>(
			SmsSchedulerContextLocalServiceUtil.class,
			SmsSchedulerContextLocalService.class);

}