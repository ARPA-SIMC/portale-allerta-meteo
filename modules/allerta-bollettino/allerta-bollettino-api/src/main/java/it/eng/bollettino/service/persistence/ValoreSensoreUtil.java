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

import it.eng.bollettino.model.ValoreSensore;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the valore sensore service. This utility wraps <code>it.eng.bollettino.service.persistence.impl.ValoreSensorePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see ValoreSensorePersistence
 * @generated
 */
@ProviderType
public class ValoreSensoreUtil {

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
	public static void clearCache(ValoreSensore valoreSensore) {
		getPersistence().clearCache(valoreSensore);
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
	public static Map<Serializable, ValoreSensore> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ValoreSensore> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ValoreSensore> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ValoreSensore> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ValoreSensore> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ValoreSensore update(ValoreSensore valoreSensore) {
		return getPersistence().update(valoreSensore);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ValoreSensore update(
		ValoreSensore valoreSensore, ServiceContext serviceContext) {

		return getPersistence().update(valoreSensore, serviceContext);
	}

	/**
	 * Returns all the valore sensores where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching valore sensores
	 */
	public static List<ValoreSensore> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the valore sensores where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @return the range of matching valore sensores
	 */
	public static List<ValoreSensore> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the valore sensores where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching valore sensores
	 */
	public static List<ValoreSensore> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ValoreSensore> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the valore sensores where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching valore sensores
	 */
	public static List<ValoreSensore> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ValoreSensore> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first valore sensore in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching valore sensore
	 * @throws NoSuchValoreSensoreException if a matching valore sensore could not be found
	 */
	public static ValoreSensore findByUuid_First(
			String uuid, OrderByComparator<ValoreSensore> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchValoreSensoreException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first valore sensore in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching valore sensore, or <code>null</code> if a matching valore sensore could not be found
	 */
	public static ValoreSensore fetchByUuid_First(
		String uuid, OrderByComparator<ValoreSensore> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last valore sensore in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching valore sensore
	 * @throws NoSuchValoreSensoreException if a matching valore sensore could not be found
	 */
	public static ValoreSensore findByUuid_Last(
			String uuid, OrderByComparator<ValoreSensore> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchValoreSensoreException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last valore sensore in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching valore sensore, or <code>null</code> if a matching valore sensore could not be found
	 */
	public static ValoreSensore fetchByUuid_Last(
		String uuid, OrderByComparator<ValoreSensore> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the valore sensores before and after the current valore sensore in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current valore sensore
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next valore sensore
	 * @throws NoSuchValoreSensoreException if a valore sensore with the primary key could not be found
	 */
	public static ValoreSensore[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<ValoreSensore> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchValoreSensoreException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the valore sensores where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of valore sensores where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching valore sensores
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the valore sensores where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @return the matching valore sensores
	 */
	public static List<ValoreSensore> findByvariabileStazione(
		String idVariabile, String idStazione) {

		return getPersistence().findByvariabileStazione(
			idVariabile, idStazione);
	}

	/**
	 * Returns a range of all the valore sensores where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @return the range of matching valore sensores
	 */
	public static List<ValoreSensore> findByvariabileStazione(
		String idVariabile, String idStazione, int start, int end) {

		return getPersistence().findByvariabileStazione(
			idVariabile, idStazione, start, end);
	}

	/**
	 * Returns an ordered range of all the valore sensores where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching valore sensores
	 */
	public static List<ValoreSensore> findByvariabileStazione(
		String idVariabile, String idStazione, int start, int end,
		OrderByComparator<ValoreSensore> orderByComparator) {

		return getPersistence().findByvariabileStazione(
			idVariabile, idStazione, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the valore sensores where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching valore sensores
	 */
	public static List<ValoreSensore> findByvariabileStazione(
		String idVariabile, String idStazione, int start, int end,
		OrderByComparator<ValoreSensore> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByvariabileStazione(
			idVariabile, idStazione, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first valore sensore in the ordered set where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching valore sensore
	 * @throws NoSuchValoreSensoreException if a matching valore sensore could not be found
	 */
	public static ValoreSensore findByvariabileStazione_First(
			String idVariabile, String idStazione,
			OrderByComparator<ValoreSensore> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchValoreSensoreException {

		return getPersistence().findByvariabileStazione_First(
			idVariabile, idStazione, orderByComparator);
	}

	/**
	 * Returns the first valore sensore in the ordered set where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching valore sensore, or <code>null</code> if a matching valore sensore could not be found
	 */
	public static ValoreSensore fetchByvariabileStazione_First(
		String idVariabile, String idStazione,
		OrderByComparator<ValoreSensore> orderByComparator) {

		return getPersistence().fetchByvariabileStazione_First(
			idVariabile, idStazione, orderByComparator);
	}

	/**
	 * Returns the last valore sensore in the ordered set where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching valore sensore
	 * @throws NoSuchValoreSensoreException if a matching valore sensore could not be found
	 */
	public static ValoreSensore findByvariabileStazione_Last(
			String idVariabile, String idStazione,
			OrderByComparator<ValoreSensore> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchValoreSensoreException {

		return getPersistence().findByvariabileStazione_Last(
			idVariabile, idStazione, orderByComparator);
	}

	/**
	 * Returns the last valore sensore in the ordered set where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching valore sensore, or <code>null</code> if a matching valore sensore could not be found
	 */
	public static ValoreSensore fetchByvariabileStazione_Last(
		String idVariabile, String idStazione,
		OrderByComparator<ValoreSensore> orderByComparator) {

		return getPersistence().fetchByvariabileStazione_Last(
			idVariabile, idStazione, orderByComparator);
	}

	/**
	 * Returns the valore sensores before and after the current valore sensore in the ordered set where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * @param id the primary key of the current valore sensore
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next valore sensore
	 * @throws NoSuchValoreSensoreException if a valore sensore with the primary key could not be found
	 */
	public static ValoreSensore[] findByvariabileStazione_PrevAndNext(
			long id, String idVariabile, String idStazione,
			OrderByComparator<ValoreSensore> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchValoreSensoreException {

		return getPersistence().findByvariabileStazione_PrevAndNext(
			id, idVariabile, idStazione, orderByComparator);
	}

	/**
	 * Removes all the valore sensores where idVariabile = &#63; and idStazione = &#63; from the database.
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 */
	public static void removeByvariabileStazione(
		String idVariabile, String idStazione) {

		getPersistence().removeByvariabileStazione(idVariabile, idStazione);
	}

	/**
	 * Returns the number of valore sensores where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @return the number of matching valore sensores
	 */
	public static int countByvariabileStazione(
		String idVariabile, String idStazione) {

		return getPersistence().countByvariabileStazione(
			idVariabile, idStazione);
	}

	/**
	 * Caches the valore sensore in the entity cache if it is enabled.
	 *
	 * @param valoreSensore the valore sensore
	 */
	public static void cacheResult(ValoreSensore valoreSensore) {
		getPersistence().cacheResult(valoreSensore);
	}

	/**
	 * Caches the valore sensores in the entity cache if it is enabled.
	 *
	 * @param valoreSensores the valore sensores
	 */
	public static void cacheResult(List<ValoreSensore> valoreSensores) {
		getPersistence().cacheResult(valoreSensores);
	}

	/**
	 * Creates a new valore sensore with the primary key. Does not add the valore sensore to the database.
	 *
	 * @param id the primary key for the new valore sensore
	 * @return the new valore sensore
	 */
	public static ValoreSensore create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the valore sensore with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the valore sensore
	 * @return the valore sensore that was removed
	 * @throws NoSuchValoreSensoreException if a valore sensore with the primary key could not be found
	 */
	public static ValoreSensore remove(long id)
		throws it.eng.bollettino.exception.NoSuchValoreSensoreException {

		return getPersistence().remove(id);
	}

	public static ValoreSensore updateImpl(ValoreSensore valoreSensore) {
		return getPersistence().updateImpl(valoreSensore);
	}

	/**
	 * Returns the valore sensore with the primary key or throws a <code>NoSuchValoreSensoreException</code> if it could not be found.
	 *
	 * @param id the primary key of the valore sensore
	 * @return the valore sensore
	 * @throws NoSuchValoreSensoreException if a valore sensore with the primary key could not be found
	 */
	public static ValoreSensore findByPrimaryKey(long id)
		throws it.eng.bollettino.exception.NoSuchValoreSensoreException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the valore sensore with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the valore sensore
	 * @return the valore sensore, or <code>null</code> if a valore sensore with the primary key could not be found
	 */
	public static ValoreSensore fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the valore sensores.
	 *
	 * @return the valore sensores
	 */
	public static List<ValoreSensore> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the valore sensores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @return the range of valore sensores
	 */
	public static List<ValoreSensore> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the valore sensores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of valore sensores
	 */
	public static List<ValoreSensore> findAll(
		int start, int end,
		OrderByComparator<ValoreSensore> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the valore sensores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of valore sensores
	 */
	public static List<ValoreSensore> findAll(
		int start, int end, OrderByComparator<ValoreSensore> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the valore sensores from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of valore sensores.
	 *
	 * @return the number of valore sensores
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ValoreSensorePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ValoreSensorePersistence, ValoreSensorePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ValoreSensorePersistence.class);

		ServiceTracker<ValoreSensorePersistence, ValoreSensorePersistence>
			serviceTracker =
				new ServiceTracker
					<ValoreSensorePersistence, ValoreSensorePersistence>(
						bundle.getBundleContext(),
						ValoreSensorePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}