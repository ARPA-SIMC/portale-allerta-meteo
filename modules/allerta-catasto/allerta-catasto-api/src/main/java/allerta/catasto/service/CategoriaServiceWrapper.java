/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CategoriaService}.
 *
 * @author Brian Wing Shun Chan
 * @see CategoriaService
 * @generated
 */
public class CategoriaServiceWrapper
	implements CategoriaService, ServiceWrapper<CategoriaService> {

	public CategoriaServiceWrapper() {
		this(null);
	}

	public CategoriaServiceWrapper(CategoriaService categoriaService) {
		_categoriaService = categoriaService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _categoriaService.getOSGiServiceIdentifier();
	}

	@Override
	public CategoriaService getWrappedService() {
		return _categoriaService;
	}

	@Override
	public void setWrappedService(CategoriaService categoriaService) {
		_categoriaService = categoriaService;
	}

	private CategoriaService _categoriaService;

}