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
 * Provides a wrapper for {@link ComponentiInvioService}.
 *
 * @author Pratola_L
 * @see ComponentiInvioService
 * @generated
 */
@ProviderType
public class ComponentiInvioServiceWrapper
	implements ComponentiInvioService, ServiceWrapper<ComponentiInvioService> {

	public ComponentiInvioServiceWrapper(
		ComponentiInvioService componentiInvioService) {

		_componentiInvioService = componentiInvioService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _componentiInvioService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<it.eng.parer.model.ComponentiInvio>
		listaComponentiByIdInvio(Long idInvio) {

		return _componentiInvioService.listaComponentiByIdInvio(idInvio);
	}

	@Override
	public ComponentiInvioService getWrappedService() {
		return _componentiInvioService;
	}

	@Override
	public void setWrappedService(
		ComponentiInvioService componentiInvioService) {

		_componentiInvioService = componentiInvioService;
	}

	private ComponentiInvioService _componentiInvioService;

}