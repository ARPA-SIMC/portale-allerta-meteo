/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package it.eng.animaeteo.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author UTENTE
 */
public class NoSuchAnimeteoSmallImgException extends NoSuchModelException {

	public NoSuchAnimeteoSmallImgException() {
	}

	public NoSuchAnimeteoSmallImgException(String msg) {
		super(msg);
	}

	public NoSuchAnimeteoSmallImgException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchAnimeteoSmallImgException(Throwable throwable) {
		super(throwable);
	}

}