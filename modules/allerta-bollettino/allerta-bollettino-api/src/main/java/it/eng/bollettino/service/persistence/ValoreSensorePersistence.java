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

import it.eng.bollettino.exception.NoSuchValoreSensoreException;
import it.eng.bollettino.model.ValoreSensore;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the valore sensore service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see ValoreSensoreUtil
 * @generated
 */
@ProviderType
public interface ValoreSensorePersistence
	extends BasePersistence<ValoreSensore> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ValoreSensoreUtil} to access the valore sensore persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, ValoreSensore> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the valore sensores where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching valore sensores
	 */
	public java.util.List<ValoreSensore> findByUuid(String uuid);

	/**
	 * Returns a range of all the valore sensores where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @return the range of matching valore sensores
	 */
	public java.util.List<ValoreSensore> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the valore sensores where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching valore sensores
	 */
	public java.util.List<ValoreSensore> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ValoreSensore>
			orderByComparator);

	/**
	 * Returns an ordered range of all the valore sensores where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching valore sensores
	 */
	public java.util.List<ValoreSensore> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ValoreSensore>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first valore sensore in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching valore sensore
	 * @throws NoSuchValoreSensoreException if a matching valore sensore could not be found
	 */
	public ValoreSensore findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ValoreSensore>
				orderByComparator)
		throws NoSuchValoreSensoreException;

	/**
	 * Returns the first valore sensore in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching valore sensore, or <code>null</code> if a matching valore sensore could not be found
	 */
	public ValoreSensore fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ValoreSensore>
			orderByComparator);

	/**
	 * Returns the last valore sensore in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching valore sensore
	 * @throws NoSuchValoreSensoreException if a matching valore sensore could not be found
	 */
	public ValoreSensore findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ValoreSensore>
				orderByComparator)
		throws NoSuchValoreSensoreException;

	/**
	 * Returns the last valore sensore in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching valore sensore, or <code>null</code> if a matching valore sensore could not be found
	 */
	public ValoreSensore fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ValoreSensore>
			orderByComparator);

	/**
	 * Returns the valore sensores before and after the current valore sensore in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current valore sensore
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next valore sensore
	 * @throws NoSuchValoreSensoreException if a valore sensore with the primary key could not be found
	 */
	public ValoreSensore[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ValoreSensore>
				orderByComparator)
		throws NoSuchValoreSensoreException;

	/**
	 * Removes all the valore sensores where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of valore sensores where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching valore sensores
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the valore sensores where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @return the matching valore sensores
	 */
	public java.util.List<ValoreSensore> findByvariabileStazione(
		String idVariabile, String idStazione);

	/**
	 * Returns a range of all the valore sensores where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @return the range of matching valore sensores
	 */
	public java.util.List<ValoreSensore> findByvariabileStazione(
		String idVariabile, String idStazione, int start, int end);

	/**
	 * Returns an ordered range of all the valore sensores where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching valore sensores
	 */
	public java.util.List<ValoreSensore> findByvariabileStazione(
		String idVariabile, String idStazione, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ValoreSensore>
			orderByComparator);

	/**
	 * Returns an ordered range of all the valore sensores where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching valore sensores
	 */
	public java.util.List<ValoreSensore> findByvariabileStazione(
		String idVariabile, String idStazione, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ValoreSensore>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first valore sensore in the ordered set where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching valore sensore
	 * @throws NoSuchValoreSensoreException if a matching valore sensore could not be found
	 */
	public ValoreSensore findByvariabileStazione_First(
			String idVariabile, String idStazione,
			com.liferay.portal.kernel.util.OrderByComparator<ValoreSensore>
				orderByComparator)
		throws NoSuchValoreSensoreException;

	/**
	 * Returns the first valore sensore in the ordered set where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching valore sensore, or <code>null</code> if a matching valore sensore could not be found
	 */
	public ValoreSensore fetchByvariabileStazione_First(
		String idVariabile, String idStazione,
		com.liferay.portal.kernel.util.OrderByComparator<ValoreSensore>
			orderByComparator);

	/**
	 * Returns the last valore sensore in the ordered set where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching valore sensore
	 * @throws NoSuchValoreSensoreException if a matching valore sensore could not be found
	 */
	public ValoreSensore findByvariabileStazione_Last(
			String idVariabile, String idStazione,
			com.liferay.portal.kernel.util.OrderByComparator<ValoreSensore>
				orderByComparator)
		throws NoSuchValoreSensoreException;

	/**
	 * Returns the last valore sensore in the ordered set where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching valore sensore, or <code>null</code> if a matching valore sensore could not be found
	 */
	public ValoreSensore fetchByvariabileStazione_Last(
		String idVariabile, String idStazione,
		com.liferay.portal.kernel.util.OrderByComparator<ValoreSensore>
			orderByComparator);

	/**
	 * Returns the valore sensores before and after the current valore sensore in the ordered set where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * @param id the primary key of the current valore sensore
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next valore sensore
	 * @throws NoSuchValoreSensoreException if a valore sensore with the primary key could not be found
	 */
	public ValoreSensore[] findByvariabileStazione_PrevAndNext(
			long id, String idVariabile, String idStazione,
			com.liferay.portal.kernel.util.OrderByComparator<ValoreSensore>
				orderByComparator)
		throws NoSuchValoreSensoreException;

	/**
	 * Removes all the valore sensores where idVariabile = &#63; and idStazione = &#63; from the database.
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 */
	public void removeByvariabileStazione(
		String idVariabile, String idStazione);

	/**
	 * Returns the number of valore sensores where idVariabile = &#63; and idStazione = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param idStazione the id stazione
	 * @return the number of matching valore sensores
	 */
	public int countByvariabileStazione(String idVariabile, String idStazione);

	/**
	 * Caches the valore sensore in the entity cache if it is enabled.
	 *
	 * @param valoreSensore the valore sensore
	 */
	public void cacheResult(ValoreSensore valoreSensore);

	/**
	 * Caches the valore sensores in the entity cache if it is enabled.
	 *
	 * @param valoreSensores the valore sensores
	 */
	public void cacheResult(java.util.List<ValoreSensore> valoreSensores);

	/**
	 * Creates a new valore sensore with the primary key. Does not add the valore sensore to the database.
	 *
	 * @param id the primary key for the new valore sensore
	 * @return the new valore sensore
	 */
	public ValoreSensore create(long id);

	/**
	 * Removes the valore sensore with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the valore sensore
	 * @return the valore sensore that was removed
	 * @throws NoSuchValoreSensoreException if a valore sensore with the primary key could not be found
	 */
	public ValoreSensore remove(long id) throws NoSuchValoreSensoreException;

	public ValoreSensore updateImpl(ValoreSensore valoreSensore);

	/**
	 * Returns the valore sensore with the primary key or throws a <code>NoSuchValoreSensoreException</code> if it could not be found.
	 *
	 * @param id the primary key of the valore sensore
	 * @return the valore sensore
	 * @throws NoSuchValoreSensoreException if a valore sensore with the primary key could not be found
	 */
	public ValoreSensore findByPrimaryKey(long id)
		throws NoSuchValoreSensoreException;

	/**
	 * Returns the valore sensore with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the valore sensore
	 * @return the valore sensore, or <code>null</code> if a valore sensore with the primary key could not be found
	 */
	public ValoreSensore fetchByPrimaryKey(long id);

	/**
	 * Returns all the valore sensores.
	 *
	 * @return the valore sensores
	 */
	public java.util.List<ValoreSensore> findAll();

	/**
	 * Returns a range of all the valore sensores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @return the range of valore sensores
	 */
	public java.util.List<ValoreSensore> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the valore sensores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of valore sensores
	 */
	public java.util.List<ValoreSensore> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ValoreSensore>
			orderByComparator);

	/**
	 * Returns an ordered range of all the valore sensores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ValoreSensoreModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of valore sensores
	 * @param end the upper bound of the range of valore sensores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of valore sensores
	 */
	public java.util.List<ValoreSensore> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ValoreSensore>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the valore sensores from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of valore sensores.
	 *
	 * @return the number of valore sensores
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}