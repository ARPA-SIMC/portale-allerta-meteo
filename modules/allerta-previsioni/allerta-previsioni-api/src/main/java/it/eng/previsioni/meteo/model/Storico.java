/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.previsioni.meteo.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Storico service. Represents a row in the &quot;prev_meteo_Storico&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see StoricoModel
 * @generated
 */
@ImplementationClassName("it.eng.previsioni.meteo.model.impl.StoricoImpl")
@ProviderType
public interface Storico extends PersistedModel, StoricoModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.previsioni.meteo.model.impl.StoricoImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Storico, Long> ID_ACCESSOR =
		new Accessor<Storico, Long>() {

			@Override
			public Long get(Storico storico) {
				return storico.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Storico> getTypeClass() {
				return Storico.class;
			}

		};

}