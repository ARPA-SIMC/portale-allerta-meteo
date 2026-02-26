/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.radarMeteo.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link JsonService}.
 *
 * @author Francesco
 * @see JsonService
 * @generated
 */
public class JsonServiceWrapper
	implements JsonService, ServiceWrapper<JsonService> {

	public JsonServiceWrapper() {
		this(null);
	}

	public JsonServiceWrapper(JsonService jsonService) {
		_jsonService = jsonService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _jsonService.getOSGiServiceIdentifier();
	}

	@Override
	public JsonService getWrappedService() {
		return _jsonService;
	}

	@Override
	public void setWrappedService(JsonService jsonService) {
		_jsonService = jsonService;
	}

	private JsonService _jsonService;

}