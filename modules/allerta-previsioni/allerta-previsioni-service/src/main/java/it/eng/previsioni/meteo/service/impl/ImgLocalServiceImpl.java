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

package it.eng.previsioni.meteo.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import it.eng.previsioni.meteo.exception.NoSuchImgException;
import it.eng.previsioni.meteo.model.Img;
import it.eng.previsioni.meteo.service.base.ImgLocalServiceBaseImpl;

/**
 * The implementation of the img local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>it.eng.previsioni.meteo.service.ImgLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImgLocalServiceBaseImpl
 */
public class ImgLocalServiceImpl extends ImgLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>it.eng.previsioni.meteo.service.ImgLocalService</code> via injection or
	 * a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>it.eng.previsioni.meteo.service.ImgLocalServiceUtil</code>.
	 */

	public List<Img> findByDay(String day) throws SystemException {
		return imgPersistence.findByday(day);

	}

	public List<Img> getByDayProvincia(String day, String provincia) throws SystemException {
		return imgPersistence.findByDay_Province(day, provincia);

	}

	public Img getByPartDayProvincia(String part, String day, String provincia)
			throws SystemException, NoSuchImgException {
		return imgPersistence.findByPart_Day_Province(part, day, provincia);
	}
}