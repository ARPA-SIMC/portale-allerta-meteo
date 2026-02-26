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
 * The table class for the &quot;ALLERTER_AllertaValanghe&quot; database table.
 *
 * @author GFAVINI
 * @see AllertaValanghe
 * @generated
 */
public class AllertaValangheTable extends BaseTable<AllertaValangheTable> {

	public static final AllertaValangheTable INSTANCE =
		new AllertaValangheTable();

	public final Column<AllertaValangheTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheTable, Long> allertaValangheId =
		createColumn(
			"allertaValangheId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AllertaValangheTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheTable, String> creatorName =
		createColumn(
			"creatorName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheTable, Date> dataEmissione =
		createColumn(
			"dataEmissione", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheTable, Date> dataInizio = createColumn(
		"dataInizio", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheTable, Date> dataFine = createColumn(
		"dataFine", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheTable, String> numero = createColumn(
		"numero", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheTable, Integer> progressivo =
		createColumn(
			"progressivo", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheTable, Integer> anno = createColumn(
		"anno", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheTable, String> titolo = createColumn(
		"titolo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheTable, String> descrizioneFenomeni =
		createColumn(
			"descrizioneFenomeni", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<AllertaValangheTable, String> note = createColumn(
		"note", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheTable, String> riferimenti =
		createColumn(
			"riferimenti", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheTable, String> sintesi = createColumn(
		"sintesi", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheTable, Long> utenteFirmaArpaId =
		createColumn(
			"utenteFirmaArpaId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheTable, Date> dataFirmaArpa =
		createColumn(
			"dataFirmaArpa", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheTable, Long> utenteFirmaProtId =
		createColumn(
			"utenteFirmaProtId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheTable, Date> dataFirmaProt =
		createColumn(
			"dataFirmaProt", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheTable, Long> parentId = createColumn(
		"parentId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheTable, String> link = createColumn(
		"link", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheTable, Integer> stato = createColumn(
		"stato", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheTable, Boolean> tipoAllerta =
		createColumn(
			"tipoAllerta", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<AllertaValangheTable, String> hash = createColumn(
		"hash", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private AllertaValangheTable() {
		super("ALLERTER_AllertaValanghe", AllertaValangheTable::new);
	}

}