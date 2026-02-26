/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the RegolaAllarmeComune service. Represents a row in the &quot;BOLLETTINO_RegolaAllarmeComune&quot; database table, with each column mapped to a property of this class.
 *
 * @author GFAVINI
 * @see RegolaAllarmeComuneModel
 * @generated
 */
@ImplementationClassName("it.eng.bollettino.model.impl.RegolaAllarmeComuneImpl")
@ProviderType
public interface RegolaAllarmeComune
	extends PersistedModel, RegolaAllarmeComuneModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.bollettino.model.impl.RegolaAllarmeComuneImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<RegolaAllarmeComune, Long> ID_ACCESSOR =
		new Accessor<RegolaAllarmeComune, Long>() {

			@Override
			public Long get(RegolaAllarmeComune regolaAllarmeComune) {
				return regolaAllarmeComune.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<RegolaAllarmeComune> getTypeClass() {
				return RegolaAllarmeComune.class;
			}

		};

}