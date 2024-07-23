/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.eng.allerter.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

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