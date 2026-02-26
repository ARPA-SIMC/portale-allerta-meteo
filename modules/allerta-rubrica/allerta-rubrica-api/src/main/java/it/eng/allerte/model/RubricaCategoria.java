/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the RubricaCategoria service. Represents a row in the &quot;rubrica_RubricaCategoria&quot; database table, with each column mapped to a property of this class.
 *
 * @author Pratola_L
 * @see RubricaCategoriaModel
 * @generated
 */
@ImplementationClassName("it.eng.allerte.model.impl.RubricaCategoriaImpl")
@ProviderType
public interface RubricaCategoria
	extends PersistedModel, RubricaCategoriaModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.allerte.model.impl.RubricaCategoriaImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<RubricaCategoria, Long> ID_CATEGORIA_ACCESSOR =
		new Accessor<RubricaCategoria, Long>() {

			@Override
			public Long get(RubricaCategoria rubricaCategoria) {
				return rubricaCategoria.getID_CATEGORIA();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<RubricaCategoria> getTypeClass() {
				return RubricaCategoria.class;
			}

		};

}