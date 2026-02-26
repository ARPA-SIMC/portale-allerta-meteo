/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AllertaService}.
 *
 * @author GFAVINI
 * @see AllertaService
 * @generated
 */
public class AllertaServiceWrapper
	implements AllertaService, ServiceWrapper<AllertaService> {

	public AllertaServiceWrapper() {
		this(null);
	}

	public AllertaServiceWrapper(AllertaService allertaService) {
		_allertaService = allertaService;
	}

	@Override
	public long getIdApprovatore(long id) {
		return _allertaService.getIdApprovatore(id);
	}

	@Override
	public java.util.Map<String, Object> getInfoAllerta() {
		return _allertaService.getInfoAllerta();
	}

	@Override
	public java.util.Map<String, Object> getInfoAllertaDomani() {
		return _allertaService.getInfoAllertaDomani();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _allertaService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.ArrayList<java.util.Map<String, String>>
		getStatoAllerta() {

		return _allertaService.getStatoAllerta();
	}

	@Override
	public java.util.ArrayList<java.util.Map<String, String>>
		getStatoAllertaDays(int giorni) {

		return _allertaService.getStatoAllertaDays(giorni);
	}

	@Override
	public java.util.ArrayList<java.util.Map<String, String>>
		getStatoAllertaDomani() {

		return _allertaService.getStatoAllertaDomani();
	}

	@Override
	public java.util.Map<String, Object> getStatoAllertaPrimes() {
		return _allertaService.getStatoAllertaPrimes();
	}

	@Override
	public java.util.Map<String, Object> getStatoAllertaPrimesDomani() {
		return _allertaService.getStatoAllertaPrimesDomani();
	}

	@Override
	public AllertaService getWrappedService() {
		return _allertaService;
	}

	@Override
	public void setWrappedService(AllertaService allertaService) {
		_allertaService = allertaService;
	}

	private AllertaService _allertaService;

}