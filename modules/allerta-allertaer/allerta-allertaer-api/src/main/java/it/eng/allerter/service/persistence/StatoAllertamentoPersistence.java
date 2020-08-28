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

import it.eng.allerter.exception.NoSuchStatoAllertamentoException;
import it.eng.allerter.model.StatoAllertamento;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the stato allertamento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see StatoAllertamentoUtil
 * @generated
 */
@ProviderType
public interface StatoAllertamentoPersistence
	extends BasePersistence<StatoAllertamento> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StatoAllertamentoUtil} to access the stato allertamento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, StatoAllertamento> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the stato allertamentos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching stato allertamentos
	 */
	public java.util.List<StatoAllertamento> findByUuid(String uuid);

	/**
	 * Returns a range of all the stato allertamentos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatoAllertamentoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of stato allertamentos
	 * @param end the upper bound of the range of stato allertamentos (not inclusive)
	 * @return the range of matching stato allertamentos
	 */
	public java.util.List<StatoAllertamento> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the stato allertamentos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatoAllertamentoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of stato allertamentos
	 * @param end the upper bound of the range of stato allertamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stato allertamentos
	 */
	public java.util.List<StatoAllertamento> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatoAllertamento>
			orderByComparator);

	/**
	 * Returns an ordered range of all the stato allertamentos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatoAllertamentoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of stato allertamentos
	 * @param end the upper bound of the range of stato allertamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching stato allertamentos
	 */
	public java.util.List<StatoAllertamento> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatoAllertamento>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first stato allertamento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a matching stato allertamento could not be found
	 */
	public StatoAllertamento findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<StatoAllertamento>
				orderByComparator)
		throws NoSuchStatoAllertamentoException;

	/**
	 * Returns the first stato allertamento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato allertamento, or <code>null</code> if a matching stato allertamento could not be found
	 */
	public StatoAllertamento fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<StatoAllertamento>
			orderByComparator);

	/**
	 * Returns the last stato allertamento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a matching stato allertamento could not be found
	 */
	public StatoAllertamento findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<StatoAllertamento>
				orderByComparator)
		throws NoSuchStatoAllertamentoException;

	/**
	 * Returns the last stato allertamento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato allertamento, or <code>null</code> if a matching stato allertamento could not be found
	 */
	public StatoAllertamento fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<StatoAllertamento>
			orderByComparator);

	/**
	 * Returns the stato allertamentos before and after the current stato allertamento in the ordered set where uuid = &#63;.
	 *
	 * @param statoId the primary key of the current stato allertamento
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a stato allertamento with the primary key could not be found
	 */
	public StatoAllertamento[] findByUuid_PrevAndNext(
			long statoId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<StatoAllertamento>
				orderByComparator)
		throws NoSuchStatoAllertamentoException;

	/**
	 * Removes all the stato allertamentos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of stato allertamentos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching stato allertamentos
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the stato allertamento where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchStatoAllertamentoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a matching stato allertamento could not be found
	 */
	public StatoAllertamento findByUUID_G(String uuid, long groupId)
		throws NoSuchStatoAllertamentoException;

	/**
	 * Returns the stato allertamento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching stato allertamento, or <code>null</code> if a matching stato allertamento could not be found
	 */
	public StatoAllertamento fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the stato allertamento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching stato allertamento, or <code>null</code> if a matching stato allertamento could not be found
	 */
	public StatoAllertamento fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache);

	/**
	 * Removes the stato allertamento where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the stato allertamento that was removed
	 */
	public StatoAllertamento removeByUUID_G(String uuid, long groupId)
		throws NoSuchStatoAllertamentoException;

	/**
	 * Returns the number of stato allertamentos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching stato allertamentos
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the stato allertamentos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching stato allertamentos
	 */
	public java.util.List<StatoAllertamento> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the stato allertamentos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatoAllertamentoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of stato allertamentos
	 * @param end the upper bound of the range of stato allertamentos (not inclusive)
	 * @return the range of matching stato allertamentos
	 */
	public java.util.List<StatoAllertamento> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the stato allertamentos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatoAllertamentoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of stato allertamentos
	 * @param end the upper bound of the range of stato allertamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stato allertamentos
	 */
	public java.util.List<StatoAllertamento> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatoAllertamento>
			orderByComparator);

	/**
	 * Returns an ordered range of all the stato allertamentos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatoAllertamentoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of stato allertamentos
	 * @param end the upper bound of the range of stato allertamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching stato allertamentos
	 */
	public java.util.List<StatoAllertamento> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatoAllertamento>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first stato allertamento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a matching stato allertamento could not be found
	 */
	public StatoAllertamento findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<StatoAllertamento>
				orderByComparator)
		throws NoSuchStatoAllertamentoException;

	/**
	 * Returns the first stato allertamento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato allertamento, or <code>null</code> if a matching stato allertamento could not be found
	 */
	public StatoAllertamento fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<StatoAllertamento>
			orderByComparator);

	/**
	 * Returns the last stato allertamento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a matching stato allertamento could not be found
	 */
	public StatoAllertamento findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<StatoAllertamento>
				orderByComparator)
		throws NoSuchStatoAllertamentoException;

	/**
	 * Returns the last stato allertamento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato allertamento, or <code>null</code> if a matching stato allertamento could not be found
	 */
	public StatoAllertamento fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<StatoAllertamento>
			orderByComparator);

	/**
	 * Returns the stato allertamentos before and after the current stato allertamento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param statoId the primary key of the current stato allertamento
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a stato allertamento with the primary key could not be found
	 */
	public StatoAllertamento[] findByUuid_C_PrevAndNext(
			long statoId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<StatoAllertamento>
				orderByComparator)
		throws NoSuchStatoAllertamentoException;

	/**
	 * Removes all the stato allertamentos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of stato allertamentos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching stato allertamentos
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the stato allertamentos where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the matching stato allertamentos
	 */
	public java.util.List<StatoAllertamento> findByNome(String nome);

	/**
	 * Returns a range of all the stato allertamentos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatoAllertamentoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of stato allertamentos
	 * @param end the upper bound of the range of stato allertamentos (not inclusive)
	 * @return the range of matching stato allertamentos
	 */
	public java.util.List<StatoAllertamento> findByNome(
		String nome, int start, int end);

	/**
	 * Returns an ordered range of all the stato allertamentos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatoAllertamentoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of stato allertamentos
	 * @param end the upper bound of the range of stato allertamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stato allertamentos
	 */
	public java.util.List<StatoAllertamento> findByNome(
		String nome, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatoAllertamento>
			orderByComparator);

	/**
	 * Returns an ordered range of all the stato allertamentos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatoAllertamentoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of stato allertamentos
	 * @param end the upper bound of the range of stato allertamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching stato allertamentos
	 */
	public java.util.List<StatoAllertamento> findByNome(
		String nome, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatoAllertamento>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first stato allertamento in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a matching stato allertamento could not be found
	 */
	public StatoAllertamento findByNome_First(
			String nome,
			com.liferay.portal.kernel.util.OrderByComparator<StatoAllertamento>
				orderByComparator)
		throws NoSuchStatoAllertamentoException;

	/**
	 * Returns the first stato allertamento in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato allertamento, or <code>null</code> if a matching stato allertamento could not be found
	 */
	public StatoAllertamento fetchByNome_First(
		String nome,
		com.liferay.portal.kernel.util.OrderByComparator<StatoAllertamento>
			orderByComparator);

	/**
	 * Returns the last stato allertamento in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a matching stato allertamento could not be found
	 */
	public StatoAllertamento findByNome_Last(
			String nome,
			com.liferay.portal.kernel.util.OrderByComparator<StatoAllertamento>
				orderByComparator)
		throws NoSuchStatoAllertamentoException;

	/**
	 * Returns the last stato allertamento in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato allertamento, or <code>null</code> if a matching stato allertamento could not be found
	 */
	public StatoAllertamento fetchByNome_Last(
		String nome,
		com.liferay.portal.kernel.util.OrderByComparator<StatoAllertamento>
			orderByComparator);

	/**
	 * Returns the stato allertamentos before and after the current stato allertamento in the ordered set where nome = &#63;.
	 *
	 * @param statoId the primary key of the current stato allertamento
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a stato allertamento with the primary key could not be found
	 */
	public StatoAllertamento[] findByNome_PrevAndNext(
			long statoId, String nome,
			com.liferay.portal.kernel.util.OrderByComparator<StatoAllertamento>
				orderByComparator)
		throws NoSuchStatoAllertamentoException;

	/**
	 * Removes all the stato allertamentos where nome = &#63; from the database.
	 *
	 * @param nome the nome
	 */
	public void removeByNome(String nome);

	/**
	 * Returns the number of stato allertamentos where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the number of matching stato allertamentos
	 */
	public int countByNome(String nome);

	/**
	 * Caches the stato allertamento in the entity cache if it is enabled.
	 *
	 * @param statoAllertamento the stato allertamento
	 */
	public void cacheResult(StatoAllertamento statoAllertamento);

	/**
	 * Caches the stato allertamentos in the entity cache if it is enabled.
	 *
	 * @param statoAllertamentos the stato allertamentos
	 */
	public void cacheResult(
		java.util.List<StatoAllertamento> statoAllertamentos);

	/**
	 * Creates a new stato allertamento with the primary key. Does not add the stato allertamento to the database.
	 *
	 * @param statoId the primary key for the new stato allertamento
	 * @return the new stato allertamento
	 */
	public StatoAllertamento create(long statoId);

	/**
	 * Removes the stato allertamento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param statoId the primary key of the stato allertamento
	 * @return the stato allertamento that was removed
	 * @throws NoSuchStatoAllertamentoException if a stato allertamento with the primary key could not be found
	 */
	public StatoAllertamento remove(long statoId)
		throws NoSuchStatoAllertamentoException;

	public StatoAllertamento updateImpl(StatoAllertamento statoAllertamento);

	/**
	 * Returns the stato allertamento with the primary key or throws a <code>NoSuchStatoAllertamentoException</code> if it could not be found.
	 *
	 * @param statoId the primary key of the stato allertamento
	 * @return the stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a stato allertamento with the primary key could not be found
	 */
	public StatoAllertamento findByPrimaryKey(long statoId)
		throws NoSuchStatoAllertamentoException;

	/**
	 * Returns the stato allertamento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param statoId the primary key of the stato allertamento
	 * @return the stato allertamento, or <code>null</code> if a stato allertamento with the primary key could not be found
	 */
	public StatoAllertamento fetchByPrimaryKey(long statoId);

	/**
	 * Returns all the stato allertamentos.
	 *
	 * @return the stato allertamentos
	 */
	public java.util.List<StatoAllertamento> findAll();

	/**
	 * Returns a range of all the stato allertamentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatoAllertamentoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato allertamentos
	 * @param end the upper bound of the range of stato allertamentos (not inclusive)
	 * @return the range of stato allertamentos
	 */
	public java.util.List<StatoAllertamento> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the stato allertamentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatoAllertamentoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato allertamentos
	 * @param end the upper bound of the range of stato allertamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of stato allertamentos
	 */
	public java.util.List<StatoAllertamento> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatoAllertamento>
			orderByComparator);

	/**
	 * Returns an ordered range of all the stato allertamentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StatoAllertamentoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato allertamentos
	 * @param end the upper bound of the range of stato allertamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of stato allertamentos
	 */
	public java.util.List<StatoAllertamento> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StatoAllertamento>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the stato allertamentos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of stato allertamentos.
	 *
	 * @return the number of stato allertamentos
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}