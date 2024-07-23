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

package it.eng.cache.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Dati service. Represents a row in the &quot;CACHE_Dati&quot; database table, with each column mapped to a property of this class.
 *
 * @author GFAVINI
 * @see DatiModel
 * @generated
 */
@ImplementationClassName("it.eng.cache.model.impl.DatiImpl")
@ProviderType
public interface Dati extends DatiModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.cache.model.impl.DatiImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Dati, String> ID_DATI_ACCESSOR =
		new Accessor<Dati, String>() {

			@Override
			public String get(Dati dati) {
				return dati.getIdDati();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<Dati> getTypeClass() {
				return Dati.class;
			}

		};

}