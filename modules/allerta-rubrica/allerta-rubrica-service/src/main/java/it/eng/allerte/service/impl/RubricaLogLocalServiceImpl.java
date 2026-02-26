/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service.impl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import it.eng.allerte.service.base.RubricaLogLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Pratola_L
 */
@Component(
	property = "model.class.name=it.eng.allerte.model.RubricaLog",
	service = AopService.class
)
public class RubricaLogLocalServiceImpl extends RubricaLogLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.allerte.service.RubricaLogLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.allerte.service.RubricaLogLocalServiceUtil</code>.
	 */
	
	public List<Object[]> getLogByNameTable(String tableName,Long ownerId,Long limit,Long offset) {
		return rubricaLogFinder.getLogByNameTable(tableName, ownerId, limit, offset);
	}
}