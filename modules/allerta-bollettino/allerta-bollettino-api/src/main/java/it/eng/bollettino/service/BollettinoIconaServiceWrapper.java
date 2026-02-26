/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BollettinoIconaService}.
 *
 * @author GFAVINI
 * @see BollettinoIconaService
 * @generated
 */
public class BollettinoIconaServiceWrapper
	implements BollettinoIconaService, ServiceWrapper<BollettinoIconaService> {

	public BollettinoIconaServiceWrapper() {
		this(null);
	}

	public BollettinoIconaServiceWrapper(
		BollettinoIconaService bollettinoIconaService) {

		_bollettinoIconaService = bollettinoIconaService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bollettinoIconaService.getOSGiServiceIdentifier();
	}

	@Override
	public BollettinoIconaService getWrappedService() {
		return _bollettinoIconaService;
	}

	@Override
	public void setWrappedService(
		BollettinoIconaService bollettinoIconaService) {

		_bollettinoIconaService = bollettinoIconaService;
	}

	private BollettinoIconaService _bollettinoIconaService;

}