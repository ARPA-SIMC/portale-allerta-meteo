/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.service.impl;

import com.liferay.portal.aop.AopService;

import it.eng.allerta.messages.services.service.base.AuthLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Giorgianni_F
 */
@Component(
	property = "model.class.name=it.eng.allerta.messages.services.model.Auth",
	service = AopService.class
)
public class AuthLocalServiceImpl extends AuthLocalServiceBaseImpl {
}