/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AllertaStatoService}.
 *
 * @author GFAVINI
 * @see AllertaStatoService
 * @generated
 */
public class AllertaStatoServiceWrapper
	implements AllertaStatoService, ServiceWrapper<AllertaStatoService> {

	public AllertaStatoServiceWrapper() {
		this(null);
	}

	public AllertaStatoServiceWrapper(AllertaStatoService allertaStatoService) {
		_allertaStatoService = allertaStatoService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _allertaStatoService.getOSGiServiceIdentifier();
	}

	@Override
	public AllertaStatoService getWrappedService() {
		return _allertaStatoService;
	}

	@Override
	public void setWrappedService(AllertaStatoService allertaStatoService) {
		_allertaStatoService = allertaStatoService;
	}

	private AllertaStatoService _allertaStatoService;

}