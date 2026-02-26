/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animaeteo.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import it.eng.animaeteo.model.AnimeteoSmallImgTable;
import it.eng.animaeteo.model.impl.AnimeteoSmallImgImpl;
import it.eng.animaeteo.model.impl.AnimeteoSmallImgModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from AnimeteoSmallImg.
 *
 * @author UTENTE
 * @generated
 */
@Component(
	property = {
		"class.name=it.eng.animaeteo.model.impl.AnimeteoSmallImgImpl",
		"table.name=animeteo_AnimeteoSmallImg"
	},
	service = ArgumentsResolver.class
)
public class AnimeteoSmallImgModelArgumentsResolver
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

		AnimeteoSmallImgModelImpl animeteoSmallImgModelImpl =
			(AnimeteoSmallImgModelImpl)baseModel;

		long columnBitmask = animeteoSmallImgModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(animeteoSmallImgModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					animeteoSmallImgModelImpl.getColumnBitmask(columnName);
			}

			if (finderPath.isBaseModelResult() &&
				(AnimeteoSmallImgPersistenceImpl.
					FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

				finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(animeteoSmallImgModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return AnimeteoSmallImgImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return AnimeteoSmallImgTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		AnimeteoSmallImgModelImpl animeteoSmallImgModelImpl,
		String[] columnNames, boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = animeteoSmallImgModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = animeteoSmallImgModelImpl.getColumnValue(
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