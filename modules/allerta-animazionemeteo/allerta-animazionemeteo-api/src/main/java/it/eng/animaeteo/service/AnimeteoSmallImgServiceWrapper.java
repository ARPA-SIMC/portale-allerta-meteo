/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animaeteo.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AnimeteoSmallImgService}.
 *
 * @author UTENTE
 * @see AnimeteoSmallImgService
 * @generated
 */
public class AnimeteoSmallImgServiceWrapper
	implements AnimeteoSmallImgService,
			   ServiceWrapper<AnimeteoSmallImgService> {

	public AnimeteoSmallImgServiceWrapper() {
		this(null);
	}

	public AnimeteoSmallImgServiceWrapper(
		AnimeteoSmallImgService animeteoSmallImgService) {

		_animeteoSmallImgService = animeteoSmallImgService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _animeteoSmallImgService.getOSGiServiceIdentifier();
	}

	@Override
	public AnimeteoSmallImgService getWrappedService() {
		return _animeteoSmallImgService;
	}

	@Override
	public void setWrappedService(
		AnimeteoSmallImgService animeteoSmallImgService) {

		_animeteoSmallImgService = animeteoSmallImgService;
	}

	private AnimeteoSmallImgService _animeteoSmallImgService;

}