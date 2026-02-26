/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animazione.image.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.animazione.image.model.elevazione;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the elevazione service. This utility wraps <code>it.eng.animazione.image.service.persistence.impl.elevazionePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author UTENTE
 * @see elevazionePersistence
 * @generated
 */
public class elevazioneUtil {

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
	public static void clearCache(elevazione elevazione) {
		getPersistence().clearCache(elevazione);
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
	public static Map<Serializable, elevazione> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<elevazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<elevazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<elevazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<elevazione> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static elevazione update(elevazione elevazione) {
		return getPersistence().update(elevazione);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static elevazione update(
		elevazione elevazione, ServiceContext serviceContext) {

		return getPersistence().update(elevazione, serviceContext);
	}

	/**
	 * Caches the elevazione in the entity cache if it is enabled.
	 *
	 * @param elevazione the elevazione
	 */
	public static void cacheResult(elevazione elevazione) {
		getPersistence().cacheResult(elevazione);
	}

	/**
	 * Caches the elevaziones in the entity cache if it is enabled.
	 *
	 * @param elevaziones the elevaziones
	 */
	public static void cacheResult(List<elevazione> elevaziones) {
		getPersistence().cacheResult(elevaziones);
	}

	/**
	 * Creates a new elevazione with the primary key. Does not add the elevazione to the database.
	 *
	 * @param id the primary key for the new elevazione
	 * @return the new elevazione
	 */
	public static elevazione create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the elevazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the elevazione
	 * @return the elevazione that was removed
	 * @throws NoSuchelevazioneException if a elevazione with the primary key could not be found
	 */
	public static elevazione remove(long id)
		throws it.eng.animazione.image.exception.NoSuchelevazioneException {

		return getPersistence().remove(id);
	}

	public static elevazione updateImpl(elevazione elevazione) {
		return getPersistence().updateImpl(elevazione);
	}

	/**
	 * Returns the elevazione with the primary key or throws a <code>NoSuchelevazioneException</code> if it could not be found.
	 *
	 * @param id the primary key of the elevazione
	 * @return the elevazione
	 * @throws NoSuchelevazioneException if a elevazione with the primary key could not be found
	 */
	public static elevazione findByPrimaryKey(long id)
		throws it.eng.animazione.image.exception.NoSuchelevazioneException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the elevazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the elevazione
	 * @return the elevazione, or <code>null</code> if a elevazione with the primary key could not be found
	 */
	public static elevazione fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the elevaziones.
	 *
	 * @return the elevaziones
	 */
	public static List<elevazione> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the elevaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>elevazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of elevaziones
	 * @param end the upper bound of the range of elevaziones (not inclusive)
	 * @return the range of elevaziones
	 */
	public static List<elevazione> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the elevaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>elevazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of elevaziones
	 * @param end the upper bound of the range of elevaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of elevaziones
	 */
	public static List<elevazione> findAll(
		int start, int end, OrderByComparator<elevazione> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the elevaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>elevazioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of elevaziones
	 * @param end the upper bound of the range of elevaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of elevaziones
	 */
	public static List<elevazione> findAll(
		int start, int end, OrderByComparator<elevazione> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the elevaziones from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of elevaziones.
	 *
	 * @return the number of elevaziones
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static elevazionePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(elevazionePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile elevazionePersistence _persistence;

}