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

package it.eng.radarMeteo.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.radarMeteo.model.Comuni_ws;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the comuni_ws service. This utility wraps <code>it.eng.radarMeteo.service.persistence.impl.Comuni_wsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Francesco
 * @see Comuni_wsPersistence
 * @generated
 */
@ProviderType
public class Comuni_wsUtil {

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
	public static void clearCache(Comuni_ws comuni_ws) {
		getPersistence().clearCache(comuni_ws);
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
	public static Map<Serializable, Comuni_ws> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Comuni_ws> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Comuni_ws> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Comuni_ws> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Comuni_ws> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Comuni_ws update(Comuni_ws comuni_ws) {
		return getPersistence().update(comuni_ws);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Comuni_ws update(
		Comuni_ws comuni_ws, ServiceContext serviceContext) {

		return getPersistence().update(comuni_ws, serviceContext);
	}

	/**
	 * Returns all the comuni_wses where sottozona = &#63;.
	 *
	 * @param sottozona the sottozona
	 * @return the matching comuni_wses
	 */
	public static List<Comuni_ws> findBySottozona(String sottozona) {
		return getPersistence().findBySottozona(sottozona);
	}

	/**
	 * Returns a range of all the comuni_wses where sottozona = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Comuni_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sottozona the sottozona
	 * @param start the lower bound of the range of comuni_wses
	 * @param end the upper bound of the range of comuni_wses (not inclusive)
	 * @return the range of matching comuni_wses
	 */
	public static List<Comuni_ws> findBySottozona(
		String sottozona, int start, int end) {

		return getPersistence().findBySottozona(sottozona, start, end);
	}

	/**
	 * Returns an ordered range of all the comuni_wses where sottozona = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Comuni_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sottozona the sottozona
	 * @param start the lower bound of the range of comuni_wses
	 * @param end the upper bound of the range of comuni_wses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comuni_wses
	 */
	public static List<Comuni_ws> findBySottozona(
		String sottozona, int start, int end,
		OrderByComparator<Comuni_ws> orderByComparator) {

		return getPersistence().findBySottozona(
			sottozona, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comuni_wses where sottozona = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Comuni_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sottozona the sottozona
	 * @param start the lower bound of the range of comuni_wses
	 * @param end the upper bound of the range of comuni_wses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching comuni_wses
	 */
	public static List<Comuni_ws> findBySottozona(
		String sottozona, int start, int end,
		OrderByComparator<Comuni_ws> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findBySottozona(
			sottozona, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first comuni_ws in the ordered set where sottozona = &#63;.
	 *
	 * @param sottozona the sottozona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comuni_ws
	 * @throws NoSuchComuni_wsException if a matching comuni_ws could not be found
	 */
	public static Comuni_ws findBySottozona_First(
			String sottozona, OrderByComparator<Comuni_ws> orderByComparator)
		throws it.eng.radarMeteo.exception.NoSuchComuni_wsException {

		return getPersistence().findBySottozona_First(
			sottozona, orderByComparator);
	}

	/**
	 * Returns the first comuni_ws in the ordered set where sottozona = &#63;.
	 *
	 * @param sottozona the sottozona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comuni_ws, or <code>null</code> if a matching comuni_ws could not be found
	 */
	public static Comuni_ws fetchBySottozona_First(
		String sottozona, OrderByComparator<Comuni_ws> orderByComparator) {

		return getPersistence().fetchBySottozona_First(
			sottozona, orderByComparator);
	}

	/**
	 * Returns the last comuni_ws in the ordered set where sottozona = &#63;.
	 *
	 * @param sottozona the sottozona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comuni_ws
	 * @throws NoSuchComuni_wsException if a matching comuni_ws could not be found
	 */
	public static Comuni_ws findBySottozona_Last(
			String sottozona, OrderByComparator<Comuni_ws> orderByComparator)
		throws it.eng.radarMeteo.exception.NoSuchComuni_wsException {

		return getPersistence().findBySottozona_Last(
			sottozona, orderByComparator);
	}

	/**
	 * Returns the last comuni_ws in the ordered set where sottozona = &#63;.
	 *
	 * @param sottozona the sottozona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comuni_ws, or <code>null</code> if a matching comuni_ws could not be found
	 */
	public static Comuni_ws fetchBySottozona_Last(
		String sottozona, OrderByComparator<Comuni_ws> orderByComparator) {

		return getPersistence().fetchBySottozona_Last(
			sottozona, orderByComparator);
	}

	/**
	 * Returns the comuni_wses before and after the current comuni_ws in the ordered set where sottozona = &#63;.
	 *
	 * @param idIstat the primary key of the current comuni_ws
	 * @param sottozona the sottozona
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comuni_ws
	 * @throws NoSuchComuni_wsException if a comuni_ws with the primary key could not be found
	 */
	public static Comuni_ws[] findBySottozona_PrevAndNext(
			String idIstat, String sottozona,
			OrderByComparator<Comuni_ws> orderByComparator)
		throws it.eng.radarMeteo.exception.NoSuchComuni_wsException {

		return getPersistence().findBySottozona_PrevAndNext(
			idIstat, sottozona, orderByComparator);
	}

	/**
	 * Removes all the comuni_wses where sottozona = &#63; from the database.
	 *
	 * @param sottozona the sottozona
	 */
	public static void removeBySottozona(String sottozona) {
		getPersistence().removeBySottozona(sottozona);
	}

	/**
	 * Returns the number of comuni_wses where sottozona = &#63;.
	 *
	 * @param sottozona the sottozona
	 * @return the number of matching comuni_wses
	 */
	public static int countBySottozona(String sottozona) {
		return getPersistence().countBySottozona(sottozona);
	}

	/**
	 * Returns all the comuni_wses where zonaallerta = &#63;.
	 *
	 * @param zonaallerta the zonaallerta
	 * @return the matching comuni_wses
	 */
	public static List<Comuni_ws> findByZonaallerta(String zonaallerta) {
		return getPersistence().findByZonaallerta(zonaallerta);
	}

	/**
	 * Returns a range of all the comuni_wses where zonaallerta = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Comuni_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param zonaallerta the zonaallerta
	 * @param start the lower bound of the range of comuni_wses
	 * @param end the upper bound of the range of comuni_wses (not inclusive)
	 * @return the range of matching comuni_wses
	 */
	public static List<Comuni_ws> findByZonaallerta(
		String zonaallerta, int start, int end) {

		return getPersistence().findByZonaallerta(zonaallerta, start, end);
	}

	/**
	 * Returns an ordered range of all the comuni_wses where zonaallerta = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Comuni_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param zonaallerta the zonaallerta
	 * @param start the lower bound of the range of comuni_wses
	 * @param end the upper bound of the range of comuni_wses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comuni_wses
	 */
	public static List<Comuni_ws> findByZonaallerta(
		String zonaallerta, int start, int end,
		OrderByComparator<Comuni_ws> orderByComparator) {

		return getPersistence().findByZonaallerta(
			zonaallerta, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comuni_wses where zonaallerta = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Comuni_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param zonaallerta the zonaallerta
	 * @param start the lower bound of the range of comuni_wses
	 * @param end the upper bound of the range of comuni_wses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching comuni_wses
	 */
	public static List<Comuni_ws> findByZonaallerta(
		String zonaallerta, int start, int end,
		OrderByComparator<Comuni_ws> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByZonaallerta(
			zonaallerta, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first comuni_ws in the ordered set where zonaallerta = &#63;.
	 *
	 * @param zonaallerta the zonaallerta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comuni_ws
	 * @throws NoSuchComuni_wsException if a matching comuni_ws could not be found
	 */
	public static Comuni_ws findByZonaallerta_First(
			String zonaallerta, OrderByComparator<Comuni_ws> orderByComparator)
		throws it.eng.radarMeteo.exception.NoSuchComuni_wsException {

		return getPersistence().findByZonaallerta_First(
			zonaallerta, orderByComparator);
	}

	/**
	 * Returns the first comuni_ws in the ordered set where zonaallerta = &#63;.
	 *
	 * @param zonaallerta the zonaallerta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comuni_ws, or <code>null</code> if a matching comuni_ws could not be found
	 */
	public static Comuni_ws fetchByZonaallerta_First(
		String zonaallerta, OrderByComparator<Comuni_ws> orderByComparator) {

		return getPersistence().fetchByZonaallerta_First(
			zonaallerta, orderByComparator);
	}

	/**
	 * Returns the last comuni_ws in the ordered set where zonaallerta = &#63;.
	 *
	 * @param zonaallerta the zonaallerta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comuni_ws
	 * @throws NoSuchComuni_wsException if a matching comuni_ws could not be found
	 */
	public static Comuni_ws findByZonaallerta_Last(
			String zonaallerta, OrderByComparator<Comuni_ws> orderByComparator)
		throws it.eng.radarMeteo.exception.NoSuchComuni_wsException {

		return getPersistence().findByZonaallerta_Last(
			zonaallerta, orderByComparator);
	}

	/**
	 * Returns the last comuni_ws in the ordered set where zonaallerta = &#63;.
	 *
	 * @param zonaallerta the zonaallerta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comuni_ws, or <code>null</code> if a matching comuni_ws could not be found
	 */
	public static Comuni_ws fetchByZonaallerta_Last(
		String zonaallerta, OrderByComparator<Comuni_ws> orderByComparator) {

		return getPersistence().fetchByZonaallerta_Last(
			zonaallerta, orderByComparator);
	}

	/**
	 * Returns the comuni_wses before and after the current comuni_ws in the ordered set where zonaallerta = &#63;.
	 *
	 * @param idIstat the primary key of the current comuni_ws
	 * @param zonaallerta the zonaallerta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comuni_ws
	 * @throws NoSuchComuni_wsException if a comuni_ws with the primary key could not be found
	 */
	public static Comuni_ws[] findByZonaallerta_PrevAndNext(
			String idIstat, String zonaallerta,
			OrderByComparator<Comuni_ws> orderByComparator)
		throws it.eng.radarMeteo.exception.NoSuchComuni_wsException {

		return getPersistence().findByZonaallerta_PrevAndNext(
			idIstat, zonaallerta, orderByComparator);
	}

	/**
	 * Removes all the comuni_wses where zonaallerta = &#63; from the database.
	 *
	 * @param zonaallerta the zonaallerta
	 */
	public static void removeByZonaallerta(String zonaallerta) {
		getPersistence().removeByZonaallerta(zonaallerta);
	}

	/**
	 * Returns the number of comuni_wses where zonaallerta = &#63;.
	 *
	 * @param zonaallerta the zonaallerta
	 * @return the number of matching comuni_wses
	 */
	public static int countByZonaallerta(String zonaallerta) {
		return getPersistence().countByZonaallerta(zonaallerta);
	}

	/**
	 * Caches the comuni_ws in the entity cache if it is enabled.
	 *
	 * @param comuni_ws the comuni_ws
	 */
	public static void cacheResult(Comuni_ws comuni_ws) {
		getPersistence().cacheResult(comuni_ws);
	}

	/**
	 * Caches the comuni_wses in the entity cache if it is enabled.
	 *
	 * @param comuni_wses the comuni_wses
	 */
	public static void cacheResult(List<Comuni_ws> comuni_wses) {
		getPersistence().cacheResult(comuni_wses);
	}

	/**
	 * Creates a new comuni_ws with the primary key. Does not add the comuni_ws to the database.
	 *
	 * @param idIstat the primary key for the new comuni_ws
	 * @return the new comuni_ws
	 */
	public static Comuni_ws create(String idIstat) {
		return getPersistence().create(idIstat);
	}

	/**
	 * Removes the comuni_ws with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idIstat the primary key of the comuni_ws
	 * @return the comuni_ws that was removed
	 * @throws NoSuchComuni_wsException if a comuni_ws with the primary key could not be found
	 */
	public static Comuni_ws remove(String idIstat)
		throws it.eng.radarMeteo.exception.NoSuchComuni_wsException {

		return getPersistence().remove(idIstat);
	}

	public static Comuni_ws updateImpl(Comuni_ws comuni_ws) {
		return getPersistence().updateImpl(comuni_ws);
	}

	/**
	 * Returns the comuni_ws with the primary key or throws a <code>NoSuchComuni_wsException</code> if it could not be found.
	 *
	 * @param idIstat the primary key of the comuni_ws
	 * @return the comuni_ws
	 * @throws NoSuchComuni_wsException if a comuni_ws with the primary key could not be found
	 */
	public static Comuni_ws findByPrimaryKey(String idIstat)
		throws it.eng.radarMeteo.exception.NoSuchComuni_wsException {

		return getPersistence().findByPrimaryKey(idIstat);
	}

	/**
	 * Returns the comuni_ws with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idIstat the primary key of the comuni_ws
	 * @return the comuni_ws, or <code>null</code> if a comuni_ws with the primary key could not be found
	 */
	public static Comuni_ws fetchByPrimaryKey(String idIstat) {
		return getPersistence().fetchByPrimaryKey(idIstat);
	}

	/**
	 * Returns all the comuni_wses.
	 *
	 * @return the comuni_wses
	 */
	public static List<Comuni_ws> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the comuni_wses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Comuni_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of comuni_wses
	 * @param end the upper bound of the range of comuni_wses (not inclusive)
	 * @return the range of comuni_wses
	 */
	public static List<Comuni_ws> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the comuni_wses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Comuni_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of comuni_wses
	 * @param end the upper bound of the range of comuni_wses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of comuni_wses
	 */
	public static List<Comuni_ws> findAll(
		int start, int end, OrderByComparator<Comuni_ws> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the comuni_wses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Comuni_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of comuni_wses
	 * @param end the upper bound of the range of comuni_wses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of comuni_wses
	 */
	public static List<Comuni_ws> findAll(
		int start, int end, OrderByComparator<Comuni_ws> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the comuni_wses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of comuni_wses.
	 *
	 * @return the number of comuni_wses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Comuni_wsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<Comuni_wsPersistence, Comuni_wsPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(Comuni_wsPersistence.class);

		ServiceTracker<Comuni_wsPersistence, Comuni_wsPersistence>
			serviceTracker =
				new ServiceTracker<Comuni_wsPersistence, Comuni_wsPersistence>(
					bundle.getBundleContext(), Comuni_wsPersistence.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}