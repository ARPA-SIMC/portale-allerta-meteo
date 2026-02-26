/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.bollettino.model.StazioneVariabile;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the stazione variabile service. This utility wraps <code>it.eng.bollettino.service.persistence.impl.StazioneVariabilePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see StazioneVariabilePersistence
 * @generated
 */
public class StazioneVariabileUtil {

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
	public static void clearCache(StazioneVariabile stazioneVariabile) {
		getPersistence().clearCache(stazioneVariabile);
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
	public static Map<Serializable, StazioneVariabile> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StazioneVariabile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StazioneVariabile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StazioneVariabile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StazioneVariabile> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StazioneVariabile update(
		StazioneVariabile stazioneVariabile) {

		return getPersistence().update(stazioneVariabile);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StazioneVariabile update(
		StazioneVariabile stazioneVariabile, ServiceContext serviceContext) {

		return getPersistence().update(stazioneVariabile, serviceContext);
	}

	/**
	 * Returns all the stazione variabiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching stazione variabiles
	 */
	public static List<StazioneVariabile> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the stazione variabiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @return the range of matching stazione variabiles
	 */
	public static List<StazioneVariabile> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the stazione variabiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stazione variabiles
	 */
	public static List<StazioneVariabile> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<StazioneVariabile> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the stazione variabiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching stazione variabiles
	 */
	public static List<StazioneVariabile> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<StazioneVariabile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first stazione variabile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione variabile
	 * @throws NoSuchStazioneVariabileException if a matching stazione variabile could not be found
	 */
	public static StazioneVariabile findByUuid_First(
			String uuid, OrderByComparator<StazioneVariabile> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchStazioneVariabileException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first stazione variabile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione variabile, or <code>null</code> if a matching stazione variabile could not be found
	 */
	public static StazioneVariabile fetchByUuid_First(
		String uuid, OrderByComparator<StazioneVariabile> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last stazione variabile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione variabile
	 * @throws NoSuchStazioneVariabileException if a matching stazione variabile could not be found
	 */
	public static StazioneVariabile findByUuid_Last(
			String uuid, OrderByComparator<StazioneVariabile> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchStazioneVariabileException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last stazione variabile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione variabile, or <code>null</code> if a matching stazione variabile could not be found
	 */
	public static StazioneVariabile fetchByUuid_Last(
		String uuid, OrderByComparator<StazioneVariabile> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the stazione variabiles before and after the current stazione variabile in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current stazione variabile
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stazione variabile
	 * @throws NoSuchStazioneVariabileException if a stazione variabile with the primary key could not be found
	 */
	public static StazioneVariabile[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<StazioneVariabile> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchStazioneVariabileException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the stazione variabiles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of stazione variabiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching stazione variabiles
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the stazione variabiles where idStazione = &#63;.
	 *
	 * @param idStazione the id stazione
	 * @return the matching stazione variabiles
	 */
	public static List<StazioneVariabile> findByStazione(String idStazione) {
		return getPersistence().findByStazione(idStazione);
	}

	/**
	 * Returns a range of all the stazione variabiles where idStazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>.
	 * </p>
	 *
	 * @param idStazione the id stazione
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @return the range of matching stazione variabiles
	 */
	public static List<StazioneVariabile> findByStazione(
		String idStazione, int start, int end) {

		return getPersistence().findByStazione(idStazione, start, end);
	}

	/**
	 * Returns an ordered range of all the stazione variabiles where idStazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>.
	 * </p>
	 *
	 * @param idStazione the id stazione
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stazione variabiles
	 */
	public static List<StazioneVariabile> findByStazione(
		String idStazione, int start, int end,
		OrderByComparator<StazioneVariabile> orderByComparator) {

		return getPersistence().findByStazione(
			idStazione, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the stazione variabiles where idStazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>.
	 * </p>
	 *
	 * @param idStazione the id stazione
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching stazione variabiles
	 */
	public static List<StazioneVariabile> findByStazione(
		String idStazione, int start, int end,
		OrderByComparator<StazioneVariabile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStazione(
			idStazione, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first stazione variabile in the ordered set where idStazione = &#63;.
	 *
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione variabile
	 * @throws NoSuchStazioneVariabileException if a matching stazione variabile could not be found
	 */
	public static StazioneVariabile findByStazione_First(
			String idStazione,
			OrderByComparator<StazioneVariabile> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchStazioneVariabileException {

		return getPersistence().findByStazione_First(
			idStazione, orderByComparator);
	}

	/**
	 * Returns the first stazione variabile in the ordered set where idStazione = &#63;.
	 *
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione variabile, or <code>null</code> if a matching stazione variabile could not be found
	 */
	public static StazioneVariabile fetchByStazione_First(
		String idStazione,
		OrderByComparator<StazioneVariabile> orderByComparator) {

		return getPersistence().fetchByStazione_First(
			idStazione, orderByComparator);
	}

	/**
	 * Returns the last stazione variabile in the ordered set where idStazione = &#63;.
	 *
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione variabile
	 * @throws NoSuchStazioneVariabileException if a matching stazione variabile could not be found
	 */
	public static StazioneVariabile findByStazione_Last(
			String idStazione,
			OrderByComparator<StazioneVariabile> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchStazioneVariabileException {

		return getPersistence().findByStazione_Last(
			idStazione, orderByComparator);
	}

	/**
	 * Returns the last stazione variabile in the ordered set where idStazione = &#63;.
	 *
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione variabile, or <code>null</code> if a matching stazione variabile could not be found
	 */
	public static StazioneVariabile fetchByStazione_Last(
		String idStazione,
		OrderByComparator<StazioneVariabile> orderByComparator) {

		return getPersistence().fetchByStazione_Last(
			idStazione, orderByComparator);
	}

	/**
	 * Returns the stazione variabiles before and after the current stazione variabile in the ordered set where idStazione = &#63;.
	 *
	 * @param id the primary key of the current stazione variabile
	 * @param idStazione the id stazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stazione variabile
	 * @throws NoSuchStazioneVariabileException if a stazione variabile with the primary key could not be found
	 */
	public static StazioneVariabile[] findByStazione_PrevAndNext(
			long id, String idStazione,
			OrderByComparator<StazioneVariabile> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchStazioneVariabileException {

		return getPersistence().findByStazione_PrevAndNext(
			id, idStazione, orderByComparator);
	}

	/**
	 * Removes all the stazione variabiles where idStazione = &#63; from the database.
	 *
	 * @param idStazione the id stazione
	 */
	public static void removeByStazione(String idStazione) {
		getPersistence().removeByStazione(idStazione);
	}

	/**
	 * Returns the number of stazione variabiles where idStazione = &#63;.
	 *
	 * @param idStazione the id stazione
	 * @return the number of matching stazione variabiles
	 */
	public static int countByStazione(String idStazione) {
		return getPersistence().countByStazione(idStazione);
	}

	/**
	 * Returns all the stazione variabiles where idVariabile = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @return the matching stazione variabiles
	 */
	public static List<StazioneVariabile> findByVariabile(String idVariabile) {
		return getPersistence().findByVariabile(idVariabile);
	}

	/**
	 * Returns a range of all the stazione variabiles where idVariabile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>.
	 * </p>
	 *
	 * @param idVariabile the id variabile
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @return the range of matching stazione variabiles
	 */
	public static List<StazioneVariabile> findByVariabile(
		String idVariabile, int start, int end) {

		return getPersistence().findByVariabile(idVariabile, start, end);
	}

	/**
	 * Returns an ordered range of all the stazione variabiles where idVariabile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>.
	 * </p>
	 *
	 * @param idVariabile the id variabile
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stazione variabiles
	 */
	public static List<StazioneVariabile> findByVariabile(
		String idVariabile, int start, int end,
		OrderByComparator<StazioneVariabile> orderByComparator) {

		return getPersistence().findByVariabile(
			idVariabile, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the stazione variabiles where idVariabile = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>.
	 * </p>
	 *
	 * @param idVariabile the id variabile
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching stazione variabiles
	 */
	public static List<StazioneVariabile> findByVariabile(
		String idVariabile, int start, int end,
		OrderByComparator<StazioneVariabile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByVariabile(
			idVariabile, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first stazione variabile in the ordered set where idVariabile = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione variabile
	 * @throws NoSuchStazioneVariabileException if a matching stazione variabile could not be found
	 */
	public static StazioneVariabile findByVariabile_First(
			String idVariabile,
			OrderByComparator<StazioneVariabile> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchStazioneVariabileException {

		return getPersistence().findByVariabile_First(
			idVariabile, orderByComparator);
	}

	/**
	 * Returns the first stazione variabile in the ordered set where idVariabile = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione variabile, or <code>null</code> if a matching stazione variabile could not be found
	 */
	public static StazioneVariabile fetchByVariabile_First(
		String idVariabile,
		OrderByComparator<StazioneVariabile> orderByComparator) {

		return getPersistence().fetchByVariabile_First(
			idVariabile, orderByComparator);
	}

	/**
	 * Returns the last stazione variabile in the ordered set where idVariabile = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione variabile
	 * @throws NoSuchStazioneVariabileException if a matching stazione variabile could not be found
	 */
	public static StazioneVariabile findByVariabile_Last(
			String idVariabile,
			OrderByComparator<StazioneVariabile> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchStazioneVariabileException {

		return getPersistence().findByVariabile_Last(
			idVariabile, orderByComparator);
	}

	/**
	 * Returns the last stazione variabile in the ordered set where idVariabile = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione variabile, or <code>null</code> if a matching stazione variabile could not be found
	 */
	public static StazioneVariabile fetchByVariabile_Last(
		String idVariabile,
		OrderByComparator<StazioneVariabile> orderByComparator) {

		return getPersistence().fetchByVariabile_Last(
			idVariabile, orderByComparator);
	}

	/**
	 * Returns the stazione variabiles before and after the current stazione variabile in the ordered set where idVariabile = &#63;.
	 *
	 * @param id the primary key of the current stazione variabile
	 * @param idVariabile the id variabile
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stazione variabile
	 * @throws NoSuchStazioneVariabileException if a stazione variabile with the primary key could not be found
	 */
	public static StazioneVariabile[] findByVariabile_PrevAndNext(
			long id, String idVariabile,
			OrderByComparator<StazioneVariabile> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchStazioneVariabileException {

		return getPersistence().findByVariabile_PrevAndNext(
			id, idVariabile, orderByComparator);
	}

	/**
	 * Removes all the stazione variabiles where idVariabile = &#63; from the database.
	 *
	 * @param idVariabile the id variabile
	 */
	public static void removeByVariabile(String idVariabile) {
		getPersistence().removeByVariabile(idVariabile);
	}

	/**
	 * Returns the number of stazione variabiles where idVariabile = &#63;.
	 *
	 * @param idVariabile the id variabile
	 * @return the number of matching stazione variabiles
	 */
	public static int countByVariabile(String idVariabile) {
		return getPersistence().countByVariabile(idVariabile);
	}

	/**
	 * Caches the stazione variabile in the entity cache if it is enabled.
	 *
	 * @param stazioneVariabile the stazione variabile
	 */
	public static void cacheResult(StazioneVariabile stazioneVariabile) {
		getPersistence().cacheResult(stazioneVariabile);
	}

	/**
	 * Caches the stazione variabiles in the entity cache if it is enabled.
	 *
	 * @param stazioneVariabiles the stazione variabiles
	 */
	public static void cacheResult(List<StazioneVariabile> stazioneVariabiles) {
		getPersistence().cacheResult(stazioneVariabiles);
	}

	/**
	 * Creates a new stazione variabile with the primary key. Does not add the stazione variabile to the database.
	 *
	 * @param id the primary key for the new stazione variabile
	 * @return the new stazione variabile
	 */
	public static StazioneVariabile create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the stazione variabile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the stazione variabile
	 * @return the stazione variabile that was removed
	 * @throws NoSuchStazioneVariabileException if a stazione variabile with the primary key could not be found
	 */
	public static StazioneVariabile remove(long id)
		throws it.eng.bollettino.exception.NoSuchStazioneVariabileException {

		return getPersistence().remove(id);
	}

	public static StazioneVariabile updateImpl(
		StazioneVariabile stazioneVariabile) {

		return getPersistence().updateImpl(stazioneVariabile);
	}

	/**
	 * Returns the stazione variabile with the primary key or throws a <code>NoSuchStazioneVariabileException</code> if it could not be found.
	 *
	 * @param id the primary key of the stazione variabile
	 * @return the stazione variabile
	 * @throws NoSuchStazioneVariabileException if a stazione variabile with the primary key could not be found
	 */
	public static StazioneVariabile findByPrimaryKey(long id)
		throws it.eng.bollettino.exception.NoSuchStazioneVariabileException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the stazione variabile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the stazione variabile
	 * @return the stazione variabile, or <code>null</code> if a stazione variabile with the primary key could not be found
	 */
	public static StazioneVariabile fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the stazione variabiles.
	 *
	 * @return the stazione variabiles
	 */
	public static List<StazioneVariabile> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the stazione variabiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @return the range of stazione variabiles
	 */
	public static List<StazioneVariabile> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the stazione variabiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of stazione variabiles
	 */
	public static List<StazioneVariabile> findAll(
		int start, int end,
		OrderByComparator<StazioneVariabile> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the stazione variabiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneVariabileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of stazione variabiles
	 */
	public static List<StazioneVariabile> findAll(
		int start, int end,
		OrderByComparator<StazioneVariabile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the stazione variabiles from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of stazione variabiles.
	 *
	 * @return the number of stazione variabiles
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StazioneVariabilePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		StazioneVariabilePersistence persistence) {

		_persistence = persistence;
	}

	private static volatile StazioneVariabilePersistence _persistence;

}