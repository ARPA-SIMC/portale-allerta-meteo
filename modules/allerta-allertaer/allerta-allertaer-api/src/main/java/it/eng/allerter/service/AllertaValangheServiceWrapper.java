/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AllertaValangheService}.
 *
 * @author GFAVINI
 * @see AllertaValangheService
 * @generated
 */
public class AllertaValangheServiceWrapper
	implements AllertaValangheService, ServiceWrapper<AllertaValangheService> {

	public AllertaValangheServiceWrapper() {
		this(null);
	}

	public AllertaValangheServiceWrapper(
		AllertaValangheService allertaValangheService) {

		_allertaValangheService = allertaValangheService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _allertaValangheService.getOSGiServiceIdentifier();
	}

	@Override
	public AllertaValangheService getWrappedService() {
		return _allertaValangheService;
	}

	@Override
	public void setWrappedService(
		AllertaValangheService allertaValangheService) {

		_allertaValangheService = allertaValangheService;
	}

	private AllertaValangheService _allertaValangheService;

}