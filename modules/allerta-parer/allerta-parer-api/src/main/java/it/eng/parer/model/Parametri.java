/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Parametri service. Represents a row in the &quot;parer_Parametri&quot; database table, with each column mapped to a property of this class.
 *
 * @author Pratola_L
 * @see ParametriModel
 * @generated
 */
@ImplementationClassName("it.eng.parer.model.impl.ParametriImpl")
@ProviderType
public interface Parametri extends ParametriModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.parer.model.impl.ParametriImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Parametri, String> CHIAVE_ACCESSOR =
		new Accessor<Parametri, String>() {

			@Override
			public String get(Parametri parametri) {
				return parametri.getChiave();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<Parametri> getTypeClass() {
				return Parametri.class;
			}

		};

}