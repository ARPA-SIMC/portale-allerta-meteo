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
 * The table class for the &quot;ALLERTER_AllertaStato&quot; database table.
 *
 * @author GFAVINI
 * @see AllertaStato
 * @generated
 */
public class AllertaStatoTable extends BaseTable<AllertaStatoTable> {

	public static final AllertaStatoTable INSTANCE = new AllertaStatoTable();

	public final Column<AllertaStatoTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllertaStatoTable, Long> allertaStatoId = createColumn(
		"allertaStatoId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AllertaStatoTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllertaStatoTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllertaStatoTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllertaStatoTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllertaStatoTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AllertaStatoTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AllertaStatoTable, String> nome = createColumn(
		"nome", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllertaStatoTable, Date> dataInizio = createColumn(
		"dataInizio", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AllertaStatoTable, Date> dataFine = createColumn(
		"dataFine", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AllertaStatoTable, Long> parentId = createColumn(
		"parentId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllertaStatoTable, Long> allertaId = createColumn(
		"allertaId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllertaStatoTable, Long> statoId = createColumn(
		"statoId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllertaStatoTable, Long> eventoId = createColumn(
		"eventoId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllertaStatoTable, Long> areaId = createColumn(
		"areaId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private AllertaStatoTable() {
		super("ALLERTER_AllertaStato", AllertaStatoTable::new);
	}

}