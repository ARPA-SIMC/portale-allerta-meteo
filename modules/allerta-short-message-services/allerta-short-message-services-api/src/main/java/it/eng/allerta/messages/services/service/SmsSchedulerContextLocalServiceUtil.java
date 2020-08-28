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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

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
@ProviderType
public class SmsSchedulerContextLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.allerta.messages.services.service.impl.SmsSchedulerContextLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the sms scheduler context to the database. Also notifies the appropriate model listeners.
	 *
	 * @param smsSchedulerContext the sms scheduler context
	 * @return the sms scheduler context that was added
	 */
	public static it.eng.allerta.messages.services.model.SmsSchedulerContext
		addSmsSchedulerContext(
			it.eng.allerta.messages.services.model.SmsSchedulerContext
				smsSchedulerContext) {

		return getService().addSmsSchedulerContext(smsSchedulerContext);
	}

	/*
	public static String callMethodFromServlet(String methodName) {
		return getService().callMethodFromServlet(methodName);
	}
	*/

	/**
	 * Creates a new sms scheduler context with the primary key. Does not add the sms scheduler context to the database.
	 *
	 * @param varId the primary key for the new sms scheduler context
	 * @return the new sms scheduler context
	 */
	public static it.eng.allerta.messages.services.model.SmsSchedulerContext
		createSmsSchedulerContext(String varId) {

		return getService().createSmsSchedulerContext(varId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the sms scheduler context from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smsSchedulerContext the sms scheduler context
	 * @return the sms scheduler context that was removed
	 */
	public static it.eng.allerta.messages.services.model.SmsSchedulerContext
		deleteSmsSchedulerContext(
			it.eng.allerta.messages.services.model.SmsSchedulerContext
				smsSchedulerContext) {

		return getService().deleteSmsSchedulerContext(smsSchedulerContext);
	}

	/**
	 * Deletes the sms scheduler context with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param varId the primary key of the sms scheduler context
	 * @return the sms scheduler context that was removed
	 * @throws PortalException if a sms scheduler context with the primary key could not be found
	 */
	public static it.eng.allerta.messages.services.model.SmsSchedulerContext
			deleteSmsSchedulerContext(String varId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteSmsSchedulerContext(varId);
	}

	public static void doPortalDestroyInExclusiveMode()
		throws com.liferay.portal.kernel.exception.SystemException {

		getService().doPortalDestroyInExclusiveMode();
	}

	public static void doPortalInitInExclusiveMode(String hostIp, String port)
		throws com.liferay.portal.kernel.exception.SystemException {

		getService().doPortalInitInExclusiveMode(hostIp, port);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

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
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static it.eng.allerta.messages.services.model.SmsSchedulerContext
		fetchSmsSchedulerContext(String varId) {

		return getService().fetchSmsSchedulerContext(varId);
	}

	/*
	public static String[] getEmailList()
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getEmailList();
	}
	*/

	/*
	public static String getHostIPAndPortOfCurrentScheduler() {
		return getService().getHostIPAndPortOfCurrentScheduler();
	}
	*/

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the sms scheduler context with the primary key.
	 *
	 * @param varId the primary key of the sms scheduler context
	 * @return the sms scheduler context
	 * @throws PortalException if a sms scheduler context with the primary key could not be found
	 */
	public static it.eng.allerta.messages.services.model.SmsSchedulerContext
			getSmsSchedulerContext(String varId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getSmsSchedulerContext(varId);
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
	public static java.util.List
		<it.eng.allerta.messages.services.model.SmsSchedulerContext>
			getSmsSchedulerContexts(int start, int end) {

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

	public static boolean ifDeadTryToBecomeScheduler(String hostIp, String port)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().ifDeadTryToBecomeScheduler(hostIp, port);
	}

	/*
	public static boolean isSchedulerInThisHost()
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().isSchedulerInThisHost();
	}
	*/

	/*
	public static boolean isSmsSchedulerDead()
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().isSmsSchedulerDead();
	}
	*/

	/*
	public static boolean isSmsSchedulerDead(
			java.util.concurrent.TimeUnit heartbeatPeriodTimeUnit,
			long heartbeatPeriod, long heartbeatOccurrences)
		throws com.liferay.portal.kernel.exception.SystemException,
			   InterruptedException {

		return getService().isSmsSchedulerDead(
			heartbeatPeriodTimeUnit, heartbeatPeriod, heartbeatOccurrences);
	}
	*/

	/*
	public static boolean isSmsWatchdogSuspend()
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().isSmsWatchdogSuspend();
	}
	*/

	public static void resetSmsSchedulerState(String smsSchedulerStateNewVal)
		throws com.liferay.portal.kernel.exception.SystemException {

		getService().resetSmsSchedulerState(smsSchedulerStateNewVal);
	}

	/*
	public static void sendMailWithPlainText(String body) {
		getService().sendMailWithPlainText(body);
	}
	*/

	public static boolean setSmsSchdulerContextInExclusiveMode(
			String querySQL, String varId, String value)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().setSmsSchdulerContextInExclusiveMode(
			querySQL, varId, value);
	}

	/*
	public static void updateHeartbeatInstant(long timestamp)
		throws com.liferay.portal.kernel.exception.SystemException {

		getService().updateHeartbeatInstant(timestamp);
	}
	*/

	/*
	public static long updateHeartbeatInstantNow()
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().updateHeartbeatInstantNow();
	}
	*/

	/**
	 * Updates the sms scheduler context in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param smsSchedulerContext the sms scheduler context
	 * @return the sms scheduler context that was updated
	 */
	public static it.eng.allerta.messages.services.model.SmsSchedulerContext
		updateSmsSchedulerContext(
			it.eng.allerta.messages.services.model.SmsSchedulerContext
				smsSchedulerContext) {

		return getService().updateSmsSchedulerContext(smsSchedulerContext);
	}

	public static it.eng.allerta.messages.services.model.SmsSchedulerContext
			updateSmsSchedulerContextNewTransaction(
				it.eng.allerta.messages.services.model.SmsSchedulerContext
					smsSchedulerContext)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().updateSmsSchedulerContextNewTransaction(
			smsSchedulerContext);
	}

	public static SmsSchedulerContextLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<SmsSchedulerContextLocalService, SmsSchedulerContextLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			SmsSchedulerContextLocalService.class);

		ServiceTracker
			<SmsSchedulerContextLocalService, SmsSchedulerContextLocalService>
				serviceTracker =
					new ServiceTracker
						<SmsSchedulerContextLocalService,
						 SmsSchedulerContextLocalService>(
							 bundle.getBundleContext(),
							 SmsSchedulerContextLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}