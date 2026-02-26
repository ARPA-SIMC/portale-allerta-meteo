/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ParametroService}.
 *
 * @author Giorgianni_F
 * @see ParametroService
 * @generated
 */
public class ParametroServiceWrapper
	implements ParametroService, ServiceWrapper<ParametroService> {

	public ParametroServiceWrapper() {
		this(null);
	}

	public ParametroServiceWrapper(ParametroService parametroService) {
		_parametroService = parametroService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _parametroService.getOSGiServiceIdentifier();
	}

	@Override
	public ParametroService getWrappedService() {
		return _parametroService;
	}

	@Override
	public void setWrappedService(ParametroService parametroService) {
		_parametroService = parametroService;
	}

	private ParametroService _parametroService;

}