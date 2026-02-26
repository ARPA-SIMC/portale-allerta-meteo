/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.verifica.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VerificaDatoService}.
 *
 * @author Brian Wing Shun Chan
 * @see VerificaDatoService
 * @generated
 */
public class VerificaDatoServiceWrapper
	implements ServiceWrapper<VerificaDatoService>, VerificaDatoService {

	public VerificaDatoServiceWrapper() {
		this(null);
	}

	public VerificaDatoServiceWrapper(VerificaDatoService verificaDatoService) {
		_verificaDatoService = verificaDatoService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _verificaDatoService.getOSGiServiceIdentifier();
	}

	@Override
	public VerificaDatoService getWrappedService() {
		return _verificaDatoService;
	}

	@Override
	public void setWrappedService(VerificaDatoService verificaDatoService) {
		_verificaDatoService = verificaDatoService;
	}

	private VerificaDatoService _verificaDatoService;

}