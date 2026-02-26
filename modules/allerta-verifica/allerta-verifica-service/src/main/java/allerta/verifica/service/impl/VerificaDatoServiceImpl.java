/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.verifica.service.impl;

import allerta.verifica.service.base.VerificaDatoServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=verifica",
		"json.web.service.context.path=VerificaDato"
	},
	service = AopService.class
)
public class VerificaDatoServiceImpl extends VerificaDatoServiceBaseImpl {
}