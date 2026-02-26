/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GeografiaService}.
 *
 * @author GFAVINI
 * @see GeografiaService
 * @generated
 */
public class GeografiaServiceWrapper
	implements GeografiaService, ServiceWrapper<GeografiaService> {

	public GeografiaServiceWrapper() {
		this(null);
	}

	public GeografiaServiceWrapper(GeografiaService geografiaService) {
		_geografiaService = geografiaService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _geografiaService.getOSGiServiceIdentifier();
	}

	@Override
	public GeografiaService getWrappedService() {
		return _geografiaService;
	}

	@Override
	public void setWrappedService(GeografiaService geografiaService) {
		_geografiaService = geografiaService;
	}

	private GeografiaService _geografiaService;

}