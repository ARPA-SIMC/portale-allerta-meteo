/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.allerter.model.Area;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the area service. This utility wraps <code>it.eng.allerter.service.persistence.impl.AreaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see AreaPersistence
 * @generated
 */
public class AreaUtil {

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
	public static void clearCache(Area area) {
		getPersistence().clearCache(area);
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
	public static Map<Serializable, Area> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Area> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Area> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Area> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Area> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Area update(Area area) {
		return getPersistence().update(area);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Area update(Area area, ServiceContext serviceContext) {
		return getPersistence().update(area, serviceContext);
	}

	/**
	 * Returns all the areas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching areas
	 */
	public static List<Area> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the areas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @return the range of matching areas
	 */
	public static List<Area> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the areas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching areas
	 */
	public static List<Area> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Area> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the areas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching areas
	 */
	public static List<Area> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Area> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first area in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area
	 * @throws NoSuchAreaException if a matching area could not be found
	 */
	public static Area findByUuid_First(
			String uuid, OrderByComparator<Area> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAreaException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first area in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area, or <code>null</code> if a matching area could not be found
	 */
	public static Area fetchByUuid_First(
		String uuid, OrderByComparator<Area> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last area in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area
	 * @throws NoSuchAreaException if a matching area could not be found
	 */
	public static Area findByUuid_Last(
			String uuid, OrderByComparator<Area> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAreaException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last area in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area, or <code>null</code> if a matching area could not be found
	 */
	public static Area fetchByUuid_Last(
		String uuid, OrderByComparator<Area> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the areas before and after the current area in the ordered set where uuid = &#63;.
	 *
	 * @param areaId the primary key of the current area
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next area
	 * @throws NoSuchAreaException if a area with the primary key could not be found
	 */
	public static Area[] findByUuid_PrevAndNext(
			long areaId, String uuid, OrderByComparator<Area> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAreaException {

		return getPersistence().findByUuid_PrevAndNext(
			areaId, uuid, orderByComparator);
	}

	/**
	 * Removes all the areas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of areas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching areas
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the area where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAreaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching area
	 * @throws NoSuchAreaException if a matching area could not be found
	 */
	public static Area findByUUID_G(String uuid, long groupId)
		throws it.eng.allerter.exception.NoSuchAreaException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the area where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching area, or <code>null</code> if a matching area could not be found
	 */
	public static Area fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the area where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching area, or <code>null</code> if a matching area could not be found
	 */
	public static Area fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the area where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the area that was removed
	 */
	public static Area removeByUUID_G(String uuid, long groupId)
		throws it.eng.allerter.exception.NoSuchAreaException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of areas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching areas
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the areas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching areas
	 */
	public static List<Area> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the areas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @return the range of matching areas
	 */
	public static List<Area> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the areas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching areas
	 */
	public static List<Area> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Area> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the areas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching areas
	 */
	public static List<Area> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Area> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first area in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area
	 * @throws NoSuchAreaException if a matching area could not be found
	 */
	public static Area findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Area> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAreaException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first area in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area, or <code>null</code> if a matching area could not be found
	 */
	public static Area fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Area> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last area in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area
	 * @throws NoSuchAreaException if a matching area could not be found
	 */
	public static Area findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Area> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAreaException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last area in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area, or <code>null</code> if a matching area could not be found
	 */
	public static Area fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Area> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the areas before and after the current area in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param areaId the primary key of the current area
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next area
	 * @throws NoSuchAreaException if a area with the primary key could not be found
	 */
	public static Area[] findByUuid_C_PrevAndNext(
			long areaId, String uuid, long companyId,
			OrderByComparator<Area> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAreaException {

		return getPersistence().findByUuid_C_PrevAndNext(
			areaId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the areas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of areas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching areas
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the areas where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the matching areas
	 */
	public static List<Area> findByNome(String nome) {
		return getPersistence().findByNome(nome);
	}

	/**
	 * Returns a range of all the areas where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @return the range of matching areas
	 */
	public static List<Area> findByNome(String nome, int start, int end) {
		return getPersistence().findByNome(nome, start, end);
	}

	/**
	 * Returns an ordered range of all the areas where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching areas
	 */
	public static List<Area> findByNome(
		String nome, int start, int end,
		OrderByComparator<Area> orderByComparator) {

		return getPersistence().findByNome(nome, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the areas where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching areas
	 */
	public static List<Area> findByNome(
		String nome, int start, int end,
		OrderByComparator<Area> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByNome(
			nome, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first area in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area
	 * @throws NoSuchAreaException if a matching area could not be found
	 */
	public static Area findByNome_First(
			String nome, OrderByComparator<Area> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAreaException {

		return getPersistence().findByNome_First(nome, orderByComparator);
	}

	/**
	 * Returns the first area in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area, or <code>null</code> if a matching area could not be found
	 */
	public static Area fetchByNome_First(
		String nome, OrderByComparator<Area> orderByComparator) {

		return getPersistence().fetchByNome_First(nome, orderByComparator);
	}

	/**
	 * Returns the last area in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area
	 * @throws NoSuchAreaException if a matching area could not be found
	 */
	public static Area findByNome_Last(
			String nome, OrderByComparator<Area> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAreaException {

		return getPersistence().findByNome_Last(nome, orderByComparator);
	}

	/**
	 * Returns the last area in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area, or <code>null</code> if a matching area could not be found
	 */
	public static Area fetchByNome_Last(
		String nome, OrderByComparator<Area> orderByComparator) {

		return getPersistence().fetchByNome_Last(nome, orderByComparator);
	}

	/**
	 * Returns the areas before and after the current area in the ordered set where nome = &#63;.
	 *
	 * @param areaId the primary key of the current area
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next area
	 * @throws NoSuchAreaException if a area with the primary key could not be found
	 */
	public static Area[] findByNome_PrevAndNext(
			long areaId, String nome, OrderByComparator<Area> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAreaException {

		return getPersistence().findByNome_PrevAndNext(
			areaId, nome, orderByComparator);
	}

	/**
	 * Removes all the areas where nome = &#63; from the database.
	 *
	 * @param nome the nome
	 */
	public static void removeByNome(String nome) {
		getPersistence().removeByNome(nome);
	}

	/**
	 * Returns the number of areas where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the number of matching areas
	 */
	public static int countByNome(String nome) {
		return getPersistence().countByNome(nome);
	}

	/**
	 * Returns all the areas where tipoArea = &#63;.
	 *
	 * @param tipoArea the tipo area
	 * @return the matching areas
	 */
	public static List<Area> findByTipoArea(String tipoArea) {
		return getPersistence().findByTipoArea(tipoArea);
	}

	/**
	 * Returns a range of all the areas where tipoArea = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param tipoArea the tipo area
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @return the range of matching areas
	 */
	public static List<Area> findByTipoArea(
		String tipoArea, int start, int end) {

		return getPersistence().findByTipoArea(tipoArea, start, end);
	}

	/**
	 * Returns an ordered range of all the areas where tipoArea = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param tipoArea the tipo area
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching areas
	 */
	public static List<Area> findByTipoArea(
		String tipoArea, int start, int end,
		OrderByComparator<Area> orderByComparator) {

		return getPersistence().findByTipoArea(
			tipoArea, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the areas where tipoArea = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param tipoArea the tipo area
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching areas
	 */
	public static List<Area> findByTipoArea(
		String tipoArea, int start, int end,
		OrderByComparator<Area> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByTipoArea(
			tipoArea, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first area in the ordered set where tipoArea = &#63;.
	 *
	 * @param tipoArea the tipo area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area
	 * @throws NoSuchAreaException if a matching area could not be found
	 */
	public static Area findByTipoArea_First(
			String tipoArea, OrderByComparator<Area> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAreaException {

		return getPersistence().findByTipoArea_First(
			tipoArea, orderByComparator);
	}

	/**
	 * Returns the first area in the ordered set where tipoArea = &#63;.
	 *
	 * @param tipoArea the tipo area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area, or <code>null</code> if a matching area could not be found
	 */
	public static Area fetchByTipoArea_First(
		String tipoArea, OrderByComparator<Area> orderByComparator) {

		return getPersistence().fetchByTipoArea_First(
			tipoArea, orderByComparator);
	}

	/**
	 * Returns the last area in the ordered set where tipoArea = &#63;.
	 *
	 * @param tipoArea the tipo area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area
	 * @throws NoSuchAreaException if a matching area could not be found
	 */
	public static Area findByTipoArea_Last(
			String tipoArea, OrderByComparator<Area> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAreaException {

		return getPersistence().findByTipoArea_Last(
			tipoArea, orderByComparator);
	}

	/**
	 * Returns the last area in the ordered set where tipoArea = &#63;.
	 *
	 * @param tipoArea the tipo area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area, or <code>null</code> if a matching area could not be found
	 */
	public static Area fetchByTipoArea_Last(
		String tipoArea, OrderByComparator<Area> orderByComparator) {

		return getPersistence().fetchByTipoArea_Last(
			tipoArea, orderByComparator);
	}

	/**
	 * Returns the areas before and after the current area in the ordered set where tipoArea = &#63;.
	 *
	 * @param areaId the primary key of the current area
	 * @param tipoArea the tipo area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next area
	 * @throws NoSuchAreaException if a area with the primary key could not be found
	 */
	public static Area[] findByTipoArea_PrevAndNext(
			long areaId, String tipoArea,
			OrderByComparator<Area> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAreaException {

		return getPersistence().findByTipoArea_PrevAndNext(
			areaId, tipoArea, orderByComparator);
	}

	/**
	 * Removes all the areas where tipoArea = &#63; from the database.
	 *
	 * @param tipoArea the tipo area
	 */
	public static void removeByTipoArea(String tipoArea) {
		getPersistence().removeByTipoArea(tipoArea);
	}

	/**
	 * Returns the number of areas where tipoArea = &#63;.
	 *
	 * @param tipoArea the tipo area
	 * @return the number of matching areas
	 */
	public static int countByTipoArea(String tipoArea) {
		return getPersistence().countByTipoArea(tipoArea);
	}

	/**
	 * Caches the area in the entity cache if it is enabled.
	 *
	 * @param area the area
	 */
	public static void cacheResult(Area area) {
		getPersistence().cacheResult(area);
	}

	/**
	 * Caches the areas in the entity cache if it is enabled.
	 *
	 * @param areas the areas
	 */
	public static void cacheResult(List<Area> areas) {
		getPersistence().cacheResult(areas);
	}

	/**
	 * Creates a new area with the primary key. Does not add the area to the database.
	 *
	 * @param areaId the primary key for the new area
	 * @return the new area
	 */
	public static Area create(long areaId) {
		return getPersistence().create(areaId);
	}

	/**
	 * Removes the area with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param areaId the primary key of the area
	 * @return the area that was removed
	 * @throws NoSuchAreaException if a area with the primary key could not be found
	 */
	public static Area remove(long areaId)
		throws it.eng.allerter.exception.NoSuchAreaException {

		return getPersistence().remove(areaId);
	}

	public static Area updateImpl(Area area) {
		return getPersistence().updateImpl(area);
	}

	/**
	 * Returns the area with the primary key or throws a <code>NoSuchAreaException</code> if it could not be found.
	 *
	 * @param areaId the primary key of the area
	 * @return the area
	 * @throws NoSuchAreaException if a area with the primary key could not be found
	 */
	public static Area findByPrimaryKey(long areaId)
		throws it.eng.allerter.exception.NoSuchAreaException {

		return getPersistence().findByPrimaryKey(areaId);
	}

	/**
	 * Returns the area with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param areaId the primary key of the area
	 * @return the area, or <code>null</code> if a area with the primary key could not be found
	 */
	public static Area fetchByPrimaryKey(long areaId) {
		return getPersistence().fetchByPrimaryKey(areaId);
	}

	/**
	 * Returns all the areas.
	 *
	 * @return the areas
	 */
	public static List<Area> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @return the range of areas
	 */
	public static List<Area> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of areas
	 */
	public static List<Area> findAll(
		int start, int end, OrderByComparator<Area> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of areas
	 */
	public static List<Area> findAll(
		int start, int end, OrderByComparator<Area> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the areas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of areas.
	 *
	 * @return the number of areas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AreaPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(AreaPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile AreaPersistence _persistence;

}