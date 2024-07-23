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

import it.eng.allerter.exception.NoSuchAllertaValangheException;
import it.eng.allerter.model.AllertaValanghe;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the allerta valanghe service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see AllertaValangheUtil
 * @generated
 */
@ProviderType
public interface AllertaValanghePersistence
	extends BasePersistence<AllertaValanghe> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AllertaValangheUtil} to access the allerta valanghe persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, AllertaValanghe> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the allerta valanghes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching allerta valanghes
	 */
	public java.util.List<AllertaValanghe> findByUuid(String uuid);

	/**
	 * Returns a range of all the allerta valanghes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @return the range of matching allerta valanghes
	 */
	public java.util.List<AllertaValanghe> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the allerta valanghes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta valanghes
	 */
	public java.util.List<AllertaValanghe> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValanghe>
			orderByComparator);

	/**
	 * Returns an ordered range of all the allerta valanghes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching allerta valanghes
	 */
	public java.util.List<AllertaValanghe> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValanghe>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first allerta valanghe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe
	 * @throws NoSuchAllertaValangheException if a matching allerta valanghe could not be found
	 */
	public AllertaValanghe findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AllertaValanghe>
				orderByComparator)
		throws NoSuchAllertaValangheException;

	/**
	 * Returns the first allerta valanghe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe, or <code>null</code> if a matching allerta valanghe could not be found
	 */
	public AllertaValanghe fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValanghe>
			orderByComparator);

	/**
	 * Returns the last allerta valanghe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe
	 * @throws NoSuchAllertaValangheException if a matching allerta valanghe could not be found
	 */
	public AllertaValanghe findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AllertaValanghe>
				orderByComparator)
		throws NoSuchAllertaValangheException;

	/**
	 * Returns the last allerta valanghe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe, or <code>null</code> if a matching allerta valanghe could not be found
	 */
	public AllertaValanghe fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValanghe>
			orderByComparator);

	/**
	 * Returns the allerta valanghes before and after the current allerta valanghe in the ordered set where uuid = &#63;.
	 *
	 * @param allertaValangheId the primary key of the current allerta valanghe
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta valanghe
	 * @throws NoSuchAllertaValangheException if a allerta valanghe with the primary key could not be found
	 */
	public AllertaValanghe[] findByUuid_PrevAndNext(
			long allertaValangheId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AllertaValanghe>
				orderByComparator)
		throws NoSuchAllertaValangheException;

	/**
	 * Removes all the allerta valanghes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of allerta valanghes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching allerta valanghes
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the allerta valanghe where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAllertaValangheException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allerta valanghe
	 * @throws NoSuchAllertaValangheException if a matching allerta valanghe could not be found
	 */
	public AllertaValanghe findByUUID_G(String uuid, long groupId)
		throws NoSuchAllertaValangheException;

	/**
	 * Returns the allerta valanghe where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching allerta valanghe, or <code>null</code> if a matching allerta valanghe could not be found
	 */
	public AllertaValanghe fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the allerta valanghe where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching allerta valanghe, or <code>null</code> if a matching allerta valanghe could not be found
	 */
	public AllertaValanghe fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache);

	/**
	 * Removes the allerta valanghe where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the allerta valanghe that was removed
	 */
	public AllertaValanghe removeByUUID_G(String uuid, long groupId)
		throws NoSuchAllertaValangheException;

	/**
	 * Returns the number of allerta valanghes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching allerta valanghes
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the allerta valanghes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching allerta valanghes
	 */
	public java.util.List<AllertaValanghe> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the allerta valanghes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @return the range of matching allerta valanghes
	 */
	public java.util.List<AllertaValanghe> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the allerta valanghes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta valanghes
	 */
	public java.util.List<AllertaValanghe> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValanghe>
			orderByComparator);

	/**
	 * Returns an ordered range of all the allerta valanghes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching allerta valanghes
	 */
	public java.util.List<AllertaValanghe> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValanghe>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first allerta valanghe in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe
	 * @throws NoSuchAllertaValangheException if a matching allerta valanghe could not be found
	 */
	public AllertaValanghe findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AllertaValanghe>
				orderByComparator)
		throws NoSuchAllertaValangheException;

	/**
	 * Returns the first allerta valanghe in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe, or <code>null</code> if a matching allerta valanghe could not be found
	 */
	public AllertaValanghe fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValanghe>
			orderByComparator);

	/**
	 * Returns the last allerta valanghe in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe
	 * @throws NoSuchAllertaValangheException if a matching allerta valanghe could not be found
	 */
	public AllertaValanghe findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AllertaValanghe>
				orderByComparator)
		throws NoSuchAllertaValangheException;

	/**
	 * Returns the last allerta valanghe in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe, or <code>null</code> if a matching allerta valanghe could not be found
	 */
	public AllertaValanghe fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValanghe>
			orderByComparator);

	/**
	 * Returns the allerta valanghes before and after the current allerta valanghe in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param allertaValangheId the primary key of the current allerta valanghe
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta valanghe
	 * @throws NoSuchAllertaValangheException if a allerta valanghe with the primary key could not be found
	 */
	public AllertaValanghe[] findByUuid_C_PrevAndNext(
			long allertaValangheId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AllertaValanghe>
				orderByComparator)
		throws NoSuchAllertaValangheException;

	/**
	 * Removes all the allerta valanghes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of allerta valanghes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching allerta valanghes
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the allerta valanghes where numero = &#63;.
	 *
	 * @param numero the numero
	 * @return the matching allerta valanghes
	 */
	public java.util.List<AllertaValanghe> findByNumero(String numero);

	/**
	 * Returns a range of all the allerta valanghes where numero = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param numero the numero
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @return the range of matching allerta valanghes
	 */
	public java.util.List<AllertaValanghe> findByNumero(
		String numero, int start, int end);

	/**
	 * Returns an ordered range of all the allerta valanghes where numero = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param numero the numero
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching allerta valanghes
	 */
	public java.util.List<AllertaValanghe> findByNumero(
		String numero, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValanghe>
			orderByComparator);

	/**
	 * Returns an ordered range of all the allerta valanghes where numero = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param numero the numero
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching allerta valanghes
	 */
	public java.util.List<AllertaValanghe> findByNumero(
		String numero, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValanghe>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first allerta valanghe in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe
	 * @throws NoSuchAllertaValangheException if a matching allerta valanghe could not be found
	 */
	public AllertaValanghe findByNumero_First(
			String numero,
			com.liferay.portal.kernel.util.OrderByComparator<AllertaValanghe>
				orderByComparator)
		throws NoSuchAllertaValangheException;

	/**
	 * Returns the first allerta valanghe in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching allerta valanghe, or <code>null</code> if a matching allerta valanghe could not be found
	 */
	public AllertaValanghe fetchByNumero_First(
		String numero,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValanghe>
			orderByComparator);

	/**
	 * Returns the last allerta valanghe in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe
	 * @throws NoSuchAllertaValangheException if a matching allerta valanghe could not be found
	 */
	public AllertaValanghe findByNumero_Last(
			String numero,
			com.liferay.portal.kernel.util.OrderByComparator<AllertaValanghe>
				orderByComparator)
		throws NoSuchAllertaValangheException;

	/**
	 * Returns the last allerta valanghe in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching allerta valanghe, or <code>null</code> if a matching allerta valanghe could not be found
	 */
	public AllertaValanghe fetchByNumero_Last(
		String numero,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValanghe>
			orderByComparator);

	/**
	 * Returns the allerta valanghes before and after the current allerta valanghe in the ordered set where numero = &#63;.
	 *
	 * @param allertaValangheId the primary key of the current allerta valanghe
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next allerta valanghe
	 * @throws NoSuchAllertaValangheException if a allerta valanghe with the primary key could not be found
	 */
	public AllertaValanghe[] findByNumero_PrevAndNext(
			long allertaValangheId, String numero,
			com.liferay.portal.kernel.util.OrderByComparator<AllertaValanghe>
				orderByComparator)
		throws NoSuchAllertaValangheException;

	/**
	 * Removes all the allerta valanghes where numero = &#63; from the database.
	 *
	 * @param numero the numero
	 */
	public void removeByNumero(String numero);

	/**
	 * Returns the number of allerta valanghes where numero = &#63;.
	 *
	 * @param numero the numero
	 * @return the number of matching allerta valanghes
	 */
	public int countByNumero(String numero);

	/**
	 * Caches the allerta valanghe in the entity cache if it is enabled.
	 *
	 * @param allertaValanghe the allerta valanghe
	 */
	public void cacheResult(AllertaValanghe allertaValanghe);

	/**
	 * Caches the allerta valanghes in the entity cache if it is enabled.
	 *
	 * @param allertaValanghes the allerta valanghes
	 */
	public void cacheResult(java.util.List<AllertaValanghe> allertaValanghes);

	/**
	 * Creates a new allerta valanghe with the primary key. Does not add the allerta valanghe to the database.
	 *
	 * @param allertaValangheId the primary key for the new allerta valanghe
	 * @return the new allerta valanghe
	 */
	public AllertaValanghe create(long allertaValangheId);

	/**
	 * Removes the allerta valanghe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaValangheId the primary key of the allerta valanghe
	 * @return the allerta valanghe that was removed
	 * @throws NoSuchAllertaValangheException if a allerta valanghe with the primary key could not be found
	 */
	public AllertaValanghe remove(long allertaValangheId)
		throws NoSuchAllertaValangheException;

	public AllertaValanghe updateImpl(AllertaValanghe allertaValanghe);

	/**
	 * Returns the allerta valanghe with the primary key or throws a <code>NoSuchAllertaValangheException</code> if it could not be found.
	 *
	 * @param allertaValangheId the primary key of the allerta valanghe
	 * @return the allerta valanghe
	 * @throws NoSuchAllertaValangheException if a allerta valanghe with the primary key could not be found
	 */
	public AllertaValanghe findByPrimaryKey(long allertaValangheId)
		throws NoSuchAllertaValangheException;

	/**
	 * Returns the allerta valanghe with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param allertaValangheId the primary key of the allerta valanghe
	 * @return the allerta valanghe, or <code>null</code> if a allerta valanghe with the primary key could not be found
	 */
	public AllertaValanghe fetchByPrimaryKey(long allertaValangheId);

	/**
	 * Returns all the allerta valanghes.
	 *
	 * @return the allerta valanghes
	 */
	public java.util.List<AllertaValanghe> findAll();

	/**
	 * Returns a range of all the allerta valanghes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @return the range of allerta valanghes
	 */
	public java.util.List<AllertaValanghe> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the allerta valanghes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of allerta valanghes
	 */
	public java.util.List<AllertaValanghe> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValanghe>
			orderByComparator);

	/**
	 * Returns an ordered range of all the allerta valanghes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of allerta valanghes
	 */
	public java.util.List<AllertaValanghe> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AllertaValanghe>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the allerta valanghes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of allerta valanghes.
	 *
	 * @return the number of allerta valanghes
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}