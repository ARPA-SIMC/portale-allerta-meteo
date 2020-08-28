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

import it.eng.bollettino.model.RegolaAllarme;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the regola allarme service. This utility wraps <code>it.eng.bollettino.service.persistence.impl.RegolaAllarmePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see RegolaAllarmePersistence
 * @generated
 */
@ProviderType
public class RegolaAllarmeUtil {

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
	public static void clearCache(RegolaAllarme regolaAllarme) {
		getPersistence().clearCache(regolaAllarme);
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
	public static Map<Serializable, RegolaAllarme> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RegolaAllarme> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RegolaAllarme> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RegolaAllarme> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RegolaAllarme> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RegolaAllarme update(RegolaAllarme regolaAllarme) {
		return getPersistence().update(regolaAllarme);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RegolaAllarme update(
		RegolaAllarme regolaAllarme, ServiceContext serviceContext) {

		return getPersistence().update(regolaAllarme, serviceContext);
	}

	/**
	 * Returns all the regola allarmes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching regola allarmes
	 */
	public static List<RegolaAllarme> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the regola allarmes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @return the range of matching regola allarmes
	 */
	public static List<RegolaAllarme> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the regola allarmes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching regola allarmes
	 */
	public static List<RegolaAllarme> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RegolaAllarme> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the regola allarmes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching regola allarmes
	 */
	public static List<RegolaAllarme> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RegolaAllarme> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first regola allarme in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme
	 * @throws NoSuchRegolaAllarmeException if a matching regola allarme could not be found
	 */
	public static RegolaAllarme findByUuid_First(
			String uuid, OrderByComparator<RegolaAllarme> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchRegolaAllarmeException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first regola allarme in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme, or <code>null</code> if a matching regola allarme could not be found
	 */
	public static RegolaAllarme fetchByUuid_First(
		String uuid, OrderByComparator<RegolaAllarme> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last regola allarme in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme
	 * @throws NoSuchRegolaAllarmeException if a matching regola allarme could not be found
	 */
	public static RegolaAllarme findByUuid_Last(
			String uuid, OrderByComparator<RegolaAllarme> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchRegolaAllarmeException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last regola allarme in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme, or <code>null</code> if a matching regola allarme could not be found
	 */
	public static RegolaAllarme fetchByUuid_Last(
		String uuid, OrderByComparator<RegolaAllarme> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the regola allarmes before and after the current regola allarme in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current regola allarme
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next regola allarme
	 * @throws NoSuchRegolaAllarmeException if a regola allarme with the primary key could not be found
	 */
	public static RegolaAllarme[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<RegolaAllarme> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchRegolaAllarmeException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the regola allarmes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of regola allarmes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching regola allarmes
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the regola allarmes where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @return the matching regola allarmes
	 */
	public static List<RegolaAllarme> findByAttivo(boolean attivo) {
		return getPersistence().findByAttivo(attivo);
	}

	/**
	 * Returns a range of all the regola allarmes where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @return the range of matching regola allarmes
	 */
	public static List<RegolaAllarme> findByAttivo(
		boolean attivo, int start, int end) {

		return getPersistence().findByAttivo(attivo, start, end);
	}

	/**
	 * Returns an ordered range of all the regola allarmes where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching regola allarmes
	 */
	public static List<RegolaAllarme> findByAttivo(
		boolean attivo, int start, int end,
		OrderByComparator<RegolaAllarme> orderByComparator) {

		return getPersistence().findByAttivo(
			attivo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the regola allarmes where attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param attivo the attivo
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching regola allarmes
	 */
	public static List<RegolaAllarme> findByAttivo(
		boolean attivo, int start, int end,
		OrderByComparator<RegolaAllarme> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByAttivo(
			attivo, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first regola allarme in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme
	 * @throws NoSuchRegolaAllarmeException if a matching regola allarme could not be found
	 */
	public static RegolaAllarme findByAttivo_First(
			boolean attivo, OrderByComparator<RegolaAllarme> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchRegolaAllarmeException {

		return getPersistence().findByAttivo_First(attivo, orderByComparator);
	}

	/**
	 * Returns the first regola allarme in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme, or <code>null</code> if a matching regola allarme could not be found
	 */
	public static RegolaAllarme fetchByAttivo_First(
		boolean attivo, OrderByComparator<RegolaAllarme> orderByComparator) {

		return getPersistence().fetchByAttivo_First(attivo, orderByComparator);
	}

	/**
	 * Returns the last regola allarme in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme
	 * @throws NoSuchRegolaAllarmeException if a matching regola allarme could not be found
	 */
	public static RegolaAllarme findByAttivo_Last(
			boolean attivo, OrderByComparator<RegolaAllarme> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchRegolaAllarmeException {

		return getPersistence().findByAttivo_Last(attivo, orderByComparator);
	}

	/**
	 * Returns the last regola allarme in the ordered set where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme, or <code>null</code> if a matching regola allarme could not be found
	 */
	public static RegolaAllarme fetchByAttivo_Last(
		boolean attivo, OrderByComparator<RegolaAllarme> orderByComparator) {

		return getPersistence().fetchByAttivo_Last(attivo, orderByComparator);
	}

	/**
	 * Returns the regola allarmes before and after the current regola allarme in the ordered set where attivo = &#63;.
	 *
	 * @param id the primary key of the current regola allarme
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next regola allarme
	 * @throws NoSuchRegolaAllarmeException if a regola allarme with the primary key could not be found
	 */
	public static RegolaAllarme[] findByAttivo_PrevAndNext(
			long id, boolean attivo,
			OrderByComparator<RegolaAllarme> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchRegolaAllarmeException {

		return getPersistence().findByAttivo_PrevAndNext(
			id, attivo, orderByComparator);
	}

	/**
	 * Removes all the regola allarmes where attivo = &#63; from the database.
	 *
	 * @param attivo the attivo
	 */
	public static void removeByAttivo(boolean attivo) {
		getPersistence().removeByAttivo(attivo);
	}

	/**
	 * Returns the number of regola allarmes where attivo = &#63;.
	 *
	 * @param attivo the attivo
	 * @return the number of matching regola allarmes
	 */
	public static int countByAttivo(boolean attivo) {
		return getPersistence().countByAttivo(attivo);
	}

	/**
	 * Caches the regola allarme in the entity cache if it is enabled.
	 *
	 * @param regolaAllarme the regola allarme
	 */
	public static void cacheResult(RegolaAllarme regolaAllarme) {
		getPersistence().cacheResult(regolaAllarme);
	}

	/**
	 * Caches the regola allarmes in the entity cache if it is enabled.
	 *
	 * @param regolaAllarmes the regola allarmes
	 */
	public static void cacheResult(List<RegolaAllarme> regolaAllarmes) {
		getPersistence().cacheResult(regolaAllarmes);
	}

	/**
	 * Creates a new regola allarme with the primary key. Does not add the regola allarme to the database.
	 *
	 * @param id the primary key for the new regola allarme
	 * @return the new regola allarme
	 */
	public static RegolaAllarme create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the regola allarme with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the regola allarme
	 * @return the regola allarme that was removed
	 * @throws NoSuchRegolaAllarmeException if a regola allarme with the primary key could not be found
	 */
	public static RegolaAllarme remove(long id)
		throws it.eng.bollettino.exception.NoSuchRegolaAllarmeException {

		return getPersistence().remove(id);
	}

	public static RegolaAllarme updateImpl(RegolaAllarme regolaAllarme) {
		return getPersistence().updateImpl(regolaAllarme);
	}

	/**
	 * Returns the regola allarme with the primary key or throws a <code>NoSuchRegolaAllarmeException</code> if it could not be found.
	 *
	 * @param id the primary key of the regola allarme
	 * @return the regola allarme
	 * @throws NoSuchRegolaAllarmeException if a regola allarme with the primary key could not be found
	 */
	public static RegolaAllarme findByPrimaryKey(long id)
		throws it.eng.bollettino.exception.NoSuchRegolaAllarmeException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the regola allarme with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the regola allarme
	 * @return the regola allarme, or <code>null</code> if a regola allarme with the primary key could not be found
	 */
	public static RegolaAllarme fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the regola allarmes.
	 *
	 * @return the regola allarmes
	 */
	public static List<RegolaAllarme> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the regola allarmes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @return the range of regola allarmes
	 */
	public static List<RegolaAllarme> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the regola allarmes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of regola allarmes
	 */
	public static List<RegolaAllarme> findAll(
		int start, int end,
		OrderByComparator<RegolaAllarme> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the regola allarmes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of regola allarmes
	 */
	public static List<RegolaAllarme> findAll(
		int start, int end, OrderByComparator<RegolaAllarme> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the regola allarmes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of regola allarmes.
	 *
	 * @return the number of regola allarmes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static RegolaAllarmePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RegolaAllarmePersistence, RegolaAllarmePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(RegolaAllarmePersistence.class);

		ServiceTracker<RegolaAllarmePersistence, RegolaAllarmePersistence>
			serviceTracker =
				new ServiceTracker
					<RegolaAllarmePersistence, RegolaAllarmePersistence>(
						bundle.getBundleContext(),
						RegolaAllarmePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}