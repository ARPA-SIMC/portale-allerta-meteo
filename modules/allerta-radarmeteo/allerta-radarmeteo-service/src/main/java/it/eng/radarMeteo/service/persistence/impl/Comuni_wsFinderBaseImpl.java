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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import it.eng.radarMeteo.model.Comuni_ws;
import it.eng.radarMeteo.service.persistence.Comuni_wsPersistence;

/**
 * @author Francesco
 * @generated
 */
public class Comuni_wsFinderBaseImpl extends BasePersistenceImpl<Comuni_ws> {

	public Comuni_wsFinderBaseImpl() {
		setModelClass(Comuni_ws.class);
	}

	/**
	 * Returns the comuni_ws persistence.
	 *
	 * @return the comuni_ws persistence
	 */
	public Comuni_wsPersistence getComuni_wsPersistence() {
		return comuni_wsPersistence;
	}

	/**
	 * Sets the comuni_ws persistence.
	 *
	 * @param comuni_wsPersistence the comuni_ws persistence
	 */
	public void setComuni_wsPersistence(
		Comuni_wsPersistence comuni_wsPersistence) {

		this.comuni_wsPersistence = comuni_wsPersistence;
	}

	@BeanReference(type = Comuni_wsPersistence.class)
	protected Comuni_wsPersistence comuni_wsPersistence;

}