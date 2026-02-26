/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FeedService}.
 *
 * @author GFAVINI
 * @see FeedService
 * @generated
 */
public class FeedServiceWrapper
	implements FeedService, ServiceWrapper<FeedService> {

	public FeedServiceWrapper() {
		this(null);
	}

	public FeedServiceWrapper(FeedService feedService) {
		_feedService = feedService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _feedService.getOSGiServiceIdentifier();
	}

	@Override
	public FeedService getWrappedService() {
		return _feedService;
	}

	@Override
	public void setWrappedService(FeedService feedService) {
		_feedService = feedService;
	}

	private FeedService _feedService;

}