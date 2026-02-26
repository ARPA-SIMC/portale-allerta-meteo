/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service.impl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import it.eng.allerte.service.base.RubricaNominativoLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Pratola_L
 */
@Component(
	property = "model.class.name=it.eng.allerte.model.RubricaNominativo",
	service = AopService.class
)
public class RubricaNominativoLocalServiceImpl
	extends RubricaNominativoLocalServiceBaseImpl {
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.allerte.service.RubricaNominativoLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.allerte.service.RubricaNominativoLocalServiceUtil</code>.
	 */
	
	public List<Object[]> getNominativiByName(String name, Long limit, Long offset) {
		return rubricaNominativoFinder.getNominativiByName(name, limit, offset);
	}
}