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
 * Provides a wrapper for {@link RubricaNominativoService}.
 *
 * @author Pratola_L
 * @see RubricaNominativoService
 * @generated
 */
@ProviderType
public class RubricaNominativoServiceWrapper
	implements RubricaNominativoService,
			   ServiceWrapper<RubricaNominativoService> {

	public RubricaNominativoServiceWrapper(
		RubricaNominativoService rubricaNominativoService) {

		_rubricaNominativoService = rubricaNominativoService;
	}

	@Override
	public java.util.Map<String, Object> addNominativesGroupsMulti(
		Long id, String data) {

		return _rubricaNominativoService.addNominativesGroupsMulti(id, data);
	}

	@Override
	public java.util.Map<String, Object> deleteNominatives(Long id) {
		return _rubricaNominativoService.deleteNominatives(id);
	}

	@Override
	public java.util.Map<String, Object> deleteNominativesGroupsMulti(
		Long id, String data) {

		return _rubricaNominativoService.deleteNominativesGroupsMulti(id, data);
	}

	@Override
	public java.util.Map<String, Object> getNominatives(Long id) {
		return _rubricaNominativoService.getNominatives(id);
	}

	@Override
	public java.util.Map<String, Object> getNominatives(
		String name, int limit, int offset) {

		return _rubricaNominativoService.getNominatives(name, limit, offset);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rubricaNominativoService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.Map<String, Object> importNominatives() {
		return _rubricaNominativoService.importNominatives();
	}

	@Override
	public java.util.Map<String, Object> insertNominatives(String data) {
		return _rubricaNominativoService.insertNominatives(data);
	}

	@Override
	public java.util.Map<String, Object> nominativesMulti(Long id) {
		return _rubricaNominativoService.nominativesMulti(id);
	}

	@Override
	public java.util.Map<String, Object> nominativesMulti(String data) {
		return _rubricaNominativoService.nominativesMulti(data);
	}

	@Override
	public java.util.Map<String, Object> updateNominatives(
		Long id, String data) {

		return _rubricaNominativoService.updateNominatives(id, data);
	}

	@Override
	public RubricaNominativoService getWrappedService() {
		return _rubricaNominativoService;
	}

	@Override
	public void setWrappedService(
		RubricaNominativoService rubricaNominativoService) {

		_rubricaNominativoService = rubricaNominativoService;
	}

	private RubricaNominativoService _rubricaNominativoService;

}