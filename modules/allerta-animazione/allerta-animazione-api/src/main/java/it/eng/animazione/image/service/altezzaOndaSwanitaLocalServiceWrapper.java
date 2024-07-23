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

package it.eng.animazione.image.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link altezzaOndaSwanitaLocalService}.
 *
 * @author UTENTE
 * @see altezzaOndaSwanitaLocalService
 * @generated
 */
@ProviderType
public class altezzaOndaSwanitaLocalServiceWrapper
	implements altezzaOndaSwanitaLocalService,
			   ServiceWrapper<altezzaOndaSwanitaLocalService> {

	public altezzaOndaSwanitaLocalServiceWrapper(
		altezzaOndaSwanitaLocalService altezzaOndaSwanitaLocalService) {

		_altezzaOndaSwanitaLocalService = altezzaOndaSwanitaLocalService;
	}

	/**
	 * Adds the altezza onda swanita to the database. Also notifies the appropriate model listeners.
	 *
	 * @param altezzaOndaSwanita the altezza onda swanita
	 * @return the altezza onda swanita that was added
	 */
	@Override
	public it.eng.animazione.image.model.altezzaOndaSwanita
		addaltezzaOndaSwanita(
			it.eng.animazione.image.model.altezzaOndaSwanita
				altezzaOndaSwanita) {

		return _altezzaOndaSwanitaLocalService.addaltezzaOndaSwanita(
			altezzaOndaSwanita);
	}

	/**
	 * Creates a new altezza onda swanita with the primary key. Does not add the altezza onda swanita to the database.
	 *
	 * @param id the primary key for the new altezza onda swanita
	 * @return the new altezza onda swanita
	 */
	@Override
	public it.eng.animazione.image.model.altezzaOndaSwanita
		createaltezzaOndaSwanita(long id) {

		return _altezzaOndaSwanitaLocalService.createaltezzaOndaSwanita(id);
	}

	/**
	 * Deletes the altezza onda swanita from the database. Also notifies the appropriate model listeners.
	 *
	 * @param altezzaOndaSwanita the altezza onda swanita
	 * @return the altezza onda swanita that was removed
	 */
	@Override
	public it.eng.animazione.image.model.altezzaOndaSwanita
		deletealtezzaOndaSwanita(
			it.eng.animazione.image.model.altezzaOndaSwanita
				altezzaOndaSwanita) {

		return _altezzaOndaSwanitaLocalService.deletealtezzaOndaSwanita(
			altezzaOndaSwanita);
	}

	/**
	 * Deletes the altezza onda swanita with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the altezza onda swanita
	 * @return the altezza onda swanita that was removed
	 * @throws PortalException if a altezza onda swanita with the primary key could not be found
	 */
	@Override
	public it.eng.animazione.image.model.altezzaOndaSwanita
			deletealtezzaOndaSwanita(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _altezzaOndaSwanitaLocalService.deletealtezzaOndaSwanita(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _altezzaOndaSwanitaLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _altezzaOndaSwanitaLocalService.dynamicQuery();
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

		return _altezzaOndaSwanitaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.animazione.image.model.impl.altezzaOndaSwanitaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _altezzaOndaSwanitaLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.animazione.image.model.impl.altezzaOndaSwanitaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _altezzaOndaSwanitaLocalService.dynamicQuery(
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

		return _altezzaOndaSwanitaLocalService.dynamicQueryCount(dynamicQuery);
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

		return _altezzaOndaSwanitaLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.animazione.image.model.altezzaOndaSwanita
		fetchaltezzaOndaSwanita(long id) {

		return _altezzaOndaSwanitaLocalService.fetchaltezzaOndaSwanita(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _altezzaOndaSwanitaLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the altezza onda swanita with the primary key.
	 *
	 * @param id the primary key of the altezza onda swanita
	 * @return the altezza onda swanita
	 * @throws PortalException if a altezza onda swanita with the primary key could not be found
	 */
	@Override
	public it.eng.animazione.image.model.altezzaOndaSwanita
			getaltezzaOndaSwanita(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _altezzaOndaSwanitaLocalService.getaltezzaOndaSwanita(id);
	}

	/**
	 * Returns a range of all the altezza onda swanitas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.animazione.image.model.impl.altezzaOndaSwanitaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza onda swanitas
	 * @param end the upper bound of the range of altezza onda swanitas (not inclusive)
	 * @return the range of altezza onda swanitas
	 */
	@Override
	public java.util.List<it.eng.animazione.image.model.altezzaOndaSwanita>
		getaltezzaOndaSwanitas(int start, int end) {

		return _altezzaOndaSwanitaLocalService.getaltezzaOndaSwanitas(
			start, end);
	}

	/**
	 * Returns the number of altezza onda swanitas.
	 *
	 * @return the number of altezza onda swanitas
	 */
	@Override
	public int getaltezzaOndaSwanitasCount() {
		return _altezzaOndaSwanitaLocalService.getaltezzaOndaSwanitasCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _altezzaOndaSwanitaLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _altezzaOndaSwanitaLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _altezzaOndaSwanitaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the altezza onda swanita in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param altezzaOndaSwanita the altezza onda swanita
	 * @return the altezza onda swanita that was updated
	 */
	@Override
	public it.eng.animazione.image.model.altezzaOndaSwanita
		updatealtezzaOndaSwanita(
			it.eng.animazione.image.model.altezzaOndaSwanita
				altezzaOndaSwanita) {

		return _altezzaOndaSwanitaLocalService.updatealtezzaOndaSwanita(
			altezzaOndaSwanita);
	}

	@Override
	public altezzaOndaSwanitaLocalService getWrappedService() {
		return _altezzaOndaSwanitaLocalService;
	}

	@Override
	public void setWrappedService(
		altezzaOndaSwanitaLocalService altezzaOndaSwanitaLocalService) {

		_altezzaOndaSwanitaLocalService = altezzaOndaSwanitaLocalService;
	}

	private altezzaOndaSwanitaLocalService _altezzaOndaSwanitaLocalService;

}