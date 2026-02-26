/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;ALLERTER_Geografia&quot; database table.
 *
 * @author GFAVINI
 * @see Geografia
 * @generated
 */
public class GeografiaTable extends BaseTable<GeografiaTable> {

	public static final GeografiaTable INSTANCE = new GeografiaTable();

	public final Column<GeografiaTable, String> geografiaId = createColumn(
		"geografiaId", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<GeografiaTable, String> tipo = createColumn(
		"tipo", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<GeografiaTable, String> area = createColumn(
		"area", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<GeografiaTable, String> complessita = createColumn(
		"complessita", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<GeografiaTable, String> geometria = createColumn(
		"geometria", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private GeografiaTable() {
		super("ALLERTER_Geografia", GeografiaTable::new);
	}

}