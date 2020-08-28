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
 * Provides a wrapper for {@link CounterSmsLocalService}.
 *
 * @author Giorgianni_F
 * @see CounterSmsLocalService
 * @generated
 */
@ProviderType
public class CounterSmsLocalServiceWrapper
	implements CounterSmsLocalService, ServiceWrapper<CounterSmsLocalService> {

	public CounterSmsLocalServiceWrapper(
		CounterSmsLocalService counterSmsLocalService) {

		_counterSmsLocalService = counterSmsLocalService;
	}

	/**
	 * Adds the counter sms to the database. Also notifies the appropriate model listeners.
	 *
	 * @param counterSms the counter sms
	 * @return the counter sms that was added
	 */
	@Override
	public it.eng.allerta.messages.services.model.CounterSms addCounterSms(
		it.eng.allerta.messages.services.model.CounterSms counterSms) {

		return _counterSmsLocalService.addCounterSms(counterSms);
	}

	/**
	 * Creates a new counter sms with the primary key. Does not add the counter sms to the database.
	 *
	 * @param counterId the primary key for the new counter sms
	 * @return the new counter sms
	 */
	@Override
	public it.eng.allerta.messages.services.model.CounterSms createCounterSms(
		long counterId) {

		return _counterSmsLocalService.createCounterSms(counterId);
	}

	/**
	 * Deletes the counter sms from the database. Also notifies the appropriate model listeners.
	 *
	 * @param counterSms the counter sms
	 * @return the counter sms that was removed
	 */
	@Override
	public it.eng.allerta.messages.services.model.CounterSms deleteCounterSms(
		it.eng.allerta.messages.services.model.CounterSms counterSms) {

		return _counterSmsLocalService.deleteCounterSms(counterSms);
	}

	/**
	 * Deletes the counter sms with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param counterId the primary key of the counter sms
	 * @return the counter sms that was removed
	 * @throws PortalException if a counter sms with the primary key could not be found
	 */
	@Override
	public it.eng.allerta.messages.services.model.CounterSms deleteCounterSms(
			long counterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _counterSmsLocalService.deleteCounterSms(counterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _counterSmsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _counterSmsLocalService.dynamicQuery();
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

		return _counterSmsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerta.messages.services.model.impl.CounterSmsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _counterSmsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerta.messages.services.model.impl.CounterSmsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _counterSmsLocalService.dynamicQuery(
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

		return _counterSmsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _counterSmsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.allerta.messages.services.model.CounterSms fetchCounterSms(
		long counterId) {

		return _counterSmsLocalService.fetchCounterSms(counterId);
	}

	@Override
	public it.eng.allerta.messages.services.model.CounterSms findBydata(
		java.util.Date date) {

		return _counterSmsLocalService.findBydata(date);
	}

	@Override
	public java.util.List<it.eng.allerta.messages.services.model.CounterSms>
		findBydataGreather(java.util.Date date) {

		return _counterSmsLocalService.findBydataGreather(date);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _counterSmsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the counter sms with the primary key.
	 *
	 * @param counterId the primary key of the counter sms
	 * @return the counter sms
	 * @throws PortalException if a counter sms with the primary key could not be found
	 */
	@Override
	public it.eng.allerta.messages.services.model.CounterSms getCounterSms(
			long counterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _counterSmsLocalService.getCounterSms(counterId);
	}

	/**
	 * Returns a range of all the counter smses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerta.messages.services.model.impl.CounterSmsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of counter smses
	 * @param end the upper bound of the range of counter smses (not inclusive)
	 * @return the range of counter smses
	 */
	@Override
	public java.util.List<it.eng.allerta.messages.services.model.CounterSms>
		getCounterSmses(int start, int end) {

		return _counterSmsLocalService.getCounterSmses(start, end);
	}

	/**
	 * Returns the number of counter smses.
	 *
	 * @return the number of counter smses
	 */
	@Override
	public int getCounterSmsesCount() {
		return _counterSmsLocalService.getCounterSmsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _counterSmsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _counterSmsLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _counterSmsLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public Long getTotalSMS() {
		return _counterSmsLocalService.getTotalSMS();
	}

	/**
	 * Updates the counter sms in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param counterSms the counter sms
	 * @return the counter sms that was updated
	 */
	@Override
	public it.eng.allerta.messages.services.model.CounterSms updateCounterSms(
		it.eng.allerta.messages.services.model.CounterSms counterSms) {

		return _counterSmsLocalService.updateCounterSms(counterSms);
	}

	@Override
	public CounterSmsLocalService getWrappedService() {
		return _counterSmsLocalService;
	}

	@Override
	public void setWrappedService(
		CounterSmsLocalService counterSmsLocalService) {

		_counterSmsLocalService = counterSmsLocalService;
	}

	private CounterSmsLocalService _counterSmsLocalService;

}