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

package it.eng.allerte.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RubricaRuoloRubricaService}.
 *
 * @author Pratola_L
 * @see RubricaRuoloRubricaService
 * @generated
 */
@ProviderType
public class RubricaRuoloRubricaServiceWrapper
	implements RubricaRuoloRubricaService,
			   ServiceWrapper<RubricaRuoloRubricaService> {

	public RubricaRuoloRubricaServiceWrapper(
		RubricaRuoloRubricaService rubricaRuoloRubricaService) {

		_rubricaRuoloRubricaService = rubricaRuoloRubricaService;
	}

	@Override
	public java.util.Map<String, Object> getAddressBookRoles() {
		return _rubricaRuoloRubricaService.getAddressBookRoles();
	}

	@Override
	public Long getCurrentSite() {
		return _rubricaRuoloRubricaService.getCurrentSite();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rubricaRuoloRubricaService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.Map<Long, String> getSites() {
		return _rubricaRuoloRubricaService.getSites();
	}

	@Override
	public void updateSite(Long sito) {
		_rubricaRuoloRubricaService.updateSite(sito);
	}

	@Override
	public RubricaRuoloRubricaService getWrappedService() {
		return _rubricaRuoloRubricaService;
	}

	@Override
	public void setWrappedService(
		RubricaRuoloRubricaService rubricaRuoloRubricaService) {

		_rubricaRuoloRubricaService = rubricaRuoloRubricaService;
	}

	private RubricaRuoloRubricaService _rubricaRuoloRubricaService;

}