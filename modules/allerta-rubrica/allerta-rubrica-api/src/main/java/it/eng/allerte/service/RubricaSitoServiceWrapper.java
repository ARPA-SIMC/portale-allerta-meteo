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
 * Provides a wrapper for {@link RubricaSitoService}.
 *
 * @author Pratola_L
 * @see RubricaSitoService
 * @generated
 */
@ProviderType
public class RubricaSitoServiceWrapper
	implements RubricaSitoService, ServiceWrapper<RubricaSitoService> {

	public RubricaSitoServiceWrapper(RubricaSitoService rubricaSitoService) {
		_rubricaSitoService = rubricaSitoService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rubricaSitoService.getOSGiServiceIdentifier();
	}

	@Override
	public RubricaSitoService getWrappedService() {
		return _rubricaSitoService;
	}

	@Override
	public void setWrappedService(RubricaSitoService rubricaSitoService) {
		_rubricaSitoService = rubricaSitoService;
	}

	private RubricaSitoService _rubricaSitoService;

}