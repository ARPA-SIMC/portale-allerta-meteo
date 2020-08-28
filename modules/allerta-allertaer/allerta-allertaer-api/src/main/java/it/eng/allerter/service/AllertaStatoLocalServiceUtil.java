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
 * Provides the local service utility for AllertaStato. This utility wraps
 * <code>it.eng.allerter.service.impl.AllertaStatoLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author GFAVINI
 * @see AllertaStatoLocalService
 * @generated
 */
@ProviderType
public class AllertaStatoLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.allerter.service.impl.AllertaStatoLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the allerta stato to the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaStato the allerta stato
	 * @return the allerta stato that was added
	 */
	public static it.eng.allerter.model.AllertaStato addAllertaStato(
		it.eng.allerter.model.AllertaStato allertaStato) {

		return getService().addAllertaStato(allertaStato);
	}

	/**
	 * Creates a new allerta stato with the primary key. Does not add the allerta stato to the database.
	 *
	 * @param allertaStatoId the primary key for the new allerta stato
	 * @return the new allerta stato
	 */
	public static it.eng.allerter.model.AllertaStato createAllertaStato(
		long allertaStatoId) {

		return getService().createAllertaStato(allertaStatoId);
	}

	/**
	 * Deletes the allerta stato from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaStato the allerta stato
	 * @return the allerta stato that was removed
	 */
	public static it.eng.allerter.model.AllertaStato deleteAllertaStato(
		it.eng.allerter.model.AllertaStato allertaStato) {

		return getService().deleteAllertaStato(allertaStato);
	}

	/**
	 * Deletes the allerta stato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaStatoId the primary key of the allerta stato
	 * @return the allerta stato that was removed
	 * @throws PortalException if a allerta stato with the primary key could not be found
	 */
	public static it.eng.allerter.model.AllertaStato deleteAllertaStato(
			long allertaStatoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteAllertaStato(allertaStatoId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.eng.allerter.model.AllertaStato fetchAllertaStato(
		long allertaStatoId) {

		return getService().fetchAllertaStato(allertaStatoId);
	}

	/**
	 * Returns the allerta stato matching the UUID and group.
	 *
	 * @param uuid the allerta stato's UUID
	 * @param groupId the primary key of the group
	 * @return the matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	public static it.eng.allerter.model.AllertaStato
		fetchAllertaStatoByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchAllertaStatoByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the allerta stato with the primary key.
	 *
	 * @param allertaStatoId the primary key of the allerta stato
	 * @return the allerta stato
	 * @throws PortalException if a allerta stato with the primary key could not be found
	 */
	public static it.eng.allerter.model.AllertaStato getAllertaStato(
			long allertaStatoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAllertaStato(allertaStatoId);
	}

	public static java.util.List<it.eng.allerter.model.AllertaStato>
		getAllertaStatoByAllerta(long allertaId) {

		return getService().getAllertaStatoByAllerta(allertaId);
	}

	/**
	 * Returns the allerta stato matching the UUID and group.
	 *
	 * @param uuid the allerta stato's UUID
	 * @param groupId the primary key of the group
	 * @return the matching allerta stato
	 * @throws PortalException if a matching allerta stato could not be found
	 */
	public static it.eng.allerter.model.AllertaStato
			getAllertaStatoByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAllertaStatoByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the allerta statos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @return the range of allerta statos
	 */
	public static java.util.List<it.eng.allerter.model.AllertaStato>
		getAllertaStatos(int start, int end) {

		return getService().getAllertaStatos(start, end);
	}

	/**
	 * Returns all the allerta statos matching the UUID and company.
	 *
	 * @param uuid the UUID of the allerta statos
	 * @param companyId the primary key of the company
	 * @return the matching allerta statos, or an empty list if no matches were found
	 */
	public static java.util.List<it.eng.allerter.model.AllertaStato>
		getAllertaStatosByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getAllertaStatosByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of allerta statos matching the UUID and company.
	 *
	 * @param uuid the UUID of the allerta statos
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching allerta statos, or an empty list if no matches were found
	 */
	public static java.util.List<it.eng.allerter.model.AllertaStato>
		getAllertaStatosByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.eng.allerter.model.AllertaStato> orderByComparator) {

		return getService().getAllertaStatosByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of allerta statos.
	 *
	 * @return the number of allerta statos
	 */
	public static int getAllertaStatosCount() {
		return getService().getAllertaStatosCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
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
	 * Updates the allerta stato in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param allertaStato the allerta stato
	 * @return the allerta stato that was updated
	 */
	public static it.eng.allerter.model.AllertaStato updateAllertaStato(
		it.eng.allerter.model.AllertaStato allertaStato) {

		return getService().updateAllertaStato(allertaStato);
	}

	public static AllertaStatoLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AllertaStatoLocalService, AllertaStatoLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AllertaStatoLocalService.class);

		ServiceTracker<AllertaStatoLocalService, AllertaStatoLocalService>
			serviceTracker =
				new ServiceTracker
					<AllertaStatoLocalService, AllertaStatoLocalService>(
						bundle.getBundleContext(),
						AllertaStatoLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}