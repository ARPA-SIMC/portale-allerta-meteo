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
 * The table class for the &quot;rubrica_RubricaNominativo&quot; database table.
 *
 * @author Pratola_L
 * @see RubricaNominativo
 * @generated
 */
public class RubricaNominativoTable extends BaseTable<RubricaNominativoTable> {

	public static final RubricaNominativoTable INSTANCE =
		new RubricaNominativoTable();

	public final Column<RubricaNominativoTable, Long> ID_NOMINATIVO =
		createColumn(
			"ID_NOMINATIVO", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	public final Column<RubricaNominativoTable, String> COGNOME = createColumn(
		"COGNOME", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<RubricaNominativoTable, String> NOME = createColumn(
		"NOME", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<RubricaNominativoTable, String> INDIRIZZO =
		createColumn(
			"INDIRIZZO", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<RubricaNominativoTable, Long> FK_SITO_PROPRIETARIO =
		createColumn(
			"FK_SITO_PROPRIETARIO", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);

	public final Column<RubricaNominativoTable, Long> FK_UTENTE_PORTALE =
		createColumn(
			"FK_UTENTE_PORTALE", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	public final Column<RubricaNominativoTable, Long> FK_UTENTE_CREAZIONE =
		createColumn(
			"FK_UTENTE_CREAZIONE", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);

	public final Column<RubricaNominativoTable, Date> DATA_CREAZIONE =
		createColumn(
			"DATA_CREAZIONE", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	public final Column<RubricaNominativoTable, Long> FK_UTENTE_MODIFICA =
		createColumn(
			"FK_UTENTE_MODIFICA", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);

	public final Column<RubricaNominativoTable, Date> DATA_MODIFICA =
		createColumn(
			"DATA_MODIFICA", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	public final Column<RubricaNominativoTable, Boolean> DISABLED =
		createColumn(
			"DISABLED", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	public final Column<RubricaNominativoTable, Boolean> MODIFICA_MINORE =
		createColumn(
			"MODIFICA_MINORE", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);

	private RubricaNominativoTable() {
		super("rubrica_RubricaNominativo", RubricaNominativoTable::new);
	}

}