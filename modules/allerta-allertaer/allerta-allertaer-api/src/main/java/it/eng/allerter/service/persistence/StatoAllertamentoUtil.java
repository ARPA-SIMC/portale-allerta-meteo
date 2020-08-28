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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.allerter.model.StatoAllertamento;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the stato allertamento service. This utility wraps <code>it.eng.allerter.service.persistence.impl.StatoAllertamentoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see StatoAllertamentoPersistence
 * @generated
 */
@ProviderType
public class StatoAllertamentoUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(StatoAllertamento statoAllertamento) {
		getPersistence().clearCache(statoAllertamento);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, StatoAllertamento> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StatoAllertamento> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StatoAllertamento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StatoAllertamento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StatoAllertamento> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StatoAllertamento update(
		StatoAllertamento statoAllertamento) {

		return getPersistence().update(statoAllertamento);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StatoAllertamento update(
		StatoAllertamento statoAllertamento, ServiceContext serviceContext) {

		return getPersistence().update(statoAllertamento, serviceContext);
	}

	/**
	 * Returns all the stato allertamentos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching stato allertamentos
	 */
	public static List<StatoAllertamento> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<StatoAllertamento> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<StatoAllertamento> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<StatoAllertamento> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<StatoAllertamento> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<StatoAllertamento> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first stato allertamento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a matching stato allertamento could not be found
	 */
	public static StatoAllertamento findByUuid_First(
			String uuid, OrderByComparator<StatoAllertamento> orderByComparator)
		throws it.eng.allerter.exception.NoSuchStatoAllertamentoException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first stato allertamento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato allertamento, or <code>null</code> if a matching stato allertamento could not be found
	 */
	public static StatoAllertamento fetchByUuid_First(
		String uuid, OrderByComparator<StatoAllertamento> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last stato allertamento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a matching stato allertamento could not be found
	 */
	public static StatoAllertamento findByUuid_Last(
			String uuid, OrderByComparator<StatoAllertamento> orderByComparator)
		throws it.eng.allerter.exception.NoSuchStatoAllertamentoException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last stato allertamento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato allertamento, or <code>null</code> if a matching stato allertamento could not be found
	 */
	public static StatoAllertamento fetchByUuid_Last(
		String uuid, OrderByComparator<StatoAllertamento> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the stato allertamentos before and after the current stato allertamento in the ordered set where uuid = &#63;.
	 *
	 * @param statoId the primary key of the current stato allertamento
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a stato allertamento with the primary key could not be found
	 */
	public static StatoAllertamento[] findByUuid_PrevAndNext(
			long statoId, String uuid,
			OrderByComparator<StatoAllertamento> orderByComparator)
		throws it.eng.allerter.exception.NoSuchStatoAllertamentoException {

		return getPersistence().findByUuid_PrevAndNext(
			statoId, uuid, orderByComparator);
	}

	/**
	 * Removes all the stato allertamentos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of stato allertamentos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching stato allertamentos
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the stato allertamento where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchStatoAllertamentoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a matching stato allertamento could not be found
	 */
	public static StatoAllertamento findByUUID_G(String uuid, long groupId)
		throws it.eng.allerter.exception.NoSuchStatoAllertamentoException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the stato allertamento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching stato allertamento, or <code>null</code> if a matching stato allertamento could not be found
	 */
	public static StatoAllertamento fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the stato allertamento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching stato allertamento, or <code>null</code> if a matching stato allertamento could not be found
	 */
	public static StatoAllertamento fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	 * Removes the stato allertamento where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the stato allertamento that was removed
	 */
	public static StatoAllertamento removeByUUID_G(String uuid, long groupId)
		throws it.eng.allerter.exception.NoSuchStatoAllertamentoException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of stato allertamentos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching stato allertamentos
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the stato allertamentos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching stato allertamentos
	 */
	public static List<StatoAllertamento> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<StatoAllertamento> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<StatoAllertamento> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<StatoAllertamento> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<StatoAllertamento> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<StatoAllertamento> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first stato allertamento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a matching stato allertamento could not be found
	 */
	public static StatoAllertamento findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<StatoAllertamento> orderByComparator)
		throws it.eng.allerter.exception.NoSuchStatoAllertamentoException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first stato allertamento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato allertamento, or <code>null</code> if a matching stato allertamento could not be found
	 */
	public static StatoAllertamento fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<StatoAllertamento> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last stato allertamento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a matching stato allertamento could not be found
	 */
	public static StatoAllertamento findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<StatoAllertamento> orderByComparator)
		throws it.eng.allerter.exception.NoSuchStatoAllertamentoException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last stato allertamento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato allertamento, or <code>null</code> if a matching stato allertamento could not be found
	 */
	public static StatoAllertamento fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<StatoAllertamento> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static StatoAllertamento[] findByUuid_C_PrevAndNext(
			long statoId, String uuid, long companyId,
			OrderByComparator<StatoAllertamento> orderByComparator)
		throws it.eng.allerter.exception.NoSuchStatoAllertamentoException {

		return getPersistence().findByUuid_C_PrevAndNext(
			statoId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the stato allertamentos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of stato allertamentos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching stato allertamentos
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the stato allertamentos where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the matching stato allertamentos
	 */
	public static List<StatoAllertamento> findByNome(String nome) {
		return getPersistence().findByNome(nome);
	}

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
	public static List<StatoAllertamento> findByNome(
		String nome, int start, int end) {

		return getPersistence().findByNome(nome, start, end);
	}

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
	public static List<StatoAllertamento> findByNome(
		String nome, int start, int end,
		OrderByComparator<StatoAllertamento> orderByComparator) {

		return getPersistence().findByNome(nome, start, end, orderByComparator);
	}

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
	public static List<StatoAllertamento> findByNome(
		String nome, int start, int end,
		OrderByComparator<StatoAllertamento> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByNome(
			nome, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first stato allertamento in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a matching stato allertamento could not be found
	 */
	public static StatoAllertamento findByNome_First(
			String nome, OrderByComparator<StatoAllertamento> orderByComparator)
		throws it.eng.allerter.exception.NoSuchStatoAllertamentoException {

		return getPersistence().findByNome_First(nome, orderByComparator);
	}

	/**
	 * Returns the first stato allertamento in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stato allertamento, or <code>null</code> if a matching stato allertamento could not be found
	 */
	public static StatoAllertamento fetchByNome_First(
		String nome, OrderByComparator<StatoAllertamento> orderByComparator) {

		return getPersistence().fetchByNome_First(nome, orderByComparator);
	}

	/**
	 * Returns the last stato allertamento in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a matching stato allertamento could not be found
	 */
	public static StatoAllertamento findByNome_Last(
			String nome, OrderByComparator<StatoAllertamento> orderByComparator)
		throws it.eng.allerter.exception.NoSuchStatoAllertamentoException {

		return getPersistence().findByNome_Last(nome, orderByComparator);
	}

	/**
	 * Returns the last stato allertamento in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stato allertamento, or <code>null</code> if a matching stato allertamento could not be found
	 */
	public static StatoAllertamento fetchByNome_Last(
		String nome, OrderByComparator<StatoAllertamento> orderByComparator) {

		return getPersistence().fetchByNome_Last(nome, orderByComparator);
	}

	/**
	 * Returns the stato allertamentos before and after the current stato allertamento in the ordered set where nome = &#63;.
	 *
	 * @param statoId the primary key of the current stato allertamento
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a stato allertamento with the primary key could not be found
	 */
	public static StatoAllertamento[] findByNome_PrevAndNext(
			long statoId, String nome,
			OrderByComparator<StatoAllertamento> orderByComparator)
		throws it.eng.allerter.exception.NoSuchStatoAllertamentoException {

		return getPersistence().findByNome_PrevAndNext(
			statoId, nome, orderByComparator);
	}

	/**
	 * Removes all the stato allertamentos where nome = &#63; from the database.
	 *
	 * @param nome the nome
	 */
	public static void removeByNome(String nome) {
		getPersistence().removeByNome(nome);
	}

	/**
	 * Returns the number of stato allertamentos where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the number of matching stato allertamentos
	 */
	public static int countByNome(String nome) {
		return getPersistence().countByNome(nome);
	}

	/**
	 * Caches the stato allertamento in the entity cache if it is enabled.
	 *
	 * @param statoAllertamento the stato allertamento
	 */
	public static void cacheResult(StatoAllertamento statoAllertamento) {
		getPersistence().cacheResult(statoAllertamento);
	}

	/**
	 * Caches the stato allertamentos in the entity cache if it is enabled.
	 *
	 * @param statoAllertamentos the stato allertamentos
	 */
	public static void cacheResult(List<StatoAllertamento> statoAllertamentos) {
		getPersistence().cacheResult(statoAllertamentos);
	}

	/**
	 * Creates a new stato allertamento with the primary key. Does not add the stato allertamento to the database.
	 *
	 * @param statoId the primary key for the new stato allertamento
	 * @return the new stato allertamento
	 */
	public static StatoAllertamento create(long statoId) {
		return getPersistence().create(statoId);
	}

	/**
	 * Removes the stato allertamento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param statoId the primary key of the stato allertamento
	 * @return the stato allertamento that was removed
	 * @throws NoSuchStatoAllertamentoException if a stato allertamento with the primary key could not be found
	 */
	public static StatoAllertamento remove(long statoId)
		throws it.eng.allerter.exception.NoSuchStatoAllertamentoException {

		return getPersistence().remove(statoId);
	}

	public static StatoAllertamento updateImpl(
		StatoAllertamento statoAllertamento) {

		return getPersistence().updateImpl(statoAllertamento);
	}

	/**
	 * Returns the stato allertamento with the primary key or throws a <code>NoSuchStatoAllertamentoException</code> if it could not be found.
	 *
	 * @param statoId the primary key of the stato allertamento
	 * @return the stato allertamento
	 * @throws NoSuchStatoAllertamentoException if a stato allertamento with the primary key could not be found
	 */
	public static StatoAllertamento findByPrimaryKey(long statoId)
		throws it.eng.allerter.exception.NoSuchStatoAllertamentoException {

		return getPersistence().findByPrimaryKey(statoId);
	}

	/**
	 * Returns the stato allertamento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param statoId the primary key of the stato allertamento
	 * @return the stato allertamento, or <code>null</code> if a stato allertamento with the primary key could not be found
	 */
	public static StatoAllertamento fetchByPrimaryKey(long statoId) {
		return getPersistence().fetchByPrimaryKey(statoId);
	}

	/**
	 * Returns all the stato allertamentos.
	 *
	 * @return the stato allertamentos
	 */
	public static List<StatoAllertamento> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<StatoAllertamento> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<StatoAllertamento> findAll(
		int start, int end,
		OrderByComparator<StatoAllertamento> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<StatoAllertamento> findAll(
		int start, int end,
		OrderByComparator<StatoAllertamento> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the stato allertamentos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of stato allertamentos.
	 *
	 * @return the number of stato allertamentos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static StatoAllertamentoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<StatoAllertamentoPersistence, StatoAllertamentoPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			StatoAllertamentoPersistence.class);

		ServiceTracker
			<StatoAllertamentoPersistence, StatoAllertamentoPersistence>
				serviceTracker =
					new ServiceTracker
						<StatoAllertamentoPersistence,
						 StatoAllertamentoPersistence>(
							 bundle.getBundleContext(),
							 StatoAllertamentoPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}