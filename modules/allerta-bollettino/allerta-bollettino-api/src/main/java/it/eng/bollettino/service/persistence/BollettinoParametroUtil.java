/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.bollettino.model.BollettinoParametro;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the bollettino parametro service. This utility wraps <code>it.eng.bollettino.service.persistence.impl.BollettinoParametroPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see BollettinoParametroPersistence
 * @generated
 */
public class BollettinoParametroUtil {

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
	public static void clearCache(BollettinoParametro bollettinoParametro) {
		getPersistence().clearCache(bollettinoParametro);
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
	public static Map<Serializable, BollettinoParametro> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BollettinoParametro> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BollettinoParametro> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BollettinoParametro> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BollettinoParametro> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BollettinoParametro update(
		BollettinoParametro bollettinoParametro) {

		return getPersistence().update(bollettinoParametro);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BollettinoParametro update(
		BollettinoParametro bollettinoParametro,
		ServiceContext serviceContext) {

		return getPersistence().update(bollettinoParametro, serviceContext);
	}

	/**
	 * Caches the bollettino parametro in the entity cache if it is enabled.
	 *
	 * @param bollettinoParametro the bollettino parametro
	 */
	public static void cacheResult(BollettinoParametro bollettinoParametro) {
		getPersistence().cacheResult(bollettinoParametro);
	}

	/**
	 * Caches the bollettino parametros in the entity cache if it is enabled.
	 *
	 * @param bollettinoParametros the bollettino parametros
	 */
	public static void cacheResult(
		List<BollettinoParametro> bollettinoParametros) {

		getPersistence().cacheResult(bollettinoParametros);
	}

	/**
	 * Creates a new bollettino parametro with the primary key. Does not add the bollettino parametro to the database.
	 *
	 * @param parametroId the primary key for the new bollettino parametro
	 * @return the new bollettino parametro
	 */
	public static BollettinoParametro create(String parametroId) {
		return getPersistence().create(parametroId);
	}

	/**
	 * Removes the bollettino parametro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param parametroId the primary key of the bollettino parametro
	 * @return the bollettino parametro that was removed
	 * @throws NoSuchBollettinoParametroException if a bollettino parametro with the primary key could not be found
	 */
	public static BollettinoParametro remove(String parametroId)
		throws it.eng.bollettino.exception.NoSuchBollettinoParametroException {

		return getPersistence().remove(parametroId);
	}

	public static BollettinoParametro updateImpl(
		BollettinoParametro bollettinoParametro) {

		return getPersistence().updateImpl(bollettinoParametro);
	}

	/**
	 * Returns the bollettino parametro with the primary key or throws a <code>NoSuchBollettinoParametroException</code> if it could not be found.
	 *
	 * @param parametroId the primary key of the bollettino parametro
	 * @return the bollettino parametro
	 * @throws NoSuchBollettinoParametroException if a bollettino parametro with the primary key could not be found
	 */
	public static BollettinoParametro findByPrimaryKey(String parametroId)
		throws it.eng.bollettino.exception.NoSuchBollettinoParametroException {

		return getPersistence().findByPrimaryKey(parametroId);
	}

	/**
	 * Returns the bollettino parametro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param parametroId the primary key of the bollettino parametro
	 * @return the bollettino parametro, or <code>null</code> if a bollettino parametro with the primary key could not be found
	 */
	public static BollettinoParametro fetchByPrimaryKey(String parametroId) {
		return getPersistence().fetchByPrimaryKey(parametroId);
	}

	/**
	 * Returns all the bollettino parametros.
	 *
	 * @return the bollettino parametros
	 */
	public static List<BollettinoParametro> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the bollettino parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoParametroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino parametros
	 * @param end the upper bound of the range of bollettino parametros (not inclusive)
	 * @return the range of bollettino parametros
	 */
	public static List<BollettinoParametro> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the bollettino parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoParametroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino parametros
	 * @param end the upper bound of the range of bollettino parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bollettino parametros
	 */
	public static List<BollettinoParametro> findAll(
		int start, int end,
		OrderByComparator<BollettinoParametro> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the bollettino parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BollettinoParametroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino parametros
	 * @param end the upper bound of the range of bollettino parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of bollettino parametros
	 */
	public static List<BollettinoParametro> findAll(
		int start, int end,
		OrderByComparator<BollettinoParametro> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the bollettino parametros from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of bollettino parametros.
	 *
	 * @return the number of bollettino parametros
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BollettinoParametroPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		BollettinoParametroPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile BollettinoParametroPersistence _persistence;

}