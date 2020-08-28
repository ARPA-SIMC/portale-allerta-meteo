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
 * Provides a wrapper for {@link SmsSchedulerContextService}.
 *
 * @author Giorgianni_F
 * @see SmsSchedulerContextService
 * @generated
 */
@ProviderType
public class SmsSchedulerContextServiceWrapper
	implements SmsSchedulerContextService,
			   ServiceWrapper<SmsSchedulerContextService> {

	public SmsSchedulerContextServiceWrapper(
		SmsSchedulerContextService smsSchedulerContextService) {

		_smsSchedulerContextService = smsSchedulerContextService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _smsSchedulerContextService.getOSGiServiceIdentifier();
	}

	@Override
	public SmsSchedulerContextService getWrappedService() {
		return _smsSchedulerContextService;
	}

	@Override
	public void setWrappedService(
		SmsSchedulerContextService smsSchedulerContextService) {

		_smsSchedulerContextService = smsSchedulerContextService;
	}

	private SmsSchedulerContextService _smsSchedulerContextService;

}