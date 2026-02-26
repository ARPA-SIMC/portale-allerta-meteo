/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.radarMeteo.service.impl;

import com.liferay.portal.aop.AopService;

import it.eng.radarMeteo.service.base.JsonServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Francesco
 */
@Component(
	property = {
		"json.web.service.context.name=rt_portlet",
		"json.web.service.context.path=Json"
	},
	service = AopService.class
)
public class JsonServiceImpl extends JsonServiceBaseImpl {
}