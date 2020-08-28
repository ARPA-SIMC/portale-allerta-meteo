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

package it.eng.bollettino.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Idrometro. This utility wraps
 * <code>it.eng.bollettino.service.impl.IdrometroLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author GFAVINI
 * @see IdrometroLocalService
 * @generated
 */
@ProviderType
public class IdrometroLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.bollettino.service.impl.IdrometroLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the idrometro to the database. Also notifies the appropriate model listeners.
	 *
	 * @param idrometro the idrometro
	 * @return the idrometro that was added
	 */
	public static it.eng.bollettino.model.Idrometro addIdrometro(
		it.eng.bollettino.model.Idrometro idrometro) {

		return getService().addIdrometro(idrometro);
	}

	/**
	 * Creates a new idrometro with the primary key. Does not add the idrometro to the database.
	 *
	 * @param stazioneId the primary key for the new idrometro
	 * @return the new idrometro
	 */
	public static it.eng.bollettino.model.Idrometro createIdrometro(
		String stazioneId) {

		return getService().createIdrometro(stazioneId);
	}

	/**
	 * Deletes the idrometro from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idrometro the idrometro
	 * @return the idrometro that was removed
	 */
	public static it.eng.bollettino.model.Idrometro deleteIdrometro(
		it.eng.bollettino.model.Idrometro idrometro) {

		return getService().deleteIdrometro(idrometro);
	}

	/**
	 * Deletes the idrometro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stazioneId the primary key of the idrometro
	 * @return the idrometro that was removed
	 * @throws PortalException if a idrometro with the primary key could not be found
	 */
	public static it.eng.bollettino.model.Idrometro deleteIdrometro(
			String stazioneId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteIdrometro(stazioneId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.eng.bollettino.model.Idrometro fetchIdrometro(
		String stazioneId) {

		return getService().fetchIdrometro(stazioneId);
	}

	/**
	 * Returns the idrometro with the primary key.
	 *
	 * @param stazioneId the primary key of the idrometro
	 * @return the idrometro
	 * @throws PortalException if a idrometro with the primary key could not be found
	 */
	public static it.eng.bollettino.model.Idrometro getIdrometro(
			String stazioneId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getIdrometro(stazioneId);
	}

	/**
	 * Returns a range of all the idrometros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.IdrometroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of idrometros
	 * @param end the upper bound of the range of idrometros (not inclusive)
	 * @return the range of idrometros
	 */
	public static java.util.List<it.eng.bollettino.model.Idrometro>
		getIdrometros(int start, int end) {

		return getService().getIdrometros(start, end);
	}

	/**
	 * Returns the number of idrometros.
	 *
	 * @return the number of idrometros
	 */
	public static int getIdrometrosCount() {
		return getService().getIdrometrosCount();
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
	 * Updates the idrometro in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param idrometro the idrometro
	 * @return the idrometro that was updated
	 */
	public static it.eng.bollettino.model.Idrometro updateIdrometro(
		it.eng.bollettino.model.Idrometro idrometro) {

		return getService().updateIdrometro(idrometro);
	}

	public static IdrometroLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<IdrometroLocalService, IdrometroLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(IdrometroLocalService.class);

		ServiceTracker<IdrometroLocalService, IdrometroLocalService>
			serviceTracker =
				new ServiceTracker
					<IdrometroLocalService, IdrometroLocalService>(
						bundle.getBundleContext(), IdrometroLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}