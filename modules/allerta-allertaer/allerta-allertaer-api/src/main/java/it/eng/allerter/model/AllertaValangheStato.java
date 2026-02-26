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
 * The extended model interface for the AllertaValangheStato service. Represents a row in the &quot;ALLERTER_AllertaValangheStato&quot; database table, with each column mapped to a property of this class.
 *
 * @author GFAVINI
 * @see AllertaValangheStatoModel
 * @generated
 */
@ImplementationClassName("it.eng.allerter.model.impl.AllertaValangheStatoImpl")
@ProviderType
public interface AllertaValangheStato
	extends AllertaValangheStatoModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.allerter.model.impl.AllertaValangheStatoImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AllertaValangheStato, Long>
		ALLERTA_VALANGHE_STATO_ID_ACCESSOR =
			new Accessor<AllertaValangheStato, Long>() {

				@Override
				public Long get(AllertaValangheStato allertaValangheStato) {
					return allertaValangheStato.getAllertaValangheStatoId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<AllertaValangheStato> getTypeClass() {
					return AllertaValangheStato.class;
				}

			};

}