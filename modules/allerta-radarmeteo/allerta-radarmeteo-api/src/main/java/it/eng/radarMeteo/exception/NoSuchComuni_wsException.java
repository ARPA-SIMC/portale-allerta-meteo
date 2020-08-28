/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package it.eng.radarMeteo.exception;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Francesco
 */
@ProviderType
public class NoSuchComuni_wsException extends NoSuchModelException {

	public NoSuchComuni_wsException() {
	}

	public NoSuchComuni_wsException(String msg) {
		super(msg);
	}

	public NoSuchComuni_wsException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchComuni_wsException(Throwable cause) {
		super(cause);
	}

}