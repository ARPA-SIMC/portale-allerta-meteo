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
 * Provides the local service utility for RegolaAllarmeCondizione. This utility wraps
 * <code>it.eng.bollettino.service.impl.RegolaAllarmeCondizioneLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author GFAVINI
 * @see RegolaAllarmeCondizioneLocalService
 * @generated
 */
@ProviderType
public class RegolaAllarmeCondizioneLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.bollettino.service.impl.RegolaAllarmeCondizioneLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the regola allarme condizione to the database. Also notifies the appropriate model listeners.
	 *
	 * @param regolaAllarmeCondizione the regola allarme condizione
	 * @return the regola allarme condizione that was added
	 */
	public static it.eng.bollettino.model.RegolaAllarmeCondizione
		addRegolaAllarmeCondizione(
			it.eng.bollettino.model.RegolaAllarmeCondizione
				regolaAllarmeCondizione) {

		return getService().addRegolaAllarmeCondizione(regolaAllarmeCondizione);
	}

	/**
	 * Creates a new regola allarme condizione with the primary key. Does not add the regola allarme condizione to the database.
	 *
	 * @param id the primary key for the new regola allarme condizione
	 * @return the new regola allarme condizione
	 */
	public static it.eng.bollettino.model.RegolaAllarmeCondizione
		createRegolaAllarmeCondizione(long id) {

		return getService().createRegolaAllarmeCondizione(id);
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

	/**
	 * Deletes the regola allarme condizione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the regola allarme condizione
	 * @return the regola allarme condizione that was removed
	 * @throws PortalException if a regola allarme condizione with the primary key could not be found
	 */
	public static it.eng.bollettino.model.RegolaAllarmeCondizione
			deleteRegolaAllarmeCondizione(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteRegolaAllarmeCondizione(id);
	}

	/**
	 * Deletes the regola allarme condizione from the database. Also notifies the appropriate model listeners.
	 *
	 * @param regolaAllarmeCondizione the regola allarme condizione
	 * @return the regola allarme condizione that was removed
	 */
	public static it.eng.bollettino.model.RegolaAllarmeCondizione
		deleteRegolaAllarmeCondizione(
			it.eng.bollettino.model.RegolaAllarmeCondizione
				regolaAllarmeCondizione) {

		return getService().deleteRegolaAllarmeCondizione(
			regolaAllarmeCondizione);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.RegolaAllarmeCondizioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.RegolaAllarmeCondizioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.eng.bollettino.model.RegolaAllarmeCondizione
		fetchRegolaAllarmeCondizione(long id) {

		return getService().fetchRegolaAllarmeCondizione(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List
		<it.eng.bollettino.model.RegolaAllarmeCondizione> getAllarmeCondizione(
			long idRegola) {

		return getService().getAllarmeCondizione(idRegola);
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
	 * Returns the regola allarme condizione with the primary key.
	 *
	 * @param id the primary key of the regola allarme condizione
	 * @return the regola allarme condizione
	 * @throws PortalException if a regola allarme condizione with the primary key could not be found
	 */
	public static it.eng.bollettino.model.RegolaAllarmeCondizione
			getRegolaAllarmeCondizione(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getRegolaAllarmeCondizione(id);
	}

	/**
	 * Returns a range of all the regola allarme condiziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.RegolaAllarmeCondizioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @return the range of regola allarme condiziones
	 */
	public static java.util.List
		<it.eng.bollettino.model.RegolaAllarmeCondizione>
			getRegolaAllarmeCondiziones(int start, int end) {

		return getService().getRegolaAllarmeCondiziones(start, end);
	}

	/**
	 * Returns the number of regola allarme condiziones.
	 *
	 * @return the number of regola allarme condiziones
	 */
	public static int getRegolaAllarmeCondizionesCount() {
		return getService().getRegolaAllarmeCondizionesCount();
	}

	/**
	 * Updates the regola allarme condizione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param regolaAllarmeCondizione the regola allarme condizione
	 * @return the regola allarme condizione that was updated
	 */
	public static it.eng.bollettino.model.RegolaAllarmeCondizione
		updateRegolaAllarmeCondizione(
			it.eng.bollettino.model.RegolaAllarmeCondizione
				regolaAllarmeCondizione) {

		return getService().updateRegolaAllarmeCondizione(
			regolaAllarmeCondizione);
	}

	public static RegolaAllarmeCondizioneLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RegolaAllarmeCondizioneLocalService,
		 RegolaAllarmeCondizioneLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			RegolaAllarmeCondizioneLocalService.class);

		ServiceTracker
			<RegolaAllarmeCondizioneLocalService,
			 RegolaAllarmeCondizioneLocalService> serviceTracker =
				new ServiceTracker
					<RegolaAllarmeCondizioneLocalService,
					 RegolaAllarmeCondizioneLocalService>(
						 bundle.getBundleContext(),
						 RegolaAllarmeCondizioneLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}