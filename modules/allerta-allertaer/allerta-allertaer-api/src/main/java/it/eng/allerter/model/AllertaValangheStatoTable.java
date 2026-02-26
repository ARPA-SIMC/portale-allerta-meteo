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
 * The table class for the &quot;ALLERTER_AllertaValangheStato&quot; database table.
 *
 * @author GFAVINI
 * @see AllertaValangheStato
 * @generated
 */
public class AllertaValangheStatoTable
	extends BaseTable<AllertaValangheStatoTable> {

	public static final AllertaValangheStatoTable INSTANCE =
		new AllertaValangheStatoTable();

	public final Column<AllertaValangheStatoTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheStatoTable, Long>
		allertaValangheStatoId = createColumn(
			"allertaValangheStatoId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<AllertaValangheStatoTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheStatoTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheStatoTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheStatoTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheStatoTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheStatoTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheStatoTable, String> nome = createColumn(
		"nome", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheStatoTable, Date> dataInizio =
		createColumn(
			"dataInizio", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheStatoTable, Date> dataFine =
		createColumn(
			"dataFine", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheStatoTable, Long> parentId =
		createColumn("parentId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheStatoTable, Long> allertaValangheId =
		createColumn(
			"allertaValangheId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheStatoTable, Long> statoId = createColumn(
		"statoId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheStatoTable, Long> eventoId =
		createColumn("eventoId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheStatoTable, Long> areaId = createColumn(
		"areaId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private AllertaValangheStatoTable() {
		super("ALLERTER_AllertaValangheStato", AllertaValangheStatoTable::new);
	}

}