/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AllertaValangheStatoService}.
 *
 * @author GFAVINI
 * @see AllertaValangheStatoService
 * @generated
 */
public class AllertaValangheStatoServiceWrapper
	implements AllertaValangheStatoService,
			   ServiceWrapper<AllertaValangheStatoService> {

	public AllertaValangheStatoServiceWrapper() {
		this(null);
	}

	public AllertaValangheStatoServiceWrapper(
		AllertaValangheStatoService allertaValangheStatoService) {

		_allertaValangheStatoService = allertaValangheStatoService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _allertaValangheStatoService.getOSGiServiceIdentifier();
	}

	@Override
	public AllertaValangheStatoService getWrappedService() {
		return _allertaValangheStatoService;
	}

	@Override
	public void setWrappedService(
		AllertaValangheStatoService allertaValangheStatoService) {

		_allertaValangheStatoService = allertaValangheStatoService;
	}

	private AllertaValangheStatoService _allertaValangheStatoService;

}