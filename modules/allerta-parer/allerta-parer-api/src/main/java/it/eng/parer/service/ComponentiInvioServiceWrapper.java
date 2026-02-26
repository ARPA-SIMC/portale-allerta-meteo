/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ComponentiInvioService}.
 *
 * @author Pratola_L
 * @see ComponentiInvioService
 * @generated
 */
public class ComponentiInvioServiceWrapper
	implements ComponentiInvioService, ServiceWrapper<ComponentiInvioService> {

	public ComponentiInvioServiceWrapper() {
		this(null);
	}

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