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

import it.eng.parer.model.DatiSpecificiInvio;
import it.eng.parer.service.base.DatiSpecificiInvioServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

/**
 * @author Pratola_L
 */
@Component(
	property = {
		"json.web.service.context.name=parer",
		"json.web.service.context.path=DatiSpecificiInvio"
	},
	service = AopService.class
)
public class DatiSpecificiInvioServiceImpl
	extends DatiSpecificiInvioServiceBaseImpl {
	

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>it.eng.parer.service.DatiSpecificiInvioServiceUtil</code> to access the dati specifici invio remote service.
	 */
	private Log logger = LogFactoryUtil.getLog(DatiSpecificiInvioServiceImpl.class);
	
	public List<DatiSpecificiInvio> listaDatiSpecificiByEsitoInvio(String esitoInvio){
		List<DatiSpecificiInvio> findByesitoInvio = null;
		try {
			findByesitoInvio = datiSpecificiInvioPersistence.findByesitoInvio(esitoInvio);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		return findByesitoInvio;
	}
}