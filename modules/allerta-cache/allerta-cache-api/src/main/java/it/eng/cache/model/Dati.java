/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.cache.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

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