/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package allerta.catasto.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchCategoriaException extends NoSuchModelException {

	public NoSuchCategoriaException() {
	}

	public NoSuchCategoriaException(String msg) {
		super(msg);
	}

	public NoSuchCategoriaException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchCategoriaException(Throwable throwable) {
		super(throwable);
	}

}