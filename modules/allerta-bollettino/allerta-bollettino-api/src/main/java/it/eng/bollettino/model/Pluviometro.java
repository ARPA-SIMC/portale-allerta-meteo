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
 * The extended model interface for the Pluviometro service. Represents a row in the &quot;BOLLETTINO_Pluviometro&quot; database table, with each column mapped to a property of this class.
 *
 * @author GFAVINI
 * @see PluviometroModel
 * @generated
 */
@ImplementationClassName("it.eng.bollettino.model.impl.PluviometroImpl")
@ProviderType
public interface Pluviometro extends PersistedModel, PluviometroModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.bollettino.model.impl.PluviometroImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Pluviometro, String> STAZIONE_ID_ACCESSOR =
		new Accessor<Pluviometro, String>() {

			@Override
			public String get(Pluviometro pluviometro) {
				return pluviometro.getStazioneId();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<Pluviometro> getTypeClass() {
				return Pluviometro.class;
			}

		};

}