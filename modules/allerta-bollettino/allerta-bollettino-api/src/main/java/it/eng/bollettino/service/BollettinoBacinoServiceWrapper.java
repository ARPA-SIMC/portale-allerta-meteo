/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BollettinoBacinoService}.
 *
 * @author GFAVINI
 * @see BollettinoBacinoService
 * @generated
 */
public class BollettinoBacinoServiceWrapper
	implements BollettinoBacinoService,
			   ServiceWrapper<BollettinoBacinoService> {

	public BollettinoBacinoServiceWrapper() {
		this(null);
	}

	public BollettinoBacinoServiceWrapper(
		BollettinoBacinoService bollettinoBacinoService) {

		_bollettinoBacinoService = bollettinoBacinoService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bollettinoBacinoService.getOSGiServiceIdentifier();
	}

	@Override
	public BollettinoBacinoService getWrappedService() {
		return _bollettinoBacinoService;
	}

	@Override
	public void setWrappedService(
		BollettinoBacinoService bollettinoBacinoService) {

		_bollettinoBacinoService = bollettinoBacinoService;
	}

	private BollettinoBacinoService _bollettinoBacinoService;

}