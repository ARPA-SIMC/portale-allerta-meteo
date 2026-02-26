/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AttivazioneFiumeService}.
 *
 * @author GFAVINI
 * @see AttivazioneFiumeService
 * @generated
 */
public class AttivazioneFiumeServiceWrapper
	implements AttivazioneFiumeService,
			   ServiceWrapper<AttivazioneFiumeService> {

	public AttivazioneFiumeServiceWrapper() {
		this(null);
	}

	public AttivazioneFiumeServiceWrapper(
		AttivazioneFiumeService attivazioneFiumeService) {

		_attivazioneFiumeService = attivazioneFiumeService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _attivazioneFiumeService.getOSGiServiceIdentifier();
	}

	@Override
	public AttivazioneFiumeService getWrappedService() {
		return _attivazioneFiumeService;
	}

	@Override
	public void setWrappedService(
		AttivazioneFiumeService attivazioneFiumeService) {

		_attivazioneFiumeService = attivazioneFiumeService;
	}

	private AttivazioneFiumeService _attivazioneFiumeService;

}