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
 * The extended model interface for the TipoEvento service. Represents a row in the &quot;ALLERTER_TipoEvento&quot; database table, with each column mapped to a property of this class.
 *
 * @author GFAVINI
 * @see TipoEventoModel
 * @generated
 */
@ImplementationClassName("it.eng.allerter.model.impl.TipoEventoImpl")
@ProviderType
public interface TipoEvento extends PersistedModel, TipoEventoModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.allerter.model.impl.TipoEventoImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<TipoEvento, Long> EVENTO_ID_ACCESSOR =
		new Accessor<TipoEvento, Long>() {

			@Override
			public Long get(TipoEvento tipoEvento) {
				return tipoEvento.getEventoId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<TipoEvento> getTypeClass() {
				return TipoEvento.class;
			}

		};

}