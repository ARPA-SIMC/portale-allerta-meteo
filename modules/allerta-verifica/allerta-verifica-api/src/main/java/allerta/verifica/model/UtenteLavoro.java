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
 * The extended model interface for the UtenteLavoro service. Represents a row in the &quot;VERIFICA_UtenteLavoro&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see UtenteLavoroModel
 * @generated
 */
@ImplementationClassName("allerta.verifica.model.impl.UtenteLavoroImpl")
@ProviderType
public interface UtenteLavoro extends PersistedModel, UtenteLavoroModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>allerta.verifica.model.impl.UtenteLavoroImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<UtenteLavoro, Long> ID_ACCESSOR =
		new Accessor<UtenteLavoro, Long>() {

			@Override
			public Long get(UtenteLavoro utenteLavoro) {
				return utenteLavoro.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<UtenteLavoro> getTypeClass() {
				return UtenteLavoro.class;
			}

		};

}