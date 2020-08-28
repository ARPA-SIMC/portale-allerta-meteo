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

import it.eng.allerte.model.RubricaUtenteSito;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the rubrica utente sito service. This utility wraps <code>it.eng.allerte.service.persistence.impl.RubricaUtenteSitoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see RubricaUtenteSitoPersistence
 * @generated
 */
@ProviderType
public class RubricaUtenteSitoUtil {

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
	public static void clearCache(RubricaUtenteSito rubricaUtenteSito) {
		getPersistence().clearCache(rubricaUtenteSito);
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
	public static Map<Serializable, RubricaUtenteSito> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RubricaUtenteSito> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RubricaUtenteSito> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RubricaUtenteSito> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RubricaUtenteSito> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RubricaUtenteSito update(
		RubricaUtenteSito rubricaUtenteSito) {

		return getPersistence().update(rubricaUtenteSito);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RubricaUtenteSito update(
		RubricaUtenteSito rubricaUtenteSito, ServiceContext serviceContext) {

		return getPersistence().update(rubricaUtenteSito, serviceContext);
	}

	/**
	 * Caches the rubrica utente sito in the entity cache if it is enabled.
	 *
	 * @param rubricaUtenteSito the rubrica utente sito
	 */
	public static void cacheResult(RubricaUtenteSito rubricaUtenteSito) {
		getPersistence().cacheResult(rubricaUtenteSito);
	}

	/**
	 * Caches the rubrica utente sitos in the entity cache if it is enabled.
	 *
	 * @param rubricaUtenteSitos the rubrica utente sitos
	 */
	public static void cacheResult(List<RubricaUtenteSito> rubricaUtenteSitos) {
		getPersistence().cacheResult(rubricaUtenteSitos);
	}

	/**
	 * Creates a new rubrica utente sito with the primary key. Does not add the rubrica utente sito to the database.
	 *
	 * @param ID_UTENTE the primary key for the new rubrica utente sito
	 * @return the new rubrica utente sito
	 */
	public static RubricaUtenteSito create(long ID_UTENTE) {
		return getPersistence().create(ID_UTENTE);
	}

	/**
	 * Removes the rubrica utente sito with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_UTENTE the primary key of the rubrica utente sito
	 * @return the rubrica utente sito that was removed
	 * @throws NoSuchRubricaUtenteSitoException if a rubrica utente sito with the primary key could not be found
	 */
	public static RubricaUtenteSito remove(long ID_UTENTE)
		throws it.eng.allerte.exception.NoSuchRubricaUtenteSitoException {

		return getPersistence().remove(ID_UTENTE);
	}

	public static RubricaUtenteSito updateImpl(
		RubricaUtenteSito rubricaUtenteSito) {

		return getPersistence().updateImpl(rubricaUtenteSito);
	}

	/**
	 * Returns the rubrica utente sito with the primary key or throws a <code>NoSuchRubricaUtenteSitoException</code> if it could not be found.
	 *
	 * @param ID_UTENTE the primary key of the rubrica utente sito
	 * @return the rubrica utente sito
	 * @throws NoSuchRubricaUtenteSitoException if a rubrica utente sito with the primary key could not be found
	 */
	public static RubricaUtenteSito findByPrimaryKey(long ID_UTENTE)
		throws it.eng.allerte.exception.NoSuchRubricaUtenteSitoException {

		return getPersistence().findByPrimaryKey(ID_UTENTE);
	}

	/**
	 * Returns the rubrica utente sito with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_UTENTE the primary key of the rubrica utente sito
	 * @return the rubrica utente sito, or <code>null</code> if a rubrica utente sito with the primary key could not be found
	 */
	public static RubricaUtenteSito fetchByPrimaryKey(long ID_UTENTE) {
		return getPersistence().fetchByPrimaryKey(ID_UTENTE);
	}

	/**
	 * Returns all the rubrica utente sitos.
	 *
	 * @return the rubrica utente sitos
	 */
	public static List<RubricaUtenteSito> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the rubrica utente sitos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaUtenteSitoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica utente sitos
	 * @param end the upper bound of the range of rubrica utente sitos (not inclusive)
	 * @return the range of rubrica utente sitos
	 */
	public static List<RubricaUtenteSito> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the rubrica utente sitos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaUtenteSitoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica utente sitos
	 * @param end the upper bound of the range of rubrica utente sitos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica utente sitos
	 */
	public static List<RubricaUtenteSito> findAll(
		int start, int end,
		OrderByComparator<RubricaUtenteSito> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rubrica utente sitos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaUtenteSitoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica utente sitos
	 * @param end the upper bound of the range of rubrica utente sitos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica utente sitos
	 */
	public static List<RubricaUtenteSito> findAll(
		int start, int end,
		OrderByComparator<RubricaUtenteSito> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the rubrica utente sitos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of rubrica utente sitos.
	 *
	 * @return the number of rubrica utente sitos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RubricaUtenteSitoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RubricaUtenteSitoPersistence, RubricaUtenteSitoPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			RubricaUtenteSitoPersistence.class);

		ServiceTracker
			<RubricaUtenteSitoPersistence, RubricaUtenteSitoPersistence>
				serviceTracker =
					new ServiceTracker
						<RubricaUtenteSitoPersistence,
						 RubricaUtenteSitoPersistence>(
							 bundle.getBundleContext(),
							 RubricaUtenteSitoPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}