/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animaeteo.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the AnimeteoImg service. Represents a row in the &quot;animeteo_AnimeteoImg&quot; database table, with each column mapped to a property of this class.
 *
 * @author UTENTE
 * @see AnimeteoImgModel
 * @generated
 */
@ImplementationClassName("it.eng.animaeteo.model.impl.AnimeteoImgImpl")
@ProviderType
public interface AnimeteoImg extends AnimeteoImgModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.animaeteo.model.impl.AnimeteoImgImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AnimeteoImg, Long> ID_ACCESSOR =
		new Accessor<AnimeteoImg, Long>() {

			@Override
			public Long get(AnimeteoImg animeteoImg) {
				return animeteoImg.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<AnimeteoImg> getTypeClass() {
				return AnimeteoImg.class;
			}

		};

}