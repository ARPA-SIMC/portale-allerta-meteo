/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.verifica.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Verifica service. Represents a row in the &quot;VERIFICA_Verifica&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see VerificaModel
 * @generated
 */
@ImplementationClassName("allerta.verifica.model.impl.VerificaImpl")
@ProviderType
public interface Verifica extends PersistedModel, VerificaModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>allerta.verifica.model.impl.VerificaImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Verifica, Long> ID_ACCESSOR =
		new Accessor<Verifica, Long>() {

			@Override
			public Long get(Verifica verifica) {
				return verifica.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Verifica> getTypeClass() {
				return Verifica.class;
			}

		};

}