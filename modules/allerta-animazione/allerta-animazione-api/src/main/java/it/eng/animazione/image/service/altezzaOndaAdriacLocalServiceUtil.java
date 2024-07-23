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

package it.eng.animazione.image.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for altezzaOndaAdriac. This utility wraps
 * <code>it.eng.animazione.image.service.impl.altezzaOndaAdriacLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author UTENTE
 * @see altezzaOndaAdriacLocalService
 * @generated
 */
@ProviderType
public class altezzaOndaAdriacLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.animazione.image.service.impl.altezzaOndaAdriacLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the altezza onda adriac to the database. Also notifies the appropriate model listeners.
	 *
	 * @param altezzaOndaAdriac the altezza onda adriac
	 * @return the altezza onda adriac that was added
	 */
	public static it.eng.animazione.image.model.altezzaOndaAdriac
		addaltezzaOndaAdriac(
			it.eng.animazione.image.model.altezzaOndaAdriac altezzaOndaAdriac) {

		return getService().addaltezzaOndaAdriac(altezzaOndaAdriac);
	}

	/**
	 * Creates a new altezza onda adriac with the primary key. Does not add the altezza onda adriac to the database.
	 *
	 * @param id the primary key for the new altezza onda adriac
	 * @return the new altezza onda adriac
	 */
	public static it.eng.animazione.image.model.altezzaOndaAdriac
		createaltezzaOndaAdriac(long id) {

		return getService().createaltezzaOndaAdriac(id);
	}

	/**
	 * Deletes the altezza onda adriac from the database. Also notifies the appropriate model listeners.
	 *
	 * @param altezzaOndaAdriac the altezza onda adriac
	 * @return the altezza onda adriac that was removed
	 */
	public static it.eng.animazione.image.model.altezzaOndaAdriac
		deletealtezzaOndaAdriac(
			it.eng.animazione.image.model.altezzaOndaAdriac altezzaOndaAdriac) {

		return getService().deletealtezzaOndaAdriac(altezzaOndaAdriac);
	}

	/**
	 * Deletes the altezza onda adriac with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the altezza onda adriac
	 * @return the altezza onda adriac that was removed
	 * @throws PortalException if a altezza onda adriac with the primary key could not be found
	 */
	public static it.eng.animazione.image.model.altezzaOndaAdriac
			deletealtezzaOndaAdriac(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletealtezzaOndaAdriac(id);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.animazione.image.model.impl.altezzaOndaAdriacModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.animazione.image.model.impl.altezzaOndaAdriacModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.eng.animazione.image.model.altezzaOndaAdriac
		fetchaltezzaOndaAdriac(long id) {

		return getService().fetchaltezzaOndaAdriac(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the altezza onda adriac with the primary key.
	 *
	 * @param id the primary key of the altezza onda adriac
	 * @return the altezza onda adriac
	 * @throws PortalException if a altezza onda adriac with the primary key could not be found
	 */
	public static it.eng.animazione.image.model.altezzaOndaAdriac
			getaltezzaOndaAdriac(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getaltezzaOndaAdriac(id);
	}

	/**
	 * Returns a range of all the altezza onda adriacs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.animazione.image.model.impl.altezzaOndaAdriacModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza onda adriacs
	 * @param end the upper bound of the range of altezza onda adriacs (not inclusive)
	 * @return the range of altezza onda adriacs
	 */
	public static java.util.List
		<it.eng.animazione.image.model.altezzaOndaAdriac> getaltezzaOndaAdriacs(
			int start, int end) {

		return getService().getaltezzaOndaAdriacs(start, end);
	}

	/**
	 * Returns the number of altezza onda adriacs.
	 *
	 * @return the number of altezza onda adriacs
	 */
	public static int getaltezzaOndaAdriacsCount() {
		return getService().getaltezzaOndaAdriacsCount();
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
	 * Updates the altezza onda adriac in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param altezzaOndaAdriac the altezza onda adriac
	 * @return the altezza onda adriac that was updated
	 */
	public static it.eng.animazione.image.model.altezzaOndaAdriac
		updatealtezzaOndaAdriac(
			it.eng.animazione.image.model.altezzaOndaAdriac altezzaOndaAdriac) {

		return getService().updatealtezzaOndaAdriac(altezzaOndaAdriac);
	}

	public static altezzaOndaAdriacLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<altezzaOndaAdriacLocalService, altezzaOndaAdriacLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			altezzaOndaAdriacLocalService.class);

		ServiceTracker
			<altezzaOndaAdriacLocalService, altezzaOndaAdriacLocalService>
				serviceTracker =
					new ServiceTracker
						<altezzaOndaAdriacLocalService,
						 altezzaOndaAdriacLocalService>(
							 bundle.getBundleContext(),
							 altezzaOndaAdriacLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}