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

import it.eng.bollettino.model.RegolaAllarmeCondizione;
import it.eng.bollettino.service.RegolaAllarmeCondizioneLocalServiceUtil;
import it.eng.bollettino.service.base.RegolaAllarmeCondizioneLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author GFAVINI
 */
@Component(
	property = "model.class.name=it.eng.bollettino.model.RegolaAllarmeCondizione",
	service = AopService.class
)
public class RegolaAllarmeCondizioneLocalServiceImpl
	extends RegolaAllarmeCondizioneLocalServiceBaseImpl {
	

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.bollettino.service.RegolaAllarmeCondizioneLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.bollettino.service.RegolaAllarmeCondizioneLocalServiceUtil</code>.
	 */
	
	public List<RegolaAllarmeCondizione> getAllarmeCondizione(long idRegola) {
		
		DynamicQuery dyn = 
					DynamicQueryFactoryUtil
						.forClass(RegolaAllarmeCondizione.class, getClassLoader())
						.add(PropertyFactoryUtil.forName("idRegola").eq(idRegola))
						.addOrder(OrderFactoryUtil.asc("id"));
		return RegolaAllarmeCondizioneLocalServiceUtil.dynamicQuery(dyn);
	}
}