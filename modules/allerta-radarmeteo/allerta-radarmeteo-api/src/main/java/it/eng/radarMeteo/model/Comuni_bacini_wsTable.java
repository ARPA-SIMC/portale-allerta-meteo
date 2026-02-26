/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.radarMeteo.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;rt_portlet_comuni_bacini_ws&quot; database table.
 *
 * @author Francesco
 * @see Comuni_bacini_ws
 * @generated
 */
public class Comuni_bacini_wsTable extends BaseTable<Comuni_bacini_wsTable> {

	public static final Comuni_bacini_wsTable INSTANCE =
		new Comuni_bacini_wsTable();

	public final Column<Comuni_bacini_wsTable, Integer> idBacini = createColumn(
		"idBacini", Integer.class, Types.INTEGER, Column.FLAG_PRIMARY);
	public final Column<Comuni_bacini_wsTable, String> comune = createColumn(
		"comune", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<Comuni_bacini_wsTable, String> provincia = createColumn(
		"provincia", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<Comuni_bacini_wsTable, String> bacino = createColumn(
		"bacino", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private Comuni_bacini_wsTable() {
		super("rt_portlet_comuni_bacini_ws", Comuni_bacini_wsTable::new);
	}

}