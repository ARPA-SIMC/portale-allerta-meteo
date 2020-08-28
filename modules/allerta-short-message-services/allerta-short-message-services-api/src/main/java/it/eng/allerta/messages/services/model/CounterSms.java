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
 * The extended model interface for the CounterSms service. Represents a row in the &quot;smsService_CounterSms&quot; database table, with each column mapped to a property of this class.
 *
 * @author Giorgianni_F
 * @see CounterSmsModel
 * @generated
 */
@ImplementationClassName(
	"it.eng.allerta.messages.services.model.impl.CounterSmsImpl"
)
@ProviderType
public interface CounterSms extends CounterSmsModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>it.eng.allerta.messages.services.model.impl.CounterSmsImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<CounterSms, Long> COUNTER_ID_ACCESSOR =
		new Accessor<CounterSms, Long>() {

			@Override
			public Long get(CounterSms counterSms) {
				return counterSms.getCounterId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<CounterSms> getTypeClass() {
				return CounterSms.class;
			}

		};

}