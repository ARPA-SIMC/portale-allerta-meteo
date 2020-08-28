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

package it.eng.bollettino.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Variabile service. Represents a row in the &quot;BOLLETTINO_Variabile&quot; database table, with each column mapped to a property of this class.
 *
 * @author GFAVINI
 * @see VariabileModel
 * @generated
 */
@ImplementationClassName("it.eng.bollettino.model.impl.VariabileImpl")
@ProviderType
public interface Variabile extends PersistedModel, VariabileModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.bollettino.model.impl.VariabileImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Variabile, String> ID_ACCESSOR =
		new Accessor<Variabile, String>() {

			@Override
			public String get(Variabile variabile) {
				return variabile.getId();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<Variabile> getTypeClass() {
				return Variabile.class;
			}

		};

}