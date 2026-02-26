/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StatoAllertamentoService}.
 *
 * @author GFAVINI
 * @see StatoAllertamentoService
 * @generated
 */
public class StatoAllertamentoServiceWrapper
	implements ServiceWrapper<StatoAllertamentoService>,
			   StatoAllertamentoService {

	public StatoAllertamentoServiceWrapper() {
		this(null);
	}

	public StatoAllertamentoServiceWrapper(
		StatoAllertamentoService statoAllertamentoService) {

		_statoAllertamentoService = statoAllertamentoService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _statoAllertamentoService.getOSGiServiceIdentifier();
	}

	@Override
	public StatoAllertamentoService getWrappedService() {
		return _statoAllertamentoService;
	}

	@Override
	public void setWrappedService(
		StatoAllertamentoService statoAllertamentoService) {

		_statoAllertamentoService = statoAllertamentoService;
	}

	private StatoAllertamentoService _statoAllertamentoService;

}