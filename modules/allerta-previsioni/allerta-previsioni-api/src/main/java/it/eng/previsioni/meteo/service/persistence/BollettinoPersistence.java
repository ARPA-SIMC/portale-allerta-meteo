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

package it.eng.previsioni.meteo.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.previsioni.meteo.exception.NoSuchBollettinoException;
import it.eng.previsioni.meteo.model.Bollettino;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the bollettino service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BollettinoUtil
 * @generated
 */
@ProviderType
public interface BollettinoPersistence extends BasePersistence<Bollettino> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BollettinoUtil} to access the bollettino persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Bollettino> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns the bollettino where tipo = &#63; or throws a <code>NoSuchBollettinoException</code> if it could not be found.
	 *
	 * @param tipo the tipo
	 * @return the matching bollettino
	 * @throws NoSuchBollettinoException if a matching bollettino could not be found
	 */
	public Bollettino findBytipo(String tipo) throws NoSuchBollettinoException;

	/**
	 * Returns the bollettino where tipo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tipo the tipo
	 * @return the matching bollettino, or <code>null</code> if a matching bollettino could not be found
	 */
	public Bollettino fetchBytipo(String tipo);

	/**
	 * Returns the bollettino where tipo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tipo the tipo
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching bollettino, or <code>null</code> if a matching bollettino could not be found
	 */
	public Bollettino fetchBytipo(String tipo, boolean retrieveFromCache);

	/**
	 * Removes the bollettino where tipo = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @return the bollettino that was removed
	 */
	public Bollettino removeBytipo(String tipo)
		throws NoSuchBollettinoException;

	/**
	 * Returns the number of bollettinos where tipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @return the number of matching bollettinos
	 */
	public int countBytipo(String tipo);

	/**
	 * Caches the bollettino in the entity cache if it is enabled.
	 *
	 * @param bollettino the bollettino
	 */
	public void cacheResult(Bollettino bollettino);

	/**
	 * Caches the bollettinos in the entity cache if it is enabled.
	 *
	 * @param bollettinos the bollettinos
	 */
	public void cacheResult(java.util.List<Bollettino> bollettinos);

	/**
	 * Creates a new bollettino with the primary key. Does not add the bollettino to the database.
	 *
	 * @param id the primary key for the new bollettino
	 * @return the new bollettino
	 */
	public Bollettino create(long id);

	/**
	 * Removes the bollettino with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the bollettino
	 * @return the bollettino that was removed
	 * @throws NoSuchBollettinoException if a bollettino with the primary key could not be found
	 */
	public Bollettino remove(long id) throws NoSuchBollettinoException;

	public Bollettino updateImpl(Bollettino bollettino);

	/**
	 * Returns the bollettino with the primary key or throws a <code>NoSuchBollettinoException</code> if it could not be found.
	 *
	 * @param id the primary key of the bollettino
	 * @return the bollettino
	 * @throws NoSuchBollettinoException if a bollettino with the primary key could not be found
	 */
	public Bollettino findByPrimaryKey(long id)
		throws NoSuchBollettinoException;

	/**
	 * Returns the bollettino with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the bollettino
	 * @return the bollettino, or <code>null</code> if a bollettino with the primary key could not be found
	 */
	public Bollettino fetchByPrimaryKey(long id);

	/**
	 * Returns all the bollettinos.
	 *
	 * @return the bollettinos
	 */
	public java.util.List<Bollettino> findAll();

	/**
	 * Returns a range of all the bollettinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @return the range of bollettinos
	 */
	public java.util.List<Bollettino> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the bollettinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bollettinos
	 */
	public java.util.List<Bollettino> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Bollettino>
			orderByComparator);

	/**
	 * Returns an ordered range of all the bollettinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of bollettinos
	 */
	public java.util.List<Bollettino> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Bollettino>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the bollettinos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of bollettinos.
	 *
	 * @return the number of bollettinos
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}