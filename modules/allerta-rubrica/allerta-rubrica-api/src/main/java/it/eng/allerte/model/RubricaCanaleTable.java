/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;rubrica_RubricaCanale&quot; database table.
 *
 * @author Pratola_L
 * @see RubricaCanale
 * @generated
 */
public class RubricaCanaleTable extends BaseTable<RubricaCanaleTable> {

	public static final RubricaCanaleTable INSTANCE = new RubricaCanaleTable();

	public final Column<RubricaCanaleTable, Long> ID_CANALE = createColumn(
		"ID_CANALE", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	public final Column<RubricaCanaleTable, String> NOME = createColumn(
		"NOME", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<RubricaCanaleTable, String> ICONA = createColumn(
		"ICONA", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<RubricaCanaleTable, String> REGEX = createColumn(
		"REGEX", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private RubricaCanaleTable() {
		super("rubrica_RubricaCanale", RubricaCanaleTable::new);
	}

}