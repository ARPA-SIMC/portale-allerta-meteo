/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.radarMeteo.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.radarMeteo.model.Img;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the img service. This utility wraps <code>it.eng.radarMeteo.service.persistence.impl.ImgPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Francesco
 * @see ImgPersistence
 * @generated
 */
public class ImgUtil {

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
	public static void clearCache(Img img) {
		getPersistence().clearCache(img);
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
	public static Map<Serializable, Img> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Img> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Img> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Img> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Img> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Img update(Img img) {
		return getPersistence().update(img);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Img update(Img img, ServiceContext serviceContext) {
		return getPersistence().update(img, serviceContext);
	}

	/**
	 * Returns all the imgs where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @return the matching imgs
	 */
	public static List<Img> findBytimeStamp(long timestamp) {
		return getPersistence().findBytimeStamp(timestamp);
	}

	/**
	 * Returns a range of all the imgs where timestamp = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>.
	 * </p>
	 *
	 * @param timestamp the timestamp
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @return the range of matching imgs
	 */
	public static List<Img> findBytimeStamp(
		long timestamp, int start, int end) {

		return getPersistence().findBytimeStamp(timestamp, start, end);
	}

	/**
	 * Returns an ordered range of all the imgs where timestamp = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>.
	 * </p>
	 *
	 * @param timestamp the timestamp
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching imgs
	 */
	public static List<Img> findBytimeStamp(
		long timestamp, int start, int end,
		OrderByComparator<Img> orderByComparator) {

		return getPersistence().findBytimeStamp(
			timestamp, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the imgs where timestamp = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>.
	 * </p>
	 *
	 * @param timestamp the timestamp
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching imgs
	 */
	public static List<Img> findBytimeStamp(
		long timestamp, int start, int end,
		OrderByComparator<Img> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBytimeStamp(
			timestamp, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first img in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching img
	 * @throws NoSuchImgException if a matching img could not be found
	 */
	public static Img findBytimeStamp_First(
			long timestamp, OrderByComparator<Img> orderByComparator)
		throws it.eng.radarMeteo.exception.NoSuchImgException {

		return getPersistence().findBytimeStamp_First(
			timestamp, orderByComparator);
	}

	/**
	 * Returns the first img in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching img, or <code>null</code> if a matching img could not be found
	 */
	public static Img fetchBytimeStamp_First(
		long timestamp, OrderByComparator<Img> orderByComparator) {

		return getPersistence().fetchBytimeStamp_First(
			timestamp, orderByComparator);
	}

	/**
	 * Returns the last img in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching img
	 * @throws NoSuchImgException if a matching img could not be found
	 */
	public static Img findBytimeStamp_Last(
			long timestamp, OrderByComparator<Img> orderByComparator)
		throws it.eng.radarMeteo.exception.NoSuchImgException {

		return getPersistence().findBytimeStamp_Last(
			timestamp, orderByComparator);
	}

	/**
	 * Returns the last img in the ordered set where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching img, or <code>null</code> if a matching img could not be found
	 */
	public static Img fetchBytimeStamp_Last(
		long timestamp, OrderByComparator<Img> orderByComparator) {

		return getPersistence().fetchBytimeStamp_Last(
			timestamp, orderByComparator);
	}

	/**
	 * Returns the imgs before and after the current img in the ordered set where timestamp = &#63;.
	 *
	 * @param id the primary key of the current img
	 * @param timestamp the timestamp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next img
	 * @throws NoSuchImgException if a img with the primary key could not be found
	 */
	public static Img[] findBytimeStamp_PrevAndNext(
			long id, long timestamp, OrderByComparator<Img> orderByComparator)
		throws it.eng.radarMeteo.exception.NoSuchImgException {

		return getPersistence().findBytimeStamp_PrevAndNext(
			id, timestamp, orderByComparator);
	}

	/**
	 * Removes all the imgs where timestamp = &#63; from the database.
	 *
	 * @param timestamp the timestamp
	 */
	public static void removeBytimeStamp(long timestamp) {
		getPersistence().removeBytimeStamp(timestamp);
	}

	/**
	 * Returns the number of imgs where timestamp = &#63;.
	 *
	 * @param timestamp the timestamp
	 * @return the number of matching imgs
	 */
	public static int countBytimeStamp(long timestamp) {
		return getPersistence().countBytimeStamp(timestamp);
	}

	/**
	 * Caches the img in the entity cache if it is enabled.
	 *
	 * @param img the img
	 */
	public static void cacheResult(Img img) {
		getPersistence().cacheResult(img);
	}

	/**
	 * Caches the imgs in the entity cache if it is enabled.
	 *
	 * @param imgs the imgs
	 */
	public static void cacheResult(List<Img> imgs) {
		getPersistence().cacheResult(imgs);
	}

	/**
	 * Creates a new img with the primary key. Does not add the img to the database.
	 *
	 * @param id the primary key for the new img
	 * @return the new img
	 */
	public static Img create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the img with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the img
	 * @return the img that was removed
	 * @throws NoSuchImgException if a img with the primary key could not be found
	 */
	public static Img remove(long id)
		throws it.eng.radarMeteo.exception.NoSuchImgException {

		return getPersistence().remove(id);
	}

	public static Img updateImpl(Img img) {
		return getPersistence().updateImpl(img);
	}

	/**
	 * Returns the img with the primary key or throws a <code>NoSuchImgException</code> if it could not be found.
	 *
	 * @param id the primary key of the img
	 * @return the img
	 * @throws NoSuchImgException if a img with the primary key could not be found
	 */
	public static Img findByPrimaryKey(long id)
		throws it.eng.radarMeteo.exception.NoSuchImgException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the img with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the img
	 * @return the img, or <code>null</code> if a img with the primary key could not be found
	 */
	public static Img fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the imgs.
	 *
	 * @return the imgs
	 */
	public static List<Img> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @return the range of imgs
	 */
	public static List<Img> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of imgs
	 */
	public static List<Img> findAll(
		int start, int end, OrderByComparator<Img> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of imgs
	 */
	public static List<Img> findAll(
		int start, int end, OrderByComparator<Img> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the imgs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of imgs.
	 *
	 * @return the number of imgs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ImgPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ImgPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ImgPersistence _persistence;

}