/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VariabileService}.
 *
 * @author GFAVINI
 * @see VariabileService
 * @generated
 */
public class VariabileServiceWrapper
	implements ServiceWrapper<VariabileService>, VariabileService {

	public VariabileServiceWrapper() {
		this(null);
	}

	public VariabileServiceWrapper(VariabileService variabileService) {
		_variabileService = variabileService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _variabileService.getOSGiServiceIdentifier();
	}

	@Override
	public VariabileService getWrappedService() {
		return _variabileService;
	}

	@Override
	public void setWrappedService(VariabileService variabileService) {
		_variabileService = variabileService;
	}

	private VariabileService _variabileService;

}