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
 * Provides a wrapper for {@link RubricaGruppoGruppiService}.
 *
 * @author Pratola_L
 * @see RubricaGruppoGruppiService
 * @generated
 */
@ProviderType
public class RubricaGruppoGruppiServiceWrapper
	implements RubricaGruppoGruppiService,
			   ServiceWrapper<RubricaGruppoGruppiService> {

	public RubricaGruppoGruppiServiceWrapper(
		RubricaGruppoGruppiService rubricaGruppoGruppiService) {

		_rubricaGruppoGruppiService = rubricaGruppoGruppiService;
	}

	@Override
	public java.util.Map<String, Object> addGroupMultiSubgroups(
		int id, String data) {

		return _rubricaGruppoGruppiService.addGroupMultiSubgroups(id, data);
	}

	@Override
	public java.util.Map<String, Object> addGroupMultiSupergroups(
		int id, String data) {

		return _rubricaGruppoGruppiService.addGroupMultiSupergroups(id, data);
	}

	@Override
	public java.util.Map<String, Object> addGroupSubgroups(
		int id, String data) {

		return _rubricaGruppoGruppiService.addGroupSubgroups(id, data);
	}

	@Override
	public java.util.Map<String, Object> deleteGroupMultiSubgroups(
		int id, String data) {

		return _rubricaGruppoGruppiService.deleteGroupMultiSubgroups(id, data);
	}

	@Override
	public java.util.Map<String, Object> deleteGroupMultiSupergroups(
		int id, String data) {

		return _rubricaGruppoGruppiService.deleteGroupMultiSupergroups(
			id, data);
	}

	@Override
	public java.util.Map<String, Object> deleteGroupSubgroups(
		int id, String data) {

		return _rubricaGruppoGruppiService.deleteGroupSubgroups(id, data);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rubricaGruppoGruppiService.getOSGiServiceIdentifier();
	}

	/**
	 * Il metodo restituisce la lista dei sottogruppi per l'id gruppo passato come parametro
	 *
	 * @param idGroup
	 * @return
	 */
	@Override
	public java.util.List<it.eng.allerte.model.RubricaGruppo> getSubGroups(
		long idGroup) {

		return _rubricaGruppoGruppiService.getSubGroups(idGroup);
	}

	@Override
	public java.util.Map<String, Object> updateGroupSubgroups(
		int id, String data) {

		return _rubricaGruppoGruppiService.updateGroupSubgroups(id, data);
	}

	@Override
	public RubricaGruppoGruppiService getWrappedService() {
		return _rubricaGruppoGruppiService;
	}

	@Override
	public void setWrappedService(
		RubricaGruppoGruppiService rubricaGruppoGruppiService) {

		_rubricaGruppoGruppiService = rubricaGruppoGruppiService;
	}

	private RubricaGruppoGruppiService _rubricaGruppoGruppiService;

}