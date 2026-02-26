/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service.impl;

import com.liferay.portal.aop.AopService;

import it.eng.allerter.service.base.AllertaParametroServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author GFAVINI
 */
@Component(
	property = {
		"json.web.service.context.name=allerter",
		"json.web.service.context.path=AllertaParametro"
	},
	service = AopService.class
)
public class AllertaParametroServiceImpl
	extends AllertaParametroServiceBaseImpl {
}