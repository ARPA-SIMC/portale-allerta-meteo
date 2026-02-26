/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the AllertaParametro service. Represents a row in the &quot;ALLERTER_AllertaParametro&quot; database table, with each column mapped to a property of this class.
 *
 * @author GFAVINI
 * @see AllertaParametroModel
 * @generated
 */
@ImplementationClassName("it.eng.allerter.model.impl.AllertaParametroImpl")
@ProviderType
public interface AllertaParametro
	extends AllertaParametroModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.allerter.model.impl.AllertaParametroImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AllertaParametro, String>
		PARAMETRO_ID_ACCESSOR = new Accessor<AllertaParametro, String>() {

			@Override
			public String get(AllertaParametro allertaParametro) {
				return allertaParametro.getParametroId();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<AllertaParametro> getTypeClass() {
				return AllertaParametro.class;
			}

		};

}