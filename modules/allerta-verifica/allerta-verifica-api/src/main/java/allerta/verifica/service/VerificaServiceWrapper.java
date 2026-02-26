/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.verifica.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VerificaService}.
 *
 * @author Brian Wing Shun Chan
 * @see VerificaService
 * @generated
 */
public class VerificaServiceWrapper
	implements ServiceWrapper<VerificaService>, VerificaService {

	public VerificaServiceWrapper() {
		this(null);
	}

	public VerificaServiceWrapper(VerificaService verificaService) {
		_verificaService = verificaService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _verificaService.getOSGiServiceIdentifier();
	}

	@Override
	public VerificaService getWrappedService() {
		return _verificaService;
	}

	@Override
	public void setWrappedService(VerificaService verificaService) {
		_verificaService = verificaService;
	}

	private VerificaService _verificaService;

}