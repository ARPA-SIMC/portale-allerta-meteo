/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmailService}.
 *
 * @author GFAVINI
 * @see EmailService
 * @generated
 */
public class EmailServiceWrapper
	implements EmailService, ServiceWrapper<EmailService> {

	public EmailServiceWrapper() {
		this(null);
	}

	public EmailServiceWrapper(EmailService emailService) {
		_emailService = emailService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _emailService.getOSGiServiceIdentifier();
	}

	@Override
	public EmailService getWrappedService() {
		return _emailService;
	}

	@Override
	public void setWrappedService(EmailService emailService) {
		_emailService = emailService;
	}

	private EmailService _emailService;

}