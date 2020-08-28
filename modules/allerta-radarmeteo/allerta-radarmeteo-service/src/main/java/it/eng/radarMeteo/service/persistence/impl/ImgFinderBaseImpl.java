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

package it.eng.radarMeteo.service.persistence.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import it.eng.radarMeteo.model.Img;
import it.eng.radarMeteo.service.persistence.ImgPersistence;

import java.lang.reflect.Field;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Francesco
 * @generated
 */
public class ImgFinderBaseImpl extends BasePersistenceImpl<Img> {

	public ImgFinderBaseImpl() {
		setModelClass(Img.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");
		dbColumnNames.put("data", "data_");

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
				"_dbColumnNames");

			field.setAccessible(true);

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	@Override
	public Set<String> getBadColumnNames() {
		return getImgPersistence().getBadColumnNames();
	}

	/**
	 * Returns the img persistence.
	 *
	 * @return the img persistence
	 */
	public ImgPersistence getImgPersistence() {
		return imgPersistence;
	}

	/**
	 * Sets the img persistence.
	 *
	 * @param imgPersistence the img persistence
	 */
	public void setImgPersistence(ImgPersistence imgPersistence) {
		this.imgPersistence = imgPersistence;
	}

	@BeanReference(type = ImgPersistence.class)
	protected ImgPersistence imgPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		ImgFinderBaseImpl.class);

}