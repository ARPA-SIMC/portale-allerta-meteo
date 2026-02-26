/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.bollettino.model.Variabile;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the variabile service. This utility wraps <code>it.eng.bollettino.service.persistence.impl.VariabilePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see VariabilePersistence
 * @generated
 */
public class VariabileUtil {

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
	public static void clearCache(Variabile variabile) {
		getPersistence().clearCache(variabile);
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
	public static Map<Serializable, Variabile> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Variabile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Variabile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Variabile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Variabile> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Variabile update(Variabile variabile) {
		return getPersistence().update(variabile);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Variabile update(
		Variabile variabile, ServiceContext serviceContext) {

		return getPersistence().update(variabile, serviceContext);
	}

	/**
	 * Returns all the variabiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching variabiles
	 */
	public static List<Variabile> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the variabiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariabileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of variabiles
	 * @param end the upper bound of the range of variabiles (not inclusive)
	 * @return the range of matching variabiles
	 */
	public static List<Variabile> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the variabiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariabileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of variabiles
	 * @param end the upper bound of the range of variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching variabiles
	 */
	public static List<Variabile> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Variabile> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the variabiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariabileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of variabiles
	 * @param end the upper bound of the range of variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching variabiles
	 */
	public static List<Variabile> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Variabile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first variabile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching variabile
	 * @throws NoSuchVariabileException if a matching variabile could not be found
	 */
	public static Variabile findByUuid_First(
			String uuid, OrderByComparator<Variabile> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchVariabileException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first variabile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching variabile, or <code>null</code> if a matching variabile could not be found
	 */
	public static Variabile fetchByUuid_First(
		String uuid, OrderByComparator<Variabile> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last variabile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching variabile
	 * @throws NoSuchVariabileException if a matching variabile could not be found
	 */
	public static Variabile findByUuid_Last(
			String uuid, OrderByComparator<Variabile> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchVariabileException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last variabile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching variabile, or <code>null</code> if a matching variabile could not be found
	 */
	public static Variabile fetchByUuid_Last(
		String uuid, OrderByComparator<Variabile> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the variabiles before and after the current variabile in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current variabile
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next variabile
	 * @throws NoSuchVariabileException if a variabile with the primary key could not be found
	 */
	public static Variabile[] findByUuid_PrevAndNext(
			String id, String uuid,
			OrderByComparator<Variabile> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchVariabileException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the variabiles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of variabiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching variabiles
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the variabile in the entity cache if it is enabled.
	 *
	 * @param variabile the variabile
	 */
	public static void cacheResult(Variabile variabile) {
		getPersistence().cacheResult(variabile);
	}

	/**
	 * Caches the variabiles in the entity cache if it is enabled.
	 *
	 * @param variabiles the variabiles
	 */
	public static void cacheResult(List<Variabile> variabiles) {
		getPersistence().cacheResult(variabiles);
	}

	/**
	 * Creates a new variabile with the primary key. Does not add the variabile to the database.
	 *
	 * @param id the primary key for the new variabile
	 * @return the new variabile
	 */
	public static Variabile create(String id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the variabile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the variabile
	 * @return the variabile that was removed
	 * @throws NoSuchVariabileException if a variabile with the primary key could not be found
	 */
	public static Variabile remove(String id)
		throws it.eng.bollettino.exception.NoSuchVariabileException {

		return getPersistence().remove(id);
	}

	public static Variabile updateImpl(Variabile variabile) {
		return getPersistence().updateImpl(variabile);
	}

	/**
	 * Returns the variabile with the primary key or throws a <code>NoSuchVariabileException</code> if it could not be found.
	 *
	 * @param id the primary key of the variabile
	 * @return the variabile
	 * @throws NoSuchVariabileException if a variabile with the primary key could not be found
	 */
	public static Variabile findByPrimaryKey(String id)
		throws it.eng.bollettino.exception.NoSuchVariabileException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the variabile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the variabile
	 * @return the variabile, or <code>null</code> if a variabile with the primary key could not be found
	 */
	public static Variabile fetchByPrimaryKey(String id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the variabiles.
	 *
	 * @return the variabiles
	 */
	public static List<Variabile> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the variabiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariabileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of variabiles
	 * @param end the upper bound of the range of variabiles (not inclusive)
	 * @return the range of variabiles
	 */
	public static List<Variabile> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the variabiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariabileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of variabiles
	 * @param end the upper bound of the range of variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of variabiles
	 */
	public static List<Variabile> findAll(
		int start, int end, OrderByComparator<Variabile> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the variabiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VariabileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of variabiles
	 * @param end the upper bound of the range of variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of variabiles
	 */
	public static List<Variabile> findAll(
		int start, int end, OrderByComparator<Variabile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the variabiles from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of variabiles.
	 *
	 * @return the number of variabiles
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static VariabilePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(VariabilePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile VariabilePersistence _persistence;

}