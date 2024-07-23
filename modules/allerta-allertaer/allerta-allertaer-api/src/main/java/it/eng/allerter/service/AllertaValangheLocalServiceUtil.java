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
 * Provides the local service utility for AllertaValanghe. This utility wraps
 * <code>it.eng.allerter.service.impl.AllertaValangheLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author GFAVINI
 * @see AllertaValangheLocalService
 * @generated
 */
@ProviderType
public class AllertaValangheLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.allerter.service.impl.AllertaValangheLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the allerta valanghe to the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaValanghe the allerta valanghe
	 * @return the allerta valanghe that was added
	 */
	public static it.eng.allerter.model.AllertaValanghe addAllertaValanghe(
		it.eng.allerter.model.AllertaValanghe allertaValanghe) {

		return getService().addAllertaValanghe(allertaValanghe);
	}

	/**
	 * Creates a new allerta valanghe with the primary key. Does not add the allerta valanghe to the database.
	 *
	 * @param allertaValangheId the primary key for the new allerta valanghe
	 * @return the new allerta valanghe
	 */
	public static it.eng.allerter.model.AllertaValanghe createAllertaValanghe(
		long allertaValangheId) {

		return getService().createAllertaValanghe(allertaValangheId);
	}

	/**
	 * Deletes the allerta valanghe from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaValanghe the allerta valanghe
	 * @return the allerta valanghe that was removed
	 */
	public static it.eng.allerter.model.AllertaValanghe deleteAllertaValanghe(
		it.eng.allerter.model.AllertaValanghe allertaValanghe) {

		return getService().deleteAllertaValanghe(allertaValanghe);
	}

	/**
	 * Deletes the allerta valanghe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaValangheId the primary key of the allerta valanghe
	 * @return the allerta valanghe that was removed
	 * @throws PortalException if a allerta valanghe with the primary key could not be found
	 */
	public static it.eng.allerter.model.AllertaValanghe deleteAllertaValanghe(
			long allertaValangheId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteAllertaValanghe(allertaValangheId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.eng.allerter.model.AllertaValanghe fetchAllertaValanghe(
		long allertaValangheId) {

		return getService().fetchAllertaValanghe(allertaValangheId);
	}

	/**
	 * Returns the allerta valanghe matching the UUID and group.
	 *
	 * @param uuid the allerta valanghe's UUID
	 * @param groupId the primary key of the group
	 * @return the matching allerta valanghe, or <code>null</code> if a matching allerta valanghe could not be found
	 */
	public static it.eng.allerter.model.AllertaValanghe
		fetchAllertaValangheByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchAllertaValangheByUuidAndGroupId(uuid, groupId);
	}

	public static void fileDeleteByApp(
		String file, String folderName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		getService().fileDeleteByApp(file, folderName, serviceContext);
	}

	public static void fileUploadByApp(
		java.io.File file, String folderName, String title, String description,
		String mimeType,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		getService().fileUploadByApp(
			file, folderName, title, description, mimeType, serviceContext);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the allerta valanghe with the primary key.
	 *
	 * @param allertaValangheId the primary key of the allerta valanghe
	 * @return the allerta valanghe
	 * @throws PortalException if a allerta valanghe with the primary key could not be found
	 */
	public static it.eng.allerter.model.AllertaValanghe getAllertaValanghe(
			long allertaValangheId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAllertaValanghe(allertaValangheId);
	}

	/**
	 * Returns the allerta valanghe matching the UUID and group.
	 *
	 * @param uuid the allerta valanghe's UUID
	 * @param groupId the primary key of the group
	 * @return the matching allerta valanghe
	 * @throws PortalException if a matching allerta valanghe could not be found
	 */
	public static it.eng.allerter.model.AllertaValanghe
			getAllertaValangheByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAllertaValangheByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the allerta valanghes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.AllertaValangheModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @return the range of allerta valanghes
	 */
	public static java.util.List<it.eng.allerter.model.AllertaValanghe>
		getAllertaValanghes(int start, int end) {

		return getService().getAllertaValanghes(start, end);
	}

	/**
	 * Returns all the allerta valanghes matching the UUID and company.
	 *
	 * @param uuid the UUID of the allerta valanghes
	 * @param companyId the primary key of the company
	 * @return the matching allerta valanghes, or an empty list if no matches were found
	 */
	public static java.util.List<it.eng.allerter.model.AllertaValanghe>
		getAllertaValanghesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getAllertaValanghesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of allerta valanghes matching the UUID and company.
	 *
	 * @param uuid the UUID of the allerta valanghes
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching allerta valanghes, or an empty list if no matches were found
	 */
	public static java.util.List<it.eng.allerter.model.AllertaValanghe>
		getAllertaValanghesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.eng.allerter.model.AllertaValanghe> orderByComparator) {

		return getService().getAllertaValanghesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of allerta valanghes.
	 *
	 * @return the number of allerta valanghes
	 */
	public static int getAllertaValanghesCount() {
		return getService().getAllertaValanghesCount();
	}

	public static java.util.List<it.eng.allerter.model.AllertaValanghe>
		getAllertaValanghesOrdered(
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.eng.allerter.model.AllertaValanghe> comparator) {

		return getService().getAllertaValanghesOrdered(start, end, comparator);
	}

	public static com.liferay.document.library.kernel.model.DLFolder
		getDLFolder(
			String folderName,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().getDLFolder(folderName, serviceContext);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.repository.model.Folder getFolder(
		long groupId, String folderName) {

		return getService().getFolder(groupId, folderName);
	}

	public static long getIdApprovatore(long id) {
		return getService().getIdApprovatore(id);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static java.util.Map<String, Object> getInfoValanghe() {
		return getService().getInfoValanghe();
	}

	public static java.util.Map<String, Object> getInfoValangheDomani() {
		return getService().getInfoValangheDomani();
	}

	public static java.util.List<it.eng.allerter.model.AllertaValanghe>
		getListaAllerteValanghe() {

		return getService().getListaAllerteValanghe();
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

	public static String nextIdAllertaValanghe(boolean allerta, int anno) {
		return getService().nextIdAllertaValanghe(allerta, anno);
	}

	public static void spedisciNotifiche(
		String tipo, String sottotipo, long l, String emailSubject,
		String emailText, it.eng.allerter.model.AllertaValanghe av) {

		getService().spedisciNotifiche(
			tipo, sottotipo, l, emailSubject, emailText, av);
	}

	/**
	 * Updates the allerta valanghe in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param allertaValanghe the allerta valanghe
	 * @return the allerta valanghe that was updated
	 */
	public static it.eng.allerter.model.AllertaValanghe updateAllertaValanghe(
		it.eng.allerter.model.AllertaValanghe allertaValanghe) {

		return getService().updateAllertaValanghe(allertaValanghe);
	}

	public static AllertaValangheLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AllertaValangheLocalService, AllertaValangheLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			AllertaValangheLocalService.class);

		ServiceTracker<AllertaValangheLocalService, AllertaValangheLocalService>
			serviceTracker =
				new ServiceTracker
					<AllertaValangheLocalService, AllertaValangheLocalService>(
						bundle.getBundleContext(),
						AllertaValangheLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}