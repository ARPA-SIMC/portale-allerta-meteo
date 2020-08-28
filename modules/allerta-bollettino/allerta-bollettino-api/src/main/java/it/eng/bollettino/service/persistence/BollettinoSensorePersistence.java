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

import it.eng.bollettino.exception.NoSuchBollettinoSensoreException;
import it.eng.bollettino.model.BollettinoSensore;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the bollettino sensore service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see BollettinoSensoreUtil
 * @generated
 */
@ProviderType
public interface BollettinoSensorePersistence
	extends BasePersistence<BollettinoSensore> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BollettinoSensoreUtil} to access the bollettino sensore persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, BollettinoSensore> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the bollettino sensores where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching bollettino sensores
	 */
	public java.util.List<BollettinoSensore> findByUuid(String uuid);

	/**
	 * Returns a range of all the bollettino sensores where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino sensores
	 * @param end the upper bound of the range of bollettino sensores (not inclusive)
	 * @return the range of matching bollettino sensores
	 */
	public java.util.List<BollettinoSensore> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the bollettino sensores where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino sensores
	 * @param end the upper bound of the range of bollettino sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bollettino sensores
	 */
	public java.util.List<BollettinoSensore> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoSensore>
			orderByComparator);

	/**
	 * Returns an ordered range of all the bollettino sensores where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino sensores
	 * @param end the upper bound of the range of bollettino sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching bollettino sensores
	 */
	public java.util.List<BollettinoSensore> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoSensore>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first bollettino sensore in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino sensore
	 * @throws NoSuchBollettinoSensoreException if a matching bollettino sensore could not be found
	 */
	public BollettinoSensore findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BollettinoSensore>
				orderByComparator)
		throws NoSuchBollettinoSensoreException;

	/**
	 * Returns the first bollettino sensore in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino sensore, or <code>null</code> if a matching bollettino sensore could not be found
	 */
	public BollettinoSensore fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoSensore>
			orderByComparator);

	/**
	 * Returns the last bollettino sensore in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino sensore
	 * @throws NoSuchBollettinoSensoreException if a matching bollettino sensore could not be found
	 */
	public BollettinoSensore findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BollettinoSensore>
				orderByComparator)
		throws NoSuchBollettinoSensoreException;

	/**
	 * Returns the last bollettino sensore in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino sensore, or <code>null</code> if a matching bollettino sensore could not be found
	 */
	public BollettinoSensore fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoSensore>
			orderByComparator);

	/**
	 * Returns the bollettino sensores before and after the current bollettino sensore in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current bollettino sensore
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bollettino sensore
	 * @throws NoSuchBollettinoSensoreException if a bollettino sensore with the primary key could not be found
	 */
	public BollettinoSensore[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BollettinoSensore>
				orderByComparator)
		throws NoSuchBollettinoSensoreException;

	/**
	 * Removes all the bollettino sensores where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of bollettino sensores where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching bollettino sensores
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the bollettino sensores where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @return the matching bollettino sensores
	 */
	public java.util.List<BollettinoSensore> findByBollettino(
		long idBollettino);

	/**
	 * Returns a range of all the bollettino sensores where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino sensores
	 * @param end the upper bound of the range of bollettino sensores (not inclusive)
	 * @return the range of matching bollettino sensores
	 */
	public java.util.List<BollettinoSensore> findByBollettino(
		long idBollettino, int start, int end);

	/**
	 * Returns an ordered range of all the bollettino sensores where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino sensores
	 * @param end the upper bound of the range of bollettino sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bollettino sensores
	 */
	public java.util.List<BollettinoSensore> findByBollettino(
		long idBollettino, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoSensore>
			orderByComparator);

	/**
	 * Returns an ordered range of all the bollettino sensores where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino sensores
	 * @param end the upper bound of the range of bollettino sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching bollettino sensores
	 */
	public java.util.List<BollettinoSensore> findByBollettino(
		long idBollettino, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoSensore>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first bollettino sensore in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino sensore
	 * @throws NoSuchBollettinoSensoreException if a matching bollettino sensore could not be found
	 */
	public BollettinoSensore findByBollettino_First(
			long idBollettino,
			com.liferay.portal.kernel.util.OrderByComparator<BollettinoSensore>
				orderByComparator)
		throws NoSuchBollettinoSensoreException;

	/**
	 * Returns the first bollettino sensore in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino sensore, or <code>null</code> if a matching bollettino sensore could not be found
	 */
	public BollettinoSensore fetchByBollettino_First(
		long idBollettino,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoSensore>
			orderByComparator);

	/**
	 * Returns the last bollettino sensore in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino sensore
	 * @throws NoSuchBollettinoSensoreException if a matching bollettino sensore could not be found
	 */
	public BollettinoSensore findByBollettino_Last(
			long idBollettino,
			com.liferay.portal.kernel.util.OrderByComparator<BollettinoSensore>
				orderByComparator)
		throws NoSuchBollettinoSensoreException;

	/**
	 * Returns the last bollettino sensore in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino sensore, or <code>null</code> if a matching bollettino sensore could not be found
	 */
	public BollettinoSensore fetchByBollettino_Last(
		long idBollettino,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoSensore>
			orderByComparator);

	/**
	 * Returns the bollettino sensores before and after the current bollettino sensore in the ordered set where idBollettino = &#63;.
	 *
	 * @param id the primary key of the current bollettino sensore
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bollettino sensore
	 * @throws NoSuchBollettinoSensoreException if a bollettino sensore with the primary key could not be found
	 */
	public BollettinoSensore[] findByBollettino_PrevAndNext(
			long id, long idBollettino,
			com.liferay.portal.kernel.util.OrderByComparator<BollettinoSensore>
				orderByComparator)
		throws NoSuchBollettinoSensoreException;

	/**
	 * Removes all the bollettino sensores where idBollettino = &#63; from the database.
	 *
	 * @param idBollettino the id bollettino
	 */
	public void removeByBollettino(long idBollettino);

	/**
	 * Returns the number of bollettino sensores where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @return the number of matching bollettino sensores
	 */
	public int countByBollettino(long idBollettino);

	/**
	 * Caches the bollettino sensore in the entity cache if it is enabled.
	 *
	 * @param bollettinoSensore the bollettino sensore
	 */
	public void cacheResult(BollettinoSensore bollettinoSensore);

	/**
	 * Caches the bollettino sensores in the entity cache if it is enabled.
	 *
	 * @param bollettinoSensores the bollettino sensores
	 */
	public void cacheResult(
		java.util.List<BollettinoSensore> bollettinoSensores);

	/**
	 * Creates a new bollettino sensore with the primary key. Does not add the bollettino sensore to the database.
	 *
	 * @param id the primary key for the new bollettino sensore
	 * @return the new bollettino sensore
	 */
	public BollettinoSensore create(long id);

	/**
	 * Removes the bollettino sensore with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the bollettino sensore
	 * @return the bollettino sensore that was removed
	 * @throws NoSuchBollettinoSensoreException if a bollettino sensore with the primary key could not be found
	 */
	public BollettinoSensore remove(long id)
		throws NoSuchBollettinoSensoreException;

	public BollettinoSensore updateImpl(BollettinoSensore bollettinoSensore);

	/**
	 * Returns the bollettino sensore with the primary key or throws a <code>NoSuchBollettinoSensoreException</code> if it could not be found.
	 *
	 * @param id the primary key of the bollettino sensore
	 * @return the bollettino sensore
	 * @throws NoSuchBollettinoSensoreException if a bollettino sensore with the primary key could not be found
	 */
	public BollettinoSensore findByPrimaryKey(long id)
		throws NoSuchBollettinoSensoreException;

	/**
	 * Returns the bollettino sensore with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the bollettino sensore
	 * @return the bollettino sensore, or <code>null</code> if a bollettino sensore with the primary key could not be found
	 */
	public BollettinoSensore fetchByPrimaryKey(long id);

	/**
	 * Returns all the bollettino sensores.
	 *
	 * @return the bollettino sensores
	 */
	public java.util.List<BollettinoSensore> findAll();

	/**
	 * Returns a range of all the bollettino sensores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino sensores
	 * @param end the upper bound of the range of bollettino sensores (not inclusive)
	 * @return the range of bollettino sensores
	 */
	public java.util.List<BollettinoSensore> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the bollettino sensores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino sensores
	 * @param end the upper bound of the range of bollettino sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bollettino sensores
	 */
	public java.util.List<BollettinoSensore> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoSensore>
			orderByComparator);

	/**
	 * Returns an ordered range of all the bollettino sensores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino sensores
	 * @param end the upper bound of the range of bollettino sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of bollettino sensores
	 */
	public java.util.List<BollettinoSensore> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoSensore>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the bollettino sensores from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of bollettino sensores.
	 *
	 * @return the number of bollettino sensores
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}