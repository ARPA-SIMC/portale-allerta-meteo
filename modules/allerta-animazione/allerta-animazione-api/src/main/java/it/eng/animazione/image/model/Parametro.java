/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animazione.image.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

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