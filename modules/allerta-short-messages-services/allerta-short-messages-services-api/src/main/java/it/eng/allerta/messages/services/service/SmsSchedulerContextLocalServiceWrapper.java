/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link SmsSchedulerContextLocalService}.
 *
 * @author Giorgianni_F
 * @see SmsSchedulerContextLocalService
 * @generated
 */
public class SmsSchedulerContextLocalServiceWrapper
	implements ServiceWrapper<SmsSchedulerContextLocalService>,
			   SmsSchedulerContextLocalService {

	public SmsSchedulerContextLocalServiceWrapper() {
		this(null);
	}

	public SmsSchedulerContextLocalServiceWrapper(
		SmsSchedulerContextLocalService smsSchedulerContextLocalService) {

		_smsSchedulerContextLocalService = smsSchedulerContextLocalService;
	}

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
	@Override
	public it.eng.allerta.messages.services.model.SmsSchedulerContext
		addSmsSchedulerContext(
			it.eng.allerta.messages.services.model.SmsSchedulerContext
				smsSchedulerContext) {

		return _smsSchedulerContextLocalService.addSmsSchedulerContext(
			smsSchedulerContext);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smsSchedulerContextLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new sms scheduler context with the primary key. Does not add the sms scheduler context to the database.
	 *
	 * @param varId the primary key for the new sms scheduler context
	 * @return the new sms scheduler context
	 */
	@Override
	public it.eng.allerta.messages.services.model.SmsSchedulerContext
		createSmsSchedulerContext(String varId) {

		return _smsSchedulerContextLocalService.createSmsSchedulerContext(
			varId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smsSchedulerContextLocalService.deletePersistedModel(
			persistedModel);
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
	@Override
	public it.eng.allerta.messages.services.model.SmsSchedulerContext
		deleteSmsSchedulerContext(
			it.eng.allerta.messages.services.model.SmsSchedulerContext
				smsSchedulerContext) {

		return _smsSchedulerContextLocalService.deleteSmsSchedulerContext(
			smsSchedulerContext);
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
	@Override
	public it.eng.allerta.messages.services.model.SmsSchedulerContext
			deleteSmsSchedulerContext(String varId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smsSchedulerContextLocalService.deleteSmsSchedulerContext(
			varId);
	}

	/**
	 * Spegne l'eventuale scheduler attivo se presente in questo host oppure il relativo watchdog.
	 */
	@Override
	public void doPortalDestroyInExclusiveMode()
		throws com.liferay.portal.kernel.exception.SystemException {

		_smsSchedulerContextLocalService.doPortalDestroyInExclusiveMode();
	}

	/**
	 * Usata nella fase di init della portlet, quindi al suo deploy (può avvenire all'avvio del server oppure al redeploy della portlet).
	 * Se esiste uno scheduler attivo lo spegne e riavvia il tutto in modalità esclusiva, oppure diventa un watchdog.
	 * Se lo scheduler non è attivo avvia lo scheduler sul nodo corrente in modalità esclusiva.
	 */
	@Override
	public void doPortalInitInExclusiveMode(String hostIp, String port)
		throws com.liferay.portal.kernel.exception.SystemException {

		_smsSchedulerContextLocalService.doPortalInitInExclusiveMode(
			hostIp, port);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _smsSchedulerContextLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _smsSchedulerContextLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _smsSchedulerContextLocalService.dynamicQuery();
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

		return _smsSchedulerContextLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _smsSchedulerContextLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _smsSchedulerContextLocalService.dynamicQuery(
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

		return _smsSchedulerContextLocalService.dynamicQueryCount(dynamicQuery);
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

		return _smsSchedulerContextLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.allerta.messages.services.model.SmsSchedulerContext
		fetchSmsSchedulerContext(String varId) {

		return _smsSchedulerContextLocalService.fetchSmsSchedulerContext(varId);
	}

	@Override
	public String[] getEmailList()
		throws com.liferay.portal.kernel.exception.SystemException {

		return _smsSchedulerContextLocalService.getEmailList();
	}

	/**
	 * Ritorna hostip,port della macchina che contiene lo scheduler attualmente attivo.
	 *
	 * @return
	 */
	@Override
	public String getHostIPAndPortOfCurrentScheduler() {
		return _smsSchedulerContextLocalService.
			getHostIPAndPortOfCurrentScheduler();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _smsSchedulerContextLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smsSchedulerContextLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public it.eng.allerter.service.SMSLocalService getSMSLocalService()
		throws InterruptedException {

		return _smsSchedulerContextLocalService.getSMSLocalService();
	}

	/**
	 * Returns the sms scheduler context with the primary key.
	 *
	 * @param varId the primary key of the sms scheduler context
	 * @return the sms scheduler context
	 * @throws PortalException if a sms scheduler context with the primary key could not be found
	 */
	@Override
	public it.eng.allerta.messages.services.model.SmsSchedulerContext
			getSmsSchedulerContext(String varId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smsSchedulerContextLocalService.getSmsSchedulerContext(varId);
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
	@Override
	public java.util.List
		<it.eng.allerta.messages.services.model.SmsSchedulerContext>
			getSmsSchedulerContexts(int start, int end) {

		return _smsSchedulerContextLocalService.getSmsSchedulerContexts(
			start, end);
	}

	/**
	 * Returns the number of sms scheduler contexts.
	 *
	 * @return the number of sms scheduler contexts
	 */
	@Override
	public int getSmsSchedulerContextsCount() {
		return _smsSchedulerContextLocalService.getSmsSchedulerContextsCount();
	}

	/**
	 * Se lo scheduler è morto prova a creare una nuova istanza dello scheduler in modalità esclusiva
	 */
	@Override
	public boolean ifDeadTryToBecomeScheduler(String hostIp, String port)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _smsSchedulerContextLocalService.ifDeadTryToBecomeScheduler(
			hostIp, port);
	}

	@Override
	public boolean isSchedulerInThisHost()
		throws com.liferay.portal.kernel.exception.SystemException {

		return _smsSchedulerContextLocalService.isSchedulerInThisHost();
	}

	@Override
	public boolean isSmsSchedulerDead()
		throws com.liferay.portal.kernel.exception.SystemException {

		return _smsSchedulerContextLocalService.isSmsSchedulerDead();
	}

	@Override
	public boolean isSmsSchedulerDead(
			java.util.concurrent.TimeUnit heartbeatPeriodTimeUnit,
			long heartbeatPeriod, long heartbeatOccurrences)
		throws com.liferay.portal.kernel.exception.SystemException,
			   InterruptedException {

		return _smsSchedulerContextLocalService.isSmsSchedulerDead(
			heartbeatPeriodTimeUnit, heartbeatPeriod, heartbeatOccurrences);
	}

	@Override
	public boolean isSmsWatchdogSuspend()
		throws com.liferay.portal.kernel.exception.SystemException {

		return _smsSchedulerContextLocalService.isSmsWatchdogSuspend();
	}

	@Override
	public void resetSmsSchedulerState(String smsSchedulerStateNewVal)
		throws com.liferay.portal.kernel.exception.SystemException {

		_smsSchedulerContextLocalService.resetSmsSchedulerState(
			smsSchedulerStateNewVal);
	}

	/**
	 * Ripristino di eventuali stati non consistenti degli SMS a causa dello shutdwon del server;
	 * devono essere inviati nuovamente : se rimasti nello stato 2 e 6 non sono mai stati inviati
	 */
	@Override
	public void ripristinaStatiInconsistentiSMS() {
		_smsSchedulerContextLocalService.ripristinaStatiInconsistentiSMS();
	}

	@Override
	public void sendMailWithPlainText(String body) {
		_smsSchedulerContextLocalService.sendMailWithPlainText(body);
	}

	@Override
	public boolean setSmsSchdulerContextInExclusiveMode(
			String querySQL, String varId, String value)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _smsSchedulerContextLocalService.
			setSmsSchdulerContextInExclusiveMode(querySQL, varId, value);
	}

	@Override
	public void updateHeartbeatInstant(long timestamp)
		throws com.liferay.portal.kernel.exception.SystemException {

		_smsSchedulerContextLocalService.updateHeartbeatInstant(timestamp);
	}

	@Override
	public long updateHeartbeatInstantNow()
		throws com.liferay.portal.kernel.exception.SystemException {

		return _smsSchedulerContextLocalService.updateHeartbeatInstantNow();
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
	@Override
	public it.eng.allerta.messages.services.model.SmsSchedulerContext
		updateSmsSchedulerContext(
			it.eng.allerta.messages.services.model.SmsSchedulerContext
				smsSchedulerContext) {

		return _smsSchedulerContextLocalService.updateSmsSchedulerContext(
			smsSchedulerContext);
	}

	@Override
	public it.eng.allerta.messages.services.model.SmsSchedulerContext
			updateSmsSchedulerContextNewTransaction(
				it.eng.allerta.messages.services.model.SmsSchedulerContext
					smsSchedulerContext)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _smsSchedulerContextLocalService.
			updateSmsSchedulerContextNewTransaction(smsSchedulerContext);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _smsSchedulerContextLocalService.getBasePersistence();
	}

	@Override
	public SmsSchedulerContextLocalService getWrappedService() {
		return _smsSchedulerContextLocalService;
	}

	@Override
	public void setWrappedService(
		SmsSchedulerContextLocalService smsSchedulerContextLocalService) {

		_smsSchedulerContextLocalService = smsSchedulerContextLocalService;
	}

	private SmsSchedulerContextLocalService _smsSchedulerContextLocalService;

}