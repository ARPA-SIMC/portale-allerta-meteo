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

import it.eng.bollettino.exception.NoSuchBollettinoBacinoException;
import it.eng.bollettino.model.BollettinoBacino;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the bollettino bacino service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see BollettinoBacinoUtil
 * @generated
 */
@ProviderType
public interface BollettinoBacinoPersistence
	extends BasePersistence<BollettinoBacino> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BollettinoBacinoUtil} to access the bollettino bacino persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, BollettinoBacino> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the bollettino bacinos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching bollettino bacinos
	 */
	public java.util.List<BollettinoBacino> findByUuid(String uuid);

	/**
	 * Returns a range of all the bollettino bacinos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @return the range of matching bollettino bacinos
	 */
	public java.util.List<BollettinoBacino> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the bollettino bacinos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bollettino bacinos
	 */
	public java.util.List<BollettinoBacino> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoBacino>
			orderByComparator);

	/**
	 * Returns an ordered range of all the bollettino bacinos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching bollettino bacinos
	 */
	public java.util.List<BollettinoBacino> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoBacino>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first bollettino bacino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino bacino
	 * @throws NoSuchBollettinoBacinoException if a matching bollettino bacino could not be found
	 */
	public BollettinoBacino findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BollettinoBacino>
				orderByComparator)
		throws NoSuchBollettinoBacinoException;

	/**
	 * Returns the first bollettino bacino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino bacino, or <code>null</code> if a matching bollettino bacino could not be found
	 */
	public BollettinoBacino fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoBacino>
			orderByComparator);

	/**
	 * Returns the last bollettino bacino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino bacino
	 * @throws NoSuchBollettinoBacinoException if a matching bollettino bacino could not be found
	 */
	public BollettinoBacino findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BollettinoBacino>
				orderByComparator)
		throws NoSuchBollettinoBacinoException;

	/**
	 * Returns the last bollettino bacino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino bacino, or <code>null</code> if a matching bollettino bacino could not be found
	 */
	public BollettinoBacino fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoBacino>
			orderByComparator);

	/**
	 * Returns the bollettino bacinos before and after the current bollettino bacino in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current bollettino bacino
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bollettino bacino
	 * @throws NoSuchBollettinoBacinoException if a bollettino bacino with the primary key could not be found
	 */
	public BollettinoBacino[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BollettinoBacino>
				orderByComparator)
		throws NoSuchBollettinoBacinoException;

	/**
	 * Removes all the bollettino bacinos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of bollettino bacinos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching bollettino bacinos
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the bollettino bacinos where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @return the matching bollettino bacinos
	 */
	public java.util.List<BollettinoBacino> findByBollettino(long idBollettino);

	/**
	 * Returns a range of all the bollettino bacinos where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @return the range of matching bollettino bacinos
	 */
	public java.util.List<BollettinoBacino> findByBollettino(
		long idBollettino, int start, int end);

	/**
	 * Returns an ordered range of all the bollettino bacinos where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bollettino bacinos
	 */
	public java.util.List<BollettinoBacino> findByBollettino(
		long idBollettino, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoBacino>
			orderByComparator);

	/**
	 * Returns an ordered range of all the bollettino bacinos where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching bollettino bacinos
	 */
	public java.util.List<BollettinoBacino> findByBollettino(
		long idBollettino, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoBacino>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first bollettino bacino in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino bacino
	 * @throws NoSuchBollettinoBacinoException if a matching bollettino bacino could not be found
	 */
	public BollettinoBacino findByBollettino_First(
			long idBollettino,
			com.liferay.portal.kernel.util.OrderByComparator<BollettinoBacino>
				orderByComparator)
		throws NoSuchBollettinoBacinoException;

	/**
	 * Returns the first bollettino bacino in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino bacino, or <code>null</code> if a matching bollettino bacino could not be found
	 */
	public BollettinoBacino fetchByBollettino_First(
		long idBollettino,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoBacino>
			orderByComparator);

	/**
	 * Returns the last bollettino bacino in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino bacino
	 * @throws NoSuchBollettinoBacinoException if a matching bollettino bacino could not be found
	 */
	public BollettinoBacino findByBollettino_Last(
			long idBollettino,
			com.liferay.portal.kernel.util.OrderByComparator<BollettinoBacino>
				orderByComparator)
		throws NoSuchBollettinoBacinoException;

	/**
	 * Returns the last bollettino bacino in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino bacino, or <code>null</code> if a matching bollettino bacino could not be found
	 */
	public BollettinoBacino fetchByBollettino_Last(
		long idBollettino,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoBacino>
			orderByComparator);

	/**
	 * Returns the bollettino bacinos before and after the current bollettino bacino in the ordered set where idBollettino = &#63;.
	 *
	 * @param id the primary key of the current bollettino bacino
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bollettino bacino
	 * @throws NoSuchBollettinoBacinoException if a bollettino bacino with the primary key could not be found
	 */
	public BollettinoBacino[] findByBollettino_PrevAndNext(
			long id, long idBollettino,
			com.liferay.portal.kernel.util.OrderByComparator<BollettinoBacino>
				orderByComparator)
		throws NoSuchBollettinoBacinoException;

	/**
	 * Removes all the bollettino bacinos where idBollettino = &#63; from the database.
	 *
	 * @param idBollettino the id bollettino
	 */
	public void removeByBollettino(long idBollettino);

	/**
	 * Returns the number of bollettino bacinos where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @return the number of matching bollettino bacinos
	 */
	public int countByBollettino(long idBollettino);

	/**
	 * Caches the bollettino bacino in the entity cache if it is enabled.
	 *
	 * @param bollettinoBacino the bollettino bacino
	 */
	public void cacheResult(BollettinoBacino bollettinoBacino);

	/**
	 * Caches the bollettino bacinos in the entity cache if it is enabled.
	 *
	 * @param bollettinoBacinos the bollettino bacinos
	 */
	public void cacheResult(java.util.List<BollettinoBacino> bollettinoBacinos);

	/**
	 * Creates a new bollettino bacino with the primary key. Does not add the bollettino bacino to the database.
	 *
	 * @param id the primary key for the new bollettino bacino
	 * @return the new bollettino bacino
	 */
	public BollettinoBacino create(long id);

	/**
	 * Removes the bollettino bacino with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the bollettino bacino
	 * @return the bollettino bacino that was removed
	 * @throws NoSuchBollettinoBacinoException if a bollettino bacino with the primary key could not be found
	 */
	public BollettinoBacino remove(long id)
		throws NoSuchBollettinoBacinoException;

	public BollettinoBacino updateImpl(BollettinoBacino bollettinoBacino);

	/**
	 * Returns the bollettino bacino with the primary key or throws a <code>NoSuchBollettinoBacinoException</code> if it could not be found.
	 *
	 * @param id the primary key of the bollettino bacino
	 * @return the bollettino bacino
	 * @throws NoSuchBollettinoBacinoException if a bollettino bacino with the primary key could not be found
	 */
	public BollettinoBacino findByPrimaryKey(long id)
		throws NoSuchBollettinoBacinoException;

	/**
	 * Returns the bollettino bacino with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the bollettino bacino
	 * @return the bollettino bacino, or <code>null</code> if a bollettino bacino with the primary key could not be found
	 */
	public BollettinoBacino fetchByPrimaryKey(long id);

	/**
	 * Returns all the bollettino bacinos.
	 *
	 * @return the bollettino bacinos
	 */
	public java.util.List<BollettinoBacino> findAll();

	/**
	 * Returns a range of all the bollettino bacinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @return the range of bollettino bacinos
	 */
	public java.util.List<BollettinoBacino> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the bollettino bacinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bollettino bacinos
	 */
	public java.util.List<BollettinoBacino> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoBacino>
			orderByComparator);

	/**
	 * Returns an ordered range of all the bollettino bacinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoBacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of bollettino bacinos
	 */
	public java.util.List<BollettinoBacino> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoBacino>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the bollettino bacinos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of bollettino bacinos.
	 *
	 * @return the number of bollettino bacinos
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}