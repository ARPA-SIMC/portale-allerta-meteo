/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SegnalazioneService}.
 *
 * @author Brian Wing Shun Chan
 * @see SegnalazioneService
 * @generated
 */
public class SegnalazioneServiceWrapper
	implements SegnalazioneService, ServiceWrapper<SegnalazioneService> {

	public SegnalazioneServiceWrapper() {
		this(null);
	}

	public SegnalazioneServiceWrapper(SegnalazioneService segnalazioneService) {
		_segnalazioneService = segnalazioneService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _segnalazioneService.getOSGiServiceIdentifier();
	}

	@Override
	public SegnalazioneService getWrappedService() {
		return _segnalazioneService;
	}

	@Override
	public void setWrappedService(SegnalazioneService segnalazioneService) {
		_segnalazioneService = segnalazioneService;
	}

	private SegnalazioneService _segnalazioneService;

}