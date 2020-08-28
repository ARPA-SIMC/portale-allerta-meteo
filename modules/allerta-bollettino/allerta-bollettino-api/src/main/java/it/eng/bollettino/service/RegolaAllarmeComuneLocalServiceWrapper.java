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
 * Provides a wrapper for {@link RegolaAllarmeComuneLocalService}.
 *
 * @author GFAVINI
 * @see RegolaAllarmeComuneLocalService
 * @generated
 */
@ProviderType
public class RegolaAllarmeComuneLocalServiceWrapper
	implements RegolaAllarmeComuneLocalService,
			   ServiceWrapper<RegolaAllarmeComuneLocalService> {

	public RegolaAllarmeComuneLocalServiceWrapper(
		RegolaAllarmeComuneLocalService regolaAllarmeComuneLocalService) {

		_regolaAllarmeComuneLocalService = regolaAllarmeComuneLocalService;
	}

	/**
	 * Adds the regola allarme comune to the database. Also notifies the appropriate model listeners.
	 *
	 * @param regolaAllarmeComune the regola allarme comune
	 * @return the regola allarme comune that was added
	 */
	@Override
	public it.eng.bollettino.model.RegolaAllarmeComune addRegolaAllarmeComune(
		it.eng.bollettino.model.RegolaAllarmeComune regolaAllarmeComune) {

		return _regolaAllarmeComuneLocalService.addRegolaAllarmeComune(
			regolaAllarmeComune);
	}

	/**
	 * Creates a new regola allarme comune with the primary key. Does not add the regola allarme comune to the database.
	 *
	 * @param id the primary key for the new regola allarme comune
	 * @return the new regola allarme comune
	 */
	@Override
	public it.eng.bollettino.model.RegolaAllarmeComune
		createRegolaAllarmeComune(long id) {

		return _regolaAllarmeComuneLocalService.createRegolaAllarmeComune(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _regolaAllarmeComuneLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the regola allarme comune with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the regola allarme comune
	 * @return the regola allarme comune that was removed
	 * @throws PortalException if a regola allarme comune with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.RegolaAllarmeComune
			deleteRegolaAllarmeComune(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _regolaAllarmeComuneLocalService.deleteRegolaAllarmeComune(id);
	}

	/**
	 * Deletes the regola allarme comune from the database. Also notifies the appropriate model listeners.
	 *
	 * @param regolaAllarmeComune the regola allarme comune
	 * @return the regola allarme comune that was removed
	 */
	@Override
	public it.eng.bollettino.model.RegolaAllarmeComune
		deleteRegolaAllarmeComune(
			it.eng.bollettino.model.RegolaAllarmeComune regolaAllarmeComune) {

		return _regolaAllarmeComuneLocalService.deleteRegolaAllarmeComune(
			regolaAllarmeComune);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _regolaAllarmeComuneLocalService.dynamicQuery();
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

		return _regolaAllarmeComuneLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _regolaAllarmeComuneLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _regolaAllarmeComuneLocalService.dynamicQuery(
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

		return _regolaAllarmeComuneLocalService.dynamicQueryCount(dynamicQuery);
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

		return _regolaAllarmeComuneLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.bollettino.model.RegolaAllarmeComune fetchRegolaAllarmeComune(
		long id) {

		return _regolaAllarmeComuneLocalService.fetchRegolaAllarmeComune(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _regolaAllarmeComuneLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<it.eng.bollettino.model.RegolaAllarmeComune>
		getAllarmeCondizione(long idRegola) {

		return _regolaAllarmeComuneLocalService.getAllarmeCondizione(idRegola);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _regolaAllarmeComuneLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _regolaAllarmeComuneLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _regolaAllarmeComuneLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the regola allarme comune with the primary key.
	 *
	 * @param id the primary key of the regola allarme comune
	 * @return the regola allarme comune
	 * @throws PortalException if a regola allarme comune with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.RegolaAllarmeComune getRegolaAllarmeComune(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _regolaAllarmeComuneLocalService.getRegolaAllarmeComune(id);
	}

	/**
	 * Returns a range of all the regola allarme comunes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.RegolaAllarmeComuneModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarme comunes
	 * @param end the upper bound of the range of regola allarme comunes (not inclusive)
	 * @return the range of regola allarme comunes
	 */
	@Override
	public java.util.List<it.eng.bollettino.model.RegolaAllarmeComune>
		getRegolaAllarmeComunes(int start, int end) {

		return _regolaAllarmeComuneLocalService.getRegolaAllarmeComunes(
			start, end);
	}

	/**
	 * Returns the number of regola allarme comunes.
	 *
	 * @return the number of regola allarme comunes
	 */
	@Override
	public int getRegolaAllarmeComunesCount() {
		return _regolaAllarmeComuneLocalService.getRegolaAllarmeComunesCount();
	}

	/**
	 * Updates the regola allarme comune in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param regolaAllarmeComune the regola allarme comune
	 * @return the regola allarme comune that was updated
	 */
	@Override
	public it.eng.bollettino.model.RegolaAllarmeComune
		updateRegolaAllarmeComune(
			it.eng.bollettino.model.RegolaAllarmeComune regolaAllarmeComune) {

		return _regolaAllarmeComuneLocalService.updateRegolaAllarmeComune(
			regolaAllarmeComune);
	}

	@Override
	public RegolaAllarmeComuneLocalService getWrappedService() {
		return _regolaAllarmeComuneLocalService;
	}

	@Override
	public void setWrappedService(
		RegolaAllarmeComuneLocalService regolaAllarmeComuneLocalService) {

		_regolaAllarmeComuneLocalService = regolaAllarmeComuneLocalService;
	}

	private RegolaAllarmeComuneLocalService _regolaAllarmeComuneLocalService;

}