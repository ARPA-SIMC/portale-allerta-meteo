/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animaeteo.service.impl;

import com.liferay.portal.aop.AopService;

import it.eng.animaeteo.service.base.AnimeteoSmallImgServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author UTENTE
 */
@Component(
	property = {
		"json.web.service.context.name=animeteo",
		"json.web.service.context.path=AnimeteoSmallImg"
	},
	service = AopService.class
)
public class AnimeteoSmallImgServiceImpl
	extends AnimeteoSmallImgServiceBaseImpl {
}