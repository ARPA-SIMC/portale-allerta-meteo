/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package it.eng.bollettino.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author GFAVINI
 */
public class NoSuchValoreSensoreException extends NoSuchModelException {

	public NoSuchValoreSensoreException() {
	}

	public NoSuchValoreSensoreException(String msg) {
		super(msg);
	}

	public NoSuchValoreSensoreException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchValoreSensoreException(Throwable throwable) {
		super(throwable);
	}

}