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

import it.eng.allerter.exception.NoSuchAllertaValangheStatoException;
import it.eng.allerter.model.AllertaValangheStato;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the allerta valanghe stato service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see AllertaValangheStatoUtil
 * @generated
 */
@ProviderType
public interface AllertaValangheStatoPersistence
	extends BasePersistence<AllertaValangheStato> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AllertaValangheStatoUtil} to access the allerta valanghe stato persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, AllertaValangheStato> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the allerta valanghe statos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching allerta valanghe statos
	 */
	public java.util.List<AllertaValangheStato> findByUuid(String uuid);

	/**
	 * Returns a range of all the allerta valanghe statos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @return the range of matching allerta valanghe statos
	 */
	public java.util.List<AllertaValangheStato> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the allerta valanghe statos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta valanghe statos
	 */
	public java.util.List<AllertaValangheStato> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValangheStato>
			orderByComparator);

	/**
	 * Returns an ordered range of all the allerta valanghe statos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching allerta valanghe statos
	 */
	public java.util.List<AllertaValangheStato> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValangheStato>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first allerta valanghe stato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a matching allerta valanghe stato could not be found
	 */
	public AllertaValangheStato findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<AllertaValangheStato> orderByComparator)
		throws NoSuchAllertaValangheStatoException;

	/**
	 * Returns the first allerta valanghe stato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe stato, or <code>null</code> if a matching allerta valanghe stato could not be found
	 */
	public AllertaValangheStato fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValangheStato>
			orderByComparator);

	/**
	 * Returns the last allerta valanghe stato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a matching allerta valanghe stato could not be found
	 */
	public AllertaValangheStato findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<AllertaValangheStato> orderByComparator)
		throws NoSuchAllertaValangheStatoException;

	/**
	 * Returns the last allerta valanghe stato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe stato, or <code>null</code> if a matching allerta valanghe stato could not be found
	 */
	public AllertaValangheStato fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValangheStato>
			orderByComparator);

	/**
	 * Returns the allerta valanghe statos before and after the current allerta valanghe stato in the ordered set where uuid = &#63;.
	 *
	 * @param allertaValangheStatoId the primary key of the current allerta valanghe stato
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a allerta valanghe stato with the primary key could not be found
	 */
	public AllertaValangheStato[] findByUuid_PrevAndNext(
			long allertaValangheStatoId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<AllertaValangheStato> orderByComparator)
		throws NoSuchAllertaValangheStatoException;

	/**
	 * Removes all the allerta valanghe statos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of allerta valanghe statos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching allerta valanghe statos
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the allerta valanghe stato where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAllertaValangheStatoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a matching allerta valanghe stato could not be found
	 */
	public AllertaValangheStato findByUUID_G(String uuid, long groupId)
		throws NoSuchAllertaValangheStatoException;

	/**
	 * Returns the allerta valanghe stato where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allerta valanghe stato, or <code>null</code> if a matching allerta valanghe stato could not be found
	 */
	public AllertaValangheStato fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the allerta valanghe stato where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching allerta valanghe stato, or <code>null</code> if a matching allerta valanghe stato could not be found
	 */
	public AllertaValangheStato fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache);

	/**
	 * Removes the allerta valanghe stato where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the allerta valanghe stato that was removed
	 */
	public AllertaValangheStato removeByUUID_G(String uuid, long groupId)
		throws NoSuchAllertaValangheStatoException;

	/**
	 * Returns the number of allerta valanghe statos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching allerta valanghe statos
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the allerta valanghe statos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching allerta valanghe statos
	 */
	public java.util.List<AllertaValangheStato> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the allerta valanghe statos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @return the range of matching allerta valanghe statos
	 */
	public java.util.List<AllertaValangheStato> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the allerta valanghe statos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta valanghe statos
	 */
	public java.util.List<AllertaValangheStato> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValangheStato>
			orderByComparator);

	/**
	 * Returns an ordered range of all the allerta valanghe statos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching allerta valanghe statos
	 */
	public java.util.List<AllertaValangheStato> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValangheStato>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first allerta valanghe stato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a matching allerta valanghe stato could not be found
	 */
	public AllertaValangheStato findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AllertaValangheStato> orderByComparator)
		throws NoSuchAllertaValangheStatoException;

	/**
	 * Returns the first allerta valanghe stato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe stato, or <code>null</code> if a matching allerta valanghe stato could not be found
	 */
	public AllertaValangheStato fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValangheStato>
			orderByComparator);

	/**
	 * Returns the last allerta valanghe stato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a matching allerta valanghe stato could not be found
	 */
	public AllertaValangheStato findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AllertaValangheStato> orderByComparator)
		throws NoSuchAllertaValangheStatoException;

	/**
	 * Returns the last allerta valanghe stato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe stato, or <code>null</code> if a matching allerta valanghe stato could not be found
	 */
	public AllertaValangheStato fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValangheStato>
			orderByComparator);

	/**
	 * Returns the allerta valanghe statos before and after the current allerta valanghe stato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param allertaValangheStatoId the primary key of the current allerta valanghe stato
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a allerta valanghe stato with the primary key could not be found
	 */
	public AllertaValangheStato[] findByUuid_C_PrevAndNext(
			long allertaValangheStatoId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AllertaValangheStato> orderByComparator)
		throws NoSuchAllertaValangheStatoException;

	/**
	 * Removes all the allerta valanghe statos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of allerta valanghe statos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching allerta valanghe statos
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the allerta valanghe statos where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the matching allerta valanghe statos
	 */
	public java.util.List<AllertaValangheStato> findByNome(String nome);

	/**
	 * Returns a range of all the allerta valanghe statos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @return the range of matching allerta valanghe statos
	 */
	public java.util.List<AllertaValangheStato> findByNome(
		String nome, int start, int end);

	/**
	 * Returns an ordered range of all the allerta valanghe statos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta valanghe statos
	 */
	public java.util.List<AllertaValangheStato> findByNome(
		String nome, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValangheStato>
			orderByComparator);

	/**
	 * Returns an ordered range of all the allerta valanghe statos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching allerta valanghe statos
	 */
	public java.util.List<AllertaValangheStato> findByNome(
		String nome, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValangheStato>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first allerta valanghe stato in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a matching allerta valanghe stato could not be found
	 */
	public AllertaValangheStato findByNome_First(
			String nome,
			com.liferay.portal.kernel.util.OrderByComparator
				<AllertaValangheStato> orderByComparator)
		throws NoSuchAllertaValangheStatoException;

	/**
	 * Returns the first allerta valanghe stato in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe stato, or <code>null</code> if a matching allerta valanghe stato could not be found
	 */
	public AllertaValangheStato fetchByNome_First(
		String nome,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValangheStato>
			orderByComparator);

	/**
	 * Returns the last allerta valanghe stato in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a matching allerta valanghe stato could not be found
	 */
	public AllertaValangheStato findByNome_Last(
			String nome,
			com.liferay.portal.kernel.util.OrderByComparator
				<AllertaValangheStato> orderByComparator)
		throws NoSuchAllertaValangheStatoException;

	/**
	 * Returns the last allerta valanghe stato in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe stato, or <code>null</code> if a matching allerta valanghe stato could not be found
	 */
	public AllertaValangheStato fetchByNome_Last(
		String nome,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValangheStato>
			orderByComparator);

	/**
	 * Returns the allerta valanghe statos before and after the current allerta valanghe stato in the ordered set where nome = &#63;.
	 *
	 * @param allertaValangheStatoId the primary key of the current allerta valanghe stato
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a allerta valanghe stato with the primary key could not be found
	 */
	public AllertaValangheStato[] findByNome_PrevAndNext(
			long allertaValangheStatoId, String nome,
			com.liferay.portal.kernel.util.OrderByComparator
				<AllertaValangheStato> orderByComparator)
		throws NoSuchAllertaValangheStatoException;

	/**
	 * Removes all the allerta valanghe statos where nome = &#63; from the database.
	 *
	 * @param nome the nome
	 */
	public void removeByNome(String nome);

	/**
	 * Returns the number of allerta valanghe statos where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the number of matching allerta valanghe statos
	 */
	public int countByNome(String nome);

	/**
	 * Returns all the allerta valanghe statos where allertaValangheId = &#63;.
	 *
	 * @param allertaValangheId the allerta valanghe ID
	 * @return the matching allerta valanghe statos
	 */
	public java.util.List<AllertaValangheStato> findByAllertaValangheId(
		long allertaValangheId);

	/**
	 * Returns a range of all the allerta valanghe statos where allertaValangheId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param allertaValangheId the allerta valanghe ID
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @return the range of matching allerta valanghe statos
	 */
	public java.util.List<AllertaValangheStato> findByAllertaValangheId(
		long allertaValangheId, int start, int end);

	/**
	 * Returns an ordered range of all the allerta valanghe statos where allertaValangheId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param allertaValangheId the allerta valanghe ID
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta valanghe statos
	 */
	public java.util.List<AllertaValangheStato> findByAllertaValangheId(
		long allertaValangheId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValangheStato>
			orderByComparator);

	/**
	 * Returns an ordered range of all the allerta valanghe statos where allertaValangheId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param allertaValangheId the allerta valanghe ID
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching allerta valanghe statos
	 */
	public java.util.List<AllertaValangheStato> findByAllertaValangheId(
		long allertaValangheId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValangheStato>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first allerta valanghe stato in the ordered set where allertaValangheId = &#63;.
	 *
	 * @param allertaValangheId the allerta valanghe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a matching allerta valanghe stato could not be found
	 */
	public AllertaValangheStato findByAllertaValangheId_First(
			long allertaValangheId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AllertaValangheStato> orderByComparator)
		throws NoSuchAllertaValangheStatoException;

	/**
	 * Returns the first allerta valanghe stato in the ordered set where allertaValangheId = &#63;.
	 *
	 * @param allertaValangheId the allerta valanghe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe stato, or <code>null</code> if a matching allerta valanghe stato could not be found
	 */
	public AllertaValangheStato fetchByAllertaValangheId_First(
		long allertaValangheId,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValangheStato>
			orderByComparator);

	/**
	 * Returns the last allerta valanghe stato in the ordered set where allertaValangheId = &#63;.
	 *
	 * @param allertaValangheId the allerta valanghe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a matching allerta valanghe stato could not be found
	 */
	public AllertaValangheStato findByAllertaValangheId_Last(
			long allertaValangheId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AllertaValangheStato> orderByComparator)
		throws NoSuchAllertaValangheStatoException;

	/**
	 * Returns the last allerta valanghe stato in the ordered set where allertaValangheId = &#63;.
	 *
	 * @param allertaValangheId the allerta valanghe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe stato, or <code>null</code> if a matching allerta valanghe stato could not be found
	 */
	public AllertaValangheStato fetchByAllertaValangheId_Last(
		long allertaValangheId,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValangheStato>
			orderByComparator);

	/**
	 * Returns the allerta valanghe statos before and after the current allerta valanghe stato in the ordered set where allertaValangheId = &#63;.
	 *
	 * @param allertaValangheStatoId the primary key of the current allerta valanghe stato
	 * @param allertaValangheId the allerta valanghe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a allerta valanghe stato with the primary key could not be found
	 */
	public AllertaValangheStato[] findByAllertaValangheId_PrevAndNext(
			long allertaValangheStatoId, long allertaValangheId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AllertaValangheStato> orderByComparator)
		throws NoSuchAllertaValangheStatoException;

	/**
	 * Removes all the allerta valanghe statos where allertaValangheId = &#63; from the database.
	 *
	 * @param allertaValangheId the allerta valanghe ID
	 */
	public void removeByAllertaValangheId(long allertaValangheId);

	/**
	 * Returns the number of allerta valanghe statos where allertaValangheId = &#63;.
	 *
	 * @param allertaValangheId the allerta valanghe ID
	 * @return the number of matching allerta valanghe statos
	 */
	public int countByAllertaValangheId(long allertaValangheId);

	/**
	 * Caches the allerta valanghe stato in the entity cache if it is enabled.
	 *
	 * @param allertaValangheStato the allerta valanghe stato
	 */
	public void cacheResult(AllertaValangheStato allertaValangheStato);

	/**
	 * Caches the allerta valanghe statos in the entity cache if it is enabled.
	 *
	 * @param allertaValangheStatos the allerta valanghe statos
	 */
	public void cacheResult(
		java.util.List<AllertaValangheStato> allertaValangheStatos);

	/**
	 * Creates a new allerta valanghe stato with the primary key. Does not add the allerta valanghe stato to the database.
	 *
	 * @param allertaValangheStatoId the primary key for the new allerta valanghe stato
	 * @return the new allerta valanghe stato
	 */
	public AllertaValangheStato create(long allertaValangheStatoId);

	/**
	 * Removes the allerta valanghe stato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaValangheStatoId the primary key of the allerta valanghe stato
	 * @return the allerta valanghe stato that was removed
	 * @throws NoSuchAllertaValangheStatoException if a allerta valanghe stato with the primary key could not be found
	 */
	public AllertaValangheStato remove(long allertaValangheStatoId)
		throws NoSuchAllertaValangheStatoException;

	public AllertaValangheStato updateImpl(
		AllertaValangheStato allertaValangheStato);

	/**
	 * Returns the allerta valanghe stato with the primary key or throws a <code>NoSuchAllertaValangheStatoException</code> if it could not be found.
	 *
	 * @param allertaValangheStatoId the primary key of the allerta valanghe stato
	 * @return the allerta valanghe stato
	 * @throws NoSuchAllertaValangheStatoException if a allerta valanghe stato with the primary key could not be found
	 */
	public AllertaValangheStato findByPrimaryKey(long allertaValangheStatoId)
		throws NoSuchAllertaValangheStatoException;

	/**
	 * Returns the allerta valanghe stato with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param allertaValangheStatoId the primary key of the allerta valanghe stato
	 * @return the allerta valanghe stato, or <code>null</code> if a allerta valanghe stato with the primary key could not be found
	 */
	public AllertaValangheStato fetchByPrimaryKey(long allertaValangheStatoId);

	/**
	 * Returns all the allerta valanghe statos.
	 *
	 * @return the allerta valanghe statos
	 */
	public java.util.List<AllertaValangheStato> findAll();

	/**
	 * Returns a range of all the allerta valanghe statos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @return the range of allerta valanghe statos
	 */
	public java.util.List<AllertaValangheStato> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the allerta valanghe statos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of allerta valanghe statos
	 */
	public java.util.List<AllertaValangheStato> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValangheStato>
			orderByComparator);

	/**
	 * Returns an ordered range of all the allerta valanghe statos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of allerta valanghe statos
	 */
	public java.util.List<AllertaValangheStato> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValangheStato>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the allerta valanghe statos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of allerta valanghe statos.
	 *
	 * @return the number of allerta valanghe statos
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}