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