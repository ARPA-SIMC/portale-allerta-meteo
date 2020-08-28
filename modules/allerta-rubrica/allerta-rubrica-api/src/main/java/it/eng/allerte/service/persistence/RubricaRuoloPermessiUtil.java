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

import it.eng.allerte.model.RubricaRuoloPermessi;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the rubrica ruolo permessi service. This utility wraps <code>it.eng.allerte.service.persistence.impl.RubricaRuoloPermessiPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Pratola_L
 * @see RubricaRuoloPermessiPersistence
 * @generated
 */
@ProviderType
public class RubricaRuoloPermessiUtil {

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
	public static void clearCache(RubricaRuoloPermessi rubricaRuoloPermessi) {
		getPersistence().clearCache(rubricaRuoloPermessi);
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
	public static Map<Serializable, RubricaRuoloPermessi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RubricaRuoloPermessi> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RubricaRuoloPermessi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RubricaRuoloPermessi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RubricaRuoloPermessi> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RubricaRuoloPermessi update(
		RubricaRuoloPermessi rubricaRuoloPermessi) {

		return getPersistence().update(rubricaRuoloPermessi);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RubricaRuoloPermessi update(
		RubricaRuoloPermessi rubricaRuoloPermessi,
		ServiceContext serviceContext) {

		return getPersistence().update(rubricaRuoloPermessi, serviceContext);
	}

	/**
	 * Returns all the rubrica ruolo permessis where FK_ID_RUOLO = &#63;.
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @return the matching rubrica ruolo permessis
	 */
	public static List<RubricaRuoloPermessi> findByRubricaPermessiByRuolo(
		long FK_ID_RUOLO) {

		return getPersistence().findByRubricaPermessiByRuolo(FK_ID_RUOLO);
	}

	/**
	 * Returns a range of all the rubrica ruolo permessis where FK_ID_RUOLO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param start the lower bound of the range of rubrica ruolo permessis
	 * @param end the upper bound of the range of rubrica ruolo permessis (not inclusive)
	 * @return the range of matching rubrica ruolo permessis
	 */
	public static List<RubricaRuoloPermessi> findByRubricaPermessiByRuolo(
		long FK_ID_RUOLO, int start, int end) {

		return getPersistence().findByRubricaPermessiByRuolo(
			FK_ID_RUOLO, start, end);
	}

	/**
	 * Returns an ordered range of all the rubrica ruolo permessis where FK_ID_RUOLO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param start the lower bound of the range of rubrica ruolo permessis
	 * @param end the upper bound of the range of rubrica ruolo permessis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rubrica ruolo permessis
	 */
	public static List<RubricaRuoloPermessi> findByRubricaPermessiByRuolo(
		long FK_ID_RUOLO, int start, int end,
		OrderByComparator<RubricaRuoloPermessi> orderByComparator) {

		return getPersistence().findByRubricaPermessiByRuolo(
			FK_ID_RUOLO, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rubrica ruolo permessis where FK_ID_RUOLO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param start the lower bound of the range of rubrica ruolo permessis
	 * @param end the upper bound of the range of rubrica ruolo permessis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching rubrica ruolo permessis
	 */
	public static List<RubricaRuoloPermessi> findByRubricaPermessiByRuolo(
		long FK_ID_RUOLO, int start, int end,
		OrderByComparator<RubricaRuoloPermessi> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByRubricaPermessiByRuolo(
			FK_ID_RUOLO, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first rubrica ruolo permessi in the ordered set where FK_ID_RUOLO = &#63;.
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica ruolo permessi
	 * @throws NoSuchRubricaRuoloPermessiException if a matching rubrica ruolo permessi could not be found
	 */
	public static RubricaRuoloPermessi findByRubricaPermessiByRuolo_First(
			long FK_ID_RUOLO,
			OrderByComparator<RubricaRuoloPermessi> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaRuoloPermessiException {

		return getPersistence().findByRubricaPermessiByRuolo_First(
			FK_ID_RUOLO, orderByComparator);
	}

	/**
	 * Returns the first rubrica ruolo permessi in the ordered set where FK_ID_RUOLO = &#63;.
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rubrica ruolo permessi, or <code>null</code> if a matching rubrica ruolo permessi could not be found
	 */
	public static RubricaRuoloPermessi fetchByRubricaPermessiByRuolo_First(
		long FK_ID_RUOLO,
		OrderByComparator<RubricaRuoloPermessi> orderByComparator) {

		return getPersistence().fetchByRubricaPermessiByRuolo_First(
			FK_ID_RUOLO, orderByComparator);
	}

	/**
	 * Returns the last rubrica ruolo permessi in the ordered set where FK_ID_RUOLO = &#63;.
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica ruolo permessi
	 * @throws NoSuchRubricaRuoloPermessiException if a matching rubrica ruolo permessi could not be found
	 */
	public static RubricaRuoloPermessi findByRubricaPermessiByRuolo_Last(
			long FK_ID_RUOLO,
			OrderByComparator<RubricaRuoloPermessi> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaRuoloPermessiException {

		return getPersistence().findByRubricaPermessiByRuolo_Last(
			FK_ID_RUOLO, orderByComparator);
	}

	/**
	 * Returns the last rubrica ruolo permessi in the ordered set where FK_ID_RUOLO = &#63;.
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rubrica ruolo permessi, or <code>null</code> if a matching rubrica ruolo permessi could not be found
	 */
	public static RubricaRuoloPermessi fetchByRubricaPermessiByRuolo_Last(
		long FK_ID_RUOLO,
		OrderByComparator<RubricaRuoloPermessi> orderByComparator) {

		return getPersistence().fetchByRubricaPermessiByRuolo_Last(
			FK_ID_RUOLO, orderByComparator);
	}

	/**
	 * Returns the rubrica ruolo permessis before and after the current rubrica ruolo permessi in the ordered set where FK_ID_RUOLO = &#63;.
	 *
	 * @param rubricaRuoloPermessiPK the primary key of the current rubrica ruolo permessi
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rubrica ruolo permessi
	 * @throws NoSuchRubricaRuoloPermessiException if a rubrica ruolo permessi with the primary key could not be found
	 */
	public static RubricaRuoloPermessi[]
			findByRubricaPermessiByRuolo_PrevAndNext(
				it.eng.allerte.service.persistence.RubricaRuoloPermessiPK
					rubricaRuoloPermessiPK,
				long FK_ID_RUOLO,
				OrderByComparator<RubricaRuoloPermessi> orderByComparator)
		throws it.eng.allerte.exception.NoSuchRubricaRuoloPermessiException {

		return getPersistence().findByRubricaPermessiByRuolo_PrevAndNext(
			rubricaRuoloPermessiPK, FK_ID_RUOLO, orderByComparator);
	}

	/**
	 * Removes all the rubrica ruolo permessis where FK_ID_RUOLO = &#63; from the database.
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 */
	public static void removeByRubricaPermessiByRuolo(long FK_ID_RUOLO) {
		getPersistence().removeByRubricaPermessiByRuolo(FK_ID_RUOLO);
	}

	/**
	 * Returns the number of rubrica ruolo permessis where FK_ID_RUOLO = &#63;.
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo
	 * @return the number of matching rubrica ruolo permessis
	 */
	public static int countByRubricaPermessiByRuolo(long FK_ID_RUOLO) {
		return getPersistence().countByRubricaPermessiByRuolo(FK_ID_RUOLO);
	}

	/**
	 * Caches the rubrica ruolo permessi in the entity cache if it is enabled.
	 *
	 * @param rubricaRuoloPermessi the rubrica ruolo permessi
	 */
	public static void cacheResult(RubricaRuoloPermessi rubricaRuoloPermessi) {
		getPersistence().cacheResult(rubricaRuoloPermessi);
	}

	/**
	 * Caches the rubrica ruolo permessis in the entity cache if it is enabled.
	 *
	 * @param rubricaRuoloPermessis the rubrica ruolo permessis
	 */
	public static void cacheResult(
		List<RubricaRuoloPermessi> rubricaRuoloPermessis) {

		getPersistence().cacheResult(rubricaRuoloPermessis);
	}

	/**
	 * Creates a new rubrica ruolo permessi with the primary key. Does not add the rubrica ruolo permessi to the database.
	 *
	 * @param rubricaRuoloPermessiPK the primary key for the new rubrica ruolo permessi
	 * @return the new rubrica ruolo permessi
	 */
	public static RubricaRuoloPermessi create(
		it.eng.allerte.service.persistence.RubricaRuoloPermessiPK
			rubricaRuoloPermessiPK) {

		return getPersistence().create(rubricaRuoloPermessiPK);
	}

	/**
	 * Removes the rubrica ruolo permessi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaRuoloPermessiPK the primary key of the rubrica ruolo permessi
	 * @return the rubrica ruolo permessi that was removed
	 * @throws NoSuchRubricaRuoloPermessiException if a rubrica ruolo permessi with the primary key could not be found
	 */
	public static RubricaRuoloPermessi remove(
			it.eng.allerte.service.persistence.RubricaRuoloPermessiPK
				rubricaRuoloPermessiPK)
		throws it.eng.allerte.exception.NoSuchRubricaRuoloPermessiException {

		return getPersistence().remove(rubricaRuoloPermessiPK);
	}

	public static RubricaRuoloPermessi updateImpl(
		RubricaRuoloPermessi rubricaRuoloPermessi) {

		return getPersistence().updateImpl(rubricaRuoloPermessi);
	}

	/**
	 * Returns the rubrica ruolo permessi with the primary key or throws a <code>NoSuchRubricaRuoloPermessiException</code> if it could not be found.
	 *
	 * @param rubricaRuoloPermessiPK the primary key of the rubrica ruolo permessi
	 * @return the rubrica ruolo permessi
	 * @throws NoSuchRubricaRuoloPermessiException if a rubrica ruolo permessi with the primary key could not be found
	 */
	public static RubricaRuoloPermessi findByPrimaryKey(
			it.eng.allerte.service.persistence.RubricaRuoloPermessiPK
				rubricaRuoloPermessiPK)
		throws it.eng.allerte.exception.NoSuchRubricaRuoloPermessiException {

		return getPersistence().findByPrimaryKey(rubricaRuoloPermessiPK);
	}

	/**
	 * Returns the rubrica ruolo permessi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rubricaRuoloPermessiPK the primary key of the rubrica ruolo permessi
	 * @return the rubrica ruolo permessi, or <code>null</code> if a rubrica ruolo permessi with the primary key could not be found
	 */
	public static RubricaRuoloPermessi fetchByPrimaryKey(
		it.eng.allerte.service.persistence.RubricaRuoloPermessiPK
			rubricaRuoloPermessiPK) {

		return getPersistence().fetchByPrimaryKey(rubricaRuoloPermessiPK);
	}

	/**
	 * Returns all the rubrica ruolo permessis.
	 *
	 * @return the rubrica ruolo permessis
	 */
	public static List<RubricaRuoloPermessi> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the rubrica ruolo permessis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolo permessis
	 * @param end the upper bound of the range of rubrica ruolo permessis (not inclusive)
	 * @return the range of rubrica ruolo permessis
	 */
	public static List<RubricaRuoloPermessi> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the rubrica ruolo permessis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolo permessis
	 * @param end the upper bound of the range of rubrica ruolo permessis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rubrica ruolo permessis
	 */
	public static List<RubricaRuoloPermessi> findAll(
		int start, int end,
		OrderByComparator<RubricaRuoloPermessi> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rubrica ruolo permessis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>RubricaRuoloPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolo permessis
	 * @param end the upper bound of the range of rubrica ruolo permessis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rubrica ruolo permessis
	 */
	public static List<RubricaRuoloPermessi> findAll(
		int start, int end,
		OrderByComparator<RubricaRuoloPermessi> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the rubrica ruolo permessis from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of rubrica ruolo permessis.
	 *
	 * @return the number of rubrica ruolo permessis
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static RubricaRuoloPermessiPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RubricaRuoloPermessiPersistence, RubricaRuoloPermessiPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			RubricaRuoloPermessiPersistence.class);

		ServiceTracker
			<RubricaRuoloPermessiPersistence, RubricaRuoloPermessiPersistence>
				serviceTracker =
					new ServiceTracker
						<RubricaRuoloPermessiPersistence,
						 RubricaRuoloPermessiPersistence>(
							 bundle.getBundleContext(),
							 RubricaRuoloPermessiPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}