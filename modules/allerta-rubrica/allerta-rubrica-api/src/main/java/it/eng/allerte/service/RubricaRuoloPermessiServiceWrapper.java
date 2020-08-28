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
 * Provides a wrapper for {@link RubricaRuoloPermessiService}.
 *
 * @author Pratola_L
 * @see RubricaRuoloPermessiService
 * @generated
 */
@ProviderType
public class RubricaRuoloPermessiServiceWrapper
	implements RubricaRuoloPermessiService,
			   ServiceWrapper<RubricaRuoloPermessiService> {

	public RubricaRuoloPermessiServiceWrapper(
		RubricaRuoloPermessiService rubricaRuoloPermessiService) {

		_rubricaRuoloPermessiService = rubricaRuoloPermessiService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rubricaRuoloPermessiService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.Map<String, Object> getRolePermission() {
		return _rubricaRuoloPermessiService.getRolePermission();
	}

	@Override
	public java.util.Map<String, Object> getUserInfo() {
		return _rubricaRuoloPermessiService.getUserInfo();
	}

	@Override
	public java.util.Map<String, Object> insertRolePermission(String data) {
		return _rubricaRuoloPermessiService.insertRolePermission(data);
	}

	@Override
	public java.util.Map<String, Object> updateRolePermission(String data) {
		return _rubricaRuoloPermessiService.updateRolePermission(data);
	}

	@Override
	public RubricaRuoloPermessiService getWrappedService() {
		return _rubricaRuoloPermessiService;
	}

	@Override
	public void setWrappedService(
		RubricaRuoloPermessiService rubricaRuoloPermessiService) {

		_rubricaRuoloPermessiService = rubricaRuoloPermessiService;
	}

	private RubricaRuoloPermessiService _rubricaRuoloPermessiService;

}