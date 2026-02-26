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