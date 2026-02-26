/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package it.eng.bollettino.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author GFAVINI
 */
public class NoSuchBollettinoBacinoException extends NoSuchModelException {

	public NoSuchBollettinoBacinoException() {
	}

	public NoSuchBollettinoBacinoException(String msg) {
		super(msg);
	}

	public NoSuchBollettinoBacinoException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchBollettinoBacinoException(Throwable throwable) {
		super(throwable);
	}

}