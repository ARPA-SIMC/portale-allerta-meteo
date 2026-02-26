/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package allerta.verifica.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchVerificaDatoException extends NoSuchModelException {

	public NoSuchVerificaDatoException() {
	}

	public NoSuchVerificaDatoException(String msg) {
		super(msg);
	}

	public NoSuchVerificaDatoException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchVerificaDatoException(Throwable throwable) {
		super(throwable);
	}

}