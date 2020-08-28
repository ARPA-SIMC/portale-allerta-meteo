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

package it.eng.allerte.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the RubricaContatto service. Represents a row in the &quot;rubrica_RubricaContatto&quot; database table, with each column mapped to a property of this class.
 *
 * @author Pratola_L
 * @see RubricaContattoModel
 * @generated
 */
@ImplementationClassName("it.eng.allerte.model.impl.RubricaContattoImpl")
@ProviderType
public interface RubricaContatto extends PersistedModel, RubricaContattoModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.allerte.model.impl.RubricaContattoImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<RubricaContatto, Long> ID_CONTATTO_ACCESSOR =
		new Accessor<RubricaContatto, Long>() {

			@Override
			public Long get(RubricaContatto rubricaContatto) {
				return rubricaContatto.getID_CONTATTO();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<RubricaContatto> getTypeClass() {
				return RubricaContatto.class;
			}

		};

}