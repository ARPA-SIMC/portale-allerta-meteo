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

package allerta.verifica.service.persistence;

import aQute.bnd.annotation.ProviderType;

import allerta.verifica.model.UtenteLavoro;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the utente lavoro service. This utility wraps <code>allerta.verifica.service.persistence.impl.UtenteLavoroPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UtenteLavoroPersistence
 * @generated
 */
@ProviderType
public class UtenteLavoroUtil {

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
	public static void clearCache(UtenteLavoro utenteLavoro) {
		getPersistence().clearCache(utenteLavoro);
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
	public static Map<Serializable, UtenteLavoro> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UtenteLavoro> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UtenteLavoro> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UtenteLavoro> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UtenteLavoro> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UtenteLavoro update(UtenteLavoro utenteLavoro) {
		return getPersistence().update(utenteLavoro);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UtenteLavoro update(
		UtenteLavoro utenteLavoro, ServiceContext serviceContext) {

		return getPersistence().update(utenteLavoro, serviceContext);
	}

	/**
	 * Returns all the utente lavoros where documento = &#63;.
	 *
	 * @param documento the documento
	 * @return the matching utente lavoros
	 */
	public static List<UtenteLavoro> findByDocumento(long documento) {
		return getPersistence().findByDocumento(documento);
	}

	/**
	 * Returns a range of all the utente lavoros where documento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UtenteLavoroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param start the lower bound of the range of utente lavoros
	 * @param end the upper bound of the range of utente lavoros (not inclusive)
	 * @return the range of matching utente lavoros
	 */
	public static List<UtenteLavoro> findByDocumento(
		long documento, int start, int end) {

		return getPersistence().findByDocumento(documento, start, end);
	}

	/**
	 * Returns an ordered range of all the utente lavoros where documento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UtenteLavoroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param start the lower bound of the range of utente lavoros
	 * @param end the upper bound of the range of utente lavoros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching utente lavoros
	 */
	public static List<UtenteLavoro> findByDocumento(
		long documento, int start, int end,
		OrderByComparator<UtenteLavoro> orderByComparator) {

		return getPersistence().findByDocumento(
			documento, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the utente lavoros where documento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UtenteLavoroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param documento the documento
	 * @param start the lower bound of the range of utente lavoros
	 * @param end the upper bound of the range of utente lavoros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching utente lavoros
	 */
	public static List<UtenteLavoro> findByDocumento(
		long documento, int start, int end,
		OrderByComparator<UtenteLavoro> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByDocumento(
			documento, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first utente lavoro in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente lavoro
	 * @throws NoSuchUtenteLavoroException if a matching utente lavoro could not be found
	 */
	public static UtenteLavoro findByDocumento_First(
			long documento, OrderByComparator<UtenteLavoro> orderByComparator)
		throws allerta.verifica.exception.NoSuchUtenteLavoroException {

		return getPersistence().findByDocumento_First(
			documento, orderByComparator);
	}

	/**
	 * Returns the first utente lavoro in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching utente lavoro, or <code>null</code> if a matching utente lavoro could not be found
	 */
	public static UtenteLavoro fetchByDocumento_First(
		long documento, OrderByComparator<UtenteLavoro> orderByComparator) {

		return getPersistence().fetchByDocumento_First(
			documento, orderByComparator);
	}

	/**
	 * Returns the last utente lavoro in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente lavoro
	 * @throws NoSuchUtenteLavoroException if a matching utente lavoro could not be found
	 */
	public static UtenteLavoro findByDocumento_Last(
			long documento, OrderByComparator<UtenteLavoro> orderByComparator)
		throws allerta.verifica.exception.NoSuchUtenteLavoroException {

		return getPersistence().findByDocumento_Last(
			documento, orderByComparator);
	}

	/**
	 * Returns the last utente lavoro in the ordered set where documento = &#63;.
	 *
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching utente lavoro, or <code>null</code> if a matching utente lavoro could not be found
	 */
	public static UtenteLavoro fetchByDocumento_Last(
		long documento, OrderByComparator<UtenteLavoro> orderByComparator) {

		return getPersistence().fetchByDocumento_Last(
			documento, orderByComparator);
	}

	/**
	 * Returns the utente lavoros before and after the current utente lavoro in the ordered set where documento = &#63;.
	 *
	 * @param id the primary key of the current utente lavoro
	 * @param documento the documento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next utente lavoro
	 * @throws NoSuchUtenteLavoroException if a utente lavoro with the primary key could not be found
	 */
	public static UtenteLavoro[] findByDocumento_PrevAndNext(
			long id, long documento,
			OrderByComparator<UtenteLavoro> orderByComparator)
		throws allerta.verifica.exception.NoSuchUtenteLavoroException {

		return getPersistence().findByDocumento_PrevAndNext(
			id, documento, orderByComparator);
	}

	/**
	 * Removes all the utente lavoros where documento = &#63; from the database.
	 *
	 * @param documento the documento
	 */
	public static void removeByDocumento(long documento) {
		getPersistence().removeByDocumento(documento);
	}

	/**
	 * Returns the number of utente lavoros where documento = &#63;.
	 *
	 * @param documento the documento
	 * @return the number of matching utente lavoros
	 */
	public static int countByDocumento(long documento) {
		return getPersistence().countByDocumento(documento);
	}

	/**
	 * Caches the utente lavoro in the entity cache if it is enabled.
	 *
	 * @param utenteLavoro the utente lavoro
	 */
	public static void cacheResult(UtenteLavoro utenteLavoro) {
		getPersistence().cacheResult(utenteLavoro);
	}

	/**
	 * Caches the utente lavoros in the entity cache if it is enabled.
	 *
	 * @param utenteLavoros the utente lavoros
	 */
	public static void cacheResult(List<UtenteLavoro> utenteLavoros) {
		getPersistence().cacheResult(utenteLavoros);
	}

	/**
	 * Creates a new utente lavoro with the primary key. Does not add the utente lavoro to the database.
	 *
	 * @param id the primary key for the new utente lavoro
	 * @return the new utente lavoro
	 */
	public static UtenteLavoro create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the utente lavoro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the utente lavoro
	 * @return the utente lavoro that was removed
	 * @throws NoSuchUtenteLavoroException if a utente lavoro with the primary key could not be found
	 */
	public static UtenteLavoro remove(long id)
		throws allerta.verifica.exception.NoSuchUtenteLavoroException {

		return getPersistence().remove(id);
	}

	public static UtenteLavoro updateImpl(UtenteLavoro utenteLavoro) {
		return getPersistence().updateImpl(utenteLavoro);
	}

	/**
	 * Returns the utente lavoro with the primary key or throws a <code>NoSuchUtenteLavoroException</code> if it could not be found.
	 *
	 * @param id the primary key of the utente lavoro
	 * @return the utente lavoro
	 * @throws NoSuchUtenteLavoroException if a utente lavoro with the primary key could not be found
	 */
	public static UtenteLavoro findByPrimaryKey(long id)
		throws allerta.verifica.exception.NoSuchUtenteLavoroException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the utente lavoro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the utente lavoro
	 * @return the utente lavoro, or <code>null</code> if a utente lavoro with the primary key could not be found
	 */
	public static UtenteLavoro fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the utente lavoros.
	 *
	 * @return the utente lavoros
	 */
	public static List<UtenteLavoro> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the utente lavoros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UtenteLavoroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente lavoros
	 * @param end the upper bound of the range of utente lavoros (not inclusive)
	 * @return the range of utente lavoros
	 */
	public static List<UtenteLavoro> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the utente lavoros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UtenteLavoroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente lavoros
	 * @param end the upper bound of the range of utente lavoros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of utente lavoros
	 */
	public static List<UtenteLavoro> findAll(
		int start, int end, OrderByComparator<UtenteLavoro> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the utente lavoros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UtenteLavoroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente lavoros
	 * @param end the upper bound of the range of utente lavoros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of utente lavoros
	 */
	public static List<UtenteLavoro> findAll(
		int start, int end, OrderByComparator<UtenteLavoro> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the utente lavoros from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of utente lavoros.
	 *
	 * @return the number of utente lavoros
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static UtenteLavoroPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<UtenteLavoroPersistence, UtenteLavoroPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(UtenteLavoroPersistence.class);

		ServiceTracker<UtenteLavoroPersistence, UtenteLavoroPersistence>
			serviceTracker =
				new ServiceTracker
					<UtenteLavoroPersistence, UtenteLavoroPersistence>(
						bundle.getBundleContext(),
						UtenteLavoroPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}