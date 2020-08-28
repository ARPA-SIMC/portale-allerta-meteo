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

package it.eng.parer.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the DatiSpecificiInvio service. Represents a row in the &quot;parer_DatiSpecificiInvio&quot; database table, with each column mapped to a property of this class.
 *
 * @author Pratola_L
 * @see DatiSpecificiInvioModel
 * @generated
 */
@ImplementationClassName("it.eng.parer.model.impl.DatiSpecificiInvioImpl")
@ProviderType
public interface DatiSpecificiInvio
	extends DatiSpecificiInvioModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.parer.model.impl.DatiSpecificiInvioImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DatiSpecificiInvio, Long> ID_INVIO_ACCESSOR =
		new Accessor<DatiSpecificiInvio, Long>() {

			@Override
			public Long get(DatiSpecificiInvio datiSpecificiInvio) {
				return datiSpecificiInvio.getID_INVIO();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<DatiSpecificiInvio> getTypeClass() {
				return DatiSpecificiInvio.class;
			}

		};

}