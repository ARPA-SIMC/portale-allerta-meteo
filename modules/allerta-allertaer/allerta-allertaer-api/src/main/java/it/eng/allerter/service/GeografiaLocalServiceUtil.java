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

package it.eng.allerter.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Geografia. This utility wraps
 * <code>it.eng.allerter.service.impl.GeografiaLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author GFAVINI
 * @see GeografiaLocalService
 * @generated
 */
@ProviderType
public class GeografiaLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.allerter.service.impl.GeografiaLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the geografia to the database. Also notifies the appropriate model listeners.
	 *
	 * @param geografia the geografia
	 * @return the geografia that was added
	 */
	public static it.eng.allerter.model.Geografia addGeografia(
		it.eng.allerter.model.Geografia geografia) {

		return getService().addGeografia(geografia);
	}

	/**
	 * Creates a new geografia with the primary key. Does not add the geografia to the database.
	 *
	 * @param geografiaPK the primary key for the new geografia
	 * @return the new geografia
	 */
	public static it.eng.allerter.model.Geografia createGeografia(
		it.eng.allerter.service.persistence.GeografiaPK geografiaPK) {

		return getService().createGeografia(geografiaPK);
	}

	/**
	 * Deletes the geografia from the database. Also notifies the appropriate model listeners.
	 *
	 * @param geografia the geografia
	 * @return the geografia that was removed
	 */
	public static it.eng.allerter.model.Geografia deleteGeografia(
		it.eng.allerter.model.Geografia geografia) {

		return getService().deleteGeografia(geografia);
	}

	/**
	 * Deletes the geografia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param geografiaPK the primary key of the geografia
	 * @return the geografia that was removed
	 * @throws PortalException if a geografia with the primary key could not be found
	 */
	public static it.eng.allerter.model.Geografia deleteGeografia(
			it.eng.allerter.service.persistence.GeografiaPK geografiaPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteGeografia(geografiaPK);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static it.eng.allerter.model.Geografia fetchGeografia(
		it.eng.allerter.service.persistence.GeografiaPK geografiaPK) {

		return getService().fetchGeografia(geografiaPK);
	}

	public static java.util.List<it.eng.allerter.model.Geografia>
		findByAreaComplessita(String area, String compl) {

		return getService().findByAreaComplessita(area, compl);
	}

	public static java.util.List<it.eng.allerter.model.Geografia>
		findByIdComplessita(String id, String compl) {

		return getService().findByIdComplessita(id, compl);
	}

	/**
	 * Returns the geografia with the primary key.
	 *
	 * @param geografiaPK the primary key of the geografia
	 * @return the geografia
	 * @throws PortalException if a geografia with the primary key could not be found
	 */
	public static it.eng.allerter.model.Geografia getGeografia(
			it.eng.allerter.service.persistence.GeografiaPK geografiaPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getGeografia(geografiaPK);
	}

	/**
	 * Returns a range of all the geografias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @return the range of geografias
	 */
	public static java.util.List<it.eng.allerter.model.Geografia> getGeografias(
		int start, int end) {

		return getService().getGeografias(start, end);
	}

	/**
	 * Returns the number of geografias.
	 *
	 * @return the number of geografias
	 */
	public static int getGeografiasCount() {
		return getService().getGeografiasCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the geografia in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param geografia the geografia
	 * @return the geografia that was updated
	 */
	public static it.eng.allerter.model.Geografia updateGeografia(
		it.eng.allerter.model.Geografia geografia) {

		return getService().updateGeografia(geografia);
	}

	public static GeografiaLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<GeografiaLocalService, GeografiaLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(GeografiaLocalService.class);

		ServiceTracker<GeografiaLocalService, GeografiaLocalService>
			serviceTracker =
				new ServiceTracker
					<GeografiaLocalService, GeografiaLocalService>(
						bundle.getBundleContext(), GeografiaLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}