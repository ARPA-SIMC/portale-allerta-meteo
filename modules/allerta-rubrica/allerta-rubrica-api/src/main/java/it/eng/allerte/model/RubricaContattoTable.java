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
 * The table class for the &quot;rubrica_RubricaContatto&quot; database table.
 *
 * @author Pratola_L
 * @see RubricaContatto
 * @generated
 */
public class RubricaContattoTable extends BaseTable<RubricaContattoTable> {

	public static final RubricaContattoTable INSTANCE =
		new RubricaContattoTable();

	public final Column<RubricaContattoTable, Long> ID_CONTATTO = createColumn(
		"ID_CONTATTO", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	public final Column<RubricaContattoTable, Long> FK_NOMINATIVO =
		createColumn(
			"FK_NOMINATIVO", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	public final Column<RubricaContattoTable, Long> FK_CANALE = createColumn(
		"FK_CANALE", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	public final Column<RubricaContattoTable, String> CONTATTO = createColumn(
		"CONTATTO", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<RubricaContattoTable, Boolean> ALLERTAMENTO =
		createColumn(
			"ALLERTAMENTO", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	public final Column<RubricaContattoTable, Long> FK_UTENTE_CREAZIONE =
		createColumn(
			"FK_UTENTE_CREAZIONE", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);

	public final Column<RubricaContattoTable, Date> DATA_CREAZIONE =
		createColumn(
			"DATA_CREAZIONE", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	public final Column<RubricaContattoTable, Long> FK_UTENTE_MODIFICA =
		createColumn(
			"FK_UTENTE_MODIFICA", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);

	public final Column<RubricaContattoTable, Date> DATA_MODIFICA =
		createColumn(
			"DATA_MODIFICA", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	public final Column<RubricaContattoTable, Date> DATA_FINE_VALIDITA =
		createColumn(
			"DATA_FINE_VALIDITA", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);

	public final Column<RubricaContattoTable, Boolean> MODIFICA_MINORE =
		createColumn(
			"MODIFICA_MINORE", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);

	private RubricaContattoTable() {
		super("rubrica_RubricaContatto", RubricaContattoTable::new);
	}

}