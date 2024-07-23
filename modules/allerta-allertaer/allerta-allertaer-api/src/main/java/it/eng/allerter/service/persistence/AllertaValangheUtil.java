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

import it.eng.allerter.model.AllertaValanghe;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the allerta valanghe service. This utility wraps <code>it.eng.allerter.service.persistence.impl.AllertaValanghePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see AllertaValanghePersistence
 * @generated
 */
@ProviderType
public class AllertaValangheUtil {

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
	public static void clearCache(AllertaValanghe allertaValanghe) {
		getPersistence().clearCache(allertaValanghe);
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
	public static Map<Serializable, AllertaValanghe> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AllertaValanghe> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AllertaValanghe> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AllertaValanghe> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AllertaValanghe> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AllertaValanghe update(AllertaValanghe allertaValanghe) {
		return getPersistence().update(allertaValanghe);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AllertaValanghe update(
		AllertaValanghe allertaValanghe, ServiceContext serviceContext) {

		return getPersistence().update(allertaValanghe, serviceContext);
	}

	/**
	 * Returns all the allerta valanghes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching allerta valanghes
	 */
	public static List<AllertaValanghe> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the allerta valanghes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @return the range of matching allerta valanghes
	 */
	public static List<AllertaValanghe> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the allerta valanghes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta valanghes
	 */
	public static List<AllertaValanghe> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AllertaValanghe> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the allerta valanghes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching allerta valanghes
	 */
	public static List<AllertaValanghe> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AllertaValanghe> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first allerta valanghe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe
	 * @throws NoSuchAllertaValangheException if a matching allerta valanghe could not be found
	 */
	public static AllertaValanghe findByUuid_First(
			String uuid, OrderByComparator<AllertaValanghe> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaValangheException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first allerta valanghe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe, or <code>null</code> if a matching allerta valanghe could not be found
	 */
	public static AllertaValanghe fetchByUuid_First(
		String uuid, OrderByComparator<AllertaValanghe> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last allerta valanghe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe
	 * @throws NoSuchAllertaValangheException if a matching allerta valanghe could not be found
	 */
	public static AllertaValanghe findByUuid_Last(
			String uuid, OrderByComparator<AllertaValanghe> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaValangheException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last allerta valanghe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe, or <code>null</code> if a matching allerta valanghe could not be found
	 */
	public static AllertaValanghe fetchByUuid_Last(
		String uuid, OrderByComparator<AllertaValanghe> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the allerta valanghes before and after the current allerta valanghe in the ordered set where uuid = &#63;.
	 *
	 * @param allertaValangheId the primary key of the current allerta valanghe
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta valanghe
	 * @throws NoSuchAllertaValangheException if a allerta valanghe with the primary key could not be found
	 */
	public static AllertaValanghe[] findByUuid_PrevAndNext(
			long allertaValangheId, String uuid,
			OrderByComparator<AllertaValanghe> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaValangheException {

		return getPersistence().findByUuid_PrevAndNext(
			allertaValangheId, uuid, orderByComparator);
	}

	/**
	 * Removes all the allerta valanghes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of allerta valanghes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching allerta valanghes
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the allerta valanghe where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAllertaValangheException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allerta valanghe
	 * @throws NoSuchAllertaValangheException if a matching allerta valanghe could not be found
	 */
	public static AllertaValanghe findByUUID_G(String uuid, long groupId)
		throws it.eng.allerter.exception.NoSuchAllertaValangheException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the allerta valanghe where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allerta valanghe, or <code>null</code> if a matching allerta valanghe could not be found
	 */
	public static AllertaValanghe fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the allerta valanghe where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching allerta valanghe, or <code>null</code> if a matching allerta valanghe could not be found
	 */
	public static AllertaValanghe fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	 * Removes the allerta valanghe where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the allerta valanghe that was removed
	 */
	public static AllertaValanghe removeByUUID_G(String uuid, long groupId)
		throws it.eng.allerter.exception.NoSuchAllertaValangheException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of allerta valanghes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching allerta valanghes
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the allerta valanghes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching allerta valanghes
	 */
	public static List<AllertaValanghe> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the allerta valanghes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @return the range of matching allerta valanghes
	 */
	public static List<AllertaValanghe> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the allerta valanghes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta valanghes
	 */
	public static List<AllertaValanghe> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AllertaValanghe> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the allerta valanghes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching allerta valanghes
	 */
	public static List<AllertaValanghe> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AllertaValanghe> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first allerta valanghe in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe
	 * @throws NoSuchAllertaValangheException if a matching allerta valanghe could not be found
	 */
	public static AllertaValanghe findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AllertaValanghe> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaValangheException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first allerta valanghe in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe, or <code>null</code> if a matching allerta valanghe could not be found
	 */
	public static AllertaValanghe fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AllertaValanghe> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last allerta valanghe in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe
	 * @throws NoSuchAllertaValangheException if a matching allerta valanghe could not be found
	 */
	public static AllertaValanghe findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AllertaValanghe> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaValangheException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last allerta valanghe in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe, or <code>null</code> if a matching allerta valanghe could not be found
	 */
	public static AllertaValanghe fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AllertaValanghe> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the allerta valanghes before and after the current allerta valanghe in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param allertaValangheId the primary key of the current allerta valanghe
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta valanghe
	 * @throws NoSuchAllertaValangheException if a allerta valanghe with the primary key could not be found
	 */
	public static AllertaValanghe[] findByUuid_C_PrevAndNext(
			long allertaValangheId, String uuid, long companyId,
			OrderByComparator<AllertaValanghe> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaValangheException {

		return getPersistence().findByUuid_C_PrevAndNext(
			allertaValangheId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the allerta valanghes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of allerta valanghes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching allerta valanghes
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the allerta valanghes where numero = &#63;.
	 *
	 * @param numero the numero
	 * @return the matching allerta valanghes
	 */
	public static List<AllertaValanghe> findByNumero(String numero) {
		return getPersistence().findByNumero(numero);
	}

	/**
	 * Returns a range of all the allerta valanghes where numero = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param numero the numero
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @return the range of matching allerta valanghes
	 */
	public static List<AllertaValanghe> findByNumero(
		String numero, int start, int end) {

		return getPersistence().findByNumero(numero, start, end);
	}

	/**
	 * Returns an ordered range of all the allerta valanghes where numero = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param numero the numero
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta valanghes
	 */
	public static List<AllertaValanghe> findByNumero(
		String numero, int start, int end,
		OrderByComparator<AllertaValanghe> orderByComparator) {

		return getPersistence().findByNumero(
			numero, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the allerta valanghes where numero = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param numero the numero
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching allerta valanghes
	 */
	public static List<AllertaValanghe> findByNumero(
		String numero, int start, int end,
		OrderByComparator<AllertaValanghe> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByNumero(
			numero, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first allerta valanghe in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe
	 * @throws NoSuchAllertaValangheException if a matching allerta valanghe could not be found
	 */
	public static AllertaValanghe findByNumero_First(
			String numero, OrderByComparator<AllertaValanghe> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaValangheException {

		return getPersistence().findByNumero_First(numero, orderByComparator);
	}

	/**
	 * Returns the first allerta valanghe in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe, or <code>null</code> if a matching allerta valanghe could not be found
	 */
	public static AllertaValanghe fetchByNumero_First(
		String numero, OrderByComparator<AllertaValanghe> orderByComparator) {

		return getPersistence().fetchByNumero_First(numero, orderByComparator);
	}

	/**
	 * Returns the last allerta valanghe in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe
	 * @throws NoSuchAllertaValangheException if a matching allerta valanghe could not be found
	 */
	public static AllertaValanghe findByNumero_Last(
			String numero, OrderByComparator<AllertaValanghe> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaValangheException {

		return getPersistence().findByNumero_Last(numero, orderByComparator);
	}

	/**
	 * Returns the last allerta valanghe in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe, or <code>null</code> if a matching allerta valanghe could not be found
	 */
	public static AllertaValanghe fetchByNumero_Last(
		String numero, OrderByComparator<AllertaValanghe> orderByComparator) {

		return getPersistence().fetchByNumero_Last(numero, orderByComparator);
	}

	/**
	 * Returns the allerta valanghes before and after the current allerta valanghe in the ordered set where numero = &#63;.
	 *
	 * @param allertaValangheId the primary key of the current allerta valanghe
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta valanghe
	 * @throws NoSuchAllertaValangheException if a allerta valanghe with the primary key could not be found
	 */
	public static AllertaValanghe[] findByNumero_PrevAndNext(
			long allertaValangheId, String numero,
			OrderByComparator<AllertaValanghe> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaValangheException {

		return getPersistence().findByNumero_PrevAndNext(
			allertaValangheId, numero, orderByComparator);
	}

	/**
	 * Removes all the allerta valanghes where numero = &#63; from the database.
	 *
	 * @param numero the numero
	 */
	public static void removeByNumero(String numero) {
		getPersistence().removeByNumero(numero);
	}

	/**
	 * Returns the number of allerta valanghes where numero = &#63;.
	 *
	 * @param numero the numero
	 * @return the number of matching allerta valanghes
	 */
	public static int countByNumero(String numero) {
		return getPersistence().countByNumero(numero);
	}

	/**
	 * Caches the allerta valanghe in the entity cache if it is enabled.
	 *
	 * @param allertaValanghe the allerta valanghe
	 */
	public static void cacheResult(AllertaValanghe allertaValanghe) {
		getPersistence().cacheResult(allertaValanghe);
	}

	/**
	 * Caches the allerta valanghes in the entity cache if it is enabled.
	 *
	 * @param allertaValanghes the allerta valanghes
	 */
	public static void cacheResult(List<AllertaValanghe> allertaValanghes) {
		getPersistence().cacheResult(allertaValanghes);
	}

	/**
	 * Creates a new allerta valanghe with the primary key. Does not add the allerta valanghe to the database.
	 *
	 * @param allertaValangheId the primary key for the new allerta valanghe
	 * @return the new allerta valanghe
	 */
	public static AllertaValanghe create(long allertaValangheId) {
		return getPersistence().create(allertaValangheId);
	}

	/**
	 * Removes the allerta valanghe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaValangheId the primary key of the allerta valanghe
	 * @return the allerta valanghe that was removed
	 * @throws NoSuchAllertaValangheException if a allerta valanghe with the primary key could not be found
	 */
	public static AllertaValanghe remove(long allertaValangheId)
		throws it.eng.allerter.exception.NoSuchAllertaValangheException {

		return getPersistence().remove(allertaValangheId);
	}

	public static AllertaValanghe updateImpl(AllertaValanghe allertaValanghe) {
		return getPersistence().updateImpl(allertaValanghe);
	}

	/**
	 * Returns the allerta valanghe with the primary key or throws a <code>NoSuchAllertaValangheException</code> if it could not be found.
	 *
	 * @param allertaValangheId the primary key of the allerta valanghe
	 * @return the allerta valanghe
	 * @throws NoSuchAllertaValangheException if a allerta valanghe with the primary key could not be found
	 */
	public static AllertaValanghe findByPrimaryKey(long allertaValangheId)
		throws it.eng.allerter.exception.NoSuchAllertaValangheException {

		return getPersistence().findByPrimaryKey(allertaValangheId);
	}

	/**
	 * Returns the allerta valanghe with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param allertaValangheId the primary key of the allerta valanghe
	 * @return the allerta valanghe, or <code>null</code> if a allerta valanghe with the primary key could not be found
	 */
	public static AllertaValanghe fetchByPrimaryKey(long allertaValangheId) {
		return getPersistence().fetchByPrimaryKey(allertaValangheId);
	}

	/**
	 * Returns all the allerta valanghes.
	 *
	 * @return the allerta valanghes
	 */
	public static List<AllertaValanghe> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the allerta valanghes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @return the range of allerta valanghes
	 */
	public static List<AllertaValanghe> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the allerta valanghes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of allerta valanghes
	 */
	public static List<AllertaValanghe> findAll(
		int start, int end,
		OrderByComparator<AllertaValanghe> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the allerta valanghes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of allerta valanghes
	 */
	public static List<AllertaValanghe> findAll(
		int start, int end,
		OrderByComparator<AllertaValanghe> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the allerta valanghes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of allerta valanghes.
	 *
	 * @return the number of allerta valanghes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static AllertaValanghePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AllertaValanghePersistence, AllertaValanghePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			AllertaValanghePersistence.class);

		ServiceTracker<AllertaValanghePersistence, AllertaValanghePersistence>
			serviceTracker =
				new ServiceTracker
					<AllertaValanghePersistence, AllertaValanghePersistence>(
						bundle.getBundleContext(),
						AllertaValanghePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}