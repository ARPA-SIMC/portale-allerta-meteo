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

package it.eng.allerter.service.persistence.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import it.eng.allerter.model.AllertaValanghe;
import it.eng.allerter.service.persistence.AllertaValanghePersistence;

import java.lang.reflect.Field;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author GFAVINI
 * @generated
 */
public class AllertaValangheFinderBaseImpl
	extends BasePersistenceImpl<AllertaValanghe> {

	public AllertaValangheFinderBaseImpl() {
		setModelClass(AllertaValanghe.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

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
		return getAllertaValanghePersistence().getBadColumnNames();
	}

	/**
	 * Returns the allerta valanghe persistence.
	 *
	 * @return the allerta valanghe persistence
	 */
	public AllertaValanghePersistence getAllertaValanghePersistence() {
		return allertaValanghePersistence;
	}

	/**
	 * Sets the allerta valanghe persistence.
	 *
	 * @param allertaValanghePersistence the allerta valanghe persistence
	 */
	public void setAllertaValanghePersistence(
		AllertaValanghePersistence allertaValanghePersistence) {

		this.allertaValanghePersistence = allertaValanghePersistence;
	}

	@BeanReference(type = AllertaValanghePersistence.class)
	protected AllertaValanghePersistence allertaValanghePersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		AllertaValangheFinderBaseImpl.class);

}