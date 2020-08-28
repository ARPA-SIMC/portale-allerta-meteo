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

package it.eng.allerte.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RubricaRuoloLocalService}.
 *
 * @author Pratola_L
 * @see RubricaRuoloLocalService
 * @generated
 */
@ProviderType
public class RubricaRuoloLocalServiceWrapper
	implements RubricaRuoloLocalService,
			   ServiceWrapper<RubricaRuoloLocalService> {

	public RubricaRuoloLocalServiceWrapper(
		RubricaRuoloLocalService rubricaRuoloLocalService) {

		_rubricaRuoloLocalService = rubricaRuoloLocalService;
	}

	/**
	 * Adds the rubrica ruolo to the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaRuolo the rubrica ruolo
	 * @return the rubrica ruolo that was added
	 */
	@Override
	public it.eng.allerte.model.RubricaRuolo addRubricaRuolo(
		it.eng.allerte.model.RubricaRuolo rubricaRuolo) {

		return _rubricaRuoloLocalService.addRubricaRuolo(rubricaRuolo);
	}

	/**
	 * Creates a new rubrica ruolo with the primary key. Does not add the rubrica ruolo to the database.
	 *
	 * @param ID_RUOLO the primary key for the new rubrica ruolo
	 * @return the new rubrica ruolo
	 */
	@Override
	public it.eng.allerte.model.RubricaRuolo createRubricaRuolo(long ID_RUOLO) {
		return _rubricaRuoloLocalService.createRubricaRuolo(ID_RUOLO);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaRuoloLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the rubrica ruolo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_RUOLO the primary key of the rubrica ruolo
	 * @return the rubrica ruolo that was removed
	 * @throws PortalException if a rubrica ruolo with the primary key could not be found
	 */
	@Override
	public it.eng.allerte.model.RubricaRuolo deleteRubricaRuolo(long ID_RUOLO)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaRuoloLocalService.deleteRubricaRuolo(ID_RUOLO);
	}

	/**
	 * Deletes the rubrica ruolo from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaRuolo the rubrica ruolo
	 * @return the rubrica ruolo that was removed
	 */
	@Override
	public it.eng.allerte.model.RubricaRuolo deleteRubricaRuolo(
		it.eng.allerte.model.RubricaRuolo rubricaRuolo) {

		return _rubricaRuoloLocalService.deleteRubricaRuolo(rubricaRuolo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _rubricaRuoloLocalService.dynamicQuery();
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

		return _rubricaRuoloLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaRuoloModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _rubricaRuoloLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaRuoloModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _rubricaRuoloLocalService.dynamicQuery(
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

		return _rubricaRuoloLocalService.dynamicQueryCount(dynamicQuery);
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

		return _rubricaRuoloLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.allerte.model.RubricaRuolo fetchRubricaRuolo(long ID_RUOLO) {
		return _rubricaRuoloLocalService.fetchRubricaRuolo(ID_RUOLO);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _rubricaRuoloLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _rubricaRuoloLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rubricaRuoloLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaRuoloLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the rubrica ruolo with the primary key.
	 *
	 * @param ID_RUOLO the primary key of the rubrica ruolo
	 * @return the rubrica ruolo
	 * @throws PortalException if a rubrica ruolo with the primary key could not be found
	 */
	@Override
	public it.eng.allerte.model.RubricaRuolo getRubricaRuolo(long ID_RUOLO)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaRuoloLocalService.getRubricaRuolo(ID_RUOLO);
	}

	/**
	 * Returns a range of all the rubrica ruolos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaRuoloModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolos
	 * @param end the upper bound of the range of rubrica ruolos (not inclusive)
	 * @return the range of rubrica ruolos
	 */
	@Override
	public java.util.List<it.eng.allerte.model.RubricaRuolo> getRubricaRuolos(
		int start, int end) {

		return _rubricaRuoloLocalService.getRubricaRuolos(start, end);
	}

	/**
	 * Returns the number of rubrica ruolos.
	 *
	 * @return the number of rubrica ruolos
	 */
	@Override
	public int getRubricaRuolosCount() {
		return _rubricaRuoloLocalService.getRubricaRuolosCount();
	}

	/**
	 * Updates the rubrica ruolo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaRuolo the rubrica ruolo
	 * @return the rubrica ruolo that was updated
	 */
	@Override
	public it.eng.allerte.model.RubricaRuolo updateRubricaRuolo(
		it.eng.allerte.model.RubricaRuolo rubricaRuolo) {

		return _rubricaRuoloLocalService.updateRubricaRuolo(rubricaRuolo);
	}

	@Override
	public RubricaRuoloLocalService getWrappedService() {
		return _rubricaRuoloLocalService;
	}

	@Override
	public void setWrappedService(
		RubricaRuoloLocalService rubricaRuoloLocalService) {

		_rubricaRuoloLocalService = rubricaRuoloLocalService;
	}

	private RubricaRuoloLocalService _rubricaRuoloLocalService;

}