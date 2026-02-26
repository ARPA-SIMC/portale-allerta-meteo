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
 * The extended model interface for the EffettiSub service. Represents a row in the &quot;CATASTO_EffettiSub&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see EffettiSubModel
 * @generated
 */
@ImplementationClassName("allerta.catasto.model.impl.EffettiSubImpl")
@ProviderType
public interface EffettiSub extends EffettiSubModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>allerta.catasto.model.impl.EffettiSubImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<EffettiSub, Long> ID_ACCESSOR =
		new Accessor<EffettiSub, Long>() {

			@Override
			public Long get(EffettiSub effettiSub) {
				return effettiSub.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<EffettiSub> getTypeClass() {
				return EffettiSub.class;
			}

		};
	public static final Accessor<EffettiSub, Long> ID_EFFETTI_ACCESSOR =
		new Accessor<EffettiSub, Long>() {

			@Override
			public Long get(EffettiSub effettiSub) {
				return effettiSub.getIdEffetti();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<EffettiSub> getTypeClass() {
				return EffettiSub.class;
			}

		};

}