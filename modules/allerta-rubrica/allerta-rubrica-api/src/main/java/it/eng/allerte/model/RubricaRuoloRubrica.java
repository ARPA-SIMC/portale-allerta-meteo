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
 * The extended model interface for the RubricaRuoloRubrica service. Represents a row in the &quot;rubrica_RubricaRuoloRubrica&quot; database table, with each column mapped to a property of this class.
 *
 * @author Pratola_L
 * @see RubricaRuoloRubricaModel
 * @generated
 */
@ImplementationClassName("it.eng.allerte.model.impl.RubricaRuoloRubricaImpl")
@ProviderType
public interface RubricaRuoloRubrica
	extends PersistedModel, RubricaRuoloRubricaModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.allerte.model.impl.RubricaRuoloRubricaImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<RubricaRuoloRubrica, Long> ID_RUOLO_ACCESSOR =
		new Accessor<RubricaRuoloRubrica, Long>() {

			@Override
			public Long get(RubricaRuoloRubrica rubricaRuoloRubrica) {
				return rubricaRuoloRubrica.getID_RUOLO();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<RubricaRuoloRubrica> getTypeClass() {
				return RubricaRuoloRubrica.class;
			}

		};

}