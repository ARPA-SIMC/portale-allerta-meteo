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
 * The extended model interface for the RubricaUtenteSito service. Represents a row in the &quot;rubrica_RubricaUtenteSito&quot; database table, with each column mapped to a property of this class.
 *
 * @author Pratola_L
 * @see RubricaUtenteSitoModel
 * @generated
 */
@ImplementationClassName("it.eng.allerte.model.impl.RubricaUtenteSitoImpl")
@ProviderType
public interface RubricaUtenteSito
	extends PersistedModel, RubricaUtenteSitoModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.allerte.model.impl.RubricaUtenteSitoImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<RubricaUtenteSito, Long> ID_UTENTE_ACCESSOR =
		new Accessor<RubricaUtenteSito, Long>() {

			@Override
			public Long get(RubricaUtenteSito rubricaUtenteSito) {
				return rubricaUtenteSito.getID_UTENTE();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<RubricaUtenteSito> getTypeClass() {
				return RubricaUtenteSito.class;
			}

		};

}