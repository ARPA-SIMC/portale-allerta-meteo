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
 * Provides a wrapper for {@link ParametroService}.
 *
 * @author Giorgianni_F
 * @see ParametroService
 * @generated
 */
@ProviderType
public class ParametroServiceWrapper
	implements ParametroService, ServiceWrapper<ParametroService> {

	public ParametroServiceWrapper(ParametroService parametroService) {
		_parametroService = parametroService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _parametroService.getOSGiServiceIdentifier();
	}

	@Override
	public ParametroService getWrappedService() {
		return _parametroService;
	}

	@Override
	public void setWrappedService(ParametroService parametroService) {
		_parametroService = parametroService;
	}

	private ParametroService _parametroService;

}