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

package it.eng.allerta.messages.services.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link NodoLocalService}.
 *
 * @author Giorgianni_F
 * @see NodoLocalService
 * @generated
 */
@ProviderType
public class NodoLocalServiceWrapper
	implements NodoLocalService, ServiceWrapper<NodoLocalService> {

	public NodoLocalServiceWrapper(NodoLocalService nodoLocalService) {
		_nodoLocalService = nodoLocalService;
	}

	/**
	 * Adds the nodo to the database. Also notifies the appropriate model listeners.
	 *
	 * @param nodo the nodo
	 * @return the nodo that was added
	 */
	@Override
	public it.eng.allerta.messages.services.model.Nodo addNodo(
		it.eng.allerta.messages.services.model.Nodo nodo) {

		return _nodoLocalService.addNodo(nodo);
	}

	/**
	 * Creates a new nodo with the primary key. Does not add the nodo to the database.
	 *
	 * @param Id the primary key for the new nodo
	 * @return the new nodo
	 */
	@Override
	public it.eng.allerta.messages.services.model.Nodo createNodo(long Id) {
		return _nodoLocalService.createNodo(Id);
	}

	/**
	 * Deletes the nodo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the nodo
	 * @return the nodo that was removed
	 * @throws PortalException if a nodo with the primary key could not be found
	 */
	@Override
	public it.eng.allerta.messages.services.model.Nodo deleteNodo(long Id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _nodoLocalService.deleteNodo(Id);
	}

	/**
	 * Deletes the nodo from the database. Also notifies the appropriate model listeners.
	 *
	 * @param nodo the nodo
	 * @return the nodo that was removed
	 */
	@Override
	public it.eng.allerta.messages.services.model.Nodo deleteNodo(
		it.eng.allerta.messages.services.model.Nodo nodo) {

		return _nodoLocalService.deleteNodo(nodo);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _nodoLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _nodoLocalService.dynamicQuery();
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

		return _nodoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerta.messages.services.model.impl.NodoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _nodoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerta.messages.services.model.impl.NodoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _nodoLocalService.dynamicQuery(
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

		return _nodoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _nodoLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.eng.allerta.messages.services.model.Nodo fetchNodo(long Id) {
		return _nodoLocalService.fetchNodo(Id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _nodoLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _nodoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the nodo with the primary key.
	 *
	 * @param Id the primary key of the nodo
	 * @return the nodo
	 * @throws PortalException if a nodo with the primary key could not be found
	 */
	@Override
	public it.eng.allerta.messages.services.model.Nodo getNodo(long Id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _nodoLocalService.getNodo(Id);
	}

	/**
	 * Returns a range of all the nodos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerta.messages.services.model.impl.NodoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of nodos
	 * @param end the upper bound of the range of nodos (not inclusive)
	 * @return the range of nodos
	 */
	@Override
	public java.util.List<it.eng.allerta.messages.services.model.Nodo> getNodos(
		int start, int end) {

		return _nodoLocalService.getNodos(start, end);
	}

	/**
	 * Returns the number of nodos.
	 *
	 * @return the number of nodos
	 */
	@Override
	public int getNodosCount() {
		return _nodoLocalService.getNodosCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _nodoLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _nodoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the nodo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param nodo the nodo
	 * @return the nodo that was updated
	 */
	@Override
	public it.eng.allerta.messages.services.model.Nodo updateNodo(
		it.eng.allerta.messages.services.model.Nodo nodo) {

		return _nodoLocalService.updateNodo(nodo);
	}

	@Override
	public NodoLocalService getWrappedService() {
		return _nodoLocalService;
	}

	@Override
	public void setWrappedService(NodoLocalService nodoLocalService) {
		_nodoLocalService = nodoLocalService;
	}

	private NodoLocalService _nodoLocalService;

}