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
 * Provides a wrapper for {@link RubricaCategoriaService}.
 *
 * @author Pratola_L
 * @see RubricaCategoriaService
 * @generated
 */
@ProviderType
public class RubricaCategoriaServiceWrapper
	implements RubricaCategoriaService,
			   ServiceWrapper<RubricaCategoriaService> {

	public RubricaCategoriaServiceWrapper(
		RubricaCategoriaService rubricaCategoriaService) {

		_rubricaCategoriaService = rubricaCategoriaService;
	}

	@Override
	public java.util.Map<String, Object> getCategorie() {
		return _rubricaCategoriaService.getCategorie();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rubricaCategoriaService.getOSGiServiceIdentifier();
	}

	@Override
	public RubricaCategoriaService getWrappedService() {
		return _rubricaCategoriaService;
	}

	@Override
	public void setWrappedService(
		RubricaCategoriaService rubricaCategoriaService) {

		_rubricaCategoriaService = rubricaCategoriaService;
	}

	private RubricaCategoriaService _rubricaCategoriaService;

}