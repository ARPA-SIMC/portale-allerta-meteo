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
 * Provides a wrapper for {@link RubricaGruppoLocalService}.
 *
 * @author Pratola_L
 * @see RubricaGruppoLocalService
 * @generated
 */
@ProviderType
public class RubricaGruppoLocalServiceWrapper
	implements RubricaGruppoLocalService,
			   ServiceWrapper<RubricaGruppoLocalService> {

	public RubricaGruppoLocalServiceWrapper(
		RubricaGruppoLocalService rubricaGruppoLocalService) {

		_rubricaGruppoLocalService = rubricaGruppoLocalService;
	}

	/**
	 * Adds the rubrica gruppo to the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaGruppo the rubrica gruppo
	 * @return the rubrica gruppo that was added
	 */
	@Override
	public it.eng.allerte.model.RubricaGruppo addRubricaGruppo(
		it.eng.allerte.model.RubricaGruppo rubricaGruppo) {

		return _rubricaGruppoLocalService.addRubricaGruppo(rubricaGruppo);
	}

	@Override
	public void aggiornaTuttoGruppo(Long gruppo) {
		_rubricaGruppoLocalService.aggiornaTuttoGruppo(gruppo);
	}

	/**
	 * Creates a new rubrica gruppo with the primary key. Does not add the rubrica gruppo to the database.
	 *
	 * @param ID_GRUPPO the primary key for the new rubrica gruppo
	 * @return the new rubrica gruppo
	 */
	@Override
	public it.eng.allerte.model.RubricaGruppo createRubricaGruppo(
		long ID_GRUPPO) {

		return _rubricaGruppoLocalService.createRubricaGruppo(ID_GRUPPO);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaGruppoLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the rubrica gruppo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_GRUPPO the primary key of the rubrica gruppo
	 * @return the rubrica gruppo that was removed
	 * @throws PortalException if a rubrica gruppo with the primary key could not be found
	 */
	@Override
	public it.eng.allerte.model.RubricaGruppo deleteRubricaGruppo(
			long ID_GRUPPO)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaGruppoLocalService.deleteRubricaGruppo(ID_GRUPPO);
	}

	/**
	 * Deletes the rubrica gruppo from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaGruppo the rubrica gruppo
	 * @return the rubrica gruppo that was removed
	 */
	@Override
	public it.eng.allerte.model.RubricaGruppo deleteRubricaGruppo(
		it.eng.allerte.model.RubricaGruppo rubricaGruppo) {

		return _rubricaGruppoLocalService.deleteRubricaGruppo(rubricaGruppo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _rubricaGruppoLocalService.dynamicQuery();
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

		return _rubricaGruppoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaGruppoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _rubricaGruppoLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaGruppoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _rubricaGruppoLocalService.dynamicQuery(
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

		return _rubricaGruppoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _rubricaGruppoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.allerte.model.RubricaGruppo fetchRubricaGruppo(
		long ID_GRUPPO) {

		return _rubricaGruppoLocalService.fetchRubricaGruppo(ID_GRUPPO);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _rubricaGruppoLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<Object[]> getGroup(Long id) {
		return _rubricaGruppoLocalService.getGroup(id);
	}

	/**
	 * Il metodo restituisce le info sul gruppo a partire dal nome e per il sito proprietario
	 */
	@Override
	public it.eng.allerte.model.RubricaGruppo getGroupForOwnerByName(
		Long ownerId, String groupName) {

		return _rubricaGruppoLocalService.getGroupForOwnerByName(
			ownerId, groupName);
	}

	@Override
	public java.util.ArrayList<Object[]> getGruppiByName(
		Long site, String groupName, Long limit, Long offset) {

		return _rubricaGruppoLocalService.getGruppiByName(
			site, groupName, limit, offset);
	}

	@Override
	public Object[] getGruppiByOwnerAndName(Long idOwner, String groupName) {
		return _rubricaGruppoLocalService.getGruppiByOwnerAndName(
			idOwner, groupName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _rubricaGruppoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rubricaGruppoLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaGruppoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the rubrica gruppo with the primary key.
	 *
	 * @param ID_GRUPPO the primary key of the rubrica gruppo
	 * @return the rubrica gruppo
	 * @throws PortalException if a rubrica gruppo with the primary key could not be found
	 */
	@Override
	public it.eng.allerte.model.RubricaGruppo getRubricaGruppo(long ID_GRUPPO)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaGruppoLocalService.getRubricaGruppo(ID_GRUPPO);
	}

	/**
	 * Returns a range of all the rubrica gruppos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaGruppoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppos
	 * @param end the upper bound of the range of rubrica gruppos (not inclusive)
	 * @return the range of rubrica gruppos
	 */
	@Override
	public java.util.List<it.eng.allerte.model.RubricaGruppo> getRubricaGruppos(
		int start, int end) {

		return _rubricaGruppoLocalService.getRubricaGruppos(start, end);
	}

	/**
	 * Returns the number of rubrica gruppos.
	 *
	 * @return the number of rubrica gruppos
	 */
	@Override
	public int getRubricaGrupposCount() {
		return _rubricaGruppoLocalService.getRubricaGrupposCount();
	}

	/**
	 * Updates the rubrica gruppo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaGruppo the rubrica gruppo
	 * @return the rubrica gruppo that was updated
	 */
	@Override
	public it.eng.allerte.model.RubricaGruppo updateRubricaGruppo(
		it.eng.allerte.model.RubricaGruppo rubricaGruppo) {

		return _rubricaGruppoLocalService.updateRubricaGruppo(rubricaGruppo);
	}

	@Override
	public RubricaGruppoLocalService getWrappedService() {
		return _rubricaGruppoLocalService;
	}

	@Override
	public void setWrappedService(
		RubricaGruppoLocalService rubricaGruppoLocalService) {

		_rubricaGruppoLocalService = rubricaGruppoLocalService;
	}

	private RubricaGruppoLocalService _rubricaGruppoLocalService;

}