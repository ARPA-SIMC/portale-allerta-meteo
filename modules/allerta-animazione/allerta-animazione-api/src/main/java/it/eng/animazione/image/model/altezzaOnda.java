/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animazione.image.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the altezzaOnda service. Represents a row in the &quot;img_animazioni_altezzaOnda&quot; database table, with each column mapped to a property of this class.
 *
 * @author UTENTE
 * @see altezzaOndaModel
 * @generated
 */
@ImplementationClassName("it.eng.animazione.image.model.impl.altezzaOndaImpl")
@ProviderType
public interface altezzaOnda extends altezzaOndaModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.animazione.image.model.impl.altezzaOndaImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<altezzaOnda, Long> ID_ACCESSOR =
		new Accessor<altezzaOnda, Long>() {

			@Override
			public Long get(altezzaOnda altezzaOnda) {
				return altezzaOnda.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<altezzaOnda> getTypeClass() {
				return altezzaOnda.class;
			}

		};

}