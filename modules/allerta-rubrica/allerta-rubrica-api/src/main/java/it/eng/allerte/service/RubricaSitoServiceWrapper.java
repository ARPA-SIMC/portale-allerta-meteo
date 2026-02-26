/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RubricaSitoService}.
 *
 * @author Pratola_L
 * @see RubricaSitoService
 * @generated
 */
public class RubricaSitoServiceWrapper
	implements RubricaSitoService, ServiceWrapper<RubricaSitoService> {

	public RubricaSitoServiceWrapper() {
		this(null);
	}

	public RubricaSitoServiceWrapper(RubricaSitoService rubricaSitoService) {
		_rubricaSitoService = rubricaSitoService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rubricaSitoService.getOSGiServiceIdentifier();
	}

	@Override
	public RubricaSitoService getWrappedService() {
		return _rubricaSitoService;
	}

	@Override
	public void setWrappedService(RubricaSitoService rubricaSitoService) {
		_rubricaSitoService = rubricaSitoService;
	}

	private RubricaSitoService _rubricaSitoService;

}