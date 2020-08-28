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
 * The extended model interface for the Comuni_bacini_ws service. Represents a row in the &quot;rt_portlet_comuni_bacini_ws&quot; database table, with each column mapped to a property of this class.
 *
 * @author Francesco
 * @see Comuni_bacini_wsModel
 * @generated
 */
@ImplementationClassName("it.eng.radarMeteo.model.impl.Comuni_bacini_wsImpl")
@ProviderType
public interface Comuni_bacini_ws
	extends Comuni_bacini_wsModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.radarMeteo.model.impl.Comuni_bacini_wsImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Comuni_bacini_ws, Integer> ID_BACINI_ACCESSOR =
		new Accessor<Comuni_bacini_ws, Integer>() {

			@Override
			public Integer get(Comuni_bacini_ws comuni_bacini_ws) {
				return comuni_bacini_ws.getIdBacini();
			}

			@Override
			public Class<Integer> getAttributeClass() {
				return Integer.class;
			}

			@Override
			public Class<Comuni_bacini_ws> getTypeClass() {
				return Comuni_bacini_ws.class;
			}

		};

}