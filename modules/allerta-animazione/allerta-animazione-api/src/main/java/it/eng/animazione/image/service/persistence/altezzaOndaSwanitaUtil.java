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

package it.eng.animazione.image.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.animazione.image.model.altezzaOndaSwanita;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the altezza onda swanita service. This utility wraps <code>it.eng.animazione.image.service.persistence.impl.altezzaOndaSwanitaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author UTENTE
 * @see altezzaOndaSwanitaPersistence
 * @generated
 */
@ProviderType
public class altezzaOndaSwanitaUtil {

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
	public static void clearCache(altezzaOndaSwanita altezzaOndaSwanita) {
		getPersistence().clearCache(altezzaOndaSwanita);
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
	public static Map<Serializable, altezzaOndaSwanita> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<altezzaOndaSwanita> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<altezzaOndaSwanita> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<altezzaOndaSwanita> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<altezzaOndaSwanita> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static altezzaOndaSwanita update(
		altezzaOndaSwanita altezzaOndaSwanita) {

		return getPersistence().update(altezzaOndaSwanita);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static altezzaOndaSwanita update(
		altezzaOndaSwanita altezzaOndaSwanita, ServiceContext serviceContext) {

		return getPersistence().update(altezzaOndaSwanita, serviceContext);
	}

	/**
	 * Caches the altezza onda swanita in the entity cache if it is enabled.
	 *
	 * @param altezzaOndaSwanita the altezza onda swanita
	 */
	public static void cacheResult(altezzaOndaSwanita altezzaOndaSwanita) {
		getPersistence().cacheResult(altezzaOndaSwanita);
	}

	/**
	 * Caches the altezza onda swanitas in the entity cache if it is enabled.
	 *
	 * @param altezzaOndaSwanitas the altezza onda swanitas
	 */
	public static void cacheResult(
		List<altezzaOndaSwanita> altezzaOndaSwanitas) {

		getPersistence().cacheResult(altezzaOndaSwanitas);
	}

	/**
	 * Creates a new altezza onda swanita with the primary key. Does not add the altezza onda swanita to the database.
	 *
	 * @param id the primary key for the new altezza onda swanita
	 * @return the new altezza onda swanita
	 */
	public static altezzaOndaSwanita create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the altezza onda swanita with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the altezza onda swanita
	 * @return the altezza onda swanita that was removed
	 * @throws NoSuchaltezzaOndaSwanitaException if a altezza onda swanita with the primary key could not be found
	 */
	public static altezzaOndaSwanita remove(long id)
		throws it.eng.animazione.image.exception.
			NoSuchaltezzaOndaSwanitaException {

		return getPersistence().remove(id);
	}

	public static altezzaOndaSwanita updateImpl(
		altezzaOndaSwanita altezzaOndaSwanita) {

		return getPersistence().updateImpl(altezzaOndaSwanita);
	}

	/**
	 * Returns the altezza onda swanita with the primary key or throws a <code>NoSuchaltezzaOndaSwanitaException</code> if it could not be found.
	 *
	 * @param id the primary key of the altezza onda swanita
	 * @return the altezza onda swanita
	 * @throws NoSuchaltezzaOndaSwanitaException if a altezza onda swanita with the primary key could not be found
	 */
	public static altezzaOndaSwanita findByPrimaryKey(long id)
		throws it.eng.animazione.image.exception.
			NoSuchaltezzaOndaSwanitaException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the altezza onda swanita with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the altezza onda swanita
	 * @return the altezza onda swanita, or <code>null</code> if a altezza onda swanita with the primary key could not be found
	 */
	public static altezzaOndaSwanita fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the altezza onda swanitas.
	 *
	 * @return the altezza onda swanitas
	 */
	public static List<altezzaOndaSwanita> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the altezza onda swanitas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>altezzaOndaSwanitaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza onda swanitas
	 * @param end the upper bound of the range of altezza onda swanitas (not inclusive)
	 * @return the range of altezza onda swanitas
	 */
	public static List<altezzaOndaSwanita> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the altezza onda swanitas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>altezzaOndaSwanitaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza onda swanitas
	 * @param end the upper bound of the range of altezza onda swanitas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of altezza onda swanitas
	 */
	public static List<altezzaOndaSwanita> findAll(
		int start, int end,
		OrderByComparator<altezzaOndaSwanita> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the altezza onda swanitas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>altezzaOndaSwanitaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza onda swanitas
	 * @param end the upper bound of the range of altezza onda swanitas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of altezza onda swanitas
	 */
	public static List<altezzaOndaSwanita> findAll(
		int start, int end,
		OrderByComparator<altezzaOndaSwanita> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the altezza onda swanitas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of altezza onda swanitas.
	 *
	 * @return the number of altezza onda swanitas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static altezzaOndaSwanitaPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<altezzaOndaSwanitaPersistence, altezzaOndaSwanitaPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			altezzaOndaSwanitaPersistence.class);

		ServiceTracker
			<altezzaOndaSwanitaPersistence, altezzaOndaSwanitaPersistence>
				serviceTracker =
					new ServiceTracker
						<altezzaOndaSwanitaPersistence,
						 altezzaOndaSwanitaPersistence>(
							 bundle.getBundleContext(),
							 altezzaOndaSwanitaPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}