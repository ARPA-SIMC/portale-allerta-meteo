/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RubricaRuoloRubricaService}.
 *
 * @author Pratola_L
 * @see RubricaRuoloRubricaService
 * @generated
 */
public class RubricaRuoloRubricaServiceWrapper
	implements RubricaRuoloRubricaService,
			   ServiceWrapper<RubricaRuoloRubricaService> {

	public RubricaRuoloRubricaServiceWrapper() {
		this(null);
	}

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