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

package it.eng.allerta.messages.services.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.allerta.messages.services.exception.NoSuchSmsSchedulerContextException;
import it.eng.allerta.messages.services.model.SmsSchedulerContext;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the sms scheduler context service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Giorgianni_F
 * @see SmsSchedulerContextUtil
 * @generated
 */
@ProviderType
public interface SmsSchedulerContextPersistence
	extends BasePersistence<SmsSchedulerContext> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SmsSchedulerContextUtil} to access the sms scheduler context persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, SmsSchedulerContext> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Caches the sms scheduler context in the entity cache if it is enabled.
	 *
	 * @param smsSchedulerContext the sms scheduler context
	 */
	public void cacheResult(SmsSchedulerContext smsSchedulerContext);

	/**
	 * Caches the sms scheduler contexts in the entity cache if it is enabled.
	 *
	 * @param smsSchedulerContexts the sms scheduler contexts
	 */
	public void cacheResult(
		java.util.List<SmsSchedulerContext> smsSchedulerContexts);

	/**
	 * Creates a new sms scheduler context with the primary key. Does not add the sms scheduler context to the database.
	 *
	 * @param varId the primary key for the new sms scheduler context
	 * @return the new sms scheduler context
	 */
	public SmsSchedulerContext create(String varId);

	/**
	 * Removes the sms scheduler context with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param varId the primary key of the sms scheduler context
	 * @return the sms scheduler context that was removed
	 * @throws NoSuchSmsSchedulerContextException if a sms scheduler context with the primary key could not be found
	 */
	public SmsSchedulerContext remove(String varId)
		throws NoSuchSmsSchedulerContextException;

	public SmsSchedulerContext updateImpl(
		SmsSchedulerContext smsSchedulerContext);

	/**
	 * Returns the sms scheduler context with the primary key or throws a <code>NoSuchSmsSchedulerContextException</code> if it could not be found.
	 *
	 * @param varId the primary key of the sms scheduler context
	 * @return the sms scheduler context
	 * @throws NoSuchSmsSchedulerContextException if a sms scheduler context with the primary key could not be found
	 */
	public SmsSchedulerContext findByPrimaryKey(String varId)
		throws NoSuchSmsSchedulerContextException;

	/**
	 * Returns the sms scheduler context with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param varId the primary key of the sms scheduler context
	 * @return the sms scheduler context, or <code>null</code> if a sms scheduler context with the primary key could not be found
	 */
	public SmsSchedulerContext fetchByPrimaryKey(String varId);

	/**
	 * Returns all the sms scheduler contexts.
	 *
	 * @return the sms scheduler contexts
	 */
	public java.util.List<SmsSchedulerContext> findAll();

	/**
	 * Returns a range of all the sms scheduler contexts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SmsSchedulerContextModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sms scheduler contexts
	 * @param end the upper bound of the range of sms scheduler contexts (not inclusive)
	 * @return the range of sms scheduler contexts
	 */
	public java.util.List<SmsSchedulerContext> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the sms scheduler contexts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SmsSchedulerContextModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sms scheduler contexts
	 * @param end the upper bound of the range of sms scheduler contexts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sms scheduler contexts
	 */
	public java.util.List<SmsSchedulerContext> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmsSchedulerContext>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sms scheduler contexts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SmsSchedulerContextModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sms scheduler contexts
	 * @param end the upper bound of the range of sms scheduler contexts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of sms scheduler contexts
	 */
	public java.util.List<SmsSchedulerContext> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmsSchedulerContext>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the sms scheduler contexts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of sms scheduler contexts.
	 *
	 * @return the number of sms scheduler contexts
	 */
	public int countAll();

}