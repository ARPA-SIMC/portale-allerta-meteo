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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.bollettino.exception.NoSuchImgException;
import it.eng.bollettino.model.Img;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the img service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see ImgUtil
 * @generated
 */
@ProviderType
public interface ImgPersistence extends BasePersistence<Img> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ImgUtil} to access the img persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Img> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the imgs where day = &#63;.
	 *
	 * @param day the day
	 * @return the matching imgs
	 */
	public java.util.List<Img> findByday(String day);

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
	public java.util.List<Img> findByday(String day, int start, int end);

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
	public java.util.List<Img> findByday(
		String day, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Img>
			orderByComparator);

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
	public java.util.List<Img> findByday(
		String day, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Img> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first img in the ordered set where day = &#63;.
	 *
	 * @param day the day
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching img
	 * @throws NoSuchImgException if a matching img could not be found
	 */
	public Img findByday_First(
			String day,
			com.liferay.portal.kernel.util.OrderByComparator<Img>
				orderByComparator)
		throws NoSuchImgException;

	/**
	 * Returns the first img in the ordered set where day = &#63;.
	 *
	 * @param day the day
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching img, or <code>null</code> if a matching img could not be found
	 */
	public Img fetchByday_First(
		String day,
		com.liferay.portal.kernel.util.OrderByComparator<Img>
			orderByComparator);

	/**
	 * Returns the last img in the ordered set where day = &#63;.
	 *
	 * @param day the day
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching img
	 * @throws NoSuchImgException if a matching img could not be found
	 */
	public Img findByday_Last(
			String day,
			com.liferay.portal.kernel.util.OrderByComparator<Img>
				orderByComparator)
		throws NoSuchImgException;

	/**
	 * Returns the last img in the ordered set where day = &#63;.
	 *
	 * @param day the day
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching img, or <code>null</code> if a matching img could not be found
	 */
	public Img fetchByday_Last(
		String day,
		com.liferay.portal.kernel.util.OrderByComparator<Img>
			orderByComparator);

	/**
	 * Returns the imgs before and after the current img in the ordered set where day = &#63;.
	 *
	 * @param id the primary key of the current img
	 * @param day the day
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next img
	 * @throws NoSuchImgException if a img with the primary key could not be found
	 */
	public Img[] findByday_PrevAndNext(
			long id, String day,
			com.liferay.portal.kernel.util.OrderByComparator<Img>
				orderByComparator)
		throws NoSuchImgException;

	/**
	 * Removes all the imgs where day = &#63; from the database.
	 *
	 * @param day the day
	 */
	public void removeByday(String day);

	/**
	 * Returns the number of imgs where day = &#63;.
	 *
	 * @param day the day
	 * @return the number of matching imgs
	 */
	public int countByday(String day);

	/**
	 * Returns all the imgs where day = &#63; and provincia = &#63;.
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @return the matching imgs
	 */
	public java.util.List<Img> findByDay_Province(String day, String provincia);

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
	public java.util.List<Img> findByDay_Province(
		String day, String provincia, int start, int end);

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
	public java.util.List<Img> findByDay_Province(
		String day, String provincia, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Img>
			orderByComparator);

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
	public java.util.List<Img> findByDay_Province(
		String day, String provincia, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Img> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first img in the ordered set where day = &#63; and provincia = &#63;.
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching img
	 * @throws NoSuchImgException if a matching img could not be found
	 */
	public Img findByDay_Province_First(
			String day, String provincia,
			com.liferay.portal.kernel.util.OrderByComparator<Img>
				orderByComparator)
		throws NoSuchImgException;

	/**
	 * Returns the first img in the ordered set where day = &#63; and provincia = &#63;.
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching img, or <code>null</code> if a matching img could not be found
	 */
	public Img fetchByDay_Province_First(
		String day, String provincia,
		com.liferay.portal.kernel.util.OrderByComparator<Img>
			orderByComparator);

	/**
	 * Returns the last img in the ordered set where day = &#63; and provincia = &#63;.
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching img
	 * @throws NoSuchImgException if a matching img could not be found
	 */
	public Img findByDay_Province_Last(
			String day, String provincia,
			com.liferay.portal.kernel.util.OrderByComparator<Img>
				orderByComparator)
		throws NoSuchImgException;

	/**
	 * Returns the last img in the ordered set where day = &#63; and provincia = &#63;.
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching img, or <code>null</code> if a matching img could not be found
	 */
	public Img fetchByDay_Province_Last(
		String day, String provincia,
		com.liferay.portal.kernel.util.OrderByComparator<Img>
			orderByComparator);

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
	public Img[] findByDay_Province_PrevAndNext(
			long id, String day, String provincia,
			com.liferay.portal.kernel.util.OrderByComparator<Img>
				orderByComparator)
		throws NoSuchImgException;

	/**
	 * Removes all the imgs where day = &#63; and provincia = &#63; from the database.
	 *
	 * @param day the day
	 * @param provincia the provincia
	 */
	public void removeByDay_Province(String day, String provincia);

	/**
	 * Returns the number of imgs where day = &#63; and provincia = &#63;.
	 *
	 * @param day the day
	 * @param provincia the provincia
	 * @return the number of matching imgs
	 */
	public int countByDay_Province(String day, String provincia);

	/**
	 * Returns the img where daypart = &#63; and day = &#63; and provincia = &#63; or throws a <code>NoSuchImgException</code> if it could not be found.
	 *
	 * @param daypart the daypart
	 * @param day the day
	 * @param provincia the provincia
	 * @return the matching img
	 * @throws NoSuchImgException if a matching img could not be found
	 */
	public Img findByPart_Day_Province(
			String daypart, String day, String provincia)
		throws NoSuchImgException;

	/**
	 * Returns the img where daypart = &#63; and day = &#63; and provincia = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param daypart the daypart
	 * @param day the day
	 * @param provincia the provincia
	 * @return the matching img, or <code>null</code> if a matching img could not be found
	 */
	public Img fetchByPart_Day_Province(
		String daypart, String day, String provincia);

	/**
	 * Returns the img where daypart = &#63; and day = &#63; and provincia = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param daypart the daypart
	 * @param day the day
	 * @param provincia the provincia
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching img, or <code>null</code> if a matching img could not be found
	 */
	public Img fetchByPart_Day_Province(
		String daypart, String day, String provincia,
		boolean retrieveFromCache);

	/**
	 * Removes the img where daypart = &#63; and day = &#63; and provincia = &#63; from the database.
	 *
	 * @param daypart the daypart
	 * @param day the day
	 * @param provincia the provincia
	 * @return the img that was removed
	 */
	public Img removeByPart_Day_Province(
			String daypart, String day, String provincia)
		throws NoSuchImgException;

	/**
	 * Returns the number of imgs where daypart = &#63; and day = &#63; and provincia = &#63;.
	 *
	 * @param daypart the daypart
	 * @param day the day
	 * @param provincia the provincia
	 * @return the number of matching imgs
	 */
	public int countByPart_Day_Province(
		String daypart, String day, String provincia);

	/**
	 * Caches the img in the entity cache if it is enabled.
	 *
	 * @param img the img
	 */
	public void cacheResult(Img img);

	/**
	 * Caches the imgs in the entity cache if it is enabled.
	 *
	 * @param imgs the imgs
	 */
	public void cacheResult(java.util.List<Img> imgs);

	/**
	 * Creates a new img with the primary key. Does not add the img to the database.
	 *
	 * @param id the primary key for the new img
	 * @return the new img
	 */
	public Img create(long id);

	/**
	 * Removes the img with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the img
	 * @return the img that was removed
	 * @throws NoSuchImgException if a img with the primary key could not be found
	 */
	public Img remove(long id) throws NoSuchImgException;

	public Img updateImpl(Img img);

	/**
	 * Returns the img with the primary key or throws a <code>NoSuchImgException</code> if it could not be found.
	 *
	 * @param id the primary key of the img
	 * @return the img
	 * @throws NoSuchImgException if a img with the primary key could not be found
	 */
	public Img findByPrimaryKey(long id) throws NoSuchImgException;

	/**
	 * Returns the img with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the img
	 * @return the img, or <code>null</code> if a img with the primary key could not be found
	 */
	public Img fetchByPrimaryKey(long id);

	/**
	 * Returns all the imgs.
	 *
	 * @return the imgs
	 */
	public java.util.List<Img> findAll();

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
	public java.util.List<Img> findAll(int start, int end);

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
	public java.util.List<Img> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Img>
			orderByComparator);

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
	public java.util.List<Img> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Img> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the imgs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of imgs.
	 *
	 * @return the number of imgs
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}