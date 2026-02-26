/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.previsioni.meteo.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ImgService}.
 *
 * @author Brian Wing Shun Chan
 * @see ImgService
 * @generated
 */
public class ImgServiceWrapper
	implements ImgService, ServiceWrapper<ImgService> {

	public ImgServiceWrapper() {
		this(null);
	}

	public ImgServiceWrapper(ImgService imgService) {
		_imgService = imgService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _imgService.getOSGiServiceIdentifier();
	}

	@Override
	public ImgService getWrappedService() {
		return _imgService;
	}

	@Override
	public void setWrappedService(ImgService imgService) {
		_imgService = imgService;
	}

	private ImgService _imgService;

}