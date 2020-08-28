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

package it.eng.parer.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DocumentiCollegatiService}.
 *
 * @author Pratola_L
 * @see DocumentiCollegatiService
 * @generated
 */
@ProviderType
public class DocumentiCollegatiServiceWrapper
	implements DocumentiCollegatiService,
			   ServiceWrapper<DocumentiCollegatiService> {

	public DocumentiCollegatiServiceWrapper(
		DocumentiCollegatiService documentiCollegatiService) {

		_documentiCollegatiService = documentiCollegatiService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _documentiCollegatiService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<it.eng.parer.model.DocumentiCollegati>
		listaDocumentiCollegatiByEsitoInvio(Long idInvio) {

		return _documentiCollegatiService.listaDocumentiCollegatiByEsitoInvio(
			idInvio);
	}

	@Override
	public DocumentiCollegatiService getWrappedService() {
		return _documentiCollegatiService;
	}

	@Override
	public void setWrappedService(
		DocumentiCollegatiService documentiCollegatiService) {

		_documentiCollegatiService = documentiCollegatiService;
	}

	private DocumentiCollegatiService _documentiCollegatiService;

}