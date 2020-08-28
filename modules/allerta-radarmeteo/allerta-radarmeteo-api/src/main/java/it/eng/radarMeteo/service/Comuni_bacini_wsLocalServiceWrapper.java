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

package it.eng.radarMeteo.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link Comuni_bacini_wsLocalService}.
 *
 * @author Francesco
 * @see Comuni_bacini_wsLocalService
 * @generated
 */
@ProviderType
public class Comuni_bacini_wsLocalServiceWrapper
	implements Comuni_bacini_wsLocalService,
			   ServiceWrapper<Comuni_bacini_wsLocalService> {

	public Comuni_bacini_wsLocalServiceWrapper(
		Comuni_bacini_wsLocalService comuni_bacini_wsLocalService) {

		_comuni_bacini_wsLocalService = comuni_bacini_wsLocalService;
	}

	/**
	 * Adds the comuni_bacini_ws to the database. Also notifies the appropriate model listeners.
	 *
	 * @param comuni_bacini_ws the comuni_bacini_ws
	 * @return the comuni_bacini_ws that was added
	 */
	@Override
	public it.eng.radarMeteo.model.Comuni_bacini_ws addComuni_bacini_ws(
		it.eng.radarMeteo.model.Comuni_bacini_ws comuni_bacini_ws) {

		return _comuni_bacini_wsLocalService.addComuni_bacini_ws(
			comuni_bacini_ws);
	}

	/**
	 * Creates a new comuni_bacini_ws with the primary key. Does not add the comuni_bacini_ws to the database.
	 *
	 * @param idBacini the primary key for the new comuni_bacini_ws
	 * @return the new comuni_bacini_ws
	 */
	@Override
	public it.eng.radarMeteo.model.Comuni_bacini_ws createComuni_bacini_ws(
		int idBacini) {

		return _comuni_bacini_wsLocalService.createComuni_bacini_ws(idBacini);
	}

	/**
	 * Deletes the comuni_bacini_ws from the database. Also notifies the appropriate model listeners.
	 *
	 * @param comuni_bacini_ws the comuni_bacini_ws
	 * @return the comuni_bacini_ws that was removed
	 */
	@Override
	public it.eng.radarMeteo.model.Comuni_bacini_ws deleteComuni_bacini_ws(
		it.eng.radarMeteo.model.Comuni_bacini_ws comuni_bacini_ws) {

		return _comuni_bacini_wsLocalService.deleteComuni_bacini_ws(
			comuni_bacini_ws);
	}

	/**
	 * Deletes the comuni_bacini_ws with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idBacini the primary key of the comuni_bacini_ws
	 * @return the comuni_bacini_ws that was removed
	 * @throws PortalException if a comuni_bacini_ws with the primary key could not be found
	 */
	@Override
	public it.eng.radarMeteo.model.Comuni_bacini_ws deleteComuni_bacini_ws(
			int idBacini)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _comuni_bacini_wsLocalService.deleteComuni_bacini_ws(idBacini);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _comuni_bacini_wsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _comuni_bacini_wsLocalService.dynamicQuery();
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

		return _comuni_bacini_wsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.radarMeteo.model.impl.Comuni_bacini_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _comuni_bacini_wsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.radarMeteo.model.impl.Comuni_bacini_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _comuni_bacini_wsLocalService.dynamicQuery(
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

		return _comuni_bacini_wsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _comuni_bacini_wsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.radarMeteo.model.Comuni_bacini_ws fetchComuni_bacini_ws(
		int idBacini) {

		return _comuni_bacini_wsLocalService.fetchComuni_bacini_ws(idBacini);
	}

	@Override
	public java.util.List<it.eng.radarMeteo.model.Comuni_bacini_ws>
		findByBacino(String bacino) {

		return _comuni_bacini_wsLocalService.findByBacino(bacino);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _comuni_bacini_wsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the comuni_bacini_ws with the primary key.
	 *
	 * @param idBacini the primary key of the comuni_bacini_ws
	 * @return the comuni_bacini_ws
	 * @throws PortalException if a comuni_bacini_ws with the primary key could not be found
	 */
	@Override
	public it.eng.radarMeteo.model.Comuni_bacini_ws getComuni_bacini_ws(
			int idBacini)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _comuni_bacini_wsLocalService.getComuni_bacini_ws(idBacini);
	}

	/**
	 * Returns a range of all the comuni_bacini_wses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.radarMeteo.model.impl.Comuni_bacini_wsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of comuni_bacini_wses
	 * @param end the upper bound of the range of comuni_bacini_wses (not inclusive)
	 * @return the range of comuni_bacini_wses
	 */
	@Override
	public java.util.List<it.eng.radarMeteo.model.Comuni_bacini_ws>
		getComuni_bacini_wses(int start, int end) {

		return _comuni_bacini_wsLocalService.getComuni_bacini_wses(start, end);
	}

	/**
	 * Returns the number of comuni_bacini_wses.
	 *
	 * @return the number of comuni_bacini_wses
	 */
	@Override
	public int getComuni_bacini_wsesCount() {
		return _comuni_bacini_wsLocalService.getComuni_bacini_wsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _comuni_bacini_wsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _comuni_bacini_wsLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _comuni_bacini_wsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the comuni_bacini_ws in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param comuni_bacini_ws the comuni_bacini_ws
	 * @return the comuni_bacini_ws that was updated
	 */
	@Override
	public it.eng.radarMeteo.model.Comuni_bacini_ws updateComuni_bacini_ws(
		it.eng.radarMeteo.model.Comuni_bacini_ws comuni_bacini_ws) {

		return _comuni_bacini_wsLocalService.updateComuni_bacini_ws(
			comuni_bacini_ws);
	}

	@Override
	public Comuni_bacini_wsLocalService getWrappedService() {
		return _comuni_bacini_wsLocalService;
	}

	@Override
	public void setWrappedService(
		Comuni_bacini_wsLocalService comuni_bacini_wsLocalService) {

		_comuni_bacini_wsLocalService = comuni_bacini_wsLocalService;
	}

	private Comuni_bacini_wsLocalService _comuni_bacini_wsLocalService;

}