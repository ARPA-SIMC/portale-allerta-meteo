/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.verifica.service.persistence.impl;

import allerta.verifica.model.UtenteLavoroTable;
import allerta.verifica.model.impl.UtenteLavoroImpl;
import allerta.verifica.model.impl.UtenteLavoroModelImpl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from UtenteLavoro.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=allerta.verifica.model.impl.UtenteLavoroImpl",
		"table.name=VERIFICA_UtenteLavoro"
	},
	service = ArgumentsResolver.class
)
public class UtenteLavoroModelArgumentsResolver implements ArgumentsResolver {

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

		UtenteLavoroModelImpl utenteLavoroModelImpl =
			(UtenteLavoroModelImpl)baseModel;

		long columnBitmask = utenteLavoroModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(utenteLavoroModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					utenteLavoroModelImpl.getColumnBitmask(columnName);
			}

			if (finderPath.isBaseModelResult() &&
				(UtenteLavoroPersistenceImpl.
					FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

				finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(utenteLavoroModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return UtenteLavoroImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return UtenteLavoroTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		UtenteLavoroModelImpl utenteLavoroModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = utenteLavoroModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = utenteLavoroModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

	private static final long _ORDER_BY_COLUMNS_BITMASK;

	static {
		long orderByColumnsBitmask = 0;

		orderByColumnsBitmask |= UtenteLavoroModelImpl.getColumnBitmask("ts");

		_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
	}

}