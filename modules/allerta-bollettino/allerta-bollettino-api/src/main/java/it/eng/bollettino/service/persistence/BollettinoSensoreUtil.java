/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.bollettino.model.BollettinoSensore;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the bollettino sensore service. This utility wraps <code>it.eng.bollettino.service.persistence.impl.BollettinoSensorePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see BollettinoSensorePersistence
 * @generated
 */
public class BollettinoSensoreUtil {

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
	public static void clearCache(BollettinoSensore bollettinoSensore) {
		getPersistence().clearCache(bollettinoSensore);
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
	public static Map<Serializable, BollettinoSensore> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BollettinoSensore> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BollettinoSensore> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BollettinoSensore> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BollettinoSensore> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BollettinoSensore update(
		BollettinoSensore bollettinoSensore) {

		return getPersistence().update(bollettinoSensore);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BollettinoSensore update(
		BollettinoSensore bollettinoSensore, ServiceContext serviceContext) {

		return getPersistence().update(bollettinoSensore, serviceContext);
	}

	/**
	 * Returns all the bollettino sensores where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching bollettino sensores
	 */
	public static List<BollettinoSensore> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the bollettino sensores where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoSensoreModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino sensores
	 * @param end the upper bound of the range of bollettino sensores (not inclusive)
	 * @return the range of matching bollettino sensores
	 */
	public static List<BollettinoSensore> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the bollettino sensores where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoSensoreModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino sensores
	 * @param end the upper bound of the range of bollettino sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bollettino sensores
	 */
	public static List<BollettinoSensore> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BollettinoSensore> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the bollettino sensores where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoSensoreModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino sensores
	 * @param end the upper bound of the range of bollettino sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bollettino sensores
	 */
	public static List<BollettinoSensore> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BollettinoSensore> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first bollettino sensore in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino sensore
	 * @throws NoSuchBollettinoSensoreException if a matching bollettino sensore could not be found
	 */
	public static BollettinoSensore findByUuid_First(
			String uuid, OrderByComparator<BollettinoSensore> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchBollettinoSensoreException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first bollettino sensore in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino sensore, or <code>null</code> if a matching bollettino sensore could not be found
	 */
	public static BollettinoSensore fetchByUuid_First(
		String uuid, OrderByComparator<BollettinoSensore> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last bollettino sensore in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino sensore
	 * @throws NoSuchBollettinoSensoreException if a matching bollettino sensore could not be found
	 */
	public static BollettinoSensore findByUuid_Last(
			String uuid, OrderByComparator<BollettinoSensore> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchBollettinoSensoreException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last bollettino sensore in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino sensore, or <code>null</code> if a matching bollettino sensore could not be found
	 */
	public static BollettinoSensore fetchByUuid_Last(
		String uuid, OrderByComparator<BollettinoSensore> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the bollettino sensores before and after the current bollettino sensore in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current bollettino sensore
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bollettino sensore
	 * @throws NoSuchBollettinoSensoreException if a bollettino sensore with the primary key could not be found
	 */
	public static BollettinoSensore[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<BollettinoSensore> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchBollettinoSensoreException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the bollettino sensores where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of bollettino sensores where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching bollettino sensores
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the bollettino sensores where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @return the matching bollettino sensores
	 */
	public static List<BollettinoSensore> findByBollettino(long idBollettino) {
		return getPersistence().findByBollettino(idBollettino);
	}

	/**
	 * Returns a range of all the bollettino sensores where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoSensoreModelImpl</code>.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino sensores
	 * @param end the upper bound of the range of bollettino sensores (not inclusive)
	 * @return the range of matching bollettino sensores
	 */
	public static List<BollettinoSensore> findByBollettino(
		long idBollettino, int start, int end) {

		return getPersistence().findByBollettino(idBollettino, start, end);
	}

	/**
	 * Returns an ordered range of all the bollettino sensores where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoSensoreModelImpl</code>.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino sensores
	 * @param end the upper bound of the range of bollettino sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bollettino sensores
	 */
	public static List<BollettinoSensore> findByBollettino(
		long idBollettino, int start, int end,
		OrderByComparator<BollettinoSensore> orderByComparator) {

		return getPersistence().findByBollettino(
			idBollettino, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the bollettino sensores where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoSensoreModelImpl</code>.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino sensores
	 * @param end the upper bound of the range of bollettino sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bollettino sensores
	 */
	public static List<BollettinoSensore> findByBollettino(
		long idBollettino, int start, int end,
		OrderByComparator<BollettinoSensore> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByBollettino(
			idBollettino, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first bollettino sensore in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino sensore
	 * @throws NoSuchBollettinoSensoreException if a matching bollettino sensore could not be found
	 */
	public static BollettinoSensore findByBollettino_First(
			long idBollettino,
			OrderByComparator<BollettinoSensore> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchBollettinoSensoreException {

		return getPersistence().findByBollettino_First(
			idBollettino, orderByComparator);
	}

	/**
	 * Returns the first bollettino sensore in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino sensore, or <code>null</code> if a matching bollettino sensore could not be found
	 */
	public static BollettinoSensore fetchByBollettino_First(
		long idBollettino,
		OrderByComparator<BollettinoSensore> orderByComparator) {

		return getPersistence().fetchByBollettino_First(
			idBollettino, orderByComparator);
	}

	/**
	 * Returns the last bollettino sensore in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino sensore
	 * @throws NoSuchBollettinoSensoreException if a matching bollettino sensore could not be found
	 */
	public static BollettinoSensore findByBollettino_Last(
			long idBollettino,
			OrderByComparator<BollettinoSensore> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchBollettinoSensoreException {

		return getPersistence().findByBollettino_Last(
			idBollettino, orderByComparator);
	}

	/**
	 * Returns the last bollettino sensore in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino sensore, or <code>null</code> if a matching bollettino sensore could not be found
	 */
	public static BollettinoSensore fetchByBollettino_Last(
		long idBollettino,
		OrderByComparator<BollettinoSensore> orderByComparator) {

		return getPersistence().fetchByBollettino_Last(
			idBollettino, orderByComparator);
	}

	/**
	 * Returns the bollettino sensores before and after the current bollettino sensore in the ordered set where idBollettino = &#63;.
	 *
	 * @param id the primary key of the current bollettino sensore
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bollettino sensore
	 * @throws NoSuchBollettinoSensoreException if a bollettino sensore with the primary key could not be found
	 */
	public static BollettinoSensore[] findByBollettino_PrevAndNext(
			long id, long idBollettino,
			OrderByComparator<BollettinoSensore> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchBollettinoSensoreException {

		return getPersistence().findByBollettino_PrevAndNext(
			id, idBollettino, orderByComparator);
	}

	/**
	 * Removes all the bollettino sensores where idBollettino = &#63; from the database.
	 *
	 * @param idBollettino the id bollettino
	 */
	public static void removeByBollettino(long idBollettino) {
		getPersistence().removeByBollettino(idBollettino);
	}

	/**
	 * Returns the number of bollettino sensores where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @return the number of matching bollettino sensores
	 */
	public static int countByBollettino(long idBollettino) {
		return getPersistence().countByBollettino(idBollettino);
	}

	/**
	 * Caches the bollettino sensore in the entity cache if it is enabled.
	 *
	 * @param bollettinoSensore the bollettino sensore
	 */
	public static void cacheResult(BollettinoSensore bollettinoSensore) {
		getPersistence().cacheResult(bollettinoSensore);
	}

	/**
	 * Caches the bollettino sensores in the entity cache if it is enabled.
	 *
	 * @param bollettinoSensores the bollettino sensores
	 */
	public static void cacheResult(List<BollettinoSensore> bollettinoSensores) {
		getPersistence().cacheResult(bollettinoSensores);
	}

	/**
	 * Creates a new bollettino sensore with the primary key. Does not add the bollettino sensore to the database.
	 *
	 * @param id the primary key for the new bollettino sensore
	 * @return the new bollettino sensore
	 */
	public static BollettinoSensore create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the bollettino sensore with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the bollettino sensore
	 * @return the bollettino sensore that was removed
	 * @throws NoSuchBollettinoSensoreException if a bollettino sensore with the primary key could not be found
	 */
	public static BollettinoSensore remove(long id)
		throws it.eng.bollettino.exception.NoSuchBollettinoSensoreException {

		return getPersistence().remove(id);
	}

	public static BollettinoSensore updateImpl(
		BollettinoSensore bollettinoSensore) {

		return getPersistence().updateImpl(bollettinoSensore);
	}

	/**
	 * Returns the bollettino sensore with the primary key or throws a <code>NoSuchBollettinoSensoreException</code> if it could not be found.
	 *
	 * @param id the primary key of the bollettino sensore
	 * @return the bollettino sensore
	 * @throws NoSuchBollettinoSensoreException if a bollettino sensore with the primary key could not be found
	 */
	public static BollettinoSensore findByPrimaryKey(long id)
		throws it.eng.bollettino.exception.NoSuchBollettinoSensoreException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the bollettino sensore with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the bollettino sensore
	 * @return the bollettino sensore, or <code>null</code> if a bollettino sensore with the primary key could not be found
	 */
	public static BollettinoSensore fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the bollettino sensores.
	 *
	 * @return the bollettino sensores
	 */
	public static List<BollettinoSensore> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the bollettino sensores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoSensoreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino sensores
	 * @param end the upper bound of the range of bollettino sensores (not inclusive)
	 * @return the range of bollettino sensores
	 */
	public static List<BollettinoSensore> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the bollettino sensores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoSensoreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino sensores
	 * @param end the upper bound of the range of bollettino sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bollettino sensores
	 */
	public static List<BollettinoSensore> findAll(
		int start, int end,
		OrderByComparator<BollettinoSensore> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the bollettino sensores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoSensoreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino sensores
	 * @param end the upper bound of the range of bollettino sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of bollettino sensores
	 */
	public static List<BollettinoSensore> findAll(
		int start, int end,
		OrderByComparator<BollettinoSensore> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the bollettino sensores from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of bollettino sensores.
	 *
	 * @return the number of bollettino sensores
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BollettinoSensorePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		BollettinoSensorePersistence persistence) {

		_persistence = persistence;
	}

	private static volatile BollettinoSensorePersistence _persistence;

}