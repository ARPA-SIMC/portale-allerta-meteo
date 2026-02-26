/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package it.eng.animaeteo.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author UTENTE
 */
public class NoSuchAnimeteoImgException extends NoSuchModelException {

	public NoSuchAnimeteoImgException() {
	}

	public NoSuchAnimeteoImgException(String msg) {
		super(msg);
	}

	public NoSuchAnimeteoImgException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchAnimeteoImgException(Throwable throwable) {
		super(throwable);
	}

}