/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RegolaAllarmeComuneService}.
 *
 * @author GFAVINI
 * @see RegolaAllarmeComuneService
 * @generated
 */
public class RegolaAllarmeComuneServiceWrapper
	implements RegolaAllarmeComuneService,
			   ServiceWrapper<RegolaAllarmeComuneService> {

	public RegolaAllarmeComuneServiceWrapper() {
		this(null);
	}

	public RegolaAllarmeComuneServiceWrapper(
		RegolaAllarmeComuneService regolaAllarmeComuneService) {

		_regolaAllarmeComuneService = regolaAllarmeComuneService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _regolaAllarmeComuneService.getOSGiServiceIdentifier();
	}

	@Override
	public RegolaAllarmeComuneService getWrappedService() {
		return _regolaAllarmeComuneService;
	}

	@Override
	public void setWrappedService(
		RegolaAllarmeComuneService regolaAllarmeComuneService) {

		_regolaAllarmeComuneService = regolaAllarmeComuneService;
	}

	private RegolaAllarmeComuneService _regolaAllarmeComuneService;

}