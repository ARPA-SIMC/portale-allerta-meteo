/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.radarMeteo.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

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