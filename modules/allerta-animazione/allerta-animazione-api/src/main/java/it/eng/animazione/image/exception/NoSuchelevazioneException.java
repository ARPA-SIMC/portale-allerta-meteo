/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package it.eng.animazione.image.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author UTENTE
 */
public class NoSuchelevazioneException extends NoSuchModelException {

	public NoSuchelevazioneException() {
	}

	public NoSuchelevazioneException(String msg) {
		super(msg);
	}

	public NoSuchelevazioneException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchelevazioneException(Throwable throwable) {
		super(throwable);
	}

}