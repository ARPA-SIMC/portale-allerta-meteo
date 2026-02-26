/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SMSService}.
 *
 * @author GFAVINI
 * @see SMSService
 * @generated
 */
public class SMSServiceWrapper
	implements ServiceWrapper<SMSService>, SMSService {

	public SMSServiceWrapper() {
		this(null);
	}

	public SMSServiceWrapper(SMSService smsService) {
		_smsService = smsService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _smsService.getOSGiServiceIdentifier();
	}

	@Override
	public SMSService getWrappedService() {
		return _smsService;
	}

	@Override
	public void setWrappedService(SMSService smsService) {
		_smsService = smsService;
	}

	private SMSService _smsService;

}