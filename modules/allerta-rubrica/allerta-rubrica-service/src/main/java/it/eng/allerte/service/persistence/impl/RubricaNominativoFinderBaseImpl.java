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

import it.eng.allerte.model.RubricaNominativo;
import it.eng.allerte.service.persistence.RubricaNominativoPersistence;

/**
 * @author Pratola_L
 * @generated
 */
public class RubricaNominativoFinderBaseImpl
	extends BasePersistenceImpl<RubricaNominativo> {

	public RubricaNominativoFinderBaseImpl() {
		setModelClass(RubricaNominativo.class);
	}

	/**
	 * Returns the rubrica nominativo persistence.
	 *
	 * @return the rubrica nominativo persistence
	 */
	public RubricaNominativoPersistence getRubricaNominativoPersistence() {
		return rubricaNominativoPersistence;
	}

	/**
	 * Sets the rubrica nominativo persistence.
	 *
	 * @param rubricaNominativoPersistence the rubrica nominativo persistence
	 */
	public void setRubricaNominativoPersistence(
		RubricaNominativoPersistence rubricaNominativoPersistence) {

		this.rubricaNominativoPersistence = rubricaNominativoPersistence;
	}

	@BeanReference(type = RubricaNominativoPersistence.class)
	protected RubricaNominativoPersistence rubricaNominativoPersistence;

}