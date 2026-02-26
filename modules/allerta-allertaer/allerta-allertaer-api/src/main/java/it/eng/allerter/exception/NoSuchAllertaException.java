/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package it.eng.allerter.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author GFAVINI
 */
public class NoSuchAllertaException extends NoSuchModelException {

	public NoSuchAllertaException() {
	}

	public NoSuchAllertaException(String msg) {
		super(msg);
	}

	public NoSuchAllertaException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchAllertaException(Throwable throwable) {
		super(throwable);
	}

}