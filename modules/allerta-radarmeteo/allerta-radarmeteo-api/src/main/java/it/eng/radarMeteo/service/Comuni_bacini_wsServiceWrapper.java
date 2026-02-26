/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.radarMeteo.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link Comuni_bacini_wsService}.
 *
 * @author Francesco
 * @see Comuni_bacini_wsService
 * @generated
 */
public class Comuni_bacini_wsServiceWrapper
	implements Comuni_bacini_wsService,
			   ServiceWrapper<Comuni_bacini_wsService> {

	public Comuni_bacini_wsServiceWrapper() {
		this(null);
	}

	public Comuni_bacini_wsServiceWrapper(
		Comuni_bacini_wsService comuni_bacini_wsService) {

		_comuni_bacini_wsService = comuni_bacini_wsService;
	}

	@Override
	public java.util.Map<String, Object> getBollettinoMonitoraggio() {
		return _comuni_bacini_wsService.getBollettinoMonitoraggio();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _comuni_bacini_wsService.getOSGiServiceIdentifier();
	}

	@Override
	public Comuni_bacini_wsService getWrappedService() {
		return _comuni_bacini_wsService;
	}

	@Override
	public void setWrappedService(
		Comuni_bacini_wsService comuni_bacini_wsService) {

		_comuni_bacini_wsService = comuni_bacini_wsService;
	}

	private Comuni_bacini_wsService _comuni_bacini_wsService;

}