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

package it.eng.cache.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.cache.exception.NoSuchDatiException;
import it.eng.cache.model.Dati;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the dati service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see DatiUtil
 * @generated
 */
@ProviderType
public interface DatiPersistence extends BasePersistence<Dati> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DatiUtil} to access the dati persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Dati> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Caches the dati in the entity cache if it is enabled.
	 *
	 * @param dati the dati
	 */
	public void cacheResult(Dati dati);

	/**
	 * Caches the datis in the entity cache if it is enabled.
	 *
	 * @param datis the datis
	 */
	public void cacheResult(java.util.List<Dati> datis);

	/**
	 * Creates a new dati with the primary key. Does not add the dati to the database.
	 *
	 * @param idDati the primary key for the new dati
	 * @return the new dati
	 */
	public Dati create(String idDati);

	/**
	 * Removes the dati with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idDati the primary key of the dati
	 * @return the dati that was removed
	 * @throws NoSuchDatiException if a dati with the primary key could not be found
	 */
	public Dati remove(String idDati) throws NoSuchDatiException;

	public Dati updateImpl(Dati dati);

	/**
	 * Returns the dati with the primary key or throws a <code>NoSuchDatiException</code> if it could not be found.
	 *
	 * @param idDati the primary key of the dati
	 * @return the dati
	 * @throws NoSuchDatiException if a dati with the primary key could not be found
	 */
	public Dati findByPrimaryKey(String idDati) throws NoSuchDatiException;

	/**
	 * Returns the dati with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idDati the primary key of the dati
	 * @return the dati, or <code>null</code> if a dati with the primary key could not be found
	 */
	public Dati fetchByPrimaryKey(String idDati);

	/**
	 * Returns all the datis.
	 *
	 * @return the datis
	 */
	public java.util.List<Dati> findAll();

	/**
	 * Returns a range of all the datis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DatiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of datis
	 * @param end the upper bound of the range of datis (not inclusive)
	 * @return the range of datis
	 */
	public java.util.List<Dati> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the datis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DatiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of datis
	 * @param end the upper bound of the range of datis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of datis
	 */
	public java.util.List<Dati> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dati>
			orderByComparator);

	/**
	 * Returns an ordered range of all the datis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DatiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of datis
	 * @param end the upper bound of the range of datis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of datis
	 */
	public java.util.List<Dati> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dati>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the datis from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of datis.
	 *
	 * @return the number of datis
	 */
	public int countAll();

}