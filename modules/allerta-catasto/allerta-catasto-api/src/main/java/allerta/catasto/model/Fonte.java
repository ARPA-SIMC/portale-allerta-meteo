/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Fonte service. Represents a row in the &quot;CATASTO_Fonte&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see FonteModel
 * @generated
 */
@ImplementationClassName("allerta.catasto.model.impl.FonteImpl")
@ProviderType
public interface Fonte extends FonteModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>allerta.catasto.model.impl.FonteImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Fonte, Long> ID_ACCESSOR =
		new Accessor<Fonte, Long>() {

			@Override
			public Long get(Fonte fonte) {
				return fonte.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Fonte> getTypeClass() {
				return Fonte.class;
			}

		};

}