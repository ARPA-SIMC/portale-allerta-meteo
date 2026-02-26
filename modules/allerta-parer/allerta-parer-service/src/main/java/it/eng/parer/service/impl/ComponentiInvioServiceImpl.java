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

import it.eng.parer.model.ComponentiInvio;
import it.eng.parer.service.base.ComponentiInvioServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

/**
 * @author Pratola_L
 */
@Component(
	property = {
		"json.web.service.context.name=parer",
		"json.web.service.context.path=ComponentiInvio"
	},
	service = AopService.class
)
public class ComponentiInvioServiceImpl extends ComponentiInvioServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>it.eng.parer.service.ComponentiInvioServiceUtil</code> to access the componenti invio remote service.
	 */
	
	
	private Log logger = LogFactoryUtil.getLog(ComponentiInvioServiceImpl.class);
	
	
	public List<ComponentiInvio> listaComponentiByIdInvio(Long idInvio){
		List<ComponentiInvio> findByIdInvio = null;
		try {
			findByIdInvio = componentiInvioPersistence.findByComponentiByIdInvio(idInvio);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		return findByIdInvio;
	}

}