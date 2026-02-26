/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.dewetra.service.persistence;

import allerta.dewetra.model.HRW;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the hrw service. This utility wraps <code>allerta.dewetra.service.persistence.impl.HRWPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HRWPersistence
 * @generated
 */
public class HRWUtil {

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
	public static void clearCache(HRW hrw) {
		getPersistence().clearCache(hrw);
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
	public static Map<Serializable, HRW> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<HRW> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<HRW> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<HRW> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<HRW> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static HRW update(HRW hrw) {
		return getPersistence().update(hrw);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static HRW update(HRW hrw, ServiceContext serviceContext) {
		return getPersistence().update(hrw, serviceContext);
	}

	/**
	 * Returns all the hrws where comune = &#63;.
	 *
	 * @param comune the comune
	 * @return the matching hrws
	 */
	public static List<HRW> findByComune(String comune) {
		return getPersistence().findByComune(comune);
	}

	/**
	 * Returns a range of all the hrws where comune = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HRWModelImpl</code>.
	 * </p>
	 *
	 * @param comune the comune
	 * @param start the lower bound of the range of hrws
	 * @param end the upper bound of the range of hrws (not inclusive)
	 * @return the range of matching hrws
	 */
	public static List<HRW> findByComune(String comune, int start, int end) {
		return getPersistence().findByComune(comune, start, end);
	}

	/**
	 * Returns an ordered range of all the hrws where comune = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HRWModelImpl</code>.
	 * </p>
	 *
	 * @param comune the comune
	 * @param start the lower bound of the range of hrws
	 * @param end the upper bound of the range of hrws (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching hrws
	 */
	public static List<HRW> findByComune(
		String comune, int start, int end,
		OrderByComparator<HRW> orderByComparator) {

		return getPersistence().findByComune(
			comune, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the hrws where comune = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HRWModelImpl</code>.
	 * </p>
	 *
	 * @param comune the comune
	 * @param start the lower bound of the range of hrws
	 * @param end the upper bound of the range of hrws (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching hrws
	 */
	public static List<HRW> findByComune(
		String comune, int start, int end,
		OrderByComparator<HRW> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByComune(
			comune, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first hrw in the ordered set where comune = &#63;.
	 *
	 * @param comune the comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hrw
	 * @throws NoSuchHRWException if a matching hrw could not be found
	 */
	public static HRW findByComune_First(
			String comune, OrderByComparator<HRW> orderByComparator)
		throws allerta.dewetra.exception.NoSuchHRWException {

		return getPersistence().findByComune_First(comune, orderByComparator);
	}

	/**
	 * Returns the first hrw in the ordered set where comune = &#63;.
	 *
	 * @param comune the comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hrw, or <code>null</code> if a matching hrw could not be found
	 */
	public static HRW fetchByComune_First(
		String comune, OrderByComparator<HRW> orderByComparator) {

		return getPersistence().fetchByComune_First(comune, orderByComparator);
	}

	/**
	 * Returns the last hrw in the ordered set where comune = &#63;.
	 *
	 * @param comune the comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hrw
	 * @throws NoSuchHRWException if a matching hrw could not be found
	 */
	public static HRW findByComune_Last(
			String comune, OrderByComparator<HRW> orderByComparator)
		throws allerta.dewetra.exception.NoSuchHRWException {

		return getPersistence().findByComune_Last(comune, orderByComparator);
	}

	/**
	 * Returns the last hrw in the ordered set where comune = &#63;.
	 *
	 * @param comune the comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hrw, or <code>null</code> if a matching hrw could not be found
	 */
	public static HRW fetchByComune_Last(
		String comune, OrderByComparator<HRW> orderByComparator) {

		return getPersistence().fetchByComune_Last(comune, orderByComparator);
	}

	/**
	 * Returns the hrws before and after the current hrw in the ordered set where comune = &#63;.
	 *
	 * @param id the primary key of the current hrw
	 * @param comune the comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next hrw
	 * @throws NoSuchHRWException if a hrw with the primary key could not be found
	 */
	public static HRW[] findByComune_PrevAndNext(
			long id, String comune, OrderByComparator<HRW> orderByComparator)
		throws allerta.dewetra.exception.NoSuchHRWException {

		return getPersistence().findByComune_PrevAndNext(
			id, comune, orderByComparator);
	}

	/**
	 * Removes all the hrws where comune = &#63; from the database.
	 *
	 * @param comune the comune
	 */
	public static void removeByComune(String comune) {
		getPersistence().removeByComune(comune);
	}

	/**
	 * Returns the number of hrws where comune = &#63;.
	 *
	 * @param comune the comune
	 * @return the number of matching hrws
	 */
	public static int countByComune(String comune) {
		return getPersistence().countByComune(comune);
	}

	/**
	 * Caches the hrw in the entity cache if it is enabled.
	 *
	 * @param hrw the hrw
	 */
	public static void cacheResult(HRW hrw) {
		getPersistence().cacheResult(hrw);
	}

	/**
	 * Caches the hrws in the entity cache if it is enabled.
	 *
	 * @param hrws the hrws
	 */
	public static void cacheResult(List<HRW> hrws) {
		getPersistence().cacheResult(hrws);
	}

	/**
	 * Creates a new hrw with the primary key. Does not add the hrw to the database.
	 *
	 * @param id the primary key for the new hrw
	 * @return the new hrw
	 */
	public static HRW create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the hrw with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the hrw
	 * @return the hrw that was removed
	 * @throws NoSuchHRWException if a hrw with the primary key could not be found
	 */
	public static HRW remove(long id)
		throws allerta.dewetra.exception.NoSuchHRWException {

		return getPersistence().remove(id);
	}

	public static HRW updateImpl(HRW hrw) {
		return getPersistence().updateImpl(hrw);
	}

	/**
	 * Returns the hrw with the primary key or throws a <code>NoSuchHRWException</code> if it could not be found.
	 *
	 * @param id the primary key of the hrw
	 * @return the hrw
	 * @throws NoSuchHRWException if a hrw with the primary key could not be found
	 */
	public static HRW findByPrimaryKey(long id)
		throws allerta.dewetra.exception.NoSuchHRWException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the hrw with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the hrw
	 * @return the hrw, or <code>null</code> if a hrw with the primary key could not be found
	 */
	public static HRW fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the hrws.
	 *
	 * @return the hrws
	 */
	public static List<HRW> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the hrws.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HRWModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hrws
	 * @param end the upper bound of the range of hrws (not inclusive)
	 * @return the range of hrws
	 */
	public static List<HRW> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the hrws.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HRWModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hrws
	 * @param end the upper bound of the range of hrws (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of hrws
	 */
	public static List<HRW> findAll(
		int start, int end, OrderByComparator<HRW> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the hrws.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HRWModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hrws
	 * @param end the upper bound of the range of hrws (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of hrws
	 */
	public static List<HRW> findAll(
		int start, int end, OrderByComparator<HRW> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the hrws from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of hrws.
	 *
	 * @return the number of hrws
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static HRWPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(HRWPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile HRWPersistence _persistence;

}