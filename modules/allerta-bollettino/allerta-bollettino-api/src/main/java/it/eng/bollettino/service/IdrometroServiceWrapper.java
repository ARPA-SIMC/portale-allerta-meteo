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

package it.eng.bollettino.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link IdrometroService}.
 *
 * @author GFAVINI
 * @see IdrometroService
 * @generated
 */
@ProviderType
public class IdrometroServiceWrapper
	implements IdrometroService, ServiceWrapper<IdrometroService> {

	public IdrometroServiceWrapper(IdrometroService idrometroService) {
		_idrometroService = idrometroService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _idrometroService.getOSGiServiceIdentifier();
	}

	@Override
	public IdrometroService getWrappedService() {
		return _idrometroService;
	}

	@Override
	public void setWrappedService(IdrometroService idrometroService) {
		_idrometroService = idrometroService;
	}

	private IdrometroService _idrometroService;

}