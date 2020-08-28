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
 * Provides a wrapper for {@link LogInternoService}.
 *
 * @author GFAVINI
 * @see LogInternoService
 * @generated
 */
@ProviderType
public class LogInternoServiceWrapper
	implements LogInternoService, ServiceWrapper<LogInternoService> {

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