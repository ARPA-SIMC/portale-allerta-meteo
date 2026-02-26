/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.service.impl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.eng.parer.model.DocumentiCollegati;
import it.eng.parer.service.base.DocumentiCollegatiServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

/**
 * @author Pratola_L
 */
@Component(
	property = {
		"json.web.service.context.name=parer",
		"json.web.service.context.path=DocumentiCollegati"
	},
	service = AopService.class
)
public class DocumentiCollegatiServiceImpl
	extends DocumentiCollegatiServiceBaseImpl {
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>it.eng.parer.service.DocumentiCollegatiServiceUtil</code> to access the documenti collegati remote service.
	 */
	

	private Log logger = LogFactoryUtil.getLog(DocumentiCollegatiServiceImpl.class);
	
	public List<DocumentiCollegati> listaDocumentiCollegatiByEsitoInvio(Long idInvio){
		List<DocumentiCollegati> findByesitoInvio = null;
		try {
			findByesitoInvio = documentiCollegatiPersistence.findByDocumentiCollegatiByIdInvio(idInvio);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		return findByesitoInvio;
	}
}