/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the SMS service. Represents a row in the &quot;ALLERTER_SMS&quot; database table, with each column mapped to a property of this class.
 *
 * @author GFAVINI
 * @see SMSModel
 * @generated
 */
@ImplementationClassName("it.eng.allerter.model.impl.SMSImpl")
@ProviderType
public interface SMS extends PersistedModel, SMSModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.allerter.model.impl.SMSImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<SMS, Long> ID_ACCESSOR =
		new Accessor<SMS, Long>() {

			@Override
			public Long get(SMS sms) {
				return sms.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<SMS> getTypeClass() {
				return SMS.class;
			}

		};

}