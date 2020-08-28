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

package it.eng.animazione.image.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Parametro service. Represents a row in the &quot;img_animazioni_Parametro&quot; database table, with each column mapped to a property of this class.
 *
 * @author UTENTE
 * @see ParametroModel
 * @generated
 */
@ImplementationClassName("it.eng.animazione.image.model.impl.ParametroImpl")
@ProviderType
public interface Parametro extends ParametroModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.animazione.image.model.impl.ParametroImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Parametro, String> KEY_ACCESSOR =
		new Accessor<Parametro, String>() {

			@Override
			public String get(Parametro parametro) {
				return parametro.getKey();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<Parametro> getTypeClass() {
				return Parametro.class;
			}

		};

}