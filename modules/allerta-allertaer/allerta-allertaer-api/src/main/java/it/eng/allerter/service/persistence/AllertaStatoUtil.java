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

package it.eng.allerter.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.allerter.model.AllertaStato;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the allerta stato service. This utility wraps <code>it.eng.allerter.service.persistence.impl.AllertaStatoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see AllertaStatoPersistence
 * @generated
 */
@ProviderType
public class AllertaStatoUtil {

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
	public static void clearCache(AllertaStato allertaStato) {
		getPersistence().clearCache(allertaStato);
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
	public static Map<Serializable, AllertaStato> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AllertaStato> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AllertaStato> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AllertaStato> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AllertaStato> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AllertaStato update(AllertaStato allertaStato) {
		return getPersistence().update(allertaStato);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AllertaStato update(
		AllertaStato allertaStato, ServiceContext serviceContext) {

		return getPersistence().update(allertaStato, serviceContext);
	}

	/**
	 * Returns all the allerta statos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching allerta statos
	 */
	public static List<AllertaStato> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the allerta statos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @return the range of matching allerta statos
	 */
	public static List<AllertaStato> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the allerta statos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta statos
	 */
	public static List<AllertaStato> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AllertaStato> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the allerta statos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching allerta statos
	 */
	public static List<AllertaStato> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AllertaStato> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first allerta stato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta stato
	 * @throws NoSuchAllertaStatoException if a matching allerta stato could not be found
	 */
	public static AllertaStato findByUuid_First(
			String uuid, OrderByComparator<AllertaStato> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaStatoException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first allerta stato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	public static AllertaStato fetchByUuid_First(
		String uuid, OrderByComparator<AllertaStato> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last allerta stato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta stato
	 * @throws NoSuchAllertaStatoException if a matching allerta stato could not be found
	 */
	public static AllertaStato findByUuid_Last(
			String uuid, OrderByComparator<AllertaStato> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaStatoException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last allerta stato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	public static AllertaStato fetchByUuid_Last(
		String uuid, OrderByComparator<AllertaStato> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the allerta statos before and after the current allerta stato in the ordered set where uuid = &#63;.
	 *
	 * @param allertaStatoId the primary key of the current allerta stato
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta stato
	 * @throws NoSuchAllertaStatoException if a allerta stato with the primary key could not be found
	 */
	public static AllertaStato[] findByUuid_PrevAndNext(
			long allertaStatoId, String uuid,
			OrderByComparator<AllertaStato> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaStatoException {

		return getPersistence().findByUuid_PrevAndNext(
			allertaStatoId, uuid, orderByComparator);
	}

	/**
	 * Removes all the allerta statos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of allerta statos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching allerta statos
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the allerta stato where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAllertaStatoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allerta stato
	 * @throws NoSuchAllertaStatoException if a matching allerta stato could not be found
	 */
	public static AllertaStato findByUUID_G(String uuid, long groupId)
		throws it.eng.allerter.exception.NoSuchAllertaStatoException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the allerta stato where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	public static AllertaStato fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the allerta stato where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	public static AllertaStato fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	 * Removes the allerta stato where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the allerta stato that was removed
	 */
	public static AllertaStato removeByUUID_G(String uuid, long groupId)
		throws it.eng.allerter.exception.NoSuchAllertaStatoException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of allerta statos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching allerta statos
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the allerta statos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching allerta statos
	 */
	public static List<AllertaStato> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the allerta statos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @return the range of matching allerta statos
	 */
	public static List<AllertaStato> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the allerta statos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta statos
	 */
	public static List<AllertaStato> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AllertaStato> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the allerta statos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching allerta statos
	 */
	public static List<AllertaStato> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AllertaStato> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first allerta stato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta stato
	 * @throws NoSuchAllertaStatoException if a matching allerta stato could not be found
	 */
	public static AllertaStato findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AllertaStato> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaStatoException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first allerta stato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	public static AllertaStato fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AllertaStato> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last allerta stato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta stato
	 * @throws NoSuchAllertaStatoException if a matching allerta stato could not be found
	 */
	public static AllertaStato findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AllertaStato> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaStatoException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last allerta stato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	public static AllertaStato fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AllertaStato> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the allerta statos before and after the current allerta stato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param allertaStatoId the primary key of the current allerta stato
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta stato
	 * @throws NoSuchAllertaStatoException if a allerta stato with the primary key could not be found
	 */
	public static AllertaStato[] findByUuid_C_PrevAndNext(
			long allertaStatoId, String uuid, long companyId,
			OrderByComparator<AllertaStato> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaStatoException {

		return getPersistence().findByUuid_C_PrevAndNext(
			allertaStatoId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the allerta statos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of allerta statos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching allerta statos
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the allerta statos where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the matching allerta statos
	 */
	public static List<AllertaStato> findByNome(String nome) {
		return getPersistence().findByNome(nome);
	}

	/**
	 * Returns a range of all the allerta statos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @return the range of matching allerta statos
	 */
	public static List<AllertaStato> findByNome(
		String nome, int start, int end) {

		return getPersistence().findByNome(nome, start, end);
	}

	/**
	 * Returns an ordered range of all the allerta statos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta statos
	 */
	public static List<AllertaStato> findByNome(
		String nome, int start, int end,
		OrderByComparator<AllertaStato> orderByComparator) {

		return getPersistence().findByNome(nome, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the allerta statos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching allerta statos
	 */
	public static List<AllertaStato> findByNome(
		String nome, int start, int end,
		OrderByComparator<AllertaStato> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByNome(
			nome, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first allerta stato in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta stato
	 * @throws NoSuchAllertaStatoException if a matching allerta stato could not be found
	 */
	public static AllertaStato findByNome_First(
			String nome, OrderByComparator<AllertaStato> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaStatoException {

		return getPersistence().findByNome_First(nome, orderByComparator);
	}

	/**
	 * Returns the first allerta stato in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	public static AllertaStato fetchByNome_First(
		String nome, OrderByComparator<AllertaStato> orderByComparator) {

		return getPersistence().fetchByNome_First(nome, orderByComparator);
	}

	/**
	 * Returns the last allerta stato in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta stato
	 * @throws NoSuchAllertaStatoException if a matching allerta stato could not be found
	 */
	public static AllertaStato findByNome_Last(
			String nome, OrderByComparator<AllertaStato> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaStatoException {

		return getPersistence().findByNome_Last(nome, orderByComparator);
	}

	/**
	 * Returns the last allerta stato in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	public static AllertaStato fetchByNome_Last(
		String nome, OrderByComparator<AllertaStato> orderByComparator) {

		return getPersistence().fetchByNome_Last(nome, orderByComparator);
	}

	/**
	 * Returns the allerta statos before and after the current allerta stato in the ordered set where nome = &#63;.
	 *
	 * @param allertaStatoId the primary key of the current allerta stato
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta stato
	 * @throws NoSuchAllertaStatoException if a allerta stato with the primary key could not be found
	 */
	public static AllertaStato[] findByNome_PrevAndNext(
			long allertaStatoId, String nome,
			OrderByComparator<AllertaStato> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaStatoException {

		return getPersistence().findByNome_PrevAndNext(
			allertaStatoId, nome, orderByComparator);
	}

	/**
	 * Removes all the allerta statos where nome = &#63; from the database.
	 *
	 * @param nome the nome
	 */
	public static void removeByNome(String nome) {
		getPersistence().removeByNome(nome);
	}

	/**
	 * Returns the number of allerta statos where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the number of matching allerta statos
	 */
	public static int countByNome(String nome) {
		return getPersistence().countByNome(nome);
	}

	/**
	 * Returns all the allerta statos where allertaId = &#63;.
	 *
	 * @param allertaId the allerta ID
	 * @return the matching allerta statos
	 */
	public static List<AllertaStato> findByAllertaId(long allertaId) {
		return getPersistence().findByAllertaId(allertaId);
	}

	/**
	 * Returns a range of all the allerta statos where allertaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param allertaId the allerta ID
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @return the range of matching allerta statos
	 */
	public static List<AllertaStato> findByAllertaId(
		long allertaId, int start, int end) {

		return getPersistence().findByAllertaId(allertaId, start, end);
	}

	/**
	 * Returns an ordered range of all the allerta statos where allertaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param allertaId the allerta ID
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta statos
	 */
	public static List<AllertaStato> findByAllertaId(
		long allertaId, int start, int end,
		OrderByComparator<AllertaStato> orderByComparator) {

		return getPersistence().findByAllertaId(
			allertaId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the allerta statos where allertaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param allertaId the allerta ID
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching allerta statos
	 */
	public static List<AllertaStato> findByAllertaId(
		long allertaId, int start, int end,
		OrderByComparator<AllertaStato> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByAllertaId(
			allertaId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first allerta stato in the ordered set where allertaId = &#63;.
	 *
	 * @param allertaId the allerta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta stato
	 * @throws NoSuchAllertaStatoException if a matching allerta stato could not be found
	 */
	public static AllertaStato findByAllertaId_First(
			long allertaId, OrderByComparator<AllertaStato> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaStatoException {

		return getPersistence().findByAllertaId_First(
			allertaId, orderByComparator);
	}

	/**
	 * Returns the first allerta stato in the ordered set where allertaId = &#63;.
	 *
	 * @param allertaId the allerta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	public static AllertaStato fetchByAllertaId_First(
		long allertaId, OrderByComparator<AllertaStato> orderByComparator) {

		return getPersistence().fetchByAllertaId_First(
			allertaId, orderByComparator);
	}

	/**
	 * Returns the last allerta stato in the ordered set where allertaId = &#63;.
	 *
	 * @param allertaId the allerta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta stato
	 * @throws NoSuchAllertaStatoException if a matching allerta stato could not be found
	 */
	public static AllertaStato findByAllertaId_Last(
			long allertaId, OrderByComparator<AllertaStato> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaStatoException {

		return getPersistence().findByAllertaId_Last(
			allertaId, orderByComparator);
	}

	/**
	 * Returns the last allerta stato in the ordered set where allertaId = &#63;.
	 *
	 * @param allertaId the allerta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	public static AllertaStato fetchByAllertaId_Last(
		long allertaId, OrderByComparator<AllertaStato> orderByComparator) {

		return getPersistence().fetchByAllertaId_Last(
			allertaId, orderByComparator);
	}

	/**
	 * Returns the allerta statos before and after the current allerta stato in the ordered set where allertaId = &#63;.
	 *
	 * @param allertaStatoId the primary key of the current allerta stato
	 * @param allertaId the allerta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta stato
	 * @throws NoSuchAllertaStatoException if a allerta stato with the primary key could not be found
	 */
	public static AllertaStato[] findByAllertaId_PrevAndNext(
			long allertaStatoId, long allertaId,
			OrderByComparator<AllertaStato> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaStatoException {

		return getPersistence().findByAllertaId_PrevAndNext(
			allertaStatoId, allertaId, orderByComparator);
	}

	/**
	 * Removes all the allerta statos where allertaId = &#63; from the database.
	 *
	 * @param allertaId the allerta ID
	 */
	public static void removeByAllertaId(long allertaId) {
		getPersistence().removeByAllertaId(allertaId);
	}

	/**
	 * Returns the number of allerta statos where allertaId = &#63;.
	 *
	 * @param allertaId the allerta ID
	 * @return the number of matching allerta statos
	 */
	public static int countByAllertaId(long allertaId) {
		return getPersistence().countByAllertaId(allertaId);
	}

	/**
	 * Caches the allerta stato in the entity cache if it is enabled.
	 *
	 * @param allertaStato the allerta stato
	 */
	public static void cacheResult(AllertaStato allertaStato) {
		getPersistence().cacheResult(allertaStato);
	}

	/**
	 * Caches the allerta statos in the entity cache if it is enabled.
	 *
	 * @param allertaStatos the allerta statos
	 */
	public static void cacheResult(List<AllertaStato> allertaStatos) {
		getPersistence().cacheResult(allertaStatos);
	}

	/**
	 * Creates a new allerta stato with the primary key. Does not add the allerta stato to the database.
	 *
	 * @param allertaStatoId the primary key for the new allerta stato
	 * @return the new allerta stato
	 */
	public static AllertaStato create(long allertaStatoId) {
		return getPersistence().create(allertaStatoId);
	}

	/**
	 * Removes the allerta stato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaStatoId the primary key of the allerta stato
	 * @return the allerta stato that was removed
	 * @throws NoSuchAllertaStatoException if a allerta stato with the primary key could not be found
	 */
	public static AllertaStato remove(long allertaStatoId)
		throws it.eng.allerter.exception.NoSuchAllertaStatoException {

		return getPersistence().remove(allertaStatoId);
	}

	public static AllertaStato updateImpl(AllertaStato allertaStato) {
		return getPersistence().updateImpl(allertaStato);
	}

	/**
	 * Returns the allerta stato with the primary key or throws a <code>NoSuchAllertaStatoException</code> if it could not be found.
	 *
	 * @param allertaStatoId the primary key of the allerta stato
	 * @return the allerta stato
	 * @throws NoSuchAllertaStatoException if a allerta stato with the primary key could not be found
	 */
	public static AllertaStato findByPrimaryKey(long allertaStatoId)
		throws it.eng.allerter.exception.NoSuchAllertaStatoException {

		return getPersistence().findByPrimaryKey(allertaStatoId);
	}

	/**
	 * Returns the allerta stato with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param allertaStatoId the primary key of the allerta stato
	 * @return the allerta stato, or <code>null</code> if a allerta stato with the primary key could not be found
	 */
	public static AllertaStato fetchByPrimaryKey(long allertaStatoId) {
		return getPersistence().fetchByPrimaryKey(allertaStatoId);
	}

	/**
	 * Returns all the allerta statos.
	 *
	 * @return the allerta statos
	 */
	public static List<AllertaStato> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the allerta statos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @return the range of allerta statos
	 */
	public static List<AllertaStato> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the allerta statos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of allerta statos
	 */
	public static List<AllertaStato> findAll(
		int start, int end, OrderByComparator<AllertaStato> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the allerta statos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of allerta statos
	 */
	public static List<AllertaStato> findAll(
		int start, int end, OrderByComparator<AllertaStato> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the allerta statos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of allerta statos.
	 *
	 * @return the number of allerta statos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static AllertaStatoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AllertaStatoPersistence, AllertaStatoPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AllertaStatoPersistence.class);

		ServiceTracker<AllertaStatoPersistence, AllertaStatoPersistence>
			serviceTracker =
				new ServiceTracker
					<AllertaStatoPersistence, AllertaStatoPersistence>(
						bundle.getBundleContext(),
						AllertaStatoPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}