/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PluviometroService}.
 *
 * @author GFAVINI
 * @see PluviometroService
 * @generated
 */
public class PluviometroServiceWrapper
	implements PluviometroService, ServiceWrapper<PluviometroService> {

	public PluviometroServiceWrapper() {
		this(null);
	}

	public PluviometroServiceWrapper(PluviometroService pluviometroService) {
		_pluviometroService = pluviometroService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _pluviometroService.getOSGiServiceIdentifier();
	}

	@Override
	public PluviometroService getWrappedService() {
		return _pluviometroService;
	}

	@Override
	public void setWrappedService(PluviometroService pluviometroService) {
		_pluviometroService = pluviometroService;
	}

	private PluviometroService _pluviometroService;

}