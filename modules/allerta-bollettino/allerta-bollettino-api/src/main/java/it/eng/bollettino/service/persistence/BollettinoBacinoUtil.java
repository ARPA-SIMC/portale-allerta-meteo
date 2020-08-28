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

package it.eng.bollettino.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.bollettino.model.BollettinoBacino;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the bollettino bacino service. This utility wraps <code>it.eng.bollettino.service.persistence.impl.BollettinoBacinoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see BollettinoBacinoPersistence
 * @generated
 */
@ProviderType
public class BollettinoBacinoUtil {

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
	public static void clearCache(BollettinoBacino bollettinoBacino) {
		getPersistence().clearCache(bollettinoBacino);
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
	public static Map<Serializable, BollettinoBacino> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BollettinoBacino> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BollettinoBacino> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BollettinoBacino> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BollettinoBacino> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BollettinoBacino update(BollettinoBacino bollettinoBacino) {
		return getPersistence().update(bollettinoBacino);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BollettinoBacino update(
		BollettinoBacino bollettinoBacino, ServiceContext serviceContext) {

		return getPersistence().update(bollettinoBacino, serviceContext);
	}

	/**
	 * Returns all the bollettino bacinos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching bollettino bacinos
	 */
	public static List<BollettinoBacino> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the bollettino bacinos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @return the range of matching bollettino bacinos
	 */
	public static List<BollettinoBacino> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the bollettino bacinos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bollettino bacinos
	 */
	public static List<BollettinoBacino> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BollettinoBacino> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the bollettino bacinos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching bollettino bacinos
	 */
	public static List<BollettinoBacino> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BollettinoBacino> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first bollettino bacino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino bacino
	 * @throws NoSuchBollettinoBacinoException if a matching bollettino bacino could not be found
	 */
	public static BollettinoBacino findByUuid_First(
			String uuid, OrderByComparator<BollettinoBacino> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchBollettinoBacinoException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first bollettino bacino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino bacino, or <code>null</code> if a matching bollettino bacino could not be found
	 */
	public static BollettinoBacino fetchByUuid_First(
		String uuid, OrderByComparator<BollettinoBacino> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last bollettino bacino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino bacino
	 * @throws NoSuchBollettinoBacinoException if a matching bollettino bacino could not be found
	 */
	public static BollettinoBacino findByUuid_Last(
			String uuid, OrderByComparator<BollettinoBacino> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchBollettinoBacinoException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last bollettino bacino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino bacino, or <code>null</code> if a matching bollettino bacino could not be found
	 */
	public static BollettinoBacino fetchByUuid_Last(
		String uuid, OrderByComparator<BollettinoBacino> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the bollettino bacinos before and after the current bollettino bacino in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current bollettino bacino
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bollettino bacino
	 * @throws NoSuchBollettinoBacinoException if a bollettino bacino with the primary key could not be found
	 */
	public static BollettinoBacino[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<BollettinoBacino> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchBollettinoBacinoException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the bollettino bacinos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of bollettino bacinos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching bollettino bacinos
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the bollettino bacinos where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @return the matching bollettino bacinos
	 */
	public static List<BollettinoBacino> findByBollettino(long idBollettino) {
		return getPersistence().findByBollettino(idBollettino);
	}

	/**
	 * Returns a range of all the bollettino bacinos where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @return the range of matching bollettino bacinos
	 */
	public static List<BollettinoBacino> findByBollettino(
		long idBollettino, int start, int end) {

		return getPersistence().findByBollettino(idBollettino, start, end);
	}

	/**
	 * Returns an ordered range of all the bollettino bacinos where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bollettino bacinos
	 */
	public static List<BollettinoBacino> findByBollettino(
		long idBollettino, int start, int end,
		OrderByComparator<BollettinoBacino> orderByComparator) {

		return getPersistence().findByBollettino(
			idBollettino, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the bollettino bacinos where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching bollettino bacinos
	 */
	public static List<BollettinoBacino> findByBollettino(
		long idBollettino, int start, int end,
		OrderByComparator<BollettinoBacino> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByBollettino(
			idBollettino, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first bollettino bacino in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino bacino
	 * @throws NoSuchBollettinoBacinoException if a matching bollettino bacino could not be found
	 */
	public static BollettinoBacino findByBollettino_First(
			long idBollettino,
			OrderByComparator<BollettinoBacino> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchBollettinoBacinoException {

		return getPersistence().findByBollettino_First(
			idBollettino, orderByComparator);
	}

	/**
	 * Returns the first bollettino bacino in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino bacino, or <code>null</code> if a matching bollettino bacino could not be found
	 */
	public static BollettinoBacino fetchByBollettino_First(
		long idBollettino,
		OrderByComparator<BollettinoBacino> orderByComparator) {

		return getPersistence().fetchByBollettino_First(
			idBollettino, orderByComparator);
	}

	/**
	 * Returns the last bollettino bacino in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino bacino
	 * @throws NoSuchBollettinoBacinoException if a matching bollettino bacino could not be found
	 */
	public static BollettinoBacino findByBollettino_Last(
			long idBollettino,
			OrderByComparator<BollettinoBacino> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchBollettinoBacinoException {

		return getPersistence().findByBollettino_Last(
			idBollettino, orderByComparator);
	}

	/**
	 * Returns the last bollettino bacino in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino bacino, or <code>null</code> if a matching bollettino bacino could not be found
	 */
	public static BollettinoBacino fetchByBollettino_Last(
		long idBollettino,
		OrderByComparator<BollettinoBacino> orderByComparator) {

		return getPersistence().fetchByBollettino_Last(
			idBollettino, orderByComparator);
	}

	/**
	 * Returns the bollettino bacinos before and after the current bollettino bacino in the ordered set where idBollettino = &#63;.
	 *
	 * @param id the primary key of the current bollettino bacino
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bollettino bacino
	 * @throws NoSuchBollettinoBacinoException if a bollettino bacino with the primary key could not be found
	 */
	public static BollettinoBacino[] findByBollettino_PrevAndNext(
			long id, long idBollettino,
			OrderByComparator<BollettinoBacino> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchBollettinoBacinoException {

		return getPersistence().findByBollettino_PrevAndNext(
			id, idBollettino, orderByComparator);
	}

	/**
	 * Removes all the bollettino bacinos where idBollettino = &#63; from the database.
	 *
	 * @param idBollettino the id bollettino
	 */
	public static void removeByBollettino(long idBollettino) {
		getPersistence().removeByBollettino(idBollettino);
	}

	/**
	 * Returns the number of bollettino bacinos where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @return the number of matching bollettino bacinos
	 */
	public static int countByBollettino(long idBollettino) {
		return getPersistence().countByBollettino(idBollettino);
	}

	/**
	 * Caches the bollettino bacino in the entity cache if it is enabled.
	 *
	 * @param bollettinoBacino the bollettino bacino
	 */
	public static void cacheResult(BollettinoBacino bollettinoBacino) {
		getPersistence().cacheResult(bollettinoBacino);
	}

	/**
	 * Caches the bollettino bacinos in the entity cache if it is enabled.
	 *
	 * @param bollettinoBacinos the bollettino bacinos
	 */
	public static void cacheResult(List<BollettinoBacino> bollettinoBacinos) {
		getPersistence().cacheResult(bollettinoBacinos);
	}

	/**
	 * Creates a new bollettino bacino with the primary key. Does not add the bollettino bacino to the database.
	 *
	 * @param id the primary key for the new bollettino bacino
	 * @return the new bollettino bacino
	 */
	public static BollettinoBacino create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the bollettino bacino with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the bollettino bacino
	 * @return the bollettino bacino that was removed
	 * @throws NoSuchBollettinoBacinoException if a bollettino bacino with the primary key could not be found
	 */
	public static BollettinoBacino remove(long id)
		throws it.eng.bollettino.exception.NoSuchBollettinoBacinoException {

		return getPersistence().remove(id);
	}

	public static BollettinoBacino updateImpl(
		BollettinoBacino bollettinoBacino) {

		return getPersistence().updateImpl(bollettinoBacino);
	}

	/**
	 * Returns the bollettino bacino with the primary key or throws a <code>NoSuchBollettinoBacinoException</code> if it could not be found.
	 *
	 * @param id the primary key of the bollettino bacino
	 * @return the bollettino bacino
	 * @throws NoSuchBollettinoBacinoException if a bollettino bacino with the primary key could not be found
	 */
	public static BollettinoBacino findByPrimaryKey(long id)
		throws it.eng.bollettino.exception.NoSuchBollettinoBacinoException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the bollettino bacino with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the bollettino bacino
	 * @return the bollettino bacino, or <code>null</code> if a bollettino bacino with the primary key could not be found
	 */
	public static BollettinoBacino fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the bollettino bacinos.
	 *
	 * @return the bollettino bacinos
	 */
	public static List<BollettinoBacino> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the bollettino bacinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @return the range of bollettino bacinos
	 */
	public static List<BollettinoBacino> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the bollettino bacinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bollettino bacinos
	 */
	public static List<BollettinoBacino> findAll(
		int start, int end,
		OrderByComparator<BollettinoBacino> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the bollettino bacinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of bollettino bacinos
	 */
	public static List<BollettinoBacino> findAll(
		int start, int end,
		OrderByComparator<BollettinoBacino> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the bollettino bacinos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of bollettino bacinos.
	 *
	 * @return the number of bollettino bacinos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static BollettinoBacinoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<BollettinoBacinoPersistence, BollettinoBacinoPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			BollettinoBacinoPersistence.class);

		ServiceTracker<BollettinoBacinoPersistence, BollettinoBacinoPersistence>
			serviceTracker =
				new ServiceTracker
					<BollettinoBacinoPersistence, BollettinoBacinoPersistence>(
						bundle.getBundleContext(),
						BollettinoBacinoPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}