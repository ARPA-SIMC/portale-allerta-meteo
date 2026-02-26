/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package it.eng.allerter.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author GFAVINI
 */
public class NoSuchLogInternoException extends NoSuchModelException {

	public NoSuchLogInternoException() {
	}

	public NoSuchLogInternoException(String msg) {
		super(msg);
	}

	public NoSuchLogInternoException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchLogInternoException(Throwable throwable) {
		super(throwable);
	}

}