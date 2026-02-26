/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animaeteo.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AnimeteoImgService}.
 *
 * @author UTENTE
 * @see AnimeteoImgService
 * @generated
 */
public class AnimeteoImgServiceWrapper
	implements AnimeteoImgService, ServiceWrapper<AnimeteoImgService> {

	public AnimeteoImgServiceWrapper() {
		this(null);
	}

	public AnimeteoImgServiceWrapper(AnimeteoImgService animeteoImgService) {
		_animeteoImgService = animeteoImgService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _animeteoImgService.getOSGiServiceIdentifier();
	}

	@Override
	public AnimeteoImgService getWrappedService() {
		return _animeteoImgService;
	}

	@Override
	public void setWrappedService(AnimeteoImgService animeteoImgService) {
		_animeteoImgService = animeteoImgService;
	}

	private AnimeteoImgService _animeteoImgService;

}