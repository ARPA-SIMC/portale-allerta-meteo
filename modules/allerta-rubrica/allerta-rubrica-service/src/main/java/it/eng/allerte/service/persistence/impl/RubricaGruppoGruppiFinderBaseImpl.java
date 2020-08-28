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

import it.eng.allerte.model.RubricaGruppoGruppi;
import it.eng.allerte.service.persistence.RubricaGruppoGruppiPersistence;

/**
 * @author Pratola_L
 * @generated
 */
public class RubricaGruppoGruppiFinderBaseImpl
	extends BasePersistenceImpl<RubricaGruppoGruppi> {

	public RubricaGruppoGruppiFinderBaseImpl() {
		setModelClass(RubricaGruppoGruppi.class);
	}

	/**
	 * Returns the rubrica gruppo gruppi persistence.
	 *
	 * @return the rubrica gruppo gruppi persistence
	 */
	public RubricaGruppoGruppiPersistence getRubricaGruppoGruppiPersistence() {
		return rubricaGruppoGruppiPersistence;
	}

	/**
	 * Sets the rubrica gruppo gruppi persistence.
	 *
	 * @param rubricaGruppoGruppiPersistence the rubrica gruppo gruppi persistence
	 */
	public void setRubricaGruppoGruppiPersistence(
		RubricaGruppoGruppiPersistence rubricaGruppoGruppiPersistence) {

		this.rubricaGruppoGruppiPersistence = rubricaGruppoGruppiPersistence;
	}

	@BeanReference(type = RubricaGruppoGruppiPersistence.class)
	protected RubricaGruppoGruppiPersistence rubricaGruppoGruppiPersistence;

}