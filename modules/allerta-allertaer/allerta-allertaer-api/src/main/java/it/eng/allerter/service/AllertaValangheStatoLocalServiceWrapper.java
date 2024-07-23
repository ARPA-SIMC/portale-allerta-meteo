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
 * Provides a wrapper for {@link AllertaValangheStatoLocalService}.
 *
 * @author GFAVINI
 * @see AllertaValangheStatoLocalService
 * @generated
 */
@ProviderType
public class AllertaValangheStatoLocalServiceWrapper
	implements AllertaValangheStatoLocalService,
			   ServiceWrapper<AllertaValangheStatoLocalService> {

	public AllertaValangheStatoLocalServiceWrapper(
		AllertaValangheStatoLocalService allertaValangheStatoLocalService) {

		_allertaValangheStatoLocalService = allertaValangheStatoLocalService;
	}

	/**
	 * Adds the allerta valanghe stato to the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaValangheStato the allerta valanghe stato
	 * @return the allerta valanghe stato that was added
	 */
	@Override
	public it.eng.allerter.model.AllertaValangheStato addAllertaValangheStato(
		it.eng.allerter.model.AllertaValangheStato allertaValangheStato) {

		return _allertaValangheStatoLocalService.addAllertaValangheStato(
			allertaValangheStato);
	}

	/**
	 * Creates a new allerta valanghe stato with the primary key. Does not add the allerta valanghe stato to the database.
	 *
	 * @param allertaValangheStatoId the primary key for the new allerta valanghe stato
	 * @return the new allerta valanghe stato
	 */
	@Override
	public it.eng.allerter.model.AllertaValangheStato
		createAllertaValangheStato(long allertaValangheStatoId) {

		return _allertaValangheStatoLocalService.createAllertaValangheStato(
			allertaValangheStatoId);
	}

	/**
	 * Deletes the allerta valanghe stato from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaValangheStato the allerta valanghe stato
	 * @return the allerta valanghe stato that was removed
	 */
	@Override
	public it.eng.allerter.model.AllertaValangheStato
		deleteAllertaValangheStato(
			it.eng.allerter.model.AllertaValangheStato allertaValangheStato) {

		return _allertaValangheStatoLocalService.deleteAllertaValangheStato(
			allertaValangheStato);
	}

	/**
	 * Deletes the allerta valanghe stato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaValangheStatoId the primary key of the allerta valanghe stato
	 * @return the allerta valanghe stato that was removed
	 * @throws PortalException if a allerta valanghe stato with the primary key could not be found
	 */
	@Override
	public it.eng.allerter.model.AllertaValangheStato
			deleteAllertaValangheStato(long allertaValangheStatoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allertaValangheStatoLocalService.deleteAllertaValangheStato(
			allertaValangheStatoId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allertaValangheStatoLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _allertaValangheStatoLocalService.dynamicQuery();
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

		return _allertaValangheStatoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _allertaValangheStatoLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _allertaValangheStatoLocalService.dynamicQuery(
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

		return _allertaValangheStatoLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _allertaValangheStatoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.allerter.model.AllertaValangheStato fetchAllertaValangheStato(
		long allertaValangheStatoId) {

		return _allertaValangheStatoLocalService.fetchAllertaValangheStato(
			allertaValangheStatoId);
	}

	/**
	 * Returns the allerta valanghe stato matching the UUID and group.
	 *
	 * @param uuid the allerta valanghe stato's UUID
	 * @param groupId the primary key of the group
	 * @return the matching allerta valanghe stato, or <code>null</code> if a matching allerta valanghe stato could not be found
	 */
	@Override
	public it.eng.allerter.model.AllertaValangheStato
		fetchAllertaValangheStatoByUuidAndGroupId(String uuid, long groupId) {

		return _allertaValangheStatoLocalService.
			fetchAllertaValangheStatoByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _allertaValangheStatoLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the allerta valanghe stato with the primary key.
	 *
	 * @param allertaValangheStatoId the primary key of the allerta valanghe stato
	 * @return the allerta valanghe stato
	 * @throws PortalException if a allerta valanghe stato with the primary key could not be found
	 */
	@Override
	public it.eng.allerter.model.AllertaValangheStato getAllertaValangheStato(
			long allertaValangheStatoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allertaValangheStatoLocalService.getAllertaValangheStato(
			allertaValangheStatoId);
	}

	@Override
	public java.util.List<it.eng.allerter.model.AllertaValangheStato>
		getAllertaValangheStatoByAllertaValanghe(long allertaValangheId) {

		return _allertaValangheStatoLocalService.
			getAllertaValangheStatoByAllertaValanghe(allertaValangheId);
	}

	/**
	 * Returns the allerta valanghe stato matching the UUID and group.
	 *
	 * @param uuid the allerta valanghe stato's UUID
	 * @param groupId the primary key of the group
	 * @return the matching allerta valanghe stato
	 * @throws PortalException if a matching allerta valanghe stato could not be found
	 */
	@Override
	public it.eng.allerter.model.AllertaValangheStato
			getAllertaValangheStatoByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allertaValangheStatoLocalService.
			getAllertaValangheStatoByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the allerta valanghe statos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.AllertaValangheStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @return the range of allerta valanghe statos
	 */
	@Override
	public java.util.List<it.eng.allerter.model.AllertaValangheStato>
		getAllertaValangheStatos(int start, int end) {

		return _allertaValangheStatoLocalService.getAllertaValangheStatos(
			start, end);
	}

	/**
	 * Returns all the allerta valanghe statos matching the UUID and company.
	 *
	 * @param uuid the UUID of the allerta valanghe statos
	 * @param companyId the primary key of the company
	 * @return the matching allerta valanghe statos, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.eng.allerter.model.AllertaValangheStato>
		getAllertaValangheStatosByUuidAndCompanyId(
			String uuid, long companyId) {

		return _allertaValangheStatoLocalService.
			getAllertaValangheStatosByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of allerta valanghe statos matching the UUID and company.
	 *
	 * @param uuid the UUID of the allerta valanghe statos
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of allerta valanghe statos
	 * @param end the upper bound of the range of allerta valanghe statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching allerta valanghe statos, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.eng.allerter.model.AllertaValangheStato>
		getAllertaValangheStatosByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.eng.allerter.model.AllertaValangheStato>
					orderByComparator) {

		return _allertaValangheStatoLocalService.
			getAllertaValangheStatosByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of allerta valanghe statos.
	 *
	 * @return the number of allerta valanghe statos
	 */
	@Override
	public int getAllertaValangheStatosCount() {
		return _allertaValangheStatoLocalService.
			getAllertaValangheStatosCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _allertaValangheStatoLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _allertaValangheStatoLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _allertaValangheStatoLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allertaValangheStatoLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the allerta valanghe stato in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param allertaValangheStato the allerta valanghe stato
	 * @return the allerta valanghe stato that was updated
	 */
	@Override
	public it.eng.allerter.model.AllertaValangheStato
		updateAllertaValangheStato(
			it.eng.allerter.model.AllertaValangheStato allertaValangheStato) {

		return _allertaValangheStatoLocalService.updateAllertaValangheStato(
			allertaValangheStato);
	}

	@Override
	public AllertaValangheStatoLocalService getWrappedService() {
		return _allertaValangheStatoLocalService;
	}

	@Override
	public void setWrappedService(
		AllertaValangheStatoLocalService allertaValangheStatoLocalService) {

		_allertaValangheStatoLocalService = allertaValangheStatoLocalService;
	}

	private AllertaValangheStatoLocalService _allertaValangheStatoLocalService;

}