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
 * Provides a wrapper for {@link AllertaStatoLocalService}.
 *
 * @author GFAVINI
 * @see AllertaStatoLocalService
 * @generated
 */
@ProviderType
public class AllertaStatoLocalServiceWrapper
	implements AllertaStatoLocalService,
			   ServiceWrapper<AllertaStatoLocalService> {

	public AllertaStatoLocalServiceWrapper(
		AllertaStatoLocalService allertaStatoLocalService) {

		_allertaStatoLocalService = allertaStatoLocalService;
	}

	/**
	 * Adds the allerta stato to the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaStato the allerta stato
	 * @return the allerta stato that was added
	 */
	@Override
	public it.eng.allerter.model.AllertaStato addAllertaStato(
		it.eng.allerter.model.AllertaStato allertaStato) {

		return _allertaStatoLocalService.addAllertaStato(allertaStato);
	}

	/**
	 * Creates a new allerta stato with the primary key. Does not add the allerta stato to the database.
	 *
	 * @param allertaStatoId the primary key for the new allerta stato
	 * @return the new allerta stato
	 */
	@Override
	public it.eng.allerter.model.AllertaStato createAllertaStato(
		long allertaStatoId) {

		return _allertaStatoLocalService.createAllertaStato(allertaStatoId);
	}

	/**
	 * Deletes the allerta stato from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaStato the allerta stato
	 * @return the allerta stato that was removed
	 */
	@Override
	public it.eng.allerter.model.AllertaStato deleteAllertaStato(
		it.eng.allerter.model.AllertaStato allertaStato) {

		return _allertaStatoLocalService.deleteAllertaStato(allertaStato);
	}

	/**
	 * Deletes the allerta stato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaStatoId the primary key of the allerta stato
	 * @return the allerta stato that was removed
	 * @throws PortalException if a allerta stato with the primary key could not be found
	 */
	@Override
	public it.eng.allerter.model.AllertaStato deleteAllertaStato(
			long allertaStatoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allertaStatoLocalService.deleteAllertaStato(allertaStatoId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allertaStatoLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _allertaStatoLocalService.dynamicQuery();
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

		return _allertaStatoLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _allertaStatoLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _allertaStatoLocalService.dynamicQuery(
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

		return _allertaStatoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _allertaStatoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.allerter.model.AllertaStato fetchAllertaStato(
		long allertaStatoId) {

		return _allertaStatoLocalService.fetchAllertaStato(allertaStatoId);
	}

	/**
	 * Returns the allerta stato matching the UUID and group.
	 *
	 * @param uuid the allerta stato's UUID
	 * @param groupId the primary key of the group
	 * @return the matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	@Override
	public it.eng.allerter.model.AllertaStato fetchAllertaStatoByUuidAndGroupId(
		String uuid, long groupId) {

		return _allertaStatoLocalService.fetchAllertaStatoByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _allertaStatoLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the allerta stato with the primary key.
	 *
	 * @param allertaStatoId the primary key of the allerta stato
	 * @return the allerta stato
	 * @throws PortalException if a allerta stato with the primary key could not be found
	 */
	@Override
	public it.eng.allerter.model.AllertaStato getAllertaStato(
			long allertaStatoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allertaStatoLocalService.getAllertaStato(allertaStatoId);
	}

	@Override
	public java.util.List<it.eng.allerter.model.AllertaStato>
		getAllertaStatoByAllerta(long allertaId) {

		return _allertaStatoLocalService.getAllertaStatoByAllerta(allertaId);
	}

	/**
	 * Returns the allerta stato matching the UUID and group.
	 *
	 * @param uuid the allerta stato's UUID
	 * @param groupId the primary key of the group
	 * @return the matching allerta stato
	 * @throws PortalException if a matching allerta stato could not be found
	 */
	@Override
	public it.eng.allerter.model.AllertaStato getAllertaStatoByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allertaStatoLocalService.getAllertaStatoByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<it.eng.allerter.model.AllertaStato> getAllertaStatos(
		int start, int end) {

		return _allertaStatoLocalService.getAllertaStatos(start, end);
	}

	/**
	 * Returns all the allerta statos matching the UUID and company.
	 *
	 * @param uuid the UUID of the allerta statos
	 * @param companyId the primary key of the company
	 * @return the matching allerta statos, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.eng.allerter.model.AllertaStato>
		getAllertaStatosByUuidAndCompanyId(String uuid, long companyId) {

		return _allertaStatoLocalService.getAllertaStatosByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<it.eng.allerter.model.AllertaStato>
		getAllertaStatosByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.eng.allerter.model.AllertaStato> orderByComparator) {

		return _allertaStatoLocalService.getAllertaStatosByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of allerta statos.
	 *
	 * @return the number of allerta statos
	 */
	@Override
	public int getAllertaStatosCount() {
		return _allertaStatoLocalService.getAllertaStatosCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _allertaStatoLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _allertaStatoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _allertaStatoLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allertaStatoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the allerta stato in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param allertaStato the allerta stato
	 * @return the allerta stato that was updated
	 */
	@Override
	public it.eng.allerter.model.AllertaStato updateAllertaStato(
		it.eng.allerter.model.AllertaStato allertaStato) {

		return _allertaStatoLocalService.updateAllertaStato(allertaStato);
	}

	@Override
	public AllertaStatoLocalService getWrappedService() {
		return _allertaStatoLocalService;
	}

	@Override
	public void setWrappedService(
		AllertaStatoLocalService allertaStatoLocalService) {

		_allertaStatoLocalService = allertaStatoLocalService;
	}

	private AllertaStatoLocalService _allertaStatoLocalService;

}