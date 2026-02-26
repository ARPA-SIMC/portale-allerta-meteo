/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CounterSmsService}.
 *
 * @author Giorgianni_F
 * @see CounterSmsService
 * @generated
 */
public class CounterSmsServiceWrapper
	implements CounterSmsService, ServiceWrapper<CounterSmsService> {

	public CounterSmsServiceWrapper() {
		this(null);
	}

	public CounterSmsServiceWrapper(CounterSmsService counterSmsService) {
		_counterSmsService = counterSmsService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _counterSmsService.getOSGiServiceIdentifier();
	}

	@Override
	public CounterSmsService getWrappedService() {
		return _counterSmsService;
	}

	@Override
	public void setWrappedService(CounterSmsService counterSmsService) {
		_counterSmsService = counterSmsService;
	}

	private CounterSmsService _counterSmsService;

}