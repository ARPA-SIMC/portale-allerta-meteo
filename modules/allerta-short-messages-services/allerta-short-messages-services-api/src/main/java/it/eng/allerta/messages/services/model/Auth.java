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
 * The extended model interface for the Auth service. Represents a row in the &quot;smsService_Auth&quot; database table, with each column mapped to a property of this class.
 *
 * @author Giorgianni_F
 * @see AuthModel
 * @generated
 */
@ImplementationClassName("it.eng.allerta.messages.services.model.impl.AuthImpl")
@ProviderType
public interface Auth extends AuthModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.allerta.messages.services.model.impl.AuthImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Auth, String> KEY_ACCESSOR =
		new Accessor<Auth, String>() {

			@Override
			public String get(Auth auth) {
				return auth.getKey();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<Auth> getTypeClass() {
				return Auth.class;
			}

		};

}