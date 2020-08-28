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

import it.eng.bollettino.model.RegolaAllarmeComune;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the regola allarme comune service. This utility wraps <code>it.eng.bollettino.service.persistence.impl.RegolaAllarmeComunePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see RegolaAllarmeComunePersistence
 * @generated
 */
@ProviderType
public class RegolaAllarmeComuneUtil {

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
	public static void clearCache(RegolaAllarmeComune regolaAllarmeComune) {
		getPersistence().clearCache(regolaAllarmeComune);
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
	public static Map<Serializable, RegolaAllarmeComune> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RegolaAllarmeComune> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RegolaAllarmeComune> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RegolaAllarmeComune> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RegolaAllarmeComune> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RegolaAllarmeComune update(
		RegolaAllarmeComune regolaAllarmeComune) {

		return getPersistence().update(regolaAllarmeComune);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RegolaAllarmeComune update(
		RegolaAllarmeComune regolaAllarmeComune,
		ServiceContext serviceContext) {

		return getPersistence().update(regolaAllarmeComune, serviceContext);
	}

	/**
	 * Returns all the regola allarme comunes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching regola allarme comunes
	 */
	public static List<RegolaAllarmeComune> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the regola allarme comunes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @return the range of matching regola allarme comunes
	 */
	public static List<RegolaAllarmeComune> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the regola allarme comunes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching regola allarme comunes
	 */
	public static List<RegolaAllarmeComune> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RegolaAllarmeComune> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the regola allarme comunes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching regola allarme comunes
	 */
	public static List<RegolaAllarmeComune> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RegolaAllarmeComune> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first regola allarme comune in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a matching regola allarme comune could not be found
	 */
	public static RegolaAllarmeComune findByUuid_First(
			String uuid,
			OrderByComparator<RegolaAllarmeComune> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchRegolaAllarmeComuneException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first regola allarme comune in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme comune, or <code>null</code> if a matching regola allarme comune could not be found
	 */
	public static RegolaAllarmeComune fetchByUuid_First(
		String uuid, OrderByComparator<RegolaAllarmeComune> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last regola allarme comune in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a matching regola allarme comune could not be found
	 */
	public static RegolaAllarmeComune findByUuid_Last(
			String uuid,
			OrderByComparator<RegolaAllarmeComune> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchRegolaAllarmeComuneException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last regola allarme comune in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme comune, or <code>null</code> if a matching regola allarme comune could not be found
	 */
	public static RegolaAllarmeComune fetchByUuid_Last(
		String uuid, OrderByComparator<RegolaAllarmeComune> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the regola allarme comunes before and after the current regola allarme comune in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current regola allarme comune
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a regola allarme comune with the primary key could not be found
	 */
	public static RegolaAllarmeComune[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<RegolaAllarmeComune> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchRegolaAllarmeComuneException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the regola allarme comunes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of regola allarme comunes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching regola allarme comunes
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the regola allarme comunes where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @return the matching regola allarme comunes
	 */
	public static List<RegolaAllarmeComune> findByRegola(long idRegola) {
		return getPersistence().findByRegola(idRegola);
	}

	/**
	 * Returns a range of all the regola allarme comunes where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @return the range of matching regola allarme comunes
	 */
	public static List<RegolaAllarmeComune> findByRegola(
		long idRegola, int start, int end) {

		return getPersistence().findByRegola(idRegola, start, end);
	}

	/**
	 * Returns an ordered range of all the regola allarme comunes where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching regola allarme comunes
	 */
	public static List<RegolaAllarmeComune> findByRegola(
		long idRegola, int start, int end,
		OrderByComparator<RegolaAllarmeComune> orderByComparator) {

		return getPersistence().findByRegola(
			idRegola, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the regola allarme comunes where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching regola allarme comunes
	 */
	public static List<RegolaAllarmeComune> findByRegola(
		long idRegola, int start, int end,
		OrderByComparator<RegolaAllarmeComune> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByRegola(
			idRegola, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first regola allarme comune in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a matching regola allarme comune could not be found
	 */
	public static RegolaAllarmeComune findByRegola_First(
			long idRegola,
			OrderByComparator<RegolaAllarmeComune> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchRegolaAllarmeComuneException {

		return getPersistence().findByRegola_First(idRegola, orderByComparator);
	}

	/**
	 * Returns the first regola allarme comune in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme comune, or <code>null</code> if a matching regola allarme comune could not be found
	 */
	public static RegolaAllarmeComune fetchByRegola_First(
		long idRegola,
		OrderByComparator<RegolaAllarmeComune> orderByComparator) {

		return getPersistence().fetchByRegola_First(
			idRegola, orderByComparator);
	}

	/**
	 * Returns the last regola allarme comune in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a matching regola allarme comune could not be found
	 */
	public static RegolaAllarmeComune findByRegola_Last(
			long idRegola,
			OrderByComparator<RegolaAllarmeComune> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchRegolaAllarmeComuneException {

		return getPersistence().findByRegola_Last(idRegola, orderByComparator);
	}

	/**
	 * Returns the last regola allarme comune in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme comune, or <code>null</code> if a matching regola allarme comune could not be found
	 */
	public static RegolaAllarmeComune fetchByRegola_Last(
		long idRegola,
		OrderByComparator<RegolaAllarmeComune> orderByComparator) {

		return getPersistence().fetchByRegola_Last(idRegola, orderByComparator);
	}

	/**
	 * Returns the regola allarme comunes before and after the current regola allarme comune in the ordered set where idRegola = &#63;.
	 *
	 * @param id the primary key of the current regola allarme comune
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a regola allarme comune with the primary key could not be found
	 */
	public static RegolaAllarmeComune[] findByRegola_PrevAndNext(
			long id, long idRegola,
			OrderByComparator<RegolaAllarmeComune> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchRegolaAllarmeComuneException {

		return getPersistence().findByRegola_PrevAndNext(
			id, idRegola, orderByComparator);
	}

	/**
	 * Removes all the regola allarme comunes where idRegola = &#63; from the database.
	 *
	 * @param idRegola the id regola
	 */
	public static void removeByRegola(long idRegola) {
		getPersistence().removeByRegola(idRegola);
	}

	/**
	 * Returns the number of regola allarme comunes where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @return the number of matching regola allarme comunes
	 */
	public static int countByRegola(long idRegola) {
		return getPersistence().countByRegola(idRegola);
	}

	/**
	 * Returns all the regola allarme comunes where idComune = &#63;.
	 *
	 * @param idComune the id comune
	 * @return the matching regola allarme comunes
	 */
	public static List<RegolaAllarmeComune> findByComune(long idComune) {
		return getPersistence().findByComune(idComune);
	}

	/**
	 * Returns a range of all the regola allarme comunes where idComune = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idComune the id comune
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @return the range of matching regola allarme comunes
	 */
	public static List<RegolaAllarmeComune> findByComune(
		long idComune, int start, int end) {

		return getPersistence().findByComune(idComune, start, end);
	}

	/**
	 * Returns an ordered range of all the regola allarme comunes where idComune = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idComune the id comune
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching regola allarme comunes
	 */
	public static List<RegolaAllarmeComune> findByComune(
		long idComune, int start, int end,
		OrderByComparator<RegolaAllarmeComune> orderByComparator) {

		return getPersistence().findByComune(
			idComune, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the regola allarme comunes where idComune = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idComune the id comune
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching regola allarme comunes
	 */
	public static List<RegolaAllarmeComune> findByComune(
		long idComune, int start, int end,
		OrderByComparator<RegolaAllarmeComune> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByComune(
			idComune, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first regola allarme comune in the ordered set where idComune = &#63;.
	 *
	 * @param idComune the id comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a matching regola allarme comune could not be found
	 */
	public static RegolaAllarmeComune findByComune_First(
			long idComune,
			OrderByComparator<RegolaAllarmeComune> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchRegolaAllarmeComuneException {

		return getPersistence().findByComune_First(idComune, orderByComparator);
	}

	/**
	 * Returns the first regola allarme comune in the ordered set where idComune = &#63;.
	 *
	 * @param idComune the id comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme comune, or <code>null</code> if a matching regola allarme comune could not be found
	 */
	public static RegolaAllarmeComune fetchByComune_First(
		long idComune,
		OrderByComparator<RegolaAllarmeComune> orderByComparator) {

		return getPersistence().fetchByComune_First(
			idComune, orderByComparator);
	}

	/**
	 * Returns the last regola allarme comune in the ordered set where idComune = &#63;.
	 *
	 * @param idComune the id comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a matching regola allarme comune could not be found
	 */
	public static RegolaAllarmeComune findByComune_Last(
			long idComune,
			OrderByComparator<RegolaAllarmeComune> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchRegolaAllarmeComuneException {

		return getPersistence().findByComune_Last(idComune, orderByComparator);
	}

	/**
	 * Returns the last regola allarme comune in the ordered set where idComune = &#63;.
	 *
	 * @param idComune the id comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme comune, or <code>null</code> if a matching regola allarme comune could not be found
	 */
	public static RegolaAllarmeComune fetchByComune_Last(
		long idComune,
		OrderByComparator<RegolaAllarmeComune> orderByComparator) {

		return getPersistence().fetchByComune_Last(idComune, orderByComparator);
	}

	/**
	 * Returns the regola allarme comunes before and after the current regola allarme comune in the ordered set where idComune = &#63;.
	 *
	 * @param id the primary key of the current regola allarme comune
	 * @param idComune the id comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a regola allarme comune with the primary key could not be found
	 */
	public static RegolaAllarmeComune[] findByComune_PrevAndNext(
			long id, long idComune,
			OrderByComparator<RegolaAllarmeComune> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchRegolaAllarmeComuneException {

		return getPersistence().findByComune_PrevAndNext(
			id, idComune, orderByComparator);
	}

	/**
	 * Removes all the regola allarme comunes where idComune = &#63; from the database.
	 *
	 * @param idComune the id comune
	 */
	public static void removeByComune(long idComune) {
		getPersistence().removeByComune(idComune);
	}

	/**
	 * Returns the number of regola allarme comunes where idComune = &#63;.
	 *
	 * @param idComune the id comune
	 * @return the number of matching regola allarme comunes
	 */
	public static int countByComune(long idComune) {
		return getPersistence().countByComune(idComune);
	}

	/**
	 * Caches the regola allarme comune in the entity cache if it is enabled.
	 *
	 * @param regolaAllarmeComune the regola allarme comune
	 */
	public static void cacheResult(RegolaAllarmeComune regolaAllarmeComune) {
		getPersistence().cacheResult(regolaAllarmeComune);
	}

	/**
	 * Caches the regola allarme comunes in the entity cache if it is enabled.
	 *
	 * @param regolaAllarmeComunes the regola allarme comunes
	 */
	public static void cacheResult(
		List<RegolaAllarmeComune> regolaAllarmeComunes) {

		getPersistence().cacheResult(regolaAllarmeComunes);
	}

	/**
	 * Creates a new regola allarme comune with the primary key. Does not add the regola allarme comune to the database.
	 *
	 * @param id the primary key for the new regola allarme comune
	 * @return the new regola allarme comune
	 */
	public static RegolaAllarmeComune create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the regola allarme comune with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the regola allarme comune
	 * @return the regola allarme comune that was removed
	 * @throws NoSuchRegolaAllarmeComuneException if a regola allarme comune with the primary key could not be found
	 */
	public static RegolaAllarmeComune remove(long id)
		throws it.eng.bollettino.exception.NoSuchRegolaAllarmeComuneException {

		return getPersistence().remove(id);
	}

	public static RegolaAllarmeComune updateImpl(
		RegolaAllarmeComune regolaAllarmeComune) {

		return getPersistence().updateImpl(regolaAllarmeComune);
	}

	/**
	 * Returns the regola allarme comune with the primary key or throws a <code>NoSuchRegolaAllarmeComuneException</code> if it could not be found.
	 *
	 * @param id the primary key of the regola allarme comune
	 * @return the regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a regola allarme comune with the primary key could not be found
	 */
	public static RegolaAllarmeComune findByPrimaryKey(long id)
		throws it.eng.bollettino.exception.NoSuchRegolaAllarmeComuneException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the regola allarme comune with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the regola allarme comune
	 * @return the regola allarme comune, or <code>null</code> if a regola allarme comune with the primary key could not be found
	 */
	public static RegolaAllarmeComune fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the regola allarme comunes.
	 *
	 * @return the regola allarme comunes
	 */
	public static List<RegolaAllarmeComune> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the regola allarme comunes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @return the range of regola allarme comunes
	 */
	public static List<RegolaAllarmeComune> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the regola allarme comunes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of regola allarme comunes
	 */
	public static List<RegolaAllarmeComune> findAll(
		int start, int end,
		OrderByComparator<RegolaAllarmeComune> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the regola allarme comunes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of regola allarme comunes
	 */
	public static List<RegolaAllarmeComune> findAll(
		int start, int end,
		OrderByComparator<RegolaAllarmeComune> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the regola allarme comunes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of regola allarme comunes.
	 *
	 * @return the number of regola allarme comunes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static RegolaAllarmeComunePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RegolaAllarmeComunePersistence, RegolaAllarmeComunePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			RegolaAllarmeComunePersistence.class);

		ServiceTracker
			<RegolaAllarmeComunePersistence, RegolaAllarmeComunePersistence>
				serviceTracker =
					new ServiceTracker
						<RegolaAllarmeComunePersistence,
						 RegolaAllarmeComunePersistence>(
							 bundle.getBundleContext(),
							 RegolaAllarmeComunePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}