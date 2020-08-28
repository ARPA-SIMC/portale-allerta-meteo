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

import it.eng.bollettino.exception.NoSuchRegolaAllarmeComuneException;
import it.eng.bollettino.model.RegolaAllarmeComune;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the regola allarme comune service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see RegolaAllarmeComuneUtil
 * @generated
 */
@ProviderType
public interface RegolaAllarmeComunePersistence
	extends BasePersistence<RegolaAllarmeComune> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RegolaAllarmeComuneUtil} to access the regola allarme comune persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, RegolaAllarmeComune> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the regola allarme comunes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching regola allarme comunes
	 */
	public java.util.List<RegolaAllarmeComune> findByUuid(String uuid);

	/**
	 * Returns a range of all the regola allarme comunes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @return the range of matching regola allarme comunes
	 */
	public java.util.List<RegolaAllarmeComune> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the regola allarme comunes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching regola allarme comunes
	 */
	public java.util.List<RegolaAllarmeComune> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegolaAllarmeComune>
			orderByComparator);

	/**
	 * Returns an ordered range of all the regola allarme comunes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching regola allarme comunes
	 */
	public java.util.List<RegolaAllarmeComune> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegolaAllarmeComune>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first regola allarme comune in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a matching regola allarme comune could not be found
	 */
	public RegolaAllarmeComune findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegolaAllarmeComune> orderByComparator)
		throws NoSuchRegolaAllarmeComuneException;

	/**
	 * Returns the first regola allarme comune in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme comune, or <code>null</code> if a matching regola allarme comune could not be found
	 */
	public RegolaAllarmeComune fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RegolaAllarmeComune>
			orderByComparator);

	/**
	 * Returns the last regola allarme comune in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a matching regola allarme comune could not be found
	 */
	public RegolaAllarmeComune findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegolaAllarmeComune> orderByComparator)
		throws NoSuchRegolaAllarmeComuneException;

	/**
	 * Returns the last regola allarme comune in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme comune, or <code>null</code> if a matching regola allarme comune could not be found
	 */
	public RegolaAllarmeComune fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RegolaAllarmeComune>
			orderByComparator);

	/**
	 * Returns the regola allarme comunes before and after the current regola allarme comune in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current regola allarme comune
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a regola allarme comune with the primary key could not be found
	 */
	public RegolaAllarmeComune[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegolaAllarmeComune> orderByComparator)
		throws NoSuchRegolaAllarmeComuneException;

	/**
	 * Removes all the regola allarme comunes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of regola allarme comunes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching regola allarme comunes
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the regola allarme comunes where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @return the matching regola allarme comunes
	 */
	public java.util.List<RegolaAllarmeComune> findByRegola(long idRegola);

	/**
	 * Returns a range of all the regola allarme comunes where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @return the range of matching regola allarme comunes
	 */
	public java.util.List<RegolaAllarmeComune> findByRegola(
		long idRegola, int start, int end);

	/**
	 * Returns an ordered range of all the regola allarme comunes where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching regola allarme comunes
	 */
	public java.util.List<RegolaAllarmeComune> findByRegola(
		long idRegola, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegolaAllarmeComune>
			orderByComparator);

	/**
	 * Returns an ordered range of all the regola allarme comunes where idRegola = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idRegola the id regola
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching regola allarme comunes
	 */
	public java.util.List<RegolaAllarmeComune> findByRegola(
		long idRegola, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegolaAllarmeComune>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first regola allarme comune in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a matching regola allarme comune could not be found
	 */
	public RegolaAllarmeComune findByRegola_First(
			long idRegola,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegolaAllarmeComune> orderByComparator)
		throws NoSuchRegolaAllarmeComuneException;

	/**
	 * Returns the first regola allarme comune in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme comune, or <code>null</code> if a matching regola allarme comune could not be found
	 */
	public RegolaAllarmeComune fetchByRegola_First(
		long idRegola,
		com.liferay.portal.kernel.util.OrderByComparator<RegolaAllarmeComune>
			orderByComparator);

	/**
	 * Returns the last regola allarme comune in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a matching regola allarme comune could not be found
	 */
	public RegolaAllarmeComune findByRegola_Last(
			long idRegola,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegolaAllarmeComune> orderByComparator)
		throws NoSuchRegolaAllarmeComuneException;

	/**
	 * Returns the last regola allarme comune in the ordered set where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme comune, or <code>null</code> if a matching regola allarme comune could not be found
	 */
	public RegolaAllarmeComune fetchByRegola_Last(
		long idRegola,
		com.liferay.portal.kernel.util.OrderByComparator<RegolaAllarmeComune>
			orderByComparator);

	/**
	 * Returns the regola allarme comunes before and after the current regola allarme comune in the ordered set where idRegola = &#63;.
	 *
	 * @param id the primary key of the current regola allarme comune
	 * @param idRegola the id regola
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a regola allarme comune with the primary key could not be found
	 */
	public RegolaAllarmeComune[] findByRegola_PrevAndNext(
			long id, long idRegola,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegolaAllarmeComune> orderByComparator)
		throws NoSuchRegolaAllarmeComuneException;

	/**
	 * Removes all the regola allarme comunes where idRegola = &#63; from the database.
	 *
	 * @param idRegola the id regola
	 */
	public void removeByRegola(long idRegola);

	/**
	 * Returns the number of regola allarme comunes where idRegola = &#63;.
	 *
	 * @param idRegola the id regola
	 * @return the number of matching regola allarme comunes
	 */
	public int countByRegola(long idRegola);

	/**
	 * Returns all the regola allarme comunes where idComune = &#63;.
	 *
	 * @param idComune the id comune
	 * @return the matching regola allarme comunes
	 */
	public java.util.List<RegolaAllarmeComune> findByComune(long idComune);

	/**
	 * Returns a range of all the regola allarme comunes where idComune = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idComune the id comune
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @return the range of matching regola allarme comunes
	 */
	public java.util.List<RegolaAllarmeComune> findByComune(
		long idComune, int start, int end);

	/**
	 * Returns an ordered range of all the regola allarme comunes where idComune = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idComune the id comune
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching regola allarme comunes
	 */
	public java.util.List<RegolaAllarmeComune> findByComune(
		long idComune, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegolaAllarmeComune>
			orderByComparator);

	/**
	 * Returns an ordered range of all the regola allarme comunes where idComune = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param idComune the id comune
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching regola allarme comunes
	 */
	public java.util.List<RegolaAllarmeComune> findByComune(
		long idComune, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegolaAllarmeComune>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first regola allarme comune in the ordered set where idComune = &#63;.
	 *
	 * @param idComune the id comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a matching regola allarme comune could not be found
	 */
	public RegolaAllarmeComune findByComune_First(
			long idComune,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegolaAllarmeComune> orderByComparator)
		throws NoSuchRegolaAllarmeComuneException;

	/**
	 * Returns the first regola allarme comune in the ordered set where idComune = &#63;.
	 *
	 * @param idComune the id comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching regola allarme comune, or <code>null</code> if a matching regola allarme comune could not be found
	 */
	public RegolaAllarmeComune fetchByComune_First(
		long idComune,
		com.liferay.portal.kernel.util.OrderByComparator<RegolaAllarmeComune>
			orderByComparator);

	/**
	 * Returns the last regola allarme comune in the ordered set where idComune = &#63;.
	 *
	 * @param idComune the id comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a matching regola allarme comune could not be found
	 */
	public RegolaAllarmeComune findByComune_Last(
			long idComune,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegolaAllarmeComune> orderByComparator)
		throws NoSuchRegolaAllarmeComuneException;

	/**
	 * Returns the last regola allarme comune in the ordered set where idComune = &#63;.
	 *
	 * @param idComune the id comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching regola allarme comune, or <code>null</code> if a matching regola allarme comune could not be found
	 */
	public RegolaAllarmeComune fetchByComune_Last(
		long idComune,
		com.liferay.portal.kernel.util.OrderByComparator<RegolaAllarmeComune>
			orderByComparator);

	/**
	 * Returns the regola allarme comunes before and after the current regola allarme comune in the ordered set where idComune = &#63;.
	 *
	 * @param id the primary key of the current regola allarme comune
	 * @param idComune the id comune
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a regola allarme comune with the primary key could not be found
	 */
	public RegolaAllarmeComune[] findByComune_PrevAndNext(
			long id, long idComune,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegolaAllarmeComune> orderByComparator)
		throws NoSuchRegolaAllarmeComuneException;

	/**
	 * Removes all the regola allarme comunes where idComune = &#63; from the database.
	 *
	 * @param idComune the id comune
	 */
	public void removeByComune(long idComune);

	/**
	 * Returns the number of regola allarme comunes where idComune = &#63;.
	 *
	 * @param idComune the id comune
	 * @return the number of matching regola allarme comunes
	 */
	public int countByComune(long idComune);

	/**
	 * Caches the regola allarme comune in the entity cache if it is enabled.
	 *
	 * @param regolaAllarmeComune the regola allarme comune
	 */
	public void cacheResult(RegolaAllarmeComune regolaAllarmeComune);

	/**
	 * Caches the regola allarme comunes in the entity cache if it is enabled.
	 *
	 * @param regolaAllarmeComunes the regola allarme comunes
	 */
	public void cacheResult(
		java.util.List<RegolaAllarmeComune> regolaAllarmeComunes);

	/**
	 * Creates a new regola allarme comune with the primary key. Does not add the regola allarme comune to the database.
	 *
	 * @param id the primary key for the new regola allarme comune
	 * @return the new regola allarme comune
	 */
	public RegolaAllarmeComune create(long id);

	/**
	 * Removes the regola allarme comune with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the regola allarme comune
	 * @return the regola allarme comune that was removed
	 * @throws NoSuchRegolaAllarmeComuneException if a regola allarme comune with the primary key could not be found
	 */
	public RegolaAllarmeComune remove(long id)
		throws NoSuchRegolaAllarmeComuneException;

	public RegolaAllarmeComune updateImpl(
		RegolaAllarmeComune regolaAllarmeComune);

	/**
	 * Returns the regola allarme comune with the primary key or throws a <code>NoSuchRegolaAllarmeComuneException</code> if it could not be found.
	 *
	 * @param id the primary key of the regola allarme comune
	 * @return the regola allarme comune
	 * @throws NoSuchRegolaAllarmeComuneException if a regola allarme comune with the primary key could not be found
	 */
	public RegolaAllarmeComune findByPrimaryKey(long id)
		throws NoSuchRegolaAllarmeComuneException;

	/**
	 * Returns the regola allarme comune with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the regola allarme comune
	 * @return the regola allarme comune, or <code>null</code> if a regola allarme comune with the primary key could not be found
	 */
	public RegolaAllarmeComune fetchByPrimaryKey(long id);

	/**
	 * Returns all the regola allarme comunes.
	 *
	 * @return the regola allarme comunes
	 */
	public java.util.List<RegolaAllarmeComune> findAll();

	/**
	 * Returns a range of all the regola allarme comunes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @return the range of regola allarme comunes
	 */
	public java.util.List<RegolaAllarmeComune> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the regola allarme comunes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of regola allarme comunes
	 */
	public java.util.List<RegolaAllarmeComune> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegolaAllarmeComune>
			orderByComparator);

	/**
	 * Returns an ordered range of all the regola allarme comunes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of regola allarme comunes
	 */
	public java.util.List<RegolaAllarmeComune> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegolaAllarmeComune>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the regola allarme comunes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of regola allarme comunes.
	 *
	 * @return the number of regola allarme comunes
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}