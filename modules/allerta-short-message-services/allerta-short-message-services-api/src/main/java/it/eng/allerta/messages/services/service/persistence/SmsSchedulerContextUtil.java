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

package it.eng.allerta.messages.services.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.allerta.messages.services.model.SmsSchedulerContext;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the sms scheduler context service. This utility wraps <code>it.eng.allerta.messages.services.service.persistence.impl.SmsSchedulerContextPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Giorgianni_F
 * @see SmsSchedulerContextPersistence
 * @generated
 */
@ProviderType
public class SmsSchedulerContextUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(SmsSchedulerContext smsSchedulerContext) {
		getPersistence().clearCache(smsSchedulerContext);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, SmsSchedulerContext> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SmsSchedulerContext> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SmsSchedulerContext> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SmsSchedulerContext> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SmsSchedulerContext> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SmsSchedulerContext update(
		SmsSchedulerContext smsSchedulerContext) {

		return getPersistence().update(smsSchedulerContext);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SmsSchedulerContext update(
		SmsSchedulerContext smsSchedulerContext,
		ServiceContext serviceContext) {

		return getPersistence().update(smsSchedulerContext, serviceContext);
	}

	/**
	 * Caches the sms scheduler context in the entity cache if it is enabled.
	 *
	 * @param smsSchedulerContext the sms scheduler context
	 */
	public static void cacheResult(SmsSchedulerContext smsSchedulerContext) {
		getPersistence().cacheResult(smsSchedulerContext);
	}

	/**
	 * Caches the sms scheduler contexts in the entity cache if it is enabled.
	 *
	 * @param smsSchedulerContexts the sms scheduler contexts
	 */
	public static void cacheResult(
		List<SmsSchedulerContext> smsSchedulerContexts) {

		getPersistence().cacheResult(smsSchedulerContexts);
	}

	/**
	 * Creates a new sms scheduler context with the primary key. Does not add the sms scheduler context to the database.
	 *
	 * @param varId the primary key for the new sms scheduler context
	 * @return the new sms scheduler context
	 */
	public static SmsSchedulerContext create(String varId) {
		return getPersistence().create(varId);
	}

	/**
	 * Removes the sms scheduler context with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param varId the primary key of the sms scheduler context
	 * @return the sms scheduler context that was removed
	 * @throws NoSuchSmsSchedulerContextException if a sms scheduler context with the primary key could not be found
	 */
	public static SmsSchedulerContext remove(String varId)
		throws it.eng.allerta.messages.services.exception.
			NoSuchSmsSchedulerContextException {

		return getPersistence().remove(varId);
	}

	public static SmsSchedulerContext updateImpl(
		SmsSchedulerContext smsSchedulerContext) {

		return getPersistence().updateImpl(smsSchedulerContext);
	}

	/**
	 * Returns the sms scheduler context with the primary key or throws a <code>NoSuchSmsSchedulerContextException</code> if it could not be found.
	 *
	 * @param varId the primary key of the sms scheduler context
	 * @return the sms scheduler context
	 * @throws NoSuchSmsSchedulerContextException if a sms scheduler context with the primary key could not be found
	 */
	public static SmsSchedulerContext findByPrimaryKey(String varId)
		throws it.eng.allerta.messages.services.exception.
			NoSuchSmsSchedulerContextException {

		return getPersistence().findByPrimaryKey(varId);
	}

	/**
	 * Returns the sms scheduler context with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param varId the primary key of the sms scheduler context
	 * @return the sms scheduler context, or <code>null</code> if a sms scheduler context with the primary key could not be found
	 */
	public static SmsSchedulerContext fetchByPrimaryKey(String varId) {
		return getPersistence().fetchByPrimaryKey(varId);
	}

	/**
	 * Returns all the sms scheduler contexts.
	 *
	 * @return the sms scheduler contexts
	 */
	public static List<SmsSchedulerContext> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the sms scheduler contexts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SmsSchedulerContextModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sms scheduler contexts
	 * @param end the upper bound of the range of sms scheduler contexts (not inclusive)
	 * @return the range of sms scheduler contexts
	 */
	public static List<SmsSchedulerContext> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the sms scheduler contexts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SmsSchedulerContextModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sms scheduler contexts
	 * @param end the upper bound of the range of sms scheduler contexts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sms scheduler contexts
	 */
	public static List<SmsSchedulerContext> findAll(
		int start, int end,
		OrderByComparator<SmsSchedulerContext> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sms scheduler contexts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SmsSchedulerContextModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sms scheduler contexts
	 * @param end the upper bound of the range of sms scheduler contexts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of sms scheduler contexts
	 */
	public static List<SmsSchedulerContext> findAll(
		int start, int end,
		OrderByComparator<SmsSchedulerContext> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the sms scheduler contexts from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of sms scheduler contexts.
	 *
	 * @return the number of sms scheduler contexts
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SmsSchedulerContextPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<SmsSchedulerContextPersistence, SmsSchedulerContextPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			SmsSchedulerContextPersistence.class);

		ServiceTracker
			<SmsSchedulerContextPersistence, SmsSchedulerContextPersistence>
				serviceTracker =
					new ServiceTracker
						<SmsSchedulerContextPersistence,
						 SmsSchedulerContextPersistence>(
							 bundle.getBundleContext(),
							 SmsSchedulerContextPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}