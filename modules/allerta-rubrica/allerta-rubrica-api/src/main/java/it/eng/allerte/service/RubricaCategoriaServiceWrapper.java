/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RubricaCategoriaService}.
 *
 * @author Pratola_L
 * @see RubricaCategoriaService
 * @generated
 */
public class RubricaCategoriaServiceWrapper
	implements RubricaCategoriaService,
			   ServiceWrapper<RubricaCategoriaService> {

	public RubricaCategoriaServiceWrapper() {
		this(null);
	}

	public RubricaCategoriaServiceWrapper(
		RubricaCategoriaService rubricaCategoriaService) {

		_rubricaCategoriaService = rubricaCategoriaService;
	}

	@Override
	public java.util.Map<String, Object> getCategorie() {
		return _rubricaCategoriaService.getCategorie();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rubricaCategoriaService.getOSGiServiceIdentifier();
	}

	@Override
	public RubricaCategoriaService getWrappedService() {
		return _rubricaCategoriaService;
	}

	@Override
	public void setWrappedService(
		RubricaCategoriaService rubricaCategoriaService) {

		_rubricaCategoriaService = rubricaCategoriaService;
	}

	private RubricaCategoriaService _rubricaCategoriaService;

}