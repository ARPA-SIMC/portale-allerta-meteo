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
 * Provides a wrapper for {@link AllertaParametroLocalService}.
 *
 * @author GFAVINI
 * @see AllertaParametroLocalService
 * @generated
 */
@ProviderType
public class AllertaParametroLocalServiceWrapper
	implements AllertaParametroLocalService,
			   ServiceWrapper<AllertaParametroLocalService> {

	public AllertaParametroLocalServiceWrapper(
		AllertaParametroLocalService allertaParametroLocalService) {

		_allertaParametroLocalService = allertaParametroLocalService;
	}

	/**
	 * Adds the allerta parametro to the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaParametro the allerta parametro
	 * @return the allerta parametro that was added
	 */
	@Override
	public it.eng.allerter.model.AllertaParametro addAllertaParametro(
		it.eng.allerter.model.AllertaParametro allertaParametro) {

		return _allertaParametroLocalService.addAllertaParametro(
			allertaParametro);
	}

	/**
	 * Creates a new allerta parametro with the primary key. Does not add the allerta parametro to the database.
	 *
	 * @param parametroId the primary key for the new allerta parametro
	 * @return the new allerta parametro
	 */
	@Override
	public it.eng.allerter.model.AllertaParametro createAllertaParametro(
		String parametroId) {

		return _allertaParametroLocalService.createAllertaParametro(
			parametroId);
	}

	/**
	 * Deletes the allerta parametro from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaParametro the allerta parametro
	 * @return the allerta parametro that was removed
	 */
	@Override
	public it.eng.allerter.model.AllertaParametro deleteAllertaParametro(
		it.eng.allerter.model.AllertaParametro allertaParametro) {

		return _allertaParametroLocalService.deleteAllertaParametro(
			allertaParametro);
	}

	/**
	 * Deletes the allerta parametro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param parametroId the primary key of the allerta parametro
	 * @return the allerta parametro that was removed
	 * @throws PortalException if a allerta parametro with the primary key could not be found
	 */
	@Override
	public it.eng.allerter.model.AllertaParametro deleteAllertaParametro(
			String parametroId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allertaParametroLocalService.deleteAllertaParametro(
			parametroId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allertaParametroLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _allertaParametroLocalService.dynamicQuery();
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

		return _allertaParametroLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.AllertaParametroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _allertaParametroLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.AllertaParametroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _allertaParametroLocalService.dynamicQuery(
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

		return _allertaParametroLocalService.dynamicQueryCount(dynamicQuery);
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

		return _allertaParametroLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.allerter.model.AllertaParametro fetchAllertaParametro(
		String parametroId) {

		return _allertaParametroLocalService.fetchAllertaParametro(parametroId);
	}

	/**
	 * Returns the allerta parametro with the primary key.
	 *
	 * @param parametroId the primary key of the allerta parametro
	 * @return the allerta parametro
	 * @throws PortalException if a allerta parametro with the primary key could not be found
	 */
	@Override
	public it.eng.allerter.model.AllertaParametro getAllertaParametro(
			String parametroId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allertaParametroLocalService.getAllertaParametro(parametroId);
	}

	/**
	 * Returns a range of all the allerta parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.AllertaParametroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta parametros
	 * @param end the upper bound of the range of allerta parametros (not inclusive)
	 * @return the range of allerta parametros
	 */
	@Override
	public java.util.List<it.eng.allerter.model.AllertaParametro>
		getAllertaParametros(int start, int end) {

		return _allertaParametroLocalService.getAllertaParametros(start, end);
	}

	/**
	 * Returns the number of allerta parametros.
	 *
	 * @return the number of allerta parametros
	 */
	@Override
	public int getAllertaParametrosCount() {
		return _allertaParametroLocalService.getAllertaParametrosCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _allertaParametroLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allertaParametroLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the allerta parametro in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param allertaParametro the allerta parametro
	 * @return the allerta parametro that was updated
	 */
	@Override
	public it.eng.allerter.model.AllertaParametro updateAllertaParametro(
		it.eng.allerter.model.AllertaParametro allertaParametro) {

		return _allertaParametroLocalService.updateAllertaParametro(
			allertaParametro);
	}

	@Override
	public AllertaParametroLocalService getWrappedService() {
		return _allertaParametroLocalService;
	}

	@Override
	public void setWrappedService(
		AllertaParametroLocalService allertaParametroLocalService) {

		_allertaParametroLocalService = allertaParametroLocalService;
	}

	private AllertaParametroLocalService _allertaParametroLocalService;

}