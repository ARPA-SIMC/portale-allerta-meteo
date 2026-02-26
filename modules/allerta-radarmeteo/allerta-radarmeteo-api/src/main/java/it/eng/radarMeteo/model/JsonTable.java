/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.radarMeteo.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;rt_portlet_json&quot; database table.
 *
 * @author Francesco
 * @see Json
 * @generated
 */
public class JsonTable extends BaseTable<JsonTable> {

	public static final JsonTable INSTANCE = new JsonTable();

	public final Column<JsonTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<JsonTable, String> type = createColumn(
		"type_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JsonTable, Long> inserted = createColumn(
		"inserted", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<JsonTable, String> data = createColumn(
		"data_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private JsonTable() {
		super("rt_portlet_json", JsonTable::new);
	}

}