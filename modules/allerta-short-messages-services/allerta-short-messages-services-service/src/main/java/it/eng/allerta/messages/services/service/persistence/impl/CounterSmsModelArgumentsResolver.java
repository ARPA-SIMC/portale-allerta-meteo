/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import it.eng.allerta.messages.services.model.CounterSmsTable;
import it.eng.allerta.messages.services.model.impl.CounterSmsImpl;
import it.eng.allerta.messages.services.model.impl.CounterSmsModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from CounterSms.
 *
 * @author Giorgianni_F
 * @generated
 */
@Component(
	property = {
		"class.name=it.eng.allerta.messages.services.model.impl.CounterSmsImpl",
		"table.name=smsService_CounterSms"
	},
	service = ArgumentsResolver.class
)
public class CounterSmsModelArgumentsResolver implements ArgumentsResolver {

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

		CounterSmsModelImpl counterSmsModelImpl =
			(CounterSmsModelImpl)baseModel;

		long columnBitmask = counterSmsModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(counterSmsModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |= counterSmsModelImpl.getColumnBitmask(
					columnName);
			}

			if (finderPath.isBaseModelResult() &&
				(CounterSmsPersistenceImpl.
					FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

				finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(counterSmsModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return CounterSmsImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return CounterSmsTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		CounterSmsModelImpl counterSmsModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = counterSmsModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = counterSmsModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

	private static final long _ORDER_BY_COLUMNS_BITMASK;

	static {
		long orderByColumnsBitmask = 0;

		orderByColumnsBitmask |= CounterSmsModelImpl.getColumnBitmask("date_");

		_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
	}

}