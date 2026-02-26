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
 * The extended model interface for the RubricaRuolo service. Represents a row in the &quot;rubrica_RubricaRuolo&quot; database table, with each column mapped to a property of this class.
 *
 * @author Pratola_L
 * @see RubricaRuoloModel
 * @generated
 */
@ImplementationClassName("it.eng.allerte.model.impl.RubricaRuoloImpl")
@ProviderType
public interface RubricaRuolo extends PersistedModel, RubricaRuoloModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.allerte.model.impl.RubricaRuoloImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<RubricaRuolo, Long> ID_RUOLO_ACCESSOR =
		new Accessor<RubricaRuolo, Long>() {

			@Override
			public Long get(RubricaRuolo rubricaRuolo) {
				return rubricaRuolo.getID_RUOLO();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<RubricaRuolo> getTypeClass() {
				return RubricaRuolo.class;
			}

		};

}