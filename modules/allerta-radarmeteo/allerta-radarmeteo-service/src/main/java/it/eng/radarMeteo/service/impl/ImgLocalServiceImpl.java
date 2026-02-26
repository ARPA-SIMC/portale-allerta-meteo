/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.radarMeteo.service.impl;

import com.liferay.portal.aop.AopService;

import it.eng.radarMeteo.service.base.ImgLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Francesco
 */
@Component(
	property = "model.class.name=it.eng.radarMeteo.model.Img",
	service = AopService.class
)
public class ImgLocalServiceImpl extends ImgLocalServiceBaseImpl {
}