/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;ALLERTER_AllertaParametro&quot; database table.
 *
 * @author GFAVINI
 * @see AllertaParametro
 * @generated
 */
public class AllertaParametroTable extends BaseTable<AllertaParametroTable> {

	public static final AllertaParametroTable INSTANCE =
		new AllertaParametroTable();

	public final Column<AllertaParametroTable, String> parametroId =
		createColumn(
			"parametroId", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<AllertaParametroTable, String> valore = createColumn(
		"valore", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private AllertaParametroTable() {
		super("ALLERTER_AllertaParametro", AllertaParametroTable::new);
	}

}