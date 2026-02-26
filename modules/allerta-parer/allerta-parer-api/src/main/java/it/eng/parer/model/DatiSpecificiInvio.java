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