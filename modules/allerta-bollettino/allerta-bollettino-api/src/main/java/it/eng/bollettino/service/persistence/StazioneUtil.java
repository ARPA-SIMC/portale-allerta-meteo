/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.bollettino.model.Stazione;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the stazione service. This utility wraps <code>it.eng.bollettino.service.persistence.impl.StazionePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see StazionePersistence
 * @generated
 */
public class StazioneUtil {

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
	public static void clearCache(Stazione stazione) {
		getPersistence().clearCache(stazione);
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
	public static Map<Serializable, Stazione> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Stazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Stazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Stazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Stazione> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Stazione update(Stazione stazione) {
		return getPersistence().update(stazione);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Stazione update(
		Stazione stazione, ServiceContext serviceContext) {

		return getPersistence().update(stazione, serviceContext);
	}

	/**
	 * Returns all the staziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching staziones
	 */
	public static List<Stazione> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the staziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @return the range of matching staziones
	 */
	public static List<Stazione> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the staziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching staziones
	 */
	public static List<Stazione> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Stazione> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the staziones where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching staziones
	 */
	public static List<Stazione> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Stazione> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first stazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione
	 * @throws NoSuchStazioneException if a matching stazione could not be found
	 */
	public static Stazione findByUuid_First(
			String uuid, OrderByComparator<Stazione> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchStazioneException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first stazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione, or <code>null</code> if a matching stazione could not be found
	 */
	public static Stazione fetchByUuid_First(
		String uuid, OrderByComparator<Stazione> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last stazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione
	 * @throws NoSuchStazioneException if a matching stazione could not be found
	 */
	public static Stazione findByUuid_Last(
			String uuid, OrderByComparator<Stazione> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchStazioneException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last stazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione, or <code>null</code> if a matching stazione could not be found
	 */
	public static Stazione fetchByUuid_Last(
		String uuid, OrderByComparator<Stazione> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the staziones before and after the current stazione in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current stazione
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stazione
	 * @throws NoSuchStazioneException if a stazione with the primary key could not be found
	 */
	public static Stazione[] findByUuid_PrevAndNext(
			String id, String uuid,
			OrderByComparator<Stazione> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchStazioneException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the staziones where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of staziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching staziones
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the staziones where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching staziones
	 */
	public static List<Stazione> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	 * Returns a range of all the staziones where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @return the range of matching staziones
	 */
	public static List<Stazione> findByName(String name, int start, int end) {
		return getPersistence().findByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the staziones where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching staziones
	 */
	public static List<Stazione> findByName(
		String name, int start, int end,
		OrderByComparator<Stazione> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the staziones where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching staziones
	 */
	public static List<Stazione> findByName(
		String name, int start, int end,
		OrderByComparator<Stazione> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first stazione in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione
	 * @throws NoSuchStazioneException if a matching stazione could not be found
	 */
	public static Stazione findByName_First(
			String name, OrderByComparator<Stazione> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchStazioneException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first stazione in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione, or <code>null</code> if a matching stazione could not be found
	 */
	public static Stazione fetchByName_First(
		String name, OrderByComparator<Stazione> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last stazione in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione
	 * @throws NoSuchStazioneException if a matching stazione could not be found
	 */
	public static Stazione findByName_Last(
			String name, OrderByComparator<Stazione> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchStazioneException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last stazione in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione, or <code>null</code> if a matching stazione could not be found
	 */
	public static Stazione fetchByName_Last(
		String name, OrderByComparator<Stazione> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the staziones before and after the current stazione in the ordered set where name = &#63;.
	 *
	 * @param id the primary key of the current stazione
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stazione
	 * @throws NoSuchStazioneException if a stazione with the primary key could not be found
	 */
	public static Stazione[] findByName_PrevAndNext(
			String id, String name,
			OrderByComparator<Stazione> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchStazioneException {

		return getPersistence().findByName_PrevAndNext(
			id, name, orderByComparator);
	}

	/**
	 * Removes all the staziones where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of staziones where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching staziones
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Returns all the staziones where idBasin = &#63;.
	 *
	 * @param idBasin the id basin
	 * @return the matching staziones
	 */
	public static List<Stazione> findByBacino(String idBasin) {
		return getPersistence().findByBacino(idBasin);
	}

	/**
	 * Returns a range of all the staziones where idBasin = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param idBasin the id basin
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @return the range of matching staziones
	 */
	public static List<Stazione> findByBacino(
		String idBasin, int start, int end) {

		return getPersistence().findByBacino(idBasin, start, end);
	}

	/**
	 * Returns an ordered range of all the staziones where idBasin = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param idBasin the id basin
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching staziones
	 */
	public static List<Stazione> findByBacino(
		String idBasin, int start, int end,
		OrderByComparator<Stazione> orderByComparator) {

		return getPersistence().findByBacino(
			idBasin, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the staziones where idBasin = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param idBasin the id basin
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching staziones
	 */
	public static List<Stazione> findByBacino(
		String idBasin, int start, int end,
		OrderByComparator<Stazione> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByBacino(
			idBasin, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first stazione in the ordered set where idBasin = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione
	 * @throws NoSuchStazioneException if a matching stazione could not be found
	 */
	public static Stazione findByBacino_First(
			String idBasin, OrderByComparator<Stazione> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchStazioneException {

		return getPersistence().findByBacino_First(idBasin, orderByComparator);
	}

	/**
	 * Returns the first stazione in the ordered set where idBasin = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione, or <code>null</code> if a matching stazione could not be found
	 */
	public static Stazione fetchByBacino_First(
		String idBasin, OrderByComparator<Stazione> orderByComparator) {

		return getPersistence().fetchByBacino_First(idBasin, orderByComparator);
	}

	/**
	 * Returns the last stazione in the ordered set where idBasin = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione
	 * @throws NoSuchStazioneException if a matching stazione could not be found
	 */
	public static Stazione findByBacino_Last(
			String idBasin, OrderByComparator<Stazione> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchStazioneException {

		return getPersistence().findByBacino_Last(idBasin, orderByComparator);
	}

	/**
	 * Returns the last stazione in the ordered set where idBasin = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione, or <code>null</code> if a matching stazione could not be found
	 */
	public static Stazione fetchByBacino_Last(
		String idBasin, OrderByComparator<Stazione> orderByComparator) {

		return getPersistence().fetchByBacino_Last(idBasin, orderByComparator);
	}

	/**
	 * Returns the staziones before and after the current stazione in the ordered set where idBasin = &#63;.
	 *
	 * @param id the primary key of the current stazione
	 * @param idBasin the id basin
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stazione
	 * @throws NoSuchStazioneException if a stazione with the primary key could not be found
	 */
	public static Stazione[] findByBacino_PrevAndNext(
			String id, String idBasin,
			OrderByComparator<Stazione> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchStazioneException {

		return getPersistence().findByBacino_PrevAndNext(
			id, idBasin, orderByComparator);
	}

	/**
	 * Removes all the staziones where idBasin = &#63; from the database.
	 *
	 * @param idBasin the id basin
	 */
	public static void removeByBacino(String idBasin) {
		getPersistence().removeByBacino(idBasin);
	}

	/**
	 * Returns the number of staziones where idBasin = &#63;.
	 *
	 * @param idBasin the id basin
	 * @return the number of matching staziones
	 */
	public static int countByBacino(String idBasin) {
		return getPersistence().countByBacino(idBasin);
	}

	/**
	 * Returns all the staziones where idBasin = &#63; and attivo = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @return the matching staziones
	 */
	public static List<Stazione> findByBacinoAttivo(
		String idBasin, boolean attivo) {

		return getPersistence().findByBacinoAttivo(idBasin, attivo);
	}

	/**
	 * Returns a range of all the staziones where idBasin = &#63; and attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @return the range of matching staziones
	 */
	public static List<Stazione> findByBacinoAttivo(
		String idBasin, boolean attivo, int start, int end) {

		return getPersistence().findByBacinoAttivo(idBasin, attivo, start, end);
	}

	/**
	 * Returns an ordered range of all the staziones where idBasin = &#63; and attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching staziones
	 */
	public static List<Stazione> findByBacinoAttivo(
		String idBasin, boolean attivo, int start, int end,
		OrderByComparator<Stazione> orderByComparator) {

		return getPersistence().findByBacinoAttivo(
			idBasin, attivo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the staziones where idBasin = &#63; and attivo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching staziones
	 */
	public static List<Stazione> findByBacinoAttivo(
		String idBasin, boolean attivo, int start, int end,
		OrderByComparator<Stazione> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByBacinoAttivo(
			idBasin, attivo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first stazione in the ordered set where idBasin = &#63; and attivo = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione
	 * @throws NoSuchStazioneException if a matching stazione could not be found
	 */
	public static Stazione findByBacinoAttivo_First(
			String idBasin, boolean attivo,
			OrderByComparator<Stazione> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchStazioneException {

		return getPersistence().findByBacinoAttivo_First(
			idBasin, attivo, orderByComparator);
	}

	/**
	 * Returns the first stazione in the ordered set where idBasin = &#63; and attivo = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione, or <code>null</code> if a matching stazione could not be found
	 */
	public static Stazione fetchByBacinoAttivo_First(
		String idBasin, boolean attivo,
		OrderByComparator<Stazione> orderByComparator) {

		return getPersistence().fetchByBacinoAttivo_First(
			idBasin, attivo, orderByComparator);
	}

	/**
	 * Returns the last stazione in the ordered set where idBasin = &#63; and attivo = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione
	 * @throws NoSuchStazioneException if a matching stazione could not be found
	 */
	public static Stazione findByBacinoAttivo_Last(
			String idBasin, boolean attivo,
			OrderByComparator<Stazione> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchStazioneException {

		return getPersistence().findByBacinoAttivo_Last(
			idBasin, attivo, orderByComparator);
	}

	/**
	 * Returns the last stazione in the ordered set where idBasin = &#63; and attivo = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione, or <code>null</code> if a matching stazione could not be found
	 */
	public static Stazione fetchByBacinoAttivo_Last(
		String idBasin, boolean attivo,
		OrderByComparator<Stazione> orderByComparator) {

		return getPersistence().fetchByBacinoAttivo_Last(
			idBasin, attivo, orderByComparator);
	}

	/**
	 * Returns the staziones before and after the current stazione in the ordered set where idBasin = &#63; and attivo = &#63;.
	 *
	 * @param id the primary key of the current stazione
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stazione
	 * @throws NoSuchStazioneException if a stazione with the primary key could not be found
	 */
	public static Stazione[] findByBacinoAttivo_PrevAndNext(
			String id, String idBasin, boolean attivo,
			OrderByComparator<Stazione> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchStazioneException {

		return getPersistence().findByBacinoAttivo_PrevAndNext(
			id, idBasin, attivo, orderByComparator);
	}

	/**
	 * Removes all the staziones where idBasin = &#63; and attivo = &#63; from the database.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 */
	public static void removeByBacinoAttivo(String idBasin, boolean attivo) {
		getPersistence().removeByBacinoAttivo(idBasin, attivo);
	}

	/**
	 * Returns the number of staziones where idBasin = &#63; and attivo = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @return the number of matching staziones
	 */
	public static int countByBacinoAttivo(String idBasin, boolean attivo) {
		return getPersistence().countByBacinoAttivo(idBasin, attivo);
	}

	/**
	 * Returns all the staziones where idBasin = &#63; and attivo = &#63; and incluso = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 * @return the matching staziones
	 */
	public static List<Stazione> findByBacinoAttivoIncluso(
		String idBasin, boolean attivo, boolean incluso) {

		return getPersistence().findByBacinoAttivoIncluso(
			idBasin, attivo, incluso);
	}

	/**
	 * Returns a range of all the staziones where idBasin = &#63; and attivo = &#63; and incluso = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @return the range of matching staziones
	 */
	public static List<Stazione> findByBacinoAttivoIncluso(
		String idBasin, boolean attivo, boolean incluso, int start, int end) {

		return getPersistence().findByBacinoAttivoIncluso(
			idBasin, attivo, incluso, start, end);
	}

	/**
	 * Returns an ordered range of all the staziones where idBasin = &#63; and attivo = &#63; and incluso = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching staziones
	 */
	public static List<Stazione> findByBacinoAttivoIncluso(
		String idBasin, boolean attivo, boolean incluso, int start, int end,
		OrderByComparator<Stazione> orderByComparator) {

		return getPersistence().findByBacinoAttivoIncluso(
			idBasin, attivo, incluso, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the staziones where idBasin = &#63; and attivo = &#63; and incluso = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching staziones
	 */
	public static List<Stazione> findByBacinoAttivoIncluso(
		String idBasin, boolean attivo, boolean incluso, int start, int end,
		OrderByComparator<Stazione> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByBacinoAttivoIncluso(
			idBasin, attivo, incluso, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first stazione in the ordered set where idBasin = &#63; and attivo = &#63; and incluso = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione
	 * @throws NoSuchStazioneException if a matching stazione could not be found
	 */
	public static Stazione findByBacinoAttivoIncluso_First(
			String idBasin, boolean attivo, boolean incluso,
			OrderByComparator<Stazione> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchStazioneException {

		return getPersistence().findByBacinoAttivoIncluso_First(
			idBasin, attivo, incluso, orderByComparator);
	}

	/**
	 * Returns the first stazione in the ordered set where idBasin = &#63; and attivo = &#63; and incluso = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stazione, or <code>null</code> if a matching stazione could not be found
	 */
	public static Stazione fetchByBacinoAttivoIncluso_First(
		String idBasin, boolean attivo, boolean incluso,
		OrderByComparator<Stazione> orderByComparator) {

		return getPersistence().fetchByBacinoAttivoIncluso_First(
			idBasin, attivo, incluso, orderByComparator);
	}

	/**
	 * Returns the last stazione in the ordered set where idBasin = &#63; and attivo = &#63; and incluso = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione
	 * @throws NoSuchStazioneException if a matching stazione could not be found
	 */
	public static Stazione findByBacinoAttivoIncluso_Last(
			String idBasin, boolean attivo, boolean incluso,
			OrderByComparator<Stazione> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchStazioneException {

		return getPersistence().findByBacinoAttivoIncluso_Last(
			idBasin, attivo, incluso, orderByComparator);
	}

	/**
	 * Returns the last stazione in the ordered set where idBasin = &#63; and attivo = &#63; and incluso = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stazione, or <code>null</code> if a matching stazione could not be found
	 */
	public static Stazione fetchByBacinoAttivoIncluso_Last(
		String idBasin, boolean attivo, boolean incluso,
		OrderByComparator<Stazione> orderByComparator) {

		return getPersistence().fetchByBacinoAttivoIncluso_Last(
			idBasin, attivo, incluso, orderByComparator);
	}

	/**
	 * Returns the staziones before and after the current stazione in the ordered set where idBasin = &#63; and attivo = &#63; and incluso = &#63;.
	 *
	 * @param id the primary key of the current stazione
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stazione
	 * @throws NoSuchStazioneException if a stazione with the primary key could not be found
	 */
	public static Stazione[] findByBacinoAttivoIncluso_PrevAndNext(
			String id, String idBasin, boolean attivo, boolean incluso,
			OrderByComparator<Stazione> orderByComparator)
		throws it.eng.bollettino.exception.NoSuchStazioneException {

		return getPersistence().findByBacinoAttivoIncluso_PrevAndNext(
			id, idBasin, attivo, incluso, orderByComparator);
	}

	/**
	 * Removes all the staziones where idBasin = &#63; and attivo = &#63; and incluso = &#63; from the database.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 */
	public static void removeByBacinoAttivoIncluso(
		String idBasin, boolean attivo, boolean incluso) {

		getPersistence().removeByBacinoAttivoIncluso(idBasin, attivo, incluso);
	}

	/**
	 * Returns the number of staziones where idBasin = &#63; and attivo = &#63; and incluso = &#63;.
	 *
	 * @param idBasin the id basin
	 * @param attivo the attivo
	 * @param incluso the incluso
	 * @return the number of matching staziones
	 */
	public static int countByBacinoAttivoIncluso(
		String idBasin, boolean attivo, boolean incluso) {

		return getPersistence().countByBacinoAttivoIncluso(
			idBasin, attivo, incluso);
	}

	/**
	 * Caches the stazione in the entity cache if it is enabled.
	 *
	 * @param stazione the stazione
	 */
	public static void cacheResult(Stazione stazione) {
		getPersistence().cacheResult(stazione);
	}

	/**
	 * Caches the staziones in the entity cache if it is enabled.
	 *
	 * @param staziones the staziones
	 */
	public static void cacheResult(List<Stazione> staziones) {
		getPersistence().cacheResult(staziones);
	}

	/**
	 * Creates a new stazione with the primary key. Does not add the stazione to the database.
	 *
	 * @param id the primary key for the new stazione
	 * @return the new stazione
	 */
	public static Stazione create(String id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the stazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the stazione
	 * @return the stazione that was removed
	 * @throws NoSuchStazioneException if a stazione with the primary key could not be found
	 */
	public static Stazione remove(String id)
		throws it.eng.bollettino.exception.NoSuchStazioneException {

		return getPersistence().remove(id);
	}

	public static Stazione updateImpl(Stazione stazione) {
		return getPersistence().updateImpl(stazione);
	}

	/**
	 * Returns the stazione with the primary key or throws a <code>NoSuchStazioneException</code> if it could not be found.
	 *
	 * @param id the primary key of the stazione
	 * @return the stazione
	 * @throws NoSuchStazioneException if a stazione with the primary key could not be found
	 */
	public static Stazione findByPrimaryKey(String id)
		throws it.eng.bollettino.exception.NoSuchStazioneException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the stazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the stazione
	 * @return the stazione, or <code>null</code> if a stazione with the primary key could not be found
	 */
	public static Stazione fetchByPrimaryKey(String id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the staziones.
	 *
	 * @return the staziones
	 */
	public static List<Stazione> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the staziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @return the range of staziones
	 */
	public static List<Stazione> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the staziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staziones
	 */
	public static List<Stazione> findAll(
		int start, int end, OrderByComparator<Stazione> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the staziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staziones
	 * @param end the upper bound of the range of staziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staziones
	 */
	public static List<Stazione> findAll(
		int start, int end, OrderByComparator<Stazione> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the staziones from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of staziones.
	 *
	 * @return the number of staziones
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StazionePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(StazionePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile StazionePersistence _persistence;

}