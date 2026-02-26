/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.service.persistence;

import allerta.catasto.model.Sottocategoria;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the sottocategoria service. This utility wraps <code>allerta.catasto.service.persistence.impl.SottocategoriaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SottocategoriaPersistence
 * @generated
 */
public class SottocategoriaUtil {

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
	public static void clearCache(Sottocategoria sottocategoria) {
		getPersistence().clearCache(sottocategoria);
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
	public static Map<Serializable, Sottocategoria> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Sottocategoria> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Sottocategoria> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Sottocategoria> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Sottocategoria> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Sottocategoria update(Sottocategoria sottocategoria) {
		return getPersistence().update(sottocategoria);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Sottocategoria update(
		Sottocategoria sottocategoria, ServiceContext serviceContext) {

		return getPersistence().update(sottocategoria, serviceContext);
	}

	/**
	 * Caches the sottocategoria in the entity cache if it is enabled.
	 *
	 * @param sottocategoria the sottocategoria
	 */
	public static void cacheResult(Sottocategoria sottocategoria) {
		getPersistence().cacheResult(sottocategoria);
	}

	/**
	 * Caches the sottocategorias in the entity cache if it is enabled.
	 *
	 * @param sottocategorias the sottocategorias
	 */
	public static void cacheResult(List<Sottocategoria> sottocategorias) {
		getPersistence().cacheResult(sottocategorias);
	}

	/**
	 * Creates a new sottocategoria with the primary key. Does not add the sottocategoria to the database.
	 *
	 * @param sottocategoriaPK the primary key for the new sottocategoria
	 * @return the new sottocategoria
	 */
	public static Sottocategoria create(SottocategoriaPK sottocategoriaPK) {
		return getPersistence().create(sottocategoriaPK);
	}

	/**
	 * Removes the sottocategoria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sottocategoriaPK the primary key of the sottocategoria
	 * @return the sottocategoria that was removed
	 * @throws NoSuchSottocategoriaException if a sottocategoria with the primary key could not be found
	 */
	public static Sottocategoria remove(SottocategoriaPK sottocategoriaPK)
		throws allerta.catasto.exception.NoSuchSottocategoriaException {

		return getPersistence().remove(sottocategoriaPK);
	}

	public static Sottocategoria updateImpl(Sottocategoria sottocategoria) {
		return getPersistence().updateImpl(sottocategoria);
	}

	/**
	 * Returns the sottocategoria with the primary key or throws a <code>NoSuchSottocategoriaException</code> if it could not be found.
	 *
	 * @param sottocategoriaPK the primary key of the sottocategoria
	 * @return the sottocategoria
	 * @throws NoSuchSottocategoriaException if a sottocategoria with the primary key could not be found
	 */
	public static Sottocategoria findByPrimaryKey(
			SottocategoriaPK sottocategoriaPK)
		throws allerta.catasto.exception.NoSuchSottocategoriaException {

		return getPersistence().findByPrimaryKey(sottocategoriaPK);
	}

	/**
	 * Returns the sottocategoria with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sottocategoriaPK the primary key of the sottocategoria
	 * @return the sottocategoria, or <code>null</code> if a sottocategoria with the primary key could not be found
	 */
	public static Sottocategoria fetchByPrimaryKey(
		SottocategoriaPK sottocategoriaPK) {

		return getPersistence().fetchByPrimaryKey(sottocategoriaPK);
	}

	/**
	 * Returns all the sottocategorias.
	 *
	 * @return the sottocategorias
	 */
	public static List<Sottocategoria> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the sottocategorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SottocategoriaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sottocategorias
	 * @param end the upper bound of the range of sottocategorias (not inclusive)
	 * @return the range of sottocategorias
	 */
	public static List<Sottocategoria> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the sottocategorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SottocategoriaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sottocategorias
	 * @param end the upper bound of the range of sottocategorias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sottocategorias
	 */
	public static List<Sottocategoria> findAll(
		int start, int end,
		OrderByComparator<Sottocategoria> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sottocategorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SottocategoriaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sottocategorias
	 * @param end the upper bound of the range of sottocategorias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sottocategorias
	 */
	public static List<Sottocategoria> findAll(
		int start, int end, OrderByComparator<Sottocategoria> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the sottocategorias from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of sottocategorias.
	 *
	 * @return the number of sottocategorias
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static SottocategoriaPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(SottocategoriaPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile SottocategoriaPersistence _persistence;

}