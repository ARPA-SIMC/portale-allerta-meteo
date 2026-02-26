/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.dewetra.service.impl;

import allerta.dewetra.service.base.HRWServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=dewetra",
		"json.web.service.context.path=HRW"
	},
	service = AopService.class
)
public class HRWServiceImpl extends HRWServiceBaseImpl {
}