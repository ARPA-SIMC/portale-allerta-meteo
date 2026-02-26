/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package it.eng.allerta.messages.services.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Giorgianni_F
 */
public class NoSuchParametroException extends NoSuchModelException {

	public NoSuchParametroException() {
	}

	public NoSuchParametroException(String msg) {
		super(msg);
	}

	public NoSuchParametroException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchParametroException(Throwable throwable) {
		super(throwable);
	}

}