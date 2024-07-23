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
 * Provides a wrapper for {@link RubricaCategoriaLocalService}.
 *
 * @author Pratola_L
 * @see RubricaCategoriaLocalService
 * @generated
 */
@ProviderType
public class RubricaCategoriaLocalServiceWrapper
	implements RubricaCategoriaLocalService,
			   ServiceWrapper<RubricaCategoriaLocalService> {

	public RubricaCategoriaLocalServiceWrapper(
		RubricaCategoriaLocalService rubricaCategoriaLocalService) {

		_rubricaCategoriaLocalService = rubricaCategoriaLocalService;
	}

	/**
	 * Adds the rubrica categoria to the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaCategoria the rubrica categoria
	 * @return the rubrica categoria that was added
	 */
	@Override
	public it.eng.allerte.model.RubricaCategoria addRubricaCategoria(
		it.eng.allerte.model.RubricaCategoria rubricaCategoria) {

		return _rubricaCategoriaLocalService.addRubricaCategoria(
			rubricaCategoria);
	}

	/**
	 * Creates a new rubrica categoria with the primary key. Does not add the rubrica categoria to the database.
	 *
	 * @param ID_CATEGORIA the primary key for the new rubrica categoria
	 * @return the new rubrica categoria
	 */
	@Override
	public it.eng.allerte.model.RubricaCategoria createRubricaCategoria(
		long ID_CATEGORIA) {

		return _rubricaCategoriaLocalService.createRubricaCategoria(
			ID_CATEGORIA);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaCategoriaLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the rubrica categoria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_CATEGORIA the primary key of the rubrica categoria
	 * @return the rubrica categoria that was removed
	 * @throws PortalException if a rubrica categoria with the primary key could not be found
	 */
	@Override
	public it.eng.allerte.model.RubricaCategoria deleteRubricaCategoria(
			long ID_CATEGORIA)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaCategoriaLocalService.deleteRubricaCategoria(
			ID_CATEGORIA);
	}

	/**
	 * Deletes the rubrica categoria from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaCategoria the rubrica categoria
	 * @return the rubrica categoria that was removed
	 */
	@Override
	public it.eng.allerte.model.RubricaCategoria deleteRubricaCategoria(
		it.eng.allerte.model.RubricaCategoria rubricaCategoria) {

		return _rubricaCategoriaLocalService.deleteRubricaCategoria(
			rubricaCategoria);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _rubricaCategoriaLocalService.dynamicQuery();
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

		return _rubricaCategoriaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaCategoriaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _rubricaCategoriaLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaCategoriaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _rubricaCategoriaLocalService.dynamicQuery(
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

		return _rubricaCategoriaLocalService.dynamicQueryCount(dynamicQuery);
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

		return _rubricaCategoriaLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.allerte.model.RubricaCategoria fetchRubricaCategoria(
		long ID_CATEGORIA) {

		return _rubricaCategoriaLocalService.fetchRubricaCategoria(
			ID_CATEGORIA);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _rubricaCategoriaLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _rubricaCategoriaLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rubricaCategoriaLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaCategoriaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the rubrica categoria with the primary key.
	 *
	 * @param ID_CATEGORIA the primary key of the rubrica categoria
	 * @return the rubrica categoria
	 * @throws PortalException if a rubrica categoria with the primary key could not be found
	 */
	@Override
	public it.eng.allerte.model.RubricaCategoria getRubricaCategoria(
			long ID_CATEGORIA)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaCategoriaLocalService.getRubricaCategoria(ID_CATEGORIA);
	}

	/**
	 * Returns a range of all the rubrica categorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaCategoriaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica categorias
	 * @param end the upper bound of the range of rubrica categorias (not inclusive)
	 * @return the range of rubrica categorias
	 */
	@Override
	public java.util.List<it.eng.allerte.model.RubricaCategoria>
		getRubricaCategorias(int start, int end) {

		return _rubricaCategoriaLocalService.getRubricaCategorias(start, end);
	}

	/**
	 * Returns the number of rubrica categorias.
	 *
	 * @return the number of rubrica categorias
	 */
	@Override
	public int getRubricaCategoriasCount() {
		return _rubricaCategoriaLocalService.getRubricaCategoriasCount();
	}

	/**
	 * Updates the rubrica categoria in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaCategoria the rubrica categoria
	 * @return the rubrica categoria that was updated
	 */
	@Override
	public it.eng.allerte.model.RubricaCategoria updateRubricaCategoria(
		it.eng.allerte.model.RubricaCategoria rubricaCategoria) {

		return _rubricaCategoriaLocalService.updateRubricaCategoria(
			rubricaCategoria);
	}

	@Override
	public RubricaCategoriaLocalService getWrappedService() {
		return _rubricaCategoriaLocalService;
	}

	@Override
	public void setWrappedService(
		RubricaCategoriaLocalService rubricaCategoriaLocalService) {

		_rubricaCategoriaLocalService = rubricaCategoriaLocalService;
	}

	private RubricaCategoriaLocalService _rubricaCategoriaLocalService;

}