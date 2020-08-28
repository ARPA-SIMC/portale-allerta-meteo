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

import it.eng.allerte.model.RubricaCanale;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the rubrica canale service. This utility wraps <code>it.eng.allerte.service.persistence.impl.RubricaCanalePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see RubricaCanalePersistence
 * @generated
 */
@ProviderType
public class RubricaCanaleUtil {

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
	public static void clearCache(RubricaCanale rubricaCanale) {
		getPersistence().clearCache(rubricaCanale);
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
	public static Map<Serializable, RubricaCanale> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RubricaCanale> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RubricaCanale> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RubricaCanale> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RubricaCanale> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RubricaCanale update(RubricaCanale rubricaCanale) {
		return getPersistence().update(rubricaCanale);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RubricaCanale update(
		RubricaCanale rubricaCanale, ServiceContext serviceContext) {

		return getPersistence().update(rubricaCanale, serviceContext);
	}

	/**
	 * Caches the rubrica canale in the entity cache if it is enabled.
	 *
	 * @param rubricaCanale the rubrica canale
	 */
	public static void cacheResult(RubricaCanale rubricaCanale) {
		getPersistence().cacheResult(rubricaCanale);
	}

	/**
	 * Caches the rubrica canales in the entity cache if it is enabled.
	 *
	 * @param rubricaCanales the rubrica canales
	 */
	public static void cacheResult(List<RubricaCanale> rubricaCanales) {
		getPersistence().cacheResult(rubricaCanales);
	}

	/**
	 * Creates a new rubrica canale with the primary key. Does not add the rubrica canale to the database.
	 *
	 * @param ID_CANALE the primary key for the new rubrica canale
	 * @return the new rubrica canale
	 */
	public static RubricaCanale create(long ID_CANALE) {
		return getPersistence().create(ID_CANALE);
	}

	/**
	 * Removes the rubrica canale with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_CANALE the primary key of the rubrica canale
	 * @return the rubrica canale that was removed
	 * @throws NoSuchRubricaCanaleException if a rubrica canale with the primary key could not be found
	 */
	public static RubricaCanale remove(long ID_CANALE)
		throws it.eng.allerte.exception.NoSuchRubricaCanaleException {

		return getPersistence().remove(ID_CANALE);
	}

	public static RubricaCanale updateImpl(RubricaCanale rubricaCanale) {
		return getPersistence().updateImpl(rubricaCanale);
	}

	/**
	 * Returns the rubrica canale with the primary key or throws a <code>NoSuchRubricaCanaleException</code> if it could not be found.
	 *
	 * @param ID_CANALE the primary key of the rubrica canale
	 * @return the rubrica canale
	 * @throws NoSuchRubricaCanaleException if a rubrica canale with the primary key could not be found
	 */
	public static RubricaCanale findByPrimaryKey(long ID_CANALE)
		throws it.eng.allerte.exception.NoSuchRubricaCanaleException {

		return getPersistence().findByPrimaryKey(ID_CANALE);
	}

	/**
	 * Returns the rubrica canale with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_CANALE the primary key of the rubrica canale
	 * @return the rubrica canale, or <code>null</code> if a rubrica canale with the primary key could not be found
	 */
	public static RubricaCanale fetchByPrimaryKey(long ID_CANALE) {
		return getPersistence().fetchByPrimaryKey(ID_CANALE);
	}

	/**
	 * Returns all the rubrica canales.
	 *
	 * @return the rubrica canales
	 */
	public static List<RubricaCanale> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the rubrica canales.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaCanaleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica canales
	 * @param end the upper bound of the range of rubrica canales (not inclusive)
	 * @return the range of rubrica canales
	 */
	public static List<RubricaCanale> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the rubrica canales.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaCanaleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica canales
	 * @param end the upper bound of the range of rubrica canales (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica canales
	 */
	public static List<RubricaCanale> findAll(
		int start, int end,
		OrderByComparator<RubricaCanale> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rubrica canales.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaCanaleModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica canales
	 * @param end the upper bound of the range of rubrica canales (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica canales
	 */
	public static List<RubricaCanale> findAll(
		int start, int end, OrderByComparator<RubricaCanale> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the rubrica canales from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of rubrica canales.
	 *
	 * @return the number of rubrica canales
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RubricaCanalePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RubricaCanalePersistence, RubricaCanalePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(RubricaCanalePersistence.class);

		ServiceTracker<RubricaCanalePersistence, RubricaCanalePersistence>
			serviceTracker =
				new ServiceTracker
					<RubricaCanalePersistence, RubricaCanalePersistence>(
						bundle.getBundleContext(),
						RubricaCanalePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}