/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EffettiService}.
 *
 * @author Brian Wing Shun Chan
 * @see EffettiService
 * @generated
 */
public class EffettiServiceWrapper
	implements EffettiService, ServiceWrapper<EffettiService> {

	public EffettiServiceWrapper() {
		this(null);
	}

	public EffettiServiceWrapper(EffettiService effettiService) {
		_effettiService = effettiService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _effettiService.getOSGiServiceIdentifier();
	}

	@Override
	public EffettiService getWrappedService() {
		return _effettiService;
	}

	@Override
	public void setWrappedService(EffettiService effettiService) {
		_effettiService = effettiService;
	}

	private EffettiService _effettiService;

}