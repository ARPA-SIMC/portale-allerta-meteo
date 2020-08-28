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

package it.eng.bollettino.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RegolaAllarmeCondizioneService}.
 *
 * @author GFAVINI
 * @see RegolaAllarmeCondizioneService
 * @generated
 */
@ProviderType
public class RegolaAllarmeCondizioneServiceWrapper
	implements RegolaAllarmeCondizioneService,
			   ServiceWrapper<RegolaAllarmeCondizioneService> {

	public RegolaAllarmeCondizioneServiceWrapper(
		RegolaAllarmeCondizioneService regolaAllarmeCondizioneService) {

		_regolaAllarmeCondizioneService = regolaAllarmeCondizioneService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _regolaAllarmeCondizioneService.getOSGiServiceIdentifier();
	}

	@Override
	public RegolaAllarmeCondizioneService getWrappedService() {
		return _regolaAllarmeCondizioneService;
	}

	@Override
	public void setWrappedService(
		RegolaAllarmeCondizioneService regolaAllarmeCondizioneService) {

		_regolaAllarmeCondizioneService = regolaAllarmeCondizioneService;
	}

	private RegolaAllarmeCondizioneService _regolaAllarmeCondizioneService;

}