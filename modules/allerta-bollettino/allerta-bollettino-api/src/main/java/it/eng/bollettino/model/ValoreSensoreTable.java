/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;BOLLETTINO_ValoreSensore&quot; database table.
 *
 * @author GFAVINI
 * @see ValoreSensore
 * @generated
 */
public class ValoreSensoreTable extends BaseTable<ValoreSensoreTable> {

	public static final ValoreSensoreTable INSTANCE = new ValoreSensoreTable();

	public final Column<ValoreSensoreTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ValoreSensoreTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ValoreSensoreTable, Double> value = createColumn(
		"value", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<ValoreSensoreTable, Date> datetime = createColumn(
		"datetime", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ValoreSensoreTable, String> idVariabile = createColumn(
		"idVariabile", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ValoreSensoreTable, String> idStazione = createColumn(
		"idStazione", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ValoreSensoreTable() {
		super("BOLLETTINO_ValoreSensore", ValoreSensoreTable::new);
	}

}