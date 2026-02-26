/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ValoreSensoreService}.
 *
 * @author GFAVINI
 * @see ValoreSensoreService
 * @generated
 */
public class ValoreSensoreServiceWrapper
	implements ServiceWrapper<ValoreSensoreService>, ValoreSensoreService {

	public ValoreSensoreServiceWrapper() {
		this(null);
	}

	public ValoreSensoreServiceWrapper(
		ValoreSensoreService valoreSensoreService) {

		_valoreSensoreService = valoreSensoreService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _valoreSensoreService.getOSGiServiceIdentifier();
	}

	@Override
	public ValoreSensoreService getWrappedService() {
		return _valoreSensoreService;
	}

	@Override
	public void setWrappedService(ValoreSensoreService valoreSensoreService) {
		_valoreSensoreService = valoreSensoreService;
	}

	private ValoreSensoreService _valoreSensoreService;

}