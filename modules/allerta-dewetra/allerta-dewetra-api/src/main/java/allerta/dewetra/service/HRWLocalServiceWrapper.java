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

package allerta.dewetra.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link HRWLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see HRWLocalService
 * @generated
 */
@ProviderType
public class HRWLocalServiceWrapper
	implements HRWLocalService, ServiceWrapper<HRWLocalService> {

	public HRWLocalServiceWrapper(HRWLocalService hrwLocalService) {
		_hrwLocalService = hrwLocalService;
	}

	/**
	 * Adds the hrw to the database. Also notifies the appropriate model listeners.
	 *
	 * @param hrw the hrw
	 * @return the hrw that was added
	 */
	@Override
	public allerta.dewetra.model.HRW addHRW(allerta.dewetra.model.HRW hrw) {
		return _hrwLocalService.addHRW(hrw);
	}

	@Override
	public java.util.Map<String, Object> aggiornaDewetra(String dati) {
		return _hrwLocalService.aggiornaDewetra(dati);
	}

	/**
	 * Creates a new hrw with the primary key. Does not add the hrw to the database.
	 *
	 * @param id the primary key for the new hrw
	 * @return the new hrw
	 */
	@Override
	public allerta.dewetra.model.HRW createHRW(long id) {
		return _hrwLocalService.createHRW(id);
	}

	/**
	 * Deletes the hrw from the database. Also notifies the appropriate model listeners.
	 *
	 * @param hrw the hrw
	 * @return the hrw that was removed
	 */
	@Override
	public allerta.dewetra.model.HRW deleteHRW(allerta.dewetra.model.HRW hrw) {
		return _hrwLocalService.deleteHRW(hrw);
	}

	/**
	 * Deletes the hrw with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the hrw
	 * @return the hrw that was removed
	 * @throws PortalException if a hrw with the primary key could not be found
	 */
	@Override
	public allerta.dewetra.model.HRW deleteHRW(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hrwLocalService.deleteHRW(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hrwLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _hrwLocalService.dynamicQuery();
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

		return _hrwLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>allerta.dewetra.model.impl.HRWModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _hrwLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>allerta.dewetra.model.impl.HRWModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _hrwLocalService.dynamicQuery(
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

		return _hrwLocalService.dynamicQueryCount(dynamicQuery);
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

		return _hrwLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public allerta.dewetra.model.HRW fetchHRW(long id) {
		return _hrwLocalService.fetchHRW(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _hrwLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the hrw with the primary key.
	 *
	 * @param id the primary key of the hrw
	 * @return the hrw
	 * @throws PortalException if a hrw with the primary key could not be found
	 */
	@Override
	public allerta.dewetra.model.HRW getHRW(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hrwLocalService.getHRW(id);
	}

	/**
	 * Returns a range of all the hrws.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>allerta.dewetra.model.impl.HRWModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of hrws
	 * @param end the upper bound of the range of hrws (not inclusive)
	 * @return the range of hrws
	 */
	@Override
	public java.util.List<allerta.dewetra.model.HRW> getHRWs(
		int start, int end) {

		return _hrwLocalService.getHRWs(start, end);
	}

	/**
	 * Returns the number of hrws.
	 *
	 * @return the number of hrws
	 */
	@Override
	public int getHRWsCount() {
		return _hrwLocalService.getHRWsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _hrwLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _hrwLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hrwLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the hrw in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param hrw the hrw
	 * @return the hrw that was updated
	 */
	@Override
	public allerta.dewetra.model.HRW updateHRW(allerta.dewetra.model.HRW hrw) {
		return _hrwLocalService.updateHRW(hrw);
	}

	@Override
	public HRWLocalService getWrappedService() {
		return _hrwLocalService;
	}

	@Override
	public void setWrappedService(HRWLocalService hrwLocalService) {
		_hrwLocalService = hrwLocalService;
	}

	private HRWLocalService _hrwLocalService;

}