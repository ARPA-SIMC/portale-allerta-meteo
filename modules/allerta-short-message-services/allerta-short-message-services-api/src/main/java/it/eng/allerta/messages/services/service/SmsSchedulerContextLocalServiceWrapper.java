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

package it.eng.allerta.messages.services.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SmsSchedulerContextLocalService}.
 *
 * @author Giorgianni_F
 * @see SmsSchedulerContextLocalService
 * @generated
 */
@ProviderType
public class SmsSchedulerContextLocalServiceWrapper
	implements SmsSchedulerContextLocalService,
			   ServiceWrapper<SmsSchedulerContextLocalService> {

	public SmsSchedulerContextLocalServiceWrapper(
		SmsSchedulerContextLocalService smsSchedulerContextLocalService) {

		_smsSchedulerContextLocalService = smsSchedulerContextLocalService;
	}

	/**
	 * Adds the sms scheduler context to the database. Also notifies the appropriate model listeners.
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

	/*
	@Override
	public String callMethodFromServlet(String methodName) {
		return _smsSchedulerContextLocalService.callMethodFromServlet(
			methodName);
	}
	*/

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

	@Override
	public void doPortalDestroyInExclusiveMode()
		throws com.liferay.portal.kernel.exception.SystemException {

		_smsSchedulerContextLocalService.doPortalDestroyInExclusiveMode();
	}

	@Override
	public void doPortalInitInExclusiveMode(String hostIp, String port)
		throws com.liferay.portal.kernel.exception.SystemException {

		_smsSchedulerContextLocalService.doPortalInitInExclusiveMode(hostIp, port);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerta.messages.services.model.impl.SmsSchedulerContextModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerta.messages.services.model.impl.SmsSchedulerContextModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smsSchedulerContextLocalService.getPersistedModel(
			primaryKeyObj);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerta.messages.services.model.impl.SmsSchedulerContextModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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