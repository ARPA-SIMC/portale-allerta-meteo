/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.eng.allerte.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.allerte.model.RubricaRuoloRubrica;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the rubrica ruolo rubrica service. This utility wraps <code>it.eng.allerte.service.persistence.impl.RubricaRuoloRubricaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see RubricaRuoloRubricaPersistence
 * @generated
 */
@ProviderType
public class RubricaRuoloRubricaUtil {

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
	public static void clearCache(RubricaRuoloRubrica rubricaRuoloRubrica) {
		getPersistence().clearCache(rubricaRuoloRubrica);
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
	public static Map<Serializable, RubricaRuoloRubrica> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RubricaRuoloRubrica> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RubricaRuoloRubrica> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RubricaRuoloRubrica> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RubricaRuoloRubrica> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RubricaRuoloRubrica update(
		RubricaRuoloRubrica rubricaRuoloRubrica) {

		return getPersistence().update(rubricaRuoloRubrica);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RubricaRuoloRubrica update(
		RubricaRuoloRubrica rubricaRuoloRubrica,
		ServiceContext serviceContext) {

		return getPersistence().update(rubricaRuoloRubrica, serviceContext);
	}

	/**
	 * Caches the rubrica ruolo rubrica in the entity cache if it is enabled.
	 *
	 * @param rubricaRuoloRubrica the rubrica ruolo rubrica
	 */
	public static void cacheResult(RubricaRuoloRubrica rubricaRuoloRubrica) {
		getPersistence().cacheResult(rubricaRuoloRubrica);
	}

	/**
	 * Caches the rubrica ruolo rubricas in the entity cache if it is enabled.
	 *
	 * @param rubricaRuoloRubricas the rubrica ruolo rubricas
	 */
	public static void cacheResult(
		List<RubricaRuoloRubrica> rubricaRuoloRubricas) {

		getPersistence().cacheResult(rubricaRuoloRubricas);
	}

	/**
	 * Creates a new rubrica ruolo rubrica with the primary key. Does not add the rubrica ruolo rubrica to the database.
	 *
	 * @param ID_RUOLO the primary key for the new rubrica ruolo rubrica
	 * @return the new rubrica ruolo rubrica
	 */
	public static RubricaRuoloRubrica create(long ID_RUOLO) {
		return getPersistence().create(ID_RUOLO);
	}

	/**
	 * Removes the rubrica ruolo rubrica with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_RUOLO the primary key of the rubrica ruolo rubrica
	 * @return the rubrica ruolo rubrica that was removed
	 * @throws NoSuchRubricaRuoloRubricaException if a rubrica ruolo rubrica with the primary key could not be found
	 */
	public static RubricaRuoloRubrica remove(long ID_RUOLO)
		throws it.eng.allerte.exception.NoSuchRubricaRuoloRubricaException {

		return getPersistence().remove(ID_RUOLO);
	}

	public static RubricaRuoloRubrica updateImpl(
		RubricaRuoloRubrica rubricaRuoloRubrica) {

		return getPersistence().updateImpl(rubricaRuoloRubrica);
	}

	/**
	 * Returns the rubrica ruolo rubrica with the primary key or throws a <code>NoSuchRubricaRuoloRubricaException</code> if it could not be found.
	 *
	 * @param ID_RUOLO the primary key of the rubrica ruolo rubrica
	 * @return the rubrica ruolo rubrica
	 * @throws NoSuchRubricaRuoloRubricaException if a rubrica ruolo rubrica with the primary key could not be found
	 */
	public static RubricaRuoloRubrica findByPrimaryKey(long ID_RUOLO)
		throws it.eng.allerte.exception.NoSuchRubricaRuoloRubricaException {

		return getPersistence().findByPrimaryKey(ID_RUOLO);
	}

	/**
	 * Returns the rubrica ruolo rubrica with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_RUOLO the primary key of the rubrica ruolo rubrica
	 * @return the rubrica ruolo rubrica, or <code>null</code> if a rubrica ruolo rubrica with the primary key could not be found
	 */
	public static RubricaRuoloRubrica fetchByPrimaryKey(long ID_RUOLO) {
		return getPersistence().fetchByPrimaryKey(ID_RUOLO);
	}

	/**
	 * Returns all the rubrica ruolo rubricas.
	 *
	 * @return the rubrica ruolo rubricas
	 */
	public static List<RubricaRuoloRubrica> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the rubrica ruolo rubricas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloRubricaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolo rubricas
	 * @param end the upper bound of the range of rubrica ruolo rubricas (not inclusive)
	 * @return the range of rubrica ruolo rubricas
	 */
	public static List<RubricaRuoloRubrica> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the rubrica ruolo rubricas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloRubricaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolo rubricas
	 * @param end the upper bound of the range of rubrica ruolo rubricas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica ruolo rubricas
	 */
	public static List<RubricaRuoloRubrica> findAll(
		int start, int end,
		OrderByComparator<RubricaRuoloRubrica> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rubrica ruolo rubricas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloRubricaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolo rubricas
	 * @param end the upper bound of the range of rubrica ruolo rubricas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica ruolo rubricas
	 */
	public static List<RubricaRuoloRubrica> findAll(
		int start, int end,
		OrderByComparator<RubricaRuoloRubrica> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the rubrica ruolo rubricas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of rubrica ruolo rubricas.
	 *
	 * @return the number of rubrica ruolo rubricas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RubricaRuoloRubricaPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RubricaRuoloRubricaPersistence, RubricaRuoloRubricaPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			RubricaRuoloRubricaPersistence.class);

		ServiceTracker
			<RubricaRuoloRubricaPersistence, RubricaRuoloRubricaPersistence>
				serviceTracker =
					new ServiceTracker
						<RubricaRuoloRubricaPersistence,
						 RubricaRuoloRubricaPersistence>(
							 bundle.getBundleContext(),
							 RubricaRuoloRubricaPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}