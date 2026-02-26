/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the RubricaPermessi service. Represents a row in the &quot;rubrica_RubricaPermessi&quot; database table, with each column mapped to a property of this class.
 *
 * @author Pratola_L
 * @see RubricaPermessiModel
 * @generated
 */
@ImplementationClassName("it.eng.allerte.model.impl.RubricaPermessiImpl")
@ProviderType
public interface RubricaPermessi extends RubricaPermessiModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.allerte.model.impl.RubricaPermessiImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<RubricaPermessi, String> ID_PERMESSO_ACCESSOR =
		new Accessor<RubricaPermessi, String>() {

			@Override
			public String get(RubricaPermessi rubricaPermessi) {
				return rubricaPermessi.getID_PERMESSO();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<RubricaPermessi> getTypeClass() {
				return RubricaPermessi.class;
			}

		};

}