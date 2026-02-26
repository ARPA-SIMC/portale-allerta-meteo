/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.dewetra.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the HRW service. Represents a row in the &quot;DEWETRA_HRW&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see HRWModel
 * @generated
 */
@ImplementationClassName("allerta.dewetra.model.impl.HRWImpl")
@ProviderType
public interface HRW extends HRWModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>allerta.dewetra.model.impl.HRWImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<HRW, Long> ID_ACCESSOR =
		new Accessor<HRW, Long>() {

			@Override
			public Long get(HRW hrw) {
				return hrw.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<HRW> getTypeClass() {
				return HRW.class;
			}

		};

}