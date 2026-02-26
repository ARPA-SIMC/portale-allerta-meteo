/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.cache.service.impl;

import com.liferay.portal.aop.AopService;

import it.eng.cache.service.base.DatiServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author GFAVINI
 */
@Component(
	property = {
		"json.web.service.context.name=cache",
		"json.web.service.context.path=Dati"
	},
	service = AopService.class
)
public class DatiServiceImpl extends DatiServiceBaseImpl {
}