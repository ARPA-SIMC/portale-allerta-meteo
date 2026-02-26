/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link IdrometroService}.
 *
 * @author GFAVINI
 * @see IdrometroService
 * @generated
 */
public class IdrometroServiceWrapper
	implements IdrometroService, ServiceWrapper<IdrometroService> {

	public IdrometroServiceWrapper() {
		this(null);
	}

	public IdrometroServiceWrapper(IdrometroService idrometroService) {
		_idrometroService = idrometroService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _idrometroService.getOSGiServiceIdentifier();
	}

	@Override
	public IdrometroService getWrappedService() {
		return _idrometroService;
	}

	@Override
	public void setWrappedService(IdrometroService idrometroService) {
		_idrometroService = idrometroService;
	}

	private IdrometroService _idrometroService;

}