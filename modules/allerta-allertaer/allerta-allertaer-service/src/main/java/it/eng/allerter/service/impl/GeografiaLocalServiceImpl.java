/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service.impl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import it.eng.allerter.model.Geografia;
import it.eng.allerter.service.base.GeografiaLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author GFAVINI
 */
@Component(
	property = "model.class.name=it.eng.allerter.model.Geografia",
	service = AopService.class
)
public class GeografiaLocalServiceImpl extends GeografiaLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.allerter.service.GeografiaLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.allerter.service.GeografiaLocalServiceUtil</code>.
	 */
	
	public List<Geografia> findByIdComplessita(String id, String compl) {
		try {
			return geografiaPersistence.findByIdComplessita(id, compl);
		} catch (Exception e) {
			//logInternoLocalService.log("GeografiaLocalServiceImpl", "findByIdComplessita", e, "");
			return null;
		}
	}
	
	public List<Geografia> findByAreaComplessita(String area, String compl) {
		try {
			return geografiaPersistence.findByAreaComplessita(area, compl);
		} catch (Exception e) {
			//logInternoLocalService.log("GeografiaLocalServiceImpl", "findByAreaComplessita", e, "");
			return null;
		}
	}

}