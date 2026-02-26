/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import it.eng.allerta.messages.services.model.SmsSchedulerContextTable;
import it.eng.allerta.messages.services.model.impl.SmsSchedulerContextImpl;
import it.eng.allerta.messages.services.model.impl.SmsSchedulerContextModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from SmsSchedulerContext.
 *
 * @author Giorgianni_F
 * @generated
 */
@Component(
	property = {
		"class.name=it.eng.allerta.messages.services.model.impl.SmsSchedulerContextImpl",
		"table.name=smsService_SmsSchedulerContext"
	},
	service = ArgumentsResolver.class
)
public class SmsSchedulerContextModelArgumentsResolver
	implements ArgumentsResolver {

	@Override
	public Object[] getArguments(
		FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
		boolean original) {

		String[] columnNames = finderPath.getColumnNames();

		if ((columnNames == null) || (columnNames.length == 0)) {
			if (baseModel.isNew()) {
				return new Object[0];
			}

			return null;
		}

		SmsSchedulerContextModelImpl smsSchedulerContextModelImpl =
			(SmsSchedulerContextModelImpl)baseModel;

		long columnBitmask = smsSchedulerContextModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(
				smsSchedulerContextModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					smsSchedulerContextModelImpl.getColumnBitmask(columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(
				smsSchedulerContextModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return SmsSchedulerContextImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return SmsSchedulerContextTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		SmsSchedulerContextModelImpl smsSchedulerContextModelImpl,
		String[] columnNames, boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] =
					smsSchedulerContextModelImpl.getColumnOriginalValue(
						columnName);
			}
			else {
				arguments[i] = smsSchedulerContextModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}