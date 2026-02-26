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
 * The extended model interface for the AttivazioneFiume service. Represents a row in the &quot;BOLLETTINO_AttivazioneFiume&quot; database table, with each column mapped to a property of this class.
 *
 * @author GFAVINI
 * @see AttivazioneFiumeModel
 * @generated
 */
@ImplementationClassName("it.eng.bollettino.model.impl.AttivazioneFiumeImpl")
@ProviderType
public interface AttivazioneFiume
	extends AttivazioneFiumeModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.bollettino.model.impl.AttivazioneFiumeImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AttivazioneFiume, String> FIUME_ID_ACCESSOR =
		new Accessor<AttivazioneFiume, String>() {

			@Override
			public String get(AttivazioneFiume attivazioneFiume) {
				return attivazioneFiume.getFiumeId();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<AttivazioneFiume> getTypeClass() {
				return AttivazioneFiume.class;
			}

		};

}