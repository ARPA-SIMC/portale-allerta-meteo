/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SottocategoriaService}.
 *
 * @author Brian Wing Shun Chan
 * @see SottocategoriaService
 * @generated
 */
public class SottocategoriaServiceWrapper
	implements ServiceWrapper<SottocategoriaService>, SottocategoriaService {

	public SottocategoriaServiceWrapper() {
		this(null);
	}

	public SottocategoriaServiceWrapper(
		SottocategoriaService sottocategoriaService) {

		_sottocategoriaService = sottocategoriaService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _sottocategoriaService.getOSGiServiceIdentifier();
	}

	@Override
	public SottocategoriaService getWrappedService() {
		return _sottocategoriaService;
	}

	@Override
	public void setWrappedService(SottocategoriaService sottocategoriaService) {
		_sottocategoriaService = sottocategoriaService;
	}

	private SottocategoriaService _sottocategoriaService;

}