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

package it.eng.allerte.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for RubricaRuoloPermessi. This utility wraps
 * <code>it.eng.allerte.service.impl.RubricaRuoloPermessiLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Pratola_L
 * @see RubricaRuoloPermessiLocalService
 * @generated
 */
@ProviderType
public class RubricaRuoloPermessiLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.allerte.service.impl.RubricaRuoloPermessiLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the rubrica ruolo permessi to the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaRuoloPermessi the rubrica ruolo permessi
	 * @return the rubrica ruolo permessi that was added
	 */
	public static it.eng.allerte.model.RubricaRuoloPermessi
		addRubricaRuoloPermessi(
			it.eng.allerte.model.RubricaRuoloPermessi rubricaRuoloPermessi) {

		return getService().addRubricaRuoloPermessi(rubricaRuoloPermessi);
	}

	/**
	 * Creates a new rubrica ruolo permessi with the primary key. Does not add the rubrica ruolo permessi to the database.
	 *
	 * @param rubricaRuoloPermessiPK the primary key for the new rubrica ruolo permessi
	 * @return the new rubrica ruolo permessi
	 */
	public static it.eng.allerte.model.RubricaRuoloPermessi
		createRubricaRuoloPermessi(
			it.eng.allerte.service.persistence.RubricaRuoloPermessiPK
				rubricaRuoloPermessiPK) {

		return getService().createRubricaRuoloPermessi(rubricaRuoloPermessiPK);
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
	 * Deletes the rubrica ruolo permessi from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaRuoloPermessi the rubrica ruolo permessi
	 * @return the rubrica ruolo permessi that was removed
	 */
	public static it.eng.allerte.model.RubricaRuoloPermessi
		deleteRubricaRuoloPermessi(
			it.eng.allerte.model.RubricaRuoloPermessi rubricaRuoloPermessi) {

		return getService().deleteRubricaRuoloPermessi(rubricaRuoloPermessi);
	}

	/**
	 * Deletes the rubrica ruolo permessi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaRuoloPermessiPK the primary key of the rubrica ruolo permessi
	 * @return the rubrica ruolo permessi that was removed
	 * @throws PortalException if a rubrica ruolo permessi with the primary key could not be found
	 */
	public static it.eng.allerte.model.RubricaRuoloPermessi
			deleteRubricaRuoloPermessi(
				it.eng.allerte.service.persistence.RubricaRuoloPermessiPK
					rubricaRuoloPermessiPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteRubricaRuoloPermessi(rubricaRuoloPermessiPK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaRuoloPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaRuoloPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.eng.allerte.model.RubricaRuoloPermessi
		fetchRubricaRuoloPermessi(
			it.eng.allerte.service.persistence.RubricaRuoloPermessiPK
				rubricaRuoloPermessiPK) {

		return getService().fetchRubricaRuoloPermessi(rubricaRuoloPermessiPK);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the rubrica ruolo permessi with the primary key.
	 *
	 * @param rubricaRuoloPermessiPK the primary key of the rubrica ruolo permessi
	 * @return the rubrica ruolo permessi
	 * @throws PortalException if a rubrica ruolo permessi with the primary key could not be found
	 */
	public static it.eng.allerte.model.RubricaRuoloPermessi
			getRubricaRuoloPermessi(
				it.eng.allerte.service.persistence.RubricaRuoloPermessiPK
					rubricaRuoloPermessiPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getRubricaRuoloPermessi(rubricaRuoloPermessiPK);
	}

	/**
	 * Returns a range of all the rubrica ruolo permessis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaRuoloPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolo permessis
	 * @param end the upper bound of the range of rubrica ruolo permessis (not inclusive)
	 * @return the range of rubrica ruolo permessis
	 */
	public static java.util.List<it.eng.allerte.model.RubricaRuoloPermessi>
		getRubricaRuoloPermessis(int start, int end) {

		return getService().getRubricaRuoloPermessis(start, end);
	}

	/**
	 * Returns the number of rubrica ruolo permessis.
	 *
	 * @return the number of rubrica ruolo permessis
	 */
	public static int getRubricaRuoloPermessisCount() {
		return getService().getRubricaRuoloPermessisCount();
	}

	/**
	 * Updates the rubrica ruolo permessi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaRuoloPermessi the rubrica ruolo permessi
	 * @return the rubrica ruolo permessi that was updated
	 */
	public static it.eng.allerte.model.RubricaRuoloPermessi
		updateRubricaRuoloPermessi(
			it.eng.allerte.model.RubricaRuoloPermessi rubricaRuoloPermessi) {

		return getService().updateRubricaRuoloPermessi(rubricaRuoloPermessi);
	}

	public static RubricaRuoloPermessiLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RubricaRuoloPermessiLocalService, RubricaRuoloPermessiLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			RubricaRuoloPermessiLocalService.class);

		ServiceTracker
			<RubricaRuoloPermessiLocalService, RubricaRuoloPermessiLocalService>
				serviceTracker =
					new ServiceTracker
						<RubricaRuoloPermessiLocalService,
						 RubricaRuoloPermessiLocalService>(
							 bundle.getBundleContext(),
							 RubricaRuoloPermessiLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}