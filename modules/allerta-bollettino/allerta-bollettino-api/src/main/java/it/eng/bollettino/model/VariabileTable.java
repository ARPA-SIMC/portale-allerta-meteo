/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;BOLLETTINO_Variabile&quot; database table.
 *
 * @author GFAVINI
 * @see Variabile
 * @generated
 */
public class VariabileTable extends BaseTable<VariabileTable> {

	public static final VariabileTable INSTANCE = new VariabileTable();

	public final Column<VariabileTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VariabileTable, String> id = createColumn(
		"id_", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<VariabileTable, String> description_it = createColumn(
		"description_it", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VariabileTable, Integer> level_t1 = createColumn(
		"level_t1", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<VariabileTable, Integer> level_t2 = createColumn(
		"level_t2", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<VariabileTable, Integer> level_v1 = createColumn(
		"level_v1", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<VariabileTable, Integer> level_v2 = createColumn(
		"level_v2", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<VariabileTable, Integer> trange_p1 = createColumn(
		"trange_p1", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<VariabileTable, Integer> trange_p2 = createColumn(
		"trange_p2", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<VariabileTable, Integer> trange_pind = createColumn(
		"trange_pind", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<VariabileTable, String> unit = createColumn(
		"unit", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VariabileTable, String> bcode = createColumn(
		"bcode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private VariabileTable() {
		super("BOLLETTINO_Variabile", VariabileTable::new);
	}

}