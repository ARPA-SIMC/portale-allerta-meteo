/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import it.eng.bollettino.model.Bacino;
import it.eng.bollettino.model.Stazione;
import it.eng.bollettino.service.StazioneLocalServiceUtil;
import it.eng.bollettino.service.base.BacinoLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author GFAVINI
 */
@Component(
	property = "model.class.name=it.eng.bollettino.model.Bacino",
	service = AopService.class
)
public class BacinoLocalServiceImpl extends BacinoLocalServiceBaseImpl {
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.bollettino.service.BacinoLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.bollettino.service.BacinoLocalServiceUtil</code>.
	 */
	

	public Bacino creaBacinoDefault(String id, String nome, int progressivo, 
			String[] stazioni) throws PortalException  {
		
		Bacino b = bacinoLocalService.createBacino(id);
		b.setNome(nome);
		b.setProgressivo(progressivo);
		bacinoLocalService.updateBacino(b);

		for (int k = 0; k < stazioni.length; k++) {
			Stazione s = StazioneLocalServiceUtil.getStazione(stazioni[k]);
			if (s != null) {
				s.setIncluso(true);
				StazioneLocalServiceUtil.updateStazione(s);
			}
		}
		
		return b;

	}
}