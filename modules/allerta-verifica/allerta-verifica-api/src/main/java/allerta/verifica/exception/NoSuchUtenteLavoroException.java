/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package allerta.verifica.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchUtenteLavoroException extends NoSuchModelException {

	public NoSuchUtenteLavoroException() {
	}

	public NoSuchUtenteLavoroException(String msg) {
		super(msg);
	}

	public NoSuchUtenteLavoroException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchUtenteLavoroException(Throwable throwable) {
		super(throwable);
	}

}