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
 * Provides a wrapper for {@link AllertaValangheService}.
 *
 * @author GFAVINI
 * @see AllertaValangheService
 * @generated
 */
@ProviderType
public class AllertaValangheServiceWrapper
	implements AllertaValangheService, ServiceWrapper<AllertaValangheService> {

	public AllertaValangheServiceWrapper(
		AllertaValangheService allertaValangheService) {

		_allertaValangheService = allertaValangheService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _allertaValangheService.getOSGiServiceIdentifier();
	}

	@Override
	public AllertaValangheService getWrappedService() {
		return _allertaValangheService;
	}

	@Override
	public void setWrappedService(
		AllertaValangheService allertaValangheService) {

		_allertaValangheService = allertaValangheService;
	}

	private AllertaValangheService _allertaValangheService;

}