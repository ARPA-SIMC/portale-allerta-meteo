/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.radarMeteo.service.impl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.eng.radarMeteo.model.Comuni_bacini_ws;
import it.eng.radarMeteo.service.base.Comuni_bacini_wsLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Francesco
 */
@Component(
	property = "model.class.name=it.eng.radarMeteo.model.Comuni_bacini_ws",
	service = AopService.class
)
public class Comuni_bacini_wsLocalServiceImpl
	extends Comuni_bacini_wsLocalServiceBaseImpl {
	
	private final Log _log = LogFactoryUtil.getLog(Comuni_bacini_wsLocalServiceImpl.class);
	
	public List<Comuni_bacini_ws> findByBacino(String bacino){
		try {
			return comuni_bacini_wsPersistence.findByBacino(bacino);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			_log.error(e);
		}
		return null;
	}
}