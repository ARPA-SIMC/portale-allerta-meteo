/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import it.eng.allerte.model.RubricaPermessiTable;
import it.eng.allerte.model.impl.RubricaPermessiImpl;
import it.eng.allerte.model.impl.RubricaPermessiModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from RubricaPermessi.
 *
 * @author Pratola_L
 * @generated
 */
@Component(
	property = {
		"class.name=it.eng.allerte.model.impl.RubricaPermessiImpl",
		"table.name=rubrica_RubricaPermessi"
	},
	service = ArgumentsResolver.class
)
public class RubricaPermessiModelArgumentsResolver
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

		RubricaPermessiModelImpl rubricaPermessiModelImpl =
			(RubricaPermessiModelImpl)baseModel;

		long columnBitmask = rubricaPermessiModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(rubricaPermessiModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					rubricaPermessiModelImpl.getColumnBitmask(columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(rubricaPermessiModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return RubricaPermessiImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return RubricaPermessiTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		RubricaPermessiModelImpl rubricaPermessiModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = rubricaPermessiModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = rubricaPermessiModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}