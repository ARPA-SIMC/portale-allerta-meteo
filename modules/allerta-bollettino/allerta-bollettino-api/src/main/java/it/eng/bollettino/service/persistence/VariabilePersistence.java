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

import it.eng.bollettino.exception.NoSuchVariabileException;
import it.eng.bollettino.model.Variabile;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the variabile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see VariabileUtil
 * @generated
 */
@ProviderType
public interface VariabilePersistence extends BasePersistence<Variabile> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VariabileUtil} to access the variabile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Variabile> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the variabiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching variabiles
	 */
	public java.util.List<Variabile> findByUuid(String uuid);

	/**
	 * Returns a range of all the variabiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VariabileModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of variabiles
	 * @param end the upper bound of the range of variabiles (not inclusive)
	 * @return the range of matching variabiles
	 */
	public java.util.List<Variabile> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the variabiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VariabileModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of variabiles
	 * @param end the upper bound of the range of variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching variabiles
	 */
	public java.util.List<Variabile> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Variabile>
			orderByComparator);

	/**
	 * Returns an ordered range of all the variabiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VariabileModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of variabiles
	 * @param end the upper bound of the range of variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching variabiles
	 */
	public java.util.List<Variabile> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Variabile>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first variabile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching variabile
	 * @throws NoSuchVariabileException if a matching variabile could not be found
	 */
	public Variabile findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Variabile>
				orderByComparator)
		throws NoSuchVariabileException;

	/**
	 * Returns the first variabile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching variabile, or <code>null</code> if a matching variabile could not be found
	 */
	public Variabile fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Variabile>
			orderByComparator);

	/**
	 * Returns the last variabile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching variabile
	 * @throws NoSuchVariabileException if a matching variabile could not be found
	 */
	public Variabile findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Variabile>
				orderByComparator)
		throws NoSuchVariabileException;

	/**
	 * Returns the last variabile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching variabile, or <code>null</code> if a matching variabile could not be found
	 */
	public Variabile fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Variabile>
			orderByComparator);

	/**
	 * Returns the variabiles before and after the current variabile in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current variabile
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next variabile
	 * @throws NoSuchVariabileException if a variabile with the primary key could not be found
	 */
	public Variabile[] findByUuid_PrevAndNext(
			String id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Variabile>
				orderByComparator)
		throws NoSuchVariabileException;

	/**
	 * Removes all the variabiles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of variabiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching variabiles
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the variabile in the entity cache if it is enabled.
	 *
	 * @param variabile the variabile
	 */
	public void cacheResult(Variabile variabile);

	/**
	 * Caches the variabiles in the entity cache if it is enabled.
	 *
	 * @param variabiles the variabiles
	 */
	public void cacheResult(java.util.List<Variabile> variabiles);

	/**
	 * Creates a new variabile with the primary key. Does not add the variabile to the database.
	 *
	 * @param id the primary key for the new variabile
	 * @return the new variabile
	 */
	public Variabile create(String id);

	/**
	 * Removes the variabile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the variabile
	 * @return the variabile that was removed
	 * @throws NoSuchVariabileException if a variabile with the primary key could not be found
	 */
	public Variabile remove(String id) throws NoSuchVariabileException;

	public Variabile updateImpl(Variabile variabile);

	/**
	 * Returns the variabile with the primary key or throws a <code>NoSuchVariabileException</code> if it could not be found.
	 *
	 * @param id the primary key of the variabile
	 * @return the variabile
	 * @throws NoSuchVariabileException if a variabile with the primary key could not be found
	 */
	public Variabile findByPrimaryKey(String id)
		throws NoSuchVariabileException;

	/**
	 * Returns the variabile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the variabile
	 * @return the variabile, or <code>null</code> if a variabile with the primary key could not be found
	 */
	public Variabile fetchByPrimaryKey(String id);

	/**
	 * Returns all the variabiles.
	 *
	 * @return the variabiles
	 */
	public java.util.List<Variabile> findAll();

	/**
	 * Returns a range of all the variabiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VariabileModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of variabiles
	 * @param end the upper bound of the range of variabiles (not inclusive)
	 * @return the range of variabiles
	 */
	public java.util.List<Variabile> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the variabiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VariabileModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of variabiles
	 * @param end the upper bound of the range of variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of variabiles
	 */
	public java.util.List<Variabile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Variabile>
			orderByComparator);

	/**
	 * Returns an ordered range of all the variabiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>VariabileModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of variabiles
	 * @param end the upper bound of the range of variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of variabiles
	 */
	public java.util.List<Variabile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Variabile>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the variabiles from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of variabiles.
	 *
	 * @return the number of variabiles
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}