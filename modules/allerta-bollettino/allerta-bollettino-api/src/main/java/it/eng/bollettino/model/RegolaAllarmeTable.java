/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;BOLLETTINO_RegolaAllarme&quot; database table.
 *
 * @author GFAVINI
 * @see RegolaAllarme
 * @generated
 */
public class RegolaAllarmeTable extends BaseTable<RegolaAllarmeTable> {

	public static final RegolaAllarmeTable INSTANCE = new RegolaAllarmeTable();

	public final Column<RegolaAllarmeTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RegolaAllarmeTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<RegolaAllarmeTable, String> nome = createColumn(
		"nome", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RegolaAllarmeTable, String> espressione = createColumn(
		"espressione", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RegolaAllarmeTable, String> descrizione = createColumn(
		"descrizione", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RegolaAllarmeTable, Integer> colore = createColumn(
		"colore", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<RegolaAllarmeTable, Boolean> attivo = createColumn(
		"attivo", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private RegolaAllarmeTable() {
		super("BOLLETTINO_RegolaAllarme", RegolaAllarmeTable::new);
	}

}