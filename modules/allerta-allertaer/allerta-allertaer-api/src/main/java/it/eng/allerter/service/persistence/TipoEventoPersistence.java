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

package it.eng.allerter.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.allerter.exception.NoSuchTipoEventoException;
import it.eng.allerter.model.TipoEvento;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the tipo evento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see TipoEventoUtil
 * @generated
 */
@ProviderType
public interface TipoEventoPersistence extends BasePersistence<TipoEvento> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TipoEventoUtil} to access the tipo evento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, TipoEvento> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the tipo eventos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching tipo eventos
	 */
	public java.util.List<TipoEvento> findByUuid(String uuid);

	/**
	 * Returns a range of all the tipo eventos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @return the range of matching tipo eventos
	 */
	public java.util.List<TipoEvento> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the tipo eventos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipo eventos
	 */
	public java.util.List<TipoEvento> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipoEvento>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tipo eventos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tipo eventos
	 */
	public java.util.List<TipoEvento> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipoEvento>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first tipo evento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo evento
	 * @throws NoSuchTipoEventoException if a matching tipo evento could not be found
	 */
	public TipoEvento findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TipoEvento>
				orderByComparator)
		throws NoSuchTipoEventoException;

	/**
	 * Returns the first tipo evento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	public TipoEvento fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TipoEvento>
			orderByComparator);

	/**
	 * Returns the last tipo evento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo evento
	 * @throws NoSuchTipoEventoException if a matching tipo evento could not be found
	 */
	public TipoEvento findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TipoEvento>
				orderByComparator)
		throws NoSuchTipoEventoException;

	/**
	 * Returns the last tipo evento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	public TipoEvento fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TipoEvento>
			orderByComparator);

	/**
	 * Returns the tipo eventos before and after the current tipo evento in the ordered set where uuid = &#63;.
	 *
	 * @param eventoId the primary key of the current tipo evento
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tipo evento
	 * @throws NoSuchTipoEventoException if a tipo evento with the primary key could not be found
	 */
	public TipoEvento[] findByUuid_PrevAndNext(
			long eventoId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TipoEvento>
				orderByComparator)
		throws NoSuchTipoEventoException;

	/**
	 * Removes all the tipo eventos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of tipo eventos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching tipo eventos
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the tipo evento where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTipoEventoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching tipo evento
	 * @throws NoSuchTipoEventoException if a matching tipo evento could not be found
	 */
	public TipoEvento findByUUID_G(String uuid, long groupId)
		throws NoSuchTipoEventoException;

	/**
	 * Returns the tipo evento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	public TipoEvento fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the tipo evento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	public TipoEvento fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache);

	/**
	 * Removes the tipo evento where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the tipo evento that was removed
	 */
	public TipoEvento removeByUUID_G(String uuid, long groupId)
		throws NoSuchTipoEventoException;

	/**
	 * Returns the number of tipo eventos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching tipo eventos
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the tipo eventos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching tipo eventos
	 */
	public java.util.List<TipoEvento> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the tipo eventos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @return the range of matching tipo eventos
	 */
	public java.util.List<TipoEvento> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the tipo eventos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipo eventos
	 */
	public java.util.List<TipoEvento> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipoEvento>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tipo eventos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tipo eventos
	 */
	public java.util.List<TipoEvento> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipoEvento>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first tipo evento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo evento
	 * @throws NoSuchTipoEventoException if a matching tipo evento could not be found
	 */
	public TipoEvento findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TipoEvento>
				orderByComparator)
		throws NoSuchTipoEventoException;

	/**
	 * Returns the first tipo evento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	public TipoEvento fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TipoEvento>
			orderByComparator);

	/**
	 * Returns the last tipo evento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo evento
	 * @throws NoSuchTipoEventoException if a matching tipo evento could not be found
	 */
	public TipoEvento findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TipoEvento>
				orderByComparator)
		throws NoSuchTipoEventoException;

	/**
	 * Returns the last tipo evento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	public TipoEvento fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TipoEvento>
			orderByComparator);

	/**
	 * Returns the tipo eventos before and after the current tipo evento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param eventoId the primary key of the current tipo evento
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tipo evento
	 * @throws NoSuchTipoEventoException if a tipo evento with the primary key could not be found
	 */
	public TipoEvento[] findByUuid_C_PrevAndNext(
			long eventoId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TipoEvento>
				orderByComparator)
		throws NoSuchTipoEventoException;

	/**
	 * Removes all the tipo eventos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of tipo eventos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching tipo eventos
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the tipo eventos where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the matching tipo eventos
	 */
	public java.util.List<TipoEvento> findByNome(String nome);

	/**
	 * Returns a range of all the tipo eventos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @return the range of matching tipo eventos
	 */
	public java.util.List<TipoEvento> findByNome(
		String nome, int start, int end);

	/**
	 * Returns an ordered range of all the tipo eventos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipo eventos
	 */
	public java.util.List<TipoEvento> findByNome(
		String nome, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipoEvento>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tipo eventos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tipo eventos
	 */
	public java.util.List<TipoEvento> findByNome(
		String nome, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipoEvento>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first tipo evento in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo evento
	 * @throws NoSuchTipoEventoException if a matching tipo evento could not be found
	 */
	public TipoEvento findByNome_First(
			String nome,
			com.liferay.portal.kernel.util.OrderByComparator<TipoEvento>
				orderByComparator)
		throws NoSuchTipoEventoException;

	/**
	 * Returns the first tipo evento in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	public TipoEvento fetchByNome_First(
		String nome,
		com.liferay.portal.kernel.util.OrderByComparator<TipoEvento>
			orderByComparator);

	/**
	 * Returns the last tipo evento in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo evento
	 * @throws NoSuchTipoEventoException if a matching tipo evento could not be found
	 */
	public TipoEvento findByNome_Last(
			String nome,
			com.liferay.portal.kernel.util.OrderByComparator<TipoEvento>
				orderByComparator)
		throws NoSuchTipoEventoException;

	/**
	 * Returns the last tipo evento in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	public TipoEvento fetchByNome_Last(
		String nome,
		com.liferay.portal.kernel.util.OrderByComparator<TipoEvento>
			orderByComparator);

	/**
	 * Returns the tipo eventos before and after the current tipo evento in the ordered set where nome = &#63;.
	 *
	 * @param eventoId the primary key of the current tipo evento
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tipo evento
	 * @throws NoSuchTipoEventoException if a tipo evento with the primary key could not be found
	 */
	public TipoEvento[] findByNome_PrevAndNext(
			long eventoId, String nome,
			com.liferay.portal.kernel.util.OrderByComparator<TipoEvento>
				orderByComparator)
		throws NoSuchTipoEventoException;

	/**
	 * Removes all the tipo eventos where nome = &#63; from the database.
	 *
	 * @param nome the nome
	 */
	public void removeByNome(String nome);

	/**
	 * Returns the number of tipo eventos where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the number of matching tipo eventos
	 */
	public int countByNome(String nome);

	/**
	 * Returns all the tipo eventos where tabella = &#63;.
	 *
	 * @param tabella the tabella
	 * @return the matching tipo eventos
	 */
	public java.util.List<TipoEvento> findByTabella(int tabella);

	/**
	 * Returns a range of all the tipo eventos where tabella = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tabella the tabella
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @return the range of matching tipo eventos
	 */
	public java.util.List<TipoEvento> findByTabella(
		int tabella, int start, int end);

	/**
	 * Returns an ordered range of all the tipo eventos where tabella = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tabella the tabella
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipo eventos
	 */
	public java.util.List<TipoEvento> findByTabella(
		int tabella, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipoEvento>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tipo eventos where tabella = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tabella the tabella
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tipo eventos
	 */
	public java.util.List<TipoEvento> findByTabella(
		int tabella, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipoEvento>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first tipo evento in the ordered set where tabella = &#63;.
	 *
	 * @param tabella the tabella
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo evento
	 * @throws NoSuchTipoEventoException if a matching tipo evento could not be found
	 */
	public TipoEvento findByTabella_First(
			int tabella,
			com.liferay.portal.kernel.util.OrderByComparator<TipoEvento>
				orderByComparator)
		throws NoSuchTipoEventoException;

	/**
	 * Returns the first tipo evento in the ordered set where tabella = &#63;.
	 *
	 * @param tabella the tabella
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	public TipoEvento fetchByTabella_First(
		int tabella,
		com.liferay.portal.kernel.util.OrderByComparator<TipoEvento>
			orderByComparator);

	/**
	 * Returns the last tipo evento in the ordered set where tabella = &#63;.
	 *
	 * @param tabella the tabella
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo evento
	 * @throws NoSuchTipoEventoException if a matching tipo evento could not be found
	 */
	public TipoEvento findByTabella_Last(
			int tabella,
			com.liferay.portal.kernel.util.OrderByComparator<TipoEvento>
				orderByComparator)
		throws NoSuchTipoEventoException;

	/**
	 * Returns the last tipo evento in the ordered set where tabella = &#63;.
	 *
	 * @param tabella the tabella
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	public TipoEvento fetchByTabella_Last(
		int tabella,
		com.liferay.portal.kernel.util.OrderByComparator<TipoEvento>
			orderByComparator);

	/**
	 * Returns the tipo eventos before and after the current tipo evento in the ordered set where tabella = &#63;.
	 *
	 * @param eventoId the primary key of the current tipo evento
	 * @param tabella the tabella
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tipo evento
	 * @throws NoSuchTipoEventoException if a tipo evento with the primary key could not be found
	 */
	public TipoEvento[] findByTabella_PrevAndNext(
			long eventoId, int tabella,
			com.liferay.portal.kernel.util.OrderByComparator<TipoEvento>
				orderByComparator)
		throws NoSuchTipoEventoException;

	/**
	 * Removes all the tipo eventos where tabella = &#63; from the database.
	 *
	 * @param tabella the tabella
	 */
	public void removeByTabella(int tabella);

	/**
	 * Returns the number of tipo eventos where tabella = &#63;.
	 *
	 * @param tabella the tabella
	 * @return the number of matching tipo eventos
	 */
	public int countByTabella(int tabella);

	/**
	 * Caches the tipo evento in the entity cache if it is enabled.
	 *
	 * @param tipoEvento the tipo evento
	 */
	public void cacheResult(TipoEvento tipoEvento);

	/**
	 * Caches the tipo eventos in the entity cache if it is enabled.
	 *
	 * @param tipoEventos the tipo eventos
	 */
	public void cacheResult(java.util.List<TipoEvento> tipoEventos);

	/**
	 * Creates a new tipo evento with the primary key. Does not add the tipo evento to the database.
	 *
	 * @param eventoId the primary key for the new tipo evento
	 * @return the new tipo evento
	 */
	public TipoEvento create(long eventoId);

	/**
	 * Removes the tipo evento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventoId the primary key of the tipo evento
	 * @return the tipo evento that was removed
	 * @throws NoSuchTipoEventoException if a tipo evento with the primary key could not be found
	 */
	public TipoEvento remove(long eventoId) throws NoSuchTipoEventoException;

	public TipoEvento updateImpl(TipoEvento tipoEvento);

	/**
	 * Returns the tipo evento with the primary key or throws a <code>NoSuchTipoEventoException</code> if it could not be found.
	 *
	 * @param eventoId the primary key of the tipo evento
	 * @return the tipo evento
	 * @throws NoSuchTipoEventoException if a tipo evento with the primary key could not be found
	 */
	public TipoEvento findByPrimaryKey(long eventoId)
		throws NoSuchTipoEventoException;

	/**
	 * Returns the tipo evento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventoId the primary key of the tipo evento
	 * @return the tipo evento, or <code>null</code> if a tipo evento with the primary key could not be found
	 */
	public TipoEvento fetchByPrimaryKey(long eventoId);

	/**
	 * Returns all the tipo eventos.
	 *
	 * @return the tipo eventos
	 */
	public java.util.List<TipoEvento> findAll();

	/**
	 * Returns a range of all the tipo eventos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @return the range of tipo eventos
	 */
	public java.util.List<TipoEvento> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the tipo eventos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tipo eventos
	 */
	public java.util.List<TipoEvento> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipoEvento>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tipo eventos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of tipo eventos
	 */
	public java.util.List<TipoEvento> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipoEvento>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the tipo eventos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of tipo eventos.
	 *
	 * @return the number of tipo eventos
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}