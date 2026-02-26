/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package allerta.verifica.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchVerificaException extends NoSuchModelException {

	public NoSuchVerificaException() {
	}

	public NoSuchVerificaException(String msg) {
		super(msg);
	}

	public NoSuchVerificaException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchVerificaException(Throwable throwable) {
		super(throwable);
	}

}