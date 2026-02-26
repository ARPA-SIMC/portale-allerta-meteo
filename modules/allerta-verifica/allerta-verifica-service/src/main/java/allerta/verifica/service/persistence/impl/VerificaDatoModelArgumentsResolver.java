/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.verifica.service.persistence.impl;

import allerta.verifica.model.VerificaDatoTable;
import allerta.verifica.model.impl.VerificaDatoImpl;
import allerta.verifica.model.impl.VerificaDatoModelImpl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from VerificaDato.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=allerta.verifica.model.impl.VerificaDatoImpl",
		"table.name=VERIFICA_VerificaDato"
	},
	service = ArgumentsResolver.class
)
public class VerificaDatoModelArgumentsResolver implements ArgumentsResolver {

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

		VerificaDatoModelImpl verificaDatoModelImpl =
			(VerificaDatoModelImpl)baseModel;

		long columnBitmask = verificaDatoModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(verificaDatoModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					verificaDatoModelImpl.getColumnBitmask(columnName);
			}

			if (finderPath.isBaseModelResult() &&
				(VerificaDatoPersistenceImpl.
					FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

				finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(verificaDatoModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return VerificaDatoImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return VerificaDatoTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		VerificaDatoModelImpl verificaDatoModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = verificaDatoModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = verificaDatoModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

	private static final long _ORDER_BY_COLUMNS_BITMASK;

	static {
		long orderByColumnsBitmask = 0;

		orderByColumnsBitmask |= VerificaDatoModelImpl.getColumnBitmask(
			"documento");
		orderByColumnsBitmask |= VerificaDatoModelImpl.getColumnBitmask(
			"giorno");
		orderByColumnsBitmask |= VerificaDatoModelImpl.getColumnBitmask("zona");
		orderByColumnsBitmask |= VerificaDatoModelImpl.getColumnBitmask(
			"evento");
		orderByColumnsBitmask |= VerificaDatoModelImpl.getColumnBitmask(
			"nomeDato");
		orderByColumnsBitmask |= VerificaDatoModelImpl.getColumnBitmask(
			"progressivo");

		_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
	}

}