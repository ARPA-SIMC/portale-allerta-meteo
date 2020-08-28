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

import it.eng.allerte.model.RubricaGruppo;
import it.eng.allerte.service.persistence.RubricaGruppoPersistence;

/**
 * @author Pratola_L
 * @generated
 */
public class RubricaGruppoFinderBaseImpl
	extends BasePersistenceImpl<RubricaGruppo> {

	public RubricaGruppoFinderBaseImpl() {
		setModelClass(RubricaGruppo.class);
	}

	/**
	 * Returns the rubrica gruppo persistence.
	 *
	 * @return the rubrica gruppo persistence
	 */
	public RubricaGruppoPersistence getRubricaGruppoPersistence() {
		return rubricaGruppoPersistence;
	}

	/**
	 * Sets the rubrica gruppo persistence.
	 *
	 * @param rubricaGruppoPersistence the rubrica gruppo persistence
	 */
	public void setRubricaGruppoPersistence(
		RubricaGruppoPersistence rubricaGruppoPersistence) {

		this.rubricaGruppoPersistence = rubricaGruppoPersistence;
	}

	@BeanReference(type = RubricaGruppoPersistence.class)
	protected RubricaGruppoPersistence rubricaGruppoPersistence;

}