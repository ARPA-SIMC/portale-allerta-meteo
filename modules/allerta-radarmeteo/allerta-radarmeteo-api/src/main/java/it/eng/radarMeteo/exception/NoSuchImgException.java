/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package it.eng.radarMeteo.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Francesco
 */
public class NoSuchImgException extends NoSuchModelException {

	public NoSuchImgException() {
	}

	public NoSuchImgException(String msg) {
		super(msg);
	}

	public NoSuchImgException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchImgException(Throwable throwable) {
		super(throwable);
	}

}