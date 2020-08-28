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

package it.eng.animaeteo.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AnimeteoImgService}.
 *
 * @author UTENTE
 * @see AnimeteoImgService
 * @generated
 */
@ProviderType
public class AnimeteoImgServiceWrapper
	implements AnimeteoImgService, ServiceWrapper<AnimeteoImgService> {

	public AnimeteoImgServiceWrapper(AnimeteoImgService animeteoImgService) {
		_animeteoImgService = animeteoImgService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _animeteoImgService.getOSGiServiceIdentifier();
	}

	@Override
	public AnimeteoImgService getWrappedService() {
		return _animeteoImgService;
	}

	@Override
	public void setWrappedService(AnimeteoImgService animeteoImgService) {
		_animeteoImgService = animeteoImgService;
	}

	private AnimeteoImgService _animeteoImgService;

}