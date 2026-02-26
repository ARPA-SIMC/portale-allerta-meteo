/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RubricaPermessiService}.
 *
 * @author Pratola_L
 * @see RubricaPermessiService
 * @generated
 */
public class RubricaPermessiServiceWrapper
	implements RubricaPermessiService, ServiceWrapper<RubricaPermessiService> {

	public RubricaPermessiServiceWrapper() {
		this(null);
	}

	public RubricaPermessiServiceWrapper(
		RubricaPermessiService rubricaPermessiService) {

		_rubricaPermessiService = rubricaPermessiService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rubricaPermessiService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.Map<String, Object> getPermission() {
		return _rubricaPermessiService.getPermission();
	}

	@Override
	public RubricaPermessiService getWrappedService() {
		return _rubricaPermessiService;
	}

	@Override
	public void setWrappedService(
		RubricaPermessiService rubricaPermessiService) {

		_rubricaPermessiService = rubricaPermessiService;
	}

	private RubricaPermessiService _rubricaPermessiService;

}