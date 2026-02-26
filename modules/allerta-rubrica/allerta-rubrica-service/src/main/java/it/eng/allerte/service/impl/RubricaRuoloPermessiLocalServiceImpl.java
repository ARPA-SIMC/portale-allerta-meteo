/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service.impl;

import com.liferay.portal.aop.AopService;

import it.eng.allerte.service.base.RubricaRuoloPermessiLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Pratola_L
 */
@Component(
	property = "model.class.name=it.eng.allerte.model.RubricaRuoloPermessi",
	service = AopService.class
)
public class RubricaRuoloPermessiLocalServiceImpl
	extends RubricaRuoloPermessiLocalServiceBaseImpl {
}