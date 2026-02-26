/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link IconaService}.
 *
 * @author GFAVINI
 * @see IconaService
 * @generated
 */
public class IconaServiceWrapper
	implements IconaService, ServiceWrapper<IconaService> {

	public IconaServiceWrapper() {
		this(null);
	}

	public IconaServiceWrapper(IconaService iconaService) {
		_iconaService = iconaService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _iconaService.getOSGiServiceIdentifier();
	}

	@Override
	public IconaService getWrappedService() {
		return _iconaService;
	}

	@Override
	public void setWrappedService(IconaService iconaService) {
		_iconaService = iconaService;
	}

	private IconaService _iconaService;

}