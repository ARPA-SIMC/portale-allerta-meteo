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

package it.eng.allerta.messages.services.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.allerta.messages.services.model.CounterSms;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the counter sms service. This utility wraps <code>it.eng.allerta.messages.services.service.persistence.impl.CounterSmsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Giorgianni_F
 * @see CounterSmsPersistence
 * @generated
 */
@ProviderType
public class CounterSmsUtil {

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
	public static void clearCache(CounterSms counterSms) {
		getPersistence().clearCache(counterSms);
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
	public static Map<Serializable, CounterSms> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CounterSms> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CounterSms> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CounterSms> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CounterSms> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CounterSms update(CounterSms counterSms) {
		return getPersistence().update(counterSms);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CounterSms update(
		CounterSms counterSms, ServiceContext serviceContext) {

		return getPersistence().update(counterSms, serviceContext);
	}

	/**
	 * Returns the counter sms where date = &#63; or throws a <code>NoSuchCounterSmsException</code> if it could not be found.
	 *
	 * @param date the date
	 * @return the matching counter sms
	 * @throws NoSuchCounterSmsException if a matching counter sms could not be found
	 */
	public static CounterSms findBydata(Date date)
		throws it.eng.allerta.messages.services.exception.
			NoSuchCounterSmsException {

		return getPersistence().findBydata(date);
	}

	/**
	 * Returns the counter sms where date = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param date the date
	 * @return the matching counter sms, or <code>null</code> if a matching counter sms could not be found
	 */
	public static CounterSms fetchBydata(Date date) {
		return getPersistence().fetchBydata(date);
	}

	/**
	 * Returns the counter sms where date = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param date the date
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching counter sms, or <code>null</code> if a matching counter sms could not be found
	 */
	public static CounterSms fetchBydata(Date date, boolean retrieveFromCache) {
		return getPersistence().fetchBydata(date, retrieveFromCache);
	}

	/**
	 * Removes the counter sms where date = &#63; from the database.
	 *
	 * @param date the date
	 * @return the counter sms that was removed
	 */
	public static CounterSms removeBydata(Date date)
		throws it.eng.allerta.messages.services.exception.
			NoSuchCounterSmsException {

		return getPersistence().removeBydata(date);
	}

	/**
	 * Returns the number of counter smses where date = &#63;.
	 *
	 * @param date the date
	 * @return the number of matching counter smses
	 */
	public static int countBydata(Date date) {
		return getPersistence().countBydata(date);
	}

	/**
	 * Returns all the counter smses where date &gt; &#63;.
	 *
	 * @param date the date
	 * @return the matching counter smses
	 */
	public static List<CounterSms> findBydataGreather(Date date) {
		return getPersistence().findBydataGreather(date);
	}

	/**
	 * Returns a range of all the counter smses where date &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CounterSmsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param date the date
	 * @param start the lower bound of the range of counter smses
	 * @param end the upper bound of the range of counter smses (not inclusive)
	 * @return the range of matching counter smses
	 */
	public static List<CounterSms> findBydataGreather(
		Date date, int start, int end) {

		return getPersistence().findBydataGreather(date, start, end);
	}

	/**
	 * Returns an ordered range of all the counter smses where date &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CounterSmsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param date the date
	 * @param start the lower bound of the range of counter smses
	 * @param end the upper bound of the range of counter smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching counter smses
	 */
	public static List<CounterSms> findBydataGreather(
		Date date, int start, int end,
		OrderByComparator<CounterSms> orderByComparator) {

		return getPersistence().findBydataGreather(
			date, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the counter smses where date &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CounterSmsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param date the date
	 * @param start the lower bound of the range of counter smses
	 * @param end the upper bound of the range of counter smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching counter smses
	 */
	public static List<CounterSms> findBydataGreather(
		Date date, int start, int end,
		OrderByComparator<CounterSms> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findBydataGreather(
			date, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first counter sms in the ordered set where date &gt; &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching counter sms
	 * @throws NoSuchCounterSmsException if a matching counter sms could not be found
	 */
	public static CounterSms findBydataGreather_First(
			Date date, OrderByComparator<CounterSms> orderByComparator)
		throws it.eng.allerta.messages.services.exception.
			NoSuchCounterSmsException {

		return getPersistence().findBydataGreather_First(
			date, orderByComparator);
	}

	/**
	 * Returns the first counter sms in the ordered set where date &gt; &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching counter sms, or <code>null</code> if a matching counter sms could not be found
	 */
	public static CounterSms fetchBydataGreather_First(
		Date date, OrderByComparator<CounterSms> orderByComparator) {

		return getPersistence().fetchBydataGreather_First(
			date, orderByComparator);
	}

	/**
	 * Returns the last counter sms in the ordered set where date &gt; &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching counter sms
	 * @throws NoSuchCounterSmsException if a matching counter sms could not be found
	 */
	public static CounterSms findBydataGreather_Last(
			Date date, OrderByComparator<CounterSms> orderByComparator)
		throws it.eng.allerta.messages.services.exception.
			NoSuchCounterSmsException {

		return getPersistence().findBydataGreather_Last(
			date, orderByComparator);
	}

	/**
	 * Returns the last counter sms in the ordered set where date &gt; &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching counter sms, or <code>null</code> if a matching counter sms could not be found
	 */
	public static CounterSms fetchBydataGreather_Last(
		Date date, OrderByComparator<CounterSms> orderByComparator) {

		return getPersistence().fetchBydataGreather_Last(
			date, orderByComparator);
	}

	/**
	 * Returns the counter smses before and after the current counter sms in the ordered set where date &gt; &#63;.
	 *
	 * @param counterId the primary key of the current counter sms
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next counter sms
	 * @throws NoSuchCounterSmsException if a counter sms with the primary key could not be found
	 */
	public static CounterSms[] findBydataGreather_PrevAndNext(
			long counterId, Date date,
			OrderByComparator<CounterSms> orderByComparator)
		throws it.eng.allerta.messages.services.exception.
			NoSuchCounterSmsException {

		return getPersistence().findBydataGreather_PrevAndNext(
			counterId, date, orderByComparator);
	}

	/**
	 * Removes all the counter smses where date &gt; &#63; from the database.
	 *
	 * @param date the date
	 */
	public static void removeBydataGreather(Date date) {
		getPersistence().removeBydataGreather(date);
	}

	/**
	 * Returns the number of counter smses where date &gt; &#63;.
	 *
	 * @param date the date
	 * @return the number of matching counter smses
	 */
	public static int countBydataGreather(Date date) {
		return getPersistence().countBydataGreather(date);
	}

	/**
	 * Returns all the counter smses where date = &#63; and nodo = &#63;.
	 *
	 * @param date the date
	 * @param nodo the nodo
	 * @return the matching counter smses
	 */
	public static List<CounterSms> findBydataAndNodo(Date date, String nodo) {
		return getPersistence().findBydataAndNodo(date, nodo);
	}

	/**
	 * Returns a range of all the counter smses where date = &#63; and nodo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CounterSmsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param date the date
	 * @param nodo the nodo
	 * @param start the lower bound of the range of counter smses
	 * @param end the upper bound of the range of counter smses (not inclusive)
	 * @return the range of matching counter smses
	 */
	public static List<CounterSms> findBydataAndNodo(
		Date date, String nodo, int start, int end) {

		return getPersistence().findBydataAndNodo(date, nodo, start, end);
	}

	/**
	 * Returns an ordered range of all the counter smses where date = &#63; and nodo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CounterSmsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param date the date
	 * @param nodo the nodo
	 * @param start the lower bound of the range of counter smses
	 * @param end the upper bound of the range of counter smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching counter smses
	 */
	public static List<CounterSms> findBydataAndNodo(
		Date date, String nodo, int start, int end,
		OrderByComparator<CounterSms> orderByComparator) {

		return getPersistence().findBydataAndNodo(
			date, nodo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the counter smses where date = &#63; and nodo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CounterSmsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param date the date
	 * @param nodo the nodo
	 * @param start the lower bound of the range of counter smses
	 * @param end the upper bound of the range of counter smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching counter smses
	 */
	public static List<CounterSms> findBydataAndNodo(
		Date date, String nodo, int start, int end,
		OrderByComparator<CounterSms> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findBydataAndNodo(
			date, nodo, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first counter sms in the ordered set where date = &#63; and nodo = &#63;.
	 *
	 * @param date the date
	 * @param nodo the nodo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching counter sms
	 * @throws NoSuchCounterSmsException if a matching counter sms could not be found
	 */
	public static CounterSms findBydataAndNodo_First(
			Date date, String nodo,
			OrderByComparator<CounterSms> orderByComparator)
		throws it.eng.allerta.messages.services.exception.
			NoSuchCounterSmsException {

		return getPersistence().findBydataAndNodo_First(
			date, nodo, orderByComparator);
	}

	/**
	 * Returns the first counter sms in the ordered set where date = &#63; and nodo = &#63;.
	 *
	 * @param date the date
	 * @param nodo the nodo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching counter sms, or <code>null</code> if a matching counter sms could not be found
	 */
	public static CounterSms fetchBydataAndNodo_First(
		Date date, String nodo,
		OrderByComparator<CounterSms> orderByComparator) {

		return getPersistence().fetchBydataAndNodo_First(
			date, nodo, orderByComparator);
	}

	/**
	 * Returns the last counter sms in the ordered set where date = &#63; and nodo = &#63;.
	 *
	 * @param date the date
	 * @param nodo the nodo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching counter sms
	 * @throws NoSuchCounterSmsException if a matching counter sms could not be found
	 */
	public static CounterSms findBydataAndNodo_Last(
			Date date, String nodo,
			OrderByComparator<CounterSms> orderByComparator)
		throws it.eng.allerta.messages.services.exception.
			NoSuchCounterSmsException {

		return getPersistence().findBydataAndNodo_Last(
			date, nodo, orderByComparator);
	}

	/**
	 * Returns the last counter sms in the ordered set where date = &#63; and nodo = &#63;.
	 *
	 * @param date the date
	 * @param nodo the nodo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching counter sms, or <code>null</code> if a matching counter sms could not be found
	 */
	public static CounterSms fetchBydataAndNodo_Last(
		Date date, String nodo,
		OrderByComparator<CounterSms> orderByComparator) {

		return getPersistence().fetchBydataAndNodo_Last(
			date, nodo, orderByComparator);
	}

	/**
	 * Returns the counter smses before and after the current counter sms in the ordered set where date = &#63; and nodo = &#63;.
	 *
	 * @param counterId the primary key of the current counter sms
	 * @param date the date
	 * @param nodo the nodo
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next counter sms
	 * @throws NoSuchCounterSmsException if a counter sms with the primary key could not be found
	 */
	public static CounterSms[] findBydataAndNodo_PrevAndNext(
			long counterId, Date date, String nodo,
			OrderByComparator<CounterSms> orderByComparator)
		throws it.eng.allerta.messages.services.exception.
			NoSuchCounterSmsException {

		return getPersistence().findBydataAndNodo_PrevAndNext(
			counterId, date, nodo, orderByComparator);
	}

	/**
	 * Removes all the counter smses where date = &#63; and nodo = &#63; from the database.
	 *
	 * @param date the date
	 * @param nodo the nodo
	 */
	public static void removeBydataAndNodo(Date date, String nodo) {
		getPersistence().removeBydataAndNodo(date, nodo);
	}

	/**
	 * Returns the number of counter smses where date = &#63; and nodo = &#63;.
	 *
	 * @param date the date
	 * @param nodo the nodo
	 * @return the number of matching counter smses
	 */
	public static int countBydataAndNodo(Date date, String nodo) {
		return getPersistence().countBydataAndNodo(date, nodo);
	}

	/**
	 * Caches the counter sms in the entity cache if it is enabled.
	 *
	 * @param counterSms the counter sms
	 */
	public static void cacheResult(CounterSms counterSms) {
		getPersistence().cacheResult(counterSms);
	}

	/**
	 * Caches the counter smses in the entity cache if it is enabled.
	 *
	 * @param counterSmses the counter smses
	 */
	public static void cacheResult(List<CounterSms> counterSmses) {
		getPersistence().cacheResult(counterSmses);
	}

	/**
	 * Creates a new counter sms with the primary key. Does not add the counter sms to the database.
	 *
	 * @param counterId the primary key for the new counter sms
	 * @return the new counter sms
	 */
	public static CounterSms create(long counterId) {
		return getPersistence().create(counterId);
	}

	/**
	 * Removes the counter sms with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param counterId the primary key of the counter sms
	 * @return the counter sms that was removed
	 * @throws NoSuchCounterSmsException if a counter sms with the primary key could not be found
	 */
	public static CounterSms remove(long counterId)
		throws it.eng.allerta.messages.services.exception.
			NoSuchCounterSmsException {

		return getPersistence().remove(counterId);
	}

	public static CounterSms updateImpl(CounterSms counterSms) {
		return getPersistence().updateImpl(counterSms);
	}

	/**
	 * Returns the counter sms with the primary key or throws a <code>NoSuchCounterSmsException</code> if it could not be found.
	 *
	 * @param counterId the primary key of the counter sms
	 * @return the counter sms
	 * @throws NoSuchCounterSmsException if a counter sms with the primary key could not be found
	 */
	public static CounterSms findByPrimaryKey(long counterId)
		throws it.eng.allerta.messages.services.exception.
			NoSuchCounterSmsException {

		return getPersistence().findByPrimaryKey(counterId);
	}

	/**
	 * Returns the counter sms with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param counterId the primary key of the counter sms
	 * @return the counter sms, or <code>null</code> if a counter sms with the primary key could not be found
	 */
	public static CounterSms fetchByPrimaryKey(long counterId) {
		return getPersistence().fetchByPrimaryKey(counterId);
	}

	/**
	 * Returns all the counter smses.
	 *
	 * @return the counter smses
	 */
	public static List<CounterSms> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the counter smses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CounterSmsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of counter smses
	 * @param end the upper bound of the range of counter smses (not inclusive)
	 * @return the range of counter smses
	 */
	public static List<CounterSms> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the counter smses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CounterSmsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of counter smses
	 * @param end the upper bound of the range of counter smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of counter smses
	 */
	public static List<CounterSms> findAll(
		int start, int end, OrderByComparator<CounterSms> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the counter smses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CounterSmsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of counter smses
	 * @param end the upper bound of the range of counter smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of counter smses
	 */
	public static List<CounterSms> findAll(
		int start, int end, OrderByComparator<CounterSms> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the counter smses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of counter smses.
	 *
	 * @return the number of counter smses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static CounterSmsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CounterSmsPersistence, CounterSmsPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CounterSmsPersistence.class);

		ServiceTracker<CounterSmsPersistence, CounterSmsPersistence>
			serviceTracker =
				new ServiceTracker
					<CounterSmsPersistence, CounterSmsPersistence>(
						bundle.getBundleContext(), CounterSmsPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}