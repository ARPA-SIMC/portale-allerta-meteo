/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service.impl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import it.eng.allerter.model.AllertaValangheStato;
import it.eng.allerter.service.base.AllertaValangheStatoLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author GFAVINI
 */
@Component(
	property = "model.class.name=it.eng.allerter.model.AllertaValangheStato",
	service = AopService.class
)
public class AllertaValangheStatoLocalServiceImpl
	extends AllertaValangheStatoLocalServiceBaseImpl {
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.allerter.service.AllertaValangheStatoLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.allerter.service.AllertaValangheStatoLocalServiceUtil</code>.
	 */
	
	public List<AllertaValangheStato> getAllertaValangheStatoByAllertaValanghe(long allertaValangheId) {
		return allertaValangheStatoPersistence.findByAllertaValangheId(allertaValangheId);
	}
}