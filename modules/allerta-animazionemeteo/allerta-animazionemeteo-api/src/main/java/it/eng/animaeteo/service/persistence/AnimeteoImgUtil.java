/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animaeteo.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.animaeteo.model.AnimeteoImg;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the animeteo img service. This utility wraps <code>it.eng.animaeteo.service.persistence.impl.AnimeteoImgPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author UTENTE
 * @see AnimeteoImgPersistence
 * @generated
 */
public class AnimeteoImgUtil {

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
	public static void clearCache(AnimeteoImg animeteoImg) {
		getPersistence().clearCache(animeteoImg);
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
	public static Map<Serializable, AnimeteoImg> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AnimeteoImg> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AnimeteoImg> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AnimeteoImg> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AnimeteoImg> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AnimeteoImg update(AnimeteoImg animeteoImg) {
		return getPersistence().update(animeteoImg);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AnimeteoImg update(
		AnimeteoImg animeteoImg, ServiceContext serviceContext) {

		return getPersistence().update(animeteoImg, serviceContext);
	}

	/**
	 * Returns all the animeteo imgs where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching animeteo imgs
	 */
	public static List<AnimeteoImg> findByImageData(String type) {
		return getPersistence().findByImageData(type);
	}

	/**
	 * Returns a range of all the animeteo imgs where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimeteoImgModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of animeteo imgs
	 * @param end the upper bound of the range of animeteo imgs (not inclusive)
	 * @return the range of matching animeteo imgs
	 */
	public static List<AnimeteoImg> findByImageData(
		String type, int start, int end) {

		return getPersistence().findByImageData(type, start, end);
	}

	/**
	 * Returns an ordered range of all the animeteo imgs where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimeteoImgModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of animeteo imgs
	 * @param end the upper bound of the range of animeteo imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching animeteo imgs
	 */
	public static List<AnimeteoImg> findByImageData(
		String type, int start, int end,
		OrderByComparator<AnimeteoImg> orderByComparator) {

		return getPersistence().findByImageData(
			type, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the animeteo imgs where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimeteoImgModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of animeteo imgs
	 * @param end the upper bound of the range of animeteo imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching animeteo imgs
	 */
	public static List<AnimeteoImg> findByImageData(
		String type, int start, int end,
		OrderByComparator<AnimeteoImg> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByImageData(
			type, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first animeteo img in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animeteo img
	 * @throws NoSuchAnimeteoImgException if a matching animeteo img could not be found
	 */
	public static AnimeteoImg findByImageData_First(
			String type, OrderByComparator<AnimeteoImg> orderByComparator)
		throws it.eng.animaeteo.exception.NoSuchAnimeteoImgException {

		return getPersistence().findByImageData_First(type, orderByComparator);
	}

	/**
	 * Returns the first animeteo img in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animeteo img, or <code>null</code> if a matching animeteo img could not be found
	 */
	public static AnimeteoImg fetchByImageData_First(
		String type, OrderByComparator<AnimeteoImg> orderByComparator) {

		return getPersistence().fetchByImageData_First(type, orderByComparator);
	}

	/**
	 * Returns the last animeteo img in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animeteo img
	 * @throws NoSuchAnimeteoImgException if a matching animeteo img could not be found
	 */
	public static AnimeteoImg findByImageData_Last(
			String type, OrderByComparator<AnimeteoImg> orderByComparator)
		throws it.eng.animaeteo.exception.NoSuchAnimeteoImgException {

		return getPersistence().findByImageData_Last(type, orderByComparator);
	}

	/**
	 * Returns the last animeteo img in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animeteo img, or <code>null</code> if a matching animeteo img could not be found
	 */
	public static AnimeteoImg fetchByImageData_Last(
		String type, OrderByComparator<AnimeteoImg> orderByComparator) {

		return getPersistence().fetchByImageData_Last(type, orderByComparator);
	}

	/**
	 * Returns the animeteo imgs before and after the current animeteo img in the ordered set where type = &#63;.
	 *
	 * @param id the primary key of the current animeteo img
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next animeteo img
	 * @throws NoSuchAnimeteoImgException if a animeteo img with the primary key could not be found
	 */
	public static AnimeteoImg[] findByImageData_PrevAndNext(
			long id, String type,
			OrderByComparator<AnimeteoImg> orderByComparator)
		throws it.eng.animaeteo.exception.NoSuchAnimeteoImgException {

		return getPersistence().findByImageData_PrevAndNext(
			id, type, orderByComparator);
	}

	/**
	 * Removes all the animeteo imgs where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	public static void removeByImageData(String type) {
		getPersistence().removeByImageData(type);
	}

	/**
	 * Returns the number of animeteo imgs where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching animeteo imgs
	 */
	public static int countByImageData(String type) {
		return getPersistence().countByImageData(type);
	}

	/**
	 * Caches the animeteo img in the entity cache if it is enabled.
	 *
	 * @param animeteoImg the animeteo img
	 */
	public static void cacheResult(AnimeteoImg animeteoImg) {
		getPersistence().cacheResult(animeteoImg);
	}

	/**
	 * Caches the animeteo imgs in the entity cache if it is enabled.
	 *
	 * @param animeteoImgs the animeteo imgs
	 */
	public static void cacheResult(List<AnimeteoImg> animeteoImgs) {
		getPersistence().cacheResult(animeteoImgs);
	}

	/**
	 * Creates a new animeteo img with the primary key. Does not add the animeteo img to the database.
	 *
	 * @param id the primary key for the new animeteo img
	 * @return the new animeteo img
	 */
	public static AnimeteoImg create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the animeteo img with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the animeteo img
	 * @return the animeteo img that was removed
	 * @throws NoSuchAnimeteoImgException if a animeteo img with the primary key could not be found
	 */
	public static AnimeteoImg remove(long id)
		throws it.eng.animaeteo.exception.NoSuchAnimeteoImgException {

		return getPersistence().remove(id);
	}

	public static AnimeteoImg updateImpl(AnimeteoImg animeteoImg) {
		return getPersistence().updateImpl(animeteoImg);
	}

	/**
	 * Returns the animeteo img with the primary key or throws a <code>NoSuchAnimeteoImgException</code> if it could not be found.
	 *
	 * @param id the primary key of the animeteo img
	 * @return the animeteo img
	 * @throws NoSuchAnimeteoImgException if a animeteo img with the primary key could not be found
	 */
	public static AnimeteoImg findByPrimaryKey(long id)
		throws it.eng.animaeteo.exception.NoSuchAnimeteoImgException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the animeteo img with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the animeteo img
	 * @return the animeteo img, or <code>null</code> if a animeteo img with the primary key could not be found
	 */
	public static AnimeteoImg fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the animeteo imgs.
	 *
	 * @return the animeteo imgs
	 */
	public static List<AnimeteoImg> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the animeteo imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimeteoImgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of animeteo imgs
	 * @param end the upper bound of the range of animeteo imgs (not inclusive)
	 * @return the range of animeteo imgs
	 */
	public static List<AnimeteoImg> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the animeteo imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimeteoImgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of animeteo imgs
	 * @param end the upper bound of the range of animeteo imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of animeteo imgs
	 */
	public static List<AnimeteoImg> findAll(
		int start, int end, OrderByComparator<AnimeteoImg> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the animeteo imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnimeteoImgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of animeteo imgs
	 * @param end the upper bound of the range of animeteo imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of animeteo imgs
	 */
	public static List<AnimeteoImg> findAll(
		int start, int end, OrderByComparator<AnimeteoImg> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the animeteo imgs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of animeteo imgs.
	 *
	 * @return the number of animeteo imgs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AnimeteoImgPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(AnimeteoImgPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile AnimeteoImgPersistence _persistence;

}