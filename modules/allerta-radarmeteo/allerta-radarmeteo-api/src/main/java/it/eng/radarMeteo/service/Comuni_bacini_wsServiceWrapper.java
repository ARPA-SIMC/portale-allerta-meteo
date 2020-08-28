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

package it.eng.radarMeteo.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link Comuni_bacini_wsService}.
 *
 * @author Francesco
 * @see Comuni_bacini_wsService
 * @generated
 */
@ProviderType
public class Comuni_bacini_wsServiceWrapper
	implements Comuni_bacini_wsService,
			   ServiceWrapper<Comuni_bacini_wsService> {

	public Comuni_bacini_wsServiceWrapper(
		Comuni_bacini_wsService comuni_bacini_wsService) {

		_comuni_bacini_wsService = comuni_bacini_wsService;
	}

	@Override
	public java.util.Map<String, Object> getBollettinoMonitoraggio() {
		return _comuni_bacini_wsService.getBollettinoMonitoraggio();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _comuni_bacini_wsService.getOSGiServiceIdentifier();
	}

	@Override
	public Comuni_bacini_wsService getWrappedService() {
		return _comuni_bacini_wsService;
	}

	@Override
	public void setWrappedService(
		Comuni_bacini_wsService comuni_bacini_wsService) {

		_comuni_bacini_wsService = comuni_bacini_wsService;
	}

	private Comuni_bacini_wsService _comuni_bacini_wsService;

}