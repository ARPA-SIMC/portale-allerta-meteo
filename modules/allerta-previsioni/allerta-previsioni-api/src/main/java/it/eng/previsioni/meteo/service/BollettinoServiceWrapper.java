/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.previsioni.meteo.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BollettinoService}.
 *
 * @author Brian Wing Shun Chan
 * @see BollettinoService
 * @generated
 */
public class BollettinoServiceWrapper
	implements BollettinoService, ServiceWrapper<BollettinoService> {

	public BollettinoServiceWrapper() {
		this(null);
	}

	public BollettinoServiceWrapper(BollettinoService bollettinoService) {
		_bollettinoService = bollettinoService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bollettinoService.getOSGiServiceIdentifier();
	}

	@Override
	public BollettinoService getWrappedService() {
		return _bollettinoService;
	}

	@Override
	public void setWrappedService(BollettinoService bollettinoService) {
		_bollettinoService = bollettinoService;
	}

	private BollettinoService _bollettinoService;

}