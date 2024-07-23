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

package it.eng.cache.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DatiLocalService}.
 *
 * @author GFAVINI
 * @see DatiLocalService
 * @generated
 */
@ProviderType
public class DatiLocalServiceWrapper
	implements DatiLocalService, ServiceWrapper<DatiLocalService> {

	public DatiLocalServiceWrapper(DatiLocalService datiLocalService) {
		_datiLocalService = datiLocalService;
	}

	/**
	 * Adds the dati to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dati the dati
	 * @return the dati that was added
	 */
	@Override
	public it.eng.cache.model.Dati addDati(it.eng.cache.model.Dati dati) {
		return _datiLocalService.addDati(dati);
	}

	/**
	 * Creates a new dati with the primary key. Does not add the dati to the database.
	 *
	 * @param idDati the primary key for the new dati
	 * @return the new dati
	 */
	@Override
	public it.eng.cache.model.Dati createDati(String idDati) {
		return _datiLocalService.createDati(idDati);
	}

	/**
	 * Deletes the dati from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dati the dati
	 * @return the dati that was removed
	 */
	@Override
	public it.eng.cache.model.Dati deleteDati(it.eng.cache.model.Dati dati) {
		return _datiLocalService.deleteDati(dati);
	}

	/**
	 * Deletes the dati with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idDati the primary key of the dati
	 * @return the dati that was removed
	 * @throws PortalException if a dati with the primary key could not be found
	 */
	@Override
	public it.eng.cache.model.Dati deleteDati(String idDati)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _datiLocalService.deleteDati(idDati);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _datiLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _datiLocalService.dynamicQuery();
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

		return _datiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.cache.model.impl.DatiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _datiLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.cache.model.impl.DatiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _datiLocalService.dynamicQuery(
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

		return _datiLocalService.dynamicQueryCount(dynamicQuery);
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

		return _datiLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.eng.cache.model.Dati fetchDati(String idDati) {
		return _datiLocalService.fetchDati(idDati);
	}

	/**
	 * Returns the dati with the primary key.
	 *
	 * @param idDati the primary key of the dati
	 * @return the dati
	 * @throws PortalException if a dati with the primary key could not be found
	 */
	@Override
	public it.eng.cache.model.Dati getDati(String idDati)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _datiLocalService.getDati(idDati);
	}

	@Override
	public java.util.List<it.eng.cache.model.Dati> getDatiByPrefix(
		String prefix) {

		return _datiLocalService.getDatiByPrefix(prefix);
	}

	/**
	 * Returns a range of all the datis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.cache.model.impl.DatiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of datis
	 * @param end the upper bound of the range of datis (not inclusive)
	 * @return the range of datis
	 */
	@Override
	public java.util.List<it.eng.cache.model.Dati> getDatis(
		int start, int end) {

		return _datiLocalService.getDatis(start, end);
	}

	/**
	 * Returns the number of datis.
	 *
	 * @return the number of datis
	 */
	@Override
	public int getDatisCount() {
		return _datiLocalService.getDatisCount();
	}

	@Override
	public Object getDato(String chiave) {
		return _datiLocalService.getDato(chiave);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _datiLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _datiLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public void putDato(String chiave, Object valore) {
		_datiLocalService.putDato(chiave, valore);
	}

	@Override
	public void removeDatiByPrefix(String prefix) {
		_datiLocalService.removeDatiByPrefix(prefix);
	}

	/**
	 * Updates the dati in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dati the dati
	 * @return the dati that was updated
	 */
	@Override
	public it.eng.cache.model.Dati updateDati(it.eng.cache.model.Dati dati) {
		return _datiLocalService.updateDati(dati);
	}

	@Override
	public DatiLocalService getWrappedService() {
		return _datiLocalService;
	}

	@Override
	public void setWrappedService(DatiLocalService datiLocalService) {
		_datiLocalService = datiLocalService;
	}

	private DatiLocalService _datiLocalService;

}