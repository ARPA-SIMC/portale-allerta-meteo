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

package allerta.verifica.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UtenteLavoroLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UtenteLavoroLocalService
 * @generated
 */
@ProviderType
public class UtenteLavoroLocalServiceWrapper
	implements UtenteLavoroLocalService,
			   ServiceWrapper<UtenteLavoroLocalService> {

	public UtenteLavoroLocalServiceWrapper(
		UtenteLavoroLocalService utenteLavoroLocalService) {

		_utenteLavoroLocalService = utenteLavoroLocalService;
	}

	/**
	 * Adds the utente lavoro to the database. Also notifies the appropriate model listeners.
	 *
	 * @param utenteLavoro the utente lavoro
	 * @return the utente lavoro that was added
	 */
	@Override
	public allerta.verifica.model.UtenteLavoro addUtenteLavoro(
		allerta.verifica.model.UtenteLavoro utenteLavoro) {

		return _utenteLavoroLocalService.addUtenteLavoro(utenteLavoro);
	}

	/**
	 * Creates a new utente lavoro with the primary key. Does not add the utente lavoro to the database.
	 *
	 * @param id the primary key for the new utente lavoro
	 * @return the new utente lavoro
	 */
	@Override
	public allerta.verifica.model.UtenteLavoro createUtenteLavoro(long id) {
		return _utenteLavoroLocalService.createUtenteLavoro(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _utenteLavoroLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the utente lavoro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the utente lavoro
	 * @return the utente lavoro that was removed
	 * @throws PortalException if a utente lavoro with the primary key could not be found
	 */
	@Override
	public allerta.verifica.model.UtenteLavoro deleteUtenteLavoro(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _utenteLavoroLocalService.deleteUtenteLavoro(id);
	}

	/**
	 * Deletes the utente lavoro from the database. Also notifies the appropriate model listeners.
	 *
	 * @param utenteLavoro the utente lavoro
	 * @return the utente lavoro that was removed
	 */
	@Override
	public allerta.verifica.model.UtenteLavoro deleteUtenteLavoro(
		allerta.verifica.model.UtenteLavoro utenteLavoro) {

		return _utenteLavoroLocalService.deleteUtenteLavoro(utenteLavoro);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _utenteLavoroLocalService.dynamicQuery();
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

		return _utenteLavoroLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>allerta.verifica.model.impl.UtenteLavoroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _utenteLavoroLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>allerta.verifica.model.impl.UtenteLavoroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _utenteLavoroLocalService.dynamicQuery(
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

		return _utenteLavoroLocalService.dynamicQueryCount(dynamicQuery);
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

		return _utenteLavoroLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public allerta.verifica.model.UtenteLavoro fetchUtenteLavoro(long id) {
		return _utenteLavoroLocalService.fetchUtenteLavoro(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _utenteLavoroLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _utenteLavoroLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _utenteLavoroLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _utenteLavoroLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the utente lavoro with the primary key.
	 *
	 * @param id the primary key of the utente lavoro
	 * @return the utente lavoro
	 * @throws PortalException if a utente lavoro with the primary key could not be found
	 */
	@Override
	public allerta.verifica.model.UtenteLavoro getUtenteLavoro(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _utenteLavoroLocalService.getUtenteLavoro(id);
	}

	/**
	 * Returns a range of all the utente lavoros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>allerta.verifica.model.impl.UtenteLavoroModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of utente lavoros
	 * @param end the upper bound of the range of utente lavoros (not inclusive)
	 * @return the range of utente lavoros
	 */
	@Override
	public java.util.List<allerta.verifica.model.UtenteLavoro> getUtenteLavoros(
		int start, int end) {

		return _utenteLavoroLocalService.getUtenteLavoros(start, end);
	}

	/**
	 * Returns the number of utente lavoros.
	 *
	 * @return the number of utente lavoros
	 */
	@Override
	public int getUtenteLavorosCount() {
		return _utenteLavoroLocalService.getUtenteLavorosCount();
	}

	/**
	 * Updates the utente lavoro in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param utenteLavoro the utente lavoro
	 * @return the utente lavoro that was updated
	 */
	@Override
	public allerta.verifica.model.UtenteLavoro updateUtenteLavoro(
		allerta.verifica.model.UtenteLavoro utenteLavoro) {

		return _utenteLavoroLocalService.updateUtenteLavoro(utenteLavoro);
	}

	@Override
	public UtenteLavoroLocalService getWrappedService() {
		return _utenteLavoroLocalService;
	}

	@Override
	public void setWrappedService(
		UtenteLavoroLocalService utenteLavoroLocalService) {

		_utenteLavoroLocalService = utenteLavoroLocalService;
	}

	private UtenteLavoroLocalService _utenteLavoroLocalService;

}