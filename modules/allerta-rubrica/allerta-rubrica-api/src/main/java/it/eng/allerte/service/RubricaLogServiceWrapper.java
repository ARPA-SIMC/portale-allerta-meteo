/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RubricaLogService}.
 *
 * @author Pratola_L
 * @see RubricaLogService
 * @generated
 */
public class RubricaLogServiceWrapper
	implements RubricaLogService, ServiceWrapper<RubricaLogService> {

	public RubricaLogServiceWrapper() {
		this(null);
	}

	public RubricaLogServiceWrapper(RubricaLogService rubricaLogService) {
		_rubricaLogService = rubricaLogService;
	}

	@Override
	public java.util.Map<String, Object> getLogs(
		String name, int limit, int offset) {

		return _rubricaLogService.getLogs(name, limit, offset);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rubricaLogService.getOSGiServiceIdentifier();
	}

	@Override
	public RubricaLogService getWrappedService() {
		return _rubricaLogService;
	}

	@Override
	public void setWrappedService(RubricaLogService rubricaLogService) {
		_rubricaLogService = rubricaLogService;
	}

	private RubricaLogService _rubricaLogService;

}