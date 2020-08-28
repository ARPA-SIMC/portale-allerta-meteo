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

import it.eng.bollettino.exception.NoSuchBollettinoIconaException;
import it.eng.bollettino.model.BollettinoIcona;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the bollettino icona service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see BollettinoIconaUtil
 * @generated
 */
@ProviderType
public interface BollettinoIconaPersistence
	extends BasePersistence<BollettinoIcona> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BollettinoIconaUtil} to access the bollettino icona persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, BollettinoIcona> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the bollettino iconas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching bollettino iconas
	 */
	public java.util.List<BollettinoIcona> findByUuid(String uuid);

	/**
	 * Returns a range of all the bollettino iconas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @return the range of matching bollettino iconas
	 */
	public java.util.List<BollettinoIcona> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the bollettino iconas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bollettino iconas
	 */
	public java.util.List<BollettinoIcona> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoIcona>
			orderByComparator);

	/**
	 * Returns an ordered range of all the bollettino iconas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching bollettino iconas
	 */
	public java.util.List<BollettinoIcona> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoIcona>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first bollettino icona in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino icona
	 * @throws NoSuchBollettinoIconaException if a matching bollettino icona could not be found
	 */
	public BollettinoIcona findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BollettinoIcona>
				orderByComparator)
		throws NoSuchBollettinoIconaException;

	/**
	 * Returns the first bollettino icona in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino icona, or <code>null</code> if a matching bollettino icona could not be found
	 */
	public BollettinoIcona fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoIcona>
			orderByComparator);

	/**
	 * Returns the last bollettino icona in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino icona
	 * @throws NoSuchBollettinoIconaException if a matching bollettino icona could not be found
	 */
	public BollettinoIcona findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BollettinoIcona>
				orderByComparator)
		throws NoSuchBollettinoIconaException;

	/**
	 * Returns the last bollettino icona in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino icona, or <code>null</code> if a matching bollettino icona could not be found
	 */
	public BollettinoIcona fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoIcona>
			orderByComparator);

	/**
	 * Returns the bollettino iconas before and after the current bollettino icona in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current bollettino icona
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bollettino icona
	 * @throws NoSuchBollettinoIconaException if a bollettino icona with the primary key could not be found
	 */
	public BollettinoIcona[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BollettinoIcona>
				orderByComparator)
		throws NoSuchBollettinoIconaException;

	/**
	 * Removes all the bollettino iconas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of bollettino iconas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching bollettino iconas
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the bollettino iconas where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @return the matching bollettino iconas
	 */
	public java.util.List<BollettinoIcona> findByBollettino(long idBollettino);

	/**
	 * Returns a range of all the bollettino iconas where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @return the range of matching bollettino iconas
	 */
	public java.util.List<BollettinoIcona> findByBollettino(
		long idBollettino, int start, int end);

	/**
	 * Returns an ordered range of all the bollettino iconas where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bollettino iconas
	 */
	public java.util.List<BollettinoIcona> findByBollettino(
		long idBollettino, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoIcona>
			orderByComparator);

	/**
	 * Returns an ordered range of all the bollettino iconas where idBollettino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idBollettino the id bollettino
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching bollettino iconas
	 */
	public java.util.List<BollettinoIcona> findByBollettino(
		long idBollettino, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoIcona>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first bollettino icona in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino icona
	 * @throws NoSuchBollettinoIconaException if a matching bollettino icona could not be found
	 */
	public BollettinoIcona findByBollettino_First(
			long idBollettino,
			com.liferay.portal.kernel.util.OrderByComparator<BollettinoIcona>
				orderByComparator)
		throws NoSuchBollettinoIconaException;

	/**
	 * Returns the first bollettino icona in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino icona, or <code>null</code> if a matching bollettino icona could not be found
	 */
	public BollettinoIcona fetchByBollettino_First(
		long idBollettino,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoIcona>
			orderByComparator);

	/**
	 * Returns the last bollettino icona in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino icona
	 * @throws NoSuchBollettinoIconaException if a matching bollettino icona could not be found
	 */
	public BollettinoIcona findByBollettino_Last(
			long idBollettino,
			com.liferay.portal.kernel.util.OrderByComparator<BollettinoIcona>
				orderByComparator)
		throws NoSuchBollettinoIconaException;

	/**
	 * Returns the last bollettino icona in the ordered set where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino icona, or <code>null</code> if a matching bollettino icona could not be found
	 */
	public BollettinoIcona fetchByBollettino_Last(
		long idBollettino,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoIcona>
			orderByComparator);

	/**
	 * Returns the bollettino iconas before and after the current bollettino icona in the ordered set where idBollettino = &#63;.
	 *
	 * @param id the primary key of the current bollettino icona
	 * @param idBollettino the id bollettino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bollettino icona
	 * @throws NoSuchBollettinoIconaException if a bollettino icona with the primary key could not be found
	 */
	public BollettinoIcona[] findByBollettino_PrevAndNext(
			long id, long idBollettino,
			com.liferay.portal.kernel.util.OrderByComparator<BollettinoIcona>
				orderByComparator)
		throws NoSuchBollettinoIconaException;

	/**
	 * Removes all the bollettino iconas where idBollettino = &#63; from the database.
	 *
	 * @param idBollettino the id bollettino
	 */
	public void removeByBollettino(long idBollettino);

	/**
	 * Returns the number of bollettino iconas where idBollettino = &#63;.
	 *
	 * @param idBollettino the id bollettino
	 * @return the number of matching bollettino iconas
	 */
	public int countByBollettino(long idBollettino);

	/**
	 * Caches the bollettino icona in the entity cache if it is enabled.
	 *
	 * @param bollettinoIcona the bollettino icona
	 */
	public void cacheResult(BollettinoIcona bollettinoIcona);

	/**
	 * Caches the bollettino iconas in the entity cache if it is enabled.
	 *
	 * @param bollettinoIconas the bollettino iconas
	 */
	public void cacheResult(java.util.List<BollettinoIcona> bollettinoIconas);

	/**
	 * Creates a new bollettino icona with the primary key. Does not add the bollettino icona to the database.
	 *
	 * @param id the primary key for the new bollettino icona
	 * @return the new bollettino icona
	 */
	public BollettinoIcona create(long id);

	/**
	 * Removes the bollettino icona with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the bollettino icona
	 * @return the bollettino icona that was removed
	 * @throws NoSuchBollettinoIconaException if a bollettino icona with the primary key could not be found
	 */
	public BollettinoIcona remove(long id)
		throws NoSuchBollettinoIconaException;

	public BollettinoIcona updateImpl(BollettinoIcona bollettinoIcona);

	/**
	 * Returns the bollettino icona with the primary key or throws a <code>NoSuchBollettinoIconaException</code> if it could not be found.
	 *
	 * @param id the primary key of the bollettino icona
	 * @return the bollettino icona
	 * @throws NoSuchBollettinoIconaException if a bollettino icona with the primary key could not be found
	 */
	public BollettinoIcona findByPrimaryKey(long id)
		throws NoSuchBollettinoIconaException;

	/**
	 * Returns the bollettino icona with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the bollettino icona
	 * @return the bollettino icona, or <code>null</code> if a bollettino icona with the primary key could not be found
	 */
	public BollettinoIcona fetchByPrimaryKey(long id);

	/**
	 * Returns all the bollettino iconas.
	 *
	 * @return the bollettino iconas
	 */
	public java.util.List<BollettinoIcona> findAll();

	/**
	 * Returns a range of all the bollettino iconas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @return the range of bollettino iconas
	 */
	public java.util.List<BollettinoIcona> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the bollettino iconas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bollettino iconas
	 */
	public java.util.List<BollettinoIcona> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoIcona>
			orderByComparator);

	/**
	 * Returns an ordered range of all the bollettino iconas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoIconaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of bollettino iconas
	 */
	public java.util.List<BollettinoIcona> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BollettinoIcona>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the bollettino iconas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of bollettino iconas.
	 *
	 * @return the number of bollettino iconas
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}