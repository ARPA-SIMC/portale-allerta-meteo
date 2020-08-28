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
 * Provides a wrapper for {@link StatoAllertamentoLocalService}.
 *
 * @author GFAVINI
 * @see StatoAllertamentoLocalService
 * @generated
 */
@ProviderType
public class StatoAllertamentoLocalServiceWrapper
	implements StatoAllertamentoLocalService,
			   ServiceWrapper<StatoAllertamentoLocalService> {

	public StatoAllertamentoLocalServiceWrapper(
		StatoAllertamentoLocalService statoAllertamentoLocalService) {

		_statoAllertamentoLocalService = statoAllertamentoLocalService;
	}

	/**
	 * Adds the stato allertamento to the database. Also notifies the appropriate model listeners.
	 *
	 * @param statoAllertamento the stato allertamento
	 * @return the stato allertamento that was added
	 */
	@Override
	public it.eng.allerter.model.StatoAllertamento addStatoAllertamento(
		it.eng.allerter.model.StatoAllertamento statoAllertamento) {

		return _statoAllertamentoLocalService.addStatoAllertamento(
			statoAllertamento);
	}

	/**
	 * Creates a new stato allertamento with the primary key. Does not add the stato allertamento to the database.
	 *
	 * @param statoId the primary key for the new stato allertamento
	 * @return the new stato allertamento
	 */
	@Override
	public it.eng.allerter.model.StatoAllertamento createStatoAllertamento(
		long statoId) {

		return _statoAllertamentoLocalService.createStatoAllertamento(statoId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _statoAllertamentoLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the stato allertamento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param statoId the primary key of the stato allertamento
	 * @return the stato allertamento that was removed
	 * @throws PortalException if a stato allertamento with the primary key could not be found
	 */
	@Override
	public it.eng.allerter.model.StatoAllertamento deleteStatoAllertamento(
			long statoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _statoAllertamentoLocalService.deleteStatoAllertamento(statoId);
	}

	/**
	 * Deletes the stato allertamento from the database. Also notifies the appropriate model listeners.
	 *
	 * @param statoAllertamento the stato allertamento
	 * @return the stato allertamento that was removed
	 */
	@Override
	public it.eng.allerter.model.StatoAllertamento deleteStatoAllertamento(
		it.eng.allerter.model.StatoAllertamento statoAllertamento) {

		return _statoAllertamentoLocalService.deleteStatoAllertamento(
			statoAllertamento);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _statoAllertamentoLocalService.dynamicQuery();
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

		return _statoAllertamentoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.StatoAllertamentoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _statoAllertamentoLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.StatoAllertamentoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _statoAllertamentoLocalService.dynamicQuery(
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

		return _statoAllertamentoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _statoAllertamentoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.allerter.model.StatoAllertamento fetchStatoAllertamento(
		long statoId) {

		return _statoAllertamentoLocalService.fetchStatoAllertamento(statoId);
	}

	/**
	 * Returns the stato allertamento matching the UUID and group.
	 *
	 * @param uuid the stato allertamento's UUID
	 * @param groupId the primary key of the group
	 * @return the matching stato allertamento, or <code>null</code> if a matching stato allertamento could not be found
	 */
	@Override
	public it.eng.allerter.model.StatoAllertamento
		fetchStatoAllertamentoByUuidAndGroupId(String uuid, long groupId) {

		return _statoAllertamentoLocalService.
			fetchStatoAllertamentoByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _statoAllertamentoLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _statoAllertamentoLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _statoAllertamentoLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _statoAllertamentoLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _statoAllertamentoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the stato allertamento with the primary key.
	 *
	 * @param statoId the primary key of the stato allertamento
	 * @return the stato allertamento
	 * @throws PortalException if a stato allertamento with the primary key could not be found
	 */
	@Override
	public it.eng.allerter.model.StatoAllertamento getStatoAllertamento(
			long statoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _statoAllertamentoLocalService.getStatoAllertamento(statoId);
	}

	/**
	 * Returns the stato allertamento matching the UUID and group.
	 *
	 * @param uuid the stato allertamento's UUID
	 * @param groupId the primary key of the group
	 * @return the matching stato allertamento
	 * @throws PortalException if a matching stato allertamento could not be found
	 */
	@Override
	public it.eng.allerter.model.StatoAllertamento
			getStatoAllertamentoByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _statoAllertamentoLocalService.
			getStatoAllertamentoByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the stato allertamentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.StatoAllertamentoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stato allertamentos
	 * @param end the upper bound of the range of stato allertamentos (not inclusive)
	 * @return the range of stato allertamentos
	 */
	@Override
	public java.util.List<it.eng.allerter.model.StatoAllertamento>
		getStatoAllertamentos(int start, int end) {

		return _statoAllertamentoLocalService.getStatoAllertamentos(start, end);
	}

	/**
	 * Returns all the stato allertamentos matching the UUID and company.
	 *
	 * @param uuid the UUID of the stato allertamentos
	 * @param companyId the primary key of the company
	 * @return the matching stato allertamentos, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.eng.allerter.model.StatoAllertamento>
		getStatoAllertamentosByUuidAndCompanyId(String uuid, long companyId) {

		return _statoAllertamentoLocalService.
			getStatoAllertamentosByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of stato allertamentos matching the UUID and company.
	 *
	 * @param uuid the UUID of the stato allertamentos
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of stato allertamentos
	 * @param end the upper bound of the range of stato allertamentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching stato allertamentos, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.eng.allerter.model.StatoAllertamento>
		getStatoAllertamentosByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.eng.allerter.model.StatoAllertamento> orderByComparator) {

		return _statoAllertamentoLocalService.
			getStatoAllertamentosByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of stato allertamentos.
	 *
	 * @return the number of stato allertamentos
	 */
	@Override
	public int getStatoAllertamentosCount() {
		return _statoAllertamentoLocalService.getStatoAllertamentosCount();
	}

	/**
	 * Updates the stato allertamento in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param statoAllertamento the stato allertamento
	 * @return the stato allertamento that was updated
	 */
	@Override
	public it.eng.allerter.model.StatoAllertamento updateStatoAllertamento(
		it.eng.allerter.model.StatoAllertamento statoAllertamento) {

		return _statoAllertamentoLocalService.updateStatoAllertamento(
			statoAllertamento);
	}

	@Override
	public StatoAllertamentoLocalService getWrappedService() {
		return _statoAllertamentoLocalService;
	}

	@Override
	public void setWrappedService(
		StatoAllertamentoLocalService statoAllertamentoLocalService) {

		_statoAllertamentoLocalService = statoAllertamentoLocalService;
	}

	private StatoAllertamentoLocalService _statoAllertamentoLocalService;

}