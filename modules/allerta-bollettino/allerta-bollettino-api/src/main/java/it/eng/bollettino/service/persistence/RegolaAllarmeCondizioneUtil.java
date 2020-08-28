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

import it.eng.bollettino.model.RegolaAllarmeCondizione;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the regola allarme condizione service. This utility wraps <code>it.eng.bollettino.service.persistence.impl.RegolaAllarmeCondizionePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see RegolaAllarmeCondizionePersistence
 * @generated
 */
@ProviderType
public class RegolaAllarmeCondizioneUtil {

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
	public static void clearCache(
		RegolaAllarmeCondizione regolaAllarmeCondizione) {

		getPersistence().clearCache(regolaAllarmeCondizione);
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
	public static Map<Serializable, RegolaAllarmeCondizione> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RegolaAllarmeCondizione> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RegolaAllarmeCondizione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RegolaAllarmeCondizione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RegolaAllarmeCondizione update(
		RegolaAllarmeCondizione regolaAllarmeCondizione) {

		return getPersistence().update(regolaAllarmeCondizione);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RegolaAllarmeCondizione update(
		RegolaAllarmeCondizione regolaAllarmeCondizione,
		ServiceContext serviceContext) {

		return getPersistence().update(regolaAllarmeCondizione, serviceContext);
	}

	/**
	 * Returns all the regola allarme condiziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching regola allarme condiziones
	 */
	public static List<RegolaAllarmeCondizione> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the regola allarme condiziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @return the range of matching regola allarme condiziones
	 */
	public static List<RegolaAllarmeCondizione> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the regola allarme condiziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching regola allarme condiziones
	 */
	public static List<RegolaAllarmeCondizione> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the regola allarme condiziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching regola allarme condiziones
	 */
	public static List<RegolaAllarmeCondizione> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first regola allarme condizione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme condizione
	 * @throws NoSuchRegolaAllarmeCondizioneException if a matching regola allarme condizione could not be found
	 */
	public static RegolaAllarmeCondizione findByUuid_First(
			String uuid,
			OrderByComparator<RegolaAllarmeCondizione> orderByComparator)
		throws it.eng.bollettino.exception.
			NoSuchRegolaAllarmeCondizioneException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first regola allarme condizione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme condizione, or <code>null</code> if a matching regola allarme condizione could not be found
	 */
	public static RegolaAllarmeCondizione fetchByUuid_First(
		String uuid,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last regola allarme condizione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme condizione
	 * @throws NoSuchRegolaAllarmeCondizioneException if a matching regola allarme condizione could not be found
	 */
	public static RegolaAllarmeCondizione findByUuid_Last(
			String uuid,
			OrderByComparator<RegolaAllarmeCondizione> orderByComparator)
		throws it.eng.bollettino.exception.
			NoSuchRegolaAllarmeCondizioneException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last regola allarme condizione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme condizione, or <code>null</code> if a matching regola allarme condizione could not be found
	 */
	public static RegolaAllarmeCondizione fetchByUuid_Last(
		String uuid,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the regola allarme condiziones before and after the current regola allarme condizione in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current regola allarme condizione
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next regola allarme condizione
	 * @throws NoSuchRegolaAllarmeCondizioneException if a regola allarme condizione with the primary key could not be found
	 */
	public static RegolaAllarmeCondizione[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<RegolaAllarmeCondizione> orderByComparator)
		throws it.eng.bollettino.exception.
			NoSuchRegolaAllarmeCondizioneException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the regola allarme condiziones where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of regola allarme condiziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching regola allarme condiziones
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the regola allarme condiziones where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @return the matching regola allarme condiziones
	 */
	public static List<RegolaAllarmeCondizione> findByRegola(long idRegola) {
		return getPersistence().findByRegola(idRegola);
	}

	/**
	 * Returns a range of all the regola allarme condiziones where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @return the range of matching regola allarme condiziones
	 */
	public static List<RegolaAllarmeCondizione> findByRegola(
		long idRegola, int start, int end) {

		return getPersistence().findByRegola(idRegola, start, end);
	}

	/**
	 * Returns an ordered range of all the regola allarme condiziones where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching regola allarme condiziones
	 */
	public static List<RegolaAllarmeCondizione> findByRegola(
		long idRegola, int start, int end,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator) {

		return getPersistence().findByRegola(
			idRegola, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the regola allarme condiziones where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching regola allarme condiziones
	 */
	public static List<RegolaAllarmeCondizione> findByRegola(
		long idRegola, int start, int end,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByRegola(
			idRegola, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first regola allarme condizione in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme condizione
	 * @throws NoSuchRegolaAllarmeCondizioneException if a matching regola allarme condizione could not be found
	 */
	public static RegolaAllarmeCondizione findByRegola_First(
			long idRegola,
			OrderByComparator<RegolaAllarmeCondizione> orderByComparator)
		throws it.eng.bollettino.exception.
			NoSuchRegolaAllarmeCondizioneException {

		return getPersistence().findByRegola_First(idRegola, orderByComparator);
	}

	/**
	 * Returns the first regola allarme condizione in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme condizione, or <code>null</code> if a matching regola allarme condizione could not be found
	 */
	public static RegolaAllarmeCondizione fetchByRegola_First(
		long idRegola,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator) {

		return getPersistence().fetchByRegola_First(
			idRegola, orderByComparator);
	}

	/**
	 * Returns the last regola allarme condizione in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme condizione
	 * @throws NoSuchRegolaAllarmeCondizioneException if a matching regola allarme condizione could not be found
	 */
	public static RegolaAllarmeCondizione findByRegola_Last(
			long idRegola,
			OrderByComparator<RegolaAllarmeCondizione> orderByComparator)
		throws it.eng.bollettino.exception.
			NoSuchRegolaAllarmeCondizioneException {

		return getPersistence().findByRegola_Last(idRegola, orderByComparator);
	}

	/**
	 * Returns the last regola allarme condizione in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme condizione, or <code>null</code> if a matching regola allarme condizione could not be found
	 */
	public static RegolaAllarmeCondizione fetchByRegola_Last(
		long idRegola,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator) {

		return getPersistence().fetchByRegola_Last(idRegola, orderByComparator);
	}

	/**
	 * Returns the regola allarme condiziones before and after the current regola allarme condizione in the ordered set where idRegola = &#63;.
	 *
	 * @param id the primary key of the current regola allarme condizione
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next regola allarme condizione
	 * @throws NoSuchRegolaAllarmeCondizioneException if a regola allarme condizione with the primary key could not be found
	 */
	public static RegolaAllarmeCondizione[] findByRegola_PrevAndNext(
			long id, long idRegola,
			OrderByComparator<RegolaAllarmeCondizione> orderByComparator)
		throws it.eng.bollettino.exception.
			NoSuchRegolaAllarmeCondizioneException {

		return getPersistence().findByRegola_PrevAndNext(
			id, idRegola, orderByComparator);
	}

	/**
	 * Removes all the regola allarme condiziones where idRegola = &#63; from the database.
	 *
	 * @param idRegola the id regola
	 */
	public static void removeByRegola(long idRegola) {
		getPersistence().removeByRegola(idRegola);
	}

	/**
	 * Returns the number of regola allarme condiziones where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @return the number of matching regola allarme condiziones
	 */
	public static int countByRegola(long idRegola) {
		return getPersistence().countByRegola(idRegola);
	}

	/**
	 * Caches the regola allarme condizione in the entity cache if it is enabled.
	 *
	 * @param regolaAllarmeCondizione the regola allarme condizione
	 */
	public static void cacheResult(
		RegolaAllarmeCondizione regolaAllarmeCondizione) {

		getPersistence().cacheResult(regolaAllarmeCondizione);
	}

	/**
	 * Caches the regola allarme condiziones in the entity cache if it is enabled.
	 *
	 * @param regolaAllarmeCondiziones the regola allarme condiziones
	 */
	public static void cacheResult(
		List<RegolaAllarmeCondizione> regolaAllarmeCondiziones) {

		getPersistence().cacheResult(regolaAllarmeCondiziones);
	}

	/**
	 * Creates a new regola allarme condizione with the primary key. Does not add the regola allarme condizione to the database.
	 *
	 * @param id the primary key for the new regola allarme condizione
	 * @return the new regola allarme condizione
	 */
	public static RegolaAllarmeCondizione create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the regola allarme condizione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the regola allarme condizione
	 * @return the regola allarme condizione that was removed
	 * @throws NoSuchRegolaAllarmeCondizioneException if a regola allarme condizione with the primary key could not be found
	 */
	public static RegolaAllarmeCondizione remove(long id)
		throws it.eng.bollettino.exception.
			NoSuchRegolaAllarmeCondizioneException {

		return getPersistence().remove(id);
	}

	public static RegolaAllarmeCondizione updateImpl(
		RegolaAllarmeCondizione regolaAllarmeCondizione) {

		return getPersistence().updateImpl(regolaAllarmeCondizione);
	}

	/**
	 * Returns the regola allarme condizione with the primary key or throws a <code>NoSuchRegolaAllarmeCondizioneException</code> if it could not be found.
	 *
	 * @param id the primary key of the regola allarme condizione
	 * @return the regola allarme condizione
	 * @throws NoSuchRegolaAllarmeCondizioneException if a regola allarme condizione with the primary key could not be found
	 */
	public static RegolaAllarmeCondizione findByPrimaryKey(long id)
		throws it.eng.bollettino.exception.
			NoSuchRegolaAllarmeCondizioneException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the regola allarme condizione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the regola allarme condizione
	 * @return the regola allarme condizione, or <code>null</code> if a regola allarme condizione with the primary key could not be found
	 */
	public static RegolaAllarmeCondizione fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the regola allarme condiziones.
	 *
	 * @return the regola allarme condiziones
	 */
	public static List<RegolaAllarmeCondizione> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the regola allarme condiziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @return the range of regola allarme condiziones
	 */
	public static List<RegolaAllarmeCondizione> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the regola allarme condiziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of regola allarme condiziones
	 */
	public static List<RegolaAllarmeCondizione> findAll(
		int start, int end,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the regola allarme condiziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of regola allarme condiziones
	 */
	public static List<RegolaAllarmeCondizione> findAll(
		int start, int end,
		OrderByComparator<RegolaAllarmeCondizione> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the regola allarme condiziones from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of regola allarme condiziones.
	 *
	 * @return the number of regola allarme condiziones
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static RegolaAllarmeCondizionePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RegolaAllarmeCondizionePersistence, RegolaAllarmeCondizionePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			RegolaAllarmeCondizionePersistence.class);

		ServiceTracker
			<RegolaAllarmeCondizionePersistence,
			 RegolaAllarmeCondizionePersistence> serviceTracker =
				new ServiceTracker
					<RegolaAllarmeCondizionePersistence,
					 RegolaAllarmeCondizionePersistence>(
						 bundle.getBundleContext(),
						 RegolaAllarmeCondizionePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}