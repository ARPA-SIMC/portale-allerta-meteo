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

import it.eng.bollettino.model.BollettinoIcona;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the bollettino icona service. This utility wraps <code>it.eng.bollettino.service.persistence.impl.BollettinoIconaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see BollettinoIconaPersistence
 * @generated
 */
@ProviderType
public class BollettinoIconaUtil {

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
	public static void clearCache(BollettinoIcona bollettinoIcona) {
		getPersistence().clearCache(bollettinoIcona);
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
	public static Map<Serializable, BollettinoIcona> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BollettinoIcona> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BollettinoIcona> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BollettinoIcona> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BollettinoIcona> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BollettinoIcona update(BollettinoIcona bollettinoIcona) {
		return getPersistence().update(bollettinoIcona);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BollettinoIcona update(
		BollettinoIcona bollettinoIcona, ServiceContext serviceContext) {

		return getPersistence().update(bollettinoIcona, serviceContext);
	}

	/**
	 * Returns all the bollettino iconas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching bollettino iconas
	 */
	public static List<BollettinoIcona> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the bollettino iconas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @return the range of matching bollettino iconas
	 */
	public static List<BollettinoIcona> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the bollettino iconas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bollettino iconas
	 */
	public static List<BollettinoIcona> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BollettinoIcona> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the bollettino iconas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching bollettino iconas
	 */
	public static List<BollettinoIcona> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BollettinoIcona> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first bollettino icona in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino icona
	 * @throws NoSuchBollettinoIconaException if a matching bollettino icona could not be found
	 */
	public static BollettinoIcona findByUuid_First(
			String uuid, OrderByComparator<BollettinoIcona> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchBollettinoIconaException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first bollettino icona in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino icona, or <code>null</code> if a matching bollettino icona could not be found
	 */
	public static BollettinoIcona fetchByUuid_First(
		String uuid, OrderByComparator<BollettinoIcona> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last bollettino icona in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino icona
	 * @throws NoSuchBollettinoIconaException if a matching bollettino icona could not be found
	 */
	public static BollettinoIcona findByUuid_Last(
			String uuid, OrderByComparator<BollettinoIcona> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchBollettinoIconaException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last bollettino icona in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino icona, or <code>null</code> if a matching bollettino icona could not be found
	 */
	public static BollettinoIcona fetchByUuid_Last(
		String uuid, OrderByComparator<BollettinoIcona> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the bollettino iconas before and after the current bollettino icona in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current bollettino icona
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bollettino icona
	 * @throws NoSuchBollettinoIconaException if a bollettino icona with the primary key could not be found
	 */
	public static BollettinoIcona[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<BollettinoIcona> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchBollettinoIconaException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the bollettino iconas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of bollettino iconas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching bollettino iconas
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the bollettino iconas where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @return the matching bollettino iconas
	 */
	public static List<BollettinoIcona> findByBollettino(long idBollettino) {
		return getPersistence().findByBollettino(idBollettino);
	}

	/**
	 * Returns a range of all the bollettino iconas where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @return the range of matching bollettino iconas
	 */
	public static List<BollettinoIcona> findByBollettino(
		long idBollettino, int start, int end) {

		return getPersistence().findByBollettino(idBollettino, start, end);
	}

	/**
	 * Returns an ordered range of all the bollettino iconas where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bollettino iconas
	 */
	public static List<BollettinoIcona> findByBollettino(
		long idBollettino, int start, int end,
		OrderByComparator<BollettinoIcona> orderByComparator) {

		return getPersistence().findByBollettino(
			idBollettino, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the bollettino iconas where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching bollettino iconas
	 */
	public static List<BollettinoIcona> findByBollettino(
		long idBollettino, int start, int end,
		OrderByComparator<BollettinoIcona> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByBollettino(
			idBollettino, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first bollettino icona in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino icona
	 * @throws NoSuchBollettinoIconaException if a matching bollettino icona could not be found
	 */
	public static BollettinoIcona findByBollettino_First(
			long idBollettino,
			OrderByComparator<BollettinoIcona> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchBollettinoIconaException {

		return getPersistence().findByBollettino_First(
			idBollettino, orderByComparator);
	}

	/**
	 * Returns the first bollettino icona in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino icona, or <code>null</code> if a matching bollettino icona could not be found
	 */
	public static BollettinoIcona fetchByBollettino_First(
		long idBollettino,
		OrderByComparator<BollettinoIcona> orderByComparator) {

		return getPersistence().fetchByBollettino_First(
			idBollettino, orderByComparator);
	}

	/**
	 * Returns the last bollettino icona in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino icona
	 * @throws NoSuchBollettinoIconaException if a matching bollettino icona could not be found
	 */
	public static BollettinoIcona findByBollettino_Last(
			long idBollettino,
			OrderByComparator<BollettinoIcona> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchBollettinoIconaException {

		return getPersistence().findByBollettino_Last(
			idBollettino, orderByComparator);
	}

	/**
	 * Returns the last bollettino icona in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino icona, or <code>null</code> if a matching bollettino icona could not be found
	 */
	public static BollettinoIcona fetchByBollettino_Last(
		long idBollettino,
		OrderByComparator<BollettinoIcona> orderByComparator) {

		return getPersistence().fetchByBollettino_Last(
			idBollettino, orderByComparator);
	}

	/**
	 * Returns the bollettino iconas before and after the current bollettino icona in the ordered set where idBollettino = &#63;.
	 *
	 * @param id the primary key of the current bollettino icona
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bollettino icona
	 * @throws NoSuchBollettinoIconaException if a bollettino icona with the primary key could not be found
	 */
	public static BollettinoIcona[] findByBollettino_PrevAndNext(
			long id, long idBollettino,
			OrderByComparator<BollettinoIcona> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchBollettinoIconaException {

		return getPersistence().findByBollettino_PrevAndNext(
			id, idBollettino, orderByComparator);
	}

	/**
	 * Removes all the bollettino iconas where idBollettino = &#63; from the database.
	 *
	 * @param idBollettino the id bollettino
	 */
	public static void removeByBollettino(long idBollettino) {
		getPersistence().removeByBollettino(idBollettino);
	}

	/**
	 * Returns the number of bollettino iconas where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @return the number of matching bollettino iconas
	 */
	public static int countByBollettino(long idBollettino) {
		return getPersistence().countByBollettino(idBollettino);
	}

	/**
	 * Caches the bollettino icona in the entity cache if it is enabled.
	 *
	 * @param bollettinoIcona the bollettino icona
	 */
	public static void cacheResult(BollettinoIcona bollettinoIcona) {
		getPersistence().cacheResult(bollettinoIcona);
	}

	/**
	 * Caches the bollettino iconas in the entity cache if it is enabled.
	 *
	 * @param bollettinoIconas the bollettino iconas
	 */
	public static void cacheResult(List<BollettinoIcona> bollettinoIconas) {
		getPersistence().cacheResult(bollettinoIconas);
	}

	/**
	 * Creates a new bollettino icona with the primary key. Does not add the bollettino icona to the database.
	 *
	 * @param id the primary key for the new bollettino icona
	 * @return the new bollettino icona
	 */
	public static BollettinoIcona create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the bollettino icona with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the bollettino icona
	 * @return the bollettino icona that was removed
	 * @throws NoSuchBollettinoIconaException if a bollettino icona with the primary key could not be found
	 */
	public static BollettinoIcona remove(long id)
		throws it.eng.bollettino.exception.NoSuchBollettinoIconaException {

		return getPersistence().remove(id);
	}

	public static BollettinoIcona updateImpl(BollettinoIcona bollettinoIcona) {
		return getPersistence().updateImpl(bollettinoIcona);
	}

	/**
	 * Returns the bollettino icona with the primary key or throws a <code>NoSuchBollettinoIconaException</code> if it could not be found.
	 *
	 * @param id the primary key of the bollettino icona
	 * @return the bollettino icona
	 * @throws NoSuchBollettinoIconaException if a bollettino icona with the primary key could not be found
	 */
	public static BollettinoIcona findByPrimaryKey(long id)
		throws it.eng.bollettino.exception.NoSuchBollettinoIconaException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the bollettino icona with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the bollettino icona
	 * @return the bollettino icona, or <code>null</code> if a bollettino icona with the primary key could not be found
	 */
	public static BollettinoIcona fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the bollettino iconas.
	 *
	 * @return the bollettino iconas
	 */
	public static List<BollettinoIcona> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the bollettino iconas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @return the range of bollettino iconas
	 */
	public static List<BollettinoIcona> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the bollettino iconas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bollettino iconas
	 */
	public static List<BollettinoIcona> findAll(
		int start, int end,
		OrderByComparator<BollettinoIcona> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the bollettino iconas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of bollettino iconas
	 */
	public static List<BollettinoIcona> findAll(
		int start, int end,
		OrderByComparator<BollettinoIcona> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the bollettino iconas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of bollettino iconas.
	 *
	 * @return the number of bollettino iconas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static BollettinoIconaPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<BollettinoIconaPersistence, BollettinoIconaPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			BollettinoIconaPersistence.class);

		ServiceTracker<BollettinoIconaPersistence, BollettinoIconaPersistence>
			serviceTracker =
				new ServiceTracker
					<BollettinoIconaPersistence, BollettinoIconaPersistence>(
						bundle.getBundleContext(),
						BollettinoIconaPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}