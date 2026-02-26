/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.previsioni.meteo.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.previsioni.meteo.model.Bollettino;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the bollettino service. This utility wraps <code>it.eng.previsioni.meteo.service.persistence.impl.BollettinoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BollettinoPersistence
 * @generated
 */
public class BollettinoUtil {

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
	public static void clearCache(Bollettino bollettino) {
		getPersistence().clearCache(bollettino);
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
	public static Map<Serializable, Bollettino> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Bollettino> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Bollettino> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Bollettino> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Bollettino> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Bollettino update(Bollettino bollettino) {
		return getPersistence().update(bollettino);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Bollettino update(
		Bollettino bollettino, ServiceContext serviceContext) {

		return getPersistence().update(bollettino, serviceContext);
	}

	/**
	 * Returns the bollettino where tipo = &#63; or throws a <code>NoSuchBollettinoException</code> if it could not be found.
	 *
	 * @param tipo the tipo
	 * @return the matching bollettino
	 * @throws NoSuchBollettinoException if a matching bollettino could not be found
	 */
	public static Bollettino findBytipo(String tipo)
		throws it.eng.previsioni.meteo.exception.NoSuchBollettinoException {

		return getPersistence().findBytipo(tipo);
	}

	/**
	 * Returns the bollettino where tipo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tipo the tipo
	 * @return the matching bollettino, or <code>null</code> if a matching bollettino could not be found
	 */
	public static Bollettino fetchBytipo(String tipo) {
		return getPersistence().fetchBytipo(tipo);
	}

	/**
	 * Returns the bollettino where tipo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tipo the tipo
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching bollettino, or <code>null</code> if a matching bollettino could not be found
	 */
	public static Bollettino fetchBytipo(String tipo, boolean useFinderCache) {
		return getPersistence().fetchBytipo(tipo, useFinderCache);
	}

	/**
	 * Removes the bollettino where tipo = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @return the bollettino that was removed
	 */
	public static Bollettino removeBytipo(String tipo)
		throws it.eng.previsioni.meteo.exception.NoSuchBollettinoException {

		return getPersistence().removeBytipo(tipo);
	}

	/**
	 * Returns the number of bollettinos where tipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @return the number of matching bollettinos
	 */
	public static int countBytipo(String tipo) {
		return getPersistence().countBytipo(tipo);
	}

	/**
	 * Caches the bollettino in the entity cache if it is enabled.
	 *
	 * @param bollettino the bollettino
	 */
	public static void cacheResult(Bollettino bollettino) {
		getPersistence().cacheResult(bollettino);
	}

	/**
	 * Caches the bollettinos in the entity cache if it is enabled.
	 *
	 * @param bollettinos the bollettinos
	 */
	public static void cacheResult(List<Bollettino> bollettinos) {
		getPersistence().cacheResult(bollettinos);
	}

	/**
	 * Creates a new bollettino with the primary key. Does not add the bollettino to the database.
	 *
	 * @param id the primary key for the new bollettino
	 * @return the new bollettino
	 */
	public static Bollettino create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the bollettino with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the bollettino
	 * @return the bollettino that was removed
	 * @throws NoSuchBollettinoException if a bollettino with the primary key could not be found
	 */
	public static Bollettino remove(long id)
		throws it.eng.previsioni.meteo.exception.NoSuchBollettinoException {

		return getPersistence().remove(id);
	}

	public static Bollettino updateImpl(Bollettino bollettino) {
		return getPersistence().updateImpl(bollettino);
	}

	/**
	 * Returns the bollettino with the primary key or throws a <code>NoSuchBollettinoException</code> if it could not be found.
	 *
	 * @param id the primary key of the bollettino
	 * @return the bollettino
	 * @throws NoSuchBollettinoException if a bollettino with the primary key could not be found
	 */
	public static Bollettino findByPrimaryKey(long id)
		throws it.eng.previsioni.meteo.exception.NoSuchBollettinoException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the bollettino with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the bollettino
	 * @return the bollettino, or <code>null</code> if a bollettino with the primary key could not be found
	 */
	public static Bollettino fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the bollettinos.
	 *
	 * @return the bollettinos
	 */
	public static List<Bollettino> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the bollettinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @return the range of bollettinos
	 */
	public static List<Bollettino> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the bollettinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bollettinos
	 */
	public static List<Bollettino> findAll(
		int start, int end, OrderByComparator<Bollettino> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the bollettinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of bollettinos
	 */
	public static List<Bollettino> findAll(
		int start, int end, OrderByComparator<Bollettino> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the bollettinos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of bollettinos.
	 *
	 * @return the number of bollettinos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BollettinoPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(BollettinoPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile BollettinoPersistence _persistence;

}