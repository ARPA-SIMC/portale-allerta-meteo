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

import it.eng.bollettino.model.Img;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the img service. This utility wraps <code>it.eng.bollettino.service.persistence.impl.ImgPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see ImgPersistence
 * @generated
 */
@ProviderType
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
	 * Returns all the imgs where day = &#63;.
	 *
	 * @param day the day
	 * @return the matching imgs
	 */
	public static List<Img> findByday(String day) {
		return getPersistence().findByday(day);
	}

	/**
	 * Returns a range of all the imgs where day = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param day the day
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @return the range of matching imgs
	 */
	public static List<Img> findByday(String day, int start, int end) {
		return getPersistence().findByday(day, start, end);
	}

	/**
	 * Returns an ordered range of all the imgs where day = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param day the day
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching imgs
	 */
	public static List<Img> findByday(
		String day, int start, int end,
		OrderByComparator<Img> orderByComparator) {

		return getPersistence().findByday(day, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the imgs where day = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param day the day
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching imgs
	 */
	public static List<Img> findByday(
		String day, int start, int end,
		OrderByComparator<Img> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByday(
			day, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first img in the ordered set where day = &#63;.
	 *
	 * @param day the day
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching img
	 * @throws NoSuchImgException if a matching img could not be found
	 */
	public static Img findByday_First(
			String day, OrderByComparator<Img> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchImgException {

		return getPersistence().findByday_First(day, orderByComparator);
	}

	/**
	 * Returns the first img in the ordered set where day = &#63;.
	 *
	 * @param day the day
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching img, or <code>null</code> if a matching img could not be found
	 */
	public static Img fetchByday_First(
		String day, OrderByComparator<Img> orderByComparator) {

		return getPersistence().fetchByday_First(day, orderByComparator);
	}

	/**
	 * Returns the last img in the ordered set where day = &#63;.
	 *
	 * @param day the day
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching img
	 * @throws NoSuchImgException if a matching img could not be found
	 */
	public static Img findByday_Last(
			String day, OrderByComparator<Img> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchImgException {

		return getPersistence().findByday_Last(day, orderByComparator);
	}

	/**
	 * Returns the last img in the ordered set where day = &#63;.
	 *
	 * @param day the day
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching img, or <code>null</code> if a matching img could not be found
	 */
	public static Img fetchByday_Last(
		String day, OrderByComparator<Img> orderByComparator) {

		return getPersistence().fetchByday_Last(day, orderByComparator);
	}

	/**
	 * Returns the imgs before and after the current img in the ordered set where day = &#63;.
	 *
	 * @param id the primary key of the current img
	 * @param day the day
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next img
	 * @throws NoSuchImgException if a img with the primary key could not be found
	 */
	public static Img[] findByday_PrevAndNext(
			long id, String day, OrderByComparator<Img> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchImgException {

		return getPersistence().findByday_PrevAndNext(
			id, day, orderByComparator);
	}

	/**
	 * Removes all the imgs where day = &#63; from the database.
	 *
	 * @param day the day
	 */
	public static void removeByday(String day) {
		getPersistence().removeByday(day);
	}

	/**
	 * Returns the number of imgs where day = &#63;.
	 *
	 * @param day the day
	 * @return the number of matching imgs
	 */
	public static int countByday(String day) {
		return getPersistence().countByday(day);
	}

	/**
	 * Returns all the imgs where day = &#63; and provincia = &#63;.
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @return the matching imgs
	 */
	public static List<Img> findByDay_Province(String day, String provincia) {
		return getPersistence().findByDay_Province(day, provincia);
	}

	/**
	 * Returns a range of all the imgs where day = &#63; and provincia = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @return the range of matching imgs
	 */
	public static List<Img> findByDay_Province(
		String day, String provincia, int start, int end) {

		return getPersistence().findByDay_Province(day, provincia, start, end);
	}

	/**
	 * Returns an ordered range of all the imgs where day = &#63; and provincia = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching imgs
	 */
	public static List<Img> findByDay_Province(
		String day, String provincia, int start, int end,
		OrderByComparator<Img> orderByComparator) {

		return getPersistence().findByDay_Province(
			day, provincia, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the imgs where day = &#63; and provincia = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching imgs
	 */
	public static List<Img> findByDay_Province(
		String day, String provincia, int start, int end,
		OrderByComparator<Img> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByDay_Province(
			day, provincia, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first img in the ordered set where day = &#63; and provincia = &#63;.
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching img
	 * @throws NoSuchImgException if a matching img could not be found
	 */
	public static Img findByDay_Province_First(
			String day, String provincia,
			OrderByComparator<Img> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchImgException {

		return getPersistence().findByDay_Province_First(
			day, provincia, orderByComparator);
	}

	/**
	 * Returns the first img in the ordered set where day = &#63; and provincia = &#63;.
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching img, or <code>null</code> if a matching img could not be found
	 */
	public static Img fetchByDay_Province_First(
		String day, String provincia,
		OrderByComparator<Img> orderByComparator) {

		return getPersistence().fetchByDay_Province_First(
			day, provincia, orderByComparator);
	}

	/**
	 * Returns the last img in the ordered set where day = &#63; and provincia = &#63;.
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching img
	 * @throws NoSuchImgException if a matching img could not be found
	 */
	public static Img findByDay_Province_Last(
			String day, String provincia,
			OrderByComparator<Img> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchImgException {

		return getPersistence().findByDay_Province_Last(
			day, provincia, orderByComparator);
	}

	/**
	 * Returns the last img in the ordered set where day = &#63; and provincia = &#63;.
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching img, or <code>null</code> if a matching img could not be found
	 */
	public static Img fetchByDay_Province_Last(
		String day, String provincia,
		OrderByComparator<Img> orderByComparator) {

		return getPersistence().fetchByDay_Province_Last(
			day, provincia, orderByComparator);
	}

	/**
	 * Returns the imgs before and after the current img in the ordered set where day = &#63; and provincia = &#63;.
	 *
	 * @param id the primary key of the current img
	 * @param day the day
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next img
	 * @throws NoSuchImgException if a img with the primary key could not be found
	 */
	public static Img[] findByDay_Province_PrevAndNext(
			long id, String day, String provincia,
			OrderByComparator<Img> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchImgException {

		return getPersistence().findByDay_Province_PrevAndNext(
			id, day, provincia, orderByComparator);
	}

	/**
	 * Removes all the imgs where day = &#63; and provincia = &#63; from the database.
	 *
	 * @param day the day
	 * @param provincia the provincia
	 */
	public static void removeByDay_Province(String day, String provincia) {
		getPersistence().removeByDay_Province(day, provincia);
	}

	/**
	 * Returns the number of imgs where day = &#63; and provincia = &#63;.
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @return the number of matching imgs
	 */
	public static int countByDay_Province(String day, String provincia) {
		return getPersistence().countByDay_Province(day, provincia);
	}

	/**
	 * Returns the img where daypart = &#63; and day = &#63; and provincia = &#63; or throws a <code>NoSuchImgException</code> if it could not be found.
	 *
	 * @param daypart the daypart
	 * @param day the day
	 * @param provincia the provincia
	 * @return the matching img
	 * @throws NoSuchImgException if a matching img could not be found
	 */
	public static Img findByPart_Day_Province(
			String daypart, String day, String provincia)
		throws it.eng.bollettino.exception.NoSuchImgException {

		return getPersistence().findByPart_Day_Province(
			daypart, day, provincia);
	}

	/**
	 * Returns the img where daypart = &#63; and day = &#63; and provincia = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param daypart the daypart
	 * @param day the day
	 * @param provincia the provincia
	 * @return the matching img, or <code>null</code> if a matching img could not be found
	 */
	public static Img fetchByPart_Day_Province(
		String daypart, String day, String provincia) {

		return getPersistence().fetchByPart_Day_Province(
			daypart, day, provincia);
	}

	/**
	 * Returns the img where daypart = &#63; and day = &#63; and provincia = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param daypart the daypart
	 * @param day the day
	 * @param provincia the provincia
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching img, or <code>null</code> if a matching img could not be found
	 */
	public static Img fetchByPart_Day_Province(
		String daypart, String day, String provincia,
		boolean retrieveFromCache) {

		return getPersistence().fetchByPart_Day_Province(
			daypart, day, provincia, retrieveFromCache);
	}

	/**
	 * Removes the img where daypart = &#63; and day = &#63; and provincia = &#63; from the database.
	 *
	 * @param daypart the daypart
	 * @param day the day
	 * @param provincia the provincia
	 * @return the img that was removed
	 */
	public static Img removeByPart_Day_Province(
			String daypart, String day, String provincia)
		throws it.eng.bollettino.exception.NoSuchImgException {

		return getPersistence().removeByPart_Day_Province(
			daypart, day, provincia);
	}

	/**
	 * Returns the number of imgs where daypart = &#63; and day = &#63; and provincia = &#63;.
	 *
	 * @param daypart the daypart
	 * @param day the day
	 * @param provincia the provincia
	 * @return the number of matching imgs
	 */
	public static int countByPart_Day_Province(
		String daypart, String day, String provincia) {

		return getPersistence().countByPart_Day_Province(
			daypart, day, provincia);
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
		throws it.eng.bollettino.exception.NoSuchImgException {

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
		throws it.eng.bollettino.exception.NoSuchImgException {

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of imgs
	 */
	public static List<Img> findAll(
		int start, int end, OrderByComparator<Img> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
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

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ImgPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ImgPersistence, ImgPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ImgPersistence.class);

		ServiceTracker<ImgPersistence, ImgPersistence> serviceTracker =
			new ServiceTracker<ImgPersistence, ImgPersistence>(
				bundle.getBundleContext(), ImgPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}