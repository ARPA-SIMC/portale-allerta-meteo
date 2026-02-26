/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package it.eng.parer.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Pratola_L
 */
public class NoSuchComponentiInvioException extends NoSuchModelException {

	public NoSuchComponentiInvioException() {
	}

	public NoSuchComponentiInvioException(String msg) {
		super(msg);
	}

	public NoSuchComponentiInvioException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchComponentiInvioException(Throwable throwable) {
		super(throwable);
	}

}