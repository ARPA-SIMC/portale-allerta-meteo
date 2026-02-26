/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RubricaGruppoService}.
 *
 * @author Pratola_L
 * @see RubricaGruppoService
 * @generated
 */
public class RubricaGruppoServiceWrapper
	implements RubricaGruppoService, ServiceWrapper<RubricaGruppoService> {

	public RubricaGruppoServiceWrapper() {
		this(null);
	}

	public RubricaGruppoServiceWrapper(
		RubricaGruppoService rubricaGruppoService) {

		_rubricaGruppoService = rubricaGruppoService;
	}

	@Override
	public java.util.Map<String, Object> addGroup(String data) {
		return _rubricaGruppoService.addGroup(data);
	}

	@Override
	public java.util.Map<String, Object> deleteGroups(Long id) {
		return _rubricaGruppoService.deleteGroups(id);
	}

	@Override
	public java.util.Map<String, Object> deleteGroupsMulti(String data) {
		return _rubricaGruppoService.deleteGroupsMulti(data);
	}

	/**
	 * Il metodo restituisce le info sul gruppo a partire dal nome e per il sito proprietario
	 */
	@Override
	public it.eng.allerte.model.RubricaGruppo getGroupForOwnerByName(
		Long ownerId, String groupName) {

		return _rubricaGruppoService.getGroupForOwnerByName(ownerId, groupName);
	}

	@Override
	public java.util.Map<String, Object> getGroups() {
		return _rubricaGruppoService.getGroups();
	}

	@Override
	public java.util.Map<String, Object> getGroups(Long id) {
		return _rubricaGruppoService.getGroups(id);
	}

	@Override
	public java.util.Map<String, Object> getGroups(
		String name, Long categoria, int limit, int offset) {

		return _rubricaGruppoService.getGroups(name, categoria, limit, offset);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rubricaGruppoService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.Map<String, Object> updateGroups(Long id, String data) {
		return _rubricaGruppoService.updateGroups(id, data);
	}

	@Override
	public RubricaGruppoService getWrappedService() {
		return _rubricaGruppoService;
	}

	@Override
	public void setWrappedService(RubricaGruppoService rubricaGruppoService) {
		_rubricaGruppoService = rubricaGruppoService;
	}

	private RubricaGruppoService _rubricaGruppoService;

}