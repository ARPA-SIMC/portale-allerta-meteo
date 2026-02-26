/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.bollettino.model.Allarme;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the allarme service. This utility wraps <code>it.eng.bollettino.service.persistence.impl.AllarmePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see AllarmePersistence
 * @generated
 */
public class AllarmeUtil {

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
	public static void clearCache(Allarme allarme) {
		getPersistence().clearCache(allarme);
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
	public static Map<Serializable, Allarme> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Allarme> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Allarme> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Allarme> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Allarme> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Allarme update(Allarme allarme) {
		return getPersistence().update(allarme);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Allarme update(
		Allarme allarme, ServiceContext serviceContext) {

		return getPersistence().update(allarme, serviceContext);
	}

	/**
	 * Returns all the allarmes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching allarmes
	 */
	public static List<Allarme> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the allarmes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @return the range of matching allarmes
	 */
	public static List<Allarme> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the allarmes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allarmes
	 */
	public static List<Allarme> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Allarme> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the allarmes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allarmes
	 */
	public static List<Allarme> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Allarme> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first allarme in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allarme
	 * @throws NoSuchAllarmeException if a matching allarme could not be found
	 */
	public static Allarme findByUuid_First(
			String uuid, OrderByComparator<Allarme> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchAllarmeException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first allarme in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allarme, or <code>null</code> if a matching allarme could not be found
	 */
	public static Allarme fetchByUuid_First(
		String uuid, OrderByComparator<Allarme> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last allarme in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allarme
	 * @throws NoSuchAllarmeException if a matching allarme could not be found
	 */
	public static Allarme findByUuid_Last(
			String uuid, OrderByComparator<Allarme> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchAllarmeException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last allarme in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allarme, or <code>null</code> if a matching allarme could not be found
	 */
	public static Allarme fetchByUuid_Last(
		String uuid, OrderByComparator<Allarme> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the allarmes before and after the current allarme in the ordered set where uuid = &#63;.
	 *
	 * @param allarmeId the primary key of the current allarme
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allarme
	 * @throws NoSuchAllarmeException if a allarme with the primary key could not be found
	 */
	public static Allarme[] findByUuid_PrevAndNext(
			long allarmeId, String uuid,
			OrderByComparator<Allarme> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchAllarmeException {

		return getPersistence().findByUuid_PrevAndNext(
			allarmeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the allarmes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of allarmes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching allarmes
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the allarme where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAllarmeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allarme
	 * @throws NoSuchAllarmeException if a matching allarme could not be found
	 */
	public static Allarme findByUUID_G(String uuid, long groupId)
		throws it.eng.bollettino.exception.NoSuchAllarmeException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the allarme where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allarme, or <code>null</code> if a matching allarme could not be found
	 */
	public static Allarme fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the allarme where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching allarme, or <code>null</code> if a matching allarme could not be found
	 */
	public static Allarme fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the allarme where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the allarme that was removed
	 */
	public static Allarme removeByUUID_G(String uuid, long groupId)
		throws it.eng.bollettino.exception.NoSuchAllarmeException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of allarmes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching allarmes
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the allarmes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching allarmes
	 */
	public static List<Allarme> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the allarmes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @return the range of matching allarmes
	 */
	public static List<Allarme> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the allarmes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allarmes
	 */
	public static List<Allarme> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Allarme> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the allarmes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allarmes
	 */
	public static List<Allarme> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Allarme> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first allarme in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allarme
	 * @throws NoSuchAllarmeException if a matching allarme could not be found
	 */
	public static Allarme findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Allarme> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchAllarmeException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first allarme in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allarme, or <code>null</code> if a matching allarme could not be found
	 */
	public static Allarme fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Allarme> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last allarme in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allarme
	 * @throws NoSuchAllarmeException if a matching allarme could not be found
	 */
	public static Allarme findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Allarme> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchAllarmeException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last allarme in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allarme, or <code>null</code> if a matching allarme could not be found
	 */
	public static Allarme fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Allarme> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the allarmes before and after the current allarme in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param allarmeId the primary key of the current allarme
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allarme
	 * @throws NoSuchAllarmeException if a allarme with the primary key could not be found
	 */
	public static Allarme[] findByUuid_C_PrevAndNext(
			long allarmeId, String uuid, long companyId,
			OrderByComparator<Allarme> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchAllarmeException {

		return getPersistence().findByUuid_C_PrevAndNext(
			allarmeId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the allarmes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of allarmes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching allarmes
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the allarmes where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @return the matching allarmes
	 */
	public static List<Allarme> findByRegola(long idRegola) {
		return getPersistence().findByRegola(idRegola);
	}

	/**
	 * Returns a range of all the allarmes where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @return the range of matching allarmes
	 */
	public static List<Allarme> findByRegola(
		long idRegola, int start, int end) {

		return getPersistence().findByRegola(idRegola, start, end);
	}

	/**
	 * Returns an ordered range of all the allarmes where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allarmes
	 */
	public static List<Allarme> findByRegola(
		long idRegola, int start, int end,
		OrderByComparator<Allarme> orderByComparator) {

		return getPersistence().findByRegola(
			idRegola, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the allarmes where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching allarmes
	 */
	public static List<Allarme> findByRegola(
		long idRegola, int start, int end,
		OrderByComparator<Allarme> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByRegola(
			idRegola, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first allarme in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allarme
	 * @throws NoSuchAllarmeException if a matching allarme could not be found
	 */
	public static Allarme findByRegola_First(
			long idRegola, OrderByComparator<Allarme> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchAllarmeException {

		return getPersistence().findByRegola_First(idRegola, orderByComparator);
	}

	/**
	 * Returns the first allarme in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allarme, or <code>null</code> if a matching allarme could not be found
	 */
	public static Allarme fetchByRegola_First(
		long idRegola, OrderByComparator<Allarme> orderByComparator) {

		return getPersistence().fetchByRegola_First(
			idRegola, orderByComparator);
	}

	/**
	 * Returns the last allarme in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allarme
	 * @throws NoSuchAllarmeException if a matching allarme could not be found
	 */
	public static Allarme findByRegola_Last(
			long idRegola, OrderByComparator<Allarme> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchAllarmeException {

		return getPersistence().findByRegola_Last(idRegola, orderByComparator);
	}

	/**
	 * Returns the last allarme in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allarme, or <code>null</code> if a matching allarme could not be found
	 */
	public static Allarme fetchByRegola_Last(
		long idRegola, OrderByComparator<Allarme> orderByComparator) {

		return getPersistence().fetchByRegola_Last(idRegola, orderByComparator);
	}

	/**
	 * Returns the allarmes before and after the current allarme in the ordered set where idRegola = &#63;.
	 *
	 * @param allarmeId the primary key of the current allarme
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allarme
	 * @throws NoSuchAllarmeException if a allarme with the primary key could not be found
	 */
	public static Allarme[] findByRegola_PrevAndNext(
			long allarmeId, long idRegola,
			OrderByComparator<Allarme> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchAllarmeException {

		return getPersistence().findByRegola_PrevAndNext(
			allarmeId, idRegola, orderByComparator);
	}

	/**
	 * Removes all the allarmes where idRegola = &#63; from the database.
	 *
	 * @param idRegola the id regola
	 */
	public static void removeByRegola(long idRegola) {
		getPersistence().removeByRegola(idRegola);
	}

	/**
	 * Returns the number of allarmes where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @return the number of matching allarmes
	 */
	public static int countByRegola(long idRegola) {
		return getPersistence().countByRegola(idRegola);
	}

	/**
	 * Caches the allarme in the entity cache if it is enabled.
	 *
	 * @param allarme the allarme
	 */
	public static void cacheResult(Allarme allarme) {
		getPersistence().cacheResult(allarme);
	}

	/**
	 * Caches the allarmes in the entity cache if it is enabled.
	 *
	 * @param allarmes the allarmes
	 */
	public static void cacheResult(List<Allarme> allarmes) {
		getPersistence().cacheResult(allarmes);
	}

	/**
	 * Creates a new allarme with the primary key. Does not add the allarme to the database.
	 *
	 * @param allarmeId the primary key for the new allarme
	 * @return the new allarme
	 */
	public static Allarme create(long allarmeId) {
		return getPersistence().create(allarmeId);
	}

	/**
	 * Removes the allarme with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allarmeId the primary key of the allarme
	 * @return the allarme that was removed
	 * @throws NoSuchAllarmeException if a allarme with the primary key could not be found
	 */
	public static Allarme remove(long allarmeId)
		throws it.eng.bollettino.exception.NoSuchAllarmeException {

		return getPersistence().remove(allarmeId);
	}

	public static Allarme updateImpl(Allarme allarme) {
		return getPersistence().updateImpl(allarme);
	}

	/**
	 * Returns the allarme with the primary key or throws a <code>NoSuchAllarmeException</code> if it could not be found.
	 *
	 * @param allarmeId the primary key of the allarme
	 * @return the allarme
	 * @throws NoSuchAllarmeException if a allarme with the primary key could not be found
	 */
	public static Allarme findByPrimaryKey(long allarmeId)
		throws it.eng.bollettino.exception.NoSuchAllarmeException {

		return getPersistence().findByPrimaryKey(allarmeId);
	}

	/**
	 * Returns the allarme with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param allarmeId the primary key of the allarme
	 * @return the allarme, or <code>null</code> if a allarme with the primary key could not be found
	 */
	public static Allarme fetchByPrimaryKey(long allarmeId) {
		return getPersistence().fetchByPrimaryKey(allarmeId);
	}

	/**
	 * Returns all the allarmes.
	 *
	 * @return the allarmes
	 */
	public static List<Allarme> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the allarmes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @return the range of allarmes
	 */
	public static List<Allarme> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the allarmes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of allarmes
	 */
	public static List<Allarme> findAll(
		int start, int end, OrderByComparator<Allarme> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the allarmes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of allarmes
	 */
	public static List<Allarme> findAll(
		int start, int end, OrderByComparator<Allarme> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the allarmes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of allarmes.
	 *
	 * @return the number of allarmes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AllarmePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(AllarmePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile AllarmePersistence _persistence;

}