/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animazione.image.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.animazione.image.model.altezzaOnda;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the altezza onda service. This utility wraps <code>it.eng.animazione.image.service.persistence.impl.altezzaOndaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author UTENTE
 * @see altezzaOndaPersistence
 * @generated
 */
public class altezzaOndaUtil {

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
	public static void clearCache(altezzaOnda altezzaOnda) {
		getPersistence().clearCache(altezzaOnda);
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
	public static Map<Serializable, altezzaOnda> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<altezzaOnda> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<altezzaOnda> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<altezzaOnda> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<altezzaOnda> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static altezzaOnda update(altezzaOnda altezzaOnda) {
		return getPersistence().update(altezzaOnda);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static altezzaOnda update(
		altezzaOnda altezzaOnda, ServiceContext serviceContext) {

		return getPersistence().update(altezzaOnda, serviceContext);
	}

	/**
	 * Caches the altezza onda in the entity cache if it is enabled.
	 *
	 * @param altezzaOnda the altezza onda
	 */
	public static void cacheResult(altezzaOnda altezzaOnda) {
		getPersistence().cacheResult(altezzaOnda);
	}

	/**
	 * Caches the altezza ondas in the entity cache if it is enabled.
	 *
	 * @param altezzaOndas the altezza ondas
	 */
	public static void cacheResult(List<altezzaOnda> altezzaOndas) {
		getPersistence().cacheResult(altezzaOndas);
	}

	/**
	 * Creates a new altezza onda with the primary key. Does not add the altezza onda to the database.
	 *
	 * @param id the primary key for the new altezza onda
	 * @return the new altezza onda
	 */
	public static altezzaOnda create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the altezza onda with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the altezza onda
	 * @return the altezza onda that was removed
	 * @throws NoSuchaltezzaOndaException if a altezza onda with the primary key could not be found
	 */
	public static altezzaOnda remove(long id)
		throws it.eng.animazione.image.exception.NoSuchaltezzaOndaException {

		return getPersistence().remove(id);
	}

	public static altezzaOnda updateImpl(altezzaOnda altezzaOnda) {
		return getPersistence().updateImpl(altezzaOnda);
	}

	/**
	 * Returns the altezza onda with the primary key or throws a <code>NoSuchaltezzaOndaException</code> if it could not be found.
	 *
	 * @param id the primary key of the altezza onda
	 * @return the altezza onda
	 * @throws NoSuchaltezzaOndaException if a altezza onda with the primary key could not be found
	 */
	public static altezzaOnda findByPrimaryKey(long id)
		throws it.eng.animazione.image.exception.NoSuchaltezzaOndaException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the altezza onda with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the altezza onda
	 * @return the altezza onda, or <code>null</code> if a altezza onda with the primary key could not be found
	 */
	public static altezzaOnda fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the altezza ondas.
	 *
	 * @return the altezza ondas
	 */
	public static List<altezzaOnda> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the altezza ondas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>altezzaOndaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza ondas
	 * @param end the upper bound of the range of altezza ondas (not inclusive)
	 * @return the range of altezza ondas
	 */
	public static List<altezzaOnda> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the altezza ondas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>altezzaOndaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza ondas
	 * @param end the upper bound of the range of altezza ondas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of altezza ondas
	 */
	public static List<altezzaOnda> findAll(
		int start, int end, OrderByComparator<altezzaOnda> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the altezza ondas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>altezzaOndaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza ondas
	 * @param end the upper bound of the range of altezza ondas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of altezza ondas
	 */
	public static List<altezzaOnda> findAll(
		int start, int end, OrderByComparator<altezzaOnda> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the altezza ondas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of altezza ondas.
	 *
	 * @return the number of altezza ondas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static altezzaOndaPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(altezzaOndaPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile altezzaOndaPersistence _persistence;

}