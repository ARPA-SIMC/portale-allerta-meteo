/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.allerta.messages.services.model.Nodo;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the nodo service. This utility wraps <code>it.eng.allerta.messages.services.service.persistence.impl.NodoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Giorgianni_F
 * @see NodoPersistence
 * @generated
 */
public class NodoUtil {

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
	public static void clearCache(Nodo nodo) {
		getPersistence().clearCache(nodo);
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
	public static Map<Serializable, Nodo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Nodo> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Nodo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Nodo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Nodo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Nodo update(Nodo nodo) {
		return getPersistence().update(nodo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Nodo update(Nodo nodo, ServiceContext serviceContext) {
		return getPersistence().update(nodo, serviceContext);
	}

	/**
	 * Returns the nodo where nodoConnesso = &#63; or throws a <code>NoSuchNodoException</code> if it could not be found.
	 *
	 * @param nodoConnesso the nodo connesso
	 * @return the matching nodo
	 * @throws NoSuchNodoException if a matching nodo could not be found
	 */
	public static Nodo findBynodoConnesso(String nodoConnesso)
		throws it.eng.allerta.messages.services.exception.NoSuchNodoException {

		return getPersistence().findBynodoConnesso(nodoConnesso);
	}

	/**
	 * Returns the nodo where nodoConnesso = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nodoConnesso the nodo connesso
	 * @return the matching nodo, or <code>null</code> if a matching nodo could not be found
	 */
	public static Nodo fetchBynodoConnesso(String nodoConnesso) {
		return getPersistence().fetchBynodoConnesso(nodoConnesso);
	}

	/**
	 * Returns the nodo where nodoConnesso = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nodoConnesso the nodo connesso
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching nodo, or <code>null</code> if a matching nodo could not be found
	 */
	public static Nodo fetchBynodoConnesso(
		String nodoConnesso, boolean useFinderCache) {

		return getPersistence().fetchBynodoConnesso(
			nodoConnesso, useFinderCache);
	}

	/**
	 * Removes the nodo where nodoConnesso = &#63; from the database.
	 *
	 * @param nodoConnesso the nodo connesso
	 * @return the nodo that was removed
	 */
	public static Nodo removeBynodoConnesso(String nodoConnesso)
		throws it.eng.allerta.messages.services.exception.NoSuchNodoException {

		return getPersistence().removeBynodoConnesso(nodoConnesso);
	}

	/**
	 * Returns the number of nodos where nodoConnesso = &#63;.
	 *
	 * @param nodoConnesso the nodo connesso
	 * @return the number of matching nodos
	 */
	public static int countBynodoConnesso(String nodoConnesso) {
		return getPersistence().countBynodoConnesso(nodoConnesso);
	}

	/**
	 * Returns the nodo where ip = &#63; or throws a <code>NoSuchNodoException</code> if it could not be found.
	 *
	 * @param ip the ip
	 * @return the matching nodo
	 * @throws NoSuchNodoException if a matching nodo could not be found
	 */
	public static Nodo findByip(String ip)
		throws it.eng.allerta.messages.services.exception.NoSuchNodoException {

		return getPersistence().findByip(ip);
	}

	/**
	 * Returns the nodo where ip = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ip the ip
	 * @return the matching nodo, or <code>null</code> if a matching nodo could not be found
	 */
	public static Nodo fetchByip(String ip) {
		return getPersistence().fetchByip(ip);
	}

	/**
	 * Returns the nodo where ip = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ip the ip
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching nodo, or <code>null</code> if a matching nodo could not be found
	 */
	public static Nodo fetchByip(String ip, boolean useFinderCache) {
		return getPersistence().fetchByip(ip, useFinderCache);
	}

	/**
	 * Removes the nodo where ip = &#63; from the database.
	 *
	 * @param ip the ip
	 * @return the nodo that was removed
	 */
	public static Nodo removeByip(String ip)
		throws it.eng.allerta.messages.services.exception.NoSuchNodoException {

		return getPersistence().removeByip(ip);
	}

	/**
	 * Returns the number of nodos where ip = &#63;.
	 *
	 * @param ip the ip
	 * @return the number of matching nodos
	 */
	public static int countByip(String ip) {
		return getPersistence().countByip(ip);
	}

	/**
	 * Caches the nodo in the entity cache if it is enabled.
	 *
	 * @param nodo the nodo
	 */
	public static void cacheResult(Nodo nodo) {
		getPersistence().cacheResult(nodo);
	}

	/**
	 * Caches the nodos in the entity cache if it is enabled.
	 *
	 * @param nodos the nodos
	 */
	public static void cacheResult(List<Nodo> nodos) {
		getPersistence().cacheResult(nodos);
	}

	/**
	 * Creates a new nodo with the primary key. Does not add the nodo to the database.
	 *
	 * @param Id the primary key for the new nodo
	 * @return the new nodo
	 */
	public static Nodo create(long Id) {
		return getPersistence().create(Id);
	}

	/**
	 * Removes the nodo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the nodo
	 * @return the nodo that was removed
	 * @throws NoSuchNodoException if a nodo with the primary key could not be found
	 */
	public static Nodo remove(long Id)
		throws it.eng.allerta.messages.services.exception.NoSuchNodoException {

		return getPersistence().remove(Id);
	}

	public static Nodo updateImpl(Nodo nodo) {
		return getPersistence().updateImpl(nodo);
	}

	/**
	 * Returns the nodo with the primary key or throws a <code>NoSuchNodoException</code> if it could not be found.
	 *
	 * @param Id the primary key of the nodo
	 * @return the nodo
	 * @throws NoSuchNodoException if a nodo with the primary key could not be found
	 */
	public static Nodo findByPrimaryKey(long Id)
		throws it.eng.allerta.messages.services.exception.NoSuchNodoException {

		return getPersistence().findByPrimaryKey(Id);
	}

	/**
	 * Returns the nodo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the nodo
	 * @return the nodo, or <code>null</code> if a nodo with the primary key could not be found
	 */
	public static Nodo fetchByPrimaryKey(long Id) {
		return getPersistence().fetchByPrimaryKey(Id);
	}

	/**
	 * Returns all the nodos.
	 *
	 * @return the nodos
	 */
	public static List<Nodo> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the nodos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NodoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of nodos
	 * @param end the upper bound of the range of nodos (not inclusive)
	 * @return the range of nodos
	 */
	public static List<Nodo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the nodos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NodoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of nodos
	 * @param end the upper bound of the range of nodos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of nodos
	 */
	public static List<Nodo> findAll(
		int start, int end, OrderByComparator<Nodo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the nodos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NodoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of nodos
	 * @param end the upper bound of the range of nodos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of nodos
	 */
	public static List<Nodo> findAll(
		int start, int end, OrderByComparator<Nodo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the nodos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of nodos.
	 *
	 * @return the number of nodos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static NodoPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(NodoPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile NodoPersistence _persistence;

}