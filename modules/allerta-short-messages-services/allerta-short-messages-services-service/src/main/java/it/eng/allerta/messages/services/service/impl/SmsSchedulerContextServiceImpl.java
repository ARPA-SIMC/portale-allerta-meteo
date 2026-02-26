/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.service.impl;

import com.liferay.portal.aop.AopService;

import it.eng.allerta.messages.services.service.base.SmsSchedulerContextServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Giorgianni_F
 */
@Component(
	property = {
		"json.web.service.context.name=smsservice",
		"json.web.service.context.path=SmsSchedulerContext"
	},
	service = AopService.class
)
public class SmsSchedulerContextServiceImpl
	extends SmsSchedulerContextServiceBaseImpl {
}