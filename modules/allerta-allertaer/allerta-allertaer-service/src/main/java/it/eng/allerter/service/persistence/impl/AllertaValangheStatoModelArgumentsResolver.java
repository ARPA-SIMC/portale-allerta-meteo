/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import it.eng.allerter.model.AllertaValangheStatoTable;
import it.eng.allerter.model.impl.AllertaValangheStatoImpl;
import it.eng.allerter.model.impl.AllertaValangheStatoModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from AllertaValangheStato.
 *
 * @author GFAVINI
 * @generated
 */
@Component(
	property = {
		"class.name=it.eng.allerter.model.impl.AllertaValangheStatoImpl",
		"table.name=ALLERTER_AllertaValangheStato"
	},
	service = ArgumentsResolver.class
)
public class AllertaValangheStatoModelArgumentsResolver
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

		AllertaValangheStatoModelImpl allertaValangheStatoModelImpl =
			(AllertaValangheStatoModelImpl)baseModel;

		long columnBitmask = allertaValangheStatoModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(
				allertaValangheStatoModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					allertaValangheStatoModelImpl.getColumnBitmask(columnName);
			}

			if (finderPath.isBaseModelResult() &&
				(AllertaValangheStatoPersistenceImpl.
					FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

				finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(
				allertaValangheStatoModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return AllertaValangheStatoImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return AllertaValangheStatoTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		AllertaValangheStatoModelImpl allertaValangheStatoModelImpl,
		String[] columnNames, boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] =
					allertaValangheStatoModelImpl.getColumnOriginalValue(
						columnName);
			}
			else {
				arguments[i] = allertaValangheStatoModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

	private static final long _ORDER_BY_COLUMNS_BITMASK;

	static {
		long orderByColumnsBitmask = 0;

		orderByColumnsBitmask |= AllertaValangheStatoModelImpl.getColumnBitmask(
			"nome");

		_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
	}

}