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
 * Provides a wrapper for {@link RubricaGruppoService}.
 *
 * @author Pratola_L
 * @see RubricaGruppoService
 * @generated
 */
@ProviderType
public class RubricaGruppoServiceWrapper
	implements RubricaGruppoService, ServiceWrapper<RubricaGruppoService> {

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
		String name, int limit, int offset) {

		return _rubricaGruppoService.getGroups(name, limit, offset);
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