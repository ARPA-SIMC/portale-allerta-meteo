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

package it.eng.parer.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Parametri service. Represents a row in the &quot;parer_Parametri&quot; database table, with each column mapped to a property of this class.
 *
 * @author Pratola_L
 * @see ParametriModel
 * @generated
 */
@ImplementationClassName("it.eng.parer.model.impl.ParametriImpl")
@ProviderType
public interface Parametri extends ParametriModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.parer.model.impl.ParametriImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Parametri, String> CHIAVE_ACCESSOR =
		new Accessor<Parametri, String>() {

			@Override
			public String get(Parametri parametri) {
				return parametri.getChiave();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<Parametri> getTypeClass() {
				return Parametri.class;
			}

		};

}