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
 * The table class for the &quot;ALLERTER_Area&quot; database table.
 *
 * @author GFAVINI
 * @see Area
 * @generated
 */
public class AreaTable extends BaseTable<AreaTable> {

	public static final AreaTable INSTANCE = new AreaTable();

	public final Column<AreaTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AreaTable, Long> areaId = createColumn(
		"areaId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AreaTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AreaTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AreaTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AreaTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AreaTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AreaTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AreaTable, String> nome = createColumn(
		"nome", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AreaTable, String> tipoArea = createColumn(
		"tipoArea", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AreaTable, Boolean> costiero = createColumn(
		"costiero", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<AreaTable, Date> dataInizio = createColumn(
		"dataInizio", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AreaTable, Date> dataFine = createColumn(
		"dataFine", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AreaTable, Long> parentId = createColumn(
		"parentId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private AreaTable() {
		super("ALLERTER_Area", AreaTable::new);
	}

}