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
 * Provides a wrapper for {@link RubricaContattoService}.
 *
 * @author Pratola_L
 * @see RubricaContattoService
 * @generated
 */
@ProviderType
public class RubricaContattoServiceWrapper
	implements RubricaContattoService, ServiceWrapper<RubricaContattoService> {

	public RubricaContattoServiceWrapper(
		RubricaContattoService rubricaContattoService) {

		_rubricaContattoService = rubricaContattoService;
	}

	@Override
	public java.util.Map<String, Object> addContacts(String data) {
		return _rubricaContattoService.addContacts(data);
	}

	@Override
	public java.util.Map<String, Object> deleteContacts(Long id, String data) {
		return _rubricaContattoService.deleteContacts(id, data);
	}

	@Override
	public java.util.Map<String, Object> deleteContactsMulti(String data) {
		return _rubricaContattoService.deleteContactsMulti(data);
	}

	/**
	 * ritorna una lista di contatti per l'id nominativo passato come parametro
	 *
	 * @param idNominative
	 * @return
	 */
	@Override
	public java.util.List<it.eng.allerte.model.RubricaContatto>
		getContactByNominative(long idNominative) {

		return _rubricaContattoService.getContactByNominative(idNominative);
	}

	/**
	 * Il metodo ritorna i conatti per un user iscritto al portale
	 *
	 * @param idUserPortal
	 * @return
	 */
	@Override
	public java.util.List<it.eng.allerte.model.RubricaContatto>
		getContactByNominativePortal(long idUserPortal) {

		return _rubricaContattoService.getContactByNominativePortal(
			idUserPortal);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rubricaContattoService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.Map<String, Object> updateContacts(Long id, String data) {
		return _rubricaContattoService.updateContacts(id, data);
	}

	@Override
	public RubricaContattoService getWrappedService() {
		return _rubricaContattoService;
	}

	@Override
	public void setWrappedService(
		RubricaContattoService rubricaContattoService) {

		_rubricaContattoService = rubricaContattoService;
	}

	private RubricaContattoService _rubricaContattoService;

}