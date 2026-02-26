/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StazioneVariabileService}.
 *
 * @author GFAVINI
 * @see StazioneVariabileService
 * @generated
 */
public class StazioneVariabileServiceWrapper
	implements ServiceWrapper<StazioneVariabileService>,
			   StazioneVariabileService {

	public StazioneVariabileServiceWrapper() {
		this(null);
	}

	public StazioneVariabileServiceWrapper(
		StazioneVariabileService stazioneVariabileService) {

		_stazioneVariabileService = stazioneVariabileService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _stazioneVariabileService.getOSGiServiceIdentifier();
	}

	@Override
	public StazioneVariabileService getWrappedService() {
		return _stazioneVariabileService;
	}

	@Override
	public void setWrappedService(
		StazioneVariabileService stazioneVariabileService) {

		_stazioneVariabileService = stazioneVariabileService;
	}

	private StazioneVariabileService _stazioneVariabileService;

}