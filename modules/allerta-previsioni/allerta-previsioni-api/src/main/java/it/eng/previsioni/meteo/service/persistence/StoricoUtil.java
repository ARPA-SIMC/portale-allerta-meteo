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

package it.eng.previsioni.meteo.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.previsioni.meteo.model.Storico;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the storico service. This utility wraps <code>it.eng.previsioni.meteo.service.persistence.impl.StoricoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StoricoPersistence
 * @generated
 */
@ProviderType
public class StoricoUtil {

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
	public static void clearCache(Storico storico) {
		getPersistence().clearCache(storico);
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
	public static Map<Serializable, Storico> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Storico> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Storico> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Storico> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Storico> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Storico update(Storico storico) {
		return getPersistence().update(storico);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Storico update(
		Storico storico, ServiceContext serviceContext) {

		return getPersistence().update(storico, serviceContext);
	}

	/**
	 * Returns all the storicos where sigla = &#63;.
	 *
	 * @param sigla the sigla
	 * @return the matching storicos
	 */
	public static List<Storico> findBySigla(String sigla) {
		return getPersistence().findBySigla(sigla);
	}

	/**
	 * Returns a range of all the storicos where sigla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StoricoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sigla the sigla
	 * @param start the lower bound of the range of storicos
	 * @param end the upper bound of the range of storicos (not inclusive)
	 * @return the range of matching storicos
	 */
	public static List<Storico> findBySigla(String sigla, int start, int end) {
		return getPersistence().findBySigla(sigla, start, end);
	}

	/**
	 * Returns an ordered range of all the storicos where sigla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StoricoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sigla the sigla
	 * @param start the lower bound of the range of storicos
	 * @param end the upper bound of the range of storicos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching storicos
	 */
	public static List<Storico> findBySigla(
		String sigla, int start, int end,
		OrderByComparator<Storico> orderByComparator) {

		return getPersistence().findBySigla(
			sigla, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the storicos where sigla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StoricoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sigla the sigla
	 * @param start the lower bound of the range of storicos
	 * @param end the upper bound of the range of storicos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching storicos
	 */
	public static List<Storico> findBySigla(
		String sigla, int start, int end,
		OrderByComparator<Storico> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findBySigla(
			sigla, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first storico in the ordered set where sigla = &#63;.
	 *
	 * @param sigla the sigla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching storico
	 * @throws NoSuchStoricoException if a matching storico could not be found
	 */
	public static Storico findBySigla_First(
			String sigla, OrderByComparator<Storico> orderByComparator)
		throws it.eng.previsioni.meteo.exception.NoSuchStoricoException {

		return getPersistence().findBySigla_First(sigla, orderByComparator);
	}

	/**
	 * Returns the first storico in the ordered set where sigla = &#63;.
	 *
	 * @param sigla the sigla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching storico, or <code>null</code> if a matching storico could not be found
	 */
	public static Storico fetchBySigla_First(
		String sigla, OrderByComparator<Storico> orderByComparator) {

		return getPersistence().fetchBySigla_First(sigla, orderByComparator);
	}

	/**
	 * Returns the last storico in the ordered set where sigla = &#63;.
	 *
	 * @param sigla the sigla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching storico
	 * @throws NoSuchStoricoException if a matching storico could not be found
	 */
	public static Storico findBySigla_Last(
			String sigla, OrderByComparator<Storico> orderByComparator)
		throws it.eng.previsioni.meteo.exception.NoSuchStoricoException {

		return getPersistence().findBySigla_Last(sigla, orderByComparator);
	}

	/**
	 * Returns the last storico in the ordered set where sigla = &#63;.
	 *
	 * @param sigla the sigla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching storico, or <code>null</code> if a matching storico could not be found
	 */
	public static Storico fetchBySigla_Last(
		String sigla, OrderByComparator<Storico> orderByComparator) {

		return getPersistence().fetchBySigla_Last(sigla, orderByComparator);
	}

	/**
	 * Returns the storicos before and after the current storico in the ordered set where sigla = &#63;.
	 *
	 * @param id the primary key of the current storico
	 * @param sigla the sigla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next storico
	 * @throws NoSuchStoricoException if a storico with the primary key could not be found
	 */
	public static Storico[] findBySigla_PrevAndNext(
			long id, String sigla, OrderByComparator<Storico> orderByComparator)
		throws it.eng.previsioni.meteo.exception.NoSuchStoricoException {

		return getPersistence().findBySigla_PrevAndNext(
			id, sigla, orderByComparator);
	}

	/**
	 * Removes all the storicos where sigla = &#63; from the database.
	 *
	 * @param sigla the sigla
	 */
	public static void removeBySigla(String sigla) {
		getPersistence().removeBySigla(sigla);
	}

	/**
	 * Returns the number of storicos where sigla = &#63;.
	 *
	 * @param sigla the sigla
	 * @return the number of matching storicos
	 */
	public static int countBySigla(String sigla) {
		return getPersistence().countBySigla(sigla);
	}

	/**
	 * Caches the storico in the entity cache if it is enabled.
	 *
	 * @param storico the storico
	 */
	public static void cacheResult(Storico storico) {
		getPersistence().cacheResult(storico);
	}

	/**
	 * Caches the storicos in the entity cache if it is enabled.
	 *
	 * @param storicos the storicos
	 */
	public static void cacheResult(List<Storico> storicos) {
		getPersistence().cacheResult(storicos);
	}

	/**
	 * Creates a new storico with the primary key. Does not add the storico to the database.
	 *
	 * @param id the primary key for the new storico
	 * @return the new storico
	 */
	public static Storico create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the storico with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the storico
	 * @return the storico that was removed
	 * @throws NoSuchStoricoException if a storico with the primary key could not be found
	 */
	public static Storico remove(long id)
		throws it.eng.previsioni.meteo.exception.NoSuchStoricoException {

		return getPersistence().remove(id);
	}

	public static Storico updateImpl(Storico storico) {
		return getPersistence().updateImpl(storico);
	}

	/**
	 * Returns the storico with the primary key or throws a <code>NoSuchStoricoException</code> if it could not be found.
	 *
	 * @param id the primary key of the storico
	 * @return the storico
	 * @throws NoSuchStoricoException if a storico with the primary key could not be found
	 */
	public static Storico findByPrimaryKey(long id)
		throws it.eng.previsioni.meteo.exception.NoSuchStoricoException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the storico with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the storico
	 * @return the storico, or <code>null</code> if a storico with the primary key could not be found
	 */
	public static Storico fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the storicos.
	 *
	 * @return the storicos
	 */
	public static List<Storico> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the storicos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StoricoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of storicos
	 * @param end the upper bound of the range of storicos (not inclusive)
	 * @return the range of storicos
	 */
	public static List<Storico> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the storicos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StoricoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of storicos
	 * @param end the upper bound of the range of storicos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of storicos
	 */
	public static List<Storico> findAll(
		int start, int end, OrderByComparator<Storico> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the storicos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StoricoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of storicos
	 * @param end the upper bound of the range of storicos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of storicos
	 */
	public static List<Storico> findAll(
		int start, int end, OrderByComparator<Storico> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the storicos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of storicos.
	 *
	 * @return the number of storicos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static StoricoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StoricoPersistence, StoricoPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(StoricoPersistence.class);

		ServiceTracker<StoricoPersistence, StoricoPersistence> serviceTracker =
			new ServiceTracker<StoricoPersistence, StoricoPersistence>(
				bundle.getBundleContext(), StoricoPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}