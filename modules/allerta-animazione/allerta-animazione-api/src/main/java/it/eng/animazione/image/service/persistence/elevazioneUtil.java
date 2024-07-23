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

import it.eng.animazione.image.model.elevazione;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the elevazione service. This utility wraps <code>it.eng.animazione.image.service.persistence.impl.elevazionePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author UTENTE
 * @see elevazionePersistence
 * @generated
 */
@ProviderType
public class elevazioneUtil {

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
	public static void clearCache(elevazione elevazione) {
		getPersistence().clearCache(elevazione);
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
	public static Map<Serializable, elevazione> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<elevazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<elevazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<elevazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<elevazione> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static elevazione update(elevazione elevazione) {
		return getPersistence().update(elevazione);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static elevazione update(
		elevazione elevazione, ServiceContext serviceContext) {

		return getPersistence().update(elevazione, serviceContext);
	}

	/**
	 * Caches the elevazione in the entity cache if it is enabled.
	 *
	 * @param elevazione the elevazione
	 */
	public static void cacheResult(elevazione elevazione) {
		getPersistence().cacheResult(elevazione);
	}

	/**
	 * Caches the elevaziones in the entity cache if it is enabled.
	 *
	 * @param elevaziones the elevaziones
	 */
	public static void cacheResult(List<elevazione> elevaziones) {
		getPersistence().cacheResult(elevaziones);
	}

	/**
	 * Creates a new elevazione with the primary key. Does not add the elevazione to the database.
	 *
	 * @param id the primary key for the new elevazione
	 * @return the new elevazione
	 */
	public static elevazione create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the elevazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the elevazione
	 * @return the elevazione that was removed
	 * @throws NoSuchelevazioneException if a elevazione with the primary key could not be found
	 */
	public static elevazione remove(long id)
		throws it.eng.animazione.image.exception.NoSuchelevazioneException {

		return getPersistence().remove(id);
	}

	public static elevazione updateImpl(elevazione elevazione) {
		return getPersistence().updateImpl(elevazione);
	}

	/**
	 * Returns the elevazione with the primary key or throws a <code>NoSuchelevazioneException</code> if it could not be found.
	 *
	 * @param id the primary key of the elevazione
	 * @return the elevazione
	 * @throws NoSuchelevazioneException if a elevazione with the primary key could not be found
	 */
	public static elevazione findByPrimaryKey(long id)
		throws it.eng.animazione.image.exception.NoSuchelevazioneException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the elevazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the elevazione
	 * @return the elevazione, or <code>null</code> if a elevazione with the primary key could not be found
	 */
	public static elevazione fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the elevaziones.
	 *
	 * @return the elevaziones
	 */
	public static List<elevazione> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the elevaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>elevazioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of elevaziones
	 * @param end the upper bound of the range of elevaziones (not inclusive)
	 * @return the range of elevaziones
	 */
	public static List<elevazione> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the elevaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>elevazioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of elevaziones
	 * @param end the upper bound of the range of elevaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of elevaziones
	 */
	public static List<elevazione> findAll(
		int start, int end, OrderByComparator<elevazione> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the elevaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>elevazioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of elevaziones
	 * @param end the upper bound of the range of elevaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of elevaziones
	 */
	public static List<elevazione> findAll(
		int start, int end, OrderByComparator<elevazione> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the elevaziones from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of elevaziones.
	 *
	 * @return the number of elevaziones
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static elevazionePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<elevazionePersistence, elevazionePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(elevazionePersistence.class);

		ServiceTracker<elevazionePersistence, elevazionePersistence>
			serviceTracker =
				new ServiceTracker
					<elevazionePersistence, elevazionePersistence>(
						bundle.getBundleContext(), elevazionePersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}