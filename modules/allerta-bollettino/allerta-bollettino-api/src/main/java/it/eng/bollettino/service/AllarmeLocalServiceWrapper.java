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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AllarmeLocalService}.
 *
 * @author GFAVINI
 * @see AllarmeLocalService
 * @generated
 */
@ProviderType
public class AllarmeLocalServiceWrapper
	implements AllarmeLocalService, ServiceWrapper<AllarmeLocalService> {

	public AllarmeLocalServiceWrapper(AllarmeLocalService allarmeLocalService) {
		_allarmeLocalService = allarmeLocalService;
	}

	/**
	 * Adds the allarme to the database. Also notifies the appropriate model listeners.
	 *
	 * @param allarme the allarme
	 * @return the allarme that was added
	 */
	@Override
	public it.eng.bollettino.model.Allarme addAllarme(
		it.eng.bollettino.model.Allarme allarme) {

		return _allarmeLocalService.addAllarme(allarme);
	}

	/**
	 * Creates a new allarme with the primary key. Does not add the allarme to the database.
	 *
	 * @param allarmeId the primary key for the new allarme
	 * @return the new allarme
	 */
	@Override
	public it.eng.bollettino.model.Allarme createAllarme(long allarmeId) {
		return _allarmeLocalService.createAllarme(allarmeId);
	}

	/**
	 * Deletes the allarme from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allarme the allarme
	 * @return the allarme that was removed
	 */
	@Override
	public it.eng.bollettino.model.Allarme deleteAllarme(
		it.eng.bollettino.model.Allarme allarme) {

		return _allarmeLocalService.deleteAllarme(allarme);
	}

	/**
	 * Deletes the allarme with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allarmeId the primary key of the allarme
	 * @return the allarme that was removed
	 * @throws PortalException if a allarme with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.Allarme deleteAllarme(long allarmeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allarmeLocalService.deleteAllarme(allarmeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allarmeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _allarmeLocalService.dynamicQuery();
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

		return _allarmeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.AllarmeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _allarmeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.AllarmeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _allarmeLocalService.dynamicQuery(
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

		return _allarmeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _allarmeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.eng.bollettino.model.Allarme fetchAllarme(long allarmeId) {
		return _allarmeLocalService.fetchAllarme(allarmeId);
	}

	/**
	 * Returns the allarme matching the UUID and group.
	 *
	 * @param uuid the allarme's UUID
	 * @param groupId the primary key of the group
	 * @return the matching allarme, or <code>null</code> if a matching allarme could not be found
	 */
	@Override
	public it.eng.bollettino.model.Allarme fetchAllarmeByUuidAndGroupId(
		String uuid, long groupId) {

		return _allarmeLocalService.fetchAllarmeByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _allarmeLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the allarme with the primary key.
	 *
	 * @param allarmeId the primary key of the allarme
	 * @return the allarme
	 * @throws PortalException if a allarme with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.Allarme getAllarme(long allarmeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allarmeLocalService.getAllarme(allarmeId);
	}

	/**
	 * Returns the allarme matching the UUID and group.
	 *
	 * @param uuid the allarme's UUID
	 * @param groupId the primary key of the group
	 * @return the matching allarme
	 * @throws PortalException if a matching allarme could not be found
	 */
	@Override
	public it.eng.bollettino.model.Allarme getAllarmeByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allarmeLocalService.getAllarmeByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the allarmes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.AllarmeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @return the range of allarmes
	 */
	@Override
	public java.util.List<it.eng.bollettino.model.Allarme> getAllarmes(
		int start, int end) {

		return _allarmeLocalService.getAllarmes(start, end);
	}

	/**
	 * Returns all the allarmes matching the UUID and company.
	 *
	 * @param uuid the UUID of the allarmes
	 * @param companyId the primary key of the company
	 * @return the matching allarmes, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.eng.bollettino.model.Allarme>
		getAllarmesByUuidAndCompanyId(String uuid, long companyId) {

		return _allarmeLocalService.getAllarmesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of allarmes matching the UUID and company.
	 *
	 * @param uuid the UUID of the allarmes
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of allarmes
	 * @param end the upper bound of the range of allarmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching allarmes, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.eng.bollettino.model.Allarme>
		getAllarmesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.eng.bollettino.model.Allarme> orderByComparator) {

		return _allarmeLocalService.getAllarmesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of allarmes.
	 *
	 * @return the number of allarmes
	 */
	@Override
	public int getAllarmesCount() {
		return _allarmeLocalService.getAllarmesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _allarmeLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _allarmeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _allarmeLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allarmeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the allarme in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param allarme the allarme
	 * @return the allarme that was updated
	 */
	@Override
	public it.eng.bollettino.model.Allarme updateAllarme(
		it.eng.bollettino.model.Allarme allarme) {

		return _allarmeLocalService.updateAllarme(allarme);
	}

	@Override
	public AllarmeLocalService getWrappedService() {
		return _allarmeLocalService;
	}

	@Override
	public void setWrappedService(AllarmeLocalService allarmeLocalService) {
		_allarmeLocalService = allarmeLocalService;
	}

	private AllarmeLocalService _allarmeLocalService;

}