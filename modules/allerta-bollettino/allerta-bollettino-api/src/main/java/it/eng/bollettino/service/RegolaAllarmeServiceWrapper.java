/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RegolaAllarmeService}.
 *
 * @author GFAVINI
 * @see RegolaAllarmeService
 * @generated
 */
public class RegolaAllarmeServiceWrapper
	implements RegolaAllarmeService, ServiceWrapper<RegolaAllarmeService> {

	public RegolaAllarmeServiceWrapper() {
		this(null);
	}

	public RegolaAllarmeServiceWrapper(
		RegolaAllarmeService regolaAllarmeService) {

		_regolaAllarmeService = regolaAllarmeService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _regolaAllarmeService.getOSGiServiceIdentifier();
	}

	@Override
	public RegolaAllarmeService getWrappedService() {
		return _regolaAllarmeService;
	}

	@Override
	public void setWrappedService(RegolaAllarmeService regolaAllarmeService) {
		_regolaAllarmeService = regolaAllarmeService;
	}

	private RegolaAllarmeService _regolaAllarmeService;

}