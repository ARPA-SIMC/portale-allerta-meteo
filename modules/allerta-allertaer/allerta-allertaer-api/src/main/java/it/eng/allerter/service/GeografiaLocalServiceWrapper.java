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
 * Provides a wrapper for {@link GeografiaLocalService}.
 *
 * @author GFAVINI
 * @see GeografiaLocalService
 * @generated
 */
@ProviderType
public class GeografiaLocalServiceWrapper
	implements GeografiaLocalService, ServiceWrapper<GeografiaLocalService> {

	public GeografiaLocalServiceWrapper(
		GeografiaLocalService geografiaLocalService) {

		_geografiaLocalService = geografiaLocalService;
	}

	/**
	 * Adds the geografia to the database. Also notifies the appropriate model listeners.
	 *
	 * @param geografia the geografia
	 * @return the geografia that was added
	 */
	@Override
	public it.eng.allerter.model.Geografia addGeografia(
		it.eng.allerter.model.Geografia geografia) {

		return _geografiaLocalService.addGeografia(geografia);
	}

	/**
	 * Creates a new geografia with the primary key. Does not add the geografia to the database.
	 *
	 * @param geografiaPK the primary key for the new geografia
	 * @return the new geografia
	 */
	@Override
	public it.eng.allerter.model.Geografia createGeografia(
		it.eng.allerter.service.persistence.GeografiaPK geografiaPK) {

		return _geografiaLocalService.createGeografia(geografiaPK);
	}

	/**
	 * Deletes the geografia from the database. Also notifies the appropriate model listeners.
	 *
	 * @param geografia the geografia
	 * @return the geografia that was removed
	 */
	@Override
	public it.eng.allerter.model.Geografia deleteGeografia(
		it.eng.allerter.model.Geografia geografia) {

		return _geografiaLocalService.deleteGeografia(geografia);
	}

	/**
	 * Deletes the geografia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param geografiaPK the primary key of the geografia
	 * @return the geografia that was removed
	 * @throws PortalException if a geografia with the primary key could not be found
	 */
	@Override
	public it.eng.allerter.model.Geografia deleteGeografia(
			it.eng.allerter.service.persistence.GeografiaPK geografiaPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _geografiaLocalService.deleteGeografia(geografiaPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _geografiaLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _geografiaLocalService.dynamicQuery();
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

		return _geografiaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _geografiaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _geografiaLocalService.dynamicQuery(
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

		return _geografiaLocalService.dynamicQueryCount(dynamicQuery);
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

		return _geografiaLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.allerter.model.Geografia fetchGeografia(
		it.eng.allerter.service.persistence.GeografiaPK geografiaPK) {

		return _geografiaLocalService.fetchGeografia(geografiaPK);
	}

	@Override
	public java.util.List<it.eng.allerter.model.Geografia>
		findByAreaComplessita(String area, String compl) {

		return _geografiaLocalService.findByAreaComplessita(area, compl);
	}

	@Override
	public java.util.List<it.eng.allerter.model.Geografia> findByIdComplessita(
		String id, String compl) {

		return _geografiaLocalService.findByIdComplessita(id, compl);
	}

	/**
	 * Returns the geografia with the primary key.
	 *
	 * @param geografiaPK the primary key of the geografia
	 * @return the geografia
	 * @throws PortalException if a geografia with the primary key could not be found
	 */
	@Override
	public it.eng.allerter.model.Geografia getGeografia(
			it.eng.allerter.service.persistence.GeografiaPK geografiaPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _geografiaLocalService.getGeografia(geografiaPK);
	}

	/**
	 * Returns a range of all the geografias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.GeografiaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of geografias
	 * @param end the upper bound of the range of geografias (not inclusive)
	 * @return the range of geografias
	 */
	@Override
	public java.util.List<it.eng.allerter.model.Geografia> getGeografias(
		int start, int end) {

		return _geografiaLocalService.getGeografias(start, end);
	}

	/**
	 * Returns the number of geografias.
	 *
	 * @return the number of geografias
	 */
	@Override
	public int getGeografiasCount() {
		return _geografiaLocalService.getGeografiasCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _geografiaLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _geografiaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the geografia in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param geografia the geografia
	 * @return the geografia that was updated
	 */
	@Override
	public it.eng.allerter.model.Geografia updateGeografia(
		it.eng.allerter.model.Geografia geografia) {

		return _geografiaLocalService.updateGeografia(geografia);
	}

	@Override
	public GeografiaLocalService getWrappedService() {
		return _geografiaLocalService;
	}

	@Override
	public void setWrappedService(GeografiaLocalService geografiaLocalService) {
		_geografiaLocalService = geografiaLocalService;
	}

	private GeografiaLocalService _geografiaLocalService;

}