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
 * Provides a wrapper for {@link RubricaPermessiService}.
 *
 * @author Pratola_L
 * @see RubricaPermessiService
 * @generated
 */
@ProviderType
public class RubricaPermessiServiceWrapper
	implements RubricaPermessiService, ServiceWrapper<RubricaPermessiService> {

	public RubricaPermessiServiceWrapper(
		RubricaPermessiService rubricaPermessiService) {

		_rubricaPermessiService = rubricaPermessiService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rubricaPermessiService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.Map<String, Object> getPermission() {
		return _rubricaPermessiService.getPermission();
	}

	@Override
	public RubricaPermessiService getWrappedService() {
		return _rubricaPermessiService;
	}

	@Override
	public void setWrappedService(
		RubricaPermessiService rubricaPermessiService) {

		_rubricaPermessiService = rubricaPermessiService;
	}

	private RubricaPermessiService _rubricaPermessiService;

}