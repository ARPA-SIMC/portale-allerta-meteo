/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link NodoService}.
 *
 * @author Giorgianni_F
 * @see NodoService
 * @generated
 */
public class NodoServiceWrapper
	implements NodoService, ServiceWrapper<NodoService> {

	public NodoServiceWrapper() {
		this(null);
	}

	public NodoServiceWrapper(NodoService nodoService) {
		_nodoService = nodoService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _nodoService.getOSGiServiceIdentifier();
	}

	@Override
	public NodoService getWrappedService() {
		return _nodoService;
	}

	@Override
	public void setWrappedService(NodoService nodoService) {
		_nodoService = nodoService;
	}

	private NodoService _nodoService;

}