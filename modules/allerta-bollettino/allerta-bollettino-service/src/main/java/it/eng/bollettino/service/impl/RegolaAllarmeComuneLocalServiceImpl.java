/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service.impl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;

import it.eng.bollettino.model.RegolaAllarmeComune;
import it.eng.bollettino.model.RegolaAllarmeCondizione;
import it.eng.bollettino.service.RegolaAllarmeComuneLocalServiceUtil;
import it.eng.bollettino.service.base.RegolaAllarmeComuneLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

/**
 * @author GFAVINI
 */
@Component(
	property = "model.class.name=it.eng.bollettino.model.RegolaAllarmeComune",
	service = AopService.class
)
public class RegolaAllarmeComuneLocalServiceImpl
	extends RegolaAllarmeComuneLocalServiceBaseImpl {
	

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.bollettino.service.RegolaAllarmeComuneLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.bollettino.service.RegolaAllarmeComuneLocalServiceUtil</code>.
	 */
	
	public List<RegolaAllarmeComune> getAllarmeCondizione(long idRegola) {
		
		DynamicQuery dyn = 
					DynamicQueryFactoryUtil
						.forClass(RegolaAllarmeComune.class, getClassLoader())
						.add(PropertyFactoryUtil.forName("idRegola").eq(idRegola));
		
		return RegolaAllarmeComuneLocalServiceUtil.dynamicQuery(dyn);
	}
	
}