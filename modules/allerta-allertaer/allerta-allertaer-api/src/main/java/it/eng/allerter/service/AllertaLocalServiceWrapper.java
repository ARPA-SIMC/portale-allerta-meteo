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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AllertaLocalService}.
 *
 * @author GFAVINI
 * @see AllertaLocalService
 * @generated
 */
@ProviderType
public class AllertaLocalServiceWrapper
	implements AllertaLocalService, ServiceWrapper<AllertaLocalService> {

	public AllertaLocalServiceWrapper(AllertaLocalService allertaLocalService) {
		_allertaLocalService = allertaLocalService;
	}

	/**
	 * Adds the allerta to the database. Also notifies the appropriate model listeners.
	 *
	 * @param allerta the allerta
	 * @return the allerta that was added
	 */
	@Override
	public it.eng.allerter.model.Allerta addAllerta(
		it.eng.allerter.model.Allerta allerta) {

		return _allertaLocalService.addAllerta(allerta);
	}

	/**
	 * Creates a new allerta with the primary key. Does not add the allerta to the database.
	 *
	 * @param allertaId the primary key for the new allerta
	 * @return the new allerta
	 */
	@Override
	public it.eng.allerter.model.Allerta createAllerta(long allertaId) {
		return _allertaLocalService.createAllerta(allertaId);
	}

	/**
	 * Deletes the allerta from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allerta the allerta
	 * @return the allerta that was removed
	 */
	@Override
	public it.eng.allerter.model.Allerta deleteAllerta(
		it.eng.allerter.model.Allerta allerta) {

		return _allertaLocalService.deleteAllerta(allerta);
	}

	/**
	 * Deletes the allerta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaId the primary key of the allerta
	 * @return the allerta that was removed
	 * @throws PortalException if a allerta with the primary key could not be found
	 */
	@Override
	public it.eng.allerter.model.Allerta deleteAllerta(long allertaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allertaLocalService.deleteAllerta(allertaId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allertaLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _allertaLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _allertaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.AllertaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _allertaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.AllertaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _allertaLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _allertaLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _allertaLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.eng.allerter.model.Allerta fetchAllerta(long allertaId) {
		return _allertaLocalService.fetchAllerta(allertaId);
	}

	/**
	 * Returns the allerta matching the UUID and group.
	 *
	 * @param uuid the allerta's UUID
	 * @param groupId the primary key of the group
	 * @return the matching allerta, or <code>null</code> if a matching allerta could not be found
	 */
	@Override
	public it.eng.allerter.model.Allerta fetchAllertaByUuidAndGroupId(
		String uuid, long groupId) {

		return _allertaLocalService.fetchAllertaByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public void fileDeleteByApp(
		String file, String folderName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		_allertaLocalService.fileDeleteByApp(file, folderName, serviceContext);
	}

	@Override
	public void fileUploadByApp(
		java.io.File file, String folderName, String title, String description,
		String mimeType,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		_allertaLocalService.fileUploadByApp(
			file, folderName, title, description, mimeType, serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _allertaLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the allerta with the primary key.
	 *
	 * @param allertaId the primary key of the allerta
	 * @return the allerta
	 * @throws PortalException if a allerta with the primary key could not be found
	 */
	@Override
	public it.eng.allerter.model.Allerta getAllerta(long allertaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allertaLocalService.getAllerta(allertaId);
	}

	/**
	 * Returns the allerta matching the UUID and group.
	 *
	 * @param uuid the allerta's UUID
	 * @param groupId the primary key of the group
	 * @return the matching allerta
	 * @throws PortalException if a matching allerta could not be found
	 */
	@Override
	public it.eng.allerter.model.Allerta getAllertaByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allertaLocalService.getAllertaByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the allertas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.AllertaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allertas
	 * @param end the upper bound of the range of allertas (not inclusive)
	 * @return the range of allertas
	 */
	@Override
	public java.util.List<it.eng.allerter.model.Allerta> getAllertas(
		int start, int end) {

		return _allertaLocalService.getAllertas(start, end);
	}

	/**
	 * Returns all the allertas matching the UUID and company.
	 *
	 * @param uuid the UUID of the allertas
	 * @param companyId the primary key of the company
	 * @return the matching allertas, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.eng.allerter.model.Allerta>
		getAllertasByUuidAndCompanyId(String uuid, long companyId) {

		return _allertaLocalService.getAllertasByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of allertas matching the UUID and company.
	 *
	 * @param uuid the UUID of the allertas
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of allertas
	 * @param end the upper bound of the range of allertas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching allertas, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.eng.allerter.model.Allerta>
		getAllertasByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.eng.allerter.model.Allerta> orderByComparator) {

		return _allertaLocalService.getAllertasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of allertas.
	 *
	 * @return the number of allertas
	 */
	@Override
	public int getAllertasCount() {
		return _allertaLocalService.getAllertasCount();
	}

	@Override
	public java.util.List<it.eng.allerter.model.Allerta> getAllertasOrdered(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<it.eng.allerter.model.Allerta> comparator) {

		return _allertaLocalService.getAllertasOrdered(start, end, comparator);
	}

	@Override
	public com.liferay.document.library.kernel.model.DLFolder getDLFolder(
		String folderName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _allertaLocalService.getDLFolder(folderName, serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _allertaLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.repository.model.Folder getFolder(
		long groupId, String folderName) {

		return _allertaLocalService.getFolder(groupId, folderName);
	}

	@Override
	public long getIdApprovatore(long id) {
		return _allertaLocalService.getIdApprovatore(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _allertaLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<it.eng.allerter.model.Allerta> getListaAllerte() {
		return _allertaLocalService.getListaAllerte();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _allertaLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allertaLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public String nextIdAllerta(boolean allerta, int anno) {
		return _allertaLocalService.nextIdAllerta(allerta, anno);
	}

	@Override
	public void spedisciNotifiche(
		String tipo, String sottotipo, long l, String emailSubject,
		String emailText, it.eng.allerter.model.Allerta a) {

		_allertaLocalService.spedisciNotifiche(
			tipo, sottotipo, l, emailSubject, emailText, a);
	}

	/**
	 * Updates the allerta in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param allerta the allerta
	 * @return the allerta that was updated
	 */
	@Override
	public it.eng.allerter.model.Allerta updateAllerta(
		it.eng.allerter.model.Allerta allerta) {

		return _allertaLocalService.updateAllerta(allerta);
	}

	@Override
	public AllertaLocalService getWrappedService() {
		return _allertaLocalService;
	}

	@Override
	public void setWrappedService(AllertaLocalService allertaLocalService) {
		_allertaLocalService = allertaLocalService;
	}

	private AllertaLocalService _allertaLocalService;

}