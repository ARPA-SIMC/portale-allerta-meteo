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

package it.eng.allerte.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RubricaLogService}.
 *
 * @author Pratola_L
 * @see RubricaLogService
 * @generated
 */
@ProviderType
public class RubricaLogServiceWrapper
	implements RubricaLogService, ServiceWrapper<RubricaLogService> {

	public RubricaLogServiceWrapper(RubricaLogService rubricaLogService) {
		_rubricaLogService = rubricaLogService;
	}

	@Override
	public java.util.Map<String, Object> getLogs(
		String name, int limit, int offset) {

		return _rubricaLogService.getLogs(name, limit, offset);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rubricaLogService.getOSGiServiceIdentifier();
	}

	@Override
	public RubricaLogService getWrappedService() {
		return _rubricaLogService;
	}

	@Override
	public void setWrappedService(RubricaLogService rubricaLogService) {
		_rubricaLogService = rubricaLogService;
	}

	private RubricaLogService _rubricaLogService;

}