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

package it.eng.radarMeteo.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.radarMeteo.model.Comuni_bacini_ws;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the comuni_bacini_ws service. This utility wraps <code>it.eng.radarMeteo.service.persistence.impl.Comuni_bacini_wsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Francesco
 * @see Comuni_bacini_wsPersistence
 * @generated
 */
@ProviderType
public class Comuni_bacini_wsUtil {

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
	public static void clearCache(Comuni_bacini_ws comuni_bacini_ws) {
		getPersistence().clearCache(comuni_bacini_ws);
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
	public static Map<Serializable, Comuni_bacini_ws> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Comuni_bacini_ws> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Comuni_bacini_ws> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Comuni_bacini_ws> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Comuni_bacini_ws> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Comuni_bacini_ws update(Comuni_bacini_ws comuni_bacini_ws) {
		return getPersistence().update(comuni_bacini_ws);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Comuni_bacini_ws update(
		Comuni_bacini_ws comuni_bacini_ws, ServiceContext serviceContext) {

		return getPersistence().update(comuni_bacini_ws, serviceContext);
	}

	/**
	 * Returns all the comuni_bacini_wses where bacino = &#63;.
	 *
	 * @param bacino the bacino
	 * @return the matching comuni_bacini_wses
	 */
	public static List<Comuni_bacini_ws> findByBacino(String bacino) {
		return getPersistence().findByBacino(bacino);
	}

	/**
	 * Returns a range of all the comuni_bacini_wses where bacino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Comuni_bacini_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param bacino the bacino
	 * @param start the lower bound of the range of comuni_bacini_wses
	 * @param end the upper bound of the range of comuni_bacini_wses (not inclusive)
	 * @return the range of matching comuni_bacini_wses
	 */
	public static List<Comuni_bacini_ws> findByBacino(
		String bacino, int start, int end) {

		return getPersistence().findByBacino(bacino, start, end);
	}

	/**
	 * Returns an ordered range of all the comuni_bacini_wses where bacino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Comuni_bacini_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param bacino the bacino
	 * @param start the lower bound of the range of comuni_bacini_wses
	 * @param end the upper bound of the range of comuni_bacini_wses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comuni_bacini_wses
	 */
	public static List<Comuni_bacini_ws> findByBacino(
		String bacino, int start, int end,
		OrderByComparator<Comuni_bacini_ws> orderByComparator) {

		return getPersistence().findByBacino(
			bacino, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comuni_bacini_wses where bacino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Comuni_bacini_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param bacino the bacino
	 * @param start the lower bound of the range of comuni_bacini_wses
	 * @param end the upper bound of the range of comuni_bacini_wses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching comuni_bacini_wses
	 */
	public static List<Comuni_bacini_ws> findByBacino(
		String bacino, int start, int end,
		OrderByComparator<Comuni_bacini_ws> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByBacino(
			bacino, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first comuni_bacini_ws in the ordered set where bacino = &#63;.
	 *
	 * @param bacino the bacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comuni_bacini_ws
	 * @throws NoSuchComuni_bacini_wsException if a matching comuni_bacini_ws could not be found
	 */
	public static Comuni_bacini_ws findByBacino_First(
			String bacino,
			OrderByComparator<Comuni_bacini_ws> orderByComparator)
		throws it.eng.radarMeteo.exception.NoSuchComuni_bacini_wsException {

		return getPersistence().findByBacino_First(bacino, orderByComparator);
	}

	/**
	 * Returns the first comuni_bacini_ws in the ordered set where bacino = &#63;.
	 *
	 * @param bacino the bacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comuni_bacini_ws, or <code>null</code> if a matching comuni_bacini_ws could not be found
	 */
	public static Comuni_bacini_ws fetchByBacino_First(
		String bacino, OrderByComparator<Comuni_bacini_ws> orderByComparator) {

		return getPersistence().fetchByBacino_First(bacino, orderByComparator);
	}

	/**
	 * Returns the last comuni_bacini_ws in the ordered set where bacino = &#63;.
	 *
	 * @param bacino the bacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comuni_bacini_ws
	 * @throws NoSuchComuni_bacini_wsException if a matching comuni_bacini_ws could not be found
	 */
	public static Comuni_bacini_ws findByBacino_Last(
			String bacino,
			OrderByComparator<Comuni_bacini_ws> orderByComparator)
		throws it.eng.radarMeteo.exception.NoSuchComuni_bacini_wsException {

		return getPersistence().findByBacino_Last(bacino, orderByComparator);
	}

	/**
	 * Returns the last comuni_bacini_ws in the ordered set where bacino = &#63;.
	 *
	 * @param bacino the bacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comuni_bacini_ws, or <code>null</code> if a matching comuni_bacini_ws could not be found
	 */
	public static Comuni_bacini_ws fetchByBacino_Last(
		String bacino, OrderByComparator<Comuni_bacini_ws> orderByComparator) {

		return getPersistence().fetchByBacino_Last(bacino, orderByComparator);
	}

	/**
	 * Returns the comuni_bacini_wses before and after the current comuni_bacini_ws in the ordered set where bacino = &#63;.
	 *
	 * @param idBacini the primary key of the current comuni_bacini_ws
	 * @param bacino the bacino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comuni_bacini_ws
	 * @throws NoSuchComuni_bacini_wsException if a comuni_bacini_ws with the primary key could not be found
	 */
	public static Comuni_bacini_ws[] findByBacino_PrevAndNext(
			int idBacini, String bacino,
			OrderByComparator<Comuni_bacini_ws> orderByComparator)
		throws it.eng.radarMeteo.exception.NoSuchComuni_bacini_wsException {

		return getPersistence().findByBacino_PrevAndNext(
			idBacini, bacino, orderByComparator);
	}

	/**
	 * Removes all the comuni_bacini_wses where bacino = &#63; from the database.
	 *
	 * @param bacino the bacino
	 */
	public static void removeByBacino(String bacino) {
		getPersistence().removeByBacino(bacino);
	}

	/**
	 * Returns the number of comuni_bacini_wses where bacino = &#63;.
	 *
	 * @param bacino the bacino
	 * @return the number of matching comuni_bacini_wses
	 */
	public static int countByBacino(String bacino) {
		return getPersistence().countByBacino(bacino);
	}

	/**
	 * Caches the comuni_bacini_ws in the entity cache if it is enabled.
	 *
	 * @param comuni_bacini_ws the comuni_bacini_ws
	 */
	public static void cacheResult(Comuni_bacini_ws comuni_bacini_ws) {
		getPersistence().cacheResult(comuni_bacini_ws);
	}

	/**
	 * Caches the comuni_bacini_wses in the entity cache if it is enabled.
	 *
	 * @param comuni_bacini_wses the comuni_bacini_wses
	 */
	public static void cacheResult(List<Comuni_bacini_ws> comuni_bacini_wses) {
		getPersistence().cacheResult(comuni_bacini_wses);
	}

	/**
	 * Creates a new comuni_bacini_ws with the primary key. Does not add the comuni_bacini_ws to the database.
	 *
	 * @param idBacini the primary key for the new comuni_bacini_ws
	 * @return the new comuni_bacini_ws
	 */
	public static Comuni_bacini_ws create(int idBacini) {
		return getPersistence().create(idBacini);
	}

	/**
	 * Removes the comuni_bacini_ws with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idBacini the primary key of the comuni_bacini_ws
	 * @return the comuni_bacini_ws that was removed
	 * @throws NoSuchComuni_bacini_wsException if a comuni_bacini_ws with the primary key could not be found
	 */
	public static Comuni_bacini_ws remove(int idBacini)
		throws it.eng.radarMeteo.exception.NoSuchComuni_bacini_wsException {

		return getPersistence().remove(idBacini);
	}

	public static Comuni_bacini_ws updateImpl(
		Comuni_bacini_ws comuni_bacini_ws) {

		return getPersistence().updateImpl(comuni_bacini_ws);
	}

	/**
	 * Returns the comuni_bacini_ws with the primary key or throws a <code>NoSuchComuni_bacini_wsException</code> if it could not be found.
	 *
	 * @param idBacini the primary key of the comuni_bacini_ws
	 * @return the comuni_bacini_ws
	 * @throws NoSuchComuni_bacini_wsException if a comuni_bacini_ws with the primary key could not be found
	 */
	public static Comuni_bacini_ws findByPrimaryKey(int idBacini)
		throws it.eng.radarMeteo.exception.NoSuchComuni_bacini_wsException {

		return getPersistence().findByPrimaryKey(idBacini);
	}

	/**
	 * Returns the comuni_bacini_ws with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idBacini the primary key of the comuni_bacini_ws
	 * @return the comuni_bacini_ws, or <code>null</code> if a comuni_bacini_ws with the primary key could not be found
	 */
	public static Comuni_bacini_ws fetchByPrimaryKey(int idBacini) {
		return getPersistence().fetchByPrimaryKey(idBacini);
	}

	/**
	 * Returns all the comuni_bacini_wses.
	 *
	 * @return the comuni_bacini_wses
	 */
	public static List<Comuni_bacini_ws> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the comuni_bacini_wses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Comuni_bacini_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of comuni_bacini_wses
	 * @param end the upper bound of the range of comuni_bacini_wses (not inclusive)
	 * @return the range of comuni_bacini_wses
	 */
	public static List<Comuni_bacini_ws> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the comuni_bacini_wses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Comuni_bacini_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of comuni_bacini_wses
	 * @param end the upper bound of the range of comuni_bacini_wses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of comuni_bacini_wses
	 */
	public static List<Comuni_bacini_ws> findAll(
		int start, int end,
		OrderByComparator<Comuni_bacini_ws> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comuni_bacini_wses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Comuni_bacini_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of comuni_bacini_wses
	 * @param end the upper bound of the range of comuni_bacini_wses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of comuni_bacini_wses
	 */
	public static List<Comuni_bacini_ws> findAll(
		int start, int end,
		OrderByComparator<Comuni_bacini_ws> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the comuni_bacini_wses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of comuni_bacini_wses.
	 *
	 * @return the number of comuni_bacini_wses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Comuni_bacini_wsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<Comuni_bacini_wsPersistence, Comuni_bacini_wsPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			Comuni_bacini_wsPersistence.class);

		ServiceTracker<Comuni_bacini_wsPersistence, Comuni_bacini_wsPersistence>
			serviceTracker =
				new ServiceTracker
					<Comuni_bacini_wsPersistence, Comuni_bacini_wsPersistence>(
						bundle.getBundleContext(),
						Comuni_bacini_wsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}