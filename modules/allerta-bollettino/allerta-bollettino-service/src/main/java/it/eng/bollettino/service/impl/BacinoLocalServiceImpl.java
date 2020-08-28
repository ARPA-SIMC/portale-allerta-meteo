/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.eng.bollettino.service.impl;

import com.liferay.portal.kernel.exception.PortalException;

import it.eng.bollettino.model.Bacino;
import it.eng.bollettino.model.Stazione;
import it.eng.bollettino.service.base.BacinoLocalServiceBaseImpl;

/**
 * The implementation of the bacino local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.bollettino.service.BacinoLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author GFAVINI
 * @see BacinoLocalServiceBaseImpl
 */
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
			Stazione s = stazioneLocalService.getStazione(stazioni[k]);
			if (s != null) {
				s.setIncluso(true);
				stazioneLocalService.updateStazione(s);
			}
		}
		
		return b;

	}

	
}