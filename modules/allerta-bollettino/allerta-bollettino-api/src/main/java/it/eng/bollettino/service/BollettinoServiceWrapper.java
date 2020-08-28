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
 * Provides a wrapper for {@link BollettinoService}.
 *
 * @author GFAVINI
 * @see BollettinoService
 * @generated
 */
@ProviderType
public class BollettinoServiceWrapper
	implements BollettinoService, ServiceWrapper<BollettinoService> {

	public BollettinoServiceWrapper(BollettinoService bollettinoService) {
		_bollettinoService = bollettinoService;
	}

	@Override
	public java.util.ArrayList<java.util.Map<String, String>> getAllarmi() {
		return _bollettinoService.getAllarmi();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bollettinoService.getOSGiServiceIdentifier();
	}

	@Override
	public BollettinoService getWrappedService() {
		return _bollettinoService;
	}

	@Override
	public void setWrappedService(BollettinoService bollettinoService) {
		_bollettinoService = bollettinoService;
	}

	private BollettinoService _bollettinoService;

}