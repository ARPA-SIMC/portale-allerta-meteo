/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package it.eng.cache.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author GFAVINI
 */
public class NoSuchDatiException extends NoSuchModelException {

	public NoSuchDatiException() {
	}

	public NoSuchDatiException(String msg) {
		super(msg);
	}

	public NoSuchDatiException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchDatiException(Throwable throwable) {
		super(throwable);
	}

}