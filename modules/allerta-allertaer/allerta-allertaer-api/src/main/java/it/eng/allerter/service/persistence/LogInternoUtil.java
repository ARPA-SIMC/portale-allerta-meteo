/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.allerter.model.LogInterno;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the log interno service. This utility wraps <code>it.eng.allerter.service.persistence.impl.LogInternoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see LogInternoPersistence
 * @generated
 */
public class LogInternoUtil {

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
	public static void clearCache(LogInterno logInterno) {
		getPersistence().clearCache(logInterno);
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
	public static Map<Serializable, LogInterno> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LogInterno> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LogInterno> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LogInterno> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LogInterno> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LogInterno update(LogInterno logInterno) {
		return getPersistence().update(logInterno);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LogInterno update(
		LogInterno logInterno, ServiceContext serviceContext) {

		return getPersistence().update(logInterno, serviceContext);
	}

	/**
	 * Caches the log interno in the entity cache if it is enabled.
	 *
	 * @param logInterno the log interno
	 */
	public static void cacheResult(LogInterno logInterno) {
		getPersistence().cacheResult(logInterno);
	}

	/**
	 * Caches the log internos in the entity cache if it is enabled.
	 *
	 * @param logInternos the log internos
	 */
	public static void cacheResult(List<LogInterno> logInternos) {
		getPersistence().cacheResult(logInternos);
	}

	/**
	 * Creates a new log interno with the primary key. Does not add the log interno to the database.
	 *
	 * @param logId the primary key for the new log interno
	 * @return the new log interno
	 */
	public static LogInterno create(long logId) {
		return getPersistence().create(logId);
	}

	/**
	 * Removes the log interno with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param logId the primary key of the log interno
	 * @return the log interno that was removed
	 * @throws NoSuchLogInternoException if a log interno with the primary key could not be found
	 */
	public static LogInterno remove(long logId)
		throws it.eng.allerter.exception.NoSuchLogInternoException {

		return getPersistence().remove(logId);
	}

	public static LogInterno updateImpl(LogInterno logInterno) {
		return getPersistence().updateImpl(logInterno);
	}

	/**
	 * Returns the log interno with the primary key or throws a <code>NoSuchLogInternoException</code> if it could not be found.
	 *
	 * @param logId the primary key of the log interno
	 * @return the log interno
	 * @throws NoSuchLogInternoException if a log interno with the primary key could not be found
	 */
	public static LogInterno findByPrimaryKey(long logId)
		throws it.eng.allerter.exception.NoSuchLogInternoException {

		return getPersistence().findByPrimaryKey(logId);
	}

	/**
	 * Returns the log interno with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param logId the primary key of the log interno
	 * @return the log interno, or <code>null</code> if a log interno with the primary key could not be found
	 */
	public static LogInterno fetchByPrimaryKey(long logId) {
		return getPersistence().fetchByPrimaryKey(logId);
	}

	/**
	 * Returns all the log internos.
	 *
	 * @return the log internos
	 */
	public static List<LogInterno> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the log internos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LogInternoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of log internos
	 * @param end the upper bound of the range of log internos (not inclusive)
	 * @return the range of log internos
	 */
	public static List<LogInterno> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the log internos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LogInternoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of log internos
	 * @param end the upper bound of the range of log internos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of log internos
	 */
	public static List<LogInterno> findAll(
		int start, int end, OrderByComparator<LogInterno> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the log internos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LogInternoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of log internos
	 * @param end the upper bound of the range of log internos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of log internos
	 */
	public static List<LogInterno> findAll(
		int start, int end, OrderByComparator<LogInterno> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the log internos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of log internos.
	 *
	 * @return the number of log internos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LogInternoPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(LogInternoPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile LogInternoPersistence _persistence;

}