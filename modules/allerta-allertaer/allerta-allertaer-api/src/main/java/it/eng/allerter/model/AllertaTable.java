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
 * The table class for the &quot;ALLERTER_Allerta&quot; database table.
 *
 * @author GFAVINI
 * @see Allerta
 * @generated
 */
public class AllertaTable extends BaseTable<AllertaTable> {

	public static final AllertaTable INSTANCE = new AllertaTable();

	public final Column<AllertaTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllertaTable, Long> allertaId = createColumn(
		"allertaId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AllertaTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllertaTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllertaTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllertaTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllertaTable, String> creatorName = createColumn(
		"creatorName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllertaTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AllertaTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AllertaTable, Integer> stato = createColumn(
		"stato", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<AllertaTable, String> numero = createColumn(
		"numero", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllertaTable, Integer> progressivo = createColumn(
		"progressivo", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<AllertaTable, Integer> anno = createColumn(
		"anno", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<AllertaTable, Date> dataEmissione = createColumn(
		"dataEmissione", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AllertaTable, Date> dataInizio = createColumn(
		"dataInizio", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AllertaTable, Date> dataFine = createColumn(
		"dataFine", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AllertaTable, String> descrizioneMeteo = createColumn(
		"descrizioneMeteo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllertaTable, Integer> tendenza = createColumn(
		"tendenza", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<AllertaTable, String> note = createColumn(
		"note", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllertaTable, String> riferimenti = createColumn(
		"riferimenti", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllertaTable, Long> utenteFirmaArpaId = createColumn(
		"utenteFirmaArpaId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllertaTable, Date> dataFirmaArpa = createColumn(
		"dataFirmaArpa", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AllertaTable, Long> utenteFirmaProtId = createColumn(
		"utenteFirmaProtId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllertaTable, Date> dataFirmaProt = createColumn(
		"dataFirmaProt", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AllertaTable, Long> parentId = createColumn(
		"parentId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AllertaTable, String> sintesi = createColumn(
		"sintesi", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllertaTable, String> sintesiEng = createColumn(
		"sintesiEng", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllertaTable, String> link = createColumn(
		"link", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllertaTable, String> titolo = createColumn(
		"titolo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllertaTable, String> titoloEng = createColumn(
		"titoloEng", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllertaTable, Boolean> tipoAllerta = createColumn(
		"tipoAllerta", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<AllertaTable, String> hash = createColumn(
		"hash", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AllertaTable, String> sintesiBriefing = createColumn(
		"sintesiBriefing", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private AllertaTable() {
		super("ALLERTER_Allerta", AllertaTable::new);
	}

}