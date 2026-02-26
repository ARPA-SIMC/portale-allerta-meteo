/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.radarMeteo.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link Comuni_wsService}.
 *
 * @author Francesco
 * @see Comuni_wsService
 * @generated
 */
public class Comuni_wsServiceWrapper
	implements Comuni_wsService, ServiceWrapper<Comuni_wsService> {

	public Comuni_wsServiceWrapper() {
		this(null);
	}

	public Comuni_wsServiceWrapper(Comuni_wsService comuni_wsService) {
		_comuni_wsService = comuni_wsService;
	}

	@Override
	public java.util.ArrayList<java.util.HashMap<String, String>>
		getMeteomont() {

		return _comuni_wsService.getMeteomont();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _comuni_wsService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.Map<String, Object> getStatoAllerta() {
		return _comuni_wsService.getStatoAllerta();
	}

	@Override
	public java.util.Map<String, Object> getStatoAllerta(
		java.sql.Timestamp timestamp) {

		return _comuni_wsService.getStatoAllerta(timestamp);
	}

	@Override
	public java.util.List<Object[]> getStatoAllertaCap(
		java.sql.Timestamp timestamp) {

		return _comuni_wsService.getStatoAllertaCap(timestamp);
	}

	@Override
	public Comuni_wsService getWrappedService() {
		return _comuni_wsService;
	}

	@Override
	public void setWrappedService(Comuni_wsService comuni_wsService) {
		_comuni_wsService = comuni_wsService;
	}

	private Comuni_wsService _comuni_wsService;

}