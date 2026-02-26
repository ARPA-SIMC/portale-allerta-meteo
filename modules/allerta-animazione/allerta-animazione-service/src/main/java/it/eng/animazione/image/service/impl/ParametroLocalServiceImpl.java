/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animazione.image.service.impl;

import com.liferay.portal.aop.AopService;

import it.eng.animazione.image.service.base.ParametroLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author UTENTE
 */
@Component(
	property = "model.class.name=it.eng.animazione.image.model.Parametro",
	service = AopService.class
)
public class ParametroLocalServiceImpl extends ParametroLocalServiceBaseImpl {
}