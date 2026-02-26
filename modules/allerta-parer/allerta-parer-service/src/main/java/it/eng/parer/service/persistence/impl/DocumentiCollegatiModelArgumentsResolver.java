/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import it.eng.parer.model.DocumentiCollegatiTable;
import it.eng.parer.model.impl.DocumentiCollegatiImpl;
import it.eng.parer.model.impl.DocumentiCollegatiModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from DocumentiCollegati.
 *
 * @author Pratola_L
 * @generated
 */
@Component(
	property = {
		"class.name=it.eng.parer.model.impl.DocumentiCollegatiImpl",
		"table.name=parer_DocumentiCollegati"
	},
	service = ArgumentsResolver.class
)
public class DocumentiCollegatiModelArgumentsResolver
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

		DocumentiCollegatiModelImpl documentiCollegatiModelImpl =
			(DocumentiCollegatiModelImpl)baseModel;

		long columnBitmask = documentiCollegatiModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(
				documentiCollegatiModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					documentiCollegatiModelImpl.getColumnBitmask(columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(
				documentiCollegatiModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return DocumentiCollegatiImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return DocumentiCollegatiTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		DocumentiCollegatiModelImpl documentiCollegatiModelImpl,
		String[] columnNames, boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] =
					documentiCollegatiModelImpl.getColumnOriginalValue(
						columnName);
			}
			else {
				arguments[i] = documentiCollegatiModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}