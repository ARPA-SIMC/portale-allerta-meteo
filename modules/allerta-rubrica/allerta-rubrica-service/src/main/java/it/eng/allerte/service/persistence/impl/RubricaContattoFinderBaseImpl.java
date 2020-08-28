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

import it.eng.allerte.model.RubricaContatto;
import it.eng.allerte.service.persistence.RubricaContattoPersistence;

/**
 * @author Pratola_L
 * @generated
 */
public class RubricaContattoFinderBaseImpl
	extends BasePersistenceImpl<RubricaContatto> {

	public RubricaContattoFinderBaseImpl() {
		setModelClass(RubricaContatto.class);
	}

	/**
	 * Returns the rubrica contatto persistence.
	 *
	 * @return the rubrica contatto persistence
	 */
	public RubricaContattoPersistence getRubricaContattoPersistence() {
		return rubricaContattoPersistence;
	}

	/**
	 * Sets the rubrica contatto persistence.
	 *
	 * @param rubricaContattoPersistence the rubrica contatto persistence
	 */
	public void setRubricaContattoPersistence(
		RubricaContattoPersistence rubricaContattoPersistence) {

		this.rubricaContattoPersistence = rubricaContattoPersistence;
	}

	@BeanReference(type = RubricaContattoPersistence.class)
	protected RubricaContattoPersistence rubricaContattoPersistence;

}