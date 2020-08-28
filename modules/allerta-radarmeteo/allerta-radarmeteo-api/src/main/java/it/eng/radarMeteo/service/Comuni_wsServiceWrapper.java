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
 * Provides a wrapper for {@link Comuni_wsService}.
 *
 * @author Francesco
 * @see Comuni_wsService
 * @generated
 */
@ProviderType
public class Comuni_wsServiceWrapper
	implements Comuni_wsService, ServiceWrapper<Comuni_wsService> {

	public Comuni_wsServiceWrapper(Comuni_wsService comuni_wsService) {
		_comuni_wsService = comuni_wsService;
	}

	@Override
	public java.util.ArrayList<java.util.HashMap<String, String>>
		getMeteomont() {

		return _comuni_wsService.getMeteomont();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _comuni_wsService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.Map<String, Object> getStatoAllerta() {
		return _comuni_wsService.getStatoAllerta();
	}

	@Override
	public java.util.Map<String, Object> getStatoAllerta(
		java.sql.Timestamp timestamp) {

		return _comuni_wsService.getStatoAllerta(timestamp);
	}

	@Override
	public Comuni_wsService getWrappedService() {
		return _comuni_wsService;
	}

	@Override
	public void setWrappedService(Comuni_wsService comuni_wsService) {
		_comuni_wsService = comuni_wsService;
	}

	private Comuni_wsService _comuni_wsService;

}