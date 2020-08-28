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

package it.eng.previsioni.meteo.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StoricoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StoricoLocalService
 * @generated
 */
@ProviderType
public class StoricoLocalServiceWrapper
	implements StoricoLocalService, ServiceWrapper<StoricoLocalService> {

	public StoricoLocalServiceWrapper(StoricoLocalService storicoLocalService) {
		_storicoLocalService = storicoLocalService;
	}

	/**
	 * Adds the storico to the database. Also notifies the appropriate model listeners.
	 *
	 * @param storico the storico
	 * @return the storico that was added
	 */
	@Override
	public it.eng.previsioni.meteo.model.Storico addStorico(
		it.eng.previsioni.meteo.model.Storico storico) {

		return _storicoLocalService.addStorico(storico);
	}

	/**
	 * Creates a new storico with the primary key. Does not add the storico to the database.
	 *
	 * @param id the primary key for the new storico
	 * @return the new storico
	 */
	@Override
	public it.eng.previsioni.meteo.model.Storico createStorico(long id) {
		return _storicoLocalService.createStorico(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _storicoLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the storico with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the storico
	 * @return the storico that was removed
	 * @throws PortalException if a storico with the primary key could not be found
	 */
	@Override
	public it.eng.previsioni.meteo.model.Storico deleteStorico(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _storicoLocalService.deleteStorico(id);
	}

	/**
	 * Deletes the storico from the database. Also notifies the appropriate model listeners.
	 *
	 * @param storico the storico
	 * @return the storico that was removed
	 */
	@Override
	public it.eng.previsioni.meteo.model.Storico deleteStorico(
		it.eng.previsioni.meteo.model.Storico storico) {

		return _storicoLocalService.deleteStorico(storico);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _storicoLocalService.dynamicQuery();
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

		return _storicoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.previsioni.meteo.model.impl.StoricoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _storicoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.previsioni.meteo.model.impl.StoricoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _storicoLocalService.dynamicQuery(
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

		return _storicoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _storicoLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.eng.previsioni.meteo.model.Storico fetchStorico(long id) {
		return _storicoLocalService.fetchStorico(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _storicoLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _storicoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _storicoLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _storicoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the storico with the primary key.
	 *
	 * @param id the primary key of the storico
	 * @return the storico
	 * @throws PortalException if a storico with the primary key could not be found
	 */
	@Override
	public it.eng.previsioni.meteo.model.Storico getStorico(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _storicoLocalService.getStorico(id);
	}

	@Override
	public java.util.List<it.eng.previsioni.meteo.model.Storico>
		getStoricoBySigla(String sigla) {

		return _storicoLocalService.getStoricoBySigla(sigla);
	}

	/**
	 * Returns a range of all the storicos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.previsioni.meteo.model.impl.StoricoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of storicos
	 * @param end the upper bound of the range of storicos (not inclusive)
	 * @return the range of storicos
	 */
	@Override
	public java.util.List<it.eng.previsioni.meteo.model.Storico> getStoricos(
		int start, int end) {

		return _storicoLocalService.getStoricos(start, end);
	}

	/**
	 * Returns the number of storicos.
	 *
	 * @return the number of storicos
	 */
	@Override
	public int getStoricosCount() {
		return _storicoLocalService.getStoricosCount();
	}

	/**
	 * Updates the storico in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param storico the storico
	 * @return the storico that was updated
	 */
	@Override
	public it.eng.previsioni.meteo.model.Storico updateStorico(
		it.eng.previsioni.meteo.model.Storico storico) {

		return _storicoLocalService.updateStorico(storico);
	}

	@Override
	public StoricoLocalService getWrappedService() {
		return _storicoLocalService;
	}

	@Override
	public void setWrappedService(StoricoLocalService storicoLocalService) {
		_storicoLocalService = storicoLocalService;
	}

	private StoricoLocalService _storicoLocalService;

}