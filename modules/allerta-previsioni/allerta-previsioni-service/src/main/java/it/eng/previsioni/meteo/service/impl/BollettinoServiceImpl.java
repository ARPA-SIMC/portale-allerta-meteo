/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.previsioni.meteo.service.impl;

import com.liferay.portal.aop.AopService;

import it.eng.previsioni.meteo.service.base.BollettinoServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=prev_meteo",
		"json.web.service.context.path=Bollettino"
	},
	service = AopService.class
)
public class BollettinoServiceImpl extends BollettinoServiceBaseImpl {
}