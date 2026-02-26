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
 * The table class for the &quot;BOLLETTINO_Bollettino&quot; database table.
 *
 * @author GFAVINI
 * @see Bollettino
 * @generated
 */
public class BollettinoTable extends BaseTable<BollettinoTable> {

	public static final BollettinoTable INSTANCE = new BollettinoTable();

	public final Column<BollettinoTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BollettinoTable, Long> bollettinoId = createColumn(
		"bollettinoId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<BollettinoTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BollettinoTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BollettinoTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BollettinoTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BollettinoTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BollettinoTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BollettinoTable, Integer> stato = createColumn(
		"stato", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<BollettinoTable, Long> idApprovatore = createColumn(
		"idApprovatore", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BollettinoTable, Date> dataApprovazione = createColumn(
		"dataApprovazione", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BollettinoTable, String> numero = createColumn(
		"numero", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BollettinoTable, Integer> progressivo = createColumn(
		"progressivo", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<BollettinoTable, Integer> anno = createColumn(
		"anno", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<BollettinoTable, Date> dataEmissione = createColumn(
		"dataEmissione", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BollettinoTable, Date> dataInizio = createColumn(
		"dataInizio", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BollettinoTable, Date> dataFine = createColumn(
		"dataFine", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BollettinoTable, String> noteMeteo = createColumn(
		"noteMeteo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BollettinoTable, String> stringaMeteo = createColumn(
		"stringaMeteo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BollettinoTable, String> link = createColumn(
		"link", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BollettinoTable, Boolean> ultimo = createColumn(
		"ultimo", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<BollettinoTable, String> hash = createColumn(
		"hash", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private BollettinoTable() {
		super("BOLLETTINO_Bollettino", BollettinoTable::new);
	}

}