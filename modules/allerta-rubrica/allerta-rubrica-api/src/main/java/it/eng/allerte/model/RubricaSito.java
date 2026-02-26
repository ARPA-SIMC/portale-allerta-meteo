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
 * The extended model interface for the RubricaSito service. Represents a row in the &quot;rubrica_RubricaSito&quot; database table, with each column mapped to a property of this class.
 *
 * @author Pratola_L
 * @see RubricaSitoModel
 * @generated
 */
@ImplementationClassName("it.eng.allerte.model.impl.RubricaSitoImpl")
@ProviderType
public interface RubricaSito extends PersistedModel, RubricaSitoModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.allerte.model.impl.RubricaSitoImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<RubricaSito, Long> ID_SITO_ACCESSOR =
		new Accessor<RubricaSito, Long>() {

			@Override
			public Long get(RubricaSito rubricaSito) {
				return rubricaSito.getID_SITO();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<RubricaSito> getTypeClass() {
				return RubricaSito.class;
			}

		};

}