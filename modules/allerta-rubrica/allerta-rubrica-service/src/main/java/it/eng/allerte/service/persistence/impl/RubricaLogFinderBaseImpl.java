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

package it.eng.allerte.service.persistence.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import it.eng.allerte.model.RubricaLog;
import it.eng.allerte.service.persistence.RubricaLogPersistence;

/**
 * @author Pratola_L
 * @generated
 */
public class RubricaLogFinderBaseImpl extends BasePersistenceImpl<RubricaLog> {

	public RubricaLogFinderBaseImpl() {
		setModelClass(RubricaLog.class);
	}

	/**
	 * Returns the rubrica log persistence.
	 *
	 * @return the rubrica log persistence
	 */
	public RubricaLogPersistence getRubricaLogPersistence() {
		return rubricaLogPersistence;
	}

	/**
	 * Sets the rubrica log persistence.
	 *
	 * @param rubricaLogPersistence the rubrica log persistence
	 */
	public void setRubricaLogPersistence(
		RubricaLogPersistence rubricaLogPersistence) {

		this.rubricaLogPersistence = rubricaLogPersistence;
	}

	@BeanReference(type = RubricaLogPersistence.class)
	protected RubricaLogPersistence rubricaLogPersistence;

}