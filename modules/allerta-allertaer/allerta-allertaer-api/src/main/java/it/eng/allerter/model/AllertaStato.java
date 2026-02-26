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
 * The extended model interface for the AllertaStato service. Represents a row in the &quot;ALLERTER_AllertaStato&quot; database table, with each column mapped to a property of this class.
 *
 * @author GFAVINI
 * @see AllertaStatoModel
 * @generated
 */
@ImplementationClassName("it.eng.allerter.model.impl.AllertaStatoImpl")
@ProviderType
public interface AllertaStato extends AllertaStatoModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.allerter.model.impl.AllertaStatoImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AllertaStato, Long> ALLERTA_STATO_ID_ACCESSOR =
		new Accessor<AllertaStato, Long>() {

			@Override
			public Long get(AllertaStato allertaStato) {
				return allertaStato.getAllertaStatoId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<AllertaStato> getTypeClass() {
				return AllertaStato.class;
			}

		};

}