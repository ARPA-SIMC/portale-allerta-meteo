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

import it.eng.animaeteo.exception.NoSuchAnimeteoImgException;
import it.eng.animaeteo.model.AnimeteoImg;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the animeteo img service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author UTENTE
 * @see AnimeteoImgUtil
 * @generated
 */
@ProviderType
public interface AnimeteoImgPersistence extends BasePersistence<AnimeteoImg> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnimeteoImgUtil} to access the animeteo img persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, AnimeteoImg> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the animeteo imgs where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching animeteo imgs
	 */
	public java.util.List<AnimeteoImg> findByImageData(String type);

	/**
	 * Returns a range of all the animeteo imgs where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AnimeteoImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of animeteo imgs
	 * @param end the upper bound of the range of animeteo imgs (not inclusive)
	 * @return the range of matching animeteo imgs
	 */
	public java.util.List<AnimeteoImg> findByImageData(
		String type, int start, int end);

	/**
	 * Returns an ordered range of all the animeteo imgs where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AnimeteoImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of animeteo imgs
	 * @param end the upper bound of the range of animeteo imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching animeteo imgs
	 */
	public java.util.List<AnimeteoImg> findByImageData(
		String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimeteoImg>
			orderByComparator);

	/**
	 * Returns an ordered range of all the animeteo imgs where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AnimeteoImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of animeteo imgs
	 * @param end the upper bound of the range of animeteo imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching animeteo imgs
	 */
	public java.util.List<AnimeteoImg> findByImageData(
		String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimeteoImg>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first animeteo img in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animeteo img
	 * @throws NoSuchAnimeteoImgException if a matching animeteo img could not be found
	 */
	public AnimeteoImg findByImageData_First(
			String type,
			com.liferay.portal.kernel.util.OrderByComparator<AnimeteoImg>
				orderByComparator)
		throws NoSuchAnimeteoImgException;

	/**
	 * Returns the first animeteo img in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching animeteo img, or <code>null</code> if a matching animeteo img could not be found
	 */
	public AnimeteoImg fetchByImageData_First(
		String type,
		com.liferay.portal.kernel.util.OrderByComparator<AnimeteoImg>
			orderByComparator);

	/**
	 * Returns the last animeteo img in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animeteo img
	 * @throws NoSuchAnimeteoImgException if a matching animeteo img could not be found
	 */
	public AnimeteoImg findByImageData_Last(
			String type,
			com.liferay.portal.kernel.util.OrderByComparator<AnimeteoImg>
				orderByComparator)
		throws NoSuchAnimeteoImgException;

	/**
	 * Returns the last animeteo img in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching animeteo img, or <code>null</code> if a matching animeteo img could not be found
	 */
	public AnimeteoImg fetchByImageData_Last(
		String type,
		com.liferay.portal.kernel.util.OrderByComparator<AnimeteoImg>
			orderByComparator);

	/**
	 * Returns the animeteo imgs before and after the current animeteo img in the ordered set where type = &#63;.
	 *
	 * @param id the primary key of the current animeteo img
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next animeteo img
	 * @throws NoSuchAnimeteoImgException if a animeteo img with the primary key could not be found
	 */
	public AnimeteoImg[] findByImageData_PrevAndNext(
			long id, String type,
			com.liferay.portal.kernel.util.OrderByComparator<AnimeteoImg>
				orderByComparator)
		throws NoSuchAnimeteoImgException;

	/**
	 * Removes all the animeteo imgs where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	public void removeByImageData(String type);

	/**
	 * Returns the number of animeteo imgs where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching animeteo imgs
	 */
	public int countByImageData(String type);

	/**
	 * Caches the animeteo img in the entity cache if it is enabled.
	 *
	 * @param animeteoImg the animeteo img
	 */
	public void cacheResult(AnimeteoImg animeteoImg);

	/**
	 * Caches the animeteo imgs in the entity cache if it is enabled.
	 *
	 * @param animeteoImgs the animeteo imgs
	 */
	public void cacheResult(java.util.List<AnimeteoImg> animeteoImgs);

	/**
	 * Creates a new animeteo img with the primary key. Does not add the animeteo img to the database.
	 *
	 * @param id the primary key for the new animeteo img
	 * @return the new animeteo img
	 */
	public AnimeteoImg create(long id);

	/**
	 * Removes the animeteo img with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the animeteo img
	 * @return the animeteo img that was removed
	 * @throws NoSuchAnimeteoImgException if a animeteo img with the primary key could not be found
	 */
	public AnimeteoImg remove(long id) throws NoSuchAnimeteoImgException;

	public AnimeteoImg updateImpl(AnimeteoImg animeteoImg);

	/**
	 * Returns the animeteo img with the primary key or throws a <code>NoSuchAnimeteoImgException</code> if it could not be found.
	 *
	 * @param id the primary key of the animeteo img
	 * @return the animeteo img
	 * @throws NoSuchAnimeteoImgException if a animeteo img with the primary key could not be found
	 */
	public AnimeteoImg findByPrimaryKey(long id)
		throws NoSuchAnimeteoImgException;

	/**
	 * Returns the animeteo img with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the animeteo img
	 * @return the animeteo img, or <code>null</code> if a animeteo img with the primary key could not be found
	 */
	public AnimeteoImg fetchByPrimaryKey(long id);

	/**
	 * Returns all the animeteo imgs.
	 *
	 * @return the animeteo imgs
	 */
	public java.util.List<AnimeteoImg> findAll();

	/**
	 * Returns a range of all the animeteo imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AnimeteoImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of animeteo imgs
	 * @param end the upper bound of the range of animeteo imgs (not inclusive)
	 * @return the range of animeteo imgs
	 */
	public java.util.List<AnimeteoImg> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the animeteo imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AnimeteoImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of animeteo imgs
	 * @param end the upper bound of the range of animeteo imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of animeteo imgs
	 */
	public java.util.List<AnimeteoImg> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimeteoImg>
			orderByComparator);

	/**
	 * Returns an ordered range of all the animeteo imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AnimeteoImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of animeteo imgs
	 * @param end the upper bound of the range of animeteo imgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of animeteo imgs
	 */
	public java.util.List<AnimeteoImg> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnimeteoImg>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the animeteo imgs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of animeteo imgs.
	 *
	 * @return the number of animeteo imgs
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}