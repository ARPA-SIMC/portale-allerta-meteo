/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;ALLERTER_LogInterno&quot; database table.
 *
 * @author GFAVINI
 * @see LogInterno
 * @generated
 */
public class LogInternoTable extends BaseTable<LogInternoTable> {

	public static final LogInternoTable INSTANCE = new LogInternoTable();

	public final Column<LogInternoTable, Long> logId = createColumn(
		"logId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<LogInternoTable, Date> timestamp = createColumn(
		"timestamp", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LogInternoTable, String> thread = createColumn(
		"thread", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LogInternoTable, String> cosa = createColumn(
		"cosa", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LogInternoTable, String> dettaglio = createColumn(
		"dettaglio", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LogInternoTable, String> utente = createColumn(
		"utente", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LogInternoTable, String> risultato = createColumn(
		"risultato", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LogInternoTable, String> eccezione = createColumn(
		"eccezione", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private LogInternoTable() {
		super("ALLERTER_LogInterno", LogInternoTable::new);
	}

}