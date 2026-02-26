/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.cache.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.cache.model.Dati;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dati service. This utility wraps <code>it.eng.cache.service.persistence.impl.DatiPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see DatiPersistence
 * @generated
 */
public class DatiUtil {

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
	public static void clearCache(Dati dati) {
		getPersistence().clearCache(dati);
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
	public static Map<Serializable, Dati> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Dati> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Dati> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Dati> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Dati> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Dati update(Dati dati) {
		return getPersistence().update(dati);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Dati update(Dati dati, ServiceContext serviceContext) {
		return getPersistence().update(dati, serviceContext);
	}

	/**
	 * Caches the dati in the entity cache if it is enabled.
	 *
	 * @param dati the dati
	 */
	public static void cacheResult(Dati dati) {
		getPersistence().cacheResult(dati);
	}

	/**
	 * Caches the datis in the entity cache if it is enabled.
	 *
	 * @param datis the datis
	 */
	public static void cacheResult(List<Dati> datis) {
		getPersistence().cacheResult(datis);
	}

	/**
	 * Creates a new dati with the primary key. Does not add the dati to the database.
	 *
	 * @param idDati the primary key for the new dati
	 * @return the new dati
	 */
	public static Dati create(String idDati) {
		return getPersistence().create(idDati);
	}

	/**
	 * Removes the dati with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idDati the primary key of the dati
	 * @return the dati that was removed
	 * @throws NoSuchDatiException if a dati with the primary key could not be found
	 */
	public static Dati remove(String idDati)
		throws it.eng.cache.exception.NoSuchDatiException {

		return getPersistence().remove(idDati);
	}

	public static Dati updateImpl(Dati dati) {
		return getPersistence().updateImpl(dati);
	}

	/**
	 * Returns the dati with the primary key or throws a <code>NoSuchDatiException</code> if it could not be found.
	 *
	 * @param idDati the primary key of the dati
	 * @return the dati
	 * @throws NoSuchDatiException if a dati with the primary key could not be found
	 */
	public static Dati findByPrimaryKey(String idDati)
		throws it.eng.cache.exception.NoSuchDatiException {

		return getPersistence().findByPrimaryKey(idDati);
	}

	/**
	 * Returns the dati with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idDati the primary key of the dati
	 * @return the dati, or <code>null</code> if a dati with the primary key could not be found
	 */
	public static Dati fetchByPrimaryKey(String idDati) {
		return getPersistence().fetchByPrimaryKey(idDati);
	}

	/**
	 * Returns all the datis.
	 *
	 * @return the datis
	 */
	public static List<Dati> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the datis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DatiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of datis
	 * @param end the upper bound of the range of datis (not inclusive)
	 * @return the range of datis
	 */
	public static List<Dati> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the datis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DatiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of datis
	 * @param end the upper bound of the range of datis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of datis
	 */
	public static List<Dati> findAll(
		int start, int end, OrderByComparator<Dati> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the datis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DatiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of datis
	 * @param end the upper bound of the range of datis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of datis
	 */
	public static List<Dati> findAll(
		int start, int end, OrderByComparator<Dati> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the datis from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of datis.
	 *
	 * @return the number of datis
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DatiPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(DatiPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile DatiPersistence _persistence;

}