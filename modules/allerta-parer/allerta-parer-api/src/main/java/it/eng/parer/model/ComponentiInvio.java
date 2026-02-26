/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the ComponentiInvio service. Represents a row in the &quot;parer_ComponentiInvio&quot; database table, with each column mapped to a property of this class.
 *
 * @author Pratola_L
 * @see ComponentiInvioModel
 * @generated
 */
@ImplementationClassName("it.eng.parer.model.impl.ComponentiInvioImpl")
@ProviderType
public interface ComponentiInvio extends ComponentiInvioModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.parer.model.impl.ComponentiInvioImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ComponentiInvio, Long> ID_INVIO_ACCESSOR =
		new Accessor<ComponentiInvio, Long>() {

			@Override
			public Long get(ComponentiInvio componentiInvio) {
				return componentiInvio.getID_INVIO();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ComponentiInvio> getTypeClass() {
				return ComponentiInvio.class;
			}

		};
	public static final Accessor<ComponentiInvio, Long> ID_COMPONENTE_ACCESSOR =
		new Accessor<ComponentiInvio, Long>() {

			@Override
			public Long get(ComponentiInvio componentiInvio) {
				return componentiInvio.getID_COMPONENTE();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ComponentiInvio> getTypeClass() {
				return ComponentiInvio.class;
			}

		};

}