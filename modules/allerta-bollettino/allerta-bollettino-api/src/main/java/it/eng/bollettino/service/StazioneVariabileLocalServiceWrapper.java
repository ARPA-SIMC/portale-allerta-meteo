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
 * Provides a wrapper for {@link StazioneVariabileLocalService}.
 *
 * @author GFAVINI
 * @see StazioneVariabileLocalService
 * @generated
 */
@ProviderType
public class StazioneVariabileLocalServiceWrapper
	implements StazioneVariabileLocalService,
			   ServiceWrapper<StazioneVariabileLocalService> {

	public StazioneVariabileLocalServiceWrapper(
		StazioneVariabileLocalService stazioneVariabileLocalService) {

		_stazioneVariabileLocalService = stazioneVariabileLocalService;
	}

	/**
	 * Adds the stazione variabile to the database. Also notifies the appropriate model listeners.
	 *
	 * @param stazioneVariabile the stazione variabile
	 * @return the stazione variabile that was added
	 */
	@Override
	public it.eng.bollettino.model.StazioneVariabile addStazioneVariabile(
		it.eng.bollettino.model.StazioneVariabile stazioneVariabile) {

		return _stazioneVariabileLocalService.addStazioneVariabile(
			stazioneVariabile);
	}

	@Override
	public it.eng.bollettino.cron.RisultatiAggiornamento aggiornaSensori() {
		return _stazioneVariabileLocalService.aggiornaSensori();
	}

	/**
	 * Creates a new stazione variabile with the primary key. Does not add the stazione variabile to the database.
	 *
	 * @param id the primary key for the new stazione variabile
	 * @return the new stazione variabile
	 */
	@Override
	public it.eng.bollettino.model.StazioneVariabile createStazioneVariabile(
		long id) {

		return _stazioneVariabileLocalService.createStazioneVariabile(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stazioneVariabileLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the stazione variabile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the stazione variabile
	 * @return the stazione variabile that was removed
	 * @throws PortalException if a stazione variabile with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.StazioneVariabile deleteStazioneVariabile(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stazioneVariabileLocalService.deleteStazioneVariabile(id);
	}

	/**
	 * Deletes the stazione variabile from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stazioneVariabile the stazione variabile
	 * @return the stazione variabile that was removed
	 */
	@Override
	public it.eng.bollettino.model.StazioneVariabile deleteStazioneVariabile(
		it.eng.bollettino.model.StazioneVariabile stazioneVariabile) {

		return _stazioneVariabileLocalService.deleteStazioneVariabile(
			stazioneVariabile);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _stazioneVariabileLocalService.dynamicQuery();
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

		return _stazioneVariabileLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.StazioneVariabileModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _stazioneVariabileLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.StazioneVariabileModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _stazioneVariabileLocalService.dynamicQuery(
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

		return _stazioneVariabileLocalService.dynamicQueryCount(dynamicQuery);
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

		return _stazioneVariabileLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.bollettino.model.StazioneVariabile fetchStazioneVariabile(
		long id) {

		return _stazioneVariabileLocalService.fetchStazioneVariabile(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _stazioneVariabileLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _stazioneVariabileLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _stazioneVariabileLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stazioneVariabileLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the stazione variabile with the primary key.
	 *
	 * @param id the primary key of the stazione variabile
	 * @return the stazione variabile
	 * @throws PortalException if a stazione variabile with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.StazioneVariabile getStazioneVariabile(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stazioneVariabileLocalService.getStazioneVariabile(id);
	}

	@Override
	public java.util.List<it.eng.bollettino.model.StazioneVariabile>
		getStazioneVariabile(String idStazione, String idVariabile) {

		return _stazioneVariabileLocalService.getStazioneVariabile(
			idStazione, idVariabile);
	}

	/**
	 * Returns a range of all the stazione variabiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.StazioneVariabileModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stazione variabiles
	 * @param end the upper bound of the range of stazione variabiles (not inclusive)
	 * @return the range of stazione variabiles
	 */
	@Override
	public java.util.List<it.eng.bollettino.model.StazioneVariabile>
		getStazioneVariabiles(int start, int end) {

		return _stazioneVariabileLocalService.getStazioneVariabiles(start, end);
	}

	/**
	 * Returns the number of stazione variabiles.
	 *
	 * @return the number of stazione variabiles
	 */
	@Override
	public int getStazioneVariabilesCount() {
		return _stazioneVariabileLocalService.getStazioneVariabilesCount();
	}

	/**
	 * Updates the stazione variabile in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param stazioneVariabile the stazione variabile
	 * @return the stazione variabile that was updated
	 */
	@Override
	public it.eng.bollettino.model.StazioneVariabile updateStazioneVariabile(
		it.eng.bollettino.model.StazioneVariabile stazioneVariabile) {

		return _stazioneVariabileLocalService.updateStazioneVariabile(
			stazioneVariabile);
	}

	@Override
	public StazioneVariabileLocalService getWrappedService() {
		return _stazioneVariabileLocalService;
	}

	@Override
	public void setWrappedService(
		StazioneVariabileLocalService stazioneVariabileLocalService) {

		_stazioneVariabileLocalService = stazioneVariabileLocalService;
	}

	private StazioneVariabileLocalService _stazioneVariabileLocalService;

}