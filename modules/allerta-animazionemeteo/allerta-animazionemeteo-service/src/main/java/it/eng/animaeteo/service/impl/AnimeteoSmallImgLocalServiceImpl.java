/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animaeteo.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

import it.eng.animaeteo.model.AnimeteoSmallImg;
import it.eng.animaeteo.service.base.AnimeteoSmallImgLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author UTENTE
 */
@Component(
	property = "model.class.name=it.eng.animaeteo.model.AnimeteoSmallImg",
	service = AopService.class
)
public class AnimeteoSmallImgLocalServiceImpl
	extends AnimeteoSmallImgLocalServiceBaseImpl {
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.animaeteo.service.AnimeteoSmallImgLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.animaeteo.service.AnimeteoSmallImgLocalServiceUtil</code>.
	 */
	
	public  List<AnimeteoSmallImg> findByType(String type) throws SystemException{
		return animeteoSmallImgPersistence.findByImageData(type);
	}
}