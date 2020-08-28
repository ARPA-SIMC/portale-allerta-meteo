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

package it.eng.radarMeteo.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Comuni_ws service. Represents a row in the &quot;rt_portlet_comuni_ws&quot; database table, with each column mapped to a property of this class.
 *
 * @author Francesco
 * @see Comuni_wsModel
 * @generated
 */
@ImplementationClassName("it.eng.radarMeteo.model.impl.Comuni_wsImpl")
@ProviderType
public interface Comuni_ws extends Comuni_wsModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.radarMeteo.model.impl.Comuni_wsImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Comuni_ws, String> ID_ISTAT_ACCESSOR =
		new Accessor<Comuni_ws, String>() {

			@Override
			public String get(Comuni_ws comuni_ws) {
				return comuni_ws.getIdIstat();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<Comuni_ws> getTypeClass() {
				return Comuni_ws.class;
			}

		};

}