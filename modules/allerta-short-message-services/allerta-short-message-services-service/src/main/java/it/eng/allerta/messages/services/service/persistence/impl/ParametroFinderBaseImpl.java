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

package it.eng.allerta.messages.services.service.persistence.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import it.eng.allerta.messages.services.model.Parametro;
import it.eng.allerta.messages.services.service.persistence.ParametroPersistence;

import java.lang.reflect.Field;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Giorgianni_F
 * @generated
 */
public class ParametroFinderBaseImpl extends BasePersistenceImpl<Parametro> {

	public ParametroFinderBaseImpl() {
		setModelClass(Parametro.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("password", "password_");

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
		return getParametroPersistence().getBadColumnNames();
	}

	/**
	 * Returns the parametro persistence.
	 *
	 * @return the parametro persistence
	 */
	public ParametroPersistence getParametroPersistence() {
		return parametroPersistence;
	}

	/**
	 * Sets the parametro persistence.
	 *
	 * @param parametroPersistence the parametro persistence
	 */
	public void setParametroPersistence(
		ParametroPersistence parametroPersistence) {

		this.parametroPersistence = parametroPersistence;
	}

	@BeanReference(type = ParametroPersistence.class)
	protected ParametroPersistence parametroPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		ParametroFinderBaseImpl.class);

}