/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

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