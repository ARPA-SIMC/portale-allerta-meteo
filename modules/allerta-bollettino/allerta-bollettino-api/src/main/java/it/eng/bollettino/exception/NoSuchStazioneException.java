/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package it.eng.bollettino.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author GFAVINI
 */
public class NoSuchStazioneException extends NoSuchModelException {

	public NoSuchStazioneException() {
	}

	public NoSuchStazioneException(String msg) {
		super(msg);
	}

	public NoSuchStazioneException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchStazioneException(Throwable throwable) {
		super(throwable);
	}

}