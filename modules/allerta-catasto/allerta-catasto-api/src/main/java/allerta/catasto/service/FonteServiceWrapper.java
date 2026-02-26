/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FonteService}.
 *
 * @author Brian Wing Shun Chan
 * @see FonteService
 * @generated
 */
public class FonteServiceWrapper
	implements FonteService, ServiceWrapper<FonteService> {

	public FonteServiceWrapper() {
		this(null);
	}

	public FonteServiceWrapper(FonteService fonteService) {
		_fonteService = fonteService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _fonteService.getOSGiServiceIdentifier();
	}

	@Override
	public FonteService getWrappedService() {
		return _fonteService;
	}

	@Override
	public void setWrappedService(FonteService fonteService) {
		_fonteService = fonteService;
	}

	private FonteService _fonteService;

}