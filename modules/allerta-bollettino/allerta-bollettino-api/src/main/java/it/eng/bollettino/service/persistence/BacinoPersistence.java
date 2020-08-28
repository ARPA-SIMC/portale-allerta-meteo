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

import it.eng.bollettino.exception.NoSuchBacinoException;
import it.eng.bollettino.model.Bacino;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the bacino service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see BacinoUtil
 * @generated
 */
@ProviderType
public interface BacinoPersistence extends BasePersistence<Bacino> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BacinoUtil} to access the bacino persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Bacino> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the bacinos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching bacinos
	 */
	public java.util.List<Bacino> findByUuid(String uuid);

	/**
	 * Returns a range of all the bacinos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bacinos
	 * @param end the upper bound of the range of bacinos (not inclusive)
	 * @return the range of matching bacinos
	 */
	public java.util.List<Bacino> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the bacinos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bacinos
	 * @param end the upper bound of the range of bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bacinos
	 */
	public java.util.List<Bacino> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Bacino>
			orderByComparator);

	/**
	 * Returns an ordered range of all the bacinos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bacinos
	 * @param end the upper bound of the range of bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching bacinos
	 */
	public java.util.List<Bacino> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Bacino>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first bacino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bacino
	 * @throws NoSuchBacinoException if a matching bacino could not be found
	 */
	public Bacino findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Bacino>
				orderByComparator)
		throws NoSuchBacinoException;

	/**
	 * Returns the first bacino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bacino, or <code>null</code> if a matching bacino could not be found
	 */
	public Bacino fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Bacino>
			orderByComparator);

	/**
	 * Returns the last bacino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bacino
	 * @throws NoSuchBacinoException if a matching bacino could not be found
	 */
	public Bacino findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Bacino>
				orderByComparator)
		throws NoSuchBacinoException;

	/**
	 * Returns the last bacino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bacino, or <code>null</code> if a matching bacino could not be found
	 */
	public Bacino fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Bacino>
			orderByComparator);

	/**
	 * Returns the bacinos before and after the current bacino in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current bacino
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bacino
	 * @throws NoSuchBacinoException if a bacino with the primary key could not be found
	 */
	public Bacino[] findByUuid_PrevAndNext(
			String id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Bacino>
				orderByComparator)
		throws NoSuchBacinoException;

	/**
	 * Removes all the bacinos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of bacinos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching bacinos
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the bacino in the entity cache if it is enabled.
	 *
	 * @param bacino the bacino
	 */
	public void cacheResult(Bacino bacino);

	/**
	 * Caches the bacinos in the entity cache if it is enabled.
	 *
	 * @param bacinos the bacinos
	 */
	public void cacheResult(java.util.List<Bacino> bacinos);

	/**
	 * Creates a new bacino with the primary key. Does not add the bacino to the database.
	 *
	 * @param id the primary key for the new bacino
	 * @return the new bacino
	 */
	public Bacino create(String id);

	/**
	 * Removes the bacino with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the bacino
	 * @return the bacino that was removed
	 * @throws NoSuchBacinoException if a bacino with the primary key could not be found
	 */
	public Bacino remove(String id) throws NoSuchBacinoException;

	public Bacino updateImpl(Bacino bacino);

	/**
	 * Returns the bacino with the primary key or throws a <code>NoSuchBacinoException</code> if it could not be found.
	 *
	 * @param id the primary key of the bacino
	 * @return the bacino
	 * @throws NoSuchBacinoException if a bacino with the primary key could not be found
	 */
	public Bacino findByPrimaryKey(String id) throws NoSuchBacinoException;

	/**
	 * Returns the bacino with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the bacino
	 * @return the bacino, or <code>null</code> if a bacino with the primary key could not be found
	 */
	public Bacino fetchByPrimaryKey(String id);

	/**
	 * Returns all the bacinos.
	 *
	 * @return the bacinos
	 */
	public java.util.List<Bacino> findAll();

	/**
	 * Returns a range of all the bacinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bacinos
	 * @param end the upper bound of the range of bacinos (not inclusive)
	 * @return the range of bacinos
	 */
	public java.util.List<Bacino> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the bacinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bacinos
	 * @param end the upper bound of the range of bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bacinos
	 */
	public java.util.List<Bacino> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Bacino>
			orderByComparator);

	/**
	 * Returns an ordered range of all the bacinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bacinos
	 * @param end the upper bound of the range of bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of bacinos
	 */
	public java.util.List<Bacino> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Bacino>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the bacinos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of bacinos.
	 *
	 * @return the number of bacinos
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}