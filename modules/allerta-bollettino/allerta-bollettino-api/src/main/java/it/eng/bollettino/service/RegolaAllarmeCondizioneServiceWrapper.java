/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RegolaAllarmeCondizioneService}.
 *
 * @author GFAVINI
 * @see RegolaAllarmeCondizioneService
 * @generated
 */
public class RegolaAllarmeCondizioneServiceWrapper
	implements RegolaAllarmeCondizioneService,
			   ServiceWrapper<RegolaAllarmeCondizioneService> {

	public RegolaAllarmeCondizioneServiceWrapper() {
		this(null);
	}

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