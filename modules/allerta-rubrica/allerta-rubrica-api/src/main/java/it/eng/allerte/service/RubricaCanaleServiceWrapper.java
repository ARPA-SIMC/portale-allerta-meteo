/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RubricaCanaleService}.
 *
 * @author Pratola_L
 * @see RubricaCanaleService
 * @generated
 */
public class RubricaCanaleServiceWrapper
	implements RubricaCanaleService, ServiceWrapper<RubricaCanaleService> {

	public RubricaCanaleServiceWrapper() {
		this(null);
	}

	public RubricaCanaleServiceWrapper(
		RubricaCanaleService rubricaCanaleService) {

		_rubricaCanaleService = rubricaCanaleService;
	}

	@Override
	public java.util.Map<String, Object> getChannels() {
		return _rubricaCanaleService.getChannels();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rubricaCanaleService.getOSGiServiceIdentifier();
	}

	@Override
	public RubricaCanaleService getWrappedService() {
		return _rubricaCanaleService;
	}

	@Override
	public void setWrappedService(RubricaCanaleService rubricaCanaleService) {
		_rubricaCanaleService = rubricaCanaleService;
	}

	private RubricaCanaleService _rubricaCanaleService;

}