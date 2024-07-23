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

package allerta.verifica.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VerificaDatoService}.
 *
 * @author Brian Wing Shun Chan
 * @see VerificaDatoService
 * @generated
 */
@ProviderType
public class VerificaDatoServiceWrapper
	implements VerificaDatoService, ServiceWrapper<VerificaDatoService> {

	public VerificaDatoServiceWrapper(VerificaDatoService verificaDatoService) {
		_verificaDatoService = verificaDatoService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _verificaDatoService.getOSGiServiceIdentifier();
	}

	@Override
	public VerificaDatoService getWrappedService() {
		return _verificaDatoService;
	}

	@Override
	public void setWrappedService(VerificaDatoService verificaDatoService) {
		_verificaDatoService = verificaDatoService;
	}

	private VerificaDatoService _verificaDatoService;

}