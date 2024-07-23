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
 * Provides a wrapper for {@link altezzaOndaAdriacLocalService}.
 *
 * @author UTENTE
 * @see altezzaOndaAdriacLocalService
 * @generated
 */
@ProviderType
public class altezzaOndaAdriacLocalServiceWrapper
	implements altezzaOndaAdriacLocalService,
			   ServiceWrapper<altezzaOndaAdriacLocalService> {

	public altezzaOndaAdriacLocalServiceWrapper(
		altezzaOndaAdriacLocalService altezzaOndaAdriacLocalService) {

		_altezzaOndaAdriacLocalService = altezzaOndaAdriacLocalService;
	}

	/**
	 * Adds the altezza onda adriac to the database. Also notifies the appropriate model listeners.
	 *
	 * @param altezzaOndaAdriac the altezza onda adriac
	 * @return the altezza onda adriac that was added
	 */
	@Override
	public it.eng.animazione.image.model.altezzaOndaAdriac addaltezzaOndaAdriac(
		it.eng.animazione.image.model.altezzaOndaAdriac altezzaOndaAdriac) {

		return _altezzaOndaAdriacLocalService.addaltezzaOndaAdriac(
			altezzaOndaAdriac);
	}

	/**
	 * Creates a new altezza onda adriac with the primary key. Does not add the altezza onda adriac to the database.
	 *
	 * @param id the primary key for the new altezza onda adriac
	 * @return the new altezza onda adriac
	 */
	@Override
	public it.eng.animazione.image.model.altezzaOndaAdriac
		createaltezzaOndaAdriac(long id) {

		return _altezzaOndaAdriacLocalService.createaltezzaOndaAdriac(id);
	}

	/**
	 * Deletes the altezza onda adriac from the database. Also notifies the appropriate model listeners.
	 *
	 * @param altezzaOndaAdriac the altezza onda adriac
	 * @return the altezza onda adriac that was removed
	 */
	@Override
	public it.eng.animazione.image.model.altezzaOndaAdriac
		deletealtezzaOndaAdriac(
			it.eng.animazione.image.model.altezzaOndaAdriac altezzaOndaAdriac) {

		return _altezzaOndaAdriacLocalService.deletealtezzaOndaAdriac(
			altezzaOndaAdriac);
	}

	/**
	 * Deletes the altezza onda adriac with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the altezza onda adriac
	 * @return the altezza onda adriac that was removed
	 * @throws PortalException if a altezza onda adriac with the primary key could not be found
	 */
	@Override
	public it.eng.animazione.image.model.altezzaOndaAdriac
			deletealtezzaOndaAdriac(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _altezzaOndaAdriacLocalService.deletealtezzaOndaAdriac(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _altezzaOndaAdriacLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _altezzaOndaAdriacLocalService.dynamicQuery();
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

		return _altezzaOndaAdriacLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.animazione.image.model.impl.altezzaOndaAdriacModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _altezzaOndaAdriacLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.animazione.image.model.impl.altezzaOndaAdriacModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _altezzaOndaAdriacLocalService.dynamicQuery(
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

		return _altezzaOndaAdriacLocalService.dynamicQueryCount(dynamicQuery);
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

		return _altezzaOndaAdriacLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.animazione.image.model.altezzaOndaAdriac
		fetchaltezzaOndaAdriac(long id) {

		return _altezzaOndaAdriacLocalService.fetchaltezzaOndaAdriac(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _altezzaOndaAdriacLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the altezza onda adriac with the primary key.
	 *
	 * @param id the primary key of the altezza onda adriac
	 * @return the altezza onda adriac
	 * @throws PortalException if a altezza onda adriac with the primary key could not be found
	 */
	@Override
	public it.eng.animazione.image.model.altezzaOndaAdriac getaltezzaOndaAdriac(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _altezzaOndaAdriacLocalService.getaltezzaOndaAdriac(id);
	}

	/**
	 * Returns a range of all the altezza onda adriacs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.animazione.image.model.impl.altezzaOndaAdriacModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of altezza onda adriacs
	 * @param end the upper bound of the range of altezza onda adriacs (not inclusive)
	 * @return the range of altezza onda adriacs
	 */
	@Override
	public java.util.List<it.eng.animazione.image.model.altezzaOndaAdriac>
		getaltezzaOndaAdriacs(int start, int end) {

		return _altezzaOndaAdriacLocalService.getaltezzaOndaAdriacs(start, end);
	}

	/**
	 * Returns the number of altezza onda adriacs.
	 *
	 * @return the number of altezza onda adriacs
	 */
	@Override
	public int getaltezzaOndaAdriacsCount() {
		return _altezzaOndaAdriacLocalService.getaltezzaOndaAdriacsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _altezzaOndaAdriacLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _altezzaOndaAdriacLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _altezzaOndaAdriacLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the altezza onda adriac in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param altezzaOndaAdriac the altezza onda adriac
	 * @return the altezza onda adriac that was updated
	 */
	@Override
	public it.eng.animazione.image.model.altezzaOndaAdriac
		updatealtezzaOndaAdriac(
			it.eng.animazione.image.model.altezzaOndaAdriac altezzaOndaAdriac) {

		return _altezzaOndaAdriacLocalService.updatealtezzaOndaAdriac(
			altezzaOndaAdriac);
	}

	@Override
	public altezzaOndaAdriacLocalService getWrappedService() {
		return _altezzaOndaAdriacLocalService;
	}

	@Override
	public void setWrappedService(
		altezzaOndaAdriacLocalService altezzaOndaAdriacLocalService) {

		_altezzaOndaAdriacLocalService = altezzaOndaAdriacLocalService;
	}

	private altezzaOndaAdriacLocalService _altezzaOndaAdriacLocalService;

}