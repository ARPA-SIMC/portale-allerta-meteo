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
 * Provides the local service utility for TipoEvento. This utility wraps
 * <code>it.eng.allerter.service.impl.TipoEventoLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author GFAVINI
 * @see TipoEventoLocalService
 * @generated
 */
@ProviderType
public class TipoEventoLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.allerter.service.impl.TipoEventoLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the tipo evento to the database. Also notifies the appropriate model listeners.
	 *
	 * @param tipoEvento the tipo evento
	 * @return the tipo evento that was added
	 */
	public static it.eng.allerter.model.TipoEvento addTipoEvento(
		it.eng.allerter.model.TipoEvento tipoEvento) {

		return getService().addTipoEvento(tipoEvento);
	}

	/**
	 * Creates a new tipo evento with the primary key. Does not add the tipo evento to the database.
	 *
	 * @param eventoId the primary key for the new tipo evento
	 * @return the new tipo evento
	 */
	public static it.eng.allerter.model.TipoEvento createTipoEvento(
		long eventoId) {

		return getService().createTipoEvento(eventoId);
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
	 * Deletes the tipo evento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventoId the primary key of the tipo evento
	 * @return the tipo evento that was removed
	 * @throws PortalException if a tipo evento with the primary key could not be found
	 */
	public static it.eng.allerter.model.TipoEvento deleteTipoEvento(
			long eventoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTipoEvento(eventoId);
	}

	/**
	 * Deletes the tipo evento from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tipoEvento the tipo evento
	 * @return the tipo evento that was removed
	 */
	public static it.eng.allerter.model.TipoEvento deleteTipoEvento(
		it.eng.allerter.model.TipoEvento tipoEvento) {

		return getService().deleteTipoEvento(tipoEvento);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.TipoEventoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.TipoEventoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.eng.allerter.model.TipoEvento fetchTipoEvento(
		long eventoId) {

		return getService().fetchTipoEvento(eventoId);
	}

	/**
	 * Returns the tipo evento matching the UUID and group.
	 *
	 * @param uuid the tipo evento's UUID
	 * @param groupId the primary key of the group
	 * @return the matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	public static it.eng.allerter.model.TipoEvento
		fetchTipoEventoByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchTipoEventoByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the tipo evento with the primary key.
	 *
	 * @param eventoId the primary key of the tipo evento
	 * @return the tipo evento
	 * @throws PortalException if a tipo evento with the primary key could not be found
	 */
	public static it.eng.allerter.model.TipoEvento getTipoEvento(long eventoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTipoEvento(eventoId);
	}

	/**
	 * Returns the tipo evento matching the UUID and group.
	 *
	 * @param uuid the tipo evento's UUID
	 * @param groupId the primary key of the group
	 * @return the matching tipo evento
	 * @throws PortalException if a matching tipo evento could not be found
	 */
	public static it.eng.allerter.model.TipoEvento
			getTipoEventoByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTipoEventoByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the tipo eventos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.TipoEventoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @return the range of tipo eventos
	 */
	public static java.util.List<it.eng.allerter.model.TipoEvento>
		getTipoEventos(int start, int end) {

		return getService().getTipoEventos(start, end);
	}

	/**
	 * Returns all the tipo eventos matching the UUID and company.
	 *
	 * @param uuid the UUID of the tipo eventos
	 * @param companyId the primary key of the company
	 * @return the matching tipo eventos, or an empty list if no matches were found
	 */
	public static java.util.List<it.eng.allerter.model.TipoEvento>
		getTipoEventosByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getTipoEventosByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of tipo eventos matching the UUID and company.
	 *
	 * @param uuid the UUID of the tipo eventos
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching tipo eventos, or an empty list if no matches were found
	 */
	public static java.util.List<it.eng.allerter.model.TipoEvento>
		getTipoEventosByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.eng.allerter.model.TipoEvento> orderByComparator) {

		return getService().getTipoEventosByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of tipo eventos.
	 *
	 * @return the number of tipo eventos
	 */
	public static int getTipoEventosCount() {
		return getService().getTipoEventosCount();
	}

	/**
	 * Updates the tipo evento in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param tipoEvento the tipo evento
	 * @return the tipo evento that was updated
	 */
	public static it.eng.allerter.model.TipoEvento updateTipoEvento(
		it.eng.allerter.model.TipoEvento tipoEvento) {

		return getService().updateTipoEvento(tipoEvento);
	}

	public static TipoEventoLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TipoEventoLocalService, TipoEventoLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TipoEventoLocalService.class);

		ServiceTracker<TipoEventoLocalService, TipoEventoLocalService>
			serviceTracker =
				new ServiceTracker
					<TipoEventoLocalService, TipoEventoLocalService>(
						bundle.getBundleContext(), TipoEventoLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}