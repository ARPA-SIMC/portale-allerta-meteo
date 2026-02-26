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
 * The table class for the &quot;BOLLETTINO_Allarme&quot; database table.
 *
 * @author GFAVINI
 * @see Allarme
 * @generated
 */
public class AllarmeTable extends BaseTable<AllarmeTable> {

	public static final AllarmeTable INSTANCE = new AllarmeTable();

	public final Column<AllarmeTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllarmeTable, Long> allarmeId = createColumn(
		"allarmeId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AllarmeTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllarmeTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllarmeTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllarmeTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllarmeTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AllarmeTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AllarmeTable, Integer> stato = createColumn(
		"stato", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<AllarmeTable, Long> idApprovatore = createColumn(
		"idApprovatore", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllarmeTable, Date> dataApprovazione = createColumn(
		"dataApprovazione", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AllarmeTable, Long> idRegola = createColumn(
		"idRegola", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllarmeTable, Integer> colore = createColumn(
		"colore", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<AllarmeTable, Date> dataInizio = createColumn(
		"dataInizio", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AllarmeTable, Date> dataFine = createColumn(
		"dataFine", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private AllarmeTable() {
		super("BOLLETTINO_Allarme", AllarmeTable::new);
	}

}