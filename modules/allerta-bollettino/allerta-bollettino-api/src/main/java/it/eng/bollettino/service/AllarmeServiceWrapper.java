/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AllarmeService}.
 *
 * @author GFAVINI
 * @see AllarmeService
 * @generated
 */
public class AllarmeServiceWrapper
	implements AllarmeService, ServiceWrapper<AllarmeService> {

	public AllarmeServiceWrapper() {
		this(null);
	}

	public AllarmeServiceWrapper(AllarmeService allarmeService) {
		_allarmeService = allarmeService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _allarmeService.getOSGiServiceIdentifier();
	}

	@Override
	public AllarmeService getWrappedService() {
		return _allarmeService;
	}

	@Override
	public void setWrappedService(AllarmeService allarmeService) {
		_allarmeService = allarmeService;
	}

	private AllarmeService _allarmeService;

}