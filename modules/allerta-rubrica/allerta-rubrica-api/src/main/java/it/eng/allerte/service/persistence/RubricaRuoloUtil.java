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

import it.eng.allerte.model.RubricaRuolo;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the rubrica ruolo service. This utility wraps <code>it.eng.allerte.service.persistence.impl.RubricaRuoloPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see RubricaRuoloPersistence
 * @generated
 */
@ProviderType
public class RubricaRuoloUtil {

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
	public static void clearCache(RubricaRuolo rubricaRuolo) {
		getPersistence().clearCache(rubricaRuolo);
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
	public static Map<Serializable, RubricaRuolo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RubricaRuolo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RubricaRuolo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RubricaRuolo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RubricaRuolo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RubricaRuolo update(RubricaRuolo rubricaRuolo) {
		return getPersistence().update(rubricaRuolo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RubricaRuolo update(
		RubricaRuolo rubricaRuolo, ServiceContext serviceContext) {

		return getPersistence().update(rubricaRuolo, serviceContext);
	}

	/**
	 * Returns the rubrica ruolo where FK_RUOLO_LIFERAY = &#63; or throws a <code>NoSuchRubricaRuoloException</code> if it could not be found.
	 *
	 * @param FK_RUOLO_LIFERAY the fk_ruolo_liferay
	 * @return the matching rubrica ruolo
	 * @throws NoSuchRubricaRuoloException if a matching rubrica ruolo could not be found
	 */
	public static RubricaRuolo findByRubricaRuoloByRuoloLiferay(
			long FK_RUOLO_LIFERAY)
		throws it.eng.allerte.exception.NoSuchRubricaRuoloException {

		return getPersistence().findByRubricaRuoloByRuoloLiferay(
			FK_RUOLO_LIFERAY);
	}

	/**
	 * Returns the rubrica ruolo where FK_RUOLO_LIFERAY = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param FK_RUOLO_LIFERAY the fk_ruolo_liferay
	 * @return the matching rubrica ruolo, or <code>null</code> if a matching rubrica ruolo could not be found
	 */
	public static RubricaRuolo fetchByRubricaRuoloByRuoloLiferay(
		long FK_RUOLO_LIFERAY) {

		return getPersistence().fetchByRubricaRuoloByRuoloLiferay(
			FK_RUOLO_LIFERAY);
	}

	/**
	 * Returns the rubrica ruolo where FK_RUOLO_LIFERAY = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param FK_RUOLO_LIFERAY the fk_ruolo_liferay
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching rubrica ruolo, or <code>null</code> if a matching rubrica ruolo could not be found
	 */
	public static RubricaRuolo fetchByRubricaRuoloByRuoloLiferay(
		long FK_RUOLO_LIFERAY, boolean retrieveFromCache) {

		return getPersistence().fetchByRubricaRuoloByRuoloLiferay(
			FK_RUOLO_LIFERAY, retrieveFromCache);
	}

	/**
	 * Removes the rubrica ruolo where FK_RUOLO_LIFERAY = &#63; from the database.
	 *
	 * @param FK_RUOLO_LIFERAY the fk_ruolo_liferay
	 * @return the rubrica ruolo that was removed
	 */
	public static RubricaRuolo removeByRubricaRuoloByRuoloLiferay(
			long FK_RUOLO_LIFERAY)
		throws it.eng.allerte.exception.NoSuchRubricaRuoloException {

		return getPersistence().removeByRubricaRuoloByRuoloLiferay(
			FK_RUOLO_LIFERAY);
	}

	/**
	 * Returns the number of rubrica ruolos where FK_RUOLO_LIFERAY = &#63;.
	 *
	 * @param FK_RUOLO_LIFERAY the fk_ruolo_liferay
	 * @return the number of matching rubrica ruolos
	 */
	public static int countByRubricaRuoloByRuoloLiferay(long FK_RUOLO_LIFERAY) {
		return getPersistence().countByRubricaRuoloByRuoloLiferay(
			FK_RUOLO_LIFERAY);
	}

	/**
	 * Caches the rubrica ruolo in the entity cache if it is enabled.
	 *
	 * @param rubricaRuolo the rubrica ruolo
	 */
	public static void cacheResult(RubricaRuolo rubricaRuolo) {
		getPersistence().cacheResult(rubricaRuolo);
	}

	/**
	 * Caches the rubrica ruolos in the entity cache if it is enabled.
	 *
	 * @param rubricaRuolos the rubrica ruolos
	 */
	public static void cacheResult(List<RubricaRuolo> rubricaRuolos) {
		getPersistence().cacheResult(rubricaRuolos);
	}

	/**
	 * Creates a new rubrica ruolo with the primary key. Does not add the rubrica ruolo to the database.
	 *
	 * @param ID_RUOLO the primary key for the new rubrica ruolo
	 * @return the new rubrica ruolo
	 */
	public static RubricaRuolo create(long ID_RUOLO) {
		return getPersistence().create(ID_RUOLO);
	}

	/**
	 * Removes the rubrica ruolo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_RUOLO the primary key of the rubrica ruolo
	 * @return the rubrica ruolo that was removed
	 * @throws NoSuchRubricaRuoloException if a rubrica ruolo with the primary key could not be found
	 */
	public static RubricaRuolo remove(long ID_RUOLO)
		throws it.eng.allerte.exception.NoSuchRubricaRuoloException {

		return getPersistence().remove(ID_RUOLO);
	}

	public static RubricaRuolo updateImpl(RubricaRuolo rubricaRuolo) {
		return getPersistence().updateImpl(rubricaRuolo);
	}

	/**
	 * Returns the rubrica ruolo with the primary key or throws a <code>NoSuchRubricaRuoloException</code> if it could not be found.
	 *
	 * @param ID_RUOLO the primary key of the rubrica ruolo
	 * @return the rubrica ruolo
	 * @throws NoSuchRubricaRuoloException if a rubrica ruolo with the primary key could not be found
	 */
	public static RubricaRuolo findByPrimaryKey(long ID_RUOLO)
		throws it.eng.allerte.exception.NoSuchRubricaRuoloException {

		return getPersistence().findByPrimaryKey(ID_RUOLO);
	}

	/**
	 * Returns the rubrica ruolo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID_RUOLO the primary key of the rubrica ruolo
	 * @return the rubrica ruolo, or <code>null</code> if a rubrica ruolo with the primary key could not be found
	 */
	public static RubricaRuolo fetchByPrimaryKey(long ID_RUOLO) {
		return getPersistence().fetchByPrimaryKey(ID_RUOLO);
	}

	/**
	 * Returns all the rubrica ruolos.
	 *
	 * @return the rubrica ruolos
	 */
	public static List<RubricaRuolo> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the rubrica ruolos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolos
	 * @param end the upper bound of the range of rubrica ruolos (not inclusive)
	 * @return the range of rubrica ruolos
	 */
	public static List<RubricaRuolo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the rubrica ruolos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolos
	 * @param end the upper bound of the range of rubrica ruolos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica ruolos
	 */
	public static List<RubricaRuolo> findAll(
		int start, int end, OrderByComparator<RubricaRuolo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rubrica ruolos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolos
	 * @param end the upper bound of the range of rubrica ruolos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica ruolos
	 */
	public static List<RubricaRuolo> findAll(
		int start, int end, OrderByComparator<RubricaRuolo> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the rubrica ruolos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of rubrica ruolos.
	 *
	 * @return the number of rubrica ruolos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RubricaRuoloPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RubricaRuoloPersistence, RubricaRuoloPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(RubricaRuoloPersistence.class);

		ServiceTracker<RubricaRuoloPersistence, RubricaRuoloPersistence>
			serviceTracker =
				new ServiceTracker
					<RubricaRuoloPersistence, RubricaRuoloPersistence>(
						bundle.getBundleContext(),
						RubricaRuoloPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}