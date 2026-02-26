/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;rubrica_RubricaLog&quot; database table.
 *
 * @author Pratola_L
 * @see RubricaLog
 * @generated
 */
public class RubricaLogTable extends BaseTable<RubricaLogTable> {

	public static final RubricaLogTable INSTANCE = new RubricaLogTable();

	public final Column<RubricaLogTable, Long> ID_LOG = createColumn(
		"ID_LOG", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	public final Column<RubricaLogTable, Long> FK_SITO_PROPRIETARIO =
		createColumn(
			"FK_SITO_PROPRIETARIO", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);

	public final Column<RubricaLogTable, String> TABELLA = createColumn(
		"TABELLA", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<RubricaLogTable, String> TIPO_OPERAZIONE = createColumn(
		"TIPO_OPERAZIONE", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<RubricaLogTable, String> ID_OGGETTO = createColumn(
		"ID_OGGETTO", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<RubricaLogTable, String> NUOVA_DESCRIZIONE =
		createColumn(
			"NUOVA_DESCRIZIONE", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	public final Column<RubricaLogTable, Long> FK_UTENTE_MODIFICA =
		createColumn(
			"FK_UTENTE_MODIFICA", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);

	public final Column<RubricaLogTable, Date> DATA_MODIFICA = createColumn(
		"DATA_MODIFICA", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private RubricaLogTable() {
		super("rubrica_RubricaLog", RubricaLogTable::new);
	}

}