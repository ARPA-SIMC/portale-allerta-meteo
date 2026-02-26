/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.previsioni.meteo.service.impl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import it.eng.previsioni.meteo.exception.NoSuchImgException;
import it.eng.previsioni.meteo.model.Img;
import it.eng.previsioni.meteo.service.base.ImgLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=it.eng.previsioni.meteo.model.Img",
	service = AopService.class
)
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