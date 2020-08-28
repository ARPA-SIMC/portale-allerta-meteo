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

package it.eng.allerter.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.allerter.model.Geografia;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the geografia service. This utility wraps <code>it.eng.allerter.service.persistence.impl.GeografiaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author GFAVINI
 * @see GeografiaPersistence
 * @generated
 */
@ProviderType
public class GeografiaUtil {

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
	public static void clearCache(Geografia geografia) {
		getPersistence().clearCache(geografia);
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
	public static Map<Serializable, Geografia> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Geografia> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Geografia> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Geografia> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Geografia> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Geografia update(Geografia geografia) {
		return getPersistence().update(geografia);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Geografia update(
		Geografia geografia, ServiceContext serviceContext) {

		return getPersistence().update(geografia, serviceContext);
	}

	/**
	 * Returns all the geografias where tipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @return the matching geografias
	 */
	public static List<Geografia> findByTipo(String tipo) {
		return getPersistence().findByTipo(tipo);
	}

	/**
	 * Returns a range of all the geografias where tipo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @return the range of matching geografias
	 */
	public static List<Geografia> findByTipo(String tipo, int start, int end) {
		return getPersistence().findByTipo(tipo, start, end);
	}

	/**
	 * Returns an ordered range of all the geografias where tipo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching geografias
	 */
	public static List<Geografia> findByTipo(
		String tipo, int start, int end,
		OrderByComparator<Geografia> orderByComparator) {

		return getPersistence().findByTipo(tipo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the geografias where tipo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching geografias
	 */
	public static List<Geografia> findByTipo(
		String tipo, int start, int end,
		OrderByComparator<Geografia> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByTipo(
			tipo, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first geografia in the ordered set where tipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	public static Geografia findByTipo_First(
			String tipo, OrderByComparator<Geografia> orderByComparator)
		throws it.eng.allerter.exception.NoSuchGeografiaException {

		return getPersistence().findByTipo_First(tipo, orderByComparator);
	}

	/**
	 * Returns the first geografia in the ordered set where tipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	public static Geografia fetchByTipo_First(
		String tipo, OrderByComparator<Geografia> orderByComparator) {

		return getPersistence().fetchByTipo_First(tipo, orderByComparator);
	}

	/**
	 * Returns the last geografia in the ordered set where tipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	public static Geografia findByTipo_Last(
			String tipo, OrderByComparator<Geografia> orderByComparator)
		throws it.eng.allerter.exception.NoSuchGeografiaException {

		return getPersistence().findByTipo_Last(tipo, orderByComparator);
	}

	/**
	 * Returns the last geografia in the ordered set where tipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	public static Geografia fetchByTipo_Last(
		String tipo, OrderByComparator<Geografia> orderByComparator) {

		return getPersistence().fetchByTipo_Last(tipo, orderByComparator);
	}

	/**
	 * Returns the geografias before and after the current geografia in the ordered set where tipo = &#63;.
	 *
	 * @param geografiaPK the primary key of the current geografia
	 * @param tipo the tipo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next geografia
	 * @throws NoSuchGeografiaException if a geografia with the primary key could not be found
	 */
	public static Geografia[] findByTipo_PrevAndNext(
			it.eng.allerter.service.persistence.GeografiaPK geografiaPK,
			String tipo, OrderByComparator<Geografia> orderByComparator)
		throws it.eng.allerter.exception.NoSuchGeografiaException {

		return getPersistence().findByTipo_PrevAndNext(
			geografiaPK, tipo, orderByComparator);
	}

	/**
	 * Removes all the geografias where tipo = &#63; from the database.
	 *
	 * @param tipo the tipo
	 */
	public static void removeByTipo(String tipo) {
		getPersistence().removeByTipo(tipo);
	}

	/**
	 * Returns the number of geografias where tipo = &#63;.
	 *
	 * @param tipo the tipo
	 * @return the number of matching geografias
	 */
	public static int countByTipo(String tipo) {
		return getPersistence().countByTipo(tipo);
	}

	/**
	 * Returns all the geografias where tipo = &#63; and area = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @return the matching geografias
	 */
	public static List<Geografia> findByTipoArea(String tipo, String area) {
		return getPersistence().findByTipoArea(tipo, area);
	}

	/**
	 * Returns a range of all the geografias where tipo = &#63; and area = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @return the range of matching geografias
	 */
	public static List<Geografia> findByTipoArea(
		String tipo, String area, int start, int end) {

		return getPersistence().findByTipoArea(tipo, area, start, end);
	}

	/**
	 * Returns an ordered range of all the geografias where tipo = &#63; and area = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching geografias
	 */
	public static List<Geografia> findByTipoArea(
		String tipo, String area, int start, int end,
		OrderByComparator<Geografia> orderByComparator) {

		return getPersistence().findByTipoArea(
			tipo, area, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the geografias where tipo = &#63; and area = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching geografias
	 */
	public static List<Geografia> findByTipoArea(
		String tipo, String area, int start, int end,
		OrderByComparator<Geografia> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByTipoArea(
			tipo, area, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first geografia in the ordered set where tipo = &#63; and area = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	public static Geografia findByTipoArea_First(
			String tipo, String area,
			OrderByComparator<Geografia> orderByComparator)
		throws it.eng.allerter.exception.NoSuchGeografiaException {

		return getPersistence().findByTipoArea_First(
			tipo, area, orderByComparator);
	}

	/**
	 * Returns the first geografia in the ordered set where tipo = &#63; and area = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	public static Geografia fetchByTipoArea_First(
		String tipo, String area,
		OrderByComparator<Geografia> orderByComparator) {

		return getPersistence().fetchByTipoArea_First(
			tipo, area, orderByComparator);
	}

	/**
	 * Returns the last geografia in the ordered set where tipo = &#63; and area = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	public static Geografia findByTipoArea_Last(
			String tipo, String area,
			OrderByComparator<Geografia> orderByComparator)
		throws it.eng.allerter.exception.NoSuchGeografiaException {

		return getPersistence().findByTipoArea_Last(
			tipo, area, orderByComparator);
	}

	/**
	 * Returns the last geografia in the ordered set where tipo = &#63; and area = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	public static Geografia fetchByTipoArea_Last(
		String tipo, String area,
		OrderByComparator<Geografia> orderByComparator) {

		return getPersistence().fetchByTipoArea_Last(
			tipo, area, orderByComparator);
	}

	/**
	 * Returns the geografias before and after the current geografia in the ordered set where tipo = &#63; and area = &#63;.
	 *
	 * @param geografiaPK the primary key of the current geografia
	 * @param tipo the tipo
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next geografia
	 * @throws NoSuchGeografiaException if a geografia with the primary key could not be found
	 */
	public static Geografia[] findByTipoArea_PrevAndNext(
			it.eng.allerter.service.persistence.GeografiaPK geografiaPK,
			String tipo, String area,
			OrderByComparator<Geografia> orderByComparator)
		throws it.eng.allerter.exception.NoSuchGeografiaException {

		return getPersistence().findByTipoArea_PrevAndNext(
			geografiaPK, tipo, area, orderByComparator);
	}

	/**
	 * Removes all the geografias where tipo = &#63; and area = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 */
	public static void removeByTipoArea(String tipo, String area) {
		getPersistence().removeByTipoArea(tipo, area);
	}

	/**
	 * Returns the number of geografias where tipo = &#63; and area = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @return the number of matching geografias
	 */
	public static int countByTipoArea(String tipo, String area) {
		return getPersistence().countByTipoArea(tipo, area);
	}

	/**
	 * Returns all the geografias where tipo = &#63; and area = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param complessita the complessita
	 * @return the matching geografias
	 */
	public static List<Geografia> findByTipoAreaComplessita(
		String tipo, String area, String complessita) {

		return getPersistence().findByTipoAreaComplessita(
			tipo, area, complessita);
	}

	/**
	 * Returns a range of all the geografias where tipo = &#63; and area = &#63; and complessita = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param complessita the complessita
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @return the range of matching geografias
	 */
	public static List<Geografia> findByTipoAreaComplessita(
		String tipo, String area, String complessita, int start, int end) {

		return getPersistence().findByTipoAreaComplessita(
			tipo, area, complessita, start, end);
	}

	/**
	 * Returns an ordered range of all the geografias where tipo = &#63; and area = &#63; and complessita = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param complessita the complessita
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching geografias
	 */
	public static List<Geografia> findByTipoAreaComplessita(
		String tipo, String area, String complessita, int start, int end,
		OrderByComparator<Geografia> orderByComparator) {

		return getPersistence().findByTipoAreaComplessita(
			tipo, area, complessita, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the geografias where tipo = &#63; and area = &#63; and complessita = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param complessita the complessita
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching geografias
	 */
	public static List<Geografia> findByTipoAreaComplessita(
		String tipo, String area, String complessita, int start, int end,
		OrderByComparator<Geografia> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByTipoAreaComplessita(
			tipo, area, complessita, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first geografia in the ordered set where tipo = &#63; and area = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	public static Geografia findByTipoAreaComplessita_First(
			String tipo, String area, String complessita,
			OrderByComparator<Geografia> orderByComparator)
		throws it.eng.allerter.exception.NoSuchGeografiaException {

		return getPersistence().findByTipoAreaComplessita_First(
			tipo, area, complessita, orderByComparator);
	}

	/**
	 * Returns the first geografia in the ordered set where tipo = &#63; and area = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	public static Geografia fetchByTipoAreaComplessita_First(
		String tipo, String area, String complessita,
		OrderByComparator<Geografia> orderByComparator) {

		return getPersistence().fetchByTipoAreaComplessita_First(
			tipo, area, complessita, orderByComparator);
	}

	/**
	 * Returns the last geografia in the ordered set where tipo = &#63; and area = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	public static Geografia findByTipoAreaComplessita_Last(
			String tipo, String area, String complessita,
			OrderByComparator<Geografia> orderByComparator)
		throws it.eng.allerter.exception.NoSuchGeografiaException {

		return getPersistence().findByTipoAreaComplessita_Last(
			tipo, area, complessita, orderByComparator);
	}

	/**
	 * Returns the last geografia in the ordered set where tipo = &#63; and area = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	public static Geografia fetchByTipoAreaComplessita_Last(
		String tipo, String area, String complessita,
		OrderByComparator<Geografia> orderByComparator) {

		return getPersistence().fetchByTipoAreaComplessita_Last(
			tipo, area, complessita, orderByComparator);
	}

	/**
	 * Returns the geografias before and after the current geografia in the ordered set where tipo = &#63; and area = &#63; and complessita = &#63;.
	 *
	 * @param geografiaPK the primary key of the current geografia
	 * @param tipo the tipo
	 * @param area the area
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next geografia
	 * @throws NoSuchGeografiaException if a geografia with the primary key could not be found
	 */
	public static Geografia[] findByTipoAreaComplessita_PrevAndNext(
			it.eng.allerter.service.persistence.GeografiaPK geografiaPK,
			String tipo, String area, String complessita,
			OrderByComparator<Geografia> orderByComparator)
		throws it.eng.allerter.exception.NoSuchGeografiaException {

		return getPersistence().findByTipoAreaComplessita_PrevAndNext(
			geografiaPK, tipo, area, complessita, orderByComparator);
	}

	/**
	 * Removes all the geografias where tipo = &#63; and area = &#63; and complessita = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param complessita the complessita
	 */
	public static void removeByTipoAreaComplessita(
		String tipo, String area, String complessita) {

		getPersistence().removeByTipoAreaComplessita(tipo, area, complessita);
	}

	/**
	 * Returns the number of geografias where tipo = &#63; and area = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param area the area
	 * @param complessita the complessita
	 * @return the number of matching geografias
	 */
	public static int countByTipoAreaComplessita(
		String tipo, String area, String complessita) {

		return getPersistence().countByTipoAreaComplessita(
			tipo, area, complessita);
	}

	/**
	 * Returns all the geografias where tipo = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param complessita the complessita
	 * @return the matching geografias
	 */
	public static List<Geografia> findByTipoComplessita(
		String tipo, String complessita) {

		return getPersistence().findByTipoComplessita(tipo, complessita);
	}

	/**
	 * Returns a range of all the geografias where tipo = &#63; and complessita = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param complessita the complessita
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @return the range of matching geografias
	 */
	public static List<Geografia> findByTipoComplessita(
		String tipo, String complessita, int start, int end) {

		return getPersistence().findByTipoComplessita(
			tipo, complessita, start, end);
	}

	/**
	 * Returns an ordered range of all the geografias where tipo = &#63; and complessita = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param complessita the complessita
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching geografias
	 */
	public static List<Geografia> findByTipoComplessita(
		String tipo, String complessita, int start, int end,
		OrderByComparator<Geografia> orderByComparator) {

		return getPersistence().findByTipoComplessita(
			tipo, complessita, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the geografias where tipo = &#63; and complessita = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tipo the tipo
	 * @param complessita the complessita
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching geografias
	 */
	public static List<Geografia> findByTipoComplessita(
		String tipo, String complessita, int start, int end,
		OrderByComparator<Geografia> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByTipoComplessita(
			tipo, complessita, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first geografia in the ordered set where tipo = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	public static Geografia findByTipoComplessita_First(
			String tipo, String complessita,
			OrderByComparator<Geografia> orderByComparator)
		throws it.eng.allerter.exception.NoSuchGeografiaException {

		return getPersistence().findByTipoComplessita_First(
			tipo, complessita, orderByComparator);
	}

	/**
	 * Returns the first geografia in the ordered set where tipo = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	public static Geografia fetchByTipoComplessita_First(
		String tipo, String complessita,
		OrderByComparator<Geografia> orderByComparator) {

		return getPersistence().fetchByTipoComplessita_First(
			tipo, complessita, orderByComparator);
	}

	/**
	 * Returns the last geografia in the ordered set where tipo = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	public static Geografia findByTipoComplessita_Last(
			String tipo, String complessita,
			OrderByComparator<Geografia> orderByComparator)
		throws it.eng.allerter.exception.NoSuchGeografiaException {

		return getPersistence().findByTipoComplessita_Last(
			tipo, complessita, orderByComparator);
	}

	/**
	 * Returns the last geografia in the ordered set where tipo = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	public static Geografia fetchByTipoComplessita_Last(
		String tipo, String complessita,
		OrderByComparator<Geografia> orderByComparator) {

		return getPersistence().fetchByTipoComplessita_Last(
			tipo, complessita, orderByComparator);
	}

	/**
	 * Returns the geografias before and after the current geografia in the ordered set where tipo = &#63; and complessita = &#63;.
	 *
	 * @param geografiaPK the primary key of the current geografia
	 * @param tipo the tipo
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next geografia
	 * @throws NoSuchGeografiaException if a geografia with the primary key could not be found
	 */
	public static Geografia[] findByTipoComplessita_PrevAndNext(
			it.eng.allerter.service.persistence.GeografiaPK geografiaPK,
			String tipo, String complessita,
			OrderByComparator<Geografia> orderByComparator)
		throws it.eng.allerter.exception.NoSuchGeografiaException {

		return getPersistence().findByTipoComplessita_PrevAndNext(
			geografiaPK, tipo, complessita, orderByComparator);
	}

	/**
	 * Removes all the geografias where tipo = &#63; and complessita = &#63; from the database.
	 *
	 * @param tipo the tipo
	 * @param complessita the complessita
	 */
	public static void removeByTipoComplessita(
		String tipo, String complessita) {

		getPersistence().removeByTipoComplessita(tipo, complessita);
	}

	/**
	 * Returns the number of geografias where tipo = &#63; and complessita = &#63;.
	 *
	 * @param tipo the tipo
	 * @param complessita the complessita
	 * @return the number of matching geografias
	 */
	public static int countByTipoComplessita(String tipo, String complessita) {
		return getPersistence().countByTipoComplessita(tipo, complessita);
	}

	/**
	 * Returns all the geografias where geografiaId = &#63; and complessita = &#63;.
	 *
	 * @param geografiaId the geografia ID
	 * @param complessita the complessita
	 * @return the matching geografias
	 */
	public static List<Geografia> findByIdComplessita(
		String geografiaId, String complessita) {

		return getPersistence().findByIdComplessita(geografiaId, complessita);
	}

	/**
	 * Returns a range of all the geografias where geografiaId = &#63; and complessita = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param geografiaId the geografia ID
	 * @param complessita the complessita
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @return the range of matching geografias
	 */
	public static List<Geografia> findByIdComplessita(
		String geografiaId, String complessita, int start, int end) {

		return getPersistence().findByIdComplessita(
			geografiaId, complessita, start, end);
	}

	/**
	 * Returns an ordered range of all the geografias where geografiaId = &#63; and complessita = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param geografiaId the geografia ID
	 * @param complessita the complessita
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching geografias
	 */
	public static List<Geografia> findByIdComplessita(
		String geografiaId, String complessita, int start, int end,
		OrderByComparator<Geografia> orderByComparator) {

		return getPersistence().findByIdComplessita(
			geografiaId, complessita, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the geografias where geografiaId = &#63; and complessita = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param geografiaId the geografia ID
	 * @param complessita the complessita
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching geografias
	 */
	public static List<Geografia> findByIdComplessita(
		String geografiaId, String complessita, int start, int end,
		OrderByComparator<Geografia> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByIdComplessita(
			geografiaId, complessita, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first geografia in the ordered set where geografiaId = &#63; and complessita = &#63;.
	 *
	 * @param geografiaId the geografia ID
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	public static Geografia findByIdComplessita_First(
			String geografiaId, String complessita,
			OrderByComparator<Geografia> orderByComparator)
		throws it.eng.allerter.exception.NoSuchGeografiaException {

		return getPersistence().findByIdComplessita_First(
			geografiaId, complessita, orderByComparator);
	}

	/**
	 * Returns the first geografia in the ordered set where geografiaId = &#63; and complessita = &#63;.
	 *
	 * @param geografiaId the geografia ID
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	public static Geografia fetchByIdComplessita_First(
		String geografiaId, String complessita,
		OrderByComparator<Geografia> orderByComparator) {

		return getPersistence().fetchByIdComplessita_First(
			geografiaId, complessita, orderByComparator);
	}

	/**
	 * Returns the last geografia in the ordered set where geografiaId = &#63; and complessita = &#63;.
	 *
	 * @param geografiaId the geografia ID
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	public static Geografia findByIdComplessita_Last(
			String geografiaId, String complessita,
			OrderByComparator<Geografia> orderByComparator)
		throws it.eng.allerter.exception.NoSuchGeografiaException {

		return getPersistence().findByIdComplessita_Last(
			geografiaId, complessita, orderByComparator);
	}

	/**
	 * Returns the last geografia in the ordered set where geografiaId = &#63; and complessita = &#63;.
	 *
	 * @param geografiaId the geografia ID
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	public static Geografia fetchByIdComplessita_Last(
		String geografiaId, String complessita,
		OrderByComparator<Geografia> orderByComparator) {

		return getPersistence().fetchByIdComplessita_Last(
			geografiaId, complessita, orderByComparator);
	}

	/**
	 * Returns the geografias before and after the current geografia in the ordered set where geografiaId = &#63; and complessita = &#63;.
	 *
	 * @param geografiaPK the primary key of the current geografia
	 * @param geografiaId the geografia ID
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next geografia
	 * @throws NoSuchGeografiaException if a geografia with the primary key could not be found
	 */
	public static Geografia[] findByIdComplessita_PrevAndNext(
			it.eng.allerter.service.persistence.GeografiaPK geografiaPK,
			String geografiaId, String complessita,
			OrderByComparator<Geografia> orderByComparator)
		throws it.eng.allerter.exception.NoSuchGeografiaException {

		return getPersistence().findByIdComplessita_PrevAndNext(
			geografiaPK, geografiaId, complessita, orderByComparator);
	}

	/**
	 * Removes all the geografias where geografiaId = &#63; and complessita = &#63; from the database.
	 *
	 * @param geografiaId the geografia ID
	 * @param complessita the complessita
	 */
	public static void removeByIdComplessita(
		String geografiaId, String complessita) {

		getPersistence().removeByIdComplessita(geografiaId, complessita);
	}

	/**
	 * Returns the number of geografias where geografiaId = &#63; and complessita = &#63;.
	 *
	 * @param geografiaId the geografia ID
	 * @param complessita the complessita
	 * @return the number of matching geografias
	 */
	public static int countByIdComplessita(
		String geografiaId, String complessita) {

		return getPersistence().countByIdComplessita(geografiaId, complessita);
	}

	/**
	 * Returns all the geografias where area = &#63; and complessita = &#63;.
	 *
	 * @param area the area
	 * @param complessita the complessita
	 * @return the matching geografias
	 */
	public static List<Geografia> findByAreaComplessita(
		String area, String complessita) {

		return getPersistence().findByAreaComplessita(area, complessita);
	}

	/**
	 * Returns a range of all the geografias where area = &#63; and complessita = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param area the area
	 * @param complessita the complessita
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @return the range of matching geografias
	 */
	public static List<Geografia> findByAreaComplessita(
		String area, String complessita, int start, int end) {

		return getPersistence().findByAreaComplessita(
			area, complessita, start, end);
	}

	/**
	 * Returns an ordered range of all the geografias where area = &#63; and complessita = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param area the area
	 * @param complessita the complessita
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching geografias
	 */
	public static List<Geografia> findByAreaComplessita(
		String area, String complessita, int start, int end,
		OrderByComparator<Geografia> orderByComparator) {

		return getPersistence().findByAreaComplessita(
			area, complessita, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the geografias where area = &#63; and complessita = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param area the area
	 * @param complessita the complessita
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching geografias
	 */
	public static List<Geografia> findByAreaComplessita(
		String area, String complessita, int start, int end,
		OrderByComparator<Geografia> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByAreaComplessita(
			area, complessita, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first geografia in the ordered set where area = &#63; and complessita = &#63;.
	 *
	 * @param area the area
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	public static Geografia findByAreaComplessita_First(
			String area, String complessita,
			OrderByComparator<Geografia> orderByComparator)
		throws it.eng.allerter.exception.NoSuchGeografiaException {

		return getPersistence().findByAreaComplessita_First(
			area, complessita, orderByComparator);
	}

	/**
	 * Returns the first geografia in the ordered set where area = &#63; and complessita = &#63;.
	 *
	 * @param area the area
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	public static Geografia fetchByAreaComplessita_First(
		String area, String complessita,
		OrderByComparator<Geografia> orderByComparator) {

		return getPersistence().fetchByAreaComplessita_First(
			area, complessita, orderByComparator);
	}

	/**
	 * Returns the last geografia in the ordered set where area = &#63; and complessita = &#63;.
	 *
	 * @param area the area
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia
	 * @throws NoSuchGeografiaException if a matching geografia could not be found
	 */
	public static Geografia findByAreaComplessita_Last(
			String area, String complessita,
			OrderByComparator<Geografia> orderByComparator)
		throws it.eng.allerter.exception.NoSuchGeografiaException {

		return getPersistence().findByAreaComplessita_Last(
			area, complessita, orderByComparator);
	}

	/**
	 * Returns the last geografia in the ordered set where area = &#63; and complessita = &#63;.
	 *
	 * @param area the area
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geografia, or <code>null</code> if a matching geografia could not be found
	 */
	public static Geografia fetchByAreaComplessita_Last(
		String area, String complessita,
		OrderByComparator<Geografia> orderByComparator) {

		return getPersistence().fetchByAreaComplessita_Last(
			area, complessita, orderByComparator);
	}

	/**
	 * Returns the geografias before and after the current geografia in the ordered set where area = &#63; and complessita = &#63;.
	 *
	 * @param geografiaPK the primary key of the current geografia
	 * @param area the area
	 * @param complessita the complessita
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next geografia
	 * @throws NoSuchGeografiaException if a geografia with the primary key could not be found
	 */
	public static Geografia[] findByAreaComplessita_PrevAndNext(
			it.eng.allerter.service.persistence.GeografiaPK geografiaPK,
			String area, String complessita,
			OrderByComparator<Geografia> orderByComparator)
		throws it.eng.allerter.exception.NoSuchGeografiaException {

		return getPersistence().findByAreaComplessita_PrevAndNext(
			geografiaPK, area, complessita, orderByComparator);
	}

	/**
	 * Removes all the geografias where area = &#63; and complessita = &#63; from the database.
	 *
	 * @param area the area
	 * @param complessita the complessita
	 */
	public static void removeByAreaComplessita(
		String area, String complessita) {

		getPersistence().removeByAreaComplessita(area, complessita);
	}

	/**
	 * Returns the number of geografias where area = &#63; and complessita = &#63;.
	 *
	 * @param area the area
	 * @param complessita the complessita
	 * @return the number of matching geografias
	 */
	public static int countByAreaComplessita(String area, String complessita) {
		return getPersistence().countByAreaComplessita(area, complessita);
	}

	/**
	 * Caches the geografia in the entity cache if it is enabled.
	 *
	 * @param geografia the geografia
	 */
	public static void cacheResult(Geografia geografia) {
		getPersistence().cacheResult(geografia);
	}

	/**
	 * Caches the geografias in the entity cache if it is enabled.
	 *
	 * @param geografias the geografias
	 */
	public static void cacheResult(List<Geografia> geografias) {
		getPersistence().cacheResult(geografias);
	}

	/**
	 * Creates a new geografia with the primary key. Does not add the geografia to the database.
	 *
	 * @param geografiaPK the primary key for the new geografia
	 * @return the new geografia
	 */
	public static Geografia create(
		it.eng.allerter.service.persistence.GeografiaPK geografiaPK) {

		return getPersistence().create(geografiaPK);
	}

	/**
	 * Removes the geografia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param geografiaPK the primary key of the geografia
	 * @return the geografia that was removed
	 * @throws NoSuchGeografiaException if a geografia with the primary key could not be found
	 */
	public static Geografia remove(
			it.eng.allerter.service.persistence.GeografiaPK geografiaPK)
		throws it.eng.allerter.exception.NoSuchGeografiaException {

		return getPersistence().remove(geografiaPK);
	}

	public static Geografia updateImpl(Geografia geografia) {
		return getPersistence().updateImpl(geografia);
	}

	/**
	 * Returns the geografia with the primary key or throws a <code>NoSuchGeografiaException</code> if it could not be found.
	 *
	 * @param geografiaPK the primary key of the geografia
	 * @return the geografia
	 * @throws NoSuchGeografiaException if a geografia with the primary key could not be found
	 */
	public static Geografia findByPrimaryKey(
			it.eng.allerter.service.persistence.GeografiaPK geografiaPK)
		throws it.eng.allerter.exception.NoSuchGeografiaException {

		return getPersistence().findByPrimaryKey(geografiaPK);
	}

	/**
	 * Returns the geografia with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param geografiaPK the primary key of the geografia
	 * @return the geografia, or <code>null</code> if a geografia with the primary key could not be found
	 */
	public static Geografia fetchByPrimaryKey(
		it.eng.allerter.service.persistence.GeografiaPK geografiaPK) {

		return getPersistence().fetchByPrimaryKey(geografiaPK);
	}

	/**
	 * Returns all the geografias.
	 *
	 * @return the geografias
	 */
	public static List<Geografia> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the geografias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @return the range of geografias
	 */
	public static List<Geografia> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the geografias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of geografias
	 */
	public static List<Geografia> findAll(
		int start, int end, OrderByComparator<Geografia> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the geografias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of geografias
	 */
	public static List<Geografia> findAll(
		int start, int end, OrderByComparator<Geografia> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the geografias from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of geografias.
	 *
	 * @return the number of geografias
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static GeografiaPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<GeografiaPersistence, GeografiaPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(GeografiaPersistence.class);

		ServiceTracker<GeografiaPersistence, GeografiaPersistence>
			serviceTracker =
				new ServiceTracker<GeografiaPersistence, GeografiaPersistence>(
					bundle.getBundleContext(), GeografiaPersistence.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}