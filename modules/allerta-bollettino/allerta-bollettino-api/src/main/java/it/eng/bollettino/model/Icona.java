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
 * The extended model interface for the Icona service. Represents a row in the &quot;BOLLETTINO_Icona&quot; database table, with each column mapped to a property of this class.
 *
 * @author GFAVINI
 * @see IconaModel
 * @generated
 */
@ImplementationClassName("it.eng.bollettino.model.impl.IconaImpl")
@ProviderType
public interface Icona extends IconaModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.bollettino.model.impl.IconaImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Icona, Long> ID_ACCESSOR =
		new Accessor<Icona, Long>() {

			@Override
			public Long get(Icona icona) {
				return icona.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Icona> getTypeClass() {
				return Icona.class;
			}

		};

}