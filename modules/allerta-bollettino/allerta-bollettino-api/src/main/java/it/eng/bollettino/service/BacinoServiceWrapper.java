/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BacinoService}.
 *
 * @author GFAVINI
 * @see BacinoService
 * @generated
 */
public class BacinoServiceWrapper
	implements BacinoService, ServiceWrapper<BacinoService> {

	public BacinoServiceWrapper() {
		this(null);
	}

	public BacinoServiceWrapper(BacinoService bacinoService) {
		_bacinoService = bacinoService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bacinoService.getOSGiServiceIdentifier();
	}

	@Override
	public BacinoService getWrappedService() {
		return _bacinoService;
	}

	@Override
	public void setWrappedService(BacinoService bacinoService) {
		_bacinoService = bacinoService;
	}

	private BacinoService _bacinoService;

}