/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service.impl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import it.eng.allerter.model.AllertaStato;
import it.eng.allerter.service.base.AllertaStatoLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author GFAVINI
 */
@Component(
	property = "model.class.name=it.eng.allerter.model.AllertaStato",
	service = AopService.class
)
public class AllertaStatoLocalServiceImpl
	extends AllertaStatoLocalServiceBaseImpl {
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.allerter.service.AllertaStatoLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.allerter.service.AllertaStatoLocalServiceUtil</code>.
	 */
	
	public List<AllertaStato> getAllertaStatoByAllerta(long allertaId) {
		return allertaStatoPersistence.findByAllertaId(allertaId);
	}
}