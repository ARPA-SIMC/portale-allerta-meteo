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

package allerta.catasto.service.persistence;

import aQute.bnd.annotation.ProviderType;

import allerta.catasto.model.Fonte;

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
 * The persistence utility for the fonte service. This utility wraps <code>allerta.catasto.service.persistence.impl.FontePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FontePersistence
 * @generated
 */
@ProviderType
public class FonteUtil {

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
	public static void clearCache(Fonte fonte) {
		getPersistence().clearCache(fonte);
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
	public static Map<Serializable, Fonte> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Fonte> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Fonte> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Fonte> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Fonte> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Fonte update(Fonte fonte) {
		return getPersistence().update(fonte);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Fonte update(Fonte fonte, ServiceContext serviceContext) {
		return getPersistence().update(fonte, serviceContext);
	}

	/**
	 * Caches the fonte in the entity cache if it is enabled.
	 *
	 * @param fonte the fonte
	 */
	public static void cacheResult(Fonte fonte) {
		getPersistence().cacheResult(fonte);
	}

	/**
	 * Caches the fontes in the entity cache if it is enabled.
	 *
	 * @param fontes the fontes
	 */
	public static void cacheResult(List<Fonte> fontes) {
		getPersistence().cacheResult(fontes);
	}

	/**
	 * Creates a new fonte with the primary key. Does not add the fonte to the database.
	 *
	 * @param id the primary key for the new fonte
	 * @return the new fonte
	 */
	public static Fonte create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the fonte with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the fonte
	 * @return the fonte that was removed
	 * @throws NoSuchFonteException if a fonte with the primary key could not be found
	 */
	public static Fonte remove(long id)
		throws allerta.catasto.exception.NoSuchFonteException {

		return getPersistence().remove(id);
	}

	public static Fonte updateImpl(Fonte fonte) {
		return getPersistence().updateImpl(fonte);
	}

	/**
	 * Returns the fonte with the primary key or throws a <code>NoSuchFonteException</code> if it could not be found.
	 *
	 * @param id the primary key of the fonte
	 * @return the fonte
	 * @throws NoSuchFonteException if a fonte with the primary key could not be found
	 */
	public static Fonte findByPrimaryKey(long id)
		throws allerta.catasto.exception.NoSuchFonteException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the fonte with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the fonte
	 * @return the fonte, or <code>null</code> if a fonte with the primary key could not be found
	 */
	public static Fonte fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the fontes.
	 *
	 * @return the fontes
	 */
	public static List<Fonte> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the fontes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FonteModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fontes
	 * @param end the upper bound of the range of fontes (not inclusive)
	 * @return the range of fontes
	 */
	public static List<Fonte> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the fontes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FonteModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fontes
	 * @param end the upper bound of the range of fontes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fontes
	 */
	public static List<Fonte> findAll(
		int start, int end, OrderByComparator<Fonte> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the fontes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FonteModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fontes
	 * @param end the upper bound of the range of fontes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of fontes
	 */
	public static List<Fonte> findAll(
		int start, int end, OrderByComparator<Fonte> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the fontes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of fontes.
	 *
	 * @return the number of fontes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static FontePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FontePersistence, FontePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(FontePersistence.class);

		ServiceTracker<FontePersistence, FontePersistence> serviceTracker =
			new ServiceTracker<FontePersistence, FontePersistence>(
				bundle.getBundleContext(), FontePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}