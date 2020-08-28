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

package it.eng.parer.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ParametriLocalService}.
 *
 * @author Pratola_L
 * @see ParametriLocalService
 * @generated
 */
@ProviderType
public class ParametriLocalServiceWrapper
	implements ParametriLocalService, ServiceWrapper<ParametriLocalService> {

	public ParametriLocalServiceWrapper(
		ParametriLocalService parametriLocalService) {

		_parametriLocalService = parametriLocalService;
	}

	/**
	 * Adds the parametri to the database. Also notifies the appropriate model listeners.
	 *
	 * @param parametri the parametri
	 * @return the parametri that was added
	 */
	@Override
	public it.eng.parer.model.Parametri addParametri(
		it.eng.parer.model.Parametri parametri) {

		return _parametriLocalService.addParametri(parametri);
	}

	/**
	 * Creates a new parametri with the primary key. Does not add the parametri to the database.
	 *
	 * @param chiave the primary key for the new parametri
	 * @return the new parametri
	 */
	@Override
	public it.eng.parer.model.Parametri createParametri(String chiave) {
		return _parametriLocalService.createParametri(chiave);
	}

	/**
	 * Deletes the parametri from the database. Also notifies the appropriate model listeners.
	 *
	 * @param parametri the parametri
	 * @return the parametri that was removed
	 */
	@Override
	public it.eng.parer.model.Parametri deleteParametri(
		it.eng.parer.model.Parametri parametri) {

		return _parametriLocalService.deleteParametri(parametri);
	}

	/**
	 * Deletes the parametri with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param chiave the primary key of the parametri
	 * @return the parametri that was removed
	 * @throws PortalException if a parametri with the primary key could not be found
	 */
	@Override
	public it.eng.parer.model.Parametri deleteParametri(String chiave)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _parametriLocalService.deleteParametri(chiave);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _parametriLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _parametriLocalService.dynamicQuery();
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

		return _parametriLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.parer.model.impl.ParametriModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _parametriLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.parer.model.impl.ParametriModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _parametriLocalService.dynamicQuery(
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

		return _parametriLocalService.dynamicQueryCount(dynamicQuery);
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

		return _parametriLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.parer.model.Parametri fetchParametri(String chiave) {
		return _parametriLocalService.fetchParametri(chiave);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _parametriLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the parametri with the primary key.
	 *
	 * @param chiave the primary key of the parametri
	 * @return the parametri
	 * @throws PortalException if a parametri with the primary key could not be found
	 */
	@Override
	public it.eng.parer.model.Parametri getParametri(String chiave)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _parametriLocalService.getParametri(chiave);
	}

	/**
	 * Returns a range of all the parametris.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.parer.model.impl.ParametriModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of parametris
	 * @param end the upper bound of the range of parametris (not inclusive)
	 * @return the range of parametris
	 */
	@Override
	public java.util.List<it.eng.parer.model.Parametri> getParametris(
		int start, int end) {

		return _parametriLocalService.getParametris(start, end);
	}

	/**
	 * Returns the number of parametris.
	 *
	 * @return the number of parametris
	 */
	@Override
	public int getParametrisCount() {
		return _parametriLocalService.getParametrisCount();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _parametriLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the parametri in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param parametri the parametri
	 * @return the parametri that was updated
	 */
	@Override
	public it.eng.parer.model.Parametri updateParametri(
		it.eng.parer.model.Parametri parametri) {

		return _parametriLocalService.updateParametri(parametri);
	}

	@Override
	public ParametriLocalService getWrappedService() {
		return _parametriLocalService;
	}

	@Override
	public void setWrappedService(ParametriLocalService parametriLocalService) {
		_parametriLocalService = parametriLocalService;
	}

	private ParametriLocalService _parametriLocalService;

}