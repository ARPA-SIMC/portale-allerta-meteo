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

import it.eng.allerta.messages.services.model.Auth;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the auth service. This utility wraps <code>it.eng.allerta.messages.services.service.persistence.impl.AuthPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Giorgianni_F
 * @see AuthPersistence
 * @generated
 */
@ProviderType
public class AuthUtil {

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
	public static void clearCache(Auth auth) {
		getPersistence().clearCache(auth);
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
	public static Map<Serializable, Auth> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Auth> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Auth> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Auth> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Auth> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Auth update(Auth auth) {
		return getPersistence().update(auth);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Auth update(Auth auth, ServiceContext serviceContext) {
		return getPersistence().update(auth, serviceContext);
	}

	/**
	 * Caches the auth in the entity cache if it is enabled.
	 *
	 * @param auth the auth
	 */
	public static void cacheResult(Auth auth) {
		getPersistence().cacheResult(auth);
	}

	/**
	 * Caches the auths in the entity cache if it is enabled.
	 *
	 * @param auths the auths
	 */
	public static void cacheResult(List<Auth> auths) {
		getPersistence().cacheResult(auths);
	}

	/**
	 * Creates a new auth with the primary key. Does not add the auth to the database.
	 *
	 * @param key the primary key for the new auth
	 * @return the new auth
	 */
	public static Auth create(String key) {
		return getPersistence().create(key);
	}

	/**
	 * Removes the auth with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param key the primary key of the auth
	 * @return the auth that was removed
	 * @throws NoSuchAuthException if a auth with the primary key could not be found
	 */
	public static Auth remove(String key)
		throws it.eng.allerta.messages.services.exception.NoSuchAuthException {

		return getPersistence().remove(key);
	}

	public static Auth updateImpl(Auth auth) {
		return getPersistence().updateImpl(auth);
	}

	/**
	 * Returns the auth with the primary key or throws a <code>NoSuchAuthException</code> if it could not be found.
	 *
	 * @param key the primary key of the auth
	 * @return the auth
	 * @throws NoSuchAuthException if a auth with the primary key could not be found
	 */
	public static Auth findByPrimaryKey(String key)
		throws it.eng.allerta.messages.services.exception.NoSuchAuthException {

		return getPersistence().findByPrimaryKey(key);
	}

	/**
	 * Returns the auth with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param key the primary key of the auth
	 * @return the auth, or <code>null</code> if a auth with the primary key could not be found
	 */
	public static Auth fetchByPrimaryKey(String key) {
		return getPersistence().fetchByPrimaryKey(key);
	}

	/**
	 * Returns all the auths.
	 *
	 * @return the auths
	 */
	public static List<Auth> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the auths.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AuthModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of auths
	 * @param end the upper bound of the range of auths (not inclusive)
	 * @return the range of auths
	 */
	public static List<Auth> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the auths.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AuthModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of auths
	 * @param end the upper bound of the range of auths (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of auths
	 */
	public static List<Auth> findAll(
		int start, int end, OrderByComparator<Auth> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the auths.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AuthModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of auths
	 * @param end the upper bound of the range of auths (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of auths
	 */
	public static List<Auth> findAll(
		int start, int end, OrderByComparator<Auth> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the auths from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of auths.
	 *
	 * @return the number of auths
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static AuthPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AuthPersistence, AuthPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AuthPersistence.class);

		ServiceTracker<AuthPersistence, AuthPersistence> serviceTracker =
			new ServiceTracker<AuthPersistence, AuthPersistence>(
				bundle.getBundleContext(), AuthPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}