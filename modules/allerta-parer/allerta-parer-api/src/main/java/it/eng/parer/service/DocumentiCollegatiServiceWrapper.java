/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DocumentiCollegatiService}.
 *
 * @author Pratola_L
 * @see DocumentiCollegatiService
 * @generated
 */
public class DocumentiCollegatiServiceWrapper
	implements DocumentiCollegatiService,
			   ServiceWrapper<DocumentiCollegatiService> {

	public DocumentiCollegatiServiceWrapper() {
		this(null);
	}

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