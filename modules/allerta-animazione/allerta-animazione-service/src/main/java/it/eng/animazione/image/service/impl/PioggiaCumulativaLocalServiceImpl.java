/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animazione.image.service.impl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import it.eng.animazione.image.exception.NoSuchPioggiaCumulativaException;
import it.eng.animazione.image.model.PioggiaCumulativa;
import it.eng.animazione.image.service.base.PioggiaCumulativaLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

/**
 * @author UTENTE
 */
@Component(
	property = "model.class.name=it.eng.animazione.image.model.PioggiaCumulativa",
	service = AopService.class
)
public class PioggiaCumulativaLocalServiceImpl
	extends PioggiaCumulativaLocalServiceBaseImpl {
	

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.animazione.image.service.PioggiaCumulativaLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.animazione.image.service.PioggiaCumulativaLocalServiceUtil</code>.
	 */
	
	public PioggiaCumulativa findByID(long id) 
			throws NoSuchPioggiaCumulativaException, SystemException {
		PioggiaCumulativa result = pioggiaCumulativaPersistence.findByPrimaryKey(id);
		return result;
	}
	
	public List<PioggiaCumulativa> findByCumulazione(String cumulazione)
			throws NoSuchPioggiaCumulativaException, SystemException {
		 List<PioggiaCumulativa> result = pioggiaCumulativaPersistence.findByCumulazione(cumulazione);
		return result;
	}
}