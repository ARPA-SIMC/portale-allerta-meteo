/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.verifica.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;VERIFICA_Verifica&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Verifica
 * @generated
 */
public class VerificaTable extends BaseTable<VerificaTable> {

	public static final VerificaTable INSTANCE = new VerificaTable();

	public final Column<VerificaTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VerificaTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<VerificaTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VerificaTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VerificaTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VerificaTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VerificaTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<VerificaTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<VerificaTable, Long> documento = createColumn(
		"documento", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VerificaTable, Integer> stato = createColumn(
		"stato", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<VerificaTable, String> titolo = createColumn(
		"titolo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VerificaTable, String> fenomeni = createColumn(
		"fenomeni", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VerificaTable, String> fenomeniDescritti = createColumn(
		"fenomeniDescritti", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VerificaTable, String> note = createColumn(
		"note", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VerificaTable, Date> dataInizio = createColumn(
		"dataInizio", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<VerificaTable, Date> dataFine = createColumn(
		"dataFine", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<VerificaTable, String> link = createColumn(
		"link", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VerificaTable, String> hash = createColumn(
		"hash", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private VerificaTable() {
		super("VERIFICA_Verifica", VerificaTable::new);
	}

}