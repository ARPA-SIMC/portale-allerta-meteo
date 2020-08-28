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

import it.eng.bollettino.exception.NoSuchBollettinoException;
import it.eng.bollettino.model.Bollettino;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the bollettino service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see BollettinoUtil
 * @generated
 */
@ProviderType
public interface BollettinoPersistence extends BasePersistence<Bollettino> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BollettinoUtil} to access the bollettino persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Bollettino> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the bollettinos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching bollettinos
	 */
	public java.util.List<Bollettino> findByUuid(String uuid);

	/**
	 * Returns a range of all the bollettinos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @return the range of matching bollettinos
	 */
	public java.util.List<Bollettino> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the bollettinos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bollettinos
	 */
	public java.util.List<Bollettino> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Bollettino>
			orderByComparator);

	/**
	 * Returns an ordered range of all the bollettinos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching bollettinos
	 */
	public java.util.List<Bollettino> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Bollettino>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first bollettino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino
	 * @throws NoSuchBollettinoException if a matching bollettino could not be found
	 */
	public Bollettino findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Bollettino>
				orderByComparator)
		throws NoSuchBollettinoException;

	/**
	 * Returns the first bollettino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino, or <code>null</code> if a matching bollettino could not be found
	 */
	public Bollettino fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Bollettino>
			orderByComparator);

	/**
	 * Returns the last bollettino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino
	 * @throws NoSuchBollettinoException if a matching bollettino could not be found
	 */
	public Bollettino findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Bollettino>
				orderByComparator)
		throws NoSuchBollettinoException;

	/**
	 * Returns the last bollettino in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino, or <code>null</code> if a matching bollettino could not be found
	 */
	public Bollettino fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Bollettino>
			orderByComparator);

	/**
	 * Returns the bollettinos before and after the current bollettino in the ordered set where uuid = &#63;.
	 *
	 * @param bollettinoId the primary key of the current bollettino
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bollettino
	 * @throws NoSuchBollettinoException if a bollettino with the primary key could not be found
	 */
	public Bollettino[] findByUuid_PrevAndNext(
			long bollettinoId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Bollettino>
				orderByComparator)
		throws NoSuchBollettinoException;

	/**
	 * Removes all the bollettinos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of bollettinos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching bollettinos
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the bollettino where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBollettinoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching bollettino
	 * @throws NoSuchBollettinoException if a matching bollettino could not be found
	 */
	public Bollettino findByUUID_G(String uuid, long groupId)
		throws NoSuchBollettinoException;

	/**
	 * Returns the bollettino where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching bollettino, or <code>null</code> if a matching bollettino could not be found
	 */
	public Bollettino fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the bollettino where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching bollettino, or <code>null</code> if a matching bollettino could not be found
	 */
	public Bollettino fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache);

	/**
	 * Removes the bollettino where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the bollettino that was removed
	 */
	public Bollettino removeByUUID_G(String uuid, long groupId)
		throws NoSuchBollettinoException;

	/**
	 * Returns the number of bollettinos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching bollettinos
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the bollettinos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching bollettinos
	 */
	public java.util.List<Bollettino> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the bollettinos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @return the range of matching bollettinos
	 */
	public java.util.List<Bollettino> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the bollettinos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bollettinos
	 */
	public java.util.List<Bollettino> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Bollettino>
			orderByComparator);

	/**
	 * Returns an ordered range of all the bollettinos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching bollettinos
	 */
	public java.util.List<Bollettino> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Bollettino>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first bollettino in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino
	 * @throws NoSuchBollettinoException if a matching bollettino could not be found
	 */
	public Bollettino findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Bollettino>
				orderByComparator)
		throws NoSuchBollettinoException;

	/**
	 * Returns the first bollettino in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino, or <code>null</code> if a matching bollettino could not be found
	 */
	public Bollettino fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Bollettino>
			orderByComparator);

	/**
	 * Returns the last bollettino in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino
	 * @throws NoSuchBollettinoException if a matching bollettino could not be found
	 */
	public Bollettino findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Bollettino>
				orderByComparator)
		throws NoSuchBollettinoException;

	/**
	 * Returns the last bollettino in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino, or <code>null</code> if a matching bollettino could not be found
	 */
	public Bollettino fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Bollettino>
			orderByComparator);

	/**
	 * Returns the bollettinos before and after the current bollettino in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param bollettinoId the primary key of the current bollettino
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bollettino
	 * @throws NoSuchBollettinoException if a bollettino with the primary key could not be found
	 */
	public Bollettino[] findByUuid_C_PrevAndNext(
			long bollettinoId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Bollettino>
				orderByComparator)
		throws NoSuchBollettinoException;

	/**
	 * Removes all the bollettinos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of bollettinos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching bollettinos
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the bollettinos where numero = &#63;.
	 *
	 * @param numero the numero
	 * @return the matching bollettinos
	 */
	public java.util.List<Bollettino> findByNumero(String numero);

	/**
	 * Returns a range of all the bollettinos where numero = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param numero the numero
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @return the range of matching bollettinos
	 */
	public java.util.List<Bollettino> findByNumero(
		String numero, int start, int end);

	/**
	 * Returns an ordered range of all the bollettinos where numero = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param numero the numero
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bollettinos
	 */
	public java.util.List<Bollettino> findByNumero(
		String numero, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Bollettino>
			orderByComparator);

	/**
	 * Returns an ordered range of all the bollettinos where numero = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param numero the numero
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching bollettinos
	 */
	public java.util.List<Bollettino> findByNumero(
		String numero, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Bollettino>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first bollettino in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino
	 * @throws NoSuchBollettinoException if a matching bollettino could not be found
	 */
	public Bollettino findByNumero_First(
			String numero,
			com.liferay.portal.kernel.util.OrderByComparator<Bollettino>
				orderByComparator)
		throws NoSuchBollettinoException;

	/**
	 * Returns the first bollettino in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bollettino, or <code>null</code> if a matching bollettino could not be found
	 */
	public Bollettino fetchByNumero_First(
		String numero,
		com.liferay.portal.kernel.util.OrderByComparator<Bollettino>
			orderByComparator);

	/**
	 * Returns the last bollettino in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino
	 * @throws NoSuchBollettinoException if a matching bollettino could not be found
	 */
	public Bollettino findByNumero_Last(
			String numero,
			com.liferay.portal.kernel.util.OrderByComparator<Bollettino>
				orderByComparator)
		throws NoSuchBollettinoException;

	/**
	 * Returns the last bollettino in the ordered set where numero = &#63;.
	 *
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bollettino, or <code>null</code> if a matching bollettino could not be found
	 */
	public Bollettino fetchByNumero_Last(
		String numero,
		com.liferay.portal.kernel.util.OrderByComparator<Bollettino>
			orderByComparator);

	/**
	 * Returns the bollettinos before and after the current bollettino in the ordered set where numero = &#63;.
	 *
	 * @param bollettinoId the primary key of the current bollettino
	 * @param numero the numero
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bollettino
	 * @throws NoSuchBollettinoException if a bollettino with the primary key could not be found
	 */
	public Bollettino[] findByNumero_PrevAndNext(
			long bollettinoId, String numero,
			com.liferay.portal.kernel.util.OrderByComparator<Bollettino>
				orderByComparator)
		throws NoSuchBollettinoException;

	/**
	 * Removes all the bollettinos where numero = &#63; from the database.
	 *
	 * @param numero the numero
	 */
	public void removeByNumero(String numero);

	/**
	 * Returns the number of bollettinos where numero = &#63;.
	 *
	 * @param numero the numero
	 * @return the number of matching bollettinos
	 */
	public int countByNumero(String numero);

	/**
	 * Caches the bollettino in the entity cache if it is enabled.
	 *
	 * @param bollettino the bollettino
	 */
	public void cacheResult(Bollettino bollettino);

	/**
	 * Caches the bollettinos in the entity cache if it is enabled.
	 *
	 * @param bollettinos the bollettinos
	 */
	public void cacheResult(java.util.List<Bollettino> bollettinos);

	/**
	 * Creates a new bollettino with the primary key. Does not add the bollettino to the database.
	 *
	 * @param bollettinoId the primary key for the new bollettino
	 * @return the new bollettino
	 */
	public Bollettino create(long bollettinoId);

	/**
	 * Removes the bollettino with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bollettinoId the primary key of the bollettino
	 * @return the bollettino that was removed
	 * @throws NoSuchBollettinoException if a bollettino with the primary key could not be found
	 */
	public Bollettino remove(long bollettinoId)
		throws NoSuchBollettinoException;

	public Bollettino updateImpl(Bollettino bollettino);

	/**
	 * Returns the bollettino with the primary key or throws a <code>NoSuchBollettinoException</code> if it could not be found.
	 *
	 * @param bollettinoId the primary key of the bollettino
	 * @return the bollettino
	 * @throws NoSuchBollettinoException if a bollettino with the primary key could not be found
	 */
	public Bollettino findByPrimaryKey(long bollettinoId)
		throws NoSuchBollettinoException;

	/**
	 * Returns the bollettino with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bollettinoId the primary key of the bollettino
	 * @return the bollettino, or <code>null</code> if a bollettino with the primary key could not be found
	 */
	public Bollettino fetchByPrimaryKey(long bollettinoId);

	/**
	 * Returns all the bollettinos.
	 *
	 * @return the bollettinos
	 */
	public java.util.List<Bollettino> findAll();

	/**
	 * Returns a range of all the bollettinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @return the range of bollettinos
	 */
	public java.util.List<Bollettino> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the bollettinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bollettinos
	 */
	public java.util.List<Bollettino> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Bollettino>
			orderByComparator);

	/**
	 * Returns an ordered range of all the bollettinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>BollettinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of bollettinos
	 */
	public java.util.List<Bollettino> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Bollettino>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the bollettinos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of bollettinos.
	 *
	 * @return the number of bollettinos
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}