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
 * The extended model interface for the Stazione service. Represents a row in the &quot;BOLLETTINO_Stazione&quot; database table, with each column mapped to a property of this class.
 *
 * @author GFAVINI
 * @see StazioneModel
 * @generated
 */
@ImplementationClassName("it.eng.bollettino.model.impl.StazioneImpl")
@ProviderType
public interface Stazione extends PersistedModel, StazioneModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.bollettino.model.impl.StazioneImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Stazione, String> ID_ACCESSOR =
		new Accessor<Stazione, String>() {

			@Override
			public String get(Stazione stazione) {
				return stazione.getId();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<Stazione> getTypeClass() {
				return Stazione.class;
			}

		};

}