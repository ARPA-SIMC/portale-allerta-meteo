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
 * The extended model interface for the Json service. Represents a row in the &quot;rt_portlet_json&quot; database table, with each column mapped to a property of this class.
 *
 * @author Francesco
 * @see JsonModel
 * @generated
 */
@ImplementationClassName("it.eng.radarMeteo.model.impl.JsonImpl")
@ProviderType
public interface Json extends JsonModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.radarMeteo.model.impl.JsonImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Json, Long> ID_ACCESSOR =
		new Accessor<Json, Long>() {

			@Override
			public Long get(Json json) {
				return json.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Json> getTypeClass() {
				return Json.class;
			}

		};

}