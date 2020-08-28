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

package it.eng.animaeteo.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.animaeteo.exception.NoSuchAnimeteoSmallImgException;
import it.eng.animaeteo.model.AnimeteoSmallImg;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the animeteo small img service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author UTENTE
 * @see AnimeteoSmallImgUtil
 * @generated
 */
@ProviderType
public interface AnimeteoSmallImgPersistence
	extends BasePersistence<AnimeteoSmallImg> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnimeteoSmallImgUtil} to access the animeteo small img persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, AnimeteoSmallImg> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the animeteo small imgs where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching animeteo small imgs
	 */
	public java.util.List<AnimeteoSmallImg> findByImageData(String type);

	/**
	 * Returns a range of all the animeteo small imgs where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AnimeteoSmallImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of animeteo small imgs
	 * @param end the upper bound of the range of animeteo small imgs (not inclusive)
	 * @return the range of matching animeteo small imgs
	 */
	public java.util.List<AnimeteoSmallImg> findByImageData(
		String type, int start, int end);

	/**
	 * Returns an ordered range of all the animeteo small imgs where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AnimeteoSmallImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of animeteo small imgs
	 * @param end the upper bound of the range of animeteo small imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching animeteo small imgs
	 */
	public java.util.List<AnimeteoSmallImg> findByImageData(
		String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimeteoSmallImg>
			orderByComparator);

	/**
	 * Returns an ordered range of all the animeteo small imgs where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AnimeteoSmallImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of animeteo small imgs
	 * @param end the upper bound of the range of animeteo small imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching animeteo small imgs
	 */
	public java.util.List<AnimeteoSmallImg> findByImageData(
		String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimeteoSmallImg>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first animeteo small img in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animeteo small img
	 * @throws NoSuchAnimeteoSmallImgException if a matching animeteo small img could not be found
	 */
	public AnimeteoSmallImg findByImageData_First(
			String type,
			com.liferay.portal.kernel.util.OrderByComparator<AnimeteoSmallImg>
				orderByComparator)
		throws NoSuchAnimeteoSmallImgException;

	/**
	 * Returns the first animeteo small img in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animeteo small img, or <code>null</code> if a matching animeteo small img could not be found
	 */
	public AnimeteoSmallImg fetchByImageData_First(
		String type,
		com.liferay.portal.kernel.util.OrderByComparator<AnimeteoSmallImg>
			orderByComparator);

	/**
	 * Returns the last animeteo small img in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animeteo small img
	 * @throws NoSuchAnimeteoSmallImgException if a matching animeteo small img could not be found
	 */
	public AnimeteoSmallImg findByImageData_Last(
			String type,
			com.liferay.portal.kernel.util.OrderByComparator<AnimeteoSmallImg>
				orderByComparator)
		throws NoSuchAnimeteoSmallImgException;

	/**
	 * Returns the last animeteo small img in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animeteo small img, or <code>null</code> if a matching animeteo small img could not be found
	 */
	public AnimeteoSmallImg fetchByImageData_Last(
		String type,
		com.liferay.portal.kernel.util.OrderByComparator<AnimeteoSmallImg>
			orderByComparator);

	/**
	 * Returns the animeteo small imgs before and after the current animeteo small img in the ordered set where type = &#63;.
	 *
	 * @param id the primary key of the current animeteo small img
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next animeteo small img
	 * @throws NoSuchAnimeteoSmallImgException if a animeteo small img with the primary key could not be found
	 */
	public AnimeteoSmallImg[] findByImageData_PrevAndNext(
			long id, String type,
			com.liferay.portal.kernel.util.OrderByComparator<AnimeteoSmallImg>
				orderByComparator)
		throws NoSuchAnimeteoSmallImgException;

	/**
	 * Removes all the animeteo small imgs where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	public void removeByImageData(String type);

	/**
	 * Returns the number of animeteo small imgs where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching animeteo small imgs
	 */
	public int countByImageData(String type);

	/**
	 * Caches the animeteo small img in the entity cache if it is enabled.
	 *
	 * @param animeteoSmallImg the animeteo small img
	 */
	public void cacheResult(AnimeteoSmallImg animeteoSmallImg);

	/**
	 * Caches the animeteo small imgs in the entity cache if it is enabled.
	 *
	 * @param animeteoSmallImgs the animeteo small imgs
	 */
	public void cacheResult(java.util.List<AnimeteoSmallImg> animeteoSmallImgs);

	/**
	 * Creates a new animeteo small img with the primary key. Does not add the animeteo small img to the database.
	 *
	 * @param id the primary key for the new animeteo small img
	 * @return the new animeteo small img
	 */
	public AnimeteoSmallImg create(long id);

	/**
	 * Removes the animeteo small img with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the animeteo small img
	 * @return the animeteo small img that was removed
	 * @throws NoSuchAnimeteoSmallImgException if a animeteo small img with the primary key could not be found
	 */
	public AnimeteoSmallImg remove(long id)
		throws NoSuchAnimeteoSmallImgException;

	public AnimeteoSmallImg updateImpl(AnimeteoSmallImg animeteoSmallImg);

	/**
	 * Returns the animeteo small img with the primary key or throws a <code>NoSuchAnimeteoSmallImgException</code> if it could not be found.
	 *
	 * @param id the primary key of the animeteo small img
	 * @return the animeteo small img
	 * @throws NoSuchAnimeteoSmallImgException if a animeteo small img with the primary key could not be found
	 */
	public AnimeteoSmallImg findByPrimaryKey(long id)
		throws NoSuchAnimeteoSmallImgException;

	/**
	 * Returns the animeteo small img with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the animeteo small img
	 * @return the animeteo small img, or <code>null</code> if a animeteo small img with the primary key could not be found
	 */
	public AnimeteoSmallImg fetchByPrimaryKey(long id);

	/**
	 * Returns all the animeteo small imgs.
	 *
	 * @return the animeteo small imgs
	 */
	public java.util.List<AnimeteoSmallImg> findAll();

	/**
	 * Returns a range of all the animeteo small imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AnimeteoSmallImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of animeteo small imgs
	 * @param end the upper bound of the range of animeteo small imgs (not inclusive)
	 * @return the range of animeteo small imgs
	 */
	public java.util.List<AnimeteoSmallImg> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the animeteo small imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AnimeteoSmallImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of animeteo small imgs
	 * @param end the upper bound of the range of animeteo small imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of animeteo small imgs
	 */
	public java.util.List<AnimeteoSmallImg> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimeteoSmallImg>
			orderByComparator);

	/**
	 * Returns an ordered range of all the animeteo small imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AnimeteoSmallImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of animeteo small imgs
	 * @param end the upper bound of the range of animeteo small imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of animeteo small imgs
	 */
	public java.util.List<AnimeteoSmallImg> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimeteoSmallImg>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the animeteo small imgs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of animeteo small imgs.
	 *
	 * @return the number of animeteo small imgs
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}