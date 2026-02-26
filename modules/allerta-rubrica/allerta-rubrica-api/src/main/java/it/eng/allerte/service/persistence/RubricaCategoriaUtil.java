/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.allerte.model.RubricaCategoria;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the rubrica categoria service. This utility wraps <code>it.eng.allerte.service.persistence.impl.RubricaCategoriaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see RubricaCategoriaPersistence
 * @generated
 */
public class RubricaCategoriaUtil {

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
	public static void clearCache(RubricaCategoria rubricaCategoria) {
		getPersistence().clearCache(rubricaCategoria);
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
	public static Map<Serializable, RubricaCategoria> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RubricaCategoria> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RubricaCategoria> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RubricaCategoria> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RubricaCategoria> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RubricaCategoria update(RubricaCategoria rubricaCategoria) {
		return getPersistence().update(rubricaCategoria);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RubricaCategoria update(
		RubricaCategoria rubricaCategoria, ServiceContext serviceContext) {

		return getPersistence().update(rubricaCategoria, serviceContext);
	}

	/**
	 * Caches the rubrica categoria in the entity cache if it is enabled.
	 *
	 * @param rubricaCategoria the rubrica categoria
	 */
	public static void cacheResult(RubricaCategoria rubricaCategoria) {
		getPersistence().cacheResult(rubricaCategoria);
	}

	/**
	 * Caches the rubrica categorias in the entity cache if it is enabled.
	 *
	 * @param rubricaCategorias the rubrica categorias
	 */
	public static void cacheResult(List<RubricaCategoria> rubricaCategorias) {
		getPersistence().cacheResult(rubricaCategorias);
	}

	/**
	 * Creates a new rubrica categoria with the primary key. Does not add the rubrica categoria to the database.
	 *
	 * @param ID_CATEGORIA the primary key for the new rubrica categoria
	 * @return the new rubrica categoria
	 */
	public static RubricaCategoria create(long ID_CATEGORIA) {
		return getPersistence().create(ID_CATEGORIA);
	}

	/**
	 * Removes the rubrica categoria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_CATEGORIA the primary key of the rubrica categoria
	 * @return the rubrica categoria that was removed
	 * @throws NoSuchRubricaCategoriaException if a rubrica categoria with the primary key could not be found
	 */
	public static RubricaCategoria remove(long ID_CATEGORIA)
		throws it.eng.allerte.exception.NoSuchRubricaCategoriaException {

		return getPersistence().remove(ID_CATEGORIA);
	}

	public static RubricaCategoria updateImpl(
		RubricaCategoria rubricaCategoria) {

		return getPersistence().updateImpl(rubricaCategoria);
	}

	/**
	 * Returns the rubrica categoria with the primary key or throws a <code>NoSuchRubricaCategoriaException</code> if it could not be found.
	 *
	 * @param ID_CATEGORIA the primary key of the rubrica categoria
	 * @return the rubrica categoria
	 * @throws NoSuchRubricaCategoriaException if a rubrica categoria with the primary key could not be found
	 */
	public static RubricaCategoria findByPrimaryKey(long ID_CATEGORIA)
		throws it.eng.allerte.exception.NoSuchRubricaCategoriaException {

		return getPersistence().findByPrimaryKey(ID_CATEGORIA);
	}

	/**
	 * Returns the rubrica categoria with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_CATEGORIA the primary key of the rubrica categoria
	 * @return the rubrica categoria, or <code>null</code> if a rubrica categoria with the primary key could not be found
	 */
	public static RubricaCategoria fetchByPrimaryKey(long ID_CATEGORIA) {
		return getPersistence().fetchByPrimaryKey(ID_CATEGORIA);
	}

	/**
	 * Returns all the rubrica categorias.
	 *
	 * @return the rubrica categorias
	 */
	public static List<RubricaCategoria> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the rubrica categorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaCategoriaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica categorias
	 * @param end the upper bound of the range of rubrica categorias (not inclusive)
	 * @return the range of rubrica categorias
	 */
	public static List<RubricaCategoria> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the rubrica categorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaCategoriaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica categorias
	 * @param end the upper bound of the range of rubrica categorias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica categorias
	 */
	public static List<RubricaCategoria> findAll(
		int start, int end,
		OrderByComparator<RubricaCategoria> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rubrica categorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RubricaCategoriaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica categorias
	 * @param end the upper bound of the range of rubrica categorias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rubrica categorias
	 */
	public static List<RubricaCategoria> findAll(
		int start, int end,
		OrderByComparator<RubricaCategoria> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the rubrica categorias from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of rubrica categorias.
	 *
	 * @return the number of rubrica categorias
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RubricaCategoriaPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(RubricaCategoriaPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile RubricaCategoriaPersistence _persistence;

}