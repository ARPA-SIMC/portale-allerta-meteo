/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LogInternoService}.
 *
 * @author GFAVINI
 * @see LogInternoService
 * @generated
 */
public class LogInternoServiceWrapper
	implements LogInternoService, ServiceWrapper<LogInternoService> {

	public LogInternoServiceWrapper() {
		this(null);
	}

	public LogInternoServiceWrapper(LogInternoService logInternoService) {
		_logInternoService = logInternoService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _logInternoService.getOSGiServiceIdentifier();
	}

	@Override
	public LogInternoService getWrappedService() {
		return _logInternoService;
	}

	@Override
	public void setWrappedService(LogInternoService logInternoService) {
		_logInternoService = logInternoService;
	}

	private LogInternoService _logInternoService;

}