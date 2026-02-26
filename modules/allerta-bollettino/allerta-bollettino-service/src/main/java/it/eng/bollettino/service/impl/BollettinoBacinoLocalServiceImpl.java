/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service.impl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import it.eng.bollettino.model.BollettinoBacino;
import it.eng.bollettino.service.base.BollettinoBacinoLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author GFAVINI
 */
@Component(
	property = "model.class.name=it.eng.bollettino.model.BollettinoBacino",
	service = AopService.class
)
public class BollettinoBacinoLocalServiceImpl
	extends BollettinoBacinoLocalServiceBaseImpl {
	
	public List<BollettinoBacino> getBaciniByBollettino(long bollettinoId) {
		return bollettinoBacinoPersistence.findByBollettino(bollettinoId);
	}
}