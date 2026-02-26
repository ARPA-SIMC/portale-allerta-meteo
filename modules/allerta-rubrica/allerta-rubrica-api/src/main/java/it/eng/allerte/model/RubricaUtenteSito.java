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
 * The extended model interface for the RubricaUtenteSito service. Represents a row in the &quot;rubrica_RubricaUtenteSito&quot; database table, with each column mapped to a property of this class.
 *
 * @author Pratola_L
 * @see RubricaUtenteSitoModel
 * @generated
 */
@ImplementationClassName("it.eng.allerte.model.impl.RubricaUtenteSitoImpl")
@ProviderType
public interface RubricaUtenteSito
	extends PersistedModel, RubricaUtenteSitoModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.allerte.model.impl.RubricaUtenteSitoImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<RubricaUtenteSito, Long> ID_UTENTE_ACCESSOR =
		new Accessor<RubricaUtenteSito, Long>() {

			@Override
			public Long get(RubricaUtenteSito rubricaUtenteSito) {
				return rubricaUtenteSito.getID_UTENTE();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<RubricaUtenteSito> getTypeClass() {
				return RubricaUtenteSito.class;
			}

		};

}