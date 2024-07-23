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

package allerta.catasto.service.persistence;

import aQute.bnd.annotation.ProviderType;

import allerta.catasto.model.EffettiSub;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the effetti sub service. This utility wraps <code>allerta.catasto.service.persistence.impl.EffettiSubPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EffettiSubPersistence
 * @generated
 */
@ProviderType
public class EffettiSubUtil {

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
	public static void clearCache(EffettiSub effettiSub) {
		getPersistence().clearCache(effettiSub);
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
	public static Map<Serializable, EffettiSub> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EffettiSub> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EffettiSub> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EffettiSub> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EffettiSub> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EffettiSub update(EffettiSub effettiSub) {
		return getPersistence().update(effettiSub);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EffettiSub update(
		EffettiSub effettiSub, ServiceContext serviceContext) {

		return getPersistence().update(effettiSub, serviceContext);
	}

	/**
	 * Caches the effetti sub in the entity cache if it is enabled.
	 *
	 * @param effettiSub the effetti sub
	 */
	public static void cacheResult(EffettiSub effettiSub) {
		getPersistence().cacheResult(effettiSub);
	}

	/**
	 * Caches the effetti subs in the entity cache if it is enabled.
	 *
	 * @param effettiSubs the effetti subs
	 */
	public static void cacheResult(List<EffettiSub> effettiSubs) {
		getPersistence().cacheResult(effettiSubs);
	}

	/**
	 * Creates a new effetti sub with the primary key. Does not add the effetti sub to the database.
	 *
	 * @param effettiSubPK the primary key for the new effetti sub
	 * @return the new effetti sub
	 */
	public static EffettiSub create(
		allerta.catasto.service.persistence.EffettiSubPK effettiSubPK) {

		return getPersistence().create(effettiSubPK);
	}

	/**
	 * Removes the effetti sub with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param effettiSubPK the primary key of the effetti sub
	 * @return the effetti sub that was removed
	 * @throws NoSuchEffettiSubException if a effetti sub with the primary key could not be found
	 */
	public static EffettiSub remove(
			allerta.catasto.service.persistence.EffettiSubPK effettiSubPK)
		throws allerta.catasto.exception.NoSuchEffettiSubException {

		return getPersistence().remove(effettiSubPK);
	}

	public static EffettiSub updateImpl(EffettiSub effettiSub) {
		return getPersistence().updateImpl(effettiSub);
	}

	/**
	 * Returns the effetti sub with the primary key or throws a <code>NoSuchEffettiSubException</code> if it could not be found.
	 *
	 * @param effettiSubPK the primary key of the effetti sub
	 * @return the effetti sub
	 * @throws NoSuchEffettiSubException if a effetti sub with the primary key could not be found
	 */
	public static EffettiSub findByPrimaryKey(
			allerta.catasto.service.persistence.EffettiSubPK effettiSubPK)
		throws allerta.catasto.exception.NoSuchEffettiSubException {

		return getPersistence().findByPrimaryKey(effettiSubPK);
	}

	/**
	 * Returns the effetti sub with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param effettiSubPK the primary key of the effetti sub
	 * @return the effetti sub, or <code>null</code> if a effetti sub with the primary key could not be found
	 */
	public static EffettiSub fetchByPrimaryKey(
		allerta.catasto.service.persistence.EffettiSubPK effettiSubPK) {

		return getPersistence().fetchByPrimaryKey(effettiSubPK);
	}

	/**
	 * Returns all the effetti subs.
	 *
	 * @return the effetti subs
	 */
	public static List<EffettiSub> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the effetti subs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EffettiSubModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of effetti subs
	 * @param end the upper bound of the range of effetti subs (not inclusive)
	 * @return the range of effetti subs
	 */
	public static List<EffettiSub> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the effetti subs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EffettiSubModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of effetti subs
	 * @param end the upper bound of the range of effetti subs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of effetti subs
	 */
	public static List<EffettiSub> findAll(
		int start, int end, OrderByComparator<EffettiSub> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the effetti subs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EffettiSubModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of effetti subs
	 * @param end the upper bound of the range of effetti subs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of effetti subs
	 */
	public static List<EffettiSub> findAll(
		int start, int end, OrderByComparator<EffettiSub> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the effetti subs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of effetti subs.
	 *
	 * @return the number of effetti subs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static EffettiSubPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EffettiSubPersistence, EffettiSubPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EffettiSubPersistence.class);

		ServiceTracker<EffettiSubPersistence, EffettiSubPersistence>
			serviceTracker =
				new ServiceTracker
					<EffettiSubPersistence, EffettiSubPersistence>(
						bundle.getBundleContext(), EffettiSubPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}