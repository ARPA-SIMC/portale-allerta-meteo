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
 * Provides a wrapper for {@link AllertaValangheLocalService}.
 *
 * @author GFAVINI
 * @see AllertaValangheLocalService
 * @generated
 */
@ProviderType
public class AllertaValangheLocalServiceWrapper
	implements AllertaValangheLocalService,
			   ServiceWrapper<AllertaValangheLocalService> {

	public AllertaValangheLocalServiceWrapper(
		AllertaValangheLocalService allertaValangheLocalService) {

		_allertaValangheLocalService = allertaValangheLocalService;
	}

	/**
	 * Adds the allerta valanghe to the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaValanghe the allerta valanghe
	 * @return the allerta valanghe that was added
	 */
	@Override
	public it.eng.allerter.model.AllertaValanghe addAllertaValanghe(
		it.eng.allerter.model.AllertaValanghe allertaValanghe) {

		return _allertaValangheLocalService.addAllertaValanghe(allertaValanghe);
	}

	/**
	 * Creates a new allerta valanghe with the primary key. Does not add the allerta valanghe to the database.
	 *
	 * @param allertaValangheId the primary key for the new allerta valanghe
	 * @return the new allerta valanghe
	 */
	@Override
	public it.eng.allerter.model.AllertaValanghe createAllertaValanghe(
		long allertaValangheId) {

		return _allertaValangheLocalService.createAllertaValanghe(
			allertaValangheId);
	}

	/**
	 * Deletes the allerta valanghe from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaValanghe the allerta valanghe
	 * @return the allerta valanghe that was removed
	 */
	@Override
	public it.eng.allerter.model.AllertaValanghe deleteAllertaValanghe(
		it.eng.allerter.model.AllertaValanghe allertaValanghe) {

		return _allertaValangheLocalService.deleteAllertaValanghe(
			allertaValanghe);
	}

	/**
	 * Deletes the allerta valanghe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaValangheId the primary key of the allerta valanghe
	 * @return the allerta valanghe that was removed
	 * @throws PortalException if a allerta valanghe with the primary key could not be found
	 */
	@Override
	public it.eng.allerter.model.AllertaValanghe deleteAllertaValanghe(
			long allertaValangheId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allertaValangheLocalService.deleteAllertaValanghe(
			allertaValangheId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allertaValangheLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _allertaValangheLocalService.dynamicQuery();
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

		return _allertaValangheLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _allertaValangheLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _allertaValangheLocalService.dynamicQuery(
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

		return _allertaValangheLocalService.dynamicQueryCount(dynamicQuery);
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

		return _allertaValangheLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.allerter.model.AllertaValanghe fetchAllertaValanghe(
		long allertaValangheId) {

		return _allertaValangheLocalService.fetchAllertaValanghe(
			allertaValangheId);
	}

	/**
	 * Returns the allerta valanghe matching the UUID and group.
	 *
	 * @param uuid the allerta valanghe's UUID
	 * @param groupId the primary key of the group
	 * @return the matching allerta valanghe, or <code>null</code> if a matching allerta valanghe could not be found
	 */
	@Override
	public it.eng.allerter.model.AllertaValanghe
		fetchAllertaValangheByUuidAndGroupId(String uuid, long groupId) {

		return _allertaValangheLocalService.
			fetchAllertaValangheByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public void fileDeleteByApp(
		String file, String folderName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		_allertaValangheLocalService.fileDeleteByApp(
			file, folderName, serviceContext);
	}

	@Override
	public void fileUploadByApp(
		java.io.File file, String folderName, String title, String description,
		String mimeType,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		_allertaValangheLocalService.fileUploadByApp(
			file, folderName, title, description, mimeType, serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _allertaValangheLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the allerta valanghe with the primary key.
	 *
	 * @param allertaValangheId the primary key of the allerta valanghe
	 * @return the allerta valanghe
	 * @throws PortalException if a allerta valanghe with the primary key could not be found
	 */
	@Override
	public it.eng.allerter.model.AllertaValanghe getAllertaValanghe(
			long allertaValangheId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allertaValangheLocalService.getAllertaValanghe(
			allertaValangheId);
	}

	/**
	 * Returns the allerta valanghe matching the UUID and group.
	 *
	 * @param uuid the allerta valanghe's UUID
	 * @param groupId the primary key of the group
	 * @return the matching allerta valanghe
	 * @throws PortalException if a matching allerta valanghe could not be found
	 */
	@Override
	public it.eng.allerter.model.AllertaValanghe
			getAllertaValangheByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allertaValangheLocalService.getAllertaValangheByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<it.eng.allerter.model.AllertaValanghe>
		getAllertaValanghes(int start, int end) {

		return _allertaValangheLocalService.getAllertaValanghes(start, end);
	}

	/**
	 * Returns all the allerta valanghes matching the UUID and company.
	 *
	 * @param uuid the UUID of the allerta valanghes
	 * @param companyId the primary key of the company
	 * @return the matching allerta valanghes, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.eng.allerter.model.AllertaValanghe>
		getAllertaValanghesByUuidAndCompanyId(String uuid, long companyId) {

		return _allertaValangheLocalService.
			getAllertaValanghesByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<it.eng.allerter.model.AllertaValanghe>
		getAllertaValanghesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.eng.allerter.model.AllertaValanghe> orderByComparator) {

		return _allertaValangheLocalService.
			getAllertaValanghesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of allerta valanghes.
	 *
	 * @return the number of allerta valanghes
	 */
	@Override
	public int getAllertaValanghesCount() {
		return _allertaValangheLocalService.getAllertaValanghesCount();
	}

	@Override
	public java.util.List<it.eng.allerter.model.AllertaValanghe>
		getAllertaValanghesOrdered(
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.eng.allerter.model.AllertaValanghe> comparator) {

		return _allertaValangheLocalService.getAllertaValanghesOrdered(
			start, end, comparator);
	}

	@Override
	public com.liferay.document.library.kernel.model.DLFolder getDLFolder(
		String folderName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _allertaValangheLocalService.getDLFolder(
			folderName, serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _allertaValangheLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.repository.model.Folder getFolder(
		long groupId, String folderName) {

		return _allertaValangheLocalService.getFolder(groupId, folderName);
	}

	@Override
	public long getIdApprovatore(long id) {
		return _allertaValangheLocalService.getIdApprovatore(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _allertaValangheLocalService.
			getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.Map<String, Object> getInfoValanghe() {
		return _allertaValangheLocalService.getInfoValanghe();
	}

	@Override
	public java.util.Map<String, Object> getInfoValangheDomani() {
		return _allertaValangheLocalService.getInfoValangheDomani();
	}

	@Override
	public java.util.List<it.eng.allerter.model.AllertaValanghe>
		getListaAllerteValanghe() {

		return _allertaValangheLocalService.getListaAllerteValanghe();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _allertaValangheLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allertaValangheLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public String nextIdAllertaValanghe(boolean allerta, int anno) {
		return _allertaValangheLocalService.nextIdAllertaValanghe(
			allerta, anno);
	}

	@Override
	public void spedisciNotifiche(
		String tipo, String sottotipo, long l, String emailSubject,
		String emailText, it.eng.allerter.model.AllertaValanghe av) {

		_allertaValangheLocalService.spedisciNotifiche(
			tipo, sottotipo, l, emailSubject, emailText, av);
	}

	/**
	 * Updates the allerta valanghe in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param allertaValanghe the allerta valanghe
	 * @return the allerta valanghe that was updated
	 */
	@Override
	public it.eng.allerter.model.AllertaValanghe updateAllertaValanghe(
		it.eng.allerter.model.AllertaValanghe allertaValanghe) {

		return _allertaValangheLocalService.updateAllertaValanghe(
			allertaValanghe);
	}

	@Override
	public AllertaValangheLocalService getWrappedService() {
		return _allertaValangheLocalService;
	}

	@Override
	public void setWrappedService(
		AllertaValangheLocalService allertaValangheLocalService) {

		_allertaValangheLocalService = allertaValangheLocalService;
	}

	private AllertaValangheLocalService _allertaValangheLocalService;

}