/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Nodo service. Represents a row in the &quot;smsService_Nodo&quot; database table, with each column mapped to a property of this class.
 *
 * @author Giorgianni_F
 * @see NodoModel
 * @generated
 */
@ImplementationClassName("it.eng.allerta.messages.services.model.impl.NodoImpl")
@ProviderType
public interface Nodo extends NodoModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.allerta.messages.services.model.impl.NodoImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Nodo, Long> ID_ACCESSOR =
		new Accessor<Nodo, Long>() {

			@Override
			public Long get(Nodo nodo) {
				return nodo.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Nodo> getTypeClass() {
				return Nodo.class;
			}

		};

}