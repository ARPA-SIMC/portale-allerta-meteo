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
 * The table class for the &quot;rubrica_RubricaGruppo&quot; database table.
 *
 * @author Pratola_L
 * @see RubricaGruppo
 * @generated
 */
public class RubricaGruppoTable extends BaseTable<RubricaGruppoTable> {

	public static final RubricaGruppoTable INSTANCE = new RubricaGruppoTable();

	public final Column<RubricaGruppoTable, Long> ID_GRUPPO = createColumn(
		"ID_GRUPPO", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	public final Column<RubricaGruppoTable, String> NOME = createColumn(
		"NOME", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<RubricaGruppoTable, Long> FK_SITO_PROPRIETARIO =
		createColumn(
			"FK_SITO_PROPRIETARIO", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);

	public final Column<RubricaGruppoTable, String> NOTE = createColumn(
		"NOTE", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<RubricaGruppoTable, Long> FK_UTENTE_CREAZIONE =
		createColumn(
			"FK_UTENTE_CREAZIONE", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);

	public final Column<RubricaGruppoTable, Date> DATA_CREAZIONE = createColumn(
		"DATA_CREAZIONE", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	public final Column<RubricaGruppoTable, Long> FK_UTENTE_MODIFICA =
		createColumn(
			"FK_UTENTE_MODIFICA", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);

	public final Column<RubricaGruppoTable, Date> DATA_MODIFICA = createColumn(
		"DATA_MODIFICA", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	public final Column<RubricaGruppoTable, Boolean> DISABLED = createColumn(
		"DISABLED", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	public final Column<RubricaGruppoTable, Long> FK_CATEGORIA = createColumn(
		"FK_CATEGORIA", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private RubricaGruppoTable() {
		super("rubrica_RubricaGruppo", RubricaGruppoTable::new);
	}

}