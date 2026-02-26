/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the SmsSchedulerContext service. Represents a row in the &quot;smsService_SmsSchedulerContext&quot; database table, with each column mapped to a property of this class.
 *
 * @author Giorgianni_F
 * @see SmsSchedulerContextModel
 * @generated
 */
@ImplementationClassName(
	"it.eng.allerta.messages.services.model.impl.SmsSchedulerContextImpl"
)
@ProviderType
public interface SmsSchedulerContext
	extends PersistedModel, SmsSchedulerContextModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.allerta.messages.services.model.impl.SmsSchedulerContextImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<SmsSchedulerContext, String> VAR_ID_ACCESSOR =
		new Accessor<SmsSchedulerContext, String>() {

			@Override
			public String get(SmsSchedulerContext smsSchedulerContext) {
				return smsSchedulerContext.getVarId();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<SmsSchedulerContext> getTypeClass() {
				return SmsSchedulerContext.class;
			}

		};

}