/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.verifica.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UtenteLavoroService}.
 *
 * @author Brian Wing Shun Chan
 * @see UtenteLavoroService
 * @generated
 */
public class UtenteLavoroServiceWrapper
	implements ServiceWrapper<UtenteLavoroService>, UtenteLavoroService {

	public UtenteLavoroServiceWrapper() {
		this(null);
	}

	public UtenteLavoroServiceWrapper(UtenteLavoroService utenteLavoroService) {
		_utenteLavoroService = utenteLavoroService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _utenteLavoroService.getOSGiServiceIdentifier();
	}

	@Override
	public UtenteLavoroService getWrappedService() {
		return _utenteLavoroService;
	}

	@Override
	public void setWrappedService(UtenteLavoroService utenteLavoroService) {
		_utenteLavoroService = utenteLavoroService;
	}

	private UtenteLavoroService _utenteLavoroService;

}