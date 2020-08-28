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
 * Provides a wrapper for {@link BollettinoIconaLocalService}.
 *
 * @author GFAVINI
 * @see BollettinoIconaLocalService
 * @generated
 */
@ProviderType
public class BollettinoIconaLocalServiceWrapper
	implements BollettinoIconaLocalService,
			   ServiceWrapper<BollettinoIconaLocalService> {

	public BollettinoIconaLocalServiceWrapper(
		BollettinoIconaLocalService bollettinoIconaLocalService) {

		_bollettinoIconaLocalService = bollettinoIconaLocalService;
	}

	/**
	 * Adds the bollettino icona to the database. Also notifies the appropriate model listeners.
	 *
	 * @param bollettinoIcona the bollettino icona
	 * @return the bollettino icona that was added
	 */
	@Override
	public it.eng.bollettino.model.BollettinoIcona addBollettinoIcona(
		it.eng.bollettino.model.BollettinoIcona bollettinoIcona) {

		return _bollettinoIconaLocalService.addBollettinoIcona(bollettinoIcona);
	}

	/**
	 * Creates a new bollettino icona with the primary key. Does not add the bollettino icona to the database.
	 *
	 * @param id the primary key for the new bollettino icona
	 * @return the new bollettino icona
	 */
	@Override
	public it.eng.bollettino.model.BollettinoIcona createBollettinoIcona(
		long id) {

		return _bollettinoIconaLocalService.createBollettinoIcona(id);
	}

	/**
	 * Deletes the bollettino icona from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bollettinoIcona the bollettino icona
	 * @return the bollettino icona that was removed
	 */
	@Override
	public it.eng.bollettino.model.BollettinoIcona deleteBollettinoIcona(
		it.eng.bollettino.model.BollettinoIcona bollettinoIcona) {

		return _bollettinoIconaLocalService.deleteBollettinoIcona(
			bollettinoIcona);
	}

	/**
	 * Deletes the bollettino icona with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the bollettino icona
	 * @return the bollettino icona that was removed
	 * @throws PortalException if a bollettino icona with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.BollettinoIcona deleteBollettinoIcona(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bollettinoIconaLocalService.deleteBollettinoIcona(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bollettinoIconaLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bollettinoIconaLocalService.dynamicQuery();
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

		return _bollettinoIconaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.BollettinoIconaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _bollettinoIconaLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.BollettinoIconaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _bollettinoIconaLocalService.dynamicQuery(
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

		return _bollettinoIconaLocalService.dynamicQueryCount(dynamicQuery);
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

		return _bollettinoIconaLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.bollettino.model.BollettinoIcona fetchBollettinoIcona(
		long id) {

		return _bollettinoIconaLocalService.fetchBollettinoIcona(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _bollettinoIconaLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the bollettino icona with the primary key.
	 *
	 * @param id the primary key of the bollettino icona
	 * @return the bollettino icona
	 * @throws PortalException if a bollettino icona with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.BollettinoIcona getBollettinoIcona(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bollettinoIconaLocalService.getBollettinoIcona(id);
	}

	/**
	 * Returns a range of all the bollettino iconas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.BollettinoIconaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @return the range of bollettino iconas
	 */
	@Override
	public java.util.List<it.eng.bollettino.model.BollettinoIcona>
		getBollettinoIconas(int start, int end) {

		return _bollettinoIconaLocalService.getBollettinoIconas(start, end);
	}

	/**
	 * Returns the number of bollettino iconas.
	 *
	 * @return the number of bollettino iconas
	 */
	@Override
	public int getBollettinoIconasCount() {
		return _bollettinoIconaLocalService.getBollettinoIconasCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _bollettinoIconaLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bollettinoIconaLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bollettinoIconaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the bollettino icona in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param bollettinoIcona the bollettino icona
	 * @return the bollettino icona that was updated
	 */
	@Override
	public it.eng.bollettino.model.BollettinoIcona updateBollettinoIcona(
		it.eng.bollettino.model.BollettinoIcona bollettinoIcona) {

		return _bollettinoIconaLocalService.updateBollettinoIcona(
			bollettinoIcona);
	}

	@Override
	public BollettinoIconaLocalService getWrappedService() {
		return _bollettinoIconaLocalService;
	}

	@Override
	public void setWrappedService(
		BollettinoIconaLocalService bollettinoIconaLocalService) {

		_bollettinoIconaLocalService = bollettinoIconaLocalService;
	}

	private BollettinoIconaLocalService _bollettinoIconaLocalService;

}