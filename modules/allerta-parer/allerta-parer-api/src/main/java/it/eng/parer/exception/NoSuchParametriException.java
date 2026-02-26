/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package it.eng.parer.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Pratola_L
 */
public class NoSuchParametriException extends NoSuchModelException {

	public NoSuchParametriException() {
	}

	public NoSuchParametriException(String msg) {
		super(msg);
	}

	public NoSuchParametriException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchParametriException(Throwable throwable) {
		super(throwable);
	}

}