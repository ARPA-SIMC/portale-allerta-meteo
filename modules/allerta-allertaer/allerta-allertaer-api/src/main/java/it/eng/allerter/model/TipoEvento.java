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