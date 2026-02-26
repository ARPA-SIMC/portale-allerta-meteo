/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EffettiSubService}.
 *
 * @author Brian Wing Shun Chan
 * @see EffettiSubService
 * @generated
 */
public class EffettiSubServiceWrapper
	implements EffettiSubService, ServiceWrapper<EffettiSubService> {

	public EffettiSubServiceWrapper() {
		this(null);
	}

	public EffettiSubServiceWrapper(EffettiSubService effettiSubService) {
		_effettiSubService = effettiSubService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _effettiSubService.getOSGiServiceIdentifier();
	}

	@Override
	public EffettiSubService getWrappedService() {
		return _effettiSubService;
	}

	@Override
	public void setWrappedService(EffettiSubService effettiSubService) {
		_effettiSubService = effettiSubService;
	}

	private EffettiSubService _effettiSubService;

}