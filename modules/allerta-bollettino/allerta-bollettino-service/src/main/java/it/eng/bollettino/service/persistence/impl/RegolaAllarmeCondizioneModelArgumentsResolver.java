/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import it.eng.bollettino.model.RegolaAllarmeCondizioneTable;
import it.eng.bollettino.model.impl.RegolaAllarmeCondizioneImpl;
import it.eng.bollettino.model.impl.RegolaAllarmeCondizioneModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from RegolaAllarmeCondizione.
 *
 * @author GFAVINI
 * @generated
 */
@Component(
	property = {
		"class.name=it.eng.bollettino.model.impl.RegolaAllarmeCondizioneImpl",
		"table.name=BOLLETTINO_RegolaAllarmeCondizione"
	},
	service = ArgumentsResolver.class
)
public class RegolaAllarmeCondizioneModelArgumentsResolver
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

		RegolaAllarmeCondizioneModelImpl regolaAllarmeCondizioneModelImpl =
			(RegolaAllarmeCondizioneModelImpl)baseModel;

		long columnBitmask =
			regolaAllarmeCondizioneModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(
				regolaAllarmeCondizioneModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					regolaAllarmeCondizioneModelImpl.getColumnBitmask(
						columnName);
			}

			if (finderPath.isBaseModelResult() &&
				(RegolaAllarmeCondizionePersistenceImpl.
					FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

				finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(
				regolaAllarmeCondizioneModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return RegolaAllarmeCondizioneImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return RegolaAllarmeCondizioneTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		RegolaAllarmeCondizioneModelImpl regolaAllarmeCondizioneModelImpl,
		String[] columnNames, boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] =
					regolaAllarmeCondizioneModelImpl.getColumnOriginalValue(
						columnName);
			}
			else {
				arguments[i] = regolaAllarmeCondizioneModelImpl.getColumnValue(
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

		_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
	}

}