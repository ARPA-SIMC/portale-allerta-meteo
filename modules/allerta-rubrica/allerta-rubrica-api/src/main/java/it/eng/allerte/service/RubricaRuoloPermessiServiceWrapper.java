/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RubricaRuoloPermessiService}.
 *
 * @author Pratola_L
 * @see RubricaRuoloPermessiService
 * @generated
 */
public class RubricaRuoloPermessiServiceWrapper
	implements RubricaRuoloPermessiService,
			   ServiceWrapper<RubricaRuoloPermessiService> {

	public RubricaRuoloPermessiServiceWrapper() {
		this(null);
	}

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