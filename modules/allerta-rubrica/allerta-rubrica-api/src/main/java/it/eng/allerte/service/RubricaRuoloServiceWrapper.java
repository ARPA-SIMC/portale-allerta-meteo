/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RubricaRuoloService}.
 *
 * @author Pratola_L
 * @see RubricaRuoloService
 * @generated
 */
public class RubricaRuoloServiceWrapper
	implements RubricaRuoloService, ServiceWrapper<RubricaRuoloService> {

	public RubricaRuoloServiceWrapper() {
		this(null);
	}

	public RubricaRuoloServiceWrapper(RubricaRuoloService rubricaRuoloService) {
		_rubricaRuoloService = rubricaRuoloService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rubricaRuoloService.getOSGiServiceIdentifier();
	}

	@Override
	public RubricaRuoloService getWrappedService() {
		return _rubricaRuoloService;
	}

	@Override
	public void setWrappedService(RubricaRuoloService rubricaRuoloService) {
		_rubricaRuoloService = rubricaRuoloService;
	}

	private RubricaRuoloService _rubricaRuoloService;

}