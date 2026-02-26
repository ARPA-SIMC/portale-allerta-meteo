/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BollettinoSensoreService}.
 *
 * @author GFAVINI
 * @see BollettinoSensoreService
 * @generated
 */
public class BollettinoSensoreServiceWrapper
	implements BollettinoSensoreService,
			   ServiceWrapper<BollettinoSensoreService> {

	public BollettinoSensoreServiceWrapper() {
		this(null);
	}

	public BollettinoSensoreServiceWrapper(
		BollettinoSensoreService bollettinoSensoreService) {

		_bollettinoSensoreService = bollettinoSensoreService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bollettinoSensoreService.getOSGiServiceIdentifier();
	}

	@Override
	public BollettinoSensoreService getWrappedService() {
		return _bollettinoSensoreService;
	}

	@Override
	public void setWrappedService(
		BollettinoSensoreService bollettinoSensoreService) {

		_bollettinoSensoreService = bollettinoSensoreService;
	}

	private BollettinoSensoreService _bollettinoSensoreService;

}