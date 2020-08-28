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
 * Provides a wrapper for {@link LogInternoLocalService}.
 *
 * @author GFAVINI
 * @see LogInternoLocalService
 * @generated
 */
@ProviderType
public class LogInternoLocalServiceWrapper
	implements LogInternoLocalService, ServiceWrapper<LogInternoLocalService> {

	public LogInternoLocalServiceWrapper(
		LogInternoLocalService logInternoLocalService) {

		_logInternoLocalService = logInternoLocalService;
	}

	/**
	 * Adds the log interno to the database. Also notifies the appropriate model listeners.
	 *
	 * @param logInterno the log interno
	 * @return the log interno that was added
	 */
	@Override
	public it.eng.allerter.model.LogInterno addLogInterno(
		it.eng.allerter.model.LogInterno logInterno) {

		return _logInternoLocalService.addLogInterno(logInterno);
	}

	/**
	 * Creates a new log interno with the primary key. Does not add the log interno to the database.
	 *
	 * @param logId the primary key for the new log interno
	 * @return the new log interno
	 */
	@Override
	public it.eng.allerter.model.LogInterno createLogInterno(long logId) {
		return _logInternoLocalService.createLogInterno(logId);
	}

	/**
	 * Deletes the log interno from the database. Also notifies the appropriate model listeners.
	 *
	 * @param logInterno the log interno
	 * @return the log interno that was removed
	 */
	@Override
	public it.eng.allerter.model.LogInterno deleteLogInterno(
		it.eng.allerter.model.LogInterno logInterno) {

		return _logInternoLocalService.deleteLogInterno(logInterno);
	}

	/**
	 * Deletes the log interno with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param logId the primary key of the log interno
	 * @return the log interno that was removed
	 * @throws PortalException if a log interno with the primary key could not be found
	 */
	@Override
	public it.eng.allerter.model.LogInterno deleteLogInterno(long logId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _logInternoLocalService.deleteLogInterno(logId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _logInternoLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _logInternoLocalService.dynamicQuery();
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

		return _logInternoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.LogInternoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _logInternoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.LogInternoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _logInternoLocalService.dynamicQuery(
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

		return _logInternoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _logInternoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.allerter.model.LogInterno fetchLogInterno(long logId) {
		return _logInternoLocalService.fetchLogInterno(logId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _logInternoLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _logInternoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the log interno with the primary key.
	 *
	 * @param logId the primary key of the log interno
	 * @return the log interno
	 * @throws PortalException if a log interno with the primary key could not be found
	 */
	@Override
	public it.eng.allerter.model.LogInterno getLogInterno(long logId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _logInternoLocalService.getLogInterno(logId);
	}

	/**
	 * Returns a range of all the log internos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.LogInternoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of log internos
	 * @param end the upper bound of the range of log internos (not inclusive)
	 * @return the range of log internos
	 */
	@Override
	public java.util.List<it.eng.allerter.model.LogInterno> getLogInternos(
		int start, int end) {

		return _logInternoLocalService.getLogInternos(start, end);
	}

	/**
	 * Returns the number of log internos.
	 *
	 * @return the number of log internos
	 */
	@Override
	public int getLogInternosCount() {
		return _logInternoLocalService.getLogInternosCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _logInternoLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _logInternoLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public void log(
		String cosa, String dettaglio, Exception eccezione, String utente) {

		_logInternoLocalService.log(cosa, dettaglio, eccezione, utente);
	}

	@Override
	public void log(
		String cosa, String dettaglio, String risultato, String utente) {

		_logInternoLocalService.log(cosa, dettaglio, risultato, utente);
	}

	@Override
	public long logCount(java.util.Date da, java.util.Date a) {
		return _logInternoLocalService.logCount(da, a);
	}

	@Override
	public java.util.List<it.eng.allerter.model.LogInterno> searchLog(
		java.util.Date da, java.util.Date a, int start, int end) {

		return _logInternoLocalService.searchLog(da, a, start, end);
	}

	/**
	 * Updates the log interno in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param logInterno the log interno
	 * @return the log interno that was updated
	 */
	@Override
	public it.eng.allerter.model.LogInterno updateLogInterno(
		it.eng.allerter.model.LogInterno logInterno) {

		return _logInternoLocalService.updateLogInterno(logInterno);
	}

	@Override
	public LogInternoLocalService getWrappedService() {
		return _logInternoLocalService;
	}

	@Override
	public void setWrappedService(
		LogInternoLocalService logInternoLocalService) {

		_logInternoLocalService = logInternoLocalService;
	}

	private LogInternoLocalService _logInternoLocalService;

}