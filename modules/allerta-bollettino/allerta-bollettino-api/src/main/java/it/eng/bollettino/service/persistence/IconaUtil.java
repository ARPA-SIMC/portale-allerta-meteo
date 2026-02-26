/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.bollettino.model.Icona;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the icona service. This utility wraps <code>it.eng.bollettino.service.persistence.impl.IconaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see IconaPersistence
 * @generated
 */
public class IconaUtil {

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
	public static void clearCache(Icona icona) {
		getPersistence().clearCache(icona);
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
	public static Map<Serializable, Icona> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Icona> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Icona> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Icona> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Icona> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Icona update(Icona icona) {
		return getPersistence().update(icona);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Icona update(Icona icona, ServiceContext serviceContext) {
		return getPersistence().update(icona, serviceContext);
	}

	/**
	 * Returns all the iconas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching iconas
	 */
	public static List<Icona> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the iconas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IconaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of iconas
	 * @param end the upper bound of the range of iconas (not inclusive)
	 * @return the range of matching iconas
	 */
	public static List<Icona> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the iconas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IconaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of iconas
	 * @param end the upper bound of the range of iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching iconas
	 */
	public static List<Icona> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Icona> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the iconas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IconaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of iconas
	 * @param end the upper bound of the range of iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching iconas
	 */
	public static List<Icona> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Icona> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first icona in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icona
	 * @throws NoSuchIconaException if a matching icona could not be found
	 */
	public static Icona findByUuid_First(
			String uuid, OrderByComparator<Icona> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchIconaException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first icona in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icona, or <code>null</code> if a matching icona could not be found
	 */
	public static Icona fetchByUuid_First(
		String uuid, OrderByComparator<Icona> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last icona in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icona
	 * @throws NoSuchIconaException if a matching icona could not be found
	 */
	public static Icona findByUuid_Last(
			String uuid, OrderByComparator<Icona> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchIconaException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last icona in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icona, or <code>null</code> if a matching icona could not be found
	 */
	public static Icona fetchByUuid_Last(
		String uuid, OrderByComparator<Icona> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the iconas before and after the current icona in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current icona
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next icona
	 * @throws NoSuchIconaException if a icona with the primary key could not be found
	 */
	public static Icona[] findByUuid_PrevAndNext(
			long id, String uuid, OrderByComparator<Icona> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchIconaException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the iconas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of iconas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching iconas
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the icona in the entity cache if it is enabled.
	 *
	 * @param icona the icona
	 */
	public static void cacheResult(Icona icona) {
		getPersistence().cacheResult(icona);
	}

	/**
	 * Caches the iconas in the entity cache if it is enabled.
	 *
	 * @param iconas the iconas
	 */
	public static void cacheResult(List<Icona> iconas) {
		getPersistence().cacheResult(iconas);
	}

	/**
	 * Creates a new icona with the primary key. Does not add the icona to the database.
	 *
	 * @param id the primary key for the new icona
	 * @return the new icona
	 */
	public static Icona create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the icona with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the icona
	 * @return the icona that was removed
	 * @throws NoSuchIconaException if a icona with the primary key could not be found
	 */
	public static Icona remove(long id)
		throws it.eng.bollettino.exception.NoSuchIconaException {

		return getPersistence().remove(id);
	}

	public static Icona updateImpl(Icona icona) {
		return getPersistence().updateImpl(icona);
	}

	/**
	 * Returns the icona with the primary key or throws a <code>NoSuchIconaException</code> if it could not be found.
	 *
	 * @param id the primary key of the icona
	 * @return the icona
	 * @throws NoSuchIconaException if a icona with the primary key could not be found
	 */
	public static Icona findByPrimaryKey(long id)
		throws it.eng.bollettino.exception.NoSuchIconaException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the icona with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the icona
	 * @return the icona, or <code>null</code> if a icona with the primary key could not be found
	 */
	public static Icona fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the iconas.
	 *
	 * @return the iconas
	 */
	public static List<Icona> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the iconas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IconaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of iconas
	 * @param end the upper bound of the range of iconas (not inclusive)
	 * @return the range of iconas
	 */
	public static List<Icona> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the iconas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IconaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of iconas
	 * @param end the upper bound of the range of iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of iconas
	 */
	public static List<Icona> findAll(
		int start, int end, OrderByComparator<Icona> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the iconas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IconaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of iconas
	 * @param end the upper bound of the range of iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of iconas
	 */
	public static List<Icona> findAll(
		int start, int end, OrderByComparator<Icona> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the iconas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of iconas.
	 *
	 * @return the number of iconas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static IconaPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(IconaPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile IconaPersistence _persistence;

}