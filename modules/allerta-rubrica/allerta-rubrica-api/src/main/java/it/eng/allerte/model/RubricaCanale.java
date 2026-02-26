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
 * The extended model interface for the RubricaCanale service. Represents a row in the &quot;rubrica_RubricaCanale&quot; database table, with each column mapped to a property of this class.
 *
 * @author Pratola_L
 * @see RubricaCanaleModel
 * @generated
 */
@ImplementationClassName("it.eng.allerte.model.impl.RubricaCanaleImpl")
@ProviderType
public interface RubricaCanale extends PersistedModel, RubricaCanaleModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.allerte.model.impl.RubricaCanaleImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<RubricaCanale, Long> ID_CANALE_ACCESSOR =
		new Accessor<RubricaCanale, Long>() {

			@Override
			public Long get(RubricaCanale rubricaCanale) {
				return rubricaCanale.getID_CANALE();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<RubricaCanale> getTypeClass() {
				return RubricaCanale.class;
			}

		};

}