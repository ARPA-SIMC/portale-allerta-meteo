/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.allerter.model.AllertaValangheStato;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the allerta valanghe stato service. This utility wraps <code>it.eng.allerter.service.persistence.impl.AllertaValangheStatoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see AllertaValangheStatoPersistence
 * @generated
 */
public class AllertaValangheStatoUtil {

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
	public static void clearCache(AllertaValangheStato allertaValangheStato) {
		getPersistence().clearCache(allertaValangheStato);
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
	public static Map<Serializable, AllertaValangheStato> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AllertaValangheStato> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AllertaValangheStato> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AllertaValangheStato> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AllertaValangheStato> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AllertaValangheStato update(
		AllertaValangheStato allertaValangheStato) {

		return getPersistence().update(allertaValangheStato);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AllertaValangheStato update(
		AllertaValangheStato allertaValangheStato,
		ServiceContext serviceContext) {

		return getPersistence().update(allertaValangheStato, serviceContext);
	}

	/**
	 * Returns all the allerta valanghe statos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching allerta valanghe statos
	 */
	public static List<AllertaValangheStato> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the allerta valanghe statos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @return the range of matching allerta valanghe statos
	 */
	public static List<AllertaValangheStato> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the allerta valanghe statos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta valanghe statos
	 */
	public static List<AllertaValangheStato> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AllertaValangheStato> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the allerta valanghe statos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allerta valanghe statos
	 */
	public static List<AllertaValangheStato> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AllertaValangheStato> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first allerta valanghe stato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a matching allerta valanghe stato could not be found
	 */
	public static AllertaValangheStato findByUuid_First(
			String uuid,
			OrderByComparator<AllertaValangheStato> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaValangheStatoException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first allerta valanghe stato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe stato, or <code>null</code> if a matching allerta valanghe stato could not be found
	 */
	public static AllertaValangheStato fetchByUuid_First(
		String uuid,
		OrderByComparator<AllertaValangheStato> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last allerta valanghe stato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a matching allerta valanghe stato could not be found
	 */
	public static AllertaValangheStato findByUuid_Last(
			String uuid,
			OrderByComparator<AllertaValangheStato> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaValangheStatoException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last allerta valanghe stato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe stato, or <code>null</code> if a matching allerta valanghe stato could not be found
	 */
	public static AllertaValangheStato fetchByUuid_Last(
		String uuid,
		OrderByComparator<AllertaValangheStato> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the allerta valanghe statos before and after the current allerta valanghe stato in the ordered set where uuid = &#63;.
	 *
	 * @param allertaValangheStatoId the primary key of the current allerta valanghe stato
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a allerta valanghe stato with the primary key could not be found
	 */
	public static AllertaValangheStato[] findByUuid_PrevAndNext(
			long allertaValangheStatoId, String uuid,
			OrderByComparator<AllertaValangheStato> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaValangheStatoException {

		return getPersistence().findByUuid_PrevAndNext(
			allertaValangheStatoId, uuid, orderByComparator);
	}

	/**
	 * Removes all the allerta valanghe statos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of allerta valanghe statos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching allerta valanghe statos
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the allerta valanghe stato where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAllertaValangheStatoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a matching allerta valanghe stato could not be found
	 */
	public static AllertaValangheStato findByUUID_G(String uuid, long groupId)
		throws it.eng.allerter.exception.NoSuchAllertaValangheStatoException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the allerta valanghe stato where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allerta valanghe stato, or <code>null</code> if a matching allerta valanghe stato could not be found
	 */
	public static AllertaValangheStato fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the allerta valanghe stato where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching allerta valanghe stato, or <code>null</code> if a matching allerta valanghe stato could not be found
	 */
	public static AllertaValangheStato fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the allerta valanghe stato where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the allerta valanghe stato that was removed
	 */
	public static AllertaValangheStato removeByUUID_G(String uuid, long groupId)
		throws it.eng.allerter.exception.NoSuchAllertaValangheStatoException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of allerta valanghe statos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching allerta valanghe statos
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the allerta valanghe statos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching allerta valanghe statos
	 */
	public static List<AllertaValangheStato> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the allerta valanghe statos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @return the range of matching allerta valanghe statos
	 */
	public static List<AllertaValangheStato> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the allerta valanghe statos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta valanghe statos
	 */
	public static List<AllertaValangheStato> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AllertaValangheStato> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the allerta valanghe statos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allerta valanghe statos
	 */
	public static List<AllertaValangheStato> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AllertaValangheStato> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first allerta valanghe stato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a matching allerta valanghe stato could not be found
	 */
	public static AllertaValangheStato findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AllertaValangheStato> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaValangheStatoException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first allerta valanghe stato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe stato, or <code>null</code> if a matching allerta valanghe stato could not be found
	 */
	public static AllertaValangheStato fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AllertaValangheStato> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last allerta valanghe stato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a matching allerta valanghe stato could not be found
	 */
	public static AllertaValangheStato findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AllertaValangheStato> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaValangheStatoException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last allerta valanghe stato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe stato, or <code>null</code> if a matching allerta valanghe stato could not be found
	 */
	public static AllertaValangheStato fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AllertaValangheStato> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the allerta valanghe statos before and after the current allerta valanghe stato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param allertaValangheStatoId the primary key of the current allerta valanghe stato
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a allerta valanghe stato with the primary key could not be found
	 */
	public static AllertaValangheStato[] findByUuid_C_PrevAndNext(
			long allertaValangheStatoId, String uuid, long companyId,
			OrderByComparator<AllertaValangheStato> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaValangheStatoException {

		return getPersistence().findByUuid_C_PrevAndNext(
			allertaValangheStatoId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the allerta valanghe statos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of allerta valanghe statos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching allerta valanghe statos
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the allerta valanghe statos where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the matching allerta valanghe statos
	 */
	public static List<AllertaValangheStato> findByNome(String nome) {
		return getPersistence().findByNome(nome);
	}

	/**
	 * Returns a range of all the allerta valanghe statos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @return the range of matching allerta valanghe statos
	 */
	public static List<AllertaValangheStato> findByNome(
		String nome, int start, int end) {

		return getPersistence().findByNome(nome, start, end);
	}

	/**
	 * Returns an ordered range of all the allerta valanghe statos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta valanghe statos
	 */
	public static List<AllertaValangheStato> findByNome(
		String nome, int start, int end,
		OrderByComparator<AllertaValangheStato> orderByComparator) {

		return getPersistence().findByNome(nome, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the allerta valanghe statos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allerta valanghe statos
	 */
	public static List<AllertaValangheStato> findByNome(
		String nome, int start, int end,
		OrderByComparator<AllertaValangheStato> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByNome(
			nome, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first allerta valanghe stato in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a matching allerta valanghe stato could not be found
	 */
	public static AllertaValangheStato findByNome_First(
			String nome,
			OrderByComparator<AllertaValangheStato> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaValangheStatoException {

		return getPersistence().findByNome_First(nome, orderByComparator);
	}

	/**
	 * Returns the first allerta valanghe stato in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe stato, or <code>null</code> if a matching allerta valanghe stato could not be found
	 */
	public static AllertaValangheStato fetchByNome_First(
		String nome,
		OrderByComparator<AllertaValangheStato> orderByComparator) {

		return getPersistence().fetchByNome_First(nome, orderByComparator);
	}

	/**
	 * Returns the last allerta valanghe stato in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a matching allerta valanghe stato could not be found
	 */
	public static AllertaValangheStato findByNome_Last(
			String nome,
			OrderByComparator<AllertaValangheStato> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaValangheStatoException {

		return getPersistence().findByNome_Last(nome, orderByComparator);
	}

	/**
	 * Returns the last allerta valanghe stato in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe stato, or <code>null</code> if a matching allerta valanghe stato could not be found
	 */
	public static AllertaValangheStato fetchByNome_Last(
		String nome,
		OrderByComparator<AllertaValangheStato> orderByComparator) {

		return getPersistence().fetchByNome_Last(nome, orderByComparator);
	}

	/**
	 * Returns the allerta valanghe statos before and after the current allerta valanghe stato in the ordered set where nome = &#63;.
	 *
	 * @param allertaValangheStatoId the primary key of the current allerta valanghe stato
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a allerta valanghe stato with the primary key could not be found
	 */
	public static AllertaValangheStato[] findByNome_PrevAndNext(
			long allertaValangheStatoId, String nome,
			OrderByComparator<AllertaValangheStato> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaValangheStatoException {

		return getPersistence().findByNome_PrevAndNext(
			allertaValangheStatoId, nome, orderByComparator);
	}

	/**
	 * Removes all the allerta valanghe statos where nome = &#63; from the database.
	 *
	 * @param nome the nome
	 */
	public static void removeByNome(String nome) {
		getPersistence().removeByNome(nome);
	}

	/**
	 * Returns the number of allerta valanghe statos where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the number of matching allerta valanghe statos
	 */
	public static int countByNome(String nome) {
		return getPersistence().countByNome(nome);
	}

	/**
	 * Returns all the allerta valanghe statos where allertaValangheId = &#63;.
	 *
	 * @param allertaValangheId the allerta valanghe ID
	 * @return the matching allerta valanghe statos
	 */
	public static List<AllertaValangheStato> findByAllertaValangheId(
		long allertaValangheId) {

		return getPersistence().findByAllertaValangheId(allertaValangheId);
	}

	/**
	 * Returns a range of all the allerta valanghe statos where allertaValangheId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>.
	 * </p>
	 *
	 * @param allertaValangheId the allerta valanghe ID
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @return the range of matching allerta valanghe statos
	 */
	public static List<AllertaValangheStato> findByAllertaValangheId(
		long allertaValangheId, int start, int end) {

		return getPersistence().findByAllertaValangheId(
			allertaValangheId, start, end);
	}

	/**
	 * Returns an ordered range of all the allerta valanghe statos where allertaValangheId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>.
	 * </p>
	 *
	 * @param allertaValangheId the allerta valanghe ID
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta valanghe statos
	 */
	public static List<AllertaValangheStato> findByAllertaValangheId(
		long allertaValangheId, int start, int end,
		OrderByComparator<AllertaValangheStato> orderByComparator) {

		return getPersistence().findByAllertaValangheId(
			allertaValangheId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the allerta valanghe statos where allertaValangheId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>.
	 * </p>
	 *
	 * @param allertaValangheId the allerta valanghe ID
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allerta valanghe statos
	 */
	public static List<AllertaValangheStato> findByAllertaValangheId(
		long allertaValangheId, int start, int end,
		OrderByComparator<AllertaValangheStato> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByAllertaValangheId(
			allertaValangheId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first allerta valanghe stato in the ordered set where allertaValangheId = &#63;.
	 *
	 * @param allertaValangheId the allerta valanghe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a matching allerta valanghe stato could not be found
	 */
	public static AllertaValangheStato findByAllertaValangheId_First(
			long allertaValangheId,
			OrderByComparator<AllertaValangheStato> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaValangheStatoException {

		return getPersistence().findByAllertaValangheId_First(
			allertaValangheId, orderByComparator);
	}

	/**
	 * Returns the first allerta valanghe stato in the ordered set where allertaValangheId = &#63;.
	 *
	 * @param allertaValangheId the allerta valanghe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe stato, or <code>null</code> if a matching allerta valanghe stato could not be found
	 */
	public static AllertaValangheStato fetchByAllertaValangheId_First(
		long allertaValangheId,
		OrderByComparator<AllertaValangheStato> orderByComparator) {

		return getPersistence().fetchByAllertaValangheId_First(
			allertaValangheId, orderByComparator);
	}

	/**
	 * Returns the last allerta valanghe stato in the ordered set where allertaValangheId = &#63;.
	 *
	 * @param allertaValangheId the allerta valanghe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a matching allerta valanghe stato could not be found
	 */
	public static AllertaValangheStato findByAllertaValangheId_Last(
			long allertaValangheId,
			OrderByComparator<AllertaValangheStato> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaValangheStatoException {

		return getPersistence().findByAllertaValangheId_Last(
			allertaValangheId, orderByComparator);
	}

	/**
	 * Returns the last allerta valanghe stato in the ordered set where allertaValangheId = &#63;.
	 *
	 * @param allertaValangheId the allerta valanghe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe stato, or <code>null</code> if a matching allerta valanghe stato could not be found
	 */
	public static AllertaValangheStato fetchByAllertaValangheId_Last(
		long allertaValangheId,
		OrderByComparator<AllertaValangheStato> orderByComparator) {

		return getPersistence().fetchByAllertaValangheId_Last(
			allertaValangheId, orderByComparator);
	}

	/**
	 * Returns the allerta valanghe statos before and after the current allerta valanghe stato in the ordered set where allertaValangheId = &#63;.
	 *
	 * @param allertaValangheStatoId the primary key of the current allerta valanghe stato
	 * @param allertaValangheId the allerta valanghe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a allerta valanghe stato with the primary key could not be found
	 */
	public static AllertaValangheStato[] findByAllertaValangheId_PrevAndNext(
			long allertaValangheStatoId, long allertaValangheId,
			OrderByComparator<AllertaValangheStato> orderByComparator)
		throws it.eng.allerter.exception.NoSuchAllertaValangheStatoException {

		return getPersistence().findByAllertaValangheId_PrevAndNext(
			allertaValangheStatoId, allertaValangheId, orderByComparator);
	}

	/**
	 * Removes all the allerta valanghe statos where allertaValangheId = &#63; from the database.
	 *
	 * @param allertaValangheId the allerta valanghe ID
	 */
	public static void removeByAllertaValangheId(long allertaValangheId) {
		getPersistence().removeByAllertaValangheId(allertaValangheId);
	}

	/**
	 * Returns the number of allerta valanghe statos where allertaValangheId = &#63;.
	 *
	 * @param allertaValangheId the allerta valanghe ID
	 * @return the number of matching allerta valanghe statos
	 */
	public static int countByAllertaValangheId(long allertaValangheId) {
		return getPersistence().countByAllertaValangheId(allertaValangheId);
	}

	/**
	 * Caches the allerta valanghe stato in the entity cache if it is enabled.
	 *
	 * @param allertaValangheStato the allerta valanghe stato
	 */
	public static void cacheResult(AllertaValangheStato allertaValangheStato) {
		getPersistence().cacheResult(allertaValangheStato);
	}

	/**
	 * Caches the allerta valanghe statos in the entity cache if it is enabled.
	 *
	 * @param allertaValangheStatos the allerta valanghe statos
	 */
	public static void cacheResult(
		List<AllertaValangheStato> allertaValangheStatos) {

		getPersistence().cacheResult(allertaValangheStatos);
	}

	/**
	 * Creates a new allerta valanghe stato with the primary key. Does not add the allerta valanghe stato to the database.
	 *
	 * @param allertaValangheStatoId the primary key for the new allerta valanghe stato
	 * @return the new allerta valanghe stato
	 */
	public static AllertaValangheStato create(long allertaValangheStatoId) {
		return getPersistence().create(allertaValangheStatoId);
	}

	/**
	 * Removes the allerta valanghe stato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaValangheStatoId the primary key of the allerta valanghe stato
	 * @return the allerta valanghe stato that was removed
	 * @throws NoSuchAllertaValangheStatoException if a allerta valanghe stato with the primary key could not be found
	 */
	public static AllertaValangheStato remove(long allertaValangheStatoId)
		throws it.eng.allerter.exception.NoSuchAllertaValangheStatoException {

		return getPersistence().remove(allertaValangheStatoId);
	}

	public static AllertaValangheStato updateImpl(
		AllertaValangheStato allertaValangheStato) {

		return getPersistence().updateImpl(allertaValangheStato);
	}

	/**
	 * Returns the allerta valanghe stato with the primary key or throws a <code>NoSuchAllertaValangheStatoException</code> if it could not be found.
	 *
	 * @param allertaValangheStatoId the primary key of the allerta valanghe stato
	 * @return the allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a allerta valanghe stato with the primary key could not be found
	 */
	public static AllertaValangheStato findByPrimaryKey(
			long allertaValangheStatoId)
		throws it.eng.allerter.exception.NoSuchAllertaValangheStatoException {

		return getPersistence().findByPrimaryKey(allertaValangheStatoId);
	}

	/**
	 * Returns the allerta valanghe stato with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param allertaValangheStatoId the primary key of the allerta valanghe stato
	 * @return the allerta valanghe stato, or <code>null</code> if a allerta valanghe stato with the primary key could not be found
	 */
	public static AllertaValangheStato fetchByPrimaryKey(
		long allertaValangheStatoId) {

		return getPersistence().fetchByPrimaryKey(allertaValangheStatoId);
	}

	/**
	 * Returns all the allerta valanghe statos.
	 *
	 * @return the allerta valanghe statos
	 */
	public static List<AllertaValangheStato> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the allerta valanghe statos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @return the range of allerta valanghe statos
	 */
	public static List<AllertaValangheStato> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the allerta valanghe statos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of allerta valanghe statos
	 */
	public static List<AllertaValangheStato> findAll(
		int start, int end,
		OrderByComparator<AllertaValangheStato> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the allerta valanghe statos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of allerta valanghe statos
	 */
	public static List<AllertaValangheStato> findAll(
		int start, int end,
		OrderByComparator<AllertaValangheStato> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the allerta valanghe statos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of allerta valanghe statos.
	 *
	 * @return the number of allerta valanghe statos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AllertaValangheStatoPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		AllertaValangheStatoPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile AllertaValangheStatoPersistence _persistence;

}