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

package it.eng.radarMeteo.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.radarMeteo.exception.NoSuchJsonException;
import it.eng.radarMeteo.model.Json;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the json service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Francesco
 * @see JsonUtil
 * @generated
 */
@ProviderType
public interface JsonPersistence extends BasePersistence<Json> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JsonUtil} to access the json persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Json> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the jsons where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching jsons
	 */
	public java.util.List<Json> findBytype(String type);

	/**
	 * Returns a range of all the jsons where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of jsons
	 * @param end the upper bound of the range of jsons (not inclusive)
	 * @return the range of matching jsons
	 */
	public java.util.List<Json> findBytype(String type, int start, int end);

	/**
	 * Returns an ordered range of all the jsons where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of jsons
	 * @param end the upper bound of the range of jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jsons
	 */
	public java.util.List<Json> findBytype(
		String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Json>
			orderByComparator);

	/**
	 * Returns an ordered range of all the jsons where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of jsons
	 * @param end the upper bound of the range of jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching jsons
	 */
	public java.util.List<Json> findBytype(
		String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Json>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first json in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching json
	 * @throws NoSuchJsonException if a matching json could not be found
	 */
	public Json findBytype_First(
			String type,
			com.liferay.portal.kernel.util.OrderByComparator<Json>
				orderByComparator)
		throws NoSuchJsonException;

	/**
	 * Returns the first json in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching json, or <code>null</code> if a matching json could not be found
	 */
	public Json fetchBytype_First(
		String type,
		com.liferay.portal.kernel.util.OrderByComparator<Json>
			orderByComparator);

	/**
	 * Returns the last json in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching json
	 * @throws NoSuchJsonException if a matching json could not be found
	 */
	public Json findBytype_Last(
			String type,
			com.liferay.portal.kernel.util.OrderByComparator<Json>
				orderByComparator)
		throws NoSuchJsonException;

	/**
	 * Returns the last json in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching json, or <code>null</code> if a matching json could not be found
	 */
	public Json fetchBytype_Last(
		String type,
		com.liferay.portal.kernel.util.OrderByComparator<Json>
			orderByComparator);

	/**
	 * Returns the jsons before and after the current json in the ordered set where type = &#63;.
	 *
	 * @param id the primary key of the current json
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next json
	 * @throws NoSuchJsonException if a json with the primary key could not be found
	 */
	public Json[] findBytype_PrevAndNext(
			long id, String type,
			com.liferay.portal.kernel.util.OrderByComparator<Json>
				orderByComparator)
		throws NoSuchJsonException;

	/**
	 * Removes all the jsons where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	public void removeBytype(String type);

	/**
	 * Returns the number of jsons where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching jsons
	 */
	public int countBytype(String type);

	/**
	 * Caches the json in the entity cache if it is enabled.
	 *
	 * @param json the json
	 */
	public void cacheResult(Json json);

	/**
	 * Caches the jsons in the entity cache if it is enabled.
	 *
	 * @param jsons the jsons
	 */
	public void cacheResult(java.util.List<Json> jsons);

	/**
	 * Creates a new json with the primary key. Does not add the json to the database.
	 *
	 * @param id the primary key for the new json
	 * @return the new json
	 */
	public Json create(long id);

	/**
	 * Removes the json with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the json
	 * @return the json that was removed
	 * @throws NoSuchJsonException if a json with the primary key could not be found
	 */
	public Json remove(long id) throws NoSuchJsonException;

	public Json updateImpl(Json json);

	/**
	 * Returns the json with the primary key or throws a <code>NoSuchJsonException</code> if it could not be found.
	 *
	 * @param id the primary key of the json
	 * @return the json
	 * @throws NoSuchJsonException if a json with the primary key could not be found
	 */
	public Json findByPrimaryKey(long id) throws NoSuchJsonException;

	/**
	 * Returns the json with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the json
	 * @return the json, or <code>null</code> if a json with the primary key could not be found
	 */
	public Json fetchByPrimaryKey(long id);

	/**
	 * Returns all the jsons.
	 *
	 * @return the jsons
	 */
	public java.util.List<Json> findAll();

	/**
	 * Returns a range of all the jsons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of jsons
	 * @param end the upper bound of the range of jsons (not inclusive)
	 * @return the range of jsons
	 */
	public java.util.List<Json> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the jsons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of jsons
	 * @param end the upper bound of the range of jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of jsons
	 */
	public java.util.List<Json> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Json>
			orderByComparator);

	/**
	 * Returns an ordered range of all the jsons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of jsons
	 * @param end the upper bound of the range of jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of jsons
	 */
	public java.util.List<Json> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Json>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the jsons from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of jsons.
	 *
	 * @return the number of jsons
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}