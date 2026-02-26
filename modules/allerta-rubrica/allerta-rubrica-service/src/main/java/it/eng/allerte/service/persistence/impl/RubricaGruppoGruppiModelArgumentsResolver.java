/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import it.eng.allerte.model.RubricaGruppoGruppiTable;
import it.eng.allerte.model.impl.RubricaGruppoGruppiImpl;
import it.eng.allerte.model.impl.RubricaGruppoGruppiModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from RubricaGruppoGruppi.
 *
 * @author Pratola_L
 * @generated
 */
@Component(
	property = {
		"class.name=it.eng.allerte.model.impl.RubricaGruppoGruppiImpl",
		"table.name=rubrica_RubricaGruppoGruppi"
	},
	service = ArgumentsResolver.class
)
public class RubricaGruppoGruppiModelArgumentsResolver
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

		RubricaGruppoGruppiModelImpl rubricaGruppoGruppiModelImpl =
			(RubricaGruppoGruppiModelImpl)baseModel;

		long columnBitmask = rubricaGruppoGruppiModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(
				rubricaGruppoGruppiModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					rubricaGruppoGruppiModelImpl.getColumnBitmask(columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(
				rubricaGruppoGruppiModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return RubricaGruppoGruppiImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return RubricaGruppoGruppiTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		RubricaGruppoGruppiModelImpl rubricaGruppoGruppiModelImpl,
		String[] columnNames, boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] =
					rubricaGruppoGruppiModelImpl.getColumnOriginalValue(
						columnName);
			}
			else {
				arguments[i] = rubricaGruppoGruppiModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}