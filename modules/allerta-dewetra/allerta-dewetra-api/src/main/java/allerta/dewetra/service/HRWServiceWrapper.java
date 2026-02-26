/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.dewetra.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link HRWService}.
 *
 * @author Brian Wing Shun Chan
 * @see HRWService
 * @generated
 */
public class HRWServiceWrapper
	implements HRWService, ServiceWrapper<HRWService> {

	public HRWServiceWrapper() {
		this(null);
	}

	public HRWServiceWrapper(HRWService hrwService) {
		_hrwService = hrwService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _hrwService.getOSGiServiceIdentifier();
	}

	@Override
	public HRWService getWrappedService() {
		return _hrwService;
	}

	@Override
	public void setWrappedService(HRWService hrwService) {
		_hrwService = hrwService;
	}

	private HRWService _hrwService;

}