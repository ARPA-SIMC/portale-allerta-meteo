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

package it.eng.parer.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.eng.parer.model.DocumentiCollegati;
import it.eng.parer.service.base.DocumentiCollegatiServiceBaseImpl;

/**
 * The implementation of the documenti collegati remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.parer.service.DocumentiCollegatiService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Pratola_L
 * @see DocumentiCollegatiServiceBaseImpl
 */
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