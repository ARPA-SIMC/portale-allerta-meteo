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
 * Provides the local service utility for AllertaParametro. This utility wraps
 * <code>it.eng.allerter.service.impl.AllertaParametroLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author GFAVINI
 * @see AllertaParametroLocalService
 * @generated
 */
@ProviderType
public class AllertaParametroLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.allerter.service.impl.AllertaParametroLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the allerta parametro to the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaParametro the allerta parametro
	 * @return the allerta parametro that was added
	 */
	public static it.eng.allerter.model.AllertaParametro addAllertaParametro(
		it.eng.allerter.model.AllertaParametro allertaParametro) {

		return getService().addAllertaParametro(allertaParametro);
	}

	/**
	 * Creates a new allerta parametro with the primary key. Does not add the allerta parametro to the database.
	 *
	 * @param parametroId the primary key for the new allerta parametro
	 * @return the new allerta parametro
	 */
	public static it.eng.allerter.model.AllertaParametro createAllertaParametro(
		String parametroId) {

		return getService().createAllertaParametro(parametroId);
	}

	/**
	 * Deletes the allerta parametro from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaParametro the allerta parametro
	 * @return the allerta parametro that was removed
	 */
	public static it.eng.allerter.model.AllertaParametro deleteAllertaParametro(
		it.eng.allerter.model.AllertaParametro allertaParametro) {

		return getService().deleteAllertaParametro(allertaParametro);
	}

	/**
	 * Deletes the allerta parametro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param parametroId the primary key of the allerta parametro
	 * @return the allerta parametro that was removed
	 * @throws PortalException if a allerta parametro with the primary key could not be found
	 */
	public static it.eng.allerter.model.AllertaParametro deleteAllertaParametro(
			String parametroId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteAllertaParametro(parametroId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.AllertaParametroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.AllertaParametroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.eng.allerter.model.AllertaParametro fetchAllertaParametro(
		String parametroId) {

		return getService().fetchAllertaParametro(parametroId);
	}

	/**
	 * Returns the allerta parametro with the primary key.
	 *
	 * @param parametroId the primary key of the allerta parametro
	 * @return the allerta parametro
	 * @throws PortalException if a allerta parametro with the primary key could not be found
	 */
	public static it.eng.allerter.model.AllertaParametro getAllertaParametro(
			String parametroId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAllertaParametro(parametroId);
	}

	/**
	 * Returns a range of all the allerta parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.AllertaParametroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta parametros
	 * @param end the upper bound of the range of allerta parametros (not inclusive)
	 * @return the range of allerta parametros
	 */
	public static java.util.List<it.eng.allerter.model.AllertaParametro>
		getAllertaParametros(int start, int end) {

		return getService().getAllertaParametros(start, end);
	}

	/**
	 * Returns the number of allerta parametros.
	 *
	 * @return the number of allerta parametros
	 */
	public static int getAllertaParametrosCount() {
		return getService().getAllertaParametrosCount();
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
	 * Updates the allerta parametro in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param allertaParametro the allerta parametro
	 * @return the allerta parametro that was updated
	 */
	public static it.eng.allerter.model.AllertaParametro updateAllertaParametro(
		it.eng.allerter.model.AllertaParametro allertaParametro) {

		return getService().updateAllertaParametro(allertaParametro);
	}

	public static AllertaParametroLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AllertaParametroLocalService, AllertaParametroLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			AllertaParametroLocalService.class);

		ServiceTracker
			<AllertaParametroLocalService, AllertaParametroLocalService>
				serviceTracker =
					new ServiceTracker
						<AllertaParametroLocalService,
						 AllertaParametroLocalService>(
							 bundle.getBundleContext(),
							 AllertaParametroLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}