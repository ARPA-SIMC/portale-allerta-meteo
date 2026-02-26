/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BollettinoParametroService}.
 *
 * @author GFAVINI
 * @see BollettinoParametroService
 * @generated
 */
public class BollettinoParametroServiceWrapper
	implements BollettinoParametroService,
			   ServiceWrapper<BollettinoParametroService> {

	public BollettinoParametroServiceWrapper() {
		this(null);
	}

	public BollettinoParametroServiceWrapper(
		BollettinoParametroService bollettinoParametroService) {

		_bollettinoParametroService = bollettinoParametroService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bollettinoParametroService.getOSGiServiceIdentifier();
	}

	@Override
	public BollettinoParametroService getWrappedService() {
		return _bollettinoParametroService;
	}

	@Override
	public void setWrappedService(
		BollettinoParametroService bollettinoParametroService) {

		_bollettinoParametroService = bollettinoParametroService;
	}

	private BollettinoParametroService _bollettinoParametroService;

}