/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SmsSchedulerContextService}.
 *
 * @author Giorgianni_F
 * @see SmsSchedulerContextService
 * @generated
 */
public class SmsSchedulerContextServiceWrapper
	implements ServiceWrapper<SmsSchedulerContextService>,
			   SmsSchedulerContextService {

	public SmsSchedulerContextServiceWrapper() {
		this(null);
	}

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