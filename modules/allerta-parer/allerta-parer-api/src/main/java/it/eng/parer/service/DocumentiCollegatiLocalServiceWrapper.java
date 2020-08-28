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

package it.eng.parer.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DocumentiCollegatiLocalService}.
 *
 * @author Pratola_L
 * @see DocumentiCollegatiLocalService
 * @generated
 */
@ProviderType
public class DocumentiCollegatiLocalServiceWrapper
	implements DocumentiCollegatiLocalService,
			   ServiceWrapper<DocumentiCollegatiLocalService> {

	public DocumentiCollegatiLocalServiceWrapper(
		DocumentiCollegatiLocalService documentiCollegatiLocalService) {

		_documentiCollegatiLocalService = documentiCollegatiLocalService;
	}

	/**
	 * Adds the documenti collegati to the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentiCollegati the documenti collegati
	 * @return the documenti collegati that was added
	 */
	@Override
	public it.eng.parer.model.DocumentiCollegati addDocumentiCollegati(
		it.eng.parer.model.DocumentiCollegati documentiCollegati) {

		return _documentiCollegatiLocalService.addDocumentiCollegati(
			documentiCollegati);
	}

	/**
	 * Creates a new documenti collegati with the primary key. Does not add the documenti collegati to the database.
	 *
	 * @param documentiCollegatiPK the primary key for the new documenti collegati
	 * @return the new documenti collegati
	 */
	@Override
	public it.eng.parer.model.DocumentiCollegati createDocumentiCollegati(
		it.eng.parer.service.persistence.DocumentiCollegatiPK
			documentiCollegatiPK) {

		return _documentiCollegatiLocalService.createDocumentiCollegati(
			documentiCollegatiPK);
	}

	/**
	 * Deletes the documenti collegati from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentiCollegati the documenti collegati
	 * @return the documenti collegati that was removed
	 */
	@Override
	public it.eng.parer.model.DocumentiCollegati deleteDocumentiCollegati(
		it.eng.parer.model.DocumentiCollegati documentiCollegati) {

		return _documentiCollegatiLocalService.deleteDocumentiCollegati(
			documentiCollegati);
	}

	/**
	 * Deletes the documenti collegati with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentiCollegatiPK the primary key of the documenti collegati
	 * @return the documenti collegati that was removed
	 * @throws PortalException if a documenti collegati with the primary key could not be found
	 */
	@Override
	public it.eng.parer.model.DocumentiCollegati deleteDocumentiCollegati(
			it.eng.parer.service.persistence.DocumentiCollegatiPK
				documentiCollegatiPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentiCollegatiLocalService.deleteDocumentiCollegati(
			documentiCollegatiPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentiCollegatiLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _documentiCollegatiLocalService.dynamicQuery();
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

		return _documentiCollegatiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.parer.model.impl.DocumentiCollegatiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _documentiCollegatiLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.parer.model.impl.DocumentiCollegatiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _documentiCollegatiLocalService.dynamicQuery(
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

		return _documentiCollegatiLocalService.dynamicQueryCount(dynamicQuery);
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

		return _documentiCollegatiLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.parer.model.DocumentiCollegati fetchDocumentiCollegati(
		it.eng.parer.service.persistence.DocumentiCollegatiPK
			documentiCollegatiPK) {

		return _documentiCollegatiLocalService.fetchDocumentiCollegati(
			documentiCollegatiPK);
	}

	/**
	 * Returns the documenti collegati with the primary key.
	 *
	 * @param documentiCollegatiPK the primary key of the documenti collegati
	 * @return the documenti collegati
	 * @throws PortalException if a documenti collegati with the primary key could not be found
	 */
	@Override
	public it.eng.parer.model.DocumentiCollegati getDocumentiCollegati(
			it.eng.parer.service.persistence.DocumentiCollegatiPK
				documentiCollegatiPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentiCollegatiLocalService.getDocumentiCollegati(
			documentiCollegatiPK);
	}

	/**
	 * Returns a range of all the documenti collegatis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.parer.model.impl.DocumentiCollegatiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of documenti collegatis
	 * @param end the upper bound of the range of documenti collegatis (not inclusive)
	 * @return the range of documenti collegatis
	 */
	@Override
	public java.util.List<it.eng.parer.model.DocumentiCollegati>
		getDocumentiCollegatis(int start, int end) {

		return _documentiCollegatiLocalService.getDocumentiCollegatis(
			start, end);
	}

	/**
	 * Returns the number of documenti collegatis.
	 *
	 * @return the number of documenti collegatis
	 */
	@Override
	public int getDocumentiCollegatisCount() {
		return _documentiCollegatiLocalService.getDocumentiCollegatisCount();
	}

	@Override
	public it.eng.parer.model.DocumentiCollegati getNuovoDocumentoCollegato() {
		return _documentiCollegatiLocalService.getNuovoDocumentoCollegato();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _documentiCollegatiLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentiCollegatiLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the documenti collegati in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param documentiCollegati the documenti collegati
	 * @return the documenti collegati that was updated
	 */
	@Override
	public it.eng.parer.model.DocumentiCollegati updateDocumentiCollegati(
		it.eng.parer.model.DocumentiCollegati documentiCollegati) {

		return _documentiCollegatiLocalService.updateDocumentiCollegati(
			documentiCollegati);
	}

	@Override
	public DocumentiCollegatiLocalService getWrappedService() {
		return _documentiCollegatiLocalService;
	}

	@Override
	public void setWrappedService(
		DocumentiCollegatiLocalService documentiCollegatiLocalService) {

		_documentiCollegatiLocalService = documentiCollegatiLocalService;
	}

	private DocumentiCollegatiLocalService _documentiCollegatiLocalService;

}