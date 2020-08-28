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

package it.eng.radarMeteo.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Comuni_bacini_ws. This utility wraps
 * <code>it.eng.radarMeteo.service.impl.Comuni_bacini_wsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Francesco
 * @see Comuni_bacini_wsLocalService
 * @generated
 */
@ProviderType
public class Comuni_bacini_wsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.radarMeteo.service.impl.Comuni_bacini_wsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the comuni_bacini_ws to the database. Also notifies the appropriate model listeners.
	 *
	 * @param comuni_bacini_ws the comuni_bacini_ws
	 * @return the comuni_bacini_ws that was added
	 */
	public static it.eng.radarMeteo.model.Comuni_bacini_ws addComuni_bacini_ws(
		it.eng.radarMeteo.model.Comuni_bacini_ws comuni_bacini_ws) {

		return getService().addComuni_bacini_ws(comuni_bacini_ws);
	}

	/**
	 * Creates a new comuni_bacini_ws with the primary key. Does not add the comuni_bacini_ws to the database.
	 *
	 * @param idBacini the primary key for the new comuni_bacini_ws
	 * @return the new comuni_bacini_ws
	 */
	public static it.eng.radarMeteo.model.Comuni_bacini_ws
		createComuni_bacini_ws(int idBacini) {

		return getService().createComuni_bacini_ws(idBacini);
	}

	/**
	 * Deletes the comuni_bacini_ws from the database. Also notifies the appropriate model listeners.
	 *
	 * @param comuni_bacini_ws the comuni_bacini_ws
	 * @return the comuni_bacini_ws that was removed
	 */
	public static it.eng.radarMeteo.model.Comuni_bacini_ws
		deleteComuni_bacini_ws(
			it.eng.radarMeteo.model.Comuni_bacini_ws comuni_bacini_ws) {

		return getService().deleteComuni_bacini_ws(comuni_bacini_ws);
	}

	/**
	 * Deletes the comuni_bacini_ws with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idBacini the primary key of the comuni_bacini_ws
	 * @return the comuni_bacini_ws that was removed
	 * @throws PortalException if a comuni_bacini_ws with the primary key could not be found
	 */
	public static it.eng.radarMeteo.model.Comuni_bacini_ws
			deleteComuni_bacini_ws(int idBacini)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteComuni_bacini_ws(idBacini);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.radarMeteo.model.impl.Comuni_bacini_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.radarMeteo.model.impl.Comuni_bacini_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.eng.radarMeteo.model.Comuni_bacini_ws
		fetchComuni_bacini_ws(int idBacini) {

		return getService().fetchComuni_bacini_ws(idBacini);
	}

	public static java.util.List<it.eng.radarMeteo.model.Comuni_bacini_ws>
		findByBacino(String bacino) {

		return getService().findByBacino(bacino);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the comuni_bacini_ws with the primary key.
	 *
	 * @param idBacini the primary key of the comuni_bacini_ws
	 * @return the comuni_bacini_ws
	 * @throws PortalException if a comuni_bacini_ws with the primary key could not be found
	 */
	public static it.eng.radarMeteo.model.Comuni_bacini_ws getComuni_bacini_ws(
			int idBacini)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getComuni_bacini_ws(idBacini);
	}

	/**
	 * Returns a range of all the comuni_bacini_wses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.radarMeteo.model.impl.Comuni_bacini_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of comuni_bacini_wses
	 * @param end the upper bound of the range of comuni_bacini_wses (not inclusive)
	 * @return the range of comuni_bacini_wses
	 */
	public static java.util.List<it.eng.radarMeteo.model.Comuni_bacini_ws>
		getComuni_bacini_wses(int start, int end) {

		return getService().getComuni_bacini_wses(start, end);
	}

	/**
	 * Returns the number of comuni_bacini_wses.
	 *
	 * @return the number of comuni_bacini_wses
	 */
	public static int getComuni_bacini_wsesCount() {
		return getService().getComuni_bacini_wsesCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
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
	 * Updates the comuni_bacini_ws in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param comuni_bacini_ws the comuni_bacini_ws
	 * @return the comuni_bacini_ws that was updated
	 */
	public static it.eng.radarMeteo.model.Comuni_bacini_ws
		updateComuni_bacini_ws(
			it.eng.radarMeteo.model.Comuni_bacini_ws comuni_bacini_ws) {

		return getService().updateComuni_bacini_ws(comuni_bacini_ws);
	}

	public static Comuni_bacini_wsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<Comuni_bacini_wsLocalService, Comuni_bacini_wsLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			Comuni_bacini_wsLocalService.class);

		ServiceTracker
			<Comuni_bacini_wsLocalService, Comuni_bacini_wsLocalService>
				serviceTracker =
					new ServiceTracker
						<Comuni_bacini_wsLocalService,
						 Comuni_bacini_wsLocalService>(
							 bundle.getBundleContext(),
							 Comuni_bacini_wsLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}