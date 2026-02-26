/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package it.eng.allerter.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author GFAVINI
 */
public class NoSuchAllertaValangheException extends NoSuchModelException {

	public NoSuchAllertaValangheException() {
	}

	public NoSuchAllertaValangheException(String msg) {
		super(msg);
	}

	public NoSuchAllertaValangheException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchAllertaValangheException(Throwable throwable) {
		super(throwable);
	}

}