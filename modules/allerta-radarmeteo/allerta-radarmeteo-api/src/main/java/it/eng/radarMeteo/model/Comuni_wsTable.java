/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.radarMeteo.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;rt_portlet_comuni_ws&quot; database table.
 *
 * @author Francesco
 * @see Comuni_ws
 * @generated
 */
public class Comuni_wsTable extends BaseTable<Comuni_wsTable> {

	public static final Comuni_wsTable INSTANCE = new Comuni_wsTable();

	public final Column<Comuni_wsTable, String> idIstat = createColumn(
		"idIstat", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<Comuni_wsTable, String> comune = createColumn(
		"comune", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<Comuni_wsTable, String> provincia = createColumn(
		"provincia", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<Comuni_wsTable, String> sottozona = createColumn(
		"sottozona", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<Comuni_wsTable, String> zonaallerta = createColumn(
		"zonaallerta", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private Comuni_wsTable() {
		super("rt_portlet_comuni_ws", Comuni_wsTable::new);
	}

}