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
 * Provides a wrapper for {@link VariabileLocalService}.
 *
 * @author GFAVINI
 * @see VariabileLocalService
 * @generated
 */
@ProviderType
public class VariabileLocalServiceWrapper
	implements VariabileLocalService, ServiceWrapper<VariabileLocalService> {

	public VariabileLocalServiceWrapper(
		VariabileLocalService variabileLocalService) {

		_variabileLocalService = variabileLocalService;
	}

	/**
	 * Adds the variabile to the database. Also notifies the appropriate model listeners.
	 *
	 * @param variabile the variabile
	 * @return the variabile that was added
	 */
	@Override
	public it.eng.bollettino.model.Variabile addVariabile(
		it.eng.bollettino.model.Variabile variabile) {

		return _variabileLocalService.addVariabile(variabile);
	}

	@Override
	public it.eng.bollettino.cron.RisultatiAggiornamento aggiornaVariabili() {
		return _variabileLocalService.aggiornaVariabili();
	}

	/**
	 * Creates a new variabile with the primary key. Does not add the variabile to the database.
	 *
	 * @param id the primary key for the new variabile
	 * @return the new variabile
	 */
	@Override
	public it.eng.bollettino.model.Variabile createVariabile(String id) {
		return _variabileLocalService.createVariabile(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _variabileLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the variabile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the variabile
	 * @return the variabile that was removed
	 * @throws PortalException if a variabile with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.Variabile deleteVariabile(String id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _variabileLocalService.deleteVariabile(id);
	}

	/**
	 * Deletes the variabile from the database. Also notifies the appropriate model listeners.
	 *
	 * @param variabile the variabile
	 * @return the variabile that was removed
	 */
	@Override
	public it.eng.bollettino.model.Variabile deleteVariabile(
		it.eng.bollettino.model.Variabile variabile) {

		return _variabileLocalService.deleteVariabile(variabile);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _variabileLocalService.dynamicQuery();
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

		return _variabileLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.VariabileModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _variabileLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.VariabileModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _variabileLocalService.dynamicQuery(
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

		return _variabileLocalService.dynamicQueryCount(dynamicQuery);
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

		return _variabileLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.bollettino.model.Variabile fetchVariabile(String id) {
		return _variabileLocalService.fetchVariabile(id);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _variabileLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _variabileLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the variabile with the primary key.
	 *
	 * @param id the primary key of the variabile
	 * @return the variabile
	 * @throws PortalException if a variabile with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.Variabile getVariabile(String id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _variabileLocalService.getVariabile(id);
	}

	/**
	 * Returns a range of all the variabiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.VariabileModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of variabiles
	 * @param end the upper bound of the range of variabiles (not inclusive)
	 * @return the range of variabiles
	 */
	@Override
	public java.util.List<it.eng.bollettino.model.Variabile> getVariabiles(
		int start, int end) {

		return _variabileLocalService.getVariabiles(start, end);
	}

	/**
	 * Returns the number of variabiles.
	 *
	 * @return the number of variabiles
	 */
	@Override
	public int getVariabilesCount() {
		return _variabileLocalService.getVariabilesCount();
	}

	/**
	 * Updates the variabile in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param variabile the variabile
	 * @return the variabile that was updated
	 */
	@Override
	public it.eng.bollettino.model.Variabile updateVariabile(
		it.eng.bollettino.model.Variabile variabile) {

		return _variabileLocalService.updateVariabile(variabile);
	}

	@Override
	public VariabileLocalService getWrappedService() {
		return _variabileLocalService;
	}

	@Override
	public void setWrappedService(VariabileLocalService variabileLocalService) {
		_variabileLocalService = variabileLocalService;
	}

	private VariabileLocalService _variabileLocalService;

}