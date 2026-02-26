/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;rubrica_RubricaPermessi&quot; database table.
 *
 * @author Pratola_L
 * @see RubricaPermessi
 * @generated
 */
public class RubricaPermessiTable extends BaseTable<RubricaPermessiTable> {

	public static final RubricaPermessiTable INSTANCE =
		new RubricaPermessiTable();

	public final Column<RubricaPermessiTable, String> ID_PERMESSO =
		createColumn(
			"ID_PERMESSO", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);

	public final Column<RubricaPermessiTable, String> NOME_PERMESSO =
		createColumn(
			"NOME_PERMESSO", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private RubricaPermessiTable() {
		super("rubrica_RubricaPermessi", RubricaPermessiTable::new);
	}

}