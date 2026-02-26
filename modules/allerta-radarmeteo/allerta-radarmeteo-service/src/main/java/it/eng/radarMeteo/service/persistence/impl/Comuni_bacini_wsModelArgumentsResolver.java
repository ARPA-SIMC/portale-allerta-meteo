/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.radarMeteo.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import it.eng.radarMeteo.model.Comuni_bacini_wsTable;
import it.eng.radarMeteo.model.impl.Comuni_bacini_wsImpl;
import it.eng.radarMeteo.model.impl.Comuni_bacini_wsModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from Comuni_bacini_ws.
 *
 * @author Francesco
 * @generated
 */
@Component(
	property = {
		"class.name=it.eng.radarMeteo.model.impl.Comuni_bacini_wsImpl",
		"table.name=rt_portlet_comuni_bacini_ws"
	},
	service = ArgumentsResolver.class
)
public class Comuni_bacini_wsModelArgumentsResolver
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

		Comuni_bacini_wsModelImpl comuni_bacini_wsModelImpl =
			(Comuni_bacini_wsModelImpl)baseModel;

		long columnBitmask = comuni_bacini_wsModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(comuni_bacini_wsModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					comuni_bacini_wsModelImpl.getColumnBitmask(columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(comuni_bacini_wsModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return Comuni_bacini_wsImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return Comuni_bacini_wsTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		Comuni_bacini_wsModelImpl comuni_bacini_wsModelImpl,
		String[] columnNames, boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = comuni_bacini_wsModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = comuni_bacini_wsModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}