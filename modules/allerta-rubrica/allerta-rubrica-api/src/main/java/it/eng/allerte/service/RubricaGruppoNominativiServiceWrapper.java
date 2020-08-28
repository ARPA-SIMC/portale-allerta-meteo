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
 * Provides a wrapper for {@link RubricaGruppoNominativiService}.
 *
 * @author Pratola_L
 * @see RubricaGruppoNominativiService
 * @generated
 */
@ProviderType
public class RubricaGruppoNominativiServiceWrapper
	implements RubricaGruppoNominativiService,
			   ServiceWrapper<RubricaGruppoNominativiService> {

	public RubricaGruppoNominativiServiceWrapper(
		RubricaGruppoNominativiService rubricaGruppoNominativiService) {

		_rubricaGruppoNominativiService = rubricaGruppoNominativiService;
	}

	@Override
	public java.util.Map<String, Object> addGroupNominatives(
		int id, String data) {

		return _rubricaGruppoNominativiService.addGroupNominatives(id, data);
	}

	@Override
	public java.util.Map<String, Object> addGroupNominativesMulti(
		int id, String data) {

		return _rubricaGruppoNominativiService.addGroupNominativesMulti(
			id, data);
	}

	@Override
	public java.util.Map<String, Object> deleteGroupNominatives(
		int id, String data) {

		return _rubricaGruppoNominativiService.deleteGroupNominatives(id, data);
	}

	@Override
	public java.util.Map<String, Object> deleteGroupNominativesMulti(
		int id, String data) {

		return _rubricaGruppoNominativiService.deleteGroupNominativesMulti(
			id, data);
	}

	/**
	 * restituisci i nominvativi associati a un gruppo
	 *
	 * @param ownerId
	 * @param groupId
	 * @return
	 */
	@Override
	public java.util.Set<it.eng.allerte.model.RubricaNominativo>
		getNominativeForGroup(Long ownerId, Long groupId) {

		return _rubricaGruppoNominativiService.getNominativeForGroup(
			ownerId, groupId);
	}

	/**
	 * Il metodo ritorna le info di un nominativo iscrittto al portale per il sito proprietario
	 *
	 * @param ownerId
	 * @return
	 */
	@Override
	public java.util.List<it.eng.allerte.model.RubricaNominativo>
		getNominativeForGroupPortal(Long ownerId) {

		return _rubricaGruppoNominativiService.getNominativeForGroupPortal(
			ownerId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rubricaGruppoNominativiService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.Map<String, Object> nominativeGroupRole(String data) {
		return _rubricaGruppoNominativiService.nominativeGroupRole(data);
	}

	@Override
	public RubricaGruppoNominativiService getWrappedService() {
		return _rubricaGruppoNominativiService;
	}

	@Override
	public void setWrappedService(
		RubricaGruppoNominativiService rubricaGruppoNominativiService) {

		_rubricaGruppoNominativiService = rubricaGruppoNominativiService;
	}

	private RubricaGruppoNominativiService _rubricaGruppoNominativiService;

}