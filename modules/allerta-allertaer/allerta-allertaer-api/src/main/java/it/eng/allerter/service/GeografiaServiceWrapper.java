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
 * Provides a wrapper for {@link GeografiaService}.
 *
 * @author GFAVINI
 * @see GeografiaService
 * @generated
 */
@ProviderType
public class GeografiaServiceWrapper
	implements GeografiaService, ServiceWrapper<GeografiaService> {

	public GeografiaServiceWrapper(GeografiaService geografiaService) {
		_geografiaService = geografiaService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _geografiaService.getOSGiServiceIdentifier();
	}

	@Override
	public GeografiaService getWrappedService() {
		return _geografiaService;
	}

	@Override
	public void setWrappedService(GeografiaService geografiaService) {
		_geografiaService = geografiaService;
	}

	private GeografiaService _geografiaService;

}