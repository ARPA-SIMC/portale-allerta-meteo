/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import it.eng.allerte.model.RubricaCategoriaTable;
import it.eng.allerte.model.impl.RubricaCategoriaImpl;
import it.eng.allerte.model.impl.RubricaCategoriaModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from RubricaCategoria.
 *
 * @author Pratola_L
 * @generated
 */
@Component(
	property = {
		"class.name=it.eng.allerte.model.impl.RubricaCategoriaImpl",
		"table.name=rubrica_RubricaCategoria"
	},
	service = ArgumentsResolver.class
)
public class RubricaCategoriaModelArgumentsResolver
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

		RubricaCategoriaModelImpl rubricaCategoriaModelImpl =
			(RubricaCategoriaModelImpl)baseModel;

		long columnBitmask = rubricaCategoriaModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(rubricaCategoriaModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					rubricaCategoriaModelImpl.getColumnBitmask(columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(rubricaCategoriaModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return RubricaCategoriaImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return RubricaCategoriaTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		RubricaCategoriaModelImpl rubricaCategoriaModelImpl,
		String[] columnNames, boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = rubricaCategoriaModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = rubricaCategoriaModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}