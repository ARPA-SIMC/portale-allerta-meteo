/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.allerter.model.TipoEvento;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the tipo evento service. This utility wraps <code>it.eng.allerter.service.persistence.impl.TipoEventoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see TipoEventoPersistence
 * @generated
 */
public class TipoEventoUtil {

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
	public static void clearCache(TipoEvento tipoEvento) {
		getPersistence().clearCache(tipoEvento);
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
	public static Map<Serializable, TipoEvento> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TipoEvento> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TipoEvento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TipoEvento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TipoEvento> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TipoEvento update(TipoEvento tipoEvento) {
		return getPersistence().update(tipoEvento);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TipoEvento update(
		TipoEvento tipoEvento, ServiceContext serviceContext) {

		return getPersistence().update(tipoEvento, serviceContext);
	}

	/**
	 * Returns all the tipo eventos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching tipo eventos
	 */
	public static List<TipoEvento> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the tipo eventos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @return the range of matching tipo eventos
	 */
	public static List<TipoEvento> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the tipo eventos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipo eventos
	 */
	public static List<TipoEvento> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TipoEvento> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tipo eventos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tipo eventos
	 */
	public static List<TipoEvento> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TipoEvento> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first tipo evento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo evento
	 * @throws NoSuchTipoEventoException if a matching tipo evento could not be found
	 */
	public static TipoEvento findByUuid_First(
			String uuid, OrderByComparator<TipoEvento> orderByComparator)
		throws it.eng.allerter.exception.NoSuchTipoEventoException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first tipo evento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	public static TipoEvento fetchByUuid_First(
		String uuid, OrderByComparator<TipoEvento> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last tipo evento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo evento
	 * @throws NoSuchTipoEventoException if a matching tipo evento could not be found
	 */
	public static TipoEvento findByUuid_Last(
			String uuid, OrderByComparator<TipoEvento> orderByComparator)
		throws it.eng.allerter.exception.NoSuchTipoEventoException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last tipo evento in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	public static TipoEvento fetchByUuid_Last(
		String uuid, OrderByComparator<TipoEvento> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the tipo eventos before and after the current tipo evento in the ordered set where uuid = &#63;.
	 *
	 * @param eventoId the primary key of the current tipo evento
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tipo evento
	 * @throws NoSuchTipoEventoException if a tipo evento with the primary key could not be found
	 */
	public static TipoEvento[] findByUuid_PrevAndNext(
			long eventoId, String uuid,
			OrderByComparator<TipoEvento> orderByComparator)
		throws it.eng.allerter.exception.NoSuchTipoEventoException {

		return getPersistence().findByUuid_PrevAndNext(
			eventoId, uuid, orderByComparator);
	}

	/**
	 * Removes all the tipo eventos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of tipo eventos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching tipo eventos
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the tipo evento where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTipoEventoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching tipo evento
	 * @throws NoSuchTipoEventoException if a matching tipo evento could not be found
	 */
	public static TipoEvento findByUUID_G(String uuid, long groupId)
		throws it.eng.allerter.exception.NoSuchTipoEventoException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the tipo evento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	public static TipoEvento fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the tipo evento where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	public static TipoEvento fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the tipo evento where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the tipo evento that was removed
	 */
	public static TipoEvento removeByUUID_G(String uuid, long groupId)
		throws it.eng.allerter.exception.NoSuchTipoEventoException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of tipo eventos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching tipo eventos
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the tipo eventos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching tipo eventos
	 */
	public static List<TipoEvento> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the tipo eventos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @return the range of matching tipo eventos
	 */
	public static List<TipoEvento> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the tipo eventos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipo eventos
	 */
	public static List<TipoEvento> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TipoEvento> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tipo eventos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tipo eventos
	 */
	public static List<TipoEvento> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TipoEvento> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first tipo evento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo evento
	 * @throws NoSuchTipoEventoException if a matching tipo evento could not be found
	 */
	public static TipoEvento findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TipoEvento> orderByComparator)
		throws it.eng.allerter.exception.NoSuchTipoEventoException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first tipo evento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	public static TipoEvento fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TipoEvento> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last tipo evento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo evento
	 * @throws NoSuchTipoEventoException if a matching tipo evento could not be found
	 */
	public static TipoEvento findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TipoEvento> orderByComparator)
		throws it.eng.allerter.exception.NoSuchTipoEventoException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last tipo evento in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	public static TipoEvento fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TipoEvento> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static TipoEvento[] findByUuid_C_PrevAndNext(
			long eventoId, String uuid, long companyId,
			OrderByComparator<TipoEvento> orderByComparator)
		throws it.eng.allerter.exception.NoSuchTipoEventoException {

		return getPersistence().findByUuid_C_PrevAndNext(
			eventoId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the tipo eventos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of tipo eventos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching tipo eventos
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the tipo eventos where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the matching tipo eventos
	 */
	public static List<TipoEvento> findByNome(String nome) {
		return getPersistence().findByNome(nome);
	}

	/**
	 * Returns a range of all the tipo eventos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @return the range of matching tipo eventos
	 */
	public static List<TipoEvento> findByNome(String nome, int start, int end) {
		return getPersistence().findByNome(nome, start, end);
	}

	/**
	 * Returns an ordered range of all the tipo eventos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipo eventos
	 */
	public static List<TipoEvento> findByNome(
		String nome, int start, int end,
		OrderByComparator<TipoEvento> orderByComparator) {

		return getPersistence().findByNome(nome, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tipo eventos where nome = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>.
	 * </p>
	 *
	 * @param nome the nome
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tipo eventos
	 */
	public static List<TipoEvento> findByNome(
		String nome, int start, int end,
		OrderByComparator<TipoEvento> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByNome(
			nome, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first tipo evento in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo evento
	 * @throws NoSuchTipoEventoException if a matching tipo evento could not be found
	 */
	public static TipoEvento findByNome_First(
			String nome, OrderByComparator<TipoEvento> orderByComparator)
		throws it.eng.allerter.exception.NoSuchTipoEventoException {

		return getPersistence().findByNome_First(nome, orderByComparator);
	}

	/**
	 * Returns the first tipo evento in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	public static TipoEvento fetchByNome_First(
		String nome, OrderByComparator<TipoEvento> orderByComparator) {

		return getPersistence().fetchByNome_First(nome, orderByComparator);
	}

	/**
	 * Returns the last tipo evento in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo evento
	 * @throws NoSuchTipoEventoException if a matching tipo evento could not be found
	 */
	public static TipoEvento findByNome_Last(
			String nome, OrderByComparator<TipoEvento> orderByComparator)
		throws it.eng.allerter.exception.NoSuchTipoEventoException {

		return getPersistence().findByNome_Last(nome, orderByComparator);
	}

	/**
	 * Returns the last tipo evento in the ordered set where nome = &#63;.
	 *
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	public static TipoEvento fetchByNome_Last(
		String nome, OrderByComparator<TipoEvento> orderByComparator) {

		return getPersistence().fetchByNome_Last(nome, orderByComparator);
	}

	/**
	 * Returns the tipo eventos before and after the current tipo evento in the ordered set where nome = &#63;.
	 *
	 * @param eventoId the primary key of the current tipo evento
	 * @param nome the nome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tipo evento
	 * @throws NoSuchTipoEventoException if a tipo evento with the primary key could not be found
	 */
	public static TipoEvento[] findByNome_PrevAndNext(
			long eventoId, String nome,
			OrderByComparator<TipoEvento> orderByComparator)
		throws it.eng.allerter.exception.NoSuchTipoEventoException {

		return getPersistence().findByNome_PrevAndNext(
			eventoId, nome, orderByComparator);
	}

	/**
	 * Removes all the tipo eventos where nome = &#63; from the database.
	 *
	 * @param nome the nome
	 */
	public static void removeByNome(String nome) {
		getPersistence().removeByNome(nome);
	}

	/**
	 * Returns the number of tipo eventos where nome = &#63;.
	 *
	 * @param nome the nome
	 * @return the number of matching tipo eventos
	 */
	public static int countByNome(String nome) {
		return getPersistence().countByNome(nome);
	}

	/**
	 * Returns all the tipo eventos where tabella = &#63;.
	 *
	 * @param tabella the tabella
	 * @return the matching tipo eventos
	 */
	public static List<TipoEvento> findByTabella(int tabella) {
		return getPersistence().findByTabella(tabella);
	}

	/**
	 * Returns a range of all the tipo eventos where tabella = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>.
	 * </p>
	 *
	 * @param tabella the tabella
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @return the range of matching tipo eventos
	 */
	public static List<TipoEvento> findByTabella(
		int tabella, int start, int end) {

		return getPersistence().findByTabella(tabella, start, end);
	}

	/**
	 * Returns an ordered range of all the tipo eventos where tabella = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>.
	 * </p>
	 *
	 * @param tabella the tabella
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipo eventos
	 */
	public static List<TipoEvento> findByTabella(
		int tabella, int start, int end,
		OrderByComparator<TipoEvento> orderByComparator) {

		return getPersistence().findByTabella(
			tabella, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tipo eventos where tabella = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>.
	 * </p>
	 *
	 * @param tabella the tabella
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tipo eventos
	 */
	public static List<TipoEvento> findByTabella(
		int tabella, int start, int end,
		OrderByComparator<TipoEvento> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTabella(
			tabella, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first tipo evento in the ordered set where tabella = &#63;.
	 *
	 * @param tabella the tabella
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo evento
	 * @throws NoSuchTipoEventoException if a matching tipo evento could not be found
	 */
	public static TipoEvento findByTabella_First(
			int tabella, OrderByComparator<TipoEvento> orderByComparator)
		throws it.eng.allerter.exception.NoSuchTipoEventoException {

		return getPersistence().findByTabella_First(tabella, orderByComparator);
	}

	/**
	 * Returns the first tipo evento in the ordered set where tabella = &#63;.
	 *
	 * @param tabella the tabella
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	public static TipoEvento fetchByTabella_First(
		int tabella, OrderByComparator<TipoEvento> orderByComparator) {

		return getPersistence().fetchByTabella_First(
			tabella, orderByComparator);
	}

	/**
	 * Returns the last tipo evento in the ordered set where tabella = &#63;.
	 *
	 * @param tabella the tabella
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo evento
	 * @throws NoSuchTipoEventoException if a matching tipo evento could not be found
	 */
	public static TipoEvento findByTabella_Last(
			int tabella, OrderByComparator<TipoEvento> orderByComparator)
		throws it.eng.allerter.exception.NoSuchTipoEventoException {

		return getPersistence().findByTabella_Last(tabella, orderByComparator);
	}

	/**
	 * Returns the last tipo evento in the ordered set where tabella = &#63;.
	 *
	 * @param tabella the tabella
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	public static TipoEvento fetchByTabella_Last(
		int tabella, OrderByComparator<TipoEvento> orderByComparator) {

		return getPersistence().fetchByTabella_Last(tabella, orderByComparator);
	}

	/**
	 * Returns the tipo eventos before and after the current tipo evento in the ordered set where tabella = &#63;.
	 *
	 * @param eventoId the primary key of the current tipo evento
	 * @param tabella the tabella
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tipo evento
	 * @throws NoSuchTipoEventoException if a tipo evento with the primary key could not be found
	 */
	public static TipoEvento[] findByTabella_PrevAndNext(
			long eventoId, int tabella,
			OrderByComparator<TipoEvento> orderByComparator)
		throws it.eng.allerter.exception.NoSuchTipoEventoException {

		return getPersistence().findByTabella_PrevAndNext(
			eventoId, tabella, orderByComparator);
	}

	/**
	 * Removes all the tipo eventos where tabella = &#63; from the database.
	 *
	 * @param tabella the tabella
	 */
	public static void removeByTabella(int tabella) {
		getPersistence().removeByTabella(tabella);
	}

	/**
	 * Returns the number of tipo eventos where tabella = &#63;.
	 *
	 * @param tabella the tabella
	 * @return the number of matching tipo eventos
	 */
	public static int countByTabella(int tabella) {
		return getPersistence().countByTabella(tabella);
	}

	/**
	 * Caches the tipo evento in the entity cache if it is enabled.
	 *
	 * @param tipoEvento the tipo evento
	 */
	public static void cacheResult(TipoEvento tipoEvento) {
		getPersistence().cacheResult(tipoEvento);
	}

	/**
	 * Caches the tipo eventos in the entity cache if it is enabled.
	 *
	 * @param tipoEventos the tipo eventos
	 */
	public static void cacheResult(List<TipoEvento> tipoEventos) {
		getPersistence().cacheResult(tipoEventos);
	}

	/**
	 * Creates a new tipo evento with the primary key. Does not add the tipo evento to the database.
	 *
	 * @param eventoId the primary key for the new tipo evento
	 * @return the new tipo evento
	 */
	public static TipoEvento create(long eventoId) {
		return getPersistence().create(eventoId);
	}

	/**
	 * Removes the tipo evento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventoId the primary key of the tipo evento
	 * @return the tipo evento that was removed
	 * @throws NoSuchTipoEventoException if a tipo evento with the primary key could not be found
	 */
	public static TipoEvento remove(long eventoId)
		throws it.eng.allerter.exception.NoSuchTipoEventoException {

		return getPersistence().remove(eventoId);
	}

	public static TipoEvento updateImpl(TipoEvento tipoEvento) {
		return getPersistence().updateImpl(tipoEvento);
	}

	/**
	 * Returns the tipo evento with the primary key or throws a <code>NoSuchTipoEventoException</code> if it could not be found.
	 *
	 * @param eventoId the primary key of the tipo evento
	 * @return the tipo evento
	 * @throws NoSuchTipoEventoException if a tipo evento with the primary key could not be found
	 */
	public static TipoEvento findByPrimaryKey(long eventoId)
		throws it.eng.allerter.exception.NoSuchTipoEventoException {

		return getPersistence().findByPrimaryKey(eventoId);
	}

	/**
	 * Returns the tipo evento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventoId the primary key of the tipo evento
	 * @return the tipo evento, or <code>null</code> if a tipo evento with the primary key could not be found
	 */
	public static TipoEvento fetchByPrimaryKey(long eventoId) {
		return getPersistence().fetchByPrimaryKey(eventoId);
	}

	/**
	 * Returns all the tipo eventos.
	 *
	 * @return the tipo eventos
	 */
	public static List<TipoEvento> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the tipo eventos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @return the range of tipo eventos
	 */
	public static List<TipoEvento> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the tipo eventos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tipo eventos
	 */
	public static List<TipoEvento> findAll(
		int start, int end, OrderByComparator<TipoEvento> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tipo eventos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipoEventoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of tipo eventos
	 */
	public static List<TipoEvento> findAll(
		int start, int end, OrderByComparator<TipoEvento> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the tipo eventos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of tipo eventos.
	 *
	 * @return the number of tipo eventos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TipoEventoPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(TipoEventoPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile TipoEventoPersistence _persistence;

}