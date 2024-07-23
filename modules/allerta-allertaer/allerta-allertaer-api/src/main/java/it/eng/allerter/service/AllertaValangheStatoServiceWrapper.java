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
 * Provides a wrapper for {@link AllertaValangheStatoService}.
 *
 * @author GFAVINI
 * @see AllertaValangheStatoService
 * @generated
 */
@ProviderType
public class AllertaValangheStatoServiceWrapper
	implements AllertaValangheStatoService,
			   ServiceWrapper<AllertaValangheStatoService> {

	public AllertaValangheStatoServiceWrapper(
		AllertaValangheStatoService allertaValangheStatoService) {

		_allertaValangheStatoService = allertaValangheStatoService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _allertaValangheStatoService.getOSGiServiceIdentifier();
	}

	@Override
	public AllertaValangheStatoService getWrappedService() {
		return _allertaValangheStatoService;
	}

	@Override
	public void setWrappedService(
		AllertaValangheStatoService allertaValangheStatoService) {

		_allertaValangheStatoService = allertaValangheStatoService;
	}

	private AllertaValangheStatoService _allertaValangheStatoService;

}