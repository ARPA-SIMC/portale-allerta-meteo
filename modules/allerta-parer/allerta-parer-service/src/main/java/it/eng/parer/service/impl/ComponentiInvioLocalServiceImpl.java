/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.service.impl;

import com.liferay.portal.aop.AopService;

import it.eng.parer.model.ComponentiInvio;
import it.eng.parer.service.base.ComponentiInvioLocalServiceBaseImpl;
import it.eng.parer.service.persistence.ComponentiInvioPK;

import org.osgi.service.component.annotations.Component;

/**
 * @author Pratola_L
 */
@Component(
	property = "model.class.name=it.eng.parer.model.ComponentiInvio",
	service = AopService.class
)
public class ComponentiInvioLocalServiceImpl
	extends ComponentiInvioLocalServiceBaseImpl {
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.parer.service.ComponentiInvioLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.parer.service.ComponentiInvioLocalServiceUtil</code>.
	 */
	
	public ComponentiInvio getNuovoComponenteInvio() {
		return createComponentiInvio(new ComponentiInvioPK());
	}
}