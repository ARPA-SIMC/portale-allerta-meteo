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
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the RubricaPermessi service. Represents a row in the &quot;rubrica_RubricaPermessi&quot; database table, with each column mapped to a property of this class.
 *
 * @author Pratola_L
 * @see RubricaPermessiModel
 * @generated
 */
@ImplementationClassName("it.eng.allerte.model.impl.RubricaPermessiImpl")
@ProviderType
public interface RubricaPermessi extends RubricaPermessiModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.allerte.model.impl.RubricaPermessiImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<RubricaPermessi, String> ID_PERMESSO_ACCESSOR =
		new Accessor<RubricaPermessi, String>() {

			@Override
			public String get(RubricaPermessi rubricaPermessi) {
				return rubricaPermessi.getID_PERMESSO();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<RubricaPermessi> getTypeClass() {
				return RubricaPermessi.class;
			}

		};

}