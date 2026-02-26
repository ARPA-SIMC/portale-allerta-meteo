/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;BOLLETTINO_BollettinoParametro&quot; database table.
 *
 * @author GFAVINI
 * @see BollettinoParametro
 * @generated
 */
public class BollettinoParametroTable
	extends BaseTable<BollettinoParametroTable> {

	public static final BollettinoParametroTable INSTANCE =
		new BollettinoParametroTable();

	public final Column<BollettinoParametroTable, String> parametroId =
		createColumn(
			"parametroId", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<BollettinoParametroTable, String> valore = createColumn(
		"valore", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private BollettinoParametroTable() {
		super("BOLLETTINO_BollettinoParametro", BollettinoParametroTable::new);
	}

}