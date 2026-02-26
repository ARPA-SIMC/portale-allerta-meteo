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
 * The table class for the &quot;ALLERTER_TipoEvento&quot; database table.
 *
 * @author GFAVINI
 * @see TipoEvento
 * @generated
 */
public class TipoEventoTable extends BaseTable<TipoEventoTable> {

	public static final TipoEventoTable INSTANCE = new TipoEventoTable();

	public final Column<TipoEventoTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TipoEventoTable, Long> eventoId = createColumn(
		"eventoId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<TipoEventoTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TipoEventoTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TipoEventoTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TipoEventoTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TipoEventoTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TipoEventoTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TipoEventoTable, String> nome = createColumn(
		"nome", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TipoEventoTable, Integer> indice = createColumn(
		"indice", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<TipoEventoTable, Integer> tabella = createColumn(
		"tabella", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<TipoEventoTable, Boolean> split = createColumn(
		"split", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<TipoEventoTable, Boolean> costiero = createColumn(
		"costiero", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<TipoEventoTable, Date> dataInizio = createColumn(
		"dataInizio", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TipoEventoTable, Date> dataFine = createColumn(
		"dataFine", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TipoEventoTable, Long> parentId = createColumn(
		"parentId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private TipoEventoTable() {
		super("ALLERTER_TipoEvento", TipoEventoTable::new);
	}

}