/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AllertaParametroService}.
 *
 * @author GFAVINI
 * @see AllertaParametroService
 * @generated
 */
public class AllertaParametroServiceWrapper
	implements AllertaParametroService,
			   ServiceWrapper<AllertaParametroService> {

	public AllertaParametroServiceWrapper() {
		this(null);
	}

	public AllertaParametroServiceWrapper(
		AllertaParametroService allertaParametroService) {

		_allertaParametroService = allertaParametroService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _allertaParametroService.getOSGiServiceIdentifier();
	}

	@Override
	public AllertaParametroService getWrappedService() {
		return _allertaParametroService;
	}

	@Override
	public void setWrappedService(
		AllertaParametroService allertaParametroService) {

		_allertaParametroService = allertaParametroService;
	}

	private AllertaParametroService _allertaParametroService;

}