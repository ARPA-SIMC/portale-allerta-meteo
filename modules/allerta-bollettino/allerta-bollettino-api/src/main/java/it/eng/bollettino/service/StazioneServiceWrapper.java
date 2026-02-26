/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StazioneService}.
 *
 * @author GFAVINI
 * @see StazioneService
 * @generated
 */
public class StazioneServiceWrapper
	implements ServiceWrapper<StazioneService>, StazioneService {

	public StazioneServiceWrapper() {
		this(null);
	}

	public StazioneServiceWrapper(StazioneService stazioneService) {
		_stazioneService = stazioneService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _stazioneService.getOSGiServiceIdentifier();
	}

	@Override
	public StazioneService getWrappedService() {
		return _stazioneService;
	}

	@Override
	public void setWrappedService(StazioneService stazioneService) {
		_stazioneService = stazioneService;
	}

	private StazioneService _stazioneService;

}