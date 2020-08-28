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
 * Provides a wrapper for {@link BollettinoLocalService}.
 *
 * @author GFAVINI
 * @see BollettinoLocalService
 * @generated
 */
@ProviderType
public class BollettinoLocalServiceWrapper
	implements BollettinoLocalService, ServiceWrapper<BollettinoLocalService> {

	public BollettinoLocalServiceWrapper(
		BollettinoLocalService bollettinoLocalService) {

		_bollettinoLocalService = bollettinoLocalService;
	}

	/**
	 * Adds the bollettino to the database. Also notifies the appropriate model listeners.
	 *
	 * @param bollettino the bollettino
	 * @return the bollettino that was added
	 */
	@Override
	public it.eng.bollettino.model.Bollettino addBollettino(
		it.eng.bollettino.model.Bollettino bollettino) {

		return _bollettinoLocalService.addBollettino(bollettino);
	}

	@Override
	public void cessatiTuttiAllarmiFiumi() {
		_bollettinoLocalService.cessatiTuttiAllarmiFiumi();
	}

	@Override
	public void cessatoAllarmeFiume(
		it.eng.bollettino.model.AttivazioneFiume fiume) {

		_bollettinoLocalService.cessatoAllarmeFiume(fiume);
	}

	/**
	 * Creates a new bollettino with the primary key. Does not add the bollettino to the database.
	 *
	 * @param bollettinoId the primary key for the new bollettino
	 * @return the new bollettino
	 */
	@Override
	public it.eng.bollettino.model.Bollettino createBollettino(
		long bollettinoId) {

		return _bollettinoLocalService.createBollettino(bollettinoId);
	}

	/**
	 * Deletes the bollettino from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bollettino the bollettino
	 * @return the bollettino that was removed
	 */
	@Override
	public it.eng.bollettino.model.Bollettino deleteBollettino(
		it.eng.bollettino.model.Bollettino bollettino) {

		return _bollettinoLocalService.deleteBollettino(bollettino);
	}

	/**
	 * Deletes the bollettino with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bollettinoId the primary key of the bollettino
	 * @return the bollettino that was removed
	 * @throws PortalException if a bollettino with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.Bollettino deleteBollettino(
			long bollettinoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bollettinoLocalService.deleteBollettino(bollettinoId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bollettinoLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bollettinoLocalService.dynamicQuery();
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

		return _bollettinoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.BollettinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _bollettinoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.BollettinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _bollettinoLocalService.dynamicQuery(
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

		return _bollettinoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _bollettinoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public Object eseguiQueryGenerica(String q) {
		return _bollettinoLocalService.eseguiQueryGenerica(q);
	}

	@Override
	public java.util.List eseguiQueryGenericaLista(String q) {
		return _bollettinoLocalService.eseguiQueryGenericaLista(q);
	}

	@Override
	public it.eng.bollettino.model.Bollettino fetchBollettino(
		long bollettinoId) {

		return _bollettinoLocalService.fetchBollettino(bollettinoId);
	}

	/**
	 * Returns the bollettino matching the UUID and group.
	 *
	 * @param uuid the bollettino's UUID
	 * @param groupId the primary key of the group
	 * @return the matching bollettino, or <code>null</code> if a matching bollettino could not be found
	 */
	@Override
	public it.eng.bollettino.model.Bollettino fetchBollettinoByUuidAndGroupId(
		String uuid, long groupId) {

		return _bollettinoLocalService.fetchBollettinoByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public void fileDeleteByApp(
		long scopeGroup, String file, String folderName) {

		_bollettinoLocalService.fileDeleteByApp(scopeGroup, file, folderName);
	}

	@Override
	public void fileDeleteByApp(
		String file, String folderName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		_bollettinoLocalService.fileDeleteByApp(
			file, folderName, serviceContext);
	}

	@Override
	public void fileUploadByApp(
		java.io.File file, String folderName, String title, String description,
		String mimeType,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		_bollettinoLocalService.fileUploadByApp(
			file, folderName, title, description, mimeType, serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _bollettinoLocalService.getActionableDynamicQuery();
	}

	@Override
	public long getApprovatore(long idBollettino) {
		return _bollettinoLocalService.getApprovatore(idBollettino);
	}

	/**
	 * Returns the bollettino with the primary key.
	 *
	 * @param bollettinoId the primary key of the bollettino
	 * @return the bollettino
	 * @throws PortalException if a bollettino with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.Bollettino getBollettino(long bollettinoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bollettinoLocalService.getBollettino(bollettinoId);
	}

	/**
	 * Returns the bollettino matching the UUID and group.
	 *
	 * @param uuid the bollettino's UUID
	 * @param groupId the primary key of the group
	 * @return the matching bollettino
	 * @throws PortalException if a matching bollettino could not be found
	 */
	@Override
	public it.eng.bollettino.model.Bollettino getBollettinoByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bollettinoLocalService.getBollettinoByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the bollettinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.BollettinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @return the range of bollettinos
	 */
	@Override
	public java.util.List<it.eng.bollettino.model.Bollettino> getBollettinos(
		int start, int end) {

		return _bollettinoLocalService.getBollettinos(start, end);
	}

	/**
	 * Returns all the bollettinos matching the UUID and company.
	 *
	 * @param uuid the UUID of the bollettinos
	 * @param companyId the primary key of the company
	 * @return the matching bollettinos, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.eng.bollettino.model.Bollettino>
		getBollettinosByUuidAndCompanyId(String uuid, long companyId) {

		return _bollettinoLocalService.getBollettinosByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of bollettinos matching the UUID and company.
	 *
	 * @param uuid the UUID of the bollettinos
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of bollettinos
	 * @param end the upper bound of the range of bollettinos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching bollettinos, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.eng.bollettino.model.Bollettino>
		getBollettinosByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.eng.bollettino.model.Bollettino> orderByComparator) {

		return _bollettinoLocalService.getBollettinosByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of bollettinos.
	 *
	 * @return the number of bollettinos
	 */
	@Override
	public int getBollettinosCount() {
		return _bollettinoLocalService.getBollettinosCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _bollettinoLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public java.util.List<Object> getFiumiBollettino(long id) {
		return _bollettinoLocalService.getFiumiBollettino(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _bollettinoLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<it.eng.bollettino.model.Bollettino>
		getListaBollettiniMonitoraggio() {

		return _bollettinoLocalService.getListaBollettiniMonitoraggio();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bollettinoLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bollettinoLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public double getSommaValori(
		String idStazione, String idVariabile, int quanti) {

		return _bollettinoLocalService.getSommaValori(
			idStazione, idVariabile, quanti);
	}

	@Override
	public String nextIdMonitoraggio(int anno) {
		return _bollettinoLocalService.nextIdMonitoraggio(anno);
	}

	@Override
	public void terminaMonitoraggio() {
		_bollettinoLocalService.terminaMonitoraggio();
	}

	/**
	 * Updates the bollettino in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param bollettino the bollettino
	 * @return the bollettino that was updated
	 */
	@Override
	public it.eng.bollettino.model.Bollettino updateBollettino(
		it.eng.bollettino.model.Bollettino bollettino) {

		return _bollettinoLocalService.updateBollettino(bollettino);
	}

	@Override
	public BollettinoLocalService getWrappedService() {
		return _bollettinoLocalService;
	}

	@Override
	public void setWrappedService(
		BollettinoLocalService bollettinoLocalService) {

		_bollettinoLocalService = bollettinoLocalService;
	}

	private BollettinoLocalService _bollettinoLocalService;

}