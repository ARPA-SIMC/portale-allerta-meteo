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

package it.eng.parer.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DatiSpecificiInvioService}.
 *
 * @author Pratola_L
 * @see DatiSpecificiInvioService
 * @generated
 */
@ProviderType
public class DatiSpecificiInvioServiceWrapper
	implements DatiSpecificiInvioService,
			   ServiceWrapper<DatiSpecificiInvioService> {

	public DatiSpecificiInvioServiceWrapper(
		DatiSpecificiInvioService datiSpecificiInvioService) {

		_datiSpecificiInvioService = datiSpecificiInvioService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _datiSpecificiInvioService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<it.eng.parer.model.DatiSpecificiInvio>
		listaDatiSpecificiByEsitoInvio(String esitoInvio) {

		return _datiSpecificiInvioService.listaDatiSpecificiByEsitoInvio(
			esitoInvio);
	}

	@Override
	public DatiSpecificiInvioService getWrappedService() {
		return _datiSpecificiInvioService;
	}

	@Override
	public void setWrappedService(
		DatiSpecificiInvioService datiSpecificiInvioService) {

		_datiSpecificiInvioService = datiSpecificiInvioService;
	}

	private DatiSpecificiInvioService _datiSpecificiInvioService;

}