/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.eng.allerter.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AllertaService}.
 *
 * @author GFAVINI
 * @see AllertaService
 * @generated
 */
@ProviderType
public class AllertaServiceWrapper
	implements AllertaService, ServiceWrapper<AllertaService> {

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