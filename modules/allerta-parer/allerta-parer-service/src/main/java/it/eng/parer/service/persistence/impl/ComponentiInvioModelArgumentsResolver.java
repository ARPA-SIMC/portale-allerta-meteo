/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import it.eng.parer.model.ComponentiInvioTable;
import it.eng.parer.model.impl.ComponentiInvioImpl;
import it.eng.parer.model.impl.ComponentiInvioModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from ComponentiInvio.
 *
 * @author Pratola_L
 * @generated
 */
@Component(
	property = {
		"class.name=it.eng.parer.model.impl.ComponentiInvioImpl",
		"table.name=parer_ComponentiInvio"
	},
	service = ArgumentsResolver.class
)
public class ComponentiInvioModelArgumentsResolver
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

		ComponentiInvioModelImpl componentiInvioModelImpl =
			(ComponentiInvioModelImpl)baseModel;

		long columnBitmask = componentiInvioModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(componentiInvioModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					componentiInvioModelImpl.getColumnBitmask(columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(componentiInvioModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return ComponentiInvioImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return ComponentiInvioTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		ComponentiInvioModelImpl componentiInvioModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = componentiInvioModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = componentiInvioModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}