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
 * The extended model interface for the RubricaRuolo service. Represents a row in the &quot;rubrica_RubricaRuolo&quot; database table, with each column mapped to a property of this class.
 *
 * @author Pratola_L
 * @see RubricaRuoloModel
 * @generated
 */
@ImplementationClassName("it.eng.allerte.model.impl.RubricaRuoloImpl")
@ProviderType
public interface RubricaRuolo extends PersistedModel, RubricaRuoloModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.allerte.model.impl.RubricaRuoloImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<RubricaRuolo, Long> ID_RUOLO_ACCESSOR =
		new Accessor<RubricaRuolo, Long>() {

			@Override
			public Long get(RubricaRuolo rubricaRuolo) {
				return rubricaRuolo.getID_RUOLO();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<RubricaRuolo> getTypeClass() {
				return RubricaRuolo.class;
			}

		};

}