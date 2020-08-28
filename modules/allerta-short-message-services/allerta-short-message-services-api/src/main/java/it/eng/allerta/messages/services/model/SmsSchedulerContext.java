/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.eng.allerta.messages.services.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

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