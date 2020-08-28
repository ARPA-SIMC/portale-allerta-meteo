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

import it.eng.bollettino.exception.NoSuchRegolaAllarmeCondizioneException;
import it.eng.bollettino.model.RegolaAllarmeCondizione;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the regola allarme condizione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see RegolaAllarmeCondizioneUtil
 * @generated
 */
@ProviderType
public interface RegolaAllarmeCondizionePersistence
	extends BasePersistence<RegolaAllarmeCondizione> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RegolaAllarmeCondizioneUtil} to access the regola allarme condizione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, RegolaAllarmeCondizione> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the regola allarme condiziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching regola allarme condiziones
	 */
	public java.util.List<RegolaAllarmeCondizione> findByUuid(String uuid);

	/**
	 * Returns a range of all the regola allarme condiziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @return the range of matching regola allarme condiziones
	 */
	public java.util.List<RegolaAllarmeCondizione> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the regola allarme condiziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching regola allarme condiziones
	 */
	public java.util.List<RegolaAllarmeCondizione> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<RegolaAllarmeCondizione> orderByComparator);

	/**
	 * Returns an ordered range of all the regola allarme condiziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching regola allarme condiziones
	 */
	public java.util.List<RegolaAllarmeCondizione> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<RegolaAllarmeCondizione> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first regola allarme condizione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme condizione
	 * @throws NoSuchRegolaAllarmeCondizioneException if a matching regola allarme condizione could not be found
	 */
	public RegolaAllarmeCondizione findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegolaAllarmeCondizione> orderByComparator)
		throws NoSuchRegolaAllarmeCondizioneException;

	/**
	 * Returns the first regola allarme condizione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme condizione, or <code>null</code> if a matching regola allarme condizione could not be found
	 */
	public RegolaAllarmeCondizione fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<RegolaAllarmeCondizione> orderByComparator);

	/**
	 * Returns the last regola allarme condizione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme condizione
	 * @throws NoSuchRegolaAllarmeCondizioneException if a matching regola allarme condizione could not be found
	 */
	public RegolaAllarmeCondizione findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegolaAllarmeCondizione> orderByComparator)
		throws NoSuchRegolaAllarmeCondizioneException;

	/**
	 * Returns the last regola allarme condizione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme condizione, or <code>null</code> if a matching regola allarme condizione could not be found
	 */
	public RegolaAllarmeCondizione fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<RegolaAllarmeCondizione> orderByComparator);

	/**
	 * Returns the regola allarme condiziones before and after the current regola allarme condizione in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current regola allarme condizione
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next regola allarme condizione
	 * @throws NoSuchRegolaAllarmeCondizioneException if a regola allarme condizione with the primary key could not be found
	 */
	public RegolaAllarmeCondizione[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegolaAllarmeCondizione> orderByComparator)
		throws NoSuchRegolaAllarmeCondizioneException;

	/**
	 * Removes all the regola allarme condiziones where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of regola allarme condiziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching regola allarme condiziones
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the regola allarme condiziones where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @return the matching regola allarme condiziones
	 */
	public java.util.List<RegolaAllarmeCondizione> findByRegola(long idRegola);

	/**
	 * Returns a range of all the regola allarme condiziones where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @return the range of matching regola allarme condiziones
	 */
	public java.util.List<RegolaAllarmeCondizione> findByRegola(
		long idRegola, int start, int end);

	/**
	 * Returns an ordered range of all the regola allarme condiziones where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching regola allarme condiziones
	 */
	public java.util.List<RegolaAllarmeCondizione> findByRegola(
		long idRegola, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<RegolaAllarmeCondizione> orderByComparator);

	/**
	 * Returns an ordered range of all the regola allarme condiziones where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching regola allarme condiziones
	 */
	public java.util.List<RegolaAllarmeCondizione> findByRegola(
		long idRegola, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<RegolaAllarmeCondizione> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first regola allarme condizione in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme condizione
	 * @throws NoSuchRegolaAllarmeCondizioneException if a matching regola allarme condizione could not be found
	 */
	public RegolaAllarmeCondizione findByRegola_First(
			long idRegola,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegolaAllarmeCondizione> orderByComparator)
		throws NoSuchRegolaAllarmeCondizioneException;

	/**
	 * Returns the first regola allarme condizione in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme condizione, or <code>null</code> if a matching regola allarme condizione could not be found
	 */
	public RegolaAllarmeCondizione fetchByRegola_First(
		long idRegola,
		com.liferay.portal.kernel.util.OrderByComparator
			<RegolaAllarmeCondizione> orderByComparator);

	/**
	 * Returns the last regola allarme condizione in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme condizione
	 * @throws NoSuchRegolaAllarmeCondizioneException if a matching regola allarme condizione could not be found
	 */
	public RegolaAllarmeCondizione findByRegola_Last(
			long idRegola,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegolaAllarmeCondizione> orderByComparator)
		throws NoSuchRegolaAllarmeCondizioneException;

	/**
	 * Returns the last regola allarme condizione in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme condizione, or <code>null</code> if a matching regola allarme condizione could not be found
	 */
	public RegolaAllarmeCondizione fetchByRegola_Last(
		long idRegola,
		com.liferay.portal.kernel.util.OrderByComparator
			<RegolaAllarmeCondizione> orderByComparator);

	/**
	 * Returns the regola allarme condiziones before and after the current regola allarme condizione in the ordered set where idRegola = &#63;.
	 *
	 * @param id the primary key of the current regola allarme condizione
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next regola allarme condizione
	 * @throws NoSuchRegolaAllarmeCondizioneException if a regola allarme condizione with the primary key could not be found
	 */
	public RegolaAllarmeCondizione[] findByRegola_PrevAndNext(
			long id, long idRegola,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegolaAllarmeCondizione> orderByComparator)
		throws NoSuchRegolaAllarmeCondizioneException;

	/**
	 * Removes all the regola allarme condiziones where idRegola = &#63; from the database.
	 *
	 * @param idRegola the id regola
	 */
	public void removeByRegola(long idRegola);

	/**
	 * Returns the number of regola allarme condiziones where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @return the number of matching regola allarme condiziones
	 */
	public int countByRegola(long idRegola);

	/**
	 * Caches the regola allarme condizione in the entity cache if it is enabled.
	 *
	 * @param regolaAllarmeCondizione the regola allarme condizione
	 */
	public void cacheResult(RegolaAllarmeCondizione regolaAllarmeCondizione);

	/**
	 * Caches the regola allarme condiziones in the entity cache if it is enabled.
	 *
	 * @param regolaAllarmeCondiziones the regola allarme condiziones
	 */
	public void cacheResult(
		java.util.List<RegolaAllarmeCondizione> regolaAllarmeCondiziones);

	/**
	 * Creates a new regola allarme condizione with the primary key. Does not add the regola allarme condizione to the database.
	 *
	 * @param id the primary key for the new regola allarme condizione
	 * @return the new regola allarme condizione
	 */
	public RegolaAllarmeCondizione create(long id);

	/**
	 * Removes the regola allarme condizione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the regola allarme condizione
	 * @return the regola allarme condizione that was removed
	 * @throws NoSuchRegolaAllarmeCondizioneException if a regola allarme condizione with the primary key could not be found
	 */
	public RegolaAllarmeCondizione remove(long id)
		throws NoSuchRegolaAllarmeCondizioneException;

	public RegolaAllarmeCondizione updateImpl(
		RegolaAllarmeCondizione regolaAllarmeCondizione);

	/**
	 * Returns the regola allarme condizione with the primary key or throws a <code>NoSuchRegolaAllarmeCondizioneException</code> if it could not be found.
	 *
	 * @param id the primary key of the regola allarme condizione
	 * @return the regola allarme condizione
	 * @throws NoSuchRegolaAllarmeCondizioneException if a regola allarme condizione with the primary key could not be found
	 */
	public RegolaAllarmeCondizione findByPrimaryKey(long id)
		throws NoSuchRegolaAllarmeCondizioneException;

	/**
	 * Returns the regola allarme condizione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the regola allarme condizione
	 * @return the regola allarme condizione, or <code>null</code> if a regola allarme condizione with the primary key could not be found
	 */
	public RegolaAllarmeCondizione fetchByPrimaryKey(long id);

	/**
	 * Returns all the regola allarme condiziones.
	 *
	 * @return the regola allarme condiziones
	 */
	public java.util.List<RegolaAllarmeCondizione> findAll();

	/**
	 * Returns a range of all the regola allarme condiziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @return the range of regola allarme condiziones
	 */
	public java.util.List<RegolaAllarmeCondizione> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the regola allarme condiziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of regola allarme condiziones
	 */
	public java.util.List<RegolaAllarmeCondizione> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<RegolaAllarmeCondizione> orderByComparator);

	/**
	 * Returns an ordered range of all the regola allarme condiziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeCondizioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of regola allarme condiziones
	 */
	public java.util.List<RegolaAllarmeCondizione> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<RegolaAllarmeCondizione> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the regola allarme condiziones from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of regola allarme condiziones.
	 *
	 * @return the number of regola allarme condiziones
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}