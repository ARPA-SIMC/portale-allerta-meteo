/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.cache.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DatiService}.
 *
 * @author GFAVINI
 * @see DatiService
 * @generated
 */
public class DatiServiceWrapper
	implements DatiService, ServiceWrapper<DatiService> {

	public DatiServiceWrapper() {
		this(null);
	}

	public DatiServiceWrapper(DatiService datiService) {
		_datiService = datiService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _datiService.getOSGiServiceIdentifier();
	}

	@Override
	public DatiService getWrappedService() {
		return _datiService;
	}

	@Override
	public void setWrappedService(DatiService datiService) {
		_datiService = datiService;
	}

	private DatiService _datiService;

}