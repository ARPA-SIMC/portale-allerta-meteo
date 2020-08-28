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

import it.eng.allerter.model.SMS;
import it.eng.allerter.service.persistence.SMSPersistence;

import java.lang.reflect.Field;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author GFAVINI
 * @generated
 */
public class SMSFinderBaseImpl extends BasePersistenceImpl<SMS> {

	public SMSFinderBaseImpl() {
		setModelClass(SMS.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

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
		return getSMSPersistence().getBadColumnNames();
	}

	/**
	 * Returns the sms persistence.
	 *
	 * @return the sms persistence
	 */
	public SMSPersistence getSMSPersistence() {
		return smsPersistence;
	}

	/**
	 * Sets the sms persistence.
	 *
	 * @param smsPersistence the sms persistence
	 */
	public void setSMSPersistence(SMSPersistence smsPersistence) {
		this.smsPersistence = smsPersistence;
	}

	@BeanReference(type = SMSPersistence.class)
	protected SMSPersistence smsPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		SMSFinderBaseImpl.class);

}