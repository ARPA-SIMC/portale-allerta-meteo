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

import it.eng.allerte.model.RubricaPermessi;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the rubrica permessi service. This utility wraps <code>it.eng.allerte.service.persistence.impl.RubricaPermessiPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see RubricaPermessiPersistence
 * @generated
 */
@ProviderType
public class RubricaPermessiUtil {

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
	public static void clearCache(RubricaPermessi rubricaPermessi) {
		getPersistence().clearCache(rubricaPermessi);
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
	public static Map<Serializable, RubricaPermessi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RubricaPermessi> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RubricaPermessi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RubricaPermessi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RubricaPermessi> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RubricaPermessi update(RubricaPermessi rubricaPermessi) {
		return getPersistence().update(rubricaPermessi);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RubricaPermessi update(
		RubricaPermessi rubricaPermessi, ServiceContext serviceContext) {

		return getPersistence().update(rubricaPermessi, serviceContext);
	}

	/**
	 * Caches the rubrica permessi in the entity cache if it is enabled.
	 *
	 * @param rubricaPermessi the rubrica permessi
	 */
	public static void cacheResult(RubricaPermessi rubricaPermessi) {
		getPersistence().cacheResult(rubricaPermessi);
	}

	/**
	 * Caches the rubrica permessis in the entity cache if it is enabled.
	 *
	 * @param rubricaPermessis the rubrica permessis
	 */
	public static void cacheResult(List<RubricaPermessi> rubricaPermessis) {
		getPersistence().cacheResult(rubricaPermessis);
	}

	/**
	 * Creates a new rubrica permessi with the primary key. Does not add the rubrica permessi to the database.
	 *
	 * @param ID_PERMESSO the primary key for the new rubrica permessi
	 * @return the new rubrica permessi
	 */
	public static RubricaPermessi create(String ID_PERMESSO) {
		return getPersistence().create(ID_PERMESSO);
	}

	/**
	 * Removes the rubrica permessi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_PERMESSO the primary key of the rubrica permessi
	 * @return the rubrica permessi that was removed
	 * @throws NoSuchRubricaPermessiException if a rubrica permessi with the primary key could not be found
	 */
	public static RubricaPermessi remove(String ID_PERMESSO)
		throws it.eng.allerte.exception.NoSuchRubricaPermessiException {

		return getPersistence().remove(ID_PERMESSO);
	}

	public static RubricaPermessi updateImpl(RubricaPermessi rubricaPermessi) {
		return getPersistence().updateImpl(rubricaPermessi);
	}

	/**
	 * Returns the rubrica permessi with the primary key or throws a <code>NoSuchRubricaPermessiException</code> if it could not be found.
	 *
	 * @param ID_PERMESSO the primary key of the rubrica permessi
	 * @return the rubrica permessi
	 * @throws NoSuchRubricaPermessiException if a rubrica permessi with the primary key could not be found
	 */
	public static RubricaPermessi findByPrimaryKey(String ID_PERMESSO)
		throws it.eng.allerte.exception.NoSuchRubricaPermessiException {

		return getPersistence().findByPrimaryKey(ID_PERMESSO);
	}

	/**
	 * Returns the rubrica permessi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_PERMESSO the primary key of the rubrica permessi
	 * @return the rubrica permessi, or <code>null</code> if a rubrica permessi with the primary key could not be found
	 */
	public static RubricaPermessi fetchByPrimaryKey(String ID_PERMESSO) {
		return getPersistence().fetchByPrimaryKey(ID_PERMESSO);
	}

	/**
	 * Returns all the rubrica permessis.
	 *
	 * @return the rubrica permessis
	 */
	public static List<RubricaPermessi> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the rubrica permessis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica permessis
	 * @param end the upper bound of the range of rubrica permessis (not inclusive)
	 * @return the range of rubrica permessis
	 */
	public static List<RubricaPermessi> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the rubrica permessis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica permessis
	 * @param end the upper bound of the range of rubrica permessis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica permessis
	 */
	public static List<RubricaPermessi> findAll(
		int start, int end,
		OrderByComparator<RubricaPermessi> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rubrica permessis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica permessis
	 * @param end the upper bound of the range of rubrica permessis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica permessis
	 */
	public static List<RubricaPermessi> findAll(
		int start, int end,
		OrderByComparator<RubricaPermessi> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the rubrica permessis from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of rubrica permessis.
	 *
	 * @return the number of rubrica permessis
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RubricaPermessiPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RubricaPermessiPersistence, RubricaPermessiPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			RubricaPermessiPersistence.class);

		ServiceTracker<RubricaPermessiPersistence, RubricaPermessiPersistence>
			serviceTracker =
				new ServiceTracker
					<RubricaPermessiPersistence, RubricaPermessiPersistence>(
						bundle.getBundleContext(),
						RubricaPermessiPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}