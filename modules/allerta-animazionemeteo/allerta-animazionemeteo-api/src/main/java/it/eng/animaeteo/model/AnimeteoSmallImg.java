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
 * The extended model interface for the AnimeteoSmallImg service. Represents a row in the &quot;animeteo_AnimeteoSmallImg&quot; database table, with each column mapped to a property of this class.
 *
 * @author UTENTE
 * @see AnimeteoSmallImgModel
 * @generated
 */
@ImplementationClassName("it.eng.animaeteo.model.impl.AnimeteoSmallImgImpl")
@ProviderType
public interface AnimeteoSmallImg
	extends AnimeteoSmallImgModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.animaeteo.model.impl.AnimeteoSmallImgImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AnimeteoSmallImg, Long> ID_ACCESSOR =
		new Accessor<AnimeteoSmallImg, Long>() {

			@Override
			public Long get(AnimeteoSmallImg animeteoSmallImg) {
				return animeteoSmallImg.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<AnimeteoSmallImg> getTypeClass() {
				return AnimeteoSmallImg.class;
			}

		};

}