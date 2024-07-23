/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package allerta.catasto.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FonteService}.
 *
 * @author Brian Wing Shun Chan
 * @see FonteService
 * @generated
 */
@ProviderType
public class FonteServiceWrapper
	implements FonteService, ServiceWrapper<FonteService> {

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