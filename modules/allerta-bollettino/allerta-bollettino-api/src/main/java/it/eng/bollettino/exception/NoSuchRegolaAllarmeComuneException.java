/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package it.eng.bollettino.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author GFAVINI
 */
public class NoSuchRegolaAllarmeComuneException extends NoSuchModelException {

	public NoSuchRegolaAllarmeComuneException() {
	}

	public NoSuchRegolaAllarmeComuneException(String msg) {
		super(msg);
	}

	public NoSuchRegolaAllarmeComuneException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchRegolaAllarmeComuneException(Throwable throwable) {
		super(throwable);
	}

}