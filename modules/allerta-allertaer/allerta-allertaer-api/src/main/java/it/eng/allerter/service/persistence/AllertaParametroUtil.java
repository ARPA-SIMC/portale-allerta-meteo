/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.allerter.model.AllertaParametro;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the allerta parametro service. This utility wraps <code>it.eng.allerter.service.persistence.impl.AllertaParametroPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see AllertaParametroPersistence
 * @generated
 */
public class AllertaParametroUtil {

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
	public static void clearCache(AllertaParametro allertaParametro) {
		getPersistence().clearCache(allertaParametro);
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
	public static Map<Serializable, AllertaParametro> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AllertaParametro> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AllertaParametro> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AllertaParametro> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AllertaParametro> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AllertaParametro update(AllertaParametro allertaParametro) {
		return getPersistence().update(allertaParametro);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AllertaParametro update(
		AllertaParametro allertaParametro, ServiceContext serviceContext) {

		return getPersistence().update(allertaParametro, serviceContext);
	}

	/**
	 * Caches the allerta parametro in the entity cache if it is enabled.
	 *
	 * @param allertaParametro the allerta parametro
	 */
	public static void cacheResult(AllertaParametro allertaParametro) {
		getPersistence().cacheResult(allertaParametro);
	}

	/**
	 * Caches the allerta parametros in the entity cache if it is enabled.
	 *
	 * @param allertaParametros the allerta parametros
	 */
	public static void cacheResult(List<AllertaParametro> allertaParametros) {
		getPersistence().cacheResult(allertaParametros);
	}

	/**
	 * Creates a new allerta parametro with the primary key. Does not add the allerta parametro to the database.
	 *
	 * @param parametroId the primary key for the new allerta parametro
	 * @return the new allerta parametro
	 */
	public static AllertaParametro create(String parametroId) {
		return getPersistence().create(parametroId);
	}

	/**
	 * Removes the allerta parametro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param parametroId the primary key of the allerta parametro
	 * @return the allerta parametro that was removed
	 * @throws NoSuchAllertaParametroException if a allerta parametro with the primary key could not be found
	 */
	public static AllertaParametro remove(String parametroId)
		throws it.eng.allerter.exception.NoSuchAllertaParametroException {

		return getPersistence().remove(parametroId);
	}

	public static AllertaParametro updateImpl(
		AllertaParametro allertaParametro) {

		return getPersistence().updateImpl(allertaParametro);
	}

	/**
	 * Returns the allerta parametro with the primary key or throws a <code>NoSuchAllertaParametroException</code> if it could not be found.
	 *
	 * @param parametroId the primary key of the allerta parametro
	 * @return the allerta parametro
	 * @throws NoSuchAllertaParametroException if a allerta parametro with the primary key could not be found
	 */
	public static AllertaParametro findByPrimaryKey(String parametroId)
		throws it.eng.allerter.exception.NoSuchAllertaParametroException {

		return getPersistence().findByPrimaryKey(parametroId);
	}

	/**
	 * Returns the allerta parametro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param parametroId the primary key of the allerta parametro
	 * @return the allerta parametro, or <code>null</code> if a allerta parametro with the primary key could not be found
	 */
	public static AllertaParametro fetchByPrimaryKey(String parametroId) {
		return getPersistence().fetchByPrimaryKey(parametroId);
	}

	/**
	 * Returns all the allerta parametros.
	 *
	 * @return the allerta parametros
	 */
	public static List<AllertaParametro> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the allerta parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaParametroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta parametros
	 * @param end the upper bound of the range of allerta parametros (not inclusive)
	 * @return the range of allerta parametros
	 */
	public static List<AllertaParametro> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the allerta parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaParametroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta parametros
	 * @param end the upper bound of the range of allerta parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of allerta parametros
	 */
	public static List<AllertaParametro> findAll(
		int start, int end,
		OrderByComparator<AllertaParametro> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the allerta parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AllertaParametroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta parametros
	 * @param end the upper bound of the range of allerta parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of allerta parametros
	 */
	public static List<AllertaParametro> findAll(
		int start, int end,
		OrderByComparator<AllertaParametro> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the allerta parametros from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of allerta parametros.
	 *
	 * @return the number of allerta parametros
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AllertaParametroPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(AllertaParametroPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile AllertaParametroPersistence _persistence;

}