/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TipoEventoService}.
 *
 * @author GFAVINI
 * @see TipoEventoService
 * @generated
 */
public class TipoEventoServiceWrapper
	implements ServiceWrapper<TipoEventoService>, TipoEventoService {

	public TipoEventoServiceWrapper() {
		this(null);
	}

	public TipoEventoServiceWrapper(TipoEventoService tipoEventoService) {
		_tipoEventoService = tipoEventoService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _tipoEventoService.getOSGiServiceIdentifier();
	}

	@Override
	public TipoEventoService getWrappedService() {
		return _tipoEventoService;
	}

	@Override
	public void setWrappedService(TipoEventoService tipoEventoService) {
		_tipoEventoService = tipoEventoService;
	}

	private TipoEventoService _tipoEventoService;

}