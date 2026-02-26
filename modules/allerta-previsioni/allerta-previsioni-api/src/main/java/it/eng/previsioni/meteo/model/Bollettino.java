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
 * The extended model interface for the Bollettino service. Represents a row in the &quot;prev_meteo_Bollettino&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see BollettinoModel
 * @generated
 */
@ImplementationClassName("it.eng.previsioni.meteo.model.impl.BollettinoImpl")
@ProviderType
public interface Bollettino extends BollettinoModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.previsioni.meteo.model.impl.BollettinoImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Bollettino, Long> ID_ACCESSOR =
		new Accessor<Bollettino, Long>() {

			@Override
			public Long get(Bollettino bollettino) {
				return bollettino.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Bollettino> getTypeClass() {
				return Bollettino.class;
			}

		};

}