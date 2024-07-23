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
 * Provides a wrapper for {@link elevazioneLocalService}.
 *
 * @author UTENTE
 * @see elevazioneLocalService
 * @generated
 */
@ProviderType
public class elevazioneLocalServiceWrapper
	implements elevazioneLocalService, ServiceWrapper<elevazioneLocalService> {

	public elevazioneLocalServiceWrapper(
		elevazioneLocalService elevazioneLocalService) {

		_elevazioneLocalService = elevazioneLocalService;
	}

	/**
	 * Adds the elevazione to the database. Also notifies the appropriate model listeners.
	 *
	 * @param elevazione the elevazione
	 * @return the elevazione that was added
	 */
	@Override
	public it.eng.animazione.image.model.elevazione addelevazione(
		it.eng.animazione.image.model.elevazione elevazione) {

		return _elevazioneLocalService.addelevazione(elevazione);
	}

	/**
	 * Creates a new elevazione with the primary key. Does not add the elevazione to the database.
	 *
	 * @param id the primary key for the new elevazione
	 * @return the new elevazione
	 */
	@Override
	public it.eng.animazione.image.model.elevazione createelevazione(long id) {
		return _elevazioneLocalService.createelevazione(id);
	}

	/**
	 * Deletes the elevazione from the database. Also notifies the appropriate model listeners.
	 *
	 * @param elevazione the elevazione
	 * @return the elevazione that was removed
	 */
	@Override
	public it.eng.animazione.image.model.elevazione deleteelevazione(
		it.eng.animazione.image.model.elevazione elevazione) {

		return _elevazioneLocalService.deleteelevazione(elevazione);
	}

	/**
	 * Deletes the elevazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the elevazione
	 * @return the elevazione that was removed
	 * @throws PortalException if a elevazione with the primary key could not be found
	 */
	@Override
	public it.eng.animazione.image.model.elevazione deleteelevazione(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _elevazioneLocalService.deleteelevazione(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _elevazioneLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _elevazioneLocalService.dynamicQuery();
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

		return _elevazioneLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.animazione.image.model.impl.elevazioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _elevazioneLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.animazione.image.model.impl.elevazioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _elevazioneLocalService.dynamicQuery(
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

		return _elevazioneLocalService.dynamicQueryCount(dynamicQuery);
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

		return _elevazioneLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.animazione.image.model.elevazione fetchelevazione(long id) {
		return _elevazioneLocalService.fetchelevazione(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _elevazioneLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the elevazione with the primary key.
	 *
	 * @param id the primary key of the elevazione
	 * @return the elevazione
	 * @throws PortalException if a elevazione with the primary key could not be found
	 */
	@Override
	public it.eng.animazione.image.model.elevazione getelevazione(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _elevazioneLocalService.getelevazione(id);
	}

	/**
	 * Returns a range of all the elevaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.animazione.image.model.impl.elevazioneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of elevaziones
	 * @param end the upper bound of the range of elevaziones (not inclusive)
	 * @return the range of elevaziones
	 */
	@Override
	public java.util.List<it.eng.animazione.image.model.elevazione>
		getelevaziones(int start, int end) {

		return _elevazioneLocalService.getelevaziones(start, end);
	}

	/**
	 * Returns the number of elevaziones.
	 *
	 * @return the number of elevaziones
	 */
	@Override
	public int getelevazionesCount() {
		return _elevazioneLocalService.getelevazionesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _elevazioneLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _elevazioneLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _elevazioneLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the elevazione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param elevazione the elevazione
	 * @return the elevazione that was updated
	 */
	@Override
	public it.eng.animazione.image.model.elevazione updateelevazione(
		it.eng.animazione.image.model.elevazione elevazione) {

		return _elevazioneLocalService.updateelevazione(elevazione);
	}

	@Override
	public elevazioneLocalService getWrappedService() {
		return _elevazioneLocalService;
	}

	@Override
	public void setWrappedService(
		elevazioneLocalService elevazioneLocalService) {

		_elevazioneLocalService = elevazioneLocalService;
	}

	private elevazioneLocalService _elevazioneLocalService;

}