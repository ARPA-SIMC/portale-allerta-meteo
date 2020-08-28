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
 * Provides a wrapper for {@link BollettinoBacinoLocalService}.
 *
 * @author GFAVINI
 * @see BollettinoBacinoLocalService
 * @generated
 */
@ProviderType
public class BollettinoBacinoLocalServiceWrapper
	implements BollettinoBacinoLocalService,
			   ServiceWrapper<BollettinoBacinoLocalService> {

	public BollettinoBacinoLocalServiceWrapper(
		BollettinoBacinoLocalService bollettinoBacinoLocalService) {

		_bollettinoBacinoLocalService = bollettinoBacinoLocalService;
	}

	/**
	 * Adds the bollettino bacino to the database. Also notifies the appropriate model listeners.
	 *
	 * @param bollettinoBacino the bollettino bacino
	 * @return the bollettino bacino that was added
	 */
	@Override
	public it.eng.bollettino.model.BollettinoBacino addBollettinoBacino(
		it.eng.bollettino.model.BollettinoBacino bollettinoBacino) {

		return _bollettinoBacinoLocalService.addBollettinoBacino(
			bollettinoBacino);
	}

	/**
	 * Creates a new bollettino bacino with the primary key. Does not add the bollettino bacino to the database.
	 *
	 * @param id the primary key for the new bollettino bacino
	 * @return the new bollettino bacino
	 */
	@Override
	public it.eng.bollettino.model.BollettinoBacino createBollettinoBacino(
		long id) {

		return _bollettinoBacinoLocalService.createBollettinoBacino(id);
	}

	/**
	 * Deletes the bollettino bacino from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bollettinoBacino the bollettino bacino
	 * @return the bollettino bacino that was removed
	 */
	@Override
	public it.eng.bollettino.model.BollettinoBacino deleteBollettinoBacino(
		it.eng.bollettino.model.BollettinoBacino bollettinoBacino) {

		return _bollettinoBacinoLocalService.deleteBollettinoBacino(
			bollettinoBacino);
	}

	/**
	 * Deletes the bollettino bacino with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the bollettino bacino
	 * @return the bollettino bacino that was removed
	 * @throws PortalException if a bollettino bacino with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.BollettinoBacino deleteBollettinoBacino(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bollettinoBacinoLocalService.deleteBollettinoBacino(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bollettinoBacinoLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bollettinoBacinoLocalService.dynamicQuery();
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

		return _bollettinoBacinoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.BollettinoBacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _bollettinoBacinoLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.BollettinoBacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _bollettinoBacinoLocalService.dynamicQuery(
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

		return _bollettinoBacinoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _bollettinoBacinoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.bollettino.model.BollettinoBacino fetchBollettinoBacino(
		long id) {

		return _bollettinoBacinoLocalService.fetchBollettinoBacino(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _bollettinoBacinoLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<it.eng.bollettino.model.BollettinoBacino>
		getBaciniByBollettino(long bollettinoId) {

		return _bollettinoBacinoLocalService.getBaciniByBollettino(
			bollettinoId);
	}

	/**
	 * Returns the bollettino bacino with the primary key.
	 *
	 * @param id the primary key of the bollettino bacino
	 * @return the bollettino bacino
	 * @throws PortalException if a bollettino bacino with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.BollettinoBacino getBollettinoBacino(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bollettinoBacinoLocalService.getBollettinoBacino(id);
	}

	/**
	 * Returns a range of all the bollettino bacinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.BollettinoBacinoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino bacinos
	 * @param end the upper bound of the range of bollettino bacinos (not inclusive)
	 * @return the range of bollettino bacinos
	 */
	@Override
	public java.util.List<it.eng.bollettino.model.BollettinoBacino>
		getBollettinoBacinos(int start, int end) {

		return _bollettinoBacinoLocalService.getBollettinoBacinos(start, end);
	}

	/**
	 * Returns the number of bollettino bacinos.
	 *
	 * @return the number of bollettino bacinos
	 */
	@Override
	public int getBollettinoBacinosCount() {
		return _bollettinoBacinoLocalService.getBollettinoBacinosCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _bollettinoBacinoLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bollettinoBacinoLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bollettinoBacinoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the bollettino bacino in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param bollettinoBacino the bollettino bacino
	 * @return the bollettino bacino that was updated
	 */
	@Override
	public it.eng.bollettino.model.BollettinoBacino updateBollettinoBacino(
		it.eng.bollettino.model.BollettinoBacino bollettinoBacino) {

		return _bollettinoBacinoLocalService.updateBollettinoBacino(
			bollettinoBacino);
	}

	@Override
	public BollettinoBacinoLocalService getWrappedService() {
		return _bollettinoBacinoLocalService;
	}

	@Override
	public void setWrappedService(
		BollettinoBacinoLocalService bollettinoBacinoLocalService) {

		_bollettinoBacinoLocalService = bollettinoBacinoLocalService;
	}

	private BollettinoBacinoLocalService _bollettinoBacinoLocalService;

}