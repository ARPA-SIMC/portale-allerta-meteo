/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animazione.image.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.animazione.image.model.altezzaOndaAdriac;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the altezza onda adriac service. This utility wraps <code>it.eng.animazione.image.service.persistence.impl.altezzaOndaAdriacPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author UTENTE
 * @see altezzaOndaAdriacPersistence
 * @generated
 */
public class altezzaOndaAdriacUtil {

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
	public static void clearCache(altezzaOndaAdriac altezzaOndaAdriac) {
		getPersistence().clearCache(altezzaOndaAdriac);
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
	public static Map<Serializable, altezzaOndaAdriac> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<altezzaOndaAdriac> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<altezzaOndaAdriac> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<altezzaOndaAdriac> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<altezzaOndaAdriac> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static altezzaOndaAdriac update(
		altezzaOndaAdriac altezzaOndaAdriac) {

		return getPersistence().update(altezzaOndaAdriac);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static altezzaOndaAdriac update(
		altezzaOndaAdriac altezzaOndaAdriac, ServiceContext serviceContext) {

		return getPersistence().update(altezzaOndaAdriac, serviceContext);
	}

	/**
	 * Caches the altezza onda adriac in the entity cache if it is enabled.
	 *
	 * @param altezzaOndaAdriac the altezza onda adriac
	 */
	public static void cacheResult(altezzaOndaAdriac altezzaOndaAdriac) {
		getPersistence().cacheResult(altezzaOndaAdriac);
	}

	/**
	 * Caches the altezza onda adriacs in the entity cache if it is enabled.
	 *
	 * @param altezzaOndaAdriacs the altezza onda adriacs
	 */
	public static void cacheResult(List<altezzaOndaAdriac> altezzaOndaAdriacs) {
		getPersistence().cacheResult(altezzaOndaAdriacs);
	}

	/**
	 * Creates a new altezza onda adriac with the primary key. Does not add the altezza onda adriac to the database.
	 *
	 * @param id the primary key for the new altezza onda adriac
	 * @return the new altezza onda adriac
	 */
	public static altezzaOndaAdriac create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the altezza onda adriac with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the altezza onda adriac
	 * @return the altezza onda adriac that was removed
	 * @throws NoSuchaltezzaOndaAdriacException if a altezza onda adriac with the primary key could not be found
	 */
	public static altezzaOndaAdriac remove(long id)
		throws it.eng.animazione.image.exception.
			NoSuchaltezzaOndaAdriacException {

		return getPersistence().remove(id);
	}

	public static altezzaOndaAdriac updateImpl(
		altezzaOndaAdriac altezzaOndaAdriac) {

		return getPersistence().updateImpl(altezzaOndaAdriac);
	}

	/**
	 * Returns the altezza onda adriac with the primary key or throws a <code>NoSuchaltezzaOndaAdriacException</code> if it could not be found.
	 *
	 * @param id the primary key of the altezza onda adriac
	 * @return the altezza onda adriac
	 * @throws NoSuchaltezzaOndaAdriacException if a altezza onda adriac with the primary key could not be found
	 */
	public static altezzaOndaAdriac findByPrimaryKey(long id)
		throws it.eng.animazione.image.exception.
			NoSuchaltezzaOndaAdriacException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the altezza onda adriac with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the altezza onda adriac
	 * @return the altezza onda adriac, or <code>null</code> if a altezza onda adriac with the primary key could not be found
	 */
	public static altezzaOndaAdriac fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the altezza onda adriacs.
	 *
	 * @return the altezza onda adriacs
	 */
	public static List<altezzaOndaAdriac> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the altezza onda adriacs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>altezzaOndaAdriacModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza onda adriacs
	 * @param end the upper bound of the range of altezza onda adriacs (not inclusive)
	 * @return the range of altezza onda adriacs
	 */
	public static List<altezzaOndaAdriac> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the altezza onda adriacs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>altezzaOndaAdriacModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza onda adriacs
	 * @param end the upper bound of the range of altezza onda adriacs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of altezza onda adriacs
	 */
	public static List<altezzaOndaAdriac> findAll(
		int start, int end,
		OrderByComparator<altezzaOndaAdriac> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the altezza onda adriacs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>altezzaOndaAdriacModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza onda adriacs
	 * @param end the upper bound of the range of altezza onda adriacs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of altezza onda adriacs
	 */
	public static List<altezzaOndaAdriac> findAll(
		int start, int end,
		OrderByComparator<altezzaOndaAdriac> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the altezza onda adriacs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of altezza onda adriacs.
	 *
	 * @return the number of altezza onda adriacs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static altezzaOndaAdriacPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		altezzaOndaAdriacPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile altezzaOndaAdriacPersistence _persistence;

}