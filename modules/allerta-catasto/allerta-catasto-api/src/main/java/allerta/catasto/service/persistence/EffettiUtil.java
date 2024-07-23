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

import allerta.catasto.model.Effetti;

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
 * The persistence utility for the effetti service. This utility wraps <code>allerta.catasto.service.persistence.impl.EffettiPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EffettiPersistence
 * @generated
 */
@ProviderType
public class EffettiUtil {

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
	public static void clearCache(Effetti effetti) {
		getPersistence().clearCache(effetti);
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
	public static Map<Serializable, Effetti> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Effetti> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Effetti> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Effetti> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Effetti> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Effetti update(Effetti effetti) {
		return getPersistence().update(effetti);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Effetti update(
		Effetti effetti, ServiceContext serviceContext) {

		return getPersistence().update(effetti, serviceContext);
	}

	/**
	 * Caches the effetti in the entity cache if it is enabled.
	 *
	 * @param effetti the effetti
	 */
	public static void cacheResult(Effetti effetti) {
		getPersistence().cacheResult(effetti);
	}

	/**
	 * Caches the effettis in the entity cache if it is enabled.
	 *
	 * @param effettis the effettis
	 */
	public static void cacheResult(List<Effetti> effettis) {
		getPersistence().cacheResult(effettis);
	}

	/**
	 * Creates a new effetti with the primary key. Does not add the effetti to the database.
	 *
	 * @param id the primary key for the new effetti
	 * @return the new effetti
	 */
	public static Effetti create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the effetti with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the effetti
	 * @return the effetti that was removed
	 * @throws NoSuchEffettiException if a effetti with the primary key could not be found
	 */
	public static Effetti remove(long id)
		throws allerta.catasto.exception.NoSuchEffettiException {

		return getPersistence().remove(id);
	}

	public static Effetti updateImpl(Effetti effetti) {
		return getPersistence().updateImpl(effetti);
	}

	/**
	 * Returns the effetti with the primary key or throws a <code>NoSuchEffettiException</code> if it could not be found.
	 *
	 * @param id the primary key of the effetti
	 * @return the effetti
	 * @throws NoSuchEffettiException if a effetti with the primary key could not be found
	 */
	public static Effetti findByPrimaryKey(long id)
		throws allerta.catasto.exception.NoSuchEffettiException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the effetti with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the effetti
	 * @return the effetti, or <code>null</code> if a effetti with the primary key could not be found
	 */
	public static Effetti fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the effettis.
	 *
	 * @return the effettis
	 */
	public static List<Effetti> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the effettis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EffettiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of effettis
	 * @param end the upper bound of the range of effettis (not inclusive)
	 * @return the range of effettis
	 */
	public static List<Effetti> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the effettis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EffettiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of effettis
	 * @param end the upper bound of the range of effettis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of effettis
	 */
	public static List<Effetti> findAll(
		int start, int end, OrderByComparator<Effetti> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the effettis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EffettiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of effettis
	 * @param end the upper bound of the range of effettis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of effettis
	 */
	public static List<Effetti> findAll(
		int start, int end, OrderByComparator<Effetti> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the effettis from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of effettis.
	 *
	 * @return the number of effettis
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static EffettiPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EffettiPersistence, EffettiPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EffettiPersistence.class);

		ServiceTracker<EffettiPersistence, EffettiPersistence> serviceTracker =
			new ServiceTracker<EffettiPersistence, EffettiPersistence>(
				bundle.getBundleContext(), EffettiPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}