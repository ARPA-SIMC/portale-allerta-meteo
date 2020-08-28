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

import it.eng.animazione.image.model.PioggiaCumulativa;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the pioggia cumulativa service. This utility wraps <code>it.eng.animazione.image.service.persistence.impl.PioggiaCumulativaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author UTENTE
 * @see PioggiaCumulativaPersistence
 * @generated
 */
@ProviderType
public class PioggiaCumulativaUtil {

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
	public static void clearCache(PioggiaCumulativa pioggiaCumulativa) {
		getPersistence().clearCache(pioggiaCumulativa);
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
	public static Map<Serializable, PioggiaCumulativa> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PioggiaCumulativa> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PioggiaCumulativa> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PioggiaCumulativa> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PioggiaCumulativa> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PioggiaCumulativa update(
		PioggiaCumulativa pioggiaCumulativa) {

		return getPersistence().update(pioggiaCumulativa);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PioggiaCumulativa update(
		PioggiaCumulativa pioggiaCumulativa, ServiceContext serviceContext) {

		return getPersistence().update(pioggiaCumulativa, serviceContext);
	}

	/**
	 * Returns all the pioggia cumulativas where cumulazione = &#63;.
	 *
	 * @param cumulazione the cumulazione
	 * @return the matching pioggia cumulativas
	 */
	public static List<PioggiaCumulativa> findByCumulazione(
		String cumulazione) {

		return getPersistence().findByCumulazione(cumulazione);
	}

	/**
	 * Returns a range of all the pioggia cumulativas where cumulazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PioggiaCumulativaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cumulazione the cumulazione
	 * @param start the lower bound of the range of pioggia cumulativas
	 * @param end the upper bound of the range of pioggia cumulativas (not inclusive)
	 * @return the range of matching pioggia cumulativas
	 */
	public static List<PioggiaCumulativa> findByCumulazione(
		String cumulazione, int start, int end) {

		return getPersistence().findByCumulazione(cumulazione, start, end);
	}

	/**
	 * Returns an ordered range of all the pioggia cumulativas where cumulazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PioggiaCumulativaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cumulazione the cumulazione
	 * @param start the lower bound of the range of pioggia cumulativas
	 * @param end the upper bound of the range of pioggia cumulativas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pioggia cumulativas
	 */
	public static List<PioggiaCumulativa> findByCumulazione(
		String cumulazione, int start, int end,
		OrderByComparator<PioggiaCumulativa> orderByComparator) {

		return getPersistence().findByCumulazione(
			cumulazione, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pioggia cumulativas where cumulazione = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PioggiaCumulativaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cumulazione the cumulazione
	 * @param start the lower bound of the range of pioggia cumulativas
	 * @param end the upper bound of the range of pioggia cumulativas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching pioggia cumulativas
	 */
	public static List<PioggiaCumulativa> findByCumulazione(
		String cumulazione, int start, int end,
		OrderByComparator<PioggiaCumulativa> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByCumulazione(
			cumulazione, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first pioggia cumulativa in the ordered set where cumulazione = &#63;.
	 *
	 * @param cumulazione the cumulazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pioggia cumulativa
	 * @throws NoSuchPioggiaCumulativaException if a matching pioggia cumulativa could not be found
	 */
	public static PioggiaCumulativa findByCumulazione_First(
			String cumulazione,
			OrderByComparator<PioggiaCumulativa> orderByComparator)
		throws it.eng.animazione.image.exception.
			NoSuchPioggiaCumulativaException {

		return getPersistence().findByCumulazione_First(
			cumulazione, orderByComparator);
	}

	/**
	 * Returns the first pioggia cumulativa in the ordered set where cumulazione = &#63;.
	 *
	 * @param cumulazione the cumulazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pioggia cumulativa, or <code>null</code> if a matching pioggia cumulativa could not be found
	 */
	public static PioggiaCumulativa fetchByCumulazione_First(
		String cumulazione,
		OrderByComparator<PioggiaCumulativa> orderByComparator) {

		return getPersistence().fetchByCumulazione_First(
			cumulazione, orderByComparator);
	}

	/**
	 * Returns the last pioggia cumulativa in the ordered set where cumulazione = &#63;.
	 *
	 * @param cumulazione the cumulazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pioggia cumulativa
	 * @throws NoSuchPioggiaCumulativaException if a matching pioggia cumulativa could not be found
	 */
	public static PioggiaCumulativa findByCumulazione_Last(
			String cumulazione,
			OrderByComparator<PioggiaCumulativa> orderByComparator)
		throws it.eng.animazione.image.exception.
			NoSuchPioggiaCumulativaException {

		return getPersistence().findByCumulazione_Last(
			cumulazione, orderByComparator);
	}

	/**
	 * Returns the last pioggia cumulativa in the ordered set where cumulazione = &#63;.
	 *
	 * @param cumulazione the cumulazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pioggia cumulativa, or <code>null</code> if a matching pioggia cumulativa could not be found
	 */
	public static PioggiaCumulativa fetchByCumulazione_Last(
		String cumulazione,
		OrderByComparator<PioggiaCumulativa> orderByComparator) {

		return getPersistence().fetchByCumulazione_Last(
			cumulazione, orderByComparator);
	}

	/**
	 * Returns the pioggia cumulativas before and after the current pioggia cumulativa in the ordered set where cumulazione = &#63;.
	 *
	 * @param id the primary key of the current pioggia cumulativa
	 * @param cumulazione the cumulazione
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pioggia cumulativa
	 * @throws NoSuchPioggiaCumulativaException if a pioggia cumulativa with the primary key could not be found
	 */
	public static PioggiaCumulativa[] findByCumulazione_PrevAndNext(
			long id, String cumulazione,
			OrderByComparator<PioggiaCumulativa> orderByComparator)
		throws it.eng.animazione.image.exception.
			NoSuchPioggiaCumulativaException {

		return getPersistence().findByCumulazione_PrevAndNext(
			id, cumulazione, orderByComparator);
	}

	/**
	 * Removes all the pioggia cumulativas where cumulazione = &#63; from the database.
	 *
	 * @param cumulazione the cumulazione
	 */
	public static void removeByCumulazione(String cumulazione) {
		getPersistence().removeByCumulazione(cumulazione);
	}

	/**
	 * Returns the number of pioggia cumulativas where cumulazione = &#63;.
	 *
	 * @param cumulazione the cumulazione
	 * @return the number of matching pioggia cumulativas
	 */
	public static int countByCumulazione(String cumulazione) {
		return getPersistence().countByCumulazione(cumulazione);
	}

	/**
	 * Caches the pioggia cumulativa in the entity cache if it is enabled.
	 *
	 * @param pioggiaCumulativa the pioggia cumulativa
	 */
	public static void cacheResult(PioggiaCumulativa pioggiaCumulativa) {
		getPersistence().cacheResult(pioggiaCumulativa);
	}

	/**
	 * Caches the pioggia cumulativas in the entity cache if it is enabled.
	 *
	 * @param pioggiaCumulativas the pioggia cumulativas
	 */
	public static void cacheResult(List<PioggiaCumulativa> pioggiaCumulativas) {
		getPersistence().cacheResult(pioggiaCumulativas);
	}

	/**
	 * Creates a new pioggia cumulativa with the primary key. Does not add the pioggia cumulativa to the database.
	 *
	 * @param id the primary key for the new pioggia cumulativa
	 * @return the new pioggia cumulativa
	 */
	public static PioggiaCumulativa create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the pioggia cumulativa with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the pioggia cumulativa
	 * @return the pioggia cumulativa that was removed
	 * @throws NoSuchPioggiaCumulativaException if a pioggia cumulativa with the primary key could not be found
	 */
	public static PioggiaCumulativa remove(long id)
		throws it.eng.animazione.image.exception.
			NoSuchPioggiaCumulativaException {

		return getPersistence().remove(id);
	}

	public static PioggiaCumulativa updateImpl(
		PioggiaCumulativa pioggiaCumulativa) {

		return getPersistence().updateImpl(pioggiaCumulativa);
	}

	/**
	 * Returns the pioggia cumulativa with the primary key or throws a <code>NoSuchPioggiaCumulativaException</code> if it could not be found.
	 *
	 * @param id the primary key of the pioggia cumulativa
	 * @return the pioggia cumulativa
	 * @throws NoSuchPioggiaCumulativaException if a pioggia cumulativa with the primary key could not be found
	 */
	public static PioggiaCumulativa findByPrimaryKey(long id)
		throws it.eng.animazione.image.exception.
			NoSuchPioggiaCumulativaException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the pioggia cumulativa with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the pioggia cumulativa
	 * @return the pioggia cumulativa, or <code>null</code> if a pioggia cumulativa with the primary key could not be found
	 */
	public static PioggiaCumulativa fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the pioggia cumulativas.
	 *
	 * @return the pioggia cumulativas
	 */
	public static List<PioggiaCumulativa> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the pioggia cumulativas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PioggiaCumulativaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pioggia cumulativas
	 * @param end the upper bound of the range of pioggia cumulativas (not inclusive)
	 * @return the range of pioggia cumulativas
	 */
	public static List<PioggiaCumulativa> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the pioggia cumulativas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PioggiaCumulativaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pioggia cumulativas
	 * @param end the upper bound of the range of pioggia cumulativas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pioggia cumulativas
	 */
	public static List<PioggiaCumulativa> findAll(
		int start, int end,
		OrderByComparator<PioggiaCumulativa> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pioggia cumulativas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PioggiaCumulativaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pioggia cumulativas
	 * @param end the upper bound of the range of pioggia cumulativas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of pioggia cumulativas
	 */
	public static List<PioggiaCumulativa> findAll(
		int start, int end,
		OrderByComparator<PioggiaCumulativa> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the pioggia cumulativas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of pioggia cumulativas.
	 *
	 * @return the number of pioggia cumulativas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static PioggiaCumulativaPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PioggiaCumulativaPersistence, PioggiaCumulativaPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			PioggiaCumulativaPersistence.class);

		ServiceTracker
			<PioggiaCumulativaPersistence, PioggiaCumulativaPersistence>
				serviceTracker =
					new ServiceTracker
						<PioggiaCumulativaPersistence,
						 PioggiaCumulativaPersistence>(
							 bundle.getBundleContext(),
							 PioggiaCumulativaPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}