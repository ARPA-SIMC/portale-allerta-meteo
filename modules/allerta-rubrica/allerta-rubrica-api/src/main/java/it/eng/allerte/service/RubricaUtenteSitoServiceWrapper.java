/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RubricaUtenteSitoService}.
 *
 * @author Pratola_L
 * @see RubricaUtenteSitoService
 * @generated
 */
public class RubricaUtenteSitoServiceWrapper
	implements RubricaUtenteSitoService,
			   ServiceWrapper<RubricaUtenteSitoService> {

	public RubricaUtenteSitoServiceWrapper() {
		this(null);
	}

	public RubricaUtenteSitoServiceWrapper(
		RubricaUtenteSitoService rubricaUtenteSitoService) {

		_rubricaUtenteSitoService = rubricaUtenteSitoService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rubricaUtenteSitoService.getOSGiServiceIdentifier();
	}

	@Override
	public RubricaUtenteSitoService getWrappedService() {
		return _rubricaUtenteSitoService;
	}

	@Override
	public void setWrappedService(
		RubricaUtenteSitoService rubricaUtenteSitoService) {

		_rubricaUtenteSitoService = rubricaUtenteSitoService;
	}

	private RubricaUtenteSitoService _rubricaUtenteSitoService;

}