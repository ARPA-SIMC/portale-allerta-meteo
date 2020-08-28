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

import it.eng.previsioni.meteo.exception.NoSuchStoricoException;
import it.eng.previsioni.meteo.model.Storico;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the storico service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StoricoUtil
 * @generated
 */
@ProviderType
public interface StoricoPersistence extends BasePersistence<Storico> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StoricoUtil} to access the storico persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Storico> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the storicos where sigla = &#63;.
	 *
	 * @param sigla the sigla
	 * @return the matching storicos
	 */
	public java.util.List<Storico> findBySigla(String sigla);

	/**
	 * Returns a range of all the storicos where sigla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StoricoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sigla the sigla
	 * @param start the lower bound of the range of storicos
	 * @param end the upper bound of the range of storicos (not inclusive)
	 * @return the range of matching storicos
	 */
	public java.util.List<Storico> findBySigla(
		String sigla, int start, int end);

	/**
	 * Returns an ordered range of all the storicos where sigla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StoricoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sigla the sigla
	 * @param start the lower bound of the range of storicos
	 * @param end the upper bound of the range of storicos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching storicos
	 */
	public java.util.List<Storico> findBySigla(
		String sigla, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Storico>
			orderByComparator);

	/**
	 * Returns an ordered range of all the storicos where sigla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StoricoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sigla the sigla
	 * @param start the lower bound of the range of storicos
	 * @param end the upper bound of the range of storicos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching storicos
	 */
	public java.util.List<Storico> findBySigla(
		String sigla, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Storico>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first storico in the ordered set where sigla = &#63;.
	 *
	 * @param sigla the sigla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching storico
	 * @throws NoSuchStoricoException if a matching storico could not be found
	 */
	public Storico findBySigla_First(
			String sigla,
			com.liferay.portal.kernel.util.OrderByComparator<Storico>
				orderByComparator)
		throws NoSuchStoricoException;

	/**
	 * Returns the first storico in the ordered set where sigla = &#63;.
	 *
	 * @param sigla the sigla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching storico, or <code>null</code> if a matching storico could not be found
	 */
	public Storico fetchBySigla_First(
		String sigla,
		com.liferay.portal.kernel.util.OrderByComparator<Storico>
			orderByComparator);

	/**
	 * Returns the last storico in the ordered set where sigla = &#63;.
	 *
	 * @param sigla the sigla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching storico
	 * @throws NoSuchStoricoException if a matching storico could not be found
	 */
	public Storico findBySigla_Last(
			String sigla,
			com.liferay.portal.kernel.util.OrderByComparator<Storico>
				orderByComparator)
		throws NoSuchStoricoException;

	/**
	 * Returns the last storico in the ordered set where sigla = &#63;.
	 *
	 * @param sigla the sigla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching storico, or <code>null</code> if a matching storico could not be found
	 */
	public Storico fetchBySigla_Last(
		String sigla,
		com.liferay.portal.kernel.util.OrderByComparator<Storico>
			orderByComparator);

	/**
	 * Returns the storicos before and after the current storico in the ordered set where sigla = &#63;.
	 *
	 * @param id the primary key of the current storico
	 * @param sigla the sigla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next storico
	 * @throws NoSuchStoricoException if a storico with the primary key could not be found
	 */
	public Storico[] findBySigla_PrevAndNext(
			long id, String sigla,
			com.liferay.portal.kernel.util.OrderByComparator<Storico>
				orderByComparator)
		throws NoSuchStoricoException;

	/**
	 * Removes all the storicos where sigla = &#63; from the database.
	 *
	 * @param sigla the sigla
	 */
	public void removeBySigla(String sigla);

	/**
	 * Returns the number of storicos where sigla = &#63;.
	 *
	 * @param sigla the sigla
	 * @return the number of matching storicos
	 */
	public int countBySigla(String sigla);

	/**
	 * Caches the storico in the entity cache if it is enabled.
	 *
	 * @param storico the storico
	 */
	public void cacheResult(Storico storico);

	/**
	 * Caches the storicos in the entity cache if it is enabled.
	 *
	 * @param storicos the storicos
	 */
	public void cacheResult(java.util.List<Storico> storicos);

	/**
	 * Creates a new storico with the primary key. Does not add the storico to the database.
	 *
	 * @param id the primary key for the new storico
	 * @return the new storico
	 */
	public Storico create(long id);

	/**
	 * Removes the storico with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the storico
	 * @return the storico that was removed
	 * @throws NoSuchStoricoException if a storico with the primary key could not be found
	 */
	public Storico remove(long id) throws NoSuchStoricoException;

	public Storico updateImpl(Storico storico);

	/**
	 * Returns the storico with the primary key or throws a <code>NoSuchStoricoException</code> if it could not be found.
	 *
	 * @param id the primary key of the storico
	 * @return the storico
	 * @throws NoSuchStoricoException if a storico with the primary key could not be found
	 */
	public Storico findByPrimaryKey(long id) throws NoSuchStoricoException;

	/**
	 * Returns the storico with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the storico
	 * @return the storico, or <code>null</code> if a storico with the primary key could not be found
	 */
	public Storico fetchByPrimaryKey(long id);

	/**
	 * Returns all the storicos.
	 *
	 * @return the storicos
	 */
	public java.util.List<Storico> findAll();

	/**
	 * Returns a range of all the storicos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StoricoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of storicos
	 * @param end the upper bound of the range of storicos (not inclusive)
	 * @return the range of storicos
	 */
	public java.util.List<Storico> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the storicos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StoricoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of storicos
	 * @param end the upper bound of the range of storicos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of storicos
	 */
	public java.util.List<Storico> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Storico>
			orderByComparator);

	/**
	 * Returns an ordered range of all the storicos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StoricoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of storicos
	 * @param end the upper bound of the range of storicos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of storicos
	 */
	public java.util.List<Storico> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Storico>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the storicos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of storicos.
	 *
	 * @return the number of storicos
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}