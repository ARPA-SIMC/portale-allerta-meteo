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

package it.eng.allerter.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmailService}.
 *
 * @author GFAVINI
 * @see EmailService
 * @generated
 */
@ProviderType
public class EmailServiceWrapper
	implements EmailService, ServiceWrapper<EmailService> {

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