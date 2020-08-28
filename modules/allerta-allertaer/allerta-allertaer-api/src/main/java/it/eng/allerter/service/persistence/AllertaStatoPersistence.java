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

import it.eng.allerter.exception.NoSuchAllertaStatoException;
import it.eng.allerter.model.AllertaStato;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the allerta stato service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see AllertaStatoUtil
 * @generated
 */
@ProviderType
public interface AllertaStatoPersistence extends BasePersistence<AllertaStato> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AllertaStatoUtil} to access the allerta stato persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, AllertaStato> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the allerta statos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching allerta statos
	 */
	public java.util.List<AllertaStato> findByUuid(String uuid);

	/**
	 * Returns a range of all the allerta statos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @return the range of matching allerta statos
	 */
	public java.util.List<AllertaStato> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the allerta statos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta statos
	 */
	public java.util.List<AllertaStato> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaStato>
			orderByComparator);

	/**
	 * Returns an ordered range of all the allerta statos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching allerta statos
	 */
	public java.util.List<AllertaStato> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaStato>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first allerta stato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta stato
	 * @throws NoSuchAllertaStatoException if a matching allerta stato could not be found
	 */
	public AllertaStato findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AllertaStato>
				orderByComparator)
		throws NoSuchAllertaStatoException;

	/**
	 * Returns the first allerta stato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	public AllertaStato fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaStato>
			orderByComparator);

	/**
	 * Returns the last allerta stato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta stato
	 * @throws NoSuchAllertaStatoException if a matching allerta stato could not be found
	 */
	public AllertaStato findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AllertaStato>
				orderByComparator)
		throws NoSuchAllertaStatoException;

	/**
	 * Returns the last allerta stato in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	public AllertaStato fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaStato>
			orderByComparator);

	/**
	 * Returns the allerta statos before and after the current allerta stato in the ordered set where uuid = &#63;.
	 *
	 * @param allertaStatoId the primary key of the current allerta stato
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta stato
	 * @throws NoSuchAllertaStatoException if a allerta stato with the primary key could not be found
	 */
	public AllertaStato[] findByUuid_PrevAndNext(
			long allertaStatoId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AllertaStato>
				orderByComparator)
		throws NoSuchAllertaStatoException;

	/**
	 * Removes all the allerta statos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of allerta statos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching allerta statos
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the allerta stato where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAllertaStatoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allerta stato
	 * @throws NoSuchAllertaStatoException if a matching allerta stato could not be found
	 */
	public AllertaStato findByUUID_G(String uuid, long groupId)
		throws NoSuchAllertaStatoException;

	/**
	 * Returns the allerta stato where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	public AllertaStato fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the allerta stato where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	public AllertaStato fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache);

	/**
	 * Removes the allerta stato where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the allerta stato that was removed
	 */
	public AllertaStato removeByUUID_G(String uuid, long groupId)
		throws NoSuchAllertaStatoException;

	/**
	 * Returns the number of allerta statos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching allerta statos
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the allerta statos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching allerta statos
	 */
	public java.util.List<AllertaStato> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the allerta statos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @return the range of matching allerta statos
	 */
	public java.util.List<AllertaStato> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the allerta statos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta statos
	 */
	public java.util.List<AllertaStato> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaStato>
			orderByComparator);

	/**
	 * Returns an ordered range of all the allerta statos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching allerta statos
	 */
	public java.util.List<AllertaStato> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaStato>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first allerta stato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta stato
	 * @throws NoSuchAllertaStatoException if a matching allerta stato could not be found
	 */
	public AllertaStato findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AllertaStato>
				orderByComparator)
		throws NoSuchAllertaStatoException;

	/**
	 * Returns the first allerta stato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	public AllertaStato fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaStato>
			orderByComparator);

	/**
	 * Returns the last allerta stato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta stato
	 * @throws NoSuchAllertaStatoException if a matching allerta stato could not be found
	 */
	public AllertaStato findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AllertaStato>
				orderByComparator)
		throws NoSuchAllertaStatoException;

	/**
	 * Returns the last allerta stato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	public AllertaStato fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaStato>
			orderByComparator);

	/**
	 * Returns the allerta statos before and after the current allerta stato in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param allertaStatoId the primary key of the current allerta stato
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta stato
	 * @throws NoSuchAllertaStatoException if a allerta stato with the primary key could not be found
	 */
	public AllertaStato[] findByUuid_C_PrevAndNext(
			long allertaStatoId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AllertaStato>
				orderByComparator)
		throws NoSuchAllertaStatoException;

	/**
	 * Removes all the allerta statos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of allerta statos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching allerta statos
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the allerta statos where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the matching allerta statos
	 */
	public java.util.List<AllertaStato> findByNome(String nome);

	/**
	 * Returns a range of all the allerta statos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @return the range of matching allerta statos
	 */
	public java.util.List<AllertaStato> findByNome(
		String nome, int start, int end);

	/**
	 * Returns an ordered range of all the allerta statos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta statos
	 */
	public java.util.List<AllertaStato> findByNome(
		String nome, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaStato>
			orderByComparator);

	/**
	 * Returns an ordered range of all the allerta statos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching allerta statos
	 */
	public java.util.List<AllertaStato> findByNome(
		String nome, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaStato>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first allerta stato in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta stato
	 * @throws NoSuchAllertaStatoException if a matching allerta stato could not be found
	 */
	public AllertaStato findByNome_First(
			String nome,
			com.liferay.portal.kernel.util.OrderByComparator<AllertaStato>
				orderByComparator)
		throws NoSuchAllertaStatoException;

	/**
	 * Returns the first allerta stato in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	public AllertaStato fetchByNome_First(
		String nome,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaStato>
			orderByComparator);

	/**
	 * Returns the last allerta stato in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta stato
	 * @throws NoSuchAllertaStatoException if a matching allerta stato could not be found
	 */
	public AllertaStato findByNome_Last(
			String nome,
			com.liferay.portal.kernel.util.OrderByComparator<AllertaStato>
				orderByComparator)
		throws NoSuchAllertaStatoException;

	/**
	 * Returns the last allerta stato in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	public AllertaStato fetchByNome_Last(
		String nome,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaStato>
			orderByComparator);

	/**
	 * Returns the allerta statos before and after the current allerta stato in the ordered set where nome = &#63;.
	 *
	 * @param allertaStatoId the primary key of the current allerta stato
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta stato
	 * @throws NoSuchAllertaStatoException if a allerta stato with the primary key could not be found
	 */
	public AllertaStato[] findByNome_PrevAndNext(
			long allertaStatoId, String nome,
			com.liferay.portal.kernel.util.OrderByComparator<AllertaStato>
				orderByComparator)
		throws NoSuchAllertaStatoException;

	/**
	 * Removes all the allerta statos where nome = &#63; from the database.
	 *
	 * @param nome the nome
	 */
	public void removeByNome(String nome);

	/**
	 * Returns the number of allerta statos where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the number of matching allerta statos
	 */
	public int countByNome(String nome);

	/**
	 * Returns all the allerta statos where allertaId = &#63;.
	 *
	 * @param allertaId the allerta ID
	 * @return the matching allerta statos
	 */
	public java.util.List<AllertaStato> findByAllertaId(long allertaId);

	/**
	 * Returns a range of all the allerta statos where allertaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param allertaId the allerta ID
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @return the range of matching allerta statos
	 */
	public java.util.List<AllertaStato> findByAllertaId(
		long allertaId, int start, int end);

	/**
	 * Returns an ordered range of all the allerta statos where allertaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param allertaId the allerta ID
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta statos
	 */
	public java.util.List<AllertaStato> findByAllertaId(
		long allertaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaStato>
			orderByComparator);

	/**
	 * Returns an ordered range of all the allerta statos where allertaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param allertaId the allerta ID
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching allerta statos
	 */
	public java.util.List<AllertaStato> findByAllertaId(
		long allertaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaStato>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first allerta stato in the ordered set where allertaId = &#63;.
	 *
	 * @param allertaId the allerta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta stato
	 * @throws NoSuchAllertaStatoException if a matching allerta stato could not be found
	 */
	public AllertaStato findByAllertaId_First(
			long allertaId,
			com.liferay.portal.kernel.util.OrderByComparator<AllertaStato>
				orderByComparator)
		throws NoSuchAllertaStatoException;

	/**
	 * Returns the first allerta stato in the ordered set where allertaId = &#63;.
	 *
	 * @param allertaId the allerta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	public AllertaStato fetchByAllertaId_First(
		long allertaId,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaStato>
			orderByComparator);

	/**
	 * Returns the last allerta stato in the ordered set where allertaId = &#63;.
	 *
	 * @param allertaId the allerta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta stato
	 * @throws NoSuchAllertaStatoException if a matching allerta stato could not be found
	 */
	public AllertaStato findByAllertaId_Last(
			long allertaId,
			com.liferay.portal.kernel.util.OrderByComparator<AllertaStato>
				orderByComparator)
		throws NoSuchAllertaStatoException;

	/**
	 * Returns the last allerta stato in the ordered set where allertaId = &#63;.
	 *
	 * @param allertaId the allerta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	public AllertaStato fetchByAllertaId_Last(
		long allertaId,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaStato>
			orderByComparator);

	/**
	 * Returns the allerta statos before and after the current allerta stato in the ordered set where allertaId = &#63;.
	 *
	 * @param allertaStatoId the primary key of the current allerta stato
	 * @param allertaId the allerta ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta stato
	 * @throws NoSuchAllertaStatoException if a allerta stato with the primary key could not be found
	 */
	public AllertaStato[] findByAllertaId_PrevAndNext(
			long allertaStatoId, long allertaId,
			com.liferay.portal.kernel.util.OrderByComparator<AllertaStato>
				orderByComparator)
		throws NoSuchAllertaStatoException;

	/**
	 * Removes all the allerta statos where allertaId = &#63; from the database.
	 *
	 * @param allertaId the allerta ID
	 */
	public void removeByAllertaId(long allertaId);

	/**
	 * Returns the number of allerta statos where allertaId = &#63;.
	 *
	 * @param allertaId the allerta ID
	 * @return the number of matching allerta statos
	 */
	public int countByAllertaId(long allertaId);

	/**
	 * Caches the allerta stato in the entity cache if it is enabled.
	 *
	 * @param allertaStato the allerta stato
	 */
	public void cacheResult(AllertaStato allertaStato);

	/**
	 * Caches the allerta statos in the entity cache if it is enabled.
	 *
	 * @param allertaStatos the allerta statos
	 */
	public void cacheResult(java.util.List<AllertaStato> allertaStatos);

	/**
	 * Creates a new allerta stato with the primary key. Does not add the allerta stato to the database.
	 *
	 * @param allertaStatoId the primary key for the new allerta stato
	 * @return the new allerta stato
	 */
	public AllertaStato create(long allertaStatoId);

	/**
	 * Removes the allerta stato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaStatoId the primary key of the allerta stato
	 * @return the allerta stato that was removed
	 * @throws NoSuchAllertaStatoException if a allerta stato with the primary key could not be found
	 */
	public AllertaStato remove(long allertaStatoId)
		throws NoSuchAllertaStatoException;

	public AllertaStato updateImpl(AllertaStato allertaStato);

	/**
	 * Returns the allerta stato with the primary key or throws a <code>NoSuchAllertaStatoException</code> if it could not be found.
	 *
	 * @param allertaStatoId the primary key of the allerta stato
	 * @return the allerta stato
	 * @throws NoSuchAllertaStatoException if a allerta stato with the primary key could not be found
	 */
	public AllertaStato findByPrimaryKey(long allertaStatoId)
		throws NoSuchAllertaStatoException;

	/**
	 * Returns the allerta stato with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param allertaStatoId the primary key of the allerta stato
	 * @return the allerta stato, or <code>null</code> if a allerta stato with the primary key could not be found
	 */
	public AllertaStato fetchByPrimaryKey(long allertaStatoId);

	/**
	 * Returns all the allerta statos.
	 *
	 * @return the allerta statos
	 */
	public java.util.List<AllertaStato> findAll();

	/**
	 * Returns a range of all the allerta statos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @return the range of allerta statos
	 */
	public java.util.List<AllertaStato> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the allerta statos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of allerta statos
	 */
	public java.util.List<AllertaStato> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaStato>
			orderByComparator);

	/**
	 * Returns an ordered range of all the allerta statos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of allerta statos
	 */
	public java.util.List<AllertaStato> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaStato>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the allerta statos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of allerta statos.
	 *
	 * @return the number of allerta statos
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}